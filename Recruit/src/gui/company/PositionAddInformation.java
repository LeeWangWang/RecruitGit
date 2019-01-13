/**@FileName:PositionAddInformation.java
 * @Description:
 * @Author:周天乐Sio
 * @Date:2019年1月4日
 */
package gui.company;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;

import bean.*;
import dao.*;
import gui.candidate.MyTableModel;
import service.*;

/**@Description:
 * @FileName:PositionAddInformation.java
 * @Author:周天乐Sio
 * @Date:2019年1月4日
 */
public class PositionAddInformation extends JPanel{

	private List<JLabel> lblItemNames;
	private List<JComponent> cptItems;
	private List<JButton> btn;	
	private JPanel palDetail;
	private JTable tblInfo;
	private MyTableModel model;
	private Vector<String> tableColNames;	
	private JPopupMenu popUpMenu;
	private PositionService positionService;
	/**
	 * 
	 * @param itemNames:表格tblInfo列名称或者信息面板上方信息明细
	 * @param items:信息面板上方输入或选择组件
	 * @param btnCommond:信息面板右侧按钮列表
	 * @param countOneLine:信息面板上方每行显示的信息明细项数
	 * @throws Exception
	 */
	public PositionAddInformation(List<String> itemNames,List<String> talNames,List<JComponent> items,List<JButton> btnCommond,
			int countOneLine) throws Exception  {
		
		positionService = new PositionServImpl(new PositionDaoImpl());
		int companyId = 1;
		tableColNames = new Vector<String>(talNames);
		lblItemNames = new ArrayList<JLabel>();
		for(int i = 0; i < itemNames.size(); i++)
			lblItemNames.add(new JLabel(itemNames.get(i)));
		cptItems = items;		
		btn = btnCommond;
		palDetail = new JPanel(new BorderLayout());		
		Box commond = Box.createHorizontalBox();
		Component vGlue = Box.createHorizontalGlue();
		Component vGlue2 = Box.createHorizontalGlue();
		Component vGlue3 = Box.createHorizontalGlue();
		commond.add(vGlue);
		commond.add(vGlue2);
		for(JButton b:btnCommond) {
			commond.add(b);
		}
		commond.add(vGlue3);
		commond.add(Box.createGlue());
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
