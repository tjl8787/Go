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
 * 面板（画布）
 * 
 * @author administrator
 *
 */
public class GamePanel extends JPanel {
	GameModle model;
	/**
	 * 棋盘
	 */
	Image bg;

	/**
	 * 棋子
	 */
	Piece piece;

	/**
	 * 放置棋子（列表：储存所有棋子）
	 */
	ArrayList<Piece> piecelist = new ArrayList<>();

	/**
	 * GamePanel 构造方法
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
		 * 注册（鼠标）事件监听器
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
				 * 获得鼠标点击的坐标，并创建一个棋子 并判断是否可以落子
				 */
				Piece piece = new Piece(x, y);

				if (model.isDown(piece) == true) {
					piece.isblack = piecelist.size() % 2 == 0;

					piecelist.add(piece);
					// 更新模型
					model.update(piece);
					// 画布重绘
					repaint();
					// 局部重绘、双缓冲（两块画布进行替换）
					// repaint(r);
				}
				if (model.checkWin(piece.y / 50, piece.x / 50)) {
					if (piece.isblack) {
						JOptionPane.showMessageDialog(null, "黑棋胜！");
					} else {
						JOptionPane.showMessageDialog(null, "白棋胜！");
					}
				}
			}

		}

		);

	}

	/**
	 * 绘制
	 */
	@Override
	public void paint(Graphics graphics) {
		// 绘制1棋盘
		graphics.drawImage(bg, 0, 0, getWidth(), getHeight(), null);// 图片自适应窗口
		// 2D模式更多参数可设置
		Graphics2D g = (Graphics2D) graphics;
		// 设置渲染参数：抗锯齿
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		// super.paint(g);//将基本的绘图强转为2D绘图，增加了许多实用的功能
		// Graphics2D g2d = (Graphics2D) graphics;
		// g2d.setStroke(new BasicStroke(2f));//原有线条的粗细放大为原来的三倍大小
		// System.out.println(getWidth());
		// System.out.println(getHeight());
		// g.drawLine(0, 0, getWidth(), getHeight());

		// 绘制棋子
		for (Piece piece : piecelist) {
			piece.paint(g);
		}

	}

}
