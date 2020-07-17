/**
 * @author Ronald Wood
 * Class to keep track of tiles that contain elements, where each element has a shape and color
 */
public class Tile {

    private Shapes elementShape1;
    private Shapes elementShape2;
    private Shapes elementShape3;
    private Colors elementColor1;
    private Colors elementColor2;
    private Colors elementColor3;

    /**
     * Set a tile's shapes
     * @param shape1 Tile's first shape
     * @param shape2 Tile's second shape
     * @param shape3 Tile's third shape
     */
    public Tile(Shapes shape1, Shapes shape2, Shapes shape3){
        setElementShape1(shape1);
        setElementShape2(shape2);
        setElementShape3(shape3);

    }

    /**
     * Returns a tile's first shape
     * @return A tile's first shape
     */
    public Shapes getElementShape1() {
        return elementShape1;
    }

    private void setElementShape1(Shapes elementShape1) {
        this.elementShape1 = elementShape1;
    }

    /**
     * Returns a tile's second shape
     * @return A tile's second shape
     */
    public Shapes getElementShape2() {
        return elementShape2;
    }

    private void setElementShape2(Shapes elementShape2) {
        this.elementShape2 = elementShape2;
    }

    /**
     * Returns a tile's third shape
     * @return A tile's third shape
     */
    public Shapes getElementShape3() {
        return elementShape3;
    }

    private void setElementShape3(Shapes elementShape3) {
        this.elementShape3 = elementShape3;
    }

    /**
     * Get a tile's first color
     * @return
     */
    public Colors getElementColor1() {
        return elementColor1;
    }

    /**
     * Set the first shape's color
     * @param elementColor1 color to be set
     */
    public void setElementColor1(Colors elementColor1) {
        this.elementColor1 = elementColor1;
    }

    /**
     * Get the second color
     * @return the second color
     */
    public Colors getElementColor2() {
        return elementColor2;
    }

    /**
     * Set the second color
     * @param elementColor2 the color to set
     */
    public void setElementColor2(Colors elementColor2) {
        this.elementColor2 = elementColor2;
    }

    /**
     * Get the third color
     * @return  the third color
     */
    public Colors getElementColor3() {
        return elementColor3;
    }

    /**
     * Set the third color
     * @param elementColor3 The color to be set
     */
    public void setElementColor3(Colors elementColor3) {
        this.elementColor3 = elementColor3;
    }

    /**
     * Used to print a tile
     * @return String representing a tile
     */
    public String toString(){
        return getElementShape1() + " " + getElementShape2() + " " + getElementShape3() + " " + getElementColor1()
            + " " + getElementColor2() + " " + getElementColor3();

    }

}
