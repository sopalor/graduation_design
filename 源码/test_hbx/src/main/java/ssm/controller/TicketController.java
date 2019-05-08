package ssm.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ssm.dao.TicketDao;
import ssm.dao.UserDao;
import ssm.dao.User_TicketDao;
import ssm.model.Ticket;
import ssm.model.User;
import ssm.model.User_Ticket;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("ticket")
public class TicketController {
    @Autowired
    TicketDao ticketDao;
    @Autowired
    UserDao userdao;
    @Autowired
    User_TicketDao user_ticketDao;
    @RequestMapping(value = "init")
    public String firstInit(HttpServletRequest req){
        List<Ticket> list=ticketDao.selectAll();
        User user=userdao.selectUserById(req.getParameter("id"));
        String str=user.getCNickname();
        String name=user.getCName();
        req.getSession().setAttribute("nickname",str==null||"".equals(str)?"游客":str);
        req.getSession().setAttribute("user",user);
      //  req.getSession().setAttribute("id",req.getParameter("id"));
        req.setAttribute("list",list);
        req.setAttribute("cfdlist",ticketDao.selectCfdList1());
        req.setAttribute("mddlist",ticketDao.selectMddList1());
        req.setAttribute("rqlist",ticketDao.selectRqList1());
       return "welcome/home_page.jsp";
    }
    @RequestMapping(value = "TiaoJian")
    public String TiaoJian(HttpServletRequest req){
        String cfd=req.getParameter("cfd");
        String mdd=req.getParameter("mdd");
        String rq=req.getParameter("rq");
        List<Ticket> list=ticketDao.selectAllByTj1(cfd,mdd,rq);
        req.setAttribute("list",list);
        req.setAttribute("cfdlist",ticketDao.selectCfdList1());
        req.setAttribute("mddlist",ticketDao.selectMddList1());
        req.setAttribute("rqlist",ticketDao.selectRqList1());
        return "welcome/home_page.jsp";
    }
    @RequestMapping(value = "TiaoJian_discount")
    public String TiaoJian_discount(HttpServletRequest req){
        String cfd=req.getParameter("cfd");
        String mdd=req.getParameter("mdd");
        String rq=req.getParameter("rq");
        List<Ticket> list=ticketDao.selectAllByTj2(cfd,mdd,rq);
        req.setAttribute("list",list);
        req.setAttribute("cfdlist",ticketDao.selectCfdList2());
        req.setAttribute("mddlist",ticketDao.selectMddList2());
        req.setAttribute("rqlist",ticketDao.selectRqList2());
        return "welcome/home_page_discount.jsp";
    }
    @RequestMapping(value = "discount")
    public String discount(HttpServletRequest req){
        List<Ticket> list=ticketDao.selectAllDiscount();
        req.setAttribute("list",list);
        for(Ticket ticket:list){
            ticket.setFZk(ticket.getNJg().multiply(ticket.getFZk()));
            ticket.setFZk(ticket.getFZk().setScale(1, BigDecimal.ROUND_HALF_UP));
        }
        req.setAttribute("cfdlist",ticketDao.selectCfdList2());
        req.setAttribute("mddlist",ticketDao.selectMddList2());
        req.setAttribute("rqlist",ticketDao.selectRqList2());
        return "welcome/home_page_discount.jsp";
    }
    @RequestMapping(value = "yuding")
    public String yuding(HttpServletRequest req){
        String id=req.getParameter("id");
        Ticket ticket=ticketDao.selectAllById(id);
        ticket.setFZk(ticket.getNJg().multiply(ticket.getFZk()));
        ticket.setFZk(ticket.getFZk().setScale(1, BigDecimal.ROUND_HALF_UP));
        List<Integer> list=user_ticketDao.selectSitList(id);
        Integer sit=1;
        while(true){
            if(list.contains(sit))
                sit+=1;
            else
                break;
        }
        req.setAttribute("ticket",ticket);
        req.setAttribute("sit",sit);
        return "welcome/pay.jsp";
    }

}
