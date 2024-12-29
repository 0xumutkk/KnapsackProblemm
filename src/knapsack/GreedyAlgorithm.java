package knapsack;
import java.util.*;

public class GreedyAlgorithm {

    public Solution solve(KnapsackProblem problem) {
        List<Item> items = new ArrayList<>(problem.getItems());

        // Eşyaları birim kârlarına göre azalan sıraya göre sırala
        items.sort(Comparator.comparingDouble(Item::getUnitPrice).reversed());

        int totalWeight = 0;
        int totalProfit = 0;
        List<Item> selectedItems = new ArrayList<>();

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

