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
import bean.Company;
import dao.CompanyDaoImpl;
import gui.customStyle.ButtonFont;
import gui.customStyle.StyleArgument;
import service.CompanyService;
import service.CompanyServiceImpl;

/**
 * @author 穆正阳
 * @Description 该界面使公司的注册界面
 * @data 2019年1月3日
 */
public class CompanyLoginGUI extends JFrame{
	
	private JLabel companyId;            	    //公司id  
	private JTextField companyName;          	//公司名字
	private JTextField companyAddress;		 	//公司的地址
	private JTextField companyType; 		 	//公司的类型
	private JTextField companyLegalPerson;   	//公司的法人
	private JTextField companyEmail;         	//公司的邮箱
	private JTextField companyPhone;		 	//公司的电话
	private JTextField companyCaptial;		 	//公司的注册资本
	private JTextField companyAccount;		 	//公司的账号
	private JPasswordField companyPassword;	 	//公司的密码
	private JPasswordField companyPassword_two;	//公司的密码
	private ButtonFont sure;                    //确认注册的按钮
	private List<Company> date;                 //从数据库中读取数据的存储容器

	
	public CompanyLoginGUI() {
		super("公司注册界面");
		try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} catch (UnsupportedLookAndFeelException e1) {			
			e1.printStackTrace();
		}
		this.readDatabase();
    	this.init();
    	this.jianting();
    	this.setResizable(true);
		this.setSize(450,450);
        this.setLocation(100, 200);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);		//关闭该界面不会使父界面也关闭
		this.setVisible(true);
	}
	
	public void init() {
		
		Font f = new Font(StyleArgument.FONTNAME, StyleArgument.FONTSTYLE,StyleArgument.FONTSIZE);
		Container c = this.getContentPane();
		c.setLayout(new BorderLayout(20,10));       //设置组件之间的间距
		//中间
		Box center = Box.createVerticalBox();      //创建一个垂直盒子
		
		Box first = Box.createHorizontalBox();     //创建一个水平盒子
		JLabel id = new JLabel("id");
		int i = 0;
		for(i = 1;i < date.size();i++);
		i++;
		companyId = new JLabel(i+"");
		first.add(id);
		first.add(Box.createRigidArea(new Dimension(70, 30))); //添加一个看不见的组件Glue
		first.add(companyId);
		first.add(Box.createRigidArea(new Dimension(280, 30))); //添加一个看不见的组件Glue
		
		Box second = Box.createHorizontalBox();    //创建一个水平盒子
		JLabel Name = new JLabel("公司名称");
		companyName = new JTextField();
		second.add(Name);
		second.add(Box.createRigidArea(new Dimension(23, 30)));
		second.add(companyName);
		
		Box third = Box.createHorizontalBox();    //创建一个水平盒子
		JLabel Address = new JLabel("公司地址");
		companyAddress = new JTextField();
		third.add(Address);
		third.add(Box.createRigidArea(new Dimension(23, 30)));
		third.add(companyAddress);
		
		Box fourth = Box.createHorizontalBox();    //创建一个水平盒子
		JLabel Type = new JLabel("公司类型");
		companyType = new JTextField();
		fourth.add(Type);
		fourth.add(Box.createRigidArea(new Dimension(23, 30)));
		fourth.add(companyType);
		
		Box fifth = Box.createHorizontalBox();    //创建一个水平盒子
		JLabel LegalPerson = new JLabel("公司法人");
		companyLegalPerson = new JTextField();
		fifth.add(LegalPerson);
		fifth.add(Box.createRigidArea(new Dimension(23, 30)));
		fifth.add(companyLegalPerson);
		
		Box sixth = Box.createHorizontalBox();    //创建一个水平盒子
		JLabel Email = new JLabel("公司邮箱");
		companyEmail = new JTextField();
		sixth.add(Email);
		sixth.add(Box.createRigidArea(new Dimension(23, 30)));
		sixth.add(companyEmail);
		
		Box seventh = Box.createHorizontalBox();    //创建一个水平盒子
		JLabel Phone = new JLabel("公司电话");
		companyPhone = new JTextField();
		seventh.add(Phone);
		seventh.add(Box.createRigidArea(new Dimension(23, 30)));
		seventh.add(companyPhone);
		
		Box eighth = Box.createHorizontalBox();    //创建一个水平盒子
		JLabel Captiial = new JLabel("公司注册资本");
		companyCaptial = new JTextField();
		eighth.add(Captiial);
		eighth.add(companyCaptial);
		
		Box ninth = Box.createHorizontalBox();    //创建一个水平盒子
		JLabel Account = new JLabel("公司账号");
		companyAccount = new JTextField();
		ninth.add(Account);
		ninth.add(Box.createRigidArea(new Dimension(23, 30)));
		ninth.add(companyAccount);
		
		Box tenth = Box.createHorizontalBox();    //创建一个水平盒子
		JLabel Password = new JLabel("公司密码");
		companyPassword = new JPasswordField();
		tenth.add(Password);
		tenth.add(Box.createRigidArea(new Dimension(23, 30)));
		tenth.add(companyPassword);
		
		Box elvenlth = Box.createHorizontalBox();  //创建一个水平盒子
		JLabel Password2 = new JLabel("确认公司密码");
		companyPassword_two = new JPasswordField();
		elvenlth.add(Password2);
		elvenlth.add(companyPassword_two);
		
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
		center.add(elvenlth);
		//左边
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
	
	public void jianting() {       //监听函数
		sure.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//String info1 = companyId.getText().trim();//获取文本框的内容,并且去掉首尾的空格
				String info2 = companyName.getText().trim();//获取文本框的内容,并且去掉首尾的空格
				String info3 = companyAddress.getText().trim();//获取文本框的内容,并且去掉首尾的空格
				String info4 = companyType.getText().trim();//获取文本框的内容,并且去掉首尾的空格
				String info5 = companyLegalPerson.getText().trim();//获取文本框的内容,并且去掉首尾的空格
				String info6 = companyEmail.getText().trim();//获取文本框的内容,并且去掉首尾的空格
				String info7 = companyPhone.getText().trim();//获取文本框的内容,并且去掉首尾的空格
				String info8 = companyCaptial.getText().trim();//获取文本框的内容,并且去掉首尾的空格
				String info9 = companyAccount.getText().trim();//获取文本框的内容,并且去掉首尾的空格
				String info10 = String.valueOf(companyPassword.getPassword());//获取文本框的内容,并且去掉首尾的空格
				String info11 = String.valueOf(companyPassword_two.getPassword());//获取文本框的内容,并且去掉首尾的空格
				
				Company newCompany = new Company();   //承接数据的对象
                Company bianli = new Company();       //用来遍历的对象
				    
	            if(info2.equals("")) {
	                JOptionPane.showMessageDialog(null, "请输入公司名字");
	                return;
	            }
	            else if(info3.equals("")) {
	                JOptionPane.showMessageDialog(null, "请输入公司的地址");
	                return;
	            }
	            else if(info4.equals("")) {
	                JOptionPane.showMessageDialog(null, "请输入公司的类型");
	                return;
	            }
	            else if(info5.equals("")) {
	                JOptionPane.showMessageDialog(null, "请输入公司的法人");
	                return;
	            }
	            else if(info6.equals("")) {
	                JOptionPane.showMessageDialog(null, "请输入公司的邮箱");
	                return;
	            }
	            else if(info7.equals("")) {
	                JOptionPane.showMessageDialog(null, "请输入公司的电话");
	                return;
	            }
	            else if(info8.equals("")) {
	                JOptionPane.showMessageDialog(null, "请输入公司的注册资本");
	                return;
	            }
	            else if(info9.equals("")) {
	                JOptionPane.showMessageDialog(null, "请输入公司的账号");
	                return;
	            }
	            else if(info10.equals("")) {
	                JOptionPane.showMessageDialog(null, "请输入公司的密码");
	                return;
	            }
	            else if(!info11.equals(info10)) {
	                JOptionPane.showMessageDialog(null, "请确认重复输入的密码是正确的");
	                return;
	            }
	            else {
	            	JOptionPane.showMessageDialog(null, "注册成功！");
	            	int i = 0;
		        	for(i = 1;i < date.size();i++);
		        	i++;
		            newCompany.setCompanyId(i);
		            newCompany.setCompanyName(info2);
		            newCompany.setCompanyAddress(info3);
		            newCompany.setCompanyType(info4);
		            newCompany.setCompanyLegalPerson(info5);
		            newCompany.setCompanyEmail(info6);
		            newCompany.setCompanyPhone(info7);
		            newCompany.setCompanyCaptial(info8);
		            newCompany.setCompanyAccount(info9);
		            newCompany.setCompanyPassword(info10);
	            	CompanyService companySeriver3 = new CompanyServiceImpl(new CompanyDaoImpl());
	            	companySeriver3.addNewCompany(newCompany);  
	            	return;
	            }
		}});
	}
	private void readDatabase() {  //读数据库
		CompanyService companyDate = new CompanyServiceImpl(new CompanyDaoImpl());  //面向接口
		date = new ArrayList(); 
		date = companyDate.searchAll();   //date获取数据库的数据
		/*
		for(int i = 0;i < date.size();i++) {
			System.out.println(date.get(i).getCompanyName());
		}
		*/
	}
	
	public static void main(String[] args) {
		new CompanyLoginGUI();
	}
}
