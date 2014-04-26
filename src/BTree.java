import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Created by Seth on 4/25/2014.
 */
public class BTree {
    HashMap<Integer, Nodule> map;

    public BTree() {
        map = new HashMap<Integer, Nodule>();
    }

    public void addEdge (int a, int b) {
        Nodule nodeA = null;
        Nodule nodeB = null;
        if (map.containsKey((Integer)a)) {
            nodeA = map.get((Integer)a);
        } else {
            nodeA = new Nodule(a);
            map.put((Integer)a, nodeA);
        }

        if (map.containsKey((Integer)b)) {
            nodeB = map.get((Integer)b);
        } else {
            nodeB = new Nodule(b);
            map.put((Integer)b, nodeB);
        }

        nodeA.addConnection(nodeB);
        nodeB.addConnection(nodeA);
    }

    public int pruneToFullBinary() {
        if (map.size() == 2)
            return 1;
        if (map.size() == 3)
            return 0;
        if (map.size() == 4)
            return 1;

        int y = 0;
        // Determine how many nodes need to be removed, and assign that number to y.
        return y;
    }

    private class Nodule {
        int number;
        LinkedList<Nodule> connections;
        public Nodule(int number) {
            this.number = number;
            connections = new LinkedList<Nodule>();
        }
        void addConnection(Nodule node) {
            connections.add(node);
        }
    }
}
