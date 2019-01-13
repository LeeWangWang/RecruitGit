/**@FileName:AllResume.java
 * @Description:
 * @Author:周天乐Sio
 * @Date:2019年1月7日
 */
package gui.company;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import bean.*;
import dao.*;
import service.*;

/**@Description:
 * @FileName:AllResume.java
 * @Author:周天乐Sio
 * @Date:2019年1月7日
 */


public class AllResume implements ActionListener{

	private List<Position> position;
	private List<Resume> resume;
	private Candidate candidate;
	private PositionService positionService;
	private ResumeService resumeService;
	private CandidateService candidateService;
	public CompanyResumePanel rPal;
	public JFrame me;
	int t_Yes =1;
	int t_No = -1;
	int t_Late = 0;
	public AllResume(int companyId) {

		try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} catch (UnsupportedLookAndFeelException e1) {			
			e1.printStackTrace();
		}
		
		me = new JFrame();
		positionService = new PositionServImpl(new PositionDaoImpl());
		resumeService = new ResumeServImpl(new ResumeDaoImpl());
		candidateService = new CandidateServiceImpl(new CandidateDaoImpl());
		List<String> lblItemNames=new ArrayList<String>();
		lblItemNames.add("适用说明:");
		lblItemNames.add("<刷新>：刷新职位表格");
		lblItemNames.add("<增加招聘职位>：增加招聘职位");
		lblItemNames.add("<搜索职位投递简历>：在输入框内输入要查找的职位的ID");
		lblItemNames.add("<删除>：在输入框内输入要删除的职位的ID");
		lblItemNames.add("单机表格内的职位可查看职位的详细信息");
		
		List<String> talItemNames = new ArrayList<String>();
		talItemNames.add("职位Id");
		talItemNames.add("职位名称");
		talItemNames.add("求职者ID");
		talItemNames.add("求职者姓名");
		talItemNames.add("求职者学历");
		talItemNames.add("是否录用");
		
		List<JComponent> cptItems = new ArrayList<JComponent>();
		//JTextField fields = new JTextField();
		
		
		List<JTextField> ts = new ArrayList<JTextField>();
		for(int i=0;i<5;i++) {
			JTextField ttemp = new JTextField(0);
			ttemp.setMaximumSize(ttemp.getPreferredSize());
			ts.add(ttemp);
		}
		//ts.get(0).setText("<刷新>：刷新职位表格");
		//ts.get(1).setText("<增加招聘职位>：增加招聘职位");
		//ts.get(2).setText("<搜索职位投递简历>：在输入框内输入要查找的职位的ID");
		//ts.get(3).setText("<删除>：在输入框内输入要删除的职位的ID");
		//ts.get(4).setText("单机表格内的职位可查看职位的详细信息");
		for(int i=0;i<5;i++) {
			cptItems.add(ts.get(i));
			ts.get(i).setFont(new Font("宋体",Font.PLAIN,16));
			ts.get(i).setVisible(false);
			ts.get(i).setEditable(false);
		}
		JTextField t =new JTextField(40);
		t.setFont(new Font("宋体",Font.PLAIN,20));
		t.setMaximumSize(t.getPreferredSize());
		cptItems.add(t);
		t.setText("<请输入招聘职位ID号...>");
		t.setVisible(false);
		JComboBox com = new JComboBox();
		com.addItem("");

		com.setMaximumSize(com.getPreferredSize());
		cptItems.add(com);
		List<JButton> btnCommond = new ArrayList<JButton>();
	
		/**
		 * 找到这个职位
		 */

		position = positionService.searchByCompanyId(companyId);
		btnCommond = new ArrayList<JButton>();
		JButton button = new JButton("查看所有申请");
		JButton button1 = new JButton("查看已录用申请");
		JButton button2 = new JButton("查看以拒绝申请");
		JButton button3 = new JButton("查看未处理申请");
		btnCommond.add(button);
		btnCommond.add(button1);
		btnCommond.add(button2);
		btnCommond.add(button3);
		
