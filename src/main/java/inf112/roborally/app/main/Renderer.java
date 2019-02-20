package inf112.roborally.app.main;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import inf112.roborally.app.board.Board;
import inf112.roborally.app.exceptions.OutsideGridException;
import inf112.roborally.app.player.Player;
import inf112.roborally.app.tile.AbstractTile;
import inf112.roborally.app.tile.Floor;
import inf112.roborally.app.tile.Hole;
import inf112.roborally.app.tile.IBoardTile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Renderer {

    private ShapeRenderer render;
    private SpriteBatch batch;
    private Board board;
    private Player[] players;
    Texture playerTexture;
    Sprite playerSprite;

    public Renderer(Board board, Player[] players) {
        this.players = players;
        this.board   = board;
        render       = new ShapeRenderer();
        batch        = new SpriteBatch();

        //TODO: Player textures are in the Robot classes, so this is just temporary.
        playerTexture = new Texture("inf112/roborally/app/tile/Tank1.png");
        playerSprite = new Sprite(playerTexture);
        playerSprite.setSize(Main.TILE_SIZE, Main.TILE_SIZE);
    }

    /**
     * Draws every tile inside the board.
     * @throws OutsideGridException
     */
    public void drawBoard() throws OutsideGridException {
        batch.begin();
        for(int x = 0; x < board.getWidth(); x++) {
            for(int y = 0; y < board.getHeight(); y++) {
                LinkedList<IBoardTile> tiles = board.getGrid().getTiles(new Vector2(x,y));
                if(tiles == null || tiles.size() == 0) continue;

                Collections.sort(tiles);

                for (IBoardTile t : tiles) {
                    Sprite s = t.getSprite();
                    s.setCenter(0,0);
                    s.setPosition(x*Main.TILE_SIZE, y*Main.TILE_SIZE);
                    s.draw(batch);
                }
            }
        }
        batch.end();
    }

    public void drawPlayer() {
        batch.begin();

        for(Player p : players) {
            int x = (int) p.getPos().x;
            int y = (int) p.getPos().y;
            int rotation = p.getRotation();


            playerSprite.setPosition(x*Main.TILE_SIZE, y*Main.TILE_SIZE);
            playerSprite.setOriginCenter();
            playerSprite.setRotation(rotation);
            playerSprite.draw(batch);

            /**
            batch.end();
            render.begin(ShapeRenderer.ShapeType.Filled);
            render.setColor(0.5f,0.5f,0.5f, 1f);
            render.rect(x*Main.TILE_SIZE, y * Main.TILE_SIZE, Main.TILE_SIZE, Main.TILE_SIZE);
            render.end();
             */
        }
        batch.end();
    }

    public void drawGrid() {
        for(int x = 0; x < Main.GRID_WIDTH; x++) {
            for(int y = 0; y < Main.GRID_HEIGHT; y++) {
                drawRect(x*Main.TILE_SIZE, y * Main.TILE_SIZE, Main.TILE_SIZE);
            }
        }
    }

    private void drawRect(int x1, int x2, int size) {
        render.begin(ShapeRenderer.ShapeType.Line);
        render.setColor(1F, 0F, 1F, 1F); //GREY
        render.rect(x1, x2, size, size);
        render.end();
    }

    public void dispose() {
        batch.dispose();
        render.dispose();
    }

    public void drawEditorUI() {
        ArrayList<IBoardTile> tiles = new ArrayList<>();
        tiles.add(new Floor()); tiles.add(new Hole());

        batch.begin();

        int x = 0, y = 0;
        for (IBoardTile t : tiles) {
            Sprite s = t.getSprite();
            s.setCenter(0,0);
            s.setPosition(Main.TILE_SIZE*x, Main.WINDOW_HEIGHT - Main.TILE_SIZE);
            s.draw(batch);
            x++;
        }

        batch.end();
    }
}
