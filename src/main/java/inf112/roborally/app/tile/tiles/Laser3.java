package inf112.roborally.app.tile.tiles;

public class Laser3 extends AbstractFunctionTile {

    public Laser3(int r) {
        super(r);
    }

    @Override
    public void execute(int RobotId) {
        //TODO finish
        System.err.println("Call to unimplemented method int" + this.getClass().toString());
    }

    @Override
    public int getRenderPriority() {
        return 100;
    }

    @Override
    public char getSymbol() {
        return 'c';
    }
}