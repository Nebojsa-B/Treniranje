package com.example.vezba1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {


    EditText username, password;
    Button registration, login;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        registration = findViewById(R.id.registration);
        login = findViewById(R.id.login);
        DB = new DBHelper(this);

        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("") || pass.equals(""))
                    Toast.makeText(RegistrationActivity.this, "Popunite sva polja.", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuser = DB.checkUsername(user);
                    if(checkuser==false){
                        Boolean insert = DB.insertData(user, pass);
                        if(insert == true){
                            Toast.makeText(RegistrationActivity.this, "Uspesna registracija!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                            startActivity(intent);

                        }else{
                            Toast.makeText(RegistrationActivity.this, "Neuspesna registracija.", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(RegistrationActivity.this, "Korisnik vec postoji, pokusajte da se ulogujete.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}