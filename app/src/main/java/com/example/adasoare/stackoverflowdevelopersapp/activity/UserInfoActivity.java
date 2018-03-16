package com.example.adasoare.stackoverflowdevelopersapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adasoare.stackoverflowdevelopersapp.R;
import com.example.adasoare.stackoverflowdevelopersapp.model.User;
import com.google.common.cache.LoadingCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.concurrent.ExecutionException;

public class UserInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        int passedUserId = getIntent().getIntExtra("user_id", -1);
        LoadingCache<Integer, User> loadingCache = MainActivity.getCache();
        User user = null;
        try {
            if (passedUserId != -1) {
                user = loadingCache.get(passedUserId);

                ImageView imageView = (ImageView) findViewById(R.id.userImage);
                ImageLoader imgLoader;
                imgLoader = ImageLoader.getInstance();
                imgLoader.init(ImageLoaderConfiguration.createDefault(this));
                imgLoader.displayImage(user.getProfileImage(), imageView);

                TextView userName = (TextView) findViewById(R.id.userName);
                userName.setText(user.getDisplayName());

                TextView userLocation = (TextView) findViewById(R.id.userLocation);
                userLocation.setText(user.getLocation());

                TextView bronzeBadge = (TextView) findViewById(R.id.bronze);
                bronzeBadge.setText("Bronze: " + String.valueOf(user.getBadgeCounts().getBronze()));

                TextView silverBadge = (TextView) findViewById(R.id.silver);
                silverBadge.setText("Silver: " + String.valueOf(user.getBadgeCounts().getSilver()));

                TextView goldBadge = (TextView) findViewById(R.id.gold);
                goldBadge.setText("Gold: " + String.valueOf(user.getBadgeCounts().getGold()));
            } else {
                TextView userName = (TextView) findViewById(R.id.userName);
                userName.setText("Unknown User");
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}
