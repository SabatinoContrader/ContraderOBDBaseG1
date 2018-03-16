package main.view;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Login;
import main.model.Officina;
import main.service.LoginService;
import main.service.OfficinaService;
import java.util.Scanner;


public class OfficinaView implements View {

    private OfficinaService officinaService;
    private String mode;
    private LoginService loginService;
    private String role;

    public OfficinaView(){
        this.officinaService = new OfficinaService();
        this.loginService = new LoginService();
    }

    @Override
    public void showResults(Request request){
        this.role=(String)request.get("role");
    };

    public void showOptions() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Inserisci i dati della nuova officina:");
            System.out.println("Nome officina:");
            String Nome_Officina = getInput();
            System.out.println("Indirizzo:");
            String Indirizzo = getInput();
            System.out.println("Città:");
            String Città = getInput();
            int id=officinaService.insertOfficina(new Officina(Nome_Officina, Indirizzo, Città));
            String access = "O_00"+id;
            loginService.InsertLogin(new Login(access, access, 2, id));

        }
        @Override
        public String getInput() {
            Scanner scanner = new Scanner(System.in);
            return scanner.nextLine();
        }

        @Override
        public void submit() {
            Request request=new Request();
            request.put("role",role);
            MainDispatcher.getInstance().callAction("Home", "doControl", request);
        }


}
