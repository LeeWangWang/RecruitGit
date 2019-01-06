/**@FileName: CandidateDaoImpl.java
 * @Description: 
 * @Paclage: dao
 * @Author: ������
 * @Data: 2019��1��3������7:25:19
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
 * @Author: ������
 * @Data: 2019��1��3������7:25:19
 */
public class CandidateDaoImpl implements CandidateDao1 {

	public CandidateDaoImpl() { }
	
	/**
	 * @Methodname: addCandidate
	 * @Description: �����ݿ�������µ���ְ���û�����
	 * @Param: Candidate c ��ְ���û�����
	 * @Return: boolean ���ݿ���Ӳ����ɹ�����true , ʧ�ܷ���false
	 * @Author: ������������֤���ɹ�����
	 * @Time: 2019��1��3������9:09:47
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
	 * @Description: ���ݿ���ɾ����ְ���û�����
	 * @Param: int candidateId ��ְ�ߵı��
	 * @Return: boolean ���ݿ�ɾ�������ɹ�����true , ʧ�ܷ���false
	 * @Author: ������,����֤���ɹ�����
	 * @Time: 2019��1��3������9:09:47
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
	 * @Description: ������ְ�ߵ���������ģ����ѯ���ݿ�
	 * @Param: String name(��ְ������)
	 * @Return:  Candidate , ��ѯ���ݿ�����ɹ����ظö����б� , ���ɹ�����null
	 * @Author: ������
	 * @Time: 2019��1��4������11:00:00
	 */
	public List<Candidate> searchByName(String name) throws Exception {
		List<Candidate> list = new ArrayList<Candidate>();//������ѯ�������
		Connection conn = DBTool.getConnection();//�������ݿ�
		ResultSet rs;//���ݿ����������ݱ�
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
	 * @Description: ������ְ�ߵ��Ա����ģ����ѯ���ݿ�
	 * @Param: String gender(��ְ���Ա�)
	 * @Return: Candidate , ��ѯ���ݿ�����ɹ����ظö����б� , ���ɹ�����null
	 * @Author: ������
	 * @Time: 2019��1��4������11:00:00
	 */
	public List<Candidate> searchByGender(String gender) throws Exception {
		List<Candidate> list = new ArrayList<Candidate>();//������ѯ�������
		Connection conn = DBTool.getConnection();//�������ݿ�
		ResultSet rs;//���ݿ����������ݱ�
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
	 * @Description: ������ְ�ߵĵ�ַ����ģ����ѯ���ݿ�
	 * @Param: String address(��ְ�ߵĵ�ַ)
	 * @Return: Candidate , ��ѯ���ݿ�����ɹ����ظö����б� , ���ɹ�����null
	 * @Author: ������
	 * @Time: 2019��1��4������11:00:00
	 */
	public List<Candidate> searchByAddress(String address) throws Exception {
		List<Candidate> list = new ArrayList<Candidate>();//������ѯ�������
		Connection conn = DBTool.getConnection();//�������ݿ�
		ResultSet rs;//���ݿ����������ݱ�
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
	 * @Description: ������ְ�ߵ�רҵ����ģ����ѯ���ݿ�
	 * @Param: String major(��ְ�ߵ�רҵ)
	 * @Return: Candidate , ��ѯ���ݿ�����ɹ����ظö����б� , ���ɹ�����null
	 * @Author: ������
	 * @Time: 2019��1��4������11:00:00
	 */
	public List<Candidate> searchByMajor(String major) throws Exception {
		List<Candidate> list = new ArrayList<Candidate>();//������ѯ�������
		Connection conn = DBTool.getConnection();//�������ݿ�
		ResultSet rs;//���ݿ����������ݱ�
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
	 * @Description: ������ְ�ߵ�ѧ������ģ����ѯ���ݿ�
	 * @Param: String education(��ְ�ߵ�ѧ��)
	 * @Return: Candidate , ��ѯ���ݿ�����ɹ����ظö����б� , ���ɹ�����null
	 * @Author: ������
	 * @Time: 2019��1��4������11:00:00
	 */
	public List<Candidate> searchByEducation(String education) throws Exception {
		List<Candidate> list = new ArrayList<Candidate>();//������ѯ�������
		Connection conn = DBTool.getConnection();//�������ݿ�
		ResultSet rs;//���ݿ����������ݱ�
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
	 * @Description: ģ����ѯ���ݿ�
	 * @Param: String field , ģ����ѯ , �����ֶ�
	 * @Return: Candidate , ��ѯ���ݿ�����ɹ����ظö����б� , ���ɹ�����null
	 * @Author: ������,δ��֤
	 * @Time: 2019��1��4������9:05:48
	 */
	public List<Candidate> searchAll() throws Exception {
		List<Candidate> list = new ArrayList<Candidate>();//������ѯ�������
		Connection conn = DBTool.getConnection();//�������ݿ�
		ResultSet rs;//���ݿ����������ݱ�
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
	 * @Description: �������ݿ������
	 * @Param: Candidate c , ��Ҫ���µ���ְ���û�����
	 * @Return: Boolean , �������ݿ�����ɹ�����true , ʧ�ܷ���false
	 * @Author: ������,����֤,�ɹ�����
	 * @Time: 2019��1��4������9:05:48
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


