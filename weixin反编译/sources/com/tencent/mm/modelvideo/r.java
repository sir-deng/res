package com.tencent.mm.modelvideo;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.map.b;
import com.tencent.mm.plugin.appbrand.jsapi.map.j;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.protocal.c.aqp;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.wcdb.FileUtils;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.util.Map;

public final class r {
    String clientId = "";
    public int fAP = 0;
    public int fEo = -1;
    public String fEx = "";
    public long fGj = 0;
    public String fHB = "";
    public String fIf = "";
    public String fileName = "";
    public long hVO = 0;
    public String hVd = "";
    public int hWd = 0;
    public int hXA = 0;
    public String hXB = "";
    public int hXC = 0;
    public String hXD = "";
    public bnp hXE = new bnp();
    public aqp hXF = new aqp();
    public String hXn = "";
    public int hXp = 0;
    public int hXq = 0;
    public int hXr = 0;
    public long hXs = 0;
    public long hXt = 0;
    public long hXu = 0;
    public int hXv = 0;
    public int hXw = 0;
    public int hXx = 0;
    public int hXy = 0;
    public int hXz = 0;
    public int hmZ = 0;
    public int hvw = 0;
    public int status = 0;
    public int videoFormat = 0;

    public static String nu(String str) {
        try {
            Map y = bj.y(str, "msg");
            if (y != null) {
                return (String) y.get(".msg.videomsg.$cdnvideourl");
            }
        } catch (Exception e) {
        }
        return "";
    }

