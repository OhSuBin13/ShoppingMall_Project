package com.example.demo.domain;

public class Item{
	
    private String itemName;   
    
    private String itemOrigin;
    
    private int itemNumber;
    
    private int itemPrice;
    
    private String itemInformation;
    
    private String itemType;

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemOrigin() {
		return itemOrigin;
	}

	public void setItemOrigin(String itemOrigin) {
		this.itemOrigin = itemOrigin;
	}

	public int getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemInformation() {
		return itemInformation;
	}

	public void setItemInformation(String itemInformation) {
		this.itemInformation = itemInformation;
	}


	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
    
}