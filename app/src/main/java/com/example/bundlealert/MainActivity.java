package com.example.bundlealert;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etpg,etds,etag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();

    }

    private void findViews(){
        etpg = (EditText)findViewById(R.id.editText);
        etds = (EditText)findViewById(R.id.editText2);
        etag = (EditText)findViewById(R.id.editText3);
    }

    private boolean isValid(EditText editText){
        String pattern = "1[0]{2}|[0-9]{1,2}";
        String text = editText.getText().toString();
        if(!text.matches(pattern)){
            editText.setError("0~100");
            return false;
        }
        else{
            return true;
        }
    }
    public void onSubmitClick(View view){
        boolean isValid=isValid(etpg)& isValid(etds)& isValid(etag);
        if(!isValid){
            return;
        }
        int pg = Integer.parseInt(etpg.getText().toString());
        int ds = Integer.parseInt(etds.getText().toString());
        int ag = Integer.parseInt(etag.getText().toString());
        Intent intent = new Intent(this,ResultActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("programming",pg);
        bundle.putInt("dataStructure",ds);
        bundle.putInt("algorithm",ag);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
