package com.sanjaya.dialogspinner;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterSpinner extends RecyclerView.Adapter<AdapterSpinner.AdapterSpinnerViewHolder> {

    Context context;
    ArrayList<String> spinnerDtos;

    public AdapterSpinner(Context context, ArrayList<String> spinnerDtos) {
        this.context = context;
        this.spinnerDtos = spinnerDtos;

    }

    @NonNull
    @Override
    public AdapterSpinnerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(context).inflate(R.layout.custom_spin_view,viewGroup,false);
        return new AdapterSpinnerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterSpinnerViewHolder holder, int i) {

        String spinData=spinnerDtos.get(i);
        holder.spinView.setText(spinData);
        //final String text=spinDto.getName();

        /*final String id=spinDto.getId();

        //final CreatePostActivity con=new CreatePostActivity();

        holder.spinView.setText(text);
        holder.idView.setText(id);

        holder.spinView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                *//*if(intent.equals("Post")) {
                    CreatePostActivity.textSpinner.setText(text);
                    CreatePostActivity.txtId.setText(id);
                    dialog1.dismiss();
                }else*//* if(intent.equals("Report")){
                    ReportActivity.textSpinner.setText(text);
                    ReportActivity.txtId.setText(id);
                    dialog1.dismiss();
                }else if(intent.equals("Business")){
                    BusinessesFragment.textSpinner.setText(text);
                    BusinessesFragment.txtId.setText(id);
                    dialog1.dismiss();
                }*//*else if(intent.equals("Edprofile")){
                    EditprofileActivity.textSpinner.setText(text);
                    EditprofileActivity.txtId.setText(id);
                    dialog1.dismiss();

                }*//*



            }
        });*/

        //context.



    }

    @Override
    public int getItemCount() {
        return spinnerDtos.size();
    }

    class AdapterSpinnerViewHolder extends RecyclerView.ViewHolder{

        TextView spinView,idView;
        public AdapterSpinnerViewHolder(@NonNull View itemView) {
            super(itemView);

            spinView=itemView.findViewById(R.id.spinView);
            idView=itemView.findViewById(R.id.idView);

        }
    }
}
