/**@FileName:CompanyPositionPanel.java
 * @Description:
 * @Author:周天乐Sio
 * @Date:2019年1月4日
 */
package gui.company;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import bean.*;
import dao.*;
import service.*;

/**@Description:
 * @FileName:CompanyPositionPanel.java
 * @Author:周天乐Sio
 * @Date:2019年1月4日
 */
public class CompanyPositionPanel implements ActionListener{

	private int positionId;
	private InformationPal informationPal;
	private PositionService positionService;
	private ResumeService resumeService;
	private CandidateService candidateService;
	private Position position;
	private List<Resume> resume;
	private List<Position> positions;
	private Candidate candidate;
	int t_Yes =1;
	int t_No = -1;
	int t_Late = 0;
	public CompanyPositionPanel(int positionId,JTextField t) {
		JFrame me = new JFrame();
		positionService = new PositionServImpl(new PositionDaoImpl());
		positionService = new PositionServImpl(new PositionDaoImpl());
		resumeService = new ResumeServImpl(new ResumeDaoImpl());
		candidateService = new CandidateServiceImpl(new CandidateDaoImpl());
		List<String> lblItemNames=new ArrayList<String>();
		lblItemNames.add("职位Id");
		lblItemNames.add("职位名称");
		lblItemNames.add("公司ID");
		lblItemNames.add("职位介绍");
		lblItemNames.add("学历需求");
		lblItemNames.add("其他需求");
		List<String> talItemNames = new ArrayList<String>();
		talItemNames.add("职位Id");
		talItemNames.add("职位名称");
		talItemNames.add("求职者ID");
		talItemNames.add("求职者姓名");
		talItemNames.add("求职者学历");
		List<JComponent> cptItems = new ArrayList<JComponent>();
		JTextField[] fields = new JTextField[6];
		/**/for(int i = 0; i< fields.length;i++) {
			fields[i] =new JTextField(20);
			fields[i].setMaximumSize(fields[i].getPreferredSize());
			cptItems.add(fields[i]);
		}
		
		
		
		JComboBox com = new JComboBox();
		com.addItem("");

		com.setMaximumSize(com.getPreferredSize());
		cptItems.add(com);
		List<JButton> btnCommond = new ArrayList<JButton>();
		JButton btn = new JButton("刷新");
		btnCommond.add(btn);

		position = positionService.searchByPositionId(positionId);
		if(position!=null) {
			fields[0].setText(String.valueOf(position.getPositionId()));
			fields[1].setText(position.getPositionName());
			fields[2].setText(String.valueOf(position.getCompanyId()));
			fields[3].setText(position.getPositionIntroduction());
			fields[4].setText(position.getPositionDiploma());
			fields[5].setText(position.getPositionLightspot());
			for(int i=0;i<6;i++) {
				fields[i].setEditable(false) ;
			}
			try {
				PositionResumePanel pal = new PositionResumePanel(lblItemNames,talItemNames,cptItems,btnCommond,1);
				//short temp=0;
				resume = resumeService.searchByPositionIdIsInter(positionId,t_Late);


				pal.setSize(new Dimension(400,250));
				Vector<Vector<String>> d = new Vector<Vector<String>>();
				int i=0;
				for(Resume r:resume) {
					Vector<String> di = new Vector<String>();
					String sp = String.valueOf(r.getPositionId());
					di.add(sp);
					di.add(position.getPositionName());
					candidate = candidateService.searchByCandidateId(resume.get(i).getCandidateId());
					String sc = String.valueOf(resume.get(i).getCandidateId());
					di.add(sc);
					di.add(candidate.getCandidateName());
					di.add(candidate.getCandidateEducationed());
					d.add(di);
					i++;
				}
					btn.addActionListener(new ActionListener() {
			            public void actionPerformed(ActionEvent e) {
			            	//short temp=0;
							resume = resumeService.searchByPositionIdIsInter(positionId,t_Late);
							pal.setSize(new Dimension(400,250));
							Vector<Vector<String>> d = new Vector<Vector<String>>();
							int i=0;
								for(Resume r:resume) {
								Vector<String> di = new Vector<String>();
								String sp = String.valueOf(r.getPositionId());
								di.add(sp);
								di.add(position.getPositionName());
								try {
									candidate = candidateService.searchByCandidateId(resume.get(i).getCandidateId());
								} catch (Exception e1) {
									e1.printStackTrace();
								}
								String sc = String.valueOf(resume.get(i).getCandidateId());
								di.add(sc);
								di.add(candidate.getCandidateName());
								di.add(candidate.getCandidateEducationed());
								d.add(di);
								i++;
							}
			                	pal.freshTable(d);
			  
					        }
						});
				
				pal.freshTable(d);
				//pal.setSize(new Dimension(400,500));
				me.add(pal);
			} catch (Exception e) {
				e.printStackTrace();
				
			}
			//me.setBounds(100,200,400,500);;
			me.pack();
			me.setVisible(true);
			//me.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
			me.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}else {
			t.setText("职位ID号错误，查无此职位");
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}

