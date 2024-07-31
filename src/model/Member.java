package model;

public class Member {
    private String MemberID;
    private String MemberName;
    private String ContactNumber;
    private String Address;
    

    public Member(String memberID, String memberName, String contactNumber, String address) {
        this.MemberID = memberID;
        this.MemberName = memberName;
        this.ContactNumber = contactNumber;
        this.Address = address;
    }

    
    public Member() {
    }


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


    @Override
    public String toString() {
        return "Member [MemberID=" + MemberID + ", MemberName=" + MemberName + ",  ContactNumber="
                + ContactNumber + ", Address=" + Address + "]";
    }

    

}
