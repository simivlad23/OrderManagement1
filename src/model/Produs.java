package model;

public class Produs {
    private int idProdus;
    private String denumire;
    private String marca;
    private int pret;

    public Produs(int idProdus, String denumire, String marca, int pret) {
        this.idProdus = idProdus;
        this.denumire = denumire;
        this.marca = marca;
        this.pret = pret;
    }

    public Produs() {
    }

    public int getIdProdus() {
        return idProdus;
    }

    public void setIdProdus(int idProdus) {
        this.idProdus = idProdus;
    }

    public String getDenumire() {
        return denumire;
    }

    @Override
    public String toString() {
        return "Produs{" +
                "idProdus=" + idProdus +
                ", denumire='" + denumire + '\'' +
                ", marca='" + marca + '\'' +
                ", pret=" + pret +
                '}';
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }


    public int getPret() {
        return pret;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }


}
