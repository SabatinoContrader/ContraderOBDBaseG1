package main.controller;

import main.MainDispatcher;

public class OfficinaController implements Controller{

    @Override
    public void doControl(Request request) {
        MainDispatcher.getInstance().callView("Officina", request);

    }


}
