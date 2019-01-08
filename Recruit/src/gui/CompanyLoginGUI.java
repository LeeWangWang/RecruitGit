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
 * @author ������
 * @Description �ý���ʹ��˾��ע�����
 * @data 2019��1��3��
 */
public class CompanyLoginGUI extends JFrame{
	
	private JLabel companyId;            	    //��˾id  
	private JTextField companyName;          	//��˾����
	private JTextField companyAddress;		 	//��˾�ĵ�ַ
	private JTextField companyType; 		 	//��˾������
	private JTextField companyLegalPerson;   	//��˾�ķ���
	private JTextField companyEmail;         	//��˾������
	private JTextField companyPhone;		 	//��˾�ĵ绰
	private JTextField companyCaptial;		 	//��˾��ע���ʱ�
	private JTextField companyAccount;		 	//��˾���˺�
	private JPasswordField companyPassword;	 	//��˾������
	private JPasswordField companyPassword_two;	//��˾������
	private ButtonFont sure;                    //ȷ��ע��İ�ť
	private List<Company> date;                 //�����ݿ��ж�ȡ���ݵĴ洢����

	
	public CompanyLoginGUI() {
		super("��˾ע�����");
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
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);		//�رոý��治��ʹ������Ҳ�ر�
		this.setVisible(true);
	}
	
	public void init() {
		
		Font f = new Font(StyleArgument.FONTNAME, StyleArgument.FONTSTYLE,StyleArgument.FONTSIZE);
		Container c = this.getContentPane();
		c.setLayout(new BorderLayout(20,10));       //�������֮��ļ��
		//�м�
		Box center = Box.createVerticalBox();      //����һ����ֱ����
		
		Box first = Box.createHorizontalBox();     //����һ��ˮƽ����
		JLabel id = new JLabel("id");
		int i = 0;
		for(i = 1;i < date.size();i++);
		i++;
		companyId = new JLabel(i+"");
		first.add(id);
		first.add(Box.createRigidArea(new Dimension(70, 30))); //���һ�������������Glue
		first.add(companyId);
		first.add(Box.createRigidArea(new Dimension(280, 30))); //���һ�������������Glue
		
		Box second = Box.createHorizontalBox();    //����һ��ˮƽ����
		JLabel Name = new JLabel("��˾����");
		companyName = new JTextField();
		second.add(Name);
		second.add(Box.createRigidArea(new Dimension(23, 30)));
		second.add(companyName);
		
		Box third = Box.createHorizontalBox();    //����һ��ˮƽ����
		JLabel Address = new JLabel("��˾��ַ");
		companyAddress = new JTextField();
		third.add(Address);
		third.add(Box.createRigidArea(new Dimension(23, 30)));
		third.add(companyAddress);
		
		Box fourth = Box.createHorizontalBox();    //����һ��ˮƽ����
		JLabel Type = new JLabel("��˾����");
		companyType = new JTextField();
		fourth.add(Type);
		fourth.add(Box.createRigidArea(new Dimension(23, 30)));
		fourth.add(companyType);
		
		Box fifth = Box.createHorizontalBox();    //����һ��ˮƽ����
		JLabel LegalPerson = new JLabel("��˾����");
		companyLegalPerson = new JTextField();
		fifth.add(LegalPerson);
		fifth.add(Box.createRigidArea(new Dimension(23, 30)));
		fifth.add(companyLegalPerson);
		
		Box sixth = Box.createHorizontalBox();    //����һ��ˮƽ����
		JLabel Email = new JLabel("��˾����");
		companyEmail = new JTextField();
		sixth.add(Email);
		sixth.add(Box.createRigidArea(new Dimension(23, 30)));
		sixth.add(companyEmail);
		
		Box seventh = Box.createHorizontalBox();    //����һ��ˮƽ����
		JLabel Phone = new JLabel("��˾�绰");
		companyPhone = new JTextField();
		seventh.add(Phone);
		seventh.add(Box.createRigidArea(new Dimension(23, 30)));
		seventh.add(companyPhone);
		
		Box eighth = Box.createHorizontalBox();    //����һ��ˮƽ����
		JLabel Captiial = new JLabel("��˾ע���ʱ�");
		companyCaptial = new JTextField();
		eighth.add(Captiial);
		eighth.add(companyCaptial);
		
		Box ninth = Box.createHorizontalBox();    //����һ��ˮƽ����
		JLabel Account = new JLabel("��˾�˺�");
		companyAccount = new JTextField();
		ninth.add(Account);
		ninth.add(Box.createRigidArea(new Dimension(23, 30)));
		ninth.add(companyAccount);
		
		Box tenth = Box.createHorizontalBox();    //����һ��ˮƽ����
		JLabel Password = new JLabel("��˾����");
		companyPassword = new JPasswordField();
		tenth.add(Password);
		tenth.add(Box.createRigidArea(new Dimension(23, 30)));
		tenth.add(companyPassword);
		
		Box elvenlth = Box.createHorizontalBox();  //����һ��ˮƽ����
		JLabel Password2 = new JLabel("ȷ�Ϲ�˾����");
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
		//���
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
	
	public void jianting() {       //��������
		sure.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//String info1 = companyId.getText().trim();//��ȡ�ı��������,����ȥ����β�Ŀո�
				String info2 = companyName.getText().trim();//��ȡ�ı��������,����ȥ����β�Ŀո�
				String info3 = companyAddress.getText().trim();//��ȡ�ı��������,����ȥ����β�Ŀո�
				String info4 = companyType.getText().trim();//��ȡ�ı��������,����ȥ����β�Ŀո�
				String info5 = companyLegalPerson.getText().trim();//��ȡ�ı��������,����ȥ����β�Ŀո�
				String info6 = companyEmail.getText().trim();//��ȡ�ı��������,����ȥ����β�Ŀո�
				String info7 = companyPhone.getText().trim();//��ȡ�ı��������,����ȥ����β�Ŀո�
				String info8 = companyCaptial.getText().trim();//��ȡ�ı��������,����ȥ����β�Ŀո�
				String info9 = companyAccount.getText().trim();//��ȡ�ı��������,����ȥ����β�Ŀո�
				String info10 = String.valueOf(companyPassword.getPassword());//��ȡ�ı��������,����ȥ����β�Ŀո�
				String info11 = String.valueOf(companyPassword_two.getPassword());//��ȡ�ı��������,����ȥ����β�Ŀո�
				
				Company newCompany = new Company();   //�н����ݵĶ���
                Company bianli = new Company();       //���������Ķ���
				    
	            if(info2.equals("")) {
	                JOptionPane.showMessageDialog(null, "�����빫˾����");
	                return;
	            }
	            else if(info3.equals("")) {
	                JOptionPane.showMessageDialog(null, "�����빫˾�ĵ�ַ");
	                return;
	            }
	            else if(info4.equals("")) {
	                JOptionPane.showMessageDialog(null, "�����빫˾������");
	                return;
	            }
	            else if(info5.equals("")) {
	                JOptionPane.showMessageDialog(null, "�����빫˾�ķ���");
	                return;
	            }
	            else if(info6.equals("")) {
	                JOptionPane.showMessageDialog(null, "�����빫˾������");
	                return;
	            }
	            else if(info7.equals("")) {
	                JOptionPane.showMessageDialog(null, "�����빫˾�ĵ绰");
	                return;
	            }
	            else if(info8.equals("")) {
	                JOptionPane.showMessageDialog(null, "�����빫˾��ע���ʱ�");
	                return;
	            }
	            else if(info9.equals("")) {
	                JOptionPane.showMessageDialog(null, "�����빫˾���˺�");
	                return;
	            }
	            else if(info10.equals("")) {
	                JOptionPane.showMessageDialog(null, "�����빫˾������");
	                return;
	            }
	            else if(!info11.equals(info10)) {
	                JOptionPane.showMessageDialog(null, "��ȷ���ظ��������������ȷ��");
	                return;
	            }
	            else {
	            	JOptionPane.showMessageDialog(null, "ע��ɹ���");
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
	private void readDatabase() {  //�����ݿ�
		CompanyService companyDate = new CompanyServiceImpl(new CompanyDaoImpl());  //����ӿ�
		date = new ArrayList(); 
		date = companyDate.searchAll();   //date��ȡ���ݿ������
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
