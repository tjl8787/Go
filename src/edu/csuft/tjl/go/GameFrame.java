package edu.csuft.tjl.go;

import javax.swing.JFrame;
/**
 * 游戏窗口
 * @author administrator
 *
 */
public class GameFrame extends JFrame{
	/*
	 * 面板
	 */
	GamePanel gamePanel;
	GameModle model;
	
	/*
	 * 构造方法：定义游戏窗口
	 */
	public GameFrame(GameModle model) {
		this.model=model;
		//标题
		this.setTitle("五子棋-田某人作品");
		
		//大小
		this.setSize(516, 538);
		this.setResizable(false);
		
		//位置
		this.setLocationRelativeTo(null);//最简单的屏幕居中
		
		//退出程序
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//创建 GamePanel
		gamePanel=new GamePanel(model);
		
		this.setContentPane(gamePanel);
		
		//显示
				this.setVisible(true);
				
	}
}
