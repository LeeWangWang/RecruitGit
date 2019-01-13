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
 * @Author: ������
 * @Data: 2019��1��9������8:32:02
 */
public class CandidateResumeTanGUI extends JFrame{
	
	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	private JLabel idJLabel;               //ְλid
	private JLabel positionNameLabel;      //����
	private JLabel CompanyIdJLabel;		   //��˾id
	private JLabel positionIntroJLabel;	   //ְλ����
	private JLabel positionDiplomaJLabel;   //ְλ������ƾ
	private JLabel positionLigJLabel;	   //ְλ����
	private JTextField idJTextField;               //ְλid
	private JTextField positionNameJTextField;      //����
	private JTextField CompanyIdJTextField;		   //��˾id
	private JTextField positionIntroJTextField;	   //ְλ����
	private JTextField positionDiplomaJTextField;   //ְλ������ƾ
	private JTextField positionLigJTextField;	   //ְλ����
	private JButton exit;                          //�˳�
	
	public CandidateResumeTanGUI(Position p) {
    	super("ְλ����Ϣ");
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
		c.setLayout(new BorderLayout(20,10));       //�������֮��ļ��
		//�м�
		Box center = Box.createVerticalBox();      //����һ����ֱ����
		
		Box first = Box.createHorizontalBox();     //����һ��ˮƽ����
		idJLabel = new JLabel("ְλ���");
		idJLabel.setFont(font);
		idJTextField = new JTextField(p.getPositionId()+"");
		idJTextField.setEditable(false);
		first.add(idJLabel);
		first.add(Box.createRigidArea(new Dimension(23, 30)));
		first.add(idJTextField);
		//first.add(Box.createRigidArea(new Dimension(280, 30))); //���һ�������������Glue
		
		Box second = Box.createHorizontalBox();    //����һ��ˮƽ����
		positionNameLabel = new JLabel("ְλ����");
		positionNameLabel.setFont(font);
		positionNameJTextField = new JTextField(p.getPositionName());
		positionNameJTextField.setEditable(false);
		second.add(positionNameLabel);
		second.add(Box.createRigidArea(new Dimension(23, 30)));
		second.add(positionNameJTextField);
		
		
		Box third = Box.createHorizontalBox();    //����һ��ˮƽ����
		CompanyIdJLabel = new JLabel("��˾���");
		CompanyIdJLabel.setFont(font);
		CompanyIdJTextField = new JTextField(p.getCompanyId()+"");
		CompanyIdJTextField.setEditable(false);
		third.add(CompanyIdJLabel);
		third.add(Box.createRigidArea(new Dimension(23, 30)));
		third.add(CompanyIdJTextField);
		
		Box fourth = Box.createHorizontalBox();    //����һ��ˮƽ����
		positionIntroJLabel = new JLabel("ְλ����");
		positionIntroJLabel.setFont(font);
		positionIntroJTextField = new JTextField(p.getPositionIntroduction());
		positionIntroJTextField.setEditable(false);
		fourth.add(positionIntroJLabel);
		fourth.add(Box.createRigidArea(new Dimension(23, 30)));
		fourth.add(positionIntroJTextField);
		
		Box fifth = Box.createHorizontalBox();    //����һ��ˮƽ����
		positionDiplomaJLabel = new JLabel("������ƾ");
		positionDiplomaJLabel.setFont(font);
		positionDiplomaJTextField = new JTextField(p.getPositionDiploma());
		positionDiplomaJTextField.setEditable(false);
		fifth.add(positionDiplomaJLabel);
		fifth.add(Box.createRigidArea(new Dimension(23, 30)));
		fifth.add(positionDiplomaJTextField);
		
		Box sixth = Box.createHorizontalBox();    //����һ��ˮƽ����
		positionLigJLabel = new JLabel("ְλҪ��");
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
		//���
		JPanel west = new JPanel();
		//����
		exit = new ButtonFont("�˳�",font);
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				windowClosing();
				
			}
			
		});
		
		Box south = Box.createHorizontalBox();//ˮƽ����
		south.add(Box.createRigidArea(new Dimension(340,0)));
		south.add(exit);
		//�ұ�
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
