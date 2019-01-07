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
 * @Description: ��ְ����Ϣ����
 * @Extends: JTabbedPane��ѡ���壩�м�����
 * @Implements: ��
 * @Author: ������
 * @Data: 2018��12��31������4:02:54
 */
public class CandidateGui1 extends JPanel{
	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	
	private List<JLabel> lblItemNames;//��ǩ�б�
	private List<JComponent> cptItems;//Swing����ĸ���
	private List<JButton> btn;//��ť�б�
	private JPanel palDetail;//���
	private JTable tblInfo;//���
	private MyTableModel  model;//�洢��Ԫ�����
	private Vector<String> tableColNames;//�ַ����б�	
	private JPopupMenu popUpMenu;//�����˵�
	private final int countOneLine = 3;
	private final int fields1_length = 6;
	private ResumeService resume;
	private Position currentResume;
	private PositionService positionService;
	private CandidateService candidateService;
	private CompanyService companyService;
	
	public CandidateGui1(Candidate currentCandidate) throws Exception  {
		Font font = new Font(StyleArgument.FONTNAME,StyleArgument.FONTSTYLE,StyleArgument.FONTSIZE);
		//��ǩ
		List<String> itemNames = new ArrayList<String>();
		itemNames.add("ְλ���");
		itemNames.add("ְλ");
		itemNames.add("��˾");
		itemNames.add("ְλ����");
		itemNames.add("ѧ��Ҫ��");
		itemNames.add("ְҵ����");
		tableColNames = new Vector<String>(itemNames);
		lblItemNames = new ArrayList<JLabel>();
		List<JTextField> jTextField = new ArrayList<JTextField>();
		for(int i = 0; i < itemNames.size(); i++) {
			JLabel jLabel = new JLabel(itemNames.get(i));
			jLabel.setFont(font);
			lblItemNames.add(jLabel);
		}
		//�ı���
		cptItems = new ArrayList<JComponent>();
		for(int i = 0; i< fields1_length;i++) {
			JTextField t =new JTextField(15);
			t.setMaximumSize(t.getPreferredSize());
			t.setEnabled(false);//���ò��ɱ༭״̬
			t.setFont(font);//��������
			jTextField.add(t);
			cptItems.add(t);
		}
		
		resume = new ResumeServImpl(new ResumeDaoImpl());
		//��ť
		btn = new ArrayList<JButton>();
		JButton btnSendRecurit = new JButton("Ͷ�ݼ���");
		btnSendRecurit.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				int currentRow = tblInfo.getSelectedRow();
				if(currentRow == -1) {//������δ��ѡ��
					JOptionPane.showMessageDialog(CandidateGui1.this, "��ѡ��ҪӦƸ��ְҵ", "ȷ��", JOptionPane.INFORMATION_MESSAGE);
					return ;
				}
				if(JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(CandidateGui1.this, "ȷ��ӦƸ��ְλ��?")) {
					Resume res = new Resume();//�µ�Ͷ����
					res.setCandidateId(currentCandidate.getCandidateId());//��ȡ��ְ�߱��
					System.out.println("������Id��" + res.getCandidateId());
					res.setPositionId(Integer.parseInt(jTextField.get(0).getText()));//��ȡְλ���
					System.out.println("����ְλ��" + jTextField.get(1).getText() + "  ְλ��ţ�" + res.getCandidateId());
					res.setIsInterview(0);//�����Ƿ�¼ȡ
					//&**********************************************��ְ��Ͷ�ݼ���*******************************************&//
					if(resume.addResume(res)) {
						JOptionPane.showMessageDialog(CandidateGui1.this, "����ɹ�", "ȷ��", JOptionPane.INFORMATION_MESSAGE);
						return;
					}else {
						JOptionPane.showMessageDialog(CandidateGui1.this, "�����룬�����ظ�����", "ȷ��", JOptionPane.INFORMATION_MESSAGE);
						return;
					}
				}
			}
		});
		JButton btnQuit1 = new JButton("�˳�");
		btnQuit1.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(CandidateGui1.this, "ȷ��ӦƸ��ְλ��?")) {
					System.exit(0);
				}
			}
		});
		btn.add(btnSendRecurit);
		btn.add(btnQuit1);
		
		palDetail = new JPanel(new BorderLayout());	
		JTextField tfdsearch = new JTextField("����",10);
		tfdsearch.setFont(font);
		tfdsearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Vector<Vector<String>> freashTab1 = new Vector<Vector<String>>();
				List<Position> positions = new ArrayList<Position>();
				positions = positionService.search(tfdsearch.getText());//ģ����ѯְλ��
				for(Position p1 : positions) {
					Vector<String> table1 = new Vector<String>();
					String companyName = (companyService.searchByCompanyId(p1.getPositionId())).getCompanyName();
					table1.add(String.valueOf(p1.getPositionId()) + "");//ְλ���
					table1.add(p1.getPositionName() + "");//ְλ����
					table1.add(companyName + "");//��˾����
					table1.add(p1.getPositionIntroduction() + "");//ְλ����
					table1.add(p1.getPositionDiploma() + "");//ѧ��Ҫ��
					table1.add(p1.getPositionLightspot() + "");//ְλҪ��
					freashTab1.add(table1);
				}
				freshTable(freashTab1);
			}
		});
		
		
		JButton btnsearch = new JButton("����");
		btnsearch.setFont(font);
		//�����¼�
		
		
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
				int currentRow = tblInfo.getSelectedRow();//��ȡһ�е�����
				if(currentRow == -1)
					return ;				
				for(int i = 0; i < cptItems.size();i++) {
					JComponent c = cptItems.get(i);
					String v =  (String)tblInfo.getValueAt(currentRow, i);//��ȡ��ǰ�е�ֵ
					System.out.println(i + v);
					if(v==null)
						v="";
					if(c instanceof JTextComponent) {
						((JTextComponent)c).setText(v);
					}
					else if(c instanceof JComboBox) {//����ť��ɱ༭�ֶ��������б���ϵ������
						((JComboBox)c).setSelectedItem(v);
						System.out.println(((JComboBox) c).getSelectedItem().toString());
					}
					else
						if(c instanceof JScrollPane) {//����ǹ�����
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
				if(arg0.isPopupTrigger())//�Ƿ񵯳��Ҽ��˵�
					//�����˵�
					popUpMenu.show(tblInfo, arg0.getX(), arg0.getY());
			}

			@Override//��������϶������ж�ѡ
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
		//��ӡ����
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
	
	private void setJTableFont(JTable table,Font f) {
		table.setFont(f);//���ñ������
		table.getTableHeader().setFont(f);//���ñ�ͷ����
		table.setRowHeight(30);//���ñ�ĸ߶�
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, r);//���ñ�����ݾ�����ʾ
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



