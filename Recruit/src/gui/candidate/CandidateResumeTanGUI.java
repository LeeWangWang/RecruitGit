package gui.candidate;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import bean.Position;
import gui.customStyle.ButtonFont;
import gui.customStyle.StyleArgument;
/**
 * @ClassName: CandidateResumeTanGUI.java
 * @Author: 穆正阳
 * @Data: 2019年1月9日上午8:32:02
 */
public class CandidateResumeTanGUI extends JFrame{
	
	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	private JLabel idJLabel;               //职位id
	private JLabel positionNameLabel;      //名字
	private JLabel CompanyIdJLabel;		   //公司id
	private JLabel positionIntroJLabel;	   //职位介绍
	private JLabel positionDiplomaJLabel;   //职位所需文凭
	private JLabel positionLigJLabel;	   //职位亮点
	private JTextField idJTextField;               //职位id
	private JTextField positionNameJTextField;      //名字
	private JTextField CompanyIdJTextField;		   //公司id
	private JTextField positionIntroJTextField;	   //职位介绍
	private JTextField positionDiplomaJTextField;   //职位所需文凭
	private JTextField positionLigJTextField;	   //职位亮点
	private JButton exit;                          //退出
	
	public CandidateResumeTanGUI(Position p) {
    	super("职位总信息");
    	try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} catch (UnsupportedLookAndFeelException e1) {			
			e1.printStackTrace();
		}
    	
    	this.init(p);
    	
    	this.setResizable(true);
		this.setSize(450,380);
        this.setLocation(500, 200);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);		
		this.setVisible(true);
    }
	public void init(Position p) {
		Font font = new Font(StyleArgument.FONTNAME,StyleArgument.FONTSTYLE,StyleArgument.FONTSIZE);
		Container c = this.getContentPane();
		c.setLayout(new BorderLayout(20,10));       //设置组件之间的间距
		//中间
		Box center = Box.createVerticalBox();      //创建一个垂直盒子
		
		Box first = Box.createHorizontalBox();     //创建一个水平盒子
		idJLabel = new JLabel("职位编号");
		idJLabel.setFont(font);
		idJTextField = new JTextField(p.getPositionId()+"");
		idJTextField.setEditable(false);
		first.add(idJLabel);
		first.add(Box.createRigidArea(new Dimension(23, 30)));
		first.add(idJTextField);
		//first.add(Box.createRigidArea(new Dimension(280, 30))); //添加一个看不见的组件Glue
		
		Box second = Box.createHorizontalBox();    //创建一个水平盒子
		positionNameLabel = new JLabel("职位名称");
		positionNameLabel.setFont(font);
		positionNameJTextField = new JTextField(p.getPositionName());
		positionNameJTextField.setEditable(false);
		second.add(positionNameLabel);
		second.add(Box.createRigidArea(new Dimension(23, 30)));
		second.add(positionNameJTextField);
		
		
		Box third = Box.createHorizontalBox();    //创建一个水平盒子
		CompanyIdJLabel = new JLabel("公司编号");
		CompanyIdJLabel.setFont(font);
		CompanyIdJTextField = new JTextField(p.getCompanyId()+"");
		CompanyIdJTextField.setEditable(false);
		third.add(CompanyIdJLabel);
		third.add(Box.createRigidArea(new Dimension(23, 30)));
		third.add(CompanyIdJTextField);
		
		Box fourth = Box.createHorizontalBox();    //创建一个水平盒子
		positionIntroJLabel = new JLabel("职位介绍");
		positionIntroJLabel.setFont(font);
		positionIntroJTextField = new JTextField(p.getPositionIntroduction());
		positionIntroJTextField.setEditable(false);
		fourth.add(positionIntroJLabel);
		fourth.add(Box.createRigidArea(new Dimension(23, 30)));
		fourth.add(positionIntroJTextField);
		
		Box fifth = Box.createHorizontalBox();    //创建一个水平盒子
		positionDiplomaJLabel = new JLabel("所需文凭");
		positionDiplomaJLabel.setFont(font);
		positionDiplomaJTextField = new JTextField(p.getPositionDiploma());
		positionDiplomaJTextField.setEditable(false);
		fifth.add(positionDiplomaJLabel);
		fifth.add(Box.createRigidArea(new Dimension(23, 30)));
		fifth.add(positionDiplomaJTextField);
		
		Box sixth = Box.createHorizontalBox();    //创建一个水平盒子
		positionLigJLabel = new JLabel("职位要求");
		positionLigJLabel.setFont(font);
		positionLigJTextField = new JTextField(p.getPositionLightspot());
		positionLigJTextField.setEditable(false);
		sixth.add(positionLigJLabel);
		sixth.add(Box.createRigidArea(new Dimension(23, 30)));
		sixth.add(positionLigJTextField);
		
		center.add(first);
		center.add(second);
		center.add(third);
		center.add(fourth);
		center.add(fifth);
		center.add(sixth);
		//左边
		JPanel west = new JPanel();
		//下面
		exit = new ButtonFont("退出",font);
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				windowClosing();
				
			}
			
		});
		
		Box south = Box.createHorizontalBox();//水平盒子
		south.add(Box.createRigidArea(new Dimension(340,0)));
		south.add(exit);
		//右边
		JPanel east = new JPanel();
		
		c.add(east,BorderLayout.EAST);
		c.add(south,BorderLayout.SOUTH);
		c.add(west,BorderLayout.WEST);
		c.add(center,BorderLayout.CENTER);
	}
	public void windowClosing() {
		this.setVisible(false);
		dispose();
	}
	public static void main(String[] args) {
		//new CandidateResumeTanGUI();
	}
}
