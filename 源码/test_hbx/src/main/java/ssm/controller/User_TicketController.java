package ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ssm.dao.TicketDao;
import ssm.dao.UserDao;
import ssm.dao.User_TicketDao;
import ssm.model.Ticket;
import ssm.model.User;
import ssm.model.User_Ticket;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;
@Controller
@RequestMapping("user_ticket")
public class User_TicketController {
    @Autowired
    User_TicketDao user_ticketDao;
    @Autowired
    TicketDao ticketDao;
    @RequestMapping(value = "myticket")
    public String myticket(HttpServletRequest req){
        List<User_Ticket> list=user_ticketDao.selectAllMyTickets(req.getParameter("id"));
        req.setAttribute("list",list);
        for(User_Ticket user_ticket:list){
            Ticket ticket=user_ticket.getTTicket();
            ticket.setFZk(ticket.getNJg().multiply(ticket.getFZk()));
            ticket.setFZk(ticket.getFZk().setScale(1, BigDecimal.ROUND_HALF_UP));
        }
        return "welcome/my_ticket.jsp";
    }
    @RequestMapping(value = "ticketinfo")
    public String ticketinfo(HttpServletRequest req){
        User_Ticket user_ticket=user_ticketDao.selectOneMyTickets(req.getParameter("id"));
        req.setAttribute("ticket",user_ticket);
        return "welcome/check_my_ticket.jsp";
    }
    @RequestMapping(value = "add_user_ticket")
    public String add_user_ticket(HttpServletRequest req){
        String t_id=req.getParameter("id");
        String u_id= (String) req.getSession().getAttribute("id");
        List<Integer> list=user_ticketDao.selectSitList(t_id);
        Integer sit=1;
        while(true){
            if(list.contains(sit))
                sit+=1;
            else
                break;
        }
        int num=user_ticketDao.insertOneTicket(u_id,t_id,sit);
        return "user_ticket/myticket?id="+u_id;
    }
    @RequestMapping(value = "deleteticket")
    public String deleteticket(HttpServletRequest req){
        String c_id=req.getParameter("id");
        String u_id= (String) req.getSession().getAttribute("id");
        int user_ticket=user_ticketDao.deleteOneTicket(c_id);
        return "user_ticket/myticket?id="+u_id;
    }
    @RequestMapping(value = "changeticket")
    public String changeticket(HttpServletRequest req){
        String c_id=req.getParameter("id");
        String u_t_id=req.getParameter("u_t_id");
        List<Ticket> list=ticketDao.selectAllByZhongLei(c_id);
        req.setAttribute("list",list);
        req.setAttribute("u_t_id",u_t_id);
        return "welcome/change_my_ticket.jsp";
    }
    @RequestMapping(value = "change")
    public String change(HttpServletRequest req){
        String c_id=req.getParameter("id");
        String u_t_id=req.getParameter("u_t_id");
        String u_id= (String) req.getSession().getAttribute("id");
        int count=user_ticketDao.deleteOneTicket(u_t_id);
        List<Integer> list=user_ticketDao.selectSitList(c_id);
        Integer sit=1;
        while(true){
            if(list.contains(sit))
                sit+=1;
            else
                break;
        }
        int num=user_ticketDao.insertOneTicket(u_id,c_id,sit);

        return  "user_ticket/myticket?id="+u_id;
    }
}
