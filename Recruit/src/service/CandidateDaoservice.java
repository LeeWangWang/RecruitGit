/**@FileName: CandidateGui.java
 * @Description: 
 * @Paclage: gui
 * @Author: 李旺旺
 * @Data: 2018年12月30日下午8:25:26
 */
package service;

import java.sql.ResultSet;
import java.sql.Statement;

import bean.Candidate;

/**@ClassName: CandidateGui.java
 * @Description: 简历
 * @Extends: 
 * @Implements: 
 * @Author: 李旺旺
 * @Data: 2018年12月30日下午8:25:26
 */
public class CandidateDaoservice {
	
	/**
	 * @Methodname: searchCandidateFromId
	 * @Description: 按照求职者的id查询信息
	 * @Param: id（求职者id）
	 * @Return: Candidate（求职者对象）
	 * @Author: 李旺旺
	 * @Time: 2018年12月30日下午10:31:50
	 */
	public Candidate searchCandidateFromId(int id){
		Candidate result = null;//查询结果
		Statement statement = null;//数据库操作接口，像数据库发送要执行的SQL语句
		ResultSet resultSet = null;//数据库结果集的数据表，通常通过执行查询数据库语句生成
		try {
			statement = DBTool.getConnection().createStatement();//创建用于执行静态SQL语句并返回它所生成结果的对象
			String sql = "select* from candidate";//SQL指令
			resultSet = statement.executeQuery(sql);//发送SQL指令，结果放到ResultSet对象中
			int id1;
			while(resultSet.next()) {
				id1 = resultSet.getInt("candidateId");//如果查找到正确的求职者的id
				if(id1 == id) {//查找到正确的id
					String name = resultSet.getString("candidateName");
					String gender = resultSet.getString("candidateGender");
					int age = resultSet.getInt("candidateAge");
					String major = resultSet.getString("candidateMajor");
					String education = resultSet.getString("candidateEducationed");
					String phones = resultSet.getString("candidatePhone");
					String emails = resultSet.getString("candidateEmail");
					String address = resultSet.getString("candidateAddress");
					String jobObjective = resultSet.getString("candidateJobObjective");
					String workExperience = resultSet.getString("candidateWorkExperience");
					//result = new Candidate(name, age, gender, id, phones, emails, address, education, jobObjective, 
				           //  workExperience, major);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet != null)
					resultSet.close();
				if(statement != null)
					statement.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	/**@Methodname: main
	 * @Description: 函数入口
	 * @Param: 
	 * @Return: 
	 * @Author: 李旺旺
	 * @Time: 2018年12月30日下午8:25:26
	 */
	public static void main(String[] args) {
		CandidateDaoservice g1 = new CandidateDaoservice();
		Candidate c1 = g1.searchCandidateFromId(3);
		c1.display();
	}

}
