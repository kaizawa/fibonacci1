package com.cafeform.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Compute fibonacci number by Divide and Conquer method.
 */
public class Fibonacci1 {
    private Map<Long, AtomicInteger> fiboMap = new HashMap<>();
    AtomicInteger totalSteps = new AtomicInteger(0);

    public static void main(String[] args) {
        new Fibonacci1().start();
    }

    private void start() {
        
        for(long input = 0 ; input < 10 ; input++){
            totalSteps.set(0);

            long ans = fibo(input);
            System.out.println("Fibonacci(" + input + ")=" + ans +
              "\tTotal steps: " + totalSteps);

            /** 
             * Debug code to see how many times fibo() with same input value
             * is called.
             */
            /*
            for(Long fibo : fiboMap.keySet()){
                System.out.println("fibo(" +  fibo + "): " + fiboMap.get(fibo));  
            }
            */
            fiboMap.clear();
        }
    }

    private long fibo(long input) {
        AtomicInteger fiboCount = fiboMap.get(input);
        if(null == fiboCount){
            fiboCount = new AtomicInteger(0);
            fiboMap.put(input, fiboCount);
        }
        fiboCount.incrementAndGet();
        totalSteps.incrementAndGet();
        
        if(0 == input) {
            return 0;
        } else if(1 == input) {
            return 1;
        }
        
        return fibo(input - 2) + fibo(input - 1);
    }
}
