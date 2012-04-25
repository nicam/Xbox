/**
 * @(#)ExBoxFrame.java
 *
 * JFC ExBox application
 *
 * @author
 * @version	1.00 2012/2/3
 */
package ch.zhaw.ads;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;

public class ExBoxFrame extends JFrame implements ActionListener, ItemListener {

	private final JMenuItem connect, open, graphicalView, stringView;
	private final JButton enter;
	private final JTextField arguments;
	private final JComboBox history;
	private final JTextArea output;
	private CommandInterpreter command;
	private JScrollPane scrollPane;
	private boolean isGraphical = false;
	private GraphicPanel graphicPanel;

	public static void main(String args[]) {
		ExBoxFrame box = new ExBoxFrame();
		box.setVisible(true);
	}

	public ExBoxFrame() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menuFile = new JMenu("File");
		JMenu menuServer = new JMenu("Server");
		JMenu menuView = new JMenu("View");

		open = new JMenuItem("Open");
		connect = new JMenuItem("Connect");
		graphicalView = new JMenuItem("Graphical");
		stringView = new JMenuItem("String");

		history = new JComboBox();

		JMenuItem menuFileExit = new JMenuItem("Exit");
		
		menuView.add(graphicalView);
		menuView.add(stringView);

		open.addActionListener(this);
		stringView.addActionListener(this);

		menuFileExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExBoxFrame.this.windowClosed();
			}
		});

		menuServer.add(connect);
		menuFile.add(open);
		menuFile.add(menuFileExit);
		menuBar.add(menuFile);
		menuBar.add(menuServer);
		menuBar.add(menuView);

		setTitle("ExBox");
		setJMenuBar(menuBar);
		setSize(new Dimension(400, 400));

		// Add window listener.
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				ExBoxFrame.this.windowClosed();
			}
		});
		menuFile.addActionListener(this);
		connect.addActionListener(this);
		graphicalView.addActionListener(this);

		output = new JTextArea();
	    scrollPane = new JScrollPane(output);
		
		arguments = new JTextField(50);
		enter = new JButton("Enter");
		enter.addActionListener(this);

		this.setLayout(new BorderLayout());
		this.add(menuBar, "North");
		this.add(scrollPane, "Center");

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(enter, "East");
		panel.add(arguments, "West");
		panel.add(history, "South");
		this.add("South", panel);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.out.println("L&F not found");
		}
	}

	private void log(String s) {
		System.out.println(s);
	}

	private void error(String s) {
		output.append("\nERROR:" + s + "\n");
	}

	private void interpret(String args) throws Exception {
		if (command != null) {
			String s = command.interpret(args);
			if (!isGraphical) {
				output.append(s);
			} else {
				graphicPanel.setFigure(s);
			}
		} else
			error("no Server connected");
	}

	public void itemStateChanged(ItemEvent e) {
		arguments.setText((String) e.getItem());
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == enter) {
			try {
				this.interpret(arguments.getText());
			} catch (Exception e1) {
				this.error(e1.getMessage());
			}
		} else if (e.getSource() == open) {
			this.open();
		} else if (e.getSource() == connect) {
			this.connect();
		} else if (e.getSource() == graphicalView) {
			this.buildGraphics();
		} else if (e.getSource() == stringView) {
			this.buildString();
		}
	}
	
	private void buildGraphics() {
		if (isGraphical) {
			return;
		}
		remove(scrollPane);
		graphicPanel = new GraphicPanel();
		add("Center", graphicPanel);
		validate();
		isGraphical = true;
	}
	
	private void buildString() {
		if (!isGraphical) {
			return;
		}
		remove(graphicPanel);
		add("Center", scrollPane);
		validate();
		isGraphical = false;
	}

	public void open() {
		FileDialog fd = new FileDialog(this, "Open");
		fd.setDirectory("/Users/nicam/Dropbox/ZHAW_Public/ADS/");
		fd.setVisible(true);
		String filepath = fd.getDirectory() + fd.getFile();
		try {
			BufferedReader fr = new BufferedReader(new InputStreamReader(new FileInputStream(filepath), "ISO8859-1"));
			String line = "";
			String str = "";
			while ((str = fr.readLine()) != null) {
				line += str + "\n";
			}
			this.interpret(line);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void connect() {
		FileDialog fd = new FileDialog(this, "Connect");
		fd.setDirectory("/Users/nicam/Dropbox/ZHAW/ADS/XBox/src/ch/zhaw/ads/");
		fd.setVisible(true);
		String name = fd.getFile();
		ServerFactory sf = new ServerFactory();
		command = sf.createServer(name, fd.getDirectory());
		setTitle("ExBox connected to " + name);
	}

	protected void windowClosed() {
		System.exit(0);
	}
}