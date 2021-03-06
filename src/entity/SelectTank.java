package entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import entrance.TankClient;
import main.GamePanel;
import main.MapEditPanel;
import main.WelcomePanel;
/*
 * @author uncleYiba
 * @describe 欢迎页面/开始页面 的 选择用图标(小坦克)
 * @date 2018/01/25
 */
public class SelectTank {
	private int selectShow=0;
	private int[] xLoca={100,100,100};
	private int[] yLoca={225,255,285};
	private int index=0;
	private WelcomePanel wp;
	public SelectTank(WelcomePanel wp) {
		this.wp=wp;
	}
	public void move(KeyEvent e){
		switch (e.getKeyCode()) {
			case KeyEvent.VK_X:
				index++;
				break;
			case KeyEvent.VK_Z:
				if (index==2){
					GamePanel gp=new MapEditPanel();
					TankClient tc=wp.getTc();
					tc.replaceNewGamePanel(gp);
				}
				break;
		}
		if (index==3) index=0;
	}
	public void paint(Graphics g){
		String url2="pic/"+Terrain.terrainMap.get("select1");
		Image img2=Toolkit.getDefaultToolkit().getImage(url2); 
		
		String url3="pic/"+Terrain.terrainMap.get("select2");
		Image img3=Toolkit.getDefaultToolkit().getImage(url3); 
		if (selectShow%2==0){
			g.drawImage(img2, xLoca[index], yLoca[index],null);
			selectShow++;
		}else{
			g.drawImage(img3, xLoca[index], yLoca[index],null);
			selectShow++;
		}
		if (selectShow==100) selectShow=0;
	}
}
