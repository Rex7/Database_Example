package com.example.regis.projectuserinterface;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class FrontEnd extends AppCompatActivity {EditText first_name, last_name, cours, phone, emailid, rollno;

        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_front_end);
            first_name = (EditText) findViewById(R.id.FirstName);
            last_name = (EditText) findViewById(R.id.LastName);
            cours = (EditText) findViewById(R.id.Course);
            phone = (EditText) findViewById(R.id.PhoneNo);
            emailid = (EditText) findViewById(R.id.EmailId);
            rollno=(EditText)findViewById(R.id.Rollno);
        }

        public void Submit(View v) {


            String firstname = first_name.getText().toString();
            String last = last_name.getText().toString();
            String course = cours.getText().toString();
            String phones = phone.getText().toString();
            int roll= Integer.parseInt(rollno.getText().toString());
            String email = emailid.getText().toString();
            Student s = new Student(firstname,last,email,phones,course,roll);
            handler h = new handler(this,null,null,1);
            h.register(s);
        }

        public void clear(View v) {
            first_name.setText("");
            last_name.setText("");
            cours.setText("");
            phone.setText("");
            emailid.setText("");
        }




}
