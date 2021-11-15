public class GraphRepresentationChecker {
    public Boolean has_eulercircuit(int[][] adj_matrix, Boolean directed) {
        int n = adj_matrix.length;

        if (directed) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (adj_matrix[i][j] != adj_matrix[j][i]) return false;
                }
            }

            return true;
        } else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (adj_matrix[i][j] % 2 != 0) return false;
                }
            }

            return true;
        }
    }

    public Boolean has_eulerpath(int[][] adj_matrix, Boolean directed) {
        int n = adj_matrix.length;
        int odd_count = 0;

        if (directed) {
            int out_minus_in = 0;
            int in_minus_out = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (adj_matrix[i][j] % 2 != 0) {
                        odd_count++;
                        out_minus_in += (adj_matrix[i][j] - adj_matrix[j][i]);
                        in_minus_out += (adj_matrix[j][i] - adj_matrix[i][j]);
                    }
                }
            }

            return odd_count == 2 && out_minus_in == 1 && in_minus_out == 1;
        } else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (adj_matrix[i][j] % 2 != 0) odd_count++;
                }
            }

            return odd_count == 0 || odd_count == 2;
        }
    }
}
