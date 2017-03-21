package com.nao20010128nao.CSoA;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle
import android.widget.TextView
import groovy.transform.CompileStatic;

public class MainActivity extends AppCompatActivity {

    @Override
    @CompileStatic
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.run).onClickListener={
            def text=(findViewById(R.id.text) as TextView).text
            def output=new ConfigSlurper().parse(text.toString())
            (findViewById(R.id.result) as TextView).text=output.toString()
        }
    }
}
