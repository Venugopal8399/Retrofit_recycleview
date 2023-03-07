package com.example.retrpofit;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UsersViewHolder>{
    Context context;
    List<POJO> userListResponseData;
    public UsersAdapter(List<POJO> userListResponseData, Context context) {
        this.context = context;
        this.userListResponseData = userListResponseData;
    }

    @NonNull
    @Override
    public UsersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new UsersViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull UsersViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.id.setText("Id:"+userListResponseData.get(position).getId());
        holder.name.setText("Name:"+userListResponseData.get(position).getName());
        holder.user_name.setText("User Name:"+userListResponseData.get(position).getUsername());
        holder.emailid.setText("Email id:"+userListResponseData.get(position).getEmail());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, userListResponseData.get(position).getUsername(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return userListResponseData.size();
    }

    public class UsersViewHolder extends RecyclerView.ViewHolder {
        TextView id, name, user_name, emailid;
        public UsersViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.user_id);
            name = itemView.findViewById(R.id.name);
            user_name = itemView.findViewById(R.id.user_name);
            emailid = itemView.findViewById(R.id.email_id);
        }
    }
}
