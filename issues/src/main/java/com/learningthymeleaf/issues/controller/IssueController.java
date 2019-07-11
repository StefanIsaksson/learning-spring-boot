package com.learningthymeleaf.issues.controller;

import com.learningthymeleaf.issues.model.Issue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IssueController {

    @GetMapping("/")
    public String registerForm(Model model) {
        model.addAttribute("issue", new Issue());
        return "register";
    }

    @PostMapping("/")
    public String registerSubmit(@ModelAttribute Issue issue) {
        return "result";
    }
}
