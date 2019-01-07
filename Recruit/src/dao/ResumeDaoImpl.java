package dao;

import java.sql.*;
import java.util.*;
import bean.Resume;
import util.DBTool;

public class ResumeDaoImpl implements ResumeDao {

	/**
	 *  ����µļ�����Ϣ
	 */
	public boolean addResume(Resume r) throws Exception {
		boolean flag = false;
		Connection conn = DBTool.getConnection();
		String sql = "insert into resume(candidateId,positionId,isInterview) values(?,?,?)";
		PreparedStatement state = conn.prepareStatement(sql);
		state.setInt(1, r.getCandidateId());
		state.setInt(2, r.getPositionId());
		state.setInt(3, 0);
		int result = state.executeUpdate();
		if(1 == result){
			flag = true;
		}
		state.close();
		return flag;
	}

	/**
	 * @Description: ɾ��ָ����ְ�߱�ŵļ�����Ϣ
	 */
	public boolean deleteByPositionId(int candidateId) throws Exception {
		boolean flag = false;
		Connection conn = DBTool.getConnection();
		Statement state = conn.createStatement();
		String sql = "delete from resume where candidateId =" + candidateId;
		int result = state.executeUpdate(sql);
		if(1 == result){
			flag = true;
		}
		state.close();
		return flag;
	}

	/**
	 * @Description: ��ѯ���м�����Ϣ
	 */
	public List<Resume> searchAll(int companyId) throws Exception {
		List<Resume> list = new ArrayList<Resume>();//������ѯ�������
		Connection conn = DBTool.getConnection();//�������ݿ�
		ResultSet rs;//���ݿ����������ݱ�
		PreparedStatement pst = conn.prepareStatement("select * from candidate where companyId = " + companyId);
		rs = pst.executeQuery();
		while(rs.next()) {
			Resume r = new Resume(rs.getInt(1),rs.getInt(2),rs.getInt(3));
			list.add(r);
		}
		rs.close();
		pst.close();
		return list;
	}

	/**
	 *  ������ְ�ߵı�Ų�ѯ������Ϣ
	 */
	public List<Resume> searchByCandidateId(int searchId) throws Exception {
		List<Resume> list = new ArrayList<Resume>();
		Connection conn = DBTool.getConnection();
		ResultSet rs;
		Statement st = conn.createStatement();		
		rs = st.executeQuery("select *  from resume where candidateId = " + searchId);	
		
		while(rs.next()) {
			int candidateId = rs.getInt(1);
			int positionId = rs.getInt(2);
			short isInterview = rs.getShort(3);
			Resume r = new Resume(candidateId,positionId,isInterview);
			list.add(r);
		}
		rs.close();
		st.close();	
		return list;

	}

	/**
	 *  ����ְλ�ı�Ų�ѯ������Ϣ
	 */
	public List<Resume> searchByPositionId(int searchId) throws Exception {
		List<Resume> list = new ArrayList<Resume>();
		Connection conn = DBTool.getConnection();
		ResultSet rs;
		Statement st = conn.createStatement();		
		rs = st.executeQuery("select *  from resume where positionId = " + searchId);	
		
		while(rs.next()) {
			int candidateId = rs.getInt(1);
			int positionId = rs.getInt(2);
			short isInterview = rs.getShort(3);
			Resume r = new Resume(candidateId,positionId,isInterview);
			list.add(r);
		}
		rs.close();
		st.close();	
		return list;

	}

	/**
	 *  �����Ƿ�¼�ò�ѯ������Ϣ
	 */
	public List<Resume> searchByIsInterview(int companyId, int interview) throws Exception {
		List<Resume> list = new ArrayList<Resume>();//������ѯ�������
		Connection conn = DBTool.getConnection();//�������ݿ�
		ResultSet rs;//���ݿ����������ݱ�
		PreparedStatement pst = conn.prepareStatement("select * from candidate where companyId = " + companyId);
		rs = pst.executeQuery();
		while(rs.next()) {
			if(rs.getInt(3) == interview) {
				Resume r = new Resume(rs.getInt(1),rs.getInt(2),rs.getInt(3));
				list.add(r);
			}
		}
		rs.close();
		pst.close();
		return list;
	}

	/*
	 *  ��˾�������� 
	 */
	@Override
	public boolean dealResume(Resume resume, short isInterview) throws Exception {
		boolean flag = true;
		Connection conn = DBTool.getConnection();
		Statement st = conn.createStatement();
		int positionId = resume.getPositionId();
		int candidateId = resume.getCandidateId();
		st.executeQuery("update position set isInterview = "+isInterview+" where positionId = "+positionId+" and candidateId = "+candidateId);
		st.close();
		DBTool.closeMySql();
		return flag;
	}
}


