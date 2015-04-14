package com.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.entity.Blog;


@Stateless
public class BlogService {

	@PersistenceContext
	EntityManager entityManager;
	
	private boolean status = false;
	
	public boolean saveBlog(){
		Blog blog = new Blog();
		blog.setName("webapps4newbies");
		blog.setUrl("http://webapps4newbies.blogspot.in");
		try {
			entityManager.persist(blog);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return status;
		}
		
	}
	
}
