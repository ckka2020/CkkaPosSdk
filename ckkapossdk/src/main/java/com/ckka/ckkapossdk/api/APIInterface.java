package com.ckka.ckkapossdk.api;

import com.ckka.ckkapossdk.model.BinRespCkka;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface APIInterface {

    @FormUrlEncoded
    @POST("/v1/InitiateReceiveReq/{PosDeviceId}")
    Call<BinRespCkka> passDataToCkka(
            @Path("PosDeviceId") String PosDeviceId,
            @Field("amount") double amount,
            @Field("billPayload") String billPayload
    );
}
