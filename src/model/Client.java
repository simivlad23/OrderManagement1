package model;

public class Client {
    private int idClient;
    private int varsta;
    private String numeClient;
    private String email;





    public Client(int idClient, String numeClient, String email, int varsta) {
        this.idClient = idClient;
        this.numeClient = numeClient;
        this.email = email;
        this.varsta = varsta;

    }
    public Client() {

    }

    public int getIdClient() {
        return idClient;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getNumeClient() {
        return numeClient;
    }

    public void setNumeClient(String numeClient) {
        this.numeClient = numeClient;
    }

    @Override
    public String toString() {
        return "Client{" +
                "idClient=" + idClient +
                ", numeClient='" + numeClient + '\'' +
                ", email='" + email + '\'' +
                ", varsta=" + varsta +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }




}
