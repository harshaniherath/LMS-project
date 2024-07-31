package tm;

import javafx.scene.control.Button;

public class CategoriesTM {
    private String CategoryID;
    private String CategoryName;
    private Button btnDelete;

    public String getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(String categoryID) {
        CategoryID = categoryID;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

    public Button getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(Button btnDelete) {
        this.btnDelete = btnDelete;
    }

    public CategoriesTM(String categoryID, String categoryName, Button btnDelete) {
        CategoryID = categoryID;
        CategoryName = categoryName;
        this.btnDelete = btnDelete;
    }

    @Override
    public String toString() {
        return "CategoriesTM [CategoryID=" + CategoryID + ", CategoryName=" + CategoryName + ", btnDelete="
                + btnDelete + "]";
    }

}
