package com.softdesign.school.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.softdesign.school.R;

public class UserViewHolder extends RecyclerView.ViewHolder {

    protected TextView fullName;
    protected ImageView avatar;

    public UserViewHolder(View convertView) {
        super(convertView);
        fullName=(TextView) convertView.findViewById(R.id.user_full_name);
        avatar=(ImageView) convertView.findViewById(R.id.user_avatar);
    }
}
