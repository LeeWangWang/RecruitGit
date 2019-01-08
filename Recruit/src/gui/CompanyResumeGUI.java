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
/**
 * 新开辟一个类用来存储应聘者消息栏的信息
 * @author hp
 * @Description
 * @data 2019年1月6日
 */
class Ren{
	private int positionId;             //职位的ID 
	private String positionName;	    //职位的名字
	private int companyId;              //公司的ID
	private String companyName; 	    //公司的名字
	private String companyAddress;  	//公司的地址
	private String positionDiploma;     //薪资和职位亮点
	private String luyong;			    //是否录用1
	
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
 * 在这里面先找的是求职信，通过求职信的职位Id去找职位，在通过职位中的公司的ID来查找公司的ID
 * @author hp
 * @Description
 * @data 2019年1月7日
 */

class Jihe{
	private int candidateId;            //个人ID
	private int positionId;             //职位的ID 
	private String positionName;	    //职位的名字
	private int companyId;              //公司的ID
	private String companyName; 	    //公司的名字
	private String companyAddress;  	//公司的地址
	private String luyong;			    //是否录用1
	private List<Resume> resumeList;	//求职信List存储
	private List<Position> positionList;//职位List存储
	private List<Company> companyList;  //公司的List存储
	private Vector<Resume> resumeVector;//求职信的Vector的存储
	private Vector<Position> positionVector;//职位的Vector存储
	private Vector<Company> companyVector; //公司的Vector
	
	private Vector<Ren> renOnce;         //1层Vector
	private Vector<Vector<Ren>> renTwice;  //2层Vector
	
	public Jihe(int candidateId,List<Position> positionList
			,List<Resume> resumeList,List<Company> companyList) {
		this.candidateId = candidateId;
		this.resumeList = resumeList;
		this.positionList = positionList;	
		this.companyList  = companyList;
		
		renOnce = new Vector<Ren>();
		for(int i = 0;i < resumeList.size();i++) { //先查找求职信
			if(resumeList.get(i).getCandidateId() == this.getCandidateId()) { //找到有自己ID的求职信
				//Vector<Ren> renNew = new Vector<Ren>();
				Ren ren = new Ren();
				ren.toString();
				ren.setPositionId(resumeList.get(i).getPositionId());
				if(resumeList.get(i).getIsInterview() == 1) {
					ren.setLuyong("录用，请联系公司进行面试");
				}else if(resumeList.get(i).getIsInterview() == 0) {
					ren.setLuyong("还未录用");
				}
				//System.out.println(ren);
				for(int j = 0;j < positionList.size();j++) {  //通过求职信的职位ID来查找职位
					if(positionList.get(j).getPositionId() == ren.getPositionId()) {
						ren.setCompanyId(positionList.get(j).getCompanyId());  //给公司ID进行赋值
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

