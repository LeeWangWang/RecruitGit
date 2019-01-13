package bean;
/**
 * @ClassName: Position.java
 * @Author: 周天乐
 * @Data: 2019年1月9日上午8:28:11
 */
public class Position extends Object{

	private int positionId;									//职位编号
	private String positionName;							//职位
	private int companyId;									//公司ID
	private String positionIntroduction;					//简介
	private String positionDiploma;							//文凭
	private String positionLightspot;						//需要条件
	/**
	 * Position构造方法
	 * @param positionId
	 * @param positionName
	 * @param companyId
	 * @param positionIntroduction
	 * @param positionDiploma
	 * @param positionLightspot
	 */
	public Position(int positionId,String positionName
			,int companyId,String positionIntroduction
			,String positionDiploma,String positionLightspot) {
		super();
		this.setPositionId(positionId);
		this.setPositionName(positionName);
		this.setCompanyId(companyId);
		this.setPositionIntroduction(positionIntroduction);
		this.setPositionDiploma(positionDiploma);
		this.setPositionLightspot(positionLightspot);
	}
	public Position() {
		
	}


	/**
	 * @Description:get和set方法
	 * @FileName:Position.java
	 * @Author:周天乐Sio
	 * @Date:2018年12月30日
	 */
	public int getPositionId() {
		return positionId;
	}
	public void setPositionId(int positionId) {
		this.positionId = positionId;
	}
	public String getPositionName() {
		return positionName;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getPositionIntroduction() {
		return positionIntroduction;
	}
	public void setPositionIntroduction(String positionIntroduction) {
		this.positionIntroduction = positionIntroduction;
	}
	public String getPositionDiploma() {
		return positionDiploma;
	}
	public void setPositionDiploma(String positionDiploma) {
		this.positionDiploma = positionDiploma;
	}
	public String getPositionLightspot() {
		return positionLightspot;
	}
	public void setPositionLightspot(String positionLightspot) {
		this.positionLightspot = positionLightspot;
	}
	/**
	 * Position的toString方法
	 */
	public String toString() {
		return String.format("%d,%s,%d,%s,%s,%s", 
				positionId,positionName,companyId,positionIntroduction,positionDiploma,positionLightspot);
	}
	public void disply() {
		System.out.println(this.toString());
	}
}

