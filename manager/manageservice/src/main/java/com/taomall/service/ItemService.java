package com.taomall.service;

import com.taomall.entities.ListResult;
import com.taomall.entities.TbItem;

public interface ItemService {

    TbItem getItemById(long id);

    ListResult listItem(Integer page, Integer rows);

}
