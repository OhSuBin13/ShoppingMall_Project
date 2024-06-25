package com.example.demo.controller;

//package com.example.demo.controller;

import com.example.demo.domain.Board3;
import com.example.demo.domain.Item;
import com.example.demo.domain.User;
import com.example.demo.service.BoardService3;
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
public class BoardController3 {
    @Resource
    private BoardService3 boardService3;

    @RequestMapping("/toBoard3")
    public String lsit(Model model){
    	List<Board3> boards = boardService3.getBoardList();
        model.addAttribute("boards",boards);
        return "board/board3"; 
    }
    
    @RequestMapping("/toBoard3Add")
    public String toBoard3Add(){
        return "board/board3Add";
    }
    
    @RequestMapping("/board3Add")
    public String add(Board3 board3){
    	boardService3.save(board3);
    	return "redirect:/list";
    }
    
    @RequestMapping("/board3Read")
    public String toEdit(Model model,String id){
        Board3 board3 = boardService3.findBoardById(id);
        model.addAttribute("board3",board3);
        return "board/board3Read"; 
    }
    
}