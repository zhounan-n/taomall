package com.taomall.portal.entities;


import com.taomall.entities.TbItem;

public class ItemInfo extends TbItem {

	public String[] getImages() {
		String image = getImage();
		if (image != null) {
			String[] images = image.split(",");
			return images;
		}
		return null;
	}
}
