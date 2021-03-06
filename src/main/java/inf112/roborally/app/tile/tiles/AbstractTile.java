package inf112.roborally.app.tile.tiles;

import com.badlogic.gdx.graphics.g2d.Sprite;
import inf112.roborally.app.sprite.SpriteLoader;
import inf112.roborally.app.tile.IBoardTile;

public abstract class AbstractTile implements IBoardTile {

    protected int rotation;

    protected AbstractTile(int r) {
        rotation = r;
    }

    @Override
    public int compareTo(IBoardTile o) {
        if (getRenderPriority() < o.getRenderPriority()) return -1;
        else if (getRenderPriority() > o.getRenderPriority()) return 1;
        return 0;
    }

    /**
     * Not testable
     *
     * @return sprite
     */
    @Override
    public Sprite getSprite() {
        return SpriteLoader.fetchSprite(this);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

    public void setRotation(int rotation) {
        this.rotation = Math.floorMod(rotation, 360);
    }

    public int getRotation() {
        return rotation;
    }
}
