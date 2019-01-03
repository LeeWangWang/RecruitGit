/**@FileName: CandidateDaoImpl.java
 * @Description: 
 * @Paclage: dao
 * @Author: ������
 * @Data: 2019��1��3������7:25:19
 */
package dao;

import java.sql.*;
import service.DBTool;
import bean.Candidate;

/**@ClassName: CandidateDaoImpl.java
 * @Description: 
 * @Extends: 
 * @Implements: 
 * @Author: ������
 * @Data: 2019��1��3������7:25:19
 */
public class CandidateDaoImpl implements CandidateDao {
	
	/**
	 * @Methodname: addCandidate
	 * @Description: �����ݿ�������µ���ְ���û�����
	 * @Param: Candidate c ��ְ���û�����
	 * @Return: boolean ���ݿ���Ӳ����Ƿ�ɹ�
	 * @Author: ������������֤���ɹ�����
	 * @Time: 2019��1��3������9:09:47
	 */
	public boolean addCandidate(Candidate c) throws Exception {
		boolean flag = false;
		Connection conn = DBTool.getConnection();
		String sql = "insert into recruit(candidateId,candidateName,candidateGender,candidateAge,candidatePhone,"
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
	 * @Return: boolean ���ݿ�ɾ�������Ƿ�ɹ�
	 * @Author: ������
	 * @Time: 2019��1��3������9:09:47
	 */
	public boolean deleteCandidate(int candidateId) throws Exception {
		boolean flag = false;
		Connection conn = DBTool.getConnection();
		Statement state = conn.createStatement();
		String sql = "delete from recruit where candidateId ="+candidateId;
		int result = state.executeUpdate(sql);
		if(1 == result){
			flag = true;
		}
		state.close();
		return flag;
	}

	public Candidate searchById(int id) throws Exception {
		
		return null;
	}

	public boolean updateCandidate(Candidate c) throws Exception {
		boolean flag = false;
		Connection conn = DBTool.getConnection();
		String sql = "update recruit set candidateId=?,candidateName=?,candidateGender=?,candidateAge=?,candidatePhone=?,"
		+ "candidateIdCard=?,candidateEmail=?,candidateAddress=?,candidateMajor=?,candidateEducationed=?,candidateJobObjective=?," 
		+ "candidateWorkExperience,candidateAccount,candidatePassword=? where candidateId = ?";
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
		if(result == 1) {			
			flag = true;
		}
		state.close();
		return flag;
	}
	
	public static void main(String[] args) throws SQLException {
		Candidate c = new Candidate(22,"������", "��", 20, "15587379525", "341223199711101939",
                "2458581040@qq.com", "����", "�������", "����", "��������", "��������","777","123");
		Connection conn = DBTool.getConnection();
		String sql = "insert into candidate(candidateId,candidateName,candidateGender,candidateAge,candidatePhone,"
				+ "candidateIdCard,candidateEmail,candidateAddress,candidateMajor,candidateEducationed,candidateJobObjective,"
				+ "candidateWorkExperience,candidateAccount,candidatePassword) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
		System.out.println(result);
	}
	
}
