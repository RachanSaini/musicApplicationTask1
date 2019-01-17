package com.stackroute.musicApplicationTask1.repository;

import com.stackroute.musicApplicationTask1.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackRepository extends JpaRepository<Track,Integer> {
}
