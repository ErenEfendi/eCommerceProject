package eCommerceProject.core;

import java.util.regex.Pattern;

import eCommerceProject.entities.concretes.User;




public class InputVerification implements InputVerificationService {



    public boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }


    public boolean isValidPassword(String password) {
        if (password == null || password.length() < 6) {
            return false;
        }

        return true;
    }


    public boolean isValidString(String name) {

        if (name == null || name.length() < 2) {
            return false;
        }
        for (char c : name.toCharArray()) {
            if (Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }


    @Override
    public boolean isValid(User user) {
        if(!isValidEmail(user.getEmail())){
            System.out.println("Lütfen geçerli bir email adresi giriniz.");
            return false;

        }

        if(!isValidString(user.getFirstname())){
            System.out.println("Ýsim en az 2 karakterli olmalýdýr.");
            return false;

        }
        if(!isValidString(user.getLastname())){
            System.out.println("Soyad en az 2 karakterli olmalýdýr.");
            return false;

        }
        if(!isValidPassword(user.getPassword())){
            System.out.println("Parola en az 2 karakterli olmalýdýr.");
            return false;

        }return true;

    }

}
