package eCommerceProject.business.concretes;

import eCommerceProject.business.abstracts.UserService;
import eCommerceProject.core.InputVerificationService;
import eCommerceProject.core.ValidatorService;
import eCommerceProject.dataAccess.abstracts.UserDaoService;
import eCommerceProject.entities.concretes.User;

public class UserManager implements UserService {

    InputVerificationService memberInformationValidation;
    UserDaoService userDaoService;
    ValidatorService validatorService;

    public UserManager(InputVerificationService memberInformationValidation,
                       UserDaoService userDaoService, ValidatorService validatorService) {
        this.memberInformationValidation = memberInformationValidation;
        this.userDaoService = userDaoService;
        this.validatorService = validatorService;

    }


    @Override
    public void register(User user) {
        if (!memberInformationValidation.isValid(user)) {
            System.out.println("Kullanýcý bilgileri yanlýþ. Kayýt iþlemi BAÞARISIZ!");
        } else if (!userDaoService.emailCheck(user)) {
            System.out.println("Bu email adresi kullanýlýyor " + user.getEmail() + "\n" + "Kayýt iþlemi BAÞARISIZ!");

        } else {
            userDaoService.add(user);
            validatorService.sendVarificationMail();
        }
    }

    @Override
    public void login(String email, String password) {
        if (userDaoService.loginByCheck(email, password)) {
            System.out.println("Giriþ Baþarýlý.");
        } else {
            System.out.println("Lütfen kullanýcý adý ve þifre giriniz. Giriþ BAÞARISIZ!");
        }
    }
}
