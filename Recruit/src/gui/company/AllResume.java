/**@FileName:AllResume.java
 * @Description:
 * @Author:������Sio
 * @Date:2019��1��7��
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
 * @Author:������Sio
 * @Date:2019��1��7��
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
		lblItemNames.add("����˵��:");
		lblItemNames.add("<ˢ��>��ˢ��ְλ���");
		lblItemNames.add("<������Ƹְλ>��������Ƹְλ");
		lblItemNames.add("<����ְλͶ�ݼ���>���������������Ҫ���ҵ�ְλ��ID");
		lblItemNames.add("<ɾ��>���������������Ҫɾ����ְλ��ID");
		lblItemNames.add("��������ڵ�ְλ�ɲ鿴ְλ����ϸ��Ϣ");
		
		List<String> talItemNames = new ArrayList<String>();
		talItemNames.add("ְλId");
		talItemNames.add("ְλ����");
		talItemNames.add("��ְ��ID");
		talItemNames.add("��ְ������");
		talItemNames.add("��ְ��ѧ��");
		talItemNames.add("�Ƿ�¼��");
		
		List<JComponent> cptItems = new ArrayList<JComponent>();
		//JTextField fields = new JTextField();
		
		
		List<JTextField> ts = new ArrayList<JTextField>();
		for(int i=0;i<5;i++) {
			JTextField ttemp = new JTextField(0);
			ttemp.setMaximumSize(ttemp.getPreferredSize());
			ts.add(ttemp);
		}
		//ts.get(0).setText("<ˢ��>��ˢ��ְλ���");
		//ts.get(1).setText("<������Ƹְλ>��������Ƹְλ");
		//ts.get(2).setText("<����ְλͶ�ݼ���>���������������Ҫ���ҵ�ְλ��ID");
		//ts.get(3).setText("<ɾ��>���������������Ҫɾ����ְλ��ID");
		//ts.get(4).setText("��������ڵ�ְλ�ɲ鿴ְλ����ϸ��Ϣ");
		for(int i=0;i<5;i++) {
			cptItems.add(ts.get(i));
			ts.get(i).setFont(new Font("����",Font.PLAIN,16));
			ts.get(i).setVisible(false);
			ts.get(i).setEditable(false);
		}
		JTextField t =new JTextField(40);
		t.setFont(new Font("����",Font.PLAIN,20));
		t.setMaximumSize(t.getPreferredSize());
		cptItems.add(t);
		t.setText("<��������ƸְλID��...>");
		t.setVisible(false);
		JComboBox com = new JComboBox();
		com.addItem("");

		com.setMaximumSize(com.getPreferredSize());
		cptItems.add(com);
		List<JButton> btnCommond = new ArrayList<JButton>();
	
		/**
		 * �ҵ����ְλ
		 */

		position = positionService.searchByCompanyId(companyId);
		btnCommond = new ArrayList<JButton>();
		JButton button = new JButton("�鿴��������");
		JButton button1 = new JButton("�鿴��¼������");
		JButton button2 = new JButton("�鿴�Ծܾ�����");
		JButton button3 = new JButton("�鿴δ��������");
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
					di.add("δ����");
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
					di.add("��¼��");
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
					di.add("�Ѿܾ�");

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
			 					di.add("��¼��");
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
					 					di.add("�Ѿܾ�");
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
			 					di.add("δ����");
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
			 					di.add("δ����");
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
			 					di.add("��¼��");
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
			 					di.add("�Ѿܾ�");

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
