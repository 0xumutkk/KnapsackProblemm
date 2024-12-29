package knapsack;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static KnapsackProblem readInputFile(String fileName) throws IOException {
        // Try-with-resources yapısı kullanılarak BufferedReader oluşturulur
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                Utils.class.getClassLoader().getResourceAsStream(fileName)))) {

            // İlk satırı oku
            String firstLine = reader.readLine();
            if (firstLine == null || firstLine.trim().isEmpty()) {
                throw new IllegalArgumentException("Dosya boş veya ilk satır eksik: " + fileName);
            }

            // İlk satırdaki eşya sayısı ve kapasiteyi ayıkla
            String[] firstLineSplit = firstLine.trim().split(" ");
            if (firstLineSplit.length < 2) {
                throw new IllegalArgumentException("İlk satırda yeterli veri yok: " + fileName);
            }
            int n = Integer.parseInt(firstLineSplit[0]);  // Eşya sayısı
            int maxWeight = Integer.parseInt(firstLineSplit[1]);  // Çanta kapasitesi

            // Eşyaları oku
            List<Item> items = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String line = reader.readLine();
                if (line == null || line.trim().isEmpty()) {
                    throw new IllegalArgumentException("Eşya verisi eksik: " + fileName + ", Satır " + (i + 2));
                }

                String[] itemData = line.trim().split(" ");
                if (itemData.length < 2) {
                    throw new IllegalArgumentException("Eşya verisinde eksik bilgi: " + fileName + ", Satır " + (i + 2));
                }

                // Kâr ve ağırlık değerlerini kontrol et
                int profit = Integer.parseInt(itemData[0]);
                int weight = Integer.parseInt(itemData[1]);

                if (profit < 0 || weight < 0) {
                    throw new IllegalArgumentException("Negatif kâr veya ağırlık: " + fileName + ", Satır " + (i + 2));
                }

                items.add(new Item(profit, weight));
            }

            // KnapsackProblem nesnesini döndür
            return new KnapsackProblem(maxWeight, items);
        } catch (NullPointerException e) {
            throw new FileNotFoundException("Kaynak dosya bulunamadı. Lütfen '" + fileName
                    + "' dosyasının src/resources klasöründe olduğundan emin olun.");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Dosya içeriği beklenen formatta değil: " + fileName);
        }
    }
}
