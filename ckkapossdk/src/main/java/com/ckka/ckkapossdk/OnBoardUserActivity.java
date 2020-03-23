package com.ckka.ckkapossdk;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;


public class OnBoardUserActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CkkaSdk sdk = CkkaSdk.getInstance(this, new OnCkkaActionListener() {
            @Override
            public void onSuccess(String message) {

            }

            @Override
            public void onFailure(String message) {

            }
        });
        sdk.sendDataToCkka("",0d,"");

    }
}
