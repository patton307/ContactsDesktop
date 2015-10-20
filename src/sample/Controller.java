package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    ObservableList<Contact> contacts = FXCollections.observableArrayList();

    @FXML
    ListView listView;

    @FXML
    TextField textName;

    @FXML
    TextField textPhone;

    @FXML
    TextField textEmail;

    public void createContact () {
        if (textName.getText().equals("") || textPhone.getText().equals("") || textEmail.getText().equals(""))
        {
            System.out.println("");

        } else {
            Contact contact = new Contact(textName.getText(), textPhone.getText(), textEmail.getText());
            contacts.add(contact);

            textName.setText("");
            textPhone.setText("");
            textEmail.setText("");
        }
    }

    public void removeContact () {
        Contact contact = (Contact) listView.getSelectionModel().getSelectedItem();
        if (contact != null ) {
            contacts.remove(contact);
        }
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listView.setItems(contacts);
    }
}
