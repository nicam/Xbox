package ch.zhaw.ads.snowFlacke;

import ch.zhaw.ads.CommandInterpreter;

public class TurtleGraphicServer implements CommandInterpreter {
     
      
  String figure = "";
  Turtle turtle;
                   
  public String interpret(String command) {
	  int level = Integer.parseInt(command);
	  level = (level > 0) ? level : 4;
	  turtle = new Turtle(0.2, 0.7);
	  this.makeSchneeFlocke(level);
	  return turtle.getTrace();
  }
  
  public void makeSchneeFlocke(int level) {
	  this.schneeflocke(level, 0.6);
	  turtle.turn(-120); 
	  this.schneeflocke(level, 0.6);
	  turtle.turn(-120); 
	  this.schneeflocke(level, 0.6);
  }
  
  void schneeflocke(int stufe, double dist) {
	  if (stufe == 0) {
		  turtle.move(dist);
	  } else {
		  stufe--; 
		  dist = dist/3;
		  schneeflocke(stufe,dist);
		  turtle.turn(60); 
		  schneeflocke(stufe,dist); 
		  turtle.turn(-120); 
		  schneeflocke(stufe,dist);
		  turtle.turn(60); 
		  schneeflocke(stufe,dist);
	  }
  }

}