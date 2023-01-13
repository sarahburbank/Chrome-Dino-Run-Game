public class Cactus {
    // this class controls the movement of the cacti across the screen with moveX()
    // and allows their initial positions to be randomly generated with setPosI().
    private double xpos; // x position of a cactus
    private double ypos; // y position of a cactus
    private double vi; // initial velocity
    private double xpos1; // initial x position

    public Cactus() { // create a cactus object with an initial x and y position
        xpos = 0.0;
        ypos = 0.189;
        xpos1 = 1;

    }

    public double getXC() { // return the x position
        return xpos;
    }

    public double getYC() { // return the y position
        return ypos;
    }

    public void setPosI(double xpos2) { // store an x position, to be used for random
        // generation later
        this.xpos1 = xpos2;

    }

    public double moveX(double xpos2, double v0, double i) { // move the cactus based on a time i
        // an initial position x pos1, and a velocity v0
        this.xpos1 = xpos2;
        xpos = xpos2 + v0 * i; // kinematics equation
        return xpos; // return the x position at a given time
    }


    public static void main(String[] args) {
        Cactus jack = new Cactus(); // create a cactus object
        System.out.println("xpos: " + jack.getXC()); // check get x and get y
        System.out.println("y pos: " + jack.getYC());
        for (double i = 0; i < 0.6; i += 0.1) { // check that x positions are correct for a cactus
            // moving across the screen for time .5 units
            System.out.println("time: " + i + " ypos: " + jack.moveX(1, -2, i));
        }

    }
}
