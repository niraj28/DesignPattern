package Singleton;

public class SingletonClassicImplementation {

    private static SingletonClassicImplementation obj;

    // private constructor to force use of getInstance() to create Singleton object
    private SingletonClassicImplementation() {}

    public static SingletonClassicImplementation getInstance() {
        if (obj == null)
            obj = new SingletonClassicImplementation();
        return obj;
    }

    public static void main(String args[]) {
        int arr[] = {5,4,8,6,9,5,0};

        // sort the array using bubble sort
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        for (int num : arr) {
            System.out.println(num);
        }
    }
}
