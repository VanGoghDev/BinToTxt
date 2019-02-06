package ru.firsov.kirill.windowsApp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import ru.firsov.kirill.base.BinToTxt;
import ru.firsov.kirill.base.Searcher;

import java.io.File;
import java.io.IOException;

public class Controller {
    ObservableList<String> typeChooserList = FXCollections.observableArrayList("Boolean", "Byte", "Int", "Float");

    public Button btnOpen;
    public Button btnSearch;
    public ListView listView;
    public TextField valueText;
    public ChoiceBox typeChooser;

    private File fileIn;
    private File fileOut;

    private boolean openIsPressed = false;

    @FXML
    public void initialize() {
        typeChooser.setItems(typeChooserList);
    }

    public void fileOpen(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("bin Files", "*.bin"));
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("txt Files", "*.txt"));
        File selectedFile = fc.showOpenDialog(null);
        openIsPressed = true;

        if (selectedFile != null){
            listView.getItems().add(selectedFile.getAbsolutePath());
            fileIn = selectedFile;
        }
        else System.out.println("file is not valid");
    }

    public void fileSave(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("txt Files", "*.txt"));
        File selectedFile = fc.showOpenDialog(null);

        if (selectedFile != null) {
            listView.getItems().add(selectedFile.getAbsolutePath());
            fileOut = selectedFile;
            startAlgorithm();
        }
        else System.out.println("file is not valid");
    }

    public void search(ActionEvent event) {
        startAlgorithm();
    }

    private void startAlgorithm() {
        BinToTxt binToTxt = new BinToTxt(fileIn);
        binToTxt.read();
        binToTxt.search(16, "Byte");

        //binToTxt.writeTxt();


        //Searcher searcher = new Searcher(fileIn, fileOut);
        //searcher.setaString(binToTxt.getaString());
        /*try{
            int val;
            searcher.search(val = Integer.parseInt(valueText.getText()));
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
