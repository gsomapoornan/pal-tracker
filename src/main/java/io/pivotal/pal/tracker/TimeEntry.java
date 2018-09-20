package io.pivotal.pal.tracker;

import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Objects;

public class TimeEntry {

    private long id;
    private long projectId;
    private long userId;
    private LocalDate date;
    private int hours;

    public long getId() {
        return id;
    }

    public long getProjectId() {
        return projectId;
    }

    public long getUserId() {
        return userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getHours() {
        return hours;
    }

    public void setId(long id) {

        this.id = id;
    }

    public TimeEntry() {

    }

    public TimeEntry(long l, long l1, long l2, LocalDate parse, int i) {
        this.id = l;
        this.projectId = l1;
        this.userId = l2;
        this.date = parse;
        this.hours = i;
    }

    public TimeEntry(long l1, long l2, LocalDate parse, int i) {
        this.projectId = l1;
        this.userId = l2;
        this.date = parse;
        this.hours = i;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeEntry timeEntry = (TimeEntry) o;
        return id == timeEntry.id &&
                projectId == timeEntry.projectId &&
                userId == timeEntry.userId &&
                hours == timeEntry.hours &&
                Objects.equals(date, timeEntry.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, projectId, userId, date, hours);
    }
}
