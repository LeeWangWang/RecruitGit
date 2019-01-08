/**@FileName: CandidateService.java
 * @Description: 
 * @Paclage: service
 * @Author: 李旺旺
 * @Data: 2019年1月4日下午2:19:59
 */
package service;

import java.util.List;
import bean.Candidate;

/**@ClassName: CandidateService.java
 * @Description: 
 * @Extends: 
 * @Implements: 
 * @Author: 李旺旺
 * @Data: 2019年1月4日下午2:19:59
 */
public interface CandidateService {
	boolean addCandidate(Candidate c) throws Exception;
	boolean deleteCandidate(int candidateId) throws Exception;
	List<Candidate> searchAll(String field) throws Exception;
	List<Candidate> searchByName(String name) throws Exception;
	List<Candidate> searchByGender(String gender) throws Exception;
	List<Candidate> searchByAddress(String address) throws Exception;
	List<Candidate> searchByMajor(String major) throws Exception;
	List<Candidate> searchByEducation(String education) throws Exception;
	boolean updateCandidate(Candidate c) throws Exception;
	Candidate searchByCandidateId(int candidateId) throws Exception;
	List<Candidate> searchAll() throws Exception; 
	void addNewCandidate(Candidate candidate) throws Exception;

}
