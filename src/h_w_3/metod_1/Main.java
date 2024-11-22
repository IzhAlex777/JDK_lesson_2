package h_w_3.metod_1;

public class Main {
      public static void main(String[] args) {
      Integer[] inArray1 = {1, 2, 3, 4, 5};
      Integer[] inArray2 = {1, 2, 3, 4, 5};
      boolean result1 = compareArrays(inArray1, inArray2);
          System.out.println( "Результат для целочисленных массивов: " + result1);
   String[] stringArray1 = {"Hello", "World"};
   String[] stringArray2 = {"Hello", "World"};
   boolean result2 = compareArrays(stringArray1, stringArray2);
          System.out.println( "Результат для строковых массивов: " + result2);
   Double[] doubleArray1 = {1.6, 1.7, 1.6};
   Double[] doubleArray2 = {1.6, 1.7};
   boolean result3 = compareArrays(doubleArray1, doubleArray2);
          System.out.println( "Результат если массивы разной длины: " + result3);
      Float[] floatsArray1 = {1.6f, 1.7f, 1.6f};
      Float[] floatsArray2 = {1.6f, 1.7f, 1.8f};
      boolean result4 = compareArrays(floatsArray1, floatsArray2);
      System.out.println( "Результат если массивы не одинаковы: " + result4);
      }
      public static <T extends Number> boolean compareArrays(T[] arr1, T[] arr2) {
          if (arr1.length != arr2.length) {
              return false;
          }
          for (int i = 0; i < arr1.length; i++) {
              if (!arr1[i].getClass().equals(arr2[i].getClass())) {
                  return false;
              }
          }
          return true;
      }

    public static boolean compareArrays(String[] arr1, String[] arr2) {

        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }
        return true;
    }
}
