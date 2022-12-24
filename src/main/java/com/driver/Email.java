package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {

        return emailId;
    }

    public String getPassword() {

        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
    if(oldPassword == password){
        boolean phani = check(newPassword);
        if(phani == true){
            password = newPassword;
        }
    }
    }
    public boolean check(String s){
        int n = s.length();
        boolean char1 = false;
        if(n>=8){
            char1 = true;
        }
        boolean upper = false;
        boolean lower = false;
        boolean num = false;
        boolean special = false;
        for(int i=0;i<n;i++){
            if(s.charAt(i)>=65 && s.charAt(i)<=90){
                upper = true;
            }
            if(s.charAt(i)>=97 && s.charAt(i)<=122){
                lower = true;
            }
            if(s.charAt(i)>=48 && s.charAt(i)<=57){
                num = true;
            }
            if((s.charAt(i)>=32 && s.charAt(i)<=47) || (s.charAt(i)>=58 && s.charAt(i)<=64) || (s.charAt(i)>=91 && s.charAt(i)<=96) || (s.charAt(i)>=123 && s.charAt(i)<=126)){
                special = true;
            }
        }
        if(char1 == true && upper == true && lower == true && num == true && special == true){
            return true;
        }
        else
            return false;
    }
}
