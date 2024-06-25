package com.example.demo.service;


import com.example.demo.domain.Board;
import com.example.demo.repository.BoardMapper;
import com.example.demo.repository.ItemMapper;
import com.example.demo.repository.ItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
    
    @Override
    public List<Board> getBoardList() {
        List<Board> boards =  boardMapper.findAll();
        return boards;
    }
    
    @Override
    public Board findBoardById(String id) {
        return boardMapper.findBoardById(id);
    }
    
	@Override
	public void save(Board board) {
		boardMapper.save(board);
	}

    @Override
    public void edit(Board board) {
        boardMapper.edit(board);
    }

    @Override
    public void delete(String userId) {
        boardMapper.delete(userId);
    }

}
