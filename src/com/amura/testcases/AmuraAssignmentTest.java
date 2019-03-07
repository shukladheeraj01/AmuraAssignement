package com.amura.testcases;

import com.amura.exceptions.InvalidInputException;
import com.amura.exceptions.NonePositiveElement;
import com.amura.subarrayfinder.MaxiMumSubArrayFinder;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class AmuraAssignmentTest {

    @Test
    public void nullTest(){
        List<Integer> emptyList = new ArrayList<>();
        try {
            new MaxiMumSubArrayFinder(null);
        }catch (Exception ex){
            assertEquals (ex.getClass(), InvalidInputException.class);
        }
    }

    @Test
    public void emptyArrayTest(){
        try {
            new MaxiMumSubArrayFinder(new ArrayList<>());
        }catch (Exception ex){
            assertEquals (ex.getClass(), InvalidInputException.class);
        }
    }

    @Test
    public void negativeArrayTest(){
        try {
            MaxiMumSubArrayFinder maxiMumSubArrayFinder = new MaxiMumSubArrayFinder(Arrays.asList(-1,-2));
            List<Integer> op = maxiMumSubArrayFinder.getMaxiMumSubArray();
        }catch (Exception ex){
            assertEquals (ex.getClass(), NonePositiveElement.class);
        }
    }

    @Test
    public void BestCaseTest() throws  Exception{
        List<Integer> lst = Arrays.asList(1,2);
        MaxiMumSubArrayFinder maxiMumSubArrayFinder = new MaxiMumSubArrayFinder(lst);
        List<Integer> op = maxiMumSubArrayFinder.getMaxiMumSubArray();
        assertNotEquals(null, op);
        assertEquals(Arrays.asList(0, 2, 3), op);
    }

    @Test
    public void givenArrayTest() throws  Exception{
        List<Integer> lst = Arrays.asList(-2,1,-3,4,-1,2,1,-5,4);
        MaxiMumSubArrayFinder maxiMumSubArrayFinder = new MaxiMumSubArrayFinder(lst);
        List<Integer> op = maxiMumSubArrayFinder.getMaxiMumSubArray();
        assertNotEquals(null, op);
        assertEquals(Arrays.asList(3, 4, 6), op);
    }

    @Test
    public void maxSumtest() throws  Exception{
        List<Integer> lst = Arrays.asList(100,1,-3,4,-1,2,1,-5,500);
        MaxiMumSubArrayFinder maxiMumSubArrayFinder = new MaxiMumSubArrayFinder(lst);
        List<Integer> op = maxiMumSubArrayFinder.getMaxiMumSubArray();
        assertNotEquals(null, op);
        assertEquals(Arrays.asList(0, 9, 599), op);
    }

    @Test
    public void randomTest() throws  Exception{
        List<Integer> lst = Arrays.asList(-100,3,-3,10,4,-2,-1,-5,-500);
        MaxiMumSubArrayFinder maxiMumSubArrayFinder = new MaxiMumSubArrayFinder(lst);
        List<Integer> op = maxiMumSubArrayFinder.getMaxiMumSubArray();
        assertNotEquals(null, op);
        assertEquals(Arrays.asList(1, 4, 14), op);
    }

    @Test
    public void onlyOnePositiveElementTest() throws  Exception{
        List<Integer> lst = Arrays.asList(-100, -1, -3, -4 ,1, -2, -1, -5, -500);
        MaxiMumSubArrayFinder maxiMumSubArrayFinder = new MaxiMumSubArrayFinder(lst);
        List<Integer> op = maxiMumSubArrayFinder.getMaxiMumSubArray();
        assertNotEquals(null, op);
        assertEquals(Arrays.asList(4, 1, 1), op);
    }

    @Test
    public void incresingOrderTest() throws  Exception{
        List<Integer> lst = Arrays.asList(-10, -9, -8, -5 ,-4, -2, -1, 0, 1);
        MaxiMumSubArrayFinder maxiMumSubArrayFinder = new MaxiMumSubArrayFinder(lst);
        List<Integer> op = maxiMumSubArrayFinder.getMaxiMumSubArray();
        assertNotEquals(null, op);
        assertEquals(Arrays.asList(7, 2, 1), op);
    }
}