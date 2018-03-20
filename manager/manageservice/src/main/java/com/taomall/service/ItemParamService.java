package com.taomall.service;

import com.taomall.entities.TaotaoResult;
import com.taomall.entities.TbItemParam;

/**
 * Created by zhoun on 2018/3/20.
 **/
public interface ItemParamService {

    TaotaoResult getItemParamByCid(long cid);
    TaotaoResult insertItemParam(TbItemParam itemParam);

}
