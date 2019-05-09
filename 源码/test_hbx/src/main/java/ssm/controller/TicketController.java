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
    /*
    第一次进入首页的初始化
     */
    public String firstInit(HttpServletRequest req){
        //查找所有非折扣票
        List<Ticket> list=ticketDao.selectAll();
        User user=userdao.selectUserById(req.getParameter("id"));
        String str=user.getCNickname();
        String name=user.getCName();
        //吧登录人的信息放在session里面便于全局的一个查询
        req.getSession().setAttribute("nickname",str==null||"".equals(str)?"游客":str);
        req.getSession().setAttribute("user",user);
      //  req.getSession().setAttribute("id",req.getParameter("id"));
        req.setAttribute("list",list);
        req.setAttribute("cfdlist",ticketDao.selectCfdList1());
        req.setAttribute("mddlist",ticketDao.selectMddList1());
        req.setAttribute("rqlist",ticketDao.selectRqList1());
       return "welcome/home_page.jsp";
    }
    /*
    同后台的条件查询
     */
    @RequestMapping(value = "TiaoJian")
    public String TiaoJian(HttpServletRequest req){
        //通过request拿到所有的查询条件
        String cfd=req.getParameter("cfd");
        String mdd=req.getParameter("mdd");
        String rq=req.getParameter("rq");
        //通过查询条件进行查询
        List<Ticket> list=ticketDao.selectAllByTj1(cfd,mdd,rq);
        //返回给request 方便前台遍历
        req.setAttribute("list",list);
        req.setAttribute("cfdlist",ticketDao.selectCfdList1());
        req.setAttribute("mddlist",ticketDao.selectMddList1());
        req.setAttribute("rqlist",ticketDao.selectRqList1());
        return "welcome/home_page.jsp";
    }
    /*
    同后台的条件查询，这是查询折扣票的
     */
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
    /*
    折扣票的初始化方法
     */
    @RequestMapping(value = "discount")
    public String discount(HttpServletRequest req){
        //查询所有的折扣票
        List<Ticket> list=ticketDao.selectAllDiscount();
        req.setAttribute("list",list);
        //吧折扣的价格进行计算
        for(Ticket ticket:list){
            ticket.setFZk(ticket.getNJg().multiply(ticket.getFZk()));
            ticket.setFZk(ticket.getFZk().setScale(1, BigDecimal.ROUND_HALF_UP));
        }
        req.setAttribute("cfdlist",ticketDao.selectCfdList2());
        req.setAttribute("mddlist",ticketDao.selectMddList2());
        req.setAttribute("rqlist",ticketDao.selectRqList2());
        return "welcome/home_page_discount.jsp";
    }
    /*
    预定页面的初四花
     */
    @RequestMapping(value = "yuding")
    public String yuding(HttpServletRequest req){
        //得到预定票的id
        String id=req.getParameter("id");
        //得到预订票的详细信息
        Ticket ticket=ticketDao.selectAllById(id);
        //计算折扣
        ticket.setFZk(ticket.getNJg().multiply(ticket.getFZk()));
        ticket.setFZk(ticket.getFZk().setScale(1, BigDecimal.ROUND_HALF_UP));
        //计算座位
        List<Integer> list=user_ticketDao.selectSitList(id);
        Integer sit=1;
        while(true){
            if(list.contains(sit))
                sit+=1;
            else
                break;
        }
        //返回前台
        req.setAttribute("ticket",ticket);
        req.setAttribute("sit",sit);
        return "welcome/pay.jsp";
    }

}
