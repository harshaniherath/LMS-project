package model;

public class Categories {
    private String CategoryID;
    private String CategoryName;

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

    public Categories(String categoryID, String categoryName) {
        this.CategoryID = categoryID;
        this.CategoryName = categoryName;
    }

    public Categories() {
    }

    @Override
    public String toString() {
        return "Categories [CategoryID=" + CategoryID + ", CategoryName=" + CategoryName + "]";
    }

}
