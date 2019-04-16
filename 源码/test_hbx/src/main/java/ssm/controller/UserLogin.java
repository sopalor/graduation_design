package ssm.controller;

import com.alibaba.fastjson.JSONObject;
import com.sun.deploy.net.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ssm.dao.UserDao;
import ssm.model.Ticket;
import ssm.model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserLogin {

    @Autowired
    UserDao userdao;
    @RequestMapping(value = "login",method = RequestMethod.POST )
    @ResponseBody
    public JSONObject login(HttpServletRequest req){
        JSONObject jsonObject = new JSONObject();
        String name= req.getParameter("name");
        String password= req.getParameter("password");
        if("admin".equals(name)&&"hbx".equals(password)) {
            jsonObject.put("flag", "admin");
            return jsonObject;
        }
        List<User> list = userdao.selectLoginUser(name,password);
        if(list==null||list.isEmpty()) {
            jsonObject.put("flag", "fail");
        }
        else {
            jsonObject.put("flag", "success");
            jsonObject.put("id", list.get(0).getCId());
            req.getSession().setAttribute("id",list.get(0).getCId());
        }
        return jsonObject;
    }
    @RequestMapping(value = "registration")
    @ResponseBody
    public JSONObject registration(HttpServletRequest req){
        JSONObject jsonObject = new JSONObject();
        String name= req.getParameter("name");
        String password= req.getParameter("password");
        int count = userdao.insertUser(name,password);
        if(count>0)
            jsonObject.put("flag","success");
        else
            jsonObject.put("flag","fail");
        return jsonObject;
    }
    @RequestMapping(value = "change")
    public String change(HttpServletRequest req){
        String id= (String) req.getSession().getAttribute("id");
        User user = userdao.selectUserById(id);
        req.setAttribute("user",user);
        return "welcome/account_management.jsp";
    }
    @RequestMapping(value = "update")
    public String update(HttpServletRequest req){
        String id= (String) req.getSession().getAttribute("id");
        User user = new User();
        user.setCEmail(req.getParameter("email"));
        user.setCName(req.getParameter("name"));
        user.setCNickname(req.getParameter("nickname"));
        user.setCPhone(req.getParameter("phone"));
        user.setCSex(req.getParameter("sex"));
        user.setCSfzh(req.getParameter("sfzh"));
        user.setCId(id);
        userdao.updateUser(user);
        if(user.getCNickname()!=null||"".equals(user.getCNickname()))
        req.getSession().setAttribute("nickname",user.getCNickname());
        return "user/change";
    }
}
