package com.taomall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taomall.entities.ListResult;
import com.taomall.entities.TbItem;
import com.taomall.entities.TbItemExample;
import com.taomall.mapper.TbItemMapper;
import com.taomall.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhoun on 2018/3/18.
 **/
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper tbItemMapper;

    @Override
    public TbItem getItemById(long id) {
        TbItem tbItem = tbItemMapper.selectByPrimaryKey(id);

        return tbItem;
    }

    @Override
    public ListResult listItem(Integer page, Integer rows) {
        TbItemExample tbItemExample = new TbItemExample();
        PageHelper.startPage(page, rows);
        List<TbItem> list = tbItemMapper.selectByExample(tbItemExample);
        ListResult result = new ListResult();
        result.setRows(list);
        PageInfo<TbItem> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getSize());
        return result;
    }
}
