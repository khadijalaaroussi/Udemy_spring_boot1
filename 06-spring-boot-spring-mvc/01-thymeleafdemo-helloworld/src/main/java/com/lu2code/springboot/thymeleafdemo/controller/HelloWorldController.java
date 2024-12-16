package com.lu2code.springboot.thymeleafdemo.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
@GetMapping("/showForm")
public String showForm(){
return "helloworld-form";   }

    @RequestMapping ("/processForm")
    public String processForm(){
        return "helloworld";   }

    // need a controller to read form data
    //add data to the model
    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model){
    //read the request parameter from the html form
        String theName=request.getParameter("studentName");
        //convert the data to all capitals
        theName=theName.toUpperCase();

        // create the message
        String result ="yo!"+theName;
        //add message to the model
        model.addAttribute("message",result);
    return "helloworld";
    }



    @PostMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String theName,Model model){

        //convert the data to all capitals
        theName=theName.toUpperCase();

        // create the message
        String result ="Hey my friend!"+theName;
        //add message to the model
        model.addAttribute("message",result);
        return "helloworld";
    }


}
