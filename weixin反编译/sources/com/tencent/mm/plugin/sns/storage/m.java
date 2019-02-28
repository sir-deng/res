package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import android.os.Bundle;
import com.tencent.mm.a.g;
import com.tencent.mm.f.b.dp;
import com.tencent.mm.modelsns.e;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.bpb;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import com.tencent.wcdb.FileUtils;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class m extends dp {
    protected static a gKN;
    protected static Map<String, bpb> ruT = new ConcurrentHashMap();
    protected static Map<String, arf> ruU = new ConcurrentHashMap();
    private boolean qWK = false;
    public String ruL = null;
    public int ruM;
    public String ruV = null;
    public e ruW;
    private arf ruX = null;

    static {
        a aVar = new a();
        aVar.hUM = new Field[15];
        aVar.columns = new String[16];
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
        aVar.columns[14] = "subType";
        aVar.xrT.put("subType", "INTEGER");
        stringBuilder.append(" subType INTEGER");
        aVar.columns[15] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final a Aj() {
        return gKN;
    }

    public final arf byS() {
        if (this.field_postBuf == null) {
            return new arf();
        }
        if (this.ruV == null) {
            this.ruV = g.s(this.field_postBuf);
        }
        if (ruU.containsKey(this.ruV)) {
            this.ruX = (arf) ruU.get(this.ruV);
            if (this.ruX != null) {
                return this.ruX;
            }
        }
        try {
            this.ruX = (arf) new arf().aH(this.field_postBuf);
            ruU.put(this.ruV, this.ruX);
            return this.ruX;
        } catch (Exception e) {
            x.e("MicroMsg.SnsInfo", "error get snsinfo timeline!");
            return new arf();
        }
    }

    public m(byte b) {
        eO(0);
    }

    public static m x(m mVar) {
        m mVar2 = new m();
        mVar2.ruM = mVar.ruM;
        mVar2.field_snsId = mVar.field_snsId;
        mVar2.field_userName = mVar.field_userName;
        mVar2.field_localFlag = mVar.field_localFlag;
        mVar2.field_createTime = mVar.field_createTime;
        mVar2.field_head = mVar.field_head;
        mVar2.field_localPrivate = mVar.field_localPrivate;
        mVar2.field_type = mVar.field_type;
        mVar2.field_sourceType = mVar.field_sourceType;
        mVar2.field_likeFlag = mVar.field_likeFlag;
        mVar2.field_pravited = mVar.field_pravited;
        mVar2.field_stringSeq = mVar.field_stringSeq;
        mVar2.field_content = mVar.field_content;
        mVar2.field_attrBuf = mVar.field_attrBuf;
        return mVar2;
    }

    public final void eO(long j) {
        this.field_snsId = j;
        if (j != 0) {
            eQ(j);
        }
    }

    public final String byG() {
        if (xD(32)) {
            return u.af("ad_table_", this.field_snsId);
        }
        return u.af("sns_table_", this.field_snsId);
    }

    public final String getUserName() {
        return this.field_userName;
    }

    private static int eP(long j) {
        String format = new SimpleDateFormat("yyyyMMdd").format(new Date(1000 * j));
        try {
            return Integer.valueOf(format).intValue();
        } catch (Exception e) {
            x.e("MicroMsg.SnsInfo", "error valueOf  " + format);
            return (int) (j / 86400);
        }
    }

    public final void hN(int i) {
        if (i - this.field_createTime >= 180 || i - this.field_createTime < 0) {
            this.field_createTime = i;
            this.field_head = eP((long) i);
        } else if (this.field_head == 0) {
            this.field_head = eP((long) this.field_createTime);
        }
    }

    public final int byT() {
        return this.field_createTime;
    }

    public final void byU() {
        this.field_localPrivate |= 1;
    }

    public final int byV() {
        return this.field_localPrivate;
    }

    public final boolean byW() {
        return (this.field_localFlag & FileUtils.S_IWUSR) > 0;
    }

    public final void byX() {
        this.field_localFlag |= 2;
    }

    public final void byY() {
        this.field_localFlag &= -3;
    }

    public final boolean byZ() {
        return (this.field_localFlag & 2) > 0;
    }

    public final String bza() {
        if (xD(32)) {
            return u.af("ad_table_", (long) this.ruM);
        }
        return u.af("sns_table_", (long) this.ruM);
    }

    public final void aL(byte[] bArr) {
        this.field_attrBuf = bArr;
        this.ruL = g.s(this.field_content) + g.s(this.field_attrBuf);
    }

    public final void eQ(long j) {
        this.field_stringSeq = i.er(j);
        this.field_stringSeq = i.Ks(this.field_stringSeq);
        x.d("MicroMsg.SnsInfo", j + " stringSeq " + this.field_stringSeq);
    }

    public final void b(Cursor cursor) {
        super.b(cursor);
        this.ruM = (int) this.xrR;
    }

    public static synchronized void release() {
        synchronized (m.class) {
            ruT.clear();
            ruU.clear();
        }
    }

    public final bpb byF() {
        if (this.field_content == null) {
            return e.SH();
        }
        bpb bpb;
        if (this.ruL == null) {
            this.ruL = g.s(this.field_content) + g.s(this.field_attrBuf);
        }
        if (ruT.containsKey(this.ruL)) {
            bpb = (bpb) ruT.get(this.ruL);
            if (bpb != null) {
                return bpb;
            }
        }
        try {
            bpb = (bpb) new bpb().aH(this.field_content);
            ruT.put(this.ruL, bpb);
            return bpb;
        } catch (Exception e) {
            x.e("MicroMsg.SnsInfo", "error get snsinfo timeline!");
            return e.SH();
        }
    }

    public final void c(bpb bpb) {
        try {
            this.field_content = bpb.toByteArray();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SnsInfo", e, "", new Object[0]);
        }
        this.ruL = g.s(this.field_content) + g.s(this.field_attrBuf);
    }

    public final boolean LP(String str) {
        try {
            this.field_content = e.mK(str).toByteArray();
            this.ruL = g.s(this.field_content) + g.s(this.field_attrBuf);
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SnsInfo", e, "", new Object[0]);
            return false;
        }
    }

    public final boolean bzb() {
        return (this.field_localFlag & 16) > 0;
    }

    public final boolean bzc() {
        return (this.field_localFlag & 32) > 0 && this.field_snsId == 0;
    }

    public final void bzd() {
        this.field_localFlag &= -33;
    }

    public final void bze() {
        this.field_localFlag |= 32;
    }

    public static boolean eR(long j) {
        if (bi.bz(j / 1000) > 1200) {
            return true;
        }
        return false;
    }

    public final boolean xD(int i) {
        return (this.field_sourceType & i) > 0;
    }

    public final void xB(int i) {
        this.field_sourceType |= i;
    }

    public final void xE(int i) {
        this.field_sourceType &= i ^ -1;
    }

    public final b byB() {
        if (this.ruW == null) {
            this.ruW = ae.bwi().eL(this.field_snsId);
        }
        return this.ruW == null ? new b(null) : this.ruW.byB();
    }

    public final a byD() {
        if (this.ruW == null) {
            this.ruW = ae.bwi().eL(this.field_snsId);
        }
        return this.ruW == null ? new a(null) : this.ruW.byD();
    }

    public final String bzf() {
        a byD = byD();
        return byD == null ? "" : byD.rkf;
    }

    public final String bzg() {
        a byD = byD();
        return byD == null ? "" : byD.rke;
    }

    public final String bzh() {
        b byB = byB();
        if (byB != null) {
            return byB.rjU;
        }
        return "";
    }

    public final String bzi() {
        a byD = byD();
        if (byD != null) {
            return byD.rjU;
        }
        return "";
    }

    public final String bzj() {
        a byD = byD();
        if (byD != null) {
            return byD.iWv;
        }
        return "";
    }

    public final String bzk() {
        a byD = byD();
        if (byD != null) {
            return byD.rfQ;
        }
        return "";
    }

    public final e bzl() {
        if (this.ruW == null) {
            this.ruW = ae.bwi().eL(this.field_snsId);
        }
        if (this.ruW != null) {
            this.ruW.field_createTime = this.field_createTime;
            this.ruW.field_userName = this.field_userName;
            this.ruW.field_likeFlag = this.field_likeFlag;
            this.ruW.field_attrBuf = this.field_attrBuf;
        }
        return this.ruW;
    }

    public final boolean kg() {
        return xD(32);
    }

    public final int bzm() {
        b byB = byB();
        if (byB != null) {
            return byB.rkT;
        }
        return 0;
    }

    public final boolean bxo() {
        b byB = byB();
        if (byB != null) {
            return byB.bxo();
        }
        return false;
    }

    public final boolean isValid() {
        return this.field_snsId != 0;
    }

    public final boolean bvO() {
        return this.field_snsId == 0;
    }

    public final int bzn() {
        if (!xD(32)) {
            return -1;
        }
        b byB = byB();
        bpb byF = byF();
        if (byB.bxh()) {
            return 3;
        }
        if (byF != null && byF.wYj.wfg == 27) {
            return 6;
        }
        if (byB.bxi()) {
            if (byF == null || byF.wYj.wfg != 15 || byF.wYq == 1) {
                return 4;
            }
            return 5;
        } else if (this.field_type != 1) {
            return 2;
        } else {
            return 1;
        }
    }

    public final boolean bzo() {
        return bzn() == 6;
    }

    public final boolean bxi() {
        int bzn = bzn();
        return bzn == 5 || bzn == 4;
    }

    public final Bundle byI() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("values", super.vP());
        bundle.putInt("localid", this.ruM);
        if (bzl() != null) {
            bundle.putBundle("adValues", bzl().byI());
        }
        return bundle;
    }
}
