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
 * @Author: 穆正阳
 * @Data: 2019年1月9日上午8:31:41
 */
public class CandidateMainGUI extends JFrame{
	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	private JTabbedPane tabbedPane; //面板
	private CandidateGui1 panel1;
	private CandidateGui2 panel2;
	private CompanyResumeGUI panel3;
	private int id;
	
	public CandidateMainGUI(int id) throws Exception {
		super("应聘者界面");
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
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);		//关闭该界面不会使父界面也关闭
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
		tabbedPane = new JTabbedPane();   //选项卡
		//职位
		PositionService positionService = new PositionServImpl(new PositionDaoImpl());
		List<Position> positions = new ArrayList<Position>();
		positions = positionService.searchAll();
		//求职者
		CandidateService candidateService = new CandidateServiceImpl(new CandidateDaoImpl());
		Candidate candidate = candidateService.searchByCandidateId(this.getId());
		//公司
		CompanyService companyService1 = new CompanyServiceImpl(new CompanyDaoImpl());
		
		try {
			Vector<Vector<String>> tab1 = new Vector<Vector<String>>();
			for(Position p1 : positions) {
				Vector<String> table1 = new Vector<String>();
				String companyName = (companyService1.searchByCompanyId(p1.getCompanyId())).getCompanyName();
				table1.add(String.valueOf(p1.getPositionId()) + "");//职位编号
				table1.add(p1.getPositionName() + "");//职位名称
				table1.add(companyName + "");//公司名称
				table1.add(p1.getPositionIntroduction() + "");//职位介绍
				table1.add(p1.getPositionDiploma() + "");//学历要求
				table1.add(p1.getPositionLightspot() + "");//职位要求
				tab1.add(table1);
			}
			panel1 = new CandidateGui1(candidate);
			panel1.freshTable(tab1);//用来刷新界面一
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			panel2  = new CandidateGui2(candidate);
			panel2.freshInfromation(candidate);//用来刷新界面一
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			List<JButton> btnCommond = new ArrayList<JButton>();
			List<String> lblItemNames = new ArrayList<String>();
			lblItemNames.add("职位ID");
			lblItemNames.add("职位名称");
			lblItemNames.add("公司ID");
			lblItemNames.add("公司名称");
			lblItemNames.add("公司地址");
			lblItemNames.add("是否录取");
			
			List<JComponent> cptItems = new ArrayList<JComponent>();
			JTextField[] fields = new JTextField[6];
			for(int i = 0; i< fields.length;i++) {
				JTextField t =new JTextField(10);
				t.setEditable(false); 
				t.setMaximumSize(t.getPreferredSize());
				cptItems.add(t);
			}
			//这里加了一个id的数值，在最后一个数据上
			panel3 = new CompanyResumeGUI(lblItemNames,cptItems,btnCommond,3,this.getId());
			
			panel3.setSize(new Dimension(400,300));//封装了一个大小
			PositionDao position = new PositionDaoImpl();
			PositionService positionSearch = new PositionServImpl(position);
			ResumeDao  resume = new ResumeDaoImpl();
			ResumeService resumeService = new ResumeServImpl(resume);
			CompanyDao companydao = new CompanyDaoImpl();
			CompanyService companyService2 = new CompanyServiceImpl(companydao);
			
			List<Company> companyList = new ArrayList<Company>();
			List<Position> positList = new ArrayList<Position>();
			List<Resume> resumeList = new ArrayList<Resume>(); 
			companyList = companyService2.searchAll();//这里面存放的是所有的公司的信息
			positList = positionSearch.searchAll(); //这里面存放的是所有的职位的信息
			resumeList = resumeService.searchAll(); //这里面存放的是所有投出简历的信息
			
			Jihe jihe = new Jihe(panel3.getRandidateId(),positList,resumeList,companyList);//传的是个人的ID
			
			panel3.freshTable(jihe.getRenOnce());
			}catch (Exception e) {
				e.printStackTrace();
			}
		tabbedPane.addTab("个人首页",null,panel1,"First panel"); 
		tabbedPane.addTab("应聘职位",null,panel2,"Second panel");  
		tabbedPane.addTab("消息界面",null,panel3,"Third panel");  
		c.add(tabbedPane);
		c.setBackground(Color.white);  
	}
	
	public void jianting() {
		
	}
	
	public void readDatabase() {
		
	}
	
}
