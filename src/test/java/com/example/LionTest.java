package com.example;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

@RunWith(Parameterized.class)
public class LionTest extends TestCase {
    private static final String MALE = "Самец";
    private static final String FEMALE = "Самка";
    private static final String UNSUPPORTED_SEX = "unsupported sex";
    private static final String TEXT_EXCEPTION = "Используйте допустимые значения пола животного - самей или самка";
    private Lion lion;
    private Feline feline;
    private String sex;
    private boolean hasMane;

    public LionTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Before
    public void setUp() {
        feline = Mockito.mock(Feline.class);
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][] {
                {MALE, true},
                {FEMALE, false},
                {UNSUPPORTED_SEX, false}
        };
    }

    @Test
    public void testGetKittens() throws Exception {
        lion = new Lion(MALE, feline);

        lion.getKittens();
        Mockito.verify(feline).getKittens();
    }

    @Test
    public void testDoesHaveMane() {
        try {
            lion = new Lion(sex, feline);
            boolean actual = lion.doesHaveMane();
            assertEquals(hasMane, actual);
        } catch (Exception e) {
            assertEquals(TEXT_EXCEPTION, e.getMessage());
        }
    }

    @Test
    public void testGetFood() throws Exception {
        lion = new Lion(MALE, feline);

        lion.getFood();
        Mockito.verify(feline).getFood(Mockito.anyString());
    }
}