package ssm.model;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by Zhangxq on 2016/7/15.
 */
@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String nickname;
    private String touxiang;
    private Integer score;
    private String isexpert;
}