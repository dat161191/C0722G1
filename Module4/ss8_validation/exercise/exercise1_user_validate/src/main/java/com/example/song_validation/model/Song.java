package com.example.song_validation.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Pattern(regexp ="^([A-Z][a-z]+[ ])+([A-Z][a-z]+)$",message = "Định dạng tên bài hát sai!Vui lòng nhập lại")
    private String songName;
    @Pattern(regexp ="^([A-Z][a-z]+[ ])+([A-Z][a-z]+)$",message = "Định dạng tên Nghệ Sĩ sai!Vui lòng nhập lại")
    private String artist;

    @Pattern(regexp ="^([A-Z][a-z]+)+[,]*([A-Z][a-z]+)*$",message = "Định dạng thể loại nhạc sai!Vui lòng nhập lại")
    private String genre;
    public Song() {
    }

    public Song(Integer id, String songName, String artist, String genre) {
        this.id = id;
        this.songName = songName;
        this.artist = artist;
        this.genre = genre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

}
