package inf112.roborally.app.tile;

import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Master interface of all tiles to be placed on the board
 *
 * @author RakNoel
 * @version 1.0
 * @since 07.02.19
 */
public interface IBoardTile extends Comparable<IBoardTile> {

    /**
     * Method used to determine which order tiles should be rendered
     * @return Integer value. The lower the value the sooner to draw on map
     */
    int getRenderPriority();
    Sprite getSprite();

    /**
     * Each tile has a symbol tied to it, used for loading and saving maps.
     * @return The char representing the tile.
     */
    char getSymbol();

    String toString();

    int getRotation();
    void setRotation(int r);

}
