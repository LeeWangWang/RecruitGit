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
	 * @FileName:PositionDao.java
	 * @Author:������Sio
	 * @Date:2019��1��3��
	 */
	List<Position> searchAll() throws Exception;	
	/**
	 * @Description:ͨ����˾��Ų���ְλ
	 * @FileName:PositionDao.java
	 * @Author:������Sio
	 * @Date:2019��1��3��
	 */
	List<Position> searchByCompanyId(int searchId) throws Exception;
	/**
	 * @Description:���ְλ
	 * @FileName:PositionDao.java
	 * @Author:������Sio
	 * @Date:2019��1��3��
	 */
	void addPosition(Position position) throws Exception;
	/**
	 * @Description:��˾ɾ��ְλ
	 * @FileName:PositionDao.java
	 * @Author:������Sio
	 * @Date:2019��1��3��
	 */
	void deletePosition(int positionId)throws Exception;
	/**
	 * @Description:��˾�޸�ְλ��Ƹ��Ϣ
	 * @FileName:PositionDao.java
	 * @Author:������Sio
	 * @Date:2019��1��3��
	 */
	public void updatePosition(Position position) throws Exception;
	/**
	 * @Description:ͨ��ְλID����ְλ
	 * @FileName:PositionDao.java
	 * @Author:������Sio
	 * @Date:2019��1��3��
	 */
	public Position searchByPositionId(int positionId) throws Exception;
	
	List<Position> search(String search) throws Exception;
	
}

