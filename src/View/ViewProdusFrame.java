package View;

import bll.ProdusBLL;
import model.Produs;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ViewProdusFrame extends JFrame {
    private JScrollPane jScrollPane;
    private JPanel p;

    public ViewProdusFrame(){
        jScrollPane = new JScrollPane();
        this.setSize(500, 400);
        p = new JPanel();


        ProdusBLL produsBll = new ProdusBLL();
        List<Produs> produs1 = new ArrayList<Produs>();
        produs1 = produsBll.selectAll();

        List<Object> listaProduse = new ArrayList<Object>();
        for(Produs it : produs1)
            listaProduse.add(it);

        jScrollPane = new JScrollPane(Refection.getJTable(listaProduse));
        p.add(jScrollPane);
        this.add(p, BorderLayout.CENTER);
        this.setVisible(true);

    }


}
