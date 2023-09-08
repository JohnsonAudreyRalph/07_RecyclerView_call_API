package com.example.a07_recyclerview_call_api.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a07_recyclerview_call_api.R;
import com.example.a07_recyclerview_call_api.model.User;

import java.util.List;

public class User_Adapter extends RecyclerView.Adapter<User_Adapter.UserViewHolder> {


    private final List<User> mListUser;

    public User_Adapter(List<User> mListUser) {
        this.mListUser = mListUser;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = mListUser.get(position);
        if (user == null) return;
        holder.TextView_id.setText(String.valueOf(user.getId()));
        holder.TextView_title.setText(user.getTitle());
    }

    @Override
    public int getItemCount() {
        if (mListUser != null){
            return mListUser.size();
        }
        return 0;
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {

        TextView TextView_id, TextView_title;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            TextView_id = itemView.findViewById(R.id.TextView_id);
            TextView_title = itemView.findViewById(R.id.TextView_title);
        }
    }
}
