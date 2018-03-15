package main.controller;
import main.MainDispatcher;

public class DriverController implements Controller{


    @Override
    public void doControl(Request request) {
        int choice = (int) request.get("choice");
        switch (choice) {
            case 1:
                request.put("mode", "insert");
                break;
        }
        MainDispatcher.getInstance().callView("Driver", request);

    }
}
