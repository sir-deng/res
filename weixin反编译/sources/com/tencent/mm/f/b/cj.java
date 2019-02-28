package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public abstract class cj extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fOi = "startTime".hashCode();
    private static final int fPG = "appId".hashCode();
    private static final int fQa = "updateTime".hashCode();
    private static final int glL = "musicId".hashCode();
    private static final int glM = "originMusicId".hashCode();
    private static final int glN = "musicType".hashCode();
    private static final int glO = "downloadedLength".hashCode();
    private static final int glP = "wifiDownloadedLength".hashCode();
    private static final int glQ = "endFlag".hashCode();
    private static final int glR = "wifiEndFlag".hashCode();
    private static final int glS = "songId".hashCode();
    private static final int glT = "songName".hashCode();
    private static final int glU = "songSinger".hashCode();
    private static final int glV = "songAlbum".hashCode();
    private static final int glW = "songAlbumType".hashCode();
    private static final int glX = "songAlbumUrl".hashCode();
    private static final int glY = "songHAlbumUrl".hashCode();
    private static final int glZ = "songAlbumLocalPath".hashCode();
    private static final int gma = "songWifiUrl".hashCode();
    private static final int gmb = "songWapLinkUrl".hashCode();
    private static final int gmc = "songWebUrl".hashCode();
    private static final int gmd = "songMediaId".hashCode();
    private static final int gme = "songSnsAlbumUser".hashCode();
    private static final int gmf = "songSnsShareUser".hashCode();
    private static final int gmg = "songLyric".hashCode();
    private static final int gmh = "songBgColor".hashCode();
    private static final int gmi = "songLyricColor".hashCode();
    private static final int gmj = "songFileLength".hashCode();
    private static final int gmk = "songWifiFileLength".hashCode();
    private static final int gml = "hideBanner".hashCode();
    private static final int gmm = "jsWebUrlDomain".hashCode();
    private static final int gmn = "isBlock".hashCode();
    private static final int gmo = "mimetype".hashCode();
    private static final int gmp = "protocol".hashCode();
    private static final int gmq = "barBackToWebView".hashCode();
    private static final int gmr = "musicbar_url".hashCode();
    private boolean fOa = true;
    private boolean fPY = true;
    private boolean fPp = true;
    public String field_appId;
    public boolean field_barBackToWebView;
    public long field_downloadedLength;
    public int field_endFlag;
    public boolean field_hideBanner;
    public int field_isBlock;
    public String field_jsWebUrlDomain;
    public String field_mimetype;
    public String field_musicId;
    public int field_musicType;
    public String field_musicbar_url;
    public String field_originMusicId;
    public String field_protocol;
    public String field_songAlbum;
    public String field_songAlbumLocalPath;
    public int field_songAlbumType;
    public String field_songAlbumUrl;
    public int field_songBgColor;
    public long field_songFileLength;
    public String field_songHAlbumUrl;
    public int field_songId;
    public String field_songLyric;
    public int field_songLyricColor;
    public String field_songMediaId;
    public String field_songName;
    public String field_songSinger;
    public String field_songSnsAlbumUser;
    public String field_songSnsShareUser;
    public String field_songWapLinkUrl;
    public String field_songWebUrl;
    public long field_songWifiFileLength;
    public String field_songWifiUrl;
    public int field_startTime;
    public long field_updateTime;
    public long field_wifiDownloadedLength;
    public int field_wifiEndFlag;
    private boolean glA = true;
    private boolean glB = true;
    private boolean glC = true;
    private boolean glD = true;
    private boolean glE = true;
    private boolean glF = true;
    private boolean glG = true;
    private boolean glH = true;
    private boolean glI = true;
    private boolean glJ = true;
    private boolean glK = true;
    private boolean gle = true;
    private boolean glf = true;
    private boolean glg = true;
    private boolean glh = true;
    private boolean gli = true;
    private boolean glj = true;
    private boolean glk = true;
    private boolean gll = true;
    private boolean glm = true;
    private boolean gln = true;
    private boolean glo = true;
    private boolean glp = true;
    private boolean glq = true;
    private boolean glr = true;
    private boolean gls = true;
    private boolean glt = true;
    private boolean glu = true;
    private boolean glv = true;
    private boolean glw = true;
    private boolean glx = true;
    private boolean gly = true;
    private boolean glz = true;

    public static a vQ() {
        a aVar = new a();
        aVar.hUM = new Field[36];
        aVar.columns = new String[37];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "musicId";
        aVar.xrT.put("musicId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" musicId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xrS = "musicId";
        aVar.columns[1] = "originMusicId";
        aVar.xrT.put("originMusicId", "TEXT");
        stringBuilder.append(" originMusicId TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "musicType";
        aVar.xrT.put("musicType", "INTEGER");
        stringBuilder.append(" musicType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "downloadedLength";
        aVar.xrT.put("downloadedLength", "LONG");
        stringBuilder.append(" downloadedLength LONG");
        stringBuilder.append(", ");
        aVar.columns[4] = "wifiDownloadedLength";
        aVar.xrT.put("wifiDownloadedLength", "LONG");
        stringBuilder.append(" wifiDownloadedLength LONG");
        stringBuilder.append(", ");
        aVar.columns[5] = "endFlag";
        aVar.xrT.put("endFlag", "INTEGER");
        stringBuilder.append(" endFlag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "wifiEndFlag";
        aVar.xrT.put("wifiEndFlag", "INTEGER");
        stringBuilder.append(" wifiEndFlag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[7] = "updateTime";
        aVar.xrT.put("updateTime", "LONG");
        stringBuilder.append(" updateTime LONG");
        stringBuilder.append(", ");
        aVar.columns[8] = "songId";
        aVar.xrT.put("songId", "INTEGER");
        stringBuilder.append(" songId INTEGER");
        stringBuilder.append(", ");
        aVar.columns[9] = "songName";
        aVar.xrT.put("songName", "TEXT");
        stringBuilder.append(" songName TEXT");
        stringBuilder.append(", ");
        aVar.columns[10] = "songSinger";
        aVar.xrT.put("songSinger", "TEXT");
        stringBuilder.append(" songSinger TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "songAlbum";
        aVar.xrT.put("songAlbum", "TEXT");
        stringBuilder.append(" songAlbum TEXT");
        stringBuilder.append(", ");
        aVar.columns[12] = "songAlbumType";
        aVar.xrT.put("songAlbumType", "INTEGER");
        stringBuilder.append(" songAlbumType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[13] = "songAlbumUrl";
        aVar.xrT.put("songAlbumUrl", "TEXT");
        stringBuilder.append(" songAlbumUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[14] = "songHAlbumUrl";
        aVar.xrT.put("songHAlbumUrl", "TEXT");
        stringBuilder.append(" songHAlbumUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[15] = "songAlbumLocalPath";
        aVar.xrT.put("songAlbumLocalPath", "TEXT");
        stringBuilder.append(" songAlbumLocalPath TEXT");
        stringBuilder.append(", ");
        aVar.columns[16] = "songWifiUrl";
        aVar.xrT.put("songWifiUrl", "TEXT");
        stringBuilder.append(" songWifiUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[17] = "songWapLinkUrl";
        aVar.xrT.put("songWapLinkUrl", "TEXT");
        stringBuilder.append(" songWapLinkUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[18] = "songWebUrl";
        aVar.xrT.put("songWebUrl", "TEXT");
        stringBuilder.append(" songWebUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[19] = "appId";
        aVar.xrT.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[20] = "songMediaId";
        aVar.xrT.put("songMediaId", "TEXT");
        stringBuilder.append(" songMediaId TEXT");
        stringBuilder.append(", ");
        aVar.columns[21] = "songSnsAlbumUser";
        aVar.xrT.put("songSnsAlbumUser", "TEXT");
        stringBuilder.append(" songSnsAlbumUser TEXT");
        stringBuilder.append(", ");
        aVar.columns[22] = "songSnsShareUser";
        aVar.xrT.put("songSnsShareUser", "TEXT");
        stringBuilder.append(" songSnsShareUser TEXT");
        stringBuilder.append(", ");
        aVar.columns[23] = "songLyric";
        aVar.xrT.put("songLyric", "TEXT");
        stringBuilder.append(" songLyric TEXT");
        stringBuilder.append(", ");
        aVar.columns[24] = "songBgColor";
        aVar.xrT.put("songBgColor", "INTEGER");
        stringBuilder.append(" songBgColor INTEGER");
        stringBuilder.append(", ");
        aVar.columns[25] = "songLyricColor";
        aVar.xrT.put("songLyricColor", "INTEGER");
        stringBuilder.append(" songLyricColor INTEGER");
        stringBuilder.append(", ");
        aVar.columns[26] = "songFileLength";
        aVar.xrT.put("songFileLength", "LONG");
        stringBuilder.append(" songFileLength LONG");
        stringBuilder.append(", ");
        aVar.columns[27] = "songWifiFileLength";
        aVar.xrT.put("songWifiFileLength", "LONG");
        stringBuilder.append(" songWifiFileLength LONG");
        stringBuilder.append(", ");
        aVar.columns[28] = "hideBanner";
        aVar.xrT.put("hideBanner", "INTEGER");
        stringBuilder.append(" hideBanner INTEGER");
        stringBuilder.append(", ");
        aVar.columns[29] = "jsWebUrlDomain";
        aVar.xrT.put("jsWebUrlDomain", "TEXT");
        stringBuilder.append(" jsWebUrlDomain TEXT");
        stringBuilder.append(", ");
        aVar.columns[30] = "isBlock";
        aVar.xrT.put("isBlock", "INTEGER");
        stringBuilder.append(" isBlock INTEGER");
        stringBuilder.append(", ");
        aVar.columns[31] = "startTime";
        aVar.xrT.put("startTime", "INTEGER");
        stringBuilder.append(" startTime INTEGER");
        stringBuilder.append(", ");
        aVar.columns[32] = "mimetype";
        aVar.xrT.put("mimetype", "TEXT");
        stringBuilder.append(" mimetype TEXT");
        stringBuilder.append(", ");
        aVar.columns[33] = "protocol";
        aVar.xrT.put("protocol", "TEXT");
        stringBuilder.append(" protocol TEXT");
        stringBuilder.append(", ");
        aVar.columns[34] = "barBackToWebView";
        aVar.xrT.put("barBackToWebView", "INTEGER");
        stringBuilder.append(" barBackToWebView INTEGER");
        stringBuilder.append(", ");
        aVar.columns[35] = "musicbar_url";
        aVar.xrT.put("musicbar_url", "TEXT");
        stringBuilder.append(" musicbar_url TEXT");
        aVar.columns[36] = "rowid";
        aVar.xrU = stringBuilder.toString();
        return aVar;
    }

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (glL == hashCode) {
                    this.field_musicId = cursor.getString(i);
                    this.gle = true;
                } else if (glM == hashCode) {
                    this.field_originMusicId = cursor.getString(i);
                } else if (glN == hashCode) {
                    this.field_musicType = cursor.getInt(i);
                } else if (glO == hashCode) {
                    this.field_downloadedLength = cursor.getLong(i);
                } else if (glP == hashCode) {
                    this.field_wifiDownloadedLength = cursor.getLong(i);
                } else if (glQ == hashCode) {
                    this.field_endFlag = cursor.getInt(i);
                } else if (glR == hashCode) {
                    this.field_wifiEndFlag = cursor.getInt(i);
                } else if (fQa == hashCode) {
                    this.field_updateTime = cursor.getLong(i);
                } else if (glS == hashCode) {
                    this.field_songId = cursor.getInt(i);
                } else if (glT == hashCode) {
                    this.field_songName = cursor.getString(i);
                } else if (glU == hashCode) {
                    this.field_songSinger = cursor.getString(i);
                } else if (glV == hashCode) {
                    this.field_songAlbum = cursor.getString(i);
                } else if (glW == hashCode) {
                    this.field_songAlbumType = cursor.getInt(i);
                } else if (glX == hashCode) {
                    this.field_songAlbumUrl = cursor.getString(i);
                } else if (glY == hashCode) {
                    this.field_songHAlbumUrl = cursor.getString(i);
                } else if (glZ == hashCode) {
                    this.field_songAlbumLocalPath = cursor.getString(i);
                } else if (gma == hashCode) {
                    this.field_songWifiUrl = cursor.getString(i);
                } else if (gmb == hashCode) {
                    this.field_songWapLinkUrl = cursor.getString(i);
                } else if (gmc == hashCode) {
                    this.field_songWebUrl = cursor.getString(i);
                } else if (fPG == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (gmd == hashCode) {
                    this.field_songMediaId = cursor.getString(i);
                } else if (gme == hashCode) {
                    this.field_songSnsAlbumUser = cursor.getString(i);
                } else if (gmf == hashCode) {
                    this.field_songSnsShareUser = cursor.getString(i);
                } else if (gmg == hashCode) {
                    this.field_songLyric = cursor.getString(i);
                } else if (gmh == hashCode) {
                    this.field_songBgColor = cursor.getInt(i);
                } else if (gmi == hashCode) {
                    this.field_songLyricColor = cursor.getInt(i);
                } else if (gmj == hashCode) {
                    this.field_songFileLength = cursor.getLong(i);
                } else if (gmk == hashCode) {
                    this.field_songWifiFileLength = cursor.getLong(i);
                } else if (gml == hashCode) {
                    this.field_hideBanner = cursor.getInt(i) != 0;
                } else if (gmm == hashCode) {
                    this.field_jsWebUrlDomain = cursor.getString(i);
                } else if (gmn == hashCode) {
                    this.field_isBlock = cursor.getInt(i);
                } else if (fOi == hashCode) {
                    this.field_startTime = cursor.getInt(i);
                } else if (gmo == hashCode) {
                    this.field_mimetype = cursor.getString(i);
                } else if (gmp == hashCode) {
                    this.field_protocol = cursor.getString(i);
                } else if (gmq == hashCode) {
                    this.field_barBackToWebView = cursor.getInt(i) != 0;
                } else if (gmr == hashCode) {
                    this.field_musicbar_url = cursor.getString(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.gle) {
            contentValues.put("musicId", this.field_musicId);
        }
        if (this.glf) {
            contentValues.put("originMusicId", this.field_originMusicId);
        }
        if (this.glg) {
            contentValues.put("musicType", Integer.valueOf(this.field_musicType));
        }
        if (this.glh) {
            contentValues.put("downloadedLength", Long.valueOf(this.field_downloadedLength));
        }
        if (this.gli) {
            contentValues.put("wifiDownloadedLength", Long.valueOf(this.field_wifiDownloadedLength));
        }
        if (this.glj) {
            contentValues.put("endFlag", Integer.valueOf(this.field_endFlag));
        }
        if (this.glk) {
            contentValues.put("wifiEndFlag", Integer.valueOf(this.field_wifiEndFlag));
        }
        if (this.fPY) {
            contentValues.put("updateTime", Long.valueOf(this.field_updateTime));
        }
        if (this.gll) {
            contentValues.put("songId", Integer.valueOf(this.field_songId));
        }
        if (this.glm) {
            contentValues.put("songName", this.field_songName);
        }
        if (this.gln) {
            contentValues.put("songSinger", this.field_songSinger);
        }
        if (this.glo) {
            contentValues.put("songAlbum", this.field_songAlbum);
        }
        if (this.glp) {
            contentValues.put("songAlbumType", Integer.valueOf(this.field_songAlbumType));
        }
        if (this.glq) {
            contentValues.put("songAlbumUrl", this.field_songAlbumUrl);
        }
        if (this.glr) {
            contentValues.put("songHAlbumUrl", this.field_songHAlbumUrl);
        }
        if (this.gls) {
            contentValues.put("songAlbumLocalPath", this.field_songAlbumLocalPath);
        }
        if (this.glt) {
            contentValues.put("songWifiUrl", this.field_songWifiUrl);
        }
        if (this.glu) {
            contentValues.put("songWapLinkUrl", this.field_songWapLinkUrl);
        }
        if (this.glv) {
            contentValues.put("songWebUrl", this.field_songWebUrl);
        }
        if (this.fPp) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.glw) {
            contentValues.put("songMediaId", this.field_songMediaId);
        }
        if (this.glx) {
            contentValues.put("songSnsAlbumUser", this.field_songSnsAlbumUser);
        }
        if (this.gly) {
            contentValues.put("songSnsShareUser", this.field_songSnsShareUser);
        }
        if (this.glz) {
            contentValues.put("songLyric", this.field_songLyric);
        }
        if (this.glA) {
            contentValues.put("songBgColor", Integer.valueOf(this.field_songBgColor));
        }
        if (this.glB) {
            contentValues.put("songLyricColor", Integer.valueOf(this.field_songLyricColor));
        }
        if (this.glC) {
            contentValues.put("songFileLength", Long.valueOf(this.field_songFileLength));
        }
        if (this.glD) {
            contentValues.put("songWifiFileLength", Long.valueOf(this.field_songWifiFileLength));
        }
        if (this.glE) {
            contentValues.put("hideBanner", Boolean.valueOf(this.field_hideBanner));
        }
        if (this.glF) {
            contentValues.put("jsWebUrlDomain", this.field_jsWebUrlDomain);
        }
        if (this.glG) {
            contentValues.put("isBlock", Integer.valueOf(this.field_isBlock));
        }
        if (this.fOa) {
            contentValues.put("startTime", Integer.valueOf(this.field_startTime));
        }
        if (this.glH) {
            contentValues.put("mimetype", this.field_mimetype);
        }
        if (this.glI) {
            contentValues.put("protocol", this.field_protocol);
        }
        if (this.glJ) {
            contentValues.put("barBackToWebView", Boolean.valueOf(this.field_barBackToWebView));
        }
        if (this.glK) {
            contentValues.put("musicbar_url", this.field_musicbar_url);
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
