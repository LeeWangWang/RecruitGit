package gui;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import bean.Candidate;
import bean.Position;
import dao.CandidateDaoImpl;
import dao.CompanyDaoImpl;
import dao.PositionDaoImpl;
import service.CandidateService;
import service.CandidateServiceImpl;
import service.CompanyService;
import service.CompanyServiceImpl;
import service.PositionServImpl;
import service.PositionService;

/**@ClassName: MainGui.java
 * @Description: 项目入口
 * @Data: 2019年1月5日上午9:39:53
 */
public class CandidateMainGui extends JFrame {
	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	
	public CandidateMainGui() {}
	
	public CandidateMainGui(int candidateId) throws Exception {
		try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} catch (UnsupportedLookAndFeelException e1) {			
			e1.printStackTrace();
		}
		JFrame me = new JFrame();
		JTabbedPane top = new JTabbedPane();
		
		PositionService positionService = new PositionServImpl(new PositionDaoImpl());
		List<Position> positions = new ArrayList<Position>();
		positions = positionService.searchAll();
		
		CandidateService candidateService = new CandidateServiceImpl(new CandidateDaoImpl());
		Candidate candidate = candidateService.searchByCandidateId(candidateId);
		
		CompanyService companyService = new CompanyServiceImpl(new CompanyDaoImpl());
		
		try {
			Vector<Vector<String>> tab1 = new Vector<Vector<String>>();
			Vector<Vector<String>> tab2 = new Vector<Vector<String>>();
			for(Position p1 : positions) {
				Vector<String> table1 = new Vector<String>();
				String companyName = (companyService.searchByCompanyId(p1.getPositionId())).getCompanyName();
				table1.add(String.valueOf(p1.getPositionId()) + "");//职位编号
				table1.add(p1.getPositionName() + "");//职位名称
				table1.add(companyName + "");//公司名称
				table1.add(p1.getPositionIntroduction() + "");//职位介绍
				table1.add(p1.getPositionDiploma() + "");//学历要求
				table1.add(p1.getPositionLightspot() + "");//职位要求
				tab1.add(table1);
			}
			Vector<String> table2 = new Vector<String>();
			table2.add(candidate.getCandidateName() + "");
			table2.add(candidate.getCandidateGender() + "");
			table2.add(String.valueOf(candidate.getCandidateAge()) + "");
			table2.add(candidate.getCandidatePhone() + "");
			table2.add(candidate.getCandidateIdCard() + "");
			table2.add(candidate.getCandidateEmail() + "");
			table2.add(candidate.getCandidateAddress() + "");
			table2.add(candidate.getCandidateMajor() + "");
			table2.add(candidate.getCandidateEducationed() + "");
			table2.add(candidate.getCandidateJobObjective() + "");
			table2.add(candidate.getCandidateWorkExperience() + "");
			tab2.add(table2);
			CandidateGui1 pal1 = new CandidateGui1(candidate);
			CandidateGui2 pal2 = new CandidateGui2(candidate);
			pal1.freshTable(positions);//用来刷新界面一
			pal2.freshTable(tab2);//用来刷新界面二
			//pal1.setBounds(200, 200, 1200, 500);
			//pal2.setBounds(200, 200, 1200, 500);
			top.add("找工作",pal1);
			top.add("个人简历",pal2);
			this.add(top);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.setBounds(200,200,1200,500);
		//this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	
	public static void closeWindows() {
		//container.closeWindows();
	}
	
	public static void main(String[] args) throws Exception {
		new CandidateMainGui(1);
	}
	
}
