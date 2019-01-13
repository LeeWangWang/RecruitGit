package bean;
/**
 * @ClassName: Company.java
 * @Author: 周天乐
 * @Data: 2019年1月5日上午8:27:51
 */
public class Company extends Object implements Comparable<Company> {

	private int companyId;								//公司ID
	private String companyName;							//公司名字
	private String companyAddress;						//公司地址
	private String companyType;							//公司类型
	private String companyLegalPerson;					//公司法人代表
	private String companyEmail;						//公司邮箱
	private String companyPhone;						//公司电话
	private String companyCaptial;						//公司注册资金
	private String companyAccount;						//公司账户
	private String companyPassword;						//公司密码
	/**
	 * 公司构造函数
	 * @param companyId
	 * @param companyName
	 * @param companyAddress
	 * @param companyType
	 * @param companyLegalPerson
	 * @param companyEmail
	 * @param companyPhone
	 * @param companyCaptial
	 * @Param companyPassword
	 */
	public Company(int companyId,String companyName								
			,String companyAddress
			,String companyType
			,String companyLegalPerson
			,String companyEmail
			,String companyPhone
			,String companyCaptial
			,String companyAccount
			,String companyPassword) {
		super();
		this.setCompanyId(companyId);
		this.setCompanyName(companyName);
		this.setCompanyAddress(companyAddress);
		this.setCompanyType(companyType);
		this.setCompanyLegalPerson(companyLegalPerson);
		this.setCompanyEmail(companyEmail);
		this.setCompanyPhone(companyPhone);
		this.setCompanyCaptial(companyCaptial);
	}
	public Company() {
		
	}
	
	/**
	 * @Description:修改公司信息
	 * @FileName:Company.java
	 * @Author:周天乐Sio
	 * @Date:2018年12月30日
	 */
	public void changeCompanyImformation(int companyId,String companyName
			,String companyAddress
			,String companyType
			,String companyLegalPerson
			,String companyEmail
			,String companyPhone
			,String companyCaptial) {
		this.setCompanyId(companyId);
		this.setCompanyName(companyName);
		this.setCompanyAddress(companyAddress);
		this.setCompanyType(companyType);
		this.setCompanyLegalPerson(companyLegalPerson);
		this.setCompanyEmail(companyEmail);
		this.setCompanyPhone(companyPhone);
		this.setCompanyCaptial(companyCaptial);
	}
	
	/**比较公司顺序(按公司ID)
	 * @Author:周天乐Sio
	 * @Date:2018年12月30日 
	 */
	public int compareTo(Company p) {
		if(this.companyId>p.companyId) {
			return 1;
		}
		if(this.companyId==p.companyId) {
			return 0;
		}
		return -1;
	}
	/**
	 * @Description:get和set方法
	 * @FileName:Company.java
	 * @Author:周天乐Sio
	 * @Date:2018年12月30日
	 */
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
	public String getCompanyType() {
		return companyType;
	}
	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}
	public String getCompanyLegalPerson() {
		return companyLegalPerson;
	}
	public void setCompanyLegalPerson(String companyLegalPerson) {
		this.companyLegalPerson = companyLegalPerson;
	}
	public String getCompanyEmail() {
		return companyEmail;
	}
	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}
	public String getCompanyPhone() {
		return companyPhone;
	}
	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}
	public String getCompanyCaptial() {
		return companyCaptial;
	}
	public void setCompanyCaptial(String companyCaptial) {

		this.companyCaptial = companyCaptial;
	}	
	public String getCompanyPassword() {
		return companyPassword;
	}
	public void setCompanyPassword(String companyPassword) {
		this.companyPassword = companyPassword;
	}
	public String getCompanyAccount() {
		return companyAccount;
	}
	public void setCompanyAccount(String companyAccount) {
		this.companyAccount = companyAccount;
	}
	/**
	 * 公司的toString
	 */
	public String toString() {
		return String.format("%d,%s,%s,%s,%s,%s,%s,%s,%s,%s", 
				companyId,companyName,companyAddress,companyType,companyLegalPerson,
				companyEmail,companyPhone,companyCaptial,companyAccount,companyPassword);
	}	
	
}

