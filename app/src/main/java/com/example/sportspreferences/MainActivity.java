package com.example.sportspreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText name;
    Button clear,quit,next;
    RadioGroup rdSport;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {
        name=findViewById(R.id.editName);
        rdSport=findViewById(R.id.rgSport);
        clear=findViewById(R.id.btnClear);
        next=findViewById(R.id.btnNext);
        quit=findViewById(R.id.btnQuit);
        clear.setOnClickListener(this);
        next.setOnClickListener(this);
        quit.setOnClickListener(this);

    }
    @Override
    public void onClick(View view){
        int id=view.getId();
        switch (id){
            case R.id.btnClear:
                clearWidgets();
                break;
            case R.id.btnQuit:
                quitApp();
                break;
            case R.id.btnNext:
                goToSecondActivity();
                break;

        }

    }

    private void goToSecondActivity() {
        String nam= name.getText().toString();
        int idSport=rdSport.getCheckedRadioButtonId();

        Intent intent = new Intent(this,infoClass.class);
        intent.putExtra("name",nam);
        intent.putExtra("sport",idSport);
        startActivity(intent);

    }

    private void quitApp() {
        System.exit(0);
    }

    private void clearWidgets() {
        name.setText(null);
        rdSport.clearCheck();
    }


}