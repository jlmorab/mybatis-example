package com.framework.mybatis.example.model;

public class CatalogName extends Model {
	
	private static final long serialVersionUID = 1L;
	
	private Integer 	id;
	private String 		description;
	
	public CatalogName() {}

	public CatalogName(Integer id, String description) {
		this.id 			= id;
		this.description 	= description;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	@Override
	public void clear() {
		id 			= null;
		description = null;
	}
}
