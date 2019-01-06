package service;
/**@FileName:PositionServImpl.java
 * @Description:
 * @Author:������Sio
 * @Date:2019��1��3��
 */

import java.util.List;
import bean.Position;
import dao.PositionDao;

/**@Description:
 * @FileName:PositionServImpl.java
 * @Author:������Sio
 * @Date:2019��1��3��
 */
public class PositionServImpl implements PositionService{

	private PositionDao positionDao;
	public PositionServImpl(PositionDao positionDao) {
		this.positionDao = positionDao;
	}

	@Override
	public List<Position> searchAll() {
		try {
			return positionDao.searchAll();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Position> searchByCompanyId(int searchId) {
		try {
			return positionDao.searchByCompanyId(searchId);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void addPosition(Position position) {
		try {
			positionDao.addPosition(position);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deletePosition(int positionId) {
		try {
			positionDao.deletePosition(positionId);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updatePosition(Position position) {
		try {
			positionDao.updatePosition(position);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Position searchByPositionId(int positionId) {
		try {
			return positionDao.searchByPositionId(positionId);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}