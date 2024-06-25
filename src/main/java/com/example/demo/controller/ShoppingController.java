package com.example.demo.controller;

//package com.example.demo.controller;

import com.example.demo.domain.Item;
import com.example.demo.domain.User;
import com.example.demo.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import java.util.List;

@Controller
public class ShoppingController {
	@Resource
    private ItemService ItemService;
    
    @RequestMapping("/typeShopping")
    public String toTypeShopping(Model model){
    	List<Item> items = ItemService.getItemList();
        model.addAttribute("items",items);
        return "shopping/typeShopping";
    }
    
    @RequestMapping("/toItemTypeList")
    public String toEdit(Model model,String type){
        List<Item> items = ItemService.getTypeAll(type);
        model.addAttribute("items",items);
        return "shopping/itemTypeList"; 
    }

    
    
}