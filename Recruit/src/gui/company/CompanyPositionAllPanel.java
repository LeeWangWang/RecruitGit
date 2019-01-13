/**@FileName:CompanyPositionAllPanel.java
 * @Description:
 * @Author:周天乐Sio
 * @Date:2019年1月4日
 */
package gui.company;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.table.DefaultTableCellRenderer;
import bean.*;
import dao.*;
import service.*;

/**@Description:
 * @FileName:CompanyPositionAllPanel.java
 * @Author:周天乐Sio
 * @Date:2019年1月4日
 */
public class CompanyPositionAllPanel implements ActionListener{

	private List<Position> position1,position2,position3,position4;
	private List<Company> companys;
	private Company company;
	private List<Resume> resume;
	private PositionService positionService;
	private ResumeService resumeService;
	private CompanyService companyService;
	public PositionInformationPanel rPal;
	public JFrame me;
	public CompanyPositionAllPanel(int companyId) {

		try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} catch (UnsupportedLookAndFeelException e1) {			
			e1.printStackTrace();
		}
		
		me = new JFrame();
		positionService = new PositionServImpl(new PositionDaoImpl());
		resumeService = new ResumeServImpl(new ResumeDaoImpl());
		companyService = new CompanyServiceImpl(new CompanyDaoImpl());
		companys = companyService.searchAll();
		for(Company c:companys) {
			if(c.getCompanyId()==companyId) {
				company = c;
			}
		}
		List<String> lblItemNames=new ArrayList<String>();
		lblItemNames.add("适用说明:");
		lblItemNames.add("<刷新>：刷新职位表格");
		lblItemNames.add("<增加招聘职位>：增加招聘职位");
		lblItemNames.add("<搜索职位投递简历>：在输入框内输入要查找的职位的ID");
		lblItemNames.add("<搜索职位投递简历>：在输入框内输入关键字查找职位");
		lblItemNames.add("<删除>：在输入框内输入要删除的职位的ID");
		lblItemNames.add("单机表格内的职位可查看职位的详细信息");
		
		List<String> talItemNames = new ArrayList<String>();
		talItemNames.add("职位Id");
		talItemNames.add("职位名称");
		talItemNames.add("公司ID");
		talItemNames.add("职位介绍");
		talItemNames.add("需要文凭");
		talItemNames.add("职位需要的能力");
		
		List<JComponent> cptItems = new ArrayList<JComponent>();
		//JTextField fields = new JTextField();
		
		
		List<JTextField> ts = new ArrayList<JTextField>();
		for(int i=0;i<5;i++) {
			JTextField ttemp = new JTextField(0);
			ttemp.setMaximumSize(ttemp.getPreferredSize());
			ts.add(ttemp);
		}
		//ts.get(0).setText("<刷新>：刷新职位表格");
		//ts.get(1).setText("<增加招聘职位>：增加招聘职位");
		//ts.get(2).setText("<搜索职位投递简历>：在输入框内输入要查找的职位的ID");
		//ts.get(3).setText("<删除>：在输入框内输入要删除的职位的ID");
		//ts.get(4).setText("单机表格内的职位可查看职位的详细信息");
		for(int i=0;i<5;i++) {
			cptItems.add(ts.get(i));
			ts.get(i).setFont(new Font("宋体",Font.PLAIN,16));
			ts.get(i).setVisible(false);
			ts.get(i).setEditable(false);
		}
		JTextField t2 =new JTextField(40);
		t2.setFont(new Font("宋体",Font.PLAIN,20));
		t2.setMaximumSize(t2.getPreferredSize());
		cptItems.add(t2);
		t2.setText("<请输入招聘职位ID号...>");
		
		JTextField t =new JTextField(40);
		t.setFont(new Font("宋体",Font.PLAIN,20));
		t.setMaximumSize(t.getPreferredSize());
		cptItems.add(t);
		t.setText("<请输入职位相关信息>");
	
		JComboBox com = new JComboBox();
		com.addItem("");

		com.setMaximumSize(com.getPreferredSize());
		cptItems.add(com);
		List<JButton> btnCommond = new ArrayList<JButton>();
	
		/**
		 * 找到这个职位
		 */

		position1 = positionService.searchByCompanyId(companyId);
		btnCommond = new ArrayList<JButton>();
		JButton button = new JButton("刷新");
		JButton button1 = new JButton("增添招聘职位");
		JButton button2 = new JButton("搜索职位投递简历");
		JButton button3 = new JButton("删除选中职位");
		JButton button4 = new JButton("搜索相关职位");
		btnCommond.add(button);
		btnCommond.add(button1);
		btnCommond.add(button2);
		btnCommond.add(button3);
		btnCommond.add(button4);
		
