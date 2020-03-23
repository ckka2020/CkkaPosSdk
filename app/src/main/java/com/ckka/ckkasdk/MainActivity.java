package com.ckka.ckkasdk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.txtSend).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private String getPOSid()
    {
        return "5e731afe6d5f11169bef15e9";
    }

    private String getJsonCartInfo()
    {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject("{\"toUserId\":\"5e7320766d5f11169bef15eb\",\"amount\":\"100.25\",\"ckkaTransactionType\":5,\n" +
                    "\"currencyType\":\"CKKA\",\"billPayload\":\"{prod1:apple, prod2:peru}\"}");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
        /*if (jsonObject.opt("amount") != null)
            Toast.makeText(mContext, "" + jsonObject.opt("amount"), Toast.LENGTH_LONG).show();
        else
            Log.e("TAG", "NO amount");
        if (jsonObject.opt("billPayload") != null)
            Toast.makeText(mContext, "" + jsonObject.opt("billPayload"), Toast.LENGTH_LONG).show();
        else
            Log.e("TAG", "NO billPayload");*/
    }
}
