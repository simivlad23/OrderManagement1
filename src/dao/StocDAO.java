package dao;

import model.Stoc;

import java.util.ArrayList;
import java.util.List;

public class StocDAO extends AbstractDAO<Stoc> {
    @Override
    public List<Stoc> selectAll() {
        return super.selectAll();
    }

    @Override
    public Stoc findById(int id, String comumnId) {
        return super.findById(id, comumnId);
    }

    @Override
    public boolean update(String columnNameId, int columnNameValue, ArrayList<String> listOfColumn, ArrayList<Object> listOfValue) {
        return super.update(columnNameId, columnNameValue, listOfColumn, listOfValue);
    }

    @Override
    public boolean insert(ArrayList<String> columnList, ArrayList<Object> valueList) {
        return super.insert(columnList, valueList);
    }
}
