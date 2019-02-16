package View;

import bll.ProdusBLL;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddProdusFrame extends JFrame{

    JFrame frameMain = new JFrame("Add Product");
    JPanel panel = new JPanel();
    JLabel label = new JLabel("Denumire");
    JLabel label2 = new JLabel("Marca");
    JLabel label3 = new JLabel("Pret");
    JLabel label4 = new JLabel("Cantitate ");
    JTextField tfDenumire = new JTextField();
    JTextField tfMarca = new JTextField();
    JTextField tfPret = new JTextField();
    JTextField tfCantiate =new JTextField();

    JButton addProdusBtn = new JButton("ADD");


    public AddProdusFrame() {
        frameMain.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameMain.setSize(280, 240);
        frameMain.setLocationRelativeTo(null);

        panel.setLayout(null);

        label.setSize(100, 20);
        label.setLocation(20, 20);

        label2.setSize(60, 20);
        label2.setLocation(20, 50);

        label3.setSize(60, 20);
        label3.setLocation(20, 80);

        label4.setSize(60,20);
        label4.setLocation(20,110);

        tfDenumire.setSize(120, 20);
        tfDenumire.setLocation(100, 20);

        tfMarca.setSize(120, 20);
        tfMarca.setLocation(100, 50);

        tfPret.setSize(120, 20);
        tfPret.setLocation(100, 80);

        tfCantiate.setSize(120, 20);
        tfCantiate.setLocation(100, 110);


        addProdusBtn.setSize(120, 30);
        addProdusBtn.setLocation(60, 150);

        addProdusBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addProdus();
            }
        });

        panel.add(label);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        panel.add(addProdusBtn);
        panel.add(tfDenumire);
        panel.add(tfMarca);
        panel.add(tfPret);
        panel.add(tfCantiate);
        frameMain.setContentPane(panel);
        frameMain.setVisible(true);
    }
    public void addClientListener(ActionListener listener) {
        addProdusBtn.addActionListener(listener);
    }

    public String getDenumireProdus() {
        return tfDenumire.getText();
    }

    public String getMarca() {
        return tfMarca.getText();
    }

    public int getPret() {
        return Integer.valueOf(tfPret.getText());
    }
    public int getCantitate(){
        return Integer.valueOf(tfCantiate.getText());
    }

    public void addProdus(){
        ProdusBLL produsBLL = new ProdusBLL();
        produsBLL.insert(getDenumireProdus(),getMarca(),getPret(),getCantitate());
        resetTf();
    }
    public void resetTf(){
        tfCantiate.setText("");
        tfPret.setText("");
        tfMarca.setText("");
        tfDenumire.setText("");
    }
}
