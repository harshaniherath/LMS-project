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
import model.Borrow;
import tm.BorrowTM;

public class BorrowController {
    @FXML
    private TextField txtBookID;

    @FXML
    private TextField txtIssueDate;

    @FXML
    private TextField txtMemberID;

    @FXML
    private TextField txtReturnDate;

    @FXML
    private TableColumn<BorrowTM, String> colaction;

    @FXML
    private TableColumn<BorrowTM, String> colbookid;

    @FXML
    private TableColumn<BorrowTM, String> colissuedate;

    @FXML
    private TableColumn<BorrowTM, String> colmemberid;

    @FXML
    private TableColumn<BorrowTM, String> colreturndate;

    @FXML
    private TableView<BorrowTM> tblborrow;

    public void initialize() throws ClassNotFoundException, SQLException {
        colmemberid.setCellValueFactory(new PropertyValueFactory<>("MemberID"));
        colbookid.setCellValueFactory(new PropertyValueFactory<>("BookID"));
        colissuedate.setCellValueFactory(new PropertyValueFactory<>("IssueDate"));
        colreturndate.setCellValueFactory(new PropertyValueFactory<>("ReturnDate"));
        colaction.setCellValueFactory(new PropertyValueFactory<>("btnDelete"));

        getAllBorrows();
    }

    public void getAllBorrows() throws ClassNotFoundException, SQLException {

        PreparedStatement statement = DBConnection.getInstance().getConnection()
                .prepareStatement("SELECT * FROM borrow_details");
        ResultSet borrowSet = statement.executeQuery();

        ArrayList<Borrow> borrowList = new ArrayList<Borrow>();

        while (borrowSet.next()) {
            Borrow borrow = new Borrow(
                    borrowSet.getString(1),
                    borrowSet.getString(2),
                    borrowSet.getString(3),
                    borrowSet.getString(4));

            borrowList.add(borrow);
        }

        ObservableList<BorrowTM> borrowTMList = FXCollections.observableArrayList();

        for (Borrow borrow : borrowList) {
            Button button = new Button("Delete");

            BorrowTM borrowTM = new BorrowTM(
                    borrow.getMemberID(),
                    borrow.getBookID(),
                    borrow.getIssueDate(),
                    borrow.getReturnDate(),
                    button);

            borrowTMList.add(borrowTM);
        }

        tblborrow.setItems(borrowTMList);
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String MemberID = txtMemberID.getText();
        String BookID = txtBookID.getText();
        String IssueDate = txtIssueDate.getText();
        String ReturnDate = txtReturnDate.getText();

        Borrow borrow = new Borrow(MemberID, BookID, IssueDate, ReturnDate);
        System.out.println(borrow);

        Connection connection = DBConnection.getInstance().getConnection();

        PreparedStatement statement = connection.prepareStatement("INSERT INTO borrow_details VALUES (?,?,?,?)");
        statement.setObject(2, borrow.getMemberID());
        statement.setObject(3, borrow.getBookID());
        statement.setObject(5, borrow.getIssueDate());
        statement.setObject(6, borrow.getReturnDate());

        int rows = statement.executeUpdate();
        if (rows > 0) {
            System.out.println("Borrow Saved Successfully!!!");
            new Alert(Alert.AlertType.CONFIRMATION, "Borrow Saved Successfully!!!").show();
        } else {
            System.out.println("Error While Saving Borrow");
            new Alert(Alert.AlertType.ERROR, "Error While Saving Borrow").show();
        }

        initialize();
    }

}
