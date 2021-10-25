package dad.javafx.aprendiendo.fxml;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;

public class Controller implements Initializable {
	
	// model
	
	private StringProperty accion = new SimpleStringProperty();
	
	// view
	
	@FXML
	private VBox view;
	
	@FXML
	private ComboBox<String> accionCombo; 
	
	public Controller() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/View.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		accionCombo.getItems().addAll("Saludar", "Despedir");
		accionCombo.getSelectionModel().selectFirst();

		accion.bind(accionCombo.getSelectionModel().selectedItemProperty());
		
	}
	
	@FXML
	private void onClick(ActionEvent e) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Aprendiendo FXML");		
		if ("Saludar".equals(accion.get())) {
			alert.setContentText("¡Hola!");
		} else {
			alert.setContentText("¡Adiós!");
		}
		alert.showAndWait();
	}
	
	public VBox getView() {
		return view;
	}

}
