package be.technobel.arlon2021mvc.controller;

import be.technobel.arlon2021mvc.service.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final ServiceUser serviceUser;

    @Autowired
    public HomeController(ServiceUser serviceUser) {
        this.serviceUser = serviceUser;
    }


    @GetMapping(path = {"", "/", "/index"})
    public String indexAction(Model view) {
        view.addAttribute("nom", "Paci");
        view.addAttribute("users", this.serviceUser.findAll());

        return "home/index";
    }

}
