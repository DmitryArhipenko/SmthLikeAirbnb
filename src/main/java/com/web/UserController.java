package com.web;

import com.model.User;
import com.service.UserService;
import com.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

//    @Autowired
//    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

//        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        userService.save(userForm);

        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {

        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    }

    @RequestMapping(value = {"/admin"}, method = RequestMethod.GET)
    public String admin(Model model) {
        return "admin";
    }

    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    public ModelAndView listUsers(ModelAndView model) throws IOException {

        List<User> userList = userService.listAll();
        model.addObject("listUsers", userList);
        model.setViewName("listUsers");

        return model;
    }

    @RequestMapping(value = "/user/edit", method = RequestMethod.GET)
    public ModelAndView getEditUserForm(@RequestParam long id) {

        return new ModelAndView("/edit_user_form", "current_user", userService.get(id));
    }

    @RequestMapping(value = "/user/edit", method = RequestMethod.PUT)
    public String postEditedUserForm(@ModelAttribute("current_user") User user) {

        userService.update(user);

        return "redirect:/welcome";
    }


    @RequestMapping(value = "/user/delete", method = RequestMethod.DELETE)
    public String deleteUser(@RequestParam long id) {
        userService.delete(id);
        return "redirect:/welcome";
    }
}
