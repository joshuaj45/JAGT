# JAGT
A Java Swing application for geometry and algebra tools
All decimals are rounded to three points of accuracy.
I started making this in Python, but it didn't feel right for some reason. I wasn't very good at Python then, so that was probably why, but either way, I wanted to get more involved with Java. I wanted to make a program that could do my Geometry homework, so that's where I started, and I expanded from there. I add a tool or two every time I think of one. There is also an option to show slopes in decimals instead of fractions. There are still a few issues as far as simplification of slope in fraction form goes. These are the current available tools:
# Slope Finder:
Outputs the slope of a line segment formed by two given points.

Example Inputs and Outputs:
 
 -Point A(0, 0), Point B(2, 2) --> Slope of AB: 1/1
 
 -Point A(2, 3), Point B(4, 5) --> Slope of AB: 1/1
 
 -Point A(4, 7), Point B(6, -2) --> Slope of AB: -9/2
# Line Divider:
Outputs coordinates of point P, where point P divides the line segment formed by points A and B by the ratio X:Y.

Example Inputs and Outputs:
 
 -Point A(0, 0), Point B(2, 2), Ratio X:Y(1:1) --> Point P(1, 1)
 
 -Point A(2, 3), Point B(4, 5), Ratio X:Y(2:1) --> Point P(2.667, 3.667)
 
 -Point A(4, 7), Point B(6, -2), Ratio X:Y(2:3) --> Point P(5.2, 1.6)
# Perpendicular Bisector
Outputs the equation of the perpendicular bisector of the segment formed by points A and B in y = m * x + b form.

Example Inputs and Outputs:
 
 -Point A(0, 0), Point B(2, 2) --> Equation of perpendicular bisector: y = -x + 2
 
 -Point A(2, 3), Point B(4, 5) --> Equation of perpendicular bisector: y = -x + 7
 
 -Point A(4, 7), Point B(6, -2) --> Equation of perpendicular bisector: y = 2/9x + 1.389
# Distance Finder
Outputs the distance between two points in units.

Example Inputs and Outputs:
 
 -Point A(0, 0), Point B(2, 2) --> Distance between A and B: 2.828 units

 -Point A(2, 3), Point B(4, 5) --> Distance between A and B: 2.828 units
 
 -Point A(4, 7), Point B(6, -2) --> Distance between A and B: 9.22 units
# Circle Equation
Outputs the equation (in the standard form of (x - h)^2 + (y - k)^2 = r^2) of the circle formed with a center at (h, k) and either the radius or a point at (x, y) on the circle.

Example Inputs and Outputs (radius):
 
 -Center(0, 0), Radius(2) --> Equation of circle: (x - 0)^2 + (y - 0)^2 = 2^2 (4)
 
 -Center(2, 3), Radius(4) --> Equation of circle: (x - 2)^2 + (y - 3)^2 = 4^2 (16)
 
 -Center(4, 7), Radius(6) --> Equation of circle: (x - 4)^2 + (y - 7)^2 = 6^2 (36)

Example Inputs and Outputs (point on circle):

 -Center(0, 0), Point on circle(2, 2) --> Equation of circle: (x - 0)^2 + (y - 0)^2 = 2.828^2 (8)
 
 -Center(2, 3), Point on circle(4, 5) --> Equation of circle: (x - 2)^2 + (y - 3)^2 = 2.828^2 (8)
 
 -Center(4, 7), Point on circle(6, -2) --> Equation of circle: (x - 4)^2 + (y - 7)^2 = 9.22^2 (85)
