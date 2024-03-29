package com.example.task1;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

//مارينا منير مراد G2

public class MainActivity extends AppCompatActivity implements MainActivityContract.view {

    MainActivityContract.Presenter presenter;
    EditText email,password;
    Button btn_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        presenter = new MainActivityPresenter(this);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        btn_login = findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email1 =email.getText().toString();
                String password1 = password.getText().toString();

                if (TextUtils.isEmpty(email1) || TextUtils.isEmpty(password1)){
                    onError("Field(s) Required");
                }else{
                    presenter.doLogin(email1,password1);
                }

            }
        });
    }

    @Override
    public void onSuccess(String message) {
        Toast.makeText( this,message,Toast.LENGTH_LONG).show();

    }

    @Override
    public void onError(String message) {
        Toast.makeText( this,message,Toast.LENGTH_LONG).show();
    }
}