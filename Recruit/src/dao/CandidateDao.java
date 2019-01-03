/**@FileName: CandidateDao.java
 * @Description: 
 * @Paclage: dao
 * @Author: 李旺旺
 * @Data: 2019年1月3日下午7:21:36
 */
package dao;

import bean.Candidate;

/**@ClassName: CandidateDao.java
 * @Description: 
 * @Extends: 
 * @Implements: 
 * @Author: 李旺旺
 * @Data: 2019年1月3日下午7:21:36
 */
public interface CandidateDao {
	boolean addCandidate(Candidate c) throws Exception;
	boolean deleteCandidate(int candidateId) throws Exception;
	Candidate searchById(int id) throws Exception;
	boolean updateCandidate(Candidate c) throws Exception;
}

