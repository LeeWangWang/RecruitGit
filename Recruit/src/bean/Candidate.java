package bean;

/**@ClassName:User.java
 * @Description: 用户类,描述用户的基本属性
 * @Extends: null
 * @Implements: null
 * @Author: 李旺旺
 * @Data:2018年12月30日下午6:53:39
 */
public class Candidate {
    private String name;//姓名
    private String gender;//性别
    private int age;//年龄
    private String phones;//电话
    private String address;//地址
    private String emails;//邮箱
    private String workExperience;//工作经验
    private int idCard;//身份证
    private String jobObjective;//求职意向
    private String education; //学历
    private String major;//主修专业

    /**
     * @ClassName: User
     * @Description: Get和Set方法
     * @Author: 李旺旺
     * @Date: 2018/12/15 22:44
     */
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getGender() {
        return this.gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public int getIdCard() {
        return this.idCard;
    }
    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }
    public String getPhones() {
        return this.phones;
    }
    public void setPhones(String phones) {
        this.phones = phones;
    }
    public String getEmails() {
        return this.emails;
    }
    public void setEmails(String emails) {
        this.emails = emails;
    }
    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getEducation() {
        return education;
    }
    public void setEducation(String education) {
        this.education = education;
    }
    public String getMajor() {
        return major;
    }
    public void setMajor(String major) {
        this.major = major;
    }
    public String getJobObjective() {
        return jobObjective;
    }
    public void setJobObjective(String jobObjective) {
        this.jobObjective = jobObjective;
    }
    public String getWorkExperience() {
        return workExperience;
    }
    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience;
    }

    public Candidate() { }
    
    /**
     * @Title: Candidate
     * @Description: 用户类的构造方法,包含所有信息
     * @Param: [name, age, gender, idCard, phones, emails, address, education]
     * @Author: 李旺旺
     * @Time: 2018年12月31日下午3:03:26
     */
    public Candidate(String name, int age, String gender, int idCard, String phones,
                String emails, String address, String education) {
        super();
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
        this.setIdCard(idCard);
        this.setPhones(phones);
        this.setEmails(emails);
        this.setAddress(address);
        this.setEducation(education);
    }
    /**
     * @Title: Candidate
     * @Description: 用户类的构造方法,包含所有信息
     * @Param: [name, age, gender, idCard, phones, emails, address, education, jobObjective, workExperience, major]
     * @Author: 李旺旺
     * @Time: 2018年12月31日下午3:03:26
     */
    public Candidate(String name, int age, String gender, int idCard, String phones,
            String emails, String address, String education,String jobObjective, 
            String workExperience, String major) {
    super();
    this.setName(name);
    this.setAge(age);
    this.setGender(gender);
    this.setIdCard(idCard);
    this.setPhones(phones);
    this.setEmails(emails);
    this.setAddress(address);
    this.setEducation(education);
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
        return this.getName();
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
        System.out.println("姓名:" + this.getName()
                + "  年龄:" + this.getAge()
                + "  性别:" + this.getGender()
                + "  身份证:" + this.getIdCard()
                + "  电话:" + this.getPhones()
                + "  邮箱:" + this.getEmails()
                + "  住址:" + this.getAddress());
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
        Candidate user1 = new Candidate("李旺旺", 20, "男", 111,
                "111", "111", "上海市", "1");

        Candidate user2 = new Candidate("邱璐", 18, "女", 222,
                "222", "222", "昆山市", "1");

        Candidate user3 = new Candidate("周靖怡", 18, "女", 333,
                "333", "333", "宁波市", "3");

        Candidate user4 = new Candidate("熊大", 19, "男", 444,
                "444", "444", "微山县", "1");

        Candidate user5 = new Candidate("熊二", 19, "男", 555,
                "555", "555", "浏阳市", "5");
        user1.display();
        user2.display();
        user3.display();
        user4.display();
        user5.display();
        System.out.println(user1);
    }

}