		button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AddPositionPanel(companyId);
  
		        }
			});
		
		button2.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		                new CompanyPositionPanel(Integer.valueOf(t2.getText().toString()),t);
		            }
		        });

		
		try {
			rPal = new PositionInformationPanel(lblItemNames,talItemNames,cptItems,btnCommond,1);
				
			rPal.setSize(new Dimension(400,250));
			Vector<Vector<String>> d = new Vector<Vector<String>>();
			int i=0;
				for(Position p:position1) {
				Vector<String> di = new Vector<String>();
				String sp = String.valueOf(p.getPositionId());
				di.add(sp);
				di.add(p.getPositionName());
				sp = String.valueOf(p.getCompanyId());
				di.add(sp);
				di.add(p.getPositionIntroduction());
				di.add(p.getPositionDiploma());
				di.add(p.getPositionLightspot());
				d.add(di);
				i++;
			}

		button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	int i=0;
            	resume = resumeService.searchByPositionId(Integer.valueOf(t.getText().toString()));
            	for(Resume r:resume)
            		i++;
            	if(i==0) {
            		
            		positionService.deletePosition(Integer.valueOf(t.getText().toString()));
            		
            	}else {
            		t.setText("  <请先处理完该职位的申请!>  ");
            	}
		                
                position1 = positionService.searchByCompanyId(companyId);
		                
    			Vector<Vector<String>> d = new Vector<Vector<String>>();
    			i=0;
    			for(Position p:position1) {
    				Vector<String> di = new Vector<String>();
    				String sp = String.valueOf(p.getPositionId());
    				di.add(sp);
    				di.add(p.getPositionName());
    				sp = String.valueOf(p.getCompanyId());
    				di.add(sp);
    				di.add(p.getPositionIntroduction());
    				di.add(p.getPositionDiploma());
    				di.add(p.getPositionLightspot());
    				d.add(di);
    				i++;
    			}
    			rPal.freshTable(d);
                
            }
        });	
		button.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	                position1 = positionService.searchByCompanyId(companyId);
	    			Vector<Vector<String>> d = new Vector<Vector<String>>();
	    			int i=0;
	    			for(Position p:position1) {
	    				Vector<String> di = new Vector<String>();
	    				String sp = String.valueOf(p.getPositionId());
	    				di.add(sp);
	    				di.add(p.getPositionName());
	    				sp = String.valueOf(p.getCompanyId());
	    				di.add(sp);
	    				di.add(p.getPositionIntroduction());
	    				di.add(p.getPositionDiploma());
	    				di.add(p.getPositionLightspot());
	    				d.add(di);
	    				i++;
	    			}
    			rPal.freshTable(d);
	         }
	    });
		button4.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	                position1 = positionService.searchByPositionName(companyId,t.getText().toString());
	                position2 = positionService.searchByPositionIntroduciton(companyId,t.getText().toString());
	                position3 = positionService.searchByPositionDiploma(companyId, t.getText().toString());
	                position4 = positionService.searchByPositionLightspot(companyId, t.getText().toString());
	                position1.addAll(position2);
	                position1.addAll(position3);
	                position1.addAll(position4);
	                for  ( int  i  =   0 ; i  <  position1.size()  -   1 ; i ++ )  {       
	                    for  ( int  j  =  position1.size()  -   1 ; j  >  i; j -- )  {       
	                         if  (position1.get(j).getPositionId() == position1.get(i).getPositionId())  {       
	                            position1.remove(j);       
	                          }        
	                     }        
	                } 
	    			Vector<Vector<String>> d = new Vector<Vector<String>>();
	    			int i=0;
	    			for(Position p:position1) {
	    				Vector<String> di = new Vector<String>();
	    				String sp = String.valueOf(p.getPositionId());
	    				di.add(sp);
	    				di.add(p.getPositionName());
	    				sp = String.valueOf(p.getCompanyId());
	    				di.add(sp);
	    				di.add(p.getPositionIntroduction());
	    				di.add(p.getPositionDiploma());
	    				di.add(p.getPositionLightspot());
	    				d.add(di);
	    				i++;
	    			}
 			rPal.freshTable(d);
	         }
	    });
			rPal.freshTable(d);
			//pal.setSize(new Dimension(400,500));
			me.add(rPal);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//me.setBounds(100,200,400,500);;
		me.pack();
		me.setVisible(true);
		me.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
