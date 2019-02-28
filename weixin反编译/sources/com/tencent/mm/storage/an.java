package com.tencent.mm.storage;

import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;

public final class an {
    public static final an xHp = new an("timeline");
    public static final an xHq = new an("album_friend");
    public static final an xHr = new an("album_self");
    public static final an xHs = new an("album_stranger");
    public static final an xHt = new an("profile_friend");
    public static final an xHu = new an("profile_stranger");
    public static final an xHv = new an(FFmpegMetadataRetriever.METADATA_KEY_COMMENT);
    public static final an xHw = new an("comment_detail");
    public static final an xHx = new an("other");
    public static final an xHy = new an("snssight");
    public static final an xHz = new an("fts");
    public String tag = "";
    public int time = 0;

    public static an cjD() {
        return new an("timeline");
    }

    public static an cjE() {
        return new an("album_friend");
    }

    public static an cjF() {
        return new an("album_self");
    }

    public static an cjG() {
        return new an("album_stranger");
    }

    public static an cjH() {
        return new an("comment_detail");
    }

    public static an cjI() {
        return new an("snssight");
    }

    public an(String str) {
        this.tag = str;
    }

    public final an DI(int i) {
        this.time = i;
        return this;
    }

    public static an a(an anVar, int i) {
        an anVar2 = new an(anVar.tag);
        anVar2.time = i;
        return anVar2;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof an) {
            return ((an) obj).tag.equals(this.tag);
        }
        return super.equals(obj);
    }

    public final String toString() {
        return this.tag + "@" + this.time;
    }
}
