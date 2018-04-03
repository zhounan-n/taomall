package com.taomall.portal.services;


import com.taomall.entities.TbUser;

public interface UserService {

	TbUser getUserByToken(String token);
}
