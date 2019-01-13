/**@FileName:DealResumePanel.java
 * @Description:
 * @Author:周天乐Sio
 * @Date:2019年1月7日
 */
package gui.company;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import bean.*;
import dao.*;
import service.*;
import gui.candidate.*;

/**@Description:
 * @FileName:DealResumePanel.java
 * @Author:周天乐Sio
 * @Date:2019年1月7日
 */
public class DealResumePanel extends JPanel{
	private List<JLabel> lblItemNames;
	private List<JComponent> cptItems;
	private JButton btn;	
	private JPanel palDetail;
	private JTable tblInfo;
	private MyTableModel model;
	private Vector<String> tableColNames;	
	private JPopupMenu popUpMenu;
	private ResumeService resumeService;
	/**
	 * 
	 * @param itemNames:表格tblInfo列名称或者信息面板上方信息明细
	 * @param items:信息面板上方输入或选择组件
	 * @param btnCommond:信息面板右侧按钮列表
	 * @param countOneLine:信息面板上方每行显示的信息明细项数
	 * @throws Exception
	 */
	public DealResumePanel(List<String> itemNames,List<String> talNames,List<JComponent> items,List<JButton> btnCommond,
			int countOneLine) throws Exception  {
		int companyId = 1;
		resumeService = new ResumeServImpl(new ResumeDaoImpl());
		tableColNames = new Vector<String>(talNames);
		lblItemNames = new ArrayList<JLabel>();
		for(int i = 0; i < itemNames.size(); i++)
			lblItemNames.add(new JLabel(itemNames.get(i)));
		cptItems = items;		
		btn = btnCommond.get(1);
		palDetail = new JPanel(new BorderLayout());		
		Box commond = Box.createVerticalBox();
		Component vGlue = Box.createVerticalGlue();
		commond.add(vGlue);
		for(JButton bt:btnCommond) {
			commond.add(bt);
			Component vGlueadd = Box.createVerticalGlue();
			commond.add(vGlueadd);
		}

		commond.add(Box.createGlue());
		
		palDetail.add(commond,BorderLayout.EAST);
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
		
		this.setJTableFont(tblInfo, new Font("宋体",Font.PLAIN,16));
		
		tblInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int clickCount = arg0.getClickCount();
				int lr = arg0.getButton();
				int pId,cId;
				int count = tblInfo.getSelectedRow();
				int hang = tblInfo.convertRowIndexToModel(tblInfo.getSelectedRow());
				pId = Integer.valueOf((tblInfo.getModel().getValueAt(hang, tblInfo.convertColumnIndexToModel(0))).toString());
				cId = Integer.valueOf((tblInfo.getModel().getValueAt(hang, tblInfo.convertColumnIndexToModel(2))).toString());				

				new UpdatePositionPanel(pId,cId);
				
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				if(arg0.isPopupTrigger()) {
					
				}
					//popUpMenu.show(tblInfo, arg0.getX(), arg0.getY());
					
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
	public static void setJTableFont(JTable table,Font f) {
		table.setFont(f);//设置表格字体
		table.getTableHeader().setFont(f);//设置表头字体
		table.setRowHeight(30);//设置表的高度
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, r);//设置表格内容居中显示
		//table.enable(false);
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
