package com.tencent.mm.plugin.shake.b;

import android.content.ContentValues;
import com.tencent.mm.f.b.dg;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.biz;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import com.tencent.wcdb.FileUtils;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.lang.reflect.Field;

public final class d extends dg {
    protected static a gKN;
    public int fEo;
    private bes qtM;
    public int scene;

    static {
        a aVar = new a();
        aVar.hUM = new Field[20];
        aVar.columns = new String[21];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "shakeItemID";
        aVar.xrT.put("shakeItemID", "INTEGER default '0'  PRIMARY KEY ");
        stringBuilder.append(" shakeItemID INTEGER default '0'  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xrS = "shakeItemID";
        aVar.columns[1] = "username";
        aVar.xrT.put("username", "TEXT");
        stringBuilder.append(" username TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "nickname";
        aVar.xrT.put("nickname", "TEXT");
        stringBuilder.append(" nickname TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "province";
        aVar.xrT.put("province", "TEXT");
        stringBuilder.append(" province TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "city";
        aVar.xrT.put("city", "TEXT");
        stringBuilder.append(" city TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "signature";
        aVar.xrT.put("signature", "TEXT");
        stringBuilder.append(" signature TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = "distance";
        aVar.xrT.put("distance", "TEXT");
        stringBuilder.append(" distance TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "sex";
        aVar.xrT.put("sex", "INTEGER");
        stringBuilder.append(" sex INTEGER");
        stringBuilder.append(", ");
        aVar.columns[8] = "imgstatus";
        aVar.xrT.put("imgstatus", "INTEGER");
        stringBuilder.append(" imgstatus INTEGER");
        stringBuilder.append(", ");
        aVar.columns[9] = "hasHDImg";
        aVar.xrT.put("hasHDImg", "INTEGER");
        stringBuilder.append(" hasHDImg INTEGER");
        stringBuilder.append(", ");
        aVar.columns[10] = "insertBatch";
        aVar.xrT.put("insertBatch", "INTEGER");
        stringBuilder.append(" insertBatch INTEGER");
        stringBuilder.append(", ");
        aVar.columns[11] = "reserved1";
        aVar.xrT.put("reserved1", "INTEGER");
        stringBuilder.append(" reserved1 INTEGER");
        stringBuilder.append(", ");
        aVar.columns[12] = "reserved2";
        aVar.xrT.put("reserved2", "INTEGER");
        stringBuilder.append(" reserved2 INTEGER");
        stringBuilder.append(", ");
        aVar.columns[13] = "reserved3";
        aVar.xrT.put("reserved3", "TEXT");
        stringBuilder.append(" reserved3 TEXT");
        stringBuilder.append(", ");
        aVar.columns[14] = "reserved4";
        aVar.xrT.put("reserved4", "TEXT");
        stringBuilder.append(" reserved4 TEXT");
        stringBuilder.append(", ");
        aVar.columns[15] = Columns.TYPE;
        aVar.xrT.put(Columns.TYPE, "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[16] = "lvbuffer";
        aVar.xrT.put("lvbuffer", "BLOB");
        stringBuilder.append(" lvbuffer BLOB");
        stringBuilder.append(", ");
        aVar.columns[17] = "regionCode";
        aVar.xrT.put("regionCode", "TEXT");
        stringBuilder.append(" regionCode TEXT");
        stringBuilder.append(", ");
        aVar.columns[18] = "snsFlag";
        aVar.xrT.put("snsFlag", "INTEGER");
        stringBuilder.append(" snsFlag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[19] = "sns_bgurl";
        aVar.xrT.put("sns_bgurl", "TEXT");
        stringBuilder.append(" sns_bgurl TEXT");
        aVar.columns[20] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final a Aj() {
        return gKN;
    }

    public d() {
        this.fEo = -1;
        this.field_insertBatch = 2;
    }

    public d(biz biz) {
        this.fEo = -1;
        this.field_username = biz.kyG;
        this.field_nickname = biz.kzN;
        this.field_signature = biz.hxh;
        this.field_distance = biz.wCp;
        this.field_reserved4 = String.valueOf(biz.wSY);
        this.field_sex = biz.hxe;
        this.field_imgstatus = biz.vNP;
        this.field_hasHDImg = biz.wSW;
        this.field_reserved1 = biz.wCq;
        this.field_reserved3 = biz.wCr;
        this.field_insertBatch = 2;
        if (biz.wCw != null) {
            this.field_snsFlag = biz.wCw.hxp;
            this.field_sns_bgurl = biz.wCw.hxq;
        }
        this.qtM = biz.wSX;
        this.field_province = biz.hxf;
        this.field_city = biz.hxg;
        this.field_regionCode = RegionCodeDecoder.ai(biz.hxn, this.field_province, this.field_city);
    }

    public final String getProvince() {
        if (!bi.oN(this.field_regionCode)) {
            String[] split = this.field_regionCode.split("_");
            if (split.length > 0) {
                if (split.length <= 2 || !split[0].equalsIgnoreCase("cn")) {
                    this.field_province = RegionCodeDecoder.ckE().Ym(split[0]);
                } else {
                    this.field_province = RegionCodeDecoder.ckE().fK(split[0], split[1]);
                }
            }
        }
        return this.field_province;
    }

    public final String getCity() {
        if (!bi.oN(this.field_regionCode)) {
            String[] split = this.field_regionCode.split("_");
            if (split.length > 0) {
                if (split.length > 2) {
                    this.field_city = RegionCodeDecoder.ckE().aj(split[0], split[1], split[2]);
                } else if (split.length == 2) {
                    this.field_city = RegionCodeDecoder.ckE().fK(split[0], split[1]);
                } else {
                    this.field_city = "";
                }
            }
        }
        return this.field_city;
    }

    private int bsa() {
        try {
            return Integer.valueOf(this.field_reserved4).intValue();
        } catch (Throwable th) {
            return 0;
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if ((this.fEo & 2) != 0) {
            contentValues.put("username", this.field_username);
        }
        if ((this.fEo & 4) != 0) {
            contentValues.put("nickname", this.field_nickname);
        }
        if ((this.fEo & 8) != 0) {
            contentValues.put("province", getProvince());
        }
        if ((this.fEo & 16) != 0) {
            contentValues.put("city", getCity());
        }
        if ((this.fEo & 32) != 0) {
            contentValues.put("signature", this.field_signature);
        }
        if ((this.fEo & 64) != 0) {
            contentValues.put("distance", this.field_distance);
        }
        if ((this.fEo & FileUtils.S_IWUSR) != 0) {
            contentValues.put("sex", Integer.valueOf(this.field_sex));
        }
        if ((this.fEo & 256) != 0) {
            contentValues.put("imgstatus", Integer.valueOf(this.field_imgstatus));
        }
        if ((this.fEo & WXMediaMessage.TITLE_LENGTH_LIMIT) != 0) {
            contentValues.put("hasHDImg", Integer.valueOf(this.field_hasHDImg));
        }
        if ((this.fEo & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            contentValues.put("insertBatch", Integer.valueOf(this.field_insertBatch));
        }
        if ((this.fEo & 2048) != 0) {
            contentValues.put("reserved1", Integer.valueOf(this.field_reserved1));
        }
        if ((this.fEo & Downloads.RECV_BUFFER_SIZE) != 0) {
            contentValues.put("reserved2", Integer.valueOf(this.field_reserved2));
        }
        if ((this.fEo & 8192) != 0) {
            contentValues.put("reserved3", this.field_reserved3);
        }
        if ((this.fEo & 16384) != 0) {
            contentValues.put("reserved4", Integer.valueOf(bsa()));
        }
        if ((this.fEo & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0) {
            contentValues.put(Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if ((this.fEo & 65536) != 0) {
            contentValues.put("lvbuffer", this.field_lvbuffer);
        }
        if ((this.fEo & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) != 0) {
            contentValues.put("regionCode", this.field_regionCode);
        }
        if ((this.fEo & 262144) != 0) {
            contentValues.put("snsFlag", Integer.valueOf(this.field_snsFlag));
        }
        if ((this.fEo & SQLiteGlobal.journalSizeLimit) != 0) {
            contentValues.put("sns_bgurl", this.field_sns_bgurl);
        }
        return contentValues;
    }
}
