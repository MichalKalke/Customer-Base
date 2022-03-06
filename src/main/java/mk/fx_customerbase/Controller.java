package mk.fx_customerbase;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import model.Customer;
import model.Customers;

/**
 * This class is a controller of the whole app
 * @author Michał Kalke
 */
public class Controller {

    /**
     * Holding table view variable
     */
    @FXML
    private TableView table;

    /**
     * Table column variable showing id
     */
    @FXML
    private TableColumn id;

    /**
     * Table column variable showing name
     */
    @FXML
    private TableColumn name;

    /**
     * Table column variable showing surname
     */
    @FXML
    private TableColumn lastName;

    /**
     * Table column variable showing e-mail address
     */
    @FXML
    private TableColumn mail;

    /**
     * Table column variable showing city
     */
    @FXML
    private TableColumn city;

    /**
     * Table column variable showing street
     */
    @FXML
    private TableColumn street;

    /**
     * Table column variable showing house number
     */
    @FXML
    private TableColumn houseNumber;

    /**
     * Table column variable showing country
     */
    @FXML
    private TableColumn country;

    /**
     * Table column variable showing orders
     */
    @FXML
    private TableColumn orders;

    /**
     * Holding button which is used to add new customers
     */
    @FXML
    private Button add;

    /**
     * Holding button which is used to delete customers
     */
    @FXML
    private Button delete;

    /**
     * The user is putting there the name of the new customer
     */
    @FXML
    private TextField txt_name;

    /**
     * The user is putting there the surname of the new customer
     */
    @FXML
    private TextField txt_lastName;

    /**
     * The user is putting there the e-mail address of the new customer
     */
    @FXML
    private TextField txt_mail;

    /**
     * The user is putting there the city of the new customer
     */
    @FXML
    private TextField txt_city;

    /**
     * The user is putting there the street of the new customer
     */
    @FXML
    private TextField txt_street;

    /**
     * The user is putting there the house number of the new customer
     */
    @FXML
    private TextField txt_houseNumber;

    /**
     * The user is putting there the country of the new customer
     */
    @FXML
    private TextField txt_country;

    /**
     * The user is putting there orders of the new customer
     */
    @FXML
    private TextField txt_orders;

    /**
     * The user is putting there the phrase which is searched
     */
    @FXML
    private TextField txt_filter;

    /**
     * Holding customers object in the observable list
     */
    private final ObservableList<Customer> data;

    /**
     * Represents object of class Customers
     */
    private final Customers customers;

    /**
     * This is a constructor of class Controller which gives values to list and looking for a change on the list
      * @param customers represents an object of class Customers
     */
    public Controller(Customers customers) {
    this.customers = customers;
    data = FXCollections.observableArrayList(customers.getData());
            data.addListener(new ListChangeListener<Customer>(){
            @Override
            public void onChanged(ListChangeListener.Change<? extends Customer> change) {
                while (change.next()) {
                    if (change.wasPermutated()) {
                        for (int i = change.getFrom(); i < change.getTo(); ++i) {

                        }
                    } else if (change.wasUpdated()) {

                    } else {
                        for (var remitem : change.getRemoved()) {
                            customers.getData().remove(remitem);
                        }
                        for (var additem : change.getAddedSubList()) {
                            customers.getData().add(additem);
                        }
                    }
                }
            }
        });
}
    
    /**
     * This method is saving informations from list of customers to .txt file
     * @param listOfCustomers stores list of customers
     */
    private void write(List<Customer> listOfCustomers) { 
    try {
      FileWriter myWriter = new FileWriter("customer"+".txt");
      listOfCustomers.stream().forEach(c->{try {
          myWriter.write(c.getId()+";"+c.getName()+";"+c.getLastName()+";"+c.getMail()+";"+c.getCity()+";"+c.getStreet()+";"+c.getHouseNumber()+";"+c.getCountry()+";"+c.getOrders()+"\n");
          } catch (IOException ex) {
              errorHandler(ex);
          }
        });
        
      myWriter.close();
     
    } 
      catch (IOException e) {
        errorHandler(e);
    }
  }

