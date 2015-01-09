import ch.bfh.shooter.Sprites.Map;
import ch.bfh.shooter.assets.AssetManager;
import org.junit.Test;

/**
 * Created by jan on 31/10/14.
 */
public class AssetManagerTest {
    @Test
    public void parseMapTest() {
        Map.TileType[][] map = AssetManager.parseMapFile("/tilemap/level1.mapconfig");
        System.out.println(map);
    }
}
