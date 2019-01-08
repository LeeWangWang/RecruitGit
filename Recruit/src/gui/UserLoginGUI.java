package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import bean.*;
import dao.*;
import gui.customStyle.ButtonFont;
import gui.customStyle.StyleArgument;
import service.CandidateServiceImpl;
/**
 * @author hp
 * @Description �ý���ʹ�û���ע�����
 * @data 2019��1��3��
 */
public class UserLoginGUI extends JFrame {
	private JLabel candidateId;            		 //ӦƸ��ID
	private JTextField candidateName;			 //ӦƸ������
	private JTextField candidateGender;			 //ӦƸ���Ա�
	private JTextField candidateAge;             //ӦƸ������ 
	private JTextField candidatePhone;			 //ӦƸ���ֻ�
	private JTextField candidateIdCard;			 //ӦƸ�����֤
	private JTextField candidateEmail;			 //ӦƸ��Email
	private JTextField candidateAddress;		 //ӦƸ�߼�ͥסַ
	private JTextField candidateMajor;			 //ӦƸ��רҵ
	private JTextField candidateEducationed;	 //ӦƸ��ѧ��
	private JTextField candidateJobObjective;	 //ӦƸ����ְ����
	private JTextField candidateWorkExperience;  //ӦƸ�߹�������
	private JTextField candidateAccount;		 //ӦƸ���˺�
	private JPasswordField candidatePassword;	 //ӦƸ������
	private JPasswordField candidatePassword_two;//ӦƸ���ظ���������
	private ButtonFont sure;                     //ȷ��ע��İ�ť
	private List<Candidate> date;                //�����ݿ��ж�ȡ���ݵĴ洢����
	
