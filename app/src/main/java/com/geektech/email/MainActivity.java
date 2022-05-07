package com.geektech.email;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private Button btnSend;
private EditText theme,eMail,message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eMail = findViewById(R.id.login);
        theme = findViewById(R.id.theme);
        message = findViewById(R.id.et_message);
        btnSend = findViewById(R.id.btn_send);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!eMail.getText().toString().isEmpty() && !theme.getText().toString().isEmpty()
                        && !message.getText().toString().isEmpty()) {
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[]{eMail.getText().toString()});
                    intent.putExtra(Intent.EXTRA_SUBJECT, theme.getText().toString());
                    intent.putExtra(Intent.EXTRA_TEXT, message.getText().toString());
                    intent.setType("message/822");
                    if (intent.resolveActivity(getPackageManager())!= null) {
                        startActivity(intent);
                    }
                }else {
                    Toast.makeText(MainActivity.this,"Пожалуйста, заполните все поля",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}