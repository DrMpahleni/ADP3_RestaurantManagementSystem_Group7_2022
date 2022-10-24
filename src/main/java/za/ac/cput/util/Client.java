/*
    Position Class
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 26 October 2022
 */
package za.ac.cput.util;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import za.ac.cput.domain.menu.MenuItem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;

public class Client {

    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    public static OkHttpClient client = new OkHttpClient();

    private String run(String URL) throws IOException {
        Request request = new Request.Builder()
                .url(URL).header("Authorization", Base64.getEncoder().encodeToString("Basic user:123".getBytes()))
                .build();
        try(Response response = client.newCall(request).execute()){
            return response.body().string();
        }
    }

    // Getting All Menu Items from Database
    public ArrayList<MenuItem> getAllMenuItems(){
        try{
            final String URl = "http://localhost:8080/restaurant/MenuItem/getAll";
            String responseBody = run(URl);
            ArrayList<MenuItem> menuItems = new ArrayList<>();
            Gson g = new Gson();
            JsonArray issues = (JsonArray) JsonParser.parseString(responseBody);
            for(int i = 0; i < issues.size(); i++)
                menuItems.add(g.fromJson(issues.get(i), MenuItem.class));
            return menuItems;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
