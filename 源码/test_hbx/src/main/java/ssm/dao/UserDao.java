package ssm.dao;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import ssm.model.User;


import java.util.List;
import java.util.Map;


@Service
public interface UserDao {

    User selectUserById(@Param("userId") String userId);

    List<Map<String,String>> selectAllUser();

    List<User> selectLoginUser(@Param("name") String name ,@Param("password") String password);

    int insertUser(@Param("name") String name ,@Param("password") String password);

    String selectNicknameById(@Param("id") String id);

    int updateUser(User user);
}