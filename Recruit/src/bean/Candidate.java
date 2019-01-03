package bean;

/**@ClassName:User.java
 * @Description: �û���,�����û��Ļ�������
 * @Extends: null
 * @Implements: null
 * @Author: ������
 * @Data:2018��12��30������6:53:39
 */
public class Candidate {
	private int candidateId;//��ְ�߱��
    private String candidateName;//����
    private String candidateGender;//�Ա�
    private int candidateAge;//����
    private String candidatePhone;//�绰
    private String candidateIdCard;//���֤
    private String candidateEmail;//����
    private String candidateAddress;//��ַ
    private String candidateMajor;//����רҵ
    private String candidateEducationed; //ѧ��
    private String candidateJobObjective;//��ְ����
	private String candidateWorkExperience;//��������
    private String candidateAccount;//�˺�(ֻ���Զ���һ��)
    private String candidatePassword;//����

    /**
     * @ClassName: User
     * @Description: Get��Set����
     * @Author: ������
     * @Date: 2018/12/15 22:44
     */    
    public int getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	public String getCandidateName() {
		return candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public String getCandidateGender() {
		return candidateGender;
	}

	public void setCandidateGender(String candidateGender) {
		this.candidateGender = candidateGender;
	}

	public int getCandidateAge() {
		return candidateAge;
	}

	public void setCandidateAge(int candidateAge) {
		this.candidateAge = candidateAge;
	}

	public String getCandidatePhone() {
		return candidatePhone;
	}

	public void setCandidatePhone(String candidatePhone) {
		this.candidatePhone = candidatePhone;
	}

	public String getCandidateIdCard() {
		return candidateIdCard;
	}

	public void setCandidateIdCard(String candidateIdCard) {
		this.candidateIdCard = candidateIdCard;
	}

	public String getCandidateEmail() {
		return candidateEmail;
	}

	public void setCandidateEmail(String candidateEmail) {
		this.candidateEmail = candidateEmail;
	}

	public String getCandidateAddress() {
		return candidateAddress;
	}

	public void setCandidateAddress(String candidateAddress) {
		this.candidateAddress = candidateAddress;
	}

	public String getCandidateMajor() {
		return candidateMajor;
	}

	public void setCandidateMajor(String candidateMajor) {
		this.candidateMajor = candidateMajor;
	}

	public String getCandidateEducationed() {
		return candidateEducationed;
	}

	public void setCandidateEducationed(String candidateEducationed) {
		this.candidateEducationed = candidateEducationed;
	}

	public String getCandidateJobObjective() {
		return candidateJobObjective;
	}

	public void setCandidateJobObjective(String candidateJobObjective) {
		this.candidateJobObjective = candidateJobObjective;
	}

	public String getCandidateWorkExperience() {
		return candidateWorkExperience;
	}

	public void setCandidateWorkExperience(String candidateWorkExperience) {
		this.candidateWorkExperience = candidateWorkExperience;
	}

	public String getCandidateAccount() {
		return candidateAccount;
	}

	public void setCandidateAccount(String candidateAccount) {
		this.candidateAccount = candidateAccount;
	}

	public String getCandidatePassword() {
		return candidatePassword;
	}

	public void setCandidatePassword(String candidatePassword) {
		this.candidatePassword = candidatePassword;
	}
	
	public Candidate() { }
	

	/**
     * @Title: Candidate
     * @Description: �û���Ĺ��췽��,��������š��˺š�����
     * @Param: [name, age, gender, idCard, phones, email, address, education, jobObjective, workExperience, major]
     * @Author: ������
     * @Time: 2018��12��31������3:03:26
     */
    public Candidate(String name, String gender, int age, String phones, String idCard,
            String email, String address, String major, String education,String jobObjective, 
            String workExperience) {
	    super();
	    this.setCandidateName(name);
	    this.setCandidateGender(gender);
	    this.setCandidateAge(age);
	    this.setCandidatePhone(phones);
	    this.setCandidateIdCard(idCard);
	    this.setCandidateEmail(email);
	    this.setCandidateAddress(address);
	    this.setCandidateMajor(major);
	    this.setCandidateEducationed(education);
	    this.setCandidateJobObjective(jobObjective);
	    this.setCandidateWorkExperience(workExperience);
    }
    //������������
    public Candidate(int id, String name, String gender, int age, String phones, String idCard,
            String email, String address, String major, String education,String jobObjective, 
            String workExperience, String account, String passworld) {
	    super();
	    this.setCandidateId(id);
	    this.setCandidateName(name);
	    this.setCandidateGender(gender);
	    this.setCandidateAge(age);
	    this.setCandidatePhone(phones);
	    this.setCandidateIdCard(idCard);
	    this.setCandidateEmail(email);
	    this.setCandidateAddress(address);
	    this.setCandidateMajor(major);
	    this.setCandidateEducationed(education);
	    this.setCandidateJobObjective(jobObjective);
	    this.setCandidateWorkExperience(workExperience);
	    this.setCandidateAccount(account);
	    this.setCandidatePassword(passworld);
    }

    /**
     * @MethodName: toString
     * @Description: ��д�û���ToString����,��ӡ�û�����ʱ���صĽ��
     * @Parame: []
     * @Return: java.lang.String
     * @Author: ������
     * @Date: 2018/12/15 22:54
     */
    public String toString(){
        return this.getCandidateName();
        //return String.format("%s,%d,%s,%s,%s,%s,%s",this.getName(),this.getAge(),
        //        this.getGender(),this.getIdCard(),this.getPhones(),this.getEmails(),this.getAddress());
    }

    /**
     * @MethodName: display
     * @Description:�û��������ʾ��Ϣ����
     * @Parame: []
     * @Return: void
     * @Author: ������
     * @Date: 2018/12/15 22:54
     */
    public void display(){
        System.out.println(
        		"���:" + this.getCandidateId()
        		+ "����:" + this.getCandidateName()
                + "  �Ա�:" + this.getCandidateGender()
                + "  ����:" + this.getCandidateAge()
                + "  �绰:" + this.getCandidatePhone()
                + "  ���֤:" + this.getCandidateIdCard()
                + "  ����:" + this.getCandidateEmail()
                + "  סַ:" + this.getCandidateAddress()
        		+ "  רҵ:" + this.getCandidateMajor()
        		+ "  רҵ:" + this.getCandidateEducationed()
                + "  ��������:" + this.getCandidateJobObjective()
        		+ "  ��������:" + this.getCandidateWorkExperience()
        		);
    }

    /**
     * @MethodName: main
     * @Description: �������
     * @Parame: [args]
     * @Return: void
     * @Author: ������
     * @Date: 2018/12/15 22:56
     */
    public static void main(String []args){
        Candidate user1 = new Candidate("������", "��", 20, "15587379525", "341223199711101939",
                 "2458581040@qq.com", "����", "�������", "����", "��������", "��������");

        Candidate user2 = new Candidate("���", "Ů", 18, "17616152016", "1522232199711101939",
                "549687018@qq.com", "��ɽ��", "���繤��", "����", "��������", "��������");

        Candidate user3 = new Candidate("�ܾ���","Ů", 18, "17616154083", "330203199711101939",
                "1814956792@qq.com", "������", "���繤��", "����", "��������", "��������");

        Candidate user4 = new Candidate("�ܴ�", "��", 19, "18853711558", "370826199711101939",
                "971557875@qq.com", "΢ɽ��", "�������", "����", "��������", "��������");

        Candidate user5 = new Candidate("�ܶ�", "��", 19, "17616152468", "430181199711101939",
                "1771240731@qq.com", "�����", "�������", "����", "��������", "��������");
        System.out.println("�����ࣺCandidate.Java");
        user1.display();
        user2.display();
        user3.display();
        user4.display();
        user5.display();
        System.out.println(user1);
    }

}

