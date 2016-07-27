package com.example.lsx.sqliter1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lsx.sqliter1.database.MydatabaseHelper;

public class MainActivity extends AppCompatActivity {
    private Button mbutton;
    private MydatabaseHelper dbHelper;
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
    }

}
