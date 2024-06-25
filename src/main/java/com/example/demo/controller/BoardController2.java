package com.example.demo.controller;

//package com.example.demo.controller;

import com.example.demo.domain.Board2;
import com.example.demo.domain.Item;
import com.example.demo.domain.User;
import com.example.demo.service.BoardService2;
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
public class BoardController2 {
    @Resource
    private BoardService2 boardService2;

    @RequestMapping("/toBoard2")
    public String lsit(Model model){
    	List<Board2> boards = boardService2.getBoardList();
        model.addAttribute("boards",boards);
        return "board/board2"; 
    }
    
    @RequestMapping("/toBoard2Add")
    public String toBoard2Add(){
        return "board/board2Add";
    }
    
    @RequestMapping("/board2Add")
    public String add(Board2 board2){
    	boardService2.save(board2);
    	return "redirect:/list";
    }
    
    @RequestMapping("/board2Read")
    public String toEdit(Model model,String id){
        Board2 board2 = boardService2.findBoardById(id);
        model.addAttribute("board2",board2);
        return "board/board2Read"; 
    }
    
}