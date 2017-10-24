import org.json.simple.*;
import org.json.simple.parser.*;

import java.io.*;
import java.util.*;

// try this:
// JSONParser parser = new JSONParser();
// JSONArray json = (JSONArray) parser.parse(input);
// System.out.println(json.get(0));

/*

AngelList users frequently select locations from a dropdown, either to specify where they currently live, or to filter down job listings by location.

Let's say we have a JSON list of locations:

[
  {"id": 1, "name": "San Francisco Bay Area", "parent_id": null},
  {"id": 2, "name": "San Jose", "parent_id": 3},
  {"id": 3, "name": "South Bay", "parent_id": 1},
  {"id": 4, "name": "San Francisco", "parent_id": 1},
  {"id": 5, "name": "Manhattan", "parent_id": 6},
  {"id": 6, "name": "New York", "parent_id": null}
]
We'd like to generate a list of the locations, with sublocations grouped under their parents, and in alphabetical order. We want to indent sub-locations with a hyphen. So the resulting output for the above data would look like this:

New York
-Manhattan
San Francisco Bay Area
-San Francisco
-South Bay
--San Jose
Rules are:

Child locations should be immediately after their parent, with an extra dash prepended.
Locations of the same level of depth should be alphabetically sorted.
Assume that the actual list of locations will be longer (up to 100 locations), and have max up to 5 levels of depth.

 */

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        // Use this to print your answer
        List<Location> locations = makeLocationList(input);
        printList(locations, 0);
    }

    private static List<Location> makeLocationList(String input) throws Exception {
        List<Location> list = new ArrayList<>();
        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse(input);

        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject object = (JSONObject) jsonArray.get(i);
            Location location = Location.makeLocation(object);
            list.add(location);
        }
        addChildren(list);

        List<Location> parents = new ArrayList<>();
        for (Location location : list) {
            if (location.parentId == -1L) {
                parents.add(location);
            }
        }

        return parents;
    }

    private static void addChildren(List<Location> locations) {
        for (Location location : locations) {
            if (location.parentId != -1L) {
                Location parent = locations.get((int) location.parentId - 1);
                parent.children.add(location);
            }
        }
    }

    private static void printList(List<Location> locations, int level) {
        Collections.sort(locations);
        String prefix = getPrefix(level);
        for (Location location : locations) {
            System.out.println(prefix + location.name);
            List<Location> children = location.children;
            printList(children, level + 1);
        }
    }

    private static String getPrefix(int level) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < level; i++) {
            sb.append("-");
        }
        return sb.toString();
    }

}
