package com.HelloToby.Consumer.pages;

import com.HelloToby.Consumer.TestRunner;

public class LoginScreen {
    public static LoginScreen getScreen() {
        LoginScreen screen = null;
        if (TestRunner.sharedInstance().isRunningOniOS()) {
            screen = new LoginScreen();
        }else {
            screen = new LoginScreen();
        }
        return screen;
    }

}



