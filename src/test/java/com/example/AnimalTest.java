package com.example;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.assertThat;

public class AnimalTest extends TestCase {
    private Animal animal;
    private static final String UNSUPPORTED_ANIMAL_KIND = "unsupported animal kind";
    private static final String TEXT_EXCEPTION = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
    private static final String FAMILY = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";

    @Before
    public void setUp() {
        animal = new Animal();
    }

    @Test
    public void testGetFoodException() {
        Throwable throwable = catchThrowable(() -> {
            animal.getFood(UNSUPPORTED_ANIMAL_KIND);
        });
        assertThat(throwable).isInstanceOf(Exception.class);
        assertThat(throwable.getMessage()).isEqualTo(TEXT_EXCEPTION);
    }

    @Test
    public void testGetFamily() {
        String actual = animal.getFamily();

        assertEquals("Ответ не соответствует ожидаемому",
                FAMILY, actual);
    }
}