package com.example.cs17aaf1.gbvreport;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class options extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button form = (Button) findViewById(R.id.form);


        form.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(options.this,Form.class);
                startActivity(intent);
                finish();
            }
        });
        final Button anon = (Button) findViewById(R.id.anon);
        anon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(options.this,anon.class);
                startActivity(intent1);
                finish();
            }
        });
        final Button location = (Button) findViewById(R.id.travel);
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(options.this,location.class);
                startActivity(intent2);
                finish();
            }
        });
        final Button data = (Button) findViewById(R.id.data);
        data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(options.this,data.class);
                startActivity(intent3);
                finish();
            }
        });





    }
}
