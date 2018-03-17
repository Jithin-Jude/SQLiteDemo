package com.inc.mountzoft.sqlite_demo;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        displayData();
    }

    public void displayData(){
        myDb = new DatabaseHelper(this);

        Cursor res = myDb.getAllData();
        if(res.getCount() == 0) {
            Toast.makeText(this,"Nothing found",Toast.LENGTH_LONG).show();
            return;
        }

        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()) {
            buffer.append("Id :"+ res.getString(0)+"\n");
            buffer.append("Name :"+ res.getString(1)+"\n");
            buffer.append("---------------------\n");
        }

        TextView text = (TextView) this.findViewById(R.id.dataDisplay);
        text.setText(buffer.toString());
    }
/*==================================================================================================
public void deleteData(){
    myDb = new DatabaseHelper(this);

    Integer deletedRows = myDb.deleteData(editTextId.getText().toString());
    if(deletedRows > 0)
        Toast.makeText(MainActivity.this,"Data Deleted",Toast.LENGTH_LONG).show();
    else
        Toast.makeText(MainActivity.this,"Data not Deleted",Toast.LENGTH_LONG).show();
}

    public void deleteData(){
        myDb = new DatabaseHelper(this);

        boolean isUpdate = myDb.updateData(editTextId.getText().toString(), editName.getText().toString());
        if(isUpdate == true)
            Toast.makeText(MainActivity.this,"Data Update",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(MainActivity.this,"Data not Updated",Toast.LENGTH_LONG).show();
    }
 =================================================================================================*/

    public void AddStudentBtnFunction(View view){
        Intent intent = new Intent(this,AddStudentActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
