package edu.csuft.tjl.go;

import javax.swing.JFrame;
/**
 * ��Ϸ����
 * @author administrator
 *
 */
public class GameFrame extends JFrame{
	/*
	 * ���
	 */
	GamePanel gamePanel;
	GameModle model;
	
	/*
	 * ���췽����������Ϸ����
	 */
	public GameFrame(GameModle model) {
		this.model=model;
		//����
		this.setTitle("������-��ĳ����Ʒ");
		
		//��С
		this.setSize(516, 538);
		this.setResizable(false);
		
		//λ��
		this.setLocationRelativeTo(null);//��򵥵���Ļ����
		
		//�˳�����
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//���� GamePanel
		gamePanel=new GamePanel(model);
		
		this.setContentPane(gamePanel);
		
		//��ʾ
				this.setVisible(true);
				
	}
}
