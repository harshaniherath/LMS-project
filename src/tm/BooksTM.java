package tm;

import javafx.scene.control.Button;

public class BooksTM {
    private String BookID;
    private String BookName;
    private String Author;
    private String CategoryID;
    private int Copies;
    private Button btnDelete;

    public String getBookID() {
        return BookID;
    }

    public void setBookID(String bookID) {
        BookID = bookID;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(String categoryID) {
        CategoryID = categoryID;
    }

    public int getCopies() {
        return Copies;
    }

    public void setCopies(int copies) {
        Copies = copies;
    }

    public Button getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(Button btnDelete) {
        this.btnDelete = btnDelete;
    }

    public BooksTM(String bookID, String bookName, String author, String categoryID, int copies,
            Button btnDelete) {
        this.BookID = bookID;
        this.BookName = bookName;
        this.Author = author;
        this.CategoryID = categoryID;
        this.Copies = copies;
        this.btnDelete = btnDelete;
    }

    @Override
    public String toString() {
        return "BooksTM [BookID=" + BookID + ", BookName=" + BookName + ", Author=" + Author
                + ", CategoryID=" + CategoryID + ", Copies=" + Copies + ", btnDelete=" + btnDelete + "]";
    }

}
