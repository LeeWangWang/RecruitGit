/**@FileName:CompanyMainGUI.java
 * @Description:
 * @Author:周天乐Sio
 * @Date:2019年1月8日
 */
package gui.company;

import java.awt.Color;
import java.awt.Container;
import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
/**@Description:
 * @FileName:CompanyMainGUI.java
 * @Author:周天乐Sio
 * @Date:2019年1月8日
 */
public class CompanyMainGUI extends JFrame{
	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	private JTabbedPane tabbedPane; //面板
	private CompanyImformationPanel panel1;
	private CompanyPositionAllPanel panel2;
	private AllResume panel3;
	
	public CompanyMainGUI(int companyId) {
		super("应聘者界面");
		try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} catch (UnsupportedLookAndFeelException e1) {			
			e1.printStackTrace();
		}
		this.readDatabase();
    	this.init(companyId);
    	this.jianting();
    	this.setResizable(true);
		this.setSize(450,450);
        this.setLocation(100, 200);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);		//关闭该界面不会使父界面也关闭
		this.setVisible(true);
	}
	
	public void init(int companyId) {
		Container c = getContentPane();  
		tabbedPane = new JTabbedPane();   //选项卡
		
		panel1 = new CompanyImformationPanel(companyId);
		panel2 = new CompanyPositionAllPanel(companyId);
		panel3 = new AllResume(companyId);
		
		tabbedPane.addTab("个人首页",null,panel1.rPal,"First panel"); 
		tabbedPane.addTab("应聘职位",null,panel2.rPal,"Second panel");  
		tabbedPane.addTab("消息界面",null,panel3.rPal,"Third panel");  
		panel1.me.dispose();
		panel2.me.dispose();
		panel3.me.dispose();
		c.add(tabbedPane);
		c.setBackground(Color.white);  
		
	}
	
	public void jianting() {}
	
	public void readDatabase() {}

}

