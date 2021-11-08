package com.example.sportspreferences;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class infoClass extends AppCompatActivity implements View.OnClickListener{
    TextView tvName,tvSport;
    Button btnReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        initialized();



    }

    private void initialized() {
        btnReturn = findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(this);
        tvName= findViewById(R.id.lblName);
        tvSport = findViewById(R.id.lblSport);
        String name= getIntent().getStringExtra("name");
        String label1 = tvName.getText().toString();
        tvName.setText(label1+name);

        int idSport = getIntent().getIntExtra("sport",-100);
        String sport = "No Sport! you gonna die";

        switch (idSport){
            case R.id.rbSoccer:
                sport="Soccer";
                break;

            case R.id.rbHandball:
                sport="HandBall";
                break;
            case R.id.rbHockey:
                sport="Hockey";
                break;

        }
        tvSport.append(sport);
    }
    @Override
    public void onClick(View view){
        finish();
    }
}
