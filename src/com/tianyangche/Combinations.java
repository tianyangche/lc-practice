public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] f = new boolean[n];
        dfs(res, new ArrayList<>(), f, 0, k);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> curr, boolean[] f, int pos, int k) {
        if (curr.size() == k) {
            res.add(new ArrayList<Integer>(curr));
            return;
        }
        for (int i = pos; i < f.length; i++) {
            if (!f[i]) {
                f[i] = true;
                curr.add(i + 1);
                dfs(res, curr, f, i + 1, k);
                f[i] = false;
                curr.remove(curr.size() - 1);
            }
        }
    }
}
