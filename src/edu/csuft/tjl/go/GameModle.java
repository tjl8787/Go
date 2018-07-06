package edu.csuft.tjl.go;

import java.awt.Graphics;

import javax.swing.*;

/**
 * ��Ϸ���߼�������
 * @author administrator
 *
 */
public class GameModle {
	int x;
	int y;
	/**
	 * 9*9��λ����
	 */
	int[][]data=new int[9][9];
	
	/**
	 * ��ʾ����ģ��
	 */
	public void show() {
		System.out.println("--------------------------------------");
		for(int row[]:data) {//�����ά����
			for(int e:row) {
				System.out.print(e+"\t");
			}
			System.out.println();
		}
	}
	/**
	 * �����µ����ӣ�����ģ��
	 * @piece
	 */
	public void update(Piece piece) {
		int i=piece.x/50;
		int j=piece.y/50;
		
		data[j][i]=piece.isblack?1:2;
		this.show();
		System.out.println(checkWin(j,i));
	}
	public boolean isDown(Piece piece) {
		int i=piece.x/50;
		int j=piece.y/50;
		if(data[j][i]!=0) {
			JOptionPane.showMessageDialog(null, "�����ظ����ӣ�");
			return false;
		}
		return true;
	}
	public boolean checkWin(int x , int y) {
        // TODO Auto-generated method stub

        boolean flag = false;
        // ���湲�ж�����ͬ��ɫ��������
        int count = 1;
        // �жϺ��� �ص㣺data[x][y]��yֵ��ͬ
        int color = data[x][y];
        // �жϺ���
        count = this.checkCount(x, y, 1, 0, color);
        if (count >= 5) {
            flag = true;
        } else {
            // �ж�����
            count = this.checkCount(x, y, 0, 1, color);
            if (count >= 5) {
                flag = true;
            } else {
                // �ж���������
                count = this.checkCount(x, y, 1, -1, color);
                if (count >= 5) {
                    flag = true;
                } else {
                    // �ж���������
                    count = this.checkCount(x, y, 1, 1, color);
                    if (count >= 5) {
                        flag = true;
                    }
                }
            }
        }
        return flag;
       
    }
	
    /**
     *  �ж���ͬ�������ӵĸ���
     * @param x
     * @param y
     * @param xChange
     * @param yChange
     * @param color
     * @return
     */
	public  int checkCount(int x, int y, int xChange, int yChange,int color) {
        // TODO Auto-generated method stub
		
        int count = 1;
        int tempX = xChange;
        int tempY = yChange;
        while (x - xChange >= 0 && x - xChange <= 8 && y - yChange >= 0 && y - yChange <= 8
                && color == data[x - xChange][y - yChange]) {
            count++;
            if (xChange != 0) {
                xChange++;
            }
            if (yChange != 0) {
                if (yChange > 0) {
                    yChange++;
                } else {
                    yChange--;
                }
            }
        }
        xChange = tempX;
        yChange = tempY;
        while (x + xChange >= 0 && x + xChange <= 8 && y + yChange >= 0 && y + yChange <= 8
                && color == data[x + xChange][y + yChange]) {
            count++;
            if (xChange != 0) {
                xChange++;
            }
            if (yChange != 0) {
                if (yChange > 0) {
                    yChange++;
                } else {
                    yChange--;
                }
            }
        }
       
        return count;
    }
	
}