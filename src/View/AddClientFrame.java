package View;

import bll.ClientBLL;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddClientFrame extends JFrame {
    JFrame frameMain = new JFrame("Warehouse Management");
    JPanel panel = new JPanel();
    JLabel label = new JLabel("Nume Client");
    JLabel label2 = new JLabel("Email");
    JLabel label3 = new JLabel("Varsta");
    JTextField tfNume = new JTextField();
    JTextField tfEmail = new JTextField();
    JTextField tfVarsta = new JTextField();

    JButton addClientBtn = new JButton("ADD");


    public AddClientFrame() {
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

        tfNume.setSize(120, 20);
        tfNume.setLocation(100, 20);

        tfEmail.setSize(120, 20);
        tfEmail.setLocation(100, 50);

        tfVarsta.setSize(120, 20);
        tfVarsta.setLocation(100, 80);

        addClientBtn.setSize(120, 20);
        addClientBtn.setLocation(60, 120);

        addClientBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addClient();
            }
        });

        panel.add(label);
        panel.add(label2);
        panel.add(label3);
        panel.add(addClientBtn);
        panel.add(tfNume);
        panel.add(tfEmail);
        panel.add(tfVarsta);
        frameMain.setContentPane(panel);
        frameMain.setVisible(true);
    }


    public String getNumeClient() {
        return tfNume.getText();
    }

    public String getEmail() {
        return tfEmail.getText();
    }

    public int getVarsta() {
        return Integer.valueOf(tfVarsta.getText());
    }

    public void addClient() {
        ClientBLL clientBLL = new ClientBLL();
        clientBLL.insert(getNumeClient(),getEmail(),getVarsta());
        resetTf();
    }
    public void resetTf(){
        tfVarsta.setText("");
        tfEmail.setText("");
        tfNume.setText("");

    }


}
