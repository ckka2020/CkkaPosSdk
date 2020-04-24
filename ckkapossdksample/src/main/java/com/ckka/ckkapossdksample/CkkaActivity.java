package com.ckka.ckkapossdksample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ckka.ckkapossdk.CkkaSdk;
import com.ckka.ckkapossdk.OnCkkaActionListener;

public class CkkaActivity extends AppCompatActivity {

    CkkaSdk ckkaSdk;
    double totalAmount;
    Activity mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ckka);
        mContext = this;
        ckkaSdk = new CkkaSdk(this);
        findViewById(R.id.txtSend).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                totalAmount = 100.50;
                ckkaSdk.sendDataToCkka(
                        /*<YOUR POS-ID HERE>*/ getPOSid(),
                        /*<YOUR TOTAL AMOUNT HERE>*/ totalAmount,
                        /*<YOUR CART DETAILS HERE>*/ getJsonCartInfo(),
                        new OnCkkaActionListener() {
                            @Override
                            public void onSuccess(String ack_id, String message) {
                                Toast.makeText(mContext, "AckId: "+ack_id+ "\nMsg: "+ message, Toast.LENGTH_LONG).show();
                            }

                            @Override
                            public void onFailure(String message) {
                                Toast.makeText(mContext, message, Toast.LENGTH_LONG).show();
                            }
                        });
            }
        });
    }

    private String getPOSid()
    {
        /*eg. */
        return "73ebfd21-91e4-484a-be8a-dfe5b479592f";
//        return "<YOUR POS-ID HERE>";
    }

    /*  Your cart details or whatever info you want to share
        should be in Json format string
     */
    private String getJsonCartInfo()
    {
        String jsonString = "{\"bill_id\":\"5e731ace6d5f4958bef15e9\",\"products\":[{\"product_code\":\"01\",\"description\":\"item-1\",\"qty\":5,\"unitRate\":1,\"amount\":5},{\"product_code\":\"02\",\"description\":\"item-2\",\"qty\":5,\"unitRate\":1,\"amount\":5}],\"gross_total\":10,\"sales_tax\":0,\"net_total\":10}";
        return jsonString;
    }
}
