package model;

public class Borrow {
    private String MemberID;
    private String BookID;
    private String IssueDate;
    private String ReturnDate;

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

    public Borrow() {
    }

    public Borrow(String memberID, String bookID, String issueDate,
            String returnDate) {

        this.MemberID = memberID;
        this.BookID = bookID;
        this.IssueDate = issueDate;
        this.ReturnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Borrow [ MemberID=" + MemberID + ", BookID=" + BookID +
                ", IssueDate=" + IssueDate + ", ReturnDate=" + ReturnDate + "]";
    }

}
