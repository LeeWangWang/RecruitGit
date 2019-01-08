package service;

import java.util.List;

import bean.Company;
import bean.Resume;


/**@Description:
 * @FileName:ResumeService.java
 * @Author:������Sio
 * @Date:2019��1��3��
 */
public interface ResumeService {
	List<Resume> searchAll();
	
	/**
	 * @Description:ͨ����˾ID������������
	 * @FileName:ResumeDao.java
	 * @Author:������Sio
	 * @Date:2019��1��3��
	 */
	List<Resume> searchAll(int companyId);
	/**
	 * @Description:ͨ��ְλID��������
	 * @FileName:ResumeDao.java
	 * @Author:������Sio
	 * @Date:2019��1��3��
	 */
	List<Resume> searchByPositionId(int searchId);
	/**
	 * @Description:ͨ����ְ��ID��������
	 * @FileName:ResumeDao.java
	 * @Author:������Sio
	 * @Date:2019��1��3��
	 */
	List<Resume> searchByCandidateId(int searchId);
	/**
	 * @Description:��˾ɾ��ְλ���������һ��ɾ��
	 * @FileName:ResumeDao.java
	 * @Author:������Sio
	 * @Date:2019��1��3��
	 */
	void deleteByPositionId(int deleteId);
	/**
	 * @Description: ��ְ������
	 * @FileName:ResumeDao.java
	 * @Author:������Sio
	 * @Date:2019��1��3��
	 */
	boolean addResume(Resume resume);
	/**
	 * @Description: ��˾��������
	 * @FileName:ResumeDao.java
	 * @Author:������Sio
	 * @Date:2019��1��3��
	 */
	boolean dealResume(Resume resume,short isInterview);
}

