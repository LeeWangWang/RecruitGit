/**@FileName: CandidateDaoImpl.java
 * @Description: 
 * @Paclage: dao
 * @Author: 李旺旺
 * @Data: 2019年1月3日下午7:25:19
 */
package dao;

import java.sql.*;
import java.util.*;

import bean.Candidate;
import util.DBTool;

/**@ClassName: CandidateDaoImpl.java
 * @Description: 
 * @Extends: 
 * @Implements: 
 * @Author: 李旺旺
 * @Data: 2019年1月3日下午7:25:19
 */
public class CandidateDaoImpl implements CandidateDao1 {

	public CandidateDaoImpl() { }
	
	/**
	 * @Methodname: addCandidate
	 * @Description: 像数据库里添加新的求职者用户对象
	 * @Param: Candidate c 求职者用户对象
	 * @Return: boolean 数据库添加操作成功返回true , 失败返回false
	 * @Author: 李旺旺，已验证，成功运行
	 * @Time: 2019年1月3日下午9:09:47
	 */
	public boolean addCandidate(Candidate c) throws Exception {
		boolean flag = false;
		Connection conn = DBTool.getConnection();
		String sql = "insert into candidate(candidateId,candidateName,candidateGender,candidateAge,candidatePhone,"
				+ "candidateIdCard,candidateEmail,candidateAddress,candidateMajor,candidateEducationed,candidateJobObjective,"
				+ "candidateWorkExperience,candidateAccount,candidatePassword) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement state = conn.prepareStatement(sql);
		state.setInt(1, c.getCandidateId());
		state.setString(2, c.getCandidateName());
		state.setString(3, c.getCandidateGender());
		state.setInt(4, c.getCandidateAge());
		state.setString(5, c.getCandidatePhone());
		state.setString(6, c.getCandidateIdCard());
		state.setString(7, c.getCandidateEmail());
		state.setString(8, c.getCandidateAddress());
		state.setString(9, c.getCandidateMajor());
		state.setString(10, c.getCandidateEducationed());
		state.setString(11, c.getCandidateJobObjective());
		state.setString(12, c.getCandidateWorkExperience());
		state.setString(13, c.getCandidateAccount());
		state.setString(14, c.getCandidatePassword());
		int result = state.executeUpdate();
		if(1 == result){
			flag = true;
		}
		state.close();
		return flag;
	}
	
	/**
	 * @Methodname: deleteCandidate
	 * @Description: 数据库里删除求职者用户对象
	 * @Param: int candidateId 求职者的编号
	 * @Return: boolean 数据库删除操作成功返回true , 失败返回false
	 * @Author: 李旺旺,已验证，成功运行
	 * @Time: 2019年1月3日下午9:09:47
	 */
	public boolean deleteCandidate(int candidateId) throws Exception {
		boolean flag = false;
		Connection conn = DBTool.getConnection();
		Statement state = conn.createStatement();
		String sql = "delete from candidate where candidateId ="+candidateId;
		int result = state.executeUpdate(sql);
		if(1 == result){
			flag = true;
		}
		state.close();
		return flag;
	}

