package org.my.example.controller;

import org.my.example.model.User;
import org.my.example.service.RoleService;
import org.my.example.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private UserService userService;
    private RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("")
    public ModelAndView printUser(ModelAndView modelAndView) {
        modelAndView.addObject("userList", userService.findAll());
        modelAndView.setViewName("/allUser");
        return modelAndView;
    }

    @GetMapping(value = "/newUserForm")
    public String addUserForm(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("roleList", roleService.findAll());
        return "/newUser";
    }

    @GetMapping(value = "/updateUserForm")
    public String updateForm(@RequestParam(value = "id") Long id, Model model) {
        model.addAttribute("user", userService.findUserById(id));
        model.addAttribute("roleList", roleService.findAll());
        return "/update";
    }

    @PostMapping(value = "/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:";
    }

    @PostMapping(value = "/update")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:";
    }

    @GetMapping(value = "/delete")
    public String delete(@RequestParam(value = "id") Long id) {
        userService.deleteUserById(id);
        return "redirect:";
    }
}
