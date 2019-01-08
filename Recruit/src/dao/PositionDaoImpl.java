package dao;

/**@FileName:PositionDaoImpl.java
 * @Description:
 * @Author:������Sio
 * @Date:2019��1��3��
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import bean.Company;
import bean.Position;
import service.CompanyService;
import service.CompanyServiceImpl;
import service.PositionServImpl;
import service.PositionService;
import util.DBTool;

/**@Description:
 * @FileName:PositionDaoImpl.java
 * @Author:������Sio
 * @Date:2019��1��3��
 */
public class PositionDaoImpl implements PositionDao{

	/**
	 * ����ȫ��ְλ
	 */
	public List<Position> searchAll() throws Exception {
		List<Position> list = new ArrayList<Position>();
		int idMax;
		Connection conn = DBTool.getConnection();
		ResultSet rs;
		Statement st = conn.createStatement();		
		rs = st.executeQuery("select *  from position");	

		while(rs.next()) {
			int positionId = rs.getInt(1);
			String positionName = rs.getString(2);
			int companyId = rs.getInt(3);
			String positionIntroduction = rs.getString(4);
			String positionDiploma = rs.getString(5);
			String positionLightspot = rs.getString(6);
			//List<String> listPhones = new ArrayList<String>(Arrays.asList(phones.split(";")));
			Position p = new Position(positionId,positionName,companyId,positionIntroduction,positionDiploma,positionLightspot);
			list.add(p);
		}
		rs.close();
		st.close();	
		DBTool.closeConnection();
		return list;
	}
	/**
	 * ͨ����˾ID����ְλ
	 */
	public List<Position> searchByCompanyId(int searchId) throws Exception{
		List<Position> list = new ArrayList<Position>();

		Connection conn = DBTool.getConnection();
		ResultSet rs,rs2;
		Statement st = conn.createStatement();		
		rs = st.executeQuery("select *  from position where companyId = "+ searchId);	

		while(rs.next()) {
			int positionId = rs.getInt(1);
			String positionName = rs.getString(2);
			int companyId = rs.getInt(3);
			String positionIntroduction = rs.getString(4);
			String positionDiploma = rs.getString(5);
			String positionLightspot = rs.getString(6);
			Position p = new Position(positionId,positionName,companyId,positionIntroduction,positionDiploma,positionLightspot);
			list.add(p);
		}
		rs.close();
		st.close();		
		DBTool.closeConnection();
		return list;
	}
	/**
	 * @Description:ͨ��ְλ��Ų���ְλ
	 * @FileName:PositionDaoImpl.java
	 * @Author:������Sio
	 * @Date:2019��1��3��
	 */
	public Position searchByPositionId(int positionId) throws Exception {
		Connection conn = DBTool.getConnection();
		ResultSet rs;
		Statement st = conn.createStatement();
		
		rs = st.executeQuery("select *  from position where positionId = "+ positionId);
		if(rs.next()) {
			String positionName = rs.getString(2);
			int companyId = rs.getInt(3);
			String positionIntroduction = rs.getString(4);
			String positionDiploma = rs.getString(5);
			String positionLightspot = rs.getString(6);
			Position position = new Position(positionId,positionName,companyId,positionIntroduction,positionDiploma,positionLightspot);
			DBTool.closeConnection();
			return position;
		}else {
			return null;
		}
		
	}
	/**
	 * ��˾����ְλ
	 */
	public void addPosition(Position position) throws Exception {
		int idMax = 0;
		String positionName = position.getPositionName();
		int companyId = position.getCompanyId();
		String positionIntroduction = position.getPositionIntroduction();
		String positionDiploma = position.getPositionDiploma();
		String positionLightspot = position.getPositionLightspot();
		Connection conn = DBTool.getConnection();
		String sql = "insert into position values(?,?,?,?,?,?)";
		PreparedStatement st = conn.prepareStatement(sql);
		ResultSet rs2;
		String sql2 = "select * from position";
		PreparedStatement st2 = conn.prepareStatement(sql2);
		rs2 = st2.executeQuery();
		while(rs2.next()) {
			idMax = rs2.getInt(1);
		}
		idMax++;
		
		st.setInt(1, idMax);
		st.setString(2, positionName);
		st.setInt(3, companyId);
		st.setString(4, positionIntroduction);
		st.setString(5, positionDiploma);
		st.setString(6, positionLightspot);
		int result = st.executeUpdate();
		st.close();
		DBTool.closeConnection();
	}
	/**
	 * ��˾ɾ����Ƹ��Ϣ
	 */
	public void deletePosition(int positionId) throws Exception {
		//int positionId = position.getPositionId();
		Connection conn = DBTool.getConnection();
		Statement st = conn.createStatement();
		st.executeQuery("delete * frome position where positionId = "+positionId);
		st.close();
		DBTool.closeConnection();
	}
	/**
	 * ��˾�޸���Ƹ��Ϣ
	 */
	public void updatePosition(Position position) throws Exception {
		int positionId = position.getPositionId();
		String positionName = position.getPositionName();
		int companyId = position.getCompanyId();
		String positionIntroduction = position.getPositionIntroduction();
		String positionDiploma = position.getPositionDiploma();
		String positionLightspot = position.getPositionLightspot();
		//List<Position> list = new ArrayList<Position>();
		Connection conn = DBTool.getConnection();
		//ResultSet rs;
		Statement st = conn.createStatement();		
		//st.executeQuery("insert into position (positionName,companyId,positionIntroduction,positionDiploma,positionLightspot) values ('"+positionName+"','"+companyId+"','"+positionIntroduction+"','"+positionDiploma+"','"+positionLightspot+"'");
		//String sql = "update position set positionName = "+positionName+" where positionId = "+positionId;
		st.executeQuery("update position set positionName = "+positionName+" where positionId = "+positionId);
		st.executeQuery("update position set positionIntroduction = "+positionIntroduction+" where positionId = "+positionId);
		st.executeQuery("update position set positionDiploma = "+positionDiploma+" where positionId = "+positionId);
		st.executeQuery("update position set positionLightspot = "+positionLightspot+" where positionId = "+positionId);		
		st.close();
		DBTool.closeConnection();
		
	}

	//ģ����ѯְλ
	public List<Position> searchByPositionName(String PositionName) throws Exception{
		List<Position> list = new ArrayList<Position>();//������ѯ�������
		Connection conn = DBTool.getConnection();//�������ݿ�
		ResultSet rs;//���ݿ����������ݱ�
		PreparedStatement pst = conn.prepareStatement("select * from position where positionName like ? order by convert(positionName using GBK)");
		pst.setString(1, "%" + PositionName + "%");
		rs = pst.executeQuery();
		while(rs.next()) {
			Position c = new Position(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),
					rs.getString(5),rs.getString(6));
			list.add(c);
		}
		rs.close();
		pst.close();
		return list;
	}
	
}

