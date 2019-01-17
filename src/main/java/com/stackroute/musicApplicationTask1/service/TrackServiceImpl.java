package com.stackroute.musicApplicationTask1.service;

import com.stackroute.musicApplicationTask1.domain.Track;
import com.stackroute.musicApplicationTask1.exceptions.TrackAlreadyExistsException;
import com.stackroute.musicApplicationTask1.exceptions.TrackNotFoundException;
import com.stackroute.musicApplicationTask1.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class TrackServiceImpl implements TrackService {

    private TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }


    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {
        if(trackRepository.existsById(track.getTrackId())){
            throw new TrackAlreadyExistsException("Track already exists.");
        }
        Track saveTrack = trackRepository.save(track);
        return saveTrack;
    }

    @Override
    public List<Track> getAllTracks() {
        return trackRepository.findAll() ;
    }

    @Override
    public Track updateTrack(Track track) throws TrackNotFoundException {
        if(trackRepository.existsById(track.getTrackId())){
           track.setComments(track.getComments());
           track.setTrackName(track.getTrackName());
           return trackRepository.save(track);
        }else
            throw new TrackNotFoundException("Track doesn't exists.");
    }

    @Override
    public void deleteTrack(int id){

        trackRepository.deleteById(id);

    }

}
