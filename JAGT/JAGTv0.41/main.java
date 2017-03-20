//Let's try this again
//Might as well comment on some of this stuff or it might get hairy later on
//I went on a massive integer purge when I added the midpoint thingy so everything is a double now >>>:3 so naughty
package main;
import java.lang.Math;
public class main {
	//Line divider tool; divides line formed by two point A and B at point C with the given ratio of the lengths of AC and CB (this was the original purpose for the program itself, which was to do my Geometry homework :D)
	public static String divider(int ax, int ay, int bx, int by, int[] ratio) {
		int num = ratio[0];
		int dem = ratio[1];
		double[] _slope = slope_pass(ax, ay, bx, by);
		double rise = _slope[0];
		double run = _slope[1];
		double total = num + dem;
		double fratio = num/total;
		double ychange = rise * fratio;
		double xchange = run * fratio;
		double fx = bx - xchange;
		double fy = by - ychange;
		String fin = "Coordinates of line-splitting point: (" + fx + ", " + fy + ")"; 
		return(fin);
	}
	//The tool "Slope finder"; use it by setting the tool to "slope"
	public static String slopetool(int ax, int ay, int bx, int by, boolean isDecimal) {
		double[] coords = {ay, by};
		//Finds slope and simplifies it; can't upgrade this to fit with the slope_pass method b/c of the following comment
		double rise = slope(coords, "rise");
		coords[0] = ax;
		coords[1] = bx;
		double run = slope(coords, "run");
		double[] _slope = {rise, run};
		_slope = simplify(_slope);
		//Checking for vertical or horizontal lines or if the points are the same
		if (rise == run) {
			if (rise != 0 && run != 0) {
				rise = 1;
				run = 1;
			}
		}
		String fin = null;
		if (isDecimal == false) {
			fin = "Slope of line formed by the points: " + _slope[0] + "/" + _slope[1];
		}
		else {
			double slopeAsDecimal = _slope[0]/_slope[1];
			fin = "Slope of line formed by the points: " + (double)Math.round(slopeAsDecimal * 1000d)/1000d;
		}
		return(fin);
	}
	//Gives the equation of the perpendicular bisector of the line formed by points A and B in slope-intercept form (y = m * x + b); also for my Geometry homework
	public static String bisector(int ax, int ay, int bx, int by, boolean isDecimal) {
		//Gets slope and simplifies it
		double[] _slope = slope_pass(ax, ay, bx, by);
		//Finds midpoint with midpoint formula
		double[] mcoords = midpoint_formuler(ax, ay, bx, by);
		String f = point_slope(mcoords, _slope, isDecimal);
		String fin = "<html>Equation of the perpendicular bisector of the line: <br>" + f + "</html>";
		return(fin);
	}
	//Equation of a circle in the standard form of (x - h)^2 + (y - k)^2 = r^2
	public static String cequation(int cx, int cy, int pointx, int pointy, int type){
		String fin = null;
		//For if the radius is given
		if (type == 0){
			fin = "Eqaution of the circle: (" + cx + " - " + "h)" + "\u00B2" + " + (" + cy + " - k)" + "\u00B2" + " = " + pointx; 
		}
		//For if a point is given
		else{
			double r = Double.parseDouble(distance(cx, cy, pointx, pointy, 0));
			fin = "Eqaution of the circle: (" + cx + " - " + "h)" + "\u00B2" + " + (" + cy + " - k)" + "\u00B2" + " = " + r + "\u00B2";
		}
		return fin;
	}
	//Finds distance between two points
	public static String distance(int ax, int ay, int bx, int by, int ron){
		double result = Math.sqrt(((by - ay)*(by - ay)) + ((bx - ax) * (bx - ax)));
		String fin = null;
		if (ron > 0){
			fin = "Distance between point A and point B: " + (double)Math.round(result * 1000d)/1000d + " units";
		}
		else {
			fin = String.valueOf((double)Math.round(result * 1000d)/1000d);
		}
		return fin;
	}
	//Things used by many different tools
	//Point slope formula (y - y1 = m * (x - x1))
	public static String point_slope(double[] crds, double[] _slope, boolean isDecimal) {
		double[] pslope = {_slope[1] * -1, _slope[0]};
		double multiply = pslope[0]/pslope[1];
		double intercept = (multiply * -(crds[0])) + crds[1];
		pslope = simplify(pslope);
		String f = null;
		if (isDecimal) {
			double slopeAsDecimal = pslope[0]/pslope[1];
			f = "y = " + (double)Math.round(slopeAsDecimal * 1000d)/1000d + "x + " + intercept;
		}
		else {
			f = "y = " + pslope[0] + "/" + pslope[1] + "x + " + intercept;
		}
		return f;
	}
	//Passes on coords to the slope method; simplifies my previous process of calling the slope method twice each time
	public static double[] slope_pass(int ax, int ay, int bx, int by) {
		double[] _slope = {ay, by};
		double rise = slope(_slope, "rise");
		_slope[0] = ax;
		_slope[1] = bx;
		double run = slope(_slope, "run");
		_slope[0] = rise;
		_slope[1] = run;
		return _slope;
	}
	//Used by almost everything; finds slope of line formed by coords
	public static double slope(double[] coords, String type) {
		double rise = 0, run = 0;
		if (type == "rise") {
			rise = coords[1] - coords[0];
		}
		else {
			run = coords[1] - coords[0];
		}
		if (type == "rise") {
			return rise;
		}
		else {
			return run;
		}
	}
	//Midpoint formuler; kind of obvious
	public static double[] midpoint_formuler(int ax, int ay, int bx, int by){
		double pmx = bx + ax;
		double pmy = by + ay;
		double mx = pmx/2;
		double my = pmy/2;
		double[] mcoords = {mx, my};
		return mcoords;
	}
	//Simplifies slope
	public static double[] simplify(double[] _slope) {
		double rise = _slope[0], run = _slope[1];
		for (int i = 0; i < 5; ++i) {
			if (rise % 2 == 0 && run % 2 == 0) {
				rise /= 2;
				run /= 2;
			}
			if (rise % 3 == 0 && run % 3 == 0) {
				rise /= 3;
				run /= 3;
			}
			if (rise % 4 == 0 && run % 4 == 0) {
				rise /= 4;
				run /= 4;
			}
			if (rise % 5 == 0 && run % 5 == 0) {
				rise /= 5;
				run /= 5;
			}
			if (rise % 6 == 0 && run % 6 == 0) {
				rise /= 6;
				run /= 6;
			}
			if (rise % 7 == 0 && run % 7 == 0) {
				rise /= 7;
				run /= 7;
			}
			if (rise % 8 == 0 && run % 8 == 0) {
				rise /= 8;
				run /= 8;
			}
			if (rise % 9 == 0 && run % 9 == 0) {
				rise /= 9;
				run /= 9;
			}
			if (rise % 10 == 0 && run % 10 == 0) {
				rise /= 10;
				run /= 10;
			}
			if (rise % -2 == 0 && run % -2 == 0) {
				rise /= -2;
				run /= -2;
			}
			if (rise % -3 == 0 && run % -3 == 0) {
				rise /= -3;
				run /= -3;
			}
			if (rise % -4 == 0 && run % -4 == 0) {
				rise /= -4;
				run /= -4;
			}
			if (rise % -5 == 0 && run % -5 == 0) {
				rise /= -5;
				run /= -5;
			}
			if (rise % -6 == 0 && run % -6 == 0) {
				rise /= -6;
				run /= -6;
			}
			if (rise % -7 == 0 && run % -7 == 0) {
				rise /= -7;
				run /= -7;
			}
			if (rise % -8 == 0 && run % -8 == 0) {
				rise /= -8;
				run /= -8;
			}
			if (rise % -9 == 0 && run % -9 == 0) {
				rise /= -9;
				run /= -9;
			}
			if (rise % -10 == 0 && run % -10 == 0) {
				rise /= -10;
				run /= -10;
			}
			if (rise % -2 == 0 && run % 2 == 0) {
				rise /= -2;
				run /= 2;
			}
			if (rise % -3 == 0 && run % 3 == 0) {
				rise /= -3;
				run /= 3;
			}
			if (rise % -4 == 0 && run % 4 == 0) {
				rise /= -4;
				run /= 4;
			}
			if (rise % -5 == 0 && run % 5 == 0) {
				rise /= -5;
				run /= 5;
			}
			if (rise % -6 == 0 && run % 6 == 0) {
				rise /= -6;
				run /= 6;
			}
			if (rise % -7 == 0 && run % 7 == 0) {
				rise /= -7;
				run /= 7;
			}
			if (rise % -8 == 0 && run % 8 == 0) {
				rise /= -8;
				run /= 8;
			}
			if (rise % -9 == 0 && run % 9 == 0) {
				rise /= -9;
				run /= 9;
			}
			if (rise % -10 == 0 && run % 10 == 0) {
				rise /= -10;
				run /= 10;
			}
			if (rise % 2 == 0 && run % -2 == 0) {
				rise /= 2;
				run /= -2;
			}
			if (rise % 3 == 0 && run % -3 == 0) {
				rise /= 3;
				run /= -3;
			}
			if (rise % 4 == 0 && run % -4 == 0) {
				rise /= 4;
				run /= -4;
			}
			if (rise % 5 == 0 && run % -5 == 0) {
				rise /= 5;
				run /= -5;
			}
			if (rise % 6 == 0 && run % -6 == 0) {
				rise /= 6;
				run /= -6;
			}
			if (rise % 7 == 0 && run % -7 == 0) {
				rise /= 7;
				run /= -7;
			}
			if (rise % 8 == 0 && run % -8 == 0) {
				rise /= 8;
				run /= -8;
			}
			if (rise % 9 == 0 && run % -9 == 0) {
				rise /= 9;
				run /= -9;
			}
			if (rise % 10 == 0 && run % -10 == 0) {
				rise /= 10;
				run /= -10;
			}
		}
		return _slope;
	}
}