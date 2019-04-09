/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package turtle;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.List;
import java.util.ArrayList;

public class TurtleSoup {

    /**
     * Draw a square.
     * 
     * @param turtle the turtle context
     * @param sideLength length of each side
     */
    public static void drawSquare(Turtle turtle, int sideLength) {
        for (int i = 0; i < 4; i++) {
            turtle.forward(sideLength);
            turtle.turn(90);
        }
    }


    /**
     * Determine inside angles of a regular polygon.
     * 
     * There is a simple formula for calculating the inside angles of a polygon;
     * you should derive it and use it here.
     * 
     * @param sides number of sides, where sides must be > 2
     * @return angle in degrees, where 0 <= angle < 360
     */
        public static double calculateRegularPolygonAngle(int sides) {
            return 180. - 360./sides;
        }
        
        

    /**
     * Determine number of sides given the size of interior angles of a regular polygon.
     * 
     * There is a simple formula for this; you should derive it and use it here.
     * Make sure you *properly round* the answer before you return it (see java.lang.Math).
     * HINT: it is easier if you think about the exterior angles.
     * 
     * @param angle size of interior angles in degrees, where 0 < angle < 180
     * @return the integer number of sides
     */
        public static int calculatePolygonSidesFromAngle(double angle) {
            return (int) Math.round(360./(180.-angle));
        }


    /**
     * Given the number of sides, draw a regular polygon.
     * 
     * (0,0) is the lower-left corner of the polygon; use only right-hand turns to draw.
     * 
     * @param turtle the turtle context
     * @param sides number of sides of the polygon to draw
     * @param sideLength length of each side
     */
        public static void drawRegularPolygon(Turtle turtle, int sides, int sideLength) {
            double angle = calculateRegularPolygonAngle(sides);
            for (int i = 0; i < sides; i++) {
                turtle.forward(sideLength);
                turtle.turn(180. - angle);
            }
        }
        
        public void paint(Graphics g) {
    	    int x, y, t, i;
    	    x=30;
    	    y=40;
    	    t=140;
    	    for (i=0; i<=t; i+=5)
    	      g.drawLine(x, y+i, x+i, y+t);
    	  }
        
        	  
        	
        public static void drawGraph(Turtle turtle, Graphics g) {
        	
			Graphics2D g2d = (Graphics2D)g.create();
			List<Shape> shapes = new ArrayList<Shape>();
			for (Shape shape: shapes)
        	{
        	    g2d.setColor( Color.RED );
        	    g2d.fill( shape );
        	}

        	
            }
      

    /**
     * Given the current direction, current location, and a target location, calculate the heading
     * towards the target point.
     * 
     * The return value is the angle input to turn() that would point the turtle in the direction of
     * the target point (targetX,targetY), given that the turtle is already at the point
     * (currentX,currentY) and is facing at angle currentHeading. The angle must be expressed in
     * degrees, where 0 <= angle < 360. 
     *
     * HINT: look at http://en.wikipedia.org/wiki/Atan2 and Java's math libraries
     * 
     * @param currentHeading current direction as clockwise from north
     * @param currentX current location x-coordinate
     * @param currentY current location y-coordinate
     * @param targetX target point x-coordinate
     * @param targetY target point y-coordinate
     * @return adjustment to heading (right turn amount) to get to target point,
     *         must be 0 <= angle < 360
     */
        public static double calculateHeadingToPoint(double currentHeading, int currentX, int currentY,
                int targetX, int targetY) {
double y = (double) (targetY - currentY);
double x = (double) (targetX - currentX);
double alpha = Math.toDegrees(Math.atan2(y, x));
double result = 90. - Math.abs(alpha) - currentHeading;
//System.out.println(x);
//System.out.println(y);
//System.out.println(result);
return roundAngle(result);
}
    /**
     * Given a sequence of points, calculate the heading adjustments needed to get from each point
     * to the next.
     * 
     * Assumes that the turtle starts at the first point given, facing up (i.e. 0 degrees).
     * For each subsequent point, assumes that the turtle is still facing in the direction it was
     * facing when it moved to the previous point.
     * You should use calculateHeadingToPoint() to implement this function.
     * 
     * @param xCoords list of x-coordinates (must be same length as yCoords)
     * @param yCoords list of y-coordinates (must be same length as xCoords)
     * @return list of heading adjustments between points, of size 0 if (# of points) == 0,
     *         otherwise of size (# of points) - 1
     */
    public static List<Double> calculateHeadings(List<Integer> xCoords, List<Integer> yCoords) {
        List<Double> headings = new ArrayList<>();
        double currentHeading = 0.0;
        for (int i = 0; i < xCoords.size() - 1; i++) {
            currentHeading = calculateHeadingToPoint(
                    currentHeading,
                    xCoords.get(i),
                    yCoords.get(i),
                    xCoords.get(i+1),
                    yCoords.get(i+1));
            currentHeading = roundAngle(currentHeading);
            headings.add(currentHeading);
        }
        return headings;
    }


