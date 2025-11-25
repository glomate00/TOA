import java.util.*;

public class graphs {

    private static final int V = 8;
    private static final int INF = Integer.MAX_VALUE / 2;

    // Матрица смежности
    private static final int[][] G = {
            {0, 8, 1, 5, 3, 0, 0, 0},
            {8, 0, 0, 0, 6, 1, 0, 0},
            {1, 0, 0, 6, 0, 7, 0, 3},
            {5, 0, 6, 0, 0, 0, 0, 0},
            {3, 6, 0, 0, 0, 0, 9, 0},
            {0, 1, 7, 0, 0, 0, 3, 1},
            {0, 0, 0, 0, 9, 3, 0, 4},
            {0, 0, 3, 0, 0, 1, 4, 0}
    };

    // ===== КРУСКАЛ =====
    private static class Edge {
        int u, v, w;
        Edge(int u, int v, int w) { this.u = u; this.v = v; this.w = w; }
    }

    private static int[] parent = new int[V + 1];

    private static int findSet(int v) {
        if (parent[v] == v) return v;
        return parent[v] = findSet(parent[v]);
    }

    private static boolean unionSets(int a, int b) {
        a = findSet(a);
        b = findSet(b);
        if (a == b) return false;
        parent[b] = a;
        return true;
    }

    private static void runKruskal() {
        System.out.println("\n=== Алгоритм Крускала ===");

        // Собираем список рёбер
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            for (int j = i + 1; j < V; j++) {
                if (G[i][j] != 0) edges.add(new Edge(i + 1, j + 1, G[i][j]));
            }
        }

        // Сортировка по весу
        edges.sort(Comparator.comparingInt(e -> e.w));

        // Инициализация множеств
        for (int i = 1; i <= V; i++) parent[i] = i;

        int total = 0;
        int used = 0;

        for (Edge e : edges) {
            if (unionSets(e.u, e.v)) {
                System.out.printf("%d - %d : %d\n", e.u, e.v, e.w);
                total += e.w;
                used++;
                if (used == V - 1) break;
            }
        }

        System.out.println("Загальна вага МКД (Крускал): " + total);
    }

    // ===== ПРИМ =====
    private static void runPrim() {
        System.out.println("\n=== Алгоритм Пріма ===");

        boolean[] used = new boolean[V];
        used[0] = true;

        int total = 0;
        int edgesUsed = 0;

        while (edgesUsed < V - 1) {
            int best = INF, x = -1, y = -1;

            for (int i = 0; i < V; i++) {
                if (used[i]) {
                    for (int j = 0; j < V; j++) {
                        if (!used[j] && G[i][j] > 0 && G[i][j] < best) {
                            best = G[i][j];
                            x = i;
                            y = j;
                        }
                    }
                }
            }

            System.out.printf("%d - %d : %d\n", x + 1, y + 1, best);
            used[y] = true;
            total += best;
            edgesUsed++;
        }

        System.out.println("Загальна вага МКД (Прім): " + total);
    }

    // ===== MAIN =====
    public static void main(String[] args) {

        System.out.println("Матриця суміжності:");
        for (int i = 0; i < V; i++) {
            System.out.println(Arrays.toString(G[i]));
        }

        runPrim();
        runKruskal();
    }
}
