package edu.csuft.tjl.go;
	/*
	 * 程序的起点
	 */
public class App {
	public static void main(String[] args) {
		
		// 游戏逻辑：模型
		GameModle model=new GameModle();
		
		//游戏窗口：界面、视图
		GameFrame frame=new GameFrame(model);
	}
}
