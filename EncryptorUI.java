import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;


// in Zusammenarbeit mit Thomas Pommerening

public class EncryptorUI extends Application{
	
	Encryptor encryptor;
	Encryptor[] liste = {new Reverse(), new Caesar()};
	
	VBox mainBox = new VBox(5);
	VBox enBox = new VBox(5);
	VBox deBox = new VBox(5);
	HBox menuBox = new HBox(5);
	TextArea enTextField = new TextArea();
	TextArea deTextField = new TextArea();
	Button enButton = new Button("Encrypt");
	Button deButton = new Button("Decrypt");
	
	ChoiceBox<String> chooser = new ChoiceBox<String>(FXCollections.observableArrayList("Reverse", "Caesar"));
	
	public static void main(String[] args) {
		launch(args);
	}

	
	public void start(Stage stage) throws Exception {
		chooser.getSelectionModel().selectedIndexProperty().addListener(e->{
			encryptor = liste[chooser.getSelectionModel().selectedIndexProperty().get()];
		});
		chooser.getSelectionModel().select(0);
		
		enBox.getChildren().addAll(new Label("Encrypt"), enTextField);
		deBox.getChildren().addAll(new Label("Decrypt"), deTextField);
		menuBox.getChildren().addAll(enButton, deButton, new Label("Method: "), chooser);
		menuBox.setAlignment(Pos.CENTER);
		mainBox.getChildren().addAll(enBox, deBox, menuBox);
		mainBox.setPadding(new Insets(9));
		
		enTextField.setPromptText("hier der Text zum Verschlüsseln");
		deTextField.setPromptText("hier der Text zum Entschlüsseln");
		VBox.setVgrow(enTextField, Priority.ALWAYS);
		VBox.setVgrow(deTextField, Priority.ALWAYS);
		
		enButton.setOnAction(e-> deTextField.setText(encryptor.encrypt(enTextField.getText())));
		deButton.setOnAction(e-> enTextField.setText(encryptor.decrypt(deTextField.getText())));
		
		BorderPane pane = new BorderPane();
		pane.setCenter(mainBox);
		Scene scene = new Scene(pane); 
		
		stage.setTitle("Encryptor");
		stage.centerOnScreen();
		stage.setHeight(400);
		stage.setWidth(600);
		stage.setScene(scene);
		stage.show();
	}

}
