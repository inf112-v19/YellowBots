package inf112.roborally.app.tile;

import inf112.roborally.app.player.Player;

public class Repair extends AbstractFunctionTile {

    public Repair(int r) {
        super(r);
    }

    @Override
    public int getRenderPriority() { return 2; }

    @Override
    public char getSymbol() {
        return 'X';
    }

    @Override
    public void execute(Player[] player) {
        // TODO: Make sure this does what it is supposed to do
        player[0].resetDamage();
    }
}