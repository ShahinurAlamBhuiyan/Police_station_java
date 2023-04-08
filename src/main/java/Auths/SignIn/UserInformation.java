package Auths.SignIn;

public class UserInformation {
    private String username;
    private String password;
    private String designation;
    private String firstName;
    private String lastName;
    private String userFullName;

    private String mobileNumber;
    private String psdId;


    public UserInformation(String username, String password, String designation,
                           String firstName, String lastName, String psdId, String mobileNumber) {
        this.username = username;
        this.password = password;
        this.designation = designation;
        this.userFullName = firstName + " " + lastName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.psdId = psdId;
        this.mobileNumber = mobileNumber;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPsdId() {
        return psdId;
    }

    public void setPsdId(String psdId) {
        this.psdId = psdId;
    }
}
