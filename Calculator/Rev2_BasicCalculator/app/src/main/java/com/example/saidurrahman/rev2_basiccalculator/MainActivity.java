package com.example.saidurrahman.rev2_basiccalculator;

/* Video tutorials can be found at https://www.youtube.com/watch?v=tj-bSlZvRCQ&t=480s
 and https://www.youtube.com/watch?v=782_MBAZRuw */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {

    //---------------- Variable Declaration -------------------
    Button btnClear, btnadd, btnsubtract, btnmultiply, btndivide, btndot, btnbackspace, btnsmallbrackets, btnequal, btnpercentage;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0;
    TextView tvProcessor, tvResult;
    String processor;
    Boolean issmallbracketsopen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        issmallbracketsopen = false;

        //------------ Assigning Variables --------------------
        tvProcessor = (TextView) findViewById(R.id.tv_process);
        tvResult = (TextView) findViewById(R.id.tv_result);

        btnClear = (Button) findViewById(R.id.btn_delete);
        btnadd = (Button) findViewById(R.id.btn_add);
        btnsubtract = (Button) findViewById(R.id.btn_subtract);
        btnmultiply = (Button) findViewById(R.id.btn_multiply);
        btndivide = (Button) findViewById(R.id.btn_divide);
        btndot = (Button) findViewById(R.id.btn_dot);
        btnbackspace = (Button) findViewById(R.id.btn_backspace);
        btnsmallbrackets = (Button) findViewById(R.id.btn_small_brackets);
        btnequal = (Button) findViewById(R.id.btn_equal);
        btnpercentage = (Button) findViewById(R.id.btn_percentage);

        btn1 = (Button) findViewById(R.id.btn_1);
        btn2 = (Button) findViewById(R.id.btn_2);
        btn3 = (Button) findViewById(R.id.btn_3);
        btn4 = (Button) findViewById(R.id.btn_4);
        btn5 = (Button) findViewById(R.id.btn_5);
        btn6 = (Button) findViewById(R.id.btn_6);
        btn7 = (Button) findViewById(R.id.btn_7);
        btn8 = (Button) findViewById(R.id.btn_8);
        btn9 = (Button) findViewById(R.id.btn_9);
        btn0 = (Button) findViewById(R.id.btn_0);

        //------------ Assigning Listeners to operator buttons ---------
        btnClear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                tvProcessor.setText("");
                tvResult.setText("");
            }
        });

        btnadd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                processor = tvProcessor.getText().toString();
                tvProcessor.setText(processor + "+");
            }
        });

        btnsubtract.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                processor = tvProcessor.getText().toString();
                tvProcessor.setText(processor + "-");
            }
        });

        btnmultiply.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                processor = tvProcessor.getText().toString();
                tvProcessor.setText(processor + "*");
            }
        });

        btndivide.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                processor = tvProcessor.getText().toString();
                tvProcessor.setText(processor + "/");
            }
        });

        btndot.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                processor = tvProcessor.getText().toString();
                tvProcessor.setText(processor + ".");
            }
        });

        btnbackspace.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                processor = tvProcessor.getText().toString();
                if (processor.length() > 0) {
                    processor = processor.substring(0, processor.length()-1);
                    tvProcessor.setText(processor);
                }

            }
        });

        btnsmallbrackets.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (issmallbracketsopen) {
                    processor = tvProcessor.getText().toString();
                    tvProcessor.setText(processor + ")");
                    issmallbracketsopen = false;
                }   else {
                    processor = tvProcessor.getText().toString();
                    tvProcessor.setText(processor + "(");
                    issmallbracketsopen = true;
                }

            }
        });

        btnpercentage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                processor = tvProcessor.getText().toString();
                tvProcessor.setText(processor + "%");
            }
        });

        btnequal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                processor = tvProcessor.getText().toString();

                processor = processor.replaceAll("%", "/100");

                Context rhino = Context.enter();
                rhino.setOptimizationLevel(-1);
                String result = "";

                try {
                    Scriptable scope = rhino.initStandardObjects();
                    result = rhino.evaluateString(scope, processor, "JavaScript", 1, null).toString();
                } catch (Exception e) {
                    result = "Error";
                }

                tvResult.setText(result);

            }
        });





        //------------ Assigning Listeners to number buttons ---------
        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                processor = tvProcessor.getText().toString();
                tvProcessor.setText(processor + "1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                processor = tvProcessor.getText().toString();
                tvProcessor.setText(processor + "2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                processor = tvProcessor.getText().toString();
                tvProcessor.setText(processor + "3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                processor = tvProcessor.getText().toString();
                tvProcessor.setText(processor + "4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                processor = tvProcessor.getText().toString();
                tvProcessor.setText(processor + "5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                processor = tvProcessor.getText().toString();
                tvProcessor.setText(processor + "6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                processor = tvProcessor.getText().toString();
                tvProcessor.setText(processor + "7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                processor = tvProcessor.getText().toString();
                tvProcessor.setText(processor + "8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                processor = tvProcessor.getText().toString();
                tvProcessor.setText(processor + "9");
            }
        });

        btn0.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                processor = tvProcessor.getText().toString();
                tvProcessor.setText(processor + "0");
            }
        });

    }
}
