package dao;

import java.sql.*;
import java.util.*;
import util.DBTool;
import bean.*;

public class CompanyDaoImpl implements CompanyDao {

	public List<Company> searchAll() throws Exception {
		List<Company> list = new ArrayList<Company>();
		Connection conn = DBTool.getConnection();
		ResultSet rs;
		Statement st = conn.createStatement();
		rs = st.executeQuery("select * from company");  //把company中的所有数据取出	
		while(rs.next()) {
			int companyId = rs.getInt(1);
			String companyName = rs.getString(2);
			String companyAddress = rs.getString(3);
			String companyType = rs.getString(4);
			String companyLegalPerson = rs.getString(5);
			String companyEmail = rs.getString(6);
			String companyPhone = rs.getString(7);
			String companyCaptial = rs.getString(8);
			String companyAccount = rs.getString(9);
			String companyPassword = rs.getString(10);
			
			Company c = new Company();
			c.setCompanyId(companyId);
			c.setCompanyName(companyName);
			c.setCompanyAddress(companyAddress);
			c.setCompanyType(companyType);
			c.setCompanyLegalPerson(companyLegalPerson);
			c.setCompanyEmail(companyEmail);
			c.setCompanyPhone(companyPhone);
			c.setCompanyCaptial(companyCaptial);
			c.setCompanyAccount(companyAccount);
			c.setCompanyPassword(companyPassword);
			list.add(c);	
		}
		rs.close();
		st.close();	
		return list;

	}

	public void addNewCompany(Company company) throws Exception {
		try {
        	// 获取数据库的连接
    		Connection conn = DBTool.getConnection();
    		// 设置SQL规则，数据由于还不知道先用"？"代替
    		String sql = "insert into company values (?,?,?,?,?,?,?,?,?,?)";
    		//预处理sql语句
    		PreparedStatement presta = conn.prepareStatement(sql);
    		//设置sql语句中的values值
    		int i = 0;
    		i=Integer.valueOf(company.getCompanyId()).intValue();
    		presta.setInt(1, i);
    		presta.setString(2, company.getCompanyName());
    		presta.setString(3, company.getCompanyAddress());
    		presta.setString(4, company.getCompanyType());
    		presta.setString(5, company.getCompanyLegalPerson());
    		presta.setString(6, company.getCompanyEmail());
    		presta.setString(7, company.getCompanyPhone());
    		presta.setString(8, company.getCompanyCaptial());
    		presta.setString(9, company.getCompanyAccount());
    		presta.setString(10, company.getCompanyPassword());
    		// 执行SQL语句，实现数据添加
    		presta.executeUpdate();
        }catch(SQLException e) {
        	e.printStackTrace();
        }
	}
	
	public static void main(String[] args)  {
		CompanyDaoImpl a = new CompanyDaoImpl();
		Company newC = new Company(7,"巨人集团","上海 ","互联网综合服务","史玉柱","777","777","80万","777","123");
		try{
			a.addNewCompany(newC);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public List<Company> searchByCompanyAddress(String address) throws Exception{
		List<Company> list = new ArrayList<Company>();//创建查询结果对象
		Connection conn = DBTool.getConnection();//连接数据库
		ResultSet rs;//数据库结果集的数据表
		PreparedStatement pst = conn.prepareStatement("select * from company where companyAddress like ? order by convert(companyAddress using GBK)");
		pst.setString(1, "%"+address+"%");
		rs = pst.executeQuery();
		while(rs.next()) {
			Company c = new Company(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
					rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),
					rs.getString(9),rs.getString(10));
			list.add(c);
		}
		rs.close();
		pst.close();
		return list;
	}
	
	public Company searchByCompanyId(int companyId) throws Exception{
		Company result = new Company();//创建查询结果对象
		Connection conn = DBTool.getConnection();//连接数据库
		ResultSet rs;//数据库结果集的数据表
		PreparedStatement pst = conn.prepareStatement("select * from company where companyId = " + companyId);
		rs = pst.executeQuery();
		while(rs.next()) {
			Company c = new Company(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
					rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),
					rs.getString(9),rs.getString(10));
			result = c;
		}
		rs.close();
		pst.close();
		return result;
	}
	
	public List<Company> searchByCompanyName(String companyName) throws Exception{
		List<Company> list = new ArrayList<Company>();//创建查询结果对象
		Connection conn = DBTool.getConnection();//连接数据库
		ResultSet rs;//数据库结果集的数据表
		PreparedStatement pst = conn.prepareStatement("select * from company where companyName like ? order by convert(companyName using GBK)");
		pst.setString(1, "%"+companyName+"%");
		rs = pst.executeQuery();
		while(rs.next()) {
			Company c = new Company(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
					rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),
					rs.getString(9),rs.getString(10));
			list.add(c);
		}
		rs.close();
		pst.close();
		return list;
	}
	
}
