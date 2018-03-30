package com.taomall.portal.services;


import com.taomall.portal.entities.ItemInfo;

public interface ItemService {

	ItemInfo getItemById(Long itemId);
	String getItemDescById(Long itemId);
	String getItemParam(Long itemId);
	
}
