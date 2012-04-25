package ch.zhaw.ads;

import javax.swing.*;
import ch.zhaw.ads.*;

import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class GraphicPanel extends JPanel {

	String figure;

	public void setFigure(String figure) {
		this.figure = figure;
		paint(getGraphics());
	}

	private void drawFigure(Graphics g) {
		if (figure != null) {
			int w = getWidth();
			int h = getHeight();
			g.setColor(Color.black);
			StringTokenizer tok = new StringTokenizer(figure," <>=/,\"\n");
			while (tok.hasMoreTokens()) {
				String command = tok.nextToken();

				tok.nextToken();

				if (command.equals("color")) {
					int red, green, blue;
					red = Integer.parseInt((String)tok.nextToken());
					tok.nextToken();
					green = Integer.parseInt((String)tok.nextToken());
					tok.nextToken();
					blue = Integer.parseInt((String)tok.nextToken());
					System.out.println(red);
					System.out.println(green);
					System.out.println(blue);
					Color c = new Color(red ,green ,blue);
					g.setColor(c);
					continue;
				}
				
				double x1 = Double.parseDouble(tok.nextToken());
				tok.nextToken();
				double y1 = Double.parseDouble(tok.nextToken());
				tok.nextToken();
				double x2 = Double.parseDouble(tok.nextToken());
				tok.nextToken();
				double y2 = Double.parseDouble(tok.nextToken());
				if (command.equals("line")) {
					g.drawLine((int)(x1 * w) , h - (int)(y1 * h), (int)(x2 * w), h - (int)(y2 * h));
				} else {
					tok.nextToken();
					this.drawRect(g, x1, y1, x2, y2, tok.nextToken());
				}
			}
		}
	}



		private void drawRect(Graphics g, double x, double y, double width, double height, String style) {
			int w = getWidth();
			int h = getHeight();
			int ix0 = (int) (w * x);
			int iy0 = (int) (h * y);
			int ix1 = (int) (w * (x + width));
			int iy1 = (int) (h * (y + height));
			if (style.equals("draw")) {
				g.drawRect(ix0,h-iy1,ix1-ix0,iy1-iy0);
			} else {
				g.fillRect(ix0,h-iy1,ix1-ix0,iy1-iy0);
			}
		}

		private void clear(Graphics g) {
			int w = getWidth();
			int h = getHeight();
			g.setColor(new Color(240,240,240));
			g.fillRect(0,0,w,h);
		}

		public void paint(Graphics g) {
			try {
				clear(g);
				drawFigure(g);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}