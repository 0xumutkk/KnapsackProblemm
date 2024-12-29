package knapsack;

import java.util.*;


public class RandomAlgorithm {

    public Solution solve(KnapsackProblem problem) {
        Random rand = new Random();
        List<Item> items = new ArrayList<>(problem.getItems());
        List<Item> selectedItems = new ArrayList<>();
        int totalWeight = 0;
        int totalProfit = 0;

        Collections.shuffle(items);  // mix of items

        for (Item item : items) {
            if (totalWeight + item.getWeight() <= problem.getMaxWeight()) {
                selectedItems.add(item);
                totalWeight += item.getWeight();
                totalProfit += item.getProfit();
            }
        }

        return new Solution(selectedItems, totalProfit, totalWeight);
    }
}
