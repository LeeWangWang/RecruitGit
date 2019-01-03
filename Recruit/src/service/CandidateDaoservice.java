/**@FileName: CandidateGui.java
 * @Description: 
 * @Paclage: gui
 * @Author: ������
 * @Data: 2018��12��30������8:25:26
 */
package service;

import java.sql.ResultSet;
import java.sql.Statement;

import bean.Candidate;

/**@ClassName: CandidateGui.java
 * @Description: ����
 * @Extends: 
 * @Implements: 
 * @Author: ������
 * @Data: 2018��12��30������8:25:26
 */
public class CandidateDaoservice {
	
	/**
	 * @Methodname: searchCandidateFromId
	 * @Description: ������ְ�ߵ�id��ѯ��Ϣ
	 * @Param: id����ְ��id��
	 * @Return: Candidate����ְ�߶���
	 * @Author: ������
	 * @Time: 2018��12��30������10:31:50
	 */
	public Candidate searchCandidateFromId(int id){
		Candidate result = null;//��ѯ���
		Statement statement = null;//���ݿ�����ӿڣ������ݿⷢ��Ҫִ�е�SQL���
		ResultSet resultSet = null;//���ݿ����������ݱ�ͨ��ͨ��ִ�в�ѯ���ݿ��������
		try {
			statement = DBTool.getConnection().createStatement();//��������ִ�о�̬SQL��䲢�����������ɽ���Ķ���
			String sql = "select* from candidate";//SQLָ��
			resultSet = statement.executeQuery(sql);//����SQLָ�����ŵ�ResultSet������
			int id1;
			while(resultSet.next()) {
				id1 = resultSet.getInt("candidateId");//������ҵ���ȷ����ְ�ߵ�id
				if(id1 == id) {//���ҵ���ȷ��id
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
	 * @Description: �������
	 * @Param: 
	 * @Return: 
	 * @Author: ������
	 * @Time: 2018��12��30������8:25:26
	 */
	public static void main(String[] args) {
		CandidateDaoservice g1 = new CandidateDaoservice();
		Candidate c1 = g1.searchCandidateFromId(3);
		c1.display();
	}

}
