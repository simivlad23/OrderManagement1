package bll;

import dao.StocDAO;
import model.Stoc;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class StocBLL {

    StocDAO stocDAO;
    public StocBLL(){
        stocDAO=new StocDAO();
    }
    public Stoc findStocById(int id) {

        Stoc cl = stocDAO.findById(id,"id");
        System.out.println(cl.getCantitate());
        if (cl == null) {
            throw new NoSuchElementException("The Stok with id " + id +" was not found!");
        }
        return cl;
    }
    public boolean insert(int idProdus,int cantiate) {
        ArrayList list = new ArrayList();
        ArrayList<String> list2 =new ArrayList<>();
        list2.add("produsId");
        list2.add("cantitateStoc");
        list.add(idProdus);
        list.add(cantiate);
        boolean cl = stocDAO.insert(list2,list);
        if (cl == false) {
            throw new NoSuchElementException("The stok with the cantity " + cantiate +" was not inserted!");
        }
        return cl;
    }
    public boolean update(int id,int cantitate) {
        ArrayList<String> listOfColumnName =new ArrayList();
        ArrayList listOfColumnValue =new ArrayList();


        listOfColumnName.add("cantitateStoc");

        listOfColumnValue.add(cantitate);


        boolean cl = stocDAO.update("idProdus",id,listOfColumnName,listOfColumnValue);
        if (cl == false) {
            throw new NoSuchElementException("The client with id " + id +" was not updated!");
        }
        return cl;
    }
    public  boolean decrement(int idProdus,int cantitate){
        ArrayList<String> listOfColumnName = new ArrayList();
        ArrayList listOfColumnValue = new ArrayList();

        listOfColumnName.add("cantitateStoc");


        listOfColumnValue.add(cantitate);


        boolean cl = stocDAO.update("produsId", idProdus, listOfColumnName, listOfColumnValue);
        if (cl == false) {
            throw new NoSuchElementException("The stoc  with idProdus: " + idProdus + " was not updated!");
        }
        return cl;

    }


    public List<Stoc> selectAll() {
        List<Stoc> cl;
        cl=stocDAO.selectAll();
        if (cl == null) {
            throw new NoSuchElementException("Elements were not found!");
        }
        return cl;
    }




}
