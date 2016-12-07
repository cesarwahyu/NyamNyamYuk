package model;

import android.graphics.drawable.Drawable;

/**
 * Created by Cesar Wahyu Cahya A on 04/12/2016.
 */

public class Restoran {
    public String judul;
    public String deskripsi;
    public Drawable foto;

    public Restoran(String judul, String deskripsi, Drawable foto) {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.foto = foto;
    }
}
