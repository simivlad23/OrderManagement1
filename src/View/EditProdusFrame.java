package View;

import bll.ProdusBLL;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditProdusFrame extends JFrame{

    JFrame frameMain = new JFrame("Edit Product");
    JPanel panel = new JPanel();
    JLabel label = new JLabel("Denumire");
    JLabel label2 = new JLabel("Marca");
    JLabel label3 = new JLabel("Pret");
    JLabel label4 = new JLabel("ID produs de Editat");
    JTextField tfDenumire = new JTextField();
    JTextField tfMarca = new JTextField();
    JTextField tfPret = new JTextField();
    JTextField tfId = new JTextField();

    JButton addProdusBtn = new JButton("EDIT PRODUS");


    public EditProdusFrame() {
        frameMain.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameMain.setSize(280, 250);
        frameMain.setLocationRelativeTo(null);

        panel.setLayout(null);

        label4.setSize(120, 20);
        label4.setLocation(20, 20);

        label.setSize(60, 20);
        label.setLocation(20, 50);

        label2.setSize(60, 20);
        label2.setLocation(20, 80);

        label3.setSize(60, 20);
        label3.setLocation(20, 110);

        tfId.setSize(90, 20);
        tfId.setLocation(130, 20);

        tfDenumire.setSize(120, 20);
        tfDenumire.setLocation(100, 50);

        tfMarca.setSize(120, 20);
        tfMarca.setLocation(100, 80);

        tfPret.setSize(120, 20);
        tfPret.setLocation(100, 110);

        addProdusBtn.setSize(120, 20);
        addProdusBtn.setLocation(60, 150);

        addProdusBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editProdus();
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
        panel.add(tfId);
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
    public int getId(){
        return Integer.valueOf(tfId.getText());
    }

    public void editProdus(){
        ProdusBLL produsBLL =new ProdusBLL();
        produsBLL.update(getId(),getDenumireProdus(),getMarca(),getPret());
        resetTf();
    }
    public void resetTf(){
        tfId.setText("");
        tfPret.setText("");
        tfMarca.setText("");
        tfDenumire.setText("");
    }
}
