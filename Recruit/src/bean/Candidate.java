package bean;

/**@ClassName:User.java
 * @Description: 用户类,描述用户的基本属性
 * @Extends: null
 * @Implements: null
 * @Author: 李旺旺
 * @Data:2018年12月30日下午6:53:39
 */
public class Candidate {
	private int candidateId;//求职者编号
    private String candidateName;//姓名
    private String candidateGender;//性别
    private int candidateAge;//年龄
    private String candidatePhone;//电话
    private String candidateIdCard;//身份证
    private String candidateEmail;//邮箱
    private String candidateAddress;//地址
    private String candidateMajor;//主修专业
    private String candidateEducationed; //学历
    private String candidateJobObjective;//求职意向
	private String candidateWorkExperience;//工作经验
    private String candidateAccount;//账号(只可以定义一次)
    private String candidatePassword;//密码

    /**
     * @ClassName: User
     * @Description: Get和Set方法
     * @Author: 李旺旺
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
     * @Description: 用户类的构造方法,不包含编号、账号、密码
     * @Param: [name, age, gender, idCard, phones, email, address, education, jobObjective, workExperience, major]
     * @Author: 李旺旺
     * @Time: 2018年12月31日下午3:03:26
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
    //包含所有属性
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
     * @Description: 重写用户的ToString方法,打印用户对象时返回的结果
     * @Parame: []
     * @Return: java.lang.String
     * @Author: 李旺旺
     * @Date: 2018/12/15 22:54
     */
    public String toString(){
        return this.getCandidateName();
        //return String.format("%s,%d,%s,%s,%s,%s,%s",this.getName(),this.getAge(),
        //        this.getGender(),this.getIdCard(),this.getPhones(),this.getEmails(),this.getAddress());
    }

    /**
     * @MethodName: display
     * @Description:用户对象的显示信息方法
     * @Parame: []
     * @Return: void
     * @Author: 李旺旺
     * @Date: 2018/12/15 22:54
     */
    public void display(){
        System.out.println(
        		"编号:" + this.getCandidateId()
        		+ "姓名:" + this.getCandidateName()
                + "  性别:" + this.getCandidateGender()
                + "  年龄:" + this.getCandidateAge()
                + "  电话:" + this.getCandidatePhone()
                + "  身份证:" + this.getCandidateIdCard()
                + "  邮箱:" + this.getCandidateEmail()
                + "  住址:" + this.getCandidateAddress()
        		+ "  专业:" + this.getCandidateMajor()
        		+ "  专业:" + this.getCandidateEducationed()
                + "  工作期望:" + this.getCandidateJobObjective()
        		+ "  工作经验:" + this.getCandidateWorkExperience()
        		);
    }

    /**
     * @MethodName: main
     * @Description: 程序入口
     * @Parame: [args]
     * @Return: void
     * @Author: 李旺旺
     * @Date: 2018/12/15 22:56
     */
    public static void main(String []args){
        Candidate user1 = new Candidate("李旺旺", "男", 20, "15587379525", "341223199711101939",
                 "2458581040@qq.com", "亳州", "软件工程", "二本", "工作期望", "工作经验");

        Candidate user2 = new Candidate("邱璐", "女", 18, "17616152016", "1522232199711101939",
                "549687018@qq.com", "昆山市", "网络工程", "二本", "工作期望", "工作经验");

        Candidate user3 = new Candidate("周靖怡","女", 18, "17616154083", "330203199711101939",
                "1814956792@qq.com", "宁波市", "网络工程", "二本", "工作期望", "工作经验");

        Candidate user4 = new Candidate("熊大", "男", 19, "18853711558", "370826199711101939",
                "971557875@qq.com", "微山县", "软件工程", "二本", "工作期望", "工作经验");

        Candidate user5 = new Candidate("熊二", "男", 19, "17616152468", "430181199711101939",
                "1771240731@qq.com", "浏阳市", "软件工程", "二本", "工作期望", "工作经验");
        System.out.println("运行类：Candidate.Java");
        user1.display();
        user2.display();
        user3.display();
        user4.display();
        user5.display();
        System.out.println(user1);
    }

}

