package com.example.my2newonlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {
    DBHelper myDb;
    EditText editid;
    Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        myDb = new DBHelper(this);

        editid = (EditText)findViewById(R.id.editTextId);
        btnDelete= (Button)findViewById(R.id.button_delete);
        DeleteData();
    }

    public void DeleteData() {
        btnDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deletedRows = myDb.deleteData(editid.getText().toString());
                        if(deletedRows > 0)
                            Toast.makeText(Main4Activity.this,"Data Deleted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Main4Activity.this,"Data not Deleted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

}
