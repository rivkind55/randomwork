module actions {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires java.management;
	
	opens application to javafx.graphics, javafx.fxml;
}
