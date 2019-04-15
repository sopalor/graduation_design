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
import java.util.List;
@Controller
@RequestMapping("user_ticket")
public class User_TicketController {
    @Autowired
    User_TicketDao user_ticketDao;
    @RequestMapping(value = "myticket")
    public String myticket(HttpServletRequest req){
        List<User_Ticket> list=user_ticketDao.selectAllMyTickets(req.getParameter("id"));
        req.setAttribute("list",list);
        return "welcome/my_ticket.jsp";
    }
}
