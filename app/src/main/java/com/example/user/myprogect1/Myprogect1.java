package com.example.user.myprogect1;

import java.util.Objects;

public class Mem
{
    private long id;
    private string link; // путь до файла в телефоне

    public Mem(string link) {
        this(0, link);
    }

    public Mem(long id, string link) {
        this.id = id;
        this.link = link;
    }
}