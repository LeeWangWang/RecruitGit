package service;
/**@FileName:PositionServImpl.java
 * @Description:
 * @Author:周天乐Sio
 * @Date:2019年1月3日
 */

import java.util.ArrayList;
import java.util.List;
import bean.Position;
import dao.PositionDao;

/**@Description:
 * @FileName:PositionServImpl.java
 * @Author:周天乐Sio
 * @Date:2019年1月3日
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

 	public List<Position> searchByPositionName(String PositionName){
		try {
			return positionDao.searchByPositionName(PositionName);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
 	
 	public List<Position> searchByPositionName(int companyId,String PositionName) {
		try {
			return positionDao.searchByPositionName(companyId,PositionName);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
 	
 	public List<Position> searchByPositionIntroduciton(int companyId,String Introduciton) {
		try {
			return positionDao.searchByPositionIntroduciton(companyId,Introduciton);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Position> searchByPositionDiploma(int companyId,String Diploma) {
		try {
			return positionDao.searchByPositionDiploma(companyId,Diploma);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Position> searchByPositionLightspot(int companyId,String PositionLightspot) {
		try {
			return positionDao.searchByPositionLightspot(companyId,PositionLightspot);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

 	
}

