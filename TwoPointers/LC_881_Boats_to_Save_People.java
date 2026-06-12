package SlowAndFastPointers;

import java.util.Arrays;

public class LC_881_Boats_to_Save_People {
    public int numRescueBoats(int[] people, int limit) {
        int left = 0;
        int right = people.length - 1;
        Arrays.sort(people);
        int boatCounter = 0;

        while (left <= right) {
            if ((people[left] + people[right]) > limit) {
                boatCounter++;
                right--;
            } else {
                boatCounter++;
                right--;
                left++;
            }
        }
        return boatCounter;
    }

    public int numRescueBoatsOptimized(int[] people, int limit) {
        int left = 0;
        int right = people.length - 1;
        Arrays.sort(people);
        int boatCounter = 0;

        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            } 
                boatCounter++;
                right--;
        }
        return boatCounter;
    }
}
