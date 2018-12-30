/**@FileName:Resume.java
 * @Description: 
 * @Paclage:bean
 * @Author:������
 * @Data:2018��12��30������6:53:28
 */
package bean;

/**@ClassName:Resume.java
 * @Description: �û��ļ���
 * @Extends: null
 * @Implements: null
 * @Author: ������
 * @Data:2018��12��30������6:53:28
 */
public class Resume{
    //����������
    private Candidate user;//�û�����Ϣ
    private int positionId;//ӦƸְλ
    private int isInterview;//�Ƿ�¼��

    /**
     * @MethodName: get and set
     * @Description: Get��Set����,�������ļ���������
     * @Parame: []
     * @Return: ����������
     * @Author: ������
     * @Date: 2018/12/28 21:03
     */
    public Candidate getUser() {
        return user;
    }
    public void setUser(Candidate user) {
        this.user = user;
    }
    public int getPositionId() {
        return positionId;
    }
    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }
    public int getIsInterview() {
        return isInterview;
    }
    public void setIsInterview(int isInterview) {
        this.isInterview = isInterview;
    }

    /**
     * @MethodName: Resume
     * @Description: ���캯��������������������
     * @Parame: [user, positionId, isInterview]
     * @Return:
     * @Author: ������
     * @Date: 2018/12/28 21:17
     */
    public Resume(Candidate user, int positionId, int isInterview){
        super();
        this.setUser(user);
        this.setPositionId(positionId);
        this.setIsInterview(isInterview);
    }
    public Resume(Candidate user, int positionId){
        super();
        this.setUser(user);
        this.setPositionId(positionId);
    }
    public Resume(){   }

    /**
     * @MethodName: display
     * @Description: ��ʾ�û���������Ϣ
     * @Parame: []
     * @Return: void
     * @Author: ������
     * @Date: 2018/12/28 21:12
     */
    public void display(){
        this.getUser().display();
        System.out.println("ӦƸְλ:" + this.getPositionId() + "   �Ƿ�¼��:" + this.getIsInterview());
    }

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
        Resume resume1 = new Resume(user1, 1);//����һ����������
        Resume resume2 = new Resume(user2, 2);
        Resume resume3 = new Resume(user3, 3);
        Resume resume4 = new Resume(user4, 4);
        Resume resume5 = new Resume(user5, 5);
        resume1.display();
        resume2.display();
        resume3.display();
        resume4.display();
        resume5.display();
    }

}

