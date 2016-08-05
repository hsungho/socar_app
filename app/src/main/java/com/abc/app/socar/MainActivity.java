package com.abc.app.socar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.abc.app.socar.member.MemberBean;
import com.abc.app.socar.member.MemberDAO;
import com.abc.app.socar.member.MemberService;
import com.abc.app.socar.member.MemberServiceImpl;

public class MainActivity extends Activity implements View.OnClickListener{

    EditText et_id, et_pw;
    Button bt_login, bt_join;
    MemberService service;
    MemberDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        service = new MemberServiceImpl(this.getApplicationContext());
        setContentView(R.layout.activity_main);
        et_id = (EditText) findViewById(R.id.et_id);
        et_pw = (EditText) findViewById(R.id.et_pw);
        bt_join = (Button) findViewById(R.id.bt_join);
        bt_login = (Button) findViewById(R.id.bt_login);
        bt_login.setOnClickListener(this);
        bt_join.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_login:
                Toast.makeText(MainActivity.this,"ID :"+ et_id.getText().toString()+"PW : "+
                        et_pw.getText().toString(),Toast.LENGTH_LONG).show();
                MemberBean member = new MemberBean();
                member.setId(et_id.getText().toString());
                member.setPw(et_pw.getText().toString());

                if (service.login(member)){
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    intent.putExtra("id", member.getId());
                    intent.putExtra("pw", member.getPw());
                    intent.putExtra("name", service.findById(member.getId()).getName());
                    intent.putExtra("phone", service.findById(member.getId()).getPhone());
                    intent.putExtra("address", service.findById(member.getId()).getAddress());
                    startActivity(intent);
                }else {
//                    startActivity(new Intent(this,HomeActivity.class));
                    startActivity(new Intent(this,MainActivity.class));
                    Toast.makeText(MainActivity.this,"다시입력해주세요",Toast.LENGTH_LONG).show();
                }

                break;
            case R.id.bt_join:
                startActivity(new Intent(this,RegistActivity.class));
                Toast.makeText(MainActivity.this,"Join"+bt_join.getText().toString(),Toast.LENGTH_LONG).show();
                break;

        }



    }
}
