package com.kodilla.testing.forum.statistics;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ForumStatisticsTestSuite {

    private Statistics statisticsMock;
    private ForumStatistics forumStatistics;

    @Before
    public void beforeTest() {
        statisticsMock = mock(Statistics.class);
        List<String> listMock = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            listMock.add("User");
        }
        when(statisticsMock.usersNames()).thenReturn(listMock);
        when(statisticsMock.postsCount()).thenReturn(40);
        when(statisticsMock.commentsCount()).thenReturn(100);
        forumStatistics = new ForumStatistics();

        System.out.println("Test Case: begin");
    }

    @After
    public void after() {
        System.out.println("Test Case: end");
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Test Suite: begin");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Test Suite: end");
    }

    @Test
    public void testCalculateAdvStatisticsWithZeroPosts() {
        //Given
        when(statisticsMock.postsCount()).thenReturn(0);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(0, forumStatistics.getPostsNumber());
        assertEquals(0, forumStatistics.getPostsAveragePerUser(), 0.01);
        assertEquals(0, forumStatistics.getCommentsAveragePerPosts(), 0.01);

        forumStatistics.showStatistics();
    }

    @Test
    public void testCalculateAdvStatisticsWithThousandPosts() {
        //Given
        when(statisticsMock.postsCount()).thenReturn(1000);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(1000, forumStatistics.getPostsNumber());
        assertEquals(50, forumStatistics.getPostsAveragePerUser(), 0.01);
        assertEquals(0.1, forumStatistics.getCommentsAveragePerPosts(), 0.01);

        forumStatistics.showStatistics();
    }

    @Test
    public void testCalculateAdvStatisticsWithZeroComments() {
        //Given
        when(statisticsMock.commentsCount()).thenReturn(0);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(0, forumStatistics.getCommentsNumber());
        assertEquals(0, forumStatistics.getCommentsAveragePerUser(), 0.01);
        assertEquals(0, forumStatistics.getCommentsAveragePerPosts(), 0.01);

        forumStatistics.showStatistics();
    }

    @Test
    public void testCalculateAdvStatisticsLessCommentsThanPosts() {
        //Given
        when(statisticsMock.commentsCount()).thenReturn(40);
        when(statisticsMock.postsCount()).thenReturn(20);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(20, forumStatistics.getPostsNumber());
        assertEquals(40, forumStatistics.getCommentsNumber());
        assertEquals(1, forumStatistics.getPostsAveragePerUser(), 0.01);
        assertEquals(2, forumStatistics.getCommentsAveragePerUser(), 0.01);
        assertEquals(2, forumStatistics.getCommentsAveragePerPosts(), 0.01);

        forumStatistics.showStatistics();
    }

    @Test
    public void testCalculateAdvStatisticsMoreCommentsThanPosts() {
        //Given
        //Same data as in method named beforeTest
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(40, forumStatistics.getPostsNumber());
        assertEquals(100, forumStatistics.getCommentsNumber());
        assertEquals(2, forumStatistics.getPostsAveragePerUser(), 0.01);
        assertEquals(5, forumStatistics.getCommentsAveragePerUser(), 0.01);
        assertEquals(2.5, forumStatistics.getCommentsAveragePerPosts(), 0.01);

        forumStatistics.showStatistics();
    }

    @Test
    public void testCalculateAdvStatisticsWithZeroUsers() {
        //Given
        List<String> listMock = new ArrayList<>();
        when(statisticsMock.usersNames()).thenReturn(listMock);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(0, forumStatistics.getUsersNumber());
        assertEquals(0, forumStatistics.getPostsAveragePerUser(), 0.01);
        assertEquals(0, forumStatistics.getCommentsAveragePerUser(), 0.01);

        forumStatistics.showStatistics();
    }

    @Test
    public void testCalculateAdvStatisticsWithHundredUsers() {
        //Given
        List<String> listMock = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            listMock.add("User");
        }
        when(statisticsMock.usersNames()).thenReturn(listMock);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(100, forumStatistics.getUsersNumber());
        assertEquals(0.4, forumStatistics.getPostsAveragePerUser(), 0.01);
        assertEquals(1, forumStatistics.getCommentsAveragePerUser(), 0.01);

        forumStatistics.showStatistics();
    }
}