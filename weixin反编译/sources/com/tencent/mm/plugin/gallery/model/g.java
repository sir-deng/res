package com.tencent.mm.plugin.gallery.model;

import com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import java.util.ArrayList;

public interface g {

    public interface b {
        void a(ArrayList<MediaItem> arrayList, long j);
    }

    public interface c {
        void a(ArrayList<MediaItem> arrayList, long j);
    }

    public interface a {
        void x(ArrayList<AlbumItem> arrayList);
    }

    ArrayList<MediaItem> a(String str, int i, c cVar, long j);

    ArrayList<AlbumItem> aOF();

    void aOG();
}
