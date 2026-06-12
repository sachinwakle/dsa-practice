package SlidingWindow.VariableWindow;

import java.util.HashMap;
import java.util.Map;

public class LC_904_Fruit_Into_Baskets {
    public int totalFruitV2(int[] fruits) {
        int left = 0, right = 0;
        Map<Integer, Integer> fruitCounter = new HashMap<>();
        int k = 2;
        int max = Integer.MIN_VALUE;
        for (right = 0; right < fruits.length; right++) {
            fruitCounter.put(fruits[right], fruitCounter.getOrDefault(fruits[right], 0) + 1);
            while (fruitCounter.size() > k) {
                fruitCounter.put(fruits[left], fruitCounter.get(fruits[left]) - 1);
                if (fruitCounter.get(fruits[left]) == 0) {
                    fruitCounter.remove(fruits[left]);
                }
                left++;
            }
            max = Math.max(max, right - left + 1);

            
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }

    public int totalFruit(int[] fruits) {
        int left = 0, right = 0;
        int[] fruitCounter = new int[fruits.length];
        int k = 2;
        int max = Integer.MIN_VALUE;
        for (right = 0; right < fruits.length; right++) {
            fruitCounter[fruits[right]]++;
            while (size(fruitCounter) > k) {
                fruitCounter[fruits[left]]--;
                left++;
            }
            if (size(fruitCounter) == k) {
                max = Math.max(max, right - left + 1);
            }

        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }

    static int size(int[] arr) {
        int counter = 0;
        for (int i : arr) {
            if (i > 0) {
                counter++;
            }
        }
        return counter;
    }
}
