package com.shetty.statuseditor;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    MainActivityViewModel mainActivityViewModel;
    private TextView textViewNumber;
    private FloatingActionButton floatingActionButtonUpdate;
    private String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        floatingActionButtonUpdate = findViewById(R.id.fb_update);
        floatingActionButtonUpdate.setOnClickListener(this);
        LiveData<String> liveDataRandomNumber = mainActivityViewModel.getNumber();
        liveDataRandomNumber.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textViewNumber.setText(s);

            }
        });
        textViewNumber.setText(liveDataRandomNumber.getValue());

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fb_update:
                mainActivityViewModel.updateRandomNumber();
                break;
        }
    }
}



