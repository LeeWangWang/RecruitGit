/**@FileName: CandidateDao.java
 * @Description: 
 * @Paclage: dao
 * @Author: ������
 * @Data: 2019��1��3������7:21:36
 */
package dao;

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
	Candidate searchById(int id) throws Exception;
	boolean updateCandidate(Candidate c) throws Exception;
}

