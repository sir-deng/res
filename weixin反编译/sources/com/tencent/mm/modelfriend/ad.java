package com.tencent.mm.modelfriend;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.wcdb.FileUtils;

public final class ad {
    int fEo = -1;
    public String fqG = "";
    String hnc = "";
    String hnd = "";
    public int hne = 0;
    public int hnf = 0;
    public long hyC = 0;
    public int hyD = 0;
    int hyE = 0;
    String hyF = "";
    String hyG = "";
    String hyH = "";
    String hyI = "";
    String hyJ = "";
    public String hyK = "";
    String hyL = "";
    String hyM = "";
    public String username = "";

    public final void b(Cursor cursor) {
        this.hyC = cursor.getLong(0);
        int i = cursor.getInt(1);
        if (i == 65536) {
            this.hyD = 0;
        } else {
            this.hyD = i;
        }
        this.hyE = cursor.getInt(2);
        this.username = cursor.getString(3);
        this.fqG = cursor.getString(4);
        this.hyF = cursor.getString(5);
        this.hyG = cursor.getString(6);
        this.hyH = cursor.getString(7);
        this.hyI = cursor.getString(8);
        this.hyJ = cursor.getString(9);
        this.hyK = cursor.getString(10);
        this.hyL = cursor.getString(11);
        this.hyM = cursor.getString(12);
        this.hnc = cursor.getString(13);
        this.hnd = cursor.getString(14);
        this.hne = cursor.getInt(15);
        this.hnf = cursor.getInt(16);
    }

    public final ContentValues OA() {
        ContentValues contentValues = new ContentValues();
        if ((this.fEo & 1) != 0) {
            contentValues.put("qq", Long.valueOf(this.hyC));
        }
        if ((this.fEo & 2) != 0) {
            int i = this.hyD;
            if (i == 0) {
                contentValues.put("wexinstatus", Integer.valueOf(65536));
            } else {
                contentValues.put("wexinstatus", Integer.valueOf(i));
            }
        }
        if ((this.fEo & 4) != 0) {
            contentValues.put("groupid", Integer.valueOf(this.hyE));
        }
        if ((this.fEo & 8) != 0) {
            contentValues.put("username", getUsername());
        }
        if ((this.fEo & 16) != 0) {
            contentValues.put("nickname", vW());
        }
        if ((this.fEo & 32) != 0) {
            contentValues.put("pyinitial", this.hyF == null ? "" : this.hyF);
        }
        if ((this.fEo & 64) != 0) {
            contentValues.put("quanpin", this.hyG == null ? "" : this.hyG);
        }
        if ((this.fEo & FileUtils.S_IWUSR) != 0) {
            contentValues.put("qqnickname", OB());
        }
        if ((this.fEo & 256) != 0) {
            contentValues.put("qqpyinitial", OC());
        }
        if ((this.fEo & WXMediaMessage.TITLE_LENGTH_LIMIT) != 0) {
            contentValues.put("qqquanpin", OD());
        }
        if ((this.fEo & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            contentValues.put("qqremark", OE());
        }
        if ((this.fEo & 2048) != 0) {
            contentValues.put("qqremarkpyinitial", OF());
        }
        if ((this.fEo & Downloads.RECV_BUFFER_SIZE) != 0) {
            contentValues.put("qqremarkquanpin", OG());
        }
        if ((this.fEo & 16384) != 0) {
            contentValues.put("reserved2", this.hnd == null ? "" : this.hnd);
        }
        if ((this.fEo & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0) {
            contentValues.put("reserved3", Integer.valueOf(this.hne));
        }
        if ((this.fEo & 65536) != 0) {
            contentValues.put("reserved4", Integer.valueOf(this.hnf));
        }
        return contentValues;
    }

    public final String getUsername() {
        return this.username == null ? "" : this.username;
    }

    public final String vW() {
        return this.fqG == null ? "" : this.fqG;
    }

    public final String OB() {
        return this.hyH == null ? "" : this.hyH;
    }

    public final String OC() {
        return this.hyI == null ? "" : this.hyI;
    }

    public final String OD() {
        return this.hyJ == null ? "" : this.hyJ;
    }

    public final String OE() {
        return this.hyK == null ? "" : this.hyK;
    }

    public final String OF() {
        return this.hyL == null ? "" : this.hyL;
    }

    public final String OG() {
        return this.hyM == null ? "" : this.hyM;
    }

    public final String getDisplayName() {
        if (OE() == null || OE().length() <= 0) {
            return OB();
        }
        return OE();
    }

    public final void OH() {
        this.hne |= 1;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("groupID\t:").append(this.hyE).append("\n");
        stringBuilder.append("qq\t:").append(this.hyC).append("\n");
        stringBuilder.append("username\t:").append(this.username).append("\n");
        stringBuilder.append("nickname\t:").append(this.fqG).append("\n");
        stringBuilder.append("wexinStatus\t:").append(this.hyD).append("\n");
        stringBuilder.append("reserved3\t:").append(this.hne).append("\n");
        stringBuilder.append("reserved4\t:").append(this.hnf).append("\n");
        return stringBuilder.toString();
    }
}
