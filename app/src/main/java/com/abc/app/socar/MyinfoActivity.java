package com.abc.app.socar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.abc.app.socar.member.MemberBean;
import com.abc.app.socar.member.MemberService;
import com.abc.app.socar.member.MemberServiceImpl;

public class MyinfoActivity extends Activity implements View.OnClickListener{

    TextView tv_id,tv_pw,tv_name,tv_phone,tv_addr;
    Button bt_list,bt_update,bt_logout;
    MemberService service;
   //MemberService service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        service = new MemberServiceImpl(getApplicationContext());


        Intent intent = getIntent();
        String id = intent.getExtras().getString("id");
        String pw = intent.getExtras().getString("pw");
        String name = intent.getExtras().getString("name");
        String phone = intent.getExtras().getString("phone");
        String address = intent.getExtras().getString("address");

        setContentView(R.layout.activity_myinfo);

        tv_id = (TextView) findViewById(R.id.tv_id);
        tv_pw = (TextView) findViewById(R.id.tv_pw);
        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_phone = (TextView) findViewById(R.id.tv_phone);
        tv_addr = (TextView) findViewById(R.id.tv_addr);
        bt_list = (Button) findViewById(R.id.bt_list);
        bt_update = (Button) findViewById(R.id.bt_update);
        bt_logout = (Button) findViewById(R.id.bt_logout);

        bt_list.setOnClickListener(this);
        bt_update.setOnClickListener(this);
        bt_logout.setOnClickListener(this);

        tv_id.setText(id);
        tv_pw.setText(pw);
        tv_name.setText(name);
        tv_phone.setText(phone);
        tv_addr.setText(address);

    }

    @Override
    public void onClick(View v) {
    switch (v.getId()){
        case R.id.bt_list :
            startActivity(new Intent(this,HomeActivity.class));
            break;
        case R.id.bt_logout :

            MemberBean member = new MemberBean();
            service.logout();

            startActivity(new Intent(this,MainActivity.class));
    }

    }
}
