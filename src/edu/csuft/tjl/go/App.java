package edu.csuft.tjl.go;
	/*
	 * ��������
	 */
public class App {
	public static void main(String[] args) {
		
		// ��Ϸ�߼���ģ��
		GameModle model=new GameModle();
		
		//��Ϸ���ڣ����桢��ͼ
		GameFrame frame=new GameFrame(model);
	}
}
