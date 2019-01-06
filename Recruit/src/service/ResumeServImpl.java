package service;

import java.util.List;
import bean.Resume;
import dao.ResumeDao;

/**@Description:
 * @FileName:ResumeServImpl.java
 * @Author:周天乐Sio
 * @Date:2019年1月3日
 */
public class ResumeServImpl implements ResumeService{

	private ResumeDao resumeDao;
	public ResumeServImpl(ResumeDao resumeDao) {
		this.resumeDao = resumeDao;
	}

	public List<Resume> searchAll(int companyId){
		try {
			return resumeDao.searchAll(companyId);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	public List<Resume> searchByPositionId(int searchId) {
		try {
			return resumeDao.searchByPositionId(searchId);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	public List<Resume> searchByCandidateId(int searchId) {
		try {
			return resumeDao.searchByCandidateId(searchId);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	public void deleteByPositionId(int deleteId) {
		try {
			resumeDao.deleteByPositionId(deleteId);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}


	public void addResume(Resume resume) {
		try {
			resumeDao.addResume(resume);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}


	public void dealResume(Resume resume, short isInterview) {
		try {
			resumeDao.dealResume(resume, isInterview);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}

