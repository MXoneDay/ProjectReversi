package view;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class AlertView {
	private Alert alert = new Alert(AlertType.NONE);
	
	public Alert getAlert(){
		return alert;
	}
	
	public void setAlert(AlertType at) {
		alert = new Alert(at);
	}
	
	public void hideAlert() {
		alert.getButtonTypes().add(ButtonType.CANCEL);
		alert.hide();
		alert.getButtonTypes().remove(ButtonType.CANCEL);
	}
}
