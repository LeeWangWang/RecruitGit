/**@FileName: Ren.java
 * @Description: 
 * @Paclage: gui.candidate
 * @Author: 李旺旺
 * @Data: 2019年1月8日下午9:13:23
 */
package gui.candidate;

/**
 * 新开辟一个类用来存储应聘者消息栏的信息
 * @author hp
 * @Description
 * @data 2019年1月6日
 */
public class Ren{
	private int positionId;             //职位的ID 
	private String positionName;	    //职位的名字
	private int companyId;              //公司的ID
	private String companyName; 	    //公司的名字
	private String companyAddress;  	//公司的地址
	private String positionDiploma;     //薪资和职位亮点
	private String luyong;			    //是否录用1
	
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
