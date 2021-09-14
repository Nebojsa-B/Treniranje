package com.example.vezba1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatDialogFragment;

public class AboutUsDialog extends AppCompatDialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("About Us")
                .setMessage("Ova aplikacija ima za cilj da prikaze znanje steceno na predmetu CS330 - Razvoj mobilnih aplikacija. \n Student: Nebojsa Bosijok \n Profesor: Vladimir Milicevic")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        return builder.create();
    }
}
