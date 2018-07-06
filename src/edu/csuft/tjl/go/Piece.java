package edu.csuft.tjl.go;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * 棋子
 * 
 * @author administrator
 *
 */
public class Piece {

	/**
	 * x坐标
	 */
	int x;

	/**
	 * y坐标
	 */
	int y;

	/**
	 * 大小（直径）
	 */
	public final int size=44;

	/**
	 * 颜色:默认黑色
	 */
	Boolean isblack = true;

	/**
	 * 创建棋子
	 * 
	 * @param x
	 *            x坐标
	 * @param y
	 *            y坐标
	 */
	public Piece(int x, int y) {
		super();
		
		this.x = x-(size/2);
		this.y = y-(size/2);
		
	}

	/**
	 * 绘制
	 * 
	 * @param g
	 */
	public void paint(Graphics2D g) {
		// 设置颜色
		g.setColor(isblack ? Color.BLACK : Color.WHITE);
		// 画图
		g.fillOval(x, y, size, size);
	}

	

}
