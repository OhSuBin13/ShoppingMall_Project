package com.example.demo.service;


import com.example.demo.domain.Board3;
import com.example.demo.repository.BoardMapper3;
import com.example.demo.repository.ItemMapper;
import com.example.demo.repository.ItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BoardServiceImpl3 implements BoardService3 {
	
	@Autowired
	private BoardMapper3 boardMapper3;
    
    @Override
    public List<Board3> getBoardList() {
        List<Board3> boards =  boardMapper3.findAll();
        return boards;
    }
    
    @Override
    public Board3 findBoardById(String id) {
        return boardMapper3.findBoardById(id);
    }
    
	@Override
	public void save(Board3 board) {
		boardMapper3.save(board);
	}

    @Override
    public void edit(Board3 board) {
        boardMapper3.edit(board);
    }

    @Override
    public void delete(String userId) {
        boardMapper3.delete(userId);
    }

}
