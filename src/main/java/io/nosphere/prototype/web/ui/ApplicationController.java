package io.nosphere.prototype.web.ui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ApplicationController {
    @RequestMapping(value = "/")
    public ModelAndView index(Model model) {
        model.addAttribute("title", "A Sample App on the REI Tech Stack");
        return new ModelAndView("index", model.asMap());
    }
}