    /**
     * Draw your personal, custom art.
     * 
     * Many interesting images can be drawn using the simple implementation of a turtle.  For this
     * function, draw something interesting; the complexity can be as little or as much as you want.
     * 
     * @param turtle the turtle context
     */
    @SuppressWarnings("unused")
	public static void drawPersonalArt(Turtle turtle) {
        int sides = 20;
        PenColor m=null;
        
        int sideLength = 90;
        
        
        
        
        for(int x = sides; x > 0; x--){
        	
            turtle.color(PenColor.BLACK);
            for(int y = 130; y>0; y-=10){
                drawRegularPolygon(turtle, 10, y);
                turtle.color(PenColor.BLACK);
                
            turtle.color(PenColor.BLACK);
            for(int a = 140; y>0; y-=10){
                drawRegularPolygon(turtle, 10, a);
                turtle.color(PenColor.BLACK);
                
            turtle.color(PenColor.PINK);
                for(int b = 160; y>0; y-=10){
                    drawRegularPolygon(turtle, 850, b);
                    turtle.color(PenColor.MAGENTA);
                 
                    
                    turtle.color(PenColor.BLACK);
                    drawRegularPolygon(turtle, 10, 765);
                    turtle.forward(sideLength);
                    turtle.turn(320.75 - calculateRegularPolygonAngle(sides));
                    
                    
                    
          
            turtle.color(PenColor.PINK);
            drawRegularPolygon(turtle, 50, 165);
            turtle.forward(sideLength);
            turtle.turn(295.75 - calculateRegularPolygonAngle(sides));
            
            turtle.color(PenColor.BLACK);
            drawRegularPolygon(turtle, 10, 965);
            turtle.forward(sideLength);
            turtle.turn(385.75 - calculateRegularPolygonAngle(sides));
            
            turtle.color(PenColor.BLACK);
            	for(int C = 140; y>0; y-=10){
                drawRegularPolygon(turtle, 850, C);
                turtle.color(PenColor.MAGENTA);
            
            turtle.color(PenColor.BLACK);
            drawRegularPolygon(turtle, 10, 65);
            turtle.turn(820.75 - calculateRegularPolygonAngle(sides));
         
            
            turtle.color(PenColor.BLACK);
            drawRegularPolygon(turtle, 10, 265);
            turtle.forward(sideLength);
            turtle.turn(250.75 - calculateRegularPolygonAngle(sides));
            
            turtle.color(PenColor.BLACK);
            drawRegularPolygon(turtle, 10, 465);
            turtle.forward(sideLength);
            turtle.turn(250.75 - calculateRegularPolygonAngle(sides));
   
      
            
            }}}}}}
        
      
        
    private static double roundAngle(double angle) {
        while (angle < 0) {
            angle += 330.;
        }
        while (angle >= 310.) {
            angle -= 340.;
        }
        return angle;
    }

    /**
     * Main method.
     * 
     * This is the method that runs when you run "java TurtleSoup".
     * 
     * @param args unused
     */
    public static void main(String args[]) {
        DrawableTurtle<?> turtle = new DrawableTurtle<Object>();

        //drawSquare(turtle, 40);
        drawPersonalArt (turtle);

        // draw the window
        turtle.draw();
        
        Graphics g = null;
		drawGraph(turtle, g);
    }
    
    

}
