package gui.customStyle;

import java.awt.Font;
import javax.swing.JButton;

public class ButtonFont extends JButton{
	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	public ButtonFont(String text,Font f) {
		super(text);
		this.setFont(f);
	}
}

