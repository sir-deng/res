package com.tencent.mm.au;

import com.tencent.mm.f.b.cj;
import com.tencent.mm.protocal.c.ati;
import com.tencent.mm.sdk.platformtools.bi;

public final class a extends cj {
    public static com.tencent.mm.sdk.e.c.a gKN = cj.vQ();
    public String hJD;
    public String hJE;

    protected final com.tencent.mm.sdk.e.c.a Aj() {
        return gKN;
    }

    public final boolean Qs() {
        return (this.field_songBgColor == 0 || this.field_songLyricColor == 0) ? false : true;
    }

    public final boolean Qt() {
        return !bi.oN(this.field_songHAlbumUrl);
    }

    public final boolean e(int[] iArr) {
        return this.field_songBgColor == iArr[0] && this.field_songLyricColor == iArr[1];
    }

    public final boolean a(a aVar) {
        if (aVar == null) {
            return false;
        }
        return this.field_musicId.equals(aVar.field_musicId);
    }

    public final ati Qu() {
        ati ati = new ati();
        ati.wdd = this.field_originMusicId;
        ati.wHt = this.field_musicType;
        ati.nlV = this.field_appId;
        ati.wHx = this.field_songAlbum;
        ati.wHF = this.field_songAlbumType;
        ati.wHy = this.field_songAlbumUrl;
        ati.wHz = this.field_songWifiUrl;
        ati.wHv = this.field_songName;
        ati.wHw = this.field_songSinger;
        ati.wHA = this.field_songWapLinkUrl;
        ati.wHB = this.field_songWebUrl;
        ati.wHD = this.field_songAlbumLocalPath;
        ati.wgu = this.field_songMediaId;
        ati.wHJ = this.field_songSnsAlbumUser;
        ati.wHK = this.field_songSnsShareUser;
        ati.wHM = this.field_hideBanner;
        ati.wHN = this.field_jsWebUrlDomain;
        ati.hmd = this.field_startTime;
        ati.hJD = this.hJD;
        ati.protocol = this.field_protocol;
        ati.wHO = this.field_barBackToWebView;
        ati.wHP = this.field_musicbar_url;
        return ati;
    }
}
