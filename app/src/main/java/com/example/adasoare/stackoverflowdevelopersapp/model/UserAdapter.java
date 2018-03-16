package com.example.adasoare.stackoverflowdevelopersapp.model;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.adasoare.stackoverflowdevelopersapp.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.List;

public class UserAdapter extends ArrayAdapter<User> {

    public UserAdapter(Context context, UserList objects) {
        super(context, 0, objects.getUsers());
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_user, parent, false);
        }

        User currentUser = getItem(position);

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.userImage);
        ImageLoader imgLoader;
        imgLoader = ImageLoader.getInstance();
        imgLoader.init(ImageLoaderConfiguration.createDefault(getContext()));
        imgLoader.displayImage(currentUser.getProfileImage(), imageView);

        TextView textView = (TextView) listItemView.findViewById(R.id.userName);
        textView.setText(currentUser.getDisplayName());

        return listItemView;
    }
}
