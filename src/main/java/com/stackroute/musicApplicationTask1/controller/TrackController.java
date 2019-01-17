package com.stackroute.musicApplicationTask1.controller;

import com.stackroute.musicApplicationTask1.domain.Track;
import com.stackroute.musicApplicationTask1.exceptions.TrackNotFoundException;
import com.stackroute.musicApplicationTask1.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TrackController {

    private TrackService trackService;

    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @PostMapping("/saveTrack")
    public ResponseEntity<?> saveTrack(@RequestBody Track track){
        ResponseEntity responseEntity;
        try{
            trackService.saveTrack(track);
            responseEntity = new ResponseEntity(track, HttpStatus.CREATED);
        }catch(Exception e){
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("/getTrack")
    public ResponseEntity<?> getAllTracks(){
        return new ResponseEntity<List<Track>>(trackService.getAllTracks(),HttpStatus.OK);
    }

    @PutMapping("/updateTrack")
    public ResponseEntity<?> updateTrack(@RequestBody Track track) throws TrackNotFoundException {
        ResponseEntity responseEntity;
        trackService.updateTrack(track);
        return new ResponseEntity(track, HttpStatus.OK);
    }

    @DeleteMapping("/deleteTrack")
    public ResponseEntity<?> deleteTrack(@RequestParam int id){
        ResponseEntity responseEntity;
        trackService.deleteTrack(id);
        return new ResponseEntity("deleted successfully",HttpStatus.OK);
    }
}
