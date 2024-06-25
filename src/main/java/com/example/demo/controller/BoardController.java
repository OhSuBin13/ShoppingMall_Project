package com.example.demo.controller;

//package com.example.demo.controller;

import com.example.demo.domain.Board;
import com.example.demo.domain.Item;
import com.example.demo.domain.User;
import com.example.demo.service.BoardService;
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
public class BoardController {
    @Resource
    private BoardService boardService;

    @RequestMapping("/toBoard1")
    public String lsit(Model model){
    	List<Board> boards = boardService.getBoardList();
        model.addAttribute("boards",boards);
        return "board/board1"; 
    }
    
    @RequestMapping("/toBoard1Add")
    public String toBoard1Add(){
        return "board/board1Add";
    }
    
    @RequestMapping("/boardAdd")
    public String add(Board board){
    	boardService.save(board);
    	return "redirect:/list";
    }
    
    @RequestMapping("/board1Read")
    public String toEdit(Model model,String id){
        Board board = boardService.findBoardById(id);
        model.addAttribute("board",board);
        return "board/board1Read"; 
    }
    
}