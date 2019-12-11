package pl.coderslab.charity.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.transaction.Transactional;

@Controller
@Transactional
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String register (Model model){
        model.addAttribute("newUser", new UserEntity());
        return "register";
    }
    @PostMapping("/register")
    public String createUser(@ModelAttribute (name = "newUser") UserEntity userEntity, BindingResult result){
        userService.saveUser(userEntity);
        return "index";
    }

    @GetMapping("/login")
    public String loginUser(Model model){
        model.addAttribute("user", new UserEntity());
        return "login";
    }
    @PostMapping("/login")
    public String login(@ModelAttribute (name = "user") UserEntity userEntity, BindingResult result){
        return "form";
    }
    @GetMapping("/failureLogin")
    public String failureLogin(){
        return "failureLogin";
    }
    @PostMapping("/failureLogin")
    public String failure(){
        return "failureLogin";
    }
    @GetMapping("/logout")
    public String logout(){
        return "logout";
    }

}
