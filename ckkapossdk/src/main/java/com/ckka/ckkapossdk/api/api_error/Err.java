package com.ckka.ckkapossdk.api.api_error;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Err {

@SerializedName("message")
@Expose
private String message;

public String getMessage() {
return message;
}

public void setMessage(String message) {
this.message = message;
}

}