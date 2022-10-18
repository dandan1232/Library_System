package Table;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class BackgroundPanel extends JPanel {

/*
 * ������������ࣨ��̫���ô���������������
 */
	
		public Image image;
		
		public BackgroundPanel() {
			super();
			setOpaque(false);
			setLayout(null);
		}
		
		public void setImage(Image image) {
			this.image = image;
		}
		@Override
		public void paintComponent(Graphics g) {
			g.drawImage(image, 0, 0, image.getWidth(this), image.getHeight(this), this);
			super.paintComponent(g);
		}
}
