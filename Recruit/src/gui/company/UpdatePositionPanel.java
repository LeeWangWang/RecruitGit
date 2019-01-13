/**@FileName:UpdatePositionPanel.java
 * @Description:
 * @Author:周天乐Sio
 * @Date:2019年1月6日
 */
package gui.company;

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

import bean.*;
import dao.*;
import service.*;
import gui.*;
import gui.candidate.*;

/**@Description:
 * @FileName:UpdatePositionPanel.java
 * @Author:周天乐Sio
 * @Date:2019年1月6日
 */
public class UpdatePositionPanel {

	private Position posi;
	private List<Position> position;
	private PositionService positionService;
	public UpdatePositionPanel(int positionId,int companyId) {
		JFrame me = new JFrame();
		positionService = new PositionServImpl(new PositionDaoImpl());
		List<String> lblItemNames=new ArrayList<String>();
		lblItemNames.add("职位ID");
		lblItemNames.add("职位名称");
		lblItemNames.add("公司ID");
		lblItemNames.add("职位介绍");
		lblItemNames.add("学历需求");
		lblItemNames.add("其他需求");
		List<String> talItemNames = new ArrayList<String>();
		
		List<JComponent> cptItems = new ArrayList<JComponent>();
		JTextField[] fields = new JTextField[6];
		List<JTextField> flds = new ArrayList<JTextField>();
		/**/for(int i = 0; i< fields.length;i++) {
			JTextField t =new JTextField(20);
			t.setMaximumSize(t.getPreferredSize());
			flds.add(t);
			cptItems.add(t);
		}	
		posi = positionService.searchByPositionId(positionId);
		flds.get(0).setText(String.valueOf(positionId));
		flds.get(0).setEditable(false);
		flds.get(1).setText(posi.getPositionName());
		flds.get(2).setText(String.valueOf(companyId));
		flds.get(2).setEditable(false);
		flds.get(3).setText(posi.getPositionIntroduction());
		flds.get(4).setText(posi.getPositionDiploma());
		flds.get(5).setText(posi.getPositionLightspot());
		JComboBox com = new JComboBox();
		com.addItem("");

		com.setMaximumSize(com.getPreferredSize());
		cptItems.add(com);
		List<JButton> btnCommond = new ArrayList<JButton>();
	
		btnCommond = new ArrayList<JButton>();
		JButton button1 = new JButton("确定修改招聘职位");
		JButton button2 = new JButton("取消修改");
		btnCommond.add(button1);
		btnCommond.add(button2);

		
		//btnCommond.add(new JButton("按钮3"));
		//btnCommond.add(new JButton("按钮4"));		
		try {
			
			PositionAddInformation pPal = new PositionAddInformation(lblItemNames,talItemNames,cptItems,btnCommond,1);
			
			pPal.setSize(new Dimension(400,250));
			Vector<Vector<String>> d = new Vector<Vector<String>>();
			
			//rPal.freshTable(d);
			//pal.setSize(new Dimension(400,500));
			me.add(pPal);
		} catch (Exception e) {
			e.printStackTrace();
		}
		button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            	positionService.updatePosition(new Position(positionId,flds.get(1).getText(),companyId,flds.get(3).getText(),flds.get(4).getText(),flds.get(5).getText()));
            	me.dispose();
            }
        });
		button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	me.dispose();
            }
        });

		//me.setBounds(100,200,400,500);;
		me.pack();
		me.setVisible(true);
		//me.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		me.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

}
