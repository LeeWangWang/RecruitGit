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
 * @Description: ��ְ����Ϣ����
 * @Extends: JTabbedPane��ѡ���壩�м�����
 * @Implements: ��
 * @Author: ������
 * @Data: 2018��12��31������4:02:54
 */
public class CandidateGui2 extends JPanel{
	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	
	private List<JLabel> lblItemNames;//��ǩ�б�
	private List<JComponent> cptItems;//Swing����ĸ���
	private List<JButton> btn;//��ť�б�
	private JPanel palDetail;//���
	private JTable tblInfo;//���
	private DefaultTableModel model;//�洢��Ԫ�����
	private Vector<String> tableColNames;//�ַ����б�	
	private JPopupMenu popUpMenu;//�����˵�
	private final int countOneLine = 2;
	
	public CandidateGui2(Candidate candidate) throws Exception  {
		Font font = new Font(StyleArgument.FONTNAME,StyleArgument.FONTSTYLE,StyleArgument.FONTSIZE);
		//��ǩ
		List<String> itemNames=new ArrayList<String>();
		itemNames.add("����");
		itemNames.add("�Ա�");
		itemNames.add("����");
		itemNames.add("�绰");
		itemNames.add("���֤");
		itemNames.add("����");
		itemNames.add("��ַ");
		itemNames.add("רҵ");
		itemNames.add("ѧ��");
		itemNames.add("������н");
		itemNames.add("��������");
		tableColNames = new Vector<String>(itemNames);
		lblItemNames = new ArrayList<JLabel>();
		for(int i = 0; i < itemNames.size(); i++) {
			JLabel jLabel = new JLabel(itemNames.get(i));
			jLabel.setFont(font);
			lblItemNames.add(jLabel);
		}
		//�ı���
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
		//��ť
		btn = new ArrayList<JButton>();
		JButton btnEdit = new JButton("�༭");
		JButton btnSave = new JButton("����");
		JButton btnQuit = new JButton("�˳�");
		JButton btnPrint = new JButton("��ӡ");
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
}

