package dao;

import connection.ConnectionFactory;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AbstractDAO<T> {
    protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());

    private final Class<T> type;

    @SuppressWarnings("unchecked")
    public AbstractDAO() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    }

    public String createInsertQuery(ArrayList<String> listColumn) {
        int sizeList = listColumn.size();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" INSERT INTO ");
        stringBuilder.append(type.getSimpleName());
        stringBuilder.append(" (");
        for (int i = 0; i < sizeList - 1; i++)
            stringBuilder.append(listColumn.get(i)+",");
        stringBuilder.append(listColumn.get(sizeList-1)+ ")");
        stringBuilder.append(" VALUES (");
        for (int i = 0; i < sizeList - 1; i++)
            stringBuilder.append("? ,");
        stringBuilder.append("?) ");
        return stringBuilder.toString();
    }

    private String createSelectQuery(String field) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT * FROM ");
        stringBuilder.append(type.getSimpleName());
        stringBuilder.append(" WHERE " + field + " =?;");
        return stringBuilder.toString();
    }


    public String createSelectAllQuery() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT * FROM ");
        stringBuilder.append(type.getSimpleName());
        return stringBuilder.toString();
    }

    public String createUpdateQuery(String columnIndentification, ArrayList<String> columnListToChange) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UPDATE ");
        stringBuilder.append(type.getSimpleName());
        stringBuilder.append(" SET ");
        int sizeList = columnListToChange.size();
        for (int i = 0; i < sizeList; i++) {
            stringBuilder.append(columnListToChange.get(i));
            stringBuilder.append("=?");
            if (i != sizeList - 1) {
                stringBuilder.append(" , ");
            }
        }
        stringBuilder.append(" WHERE " + columnIndentification + " =?;");

        return stringBuilder.toString();
    }

    public String createDeleteQuery(String column) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DELETE FROM ");
        stringBuilder.append(type.getSimpleName());
        stringBuilder.append(" WHERE " + column + " =?");

        return stringBuilder.toString();
    }

    protected List<T> createObjects(ResultSet resultSet) {
        List<T> list = new ArrayList<T>();
        try {
            while (resultSet.next()) {
               T instance = this.type.newInstance();
                for (Field field : type.getDeclaredFields()) {

                    Object value = resultSet.getObject(field.getName());
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), type);
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(instance, value);
                }

                list.add(instance);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }

    public T findById(int id,String comumnId) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectQuery(comumnId);

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            System.out.println("Se relizera urmatoara interogare");
            System.out.println(query);

            resultSet = statement.executeQuery();

            return createObjects(resultSet).get(0);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;

    }

    public boolean insert(ArrayList<String> columnList,ArrayList<Object> valueList){
        Connection connection =null;
        PreparedStatement statement = null;
        //ResultSet resultSet =null;
        int sizeList = columnList.size();
        String query = createInsertQuery(columnList);
        try{
            connection = ConnectionFactory.getConnection();
            statement =connection.prepareStatement(query);
            for (int i =0;i<sizeList;i++){

                if (valueList.get(i) instanceof Integer)
                    statement.setInt(i+1,(int)valueList.get(i));
                else
                    statement.setString(i+1,(String)valueList.get(i));
            }

            statement.execute();
            return true;

        }catch (SQLException e){
            e.printStackTrace();

        }finally {

            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return  false;
    }

    public T fiindByName(String nameValue, String columnName){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectQuery(columnName);
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, nameValue);
            resultSet = statement.executeQuery();
            return createObjects(resultSet).get(0);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    public List<T> selectAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectAllQuery();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            System.out.println("Se relizera urmatoara interogare");
            System.out.println(query);

            resultSet = statement.executeQuery();

            return createObjects(resultSet);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    public boolean delete(String column,String name){

        Connection connection =null;
        PreparedStatement statement = null;

        String query = createDeleteQuery(column);
        try{
            connection = ConnectionFactory.getConnection();
            statement =connection.prepareStatement(query);


            statement.setString(1,name);

            statement.executeUpdate();
            return true;

        }catch (SQLException e){
            e.printStackTrace();

        }finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return  false;
    }

    public boolean update(String columnNameId,int columnNameValue,ArrayList<String> listOfColumn,ArrayList<Object> listOfValue){

        Connection connection =null;
        PreparedStatement statement = null;

        String query = createUpdateQuery(columnNameId,listOfColumn);
        try{
            connection = ConnectionFactory.getConnection();
            statement =connection.prepareStatement(query);

            int sizeList =listOfColumn.size();
            for(int i =0 ;i<sizeList;i++)
            {
                if(listOfValue.get(i) instanceof Integer)
                    statement.setInt(i+1,(int)listOfValue.get(i));
                else
                    statement.setString(i+1,(String)listOfValue.get(i));
            }
            statement.setInt(sizeList+1,columnNameValue);


            statement.execute();
            return true;

        }catch (SQLException e){
            e.printStackTrace();

        }finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return  false;
    }

}
