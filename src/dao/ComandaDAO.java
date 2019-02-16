package dao;

import model.Comanda;

import java.util.ArrayList;
import java.util.List;

public class ComandaDAO extends AbstractDAO<Comanda> {


    @Override
    public Comanda findById(int id, String comumnId) {
        return super.findById(id, comumnId);
    }

    @Override
    public List<Comanda> selectAll() {
        return super.selectAll();
    }

    @Override
    public boolean insert(ArrayList<String> listColumn,ArrayList<Object> valueList) {
        return super.insert(listColumn,valueList);
    }

    @Override
    public boolean delete(String column, String name) {
        return super.delete(column, name);
    }

    @Override
    public boolean update(String columnNameId, int columnNameValue, ArrayList<String> listOfColumn, ArrayList<Object> listOfValue) {
        return super.update(columnNameId, columnNameValue, listOfColumn, listOfValue);
    }
}
