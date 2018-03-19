package com.taomall.service;

import com.taomall.entities.EuTreeNode;
import com.taomall.entities.TbItemCat;

import java.util.List;

public interface ItemCatService {

    List<EuTreeNode> listCategories(long parentId);
}
