package ru.mirea.carsharing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mirea.carsharing.domain.Car;
import ru.mirea.carsharing.domain.User;
import ru.mirea.carsharing.repo.CarRepo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    CarRepo carRepo;

    @GetMapping
    public String index(@AuthenticationPrincipal User user, Model model) {
        if (user != null) {
            model.addAttribute("user", user.getUsername());
            return "index";
        }
            model.addAttribute("user", "anonymous");
            return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PreAuthorize(value = "hasAnyAuthority('ADMIN', 'USER')")
    @GetMapping("/about")
    public String forUser() {
        return "about";
    }

    @PreAuthorize(value = "hasAnyAuthority('ADMIN')")
    @GetMapping("/foradmin")
    public String forAdmin() {
        return "foradmin";
    }

    @PreAuthorize(value = "hasAnyAuthority('ADMIN', 'USER')")
    @GetMapping("/reserve")
    public String reserve(Map<String, Object> model){
        model.put("cars",carRepo.findAllByReserved(false));
        return "reserve";
    }

    @PreAuthorize(value = "hasAnyAuthority('ADMIN', 'USER')")
    @GetMapping("/car")
    public String reserved(@RequestParam Long id, Model model){
        model.addAttribute("mark",carRepo.findCarsById(id).getMark());
        model.addAttribute("number",carRepo.findCarsById(id).getNumber());
        carRepo.findCarsById(id).setReserved(true);
        carRepo.save(carRepo.findCarsById(id));
        return "car";
    }
}
