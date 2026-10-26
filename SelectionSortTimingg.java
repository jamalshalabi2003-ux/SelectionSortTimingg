package selectionsorttimingg;

import java.util.Random;

public class SelectionSortTimingg {

    // دالة ترجع الوقت الحالي بالنانو ثانية
    static long readTime() {
        return System.nanoTime();
    }

    // Selection Sort
    // الفكرة: ندور على أصغر عنصر ونحطه في أول مكان، ثم نكرر على الباقي
    static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {

            int minIndex = i;                    // نفترض أن أصغر عنصر هو الموجود في i

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {    // لقينا عنصر أصغر
                    minIndex = j;
                }
            }

            // نبدل أصغر عنصر مع العنصر الموجود في المكان i
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static void main(String[] args) {

        int size = 100000;                       // مية ألف عنصر
        int[] arr = new int[size];
        Random random = new Random();

        // نملا المصفوفة بأرقام عشوائية
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(1000000);
        }

        // ===== السيناريو 1: مصفوفة عشوائية =====
        long startTime = readTime();             // نقرا الوقت قبل الترتيب
        selectionSort(arr);                      // نرتب
        long endTime = readTime();               // نقرا الوقت بعد الترتيب
        long result1 = endTime - startTime;      // نطرحهم من بعض
        System.out.println("Scenario 1 (random array): " + result1 + " ns");

        // ===== السيناريو 2: مصفوفة مرتبة أصلاً =====
        // المصفوفة arr صارت مرتبة بعد السيناريو 1
        startTime = readTime();
        selectionSort(arr);
        endTime = readTime();
        long result2 = endTime - startTime;
        System.out.println("Scenario 2 (sorted array): " + result2 + " ns");
    }
}