		try {
			rPal = new CompanyResumePanel(lblItemNames,talItemNames,cptItems,btnCommond,1);
				
			rPal.setSize(new Dimension(400,250));
			Vector<Vector<String>> d = new Vector<Vector<String>>();
			int i=0;
			for(Position p:position) {
				//short temp=0;
				resume = resumeService.searchByPositionIdIsInter(p.getPositionId(),t_Late);
				for(Resume r:resume) {
					Vector<String> di = new Vector<String>();
					String sp = String.valueOf(r.getPositionId());
					di.add(sp);
					di.add(p.getPositionName());
					candidate = candidateService.searchByCandidateId(r.getCandidateId());
					String sc = String.valueOf(r.getCandidateId());
					di.add(sc);
					di.add(candidate.getCandidateName());
					di.add(candidate.getCandidateEducationed());
					di.add("未处理");
					d.add(di);
					//i++;
			}
			}		
			i=0;
			for(Position p1:position) {
				//short temp1 = 1;
				resume = resumeService.searchByPositionIdIsInter(p1.getPositionId(),t_Yes);
				for(Resume r:resume) {
					Vector<String> di = new Vector<String>();
					String sp = String.valueOf(r.getPositionId());
					di.add(sp);
					di.add(p1.getPositionName());
					candidate = candidateService.searchByCandidateId(r.getCandidateId());
					String sc = String.valueOf(r.getCandidateId());
					di.add(sc);
					di.add(candidate.getCandidateName());
					di.add(candidate.getCandidateEducationed());
					di.add("已录用");
					d.add(di);
					i++;
			}
			}
			i=0;
			for(Position p2:position) {
				//short temp2=-1;
				resume = resumeService.searchByPositionIdIsInter(p2.getPositionId(),t_No);
				for(Resume r:resume) {
					Vector<String> di = new Vector<String>();
					String sp = String.valueOf(r.getPositionId());
					di.add(sp);
					di.add(p2.getPositionName());
					candidate = candidateService.searchByCandidateId(r.getCandidateId());
					String sc = String.valueOf(r.getCandidateId());
					di.add(sc);
					di.add(candidate.getCandidateName());
					di.add(candidate.getCandidateEducationed());
					di.add("已拒绝");

					d.add(di);
					i++;
			}
			}
			rPal.freshTable(d);

				button1.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	Vector<Vector<String>> d1 = new Vector<Vector<String>>();
			 			//int i=0;
			 			for(Position p1:position) {
			 				//short temp1 = 1;
			 				resume = resumeService.searchByPositionIdIsInter(p1.getPositionId(),t_Yes);
			 				for(Resume r:resume) {
			 					Vector<String> di = new Vector<String>();
			 					String sp = String.valueOf(r.getPositionId());
			 					di.add(sp);
			 					di.add(p1.getPositionName());
			 					try {
									candidate = candidateService.searchByCandidateId(r.getCandidateId());
								} catch (Exception e1) {
									e1.printStackTrace();
								}
			 					String sc = String.valueOf(r.getCandidateId());
			 					di.add(sc);
			 					di.add(candidate.getCandidateName());
			 					di.add(candidate.getCandidateEducationed());
			 					di.add("已录用");
			 					d1.add(di);
			 					//i++;
			 				}
			 			}
			 			rPal.freshTable(d1);
		            }
					});
				
				button2.addActionListener(new ActionListener() {
				            public void actionPerformed(ActionEvent e) {
				            	Vector<Vector<String>> d1 = new Vector<Vector<String>>();
					 			for(Position p1:position) {
					 				//short temp1 = -1;
					 				resume = resumeService.searchByPositionIdIsInter(p1.getPositionId(),t_No);
					 				for(Resume r:resume) {
					 					Vector<String> di = new Vector<String>();
					 					String sp = String.valueOf(r.getPositionId());
					 					di.add(sp);
					 					di.add(p1.getPositionName());
					 					try {
											candidate = candidateService.searchByCandidateId(r.getCandidateId());
										} catch (Exception e1) {
											e1.printStackTrace();
										}
					 					String sc = String.valueOf(r.getCandidateId());
					 					di.add(sc);
					 					di.add(candidate.getCandidateName());
					 					di.add(candidate.getCandidateEducationed());
					 					di.add("已拒绝");
					 					d1.add(di);
					 					//i++;
					 				}
					 			}
					 			rPal.freshTable(d1);
				            }
				        });
				
				button3.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e){
		            	Vector<Vector<String>> d1 = new Vector<Vector<String>>();
			 			for(Position p1:position) {
			 				//short temp1 = 0;
			 				resume = resumeService.searchByPositionIdIsInter(p1.getPositionId(),t_Late);
			 				for(Resume r:resume) {
			 					Vector<String> di = new Vector<String>();
			 					String sp = String.valueOf(r.getPositionId());
			 					di.add(sp);
			 					di.add(p1.getPositionName());
			 					try {
									candidate = candidateService.searchByCandidateId(r.getCandidateId());
								} catch (Exception e1) {
									e1.printStackTrace();
								}
			 					String sc = String.valueOf(r.getCandidateId());
			 					di.add(sc);
			 					di.add(candidate.getCandidateName());
			 					di.add(candidate.getCandidateEducationed());
			 					di.add("未处理");
			 					d1.add(di);
			 					//i++;
			 				}
			 			}
			 			rPal.freshTable(d1);
		                
		            }
		        });	
				button.addActionListener(new ActionListener() {
			         public void actionPerformed(ActionEvent e) {
			        	 Vector<Vector<String>> d1 = new Vector<Vector<String>>();
			 			int i=0;
			 			for(Position p:position) {
			 				//short temp=0;
			 				resume = resumeService.searchByPositionIdIsInter(p.getPositionId(),t_Late);
			 				for(Resume r:resume) {
			 					Vector<String> di = new Vector<String>();
			 					String sp = String.valueOf(r.getPositionId());
			 					di.add(sp);
			 					di.add(p.getPositionName());
			 					try {
									candidate = candidateService.searchByCandidateId(r.getCandidateId());
								} catch (Exception e1) {
									e1.printStackTrace();
								}
			 					String sc = String.valueOf(r.getCandidateId());
			 					di.add(sc);
			 					di.add(candidate.getCandidateName());
			 					di.add(candidate.getCandidateEducationed());
			 					di.add("未处理");
			 					d1.add(di);
			 					i++;
			 			}
			 			}		
			 			i=0;
			 			for(Position p1:position) {
			 				//short temp1 = 1;
			 				resume = resumeService.searchByPositionIdIsInter(p1.getPositionId(),t_Yes);
			 				for(Resume r:resume) {
			 					Vector<String> di = new Vector<String>();
			 					String sp = String.valueOf(r.getPositionId());
			 					di.add(sp);
			 					di.add(p1.getPositionName());
			 					try {
									candidate = candidateService.searchByCandidateId(r.getCandidateId());
								} catch (Exception e1) {
									e1.printStackTrace();
								}
			 					String sc = String.valueOf(r.getCandidateId());
			 					di.add(sc);
			 					di.add(candidate.getCandidateName());
			 					di.add(candidate.getCandidateEducationed());
			 					di.add("已录用");
			 					d1.add(di);
			 					i++;
			 			}
			 			}
			 			i=0;
			 			for(Position p2:position) {
			 				//short temp2=-1;
			 				resume = resumeService.searchByPositionIdIsInter(p2.getPositionId(),t_No);
			 				for(Resume r:resume) {
			 					Vector<String> di = new Vector<String>();
			 					String sp = String.valueOf(r.getPositionId());
			 					di.add(sp);
			 					di.add(p2.getPositionName());
			 					try {
									candidate = candidateService.searchByCandidateId(r.getCandidateId());
								} catch (Exception e1) {
									e1.printStackTrace();
								}
			 					String sc = String.valueOf(r.getCandidateId());
			 					di.add(sc);
			 					di.add(candidate.getCandidateName());
			 					di.add(candidate.getCandidateEducationed());
			 					di.add("已拒绝");

			 					d1.add(di);
			 					i++;
			 			}
			 			}
		    			rPal.freshTable(d1);
			         }
			    });
			rPal.freshTable(d);
			me.add(rPal);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//me.setBounds(100,200,400,500);;
		me.pack();
		me.setVisible(true);
		me.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}
}
