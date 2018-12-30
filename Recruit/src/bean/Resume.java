/**@FileName:Resume.java
 * @Description: 
 * @Paclage:bean
 * @Author:李旺旺
 * @Data:2018年12月30日下午6:53:28
 */
package bean;

/**@ClassName:Resume.java
 * @Description: 用户的简历
 * @Extends: null
 * @Implements: null
 * @Author: 李旺旺
 * @Data:2018年12月30日下午6:53:28
 */
public class Resume{
    //简历的属性
    private Candidate user;//用户的信息
    private int positionId;//应聘职位
    private int isInterview;//是否录用

    /**
     * @MethodName: get and set
     * @Description: Get和Set方法,用来更改简历的属性
     * @Parame: []
     * @Return: 简历的属性
     * @Author: 李旺旺
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
     * @Description: 构造函数，用来创建简历对象
     * @Parame: [user, positionId, isInterview]
     * @Return:
     * @Author: 李旺旺
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
     * @Description: 显示用户简历的信息
     * @Parame: []
     * @Return: void
     * @Author: 李旺旺
     * @Date: 2018/12/28 21:12
     */
    public void display(){
        this.getUser().display();
        System.out.println("应聘职位:" + this.getPositionId() + "   是否录用:" + this.getIsInterview());
    }

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
        Resume resume1 = new Resume(user1, 1);//创建一个简历对象
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

