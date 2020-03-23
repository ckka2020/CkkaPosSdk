package com.ckka.ckkapossdk.api;

import android.util.Log;

import com.ckka.ckkapossdk.api.api_error.ApiError;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.net.SocketException;
import java.net.UnknownHostException;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;

public class ApiErrorUtils {

    static String TAG = ApiErrorUtils.class.getSimpleName();
    public static final String ERROR_NETWORK = "The Internet connection appears to be offline.";
    public static final String CONNECTION_TIMEOUT = "Connection timeout";
    public static final String INTERNAL_SERVER_ERROR = "Internal Server Error";
    public static final String SOMETHING_WENT_WRONG = "Something went wrong.";


    public static String getErrorMsg(Throwable t) {
        if (t instanceof UnknownHostException) {
            Log.e(TAG, ERROR_NETWORK);
            return ERROR_NETWORK;
        } else if (t instanceof SocketException) {
            Log.e(TAG, CONNECTION_TIMEOUT);
            return ERROR_NETWORK;
        } else if (t instanceof IOException) {
            Log.e(TAG, INTERNAL_SERVER_ERROR);
            return INTERNAL_SERVER_ERROR;
        } else {
            Log.e(TAG, t.toString());
            return SOMETHING_WENT_WRONG;
        }
    }

    public static ApiError parseError(Response<?> response) {
        Converter<ResponseBody, ApiError> converter =
                APIClient.getClient()
                        .responseBodyConverter(ApiError.class, new Annotation[0]);

        ApiError error;

        try {
            error = converter.convert(response.errorBody());
        } catch (IOException e) {
            e.printStackTrace();
            return new ApiError();
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiError();
        }

        return error;
    }
}
