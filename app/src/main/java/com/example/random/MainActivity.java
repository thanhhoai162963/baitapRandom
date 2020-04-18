package com.example.random;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText mSomin, mSomax;
    Button mRandom;
    TextView mTvResult;
    int mMax, mMin,mResult, mCount=0,mRange,a;
    String mStringMin, mStringMax,m1,m2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSomin = findViewById(R.id.SoMin);
        mSomax = findViewById(R.id.SoMax);
        mRandom = findViewById(R.id.btnRandom);
        mTvResult = findViewById(R.id.TvKetqua);
        mRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCount++;
                mStringMin = mSomin.getText().toString();
                mStringMax = mSomax.getText().toString();
                if (mStringMin.isEmpty() || mStringMax.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Mời bạn nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                    return;
                }
                mMin = Integer.parseInt(mStringMin);
                mMax = Integer.parseInt(mStringMax);
                mRange  = mMax - mMin;
                if(mMin < mMax) {
                    if (mCount > mRange) {
                        Toast.makeText(MainActivity.this, "Bạn đã nhập đủ số lần", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                if (mMin > mMax)
                {
                    mMax = mMin + 1;
                    mSomax.setText(""+ mMax);
                }
                Random random = new Random();
                mResult = random.nextInt((mMax-mMin) + 1) + mMin;
                mTvResult.setText("" + mResult +"-");
                m1=mTvResult.getText().toString();
                m2= m2+ mResult;
                mTvResult.setText("-" + mResult +"-"+ m2 +"-");
            }
        });
        m2 =m1;

    }
}
