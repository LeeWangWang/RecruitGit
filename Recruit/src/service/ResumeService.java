package service;

import java.util.List;

import bean.Company;
import bean.Resume;


/**@Description:
 * @FileName:ResumeService.java
 * @Author:周天乐Sio
 * @Date:2019年1月3日
 */
public interface ResumeService {
	List<Resume> searchAll();
	
	/**
	 * @Description:通过公司ID查找所有申请
	 * @FileName:ResumeDao.java
	 * @Author:周天乐Sio
	 * @Date:2019年1月3日
	 */
	List<Resume> searchAll(int companyId);
	/**
	 * @Description:通过职位ID查找申请
	 * @FileName:ResumeDao.java
	 * @Author:周天乐Sio
	 * @Date:2019年1月3日
	 */
	List<Resume> searchByPositionId(int searchId);
	/**
	 * @Description:通过求职者ID查找申请
	 * @FileName:ResumeDao.java
	 * @Author:周天乐Sio
	 * @Date:2019年1月3日
	 */
	List<Resume> searchByCandidateId(int searchId);
	/**
	 * @Description:公司删除职位后将相关申请一并删除
	 * @FileName:ResumeDao.java
	 * @Author:周天乐Sio
	 * @Date:2019年1月3日
	 */
	void deleteByPositionId(int deleteId);
	/**
	 * @Description: 求职者申请
	 * @FileName:ResumeDao.java
	 * @Author:周天乐Sio
	 * @Date:2019年1月3日
	 */
	boolean addResume(Resume resume);
	/**
	 * @Description: 公司处理申请
	 * @FileName:ResumeDao.java
	 * @Author:周天乐Sio
	 * @Date:2019年1月3日
	 */
	boolean dealResume(Resume resume,short isInterview);
}

