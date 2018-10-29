package com.example.admin.lab2;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {
    private EditText edName, edScore;
    private Button btSend;
    private TextView tvResult;

    String strName, strScore;

    public static final String SERVICE_NAME = "https://thptgb1.000webhostapp.com/public_mauduan/index.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edName = findViewById(R.id.edName);
        edScore = findViewById(R.id.edScore);
        btSend = findViewById(R.id.btSend);
        tvResult = findViewById(R.id.tvResult);
        btSend.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btSend:
                strName = edName.getText().toString();
                strScore = edScore.getText().toString();
                BackgroundTask_GET backgroundTask = new BackgroundTask_GET(MainActivity.this, tvResult, strName, strScore);
                backgroundTask.execute();
                break;
        }
    }
}
