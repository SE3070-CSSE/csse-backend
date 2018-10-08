package csse;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import csse.users.ApplicationUser;
import csse.users.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles(profiles = {"test"})
public class UserServiceTests {
	
	@Autowired
	UserService service;
	
	//ApplicationUser testUser;
	
	private Logger logger = LoggerFactory.getLogger(UserServiceTests.class);
	private List<ApplicationUser> testUserList = new ArrayList<>();
    private ApplicationUser testAdmin;
    private ApplicationUser testUser;
	
    @Before
    public void setUp() throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        TypeReference<ApplicationUser> typeReference = new TypeReference<ApplicationUser>() {};
        InputStream adminInput = TypeReference.class.getResourceAsStream("/json/adminUser.json");
        testAdmin  = mapper.readValue(adminInput, typeReference);
        logger.info("loaded create Admin User");

        InputStream userInput = TypeReference.class.getResourceAsStream("/json/user.json");
        testUser = mapper.readValue(userInput, typeReference);
        logger.info("loaded create User type User");
        
//        InputStream userInput1 = TypeReference.class.getResourceAsStream("/json/testuser3.json");
//        testUser1 = mapper.readValue(userInput1, typeReference);
//        logger.info("loaded create User type User3");
    }
    
    @After
    public void tearDown() {
        service.cleanDatabase();
        logger.info("database renewed");
    }
    
    //register=>pass
    @Test
    public void setsUserIdOnSavePassTest() throws Exception {
        logger.info("Running setsUserIdOnSave");
        String savedUser = service.register(testAdmin);
        String savedUser1 = service.register(testUser);
        Assert.assertNotNull("After creation UserID should not be null", testAdmin.get_id());
    }
    
    //list=>pass
    @Test
    public void getAllUsersPassTest() throws Exception {
        logger.info("Running setsUserIdOnSave");
        String savedUser = service.register(testAdmin);
        String savedUser1 = service.register(testUser);
        String savedAdmin1 = service.register(testUser);

        List<ApplicationUser> list = service.all();
        Assert.assertEquals("user size should be 2", 2, list.size());

    }
   
    
    //get Username => pass
    @Test
    public void getUserByUsernamePassTest() throws Exception {
        logger.info("Running getUserByUsername");
        String savedUser = service.register(testAdmin);
        String savedUser1 = service.register(testUser);
        ApplicationUser user = service.findByUsername("Mathew99");
        
        Assert.assertEquals("user's Address Attribute shud be Negombo", "Negombo", user.getAddress());

    }
    
    //get by empID=> pass
    @Test
    public void getUserByEmpIDPassTest() throws Exception {
        logger.info("Running getUserByEmpID");
        String savedUser = service.register(testAdmin);
        String savedUser1 = service.register(testUser);
        ApplicationUser user = service.findByemp("A5099");        
        Assert.assertEquals("user's Address Attribute shud be Negombo", "Negombo", user.getAddress());

    }
   
   //get by empID=> fail
   @Test(expected=NullPointerException.class)
   public void getUserByEmpIDFailTest() throws Exception {
      logger.info("Running fail getUserByEmpID");
      String savedUser = service.register(testAdmin);
      String savedUser1 = service.register(testUser);
      ApplicationUser user = service.findByemp("A6000");  
      Assert.assertFalse("Negombo"== user.getAddress());
      //expected a null pointer exceptions since empid 6000 doesnt exists and service class returns null

  }
    //password reset=> pass
    @Test
    public void resetPasswordPassTest() throws Exception {
        logger.info("Running pass resetPassword");
        String savedUser = service.register(testAdmin);
        String savedUser1 = service.register(testUser);
        String response = service.resetPassword("Sam99", "Sam99", "sam99", "sam99");       
        Assert.assertEquals("user's pwd is reset", "Password reset successfully", response);
     //   Assert.assertNotEquals(unexpected, actual);

    }

}
