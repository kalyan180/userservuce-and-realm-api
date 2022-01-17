package com.realm.api.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.realm.api.model.Api;
import com.realm.api.model.Response;

@Repository
public class ApiDaoImpl implements ApiDao{

	private static final String INSERT_API_QUERY="INSERT INTO API_ENTITY(id, name, zip, city, state, type) values (?,?,?,?,?,?)";
	private static final String UPDATE_API_BY_ID_QUERY="UPDATE API_ENTITY SET NAME=? where ID=?";
	private static final String GET_API_QUERY="SELECT * FROM API_ENTITY";
	private static final String DELETE_API_QUERY="DELETE FROM API_ENTITY WHERE ID=?";
	private static final String GET_API_BY_ID_QUERY="SELECT * FROM API_ENTITY WHERE ID=?";
	private static final String GET_USER_BY_ID_QUERY="select  u.id,u.name,u.email,u.mobile,a.zip,a.city,a.type,a.state,u.real_id from user_entity u join api_entity a on u.real_id=a.id and u.id=?;";
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Api createApi(Api api) {
		jdbcTemplate.update(INSERT_API_QUERY, api.getId(),api.getName(),api.getZip(),api.getCity(),api.getState(),api.getType());
		return api;
	}

	@Override
	public Api updateApi(Api api) {
		jdbcTemplate.update(UPDATE_API_BY_ID_QUERY,api.getName(),api.getId());
		return api;
	}

	@Override
	public Api getApi(Integer id) {

        return jdbcTemplate.queryForObject(GET_API_BY_ID_QUERY, new Object[]{id},new BeanPropertyRowMapper<Api>(Api.class));
        		
	}
	
	


	@Override
	public String deleteApiById(Integer id) {
		jdbcTemplate.update(DELETE_API_QUERY, id);
		return null;
	}

	@Override
	public Response getUserDetails(Integer id) {
		return jdbcTemplate.queryForObject(GET_USER_BY_ID_QUERY, new Object[]{id},new BeanPropertyRowMapper<Response>(Response.class));
        
	}

}
