package com.kodilla.spring.portfolio;

import org.springframework.context.annotation.*;

@Configuration
public class BoardConfig {

    @Bean
    public Board getBoard() {
        return new Board(getToDoList(), getInProgressList(), getDoneList());
    }

    public TaskList getToDoList() {
        return new TaskList();
    }

    public TaskList getInProgressList() {
        return new TaskList();
    }

    public TaskList getDoneList() {
        return new TaskList();
    }
}