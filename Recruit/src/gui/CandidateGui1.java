package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;
import bean.*;
import dao.*;
import service.*;

/**@ClassName: CandidateGui.java
 * @Description: 求职者信息界面
 * @Extends: JTabbedPane（选项卡面板）中间容器
 * @Implements: 无
 * @Author: 李旺旺
 * @Data: 2018年12月31日下午4:02:54
 */
public class CandidateGui1 extends JPanel{
	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	
	private List<JLabel> lblItemNames;//标签列表
	private List<JComponent> cptItems;//Swing组件的根类
	private List<JButton> btn;//按钮列表
	private JPanel palDetail;//面板
	private JTable tblInfo;//表格
	private DefaultTableModel model;//存储单元格对象
	private Vector<String> tableColNames;//字符串列表	
	private JPopupMenu popUpMenu;//弹出菜单
	private final int countOneLine = 3;
	private ResumeService resume;
	private Position currentResume;
	
	public CandidateGui1(Candidate currentCandidate) throws Exception  {
		Font font = new Font(StyleArgument.FONTNAME,StyleArgument.FONTSTYLE,StyleArgument.FONTSIZE);
		//标签
		List<String> itemNames = new ArrayList<String>();
		itemNames.add("职位编号");
		itemNames.add("职位");
		itemNames.add("公司");
		itemNames.add("职位介绍");
		itemNames.add("学历要求");
		itemNames.add("职业需求");
		tableColNames = new Vector<String>(itemNames);
		lblItemNames = new ArrayList<JLabel>();
		for(int i = 0; i < itemNames.size(); i++) {
			JLabel jLabel = new JLabel(itemNames.get(i));
			jLabel.setFont(font);
			lblItemNames.add(jLabel);
		}
		//文本框
		cptItems = new ArrayList<JComponent>();
		JTextField[] fields1 = new JTextField[6];
		for(int i = 0; i< fields1.length;i++) {
			JTextField t =new JTextField(15);
			t.setMaximumSize(t.getPreferredSize());
			t.setEnabled(false);
			t.setFont(font);
			cptItems.add(t);
		}
		
		resume = new ResumeServImpl(new ResumeDaoImpl());
		//按钮
		btn = new ArrayList<JButton>();
		JButton btnSendRecurit = new JButton("投递简历");
		btnSendRecurit.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				Resume res = new Resume();
				res.setCandidateId(currentCandidate.getCandidateId());
				System.out.println(res.getCandidateId());
				res.setPositionId(Integer.parseInt(fields1[1].getText()));
				System.out.println(fields1[1].getText() + res.getCandidateId());
				res.setIsInterview(0);
				
			}
		});
		JButton btnQuit1 = new JButton("退出");
		btnQuit1.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btn.add(btnSendRecurit);
		btn.add(btnQuit1);
		
		palDetail = new JPanel(new BorderLayout());	
		JTextField tfdsearch = new JTextField("搜索",10);
		//加上事件
		
		
		JButton btnsearch = new JButton("搜索");
		//加上事件
		
		
		Box box1 = Box.createHorizontalBox();
		box1.add(tfdsearch);
		box1.add(btnsearch);
		palDetail.add(box1,BorderLayout.NORTH);
		
		Box commond = Box.createHorizontalBox();
		commond.add(Box.createGlue());
		for(JButton b:btn) {
			b.setFont(font);
			commond.add(b);
			commond.add(Box.createGlue());
		}
		palDetail.add(commond,BorderLayout.SOUTH);
		JPanel topCenter =  new JPanel();		
		GroupLayout layout = new GroupLayout(topCenter);
		topCenter.setLayout(layout);
		layout.setAutoCreateContainerGaps(true);
		layout.setAutoCreateGaps(true);
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
		model = new DefaultTableModel(null,tableColNames);
		tblInfo = new JTable(model);
		tblInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//System.out.println(arg0);
				int currentRow = tblInfo.getSelectedRow();
				if(currentRow == -1)
					return ;				
				for(int i = 0; i < cptItems.size();i++) {
					JComponent c = cptItems.get(i);
					String v =  (String)tblInfo.getValueAt(currentRow, i);
					if(v==null)
						v="";
					if(c instanceof JTextComponent)
						((JTextComponent)c).setText(v);
					else if(c instanceof JComboBox)
						((JComboBox)c).setSelectedItem(v);
					else
						if(c instanceof JScrollPane) {
							@SuppressWarnings("unchecked")
							JList<String> list = (JList<String>)(((JScrollPane)c).getViewport().getView());												
							DefaultListModel<String> listModel = (DefaultListModel<String>)(list.getModel());
							String[] value = v.split(";");
							listModel.removeAllElements();
							for (String s : value) {
								listModel.addElement(s);
							}							
						}					
				}
				
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				if(arg0.isPopupTrigger())
					popUpMenu.show(tblInfo, arg0.getX(), arg0.getY());
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				mousePressed(arg0);
				
			}
		
		});
		this.setLayout(new BorderLayout());
		this.add(palDetail,BorderLayout.NORTH);
		this.add(new JScrollPane(tblInfo));		
		popUpMenu = new JPopupMenu();
		JMenuItem printMenu = new JMenuItem("打印...");
		popUpMenu.add(printMenu);
		printMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					tblInfo.print();
				} catch (PrinterException e) {					
					e.printStackTrace();
				}				
			}
			
		});
	}
	/**
	 * 
	 * @param d 定义信息面板中信息明细的分辨率
	 */
	public void setDetailPanelSize(Dimension d) {
		palDetail.setSize(d);
	}
	/**
	 * 
	 * @param data 用于刷新表格的数据
	 */
	public void freshTable(Vector<Vector<String>> data){		
		model.setDataVector(data, tableColNames);
		model.fireTableDataChanged();
	}	
	/**
	 * 
	 * @param data用于刷新表格的数据
	 */
	public void freshTable(List<Position>data){	
		Vector<Vector<String>> vec = new Vector<Vector<String>>();
		for(Object o:data) {
			String[] sDetails = o.toString().split(",");
			Vector<String> line = new Vector<String>();
			for(String str:sDetails)
				line.add(str);
			vec.add(line);
		}			
		freshTable(vec);
	}
}

