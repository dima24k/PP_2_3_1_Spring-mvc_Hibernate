package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@RequestMapping("/users")
@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAll() );
        return "all";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User() );
        return "new";
    }

    @PostMapping("/new")
    public String createUser(@ModelAttribute("user") User user) {
        userService.newUser(user);
        return "redirect:/users/all";
    }

    @GetMapping("/update")
    public String updateUserGet(@RequestParam(value = "id", required = false) Long id, Model model) {
        model.addAttribute("user", userService.getUser(id) );
        return "update";
    }

    @PostMapping("/update")
    public String updateUserPost(@RequestParam(value="id", required = false) Long id, @ModelAttribute User user) {
        userService.updateUser(user, id);
        return "redirect:/users/all";
    }
}
