package com.nao20010128nao.CSoA;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle
import android.widget.TextView
import groovy.transform.CompileStatic
import me.champeau.groovydroid.GrooidShell;

public class MainActivity extends AppCompatActivity {
    GrooidShell compiler
    @Override
    @CompileStatic
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main)
        compiler=new GrooidShell(filesDir,classLoader)
        findViewById(R.id.run).onClickListener={
            def text=(findViewById(R.id.text) as TextView).text
            def output=new ConfigSlurper().parse(compiler.evaluate(text.toString()).script)
            (findViewById(R.id.result) as TextView).text=output.toString()
        }
    }
}
