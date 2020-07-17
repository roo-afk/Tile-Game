#How to use:

Click on two tiles to remove shared elements. The main method is found inside the display class. This class contains
two static nested classes, AlertBox and Cell. The former displays a pop-up window at the end of the game and the latter
is used to create a grid of stackpanes that can be clicked on. The program takes no command line arguments, but the 
number of rows can easily be changed the static variable, ROWS, at the top of the display class.
It should be noted that, with my implementation, ROWS must be even and the static variable COLS must NOT be changed at
all. Otherwise, the board will not be set up properly. The checkWin() method works by computing the total number of 
pairs of the matching elements. Values of ROWS > 4 should work, but were not tested.

#Tools:

There's a for loop inside the handleClick() method along with a print statement. These can be used to the track the 
contents of the queue that tracks tile selection.





#Bugs:


There are two, one with tile selection and one with the score counter.

When clicking on a tile, it may not be entirely highlighted. This is likely due to cells overlapping each other.
With the score counter, it may improperly reset when ending on an entire tile, but it does properly reset when trying 
to select tiles with no matching elements.