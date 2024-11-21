package com.example;

import org.junit.jupiter.api.Test;

import com.example.copilotdemo.HelloController;

import static org.junit.jupiter.api.Assertions.*;


public class HelloControllerTest {

    @Test
    public void testBubbleSort() {
        int[] arr = {5, 1, 4, 2, 8};
        int[] expected = {1, 2, 4, 5, 8};
        HelloController.bubbleSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testBubbleSortEmptyArray() {
        int[] arr = {};
        int[] expected = {};
        HelloController.bubbleSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testBubbleSortSingleElement() {
        int[] arr = {1};
        int[] expected = {1};
        HelloController.bubbleSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testBubbleSortAlreadySorted() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        HelloController.bubbleSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testBubbleSortReverseOrder() {
        int[] arr = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};
        HelloController.bubbleSort(arr);
        assertArrayEquals(expected, arr);
    }
}