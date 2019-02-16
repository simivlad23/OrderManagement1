package View;

import bll.ComandaBLL;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlaceOrderFrame extends JFrame{

    JFrame frameMain = new JFrame("Place Order");
    JPanel panel = new JPanel();
    JLabel label = new JLabel("Id Produs");
    JLabel label2 = new JLabel("Id Client");
    JLabel label3 = new JLabel("Cantitate");
    JTextField tfIdClient = new JTextField();
    JTextField tfIdProdus = new JTextField();
    JTextField tfCantiate = new JTextField();

    JButton addOrderBtn = new JButton("ADD ORDER");




    public PlaceOrderFrame() {
        frameMain.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameMain.setSize(280, 200);
        frameMain.setLocationRelativeTo(null);

        panel.setLayout(null);

        label.setSize(100, 20);
        label.setLocation(20, 20);

        label2.setSize(60, 20);
        label2.setLocation(20, 50);


        label3.setSize(60, 20);
        label3.setLocation(20, 80);

        addOrderBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addOrder();
            }
        });

        tfIdClient.setSize(120, 20);
        tfIdClient.setLocation(100, 20);

        tfIdProdus.setSize(120, 20);
        tfIdProdus.setLocation(100, 50);

        tfCantiate.setSize(120, 20);
        tfCantiate.setLocation(100, 80);

        addOrderBtn.setSize(120, 20);
        addOrderBtn.setLocation(60, 120);

        panel.add(label);
        panel.add(label2);
        panel.add(label3);
        panel.add(addOrderBtn);
        panel.add(tfIdClient);
        panel.add(tfCantiate);
        panel.add(tfIdProdus);
        frameMain.setContentPane(panel);
        frameMain.setVisible(true);
    }
    public void addClientListener(ActionListener listener) {
        addOrderBtn.addActionListener(listener);
    }

    public int getIdClient() {
        return Integer.valueOf(tfIdClient.getText()).intValue();
    }

    public int getIdProdus() {
        return Integer.valueOf(tfIdProdus.getText()).intValue();    }

    public int getCantitate() {
        return Integer.valueOf(tfCantiate.getText()).intValue();
    }

    public void addOrder(){
        ComandaBLL comandaBLL = new ComandaBLL();
        comandaBLL.insert(getIdProdus(),getIdClient(),getCantitate());
        resetTf();
    }
    public void resetTf(){
        tfCantiate.setText("");
        tfIdProdus.setText("");
        tfIdClient.setText("");
    }

}
