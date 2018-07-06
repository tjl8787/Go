package edu.csuft.tjl.go;

import java.awt.Graphics;

import javax.swing.*;

/**
 * 游戏的逻辑（规则）
 * @author administrator
 *
 */
public class GameModle {
	int x;
	int y;
	/**
	 * 9*9二位数组
	 */
	int[][]data=new int[9][9];
	
	/**
	 * 显示数据模型
	 */
	public void show() {
		System.out.println("--------------------------------------");
		for(int row[]:data) {//输出二维数组
			for(int e:row) {
				System.out.print(e+"\t");
			}
			System.out.println();
		}
	}
	/**
	 * 落了新的棋子，更新模型
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
			JOptionPane.showMessageDialog(null, "不能重复落子！");
			return false;
		}
		return true;
	}
	public boolean checkWin(int x , int y) {
        // TODO Auto-generated method stub

        boolean flag = false;
        // 保存共有多少相同颜色棋子相连
        int count = 1;
        // 判断横向 特点：data[x][y]中y值相同
        int color = data[x][y];
        // 判断横向
        count = this.checkCount(x, y, 1, 0, color);
        if (count >= 5) {
            flag = true;
        } else {
            // 判断纵向
            count = this.checkCount(x, y, 0, 1, color);
            if (count >= 5) {
                flag = true;
            } else {
                // 判断右上左下
                count = this.checkCount(x, y, 1, -1, color);
                if (count >= 5) {
                    flag = true;
                } else {
                    // 判断左下右上
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
     *  判断相同棋子连接的个数
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