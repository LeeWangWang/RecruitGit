/**@FileName: ResumeDao.java
 * @Description: 
 * @Paclage: dao
 * @Author: 李旺旺
 * @Data: 2019年1月4日下午2:25:55
 */
package dao;

import java.util.List;
import bean.Resume;

/**@ClassName: ResumeDao.java
 * @Author: 李旺旺
 * @Data: 2019年1月4日下午2:25:55
 */
public interface ResumeDao {
	boolean addResume(Resume r) throws Exception;
	//查找所有申请,根据公司Id
	List<Resume> searchAll(int companyId) throws Exception;
	//通过求职者ID查找申请
	List<Resume> searchByCandidateId(int searchId) throws Exception;
	//通过职位ID查找申请
	List<Resume> searchByPositionId(int searchId) throws Exception;
	//通过是否录用查看申请
	List<Resume> searchByIsInterview(int companyId ,int interview) throws Exception;
	//公司删除职位后将相关申请一并删除
	boolean deleteByPositionId(int deleteId) throws Exception;
	//公司处理申请
	boolean dealResume(Resume resume,short isInterview) throws Exception;

	
}
