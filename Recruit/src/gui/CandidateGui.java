/**@FileName: CandidateGui.java
 * @Description: 
 * @Paclage: gui
 * @Author: 李旺旺
 * @Data: 2018年12月31日下午4:02:54
 */
package gui;

import java.awt.*;
import javax.swing.*;
import bean.Candidate;
import service.CandidateDao;

/**@ClassName: CandidateGui.java
 * @Description: 
 * @Extends: 
 * @Implements: 
 * @Author: 李旺旺
 * @Data: 2018年12月31日下午4:02:54
 */
public class CandidateGui extends JFrame{
	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	private Candidate user1 = new CandidateDao().searchCandidateFromId(2);;//简历对象
	public CandidateGui() {
		super("简历");
		Font f = new Font(StyleArgument.FONTNAME, StyleArgument.FONTSTYLE,
				StyleArgument.FONTSIZE);
		JLabel candidateName = new LabelFont("姓名: ", f);
		JLabel name = new LabelFont(user1.getName() + "   ", f);
		JLabel candidateId = new LabelFont("身份证: ", f);
		JLabel id = new LabelFont(user1.getIdCard() + "   ", f);
		JLabel candidateGender = new LabelFont("性别: ", f);
		JLabel gender = new LabelFont(user1.getGender()+ "   ", f);
		JLabel candidateAge = new LabelFont("年龄: ", f);
		JLabel age = new LabelFont(user1.getAge() + "   ", f);
		JLabel candidateMajor = new LabelFont("专业: ", f);
		JLabel major = new LabelFont(user1.getMajor() + "   ", f);
		JLabel candidateEducationed = new LabelFont("学历: ", f);
		JLabel educationed = new LabelFont(user1.getEducation() + "   ", f);
		JLabel candidatePhone = new LabelFont("电话: ", f);
		JLabel phone = new LabelFont(user1.getPhones() + "   ", f);
		JLabel candidateEmail = new LabelFont("邮箱: ", f);
		JLabel email = new LabelFont(user1.getEmails() + "   ", f);
		JLabel candidateAddress = new LabelFont("地址: ", f);
		JLabel address = new LabelFont(user1.getAddress() + "   ", f);
		JLabel candidateJobObjective = new LabelFont("职位期望: ", f);
		JLabel jobObjective = new LabelFont(user1.getJobObjective() + "   ", f);
		JLabel candidateWorkExperience = new LabelFont("工作经验: ", f);
		JLabel workExperience = new LabelFont(user1.getWorkExperience() + "   ", f);
		//创建第一个水平盒子容器
		Box hBox1 = Box.createHorizontalBox();
		hBox1.add(candidateName);
		hBox1.add(name);
		hBox1.add(candidateId);
		hBox1.add(id);
		//创建第二个水平盒子容器
		Box hBox2 = Box.createHorizontalBox();
		hBox2.add(candidateGender);
		hBox2.add(gender);
		hBox2.add(candidateAge);
		hBox2.add(age);
		
		//创建第三个水平盒子容器
		Box hBox3 = Box.createHorizontalBox();
		hBox3.add(candidateMajor);
		hBox3.add(major);
		hBox3.add(candidateEducationed);
		hBox3.add(educationed);		
		
		//创建第四个水平盒子容器
		Box hBox4 = Box.createHorizontalBox();
		hBox4.add(candidatePhone);
		hBox4.add(phone);
		hBox4.add(candidateEmail);
		hBox4.add(email);	

		//创建第四个水平盒子容器
		Box hBox5 = Box.createHorizontalBox();
		hBox5.add(candidateAddress);
		hBox5.add(address);
		hBox5.add(candidateJobObjective);
		hBox5.add(jobObjective);
		
		//创建第四个水平盒子容器
		Box hBox6 = Box.createHorizontalBox();
		hBox6.add(candidateWorkExperience);
		hBox6.add(workExperience);
		
		//创建第一个竖直盒子容器
		Box vBox1 = Box.createVerticalBox();
		vBox1.add(hBox1);
		vBox1.add(hBox2);
		vBox1.add(hBox3);
		vBox1.add(hBox4);
		vBox1.add(hBox5);
		vBox1.add(hBox6);
		
		this.setContentPane(vBox1);
		this.pack();
		this.setLocation(500, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new CandidateGui();
	}
	
}
