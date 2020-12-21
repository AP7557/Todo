package com.example.todo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    EditText updateItem;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        updateItem = findViewById(R.id.updateItem);
        btnSave = findViewById(R.id.btnSave);

        getSupportActionBar().setTitle("Edit Item");

        updateItem.setText(getIntent().getStringExtra(MainActivity.KEY_ITEM_TEXT));
        //user done editing, and click save
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create intent that contains results
                Intent intent = new Intent();
                //pass data(editing)
                intent.putExtra(MainActivity.KEY_ITEM_TEXT, updateItem.getText().toString());
                intent.putExtra(MainActivity.KEY_ITEM_POSITION, getIntent().getExtras().getInt(MainActivity.KEY_ITEM_POSITION));
                //set result of intent
                setResult(RESULT_OK, intent);
                //finish activity
                finish();
            }
        });
    }
}