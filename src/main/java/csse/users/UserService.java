package csse.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	
	private final UserDAO repo;
	
	@Autowired
	public UserService(UserDAO repo) {
		this.repo = repo;
	}	
	
	//register
	void register(ApplicationUser user) {
		repo.save(user);
	}
	
	//get all users
	List<ApplicationUser> all(){
		return repo.findAll();
	}
	
	//get user by username
	ApplicationUser findByUsername(String username) {
		return repo.findByUsername(username);
	}
	/*
	//get user by emp_ID
		ApplicationUser findByiID(String ID) {
			return repo.findByID(ID);
	}
	*/
	
	//reset password through profile
	public String resetPassword(String username, String cpwd, String npwd, String confirm) {
        ApplicationUser u=repo.findByUsername(username);
        if(u.getPassword()==cpwd) {
            if(npwd==confirm) {
                u.setPassword(confirm);
                return "Password reset successfully";
            }
        }
        return "Password reset failed";
    }
	
	//reset password through forgot passWord
	public String forgotPassword(String username, String np, String confirm) {
        ApplicationUser u= repo.findByUsername(username);
        if(np==confirm) {
            u.setPassword(np);
            return "Password reset successfully";
        }
        return "Password reset failed";
    }
	
	//edit user profile
	public ApplicationUser editProfile(String username, String firstname, String lastname, String address,
			String phone, String email) {
		ApplicationUser user = repo.findByUsername(username);
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setAddress(address);
		user.setPhone(phone);
		user.setEmail(email);	
		return user;
	}
	/*
	//deactivate user
	public String deactivate(String ID) {
		repo.deleteByEmp_ID(ID);
		return "Successfully deactivated";
	}
	*/
}
