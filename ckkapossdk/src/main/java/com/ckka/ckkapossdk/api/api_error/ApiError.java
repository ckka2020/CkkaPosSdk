package com.ckka.ckkapossdk.api.api_error;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiError {

@SerializedName("status")
@Expose
private String status;
@SerializedName("responseCode")
@Expose
private Object responseCode;
@SerializedName("message")
@Expose
private String message;
@SerializedName("body")
@Expose
private Object body;

public String getStatus() {
return status;
}

public void setStatus(String status) {
this.status = status;
}

public Object getResponseCode() {
return responseCode;
}

public void setResponseCode(Object responseCode) {
this.responseCode = responseCode;
}

public String getMessage() {
return message;
}

public void setMessage(String message) {
this.message = message;
}

public Object getBody() {
return body;
}

public void setBody(Object body) {
this.body = body;
}

}
