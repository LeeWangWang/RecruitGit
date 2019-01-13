/**@FileName:InformationPal.java
 * @Description:
 * @Author:������Sio
 * @Date:2019��1��4��
 */
package gui.company;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.*;
import javax.swing.text.JTextComponent;

/**@Description:
 * @FileName:InformationPal.java
 * @Author:������Sio
 * @Date:2019��1��4��
 */
public class InformationPal extends JPanel{

	private List<JLabel> lblItemNames;
	private List<JComponent> cptItems;
	private List<JButton> btn;	
	private JPanel palDetail;
	private JTable tblInfo;
	private DefaultTableModel model;
	private Vector<String> tableColNames;	
	private JPopupMenu popUpMenu;
	/**
	 * 
	 * @param itemNames:���tblInfo�����ƻ�����Ϣ����Ϸ���Ϣ��ϸ
	 * @param items:��Ϣ����Ϸ������ѡ�����
	 * @param btnCommond:��Ϣ����Ҳఴť�б�
	 * @param countOneLine:��Ϣ����Ϸ�ÿ����ʾ����Ϣ��ϸ����
	 * @throws Exception
	 */
	public InformationPal(List<String> itemNames,List<String> talNames,List<JComponent> items,List<JButton> btnCommond,
			int countOneLine) throws Exception  {
		tableColNames = new Vector<String>(talNames);
		lblItemNames = new ArrayList<JLabel>();
		for(int i = 0; i < itemNames.size(); i++)
			lblItemNames.add(new JLabel(itemNames.get(i)));
		cptItems = items;		
		btn = btnCommond;
		palDetail = new JPanel(new BorderLayout());		
		Box commond = Box.createVerticalBox();
		for(JButton b:btn) {
			commond.add(b);
			commond.add(Box.createGlue());
		}
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
		JMenuItem printMenu = new JMenuItem("��ӡ...");
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
	 * @param d ������Ϣ�������Ϣ��ϸ�ķֱ���
	 */
	public void setDetailPanelSize(Dimension d) {
		palDetail.setSize(d);
	}
	/**
	 * 
	 * @param data ����ˢ�±�������
	 */
	public void freshTable(Vector<Vector<String>> data){		
		model.setDataVector(data, tableColNames);
		model.fireTableDataChanged();
	}	
	/**
	 * 
	 * @param data����ˢ�±�������
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
	/*public void FreshTable(List<?>data) {
		Vector<Vector<String>> vec = new Vector<Vector<String>>();
		for(Object o:data) {
			
		}
	}*/
	/*public static void main(String[] args) {
		
		JFrame me = new JFrame();
		List<String> lblItemNames=new ArrayList<String>();
		lblItemNames.add("ְλId");
		lblItemNames.add("ְλ����");
		lblItemNames.add("��˾ID");
		lblItemNames.add("ְλ����");
		lblItemNames.add("ѧ������");
		lblItemNames.add("��������");
		List<String> talItemNames = new ArrayList<String>();
		talItemNames.add("ְλId");
		talItemNames.add("ְλ����");
		talItemNames.add("��ְ��ID");
		talItemNames.add("��ְ������");
		talItemNames.add("��ְ��ѧ��");
		List<JComponent> cptItems = new ArrayList<JComponent>();
		JTextField[] fields = new JTextField[8];
		for(int tempi=0;tempi<8;tempi++) {
			fields[tempi].setText("askdghas");
		}
		///for(int i = 0; i< fields.length;i++) {
		//	JTextField t =new JTextField(10);
		//	t.setMaximumSize(t.getPreferredSize());
		//	cptItems.add(t);
		//}	
		JComboBox com = new JComboBox();
		com.addItem("");
		//com.addItem("data04");
		//com.addItem("data14");
		//com.addItem("data24");
		//com.addItem("data34");
		com.setMaximumSize(com.getPreferredSize());
		cptItems.add(com);
		List<JButton> btnCommond = new ArrayList<JButton>();
		//btnCommond.add(new JButton("������Ƹ��Ϣ"));
		//btnCommond.add(new JButton("ɾ����Ƹ��Ϣ"));
		//btnCommond.add(new JButton("�޸���Ƹ��Ϣ"));
		//btnCommond.add(new JButton("��ť4"));		
		try {
			InformationPal pal = new InformationPal(lblItemNames,talItemNames,cptItems,btnCommond,3);
			pal.setSize(new Dimension(400,250));
			Vector<Vector<String>> d = new Vector<Vector<String>>();
			for(int i= 0; i < 8; i++){
				Vector<String> di = new Vector<String>();
				for(int j = 0; j <6; j++)
					di.add("data"+i+j+"");
				d.add(di);
			}
			
			pal.freshTable(d);
			//pal.setSize(new Dimension(400,500));
			me.add(pal);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//me.setBounds(100,200,400,500);;
		me.pack();
		me.setVisible(true);
		me.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}*/
}
