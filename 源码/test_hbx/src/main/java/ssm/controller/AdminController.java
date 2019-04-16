package ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ssm.dao.TicketDao;
import ssm.dao.UserDao;
import ssm.model.Ticket;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    TicketDao ticketDao;
    @Autowired
    UserDao userdao;
    @RequestMapping(value = "init")
    public String firstInit(HttpServletRequest req){
        List<Ticket> list=ticketDao.selectAll();
        String str=userdao.selectNicknameById(req.getParameter("id"));
        req.setAttribute("list",list);
        return "ht/console_check_del.jsp";
    }
    @RequestMapping(value = "TiaoJian")
    public String TiaoJian(HttpServletRequest req){
        String cfd=req.getParameter("cfd");
        String mdd=req.getParameter("mdd");
        String rq=req.getParameter("rq");
        List<Ticket> list=ticketDao.selectAllByTj(cfd,mdd,rq);
        req.setAttribute("list",list);
        return "ht/console_check_del.jsp";
    }
    @RequestMapping(value = "deleteticket")
    public String deleteticket(HttpServletRequest req){
        String id=req.getParameter("id");
       int count=ticketDao.deleteTicketByid(id);
        req.setAttribute("list",count);
        return "admin/init";
    }
    @RequestMapping(value = "addticket")
    public String addticket(HttpServletRequest req){
        String cfd=req.getParameter("cfd");
        String mdd=req.getParameter("mdd");
        String mdd=req.getParameter("mdd");
        return "admin/init";
    }
}
