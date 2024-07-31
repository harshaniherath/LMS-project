package tm;

import javafx.scene.control.Button;

public class MemberTM {
    private String MemberID;
    private String MemberName;
    private String ContactNumber;
    private String Address;
    private Button btnDelete;


    
    public String getMemberID() {
        return MemberID;
    }
    public void setMemberID(String memberID) {
        MemberID = memberID;
    }
    public String getMemberName() {
        return MemberName;
    }
    public void setMemberName(String memberName) {
        MemberName = memberName;
    }
    public String getContactNumber() {
        return ContactNumber;
    }
    public void setContactNumber(String contactNumber) {
        ContactNumber = contactNumber;
    }
    public String getAddress() {
        return Address;
    }
    public void setAddress(String address) {
        Address = address;
    }
    public Button getBtnDelete() {
        return btnDelete;
    }
    public void setBtnDelete(Button btnDelete) {
        this.btnDelete = btnDelete;
    }

    
    public MemberTM(String memberID, String memberName, String contactNumber, String address,
            Button btnDelete) {
        MemberID = memberID;
        MemberName = memberName;
        ContactNumber = contactNumber;
        Address = address;
        this.btnDelete = btnDelete;
    }

    @Override
    public String toString() {
        return "MemberTM [MemberID=" + MemberID + ", MemberName=" + MemberName  + ", ContactNumber="
                + ContactNumber + ", Address=" + Address + ", btnDelete=" + btnDelete + "]";
    }


    

    
}
