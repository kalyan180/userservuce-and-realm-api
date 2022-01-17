package com.realm.api.dao;

import java.util.List;

import com.realm.api.model.Api;
import com.realm.api.model.Response;

public interface ApiDao  {
	Api createApi(Api api);
	Api updateApi(Api api);
	Api getApi(Integer id);
	String deleteApiById(Integer id);
	
	Response getUserDetails(Integer id);


}
