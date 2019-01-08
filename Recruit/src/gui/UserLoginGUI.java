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
 * @Description 该界面使用户的注册界面
 * @data 2019年1月3日
 */
public class UserLoginGUI extends JFrame {
	private JLabel candidateId;            		 //应聘者ID
	private JTextField candidateName;			 //应聘者姓名
	private JTextField candidateGender;			 //应聘者性别
	private JTextField candidateAge;             //应聘者年龄 
	private JTextField candidatePhone;			 //应聘者手机
	private JTextField candidateIdCard;			 //应聘者身份证
	private JTextField candidateEmail;			 //应聘者Email
	private JTextField candidateAddress;		 //应聘者家庭住址
	private JTextField candidateMajor;			 //应聘者专业
	private JTextField candidateEducationed;	 //应聘者学历
	private JTextField candidateJobObjective;	 //应聘者求职意向
	private JTextField candidateWorkExperience;  //应聘者工作经验
	private JTextField candidateAccount;		 //应聘者账号
	private JPasswordField candidatePassword;	 //应聘者密码
	private JPasswordField candidatePassword_two;//应聘者重复输入密码
	private ButtonFont sure;                     //确认注册的按钮
	private List<Candidate> date;                //从数据库中读取数据的存储容器
	
	public UserLoginGUI() {
		super("应聘者注册界面");
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
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	//关闭该界面不会使父界面也关闭	
		this.setVisible(true);
	}
	
