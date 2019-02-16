package View;

import bll.ClientBLL;
import model.Client;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ViewClientFrame extends JFrame{
    private JScrollPane jScrollPane;
    private JPanel panel;

    public ViewClientFrame(){
        panel = new JPanel();
        ClientBLL clientBll = new ClientBLL();
        List<Client> client1 = new ArrayList<Client>();

        client1 = clientBll.selectAll();

        List<Object> c = new ArrayList<Object>();
        for(Client it : client1)
            c.add(it);


        jScrollPane = new JScrollPane(Refection.getJTable(c));
        this.setSize(500, 400);
        panel.add(jScrollPane);
        this.add(panel, BorderLayout.CENTER);
        this.setVisible(true);

    }


}
