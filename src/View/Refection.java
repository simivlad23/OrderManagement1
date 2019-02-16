package View;

import javax.swing.*;
import java.lang.reflect.Field;
import java.util.List;

public class Refection {
    public static JTable getJTable(List<Object> lisatCliProd) {

        int i=0,j=0;
        int k=0;
        Object [][] tabela = new Object[lisatCliProd.size()][4];
        String [] listaCampuri = new String[4];

            for (Field field : lisatCliProd.get(0).getClass().getDeclaredFields()) {

                field.setAccessible(true);
                 listaCampuri[k]=field.getName();
                System.out.println(field.getName());
                k++;

            }

        for(Object it : lisatCliProd){
            for (Field field : it.getClass().getDeclaredFields()) {
                Object value;
                field.setAccessible(true);
               // listaCampuri[k]=field.getName();
                System.out.println(field.getName());



                try {
                    value = field.get(it);
                    tabela[i][j]=value;

                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }


                j=j+1;
                System.out.println("");

            }
            j=0;
            i=i+1;
        }

        JTable t = new JTable(tabela,listaCampuri);
        return t;
    }
}
