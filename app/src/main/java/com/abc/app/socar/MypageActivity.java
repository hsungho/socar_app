package com.abc.app.socar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MypageActivity extends Activity implements View.OnClickListener{
    Button bt_myInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);
    bt_myInfo = (Button) findViewById(R.id.bt_myInfo);

        bt_myInfo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
    switch (v.getId()){
        case R.id.bt_myInfo :
            startActivity(new Intent(this,MyinfoActivity.class));

    }
    }
}
