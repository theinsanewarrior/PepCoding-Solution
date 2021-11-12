class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums);
        // mergeSort(nums);
        // selectionSort(nums);
        // insertionSort(nums);
        // bubbleSort(nums);
        return nums;
    }
    
    public void mergeSort(int[] arr){
        ms(0, arr.length-1, arr);
    }
    public void ms(int l, int r, int[] arr){
        if(l>=r) return;
        int mid = l + (r-l)/2;
        ms(l, mid, arr);
        ms(mid+1, r, arr);
        merge(arr, l, mid, r);
    }
    public void merge(int[] arr, int l, int mid, int r){
        int[] ans = new int[r-l+1];
        int i = l, j=mid+1;
        int idx = 0;
        while(i<=mid && j<=r){
            if(arr[i] < arr[j]){
                ans[idx] = arr[i];
                i++;
                idx++;
            }
            else{
                ans[idx] = arr[j];
                j++;
                idx++;
            }
        }
        while(i<=mid){
            ans[idx] = arr[i];
            i++;
            idx++;
        }
        while(j<=r){
            ans[idx] = arr[j];
            j++;
            idx++;
        }
        
        for(i=0; i<ans.length; i++){
            arr[i+l] = ans[i];
        }
        
    }

    public void quickSort(int[] arr){
        qs(0, arr.length-1, arr);
    }
    public void qs(int l, int r, int[] arr){
        if(l>=r) return;
        int pivot = partition(l, r, arr);
        qs(l, pivot-1, arr);
        qs(pivot+1, r, arr);
    }
    public int partition(int l, int r, int[] arr){
        int pivot = random(l, r);
        swap(arr, r, pivot);
        pivot = r;
        int i = l-1, j = l;
        while(j<=r-1){
            if(arr[j] > arr[pivot]){
                j++;
            }
            else{
                swap(arr, i+1, j);
                i++;
                j++;
            }
        }
        swap(arr, i+1, pivot);
        return i+1;
    }
    public int random(int min, int max){
        int range = max-min;
        return min+(int)(Math.random()*range);
    }
    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public void bubbleSort(int[] arr){
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                if(arr[i] > arr[j]) swap(arr, i, j);
            }
        }
    }
    
    public void insertionSort(int[] arr){
        for(int i=1; i<arr.length; i++){
            if(arr[i-1] > arr[i]){
                int j = i-1;
                while(j>=0 && arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
                    j--;
                }
            }
        }
    }
    
    public void selectionSort(int[] arr){
        for(int i=0; i<arr.length; i++){
            int min = i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[j] < arr[min]) min = j;
            }        
            swap(arr, i, min);
        }
    }
}