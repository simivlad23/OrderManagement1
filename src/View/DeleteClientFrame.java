package View;

import bll.ClientBLL;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteClientFrame extends JFrame{
    JFrame frameMain = new JFrame("Delete Customer");
    JPanel panel = new JPanel();
    JLabel label = new JLabel("Nume Client De Sters");

    JTextField tfNume = new JTextField();


    JButton deleteClientBtn = new JButton("DELETE");




    public DeleteClientFrame() {
        frameMain.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameMain.setSize(270, 200);
        frameMain.setLocationRelativeTo(null);

        panel.setLayout(null);

        label.setSize(150, 20);
        label.setLocation(40, 20);



        tfNume.setSize(120, 20);
        tfNume.setLocation(40, 50);


        deleteClientBtn.setSize(120, 30);
        deleteClientBtn.setLocation(40, 90);

        deleteClientBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteClient();
            }
        });

        panel.add(label);
        panel.add(tfNume);
        panel.add(deleteClientBtn);

        frameMain.setContentPane(panel);
        frameMain.setVisible(true);
    }
    public void editClientListener(ActionListener listener) {
        deleteClientBtn.addActionListener(listener);
    }

    public String getNumeClient() {
        return tfNume.getText();
    }

    public void deleteClient(){
        ClientBLL clientBLL = new ClientBLL();
        clientBLL.delete(getName());
        resetTf();
    }
    public void resetTf(){
        tfNume.setText("");

    }


}
