package com.qf.administrator.yoursister.javabean;

import cn.bmob.v3.BmobObject;

/**
 * Created by Administrator on 2016/7/7.
 */
public class MyBmob extends BmobObject{
    private String userName;
    private String userPwd;
    private String imail;

    public MyBmob(String userName, String userPwd, String imail){
        this.userName = userName;
        this.userPwd = userPwd;
        this.imail = imail;
    }

    public MyBmob(){
    }

    public String getUserName(){
        return userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getUserPwd(){
        return userPwd;
    }

    public void setUserPwd(String userPwd){
        this.userPwd = userPwd;
    }

    public String getImail(){
        return imail;
    }

    public void setImail(String imail){
        this.imail = imail;
    }
}
