/**@FileName: Ren.java
 * @Description: 
 * @Paclage: gui.candidate
 * @Author: ������
 * @Data: 2019��1��8������9:13:23
 */
package gui.candidate;

/**
 * �¿���һ���������洢ӦƸ����Ϣ������Ϣ
 * @author hp
 * @Description
 * @data 2019��1��6��
 */
public class Ren{
	private int positionId;             //ְλ��ID 
	private String positionName;	    //ְλ������
	private int companyId;              //��˾��ID
	private String companyName; 	    //��˾������
	private String companyAddress;  	//��˾�ĵ�ַ
	private String positionDiploma;     //н�ʺ�ְλ����
	private String luyong;			    //�Ƿ�¼��1
	
	public Ren() {
		
	}
	public String toString() {
		return String.format("%d,%s,%d,%s,%s,%s",positionId,positionName,companyId,companyName,companyAddress,luyong);
	}
	
	public String getPositionDiploma() {
		return positionDiploma;
	}
	public void setPositionDiploma(String positionDiploma) {
		this.positionDiploma = positionDiploma;
	}
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

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getLuyong() {
		return luyong;
	}

	public void setLuyong(String luyong) {
		this.luyong = luyong;
	} 
	
	
}
