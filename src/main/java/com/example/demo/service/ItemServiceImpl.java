package com.example.demo.service;


import com.example.demo.domain.Item;
import com.example.demo.repository.ItemMapper;
import com.example.demo.repository.ItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;
@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemMapper itemMapper;
    
    @Override
    public List<Item> getItemList() {
        List<Item> items =  itemMapper.findAll();
        return items;
    }
    
    public List<Item> getTypeAll(String type){
    	List<Item> items = itemMapper.findTypeAll(type);
    	return items;
    }

    @Override
    public Item findItemByName(String name) {
        return itemMapper.findItemByName(name);
    }
    
    @Override
    public Item findItemByType(String type) {
        return itemMapper.findItemByType(type);
    }

    
	@Override
	public void save(Item item) {
		itemMapper.save(item);
	}

    @Override
    public void edit(Item item) {
        itemMapper.edit(item);
    }

    @Override
    public void delete(String name) {
        itemMapper.delete(name);
    }

}
