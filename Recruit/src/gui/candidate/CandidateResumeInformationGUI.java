package gui.candidate;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import gui.customStyle.StyleArgument;

/**
 *   �ý���������ӦƸ�߽���չʾ�Լ���ӦƸ��Ϣ�Ĵ������
 * @author ������
 * @Description
 * @data 2019��1��5��
 */
public class CandidateResumeInformationGUI extends JPanel{
	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	private Vector<String> tableColNames;	
	private List<JLabel> lblItemNames;
	public CandidateResumeInformationGUI(){
		
		try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} catch (UnsupportedLookAndFeelException e1) {			
			e1.printStackTrace();
		}
		
		
		this.readDatabase();
    	this.init();
    	this.jianting();
    	
		this.setSize(450,450);
        this.setLocation(100, 200);
		this.setVisible(true);
	}
	
	public void init() {
		Font font = new Font(StyleArgument.FONTNAME,StyleArgument.FONTSTYLE,StyleArgument.FONTSIZE);
		List<String> nameList = new ArrayList<String>();//������ʾ��ʾ���ݵ�����
		nameList.add("ְλID");
		nameList.add("ְλ");
		nameList.add("��˾����");
		nameList.add("��˾��ַ");
		nameList.add("��˾����");
		nameList.add("�Ƿ�¼��");
		tableColNames = new Vector<String>(nameList);
		lblItemNames = new ArrayList<JLabel>();
		for(int i = 0; i < nameList.size(); i++)
			lblItemNames.add(new JLabel(nameList.get(i)));
		for(JLabel b : lblItemNames) {
			b.setFont(font);
		}
	}
	
	public void jianting() {
		
	}
	
	public void readDatabase() {
		
	}
	public static void main(String[] args) {
		new CandidateResumeInformationGUI();
	}
}
