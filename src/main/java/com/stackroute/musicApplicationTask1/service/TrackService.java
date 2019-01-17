package com.stackroute.musicApplicationTask1.service;

import com.stackroute.musicApplicationTask1.domain.Track;
import com.stackroute.musicApplicationTask1.exceptions.TrackAlreadyExistsException;
import com.stackroute.musicApplicationTask1.exceptions.TrackNotFoundException;

import java.util.List;

public interface TrackService {

    public Track saveTrack(Track track) throws TrackAlreadyExistsException;
    public List<Track> getAllTracks();
    public Track updateTrack(Track track) throws TrackNotFoundException;
    public void deleteTrack(int id);

}
