package gui.company;

import java.awt.Dimension;
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

import bean.*;
import dao.*;
import service.*;
import gui.candidate.*;
import gui.*;

/**@Description:
 * @FileName:DealPanel.java
 * @Author:������Sio
 * @Date:2019��1��6��
 */
public class DealPanel implements ActionListener{

	private Position position;
	private Candidate candidate;
	private List<Resume> resume;
	private PositionService positionService;
	private ResumeService resumeService;
	private CandidateService candidateService;
	public DealPanel(int positionId,int candidateId) throws Exception {

		JFrame me = new JFrame();
		positionService = new PositionServImpl(new PositionDaoImpl());
		candidateService = new CandidateServiceImpl(new CandidateDaoImpl());
		resumeService = new ResumeServImpl(new ResumeDaoImpl());
		List<String> lblItemNames=new ArrayList<String>();
		lblItemNames.add("ְλID:");
		lblItemNames.add("ְλ����:");
		lblItemNames.add("ְλ���");
		lblItemNames.add("��Ҫ��ƾ:");
		lblItemNames.add("���ܼ���:");
		lblItemNames.add("");
		lblItemNames.add("");
		lblItemNames.add("");
		lblItemNames.add("��ְ��ID");
		lblItemNames.add("��ְ������:");
		lblItemNames.add("�Ա�");
		lblItemNames.add("����:");
		lblItemNames.add("�绰:");
		lblItemNames.add("���֤:");
		lblItemNames.add("����:");
		lblItemNames.add("��ַ:");
		lblItemNames.add("����רҵ:");
		lblItemNames.add("ѧ��:");
		lblItemNames.add("������н:");
		lblItemNames.add("��������:");

		List<String> talItemNames = new ArrayList<String>();
		//talItemNames.add("ְλId");
		List<JComponent> cptItems = new ArrayList<JComponent>();
		List<JTextField> fields = new ArrayList<JTextField>();
		
		for(String s:lblItemNames) {
			JTextField t =new JTextField(20);
			t.setMaximumSize(t.getPreferredSize());
			fields.add(t);
			cptItems.add(t);			
		}
		
		JComboBox com = new JComboBox();
		com.addItem("");

		com.setMaximumSize(com.getPreferredSize());
		cptItems.add(com);
		List<JButton> btnCommond = new ArrayList<JButton>();
	
		/**
		 * �ҵ����ְλ
		 */
		//System.out.println(candidateId+" "+positionId);
		candidate = candidateService.searchByCandidateId(candidateId);
		position = positionService.searchByPositionId(positionId);
		
		fields.get(0).setText(String.valueOf(position.getPositionId()));
		fields.get(1).setText(position.getPositionName());
		fields.get(2).setText(position.getPositionIntroduction());
		fields.get(3).setText(position.getPositionDiploma());
		fields.get(4).setText(position.getPositionLightspot());
		fields.get(5).setVisible(false);
		fields.get(6).setVisible(false);
		fields.get(7).setVisible(false);
		fields.get(8).setText(String.valueOf(candidate.getCandidateId()));
		fields.get(9).setText(candidate.getCandidateName());
		fields.get(10).setText(candidate.getCandidateGender());
		fields.get(11).setText(String.valueOf(candidate.getCandidateAge()));
		fields.get(12).setText(candidate.getCandidatePhone());
		fields.get(13).setText(candidate.getCandidateIdCard());
		fields.get(14).setText(candidate.getCandidateEmail());
		fields.get(15).setText(candidate.getCandidateAddress());
		fields.get(16).setText(candidate.getCandidateMajor());
		fields.get(17).setText(candidate.getCandidateEducationed());
		fields.get(18).setText(candidate.getCandidateJobObjective());
		fields.get(19).setText(candidate.getCandidateWorkExperience());
		for(JTextField jt:fields) {
			jt.setEditable(false) ;
		}
		
		btnCommond = new ArrayList<JButton>();
		JButton button = new JButton("¼��");
		JButton button1 = new JButton("�ܾ�");
		JButton button2 = new JButton("�ݲ�����");
		btnCommond.add(button);
		btnCommond.add(button1);
		btnCommond.add(button2);
		button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                	System.out.println("¼��");
                	int a =0,b=1;
                	resumeService.dealResume(new Resume(Integer.valueOf(fields.get(8).getText()),Integer.valueOf(fields.get(0).getText()),a),b);
                   	me.dispose();
            }
        });
		button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                	System.out.println("�ܾ�");
                	int a =0,b=-1;
                	resumeService.dealResume(new Resume(Integer.valueOf(fields.get(8).getText()),Integer.valueOf(fields.get(0).getText()),a),b);
                   	me.dispose();
            }
        });
		button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                	System.out.println("ȡ��");
                   	me.dispose();
            }
        });
			try {
				DealResumePanel rPal = new DealResumePanel(lblItemNames,talItemNames,cptItems,btnCommond,2);
				
				rPal.setSize(new Dimension(400,250));
				Vector<Vector<String>> d = new Vector<Vector<String>>();
				int i=0;
					/*for(Position p:position) {
					Vector<String> di = new Vector<String>();
					String sp = String.valueOf(p.getPositionId());
					di.add(sp);
					di.add(p.getPositionName());
					sp = String.valueOf(p.getCompanyId());
					di.add(sp);
					di.add(p.getPositionIntroduction());
					di.add(p.getPositionDiploma());
					di.add(p.getPositionLightspot());
					d.add(di);
					i++;
				}


		
			rPal.freshTable(d);*/
			//pal.setSize(new Dimension(400,500));
			me.add(rPal);
		} catch (Exception e) {
			e.printStackTrace();
		}

		//me.setBounds(100,200,400,500);;
		me.pack();
		me.setVisible(true);
		me.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
