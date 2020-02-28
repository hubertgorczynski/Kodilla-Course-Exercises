package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.time.Period;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {

        Forum forum = new Forum();
        Map<Integer, ForumUser> mapOfForumUsers = forum.getForumUserList().stream()
                .filter(forumUser -> forumUser.getSex() == 'M')
                .filter(forumUser -> Period.between(forumUser.getBirthDate(), LocalDate.now()).getYears() >= 20)
                .filter(forumUser -> forumUser.getPostsNumber() >= 1)
                .collect(Collectors.toMap(ForumUser::getIdNumber, forumUser -> forumUser));

        mapOfForumUsers.entrySet().stream()
                .map(entry -> entry.getKey() + " : " + entry.getValue())
                .forEach(System.out::println);
    }
}
        /*
        System.out.println("Welcome to module 7 - Stream");
        Processor processor = new Processor();
        //Executor codeToExecute = () -> System.out.println("This is an example text.");
        //processor.execute(codeToExecute);
        processor.execute(() -> System.out.println("This is an example text."));

        ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);

        //Exercise 7.1
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        String beautifulText = poemBeautifier.beautify("First sample text", String::toUpperCase);
        System.out.println(beautifulText);

        String beautifulText2 = poemBeautifier.beautify("Second sample text", (text -> "ABC " + text + " ABC"));
        System.out.println(beautifulText2);

        String beautifulText3 = poemBeautifier.beautify("Third sample text", (text -> text.replace(" ", "_")));
        System.out.println(beautifulText3);

        String beautifulText4 = poemBeautifier.beautify("Fourth sample text", (text -> text.length() + " letters in sentence ## " + text + " ## letters in sentence " + text.length()));
        System.out.println(beautifulText4);

        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);
        */
