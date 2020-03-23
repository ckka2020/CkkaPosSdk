package com.ckka.ckkapossdk;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;

import com.ckka.ckkapossdk.Utility.Validator;
import com.ckka.ckkapossdk.api.APIClient;
import com.ckka.ckkapossdk.api.ApiErrorUtils;
import com.ckka.ckkapossdk.api.api_error.ApiError;
import com.ckka.ckkapossdk.model.BinRespCkka;
import com.google.zxing.BarcodeFormat;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CkkaSdk {
    private static Activity mContext;
    private static CkkaSdk ckkaSdk;
    private String POSid;
    private String getPOSid() {
        return POSid;
    }

    private void setPOSid(String POSid) {
        this.POSid = POSid;
    }

    public static CkkaSdk getInstance(Activity context) {
        if (mContext == null) {
            ckkaSdk = new CkkaSdk(context);
        }
        return ckkaSdk;
    }

    private CkkaSdk(Activity mContext) {
        this.mContext = mContext;
    }

    public void sendDataToCkka(String POSid, double total_amount, String jsonCartData, final OnCkkaActionListener onCkkaActionListener) {
        setPOSid(POSid);
        if (total_amount <= 0d) {
            onCkkaActionListener.onFailure(mContext.getString(R.string.validate_amount));
            return;
        }
        if (Validator.isNullEmpty(POSid)) {
            onCkkaActionListener.onFailure(mContext.getString(R.string.validate_pos));
            return;
        }

        Call<BinRespCkka> call = APIClient.getApiInterface().passDataToCkka
                (getPOSid(),
                        total_amount,
                        jsonCartData);
        call.enqueue(new Callback<BinRespCkka>() {
            @Override
            public void onResponse(Call<BinRespCkka> call, Response<BinRespCkka> response) {
                if (response.isSuccessful()) {
                    BinRespCkka binRespCkka = response.body();
                    if (binRespCkka != null && binRespCkka.getMessage() != null)
                        onCkkaActionListener.onSuccess(binRespCkka.getMessage());
                    else
                        onCkkaActionListener.onSuccess(mContext.getString(R.string.data_sent_to_ckka));
                } else {
                    if (response.errorBody() != null) {
                        ApiError apiError = ApiErrorUtils.parseError(response);
                        if (apiError.getResponseCode() != null &&
                                apiError.getResponseCode().equals
                                        (SERVER_RESPONSE_CODE.DEVICE_NOT_PAIRED)) {
                            showPairingQR();
                        } else {
                            if (!Validator.isNullEmpty(apiError.getMessage()))
                                onCkkaActionListener.onFailure(apiError.getMessage());
                            else
                                onCkkaActionListener.onFailure(ApiErrorUtils.SOMETHING_WENT_WRONG);
                        }
                    } else {
                        onCkkaActionListener.onFailure(ApiErrorUtils.SOMETHING_WENT_WRONG);
                    }
                }
            }

            @Override
            public void onFailure(Call<BinRespCkka> call, Throwable t) {
                onCkkaActionListener.onFailure(ApiErrorUtils.getErrorMsg(t));
            }
        });
    }

    private void showPairingQR() {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        View view = mContext.getLayoutInflater().inflate(R.layout.layout_qr_image, null);
        builder.setView(view);
        generateQrCode(getPOSid(), (ImageView) view.findViewById(R.id.imgQRCode));
        builder.setTitle(mContext.getString(R.string.scan_qr));
        builder.setMessage(mContext.getString(R.string.pair_info));
        builder.setPositiveButton(mContext.getString(R.string.ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }

    private void generateQrCode(String content, ImageView imageViewQrCode) {
        try {
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.encodeBitmap(content, BarcodeFormat.QR_CODE, (int) mContext.getResources().getDimension(R.dimen.dp_qr_size), (int) mContext.getResources().getDimension(R.dimen.dp_qr_size));
            imageViewQrCode.setImageBitmap(bitmap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
