package com.jay.viewholderpassdata.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.jay.viewholderpassdata.MainActivity;
import com.jay.viewholderpassdata.R;
import com.jay.viewholderpassdata.model.CustomModel;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by abhisheksharma on 21-Sep-2018.
 */

public class first_Activity extends AppCompatActivity {

    Button button;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fisrt);

        button = (Button) findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(first_Activity.this, MainActivity.class);
                //startActivityForResult(in, 1);
                startActivity(in);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1)
        {
            if(resultCode == Activity.RESULT_OK)
            {
                //HashMap<String, String> hashMap = (HashMap<String, String>)intent.getSerializableExtra("map");
                HashMap<String, String> hMapHeaderAndCount = (HashMap<String, String>)data.getSerializableExtra("hMapHeaderAndCount");


                if (data.getSerializableExtra("LHM") != null)
                {
                    try {
                        LinkedHashMap<String, List<CustomModel>> user_info = (LinkedHashMap<String, List<CustomModel>>)
                                data.getSerializableExtra("LHM");

                        LinkedHashMap<String, List<CustomModel>> userdata = (LinkedHashMap<String, List<CustomModel>>) user_info;
                        int x = 5;
                    }catch (Exception ex)
                    {
                        String s =ex.getMessage();
                    }
                }
                else
                {
                    String s1 ="";

                }
            }
        }
    }
}
