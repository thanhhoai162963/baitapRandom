package com.example.random;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText mSomin, mSomax;
    Button mbtnRandom, mbtnAdd, mbtnReset;
    TextView mTvResult;
    int mMax, mMin,mResult,mIndex,mCount=0;
    String mStringMin, mStringMax, mStringResult="";
    Random mRandom;
    ArrayList<Integer> mArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSomin = findViewById(R.id.SoMin);
        mSomax = findViewById(R.id.SoMax);
        mbtnRandom = findViewById(R.id.btnRandom);
        mbtnAdd = findViewById(R.id.btnAdd);
        mbtnReset = findViewById(R.id.btnReset);
        mTvResult = findViewById(R.id.TvKetqua);
        mRandom = new Random();
        mArrayList = new ArrayList<>();
        if (mArrayList.size()==0) {
            mbtnRandom.setEnabled(false);
            mbtnReset.setEnabled(false);
        }
        mbtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mStringMin = mSomin.getText().toString();
                mStringMax = mSomax.getText().toString();
                if (mStringMin.isEmpty() || mStringMax.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Mời bạn nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                    return;
                }

                mMin = Integer.parseInt(mStringMin);
                mMax = Integer.parseInt(mStringMax);
                if(mMin >= mMax) {
                    mMax= mMin+1;
                    mSomax.setText(mMax+"");
                }
                for (int i= mMin; i<= mMax;i++)
                {
                    mArrayList.add(i);
                }

                Log.d("sss",""+mArrayList.size());
                if (mArrayList.size()>0)
                {
                    mbtnAdd.setEnabled(false);
                    mbtnRandom.setEnabled(true);
                    mbtnReset.setEnabled(true);
                }

                Log.d("ccc",""+ mArrayList);
            }
        });
        mbtnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mArrayList.size()==0)
                {
                    Toast.makeText(MainActivity.this, "Bạn đã nhập đủ số", Toast.LENGTH_SHORT).show();
                    return;
                }
                mIndex = mRandom.nextInt(mArrayList.size());
                mResult = mArrayList.get(mIndex);
                if(mArrayList.size()==1)
                {
                    mStringResult += mResult;
                }
                else {
                    mStringResult += mResult + "-";
                }
                mTvResult.setText(mStringResult);
                mArrayList.remove(mIndex);

            }
        });
        mbtnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSomin.setText("");
                mSomax.setText("");
                mArrayList.clear();
                mStringResult="";
                mTvResult.setText("");
                mbtnAdd.setEnabled(true);
                mbtnRandom.setEnabled(false);
                mbtnReset.setEnabled(false);
                Log.d("ttt","" +mArrayList);
            }
        });

    }
}
