package com.company;

import java.util.*;

public class FavGenre {
    public static Map<String, List<String>> favoriteGenre(Map<String, List<String>> userSongs, Map<String, List<String>> songsGenre) {
        Map<String, List<String>> result = new HashMap<>();
        Map<String, String> songstogenre = new HashMap<>();

        for(String genre: songsGenre.keySet()) {
            List<String> songs = songsGenre.get(genre);
            for(String song:songs) {
                songstogenre.put(song, genre);
            }
        }
        Map<String, Map<String, Integer>> usergenrecount = new HashMap<>();
        for(String user: userSongs.keySet()) {
            usergenrecount.put(user, new HashMap<>());
            List<String> songs = userSongs.get(user);
            for(String song: songs) {
                String genre = songstogenre.get(song);
                int count = usergenrecount.get(user).getOrDefault(genre, 0) + 1;
                usergenrecount.get(user).put(genre, count);

            }
        }
        for(String user: usergenrecount.keySet()) {
            if(!result.containsKey(user)) {
                result.put(user, new ArrayList<>());
            }
            Map<String, Integer> pair = usergenrecount.get(user);
            int max = 0;
            List<String> favGenre = new ArrayList<>();
            for(String genre : pair.keySet()) {
                if(favGenre.size() == 0) {
                    favGenre.add(genre);
                    max = pair.get(genre);
                } else if(pair.get(genre) > max) {
                    favGenre.clear();
                    favGenre.add(genre);
                    max = pair.get(genre);
                } else if(pair.get(genre) == max)
                    favGenre.add(genre);
            }


        }

        return result;
    }
    public static void main(String[] args) {
        HashMap<String, List<String>> userSongs = new HashMap<>();
        HashMap<String, List<String>> songGenres = new HashMap<>();
        List<String> list1 = Arrays.asList("song1", "song2", "song3", "song4", "song8");
        List<String> list2 = Arrays.asList("song5", "song6", "song7");
        userSongs.put("David", list1);
        userSongs.put("Emma", list2);
        List<String> list3 = Arrays.asList("song1", "song3");
        List<String> list4 = Arrays.asList("song7");
        List<String> list5 = Arrays.asList("song2", "song4");
        List<String> list6 = Arrays.asList("song5", "song6");
        List<String> list7 = Arrays.asList("song8", "song9");
        songGenres.put("Rock", list3);
        songGenres.put("Dubstep", list4);
        songGenres.put("Techno", list5);
        songGenres.put("Pop", list6);
        songGenres.put("Jazz", list7);
        System.out.print(favoriteGenre(userSongs, songGenres));

    }
}
