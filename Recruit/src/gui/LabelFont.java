/**@FileName: LabelFont.java
 * @Description: 
 * @Paclage: gui
 * @Author: 李旺旺
 * @Data: 2018年12月31日下午4:37:39
 */
package gui;

import java.awt.Font;
import javax.swing.JLabel;

/**@ClassName: LabelFont.java
 * @Description: 
 * @Extends: 
 * @Implements: 
 * @Author: 李旺旺
 * @Data: 2018年12月31日下午4:37:39
 */
public class LabelFont extends JLabel {
	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	public LabelFont(String text, Font f) {
		super(text);
		this.setFont(f);
	}
	public LabelFont(int text, Font f) {
		super(String.valueOf(text));
		this.setFont(f);
	}
}
