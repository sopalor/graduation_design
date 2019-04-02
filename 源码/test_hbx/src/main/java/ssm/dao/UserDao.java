package ssm.dao;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import ssm.model.User;


import java.util.List;
import java.util.Map;

/**
 * Created by Zhangxq on 2016/7/15.
 */
@Service
public interface UserDao {

    User selectUserById(@Param("userId") Integer userId);

    List<Map<String,String>> selectAllUser();
}