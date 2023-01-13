public class Game {

    // this class draws the cactus and dinosaur objects, allowing the user to jump the
    // dinosaur over the cactus objects with the space bar.
    // It uses booleans in runCondition() to check if the rules of
    // the game are being followed. It allows each consecutive cactus to have a faster velocity and
    // generates them at random distances outside of the window. It prints a message and score when
    // the game has been lost.
    private boolean keepRunning; // boolean to tell if dinosaur has hit cactus
    private Cactus cac; // cactus object
    private Dinosaur dino; // dinosaur object

    public Game() {  // invoke game constructor with cactus and dinosaur object
        cac = new Cactus();
        dino = new Dinosaur();
    }

    public boolean runCondition() { // stop game if dinosaur hits cactus
        if (cac.getXC() + 0.05 <= dino.getX() - 0.03 || cac.getXC() - 0.05 >= dino.getX() + 0.03) {
            keepRunning
                    = true; // if the x positions dont overlap in a range then the game can keep running
        }
        else if (cac.getXC() + 0.05 >= dino.getX() - 0.05
                || cac.getXC() - 0.05
                <= dino.getX() + 0.05) { // if the x positions overlap in a range check y
            if (cac.getYC() + 0.08 >= dino.getY()
                    - 0.08) { // if the y positions overlap in this range the dinosaur has hit the cactus
                keepRunning = false; // stop game
            }
            else {
                keepRunning = true;
            }
            return keepRunning;
        }
        return keepRunning; // return game state
    }

    public void runGame() { /// operates the display of the game
        double i = 0; // time incrementer
        double d = 0; // time incrementer
        StdDraw.setXscale(0, 1); // initialize screen
        StdDraw.setYscale(0, 1);
        StdDraw.enableDoubleBuffering(); // allow double buffering
        double dinoY = 0.189; // initialize dinosaur position
        double vo = -0.3; // initial velocity moving to the right
        double j = 0; // score counter
        double startpos = 1;
        StdDraw.enableDoubleBuffering();

        while (runCondition()) { // while the dinosaur has not run into the cactus

            // controls cactus behavior
            j += 0.1;  // increment score
            if (i < 6) {  // if the cactus time counter will not give a position off the screen
                i += 0.06; // increment it to give a new position

            }
            else {
                i = 0; // if the cactus time counter will give a position off the screen reset
                // it to draw a new cactus on the right side
                double xcac = StdRandom.uniform(1, 3);
                cac.setPosI(xcac);
                startpos = xcac;
            }

            double xcac = cac.moveX(startpos, vo,
                                    i); // *** NOT RANDOM was causing flicker resetting in between
            if (xcac < 0
                    && xcac > -.06) { // once the cactus is off the screen give a faster velocity
                vo -= 0.05;
            }
            //StdOut.println("start " + startpos + " i " + i + " x pos " + cac.getXC()); testing statement


            // controls dinosaur behavior
            if (StdDraw.isKeyPressed(32) && d < 0.840) {  // if the space bar is pressed and the
                // dinosaur has not completed a jump start jump behavior
                // source: https://www.loom.com/share/9fc900e953b64543a595ff3045abf930
                d = 0.061; // give an initial d to trigger the jump behavior
            }

            if (d > 0.06
                    && d < 0.840) { // if a jump has just been initialized and not yet completed
                // ie d > .840
                dinoY = dino.jumpY(d); // give appropriate y position for that time (d) in the jump
                d += 0.06; // increment d
            }
            else { // if not injump behavior the y position is on the ground, d = 0,
                dinoY = 0.189;
                d = 0;
                // source  https://introcs.cs.princeton.edu/java/stdlib/javadoc/StdDraw.html
            }
            StdDraw.picture(0.4, 0.4, "rexhouse.png"); // draw the background between every
            // time a picture is drawn to clear the screen
            StdDraw.picture(0.3, dinoY,
                            "reddino3.png");  // draw dinosaur and cactus objects based on
            // given positions
            StdDraw.picture(xcac, 0.2, "cactry3.png");
            StdDraw.show(); // show drawings
            StdDraw.pause(20);


        }

        System.out.println("Ouch! You lost :("); // tell user they have lost when loop is exited
        System.out.println("Your score is: " + j);  // show score
    }


    public static void main(String[] args) {
        Game game1 = new Game(); // create a game object
        game1.runGame(); // start game
    }
}
