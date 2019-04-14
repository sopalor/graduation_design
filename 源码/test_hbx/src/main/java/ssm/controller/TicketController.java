package ssm.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ssm.dao.TicketDao;
import ssm.dao.UserDao;
import ssm.model.Ticket;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("ticket")
public class TicketController {
    @Autowired
    TicketDao ticketDao;
    @Autowired
    UserDao userdao;
    @RequestMapping(value = "init")
    public String firstInit(HttpServletRequest req){
        List<Ticket> list=ticketDao.selectAll();
        String str=userdao.selectNicknameById(req.getParameter("id"));
        req.getSession().setAttribute("nickname",str==null||"".equals(str)?"游客":str);
      //  req.getSession().setAttribute("id",req.getParameter("id"));
        req.setAttribute("list",list);
       return "welcome/home_page.jsp";
    }
    @RequestMapping(value = "TiaoJian")
    public String TiaoJian(HttpServletRequest req){
        String cfd=req.getParameter("cfd");
        String mdd=req.getParameter("mdd");
        String rq=req.getParameter("rq");
        List<Ticket> list=ticketDao.selectAllByTj(cfd,mdd,rq);
        req.setAttribute("list",list);
        return "welcome/home_page.jsp";
    }
}
