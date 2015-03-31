/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import app.view.RootLayoutController;
import java.io.File;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import utils.common.ApplicationConstants;

/**
 *
 * @author b.dang
 */
public class Controller extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) throws Exception {

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("AddressApp");

        if (this.CheckConnectionConfig() == false) {
            this.InitConnectionConfig();
        }
        
        this.initRootLayout();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    private boolean CheckConnectionConfig() {
        boolean isCreated = true;
        boolean isFileCreated = true;
        File configFile = new File(ApplicationConstants.GetConfigFilePath());
        isFileCreated = configFile.exists() && !configFile.isDirectory();

        if (ApplicationConstants.DatabaseConfig.Config.GetValue() == null) {
            isCreated = false;
        }
        return isCreated && isFileCreated;
    }

    private void InitConnectionConfig() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void initRootLayout() {
         try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Controller.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            RootLayoutController controller = loader.getController();
            controller.setMainApp(this);

            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
