package com.ckka.ckkapossdk.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BinRespCkka {

@SerializedName("status")
@Expose
private String status;
@SerializedName("responseCode")
@Expose
private String responseCode;
@SerializedName("message")
@Expose
private String message;
@SerializedName("body")
@Expose
private String body;

public String getStatus() {
return status;
}

public void setStatus(String status) {
this.status = status;
}

public String getResponseCode() {
return responseCode;
}

public void setResponseCode(String responseCode) {
this.responseCode = responseCode;
}

public String getMessage() {
return message;
}

public void setMessage(String message) {
this.message = message;
}

public String getBody() {
return body;
}

public void setBody(String body) {
this.body = body;
}

}