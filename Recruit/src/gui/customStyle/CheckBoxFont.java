package gui.customStyle;

import java.awt.Font;
import javax.swing.JCheckBox;

public class CheckBoxFont extends JCheckBox{
	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	public CheckBoxFont(String text,Font f) {
		super(text);//°´Å¥Ãû×Ö
		this.setFont(f);
	}
	public CheckBoxFont(String text,boolean selected,Font f) {
		super(text,selected);
		this.setFont(f);
	}
}
