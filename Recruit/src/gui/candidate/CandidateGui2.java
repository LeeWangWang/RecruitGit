package gui.candidate;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import bean.Candidate;
import dao.CandidateDaoImpl;
import gui.customStyle.StyleArgument;
import service.CandidateService;
import service.CandidateServiceImpl;
/**
 * @ClassName: CandidateGui2.java
 * @Author: 李旺旺
 * @Data: 2019年1月9日上午8:31:31
 */
public class CandidateGui2 extends JPanel{
	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	
	private List<JLabel> lblItemNames;//标签列表
	private List<JTextField> cptItems;//Swing组件的根类
	private List<JButton> btn;//按钮列表
	private JPanel palDetail;//面板
	private JPopupMenu popUpMenu;//弹出菜单
	private final int countOneLine = 3;
	private JLabel lbelname;
	private JLabel lbelgender;
	private JLabel lbelage;
	private JLabel lbelphone;
	private JLabel lbelidcard;
	private JLabel lbelemaile;
	private JLabel lbelmajor;
	private JLabel lbeleducation;
	private JLabel lbejobObjective;
	private JLabel lbeladdress;
	private JLabel lbelworkExperence;
	private JTextField jTextname;                         
	private JTextField jTextgender;
	private JTextField jTextage;
	private JTextField jTextphone;
	private JTextField jTextidCard;
	private JTextField jTextemaile;
	private JTextField jTextmajor;
	private JTextField jTexteducation;
	private JTextField jTextjobObjective;
	private JTextField jTextaddress;
	private JTextArea jTextWorkexprence;
	private CandidateService candidateService;
	
