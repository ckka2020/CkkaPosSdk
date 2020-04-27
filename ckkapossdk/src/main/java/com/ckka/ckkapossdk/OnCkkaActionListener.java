package com.ckka.ckkapossdk;

public interface OnCkkaActionListener {
    public void onSuccess(String ack_id, String message);
    public void onFailure(String message);
    public void onTryingToPair();
}
