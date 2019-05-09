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
    /*
    查询所有登录人的票信息方法
     */
    @RequestMapping(value = "myticket")
    public String myticket(HttpServletRequest req){
        //查询所有登录人的票信息
        List<User_Ticket> list=user_ticketDao.selectAllMyTickets(req.getParameter("id"));
        //计算折扣价格
        for(User_Ticket user_ticket:list){
            Ticket ticket=user_ticket.getTTicket();
            ticket.setFZk(ticket.getNJg().multiply(ticket.getFZk()));
            ticket.setFZk(ticket.getFZk().setScale(1, BigDecimal.ROUND_HALF_UP));
        }
        //发送给前台
        req.setAttribute("list",list);

        return "welcome/my_ticket.jsp";
    }
    /*
    查看具体订票的信息方法
     */
    @RequestMapping(value = "ticketinfo")
    public String ticketinfo(HttpServletRequest req){
        //查询所有的登录人的票信息
        User_Ticket user_ticket=user_ticketDao.selectOneMyTickets(req.getParameter("id"));
        req.setAttribute("ticket",user_ticket);
        return "welcome/check_my_ticket.jsp";
    }
    /*
    确认支付的方法
     */
    @RequestMapping(value = "add_user_ticket")
    public String add_user_ticket(HttpServletRequest req){
        //拿到票id
        String t_id=req.getParameter("id");
        //拿到人id
        String u_id= (String) req.getSession().getAttribute("id");
        //计算座位
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
    /*
    删除我的订票
    */
    @RequestMapping(value = "deleteticket")
    public String deleteticket(HttpServletRequest req){
        //票id
        String c_id=req.getParameter("id");
        //登录人id
        String u_id= (String) req.getSession().getAttribute("id");
        //更具登录人id和票id进行删除
        int user_ticket=user_ticketDao.deleteOneTicket(c_id);
        return "user_ticket/myticket?id="+u_id;
    }
    /*
    改签方法入口
     */
    @RequestMapping(value = "changeticket")
    public String changeticket(HttpServletRequest req){
        String c_id=req.getParameter("id");
        String u_t_id=req.getParameter("u_t_id");
        List<Ticket> list=ticketDao.selectAllByZhongLei(c_id);
        req.setAttribute("list",list);
        req.setAttribute("u_t_id",u_t_id);
        return "welcome/change_my_ticket.jsp";
    }
    /*
    根据改签的票进行订票
     */
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
