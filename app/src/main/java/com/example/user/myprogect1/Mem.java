package com.example.user.myprogect1;

import java.util.Objects;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "mems")
public class Mem {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private String link; // путь до файла в телефоне
    private String comment;

    public Mem(String link, String comment) {
        this(0, link, comment);
    }

    @Ignore
    public Mem(long id, String link, String comment) {
        this.id = id;
        this.link = link;
        this.comment = comment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mem mem = (Mem) o;
        return id == mem.id &&
                Objects.equals(link, mem.link) &&
                Objects.equals(comment, mem.comment);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, link, comment);
    }
}
