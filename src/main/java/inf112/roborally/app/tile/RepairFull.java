package inf112.roborally.app.tile;

import inf112.roborally.app.player.Player;

public class RepairFull extends AbstractFunctionTile {

    public RepairFull(int r) {
        super(r);
    }

    @Override
    public int getRenderPriority() {
        return 2;
    }

    @Override
    public char getSymbol() {
        return 'A';
    }

    @Override
    public void execute(Player player) {
        // TODO: Make sure this does what it is supposed to do
        player.resetDamage();
    }
}