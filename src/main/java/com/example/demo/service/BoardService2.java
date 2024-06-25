package com.example.demo.service;

import com.example.demo.domain.Board2;

import java.util.List;


public interface BoardService2 {

    public List<Board2> getBoardList();

    public Board2 findBoardById(String id);

    public void save(Board2 board2);

    public void edit(Board2 board2);

    public void delete(String userId);

}