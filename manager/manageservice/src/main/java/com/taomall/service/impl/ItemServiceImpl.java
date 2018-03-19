package com.taomall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taomall.entities.*;
import com.taomall.mapper.TbItemDescMapper;
import com.taomall.mapper.TbItemMapper;
import com.taomall.mapper.TbItemParamItemMapper;
import com.taomall.service.ItemService;
import com.taomall.utils.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by zhoun on 2018/3/18.
 **/
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper tbItemMapper;
    @Autowired
    private TbItemDescMapper itemDescMapper;

    @Autowired
    private TbItemParamItemMapper itemParamItemMapper;

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

    @Override
    public TaotaoResult addItem(TbItem item, String desc, String itemParam) throws Exception {
        //item补全
        //生成商品ID
        Long itemId = IDUtils.genItemId();
        item.setId(itemId);
        // '商品状态，1-正常，2-下架，3-删除',
        item.setStatus((byte) 1);
        item.setCreated(new Date());
        item.setUpdated(new Date());
        //插入到数据库
        tbItemMapper.insert(item);
        //添加商品描述信息
        TaotaoResult result = insertItemDesc(itemId, desc);
        if (result.getStatus() != 200) {
            throw new Exception();
        }
        //添加规格参数
        result = insertItemParamItem(itemId, itemParam);
        if (result.getStatus() != 200) {
            throw new Exception();
        }
        return TaotaoResult.ok();
    }

    /**
     * 添加商品描述
     * <p>Title: insertItemDesc</p>
     * <p>Description: </p>
     *
     * @param desc
     */
    private TaotaoResult insertItemDesc(Long itemId, String desc) {
        TbItemDesc itemDesc = new TbItemDesc();
        itemDesc.setItemId(itemId);
        itemDesc.setItemDesc(desc);
        itemDesc.setCreated(new Date());
        itemDesc.setUpdated(new Date());
        itemDescMapper.insert(itemDesc);
        return TaotaoResult.ok();
    }


    /**
     * 添加规格参数
     * <p>Title: insertItemParamItem</p>
     * <p>Description: </p>
     *
     * @param itemId
     * @param itemParam
     * @return
     */
    private TaotaoResult insertItemParamItem(Long itemId, String itemParam) {
        //创建一个pojo
        TbItemParamItem itemParamItem = new TbItemParamItem();
        itemParamItem.setItemId(itemId);
        itemParamItem.setParamData(itemParam);
        itemParamItem.setCreated(new Date());
        itemParamItem.setUpdated(new Date());
        //向表中插入数据
        itemParamItemMapper.insert(itemParamItem);

        return TaotaoResult.ok();

    }

}
