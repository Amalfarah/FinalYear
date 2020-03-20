package com.example.cs17aaf1.gbvreport;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Form extends AppCompatActivity {



    String first;
    String last;
    String add;
    String date;
    String number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);



    }

    public boolean onOptionsItemSelected(MenuItem item){
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);

        startActivityForResult(intent,0);
        return true;


    }
    public void submitt (View view){

        send sendcode = new send();
        EditText name = (EditText) findViewById(R.id.name1);
        EditText lastname = (EditText) findViewById(R.id.surname1);
        EditText address = (EditText) findViewById(R.id.addresss1);
        EditText dob = (EditText) findViewById(R.id.dob1);
        EditText phone = (EditText) findViewById(R.id.phone1);
        first = name.getText().toString();
        last = lastname.getText().toString();
        add = address.getText().toString();
        date = dob.getText().toString();
        number = phone.getText().toString();



        sendcode.execute();

    }
    class send extends AsyncTask<Void,Void,Void>{

        Socket s;
        PrintWriter pw;
        @Override
        protected Void doInBackground(Void... voids) {

            try {
                s = new Socket("134.83.53.199", 1000);
                pw = new PrintWriter(s.getOutputStream());
                pw.write((first));
                pw.flush();
                pw.write((last));
                pw.flush();
                pw.write((add));
                pw.flush();
                pw.write((date));
                pw.flush();
                pw.write((number));
                pw.flush();

                pw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }



//                pw = new PrintWriter(String.valueOf(s.getInputStream()));
////                read = new InputStreamReader(s.getInputStream());
////                data = new BufferedReader(read);
//

            return null;
        }
    }





}
