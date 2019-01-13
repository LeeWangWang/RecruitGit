package gui.candidate;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import bean.Candidate;
import bean.Company;
import bean.Position;
import bean.Resume;
import dao.CandidateDaoImpl;
import dao.CompanyDao;
import dao.CompanyDaoImpl;
import dao.PositionDao;
import dao.PositionDaoImpl;
import dao.ResumeDao;
import dao.ResumeDaoImpl;
import gui.CompanyResumeGUI;
import service.CandidateService;
import service.CandidateServiceImpl;
import service.CompanyService;
import service.CompanyServiceImpl;
import service.PositionServImpl;
import service.PositionService;
import service.ResumeServImpl;
import service.ResumeService;
/**
 * @ClassName: CandidateMainGUI.java
 * @Author: ������
 * @Data: 2019��1��9������8:31:41
 */
public class CandidateMainGUI extends JFrame{
	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	private JTabbedPane tabbedPane; //���
	private CandidateGui1 panel1;
	private CandidateGui2 panel2;
	private CompanyResumeGUI panel3;
	private int id;
	
	public CandidateMainGUI(int id) throws Exception {
		super("ӦƸ�߽���");
		this.setId(id);
		try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} catch (UnsupportedLookAndFeelException e1) {			
			e1.printStackTrace();
		}
		this.readDatabase();
    	this.init();
    	this.jianting();
    	this.setResizable(true);
		this.setSize(1200,500);
        this.setLocation(100, 200);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);		//�رոý��治��ʹ������Ҳ�ر�
		this.setVisible(true);
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void init() throws Exception  {
		Container c = getContentPane();  
		tabbedPane = new JTabbedPane();   //ѡ�
		//ְλ
		PositionService positionService = new PositionServImpl(new PositionDaoImpl());
		List<Position> positions = new ArrayList<Position>();
		positions = positionService.searchAll();
		//��ְ��
		CandidateService candidateService = new CandidateServiceImpl(new CandidateDaoImpl());
		Candidate candidate = candidateService.searchByCandidateId(this.getId());
		//��˾
		CompanyService companyService1 = new CompanyServiceImpl(new CompanyDaoImpl());
		
		try {
			Vector<Vector<String>> tab1 = new Vector<Vector<String>>();
			for(Position p1 : positions) {
				Vector<String> table1 = new Vector<String>();
				String companyName = (companyService1.searchByCompanyId(p1.getCompanyId())).getCompanyName();
				table1.add(String.valueOf(p1.getPositionId()) + "");//ְλ���
				table1.add(p1.getPositionName() + "");//ְλ����
				table1.add(companyName + "");//��˾����
				table1.add(p1.getPositionIntroduction() + "");//ְλ����
				table1.add(p1.getPositionDiploma() + "");//ѧ��Ҫ��
				table1.add(p1.getPositionLightspot() + "");//ְλҪ��
				tab1.add(table1);
			}
			panel1 = new CandidateGui1(candidate);
			panel1.freshTable(tab1);//����ˢ�½���һ
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			panel2  = new CandidateGui2(candidate);
			panel2.freshInfromation(candidate);//����ˢ�½���һ
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			List<JButton> btnCommond = new ArrayList<JButton>();
			List<String> lblItemNames = new ArrayList<String>();
			lblItemNames.add("ְλID");
			lblItemNames.add("ְλ����");
			lblItemNames.add("��˾ID");
			lblItemNames.add("��˾����");
			lblItemNames.add("��˾��ַ");
			lblItemNames.add("�Ƿ�¼ȡ");
			
			List<JComponent> cptItems = new ArrayList<JComponent>();
			JTextField[] fields = new JTextField[6];
			for(int i = 0; i< fields.length;i++) {
				JTextField t =new JTextField(10);
				t.setEditable(false); 
				t.setMaximumSize(t.getPreferredSize());
				cptItems.add(t);
			}
			//�������һ��id����ֵ�������һ��������
			panel3 = new CompanyResumeGUI(lblItemNames,cptItems,btnCommond,3,this.getId());
			
			panel3.setSize(new Dimension(400,300));//��װ��һ����С
			PositionDao position = new PositionDaoImpl();
			PositionService positionSearch = new PositionServImpl(position);
			ResumeDao  resume = new ResumeDaoImpl();
			ResumeService resumeService = new ResumeServImpl(resume);
			CompanyDao companydao = new CompanyDaoImpl();
			CompanyService companyService2 = new CompanyServiceImpl(companydao);
			
			List<Company> companyList = new ArrayList<Company>();
			List<Position> positList = new ArrayList<Position>();
			List<Resume> resumeList = new ArrayList<Resume>(); 
			companyList = companyService2.searchAll();//�������ŵ������еĹ�˾����Ϣ
			positList = positionSearch.searchAll(); //�������ŵ������е�ְλ����Ϣ
			resumeList = resumeService.searchAll(); //�������ŵ�������Ͷ����������Ϣ
			
			Jihe jihe = new Jihe(panel3.getRandidateId(),positList,resumeList,companyList);//�����Ǹ��˵�ID
			
			panel3.freshTable(jihe.getRenOnce());
			}catch (Exception e) {
				e.printStackTrace();
			}
		tabbedPane.addTab("������ҳ",null,panel1,"First panel"); 
		tabbedPane.addTab("ӦƸְλ",null,panel2,"Second panel");  
		tabbedPane.addTab("��Ϣ����",null,panel3,"Third panel");  
		c.add(tabbedPane);
		c.setBackground(Color.white);  
	}
	
	public void jianting() {
		
	}
	
	public void readDatabase() {
		
	}
	
}
