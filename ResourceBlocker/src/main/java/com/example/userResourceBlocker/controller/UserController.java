package com.example.userresourceblocker.controller;

import com.example.userresourceblocker.domain.ChangePassword;
import com.example.userresourceblocker.domain.Inventory;
import com.example.userresourceblocker.domain.User;
import com.example.userresourceblocker.service.InventoryService;
import com.example.userresourceblocker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    HttpServletRequest httpServletRequest;

    @Autowired
    UserService userService;

    @Autowired
    private ResourcesService resourcesService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/userHome")
    public ModelAndView getUserHome() {
        ModelAndView modelAndView = new ModelAndView("userHome");
        String userEmail = httpServletRequest.getUserPrincipal().getName();
        User user = userService.getUserDetails(userEmail);
        modelAndView.addObject("displayName", user.getFirstName());
        return modelAndView;
    }


    @RequestMapping(value = "/profile")
    public ModelAndView userProfile() {
        String userEmail = httpServletRequest.getUserPrincipal().getName();
        User user1 = userService.getUserDetails(userEmail);
        ModelAndView modelAndView = new ModelAndView("userHome");
        modelAndView.addObject("displayName", user1.getFirstName());
        modelAndView.addObject("user", user1);
        modelAndView.addObject("profile", "true");
        return modelAndView;
    }

    @RequestMapping(value = "/editProfilePage/{id}")
    public ModelAndView editProfile(@PathVariable("id") Integer id) {
        User user = userService.getUserDetailById(id);
        ModelAndView modelAndView = new ModelAndView("editUserProfilePage");
        modelAndView.addObject("command", user);
        return modelAndView;
    }

    @RequestMapping("/editUser/{id}")
    public ModelAndView editEquipment(@PathVariable("id") Integer id) {
        ModelAndView mav = new ModelAndView("editUserPage");
        User user = userService.getUserDetailById(id);
        mav.addObject("command", user);
        return mav;
    }

    @RequestMapping(value = "/editUser")
    public String editUser(@RequestParam String id, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String userEmail, @RequestParam String userPassword, @RequestParam String mobileNo, @RequestParam String address, Model model) {
        User user = User.builder().id(Integer.parseInt(id)).firstName(firstName).lastName(lastName).userEmail(userEmail).userPassword(passwordEncoder.encode(userPassword)).mobileNo(mobileNo).address(address).role("user").build();
        String authUserEmail = httpServletRequest.getUserPrincipal().getName();
        User authUser = userService.getUserDetails(authUserEmail);
        userService.registerUser(user, true, false);
        if (authUser.getRole().equals("admin"))
            return "redirect:/userDetails";
        else
            return "redirect:/profile";
    }

    @RequestMapping(path = {"/userResources", "/search"})
    public ModelAndView resources(@RequestParam(defaultValue = "") String keyword) {
        ModelAndView modelAndView = new ModelAndView("userHome");
        List<Resources> equipmentList = new ArrayList<>();
        if (ObjectUtils.isEmpty(keyword)) {
            equipmentList = ResourcesService.getAllEquipments();
        } else {
            equipmentList = userService.getEquipmentsBySearch(keyword);
        }
        String userEmail = httpServletRequest.getUserPrincipal().getName();
        User user = userService.getUserDetails(userEmail);
        modelAndView.addObject("displayName", user.getFirstName());
        modelAndView.addObject("equipments", equipmentList);
        modelAndView.addObject("resources", "true");
        return modelAndView;
    }

    @RequestMapping("/sendRequest/{id}")
    public String sendRequest(@PathVariable("id") Integer id) {
        String userEmail = httpServletRequest.getUserPrincipal().getName();
        userService.sendRequest(userEmail, id);
        return "redirect:/userResources";
    }

    @RequestMapping(value = "/changePasswordPage/{id}")
    public ModelAndView changePasswordPage(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView("changePasswordPage");
        ChangePassword changePassword = ChangePassword.builder().id(id).build();
        modelAndView.addObject("command", changePassword);
        return modelAndView;
    }

    @RequestMapping(value = "/changePassword")
    public String changePassword(@RequestParam Integer id, @RequestParam String oldPassword, @RequestParam String newPassword) {
        User user = userService.getUserDetailById(id);
        boolean isPasswordTrue = passwordEncoder.matches(oldPassword, user.getUserPassword());
        if (isPasswordTrue) {
            user.setUserPassword(passwordEncoder.encode(newPassword));
            userService.registerUser(user, true, true);
        }
        return "redirect:/adminHome";
    }
}
