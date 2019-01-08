package dao;
/**@FileName:PositionDao.java
 * @Description:
 * @Author:������Sio
 * @Date:2019��1��3��
 */
import java.util.List;
import bean.Position;

/**@Description:
 * @FileName:PositionDao.java
 * @Author:������Sio
 * @Date:2019��1��3��
 */
public interface PositionDao {

	/**
	 * @Description:��������ְλ
	 */
	List<Position> searchAll() throws Exception;	
	/**
	 * @Description:ͨ����˾��Ų���ְλ
	 */
	List<Position> searchByCompanyId(int searchId) throws Exception;
	/**
	 * @Description:���ְλ
	 */
	void addPosition(Position position) throws Exception;
	/**
	 * @Description:��˾ɾ��ְλ
	 */
	void deletePosition(int positionId)throws Exception;
	/**
	 * @Description:��˾�޸�ְλ��Ƹ��Ϣ
	 */
	public void updatePosition(Position position) throws Exception;
	/**
	 * @Description:ͨ��ְλID����ְλ
	 */
	public Position searchByPositionId(int positionId) throws Exception;
	
	List<Position> searchByPositionName(String PositionName) throws Exception;
	
}

