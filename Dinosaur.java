public class Dinosaur {
    private double xpos; // the x position of the dinosaur
    private double ypos; // the y position of the dinosaur


    // take in key input, update position, and draw
    public Dinosaur() { // creates a dinosaur object with initial x and y positon
        xpos = 0.3;
        ypos = 0.189;

    }

    public double getX() { // return the x position
        return xpos;
    }

    public double getY() { // return the y position
        return ypos;
    }


    public double jumpY(double i) { //for a given time return the appropriate y position of
        // parabolic jump in gravity
        double vi = 2.8; // initial velocity
        double g = -7;  //  gravitational force constant
        double ynaught = 0.1; // initial y position
        ypos = (0.5 * g * Math.pow(i, 2)) + (vi * i) + ynaught; // kinematics equation
        return ypos;
    }


    public static void main(String[] args) {

        Dinosaur dino = new Dinosaur(); // create a dinosaur object
        System.out.println("xpos: " + dino.getX()); // check get x and get y
        System.out.println("y pos: " + dino.getY());
        for (double i = 0; i < 1; i += 0.1) { // check that y positions are parabolic for a jump
            if (dino.jumpY(i) > 0)
                System.out.println("time: " + i + " ypos: " + dino.jumpY(i));
        }
    }
}


