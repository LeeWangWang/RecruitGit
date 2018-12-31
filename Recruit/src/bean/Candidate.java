package bean;

/**@ClassName:User.java
 * @Description: �û���,�����û��Ļ�������
 * @Extends: null
 * @Implements: null
 * @Author: ������
 * @Data:2018��12��30������6:53:39
 */
public class Candidate {
    private String name;//����
    private String gender;//�Ա�
    private int age;//����
    private String phones;//�绰
    private String address;//��ַ
    private String emails;//����
    private String workExperience;//��������
    private int idCard;//���֤
    private String jobObjective;//��ְ����
    private String education; //ѧ��
    private String major;//����רҵ

    /**
     * @ClassName: User
     * @Description: Get��Set����
     * @Author: ������
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
     * @Description: �û���Ĺ��췽��,����������Ϣ
     * @Param: [name, age, gender, idCard, phones, emails, address, education]
     * @Author: ������
     * @Time: 2018��12��31������3:03:26
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
     * @Description: �û���Ĺ��췽��,����������Ϣ
     * @Param: [name, age, gender, idCard, phones, emails, address, education, jobObjective, workExperience, major]
     * @Author: ������
     * @Time: 2018��12��31������3:03:26
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
     * @Description: ��д�û���ToString����,��ӡ�û�����ʱ���صĽ��
     * @Parame: []
     * @Return: java.lang.String
     * @Author: ������
     * @Date: 2018/12/15 22:54
     */
    public String toString(){
        return this.getName();
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
        System.out.println("����:" + this.getName()
                + "  ����:" + this.getAge()
                + "  �Ա�:" + this.getGender()
                + "  ���֤:" + this.getIdCard()
                + "  �绰:" + this.getPhones()
                + "  ����:" + this.getEmails()
                + "  סַ:" + this.getAddress());
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
        Candidate user1 = new Candidate("������", 20, "��", 111,
                "111", "111", "�Ϻ���", "1");

        Candidate user2 = new Candidate("���", 18, "Ů", 222,
                "222", "222", "��ɽ��", "1");

        Candidate user3 = new Candidate("�ܾ���", 18, "Ů", 333,
                "333", "333", "������", "3");

        Candidate user4 = new Candidate("�ܴ�", 19, "��", 444,
                "444", "444", "΢ɽ��", "1");

        Candidate user5 = new Candidate("�ܶ�", 19, "��", 555,
                "555", "555", "�����", "5");
        user1.display();
        user2.display();
        user3.display();
        user4.display();
        user5.display();
        System.out.println(user1);
    }

}

