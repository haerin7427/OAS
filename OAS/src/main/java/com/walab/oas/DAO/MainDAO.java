package com.walab.oas.DAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.walab.oas.DTO.Category;
import com.walab.oas.DTO.Field;
import com.walab.oas.DTO.Form;
import com.walab.oas.DTO.Item;
import com.walab.oas.DTO.Result;
import com.walab.oas.DTO.Result_Content;
import com.walab.oas.DTO.State;

@Repository
public class MainDAO{

	@Autowired
	SqlSession sqlSession;
	
	private static String namespace ="com.walab.oas.mappers.oas_mapper";
	

	public List<Form> formList() {
		return sqlSession.selectList(namespace + ".form_list");
	}
	
	public List<Category> categoryList() {
		return sqlSession.selectList(namespace + ".category_list");
	}
	
	public List<Form> forminfo (int formID) {
		return sqlSession.selectList(namespace + ".formInfo", formID);
	}
	
	public List<Field> fieldList(int formID) {
		return sqlSession.selectList(namespace + ".fieldInfo", formID);
	}
	
	public List<Item> itemList(int fieldID) {
		return sqlSession.selectList(namespace + ".itemInfo", fieldID);
	}
	
	public int getState (int formID) {
		 return sqlSession.selectOne(namespace + ".getStateID", formID);
	}
	
	public int setResult (Result resultInfo) {
		 return sqlSession.insert(namespace + ".createResultID", resultInfo);
	}
	
	public void setContent (Result_Content resultInfo) {
		 sqlSession.insert(namespace + ".inputContent", resultInfo);
	}
}
