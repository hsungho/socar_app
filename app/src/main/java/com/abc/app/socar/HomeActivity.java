package com.abc.app.socar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.abc.app.socar.member.MemberService;
import com.abc.app.socar.member.MemberServiceImpl;

public class HomeActivity extends Activity implements View.OnClickListener{

    ImageButton bt_top,ib_aaa,ib_bbb,ib_ccc,ib_ddd;
    Button bt_cu,bt_cu2,bt_driving,bt_home,bt_booking,bt_smartKey,bt_myPage;
    MemberService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        service = new MemberServiceImpl(this.getApplicationContext());
        setContentView(R.layout.activity_home);
        bt_top = (ImageButton) findViewById(R.id.bt_top);
        bt_cu = (Button) findViewById(R.id.bt_cu);
        bt_cu2 = (Button) findViewById(R.id.bt_cu2);
        bt_driving = (Button) findViewById(R.id.bt_driving);
        ib_aaa = (ImageButton) findViewById(R.id.ib_aaa);
        ib_bbb = (ImageButton) findViewById(R.id.ib_bbb);
        ib_ccc = (ImageButton) findViewById(R.id.ib_ccc);
        ib_ddd = (ImageButton) findViewById(R.id.ib_ddd);
        bt_home = (Button) findViewById(R.id.bt_home);
        bt_booking = (Button) findViewById(R.id.bt_booking);
        bt_smartKey = (Button) findViewById(R.id.bt_smartKey);
        bt_myPage = (Button) findViewById(R.id.bt_myPage);

        bt_top.setOnClickListener(this);
        bt_cu.setOnClickListener(this);
        bt_cu2.setOnClickListener(this);
        bt_driving.setOnClickListener(this);
        ib_aaa.setOnClickListener(this);
        ib_bbb.setOnClickListener(this);
        ib_ccc.setOnClickListener(this);
        ib_ddd.setOnClickListener(this);
        bt_home.setOnClickListener(this);
        bt_booking.setOnClickListener(this);
        bt_smartKey.setOnClickListener(this);
        bt_myPage.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.bt_top :
                Toast.makeText(HomeActivity.this,"선영아 사랑해~!!",Toast.LENGTH_LONG).show();
                break;

            case R.id.bt_cu :
                Toast.makeText(HomeActivity.this,"선영아 난 너밖에 없어!!",Toast.LENGTH_LONG).show();
                break;

            case R.id.bt_cu2 :
                Toast.makeText(HomeActivity.this,"선영아 넌 나의 노예~!!",Toast.LENGTH_LONG).show();
                break;

            case R.id.bt_driving :
                Toast.makeText(HomeActivity.this,"I got u~~ 선영!!",Toast.LENGTH_LONG).show();
                startActivity(new Intent(this,DrivingActivity.class));
                break;

            case R.id.ib_aaa :
                Toast.makeText(HomeActivity.this,"포토aaa",Toast.LENGTH_LONG).show();
                startActivity(new Intent(this,PhotoActivity.class));

                break;
            case R.id.ib_bbb :
                Toast.makeText(HomeActivity.this,"포토bbb",Toast.LENGTH_LONG).show();
                startActivity(new Intent(this,PhotoActivity.class));

                break;
            case R.id.ib_ccc :
                Toast.makeText(HomeActivity.this,"포토ccc",Toast.LENGTH_LONG).show();
                startActivity(new Intent(this,PhotoActivity.class));

                break;
            case R.id.ib_ddd :
                Toast.makeText(HomeActivity.this,"포토ddd",Toast.LENGTH_LONG).show();
                startActivity(new Intent(this,PhotoActivity.class));

                break;

            case R.id.bt_home :  startActivity(new Intent(this,HomeActivity.class));break;

       case R.id.bt_booking : break;

            case R.id.bt_smartKey : Toast.makeText(HomeActivity.this,"ff",Toast.LENGTH_LONG).show(); break;

            case R.id.bt_myPage :
                Intent intent = getIntent();
                String id = intent.getExtras().getString("id");
                String pw = intent.getExtras().getString("pw");
                String name = intent.getExtras().getString("name");
                String phone = intent.getExtras().getString("phone");
                String address = intent.getExtras().getString("address");

                Intent moveIntent = new Intent(HomeActivity.this, MyinfoActivity.class);
                moveIntent.putExtra("id", id);
                moveIntent.putExtra("pw", pw);
                moveIntent.putExtra("name", name);
                moveIntent.putExtra("phone", phone);
                moveIntent.putExtra("address", address);
                startActivity(moveIntent);
                break;
        }
    }
}
