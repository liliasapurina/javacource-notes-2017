package com.db.tdd;


import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class NDSResolverImplTest {

    @Test
    public void withNDS() throws Exception {
        TaxCalculator taxCalculator = new TaxCalculator();

        // Первый способ задать моки (переписать метод и переделать возвращаемые значения)
        // Неудобно, если в интерфейсе куча методов
        /* NDSResolver mockNdsResolver = new NDSResolver() {
            @Override
            public double getNDS() {
                return 0.1;
            }
        };*/

        // Удобная альтернатива при помощи фреймворка Mockito
        NDSResolver mockNdsResolver = mock(NDSResolver.class);
        when(mockNdsResolver.getNDS()).thenReturn(0.1);

        double withNDS = taxCalculator.withNDS(100);

        Assert.assertEquals(110,withNDS,0.000001);
    }

}