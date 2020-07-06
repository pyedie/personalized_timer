package fr.maevelaouf.personalizedtimer;

import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class PersonalizedTimer {

	static long timer;
	
	public static void main(String[] args) {

		System.out.println("[INFOS] Welcome ! Enter a value to start the timer in seconds");
		
		Scanner sc = new Scanner(System.in);
		
		if (!(sc.hasNextLong())) {
			System.out.println("[ERROR] Input must be a number");
		}
		
		timer = sc.nextLong();
		
		sc.close();
		
		long t = timer;
		
		System.out.println("[INFOS] Starting timer...");
		
		try {
			TimeUnit.MILLISECONDS.sleep(5);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		while (!(timer == 0)) {
			System.out.println("[TIMER] " + timer + " seconds");
			timer--;
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
		}
		
		System.out.println("[INFOS] The timer is finish");
		
		try{
		    SystemTray tray = SystemTray.getSystemTray();

		    Image image = Toolkit.getDefaultToolkit().createImage("random.png");

		    TrayIcon trayIcon = new TrayIcon(image, "Personalized Timer");

		    trayIcon.setImageAutoSize(true);

		    trayIcon.setToolTip("System tray icon demo");
		    tray.add(trayIcon);

		    trayIcon.displayMessage("Personalized Timer", "Your timer of " + t + " seconds is finish !", MessageType.INFO);
		}catch(Exception ex){
		    System.err.print(ex);
		}
		
	}

}