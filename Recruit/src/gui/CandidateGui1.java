package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
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
	private MyTableModel  model;//存储单元格对象
	private Vector<String> tableColNames;//字符串列表	
	private JPopupMenu popUpMenu;//弹出菜单
	private final int countOneLine = 3;
	private final int fields1_length = 6;
	private ResumeService resume;
	private Position currentResume;
	private PositionService positionService;
	private CandidateService candidateService;
	private CompanyService companyService;
	
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
		List<JTextField> jTextField = new ArrayList<JTextField>();
		for(int i = 0; i < itemNames.size(); i++) {
			JLabel jLabel = new JLabel(itemNames.get(i));
			jLabel.setFont(font);
			lblItemNames.add(jLabel);
		}
		//文本框
		cptItems = new ArrayList<JComponent>();
		for(int i = 0; i< fields1_length;i++) {
			JTextField t =new JTextField(15);
			t.setMaximumSize(t.getPreferredSize());
			t.setEnabled(false);//设置不可编辑状态
			t.setFont(font);//设置字体
			jTextField.add(t);
			cptItems.add(t);
		}
		
		resume = new ResumeServImpl(new ResumeDaoImpl());
		//按钮
		btn = new ArrayList<JButton>();
		JButton btnSendRecurit = new JButton("投递简历");
		btnSendRecurit.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				int currentRow = tblInfo.getSelectedRow();
				if(currentRow == -1) {//如果表格未被选中
					JOptionPane.showMessageDialog(CandidateGui1.this, "请选中要应聘的职业", "确认", JOptionPane.INFORMATION_MESSAGE);
					return ;
				}
				if(JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(CandidateGui1.this, "确认应聘该职位吗?")) {
					Resume res = new Resume();//新的投递信
					res.setCandidateId(currentCandidate.getCandidateId());//获取求职者编号
					System.out.println("申请人Id：" + res.getCandidateId());
					res.setPositionId(Integer.parseInt(jTextField.get(0).getText()));//获取职位编号
					System.out.println("申请职位：" + jTextField.get(1).getText() + "  职位编号：" + res.getCandidateId());
					res.setIsInterview(0);//设置是否录取
					//&**********************************************求职者投递简历*******************************************&//
					if(resume.addResume(res)) {
						JOptionPane.showMessageDialog(CandidateGui1.this, "申请成功", "确认", JOptionPane.INFORMATION_MESSAGE);
						return;
					}else {
						JOptionPane.showMessageDialog(CandidateGui1.this, "已申请，请勿重复申请", "确认", JOptionPane.INFORMATION_MESSAGE);
						return;
					}
				}
			}
		});
		JButton btnQuit1 = new JButton("退出");
		btnQuit1.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(CandidateGui1.this, "确认应聘该职位吗?")) {
					System.exit(0);
				}
			}
		});
		btn.add(btnSendRecurit);
		btn.add(btnQuit1);
		
		palDetail = new JPanel(new BorderLayout());	
		JTextField tfdsearch = new JTextField("搜索",10);
		tfdsearch.setFont(font);
		tfdsearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Vector<Vector<String>> freashTab1 = new Vector<Vector<String>>();
				List<Position> positions = new ArrayList<Position>();
				positions = positionService.search(tfdsearch.getText());//模糊查询职位名
				for(Position p1 : positions) {
					Vector<String> table1 = new Vector<String>();
					String companyName = (companyService.searchByCompanyId(p1.getPositionId())).getCompanyName();
					table1.add(String.valueOf(p1.getPositionId()) + "");//职位编号
					table1.add(p1.getPositionName() + "");//职位名称
					table1.add(companyName + "");//公司名称
					table1.add(p1.getPositionIntroduction() + "");//职位介绍
					table1.add(p1.getPositionDiploma() + "");//学历要求
					table1.add(p1.getPositionLightspot() + "");//职位要求
					freashTab1.add(table1);
				}
				freshTable(freashTab1);
			}
		});
		
		
		JButton btnsearch = new JButton("搜索");
		btnsearch.setFont(font);
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
		model = new MyTableModel(null,tableColNames);
		tblInfo = new JTable(model);
		setJTableFont(tblInfo,font);
		tblInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//System.out.println(arg0);
				int currentRow = tblInfo.getSelectedRow();//获取一行的数据
				if(currentRow == -1)
					return ;				
				for(int i = 0; i < cptItems.size();i++) {
					JComponent c = cptItems.get(i);
					String v =  (String)tblInfo.getValueAt(currentRow, i);//获取当前行的值
					System.out.println(i + v);
					if(v==null)
						v="";
					if(c instanceof JTextComponent) {
						((JTextComponent)c).setText(v);
					}
					else if(c instanceof JComboBox) {//将按钮或可编辑字段与下拉列表组合的组件。
						((JComboBox)c).setSelectedItem(v);
						System.out.println(((JComboBox) c).getSelectedItem().toString());
					}
					else
						if(c instanceof JScrollPane) {//如果是滚动条
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
				if(arg0.isPopupTrigger())//是否弹出右键菜单
					//弹出菜单
					popUpMenu.show(tblInfo, arg0.getX(), arg0.getY());
			}

			@Override//按着鼠标拖动，进行多选
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
		//打印界面
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
	
	private void setJTableFont(JTable table,Font f) {
		table.setFont(f);//设置表格字体
		table.getTableHeader().setFont(f);//设置表头字体
		table.setRowHeight(30);//设置表的高度
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, r);//设置表格内容居中显示
		//table.enable(false);
	}
}

class MyTableModel extends DefaultTableModel{

	public MyTableModel(Vector data,Vector columns) {
		super(data, columns);
	}
	
	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}
}



