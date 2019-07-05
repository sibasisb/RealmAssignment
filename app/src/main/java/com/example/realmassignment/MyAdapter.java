package com.example.realmassignment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import io.realm.RealmResults;

class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    private RealmResults<Student> studentRecords;
    private Context mContext;
    private int count;

    public MyAdapter(RealmResults<Student> students, Context context) {
        studentRecords=students;
        mContext=context;
        count=0;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int viewType){
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item,parent,false);
        return new MyViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Student student=studentRecords.get(position);

        assert student!=null;
        holder.fname.setText(student.getName());
        holder.fdept.setText(student.getDept());
        holder.fgender.setText(student.getGender());
        holder.fphone.setText(student.getPhone());
        holder.froll.setText("Roll No.:"+ student.getRoll());

        switch(student.getDept()){
            case "CSE":holder.lm.setBackgroundColor(Color.parseColor("#4CAF50"));
                break;
            case "cse":holder.lm.setBackgroundColor(Color.parseColor("#4CAF50"));
                break;
            case "Computer Science Engineering":holder.lm.setBackgroundColor(Color.parseColor("#4CAF50"));
                break;
            case "IT":holder.lm.setBackgroundColor(Color.parseColor("#3F51B5"));
                break;
            case "it":holder.lm.setBackgroundColor(Color.parseColor("#3F51B5"));
                break;
            case "Information Technology":holder.lm.setBackgroundColor(Color.parseColor("#3F51B5"));
                break;
            case "EE":holder.lm.setBackgroundColor(Color.parseColor("#f44336"));
                break;
            case "ee":holder.lm.setBackgroundColor(Color.parseColor("#f44336"));
                break;
            case "Electrical Engineering":holder.lm.setBackgroundColor(Color.parseColor("#f44336"));
                break;
            case "ECE":holder.lm.setBackgroundColor(Color.parseColor("#FF9800"));
                break;
            case "ece":holder.lm.setBackgroundColor(Color.parseColor("#FF9800"));
                break;
            case "Electronics Engineering":holder.lm.setBackgroundColor(Color.parseColor("#FF9800"));
                break;
        }
    }

    @Override
    public int getItemCount(){
        return studentRecords.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private LinearLayout lm;
        private TextView fname,fphone,froll,fdept,fgender;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            count++;
            lm=itemView.findViewById(R.id.rootView);
            fname=itemView.findViewById(R.id.fname);
            fphone=itemView.findViewById(R.id.fphone);
            froll=itemView.findViewById(R.id.froll);
            fgender=itemView.findViewById(R.id.fgender);
            fdept=itemView.findViewById(R.id.fdepart);

        }
    }
}
