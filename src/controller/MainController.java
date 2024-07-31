package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainController {
    @FXML
    private AnchorPane root;

    @FXML
    void btnBookOnAction(ActionEvent event) throws IOException {
        Parent root4 = FXMLLoader.load(this.getClass().getResource("/view/Books.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root4));
        stage.show();
        stage.setTitle("Books Form");
    }

    @FXML
    void btnBorrowOnAction(ActionEvent event) throws IOException {
        Parent root3 = FXMLLoader.load(this.getClass().getResource("/view/Borrow.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root3));
        stage.show();
        stage.setTitle("Borrow Form");
    }

    @FXML
    void btnCategoriesOnAction(ActionEvent event) throws IOException {
        Parent root2 = FXMLLoader.load(this.getClass().getResource("/view/Categories.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root2));
        stage.show();
        stage.setTitle("Categories Form");
    }

    @FXML
    void btnMemberOnAction(ActionEvent event) throws IOException {
        Parent root1 = FXMLLoader.load(this.getClass().getResource("/view/Member.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();
        stage.setTitle("Member Form");
    }
}
