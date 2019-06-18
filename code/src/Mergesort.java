import java.io.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Arrays;

public class Mergesort {

  int[] arr;
  int[] helper;
  int len;

  private int[] merge (int[] first, int[] second, int[] merged) {
    int iFirst = 0;
    int iSecond = 0;
    int iMerged = 0;

    while (iFirst < first.length && iSecond < second.length) {
      if(first[iFirst] <= second[iSecond]) {
        merged[iMerged] = first[iFirst];
        iFirst++;
      } else {
        merged[iMerged] = second[iSecond];
        iSecond++;
      }
      iMerged++;
    }

    System.arraycopy(first, iFirst, merged, iMerged, first.length - iFirst);
    System.arraycopy(second, iSecond, merged, iMerged, second.length - iSecond);
    return merged;
  }

  private int[] mergeSort(int[] arr) {
    if (arr.length <= 1) {
      return arr;
    }

    int[] first = new int[arr.length / 2];
    int[] second = new int[arr.length - first.length];

    System.arraycopy(arr, 0, first, 0, first.length);
    System.arraycopy(arr, first.length, second, 0, second.length);

    mergeSort(first);
    mergeSort(second);
    merge(first, second, arr);

    return arr;
  }

  private int[] importArray(String path, int arrlength) {
    System.out.println("Importing array ...");
    int[] arr = new int[arrlength];
    try {
      File randomfile = new File(path);
      BufferedReader br = new BufferedReader(new FileReader(randomfile));
      String readLine = "";
      for(int i = 0; i < arrlength; i++) {
        arr[i] = Integer.parseInt(br.readLine());
      }
      return arr;
    } catch (IOException e) {
      e.printStackTrace();
      return arr;
    }
  }

  private void writeToFile(String str, File file) {
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
      writer.append(str + "\n");
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main (String args[]) {
    Mergesort ms = new Mergesort();
    int interval = Integer.parseInt(args[0]);
    int limit = Integer.parseInt(args[1]);
    String random_file_path = args[2];
    String output_file = args[3];
    File file = new File(output_file);

    int arr[] = ms.importArray(random_file_path, limit);

    for (int i = interval; i < limit; i += interval) {
      int[] arr_to_sort = new int[i];
      System.arraycopy(arr, 0, arr_to_sort, 0, arr_to_sort.length);
      Long start = System.currentTimeMillis();
      ms.mergeSort(arr_to_sort);
      Long end = System.currentTimeMillis();
      System.out.format("Start: %d, End, %d\n", start, end);
      Long timeElapsed = end - start;
      System.out.format("Sorted %d numbers in %d ms. \n", i, timeElapsed);
      String str = String.valueOf(i) + ", " + String.valueOf(timeElapsed);
      ms.writeToFile(str, file);
    }
  }
}
