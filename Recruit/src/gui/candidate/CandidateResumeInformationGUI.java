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
 *   该界面用来给应聘者进行展示自己的应聘信息的处理情况
 * @author 穆正阳
 * @Description
 * @data 2019年1月5日
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
		List<String> nameList = new ArrayList<String>();//用来显示显示数据的属性
		nameList.add("职位ID");
		nameList.add("职位");
		nameList.add("公司名称");
		nameList.add("公司地址");
		nameList.add("公司类型");
		nameList.add("是否被录用");
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
