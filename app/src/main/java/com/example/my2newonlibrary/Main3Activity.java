package com.example.my2newonlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    DBHelper myDb;
    EditText editName,editSurname,editMarks ,editTextId;
    Button btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        myDb = new DBHelper(this);

        editName = (EditText)findViewById(R.id.editText_Tit);
        editSurname = (EditText)findViewById(R.id.editText_Aut);
        editMarks = (EditText)findViewById(R.id.editText_Mot);
        editTextId = (EditText)findViewById(R.id.editT_id);
        btnUpdate= (Button)findViewById(R.id.button_update);
        UpdateData();

    }
    public void UpdateData() {
        btnUpdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdate = myDb.updateBook(editTextId.getText().toString(),
                                editName.getText().toString(),
                                editSurname.getText().toString(),editMarks.getText().toString());
                        if(isUpdate == true)
                            Toast.makeText(Main3Activity.this,"Data Update",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Main3Activity.this,"Data not Updated",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}
