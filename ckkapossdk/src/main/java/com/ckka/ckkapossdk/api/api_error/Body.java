package com.ckka.ckkapossdk.api.api_error;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Body {

@SerializedName("response")
@Expose
private Object response;
@SerializedName("err")
@Expose
private Err err;

public Object getResponse() {
return response;
}

public void setResponse(Object response) {
this.response = response;
}

public Err getErr() {
return err;
}

public void setErr(Err err) {
this.err = err;
}

}
