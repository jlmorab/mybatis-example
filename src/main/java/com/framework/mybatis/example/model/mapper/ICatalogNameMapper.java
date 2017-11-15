package com.framework.mybatis.example.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.framework.mybatis.example.model.CatalogName;

public interface ICatalogNameMapper {

	public int addCatalogName(CatalogName catalogName);
	public int removeCatalogName(@Param("id") Integer id);
	public int editCatalogName(CatalogName catalogName);
	public List<CatalogName> findCatalogNames(@Param("id") Integer id);
	
}
