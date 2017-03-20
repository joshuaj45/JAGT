//Let's try this again
//Might as well comment on some of this stuff or it might get hairy later on
//I went on a massive integer purge when I added the midpoint thingy so everything is a double now >>>:3 so naughty
package main;
import java.util.Scanner;
public class Main_classic {
	static Scanner input = new Scanner(System.in);
	//Main method; self explanatory
	public static void main(String[] args) {
		String[] tools = {"slope finder", " line divider", "and perpendicular bisector (bisector being used as a verb).\n"};
		System.out.println("JAGT v0.11\nExpirimental Phase; you're only seeing this if you're from GitHub or if I showed you this\nOriginally in Python, migrated to Java cuz it's better");
		System.out.print("Tools are ");
		int i = 0;
		//Over complicated way of printing out available (or upcoming) tools
		do {
			if (tools.length > 2){
				if (i >= 1){
					System.out.print(", " + tools[i]);
				}
				else {
					System.out.print(tools[i]);
				}
			}
			else {
				System.out.print(tools[i]);
			}
			i++;
		}
		while (i < tools.length);
		System.out.println("Tool? ");
		String tool = input.next();
		//Prompts for coordinates
		coordprompt(tool);
	}
	//Coordinate prompt; used at the beginning
	public static void coordprompt(String tool) {
		System.out.print("Point A X: ");
		int ax = input.nextInt();
		System.out.print("Point A Y: ");
		int ay = input.nextInt();
		System.out.print("Point B X: ");
		int bx = input.nextInt();
		System.out.print("Point B Y: ");
		int by = input.nextInt();
		switch(tool) {
		case "slope": slopetool(ax, ay, bx, by); break;
		case "grapher": grapher(ax, ay, bx, by); break;
		case "divider": divider(ax, ay, bx, by); break;
		case "bisector": bisector(ax, ay, bx, by); break;
		}
	}
	//Grapher tool; not available yet b/c I suck at GUI's
	public static void grapher(int ax, int ay, int bx, int by) {
		System.out.println("Not available");
		System.exit(0);
	}
	//Line divider tool; divides line formed by two point A and B at point C with the given ratio of the lengths of AC and CB (this was the original purpose for the program itself, which was to do my Geometry homework :D)
	public static void divider(int ax, int ay, int bx, int by) {
		double[] _slope = slope_pass(ax, ay, bx, by);
		double rise = _slope[0];
		double run = _slope[1];
		System.out.println("Ratio of AC to CB that will be made by dividing the original line");
		System.out.println("Numerator (as a double): ");
		double num = input.nextDouble();
		System.out.println("Denominator (as a double): ");
		double dem = input.nextDouble();
		double total = num + dem;
		double ratio = num/total;
		double ychange = rise * ratio;
		double xchange = run * ratio;
		double fx = bx - xchange;
		double fy = by - ychange;
		System.out.println("Final coordinates of line splitting point C: (" + fx + ", " + fy + ")");
		System.exit(0);
	}
	//The tool "Slope finder"; use it by setting the tool to "slope"
	public static void slopetool(int ax, int ay, int bx, int by) {
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
			if (rise == 0 && run == 0) {
				System.out.println("That's the same point, dingus");
				System.exit(0);
			}
			else if (rise == 0 && run != 0) {
				System.out.println("Horizontal line; slope is zero");
				System.exit(0);
			}
			else if (rise != 0 && run == 0) {
				System.out.println("Vertical line; undefined slope");
				System.exit(0);
			}
			else {
				rise = 1;
				run = 1;
			}
		}
		System.out.println("Slope: " + _slope[0] + "/" + _slope[1]);
		System.exit(0);
	}
	//Gives the equation of the perpendicular bisector of the line formed by points A and B in slope-intercept form (y = m * x + b); also for my Geometry homework
	public static void bisector(int ax, int ay, int bx, int by) {
		//Gets slope and simplifies it
		double[] _slope = slope_pass(ax, ay, bx, by);
		_slope = simplify(_slope);
		//Finds midpoint with midpoint formula
		double[] mcoords = midpoint_formuler(ax, ay, bx, by);
		String fin = point_slope(mcoords, _slope);
		System.out.println("Equation of perpendicular bisector: " + fin + ", Midpoint: " + mcoords[0] + ", " + mcoords[1]);
	}
	//Things used by many different tools
	//Point slope formula (y - y1 = m * (x - x1))
	public static String point_slope(double[] crds, double[] _slope) {
		double[] pslope = {_slope[1] * -1, _slope[0]};
		double multiply = pslope[0]/pslope[1];
		double intercept = (multiply * -(crds[0])) + crds[1];
		String f = "y = " + pslope[0] + "/" + pslope[1] + "x + " + intercept;
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
	//Midpoint formula(formuler for those of you who are Mr. Krabs); kind of obvious
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
		}
		return _slope;
	}
}