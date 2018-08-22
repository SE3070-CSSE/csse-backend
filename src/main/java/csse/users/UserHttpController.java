package csse.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserHttpController {

    private final UserService userService;

    @Autowired
    public UserHttpController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/signup")
    public void signUp(@RequestBody ApplicationUser applicationUser) {
        userService.register(applicationUser);
    }

}
