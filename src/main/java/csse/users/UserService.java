package csse.users;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	
	private List<ApplicationUser> users;
	
	//register
	String register(ApplicationUser user) {
		users=repo.findAll();
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		String d=dateFormat.format(date);
		//System.out.println(d); //2016/11/16 12:08:43
		
		if((!user.getAddress().isEmpty()) && (!user.getEmail().isEmpty()) && (!user.getEmp_ID().isEmpty()) && (!user.getEmp_type().isEmpty()) 
				&& (!user.getEmp_type().isEmpty()) && (!user.getFirstname().isEmpty()) && (!user.getLastname().isEmpty()) && (!user.getPassword().isEmpty()) 
				&& (!user.getPhone().isEmpty()) && (!user.getUsername().isEmpty()) && (user.getRoles()!=null) && (!user.getRoles().isEmpty())) {
		
			String usid=user.getEmp_ID();
			String usemail=user.getEmail();
			String ususn=user.getUsername();		
			
			if(!(users.toString().matches("\\[.*\\b" + usid + "\\b.*]"))) {
				
				if(!(users.toString().matches("\\[.*\\b" + usemail + "\\b.*]"))) {
					
					if(!(users.toString().matches("\\[.*\\b" + ususn + "\\b.*]"))) {
							
						user.setCreatedDate(d);
						user.setlastLogin("00/00/0000 00:00:00");
						user.setModifiedDate(d);
						repo.save(user);
						
						return user.toString();
							
					} else{ return "Username exists";}
				
				} else{ return "Email exists";}			
				
			} else{ return "EmployeeID exists";}
					
		} else{ return "fill all fields";}
	}
	
	//get all users
	List<ApplicationUser> all(){
		return repo.findAll();
	}
	
	//get user by username
	ApplicationUser findByUsername(String username) {
		return repo.findByUsername(username);
	}
	
	//get user by emp_ID
	ApplicationUser findByemp(String ID) {
		users=repo.findAll();
		for(ApplicationUser u: users) {
			if(u.getEmp_ID().equals(ID)) {
				return u;
			}
		}
		return null;	
	}
		
	//reset password through profile
	public String resetPassword(String username, String cpwd, String npwd, String confirm) {
        ApplicationUser u=repo.findByUsername(username);
        
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		String d=dateFormat.format(date);
        
        if(u.getPassword().equals(cpwd)) {
        	if(npwd.equals(confirm)) {
                u.setPassword(npwd);
				u.setModifiedDate(d);
				
                repo.save(u);
                return "Password reset successfully";
            }
        	return "The new passwords don't match";
        }
        return "Current password is incorrect!";
    }
	
	//reset password through forgot passWord
	public String forgotPassword(String username, String np, String confirm) {
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		String d=dateFormat.format(date);
		
		ApplicationUser u= repo.findByUsername(username);
        if(np.equals(confirm)) {
            u.setPassword(np);
			u.setModifiedDate(d);
			
            repo.save(u);
            return "Password reset successfully";
        }
        return "Password reset failed";
    }
	
	//edit user profile
	public ApplicationUser editProfile(String username, String firstname, String lastname, String address,
			String phone, String email) {
		users=repo.findAll();
		
		ApplicationUser user = repo.findByUsername(username);
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		String d=dateFormat.format(date);
		
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setAddress(address);
		user.setPhone(phone);
		
		if(!(users.toString().matches("\\[.*\\b" + email + "\\b.*]"))) {
			user.setEmail(email);
		}		
		
		user.setModifiedDate(d);
		
		repo.save(user);
		return user;
	}
	
	//deactivate user
	public String deactivate(String ID) {
		
		ApplicationUser u=this.findByemp(ID);
		
		try {
			repo.delete(u);
			return "Successfully deactivated";
			
		} catch (Exception NullPointerException) {
			return "User doesn't exist";
		}		
	}	
}
