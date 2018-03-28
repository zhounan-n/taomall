package com.taomall.rest.services;

import com.taomall.common.entities.TaotaoResult;

public interface RedisService {

    TaotaoResult syncContent(long contentCid);

}
