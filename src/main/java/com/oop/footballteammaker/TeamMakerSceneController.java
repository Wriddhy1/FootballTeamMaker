package com.oop.footballteammaker;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TeamMakerSceneController {
    @javafx.fxml.FXML
    private ComboBox<String> universityComboBox;
    @javafx.fxml.FXML
    private TextField phonenumberTextField;
    @javafx.fxml.FXML
    private TableColumn phonenumberCol;
    @javafx.fxml.FXML
    private TableColumn nameCol;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private TableView tableView;
    @javafx.fxml.FXML
    private TableColumn genderCol;
    @javafx.fxml.FXML
    private Label labelTextField;
    @javafx.fxml.FXML
    private ComboBox<String> searchComboBox;
    @javafx.fxml.FXML
    private ToggleGroup selected;
    @javafx.fxml.FXML
    private TableColumn tagCol;
    @javafx.fxml.FXML
    private RadioButton femaleSearchRadioButton;
    @javafx.fxml.FXML
    private RadioButton femaleRadioButton;
    @javafx.fxml.FXML
    private RadioButton maleRadioButton;
    @javafx.fxml.FXML
    private RadioButton maleSearchRadioButton;
    @javafx.fxml.FXML
    private TableColumn universityCol;

    @javafx.fxml.FXML
    public void initialize() {
        nameCol.setCellValueFactory(new PropertyValueFactory<Team, String>("name"));
        phonenumberCol.setCellValueFactory(new PropertyValueFactory<Team, String>("phonenumber"));
        universityCol.setCellValueFactory(new PropertyValueFactory<Team, String>("university"));
        tagCol.setCellValueFactory(new PropertyValueFactory<Team, String>("tag"));
        genderCol.setCellValueFactory(new PropertyValueFactory<Team, String>("gender"));

        universityComboBox.getItems().addAll("IUB", "NSU");
        searchComboBox.getItems().addAll("IUB", "NSU");


    }

    ArrayList<Team> teamArrayList = new ArrayList<>();

    @javafx.fxml.FXML
    public void saveOnAction(ActionEvent actionEvent) {
        String name = nameTextField.getText();
        String phonenumber = phonenumberTextField.getText();
        String university = universityComboBox.getValue();
        String tag = labelTextField.getText();
        String gender;
        if (maleRadioButton.isSelected()) {
            gender = "male";
        } else {
            gender = "female";
        }

        if(phonenumber.length()== 11)
        {
            Team newteam = new Team(name, phonenumber, university, tag, gender);
        teamArrayList.add(newteam);
        tableView.getItems().clear();
        tableView.getItems().addAll(teamArrayList);

        nameTextField.clear();
        phonenumberTextField.clear();
        universityComboBox.getSelectionModel().clearSelection();
        labelTextField.setText("Choose University");
        }
        else
        {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Selection Error");
            alert.setHeaderText(null);
            alert.setContentText("Please provide correct phone number");
            alert.showAndWait();
        }
    }


    @javafx.fxml.FXML
    public void searchOnAction(ActionEvent actionEvent) {
        String selectedUniversity = searchComboBox.getValue();
        tableView.getItems().clear();

        String selectedgender=maleSearchRadioButton.getText();
        for (Team team : teamArrayList) {
            if (team.getUniversity().equals(selectedUniversity)) {
                if (maleSearchRadioButton.isSelected() && team.getGender().equals("male")) {
                    tableView.getItems().add(team);
                } else if (femaleSearchRadioButton.isSelected() && team.getGender().equals("female")) {
                    tableView.getItems().add(team);
                }
            }
        }
    }

        @javafx.fxml.FXML
        public void universityComboBoxOnAction (ActionEvent actionEvent){

            String uniname = universityComboBox.getValue();
            if (uniname.equals("NSU")) {
                labelTextField.setText("Nsuer");
            } else {
                labelTextField.setText("IUBIAN");


            }


        }
    }


