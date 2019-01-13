package dao;
/**@FileName:PositionDao.java
 * @Description:
 * @Author:周天乐Sio
 * @Date:2019年1月3日
 */
import java.util.List;
import bean.Position;

/**@Description:
 * @FileName:PositionDao.java
 * @Author:周天乐Sio
 * @Date:2019年1月3日
 */
public interface PositionDao {

	List<Position> searchAll() throws Exception;	
	List<Position> searchByCompanyId(int searchId) throws Exception;
	List<Position> searchByPositionName(String PositionName) throws Exception;
	List<Position> searchByPositionName(int companyId,String PositionName) throws Exception;
	void addPosition(Position position) throws Exception;
	void deletePosition(int positionId)throws Exception;
	void updatePosition(Position position) throws Exception;
	Position searchByPositionId(int positionId) throws Exception;
	List<Position> searchByPositionIntroduciton(int companyId,String Introduciton) throws Exception;
	List<Position> searchByPositionDiploma(int companyId,String Diploma) throws Exception;
	List<Position> searchByPositionLightspot(int companyId,String PositionLightspot) throws Exception;
}

