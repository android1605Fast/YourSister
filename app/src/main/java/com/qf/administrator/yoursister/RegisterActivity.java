package com.qf.administrator.yoursister;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.qf.administrator.yoursister.javabean.MyBmob;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

public class RegisterActivity extends AppCompatActivity{

    private static final int SUCCESSFUL = 1;
    private EditText nameET;
    private EditText emailET;
    private EditText pwdET;
    private EditText confirmET;
    private Boolean exist = false; //判断账号是否存在的标识符
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);
        initView();
    }

    private void initView(){
        nameET = (EditText) findViewById(R.id.registName);
        emailET = (EditText) findViewById(R.id.registerEmail);
        pwdET = (EditText) findViewById(R.id.registerPwd);
        confirmET = (EditText) findViewById(R.id.registerConfirm);
    }

    /**
     * 查询是否有相同的数据
     * 注册只需要查找有没有相同账号即可
     */
    public void queryInfo(View view){
        BmobQuery<MyBmob> queryName = new BmobQuery<>();
        String nameStr = nameET.getText().toString();
        queryName.addWhereMatches("userName", nameStr);
        queryName.findObjects(new FindListener<MyBmob>(){
            @Override
            public void done(List<MyBmob> list, BmobException e){
                if(e == null && list.size() != 0){
                    //在服务器上找到数据
                    Toast.makeText(RegisterActivity.this, "用户名已存在", Toast.LENGTH_SHORT).show();
                }else if(e == null && list.size() == 0){
                    handler.sendEmptyMessage(SUCCESSFUL);
                }else{
                    Toast.makeText(RegisterActivity.this, "服务器异常", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /**
     * 如果用户名不存在 则会进入if(exsit){}判断
     * 确定注册
     *
     * @param view
     */
    public void confirmRegister(View view){
        queryInfo(view);
        handler = new Handler(new Handler.Callback(){
            @Override
            public boolean handleMessage(Message msg){
                exist = true;
                if(exist){
                    MyBmob user;
                    //判断两次密码输入的是否一样，如果一样就上传数据 to bmob
                    String pwdstr = pwdET.getText().toString();
                    String confirmstr = confirmET.getText().toString();
                    if(pwdstr.equals(confirmstr)){
                        user = new MyBmob();
                        user.setUserName(nameET.getText().toString());
                        user.setUserPwd(confirmET.getText().toString());
                        user.setImail(emailET.getText().toString());
                        user.save(new SaveListener<String>(){
                            @Override
                            public void done(String s, BmobException e){
                                if(e == null){
                                    //如果e为空，则代表上传数据成功,并且关闭当前注册页面
                                    Toast.makeText(RegisterActivity.this, "恭喜您，注册成功", Toast.LENGTH_SHORT).show();
                                    exist = false;
                                    finish();
                                }else{
                                    Toast.makeText(RegisterActivity.this, "注册失败", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }else{
                    }
                }
                return exist;
            }
        });
        Log.d("RegisterActivity", "exist.booleanValue():" + exist.booleanValue());

    }
}
