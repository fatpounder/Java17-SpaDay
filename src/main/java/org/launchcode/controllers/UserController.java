package org.launchcode.controllers;

import org.launchcode.data.UserData;
import org.springframework.ui.Model;

import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user")
public class UserController {


    @GetMapping("")
    public String displayAddUserForm(Model model) {

        return "/user/add";
    }

    @PostMapping("")
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
        if(!user.getPassword().equals(verify)) {
            model.addAttribute("username", user.getUsername());
            model.addAttribute("email", user.getEmail());
            model.addAttribute("error", "Yo, your passwords need to be the same!");
            return "redirect:/";
        }
        model.addAttribute("user", user);
        return "/user/add";


    }

}
