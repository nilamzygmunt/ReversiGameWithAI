public class Position {
    static Position[][] allPositions;

    private Position(int posX, int posY)
    {
        this.posX = posX;
        this.posY =posY;
    }

    public static Position getPosition(int posX, int posY)
    {
        if(allPositions[posX][posY].posX == posX && allPositions[posX][posY].posY == posY)
            return allPositions[posX][posY];
        else return new Position(posX, posY);
    }

    static void initializeAllPositions(int height, int width)
    {
        allPositions = new Position[width][height];
        for(int i =0; i < width; i++)
        {
            for(int j = 0; j < height; j++)
            {

                allPositions[i][j] = new Position(i, j);
            }
        }
    }
    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    private int posX;
    private int posY;

//    @Override
//    public boolean equals(Object o) {
//        if (o == this) {
//            return true;
//        }
//
//        /* Check if o is an instance of Complex or not
//          "null instanceof [type]" also returns false */
//        if (!(o instanceof Position)) {
//            return false;
//        }
//        Position pos = (Position) o;
//        return this.posY == pos.getPosY() && this.posX == getPosX();
//    }

    @Override
    public String toString() {
        return "X: "+posX+ " Y: "+posY;
    }
}
