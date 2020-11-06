package utd.com.myretrofitapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final TextView text = findViewById(R.id.text_name);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/").addConverterFactory(GsonConverterFactory.create())
                .build();

        GitHubService service  = retrofit.create(GitHubService.class);

        service.getUserInfo("octocat").enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user;
                if(response.isSuccessful())
                {
                    user = response.body();
                    text.setText(user.getName());
                }
                else
                {
                    Log.e("TEO", "code = " + response.code());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }


}