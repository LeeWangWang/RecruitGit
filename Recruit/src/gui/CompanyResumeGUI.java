package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;
import bean.Company;
import bean.Position;
import bean.Resume;
import dao.CompanyDao;
import dao.CompanyDaoImpl;
import dao.PositionDao;
import dao.PositionDaoImpl;
import dao.ResumeDao;
import dao.ResumeDaoImpl;
import gui.customStyle.ButtonFont;
import gui.customStyle.StyleArgument;
import service.CompanyService;
import service.CompanyServiceImpl;
import service.PositionServImpl;
import service.PositionService;
import service.ResumeServImpl;
import service.ResumeService;
import sun.swing.table.DefaultTableCellHeaderRenderer;

public class CompanyResumeGUI extends JPanel{
	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	private List<JLabel> lblItemNames;        //չʾ��Ϣ����������
	private List<JComponent> cptItems;
	private JPanel palDetail;
	private JTable tblInfo;
	private DefaultTableModel model;
	private Vector<String> tableColNames;	
	private JPopupMenu popUpMenu;
	public int randidateId;
	private ButtonFont exit;               //�˳�
	private ButtonFont readPosition;	   //��ȡְλ��Ϣ
	private ButtonFont readCompany;        //��ȡ��˾��Ϣ
	private int hang;
	
