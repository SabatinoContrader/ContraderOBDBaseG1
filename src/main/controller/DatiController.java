package main.controller;

import main.MainDispatcher;

public class DatiController implements Controller {


    @Override
    public void doControl(Request request) {

        MainDispatcher.getInstance().callView("Dati", request);

    }
}
