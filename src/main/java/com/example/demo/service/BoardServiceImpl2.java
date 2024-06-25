package com.example.demo.service;


import com.example.demo.domain.Board2;
import com.example.demo.repository.BoardMapper2;
import com.example.demo.repository.ItemMapper;
import com.example.demo.repository.ItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BoardServiceImpl2 implements BoardService2 {
	
	@Autowired
	private BoardMapper2 boardMapper2;
    
    @Override
    public List<Board2> getBoardList() {
        List<Board2> boards =  boardMapper2.findAll();
        return boards;
    }
    
    @Override
    public Board2 findBoardById(String id) {
        return boardMapper2.findBoardById(id);
    }
    
	@Override
	public void save(Board2 board) {
		boardMapper2.save(board);
	}

    @Override
    public void edit(Board2 board) {
        boardMapper2.edit(board);
    }

    @Override
    public void delete(String userId) {
        boardMapper2.delete(userId);
    }

}
