/**@FileName: ResumeDao.java
 * @Description: 
 * @Paclage: dao
 * @Author: ������
 * @Data: 2019��1��4������2:25:55
 */
package dao;

import java.util.List;
import bean.Resume;

/**@ClassName: ResumeDao.java
 * @Author: ������
 * @Data: 2019��1��4������2:25:55
 */
public interface ResumeDao {
	boolean addResume(Resume r) throws Exception;
	//������������,���ݹ�˾Id
	List<Resume> searchAll(int companyId) throws Exception;
	//ͨ����ְ��ID��������
	List<Resume> searchByCandidateId(int searchId) throws Exception;
	//ͨ��ְλID��������
	List<Resume> searchByPositionId(int searchId) throws Exception;
	//ͨ���Ƿ�¼�ò鿴����
	List<Resume> searchByIsInterview(int companyId ,int interview) throws Exception;
	//��˾ɾ��ְλ���������һ��ɾ��
	boolean deleteByPositionId(int deleteId) throws Exception;
	//��˾��������
	boolean dealResume(Resume resume,short isInterview) throws Exception;

	
}
