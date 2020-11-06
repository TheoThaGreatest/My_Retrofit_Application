package utd.com.myretrofitapplication;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubService {
    //https://api.github.com/users/octocat

    @GET("users/{user}")
    Call<User> getUserInfo(@Path("user") String name);
}
