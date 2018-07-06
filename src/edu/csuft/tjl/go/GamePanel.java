package edu.csuft.tjl.go;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.xml.crypto.Data;

/**
 * ��壨������
 * 
 * @author administrator
 *
 */
public class GamePanel extends JPanel {
	GameModle model;
	/**
	 * ����
	 */
	Image bg;

	/**
	 * ����
	 */
	Piece piece;

	/**
	 * �������ӣ��б������������ӣ�
	 */
	ArrayList<Piece> piecelist = new ArrayList<>();

	/**
	 * GamePanel ���췽��
	 */
	public GamePanel(GameModle model) {
		this.model = model;
		try {
			bg = ImageIO.read(new File("res/go.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/**
		 * ע�ᣨ��꣩�¼�������
		 */
		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				int x, y;
				if ((e.getX() - 31) % 55 <= 27) {
					x = ((e.getX() - 31) / 55) * 54 + 34;
				} else {
					x = (((e.getX() - 31) / 55) + 1) * 54 + 34;
				}
				if ((e.getY() - 31) % 55 <= 27) {
					y = ((e.getY() - 31) / 55) * 54 + 34;
				} else {
					y = (((e.getY() - 31) / 55) + 1) * 54 + 34;
				}

				/**
				 * �������������꣬������һ������ ���ж��Ƿ��������
				 */
				Piece piece = new Piece(x, y);

				if (model.isDown(piece) == true) {
					piece.isblack = piecelist.size() % 2 == 0;

					piecelist.add(piece);
					// ����ģ��
					model.update(piece);
					// �����ػ�
					repaint();
					// �ֲ��ػ桢˫���壨���黭�������滻��
					// repaint(r);
				}
				if (model.checkWin(piece.y / 50, piece.x / 50)) {
					if (piece.isblack) {
						JOptionPane.showMessageDialog(null, "����ʤ��");
					} else {
						JOptionPane.showMessageDialog(null, "����ʤ��");
					}
				}
			}

		}

		);

	}

	/**
	 * ����
	 */
	@Override
	public void paint(Graphics graphics) {
		// ����1����
		graphics.drawImage(bg, 0, 0, getWidth(), getHeight(), null);// ͼƬ����Ӧ����
		// 2Dģʽ�������������
		Graphics2D g = (Graphics2D) graphics;
		// ������Ⱦ�����������
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		// super.paint(g);//�������Ļ�ͼǿתΪ2D��ͼ�����������ʵ�õĹ���
		// Graphics2D g2d = (Graphics2D) graphics;
		// g2d.setStroke(new BasicStroke(2f));//ԭ�������Ĵ�ϸ�Ŵ�Ϊԭ����������С
		// System.out.println(getWidth());
		// System.out.println(getHeight());
		// g.drawLine(0, 0, getWidth(), getHeight());

		// ��������
		for (Piece piece : piecelist) {
			piece.paint(g);
		}

	}

}
