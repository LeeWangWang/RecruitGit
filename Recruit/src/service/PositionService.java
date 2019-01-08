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

	/**
	 * @Description:查找所有职位
	 */
	List<Position> searchAll();	
	/**
	 * @Description:通过公司编号查找职位
	 */
	List<Position> searchByCompanyId(int searchId);
	/**
	 * @Description:添加职位
	 */
	void addPosition(Position position);
	/**
	 * @Description:公司删除职位
	 */
	void deletePosition(int positionId);
	/**
	 * @Description:公司修改职位招聘信息
	 */
	public void updatePosition(Position position);
	/**
	 * @Description:通过职位ID查找职位
	 */
	public Position searchByPositionId(int positionId);

	List<Position> searchByPositionName(String PositionName);	
}
