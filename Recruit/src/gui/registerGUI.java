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
 * ��Ϊ��Ƹϵͳ�ĵ�¼����
 * ��Ϊ�����֣�1.��¼  ������
 *         2.ע��   
 * ͨ����ť����,���½���һ��ע�ᰴť
 * ��������ť  �ֱ���ƽ��� ��˾�ĵ�¼ ���� �û��ĵ�¼    
 * @author ������
 *
 */

public class registerGUI extends JFrame{
	private JTextField accound;             //��¼��id  
	private JPasswordField password;        //��¼������
	//private Icon icon;                		//��¼�����ͼƬ
	private JRadioButton jrb_user;    		//��ťѡ���ǹ�˾
	private JRadioButton jrb_company;  		//��ťѡ�����û�
	private ButtonFont registerButton;		//ע�ᰴť          
	private TextFieldFont tfdSearch;		//
	private List<Company> companyList;      //�����洢���ݿ���company�������
	private List<Candidate> candidateList;  //�����洢���ݿ���candidate�������
	private int hang;
	
    public registerGUI() {
    	this.setTitle("��Ƹϵͳ--��¼����.");
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
		c.setLayout(new BorderLayout(20,10));       //�������֮��ļ��
    	//���沿��
		Icon icon = new ImageIcon(this.getClass().getResource("img/logosmall.jpg"));
		//icon
		JLabel lblImage = new JLabel(icon);
		
    	//�м䲿��
    	Box first_Box = Box.createHorizontalBox();	//����һ��ˮƽ����
    	accound = new JTextField();                  	//�ı���
    	JLabel jlb_id = new JLabel("�˺�:");
    	first_Box.add(jlb_id);
    	first_Box.add(Box.createRigidArea(new Dimension(20, 30)));
    	first_Box.add(accound);
    	
    	Box twice_Box = Box.createHorizontalBox();
    	JLabel jlb_password = new JLabel("����:");
    	password  = new JPasswordField();
    	password.setSize(100,50);
    	twice_Box.add(jlb_password);
    	twice_Box.add(Box.createRigidArea(new Dimension(20, 30)));
    	twice_Box.add(password);
    	
    	Box center = Box.createVerticalBox();     //����һ����ֱ����
    	center.add(first_Box);
    	center.add(twice_Box);
    	
		//����    ��¼��ť  ע�ᰴť  
		ButtonFont loginButton = new ButtonFont("��¼",f);
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String info1 = accound.getText().trim();
				String info2 = String.valueOf(password.getPassword());
				
				if((!jrb_company.isSelected()) && (!jrb_user.isSelected())) {
					JOptionPane.showMessageDialog(null, "��ѡ���¼ѡ��","��ʾ",JOptionPane.WARNING_MESSAGE); 
					return ;
				}
				if(info1.equals("")) {
					 JOptionPane.showMessageDialog(null, "�����������˺�");
		             return;
				}
				else if(info2.equals("")) {
					 JOptionPane.showMessageDialog(null, "��������������");
		             return;
				}
				/**
				 * ��������ȷ���˺�Ҫ���ڵĴ���
				 * ͬʱҪȷ�����˺ŵ�����ȷ��Ҫ��ȷ
				 */
				if(jrb_company.isSelected()) {
					Company newC = new Company();
					//System.out.println(id.getText().trim());//��ȡ�ı��������,����ȥ����β�Ŀո�);
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
							biaozhi = 1;    //��־λ��Ϊ1�����й���
							break;
						}
					}
					if(biaozhi == 1) {
						
						if(String.valueOf(password.getPassword()).equals(companyList.get(i).getCompanyPassword())) {
							//new  ����Ҫnewһ���µĽ����ˣ� 
							//JOptionPane.showMessageDialog(null, "��¼�ɹ�!");
							windowClosingCompany();
							/**
							 * ����Ҫ��һ���½�����,�����Ǵ���id newC.getCompanyId()
							 *//*
							System.out.println(newC.getCompanyId());
							*/
							
							 dispose();//����������,�ͷ��ڴ���Դ
				            return;
						}else {
							JOptionPane.showMessageDialog(null, "�����˺Ż����������������������!");
				            return;
						}
						
					}else {
						JOptionPane.showMessageDialog(null, "�����˺Ż����������������������!");
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
							//new  ����Ҫnewһ���µĽ����ˣ� 
							JOptionPane.showMessageDialog(null, "��¼�ɹ�!");
							try {
								new CandidateMainGUI(newC.getCandidateId());
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
			                dispose();//����������,�ͷ��ڴ���Դ
						}else {
							
							JOptionPane.showMessageDialog(null, "�����˺Ż����������������������!");
				            return;
						}
					}else {
						System.out.println(newC);
						JOptionPane.showMessageDialog(null, "�����˺Ż����������������������!");
			            return;
					}
				}
			}
		});
		
		ButtonFont registerButton = new ButtonFont("ע��",f);
		registerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(!jrb_company.isSelected() && !jrb_user.isSelected()) {
					JOptionPane.showMessageDialog(null, "��ѡ�����½ǵ�ע��ѡ��","��ʾ",JOptionPane.WARNING_MESSAGE); 
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
		
		ButtonFont exitButton = new ButtonFont("�˳�",f);
		exitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "�ɹ��˳�!");
				windowClosingCompany();
			}	
		});
		
		Box south = Box.createVerticalBox();        //����ĺ���  ��ֱ����
		Box first_below = Box.createHorizontalBox();//ˮƽ���������ŵ�¼ע��
		first_below.add(Box.createRigidArea(new Dimension(165, 30)));
		first_below.add(loginButton);
		first_below.add(registerButton);
		//first_below.add(Box.createRigidArea(new Dimension(100, 30)));
		first_below.add(exitButton);
		
		Box twice_below = Box.createHorizontalBox();//ˮƽ��������ѡ����˭����¼
		jrb_user = new JRadioButton("ӦƸ��");
		jrb_user.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(jrb_user.isSelected()) {
					jrb_company.setSelected(false);
								
				}else{
					
				}
		}});
		jrb_company = new JRadioButton("��˾");		
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
		south.add(Box.createHorizontalGlue());//�����һ����ˮ
		south.add(twice_below);
		//�ұ�
		JPanel east = new JPanel();
		//���
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
	private void readcompanyDatabase() {  //�����ݿ�
		CompanyServiceImpl companyDate = new CompanyServiceImpl(new CompanyDaoImpl());  //����ӿ�
		companyList = companyDate.searchAll();   //date��ȡ���ݿ������
	}
	
	private void readcandidateDatabase() {  //�����ݿ�
		CandidateServiceImpl candidateDate = new CandidateServiceImpl(new CandidateDaoImpl());  //����ӿ�
		//candidatedate = new ArrayList(); 
		//candidatedate = candidateDate.searchAll();   //date��ȡ���ݿ������
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
