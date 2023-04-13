# canvas-drawer
A simple Java command-line tool that can draw straight lines and rectangles on a canvas

# How to run
It's recommended to build and run on an IDE such as IntelliJ

# Example output
```
Please enter one command from: 
"C w h" (Create a new canvas with width and height)
"L x1 y1 x2 y2" (Draw a line starting from (x1,y1) to (x2,y2))
"R x1 y1 x2 y2" (Draw a rectangle with upper left corner (x1,y1) and lower right corner (x2,y2))
"Q" (Quit)
Note: coordinates are 1-indexed with the origin at top left corner of canvas

C 20 10
----------------------
|                    |
|                    |
|                    |
|                    |
|                    |
|                    |
|                    |
|                    |
|                    |
|                    |
----------------------
L 1 1 8 1
----------------------
|XXXXXXXX            |
|                    |
|                    |
|                    |
|                    |
|                    |
|                    |
|                    |
|                    |
|                    |
----------------------
R 3 2 11 9
----------------------
|XXXXXXXX            |
|  XXXXXXXXX         |
|  X       X         |
|  X       X         |
|  X       X         |
|  X       X         |
|  X       X         |
|  X       X         |
|  XXXXXXXXX         |
|                    |
----------------------
R 18 8 20 10
----------------------
|XXXXXXXX            |
|  XXXXXXXXX         |
|  X       X         |
|  X       X         |
|  X       X         |
|  X       X         |
|  X       X         |
|  X       X      XXX|
|  XXXXXXXXX      X X|
|                 XXX|
----------------------
Q
Exiting programme

Process finished with exit code 0
```
