package com.example.realmassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {
    private Context mContext;
    private Switch sw;
    private String gender="";
    Realm realm;
    private EditText name;
    private EditText roll,phone,dept;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.name);
        roll=findViewById(R.id.roll);
        phone=findViewById(R.id.phone);
        dept=findViewById(R.id.dept);
        sw=findViewById(R.id.sw_ma);
        mContext=this;
    }

    public void onSave(View view) {
        Realm.init(this);
        if(sw.isChecked())
            gender="Female";
        else
            gender="Male";
        realm=Realm.getDefaultInstance();
        realm.beginTransaction();
        try{
            Student student=realm.createObject(Student.class,System.currentTimeMillis());
            student.setDept(dept.getText().toString());
            student.setGender(gender);
            student.setName(name.getText().toString());
            student.setRoll(roll.getText().toString());
            student.setPhone(phone.getText().toString());
            realm.commitTransaction();
            Toast.makeText(mContext, "Success", Toast.LENGTH_SHORT).show();
            name.setText("");
            roll.setText("");
            phone.setText("");
            dept.setText("");
            sw.setChecked(false);
        }
        catch(Exception ex){
            realm.cancelTransaction();
            Toast.makeText(mContext, "Failure" + ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
        realm.close();
    }

    public void onDisplay(View view) {
        Intent intent=new Intent(mContext,DisplayActivity.class);
        startActivity(intent);
    }
}
