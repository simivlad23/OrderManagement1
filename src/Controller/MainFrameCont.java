package Controller;

import View.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrameCont {

    private MainFrame mainFrame;

    public MainFrameCont(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        mainFrame.addClientListener(new AddClientBtn());
        mainFrame.addProdusListener(new AddProdusBtn());
        mainFrame.deleteClientListener(new DeleteClientBtn());
        mainFrame.editClientListener(new EditClientBtn());
        mainFrame.viewClientListener(new ViewClientBtn());
        mainFrame.editProdusListener(new EditProdusBtn());
        mainFrame.deleteProdusListener(new DeleteProdusBtn());
        mainFrame.viewProdusListener(new ViewProdusBtn());
        mainFrame.addPlaceOrderListener(new PlaceOrderBtn());

    }

    public void addClient() {
        AddClientFrame addClientFrame = new AddClientFrame();


    }

    public void editClient() {
        EditClientFrame editClientFrame = new EditClientFrame();

    }

    public void deleteClient() {
        DeleteClientFrame deleteClientFrame = new DeleteClientFrame();


    }

    public void viewClient() {

        ViewClientFrame viewClientFrame = new ViewClientFrame();

    }

    public void addProdus() {
        AddProdusFrame addProdusFrame = new AddProdusFrame();

    }

    public void editProdus() {

        EditProdusFrame editProdusFrame = new EditProdusFrame();
    }

    public void deleteProdus() {
        DeleteProdusFrame deleteProdusFrame = new DeleteProdusFrame();
    }

    public void viewProdus() {
        ViewProdusFrame viewProdusFrame = new ViewProdusFrame();

    }

    public void addOrder() {
        PlaceOrderFrame placeOrderFrame = new PlaceOrderFrame();

    }

    class AddClientBtn implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            try {
                addClient();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class EditClientBtn implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            try {
                editClient();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class DeleteClientBtn implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            try {
                deleteClient();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class ViewClientBtn implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            try {
                viewClient();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class AddProdusBtn implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            try {
                addProdus();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class EditProdusBtn implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            try {
                editProdus();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class DeleteProdusBtn implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            try {
                deleteProdus();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class ViewProdusBtn implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            try {
                viewProdus();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class PlaceOrderBtn implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            try {
                addOrder();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}





