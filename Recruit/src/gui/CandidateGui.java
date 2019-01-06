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

/**@ClassName: CandidateGui.java
 * @Description: 求职者信息界面
 * @Extends: JTabbedPane（选项卡面板）中间容器
 * @Implements: 无
 * @Author: 李旺旺
 * @Data: 2018年12月31日下午4:02:54
 */
public class CandidateGui extends JPanel{
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
	/**
	 * @param itemNames:表格tblInfo列名称或者信息面板上方信息明细
	 * @param items:信息面板上方输入或选择组件
	 * @param btnCommond:信息面板右侧按钮列表
	 * @param countOneLine:信息面板上方每行显示的信息明细项数
	 * @throws Exception
	 */
	public CandidateGui() {}
	public CandidateGui(List<String> itemNames,List<JComponent> items,List<JButton> btnCommond,int countOneLine) throws Exception  {
		Font f = new Font(StyleArgument.FONTNAME,StyleArgument.FONTSTYLE,
				StyleArgument.FONTSIZE);
		if(countOneLine == 3) {//面板 1 *******************************************************
			palDetail = new JPanel(new BorderLayout());	
			JTextField tfdsearch = new JTextField("搜索",10);
			//加上事件
			
			
			JButton btnsearch = new JButton("搜索");
			//加上事件
			
			
			
			Box box1 = Box.createHorizontalBox();
			box1.add(tfdsearch);
			box1.add(btnsearch);
			palDetail.add(box1,BorderLayout.NORTH);
			
			tableColNames = new Vector<String>(itemNames);
			lblItemNames = new ArrayList<JLabel>();
			for(int i = 0; i < itemNames.size(); i++) {
				JLabel jLabel = new JLabel(itemNames.get(i));
				jLabel.setFont(f);
				lblItemNames.add(jLabel);
			}
			cptItems = items;		
			btn = btnCommond;
			Box commond = Box.createHorizontalBox();
			commond.add(Box.createGlue());
			for(JButton b:btn) {
				b.setFont(f);
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
		}else {//面板 2 *******************************************************
			palDetail = new JPanel(new BorderLayout());	
			tableColNames = new Vector<String>(itemNames);
			lblItemNames = new ArrayList<JLabel>();
			for(int i = 0; i < itemNames.size(); i++) {
				JLabel jLabel = new JLabel(itemNames.get(i));
				jLabel.setFont(f);
				lblItemNames.add(jLabel);
			}
			cptItems = items;		
			btn = btnCommond;
			Box commond = Box.createHorizontalBox();
			commond.add(Box.createGlue());
			for(JButton b:btn) {
				b.setFont(f);
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
			
			this.setLayout(new BorderLayout());
			this.add(palDetail,BorderLayout.NORTH);
			//this.add(new JScrollPane(tblInfo));		
			popUpMenu = new JPopupMenu();
		}
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
	public static void Candidate1() {
		Font font = new Font(StyleArgument.FONTNAME,StyleArgument.FONTSTYLE,
				StyleArgument.FONTSIZE);
		JTabbedPane top = new JTabbedPane();
		JFrame me = new JFrame();
		//界面 1 的属性*********************************************
		List<String> lblItemNames1=new ArrayList<String>();
		lblItemNames1.add("职位编号");
		lblItemNames1.add("职位");
		lblItemNames1.add("公司");
		lblItemNames1.add("职位介绍");
		lblItemNames1.add("学历要求");
		lblItemNames1.add("职业需求");
		List<JComponent> cptItems1 = new ArrayList<JComponent>();
		JTextField[] fields1 = new JTextField[6];
		for(int i = 0; i< fields1.length;i++) {
			JTextField t =new JTextField(15);
			t.setMaximumSize(t.getPreferredSize());
			t.setEnabled(false);
			t.setFont(font);
			cptItems1.add(t);
		}
		List<JButton> btnCommond1 = new ArrayList<JButton>();
		JButton btnSendRecurit = new JButton("投递简历");
		JButton btnQuit1 = new JButton("退出");
		btnSendRecurit.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnQuit1.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnCommond1.add(btnSendRecurit);
		btnCommond1.add(btnQuit1);
		
		//界面 2 的属性*********************************************
		List<String> lblItemNames2=new ArrayList<String>();
		lblItemNames2.add("姓名");
		lblItemNames2.add("性别");
		lblItemNames2.add("年龄");
		lblItemNames2.add("电话");
		lblItemNames2.add("身份证");
		lblItemNames2.add("邮箱");
		lblItemNames2.add("地址");
		lblItemNames2.add("专业");
		lblItemNames2.add("学历");
		lblItemNames2.add("期望年薪");
		lblItemNames2.add("工作经验");
		List<JComponent> cptItems2 = new ArrayList<JComponent>();
		JTextField[] fields2 = new JTextField[10];
		for(int i = 0; i< fields2.length;i++) {
			JTextField t =new JTextField(20);
			t.setMaximumSize(t.getPreferredSize());
			//t.setEnabled(false);
			t.setFont(font);
			cptItems2.add(t);
		}
		JTextArea fields3 = new JTextArea(5,62);
		fields3.setMaximumSize(fields3.getPreferredSize());
		fields3.setFont(font);
		cptItems2.add(fields3);
		List<JButton> btnCommond2 = new ArrayList<JButton>();
		JButton btnEdit = new JButton("编辑");
		JButton btnSave = new JButton("保存");
		JButton btnQuit2 = new JButton("退出");
		JButton btnFreash = new JButton("打印");
		btnCommond2.add(btnEdit);
		btnCommond2.add(btnSave);
		btnCommond2.add(btnQuit2);
		btnCommond2.add(btnFreash);
		try {
			CandidateGui pal1 = new CandidateGui(lblItemNames1,cptItems1,btnCommond1,3);
			CandidateGui pal2 = new CandidateGui(lblItemNames2,cptItems2,btnCommond2,2);
			//pal1.setSize(new Dimension(400,250));
			//pal2.setSize(new Dimension(400,250));
			Vector<Vector<String>> d = new Vector<Vector<String>>();
			for(int i= 0; i < 4; i++){
				Vector<String> di = new Vector<String>();
				for(int j = 0; j <6; j++)
					di.add("data"+i+j+"");
				d.add(di);
			}
			pal1.freshTable(d);
			pal2.freshTable(d);
			top.add("找工作",pal1);
			top.add("个人简历",pal2);
			//top.setSize(new Dimension(400,300));
			me.add(top);
		} catch (Exception e) {
			e.printStackTrace();
		}
		me.setBounds(100,200,700,400);
		//me.pack();
		me.setVisible(true);
		me.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	
	public static void main(String[] args) {
		CandidateGui.Candidate1();
	}
	
}

