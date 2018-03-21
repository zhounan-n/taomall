package com.taomall.service;

import com.taomall.common.entities.EuTreeNode;
import com.taomall.common.entities.TaotaoResult;

import java.util.List;

public interface ContentCategoryService {

    List<EuTreeNode> getCategoryList(long parentId);
    TaotaoResult insertContentCategory(long parentId, String name);
}
