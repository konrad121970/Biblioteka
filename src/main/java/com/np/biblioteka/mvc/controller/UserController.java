package com.np.biblioteka.mvc.controller;

public class UserController extends Controller {

    public void Index() {
        if(true) {
            Login();
            return;
        }

        view();
    }

    public void Login() {
        view("Login");
    }
}
