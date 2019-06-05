package com.example.myapplication;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class ResultActivity extends AppCompatActivity {
    private TextView tvResult;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page2);
        tvResult = (TextView) findViewById(R.id.textView2);
        showResults();
    }
    private void showResults(){
        NumberFormat nf = NumberFormat.getInstance();
        Bundle bundle = getIntent().getExtras();
        int p = bundle.getInt("programming");
        int d = bundle.getInt("dataStructure");
        int a = bundle.getInt("algorithm");
        int sum = p+d+a;
        double average = sum / 3.0;
        String text = "programming="+p+"dataStructure="+d+"algorithm="+a+"\nsum="+sum+"\naverage="+nf.format(average);
        tvResult.setText(text);
        alert(average);
    }
    private void alert(double average){
        String message = new String();
        String title = new String();
        int pic = 0;
        if(average==100){
            message = "Congratulation";
            title = "PASS!";
            pic = R.drawable.pass;
        }
        else if(average<100 && average>=80){
            message = "Great";
            title = "PASS!";
            pic = R.drawable.pass2;
        }
        else if(average<80 && average>=60){
            message = "Good";
            title = "PASS!";
            pic = R.drawable.pass3;
        }
        else{
            message = "Fail";
            title = "PASS!";
            pic = R.drawable.fail;
        }
        AlertDialog.Builder bulider = new AlertDialog.Builder(this);

        bulider.setPositiveButton("OK",null);
        bulider.setNegativeButton("Cancel",null);
        bulider.setNeutralButton("Nothing",null);
        bulider.setMessage(message);
        bulider.setTitle(title);
        bulider.setIcon(pic);
        bulider.show();
    }
    public void onBackClick(View view){finish();}
}
