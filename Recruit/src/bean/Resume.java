package bean;

/**
 * @Description: 用户的简历
 * @Author: 李旺旺
 * @Data:2018年12月30日下午6:53:28
 */
public class Resume{
    //简历的属性
    private int candidateId;//用户的编号
    private int positionId;//应聘职位
    private int isInterview;//是否录用

    /**
     * @Return: 简历的属性
     * @Author: 李旺旺
     * @Date: 2018/12/28 21:03
     */
    
    public int getPositionId() {
        return positionId;
    }
    public int getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
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
     * @Description: 构造函数，用来创建简历对象
     * @Author: 李旺旺
     * @Date: 2018/12/28 21:17
     */
    public Resume(int candidateId, int positionId, int isInterview){
        super();
        this.setCandidateId(candidateId);
        this.setPositionId(positionId);
        this.setIsInterview(isInterview);
    }
    public Resume(int candidateId, int positionId){
        super();
        this.setCandidateId(candidateId);
        this.setPositionId(positionId);
    }
    public Resume(){   }

    /**
     * @Description: 显示用户简历的信息
     * @Author: 李旺旺
     * @Date: 2018/12/28 21:12
     */
    public void display(){
        //this.getUser().display();
        System.out.println("应聘职位:" + this.getPositionId() + "   是否录用:" + this.getIsInterview());
    }

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
        Resume resume1 = new Resume(1, 1);//创建一个简历对象
        Resume resume2 = new Resume(2, 2);
        Resume resume3 = new Resume(3, 3);
        Resume resume4 = new Resume(4, 4);
        Resume resume5 = new Resume(5, 5);
        resume1.display();
        resume2.display();
        resume3.display();
        resume4.display();
        resume5.display();
    }

}

