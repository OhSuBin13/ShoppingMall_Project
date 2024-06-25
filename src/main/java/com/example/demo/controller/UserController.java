package com.example.demo.controller;

//package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import java.util.List;

@Controller
public class UserController {
    @Resource
    private UserService userService;
    @RequestMapping("/")
    public String index(){
        return "redirect:/list"; 
    }
    
    @RequestMapping("/list")
    public String lsit(Model model){
        return "user/list"; 
    }
    
    @RequestMapping("/manage")
    public String toManage(Model model){
        List<User> users = userService.getUserList();
        model.addAttribute("users",users);
        return "user/manage"; 
    }
    
    @RequestMapping("/toLogin")
    public String toLogin(Model model){
        
        return "user/userLogin"; 
    }
    
    @RequestMapping("/login")
    public String login(@RequestParam("userId") String userId, @RequestParam("userPw") String userPw, HttpSession session,RedirectAttributes redirectAttr)
    {
    	if(userId != null && !"".equals(userId) && 
    			   userPw != null && !"".equals(userPw)) {
    		User user = userService.findUserByuserId(userId);
    		if(user != null) {
    			if(userPw.equals(user.getUserPw())) {
    				session.setAttribute("SID", userId);
    				session.setAttribute("SLEVEL", user.getUserLevel());
    				session.setAttribute("SNAME", user.getUserName());
    				return "redirect:/list";
    			}   			
    		}
    	}
    	return "user/userLogin"; 
    }
    
    
    @GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/list";
    }
    
    @RequestMapping("/toAdd")
    public String toadd(User user){
        return "user/userAdd";
    }
    @RequestMapping("/add")
    public String add(User user){
    	if(userService.findUserByuserId(user.getUserId())== null) {
    		userService.save(user);
    		return "redirect:/list";
    	}
    	return "user/userAdd";
    }
    @RequestMapping("/toEdit")
    public String toEdit(Model model,Long id){
        User user = userService.findUserById(id);
        model.addAttribute("user",user);
        return "user/userEdit"; 
    }
    
    @RequestMapping("/edit")
    public String edit(User user){
        userService.edit(user);
        return "redirect:/manage";
    }
    
    @RequestMapping("/delete")
    public String delete(Long id){
        userService.delete(id);
        return "redirect:/manage";
    }
}