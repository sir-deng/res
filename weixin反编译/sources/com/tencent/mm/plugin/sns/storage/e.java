package com.tencent.mm.plugin.sns.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import com.tencent.mm.a.g;
import com.tencent.mm.protocal.c.bpb;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class e extends com.tencent.mm.f.b.e {
    protected static a gKN;
    protected static Map<String, b> ruN = new ConcurrentHashMap();
    protected static Map<String, a> ruO = new ConcurrentHashMap();
    public String ruL = null;
    protected int ruM;

    static {
        a aVar = new a();
        aVar.hUM = new Field[22];
        aVar.columns = new String[23];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "snsId";
        aVar.xrT.put("snsId", "LONG");
        stringBuilder.append(" snsId LONG");
        stringBuilder.append(", ");
        aVar.columns[1] = "userName";
        aVar.xrT.put("userName", "TEXT");
        stringBuilder.append(" userName TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "localFlag";
        aVar.xrT.put("localFlag", "INTEGER");
        stringBuilder.append(" localFlag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "createTime";
        aVar.xrT.put("createTime", "INTEGER");
        stringBuilder.append(" createTime INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "head";
        aVar.xrT.put("head", "INTEGER");
        stringBuilder.append(" head INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "localPrivate";
        aVar.xrT.put("localPrivate", "INTEGER");
        stringBuilder.append(" localPrivate INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = Columns.TYPE;
        aVar.xrT.put(Columns.TYPE, "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[7] = "sourceType";
        aVar.xrT.put("sourceType", "INTEGER");
        stringBuilder.append(" sourceType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[8] = "likeFlag";
        aVar.xrT.put("likeFlag", "INTEGER");
        stringBuilder.append(" likeFlag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[9] = "pravited";
        aVar.xrT.put("pravited", "INTEGER");
        stringBuilder.append(" pravited INTEGER");
        stringBuilder.append(", ");
        aVar.columns[10] = "stringSeq";
        aVar.xrT.put("stringSeq", "TEXT");
        stringBuilder.append(" stringSeq TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "content";
        aVar.xrT.put("content", "BLOB");
        stringBuilder.append(" content BLOB");
        stringBuilder.append(", ");
        aVar.columns[12] = "attrBuf";
        aVar.xrT.put("attrBuf", "BLOB");
        stringBuilder.append(" attrBuf BLOB");
        stringBuilder.append(", ");
        aVar.columns[13] = "postBuf";
        aVar.xrT.put("postBuf", "BLOB");
        stringBuilder.append(" postBuf BLOB");
        stringBuilder.append(", ");
        aVar.columns[14] = "adinfo";
        aVar.xrT.put("adinfo", "TEXT");
        stringBuilder.append(" adinfo TEXT");
        stringBuilder.append(", ");
        aVar.columns[15] = "adxml";
        aVar.xrT.put("adxml", "TEXT");
        stringBuilder.append(" adxml TEXT");
        stringBuilder.append(", ");
        aVar.columns[16] = "createAdTime";
        aVar.xrT.put("createAdTime", "INTEGER");
        stringBuilder.append(" createAdTime INTEGER");
        stringBuilder.append(", ");
        aVar.columns[17] = "exposureTime";
        aVar.xrT.put("exposureTime", "INTEGER");
        stringBuilder.append(" exposureTime INTEGER");
        stringBuilder.append(", ");
        aVar.columns[18] = "firstControlTime";
        aVar.xrT.put("firstControlTime", "INTEGER");
        stringBuilder.append(" firstControlTime INTEGER");
        stringBuilder.append(", ");
        aVar.columns[19] = "recxml";
        aVar.xrT.put("recxml", "TEXT");
        stringBuilder.append(" recxml TEXT");
        stringBuilder.append(", ");
        aVar.columns[20] = "subType";
        aVar.xrT.put("subType", "INTEGER");
        stringBuilder.append(" subType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[21] = "exposureCount";
        aVar.xrT.put("exposureCount", "INTEGER");
        stringBuilder.append(" exposureCount INTEGER");
        aVar.columns[22] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final a Aj() {
        return gKN;
    }

    public final b byB() {
        b bVar;
        if (this.field_adxml == null) {
            bVar = null;
        } else if (ruN.containsKey(this.field_adxml)) {
            return (b) ruN.get(this.field_adxml);
        } else {
            bVar = new b(this.field_adxml);
            ruN.put(this.field_adxml, bVar);
        }
        return bVar == null ? new b(null) : bVar;
    }

    public final b byC() {
        b bVar;
        if (this.field_recxml == null) {
            bVar = null;
        } else if (ruN.containsKey(this.field_recxml)) {
            return (b) ruN.get(this.field_recxml);
        } else {
            bVar = new b(this.field_recxml);
            ruN.put(this.field_recxml, bVar);
        }
        return bVar == null ? new b(null) : bVar;
    }

    public final a byD() {
        a aVar;
        if (this.field_adinfo == null) {
            aVar = null;
        } else if (ruO.containsKey(this.field_adinfo)) {
            return (a) ruO.get(this.field_adinfo);
        } else {
            aVar = new a(this.field_adinfo);
            ruO.put(this.field_adinfo, aVar);
        }
        return aVar == null ? new a(null) : aVar;
    }

    public final boolean LO(String str) {
        if (str == null || str.length() <= 0 || str.equals(this.field_adinfo)) {
            return false;
        }
        ruO.remove(this.field_adinfo);
        this.field_adinfo = str;
        return true;
    }

    public final boolean bxo() {
        b byB = byB();
        if (byB != null) {
            return byB.bxo();
        }
        return false;
    }

    public final int byE() {
        b byC = byC();
        return byC == null ? 0 : byC.rkT;
    }

    public final int getSource() {
        b byC = byC();
        return byC == null ? 0 : byC.rkT;
    }

    public final void c(bpb bpb) {
        try {
            this.field_content = bpb.toByteArray();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AdSnsInfo", e, "", new Object[0]);
        }
    }

    public final boolean LP(String str) {
        try {
            this.field_content = com.tencent.mm.modelsns.e.mK(str).toByteArray();
            this.ruL = g.s(this.field_content) + g.s(this.field_attrBuf);
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AdSnsInfo", e, "", new Object[0]);
            return false;
        }
    }

    public final bpb byF() {
        if (this.field_content == null) {
            return com.tencent.mm.modelsns.e.SH();
        }
        bpb bpb;
        if (this.ruL == null) {
            this.ruL = g.s(this.field_content) + g.s(this.field_attrBuf);
        }
        if (m.ruT.containsKey(this.ruL)) {
            bpb = (bpb) m.ruT.get(this.ruL);
            if (bpb != null) {
                return bpb;
            }
        }
        try {
            bpb = (bpb) new bpb().aH(this.field_content);
            m.ruT.put(this.ruL, bpb);
            return bpb;
        } catch (Exception e) {
            x.e("MicroMsg.AdSnsInfo", "error get snsinfo timeline!");
            return com.tencent.mm.modelsns.e.SH();
        }
    }

    public final void aL(byte[] bArr) {
        this.field_attrBuf = bArr;
        this.ruL = g.s(this.field_content) + g.s(this.field_attrBuf);
    }

    public final void xB(int i) {
        this.field_sourceType |= i;
    }

    public final String byG() {
        return u.af("ad_table_", this.field_snsId);
    }

    public final m byH() {
        m mVar = new m();
        mVar.c(byF());
        x.d("MicroMsg.AdSnsInfo", "from server xml ok %d", Long.valueOf(this.field_snsId));
        mVar.ruM = this.ruM;
        mVar.field_userName = this.field_userName;
        mVar.hN(this.field_createTime);
        mVar.field_likeFlag = this.field_likeFlag;
        mVar.eO(this.field_snsId);
        mVar.field_sourceType = this.field_sourceType;
        mVar.field_content = this.field_content;
        mVar.xB(2);
        mVar.xB(32);
        mVar.field_attrBuf = this.field_attrBuf;
        bpb byF = mVar.byF();
        byF.kyG = this.field_userName;
        mVar.field_pravited = byF.wER;
        mVar.byX();
        mVar.c(byF);
        if (byF.wYj != null) {
            mVar.field_type = byF.wYj.wfg;
            mVar.field_subType = byF.wYj.wfi;
        }
        mVar.ruW = this;
        return mVar;
    }

    public final void b(Cursor cursor) {
        super.b(cursor);
        this.ruM = (int) this.xrR;
    }

    public final Bundle byI() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("values", super.vP());
        bundle.putInt("localid", this.ruM);
        return bundle;
    }

    public final void E(Bundle bundle) {
        if (bundle != null) {
            ContentValues contentValues = (ContentValues) bundle.getParcelable("values");
            this.field_snsId = contentValues.getAsLong("snsId").longValue();
            this.field_userName = contentValues.getAsString("userName");
            this.field_localFlag = contentValues.getAsInteger("localFlag").intValue();
            this.field_createTime = contentValues.getAsInteger("createTime").intValue();
            this.field_head = contentValues.getAsInteger("head").intValue();
            this.field_localPrivate = contentValues.getAsInteger("localPrivate").intValue();
            this.field_type = contentValues.getAsInteger(Columns.TYPE).intValue();
            this.field_sourceType = contentValues.getAsInteger("sourceType").intValue();
            this.field_likeFlag = contentValues.getAsInteger("likeFlag").intValue();
            this.field_pravited = contentValues.getAsInteger("pravited").intValue();
            this.field_stringSeq = contentValues.getAsString("stringSeq");
            this.field_content = contentValues.getAsByteArray("content");
            this.field_attrBuf = contentValues.getAsByteArray("attrBuf");
            this.field_postBuf = contentValues.getAsByteArray("postBuf");
            this.field_adinfo = contentValues.getAsString("adinfo");
            this.field_adxml = contentValues.getAsString("adxml");
            this.field_createAdTime = contentValues.getAsInteger("createAdTime").intValue();
            this.field_exposureTime = contentValues.getAsInteger("exposureTime").intValue();
            this.field_firstControlTime = contentValues.getAsInteger("firstControlTime").intValue();
            this.field_recxml = contentValues.getAsString("recxml");
            this.field_subType = contentValues.getAsInteger("subType").intValue();
            this.xrR = contentValues.getAsLong("rowid").longValue();
            this.ruM = bundle.getInt("localid");
        }
    }
}