    /**
     * This method is pulling data to table view. City, street, house number and orders can be modified by this method, and the user can search trough data in table view
     */
    @FXML
    public void initialize() {
        
       // table.setItems(data);
        id.setCellValueFactory(new PropertyValueFactory<Customer, String>("id"));
        name.setCellValueFactory(new PropertyValueFactory<Customer, String>("name"));
        lastName.setCellValueFactory(new PropertyValueFactory<Customer, String>("lastName"));
        mail.setCellValueFactory(new PropertyValueFactory<Customer, String>("mail"));
        city.setCellValueFactory(new PropertyValueFactory<Customer, String>("city"));
        street.setCellValueFactory(new PropertyValueFactory<Customer, String>("street"));
        houseNumber.setCellValueFactory(new PropertyValueFactory<Customer, String>("houseNumber"));
        country.setCellValueFactory(new PropertyValueFactory<Customer, String>("country"));
        orders.setCellValueFactory(new PropertyValueFactory<Customer, String>("orders"));
        
        FilteredList<Customer> filteredData = new FilteredList<>(data, b ->true);
        
        txt_filter.textProperty().addListener((observable, oldValue, newValue)-> {
            filteredData.setPredicate(customer -> { 
            if(newValue == null || newValue.isEmpty()) {
                return true;
            }
            String lowerCaseFilter = newValue.toLowerCase();
            
            if(customer.getName().toLowerCase().indexOf(lowerCaseFilter) !=-1) {
                return true;
            } else if(customer.getLastName().toLowerCase().indexOf(lowerCaseFilter) !=-1) {
                return true;
            } else if(customer.getMail().toLowerCase().indexOf(lowerCaseFilter) !=-1) {
                return true;
            } else return false;
            });
        });
        
        SortedList<Customer> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table.comparatorProperty());
        
        table.setItems(sortedData);
        
        table.setEditable(true);
        
        city.setCellFactory(TextFieldTableCell.forTableColumn());
        street.setCellFactory(TextFieldTableCell.forTableColumn());
        houseNumber.setCellFactory(TextFieldTableCell.forTableColumn());
        orders.setCellFactory(TextFieldTableCell.forTableColumn());
        
        city.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Customer, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Customer, String> t) {
                ((Customer) t.getTableView().getItems().get(t.getTablePosition().getRow())).setCity(t.getNewValue());
                write(data);
            }
        });
        	
        
        street.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Customer, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Customer, String> t) {
                ((Customer) t.getTableView().getItems().get(t.getTablePosition().getRow())).setStreet(t.getNewValue());
                write(data);
            }
        });
        
        houseNumber.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Customer, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Customer, String> t) {
                ((Customer) t.getTableView().getItems().get(t.getTablePosition().getRow())).setHouseNumber(t.getNewValue());
                write(data);
            }
        });
        
        orders.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Customer, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Customer, String> t) {
                ((Customer) t.getTableView().getItems().get(t.getTablePosition().getRow())).setOrders(t.getNewValue());
                write(data);
            }
        });
    }


    /**
     * This method is called when the user wants to add new customer to the base, if data are not complete or with mistake, here comes the alert
     * @param evenr holding event
     */
    @FXML
    private void add(ActionEvent evenr) {
        Customer customer = new Customer();
        if(!customer.checkIfIsInBase(data, txt_name.getText(), txt_lastName.getText(), txt_city.getText(), txt_country.getText())) {
            if (!txt_name.getText().equals("") && !txt_lastName.getText().equals("") && !txt_mail.getText().equals("") && !txt_city.getText().equals("") && !txt_street.getText().equals("") && !txt_houseNumber.getText().equals("") && !txt_country.getText().equals("") && isOrderInt(txt_orders)) {
                data.add(new Customer(customer.lastIdInBase(data) + 1, txt_name.getText(), txt_lastName.getText(), txt_mail.getText(), txt_city.getText(), txt_street.getText(), txt_houseNumber.getText(), txt_country.getText(), txt_orders.getText()));
                write(data);
            }
            else {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Brak danych");
                alert.setHeaderText(null);
                alert.setContentText("Nie podano pełnych danych!");
                alert.showAndWait();
            }
        }
        else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Istnieje");
            alert.setHeaderText(null);
            alert.setContentText("Podana osoba już istnieje w bazie!");
            alert.showAndWait();
        }
    }

    /**
     * This method is called when the user wants to remove the customer from the base
     * @param evenr holding event
     */
   @FXML
   private void remove(ActionEvent evenr) {
       int index = table.getSelectionModel().getSelectedIndex();
       if(index != -1) {
           data.remove(index);
           write(data);
       } 
   }

    /**
     * This method is called when any exception is out, printing it in alert
     * @param e holding exception
     */
   @FXML
   public void errorHandler(Exception e) {
        Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText("An error occurred. " + e.getMessage());
            alert.showAndWait();
   }

    /**
     * This method is checking if passed order in text field is an integer
     * @param order passed order fromm text field
     * @return true if order is an integer or false if it isn't
     */
   private boolean isOrderInt(TextField order) {
       if(order.getText().equals("")) return false;
       try {
           int x = Integer.parseInt(order.getText());
       } catch (NumberFormatException e){
           errorHandler(e);
           return false;
       }
       return true;
   }
    
}