	public CandidateGui2(Candidate c) throws Exception  {
		Font font = new Font(StyleArgument.FONTNAME,StyleArgument.FONTSTYLE,StyleArgument.FONTSIZE);
		//标签
		lbelname = new JLabel("姓名");
		lbelgender = new JLabel("性别");
		lbelage = new JLabel("年龄");
		lbelphone = new JLabel("电话");
		lbelidcard = new JLabel("身份证");
		lbelemaile = new JLabel("邮箱");
		lbelmajor = new JLabel("专业");
		lbeleducation = new JLabel("学历");
		lbejobObjective = new JLabel("期望年薪");
		lbeladdress = new JLabel("地址");
		lbelworkExperence = new JLabel("工作经验");
		lblItemNames = new ArrayList<JLabel>();
		lblItemNames.add(lbelname);
		lblItemNames.add(lbelgender);
		lblItemNames.add(lbelage);
		lblItemNames.add(lbelphone);
		lblItemNames.add(lbelidcard);
		lblItemNames.add(lbelemaile);
		lblItemNames.add(lbelmajor);
		lblItemNames.add(lbeleducation);
		lblItemNames.add(lbejobObjective);
		for(JLabel j : lblItemNames) {
			j.setFont(font);
		}
		//文本框
		jTextname = new JTextField(50);
		jTextgender = new JTextField(50);
		jTextage = new JTextField(50);
		jTextphone = new JTextField(50);
		jTextidCard = new JTextField(50);
		jTextemaile = new JTextField(50);
		jTextmajor = new JTextField(50);
		jTexteducation = new JTextField(50);
		jTextjobObjective = new JTextField(50);
		jTextaddress = new JTextField(50);
		jTextaddress.setFont(font);
		jTextWorkexprence = new JTextArea(8,62);
		jTextWorkexprence.setFont(font);
		cptItems = new ArrayList<JTextField>();
		cptItems.add(jTextname);
		cptItems.add(jTextgender);
		cptItems.add(jTextage);
		cptItems.add(jTextphone);
		cptItems.add(jTextidCard);
		cptItems.add(jTextemaile);
		cptItems.add(jTextmajor);
		cptItems.add(jTexteducation);
		cptItems.add(jTextjobObjective);
		for(JTextField t : cptItems) {
			setJTextfieldFont(t, font);
		}
		//按钮
		btn = new ArrayList<JButton>();
		JButton btnEdit = new JButton("编辑");
		btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setJTextEnable();
			}
		});
		JButton btnSave = new JButton("保存");
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(jTextidCard.getText().length() != 18) {
					JOptionPane.showMessageDialog(CandidateGui2.this, "请输入正确的身份证", "确认", JOptionPane.INFORMATION_MESSAGE);
				}else if(jTextage.getText().length() > 2) {
					JOptionPane.showMessageDialog(CandidateGui2.this, "请输入正确的年龄", "确认", JOptionPane.INFORMATION_MESSAGE);
				}else {
					candidateService = new CandidateServiceImpl(new CandidateDaoImpl());
					Candidate can = new Candidate(c.getCandidateId(),jTextname.getText(),jTextgender.getText(),
							Integer.valueOf(jTextage.getText()),jTextphone.getText(),jTextidCard.getText(),
							jTextemaile.getText(), jTextaddress.getText(), jTextmajor.getText(),
							jTexteducation.getText(), jTextjobObjective.getText(), jTextWorkexprence.getText(),
							c.getCandidateAccount(), c.getCandidatePassword());
					try {
						candidateService.updateCandidate(can);
						setJTextDisable();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		JButton btnQuit = new JButton("退出");
		btnQuit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(CandidateGui2.this, "确认退出程序吗?")) {
					System.exit(0);
				}
			}
		});
		JButton btnPrint = new JButton("打印");
		btnPrint.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JMenuItem printMenu = new JMenuItem("打印...");
				popUpMenu.add(printMenu);
				//打印界面
				printMenu.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
									
					}
					
				});
			}
		});
		btn.add(btnEdit);
		btn.add(btnSave);
		btn.add(btnQuit);
		btn.add(btnPrint);
		lbeladdress.setText("地址");
		lbeladdress.setFont(font);
		lbelworkExperence.setText("工作经验");
		lbelworkExperence.setFont(font);
		
		JScrollPane jsp = new JScrollPane(jTextWorkexprence);
		//fields3.setMaximumSize(fields3.getPreferredSize());
		Box VerCommond = Box.createVerticalBox();
		VerCommond.add(lbeladdress);
		VerCommond.add(jTextaddress);
		VerCommond.add(lbelworkExperence);
		VerCommond.add(jsp);
		
		palDetail = new JPanel(new BorderLayout());	
		Box commond = Box.createHorizontalBox();
		commond.add(Box.createGlue());
		for(JButton b:btn) {
			b.setFont(font);
			commond.add(b);
			commond.add(Box.createGlue());
		}
		Box box = Box.createVerticalBox();
		box.add(VerCommond);
		box.add(commond);
		palDetail.add(box,BorderLayout.SOUTH);
		JPanel topCenter =  new JPanel();		
		GroupLayout layout = new GroupLayout(topCenter);
		topCenter.setLayout(layout);
		layout.setAutoCreateContainerGaps(true);
		layout.setAutoCreateGaps(true);
		//设置水平布局
		GroupLayout.ParallelGroup groupLbl[] = new GroupLayout.ParallelGroup[countOneLine];
		GroupLayout.ParallelGroup[] groupComponent = new GroupLayout.ParallelGroup[countOneLine];
		GroupLayout.SequentialGroup groupH = layout.createSequentialGroup();
		for(int i = 0; i < countOneLine; i++) {
			groupLbl[i] = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
			groupComponent[i] =  layout.createParallelGroup(GroupLayout.Alignment.LEADING);					
			for(int j = i; j < countOneLine*(lblItemNames.size()/countOneLine); j+= countOneLine) {				
				groupLbl[i].addComponent(lblItemNames.get(j));								
				groupComponent[i].addComponent(cptItems.get(j));					
			}	
			groupH.addGroup(groupLbl[i]).addGroup(groupComponent[i]);
		}		
		layout.setHorizontalGroup(groupH);	
		//设置竖直布局
		GroupLayout.ParallelGroup groupline[] = new GroupLayout.ParallelGroup[lblItemNames.size()/countOneLine];	
		GroupLayout.SequentialGroup groupV = layout.createSequentialGroup();
		int currentComp = 0;
		for(int i = 0; i < groupline.length; i++) {
			groupline[i] = layout.createParallelGroup(GroupLayout.Alignment.LEADING);						
			for(int count = 0; count < countOneLine; count++) {				
				groupline[i].addComponent(lblItemNames.get(currentComp));								
				groupline[i].addComponent(cptItems.get(currentComp++));					
			}	
			groupV.addGroup(groupline[i]);
						
		}
		layout.setVerticalGroup(groupV);		
		JPanel residue = new JPanel();
		for(int k = countOneLine*(lblItemNames.size()/countOneLine); k < lblItemNames.size(); k++) {
			residue.add(lblItemNames.get(k));
			residue.add(cptItems.get(k));
		}		
		
		Box g = Box.createVerticalBox();
		g.add(topCenter);
		g.add(residue);
		palDetail.add(g);
		
		this.setLayout(new BorderLayout());
		this.add(palDetail,BorderLayout.NORTH);
		popUpMenu = new JPopupMenu();
	}
	/**
	 * @param data 用于刷新表格的数据
	 */
	public void freshInfromation(Candidate c){	
		jTextname.setText(c.getCandidateName());
		jTextgender.setText(c.getCandidateGender());
		jTextage.setText(String.valueOf(c.getCandidateAge()));
		jTextphone.setText(c.getCandidatePhone());
		jTextidCard.setText(c.getCandidateIdCard());
		jTextemaile.setText(c.getCandidateEmail());
		jTextmajor.setText(c.getCandidateMajor());
		jTexteducation.setText(c.getCandidateEducationed());
		jTextjobObjective.setText(c.getCandidateJobObjective());
		jTextaddress.setText(c.getCandidateAddress());
		jTextWorkexprence.setText(c.getCandidateWorkExperience());
		setJTextDisable();
	}
	//可编辑
	private void setJTextEnable() {
		for(int i = 0; i < 9; i++) {
			cptItems.get(i).setEnabled(true);
		}
		jTextaddress.setEnabled(true);
		jTextWorkexprence.setEnabled(true);
	}
	//不可编辑
	private void setJTextDisable() {
		for(int i = 0; i < 9; i++) {
			cptItems.get(i).setEnabled(false);
		}
		jTextaddress.setEnabled(false);
		jTextWorkexprence.setEnabled(false);
	}
	
	//设置文本框字体
	private void setJTextfieldFont(JTextField text, Font font) {
		//text.setMaximumSize(text.getPreferredSize());
		text.setEnabled(false);//设置不可编辑状态
		text.setFont(font);//设置字体
		text.setHorizontalAlignment(JTextField.CENTER);
	}
	
}
