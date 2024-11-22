package lib;

public class UserDetails {

    public String mobile;
    public String first_name;
    public String last_name;
    public String gender;
    public String email;
    public String dob;
    public String otp;
    public String user_id;

    public UserDetails(String mobile, String first_name, String last_name, String gender, String email, String dob, String otp, String user_id) {
        this.mobile = mobile;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.email = email;
        this.dob = dob;
        this.otp = otp;
        this.user_id = user_id;
    }

    public UserDetails() {

    }
}
