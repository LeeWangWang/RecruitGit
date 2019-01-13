package service;
/**@FileName:PositionService.java
 * @Description:
 * @Author:周天乐Sio
 * @Date:2019年1月3日
 */

import java.util.List;
import bean.Position;

/**@Description:
 * @FileName:PositionService.java
 * @Author:周天乐Sio
 * @Date:2019年1月3日
 */
public interface PositionService {

	List<Position> searchAll();	
	List<Position> searchByCompanyId(int searchId);
	List<Position> searchByPositionName(String PositionName);	
	List<Position> searchByPositionName(int companyId,String PositionName);
	void addPosition(Position position);
	void deletePosition(int positionId);
	public void updatePosition(Position position);
	Position searchByPositionId(int positionId);
	List<Position> searchByPositionIntroduciton(int companyId,String Introduciton);
	List<Position> searchByPositionDiploma(int companyId,String Diploma);
	List<Position> searchByPositionLightspot(int companyId,String PositionLightspot);
}