	/**
	 * @Methodname: searchByName
	 * @Description: 按照求职者的姓名进行模糊查询数据库
	 * @Param: String name(求职者姓名)
	 * @Return:  Candidate , 查询数据库操作成功返回该对象列表 , 不成功返回null
	 * @Author: 李旺旺
	 * @Time: 2019年1月4日上午11:00:00
	 */
	public List<Candidate> searchByName(String name) throws Exception {
		List<Candidate> list = new ArrayList<Candidate>();//创建查询结果对象
		Connection conn = DBTool.getConnection();//连接数据库
		ResultSet rs;//数据库结果集的数据表
		PreparedStatement pst = conn.prepareStatement("select * from candidate where candidateName "
				+ "like ? order by convert(candidateName using GBK)");
		pst.setString(1, "%"+name+"%");
		rs = pst.executeQuery();
		while(rs.next()) {
			Candidate c = new Candidate(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),
					rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),
					rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12));
			list.add(c);
		}
		rs.close();
		pst.close();
		return list;
	}

	/**
	 * @Methodname: searchByGender
	 * @Description: 按照求职者的性别进行模糊查询数据库
	 * @Param: String gender(求职者性别)
	 * @Return: Candidate , 查询数据库操作成功返回该对象列表 , 不成功返回null
	 * @Author: 李旺旺
	 * @Time: 2019年1月4日上午11:00:00
	 */
	public List<Candidate> searchByGender(String gender) throws Exception {
		List<Candidate> list = new ArrayList<Candidate>();//创建查询结果对象
		Connection conn = DBTool.getConnection();//连接数据库
		ResultSet rs;//数据库结果集的数据表
		PreparedStatement pst = conn.prepareStatement("select * from candidate where candidateGender "
				+ "like ? order by convert(candidateGender using GBK)");
		pst.setString(1, "%"+gender+"%");
		rs = pst.executeQuery();
		while(rs.next()) {
			Candidate c = new Candidate(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),
					rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),
					rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12));
			list.add(c);
		}
		rs.close();
		pst.close();
		return list;
	}

	/**
	 * @Methodname: searchByAddress
	 * @Description: 按照求职者的地址进行模糊查询数据库
	 * @Param: String address(求职者的地址)
	 * @Return: Candidate , 查询数据库操作成功返回该对象列表 , 不成功返回null
	 * @Author: 李旺旺
	 * @Time: 2019年1月4日上午11:00:00
	 */
	public List<Candidate> searchByAddress(String address) throws Exception {
		List<Candidate> list = new ArrayList<Candidate>();//创建查询结果对象
		Connection conn = DBTool.getConnection();//连接数据库
		ResultSet rs;//数据库结果集的数据表
		PreparedStatement pst = conn.prepareStatement("select * from candidate where candidateAddress "
				+ "like ? order by convert(candidateAddress using GBK)");
		pst.setString(1, "%"+address+"%");
		rs = pst.executeQuery();
		while(rs.next()) {
			Candidate c = new Candidate(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),
					rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),
					rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12));
			list.add(c);
		}
		rs.close();
		pst.close();
		return list;
	}

	/**
	 * @Methodname: searchByMajor
	 * @Description: 按照求职者的专业进行模糊查询数据库
	 * @Param: String major(求职者的专业)
	 * @Return: Candidate , 查询数据库操作成功返回该对象列表 , 不成功返回null
	 * @Author: 李旺旺
	 * @Time: 2019年1月4日上午11:00:00
	 */
	public List<Candidate> searchByMajor(String major) throws Exception {
		List<Candidate> list = new ArrayList<Candidate>();//创建查询结果对象
		Connection conn = DBTool.getConnection();//连接数据库
		ResultSet rs;//数据库结果集的数据表
		PreparedStatement pst = conn.prepareStatement("select * from candidate where candidateMajor "
				+ "like ? order by convert(candidateMajor using GBK)");
		pst.setString(1, "%"+major+"%");
		rs = pst.executeQuery();
		while(rs.next()) {
			Candidate c = new Candidate(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),
					rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),
					rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12));
			list.add(c);
		}
		rs.close();
		pst.close();
		return list;
	}

	/**
	 * @Methodname: searchByEducation
	 * @Description: 按照求职者的学历进行模糊查询数据库
	 * @Param: String education(求职者的学历)
	 * @Return: Candidate , 查询数据库操作成功返回该对象列表 , 不成功返回null
	 * @Author: 李旺旺
	 * @Time: 2019年1月4日上午11:00:00
	 */
	public List<Candidate> searchByEducation(String education) throws Exception {
		List<Candidate> list = new ArrayList<Candidate>();//创建查询结果对象
		Connection conn = DBTool.getConnection();//连接数据库
		ResultSet rs;//数据库结果集的数据表
		PreparedStatement pst = conn.prepareStatement("select * from candidate where candidateEducationed "
				+ "like ? order by convert(candidateEducationed using GBK)");
		pst.setString(1, "%"+education+"%");
		rs = pst.executeQuery();
		while(rs.next()) {
			Candidate c = new Candidate(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),
					rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),
					rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12));
			list.add(c);
		}
		rs.close();
		pst.close();
		return list;
	}
	
	/**
	 * @Methodname: searchAll
	 * @Description: 模糊查询数据库
	 * @Param: String field , 模糊查询 , 任意字段
	 * @Return: Candidate , 查询数据库操作成功返回该对象列表 , 不成功返回null
	 * @Author: 李旺旺,未验证
	 * @Time: 2019年1月4日上午9:05:48
	 */
	public List<Candidate> searchAll() throws Exception {
		List<Candidate> list = new ArrayList<Candidate>();//创建查询结果对象
		Connection conn = DBTool.getConnection();//连接数据库
		ResultSet rs;//数据库结果集的数据表
		//PreparedStatement pst = conn.prepareStatement("select * from candidate where candidateName like ? order by convert(candidateName using GBK)");
		PreparedStatement pst = conn.prepareStatement("select * from candidate ");
		//pst.setString(1, "%"+field+"%");
		rs = pst.executeQuery();
		while(rs.next()) {
			Candidate c = new Candidate(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),
					rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),
					rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12));
			list.add(c);
		}
		rs.close();
		pst.close();
		return list;
	}

	/**
	 * @Methodname: updateCandidate
	 * @Description: 更新数据库的数据
	 * @Param: Candidate c , 需要更新的求职者用户对象
	 * @Return: Boolean , 更新数据库操作成功返回true , 失败返回false
	 * @Author: 李旺旺,已验证,成功运行
	 * @Time: 2019年1月4日上午9:05:48
	 */
	public boolean updateCandidate(Candidate c) throws Exception {
		boolean flag = false;
		Connection conn = DBTool.getConnection();
		String sql = "update candidate set candidateName=?,candidateGender=?,candidateAge=?,candidatePhone=?,"
				+ "candidateIdCard=?,candidateEmail=?,candidateAddress=?,candidateMajor=?,candidateEducationed=?,candidateJobObjective=?," 
				+ "candidateWorkExperience=?,candidateAccount=?,candidatePassword=? where candidateId = ?";
		PreparedStatement state = conn.prepareStatement(sql);
		state.setString(1, c.getCandidateName());
		state.setString(2, c.getCandidateGender());
		state.setInt(3, c.getCandidateAge());
		state.setString(4, c.getCandidatePhone());
		state.setString(5, c.getCandidateIdCard());
		state.setString(6, c.getCandidateEmail());
		state.setString(7, c.getCandidateAddress());
		state.setString(8, c.getCandidateMajor());
		state.setString(9, c.getCandidateEducationed());
		state.setString(10, c.getCandidateJobObjective());
		state.setString(11, c.getCandidateWorkExperience());
		state.setString(12, c.getCandidateAccount());
		state.setString(13, c.getCandidatePassword());
		state.setInt(14, c.getCandidateId());
		int result = state.executeUpdate();
		if(result == 1) {			
			flag = true;
		}
		state.close();
		return flag;
	}
	
}


