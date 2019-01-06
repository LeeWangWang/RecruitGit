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
import bean.Candidate;

/**@ClassName: CandidateGui.java
 * @Description: 求职者信息界面
 * @Extends: JTabbedPane（选项卡面板）中间容器
 * @Implements: 无
 * @Author: 李旺旺
 * @Data: 2018年12月31日下午4:02:54
 */
public class CandidateGui2 extends JPanel{
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
	private final int countOneLine = 2;
	
	public CandidateGui2(Candidate candidate) throws Exception  {
		Font font = new Font(StyleArgument.FONTNAME,StyleArgument.FONTSTYLE,StyleArgument.FONTSIZE);
		//标签
		List<String> itemNames=new ArrayList<String>();
		itemNames.add("姓名");
		itemNames.add("性别");
		itemNames.add("年龄");
		itemNames.add("电话");
		itemNames.add("身份证");
		itemNames.add("邮箱");
		itemNames.add("地址");
		itemNames.add("专业");
		itemNames.add("学历");
		itemNames.add("期望年薪");
		itemNames.add("工作经验");
		tableColNames = new Vector<String>(itemNames);
		lblItemNames = new ArrayList<JLabel>();
		for(int i = 0; i < itemNames.size(); i++) {
			JLabel jLabel = new JLabel(itemNames.get(i));
			jLabel.setFont(font);
			lblItemNames.add(jLabel);
		}
		//文本框
		cptItems = new ArrayList<JComponent>();
		JTextField[] fields1 = new JTextField[10];
		for(int i = 0; i< fields1.length;i++) {
			JTextField t =new JTextField(20);
			t.setMaximumSize(t.getPreferredSize());
			//t.setEnabled(false);
			t.setFont(font);
			cptItems.add(t);
		}
		JTextArea fields3 = new JTextArea(5,62);
		fields3.setMaximumSize(fields3.getPreferredSize());
		fields3.setFont(font);
		cptItems.add(fields3);
		//按钮
		btn = new ArrayList<JButton>();
		JButton btnEdit = new JButton("编辑");
		JButton btnSave = new JButton("保存");
		JButton btnQuit = new JButton("退出");
		JButton btnPrint = new JButton("打印");
		btn.add(btnEdit);
		btn.add(btnSave);
		btn.add(btnQuit);
		btn.add(btnPrint);
		
		palDetail = new JPanel(new BorderLayout());	
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
		
		this.setLayout(new BorderLayout());
		this.add(palDetail,BorderLayout.NORTH);
		popUpMenu = new JPopupMenu();
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
	public void freshTable(List<?>data){	
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