	public void init() {
		
		Font f = new Font(StyleArgument.FONTNAME, StyleArgument.FONTSTYLE,StyleArgument.FONTSIZE);
		Container c = this.getContentPane();
		c.setLayout(new BorderLayout(20,10));       //设置组件之间的间距
		//中间
		Box center = Box.createVerticalBox();       //创建一个垂直盒子
		 
		Box first = Box.createHorizontalBox();      //创建一个水平盒子
		JLabel id = new JLabel("id");
		int i = 0;
		for(i = 1;i < date.size();i++);
		i++;
		candidateId = new JLabel(i+"");
		first.add(id);
		first.add(Box.createRigidArea(new Dimension(65, 30))); //添加一个看不见的组件Glue
		first.add(candidateId);
		first.add(Box.createRigidArea(new Dimension(365, 30))); //添加一个看不见的组件Glue
		
		Box second = Box.createHorizontalBox();    //创建一个水平盒子
		JLabel Name = new JLabel("姓名");
		candidateName = new JTextField();
		second.add(Name);
		second.add(Box.createRigidArea(new Dimension(47, 30)));
		second.add(candidateName);
		
		Box third  = Box.createHorizontalBox();    //创建一个水平盒子
		JLabel Gender = new JLabel("性别");
		candidateGender = new JTextField();
		third.add(Gender);
		third.add(Box.createRigidArea(new Dimension(47, 30)));
		third.add(candidateGender);
		
		Box fourth  = Box.createHorizontalBox();    //创建一个水平盒子
		JLabel Age = new JLabel("年龄");
		candidateAge = new JTextField();
		fourth.add(Age);
		fourth.add(Box.createRigidArea(new Dimension(47, 30)));
		fourth.add(candidateAge);
		
		Box fifth  = Box.createHorizontalBox();    //创建一个水平盒子
		JLabel Phone = new JLabel("电话");
		candidatePhone = new JTextField();
		fifth.add(Phone);
		fifth.add(Box.createRigidArea(new Dimension(47, 30)));
		fifth.add(candidatePhone);
		
		Box sixth = Box.createHorizontalBox();    //创建一个水平盒子
		JLabel IdCard = new JLabel("身份证");
		candidateIdCard = new JTextField();
		sixth.add(IdCard);
		sixth.add(Box.createRigidArea(new Dimension(36, 30)));
		sixth.add(candidateIdCard);
		
		Box seventh = Box.createHorizontalBox();    //创建一个水平盒子
		JLabel Email = new JLabel("邮箱");
		candidateEmail = new JTextField();
		seventh.add(Email);
		seventh.add(Box.createRigidArea(new Dimension(47, 30)));
		seventh.add(candidateEmail);
		
		Box eighth  = Box.createHorizontalBox();    //创建一个水平盒子
		JLabel Address = new JLabel("地址");
		candidateAddress = new JTextField();
		eighth.add(Address);
		eighth.add(Box.createRigidArea(new Dimension(47, 30)));
		eighth.add(candidateAddress);
		
		Box ninth  = Box.createHorizontalBox();    //创建一个水平盒子
		JLabel Major = new JLabel("主修专业");
		candidateMajor = new JTextField();
		ninth.add(Major);
		ninth.add(Box.createRigidArea(new Dimension(23, 30)));
		ninth.add(candidateMajor);
		
		Box tenth  = Box.createHorizontalBox();    //创建一个水平盒子
		JLabel Educationed = new JLabel("学历");
		candidateEducationed = new JTextField();
		tenth.add(Educationed);
		tenth.add(Box.createRigidArea(new Dimension(47, 30)));
		tenth.add(candidateEducationed);
		
		Box eleventh  = Box.createHorizontalBox();    //创建一个水平盒子
		JLabel JobObjective = new JLabel("求职意向");
		candidateJobObjective = new JTextField();
		eleventh.add(JobObjective);
		eleventh.add(Box.createRigidArea(new Dimension(23, 30)));
		eleventh.add(candidateJobObjective);
		
		Box twelfth  = Box.createHorizontalBox();    //创建一个水平盒子
		JLabel WorkExperience = new JLabel("工作经历");
		candidateWorkExperience = new JTextField();
		twelfth.add(WorkExperience);
		twelfth.add(Box.createRigidArea(new Dimension(23, 30)));
		twelfth.add(candidateWorkExperience);
		
		Box thirteenth  = Box.createHorizontalBox();    //创建一个水平盒子
		JLabel Account = new JLabel("个人账号");
		candidateAccount = new JTextField();
		thirteenth.add(Account);
		thirteenth.add(Box.createRigidArea(new Dimension(23, 30)));
		thirteenth.add(candidateAccount);
		
		Box fourteenth  = Box.createHorizontalBox();    //创建一个水平盒子
		JLabel Password = new JLabel("个人密码");
		candidatePassword = new JPasswordField();
		fourteenth.add(Password);
		fourteenth.add(Box.createRigidArea(new Dimension(23, 30)));
		fourteenth.add(candidatePassword);
		
		Box fifteenth  = Box.createHorizontalBox();    //创建一个水平盒子
		JLabel Password2 = new JLabel("确认个人密码");
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
		//下面
		sure = new ButtonFont("确定注册",f);
		Box south = Box.createHorizontalBox();//水平盒子
		south.add(Box.createRigidArea(new Dimension(340,0)));
		south.add(sure);
		//右边
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
				//String info1 = companyId.getText().trim();//获取文本框的内容,并且去掉首尾的空格
				String info2 = candidateName.getText().trim();//获取文本框的内容,并且去掉首尾的空格
				String info3 = candidateGender.getText().trim();//获取文本框的内容,并且去掉首尾的空格
				String info4 = candidateAge.getText().trim();//获取文本框的内容,并且去掉首尾的空格
				String info5 = candidatePhone.getText().trim();//获取文本框的内容,并且去掉首尾的空格
				String info6 = candidateIdCard.getText().trim();//获取文本框的内容,并且去掉首尾的空格
				String info7 = candidateEmail.getText().trim();//获取文本框的内容,并且去掉首尾的空格
				String info8 = candidateAddress.getText().trim();//获取文本框的内容,并且去掉首尾的空格
				String info9 = candidateMajor.getText().trim();//获取文本框的内容,并且去掉首尾的空格
				String info10 = candidateEducationed.getText().trim();//获取文本框的内容,并且去掉首尾的空格
				String info11 = candidateJobObjective.getText().trim();//获取文本框的内容,并且去掉首尾的空格
				String info12 = candidateWorkExperience.getText().trim();//获取文本框的内容,并且去掉首尾的空格
				String info13 = candidateAccount.getText().trim();//获取文本框的内容,并且去掉首尾的空格
				String info14 = String.valueOf(candidatePassword.getPassword());//获取文本框的内容,并且去掉首尾的空格
				String info15 = String.valueOf(candidatePassword_two.getPassword());//获取文本框的内容,并且去掉首尾的空格
				
				Candidate newCandidate = new Candidate();   //承接数据的对象
				Candidate bianli = new Candidate();       //用来遍历的对象
				    
	            if(info2.equals("")) {
	                JOptionPane.showMessageDialog(null, "请输入您的姓名");
	                return;
	            }
	            else if(info3.equals("")) {
	                JOptionPane.showMessageDialog(null, "请输入您的性别");
	                return;
	            }
	            else if(info4.equals("")) {
	                JOptionPane.showMessageDialog(null, "请输入您的年龄");
	                return;
	            }
	            else if(info5.equals("")) {
	                JOptionPane.showMessageDialog(null, "请输入您的电话");
	                return;
	            }
	            else if(info6.equals("")) {
	                JOptionPane.showMessageDialog(null, "请输入您的身份证");
	                return;
	            }
	            else if(info7.equals("")) {
	                JOptionPane.showMessageDialog(null, "请输入您的邮箱");
	                return;
	            }
	            else if(info8.equals("")) {
	                JOptionPane.showMessageDialog(null, "请输入您的地址");
	                return;
	            }
	            else if(info9.equals("")) {
	                JOptionPane.showMessageDialog(null, "请输入您的主修专业");
	                return;
	            }
	            else if(info10.equals("")) {
	                JOptionPane.showMessageDialog(null, "请输入您的学历");
	                return;
	            }
	            else if(info11.equals("")) {
	            	JOptionPane.showMessageDialog(null, "请输入您的求职意向");
	                return;
	            }
	            else if(info12.equals("")) {
	            	JOptionPane.showMessageDialog(null, "请输入您的工作经验");
	                return;
	            }
	            else if(info13.equals("")) {
	            	JOptionPane.showMessageDialog(null, "请输入您的账号");
	                return;
	            }
	            else if(info14.equals("")) {
	            	JOptionPane.showMessageDialog(null, "请输入您的密码");
	                return;
	            }
	            else if(!info15.equals(info14)) {
	                JOptionPane.showMessageDialog(null, "请确认您的密码是否正确");
	                return;
	            }
	            else {
	            	JOptionPane.showMessageDialog(null, "注册成功!");
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
	
	private void readDatabase() {  //读数据库
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
