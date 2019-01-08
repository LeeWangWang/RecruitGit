package dao;

import java.util.List;

import bean.Candidate;

/**@ClassName: CandidateDao.java
 * @Author: 李旺旺
 * @Data: 2019年1月3日下午7:21:36
 */
public interface CandidateDao1 {
	boolean addCandidate(Candidate c) throws Exception;
	boolean deleteCandidate(int candidateId) throws Exception;
	List<Candidate> searchAll() throws Exception;
	List<Candidate> searchByName(String name) throws Exception;
	List<Candidate> searchByGender(String gender) throws Exception;
	List<Candidate> searchByAddress(String address) throws Exception;
	List<Candidate> searchByMajor(String major) throws Exception;
	List<Candidate> searchByEducation(String education) throws Exception;
	Candidate searchByCandidateId(int candidateId) throws Exception;
	boolean updateCandidate(Candidate c) throws Exception;
	boolean addNewCandidate(Candidate candidate) throws Exception;
}

