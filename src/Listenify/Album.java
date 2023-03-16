package Listenify;

import java.util.*;

public class Album {

    public String albumName;
    public String artistName;
    public List<Song> songList;

    public Album(String albumName, String artistName) {
        this.albumName = albumName;
        this.artistName = artistName;
        this.songList = new ArrayList<>();                      //Initialise the songlist
    }

    public boolean findSongInAlbum(String title){

        //Iterate over the list and match each song title with given title
        for(Song song: songList){
            if((song.title).equals(title)){
                return true;
            }
        }
        return false;
    }

    public String addSongToAlbum(String title, double duration) {

        //check if the song is already existing, we will not add to album
        //otherwise we will create a new song and add to album
        if (findSongInAlbum(title)) {
            return "Song is already present";
        } else {
            //I need to create a song object and then add it to the songList
            Song newSong = new Song(title, duration);
            songList.add(newSong);
            return "New song has been added successfully.";
        }
    }

    //Searching from track number
    public String addSongToPlaylist ( int trackNo, LinkedList<Song > playList){

        //TrackNo = index + 1
        int index = trackNo - 1;

        //Checking for validity
        if (index >= 0 && index < this.songList.size()) {

            Song song = this.songList.get(index);
            playList.add(song);

            return "Song has been added successfully.";
        }
        return "Invalid track no.";
    }

    //Searching from title name
    public String addSongToPlaylist(String title, LinkedList<Song> playList){

        for(Song song: songList){
            if(song.title == title){
                playList.add(song);
                return "Song haas been added successfully";
            }
        }
        return "Song doesn't exist";
    }
}

