package com.dao;

import java.util.List;

public interface IDao<T> {
	
	public void addOne(T obj);
	public void updateOne(T obj);
	public List<T> getAll();
	public T getOneById(int id);
	public void deleteOne(int id);
 	
}
