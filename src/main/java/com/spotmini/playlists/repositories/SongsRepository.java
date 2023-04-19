package com.spotmini.playlists.repositories;

import com.spotmini.playlists.db.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongsRepository extends JpaRepository<Song, Long> {
}
