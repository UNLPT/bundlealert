package com.example.bundlealert;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class ResultActivity extends AppCompatActivity {
    private TextView tvr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        tvr = (TextView)findViewById(R.id.textView3);
        showResult();

    }

    private void showResult(){
        NumberFormat nf = NumberFormat.getInstance();
        Bundle bundle = getIntent().getExtras();
        int pg = bundle.getInt("programming");
        int ds = bundle.getInt("dataStructure");
        int ag = bundle.getInt("algorithm");
        int sum = pg + ds + ag;
        double average = sum/3.0;
        String text ="programming = "+pg +
                "\ndataStructure =" +ds +
                "\nalgorithm =" + ag +
                "\nsum = "+ sum +
                "\naverage ="+ nf.format(average);
        tvr.setText(text);
        alert(average);
    }

    private void alert(double average){
        String message = new String();
        String title = new String();
        int pic=0;

        if(average ==100){
            message="100";
            title="Pass";
            pic = R.drawable.circle;
        }
        else if(average>=60){
            message = "Congratulation!!";
            title="Pass";
            pic = R.drawable.circle;
        }
        else if(average <60){
            message = "See you next time";
            title="Fail";
            pic = R.drawable.cross;
        }
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message);
        builder.setTitle(title);
        builder.setIcon(pic);
        builder.show();
    }

    public void onBackClick(View view){finish();}
}
