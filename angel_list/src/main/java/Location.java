import org.json.simple.*;

import java.util.ArrayList;
import java.util.List;

public class Location implements Comparable<Location> {
    long id;
    long parentId;
    String name;
    List<Location> children;

    public Location(long id, long parentId, String name) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.children = new ArrayList<>();
    }

    public int compareTo(Location o) {
        return (this.name.compareTo(o.name));
    }

    public static Location makeLocation(JSONObject json) {
        long id = (long) json.get("id");
        long parentId = -1;
        if (json.get("parent_id") != null) {
            parentId = (long) json.get("parent_id");
        }
        String name = (String) json.get("name");
        return new Location(id, parentId, name);
    }

}
