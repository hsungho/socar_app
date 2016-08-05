package com.abc.app.socar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.abc.app.socar.member.MemberBean;
import com.abc.app.socar.member.MemberService;
import com.abc.app.socar.member.MemberServiceImpl;

public class RegistActivity extends Activity implements View.OnClickListener{

    TextView et_id,
            et_pw,
            et_name,
            et_phone,
            et_address;




    Button bt_join,bt_reset;
    MemberService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        service = new MemberServiceImpl(this.getApplicationContext());
        setContentView(R.layout.activity_regist);
        et_id = (TextView) findViewById(R.id.et_id);
        et_pw = (TextView) findViewById(R.id.et_pw);
        et_name = (TextView) findViewById(R.id.et_name);
        et_phone = (TextView) findViewById(R.id.et_phone);
        et_address = (TextView) findViewById(R.id.et_address);

        bt_join = (Button) findViewById(R.id.bt_join);
        bt_reset = (Button) findViewById(R.id.bt_reset);

        bt_join.setOnClickListener(this);
        bt_reset.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.bt_join:
            MemberBean member = new MemberBean();
                member.setId(et_id.getText().toString());
                member.setPw(et_pw.getText().toString());
                member.setName(et_name.getText().toString());
                member.setPhone(et_phone.getText().toString());
                member.setAddress(et_address.getText().toString());
                service.regist(member);
                startActivity(new Intent(this,MainActivity.class));
                break;

            case R.id.bt_reset :
                et_id.setText("");
                et_name.setText("");
                et_pw.setText("");
                et_phone.setText("");
                et_address.setText("");


                Toast.makeText(RegistActivity.this,"",Toast.LENGTH_LONG).show();
                startActivity(new Intent(this,MainActivity.class));
                break;


        }



    }
}
