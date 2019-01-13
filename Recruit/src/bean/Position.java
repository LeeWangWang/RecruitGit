package bean;
/**
 * @ClassName: Position.java
 * @Author: ������
 * @Data: 2019��1��9������8:28:11
 */
public class Position extends Object{

	private int positionId;									//ְλ���
	private String positionName;							//ְλ
	private int companyId;									//��˾ID
	private String positionIntroduction;					//���
	private String positionDiploma;							//��ƾ
	private String positionLightspot;						//��Ҫ����
	/**
	 * Position���췽��
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
	 * @Description:get��set����
	 * @FileName:Position.java
	 * @Author:������Sio
	 * @Date:2018��12��30��
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
	 * Position��toString����
	 */
	public String toString() {
		return String.format("%d,%s,%d,%s,%s,%s", 
				positionId,positionName,companyId,positionIntroduction,positionDiploma,positionLightspot);
	}
	public void disply() {
		System.out.println(this.toString());
	}
}

