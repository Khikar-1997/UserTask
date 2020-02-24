package com.company.user.task;

import java.util.Objects;

public class Task {
    private String name;
    private String state;
    private int userId;

    public Task(String name, String state, int userId) {
        this.name = name;
        if(state.equals(String.valueOf(State.valueOf(state)))){
            this.state = state;
        } else {
            throw new RuntimeException("!!!!!!");
        }
        this.userId = userId;
    }

    public Task() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return userId == task.userId &&
                Objects.equals(name, task.name) &&
                Objects.equals(state, task.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, state, userId);
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", state='" + state + '\'' +
                ", userId=" + userId +
                '}';
    }
}
