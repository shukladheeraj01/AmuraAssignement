package com.amura.subarrayfinder;

import com.amura.exceptions.InvalidInputException;
import com.amura.exceptions.NonePositiveElement;

import java.util.ArrayList;
import java.util.List;

public class MaxiMumSubArrayFinder {

    private  List<Integer> arr;
    private int lengthOfArr = 0;

    private List<Integer> getArr() {
        return arr;
    }

    private void setArr(List<Integer> arr) {
        this.arr = arr;
    }

    private int getLengthOfArr() {
        return lengthOfArr;
    }

    private void setLengthOfArr(int lengthOfArr) {
        this.lengthOfArr = lengthOfArr;
    }

    public MaxiMumSubArrayFinder(List<Integer> arr) throws  InvalidInputException {
        // Fail safe case
        // If given array is null or empty.
        // We can not process in this scenario.
        if(arr == null || arr.size() ==0)
            throw new InvalidInputException();
        this.setArr(arr);
        this.setLengthOfArr(arr.size());
    }


    public List<Integer> getMaxiMumSubArray() throws NonePositiveElement {
        if(!isAnyPositiveNumber())
            throw new NonePositiveElement();

        List<Integer> op = new ArrayList<>();
        int curentsum = 0;
        int startIndex = 0;
        int endIndex = 0;
        int s = 0;
        int maxSum = this.getArr().get(0);

        for(int i =0 ; i< this.getLengthOfArr(); i++){
            curentsum += this.getArr().get(i);

            if(curentsum < this.getArr().get(i)){
                s = i ;
                curentsum = this.getArr().get(i);
            }
            if(curentsum > maxSum){
                startIndex = s;
                endIndex = i;
                maxSum = curentsum;
            }
        }
        op.add(startIndex);
        op.add(((endIndex - startIndex) +1));
        op.add(maxSum);
        return op;

    }

    private boolean isAnyPositiveNumber(){
        for(int i =0 ; i< this.getLengthOfArr() ; i++)
        {
            // This is the base case if there is not any positive element in array.
            if(this.arr.get(i) > 0)
                return true;
        }
        return false;
    }
}
