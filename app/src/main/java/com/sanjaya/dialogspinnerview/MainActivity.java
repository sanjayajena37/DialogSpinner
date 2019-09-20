package com.sanjaya.dialogspinnerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.sanjaya.dialogspinner.DialogSpinner;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    //Button myButton;
    TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txtView=findViewById(R.id.txtView);

        txtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ArrayList<String> arrayList=new ArrayList<>();
                arrayList.add("CTC");
                arrayList.add("BBSR");
                arrayList.add("PURI");
                arrayList.add("ANUGUL");
                arrayList.add("KHORDHA");

                DialogSpinner.show(MainActivity.this,"Select city",arrayList,txtView);
            }
        });
    }
}
