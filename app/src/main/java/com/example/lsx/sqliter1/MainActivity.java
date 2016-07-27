package com.example.lsx.sqliter1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.lsx.sqliter1.database.MydatabaseHelper;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

public class MainActivity extends AppCompatActivity {
    private Button mbutton;
    private MydatabaseHelper dbHelper;
    private  Button mutilsButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper=new MydatabaseHelper(this,"BookStore.db",null,2);
        mbutton= (Button) findViewById(R.id.avtivity_main_buton_id);
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.getWritableDatabase();
            }
        });
        mutilsButton= (Button) findViewById(R.id.XUtilsButton);
        mutilsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HttpUtils http = new HttpUtils();
                http.send(HttpRequest.HttpMethod.GET,
                        "http://tapi.test.tuoguibao.com/basicapi.php?ac=1002&mobile=18562172800&password=123456",
                        new RequestCallBack<String>(){
                            @Override
                            public void onLoading(long total, long current, boolean isUploading) {
                                //testTextView.setText(current + "/" + total);
                            }

                            @Override
                            public void onSuccess(ResponseInfo<String> responseInfo) {
                               // textView.setText(responseInfo.result);
                                Log.i("jasonTag", responseInfo.result);
                            }

                            @Override
                            public void onStart() {
                            }

                            @Override
                            public void onFailure(HttpException error, String msg) {

                                Log.i("jasonTag","链接失败" );
                            }
                        });

            }
        });
    }

}
