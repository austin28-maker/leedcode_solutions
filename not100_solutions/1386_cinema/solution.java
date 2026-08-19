class Solution {
    private boolean isOk(int l, int r, Set<Integer> colSet) {
        for (int i = l; i <= r; i++) {
            if (colSet.contains(i)) {
                return false;
            }
        }
        return true;
    }

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            if (!map.containsKey(row)) {
                map.put(row, new HashSet<>());
            }
            map.get(row).add(col);
        }

        int ans = 2 * n;
        for (Integer row : map.keySet()) { // .keySet() 返回所有行号
            Set<Integer> colSet = map.get(row); // .get(row) 返回当前行的已预约座位号
            int count = 0;
            if (isOk(2, 5, colSet)) {
                count++;
                if (isOk(6, 9, colSet)) {
                    count++;
                }
            } else {
                if (isOk(4, 7, colSet)) {
                    count++;
                } else {
                    if (isOk(6, 9, colSet)) {
                        count++;
                    }
                }
            }

            int diff = 2 - count;
            ans -= diff;
        }

        return ans;
    }
}