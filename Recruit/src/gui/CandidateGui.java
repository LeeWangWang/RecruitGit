/**@FileName: CandidateGui.java
 * @Description: 
 * @Paclage: gui
 * @Author: ������
 * @Data: 2018��12��31������4:02:54
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
 * @Author: ������
 * @Data: 2018��12��31������4:02:54
 */
public class CandidateGui extends JFrame{
	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	private Candidate user1 = new CandidateDao().searchCandidateFromId(2);;//��������
	public CandidateGui() {
		super("����");
		Font f = new Font(StyleArgument.FONTNAME, StyleArgument.FONTSTYLE,
				StyleArgument.FONTSIZE);
		JLabel candidateName = new LabelFont("����: ", f);
		JLabel name = new LabelFont(user1.getName() + "   ", f);
		JLabel candidateId = new LabelFont("���֤: ", f);
		JLabel id = new LabelFont(user1.getIdCard() + "   ", f);
		JLabel candidateGender = new LabelFont("�Ա�: ", f);
		JLabel gender = new LabelFont(user1.getGender()+ "   ", f);
		JLabel candidateAge = new LabelFont("����: ", f);
		JLabel age = new LabelFont(user1.getAge() + "   ", f);
		JLabel candidateMajor = new LabelFont("רҵ: ", f);
		JLabel major = new LabelFont(user1.getMajor() + "   ", f);
		JLabel candidateEducationed = new LabelFont("ѧ��: ", f);
		JLabel educationed = new LabelFont(user1.getEducation() + "   ", f);
		JLabel candidatePhone = new LabelFont("�绰: ", f);
		JLabel phone = new LabelFont(user1.getPhones() + "   ", f);
		JLabel candidateEmail = new LabelFont("����: ", f);
		JLabel email = new LabelFont(user1.getEmails() + "   ", f);
		JLabel candidateAddress = new LabelFont("��ַ: ", f);
		JLabel address = new LabelFont(user1.getAddress() + "   ", f);
		JLabel candidateJobObjective = new LabelFont("ְλ����: ", f);
		JLabel jobObjective = new LabelFont(user1.getJobObjective() + "   ", f);
		JLabel candidateWorkExperience = new LabelFont("��������: ", f);
		JLabel workExperience = new LabelFont(user1.getWorkExperience() + "   ", f);
		//������һ��ˮƽ��������
		Box hBox1 = Box.createHorizontalBox();
		hBox1.add(candidateName);
		hBox1.add(name);
		hBox1.add(candidateId);
		hBox1.add(id);
		//�����ڶ���ˮƽ��������
		Box hBox2 = Box.createHorizontalBox();
		hBox2.add(candidateGender);
		hBox2.add(gender);
		hBox2.add(candidateAge);
		hBox2.add(age);
		
		//����������ˮƽ��������
		Box hBox3 = Box.createHorizontalBox();
		hBox3.add(candidateMajor);
		hBox3.add(major);
		hBox3.add(candidateEducationed);
		hBox3.add(educationed);		
		
		//�������ĸ�ˮƽ��������
		Box hBox4 = Box.createHorizontalBox();
		hBox4.add(candidatePhone);
		hBox4.add(phone);
		hBox4.add(candidateEmail);
		hBox4.add(email);	

		//�������ĸ�ˮƽ��������
		Box hBox5 = Box.createHorizontalBox();
		hBox5.add(candidateAddress);
		hBox5.add(address);
		hBox5.add(candidateJobObjective);
		hBox5.add(jobObjective);
		
		//�������ĸ�ˮƽ��������
		Box hBox6 = Box.createHorizontalBox();
		hBox6.add(candidateWorkExperience);
		hBox6.add(workExperience);
		
		//������һ����ֱ��������
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
