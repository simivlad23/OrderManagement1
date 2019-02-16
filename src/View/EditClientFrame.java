package View;

import bll.ClientBLL;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditClientFrame extends JFrame{
    JFrame frameMain = new JFrame("Warehouse Management");
    JPanel panel = new JPanel();
    JLabel label = new JLabel("Nume Client");
    JLabel label2 = new JLabel("Email");
    JLabel label3 = new JLabel("Varsta");
    JLabel label4 = new JLabel("ID Client de Editat");
    JTextField tfNume = new JTextField();
    JTextField tfEmail = new JTextField();
    JTextField tfVarsta = new JTextField();
    JTextField tfId = new JTextField();

    JButton editClientBtn = new JButton("ADD");




    public EditClientFrame() {
        frameMain.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameMain.setSize(280, 250);
        frameMain.setLocationRelativeTo(null);

        panel.setLayout(null);

        label4.setSize(100, 20);
        label4.setLocation(20, 20);

        label.setSize(60, 20);
        label.setLocation(20, 50);


        label2.setSize(60, 20);
        label2.setLocation(20, 80);

        label3.setSize(60,20);
        label3.setLocation(20,110);



        tfId.setSize(90, 20);
        tfId.setLocation(130, 20);

        tfNume.setSize(120, 20);
        tfNume.setLocation(100, 50);

        tfEmail.setSize(120, 20);
        tfEmail.setLocation(100, 80);

        tfVarsta.setSize(120,20);
        tfVarsta.setLocation(100,110);

        editClientBtn.setSize(120, 20);
        editClientBtn.setLocation(60, 150);

        editClientBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editClient();
            }
        });

        panel.add(label);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        panel.add(editClientBtn);
        panel.add(tfNume);
        panel.add(tfEmail);
        panel.add(tfVarsta);
        panel.add(tfId);
        frameMain.setContentPane(panel);
        frameMain.setVisible(true);
    }
    public void editClientListener(ActionListener listener) {
        editClientBtn.addActionListener(listener);
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
    public int getID(){
        return Integer.valueOf(tfId.getText());
    }

    public void editClient(){
        ClientBLL clientBLL =new ClientBLL();
        clientBLL.update(getID(),getNumeClient(),getEmail(),getVarsta());
        resetTf();
    }
    public void resetTf(){
        tfVarsta.setText("");
        tfEmail.setText("");
        tfNume.setText("");
        tfId.setText("");
    }
}
