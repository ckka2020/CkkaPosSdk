package com.ckka.ckkapossdk.Utility;

import android.text.TextUtils;
import android.util.Patterns;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.regex.Pattern;


/**
 * Created by Sagar on 1/6/17.
 */

public class Validator {

    public static boolean isNullEmpty(String string) {
        if (string!=null && string.length()>0)
            return false;
        else
            return true;
    }

    public static boolean isEmpty(TextView textView) {
        if (textView.getText().toString().trim().length() > 0)
            return false;
        else
            return true;
    }

    public static boolean isEmptyStr(String string) {
        if (string.length() > 0)
            return false;
        else
            return true;
    }

    public static String getTextStr(TextView textView) {
        return textView.getText().toString().trim();
    }

    public static boolean checkImageUrlValidation(String url) {
        if (!isNullEmpty(url) &&
                url.contains(".jpg") || url.contains(".jpeg") ||
                url.contains(".png") || url.contains(".gif") ||
                url.contains(".bmp") || url.contains(".webp"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static boolean checkEmail(@Nullable String strEmail) {
        try {
            if (strEmail != null) {
                String strPattern = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
                return Pattern.compile(strPattern).matcher(strEmail).matches();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean isInValidEmail(CharSequence target) {
        return (TextUtils.isEmpty(target) || !Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

    public static boolean isValidPhone(CharSequence phone) {
        boolean check = false;
        if (!Pattern.matches("[a-zA-Z]+", phone)) {
            check = phone.length() >= 10 && phone.length() <= 10;
        }
        return check;
    }

    public static boolean isValidPassword(CharSequence phone) {
        boolean check = false;
        if (!Pattern.matches("[a-zA-Z]+", phone)) {
            check = phone.length() >= 4 && phone.length() <= 4;
        }
        return check;
    }
}
