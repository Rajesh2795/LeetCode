import classes.Algo.*;
import classes.DS.*;
import classes.utill.Graph;
import java.util.Arrays;


public class Main {

    public static void main(String[] args) {
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        int n = 4;
        int k = 3;

        NetworkDelayTime networkDelayTime = new NetworkDelayTime();
        System.out.println(networkDelayTime.networkDelayTime(times, n, k));
    }
}
