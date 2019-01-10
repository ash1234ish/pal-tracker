package io.pivotal.pal.tracker;

import java.util.*;
import java.util.stream.Collectors;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {
    private long seed = 0L;

    Map<Long, TimeEntry> timeEntryMap;

    public InMemoryTimeEntryRepository() {
        timeEntryMap = new HashMap<>();
    }

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        seed = seed + 1;
        timeEntry.setId(seed);
        timeEntryMap.put(timeEntry.getId(), timeEntry);
        return timeEntry;
    }

    @Override
    public TimeEntry find(Long id) {
        return timeEntryMap.get(id);
    }

    @Override
    public TimeEntry update(Long id, TimeEntry timeEntry) {
        timeEntry.setId(id);
        if (timeEntryMap.containsKey(id)) {
            timeEntryMap.put(id, timeEntry);
            return timeEntry;
        }

        return null;
    }

    @Override
    public void delete(Long id) {
        timeEntryMap.remove(id);
    }

    @Override
    public List<TimeEntry> list() {
        return timeEntryMap.entrySet().stream().map(m -> m.getValue()).collect(Collectors.toList());
    }
}
