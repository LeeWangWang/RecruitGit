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
import gui.candidate.CandidateResumeTanGUI;
import gui.candidate.Jihe;
import gui.candidate.MyTableModel;
import gui.candidate.Ren;
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
	private List<JLabel> lblItemNames;        //展示信息的种类数据
	private List<JComponent> cptItems;
	private JPanel palDetail;
	private JTable tblInfo;
	private DefaultTableModel model;
	private Vector<String> tableColNames;	
	private JPopupMenu popUpMenu;
	public int randidateId;
	private ButtonFont exit;               //退出
	private ButtonFont readPosition;	   //读取职位信息
	private ButtonFont readCompany;        //读取公司信息
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
		//将分栏的信息进行存储
		tableColNames = new Vector<String>(itemNames);
		lblItemNames = new ArrayList<JLabel>();
		for(int i = 0; i < itemNames.size(); i++)
		lblItemNames.add(new JLabel(itemNames.get(i)));
		cptItems = items;		
		palDetail = new JPanel(new BorderLayout());
		
		exit = new ButtonFont("刷新", f); //退出按键
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		readPosition = new ButtonFont("读取该职位信息",f);
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
				companyList = companyService.searchAll();//这里面存放的是所有的公司的信息
				positList = positionSearch.searchAll(); //这里面存放的是所有的职位的信息
				resumeList = resumeService.searchAll(); //这里面存放的是所有投出简历的信息
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
		readCompany = new ButtonFont("读取公司信息",f);
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
				companyList = companyService.searchAll();//这里面存放的是所有的公司的信息
				positList = positionSearch.searchAll(); //这里面存放的是所有的职位的信息
				resumeList = resumeService.searchAll(); //这里面存放的是所有投出简历的信息
				List<Position> zhanshi = new ArrayList<Position>();
			}
			
		});
		//放置按钮的垂直盒子用来放置按键
		Box commond = Box.createVerticalBox();//垂直盒子  
		commond.add(readPosition);
		commond.add(readCompany);
		commond.add(Box.createRigidArea(new Dimension(47, 30)));
		commond.add(exit);
		
		JPanel topCenter =  new JPanel();		
		GroupLayout layout = new GroupLayout(topCenter);
		topCenter.setLayout(layout);
		layout.setAutoCreateContainerGaps(true);// 自动创建容器与触到容器之间的间隙
		layout.setAutoCreateGaps(true);			// 自动创建组件之间的间隙
		//这是上面的JTextField的程序水平的
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
		//这是上面的换行功能，垂直的
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
		tblInfo = new JTable(model); //表格类
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
			        //查看职位信息
			      //对数据库中的数据进行读取 存放到List中
					PositionDao position = new PositionDaoImpl();
					PositionService positionSearch = new PositionServImpl(position);
					ResumeDao  resume = new ResumeDaoImpl();
					ResumeService resumeService = new ResumeServImpl(resume);
					CompanyDao companydao = new CompanyDaoImpl();
					CompanyService companyService = new CompanyServiceImpl(companydao);
					
					List<Company> companyList = new ArrayList<Company>();
					List<Position> positList = new ArrayList<Position>();
					List<Resume> resumeList = new ArrayList<Resume>(); 
					companyList = companyService.searchAll();//这里面存放的是所有的公司的信息
					positList = positionSearch.searchAll(); //这里面存放的是所有的职位的信息
					resumeList = resumeService.searchAll(); //这里面存放的是所有投出简历的信息
					List<Position> zhanshi = new ArrayList<Position>();
					
					Jihe jihe = new Jihe(randidateId,positList,resumeList,companyList);//传的是个人的ID
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
	public int getHang() {
		return hang;
	}
	public void setHang(int hang) {
		this.hang = hang;
	}
	/**
	 * 
	 * @param d 定义信息面板中信息明细的分辨率
	 */
	public void setDetailPanelSize(Dimension d) {
		palDetail.setSize(d);
	}
	/**
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
		DefaultTableCellHeaderRenderer hr = new DefaultTableCellHeaderRenderer();
		hr.setHorizontalAlignment(JLabel.CENTER);
		table.getTableHeader().setDefaultRenderer(hr);//设置表头文字居中
		table.setRowHeight(30);//设置表的高度
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, r);//设置表格内容居中显示
		table.setSelectionBackground(new Color(0xd3d3d3));
		//table.enable(false);
	}
	
	public static void main(String[] args) {
		//new CompanyResumeGUI(1);
	}
}



