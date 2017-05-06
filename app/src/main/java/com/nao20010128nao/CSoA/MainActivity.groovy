package com.nao20010128nao.CSoA

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.gson.stream.JsonWriter
import android.widget.TextView
import com.google.gson.Gson
import groovy.transform.CompileStatic
import me.champeau.groovydroid.GrooidShell

public class MainActivity extends AppCompatActivity {
    GrooidShell compiler
    TextView text,result,run

    @Override
    @CompileStatic
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main)
        compiler=new GrooidShell(filesDir,classLoader)
        text=findViewById(R.id.text) as TextView
        result=findViewById(R.id.result) as TextView
        run=findViewById(R.id.run) as TextView
        run.onClickListener={
            def text=text.text.toString()
            run.enabled=false
            new Thread({
                def output=new StringWriter()
                def jw=new JsonWriter(output)
                jw.setIndent(" "*4)
                new Gson().toJson(new ConfigSlurper().parse(compiler.evaluate(text).script),ConfigObject,jw)
                runOnUiThread{
                    result.text=output.toString()
                    run.enabled=true
                }
            }).start()
        }
    }
}
