/**@FileName:CompanyMainGUI.java
 * @Description:
 * @Author:������Sio
 * @Date:2019��1��8��
 */
package gui.company;

import java.awt.Color;
import java.awt.Container;
import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
/**@Description:
 * @FileName:CompanyMainGUI.java
 * @Author:������Sio
 * @Date:2019��1��8��
 */
public class CompanyMainGUI extends JFrame{
	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	private JTabbedPane tabbedPane; //���
	private CompanyImformationPanel panel1;
	private CompanyPositionAllPanel panel2;
	private AllResume panel3;
	
	public CompanyMainGUI(int companyId) {
		super("ӦƸ�߽���");
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
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);		//�رոý��治��ʹ������Ҳ�ر�
		this.setVisible(true);
	}
	
	public void init(int companyId) {
		Container c = getContentPane();  
		tabbedPane = new JTabbedPane();   //ѡ�
		
		panel1 = new CompanyImformationPanel(companyId);
		panel2 = new CompanyPositionAllPanel(companyId);
		panel3 = new AllResume(companyId);
		
		tabbedPane.addTab("������ҳ",null,panel1.rPal,"First panel"); 
		tabbedPane.addTab("ӦƸְλ",null,panel2.rPal,"Second panel");  
		tabbedPane.addTab("��Ϣ����",null,panel3.rPal,"Third panel");  
		panel1.me.dispose();
		panel2.me.dispose();
		panel3.me.dispose();
		c.add(tabbedPane);
		c.setBackground(Color.white);  
		
	}
	
	public void jianting() {}
	
	public void readDatabase() {}

}

