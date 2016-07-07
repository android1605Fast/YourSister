package com.qf.administrator.yoursister;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.qf.administrator.yoursister.javabean.MyBmob;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class LoginActivity extends AppCompatActivity{

    private EditText nameET;
    private EditText pwdET;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView(){
        nameET = (EditText) findViewById(R.id.NameET);
        pwdET = (EditText) findViewById(R.id.pwdET);

    }

    //确定登录
    public void login(View view){
        BmobQuery<MyBmob> queryName = new BmobQuery<>();
        queryName.addWhereMatches("userName", nameET.getText().toString());
        queryName.findObjects(new FindListener<MyBmob>(){
            @Override
            public void done(List<MyBmob> list, BmobException e){
                //如果没有异常并且服务器userName为空的话，说明当前用户没有注册
                if(e == null && list.size() == 0){
                    Toast.makeText(LoginActivity.this, "该用户不存在", Toast.LENGTH_SHORT).show();
                    //服务器userName存在，接下来判断密码是否正确
                }else if(e == null && list.size() != 0){
                    BmobQuery<MyBmob> queryPwd = new BmobQuery<MyBmob>();
                    queryPwd.addWhereMatches("userPwd", pwdET.getText().toString());
                    queryPwd.findObjects(new FindListener<MyBmob>(){
                        @Override
                        public void done(List<MyBmob> list, BmobException e){
                            //如果没有异常并且服务器有数据,说明改用户账号密码输入正常
                            if(e == null && list.size() != 0){
                                Toast.makeText(LoginActivity.this, "恭喜你成功登录", Toast.LENGTH_SHORT).show();
                                //这里还要返回用户的信息，好设置在ownactivity上面
                                Intent intent = new Intent();
                                Bundle bundle = new Bundle();
                                bundle.putString("userName",pwdET.getText().toString());
                                intent.putExtras(bundle);
                                setResult(2,intent);
                                finish();
                                //服务器没有数据，说明密码输入错误
                            }else if(e == null && list.size() == 0){
                                Toast.makeText(LoginActivity.this, "你的密码输入有误", Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(LoginActivity.this, "服务器异常", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }

    //注册用户Activity
    public void register(View view){
        startActivity(new Intent(this, RegisterActivity.class));
    }
}
