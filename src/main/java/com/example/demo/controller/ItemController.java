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
public class ItemController {
    @Resource
    private ItemService ItemService;
    
    @RequestMapping("/itemManage")
    public String lsit(Model model){
        List<Item> items = ItemService.getItemList();
        model.addAttribute("items",items);
        return "item/itemManage"; 
    }
    
    @RequestMapping("/toItemEdit")
    public String toEdit(Model model,String name){
        Item item = ItemService.findItemByName(name);
        model.addAttribute("item",item);
        return "item/itemEdit"; 
    }
    
    @RequestMapping("/itemEdit")
    public String edit(Item item){
        ItemService.edit(item);
        return "redirect:/itemManage";
    }
    
    @RequestMapping("/itemDelete")
    public String delete(String name){
        ItemService.delete(name);
        return "redirect:/itemManage";
    }
    
    @RequestMapping("/toItemAdd")
    public String toadd(Item item){
        return "item/itemAdd";
    }
    
    @RequestMapping("/itemAdd")
    public String add(Item item){
    	if(ItemService.findItemByName(item.getItemName())== null) {
    		ItemService.save(item);
    		return "redirect:/itemManage";
    	}
    	return "item/itemAdd";
    }
    
    
}