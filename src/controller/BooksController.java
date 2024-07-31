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
import javafx.scene.layout.AnchorPane;
import model.Books;
import tm.BooksTM;

public class BooksController {

    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtAuthor;

    @FXML
    private TextField txtAvailabaleCopies;

    @FXML
    private TextField txtBookID;

    @FXML
    private TextField txtCategoryID;

    @FXML
    private TextField txtBookName;

    @FXML
    private TableColumn<BooksTM, String> colaction;

    @FXML
    private TableColumn<BooksTM, String> colauthor;

    @FXML
    private TableColumn<BooksTM, String> colbookid;

    @FXML
    private TableColumn<BooksTM, String> colbookname;

    @FXML
    private TableColumn<BooksTM, String> colcategoryid;

    @FXML
    private TableColumn<BooksTM, Integer> colcopies;

    @FXML
    private TableView<BooksTM> tblbooks;

    public void initialize() throws ClassNotFoundException, SQLException {
        colbookid.setCellValueFactory(new PropertyValueFactory<>("BookID"));
        colbookname.setCellValueFactory(new PropertyValueFactory<>("BookName"));
        colauthor.setCellValueFactory(new PropertyValueFactory<>("Author"));
        colcategoryid.setCellValueFactory(new PropertyValueFactory<>("CategoryID"));
        colcopies.setCellValueFactory(new PropertyValueFactory<>("Copies"));
        colaction.setCellValueFactory(new PropertyValueFactory<>("btnDelete"));

        getAllBooks();
    }

    public void getAllBooks() throws ClassNotFoundException, SQLException {

        PreparedStatement statement = DBConnection.getInstance().getConnection()
                .prepareStatement("SELECT * FROM books");
        ResultSet bookSet = statement.executeQuery();

        ArrayList<Books> bookList = new ArrayList<Books>();

        while (bookSet.next()) {
            Books books = new Books(
                    bookSet.getString(1),
                    bookSet.getString(2),
                    bookSet.getString(3),
                    bookSet.getString(4),
                    bookSet.getInt(5));

            bookList.add(books);
        }

        ObservableList<BooksTM> booksTMList = FXCollections.observableArrayList();

        for (Books books : bookList) {
            Button button = new Button("Delete");

            BooksTM booksTM = new BooksTM(
                    books.getBookID(),
                    books.getBookName(),
                    books.getAuthor(),
                    books.getCategoryID(),
                    books.getCopies(),
                    button);

            booksTMList.add(booksTM);
        }

        tblbooks.setItems(booksTMList);
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String BookID = txtBookID.getText();
        String BookName = txtBookName.getText();
        String Author = txtAuthor.getText();
        String CategoryID = txtCategoryID.getText();
        int Copies = Integer.parseInt(txtAvailabaleCopies.getText());

        Books books = new Books(BookID, BookName, Author, CategoryID, Copies);
        System.out.println(books);

        Connection connection = DBConnection.getInstance().getConnection();

        PreparedStatement statement = connection.prepareStatement("INSERT INTO books VALUES (?,?,?,?,?)");
        statement.setObject(1, books.getBookID());
        statement.setObject(2, books.getBookName());
        statement.setObject(3, books.getAuthor());
        statement.setObject(5, books.getCategoryID());
        statement.setObject(6, books.getCopies());

        int rows = statement.executeUpdate();
        if (rows > 0) {
            System.out.println("Book Saved Successfully!!!");
            new Alert(Alert.AlertType.CONFIRMATION, "Book Saved Successfully!!!").show();
        } else {
            System.out.println("Error While Saving Book");
            new Alert(Alert.AlertType.ERROR, "Error While Saving Book").show();
        }

        initialize();
    }

}
