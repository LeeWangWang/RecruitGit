package service;
/**@FileName:PositionService.java
 * @Description:
 * @Author:������Sio
 * @Date:2019��1��3��
 */

import java.util.List;
import bean.Position;

/**@Description:
 * @FileName:PositionService.java
 * @Author:������Sio
 * @Date:2019��1��3��
 */
public interface PositionService {

	/**
	 * @Description:��������ְλ
	 * @FileName:PositionDao.java
	 * @Author:������Sio
	 * @Date:2019��1��3��
	 */
	List<Position> searchAll();	
	/**
	 * @Description:ͨ����˾��Ų���ְλ
	 * @FileName:PositionDao.java
	 * @Author:������Sio
	 * @Date:2019��1��3��
	 */
	List<Position> searchByCompanyId(int searchId);
	/**
	 * @Description:���ְλ
	 * @FileName:PositionDao.java
	 * @Author:������Sio
	 * @Date:2019��1��3��
	 */
	void addPosition(Position position);
	/**
	 * @Description:��˾ɾ��ְλ
	 * @FileName:PositionDao.java
	 * @Author:������Sio
	 * @Date:2019��1��3��
	 */
	void deletePosition(int positionId);
	/**
	 * @Description:��˾�޸�ְλ��Ƹ��Ϣ
	 * @FileName:PositionDao.java
	 * @Author:������Sio
	 * @Date:2019��1��3��
	 */
	public void updatePosition(Position position);
	/**
	 * @Description:ͨ��ְλID����ְλ
	 * @FileName:PositionDao.java
	 * @Author:������Sio
	 * @Date:2019��1��3��
	 */
	public Position searchByPositionId(int positionId);

}
