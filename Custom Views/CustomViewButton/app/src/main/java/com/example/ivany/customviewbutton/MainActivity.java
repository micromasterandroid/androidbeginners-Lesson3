package com.example.ivany.customviewbutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.ivany.customviewbutton.views.MyButton;

public class MainActivity extends AppCompatActivity {

    MyButton mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = findViewById(R.id.mButton);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), "Custom Button! :D", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
