package com.gc.smssender;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button bt_send = (Button)findViewById(R.id.bt_send);
        bt_send.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				EditText et_phone = (EditText) findViewById(R.id.et_phone);
				EditText et_content = (EditText) findViewById(R.id.et_content);
				String phone = et_phone.getText().toString();
				String content = et_content.getText().toString();
				
				//获取短信管理器
				SmsManager sm = SmsManager.getDefault();
				//切割短信,把长短信切割成若干小短信
				ArrayList<String> sms = sm.divideMessage(content);
				//把集合中的所有短信发送出去
				for (String string : sms) {
					sm.sendTextMessage(phone, null, string, null, null);
				}
				
				
			}
		});
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
