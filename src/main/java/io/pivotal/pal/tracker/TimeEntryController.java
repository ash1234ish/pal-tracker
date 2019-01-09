package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TimeEntryController {


    @PostMapping("/create")
    public ResponseEntity<TimeEntry> create(TimeEntry timeEntry) {
        return new ResponseEntity<>(new TimeEntry(), HttpStatus.CREATED);
    }

    @GetMapping("/read")
    public  ResponseEntity<TimeEntry> read(long id){
        return new ResponseEntity<TimeEntry>(new TimeEntry(),HttpStatus.OK);
    }
    @GetMapping("/list")

}
