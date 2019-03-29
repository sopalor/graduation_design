package ssm.dao;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ssm.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by Zhangxq on 2016/7/15.
 */
public interface UserDao {

    User selectUserById(@Param("userId") Long userId);

    User selectUserByPhoneOrEmail(@Param("emailOrPhone") String emailOrPhone, @Param("state") Short state);

    List<Map<String,String>> selectAllUser();
}