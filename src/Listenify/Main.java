package Listenify;

import java.util.*;

public class Main {

    public static List<Album> albums = new ArrayList<>();
    public static void main(String[] args) {

        Album album1 = new Album("Hindi Songs","Arijit Singh");

        album1.addSongToAlbum("Pathaan",4.5);
        album1.addSongToAlbum("Channa mereya",3.5);
        album1.addSongToAlbum("Naina",5.0);

        albums.add(album1);

        Album album2 = new Album("New Songs","Prateek Kuhad");

        album2.addSongToAlbum("Kasoor",4.5);
        album2.addSongToAlbum("Tum mile",3.5);
        album2.addSongToAlbum("Baarishein",4.5);

        albums.add(album2);

        LinkedList<Song> playList_1 = new LinkedList<>();

        albums.get(0).addSongToPlaylist("Pathaan",playList_1);
        albums.get(0).addSongToPlaylist("Naina",playList_1);
        albums.get(1).addSongToPlaylist("Kasoor",playList_1);
        albums.get(1).addSongToPlaylist("Baarishein",playList_1);
        albums.get(1).addSongToPlaylist("Tum mile",playList_1);

        //print the playList that has been added
        play(playList_1);
    }

    public static void play(LinkedList<Song> playList){

        ListIterator<Song> listIterator = playList.listIterator();

        //Validation check
        if(playList.size() == 0){
            return;
        }

        Scanner sc = new Scanner(System.in);

        printMenu();

        System.out.println("Now "+listIterator.next());

        boolean forward = true;

        boolean quit = false;

        while(!quit){

            int choice = sc.nextInt();

            switch (choice){
                case 0:
                    quit = true;
                    break;

                case 1:
                    if(!forward) {
                        listIterator.next();
                        forward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println(listIterator.next().toString());
                    }
                    else{
                        System.out.println("You are at the last song");
                    }
                    //To play the next Song
                    break;

                case 2:
                    if(forward){                                //already towards the right of the last printed value
                        listIterator.previous();
                        forward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println(listIterator.previous().toString());
                    }else{
                        System.out.println("You are already at the first Song");
                    }
                    //To the previous Song
                    break;

                case 3:
                    if(forward){                                //I am on RHS : print the previous song
                        System.out.println(listIterator.previous().toString());
                        forward = false;
                    }
                    else{                                       //forward is false and I am on the LHS
                        System.out.println(listIterator.next().toString());
                        forward = true;
                    }
                    //Replay the current song
                    break;

                case 4:
                    printAllSongs(playList);
                    break;

                case 5:
                    printMenu();
                    break;

                case 6:
                    //Delete a song
                    if (playList.size() > 0) {
                        System.out.println(listIterator.previous().toString() + " has been removed from the playlist.");
                        listIterator.remove();

                        if (playList.size()>0 && listIterator.hasPrevious()) {
                            System.out.println("Now playing " + listIterator.next().toString());
                        }
                        else if (playList.size()>0 && listIterator.hasNext()) {
                            System.out.println("Now playing " + listIterator.previous().toString());
                        }
                    }
                    else {
                        System.out.println("The playlist is empty.");
                    }
                    break;
            }
        }
    }

    private static void printAllSongs(LinkedList<Song> songs){

        //Try for each loop
        ListIterator<Song> listIterator = songs.listIterator();

        while(listIterator.hasNext()){
            System.out.println(listIterator.next().toString());
        }
    }

    private static void printMenu(){
        System.out.println("Available options\n press");
        System.out.println("0 - to quit\n"+
                "1 - to play next song\n"+
                "2 - to play previous song\n"+
                "3 - to replay the current song\n"+
                "4 - list of all songs \n"+
                "5 - print all available options\n"+
                "6 - delete current song");
    }
}