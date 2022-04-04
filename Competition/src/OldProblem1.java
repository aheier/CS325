import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class OldProblem1
{
    // A set of legal numeric keys.
    private String[] keys;
    // A mapping from any key to its numeric index in the graph.
    private HashMap<String, Integer> keyIndices = new HashMap<>();
    // Adjacency matrix: graph[i][j] == true iff key[i] and key[j] differ by
    // exactly one digit.
    private boolean[][] graph;

    /**
     * Simple initiating main.
     * 
     * @param args Not used.
     */
    public static void main(String[] args)
    {
        (new OldProblem1()).solve();
    }

    /**
     * Reads in data, consisting of a set of legal keys and a number of queries.
     * Builds a graph out of the key-data, and then for each query (pair of
     * keys) determines if a legal path between the two exists in the graph, and
     * if so, the length of the shortest such path.
     */
    private void solve()
    {
        Scanner scan = new Scanner(System.in);
        int numKeys = scan.nextInt();
        int numQueries = scan.nextInt();

        keys = new String[numKeys];
        for (int k = 0; k < numKeys; k++)
        {
            keys[k] = scan.next();
            keyIndices.put(keys[k], k);
        }

        buildGraph();
        for (int q = 0; q < numQueries; q++)
        {
            String s1 = scan.next();
            String s2 = scan.next();
            int length = getMinSequenceLength(s1, s2);

            if (length != -1)
            {
                System.out.printf("Shortest legal sequence from %s to %s has length %d.\n", s1, s2, length);
            }
            else
            {
                System.out.printf("No legal sequence from %s to %s exists.\n", s1, s2);
            }
        }
        scan.close();
    }

    /**
     * Constructs a graph on the keys array. Keys are adjacent in the graph if
     * they differ by exactly one digit.
     */
    private void buildGraph()
    {
        graph = new boolean[keys.length][keys.length];
        for (int i = 0; i < keys.length - 1; i++)
        {
            for (int j = i + 1; j < keys.length; j++)
            {
                if (differByOne(keys[i], keys[j]))
                {
                    graph[i][j] = true;
                    graph[j][i] = true;
                }
            }
        }
    }

    /**
     * Uses breadth-first search to find the shortest path (if any exists)
     * between two key-strings.
     * 
     * @param s1 A numeric key-string.
     * @param s2 A distinct numeric key-string.
     * 
     * @return The length of the shortest path in the graph of key-strings from
     *         s1 to s2 (inclusive). Will be -1 if no such path exists (can
     *         occur because either s1 or s2 is not in the set of keys at all,
     *         or because no such path exists between existing key-nodes).
     */
    private int getMinSequenceLength(String s1, String s2)
    {
        if (keyIndices.containsKey(s1) && keyIndices.containsKey(s2))
        {
            int startIndex = keyIndices.get(s1);
            int endIndex = keyIndices.get(s2);

            HashMap<Integer, Integer> depthOf = new HashMap<>();
            depthOf.put(startIndex, 1);

            LinkedList<Integer> queue = new LinkedList<>();
            queue.add(startIndex);

            while ( !queue.isEmpty())
            {
                int node = queue.removeFirst();
                if (node == endIndex)
                {
                    return depthOf.get(node);
                }

                int nodeIndex = keyIndices.get(keys[node]);
                int nodeDepth = depthOf.get(node);
                for (int i = 0; i < graph[nodeIndex].length; i++)
                {
                    if (graph[nodeIndex][i] && !depthOf.containsKey(i))
                    {
                        queue.add(i);
                        depthOf.put(i, nodeDepth + 1);
                    }
                }
            }
        }
        return -1;
    }

    /**
     * Determines if two numeric strings differ by exactly 1 digit, in any
     * place. (Presumes the strings are of the same length.)
     * 
     * @param string1 One key-string.
     * @param string2 Another key-string.
     * 
     * @return true if and only if string1 and string2 differ by exactly one
     *         digit, in any place.
     */
    private boolean differByOne(String string1, String string2)
    {
        int differences = 0;
        for (int i = 0; i < string1.length(); i++)
        {
            if (string1.charAt(i) != string2.charAt(i))
            {
                differences++;
            }
        }

        return (differences == 1);
    }
}

