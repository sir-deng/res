package com.helen.rxandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.helen.rxandroid.presenter.MainPresenter;
import com.helen.rxandroid.view.IMainView;

public class MainActivity extends AppCompatActivity implements IMainView{

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text);
        MainPresenter mainPresenter = new MainPresenter(this);
        mainPresenter.getData();

    }



    @Override
    public void getData(String data) {
        if (textView!=null){
            textView.setText(data);
        }
    }
}
