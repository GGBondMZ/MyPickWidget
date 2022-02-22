package com.mz.mypicker;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.mz.mypicker.other.OnItemPickListener;
import com.mz.mypicker.other.WheelAdapter;
import com.mz.mypicker.other.WheelView;

import java.util.ArrayList;
import java.util.List;

public class JavaCodeActivity extends AppCompatActivity {
    private String[] stringArray1 = new String[59];
    private ArrayList<String> stringArrayList = new ArrayList<String>();
    private static final String TAG = "JavaCodeActivity";
    private List<String> listData = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int j = 0;
        for (int i = 0; i < 12; i++) {
            j += 5;
            stringArrayList.add("" + j);
        }

        WheelView wheelView = findViewById(R.id.wheel_view);
        wheelView.setCanLoop(false);
        wheelView.setLabel("分钟");
        wheelView.setAdapter(new WheelAdapter() {
            @Override
            public int getItemsCount() {
                return stringArrayList.size();
            }

            @Override
            public Object getItem(int index) {
                return stringArrayList.get(index);
            }

            @Override
            public int indexOf(Object o) {
                return stringArrayList.indexOf(o);
            }
        });
        wheelView.setOnItemPickListener(new OnItemPickListener() {
            @Override
            public void onItemPicked(int index, Object item) {
                Log.e(TAG, "onItemPicked: index--->" + index + "---item--->" + (String) item);
            }
        });
    }
}