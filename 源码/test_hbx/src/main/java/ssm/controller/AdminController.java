package ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ssm.dao.TicketDao;
import ssm.dao.UserDao;
import ssm.dao.User_TicketDao;
import ssm.model.Ticket;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;



@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    TicketDao ticketDao;
    @Autowired
    UserDao userdao;
    @Autowired
    User_TicketDao user_ticketDao;
    @RequestMapping(value = "init")
    public String firstInit(HttpServletRequest req){
        List<Ticket> list=ticketDao.selectAll1();
        req.setAttribute("list",list);
        req.setAttribute("cfdlist",ticketDao.selectCfdList());
        req.setAttribute("mddlist",ticketDao.selectMddList());
        req.setAttribute("rqlist",ticketDao.selectRqList());
        return "ht/console_check_del.jsp";
    }
    @RequestMapping(value = "TiaoJian")
    public String TiaoJian(HttpServletRequest req){
        String cfd=req.getParameter("cfd");
        String mdd=req.getParameter("mdd");
        String rq=req.getParameter("rq");
        List<Ticket> list=ticketDao.selectAllByTj(cfd,mdd,rq);
        req.setAttribute("list",list);
        req.setAttribute("cfdlist",ticketDao.selectCfdList());
        req.setAttribute("mddlist",ticketDao.selectMddList());
        req.setAttribute("rqlist",ticketDao.selectRqList());
        return "ht/console_check_del.jsp";
    }
    @RequestMapping(value = "deleteticket")
    public String deleteticket(HttpServletRequest req){
        String id=req.getParameter("id");
        int count=ticketDao.deleteTicketByid(id);
        user_ticketDao.deleteOneTicket(id);
        req.setAttribute("list",count);
        return "admin/init";
    }
    @RequestMapping(value = "addticket")
    public String addticket(HttpServletRequest req){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        SimpleDateFormat newsdf = new SimpleDateFormat("yyyy-MM-dd");
        String cfd=req.getParameter("cfd");
        String mdd=req.getParameter("mdd");
        String rq=req.getParameter("rq");
        String hkgs=req.getParameter("hkgs");
        String cfsj=req.getParameter("cfsj");
        String ddsj=req.getParameter("ddsj");
        String sit=req.getParameter("sit");
        String jg=req.getParameter("jg");
        String zk=req.getParameter("zk");
        Ticket ticket=new Ticket();
        ticket.setCCfd(cfd);
        ticket.setCHkgs(hkgs);
        ticket.setCId(UUID.randomUUID().toString().replaceAll("-",""));
        ticket.setCMdd(mdd);
        Date date = null;
        try {
            date = sdf.parse(cfsj);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Timestamp ts = new Timestamp(date.getTime());
        ticket.setDCfsj(ts);
        try {
            date = sdf.parse(ddsj);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        ts=new Timestamp(date.getTime());
        ticket.setDDdsj(ts);
        try {
            ticket.setDRq( new java.sql.Date(newsdf.parse(rq).getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        ticket.setNJg(new BigDecimal(jg));
        ticket.setNSyzw(Integer.parseInt(sit));
        ticket.setNZwzs(Integer.parseInt(sit));
        ticket.setFZk(new BigDecimal(zk));
        String cha=req.getParameter("flag");
        if(cha!=null&&cha.equals("yes")){
            ticket.setCId(req.getParameter("id"));
            ticketDao.updateOneTicket(ticket);

        }
        else
            ticketDao.insertOneTicket(ticket);
        return "admin/init";
    }
    @RequestMapping(value = "changeticket")
    public String changeticket(HttpServletRequest req){
        String id=req.getParameter("id");
        Ticket ticket=ticketDao.selectAllById(id);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        Date date=ticket.getDCfsj();
        String dstr=sdf.format(date);
        req.setAttribute("str",dstr);
        date=ticket.getDDdsj();
        String dstr1=sdf.format(date);
        req.setAttribute("str1",dstr1);
        req.setAttribute("change","yes");
        req.setAttribute("ticket",ticket);
        return "ht/console_change.jsp";
    }
}
