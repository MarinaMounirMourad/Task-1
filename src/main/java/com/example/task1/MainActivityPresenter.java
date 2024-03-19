package com.example.task1;

public class MainActivityPresenter implements MainActivityContract.Presenter {

    MainActivityContract.view view;

    public MainActivityPresenter(MainActivityContract.view view) {
        this.view = view;
    }

    @Override
    public void doLogin(String email, String password) {

        if (email.equals("test@live.com") && password.equals("Pass@123")){
            view.onSuccess("Successful");
        }else{
            view.onError("Wrong email or password");
        }

    }
}
