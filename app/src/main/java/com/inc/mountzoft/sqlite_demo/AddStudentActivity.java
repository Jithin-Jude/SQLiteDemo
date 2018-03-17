package com.inc.mountzoft.sqlite_demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddStudentActivity extends AppCompatActivity {

    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        myDb = new DatabaseHelper(this);
    }
    public void viewAllStudentsBtnFunction(View view){
        Intent intent = new Intent(this,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
    public void AddBtnFunction(View view){
        EditText inputStudentId = (EditText) findViewById(R.id.idTextBox);
        EditText inputStudentName = (EditText) findViewById(R.id.nameTextBox);

        String studentId = inputStudentId.getText().toString();
        String studentName = inputStudentName.getText().toString();

        boolean isInserted = myDb.insertData( studentId, studentName );
        if(isInserted)
            Toast.makeText(this,"Data Inserted",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this,"Data not Inserted",Toast.LENGTH_LONG).show();
    }
}
