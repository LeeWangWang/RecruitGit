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

public class Test extends JPanel{
	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	
	private List<JLabel> lblItemNames;//标签列表
	private List<JComponent> cptItems;//Swing组件的根类
	private List<JButton> btn;//按钮列表
	private List<JTextField> freshJTextField;//刷新文本
	private JPanel palDetail;//面板
	private Vector<String> tableColNames;//字符串列表	
	private JPopupMenu popUpMenu;//弹出菜单
	private final int countOneLine = 3;
	
	public Test(Candidate candidate) throws Exception  {
		Font font = new Font(StyleArgument.FONTNAME,StyleArgument.FONTSTYLE,StyleArgument.FONTSIZE);
		//标签
		List<String> itemNames=new ArrayList<String>();
		itemNames.add("姓名");
		itemNames.add("性别");
		itemNames.add("年龄");
		itemNames.add("电话");
		itemNames.add("身份证");
		itemNames.add("邮箱");
		itemNames.add("专业");
		itemNames.add("学历");
		itemNames.add("期望年薪");
		
		//itemNames.add("地址");
		//itemNames.add("工作经验");
		tableColNames = new Vector<String>(itemNames);
		lblItemNames = new ArrayList<JLabel>();
		for(int i = 0; i < itemNames.size(); i++) {
			JLabel jLabel = new JLabel(itemNames.get(i));
			jLabel.setFont(font);
			lblItemNames.add(jLabel);
		}
		//文本框
		cptItems = new ArrayList<JComponent>();
		JTextField[] fields1 = new JTextField[9];
		for(int i = 0; i< fields1.length;i++) {
			JTextField t = new JTextField(30);
			setJTextfieldFont(t, font);
			t.setFont(font);
			cptItems.add(t);
		}
		JTextField t = new JTextField(50);
		setJTextfieldFont(t, font);
		t.setFont(font);
		cptItems.add(t);
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
	public void freshInfromation(Candidate c){	
		
	}
	
	private void setJTextfieldFont2(JTextField text, Font font) {
		text.setMaximumSize(text.getPreferredSize());
		text.setEnabled(false);//设置不可编辑状态
		text.setFont(font);//设置字体
		text.setHorizontalAlignment(JTextField.CENTER);
	}
	
	private void setJTextfieldFont(JTextField jTextField, Font font) {
		jTextField.setMaximumSize(jTextField.getPreferredSize());
		//jTextField.setEnabled(false);//设置不可编辑状态
		jTextField.setFont(font);//设置字体
		jTextField.setHorizontalAlignment(JTextField.CENTER);
	}
	
}








