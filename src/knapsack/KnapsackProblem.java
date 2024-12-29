package knapsack;

import java.util.List;

public class KnapsackProblem {
    private int maxWeight;
    private List<Item> items;

    public KnapsackProblem(int maxWeight, List<Item> items) {
        this.maxWeight = maxWeight;
        this.items = items;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public List<Item> getItems() {
        return items;
    }
}
