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


//控制层注解。根据requestmapper的地址拦截请求
@Controller
@RequestMapping("admin")
public class AdminController {
    //自动注入 mybaits映射关系
    @Autowired
    TicketDao ticketDao;
    @Autowired
    UserDao userdao;
    @Autowired
    User_TicketDao user_ticketDao;
    /*
    第一次进入后台的方法
     */
    @RequestMapping(value = "init")
    public String firstInit(HttpServletRequest req){
        //查询所有的票信息交给request，再通过c标签前台拼接成html标签
        List<Ticket> list=ticketDao.selectAll1();
        req.setAttribute("list",list);
        //所有的出发地 交给request从而实现动态下拉框
        req.setAttribute("cfdlist",ticketDao.selectCfdList());
        //所有的目的地 交给request从而实现动态下拉框
        req.setAttribute("mddlist",ticketDao.selectMddList());
        //所有的日期 交给request从而实现动态下拉框
        req.setAttribute("rqlist",ticketDao.selectRqList());
        return "ht/console_check_del.jsp";
    }
    /*
    通过前台的查询按钮进入
     */
    @RequestMapping(value = "TiaoJian")
    public String TiaoJian(HttpServletRequest req){
        //得到所有的查询条件    出发地，目的地，日期
        String cfd=req.getParameter("cfd");
        String mdd=req.getParameter("mdd");
        String rq=req.getParameter("rq");
        //根据条件返回对应的list交给request
        List<Ticket> list=ticketDao.selectAllByTj(cfd,mdd,rq);
        /*
        同上
         */
        req.setAttribute("list",list);
        req.setAttribute("cfdlist",ticketDao.selectCfdList());
        req.setAttribute("mddlist",ticketDao.selectMddList());
        req.setAttribute("rqlist",ticketDao.selectRqList());
        return "ht/console_check_del.jsp";
    }
    /*
    删除票的方法
     */
    @RequestMapping(value = "deleteticket")
    public String deleteticket(HttpServletRequest req){
        //根据前台穿过来的id删除ticket
        String id=req.getParameter("id");
        int count=ticketDao.deleteTicketByid(id);
        user_ticketDao.deleteOneTicket(id);
        req.setAttribute("list",count);
        return "admin/init";
    }
    /*
    添加票方法
     */
    @RequestMapping(value = "addticket")
    public String addticket(HttpServletRequest req){
        //通过requset得到所有的信息再根据建库时的字段进行日期格式转码及BigDecimal的转换
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
        //由于添加票和修改票使用的同一个方法 通过flag 来尽心判断
        if(cha!=null&&cha.equals("yes")){
            ticket.setCId(req.getParameter("id"));
            ticketDao.updateOneTicket(ticket);

        }
        else
            ticketDao.insertOneTicket(ticket);
        return "admin/init";
    }
    /*
    修改票的跳转方法。把对应的票信息默认显示在前台便于修改
     */
    @RequestMapping(value = "changeticket")
    public String changeticket(HttpServletRequest req){
        //前台传过来的id
        String id=req.getParameter("id");
        //通过id查找票
        Ticket ticket=ticketDao.selectAllById(id);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        Date date=ticket.getDCfsj();
        String dstr=sdf.format(date);
        req.setAttribute("str",dstr);
        date=ticket.getDDdsj();
        String dstr1=sdf.format(date);
        //区分添加和修改的属性
        req.setAttribute("str1",dstr1);
        req.setAttribute("change","yes");
        req.setAttribute("ticket",ticket);
        return "ht/console_change.jsp";
    }
}
