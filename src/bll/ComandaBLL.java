package bll;

import dao.ComandaDAO;
import model.Client;
import model.Comanda;
import model.Produs;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ComandaBLL {
    public ComandaDAO comandaDAO;
    public ClientBLL clientBLL;
    public ProdusBLL produsBLL;

    public ComandaBLL(){
        comandaDAO = new ComandaDAO();
        clientBLL = new ClientBLL();
        produsBLL = new ProdusBLL();
    }
    public Comanda findComandaById(int id) {

        Comanda cl = comandaDAO.findById(id,"idComanda");
        if (cl == null) {
            throw new NoSuchElementException("The client with id " + id +" was not found!");
        }
        return cl;
    }

    public boolean insert(int idProdus,int idClient,int cantitate) {
        ArrayList list = new ArrayList();
        ArrayList<String> list2 =new ArrayList<>();
        list2.add("idProd");
        list2.add("idCli");
        list2.add("cantitate");
        list.add(idProdus);
        list.add(idClient);
        list.add(cantitate);
        Client client= clientBLL.findClientById(idClient);

        Produs produs= produsBLL.findProdusById(idProdus);

        if(client==null)
            throw new NoSuchElementException("The client with id:"+idClient+ " was not found");
        if(produs==null)
            throw new NoSuchElementException("The product with id:"+idProdus+ " was not found");
        boolean cl = comandaDAO.insert(list2,list);
        if (cl == false) {
            throw new NoSuchElementException("The order  was not inserted!");
        }else {
            PrintWriter writer = null;
            try {
                writer = new PrintWriter("factura.txt", "UTF-8");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            writer.println("Id client: "+ idClient);
            writer.println("Id produs: "+ idProdus);
            writer.println("Cantitate : "+ cantitate);
            writer.close();
            boolean bool = produsBLL.decrementStoc(idProdus,cantitate);
            if (bool==false)
                throw new NoSuchElementException("Stoc indisponibil");
        }

        return cl;
    }


    public List<Comanda> selectAll() {
        List<Comanda> cl;
        cl=comandaDAO.selectAll();
        if (cl == null) {
            throw new NoSuchElementException("Elements were not found!");
        }
        return cl;
    }

}
