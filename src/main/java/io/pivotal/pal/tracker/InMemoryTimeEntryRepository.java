package io.pivotal.pal.tracker;

import java.util.*;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    Map<Long,TimeEntry> timeEntryMap=new HashMap<Long, TimeEntry>();

    private long currentId = 1l;

    @Override
    public TimeEntry update(long id, TimeEntry timeEntry) {

        //timeEntryMap.replace(id, timeEntryMap.get(id), timeEntry);
        timeEntry.setId(id);
        timeEntryMap.replace(id,timeEntry);

        return timeEntryMap.get(id);


    }

    @Override
    public TimeEntry create(TimeEntry timeEntry) {

        timeEntry.setId(currentId);

        timeEntryMap.put(currentId, timeEntry);
        currentId++;

        return timeEntry;

    }


    @Override
    public TimeEntry find(long id) {

        return timeEntryMap.get(id);

    }

    @Override
    public void delete(long id) {

        timeEntryMap.remove(id);

    }

    @Override
    public List<TimeEntry> list() {

        Collection coll = timeEntryMap.values();
        List<TimeEntry> lis = new ArrayList<TimeEntry>(coll);
        return lis;
    }

}
