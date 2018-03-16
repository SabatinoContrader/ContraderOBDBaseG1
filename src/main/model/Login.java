package main.model;

public class Login {

    private String username;
    private String password;
    private int ruolo;
    private int id;

    public Login (String username, String password, int ruolo, int id){
        this.username= username;
        this.password= password;
        this.ruolo=ruolo;
        this.id=id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRuolo() {
        return ruolo;
    }

    public void setRuolo(int ruolo) {
        this.ruolo = ruolo;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Login login = (Login) o;

        if (ruolo != login.ruolo) return false;
        if (id != login.id) return false;
        if (username != null ? !username.equals(login.username) : login.username != null) return false;
        return password != null ? password.equals(login.password) : login.password == null;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + ruolo;
        result = 31 * result + id;
        return result;
    }

    @Override
    public String toString() {
        return "Login{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", ruolo=" + ruolo +
                ", id=" + id +
                '}';
    }
}
