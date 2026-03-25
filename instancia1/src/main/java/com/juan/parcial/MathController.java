package com.juan.parcial;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

public class MathController {

    @GetMapping("/fibonacci")
    public TribonacciResult getFibonacci(@RequestParam(value = "value") int n) {
        return new TribonacciResult(n, calculateTribonacci(n));
    }

    private List<Long> calculateTribonacci(int n) {
        List<Long> sequence = new ArrayList<>();
        if (n <= 0) return sequence;

        long a = 0, b = 1;
        sequence.add(a);
        if (n == 1) return sequence;

        sequence.add(b);
        for (int i = 2; i < n; i++) {
            long next = a + b;
            sequence.add(next);
            a = b;
            b = next;
        }
        return sequence;
    }
}

record FibonacciResult(int value, List<Long> sequence) {}






