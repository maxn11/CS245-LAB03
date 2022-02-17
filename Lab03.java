//Maximus Nie
//2/17/2022
//CS245 Lab 3: Sorting and Performance

//import java.util.*;
import java.lang.Math;

public class Lab03{
    public static int[] arrayGenerator(int datasetSize){
        // TODO: Implement datasetSize length array Generator
    	int arr[] = new int[datasetSize];
    	//check if array size is above size of 1
    	if(arr.length < 1) {
    		throw new IllegalArgumentException();
    	}
    	//fill with random numbers from 1 to 100
    	for(int i = 0; i < datasetSize; i++) {
    		arr[i] = (int)(Math.random() * 100);
    	}
    	return arr;
    }

    public static void algoName1Sort(int[] dataset){
        // TODO: Implement O(n^2) Sorting Algorithm
    	//INSERTION SORT
    	for(int i = 1; i < dataset.length; i++) {
    		//create a temporary space and fill
            int temp = dataset[i];
            int j = i - 1;
            while(j >= 0 && dataset[j] > temp) {
            	//move over one space to the right
                dataset[j + 1] = dataset[j];
                --j;
            }
            //swap
            dataset[j + 1] = temp;
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
        //Add data to left and right arrays
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
        //if one side runs out of elements
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
    	//start time
    	test.setFirstAlgoStartTime(System.currentTimeMillis());
    	//run the sorting algorithm "iterations" times
    	for(int i = 0; i < iterations; i++) {
    		algoName1Sort(dataset);
    	}
    	//end time
    	test.setFirstAlgoEndTime(System.currentTimeMillis());
    	
    	//second algorithm
    	//start time
    	test.setSecondAlgoStartTime(System.currentTimeMillis());
    	for(int i = 0; i < iterations; i++) {
    		algoName2Sort(dataset, 0, dataset.length - 1);
    	}
    	//end time
    	test.setSecondAlgoEndTime(System.currentTimeMillis());
    	
    	
    	
    	
    	return test;
    }

    public static String checkPerformanceForMultipleArraySizes(int[] arraySizes, int iterations){
        // TODO: Add code here
        StringBuilder response = new StringBuilder();
        for (int i = 0; i < arraySizes.length; i++){
            // TODO: Add code here and replace <name> on the next line.
        	//create a Performance object
        	Performance PerTest = new Performance(arraySizes[i], iterations);
        	//create array of current position in arraySizes
        	int arr[] = new int[arraySizes[i]];
        	//fill the random array
        	arr = arrayGenerator(arr.length);
        	//run the sorting algorithms and compare the times
        	PerTest = algorithmsComparator(arr, iterations);
        	//append to the string builder
            response.append(PerTest.toString());
            response.append(System.getProperty("line.separator"));
        }
        return response.toString();
    }

    public static void main(String[] args) {
    	
    	//arraySizes
    	int[] sizes = {10000, 100000, 1000000};
    	//print the toString return
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
