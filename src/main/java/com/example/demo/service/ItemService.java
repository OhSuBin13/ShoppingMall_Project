package com.example.demo.service;

import com.example.demo.domain.Item;

import java.util.List;


public interface ItemService {

    public List<Item> getItemList();

    public Item findItemByName(String itemName);
    
    public Item findItemByType(String type);

    public void save(Item name);

    public void edit(Item name);

    public void delete(String name);

    public List<Item> getTypeAll(String type);

}