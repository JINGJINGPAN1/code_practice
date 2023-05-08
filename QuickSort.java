public class QuickSort {
    public static void sort(int[] arr){
        quickSort(arr,0,arr.length-1);
    }


    private static void quickSort(int[]arr, int low, int high){
        if(low < high){
           int pivotIndex = partition(arr, low, high);
           quickSort(arr, low,pivotIndex-1);
           quickSort(arr,pivotIndex+1, high);
        }
    }


    public static int partition(int[]arr, int low, int high){
        int pivot = arr[low];
        int i = low + 1;
        for(int j = i; j <= high; j++){
            if(arr[j] <= pivot){
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, low,i-1);
        return i-1;
    }
    public static void swap(int[]arr, int a , int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args){
        int[] a = {3,2,1,5,3,6};
        sort(a);

        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
    }

}
