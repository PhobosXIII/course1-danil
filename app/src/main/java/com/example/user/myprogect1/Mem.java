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

    public Mem(String link) {
        this(0, link);
    }

    @Ignore
    public Mem(long id, String link) {
        this.id = id;
        this.link = link;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mem mem = (Mem) o;
        return id == mem.id &&
                Objects.equals(link, mem.link);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, link);
    }
}
