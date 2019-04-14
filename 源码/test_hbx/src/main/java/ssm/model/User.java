package ssm.model;



/**
 * Created by Zhangxq on 2016/7/15.
 */

public class User {
    private String CId;
    private String CName;
    private String CPassword;
    private String CSex;
    private String CSfzh;
    private String CEmail;
    private String CNickname;
    private String CPhone;

    @Override
    public String toString() {
        return "User{" +
                "CId='" + CId + '\'' +
                ", CName='" + CName + '\'' +
                ", CPassword='" + CPassword + '\'' +
                ", CSex='" + CSex + '\'' +
                ", CSfzh='" + CSfzh + '\'' +
                ", CEmail='" + CEmail + '\'' +
                ", CNickname='" + CNickname + '\'' +
                ", CPhone='" + CPhone + '\'' +
                '}';
    }

    public String getCId() {
        return CId;
    }

    public void setCId(String CId) {
        this.CId = CId;
    }

    public String getCName() {
        return CName;
    }

    public void setCName(String CName) {
        this.CName = CName;
    }

    public String getCPassword() {
        return CPassword;
    }

    public void setCPassword(String CPassword) {
        this.CPassword = CPassword;
    }

    public String getCSex() {
        return CSex;
    }

    public void setCSex(String CSex) {
        this.CSex = CSex;
    }

    public String getCSfzh() {
        return CSfzh;
    }

    public void setCSfzh(String CSfzh) {
        this.CSfzh = CSfzh;
    }

    public String getCEmail() {
        return CEmail;
    }

    public void setCEmail(String CEmail) {
        this.CEmail = CEmail;
    }

    public String getCNickname() {
        return CNickname;
    }

    public void setCNickname(String CNickname) {
        this.CNickname = CNickname;
    }

    public String getCPhone() {
        return CPhone;
    }

    public void setCPhone(String CPhone) {
        this.CPhone = CPhone;
    }
}