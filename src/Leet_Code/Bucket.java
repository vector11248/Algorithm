package Leet_Code;
import java.util.*;


public class Bucket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] b = new int[3];
        for(int i = 0; i < 3; i++)
            b[i] = sc.nextInt();
        Arrays.sort(b);
        int t = sc.nextInt();
        if(t > b[2]) {
            System.out.println(-1);
            return;
        }
        System.out.println(search(b, t));
    }

    public static int search(int[] b, int t) {
        int[][][] dp = new int[b[0] + 1][b[1] + 1][b[2] + 1];
        dp[0][0][b[2]] = 1;
        dp[0][b[1]][0] = 1;
        dp[b[0]][0][0] = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{b[0], 0, 0});
        q.add(new int[]{0, b[1], 0});
        q.add(new int[]{b[0], 0, b[2]});
        while(q.size() > 0) {
            int[] tmp = q.poll();
            if(tmp[0] == t || tmp[1] == t|| tmp[2] == t)
                return dp[tmp[0]][tmp[1]][tmp[2]];
            if(tmp[0] < b[0]) {
                if(dp[b[0]][tmp[1]][tmp[2]] == 0) {
                    dp[b[0]][tmp[1]][tmp[2]] = dp[tmp[0]][tmp[1]][tmp[2]] + 1;
                    q.offer(new int[]{b[0], tmp[1], tmp[2]});
                }
                if(tmp[1] > 0) {
                    int min = Math.min(b[0] - tmp[0], tmp[1]);
                    if(min > 0 && dp[tmp[0] + min][tmp[1] - min][tmp[2]] == 0) {
                        dp[tmp[0] + min][tmp[1] - min][tmp[2]] = dp[tmp[0]][tmp[1]][tmp[2]] + 1;
                        q.offer(new int[]{tmp[0] + min, tmp[1] - min, tmp[2]});
                    }
                }
                if(tmp[2] > 0) {
                    int min = Math.min(b[0] - tmp[0], tmp[2]);
                    if(min > 0 && dp[tmp[0] + min][tmp[1]][tmp[2] - min] == 0) {
                        dp[tmp[0] + min][tmp[1]][tmp[2] - min] = dp[tmp[0]][tmp[1]][tmp[2]] + 1;
                        q.offer(new int[]{tmp[0] + min, tmp[1], tmp[2] - min});
                    }
                }
            }
            if(tmp[1] < b[1]) {
                if(dp[tmp[0]][b[1]][tmp[2]] == 0) {
                    dp[tmp[0]][b[1]][tmp[2]] = dp[tmp[0]][tmp[1]][tmp[2]] + 1;
                    q.offer(new int[]{tmp[0], b[1], tmp[2]});
                }
                if(tmp[0] > 0) {
                    int min = Math.min(b[1] - tmp[1], tmp[0]);
                    if(min > 0 && dp[tmp[0] - min][tmp[1] + min][tmp[2]] == 0) {
                        dp[tmp[0] - min][tmp[1] + min][tmp[2]] = dp[tmp[0]][tmp[1]][tmp[2]] + 1;
                        q.offer(new int[]{tmp[0] - min, tmp[1] + min, tmp[2]});
                    }
                }
                if(tmp[2] > 0) {
                    int min = Math.min(b[1] - tmp[1], tmp[2]);
                    if(min > 0 && dp[tmp[0]][tmp[1] + min][tmp[2] - min] == 0) {
                        dp[tmp[0]][tmp[1] + min][tmp[2] - min] = dp[tmp[0]][tmp[1]][tmp[2]] + 1;
                        q.offer(new int[]{tmp[0], tmp[1] + min, tmp[2] - min});
                    }
                }
            }
            if(tmp[2] < b[2]) {
                if(dp[tmp[0]][tmp[1]][b[2]] == 0) {
                    dp[tmp[0]][tmp[1]][b[2]] = dp[tmp[0]][tmp[1]][tmp[2]] + 1;
                    q.offer(new int[]{tmp[0], tmp[1], b[2]});
                }
                if(tmp[0] > 0) {
                    int min = Math.min(b[2] - tmp[2], tmp[0]);
                    if(min > 0 && dp[tmp[0] - min][tmp[1]][tmp[2] + min] == 0) {
                        dp[tmp[0] - min][tmp[1]][tmp[2] + min] = dp[tmp[0]][tmp[1]][tmp[2]] + 1;
                        q.offer(new int[]{tmp[0] - min, tmp[1], tmp[2] + min});
                    }
                }
                if(tmp[1] > 0) {
                    int min = Math.min(b[2] - tmp[2], tmp[1]);
                    if(min > 0 && dp[tmp[0]][tmp[1] - min][tmp[2] + min] == 0) {
                        dp[tmp[0]][tmp[1] - min][tmp[2] + min] = dp[tmp[0]][tmp[1]][tmp[2]] + 1;
                        q.offer(new int[]{tmp[0], tmp[1] - min, tmp[2] + min});
                    }
                }
            }
            if(tmp[0] > 0 && tmp[1] != 0 && tmp[2] != 0 && dp[0][tmp[1]][tmp[2]] == 0) {
                dp[0][tmp[1]][tmp[2]] = dp[tmp[0]][tmp[1]][tmp[2]] + 1;
                q.offer(new int[]{0, tmp[1], tmp[2]});
            }
            if(tmp[0] > 0 && tmp[0] != 0 && tmp[2] != 0 && dp[tmp[0]][0][tmp[2]] == 0) {
                dp[tmp[0]][0][tmp[2]] = dp[tmp[0]][tmp[1]][tmp[2]] + 1;
                q.offer(new int[]{tmp[0], 0, tmp[2]});
            }
            if(tmp[2] > 0 && tmp[0] != 0 && tmp[1] != 0 && dp[tmp[0]][tmp[1]][2] == 0) {
                dp[tmp[0]][tmp[1]][0] = dp[tmp[0]][tmp[1]][tmp[2]] + 1;
                q.offer(new int[]{tmp[0], tmp[1], 0});
            }

        }
        return -1;
    }
}