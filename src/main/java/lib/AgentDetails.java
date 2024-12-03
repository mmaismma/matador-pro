package lib;

public class AgentDetails {

    public String mobile;
    public String first_name;
    public String last_name;
    public String aadhar;
    public String email;
    public String otp;
    public String id;

    public AgentDetails(String mobile, String first_name, String last_name, String aadhar, String email, String otp, String id) {
        this.mobile = mobile;
        this.first_name = first_name;
        this.last_name = last_name;
        this.aadhar = aadhar;
        this.email = email;
        this.otp = otp;
        this.id = id;
    }

    public AgentDetails() {

    }
}
