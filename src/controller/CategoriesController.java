package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Categories;
import tm.CategoriesTM;

public class CategoriesController {

    @FXML
    private TextField txtCategoryID;

    @FXML
    private TextField txtCategoryName;

    @FXML
    private TableView<CategoriesTM> tblcategories;

    @FXML
    private TableColumn<CategoriesTM, String> colcategoryid;

    @FXML
    private TableColumn<CategoriesTM, String> colcategoryname;

    @FXML
    private TableColumn<CategoriesTM, String> colaction;

    public void initialize() throws ClassNotFoundException, SQLException {
        colcategoryid.setCellValueFactory(new PropertyValueFactory<>("CategoryID"));
        colcategoryname.setCellValueFactory(new PropertyValueFactory<>("CategoryName"));
        colaction.setCellValueFactory(new PropertyValueFactory<>("btnDelete"));

        getAllCategories();
    }

    public void getAllCategories() throws ClassNotFoundException, SQLException {
        PreparedStatement statement = DBConnection.getInstance().getConnection()
                .prepareStatement("SELECT * FROM categories");
        ResultSet categoriesSet = statement.executeQuery();

        ArrayList<Categories> categoriesList = new ArrayList<Categories>();

        while (categoriesSet.next()) {
            Categories categories = new Categories(
                    categoriesSet.getString(1),
                    categoriesSet.getString(2));

            categoriesList.add(categories);
        }

        ObservableList<CategoriesTM> categoriesTMList = FXCollections.observableArrayList();

        for (Categories cater : categoriesList) {
            Button button = new Button("Delete");

            CategoriesTM categoriesTM = new CategoriesTM(
                    cater.getCategoryID(),
                    cater.getCategoryName(),
                    button);

            categoriesTMList.add(categoriesTM);
        }

        tblcategories.setItems(categoriesTMList);
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String CategoryID = txtCategoryID.getText();
        String CategoryName = txtCategoryName.getText();

        Categories categories = new Categories(CategoryID, CategoryName);
        System.out.println(categories);

        Connection connection = DBConnection.getInstance().getConnection();

        PreparedStatement statement = connection.prepareStatement("INSERT INTO categories VALUES (?,?)");
        statement.setObject(1, categories.getCategoryID());
        statement.setObject(2, categories.getCategoryName());

        int rows = statement.executeUpdate();
        if (rows > 0) {
            System.out.println("Category Saved Successfully!!!");
            new Alert(Alert.AlertType.CONFIRMATION, "Category Saved Successfully!!!").show();
        } else {
            System.out.println("Error While Saving Category");
            new Alert(Alert.AlertType.ERROR, "Error While Saving Category").show();
        }

        initialize();
    }

}
