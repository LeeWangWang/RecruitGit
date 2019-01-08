/**@FileName: CandidateServiceImpl.java
 * @Description: 
 * @Paclage: service
 * @Author: 李旺旺
 * @Data: 2019年1月4日下午2:21:31
 */
package service;

import java.util.List;
import bean.Candidate;
import dao.CandidateDao1;

/**@ClassName: CandidateServiceImpl.java
 * @Description: 
 * @Extends: 
 * @Implements: 
 * @Author: 李旺旺
 * @Data: 2019年1月4日下午2:21:31
 */
public class CandidateServiceImpl implements CandidateService {
	private CandidateDao1 candidateDao;
	
	public CandidateServiceImpl(CandidateDao1 candidateDao) {
		super();
		this.candidateDao = candidateDao;
	}

	@Override
	public boolean addCandidate(Candidate c) throws Exception {
		if(c != null) {
			try {
				return candidateDao.addCandidate(c);
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}

	@Override
	public boolean deleteCandidate(int candidateId) throws Exception {
		try {
			return candidateDao.deleteCandidate(candidateId);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Candidate> searchAll(String field) throws Exception {
		try {
			return candidateDao.searchAll();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Candidate> searchByName(String name) throws Exception {
		try {
			return candidateDao.searchByName(name);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Candidate> searchByGender(String gender) throws Exception {
		try {
			return candidateDao.searchByGender(gender);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Candidate> searchByAddress(String address) throws Exception {
		try {
			return candidateDao.searchByAddress(address);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Candidate> searchByMajor(String major) throws Exception {
		try {
			return candidateDao.searchByMajor(major);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Candidate> searchByEducation(String education) throws Exception {
		try {
			return candidateDao.searchByEducation(education);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateCandidate(Candidate c) throws Exception {
		if(c != null) {
			try {
				return candidateDao.updateCandidate(c);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public Candidate searchByCandidateId(int candidateId) throws Exception{
		try {
			return candidateDao.searchByCandidateId(candidateId);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Candidate> searchAll() {
		try {
			return candidateDao.searchAll();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void addNewCandidate(Candidate candidate) {
		try {
			candidateDao.addNewCandidate(candidate);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
