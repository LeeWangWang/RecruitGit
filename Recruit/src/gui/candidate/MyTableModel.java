/**@FileName: MyTableModel.java
 * @Description: 
 * @Paclage: gui.candidate
 * @Author: 李旺旺
 * @Data: 2019年1月8日下午9:09:58
 */
package gui.candidate;

import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class MyTableModel extends DefaultTableModel{

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	public MyTableModel(Vector data,Vector columns) {
		super(data, columns);
	}
	
	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}
}