	public UserLoginGUI() {
		super("ӦƸ��ע�����");
		try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} catch (UnsupportedLookAndFeelException e1) {			
			e1.printStackTrace();
		}
		this.readDatabase();
    	this.init();
    	this.jianting();
    	this.setResizable(true);
		this.setSize(450,600);
        this.setLocation(100, 200);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	//�رոý��治��ʹ������Ҳ�ر�	
		this.setVisible(true);
	}
	
	public void init() {
		
		Font f = new Font(StyleArgument.FONTNAME, StyleArgument.FONTSTYLE,StyleArgument.FONTSIZE);
		Container c = this.getContentPane();
		c.setLayout(new BorderLayout(20,10));       //�������֮��ļ��
		//�м�
		Box center = Box.createVerticalBox();       //����һ����ֱ����
		 
		Box first = Box.createHorizontalBox();      //����һ��ˮƽ����
		JLabel id = new JLabel("id");
		int i = 0;
		for(i = 1;i < date.size();i++);
		i++;
		candidateId = new JLabel(i+"");
		first.add(id);
		first.add(Box.createRigidArea(new Dimension(65, 30))); //���һ�������������Glue
		first.add(candidateId);
		first.add(Box.createRigidArea(new Dimension(365, 30))); //���һ�������������Glue
		
		Box second = Box.createHorizontalBox();    //����һ��ˮƽ����
		JLabel Name = new JLabel("����");
		candidateName = new JTextField();
		second.add(Name);
		second.add(Box.createRigidArea(new Dimension(47, 30)));
		second.add(candidateName);
		
		Box third  = Box.createHorizontalBox();    //����һ��ˮƽ����
		JLabel Gender = new JLabel("�Ա�");
		candidateGender = new JTextField();
		third.add(Gender);
		third.add(Box.createRigidArea(new Dimension(47, 30)));
		third.add(candidateGender);
		
		Box fourth  = Box.createHorizontalBox();    //����һ��ˮƽ����
		JLabel Age = new JLabel("����");
		candidateAge = new JTextField();
		fourth.add(Age);
		fourth.add(Box.createRigidArea(new Dimension(47, 30)));
		fourth.add(candidateAge);
		
		Box fifth  = Box.createHorizontalBox();    //����һ��ˮƽ����
		JLabel Phone = new JLabel("�绰");
		candidatePhone = new JTextField();
		fifth.add(Phone);
		fifth.add(Box.createRigidArea(new Dimension(47, 30)));
		fifth.add(candidatePhone);
		
		Box sixth = Box.createHorizontalBox();    //����һ��ˮƽ����
		JLabel IdCard = new JLabel("���֤");
		candidateIdCard = new JTextField();
		sixth.add(IdCard);
		sixth.add(Box.createRigidArea(new Dimension(36, 30)));
		sixth.add(candidateIdCard);
		
		Box seventh = Box.createHorizontalBox();    //����һ��ˮƽ����
		JLabel Email = new JLabel("����");
		candidateEmail = new JTextField();
		seventh.add(Email);
		seventh.add(Box.createRigidArea(new Dimension(47, 30)));
		seventh.add(candidateEmail);
		
		Box eighth  = Box.createHorizontalBox();    //����һ��ˮƽ����
		JLabel Address = new JLabel("��ַ");
		candidateAddress = new JTextField();
		eighth.add(Address);
		eighth.add(Box.createRigidArea(new Dimension(47, 30)));
		eighth.add(candidateAddress);
		
		Box ninth  = Box.createHorizontalBox();    //����һ��ˮƽ����
		JLabel Major = new JLabel("����רҵ");
		candidateMajor = new JTextField();
		ninth.add(Major);
		ninth.add(Box.createRigidArea(new Dimension(23, 30)));
		ninth.add(candidateMajor);
		
		Box tenth  = Box.createHorizontalBox();    //����һ��ˮƽ����
		JLabel Educationed = new JLabel("ѧ��");
		candidateEducationed = new JTextField();
		tenth.add(Educationed);
		tenth.add(Box.createRigidArea(new Dimension(47, 30)));
		tenth.add(candidateEducationed);
		
		Box eleventh  = Box.createHorizontalBox();    //����һ��ˮƽ����
		JLabel JobObjective = new JLabel("��ְ����");
		candidateJobObjective = new JTextField();
		eleventh.add(JobObjective);
		eleventh.add(Box.createRigidArea(new Dimension(23, 30)));
		eleventh.add(candidateJobObjective);
		
		Box twelfth  = Box.createHorizontalBox();    //����һ��ˮƽ����
		JLabel WorkExperience = new JLabel("��������");
		candidateWorkExperience = new JTextField();
		twelfth.add(WorkExperience);
		twelfth.add(Box.createRigidArea(new Dimension(23, 30)));
		twelfth.add(candidateWorkExperience);
		
		Box thirteenth  = Box.createHorizontalBox();    //����һ��ˮƽ����
		JLabel Account = new JLabel("�����˺�");
		candidateAccount = new JTextField();
		thirteenth.add(Account);
		thirteenth.add(Box.createRigidArea(new Dimension(23, 30)));
		thirteenth.add(candidateAccount);
		
		Box fourteenth  = Box.createHorizontalBox();    //����һ��ˮƽ����
		JLabel Password = new JLabel("��������");
		candidatePassword = new JPasswordField();
		fourteenth.add(Password);
		fourteenth.add(Box.createRigidArea(new Dimension(23, 30)));
		fourteenth.add(candidatePassword);
		
		Box fifteenth  = Box.createHorizontalBox();    //����һ��ˮƽ����
		JLabel Password2 = new JLabel("ȷ�ϸ�������");
		candidatePassword_two = new JPasswordField();
		fifteenth.add(Password2);
		//fifteenth.add(Box.createRigidArea(new Dimension(23, 30)));
		fifteenth.add(candidatePassword_two);
		
		center.add(first);
		center.add(second);
		center.add(third);
		center.add(fourth);
		center.add(fifth);
		center.add(sixth);
		center.add(seventh);
		center.add(eighth);
		center.add(ninth);
		center.add(tenth);
		center.add(eleventh);
		center.add(twelfth);
		center.add(thirteenth);
		center.add(fourteenth);
		center.add(fifteenth);
		
		JPanel west = new JPanel();
		//����
		sure = new ButtonFont("ȷ��ע��",f);
		Box south = Box.createHorizontalBox();//ˮƽ����
		south.add(Box.createRigidArea(new Dimension(340,0)));
		south.add(sure);
		//�ұ�
		JPanel east = new JPanel();
		
		c.add(east,BorderLayout.EAST);
		c.add(south,BorderLayout.SOUTH);
		c.add(west,BorderLayout.WEST);
		c.add(center,BorderLayout.CENTER);
	}
	
	public void jianting() {
		sure.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//String info1 = companyId.getText().trim();//��ȡ�ı��������,����ȥ����β�Ŀո�
				String info2 = candidateName.getText().trim();//��ȡ�ı��������,����ȥ����β�Ŀո�
				String info3 = candidateGender.getText().trim();//��ȡ�ı��������,����ȥ����β�Ŀո�
				String info4 = candidateAge.getText().trim();//��ȡ�ı��������,����ȥ����β�Ŀո�
				String info5 = candidatePhone.getText().trim();//��ȡ�ı��������,����ȥ����β�Ŀո�
				String info6 = candidateIdCard.getText().trim();//��ȡ�ı��������,����ȥ����β�Ŀո�
				String info7 = candidateEmail.getText().trim();//��ȡ�ı��������,����ȥ����β�Ŀո�
				String info8 = candidateAddress.getText().trim();//��ȡ�ı��������,����ȥ����β�Ŀո�
				String info9 = candidateMajor.getText().trim();//��ȡ�ı��������,����ȥ����β�Ŀո�
				String info10 = candidateEducationed.getText().trim();//��ȡ�ı��������,����ȥ����β�Ŀո�
				String info11 = candidateJobObjective.getText().trim();//��ȡ�ı��������,����ȥ����β�Ŀո�
				String info12 = candidateWorkExperience.getText().trim();//��ȡ�ı��������,����ȥ����β�Ŀո�
				String info13 = candidateAccount.getText().trim();//��ȡ�ı��������,����ȥ����β�Ŀո�
				String info14 = String.valueOf(candidatePassword.getPassword());//��ȡ�ı��������,����ȥ����β�Ŀո�
				String info15 = String.valueOf(candidatePassword_two.getPassword());//��ȡ�ı��������,����ȥ����β�Ŀո�
				
				Candidate newCandidate = new Candidate();   //�н����ݵĶ���
				Candidate bianli = new Candidate();       //���������Ķ���
				    
	            if(info2.equals("")) {
	                JOptionPane.showMessageDialog(null, "��������������");
	                return;
	            }
	            else if(info3.equals("")) {
	                JOptionPane.showMessageDialog(null, "�����������Ա�");
	                return;
	            }
	            else if(info4.equals("")) {
	                JOptionPane.showMessageDialog(null, "��������������");
	                return;
	            }
	            else if(info5.equals("")) {
	                JOptionPane.showMessageDialog(null, "���������ĵ绰");
	                return;
	            }
	            else if(info6.equals("")) {
	                JOptionPane.showMessageDialog(null, "�������������֤");
	                return;
	            }
	            else if(info7.equals("")) {
	                JOptionPane.showMessageDialog(null, "��������������");
	                return;
	            }
	            else if(info8.equals("")) {
	                JOptionPane.showMessageDialog(null, "���������ĵ�ַ");
	                return;
	            }
	            else if(info9.equals("")) {
	                JOptionPane.showMessageDialog(null, "��������������רҵ");
	                return;
	            }
	            else if(info10.equals("")) {
	                JOptionPane.showMessageDialog(null, "����������ѧ��");
	                return;
	            }
	            else if(info11.equals("")) {
	            	JOptionPane.showMessageDialog(null, "������������ְ����");
	                return;
	            }
	            else if(info12.equals("")) {
	            	JOptionPane.showMessageDialog(null, "���������Ĺ�������");
	                return;
	            }
	            else if(info13.equals("")) {
	            	JOptionPane.showMessageDialog(null, "�����������˺�");
	                return;
	            }
	            else if(info14.equals("")) {
	            	JOptionPane.showMessageDialog(null, "��������������");
	                return;
	            }
	            else if(!info15.equals(info14)) {
	                JOptionPane.showMessageDialog(null, "��ȷ�����������Ƿ���ȷ");
	                return;
	            }
	            else {
	            	JOptionPane.showMessageDialog(null, "ע��ɹ�!");
	            	int i = 0;
		        	for(i = 1;i < date.size();i++);
		        	i++;
		            newCandidate.setCandidateId(i);
		            newCandidate.setCandidateName(info2);
		            newCandidate.setCandidateGender(info3);
		            newCandidate.setCandidateAge(Integer.valueOf(info4).intValue());
		            newCandidate.setCandidatePhone(info5);
		            newCandidate.setCandidateIdCard(info6);
		            newCandidate.setCandidateEmail(info7);
		            newCandidate.setCandidateAddress(info8);
		            newCandidate.setCandidateMajor(info9);
		            newCandidate.setCandidateEducationed(info10);
		            newCandidate.setCandidateJobObjective(info11);
		            newCandidate.setCandidateWorkExperience(info12);
		            newCandidate.setCandidateAccount(info13);
		            newCandidate.setCandidatePassword(info14);
	            	CandidateDaoImpl candidateDao = new CandidateDaoImpl();
	            	CandidateServiceImpl candidateSeriver = new CandidateServiceImpl(candidateDao);
	            	candidateSeriver.addNewCandidate(newCandidate); 
	            	return;
	            }
		}});
	}
	
	private void readDatabase() {  //�����ݿ�
		CandidateServiceImpl candidateDate = new CandidateServiceImpl(new CandidateDaoImpl());
		date = new ArrayList();
		date = candidateDate.searchAll();
		for(int i = 0;i < date.size();i++) {
			System.out.println(date.get(i).getCandidateName());
		}
	}
	public static void main(String[] args) {
		new UserLoginGUI();
	}
}
