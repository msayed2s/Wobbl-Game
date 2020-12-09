package hbrs.se2.main;

import java.awt.EventQueue;

import javax.swing.JFrame;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class WobblGame extends JFrame implements CommandLineRunner {

	private static final long serialVersionUID = -437004379167511593L;

	@Override
	public void run(String... arg0) throws Exception {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					JFrame window = new JFrame("Wobbl Game \u2122");
					window.add(new Neghiah());
					window.setContentPane(new Neghiah());
					window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					window.setResizable(true);
					window.pack();
					window.setLocationRelativeTo(null);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
