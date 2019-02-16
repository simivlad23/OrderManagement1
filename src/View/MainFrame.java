package View;


import javax.swing.*;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame{

    JFrame frameMain = new JFrame("Warehouse Management");
    JPanel panel = new JPanel();
    JLabel label = new JLabel("CLIENTI");
    JLabel label2 = new JLabel("PRODUSE");
    JButton addClientBtn = new JButton("ADD");
    JButton addProdusBtn = new JButton("ADD");
    JButton editClientBtn = new JButton("EDIT");
    JButton editProdusBtn = new JButton("EDIT");
    JButton deleteClientBtn = new JButton("DELETE");
    JButton deleteProdusBtn = new JButton("DELETE");
    JButton viewClientBtn = new JButton("VIEW");
    JButton viewProdusBtn = new JButton("VIEW");
    JButton placeOrderBtn = new JButton("PLACE ORDER");

    public MainFrame() {
        frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMain.setSize(380, 300);
        frameMain.setLocationRelativeTo(null);

        panel.setLayout(null);

        label.setSize(60, 20);
        label.setLocation(60, 15);

        label2.setSize(60, 20);
        label2.setLocation(230, 15);

        addClientBtn.setSize(120, 20);
        addClientBtn.setLocation(20, 50);

        editClientBtn.setSize(120, 20);
        editClientBtn.setLocation(20, 80);

        deleteClientBtn.setSize(120, 20);
        deleteClientBtn.setLocation(20, 110);

        viewClientBtn.setSize(120, 20);
        viewClientBtn.setLocation(20, 140);
//----------------------------------------------------------

        addProdusBtn.setSize(120, 20);
        addProdusBtn.setLocation(200, 50);

        editProdusBtn.setSize(120, 20);
        editProdusBtn.setLocation(200, 80);

        deleteProdusBtn.setSize(120, 20);
        deleteProdusBtn.setLocation(200, 110);


        viewProdusBtn.setSize(120, 20);
        viewProdusBtn.setLocation(200, 140);

        placeOrderBtn.setSize(120, 30);
        placeOrderBtn.setLocation(115, 180);


        panel.add(label);
        panel.add(label2);
        panel.add(addClientBtn);
        panel.add(addProdusBtn);
        panel.add(editClientBtn);
        panel.add(editProdusBtn);
        panel.add(deleteClientBtn);
        panel.add(deleteProdusBtn);
        panel.add(viewClientBtn);
        panel.add(viewProdusBtn);
        panel.add(placeOrderBtn);
        frameMain.setContentPane(panel);
        frameMain.setVisible(true);
    }
    public void addClientListener(ActionListener listener) {
        addClientBtn.addActionListener(listener);
    }
    public void addProdusListener(ActionListener listener) {
        addProdusBtn.addActionListener(listener);
    }
    public void editClientListener(ActionListener listener) {
        editClientBtn.addActionListener(listener);
    }
    public void editProdusListener(ActionListener listener) {
        editProdusBtn.addActionListener(listener);
    }
    public void deleteClientListener(ActionListener listener) {
        deleteClientBtn.addActionListener(listener);
    }
    public void deleteProdusListener(ActionListener listener) {
        deleteProdusBtn.addActionListener(listener);
    }
    public void viewClientListener(ActionListener listener) {
        viewClientBtn.addActionListener(listener);
    }
    public void viewProdusListener(ActionListener listener) {
        viewProdusBtn.addActionListener(listener);
    }
    public void addPlaceOrderListener(ActionListener listener) {
        placeOrderBtn.addActionListener(listener);
    }


}