	public int getRandidateId() {
		return randidateId;
	}
	public void windClose() {
		this.setVisible(false);
		
	}
	public CompanyResumeGUI(List<String> itemNames,List<JComponent> items,List<JButton> btnCommond,
			int countOneLine, int randidateId) throws Exception  {
		
		this.randidateId = randidateId;
		Font f = new Font(StyleArgument.FONTNAME, StyleArgument.FONTSTYLE,StyleArgument.FONTSIZE);
		//����������Ϣ���д洢
		tableColNames = new Vector<String>(itemNames);
		lblItemNames = new ArrayList<JLabel>();
		for(int i = 0; i < itemNames.size(); i++)
		lblItemNames.add(new JLabel(itemNames.get(i)));
		cptItems = items;		
		palDetail = new JPanel(new BorderLayout());
		
		exit = new ButtonFont("ˢ��", f); //�˳�����
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		readPosition = new ButtonFont("��ȡ��ְλ��Ϣ",f);
		readPosition.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				PositionDao position = new PositionDaoImpl();
				PositionService positionSearch = new PositionServImpl(position);
				ResumeDao  resume = new ResumeDaoImpl();
				ResumeService resumeService = new ResumeServImpl(resume);
				CompanyDao companydao = new CompanyDaoImpl();
				CompanyService companyService = new CompanyServiceImpl(companydao);
				
				List<Company> companyList = new ArrayList<Company>();
				List<Position> positList = new ArrayList<Position>();
				List<Resume> resumeList = new ArrayList<Resume>(); 
				companyList = companyService.searchAll();//�������ŵ������еĹ�˾����Ϣ
				positList = positionSearch.searchAll(); //�������ŵ������е�ְλ����Ϣ
				resumeList = resumeService.searchAll(); //�������ŵ�������Ͷ����������Ϣ
				List<Position> zhanshi = new ArrayList<Position>();
				
				Jihe jihe = new Jihe(getRandidateId(), positList, resumeList, companyList);
				Vector<Ren> ren = new Vector<Ren>();
				ren = jihe.getRenOnce();
				int positionid = 0;
				positionid = ren.get(getHang()).getPositionId();
				Position newp = new Position();
				newp = positionSearch.searchByPositionId(positionid);
				System.out.println(newp);
				
				new CandidateResumeTanGUI(newp);
			}
		});
		readCompany = new ButtonFont("��ȡ��˾��Ϣ",f);
		readCompany.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				PositionDao position = new PositionDaoImpl();
				PositionService positionSearch = new PositionServImpl(position);
				ResumeDao  resume = new ResumeDaoImpl();
				ResumeService resumeService = new ResumeServImpl(resume);
				CompanyDao companydao = new CompanyDaoImpl();
				CompanyService companyService = new CompanyServiceImpl(companydao);
				
				List<Company> companyList = new ArrayList<Company>();
				List<Position> positList = new ArrayList<Position>();
				List<Resume> resumeList = new ArrayList<Resume>(); 
				companyList = companyService.searchAll();//�������ŵ������еĹ�˾����Ϣ
				positList = positionSearch.searchAll(); //�������ŵ������е�ְλ����Ϣ
				resumeList = resumeService.searchAll(); //�������ŵ�������Ͷ����������Ϣ
				List<Position> zhanshi = new ArrayList<Position>();
			}
			
		});
		//���ð�ť�Ĵ�ֱ�����������ð���
		Box commond = Box.createVerticalBox();//��ֱ����  
		commond.add(readPosition);
		commond.add(Box.createRigidArea(new Dimension(47, 30)));
		commond.add(exit);
		
		JPanel topCenter =  new JPanel();		
		GroupLayout layout = new GroupLayout(topCenter);
		topCenter.setLayout(layout);
		layout.setAutoCreateContainerGaps(true);// �Զ����������봥������֮��ļ�϶
		layout.setAutoCreateGaps(true);			// �Զ��������֮��ļ�϶
		//���������JTextField�ĳ���ˮƽ��
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
		//��������Ļ��й��ܣ���ֱ��
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
		tblInfo = new JTable(model); //�����
		setJTableFont(tblInfo,f);
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
				if(arg0.getClickCount() == 1) {
					Point p = arg0.getPoint();
			        int row = tblInfo.rowAtPoint(p);
			        int column = tblInfo.columnAtPoint(p);
			        setHang(row);
				}
				if(arg0.getClickCount() == 2) {
					Point p = arg0.getPoint();
			        int row = tblInfo.rowAtPoint(p);
			        int column = tblInfo.columnAtPoint(p);
					//System.out.println(row);
			        //�鿴ְλ��Ϣ
			      //�����ݿ��е����ݽ��ж�ȡ ��ŵ�List��
					PositionDao position = new PositionDaoImpl();
					PositionService positionSearch = new PositionServImpl(position);
					ResumeDao  resume = new ResumeDaoImpl();
					ResumeService resumeService = new ResumeServImpl(resume);
					CompanyDao companydao = new CompanyDaoImpl();
					CompanyService companyService = new CompanyServiceImpl(companydao);
					
					List<Company> companyList = new ArrayList<Company>();
					List<Position> positList = new ArrayList<Position>();
					List<Resume> resumeList = new ArrayList<Resume>(); 
					companyList = companyService.searchAll();//�������ŵ������еĹ�˾����Ϣ
					positList = positionSearch.searchAll(); //�������ŵ������е�ְλ����Ϣ
					resumeList = resumeService.searchAll(); //�������ŵ�������Ͷ����������Ϣ
					List<Position> zhanshi = new ArrayList<Position>();
					
					Jihe jihe = new Jihe(randidateId,positList,resumeList,companyList);//�����Ǹ��˵�ID
					Vector<Ren> ren = new Vector<Ren>();
					ren = jihe.getRenOnce();
					int positionid = 0;
					positionid = ren.get(row).getPositionId();
					Position newp = new Position();
					newp = positionSearch.searchByPositionId(positionid);
					System.out.println(newp);
					
					new CandidateResumeTanGUI(newp);
					/*
			        while(iter.hasNext()){
			            Vector<Vector<Ren>> ren = (Vector<Vector<Ren>>) iter.next();
			            //System.out.println(ren);
			        }*/
			        
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
		this.add(commond, BorderLayout.EAST);
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
	public int getHang() {
		return hang;
	}
	public void setHang(int hang) {
		this.hang = hang;
	}
	/**
	 * 
	 * @param d ������Ϣ�������Ϣ��ϸ�ķֱ���
	 */
	public void setDetailPanelSize(Dimension d) {
		palDetail.setSize(d);
	}
	/**
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
		DefaultTableCellHeaderRenderer hr = new DefaultTableCellHeaderRenderer();
		hr.setHorizontalAlignment(JLabel.CENTER);
		table.getTableHeader().setDefaultRenderer(hr);//���ñ�ͷ���־���
		table.setRowHeight(30);//���ñ�ĸ߶�
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, r);//���ñ�����ݾ�����ʾ
		table.setSelectionBackground(new Color(0xd3d3d3));
		//table.enable(false);
	}
	
	public static void main(String[] args) {
		//new CompanyResumeGUI(1);
	}
}
/**
 * �¿���һ���������洢ӦƸ����Ϣ������Ϣ
 * @author hp
 * @Description
 * @data 2019��1��6��
 */
class Ren{
	private int positionId;             //ְλ��ID 
	private String positionName;	    //ְλ������
	private int companyId;              //��˾��ID
	private String companyName; 	    //��˾������
	private String companyAddress;  	//��˾�ĵ�ַ
	private String positionDiploma;     //н�ʺ�ְλ����
	private String luyong;			    //�Ƿ�¼��1
	
	public Ren() {
		
	}
	public String toString() {
		return String.format("%d,%s,%d,%s,%s,%s",positionId,positionName,companyId,companyName,companyAddress,luyong);
	}
	
	public String getPositionDiploma() {
		return positionDiploma;
	}
	public void setPositionDiploma(String positionDiploma) {
		this.positionDiploma = positionDiploma;
	}
	public int getPositionId() {
		return positionId;
	}

	public void setPositionId(int positionId) {
		this.positionId = positionId;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getLuyong() {
		return luyong;
	}

	public void setLuyong(String luyong) {
		this.luyong = luyong;
	} 
	
	
}

/**
 * �����������ҵ�����ְ�ţ�ͨ����ְ�ŵ�ְλIdȥ��ְλ����ͨ��ְλ�еĹ�˾��ID�����ҹ�˾��ID
 * @author hp
 * @Description
 * @data 2019��1��7��
 */

class Jihe{
	private int candidateId;            //����ID
	private int positionId;             //ְλ��ID 
	private String positionName;	    //ְλ������
	private int companyId;              //��˾��ID
	private String companyName; 	    //��˾������
	private String companyAddress;  	//��˾�ĵ�ַ
	private String luyong;			    //�Ƿ�¼��1
	private List<Resume> resumeList;	//��ְ��List�洢
	private List<Position> positionList;//ְλList�洢
	private List<Company> companyList;  //��˾��List�洢
	private Vector<Resume> resumeVector;//��ְ�ŵ�Vector�Ĵ洢
	private Vector<Position> positionVector;//ְλ��Vector�洢
	private Vector<Company> companyVector; //��˾��Vector
	
	private Vector<Ren> renOnce;         //1��Vector
	private Vector<Vector<Ren>> renTwice;  //2��Vector
	
	public Jihe(int candidateId,List<Position> positionList
			,List<Resume> resumeList,List<Company> companyList) {
		this.candidateId = candidateId;
		this.resumeList = resumeList;
		this.positionList = positionList;	
		this.companyList  = companyList;
		
		renOnce = new Vector<Ren>();
		for(int i = 0;i < resumeList.size();i++) { //�Ȳ�����ְ��
			if(resumeList.get(i).getCandidateId() == this.getCandidateId()) { //�ҵ����Լ�ID����ְ��
				//Vector<Ren> renNew = new Vector<Ren>();
				Ren ren = new Ren();
				ren.toString();
				ren.setPositionId(resumeList.get(i).getPositionId());
				if(resumeList.get(i).getIsInterview() == 1) {
					ren.setLuyong("¼�ã�����ϵ��˾��������");
				}else if(resumeList.get(i).getIsInterview() == 0) {
					ren.setLuyong("��δ¼��");
				}
				//System.out.println(ren);
				for(int j = 0;j < positionList.size();j++) {  //ͨ����ְ�ŵ�ְλID������ְλ
					if(positionList.get(j).getPositionId() == ren.getPositionId()) {
						ren.setCompanyId(positionList.get(j).getCompanyId());  //����˾ID���и�ֵ
						ren.setPositionName(positionList.get(j).getPositionName());
						ren.setPositionDiploma(positionList.get(j).getPositionDiploma());
						//System.out.println(ren);
						for(int z = 0;z < companyList.size();z++) {
							if(ren.getCompanyId() == companyList.get(z).getCompanyId()) {
								ren.setCompanyAddress(companyList.get(z).getCompanyAddress());
								ren.setCompanyName(companyList.get(z).getCompanyName());
								renOnce.add(ren);
								//System.out.println(ren);
							}
						}
					}
				}
			}
		}
		
	}

	public Vector<Ren> getRenOnce() {
		return renOnce;
	}

	public void setRenOnce(Vector<Ren> renOnce) {
		this.renOnce = renOnce;
	}

	public Iterator Iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	public int getPositionId() {
		return positionId;
	}

	public void setPositionId(int positionId) {
		this.positionId = positionId;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getLuyong() {
		return luyong;
	}

	public void setLuyong(String luyong) {
		this.luyong = luyong;
	}

	public List<Resume> getResumeList() {
		return resumeList;
	}

	public void setResumeList(List<Resume> resumeList) {
		this.resumeList = resumeList;
	}

	public List<Position> getPositionList() {
		return positionList;
	}

	public void setPositionList(List<Position> positionList) {
		this.positionList = positionList;
	}

	public List<Company> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<Company> companyList) {
		this.companyList = companyList;
	}

	public Vector<Resume> getResumeVector() {
		return resumeVector;
	}

	public void setResumeVector(Vector<Resume> resumeVector) {
		this.resumeVector = resumeVector;
	}

	public Vector<Position> getPositionVector() {
		return positionVector;
	}

	public void setPositionVector(Vector<Position> positionVector) {
		this.positionVector = positionVector;
	}

	public Vector<Company> getCompanyVector() {
		return companyVector;
	}

	public void setCompanyVector(Vector<Company> companyVector) {
		this.companyVector = companyVector;
	}

	public Vector<Vector<Ren>> getRenTwice() {
		return renTwice;
	}

	public void setRenTwice(Vector<Vector<Ren>> renTwice) {
		this.renTwice = renTwice;
	}
}

class MyTableModel extends DefaultTableModel{

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	public MyTableModel(Vector data,Vector columns) {
		super(data, columns);
	}
	
	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}
}

