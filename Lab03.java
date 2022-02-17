//Maximus Nie
//2/17/2022
//CS245 Lab 3: Sorting and Performance

//import java.util.*;
import java.lang.Math;

public class Lab03{
    public static int[] arrayGenerator(int datasetSize){
        // TODO: Implement datasetSize length array Generator
    	int arr[] = new int[datasetSize];
    	for(int i = 0; i < datasetSize; i++) {
    		arr[i] = (int)(Math.random() * 100);
    	}
    	return arr;
    }

    public static void algoName1Sort(int[] dataset){
        // TODO: Implement O(n^2) Sorting Algorithm
    	//INSERTION SORT
    	for(int i = 1; i < dataset.length; i++) {   // "i" is 1st unsorted item
            int temp = dataset[i];    // Copy
            int j = i - 1;
            while(j >= 0 && dataset[j] > temp) {    // Move (loop)
                dataset[j + 1] = dataset[j];
                --j;
            }
            dataset[j + 1] = temp;   // Copy back
        }
    	
    }
    
    public static void merge(int arr[], int mid, int left, int right)
    {
    	//instead of making getRight and getLeft
    	//just put inside the merge function.
    	//this is how we did it in my Intro to CompSci 2 course 
    	//and how i remember it.
    	//Create left and right arrays
        int leftSize = mid - left + 1;
        int rightSize = right - mid;
        int leftArr[] = new int[leftSize];
        int rightArr[] = new int[rightSize];
        //Add data
        for(int i = 0; i < leftSize; ++i) {
        	leftArr[i] = arr[left + i];
        }
        for(int j = 0; j < rightSize; ++j) {
            rightArr[j] = arr[mid + 1 + j]; 
        }
        
        //the three merge while loops
        int i = 0, j = 0, k = 0;
        while(i < leftSize && j < rightSize) {
            if(leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            }
            else {
                arr[k++] = rightArr[j++];
            }
        }
        while(i < leftSize) {
            arr[k++] = leftArr[i++];
        }
        while(j < rightSize) {
            arr[k++] = rightArr[j++];
        }
    }

    public static void algoName2Sort(int[] dataset, int left, int right) {
        // TODO: Implement O(nlogn) Sorting Algorithm
    	//MERGE SORT
    	if(left < right) {
    		//midpoint
            int midpoint = left + (right - left) / 2;
            
            algoName2Sort(dataset, left, midpoint);
            algoName2Sort(dataset, midpoint + 1, right);
            merge(dataset, midpoint, left, right);
        }
    }

    public static Performance algorithmsComparator(int[] dataset, int iterations){
        // TODO: Implement Comparing Algorithms Running Time
    	Performance test = new Performance(dataset.length, iterations);
    	
    	//first algorithm
    	test.setFirstAlgoStartTime(System.currentTimeMillis());
    	for(int i = 0; i < iterations; i++) {
    		algoName1Sort(dataset);
    	}
    	test.setFirstAlgoEndTime(System.currentTimeMillis());
    	
    	//second algorithm
    	test.setSecondAlgoStartTime(System.currentTimeMillis());
    	for(int i = 0; i < iterations; i++) {
    		algoName2Sort(dataset, 0, dataset.length - 1);
    	}
    	test.setSecondAlgoEndTime(System.currentTimeMillis());
    	
    	
    	
    	
    	return test;
    }

    public static String checkPerformanceForMultipleArraySizes(int[] arraySizes, int iterations){
        // TODO: Add code here
        StringBuilder response = new StringBuilder();
        for (int i = 0; i < arraySizes.length; i++){
            // TODO: Add code here and replace <name> on the next line.
        	Performance PerTest = new Performance(arraySizes[i], iterations);
        	int arr[] = new int[arraySizes[i]];
        	arr = arrayGenerator(arr.length);
        	PerTest = algorithmsComparator(arr, iterations);
            response.append(PerTest.toString());
            response.append(System.getProperty("line.separator"));
        }
        return response.toString();
    }

    public static void main(String[] args) {
    	
    	int[] sizes = {10000, 100000, 1000000};
        System.out.println(checkPerformanceForMultipleArraySizes(sizes, 10));
    	
 
    	//int arr[] = new int[100];
    	//arr = arrayGenerator(arr.length);
    	//int iterations = 1000000;
    	
    	//Performance mainTest = new Performance(arr.length, iterations);
    	//mainTest = algorithmsComparator(arr, iterations);
    	
    	
    	//System.out.println(mainTest.toString());
    	
    	
    	//algoName1Sort(arr);
    	//algoName2Sort(arr, 0, arr.length - 1);
    }
}
