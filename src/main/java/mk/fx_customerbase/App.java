package mk.fx_customerbase;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import model.Customers;

/**
 * JavaFX App
 * @author Michał Kalke
 */
public class App extends Application {

    private static Scene scene; // having current scene
    private static Customers customers; // having customer object

    /**
     * Start method
     * @param stage having current stage
     * @throws IOException throws IOEception if not set
     */
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("views/view"), 1000, 480);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * This method is setting root
     * @param fxml having current fxml
     * @throws IOException throws IOEception if not set
     */
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }


    /**
     * This method is loading a fxml
     * @param fxml having current fxml
     * @return loaded fxml
     * @throws IOException
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        
         fxmlLoader.setControllerFactory( p -> { return new Controller(customers);} );
        
        return fxmlLoader.load();
    }


    /**
     * Main, where the whole app is launched
     * @param args has passed arguments
     */
    public static void main(String[] args) {
      customers = new Customers();
        launch();   
    }

}