package com.brainacad.security.controller;

import com.brainacad.security.utils.WebUtils;
import java.security.Principal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcomePage(Model model) {
        model.addAttribute("title", "Autolight");
        model.addAttribute("message", "Friend, you are on Autolight page!\nYou can see some items below:");
        return "welcomePage";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage (Model model, Principal principal) {

        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);

        return "adminPage";
    }

    @RequestMapping(value = "/signIn", method = RequestMethod.GET)
    public String signInPage(Model model, Principal principal) {

        // After user login successfully.
        String userName = principal.getName();

        System.out.println("User Name: " + userName);

        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);

        return "signInPage";
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {
        return "loginPage";
    }

    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "logoutSuccessfulPage";
    }

    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal) {

        // After user login successfully.
        String userName = principal.getName();

        System.out.println("User Name: " + userName);

        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);

        return "userInfoPage";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {

        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();

            String userInfo = WebUtils.toString(loginedUser);

            model.addAttribute("userInfo", userInfo);

            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!"
                    + "<br> Study JAVA to have access this page and be admin!";
            model.addAttribute("message", message);
        }

        return "403Page";

    }

    @RequestMapping(value = "/d1s", method = RequestMethod.GET)
    public String d1s ( Model model) {
        model.addAttribute("title", "D1S");
        model.addAttribute("description", "saadsada");
        return "d1s";
    }
    @RequestMapping(value = "/d2s", method = RequestMethod.GET)
    public String d2s ( Model model) {
        model.addAttribute("title", "D2S");
        model.addAttribute("description", "saadsada");
        return "d2s";
    }
    @RequestMapping(value = "/d3s", method = RequestMethod.GET)
    public String d3s ( Model model) {
        return "d3s";
    }

    @RequestMapping(value = "/h1", method = RequestMethod.GET)
    public String h1 ( Model model) {
        return "h1";
    }
    @RequestMapping(value = "/h4", method = RequestMethod.GET)
    public String h4 ( Model model) {
        return "h4";
    }
    @RequestMapping(value = "/h7", method = RequestMethod.GET)
    public String h7 ( Model model) {
        return "h7";
    }

}
