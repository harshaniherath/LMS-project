package tm;

import javafx.scene.control.Button;

public class BorrowTM {
    private String MemberID;
    private String BookID;
    private String IssueDate;
    private String ReturnDate;
    private Button btnDelete;

    public String getMemberID() {
        return MemberID;
    }

    public void setMemberID(String memberID) {
        MemberID = memberID;
    }

    public String getBookID() {
        return BookID;
    }

    public void setBookID(String bookID) {
        BookID = bookID;
    }

    public String getIssueDate() {
        return IssueDate;
    }

    public void setIssueDate(String issueDate) {
        IssueDate = issueDate;
    }

    public String getReturnDate() {
        return ReturnDate;
    }

    public void setReturnDate(String returnDate) {
        ReturnDate = returnDate;
    }

    public Button getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(Button btnDelete) {
        this.btnDelete = btnDelete;
    }

    public BorrowTM(String memberID, String bookID, String issueDate,
            String returnDate, Button btnDelete) {
        MemberID = memberID;
        BookID = bookID;
        IssueDate = issueDate;
        ReturnDate = returnDate;
        this.btnDelete = btnDelete;
    }

    @Override
    public String toString() {
        return "Borrow [  MemberID=" + MemberID + ", BookID=" + BookID +
                ", IssueDate=" + IssueDate + ", ReturnDate=" + ReturnDate + ", btnDelete="
                + btnDelete + "]";
    }

}
