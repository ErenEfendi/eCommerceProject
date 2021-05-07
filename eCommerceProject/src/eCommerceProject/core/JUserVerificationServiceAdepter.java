package eCommerceProject.core;

import eCommerceProject.entities.concretes.User;
import eCommerceProject.jUserValid.JUserVerificationService;

public class JUserVerificationServiceAdepter implements InputVerificationService{

	@Override
	public boolean isValid(User user) {
		JUserVerificationService googleUserValid = new JUserVerificationService();
        return googleUserValid.isValid();
	}

}
