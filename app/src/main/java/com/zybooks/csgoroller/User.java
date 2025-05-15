package com.zybooks.csgoroller;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class User {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private long id;

    @ColumnInfo(name = "usr")
    private String username;

    @ColumnInfo(name = "pwd")
    private String password;

    @ColumnInfo(name = "kOpened")
    private int numKilowattsOpened;

    @ColumnInfo(name = "eOpened")
    private int numEsportsOpened;

    @ColumnInfo(name = "dOpened")
    private int numDreamsAndNightmaresOpened;

    @ColumnInfo(name = "nw")
    private double netWorth;

    public User() {
    }

    public User(String u, String p) {
        username = u;
        password = p;
        numKilowattsOpened = 0;
        numEsportsOpened = 0;
        numDreamsAndNightmaresOpened = 0;
        netWorth = 0.0;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public int getNumKilowattsOpened()  { return numKilowattsOpened; }
    public void setNumKilowattsOpened(int n)  { numKilowattsOpened = n; }

    public int getNumEsportsOpened()  { return numEsportsOpened; }
    public void setNumEsportsOpened(int n)  { numEsportsOpened = n; }

    public int getNumDreamsAndNightmaresOpened()  { return numDreamsAndNightmaresOpened; }
    public void setNumDreamsAndNightmaresOpened(int n)   { numDreamsAndNightmaresOpened = n; }

    public double getNetWorth() { return netWorth; }
    public void setNetWorth(double n)   { netWorth = n; }
}
