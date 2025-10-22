package com.codegym.musicapp.model;

public class Song {
    private String title;
    private String artist;
    private String genre;
    private String filePath;

    public Song() {}

    public Song(String title, String artist, String genre, String filePath) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.filePath = filePath;
    }

    // Getters & Setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getArtist() { return artist; }
    public void setArtist(String artist) { this.artist = artist; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public String getFilePath() { return filePath; }
    public void setFilePath(String filePath) { this.filePath = filePath; }
}
