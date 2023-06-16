package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionAlexTest {
    @Mock
    private Feline feline;
    private LionAlex lionAlex;
    private final int expectedLionChildren = 0;
    private final List<String> expectedFriends = List.of("Марти", "Глория", "Мелман");
    private final String expectedPlace = "Нью-Йоркский зоопарк";

    @Test
    public void testGetKittens() throws Exception {
        lionAlex = new LionAlex(feline);
        int actual = lionAlex.getKittens();

        assertEquals("Количество лвят не соответствует ожидаемому",
                expectedLionChildren, actual);
    }

    @Test
    public void testGetFriends() throws Exception {
        lionAlex = new LionAlex(feline);
        List<String> actual = lionAlex.getFriends();

        assertEquals("писок друзей не соответствует ожидаемому",
                expectedFriends, actual);
    }

    @Test
    public void testGetPlaceOfLiving() throws Exception {
        lionAlex = new LionAlex(feline);
        String actual = lionAlex.getPlaceOfLiving();

        assertEquals("Некорректное место проживания льва",
                expectedPlace,actual);
    }
}
