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
	 */
	List<Position> searchAll();	
	/**
	 * @Description:ͨ����˾��Ų���ְλ
	 */
	List<Position> searchByCompanyId(int searchId);
	/**
	 * @Description:���ְλ
	 */
	void addPosition(Position position);
	/**
	 * @Description:��˾ɾ��ְλ
	 */
	void deletePosition(int positionId);
	/**
	 * @Description:��˾�޸�ְλ��Ƹ��Ϣ
	 */
	public void updatePosition(Position position);
	/**
	 * @Description:ͨ��ְλID����ְλ
	 */
	public Position searchByPositionId(int positionId);

	List<Position> searchByPositionName(String PositionName);	
}
