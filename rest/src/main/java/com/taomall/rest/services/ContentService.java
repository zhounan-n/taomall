package com.taomall.rest.services;

import com.taomall.entities.TbContent;

import java.util.List;

public interface ContentService {
    List<TbContent> getContentList(long contentCid);
}
