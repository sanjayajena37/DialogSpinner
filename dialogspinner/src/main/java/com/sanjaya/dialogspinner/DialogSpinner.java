package com.sanjaya.dialogspinner;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;

public class DialogSpinner {

    static public ArrayList<String> spinnerDtos; //=new ArrayList<>();
    static public AdapterSpinner adapterSpinner;

    static public void show(Context context, String header, ArrayList<String> arrayList, final TextView whereYoucanset) {
        final Dialog dialog1 = new Dialog((Activity)context);
        dialog1.setCanceledOnTouchOutside(false);
        spinnerDtos=new ArrayList<>();
        spinnerDtos=arrayList;
        dialog1.setContentView(R.layout.spinner_view);
        dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog1.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        ImageView button = dialog1.findViewById(R.id.iv_mark);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog1.dismiss();

            }
        });

        final RecyclerView spinnerRecy = dialog1.findViewById(R.id.spinnerRecy);
        final TextView txtHead = dialog1.findViewById(R.id.txtHead);
        txtHead.setText(header);

        adapterSpinner = new AdapterSpinner(context, spinnerDtos);
        spinnerRecy.setAdapter(adapterSpinner);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(context);
        spinnerRecy.setLayoutManager(mLayoutManager);
        spinnerRecy.addOnItemTouchListener(new RecyclerItemClickListener(context, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                String spinnerDto = spinnerDtos.get(position);
                whereYoucanset.setText(spinnerDto);
                dialog1.dismiss();

            }
        }));
        spinnerRecy.setHasFixedSize(true);

        dialog1.show();
    }

}



