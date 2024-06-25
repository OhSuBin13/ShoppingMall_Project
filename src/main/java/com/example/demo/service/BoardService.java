package com.example.demo.service;

import com.example.demo.domain.Board;

import java.util.List;


public interface BoardService {

    public List<Board> getBoardList();

    public Board findBoardById(String id);

    public void save(Board board);

    public void edit(Board board);

    public void delete(String userId);

}