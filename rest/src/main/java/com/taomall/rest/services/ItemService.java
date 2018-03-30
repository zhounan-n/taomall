package com.taomall.rest.services;

import com.taomall.common.entities.TaotaoResult;

public interface ItemService {

    TaotaoResult getItemBaseInfo(long itemId);
    TaotaoResult getItemDesc(long itemId);
    TaotaoResult getItemParam(long itemId);

}