    public final void b(Cursor cursor) {
        this.fileName = cursor.getString(0);
        this.clientId = cursor.getString(1);
        this.fGj = cursor.getLong(2);
        this.hWd = cursor.getInt(3);
        this.hXp = cursor.getInt(4);
        this.hmZ = cursor.getInt(5);
        this.hXq = cursor.getInt(6);
        this.hXr = cursor.getInt(7);
        this.status = cursor.getInt(8);
        this.hXs = cursor.getLong(9);
        this.hXt = cursor.getLong(10);
        this.hXu = cursor.getLong(11);
        this.hXv = cursor.getInt(12);
        this.hXw = cursor.getInt(13);
        this.hXx = cursor.getInt(14);
        this.hXy = cursor.getInt(15);
        this.fEx = cursor.getString(16);
        this.hXn = cursor.getString(17);
        this.hXz = cursor.getInt(18);
        this.hXA = cursor.getInt(19);
        this.hVd = cursor.getString(20);
        this.hXB = cursor.getString(21);
        this.hXC = cursor.getInt(22);
        this.hVO = cursor.getLong(23);
        this.hXD = cursor.getString(24);
        this.fIf = cursor.getString(25);
        byte[] blob = cursor.getBlob(26);
        this.hXE = new bnp();
        try {
            this.hXE.aH(blob);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.VideoInfo", e, "", new Object[0]);
        }
        this.fHB = cursor.getString(27);
        this.hvw = cursor.getInt(28);
        blob = cursor.getBlob(29);
        this.hXF = new aqp();
        try {
            this.hXF.aH(blob);
        } catch (Exception e2) {
        }
        this.fAP = cursor.getInt(30);
        this.videoFormat = cursor.getInt(31);
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if ((this.fEo & 1) != 0) {
            contentValues.put(FFmpegMetadataRetriever.METADATA_KEY_FILENAME, getFileName());
        }
        if ((this.fEo & 2) != 0) {
            contentValues.put("clientid", this.clientId == null ? "" : this.clientId);
        }
        if ((this.fEo & 4) != 0) {
            contentValues.put("msgsvrid", Long.valueOf(this.fGj));
        }
        if ((this.fEo & 8) != 0) {
            contentValues.put("netoffset", Integer.valueOf(this.hWd));
        }
        if ((this.fEo & 16) != 0) {
            contentValues.put("filenowsize", Integer.valueOf(this.hXp));
        }
        if ((this.fEo & 32) != 0) {
            contentValues.put("totallen", Integer.valueOf(this.hmZ));
        }
        if ((this.fEo & 64) != 0) {
            contentValues.put("thumbnetoffset", Integer.valueOf(this.hXq));
        }
        if ((this.fEo & FileUtils.S_IWUSR) != 0) {
            contentValues.put("thumblen", Integer.valueOf(this.hXr));
        }
        if ((this.fEo & 256) != 0) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.status));
        }
        if ((this.fEo & WXMediaMessage.TITLE_LENGTH_LIMIT) != 0) {
            contentValues.put("createtime", Long.valueOf(this.hXs));
        }
        if ((this.fEo & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            contentValues.put("lastmodifytime", Long.valueOf(this.hXt));
        }
        if ((this.fEo & 2048) != 0) {
            contentValues.put("downloadtime", Long.valueOf(this.hXu));
        }
        if ((this.fEo & Downloads.RECV_BUFFER_SIZE) != 0) {
            contentValues.put("videolength", Integer.valueOf(this.hXv));
        }
        if ((this.fEo & 8192) != 0) {
            contentValues.put("msglocalid", Integer.valueOf(this.hXw));
        }
        if ((this.fEo & 16384) != 0) {
            contentValues.put("nettimes", Integer.valueOf(this.hXx));
        }
        if ((this.fEo & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0) {
            contentValues.put("cameratype", Integer.valueOf(this.hXy));
        }
        if ((this.fEo & 65536) != 0) {
            contentValues.put("user", Uk());
        }
        if ((this.fEo & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) != 0) {
            contentValues.put("human", Ul());
        }
        if ((this.fEo & 262144) != 0) {
            contentValues.put("reserved1", Integer.valueOf(this.hXz));
        }
        if ((this.fEo & SQLiteGlobal.journalSizeLimit) != 0) {
            contentValues.put("reserved2", Integer.valueOf(this.hXA));
        }
        if ((this.fEo & 1048576) != 0) {
            contentValues.put("reserved3", Um());
        }
        if ((this.fEo & 2097152) != 0) {
            contentValues.put("reserved4", Un());
        }
        if ((this.fEo & 4194304) != 0) {
            contentValues.put("videofuncflag", Integer.valueOf(this.hXC));
        }
        if ((this.fEo & 8388608) != 0) {
            contentValues.put("masssendid", Long.valueOf(this.hVO));
        }
        if ((this.fEo & 16777216) != 0) {
            contentValues.put("masssendlist", this.hXD);
        }
        if ((this.fEo & 33554432) != 0) {
            contentValues.put("videomd5", this.fIf);
        }
        if ((this.fEo & 67108864) != 0) {
            contentValues.put("streamvideo", Uj());
        }
        if ((this.fEo & 134217728) != 0) {
            contentValues.put("statextstr", this.fHB);
        }
        if ((this.fEo & SQLiteDatabase.CREATE_IF_NECESSARY) != 0) {
            contentValues.put("downloadscene", Integer.valueOf(this.hvw));
        }
        if ((this.fEo & SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING) != 0) {
            contentValues.put("mmsightextinfo", Ur());
        }
        if ((this.fEo & 1) != 0) {
            contentValues.put("preloadsize", Integer.valueOf(this.fAP));
        }
        if ((this.fEo & 2) != 0) {
            contentValues.put("videoformat", Integer.valueOf(this.videoFormat));
        }
        return contentValues;
    }

    private byte[] Uj() {
        byte[] bArr = new byte[0];
        try {
            return this.hXE.toByteArray();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.VideoInfo", e, "", new Object[0]);
            return bArr;
        }
    }

    public final String getFileName() {
        return this.fileName == null ? "" : this.fileName;
    }

    public final String Uk() {
        return this.fEx == null ? "" : this.fEx;
    }

    public final String Ul() {
        return this.hXn == null ? "" : this.hXn;
    }

    public final String Um() {
        return this.hVd == null ? "" : this.hVd;
    }

    public final String Un() {
        return this.hXB == null ? "" : this.hXB;
    }

    public final boolean Uo() {
        if (this.status == b.CTRL_INDEX || this.status == j.CTRL_INDEX || this.status == 142) {
            return true;
        }
        return false;
    }

    public final boolean Up() {
        if (this.status == 121 || this.status == 122 || this.status == 120 || this.status == 123) {
            return true;
        }
        return false;
    }

    public final boolean Uq() {
        if (this.status == 199 || this.status == 199) {
            return true;
        }
        return false;
    }

    private byte[] Ur() {
        byte[] bArr = new byte[0];
        try {
            return this.hXF.toByteArray();
        } catch (Exception e) {
            return bArr;
        }
    }
}
