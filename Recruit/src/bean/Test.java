/**@FileName: Test.java
 * @Description: 
 * @Paclage: bean
 * @Author: 李旺旺
 * @Data: 2019年1月8日下午2:09:46
 */
package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBTool;

public class Test {

	public static void main(String[] args) throws SQLException {
		int candidateId = 3;
		Candidate result = new Candidate();//创建查询结果对象
		Connection conn = DBTool.getConnection();//连接数据库
		ResultSet rs;//数据库结果集的数据表
		PreparedStatement pst = conn.prepareStatement("select * from candidate where candidateId = " + candidateId);
		rs = pst.executeQuery();
		while(rs.next()) {
			Candidate c = new Candidate(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),
					rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),
					rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14));
			result = c;
		}
		rs.close();
		pst.close();
		result.display();
		System.out.println(result.getCandidateAccount() + " "+ result.getCandidatePassword());
	}

}
