package com.example.brian.retrofit;

import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;
import android.widget.Toast;

import com.example.brian.retrofit.Interface.UsuarioService;
import com.example.brian.retrofit.POJO.Usuario;

import java.util.List;

import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView result;
    public static  final  String BASE_URL="http://jairbarzola.esy.es";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = (TextView) findViewById(R.id.resultado);
        result.setMovementMethod(new ScrollingMovementMethod());
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(BASE_URL)
                .build();

        /*retrofit 2.1
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .build();*/
        UsuarioService service =restAdapter.create(UsuarioService.class);
        service.getUser(new retrofit.Callback<List<Usuario>>() {
            @Override
            public void success(List<Usuario> list, retrofit.client.Response response) {
                result.setText(list.toString());
                Toast.makeText(getApplicationContext(),"success",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void failure(RetrofitError error) {
                result.setText(error.getLocalizedMessage());
            }
        });

    }


}
