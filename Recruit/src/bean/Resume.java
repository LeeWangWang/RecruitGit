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

