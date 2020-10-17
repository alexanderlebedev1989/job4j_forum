package ru.job4j.forum.model;

import java.util.Calendar;
import java.util.Objects;

public class Comment {
    private int id;
    private String desc;
    private Calendar calendar;

    private static Comment of(String desc) {
        Comment comment = new Comment();
        comment.desc = desc;
        return comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Comment comment = (Comment) o;
        return id == comment.id
                && Objects.equals(desc, comment.desc)
                && Objects.equals(calendar, comment.calendar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, desc, calendar);
    }
}
