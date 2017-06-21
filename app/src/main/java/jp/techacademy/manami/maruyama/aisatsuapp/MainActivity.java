package jp.techacademy.manami.maruyama.aisatsuapp;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mTextView;
    int jikan = 25 ;
    String aisatsu ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        mTextView = (TextView) findViewById(R.id.textView);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button1) {
            mTextView.setText(String.valueOf(jikan));
            mTextView.setText(aisatsu);

        } else if (v.getId() == R.id.button2) {
            showTimePickerDialog();
        }
    }

    private void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        jikan = hourOfDay;
                        int num = jikan;
                        if (num >= 18) {
                            aisatsu = "こんばんは";
                        } else if (num >= 10) {
                            aisatsu = "こんにちは";
                        } else if (num >= 10) {
                            aisatsu = "おはよう";
                        } else {
                            aisatsu = "こんばんは";
                        }

                        Log.d("UI-PARTS", String.valueOf(jikan) + ":" + String.valueOf(minute));
                    }
                },
                13, // 初期値（時間）
                0,  // 初期値（分）
                true);
        timePickerDialog.show();
    }
}
