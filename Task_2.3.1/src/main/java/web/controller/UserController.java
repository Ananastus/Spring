package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/allUsers")
    public String showAllUsers(Model model){
        List<User> allUsers=userService.getAllUsers();
        model.addAttribute("allUsers",allUsers);
        return "allUsers";
    }

    @RequestMapping("/new")
    public String addNewUser(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "new";
    }

    @RequestMapping("/saveUser")
    public String saveUser(@Valid @ModelAttribute("user")User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()){return"new";}
        else{userService.saveUser(user);
        return "redirect:/allUsers";}
    }

    @RequestMapping("/updateUser")
    public String updateUser(@RequestParam("id")long id, Model model){
        User user = userService.getUser(id);
        model.addAttribute("user",user);
        return "new";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam("id")long id){
        userService.deleteUser(id);
        return "redirect:/allUsers";
    }

}
