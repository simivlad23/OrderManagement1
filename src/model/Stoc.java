package model;

public class Stoc {
    private int id;
    private int produsId;
    private int cantitateStoc;


    public Stoc(int id, int idProdus, int cantitate) {

        this.id = id;
        this.produsId = idProdus;
        this.cantitateStoc = cantitate;
    }


    public Stoc() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Stoc{" +
                "id=" + id +
                ", idProdus=" + produsId +
                ", cantitate=" + cantitateStoc +
                '}';
    }

    public int getIdProdus() {
        return produsId;
    }

    public void setIdProdus(int idProdus) {
        this.produsId = idProdus;
    }

    public int getCantitate() {
        return cantitateStoc;
    }


    public void setCantitate(int cantitate) {
        this.cantitateStoc = cantitate;
    }


}
