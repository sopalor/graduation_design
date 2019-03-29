package ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ssm.dao.UserDao;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("test")
public class contest {
    @Autowired
    UserDao userdao;
    @RequestMapping("sout.do")
    public String t(){

        List<Map<String,String>> list=userdao.selectAllUser();
        System.out.println(list.size());
        return "welcome";
    }
}
