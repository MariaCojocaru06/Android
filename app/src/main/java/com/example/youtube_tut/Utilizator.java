package com.example.youtube_tut;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "utilizator")
public class Utilizator implements Parcelable {
@PrimaryKey(autoGenerate = true)
private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ColumnInfo(name = "nume")
    private String nume;
    @ColumnInfo(name = "prenume")
    private String prenume;
    @ColumnInfo(name = "data")
    private String data;
    @ColumnInfo(name = "email")
    private String email;
    @ColumnInfo(name = "parola")
    private String parola;

    public Utilizator(String nume, String prenume, String data, String email, String parola) {
        this.nume = nume;
        this.prenume = prenume;
        this.data = data;
        this.email = email;
        this.parola = parola;
    }

    public Utilizator(String email, String parola) {
        this.email = email;
        this.parola = parola;
    }

    public Utilizator() {
    }

    protected Utilizator(Parcel in) {
        nume = in.readString();
        prenume = in.readString();
        data = in.readString();
        email = in.readString();
        parola = in.readString();
    }

    public static final Creator<Utilizator> CREATOR = new Creator<Utilizator>() {
        @Override
        public Utilizator createFromParcel(Parcel in) {
            return new Utilizator(in);
        }

        @Override
        public Utilizator[] newArray(int size) {
            return new Utilizator[size];
        }
    };

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    @Override
    public String toString() {
        return "Utilizator{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", data='" + data + '\'' +
                ", email='" + email + '\'' +
                ", parola='" + parola + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nume);
        dest.writeString(prenume);
        dest.writeString(data);
        dest.writeString(email);
        dest.writeString(parola);
    }
}

