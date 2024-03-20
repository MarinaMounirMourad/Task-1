package com.example.task1;

public interface MainActivityContract {

    interface view{
        void onSuccess(String message);
        void onError(String message);
    }

    interface Presenter{
        void doLogin(String email, String password);
    }
}
