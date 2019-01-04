/**@FileName: CandidateDao.java
 * @Description: 
 * @Paclage: dao
 * @Author: ������
 * @Data: 2019��1��3������7:21:36
 */
package dao;

import java.util.List;

import bean.Candidate;

/**@ClassName: CandidateDao.java
 * @Description: 
 * @Extends: 
 * @Implements: 
 * @Author: ������
 * @Data: 2019��1��3������7:21:36
 */
public interface CandidateDao {
	boolean addCandidate(Candidate c) throws Exception;
	boolean deleteCandidate(int candidateId) throws Exception;
	List<Candidate> searchAll(String field) throws Exception;
	List<Candidate> searchByName(String name) throws Exception;
	List<Candidate> searchByGender(String gender) throws Exception;
	List<Candidate> searchByAddress(String address) throws Exception;
	List<Candidate> searchByMajor(String major) throws Exception;
	List<Candidate> searchByEducation(String education) throws Exception;
	boolean updateCandidate(Candidate c) throws Exception;
}

