package io.pivotal.pal.tracker;

import java.util.List;

public interface TimeEntryRepository {

    TimeEntry update(long id, TimeEntry timeEntry);

    TimeEntry create(TimeEntry timeEntry);

    TimeEntry find(long id);

    void delete(long id);

    List<TimeEntry> list();
}
