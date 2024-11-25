package services;

public class Api {

    public static boolean register(lib.UserDetails userDetails) throws Exception {
        return Register.register(userDetails);
    }

    public static boolean login(String mobile, String otp) throws Exception {
        return Login.login(mobile, otp);
    }

    public static lib.UserDetails getUserDetails(String mobile, String otp) throws Exception {
        return GetUserDetails.getUserDetails(mobile, otp);
    }

    public static boolean editProfile(lib.UserDetails userDetails, String mobile, String otp) throws Exception {
        return EditProfile.editProfile(userDetails, mobile, otp);
    }
}
