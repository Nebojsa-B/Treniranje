package com.example.vezba1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        drawerLayout = findViewById(R.id.drawer_layout);
    }

    public void ClickMenu(View view){
        //Open drawer
        MainActivity.openDrawer(drawerLayout);
    }

    public void ClickMore(View view){
        openDialog();
    }

    public void openDialog(){
        AboutUsDialog aboutUs = new AboutUsDialog();
        aboutUs.show(getSupportFragmentManager(), "AboutUs Dialog");
    }

    public void ClickLogo(View view){
        //Close drawer
        MainActivity.closeDrawer(drawerLayout);
    }

    public void ClickHome(View view){
        //Redirect activity to home
        MainActivity.redirectActivity(this, LoadingActivity.class);
    }

    public void ClickSuplement(View view){
        MainActivity.redirectActivity(this, SuplementActivity.class);
    }

    public void ClickMap(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:44.830584, 20.455140"));
        Intent chooser = Intent.createChooser(intent, "Launch Map");
        startActivity(chooser);
    }

    public void ClickLogout(View view){
        //Close app
        MainActivity.logout(this);
    }

    @Override
    protected void onPause(){
        super.onPause();
        //close drawer
        MainActivity.closeDrawer(drawerLayout);
    }

    public void ClickAbsBegginer(View view){
        MainActivity.redirectActivity(this, AbsBegginerActivity.class);
    }

}