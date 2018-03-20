package com.taomall.service;

import com.taomall.common.entities.EuTreeNode;

import java.util.List;

public interface ItemCatService {

    List<EuTreeNode> listCategories(long parentId);
}
