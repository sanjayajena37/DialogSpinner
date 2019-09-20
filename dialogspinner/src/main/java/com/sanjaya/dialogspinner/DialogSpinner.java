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
//import com.sanjaya.R.l;
import java.util.ArrayList;

public class DialogSpinner {

    static public ArrayList<String> spinnerDtos; //=new ArrayList<>();
    static public AdapterSpinner adapterSpinner;

    static void show(Context context, String header, ArrayList<String> arrayList, final TextView whereYoucanset) {
        final Dialog dialog1 = new Dialog((Activity)context);
        dialog1.setCanceledOnTouchOutside(false);
        spinnerDtos=arrayList;
        dialog1.setContentView(R.layout.spinner_view);
        spinnerDtos.clear();
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
//                                mLayoutManager.setReverseLayout(true);
//                                mLayoutManager.setStackFromEnd(true);
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

//                fetchSpinnerList();
           /* final String URLTEXT = "http://neighbrsnook.com/admin/api/master?flag=4";

            JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, URLTEXT, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {

                    try {
                        //JSONArray jsonArray = response.getJSONArray("nbdata");
                        String status = response.getString("status");
                        String message = response.getString("message");


                        if (status.equals("success")) {
                            JSONArray jsonArray = response.getJSONArray("nbdata");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject1 = jsonArray.getJSONObject(i);

                                String id = jsonObject1.getString("id");
                                String post_title = jsonObject1.getString("post_title");

                                SpinnerDto dto = new SpinnerDto(post_title, id);
                                spinnerDtos.add(dto);
                            }

                            adapterSpinner = new AdapterSpinner(CreatePostActivity.this, spinnerDtos, dialog1, "Post");
                            spinnerRecy.setAdapter(adapterSpinner);
                            LinearLayoutManager mLayoutManager = new LinearLayoutManager(CreatePostActivity.this);
//                                mLayoutManager.setReverseLayout(true);
//                                mLayoutManager.setStackFromEnd(true);
                            spinnerRecy.setLayoutManager(mLayoutManager);
                            spinnerRecy.addOnItemTouchListener(new RecyclerItemClickListener(CreatePostActivity.this, new RecyclerItemClickListener.OnItemClickListener() {
                                @Override
                                public void onItemClick(View view, int position) {
                                    SpinnerDto spinnerDto = spinnerDtos.get(position);
                                    String txttId = spinnerDto.getId();
                                    String txtSpinner = spinnerDto.getName();

                                    txtId.setText(txttId);
                                    textSpinner.setText(txtSpinner);
                                    dialog1.dismiss();

                                }
                            }));
                            spinnerRecy.setHasFixedSize(true);


                            //
                        } else {
                            //  Toast.makeText(CreatePostActivity.this, message, Toast.LENGTH_SHORT).show();
                            //.dismiss();
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                    //Toast.makeText(getActivity(), "Error is :" + error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
            requestQueue.add(request);*/
        dialog1.show();
    }

}



