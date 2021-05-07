package eCommerceProject.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import eCommerceProject.dataAccess.abstracts.UserDaoService;
import eCommerceProject.entities.concretes.User;

public class UserDao implements UserDaoService  {

	List<User> users = new ArrayList<>();
	
	@Override
	public void add(User user) {
		users.add(user);
		System.out.println(user.getFirstname() + " " + user.getLastname().toUpperCase() + " isimli kullanýcý kayýt edildi.");
	}

	@Override
	public boolean emailCheck(User user) {
		 for (User dodolar : users)
			if (dodolar.getEmail() == user.getEmail()) {
			 return false;
			 }
			 return true;
	}

	@Override
	public boolean loginByCheck(String email, String password) {
		for (User user : users) {
            if (user.getEmail() == email && user.getPassword() == password)
             return true;
             }
			 return false;
			 }

}