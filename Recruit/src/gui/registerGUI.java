package gui;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import bean.Candidate;
import bean.Company;
import dao.*;
import gui.customStyle.*;
import service.CandidateServiceImpl;
import service.CompanyServiceImpl;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import bean.*;
/**
 * 此为招聘系统的登录界面
 * 分为两部分：1.登录  两部分
 *         2.注册   
 * 通过按钮控制,右下角有一个注册按钮
 * 有两个大按钮  分别控制进入 公司的登录 还是 用户的登录    
 * @author 穆正阳
 *
 */

public class registerGUI extends JFrame{
	private JTextField accound;             //登录的id  
	private JPasswordField password;        //登录的密码
	//private Icon icon;                		//登录界面的图片
	private JRadioButton jrb_user;    		//按钮选择是公司
	private JRadioButton jrb_company;  		//按钮选择是用户
	private ButtonFont registerButton;		//注册按钮          
	private TextFieldFont tfdSearch;		//
	private List<Company> companyList;      //用来存储数据库中company里的数据
	private List<Candidate> candidateList;  //用来存储数据库中candidate里的数据
	private int hang;
	
    public registerGUI() {
    	this.setTitle("招聘系统--登录界面.");
    	try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} catch (UnsupportedLookAndFeelException e1) {			
			e1.printStackTrace();
		}
    	
