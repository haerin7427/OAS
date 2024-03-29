package com.walab.oas.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.walab.oas.DTO.Category;
import com.walab.oas.DTO.Field;
import com.walab.oas.DTO.Form;
import com.walab.oas.DTO.Item;
import com.walab.oas.DTO.Result;
import com.walab.oas.DTO.Result_Content;
import com.walab.oas.DTO.SearchCriteria;
import com.walab.oas.DTO.State;
import com.walab.oas.DTO.User;
import com.walab.oas.DTO.ReadResult;

@Repository
public class AdminDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	private static String namespace ="com.walab.oas.mappers.oas_mapper";
	
	public List<Result> submitterList(SearchCriteria cri) {

		System.out.println("heckpage: "+cri.getSearchType()+","+cri.getKeyword());
		return sqlSession.selectList(namespace + ".submitterList",cri);
	}
	
	public int countSubmitter(String searchType, String keyword,int form_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchType", searchType);
		map.put("keyword", keyword);
		map.put("form_id", form_id);
		return sqlSession.selectOne("countSubmitter", map);
	}
	
	public List<State> stateList(int form_id) {
		return sqlSession.selectList(namespace + ".stateList",form_id);
	}

	public void stateUpdate(Map<String, Object> paramMap) {
		sqlSession.update(namespace + ".stateUpdate",paramMap);
	}
	
	public int createForm(Form form) throws Exception{
		return sqlSession.insert(namespace + ".formCreate", form);
	}
	public void createState(State state) throws Exception{
		 sqlSession.insert(namespace + ".stateCreate", state);
	}
	public void deleteDefaultState() {
		sqlSession.delete(namespace + ".deleteDefaultState");
	}
	
	public int createField(Field field) throws Exception{
		return sqlSession.insert(namespace+ ".fieldCreate", field);
	}
	
	public int createItem(Item item) throws Exception{
		return sqlSession.insert(namespace+ ".itemCreate", item);
	}
	
	public int getFormId(String link) throws Exception{
		return sqlSession.selectOne(namespace +".getFormId", link);
	}
	
	public int getFieldId(String key) throws Exception{
		return sqlSession.selectOne(namespace +".getFieldId", key);
	}
	
	public int linkDupCheck(String link) {
		return sqlSession.selectOne(namespace +".linkDupCheck", link);
	}
	
	public String getLink(int id) {
		return sqlSession.selectOne(namespace +".getLink", id);
	}
	public String getFormName(int id) {
		return sqlSession.selectOne(namespace +".getFormName", id);
	}
		
	public int addCategory (Category cg) throws Exception{
		System.out.println("im here");
		return sqlSession.insert(namespace + ".add_Category", cg);
	}
	

	//admin Form update 기능
	public Form formInfo(int form_id) {
		return sqlSession.selectOne(namespace + ".formDetailInfo",form_id);
	}
	public List<Field> formDetailField(int form_id) {
		return sqlSession.selectList(namespace + ".formDetailField",form_id);
	}
	public List<Item> formDetailItem(int field_id) {
		return sqlSession.selectList(namespace + ".formDetailItem",field_id);
	}
	public void modifyForm(Form form) {
		sqlSession.update(namespace + ".modifyForm",form);
	}
	public void modifyField(Field field) {
		sqlSession.update(namespace + ".modifyField",field);
	}
	public void modifyItem(Item item) {
		sqlSession.update(namespace + ".modifyItem",item);
	}

// 	public List<ReadResult> getReadList(int result_id){	
// 		return sqlSession.selectList(namespace+".getReadList",result_id);		
// 	}
	
	public List<ReadResult> getReadList(HashMap<String ,Integer > result_form_id){
		return sqlSession.selectList(namespace+".getReadList",result_form_id);	
	}
	
	public List<Category> getCategoryName(int form_id){		
		return sqlSession.selectList(namespace+".getCategoryName", form_id);		
	}
	
	public String getCategoryName_one(int id){	
		return sqlSession.selectOne(namespace+".getCategoryName_one", id);		
	}
	
	public List<Result> getDate(int result_id){		
		return sqlSession.selectList(namespace+".getDate", result_id);		
	}
	
	public int IsCategoryDeleted(int form_id) {
		return sqlSession.selectOne(namespace +".IsCategoryDeleted", form_id);
	}
	
	public User getUserInfobyId(int id) {
		return sqlSession.selectOne(namespace+".getUserInfobyId", id);
	}
	
	public String getStateofUser(int user_id, int form_id) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("user_id", user_id);
		map.put("form_id", form_id);
		return sqlSession.selectOne(namespace+".getStateofUser", map);
	}
	
	public List<Result> getExcelResult(int id){
		return sqlSession.selectList(namespace+".excelResult", id);
	}
	
	public List<Result_Content> getExcelResultContent(int id){
		return sqlSession.selectList(namespace+".excelResultContent", id);
	}
	
	public int resultCount(int form_id) throws Exception{
		return sqlSession.selectOne(namespace+ ".resultCount", form_id);
	}
	
	//선택한 form 삭제
	public void deleteForm(int formID) throws Exception {
		sqlSession.delete(namespace + ".deleteForm",formID);
	}
	
	public int getAvailable(int form_id) throws Exception{
		return sqlSession.selectOne(namespace+ ".getAvailable", form_id);
	}
	
	public int getUserEdit(int form_id) throws Exception{
		return sqlSession.selectOne(namespace+ ".getUserEdit", form_id);
	}
	
	public void changeAvailable(int form_id,int isAvailable)throws Exception{
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("form_id", form_id);
		map.put("isAvailable", isAvailable);
		sqlSession.update(namespace+ ".changeAvailable", map);
	}
	
	public void changeUserEdit(int form_id,int isUserEdit)throws Exception{
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("form_id", form_id);
		map.put("isUserEdit", isUserEdit);
		sqlSession.update(namespace+ ".changeUserEdit", map);
	}
	
	public int getResultId(int form_id,int user_id) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("form_id", form_id);
		map.put("user_id", user_id);
		System.out.println(map);
		return sqlSession.selectOne(namespace +".getResultId", map);
	}
	public int getResultIdCount(int form_id,int user_id) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("form_id", form_id);
		map.put("user_id", user_id);
		System.out.println(map);
		return sqlSession.selectOne(namespace +".getResultIdCount", map);
	}
	
	public int deleteField(int field_id) {
		return sqlSession.update(namespace+".deleteField",field_id);
	}
	
	public int deleteItem(int item_id) {
		return sqlSession.update(namespace+".deleteItem",item_id);
	}
	// 첨부파일 다운로드
	public Map<String, Object> selectFileInfo(Map<String, Object> map) throws Exception {
		return sqlSession.selectOne(namespace + ".selectFileInfo", map);
	}
	
	public int deleteCategory(String categoryName) {
		return sqlSession.delete(namespace+".deleteCategory",categoryName);
	}
	
	public int createCategory(String name) {
		return sqlSession.insert(namespace+".createCategory",name);
	}
}
