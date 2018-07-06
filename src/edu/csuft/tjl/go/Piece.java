package edu.csuft.tjl.go;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * ����
 * 
 * @author administrator
 *
 */
public class Piece {

	/**
	 * x����
	 */
	int x;

	/**
	 * y����
	 */
	int y;

	/**
	 * ��С��ֱ����
	 */
	public final int size=44;

	/**
	 * ��ɫ:Ĭ�Ϻ�ɫ
	 */
	Boolean isblack = true;

	/**
	 * ��������
	 * 
	 * @param x
	 *            x����
	 * @param y
	 *            y����
	 */
	public Piece(int x, int y) {
		super();
		
		this.x = x-(size/2);
		this.y = y-(size/2);
		
	}

	/**
	 * ����
	 * 
	 * @param g
	 */
	public void paint(Graphics2D g) {
		// ������ɫ
		g.setColor(isblack ? Color.BLACK : Color.WHITE);
		// ��ͼ
		g.fillOval(x, y, size, size);
	}

	

}
