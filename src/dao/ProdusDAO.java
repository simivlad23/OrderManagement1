package dao;

import model.Produs;

import java.util.ArrayList;
import java.util.List;

public class ProdusDAO extends AbstractDAO<Produs> {


    @Override
    public Produs findById(int id, String comumnId) {
        return super.findById(id, comumnId);
    }

    @Override
    public List<Produs> selectAll() {
        return super.selectAll();
    }

    @Override
    public Produs fiindByName(String nameValue, String columnName) {
        return super.fiindByName(nameValue, columnName);
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
