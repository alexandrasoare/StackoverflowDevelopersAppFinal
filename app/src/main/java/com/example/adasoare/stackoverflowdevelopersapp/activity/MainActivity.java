package com.example.adasoare.stackoverflowdevelopersapp.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.adasoare.stackoverflowdevelopersapp.R;
import com.example.adasoare.stackoverflowdevelopersapp.model.User;
import com.example.adasoare.stackoverflowdevelopersapp.model.UserAdapter;
import com.example.adasoare.stackoverflowdevelopersapp.model.UserList;
import com.example.adasoare.stackoverflowdevelopersapp.rest.APIClient;
import com.example.adasoare.stackoverflowdevelopersapp.rest.UserAPIService;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private static Context myContext;

    UserAPIService apiService;
    private static UserList userList;

    private static LoadingCache<Integer, User> userCache;
    static {
        userCache = CacheBuilder.newBuilder()
                .maximumSize(10)
                .expireAfterWrite(30, TimeUnit.MINUTES)
                .build(
                        new CacheLoader<Integer, User>() {
                            @Override
                            public User load(Integer id) throws Exception {
                                return getUserById(id);
                            }
                        }
                );
    }

    public UserList getUserList() {
        return userList;
    }

    public static LoadingCache<Integer, User> getCache() {
        return userCache;
    }

    public static Context getContext() {
        return myContext;
    }

    public static User getUserById(Integer id) {
        return userList.getUserById(id);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        myContext = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiService = APIClient.getStackOverFLowClient().create(UserAPIService.class);
        getUsers();
    }

    private void getUsers() {
        Call<UserList> call = apiService.getUsers("reputation");
        call.enqueue(new Callback<UserList>() {
            @Override
            public void onResponse(Call<UserList> call, Response<UserList> response) {
                userList = new UserList();
                userList.setUsers(response.body().getUsers().subList(0, 10));
//                Log.d(TAG, "Total number of users : " + userList.size());
//
//                for (int i = 0; i < userList.size(); i++)
//                    Log.d(TAG,"User[" + i + "] ---> " + userList.get(i).getDisplayName());
//
                UserAdapter userAdapter = new UserAdapter(MainActivity.this, userList);

                ListView listView = (ListView) findViewById(R.id.users_list);
                listView.setAdapter(userAdapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                        loadUserInfo(view.getContext(), userList.get(position).getUserID());
                    }
                });
            }

            @Override
            public void onFailure(Call<UserList> call, Throwable t) {
                Log.e(TAG, "Error : " + t.getLocalizedMessage());
            }
        });
    }

    private void loadUserInfo(Context context, int userId) {
        Intent intent = new Intent(context, UserInfoActivity.class);
        intent.putExtra("user_id", userId);

        startActivity(intent);
    }

}
