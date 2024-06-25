package com.example.demo.service;

import com.example.demo.domain.Board3;

import java.util.List;


public interface BoardService3 {

    public List<Board3> getBoardList();

    public Board3 findBoardById(String id);

    public void save(Board3 board3);

    public void edit(Board3 board3);

    public void delete(String userId);

}