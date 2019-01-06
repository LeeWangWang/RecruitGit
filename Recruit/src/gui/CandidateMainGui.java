package gui;

import java.awt.Container;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import bean.Candidate;

/**@ClassName: MainGui.java
 * @Description: ��Ŀ���
 * @Data: 2019��1��5������9:39:53
 */
public class CandidateMainGui extends JFrame {
	
	public CandidateMainGui() throws Exception {
		Container container = this.getContentPane();
		JTabbedPane top = new JTabbedPane();
		
		Candidate user1 = new Candidate("������", "��", 20, "15587379525", "341223199711101939",
                "2458581040@qq.com", "����", "�������", "����", "��������", "��������");
		try {
			CandidateGui1 pal1 = new CandidateGui1(user1);
			CandidateGui2 pal2 = new CandidateGui2(user1);
			Vector<Vector<String>> d = new Vector<Vector<String>>();
			for(int i= 0; i < 4; i++){
				Vector<String> di = new Vector<String>();
				for(int j = 0; j <6; j++)
					di.add("data"+i+j+"");
				d.add(di);
			}
			pal1.freshTable(d);
			pal2.freshTable(d);
			top.add("�ҹ���",pal1);
			top.add("���˼���",pal2);
			//top.setSize(new Dimension(400,300));
			this.add(top);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.setBounds(100,200,700,400);
		//me.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	
	public static void main(String[] args) throws Exception {
		new CandidateMainGui();
	}
	
}
