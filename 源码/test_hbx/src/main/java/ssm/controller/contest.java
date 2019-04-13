package ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ssm.dao.UserDao;
import ssm.model.User;


import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("test")
public class contest {
    @Autowired
    UserDao userdao;
    @RequestMapping("sout.do")
    public String t(){
        User u1=new User();
        u1.toString();
        User u=userdao.selectUserById(9);

        System.out.println(u.toString());
        System.out.println(u.getNickname());
        return "ht/user_login1.jsp";
    }
}
