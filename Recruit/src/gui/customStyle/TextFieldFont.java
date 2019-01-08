package gui.customStyle;

import java.awt.Font;
import javax.swing.JTextField;

public class TextFieldFont extends JTextField{
	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	public TextFieldFont(int columns,Font f) {
		super(columns);
		this.setFont(f);
	}
	public TextFieldFont(String text,Font f) {
		super(text);
		this.setFont(f);
	}
	public TextFieldFont(int column, String text,Font f) {
		super(text,column);
		this.setFont(f);
	}
}
