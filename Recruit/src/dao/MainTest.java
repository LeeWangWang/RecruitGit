package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Company;
import bean.Resume;
import service.ResumeServImpl;
import service.ResumeService;
import util.DBTool;

public class MainTest {

	public static void main(String[] args) throws SQLException {
		String address = "深圳";
		
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
		
		for(Company p : list) {
			System.out.println(p.getCompanyName());
		}
	}

}
