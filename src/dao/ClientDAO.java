package dao;

import model.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientDAO extends AbstractDAO<Client>{

    @Override
    public Client findById(int id, String columnId) {
        return super.findById(id,columnId);
    }

    @Override
    public Client fiindByName(String nameValue, String columnName) {
        return super.fiindByName(nameValue, columnName);
    }

    @Override
    public List<Client> selectAll() {
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
