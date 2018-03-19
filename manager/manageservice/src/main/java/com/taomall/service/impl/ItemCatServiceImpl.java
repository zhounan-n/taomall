package com.taomall.service.impl;

import com.taomall.entities.EuTreeNode;
import com.taomall.entities.TbItemCat;
import com.taomall.entities.TbItemCatExample;
import com.taomall.mapper.TbItemCatMapper;
import com.taomall.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhoun on 2018/3/19.
 **/
@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private TbItemCatMapper tbItemCatMapper;

    @Override
    public List<EuTreeNode> listCategories(long parentId) {
        TbItemCatExample tbItemCatExample = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = tbItemCatExample.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        List<TbItemCat> list = tbItemCatMapper.selectByExample(tbItemCatExample);
        List<EuTreeNode> nodeList = new ArrayList<>();
        for (TbItemCat item : list) {
            EuTreeNode node = new EuTreeNode();
            node.setId(item.getId());
            node.setText(item.getName());
            node.setState(item.getIsParent() ? "closed" : "open");
            nodeList.add(node);
        }
        return nodeList;
    }
}
