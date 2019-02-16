package View;

import bll.ProdusBLL;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteProdusFrame extends JFrame {
    JFrame frameMain = new JFrame("Delete Product");
    JPanel panel = new JPanel();
    JLabel label = new JLabel("Nume Produs De Sters");

    JTextField tfDenumire = new JTextField();


    JButton deleteProdusBtn = new JButton("DELETE");




    public DeleteProdusFrame() {
        frameMain.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameMain.setSize(270, 200);
        frameMain.setLocationRelativeTo(null);

        panel.setLayout(null);

        label.setSize(150, 20);
        label.setLocation(40, 20);



        tfDenumire.setSize(120, 20);
        tfDenumire.setLocation(40, 50);


        deleteProdusBtn.setSize(120, 30);
        deleteProdusBtn.setLocation(40, 90);

        deleteProdusBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteProdus();
            }
        });

        panel.add(label);
        panel.add(tfDenumire);
        panel.add(deleteProdusBtn);

        frameMain.setContentPane(panel);
        frameMain.setVisible(true);
    }
    public void editClientListener(ActionListener listener) {
        deleteProdusBtn.addActionListener(listener);
    }

    public String getDenumire() {
        return tfDenumire.getText();
    }

    public void deleteProdus(){
        ProdusBLL produsBLL = new ProdusBLL();
        produsBLL.delete(getDenumire());
        resetTf();
    }
    public void resetTf(){

        tfDenumire.setText("");
    }

}
