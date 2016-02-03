package com.softdesign.school.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.softdesign.school.R;
import com.softdesign.school.data.storage.model.User;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.MyViewHolder> {

    private List<User> users;

    public ContactAdapter(List<User> users) {
        this.users = users;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_user, parent, false);
        return new MyViewHolder(convertView);
    }



    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        User user = users.get(position);
        holder.fullName.setText(user.getmFirstName() + " " + user.getmLastName());
        holder.avatar.setImageDrawable(user.getmImage());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /*@Override
    public void setHasStableIds(boolean hasStableIds) {
        super.setHasStableIds(hasStableIds);
    }*/

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        protected TextView fullName;
        protected ImageView avatar;

        public MyViewHolder(View convertView) {
            super(convertView);
            fullName = (TextView) convertView.findViewById(R.id.user_full_name);
            avatar = (ImageView) convertView.findViewById(R.id.user_avatar);
        }
    }
}
