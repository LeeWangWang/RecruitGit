package bean;
/**
 * @ClassName: Company.java
 * @Author: ������
 * @Data: 2019��1��5������8:27:51
 */
public class Company extends Object implements Comparable<Company> {

	private int companyId;								//��˾ID
	private String companyName;							//��˾����
	private String companyAddress;						//��˾��ַ
	private String companyType;							//��˾����
	private String companyLegalPerson;					//��˾���˴���
	private String companyEmail;						//��˾����
	private String companyPhone;						//��˾�绰
	private String companyCaptial;						//��˾ע���ʽ�
	private String companyAccount;						//��˾�˻�
	private String companyPassword;						//��˾����
	/**
	 * ��˾���캯��
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
	 * @Description:�޸Ĺ�˾��Ϣ
	 * @FileName:Company.java
	 * @Author:������Sio
	 * @Date:2018��12��30��
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
	
	/**�ȽϹ�˾˳��(����˾ID)
	 * @Author:������Sio
	 * @Date:2018��12��30�� 
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
	 * @Description:get��set����
	 * @FileName:Company.java
	 * @Author:������Sio
	 * @Date:2018��12��30��
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
	 * ��˾��toString
	 */
	public String toString() {
		return String.format("%d,%s,%s,%s,%s,%s,%s,%s,%s,%s", 
				companyId,companyName,companyAddress,companyType,companyLegalPerson,
				companyEmail,companyPhone,companyCaptial,companyAccount,companyPassword);
	}	
	
}

