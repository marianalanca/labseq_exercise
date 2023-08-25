package org.acme;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.BadRequestException;

import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class ValueServiceImpl implements ValueService {

    private final Map<Integer, Long> cache = new HashMap<>();

    public long getValue(int n) {

        if (n<0) {
            throw new BadRequestException();
        }

         if (cache.containsKey(n)) {
            return cache.get(n);
        }

        if (n == 0 || n == 2) {
            return 0;
        } else if (n == 1 || n == 3) {
            return 1;
        } else {
            long result = getValue(n - 4) + getValue(n - 3);
            cache.put(n, result);
            return result;
        }
    }
}
