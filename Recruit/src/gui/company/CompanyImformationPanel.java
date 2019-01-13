package gui.company;
/**@FileName:CompanyImformationPanel.java
 * @Description:
 * @Author:周天乐Sio
 * @Date:2019年1月7日
 */

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import bean.*;
import dao.*;
import service.*;

/**@Description:
 * @FileName:CompanyImformationPanel.java
 * @Author:周天乐Sio
 * @Date:2019年1月7日
 */
public class CompanyImformationPanel {

	private List<Position> position;
	private List<Resume> resume;
	private List<Company> company;
	private PositionService positionService;
	private ResumeService resumeService;
	private CompanyService companyService;
	public PositionAddInformation rPal;
	public JFrame me;
	public CompanyImformationPanel(int companyId) {
		me = new JFrame();
		try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} catch (UnsupportedLookAndFeelException e1) {			
			e1.printStackTrace();
		}
		positionService = new PositionServImpl(new PositionDaoImpl());
		companyService = new CompanyServiceImpl(new CompanyDaoImpl());
		List<String> lblItemNames=new ArrayList<String>();
		lblItemNames.add("公司ID：");
		lblItemNames.add("公司名：");
		lblItemNames.add("公司地址：");
		lblItemNames.add("公司类型");
		lblItemNames.add("公司法人代表");
		lblItemNames.add("公司邮箱");
		lblItemNames.add("公司电话");
		lblItemNames.add("公司注册资金");
		lblItemNames.add("公司登陆账号");
		List<String> talItemNames = new ArrayList<String>();
		//talItemNames.add("职位Id");
		
		List<JComponent> cptItems = new ArrayList<JComponent>();
		JTextField[] fields = new JTextField[9];
		List<JTextField> flds = new ArrayList<JTextField>();
		/**/for(int i = 0; i< fields.length;i++) {
			JTextField t =new JTextField(20);
			t.setMaximumSize(t.getPreferredSize());
			flds.add(t);
			cptItems.add(t);
		}
		company = companyService.searchAll();
		for(Company c:company) {
			if(c.getCompanyId()==companyId) {
				flds.get(0).setText(String.valueOf(companyId));
				flds.get(0).setEditable(false);
				flds.get(1).setText(c.getCompanyAccount());
				flds.get(1).setEditable(false);
				flds.get(2).setText(c.getCompanyName());
				flds.get(2).setEditable(false);
				flds.get(3).setText(c.getCompanyAddress());
				flds.get(4).setText(c.getCompanyType());
				flds.get(4).setEditable(false);
				flds.get(5).setText(c.getCompanyLegalPerson());
				flds.get(5).setEditable(false);
				flds.get(6).setText(c.getCompanyEmail());
				flds.get(7).setText(c.getCompanyPhone());
				flds.get(7).setEditable(false);
				flds.get(8).setText(c.getCompanyCaptial());
				flds.get(8).setEditable(false);
			}
		}
		position = positionService.searchAll();
		int max =0;
		for(Position p:position) {
			max = p.getPositionId();
		}
		/*flds.get(0).setText(String.valueOf(max));
		flds.get(0).setEditable(false);
		flds.get(2).setText(String.valueOf(companyId));
		flds.get(2).setEditable(false);*/
		JComboBox com = new JComboBox();
		com.addItem("");

		com.setMaximumSize(com.getPreferredSize());
		cptItems.add(com);
		List<JButton> btnCommond = new ArrayList<JButton>();
	
		btnCommond = new ArrayList<JButton>();
		JButton button1 = new JButton("退出系统");
		//JButton button2 = new JButton("取消发布");
		btnCommond.add(button1);
		//btnCommond.add(button2);
		
		//btnCommond.add(new JButton("按钮3"));
		//btnCommond.add(new JButton("按钮4"));		
		try {
			
			rPal = new PositionAddInformation(lblItemNames,talItemNames,cptItems,btnCommond,1);
			
			rPal.setSize(new Dimension(400,250));
			Vector<Vector<String>> d = new Vector<Vector<String>>();
			
			//rPal.freshTable(d);
			//pal.setSize(new Dimension(400,500));
			me.add(rPal);
		} catch (Exception e) {
			e.printStackTrace();
		}
		button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            	System.exit(0);
            }
        });
		
		//me.setBounds(100,200,400,500);;
		me.pack();
		me.setVisible(true);
		//me.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		me.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
}
