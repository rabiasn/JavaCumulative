package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaCumulativeApplication {

	public static void main(String[] args) {
		// Set headless to false to ensure GUI can be displayed even if standard
		// environment tries to hide it
		System.setProperty("java.awt.headless", "false");

		// SpringApplication.run(JavaCumulativeApplication.class, args);

		// Launch Swing GUI
		javax.swing.SwingUtilities.invokeLater(() -> {
			com.example.demo.gui.QuizFrame frame = new com.example.demo.gui.QuizFrame();
			frame.setVisible(true);
		});
	}

}
