package bll;

import connection.ConnectionFactory;
import dao.ProdusDAO;
import model.Produs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ProdusBLL {
    public ProdusDAO produsDAO;
    public StocBLL stocBLL;

    public ProdusBLL() {
        produsDAO = new ProdusDAO();
        stocBLL = new StocBLL();
    }


    public int getStoc(int idProdus)
    {
        int stoc =0;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = "SELECT * FROM Stoc WHERE produsId= ?;";
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, idProdus);

            resultSet = statement.executeQuery();
            while(resultSet.next())
            {
                int id = resultSet.getInt(1);
                int idProd = resultSet.getInt(2);
                stoc=resultSet.getInt(3);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return stoc;
    }
    public Produs findProdusById(int id) {

        Produs cl = produsDAO.findById(id, "idProdus");
        if (cl == null) {
            throw new NoSuchElementException("The client with id " + id + " was not found!");
        }
        return cl;
    }

    public boolean insert(String denumire, String marca, int pret, int cantitate) {
        ArrayList list = new ArrayList();
        ArrayList<String> list2 = new ArrayList<>();

        ArrayList list3 = new ArrayList();
        ArrayList<String> list4 = new ArrayList<>();

        list2.add("denumire");
        list2.add("marca");
        list2.add("pret");
        list.add(denumire);
        list.add(marca);
        list.add(pret);

        list4.add("idProdus");
        list4.add("cantitateStoc");


        boolean c1 = produsDAO.insert(list2, list);

        Produs p1 = produsDAO.fiindByName(denumire, "denumire");


        if (c1 == false) {
            throw new NoSuchElementException("The produs  " + denumire + " was not inserted!");
        } else

        {
            boolean c2 = stocBLL.insert(p1.getIdProdus(), cantitate);
            if (c2 == false) {
                throw new NoSuchElementException("Can not insert in table stoc");
            }

        }
        return true;
    }
    public boolean decrementStoc(int idProdus,int cantitate) {

        int actualStoc = getStoc(idProdus);
        boolean b3;
        if (cantitate > actualStoc)
            return false;
        else {
            b3 = stocBLL.decrement(idProdus, actualStoc - cantitate);
            if (b3 == false)
                System.out.println("eroare la decrementare");

        }
        return b3;
    }

    public boolean update(int id, String denumire, String marca, int pret) {
        ArrayList<String> listOfColumnName = new ArrayList();
        ArrayList listOfColumnValue = new ArrayList();

        listOfColumnName.add("denumire");
        listOfColumnName.add("marca");
        listOfColumnName.add("pret");

        listOfColumnValue.add(denumire);
        listOfColumnValue.add(marca);
        listOfColumnValue.add(pret);


        boolean cl = produsDAO.update("idProdus", id, listOfColumnName, listOfColumnValue);
        if (cl == false) {
            throw new NoSuchElementException("The client with id " + id + " was not updated!");
        }
        return cl;
    }

    public boolean delete(String denumire) {
        boolean cl = produsDAO.delete("denumire", denumire);
        if (cl == false) {
            throw new NoSuchElementException("The product  " + denumire + " was not deleted!");
        }

        return cl;
    }

    public List<Produs> selectAll() {
        List<Produs> cl;
        cl = produsDAO.selectAll();
        if (cl == null) {
            throw new NoSuchElementException("Elements were not found!");
        }
        return cl;
    }




}
