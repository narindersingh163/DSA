package greedy;

import java.util.*;
import java.util.stream.Collectors;

public class ActivitySelection {

    public static void maxActivities(int[] start, int[] end){
        int maxAct = 1;
        List<Integer> list = new ArrayList<>();
        list.add(0);

        int lastEnd = end[0];
        for(int i = 1; i < end.length; i++){
            if(start[i] >= lastEnd){
                maxAct++;
                list.add(i);
                lastEnd = end[i];
            }
        }

        System.out.println("Max Activities that can be done are " + maxAct);
        list.stream().map(n -> "A" + n).forEach(n -> System.out.print(n + " "));
    }

    /**
     * If the activities are not sorted on the ending time basis.
     * @param start timing
     * @param end timing
     */
    public static void maxActivitiesII(int[] start , int[] end){
        int[][] activities = new int[start.length][3];//3 columns
        for(int i = 0; i < start.length; i++){
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        Arrays.sort(activities, Comparator.comparingDouble(n -> n[2]));

        List<Integer> list = new ArrayList<>();
        int maxAct = 1;
        list.add(activities[0][0]);
        int lastEnd = activities[0][2];
        for(int i = 1; i < activities.length; i++){
            if(activities[i][1] >= lastEnd){
                maxAct++;
                list.add(activities[i][0]);
                lastEnd = activities[i][2];
            }
        }

        list.stream().map(n -> "A" + n).forEach(n -> System.out.print(n + " "));
    }
    public static void main(String[] args) {
        int[] start = {1,3,0,5,8,5};
        int[] end =   {2,4,6,7,9,9};

        maxActivities(start, end);
        int[] start1 = { 5, 8, 5, 1, 3, 0 };
        int[] end1 =   { 7, 9, 9, 2, 4, 6 };
        System.out.println();
        maxActivitiesII(start1, end1);
    }
}
