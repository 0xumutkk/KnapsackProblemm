package knapsack;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        String[] testFiles = {"test.in", "test2.in", "test3.in"};

        for (String fileName : testFiles) {
            try {
                System.out.println("\n=== Dosya: " + fileName + " ===");
                KnapsackProblem problem = Utils.readInputFile(fileName);

                // Greedy algoritmayı çalıştırma
                GreedyAlgorithm greedyAlgorithm = new GreedyAlgorithm();
                Solution greedySolution = greedyAlgorithm.solve(problem);
                System.out.println("Greedy Algoritmanın Toplam Kârı: " + greedySolution.getTotalProfit());

                // Rastgele algoritmayı çalıştırma ve istatistikleri hesaplama
                RandomAlgorithm randomAlgorithm = new RandomAlgorithm();
                int betterCount = 0;
                int totalSolutions = 1000000;
                int minProfit = Integer.MAX_VALUE;
                int maxProfit = Integer.MIN_VALUE;
                int totalProfit = 0;

                for (int i = 0; i < totalSolutions; i++) {
                    Solution randomSolution = randomAlgorithm.solve(problem);
                    minProfit = Math.min(minProfit, randomSolution.getTotalProfit());
                    maxProfit = Math.max(maxProfit, randomSolution.getTotalProfit());
                    totalProfit += randomSolution.getTotalProfit();

                    if (randomSolution.getTotalProfit() > greedySolution.getTotalProfit()) {
                        betterCount++;
                    }
                }

                double averageProfit = totalProfit / (double) totalSolutions;
                System.out.println("Rastgele Algoritma İstatistikleri:");
                System.out.println("Minimum: " + minProfit);
                System.out.println("Ortalama: " + averageProfit);
                System.out.println("Maksimum: " + maxProfit);
                System.out.println("Rastgele çözümlerin Greedy'den iyi olduğu durumlar: " + betterCount + "/" + totalSolutions);
            } catch (IOException e) {
                System.err.println("Dosya okunurken hata oluştu: " + e.getMessage());
            }
        }
    }
}
