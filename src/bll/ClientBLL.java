package bll;

import dao.ClientDAO;
import model.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ClientBLL {
    public ClientDAO client;

    public ClientBLL(){
        client=new ClientDAO();
    }
    public Client findClientById(int id) {

        Client cl = client.findById(id,"idClient");
        if (cl == null) {
            throw new NoSuchElementException("The client with id " + id +" was not found!");
        }
        return cl;
    }
    public boolean update(int id,String nume,String email,int varsta) {
        ArrayList<String> listOfColumnName =new ArrayList();
        ArrayList listOfColumnValue =new ArrayList();

        listOfColumnName.add("numeClient");
        listOfColumnName.add("email");
        listOfColumnName.add("varsta");

        listOfColumnValue.add(nume);
        listOfColumnValue.add(email);
        listOfColumnValue.add(varsta);


        boolean cl = client.update("idClient",id,listOfColumnName,listOfColumnValue);
        if (cl == false) {
            throw new NoSuchElementException("The client with id " + id +" was not updated!");
        }
        return cl;
    }

    public boolean insert(String numeClient,String email,int varsta) {
        ArrayList list = new ArrayList();
        ArrayList<String> list2 =new ArrayList<>();
        list2.add("numeClient");
        list2.add("email");
        list2.add("varsta");
        list.add(numeClient);
        list.add(email);
        list.add(varsta);
        boolean cl = client.insert(list2,list);
        if (cl == false) {
            throw new NoSuchElementException("The client with name  " + numeClient +" was not inserted!");
        }
        return cl;
    }



    public boolean delete(String name) {
        boolean cl = client.delete("numeClient",name);
        if (cl == false) {
            throw new NoSuchElementException("The client  " + name +" was not deleted!");
        }
        return cl;
    }

    public List<Client> selectAll() {
        List<Client> cl;
        cl=client.selectAll();
        if (cl == null) {
            throw new NoSuchElementException("Elements were not found!");
        }
        return cl;
    }

}
