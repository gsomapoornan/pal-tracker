package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {

    private TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {

        this.timeEntryRepository = timeEntryRepository;

    }

    @PostMapping
    public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntryToCreate) {
        TimeEntry timeEntry = timeEntryRepository.create(timeEntryToCreate);

        return new ResponseEntity<>(timeEntry, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable long id) {
        TimeEntry timeEntry = timeEntryRepository.find(id);

        if (timeEntry != null) {
            return new ResponseEntity<>(timeEntry, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(timeEntry, HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping()
    public ResponseEntity<List<TimeEntry>> list() {
        List<TimeEntry> timeEntries=timeEntryRepository.list();
        return new ResponseEntity<>(timeEntries,HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable long id, @RequestBody TimeEntry timeEntry) {

        TimeEntry timeEntry1=timeEntryRepository.update(id,timeEntry);

        if ((timeEntry1 != null) && (timeEntry1.getId() >0) ) {
            return new ResponseEntity<>(timeEntry1, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<TimeEntry> delete(@PathVariable long id) {

        timeEntryRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
