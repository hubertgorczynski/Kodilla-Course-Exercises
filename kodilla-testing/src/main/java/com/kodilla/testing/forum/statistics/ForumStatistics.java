package com.kodilla.testing.forum.statistics;

public class ForumStatistics {

    private int usersNumber;
    private int postsNumber;
    private int commentsNumber;
    private double postsAveragePerUser;
    private double commentsAveragePerUser;
    private double commentsAveragePerPosts;

    public int getUsersNumber() {
        return usersNumber;
    }

    public int getPostsNumber() {
        return postsNumber;
    }

    public int getCommentsNumber() {
        return commentsNumber;
    }

    public double getPostsAveragePerUser() {
        return postsAveragePerUser;
    }

    public double getCommentsAveragePerUser() {
        return commentsAveragePerUser;
    }

    public double getCommentsAveragePerPosts() {
        return commentsAveragePerPosts;
    }

    public void calculateAdvStatistics(Statistics statistics) {
        usersNumber = statistics.usersNames().size();
        postsNumber = statistics.postsCount();
        commentsNumber = statistics.commentsCount();
        postsAveragePerUser = calculatePostsAveragePerUser();
        commentsAveragePerUser = calculateCommentsAveragePerUser();
        commentsAveragePerPosts = calculateCommentsAveragePerPost();
    }

    private double calculatePostsAveragePerUser() {

        if (usersNumber > 0) {
            return (double) postsNumber / usersNumber;
        } else {
            return 0;
        }
    }

    private double calculateCommentsAveragePerUser() {
        if (usersNumber > 0) {
            return (double) commentsNumber / usersNumber;
        } else {
            return 0;
        }
    }

    private double calculateCommentsAveragePerPost() {
        if (postsNumber > 0) {
            return (double) commentsNumber / postsNumber;
        } else {
            return 0;
        }
    }

    public void showStatistics() {
        System.out.println("Detailed forum statistics:");
        System.out.println("Number of all users: " + usersNumber);
        System.out.println("Number of all posts: " + postsNumber);
        System.out.println("Number of all comments: " + commentsNumber);
        System.out.println("Posts average per user: " + postsAveragePerUser);
        System.out.println("Comments average per user: " + commentsAveragePerUser);
        System.out.println("Comments average per post: " + commentsAveragePerPosts);
    }
}


