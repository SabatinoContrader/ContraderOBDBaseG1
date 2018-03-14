package main.controller;

import main.MainDispatcher;

public class AutoController implements Controller {


    @Override
    public void doControl(Request request) {

        MainDispatcher.getInstance().callView("Auto", request);

    }
}
