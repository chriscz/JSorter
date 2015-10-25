import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.stage.DirectoryChooser;
import java.io.IOException;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.io.File;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.layout.StackPane;

public class JSortApp extends Application

{	

	private File sortDir;
	
	public void start(Stage stage) {
		Button chooseFile = new Button("choose file to be sorted");
		chooseFile.setStyle("-fx-font-size:14pt; -fx-font-weight:bold; -fx-base: #d3d3d3; -fx-font-family:Monaco, 'Courier New', MONOSPACE");
		chooseFile.setOnAction( new EventHandler<ActionEvent>() {
			@Override
			public void handle(final ActionEvent e) {
			    final DirectoryChooser directoryChooser =
			        new DirectoryChooser();
			    final File selectedDirectory =
			            directoryChooser.showDialog(stage);
			    if (selectedDirectory != null) {
			        selectedDirectory.getAbsolutePath();
			    }
			    sortDir = selectedDirectory;
			    System.out.println(sortDir.getName());
			}
		});
		CheckBox directoryFlag = new CheckBox("sort directories");
		CheckBox deleteDuplicates = new CheckBox("delete duplicates");
		deleteDuplicates.setStyle("-fx-font-size:10pt; -fx-font-weight:bold; -fx-text-fill: rgb(255, 255, 255); -fx-base: #ffffff; -fx-font-family:Monaco, 'Courier New', MONOSPACE");
		directoryFlag.setStyle("-fx-font-size:10pt; -fx-font-weight:bold; -fx-text-fill: rgb(255, 255, 255); -fx-font-family:Monaco, 'Courier New', MONOSPACE");
		deleteDuplicates.setAlignment(Pos.BOTTOM_LEFT);
		directoryFlag.setAlignment(Pos.BOTTOM_LEFT);
		VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(20);
        root.getChildren().addAll(chooseFile, directoryFlag, deleteDuplicates);
        StackPane layout = new StackPane();
        layout.getChildren().add(root);
        Scene scene = new Scene(layout, 500, 500);
        
        layout.getStylesheets().add("style.css");
       	layout.getStyleClass().add("pane");
        scene.getStylesheets().addAll(
				JSortApp.class.getResource("style.css").toExternalForm());
		stage.setScene(scene);
        stage.show();
	} 	
	
	public static void main(String[] args) throws IOException{
		launch(args);
	}
}
