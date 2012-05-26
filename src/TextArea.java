import java.awt.Color;
import java.awt.Graphics;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TextArea {
	
	ArrayList<Line> text;	// storage for the lines of text
	
	int width, height;		// size of the text area, characters
	int lineHeight;			// how tall each line is
	int offset;				// offset used for scrolling text
	int xPosition, yPosition;
	
	public TextArea(int w, int h, int x, int y){
		xPosition = x;
		yPosition = y;
		width = w;
		height = h;
		text = new ArrayList<Line>();
		for(int i=0; i<height; i++){		// create blank lines initially
			text.add(new Line("", Color.black));
		}
		lineHeight = 20;
		offset = 0;
	}
	
	// adds a line of text, requires a color
	public void add(String t, Color c){
		offset = 0;
		DateFormat dateFormat = new SimpleDateFormat("h:mm:ss");
		Date date = new Date();
		t = "<" + dateFormat.format(date) + "> " + t; // add the date to the line
		int length = t.length(); // length of the line
		int rows = length/width;	// how many rows of text for each line
		
		// for each row, take out the width, 0-10, then 10-20, etc
		for(int i=0; i<=rows; i++){
			Line l = new Line(t.substring(i*width, Math.min((i+1)*width, length)), c);
			text.add(i, l);
		}
	}

	// draw the text area onto a Graphics object
	// requires an x and y position to draw
	public void paint(Graphics g){
		if(offset > text.size()-height*2) { offset = text.size()-height*2; }
		if(offset < 0){ offset = 0; }
		for(int i=0; i<height; i++){
			g.setColor(text.get(i+offset).color);
			g.drawString(text.get(i+offset).text, xPosition, yPosition + (i*lineHeight));
		}
	}
	
	// class used to store the color and text
	public class Line {
		String text;
		Color color;

		public Line(String s, Color c){
			text = s;
			color = c;
		}
	}
}
