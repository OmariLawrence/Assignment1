package com.example.olawr.assignment1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageButton im;
    Button add1, add2, add3, add4;
    Button remove1, remove2, remove3, remove4;
    Button cal;
    boolean changed = false;
    RelativeLayout layout;
    TextView tv1, tv2, tv3, tv4, tv5, totalcost;
    int fullcount = 0, count1 = 0, count2 = 0, count3 = 0, count4 = 0;
    double vat = 1, cost;
    RadioButton r1, r2, r3;
    CheckBox cb1;
    EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add1 = (Button) findViewById(R.id.button1);
        add2 = (Button) findViewById(R.id.button3);
        add3 = (Button) findViewById(R.id.button5);
        add4 = (Button) findViewById(R.id.button7);
        remove1 = (Button) findViewById(R.id.button2);
        remove2 = (Button) findViewById(R.id.button4);
        remove3 = (Button) findViewById(R.id.button6);
        remove4 = (Button) findViewById(R.id.button8);
        cal = (Button) findViewById(R.id.button9);
        layout = (RelativeLayout) findViewById(R.id.screen1);
        im = (ImageButton) findViewById(R.id.imageButton);
        tv1 = (TextView) findViewById(R.id.textview6);
        tv2 = (TextView) findViewById(R.id.textview7);
        tv3 = (TextView) findViewById(R.id.textview8);
        tv4 = (TextView) findViewById(R.id.textview9);
        tv5 = (TextView) findViewById(R.id.textview12);
        r1 = (RadioButton) findViewById(R.id.radiobutton1);
        r1.setChecked(true);
        tv5.setTextColor(Color.RED);
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!changed) {
                    layout.setBackgroundColor(Color.GREEN);
                    changed = true;
                } else {
                    layout.setBackgroundColor(Color.WHITE);
                    changed = false;
                }
            }
        });
    }

    public void addclick1(View v) {
        if (fullcount < 5) {
            fullcount++;
            count1++;
            tv1.setText("" + count1);
        } else {
            tv5.setVisibility(View.VISIBLE);
        }

    }

    public void addclick2(View v) {
        if (fullcount < 5) {
            fullcount++;
            count2++;
            tv2.setText("" + count2);
        } else {
            tv5.setVisibility(View.VISIBLE);
        }

    }

    public void addclick3(View v) {
        if (fullcount < 5) {
            fullcount++;
            count3++;
            tv3.setText("" + count3);
        } else {
            tv5.setVisibility(View.VISIBLE);
        }

    }

    public void addclick4(View v) {
        if (fullcount < 5) {
            fullcount++;
            count4++;
            tv4.setText("" + count4);
        } else {
            tv5.setVisibility(View.VISIBLE);
        }

    }

    public void removeclick1(View v) {
        if (fullcount > 0 && count1 > 0) {
            fullcount--;
            count1--;
            tv1.setText("" + count1);
            tv5.setVisibility(View.INVISIBLE);
        }

    }

    public void removeclick2(View v) {
        if (fullcount > 0 && count2 > 0) {
            fullcount--;
            count2--;
            tv2.setText("" + count2);
            tv5.setVisibility(View.INVISIBLE);
        }

    }

    public void removeclick3(View v) {
        if (fullcount > 0 && count3 > 0) {
            fullcount--;
            count3--;
            tv3.setText("" + count3);
            tv5.setVisibility(View.INVISIBLE);
        }

    }

    public void removeclick4(View v) {
        if (fullcount > 0 && count4 > 0) {
            fullcount--;
            count4--;
            tv4.setText("" + count4);
            tv5.setVisibility(View.INVISIBLE);
        }

    }

    public void calculate(View v) {

        r2 = (RadioButton) findViewById(R.id.radiobutton2);
        r3 = (RadioButton) findViewById(R.id.radiobutton3);
        cb1 = (CheckBox) findViewById(R.id.checkbox1);
        et1 = (EditText) findViewById(R.id.edittext1);
        totalcost = (TextView) findViewById(R.id.textview13);

        if (cb1.isChecked()) {
            vat = 0.2;
        } else {
            vat = 0;
        }
        cost = (count1 * 50) + (count2 * 100) + (count3 * 150) + (count4 * 200);
        cost = cost + (cost * vat);
        String cc = et1.getText().toString();
        if (cc.equals("COMP3606DISC005")) {
            cost = cost - (cost * 0.05);
        } else if (cc.equals("COMP3606DISC010")) {
            cost = cost - (cost * 0.1);
        }
        if (cost != 0) {
            if (r1.isChecked()) {
                cost += 4.95;
            } else if (r2.isChecked()) {
                cost += 5.95;
            } else {
                cost++;
            }
        }
        totalcost.setText("" + cost);
    }
}