    	this.init();
    	this.setResizable(true);
		this.setSize(450,380);
        this.setLocation(500, 200);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);		
		this.setVisible(true);
    }
    
	public void init() {
		
		Font f = new Font(StyleArgument.FONTNAME, StyleArgument.FONTSTYLE,StyleArgument.FONTSIZE);
    	Container c = this.getContentPane();
		c.setLayout(new BorderLayout(20,10));       //设置组件之间的间距
    	//上面部分
		Icon icon = new ImageIcon(this.getClass().getResource("img/logosmall.jpg"));
		//icon
		JLabel lblImage = new JLabel(icon);
		
    	//中间部分
    	Box first_Box = Box.createHorizontalBox();	//创建一个水平盒子
    	accound = new JTextField();                  	//文本框
    	JLabel jlb_id = new JLabel("账号:");
    	first_Box.add(jlb_id);
    	first_Box.add(Box.createRigidArea(new Dimension(20, 30)));
    	first_Box.add(accound);
    	
    	Box twice_Box = Box.createHorizontalBox();
    	JLabel jlb_password = new JLabel("密码:");
    	password  = new JPasswordField();
    	password.setSize(100,50);
    	twice_Box.add(jlb_password);
    	twice_Box.add(Box.createRigidArea(new Dimension(20, 30)));
    	twice_Box.add(password);
    	
    	Box center = Box.createVerticalBox();     //创建一个垂直盒子
    	center.add(first_Box);
    	center.add(twice_Box);
    	
		//下面    登录按钮  注册按钮  
		ButtonFont loginButton = new ButtonFont("登录",f);
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String info1 = accound.getText().trim();
				String info2 = String.valueOf(password.getPassword());
				
				if((!jrb_company.isSelected()) && (!jrb_user.isSelected())) {
					JOptionPane.showMessageDialog(null, "请选择登录选项","提示",JOptionPane.WARNING_MESSAGE); 
					return ;
				}
				if(info1.equals("")) {
					 JOptionPane.showMessageDialog(null, "请输入您的账号");
		             return;
				}
				else if(info2.equals("")) {
					 JOptionPane.showMessageDialog(null, "请输入您的密码");
		             return;
				}
				/**
				 * 这里是有确保账号要存在的代码
				 * 同时要确定该账号的密码确定要正确
				 */
				if(jrb_company.isSelected()) {
					Company newC = new Company();
					//System.out.println(id.getText().trim());//获取文本框的内容,并且去掉首尾的空格);
					//System.out.println(String.valueOf(password.getPassword()));
					CompanyDao companyDao = new CompanyDaoImpl();
					CompanyServiceImpl companySeriver = new CompanyServiceImpl(companyDao);
					companyList = companySeriver.searchAll();
					int biaozhi = 0;
					int i = 0;
					for(i = 0;i < companyList.size();i++) {
						if(accound.getText().trim().equals(companyList.get(i).getCompanyAccount())) {
							newC = companyList.get(i);
							newC.toString(); 
							biaozhi = 1;    //标志位，为1就是有过了
							break;
						}
					}
					if(biaozhi == 1) {
						
						if(String.valueOf(password.getPassword()).equals(companyList.get(i).getCompanyPassword())) {
							//new  这里要new一个新的界面了！ 
							//JOptionPane.showMessageDialog(null, "登录成功!");
							windowClosingCompany();
							/**
							 * 这里要有一个新界面了,下面是传的id newC.getCompanyId()
							 *//*
							System.out.println(newC.getCompanyId());
							*/
							
							 dispose();//本窗口销毁,释放内存资源
				            return;
						}else {
							JOptionPane.showMessageDialog(null, "您的账号或密码输入错误，请重新输入!");
				            return;
						}
						
					}else {
						JOptionPane.showMessageDialog(null, "您的账号或密码输入错误，请重新输入!");
			            return;
					}	
				}
				
				else if(jrb_user.isSelected()) {
					Candidate newC = new Candidate();
					CandidateDaoImpl candidateDao = new CandidateDaoImpl();
					CandidateServiceImpl candidateSerive = new CandidateServiceImpl(candidateDao);
					candidateList = candidateSerive.searchAll();
					System.out.println(candidateList);
					int biaozhi = 0;
					int i = 0;
					for(i = 0;i < candidateList.size();i++) {
						//System.out.println(candidateList.get(i).getCandidateAccount());
						if(accound.getText().trim().equals(candidateList.get(i).getCandidateAccount())) {
							newC = candidateList.get(i);
							biaozhi = 1;
				            break;
						}
					}
					if(biaozhi == 1) {
						
						if(String.valueOf(password.getPassword()).equals(candidateList.get(i).getCandidatePassword())) {
							//new  这里要new一个新的界面了！ 
							JOptionPane.showMessageDialog(null, "登录成功!");
							try {
								new CandidateMainGUI(newC.getCandidateId());
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
			                dispose();//本窗口销毁,释放内存资源
						}else {
							
							JOptionPane.showMessageDialog(null, "您的账号或密码输入错误，请重新输入!");
				            return;
						}
					}else {
						System.out.println(newC);
						JOptionPane.showMessageDialog(null, "您的账号或密码输入错误，请重新输入!");
			            return;
					}
				}
			}
		});
		
		ButtonFont registerButton = new ButtonFont("注册",f);
		registerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(!jrb_company.isSelected() && !jrb_user.isSelected()) {
					JOptionPane.showMessageDialog(null, "请选择右下角的注册选项","提示",JOptionPane.WARNING_MESSAGE); 
					return ;
				}
				if(jrb_company.isSelected()) {
					new CompanyLoginGUI();
				}
				else if(jrb_user.isSelected()) {
					new UserLoginGUI();
				}
			}
		});
		
		ButtonFont exitButton = new ButtonFont("退出",f);
		exitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "成功退出!");
				windowClosingCompany();
			}	
		});
		
		Box south = Box.createVerticalBox();        //下面的盒子  垂直盒子
		Box first_below = Box.createHorizontalBox();//水平盒子用来放登录注册
		first_below.add(Box.createRigidArea(new Dimension(165, 30)));
		first_below.add(loginButton);
		first_below.add(registerButton);
		//first_below.add(Box.createRigidArea(new Dimension(100, 30)));
		first_below.add(exitButton);
		
		Box twice_below = Box.createHorizontalBox();//水平盒子用来选择是谁来登录
		jrb_user = new JRadioButton("应聘者");
		jrb_user.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(jrb_user.isSelected()) {
					jrb_company.setSelected(false);
								
				}else{
					
				}
		}});
		jrb_company = new JRadioButton("公司");		
		jrb_company.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(jrb_company.isSelected()) {
					jrb_user.setSelected(false);
				}else {
					
				}
			}
		});
		
		twice_below.add(Box.createRigidArea(new Dimension(250, 30)));
		twice_below.add(jrb_user);
		twice_below.add(jrb_company);
		south.add(first_below);
		south.add(Box.createHorizontalGlue());//添加了一个胶水
		south.add(twice_below);
		//右边
		JPanel east = new JPanel();
		//左边
		JPanel west = new JPanel();
		
		c.add(west,BorderLayout.WEST);
		c.add(east,BorderLayout.EAST);
		c.add(south,BorderLayout.SOUTH);
		c.add(center,BorderLayout.CENTER);
		c.add(lblImage,BorderLayout.NORTH);
	}
	public void windowClosingCandidate() {
		this.setVisible(false);
		//
		dispose();
	}
	public void windowClosingCompany() {
		this.setVisible(false);
		//
		dispose();
	}
	private void readcompanyDatabase() {  //读数据库
		CompanyServiceImpl companyDate = new CompanyServiceImpl(new CompanyDaoImpl());  //面向接口
		companyList = companyDate.searchAll();   //date获取数据库的数据
	}
	
	private void readcandidateDatabase() {  //读数据库
		CandidateServiceImpl candidateDate = new CandidateServiceImpl(new CandidateDaoImpl());  //面向接口
		//candidatedate = new ArrayList(); 
		//candidatedate = candidateDate.searchAll();   //date获取数据库的数据
	}


	public int getHang() {
		return hang;
	}

	public void setHang(int hang) {
		this.hang = hang;
	}

	public static void main(String[] args) {
		new registerGUI();
	}

	public JTextField getAccound() {
		return accound;
	}

	public void setAccound(JTextField accound) {
		this.accound = accound;
	}

	public JPasswordField getPassword() {
		return password;
	}

	public void setPassword(JPasswordField password) {
		this.password = password;
	}

	public JRadioButton getJrb_user() {
		return jrb_user;
	}

	public void setJrb_user(JRadioButton jrb_user) {
		this.jrb_user = jrb_user;
	}

	public JRadioButton getJrb_company() {
		return jrb_company;
	}

	public void setJrb_company(JRadioButton jrb_company) {
		this.jrb_company = jrb_company;
	}

	public ButtonFont getRegisterButton() {
		return registerButton;
	}

	public void setRegisterButton(ButtonFont registerButton) {
		this.registerButton = registerButton;
	}

	public TextFieldFont getTfdSearch() {
		return tfdSearch;
	}

	public void setTfdSearch(TextFieldFont tfdSearch) {
		this.tfdSearch = tfdSearch;
	}

	public List<Company> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<Company> companyList) {
		this.companyList = companyList;
	}

	public List<Candidate> getCandidateList() {
		return candidateList;
	}

	public void setCandidateList(List<Candidate> candidateList) {
		this.candidateList = candidateList;
	}
	
}
