package com.tencent.mm.k;

import android.database.Cursor;
import com.tencent.gmtrace.Constants;
import com.tencent.mm.a.o;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.lang.reflect.Field;

public class a extends ag {
    public static com.tencent.mm.sdk.e.c.a gKN;
    private static a gKP = null;
    public long gKO;
    public int versionCode;

    public interface a {
        String cE(String str);

        String cF(String str);
    }

    static {
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.hUM = new Field[21];
        aVar.columns = new String[22];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "username";
        aVar.xrT.put("username", "TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(" username TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xrS = "username";
        aVar.columns[1] = "alias";
        aVar.xrT.put("alias", "TEXT default '' ");
        stringBuilder.append(" alias TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "conRemark";
        aVar.xrT.put("conRemark", "TEXT default '' ");
        stringBuilder.append(" conRemark TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "domainList";
        aVar.xrT.put("domainList", "TEXT default '' ");
        stringBuilder.append(" domainList TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[4] = "nickname";
        aVar.xrT.put("nickname", "TEXT default '' ");
        stringBuilder.append(" nickname TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[5] = "pyInitial";
        aVar.xrT.put("pyInitial", "TEXT default '' ");
        stringBuilder.append(" pyInitial TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[6] = "quanPin";
        aVar.xrT.put("quanPin", "TEXT default '' ");
        stringBuilder.append(" quanPin TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[7] = "showHead";
        aVar.xrT.put("showHead", "INTEGER default '0' ");
        stringBuilder.append(" showHead INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[8] = Columns.TYPE;
        aVar.xrT.put(Columns.TYPE, "INTEGER default '0' ");
        stringBuilder.append(" type INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[9] = "weiboFlag";
        aVar.xrT.put("weiboFlag", "INTEGER default '0' ");
        stringBuilder.append(" weiboFlag INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[10] = "weiboNickname";
        aVar.xrT.put("weiboNickname", "TEXT default '' ");
        stringBuilder.append(" weiboNickname TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[11] = "conRemarkPYFull";
        aVar.xrT.put("conRemarkPYFull", "TEXT default '' ");
        stringBuilder.append(" conRemarkPYFull TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[12] = "conRemarkPYShort";
        aVar.xrT.put("conRemarkPYShort", "TEXT default '' ");
        stringBuilder.append(" conRemarkPYShort TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[13] = "lvbuff";
        aVar.xrT.put("lvbuff", "BLOB");
        stringBuilder.append(" lvbuff BLOB");
        stringBuilder.append(", ");
        aVar.columns[14] = "verifyFlag";
        aVar.xrT.put("verifyFlag", "INTEGER default '0' ");
        stringBuilder.append(" verifyFlag INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[15] = "encryptUsername";
        aVar.xrT.put("encryptUsername", "TEXT default '' ");
        stringBuilder.append(" encryptUsername TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[16] = "chatroomFlag";
        aVar.xrT.put("chatroomFlag", "INTEGER");
        stringBuilder.append(" chatroomFlag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[17] = "deleteFlag";
        aVar.xrT.put("deleteFlag", "INTEGER default '0' ");
        stringBuilder.append(" deleteFlag INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[18] = "contactLabelIds";
        aVar.xrT.put("contactLabelIds", "TEXT default '' ");
        stringBuilder.append(" contactLabelIds TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[19] = "descWordingId";
        aVar.xrT.put("descWordingId", "TEXT default '' ");
        stringBuilder.append(" descWordingId TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[20] = "openImAppid";
        aVar.xrT.put("openImAppid", "TEXT");
        stringBuilder.append(" openImAppid TEXT");
        aVar.columns[21] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    public final com.tencent.mm.sdk.e.c.a Aj() {
        return gKN;
    }

    public a(String str) {
        this();
        if (str == null) {
            str = "";
        }
        setUsername(str);
    }

    public a() {
        this.versionCode = 0;
        super.setUsername("");
        super.dc("");
        super.dd("");
        super.de("");
        super.cZ("");
        super.da("");
        super.dh("");
        super.dg("");
        super.db("");
        super.ey(0);
        super.df("");
        super.ex(0);
        super.setType(0);
        super.ez(0);
        super.eA(0);
        super.dj("");
        super.eD(0);
        super.ds("");
        super.eJ(0);
        super.eE(0);
        super.dl("");
        super.dm("");
        super.eF(0);
        super.eG(0);
        super.dn("");
        super.do("");
        super.eH(1);
        super.eC(0);
        super.eI(0);
        super.dp("");
        super.dq("");
        super.dr("");
        super.setSource(0);
        super.du("");
        super.dt("");
        super.ai(0);
        super.dk("");
        super.dv("");
        super.eK(0);
        super.dy("");
        super.dz("");
        super.dA("");
        super.dD("");
        this.versionCode = 0;
    }

    public static void a(a aVar) {
        gKP = aVar;
    }

    public static String fc(String str) {
        return gKP != null ? gKP.cE(str) : null;
    }

    public final int Ak() {
        int i = 32;
        if (this.field_conRemarkPYShort != null && !this.field_conRemarkPYShort.equals("")) {
            i = this.field_conRemarkPYShort.charAt(0);
        } else if (this.field_conRemarkPYFull != null && !this.field_conRemarkPYFull.equals("")) {
            i = this.field_conRemarkPYFull.charAt(0);
        } else if (super.vX() != null && !super.vX().equals("")) {
            i = super.vX().charAt(0);
        } else if (super.vY() != null && !super.vY().equals("")) {
            i = super.vY().charAt(0);
        } else if (this.field_nickname != null && !this.field_nickname.equals("") && isLetter(this.field_nickname.charAt(0))) {
            i = this.field_nickname.charAt(0);
        } else if (!(this.field_username == null || this.field_username.equals("") || !isLetter(this.field_username.charAt(0)))) {
            i = this.field_username.charAt(0);
        }
        if (i >= 97 && i <= 122) {
            return (char) (i - 32);
        }
        if (i < 65 || i > 90) {
            return 123;
        }
        return i;
    }

    public final void Al() {
        setType(0);
    }

    public final void Am() {
        setType(this.field_type | 4);
    }

    public final void An() {
        setType(this.field_type | 1);
    }

    public final void Ao() {
        x.w("MicroMsg.RContact", "unSetContact!! user:%s oldType:%d [%s]", this.field_username, Integer.valueOf(this.field_type), bi.chl());
        setType(this.field_type & -2);
    }

    public final void Ap() {
        setType(this.field_type | 8);
    }

    public final void Aq() {
        setType(this.field_type & -9);
    }

    public final void Ar() {
        setType(this.field_type | SQLiteGlobal.journalSizeLimit);
    }

    public final void As() {
        setType(this.field_type & -524289);
    }

    public final void At() {
        setType(this.field_type | 2);
    }

    public final void Au() {
        setType(this.field_type & -3);
    }

    public final void Av() {
        setType(this.field_type & -2049);
    }

    public final void Aw() {
        setType(this.field_type | 32);
    }

    public final void Ax() {
        setType(this.field_type & -33);
    }

    public final void Ay() {
        setType(this.field_type | 64);
    }

    public final void Az() {
        setType(this.field_type & -65);
    }

    public final void AA() {
        setType(this.field_type | WXMediaMessage.TITLE_LENGTH_LIMIT);
    }

    public final void AB() {
        setType(this.field_type & -513);
    }

    public final void AC() {
        setType(this.field_type | 256);
    }

    public final void AD() {
        setType(this.field_type & -257);
    }

    public static int AE() {
        return 1;
    }

    public static int AF() {
        return 8;
    }

    public static int AG() {
        return SQLiteGlobal.journalSizeLimit;
    }

    public static int AH() {
        return 16;
    }

    public static int AI() {
        return 32;
    }

    public final boolean AJ() {
        return ga(this.field_type);
    }

    public static boolean ga(int i) {
        if ((i & 1) != 0) {
            return true;
        }
        return false;
    }

    public final boolean AK() {
        if ((this.field_type & 2) != 0) {
            return true;
        }
        return false;
    }

    public final boolean isHidden() {
        return (this.field_type & 32) != 0;
    }

    public final boolean AL() {
        return (this.field_type & 4) != 0;
    }

    public final boolean AM() {
        return (this.field_type & 8) != 0;
    }

    public final boolean AN() {
        return (SQLiteGlobal.journalSizeLimit & this.field_type) != 0;
    }

    public final boolean AO() {
        return (this.field_type & 64) != 0;
    }

    public final boolean AP() {
        return (this.field_type & WXMediaMessage.TITLE_LENGTH_LIMIT) != 0;
    }

    public final boolean AQ() {
        return (this.field_type & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) == 0;
    }

    public final boolean AR() {
        return (this.field_type & 256) != 0;
    }

    public final boolean AS() {
        return (this.field_type & 2048) != 0;
    }

    public final boolean AT() {
        return (WXMediaMessage.THUMB_LENGTH_LIMIT & this.field_type) != 0;
    }

    public final void AU() {
        setType(this.field_type | WXMediaMessage.THUMB_LENGTH_LIMIT);
    }

    private static boolean isLetter(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }

    public final int AV() {
        return (int) this.gKO;
    }

    public final String vX() {
        return (super.vX() == null || super.vX().length() < 0) ? vY() : super.vX();
    }

    public final String vY() {
        return (super.vY() == null || super.vY().length() < 0) ? this.field_nickname : super.vY();
    }

    public final String vU() {
        String cF = gKP != null ? gKP.cF(this.field_username) : null;
        return cF == null ? super.vU() : cF;
    }

    public final String AW() {
        String cE = gKP != null ? gKP.cE(this.field_username) : null;
        if (cE != null) {
            return cE;
        }
        if (this.field_nickname == null || this.field_nickname.length() <= 0) {
            return AY();
        }
        return this.field_nickname;
    }

    public final String AX() {
        if (this.field_conRemark == null || this.field_conRemark.trim().equals("")) {
            return AW();
        }
        return this.field_conRemark;
    }

    public final String AY() {
        String vU = vU();
        if (!bi.oN(vU)) {
            return vU;
        }
        vU = fd(this.field_username);
        return (vU == null || vU.length() == 0) ? this.field_username : vU;
    }

    public final int getSource() {
        return super.getSource() % Constants.MAX_BUFFER_SIZE;
    }

    public final int AZ() {
        return super.getSource();
    }

    public static String fd(String str) {
        if (str == null) {
            return null;
        }
        if (str.toLowerCase().endsWith("@t.qq.com")) {
            return "@" + str.replace("@t.qq.com", "");
        }
        if (!str.toLowerCase().endsWith("@qqim")) {
            return str;
        }
        str = str.replace("@qqim", "");
        long longValue = Long.valueOf(str).longValue();
        if (longValue < 0) {
            return new o(longValue).toString();
        }
        return str;
    }

    public final void gb(int i) {
        eA((this.field_chatroomFlag & -2) | (i & 1));
    }

    public final void b(Cursor cursor) {
        super.b(cursor);
        this.gKO = this.xrR;
        super.z(null);
    }

    private int Ba() {
        int i = this.versionCode + 1;
        this.versionCode = i;
        return i;
    }

    public final void setUsername(String str) {
        if (!bi.fA(this.field_username, str)) {
            super.setUsername(str);
            Ba();
        }
    }

    public final void cZ(String str) {
        if (!bi.fA(vU(), str)) {
            super.cZ(str);
            Ba();
        }
    }

    public final void da(String str) {
        if (!bi.fA(this.field_conRemark, str)) {
            super.da(str);
            Ba();
        }
    }

    public final void db(String str) {
        if (!bi.fA(this.field_domainList, str)) {
            super.db(str);
            Ba();
        }
    }

    public final void dc(String str) {
        if (!bi.fA(this.field_nickname, str)) {
            super.dc(str);
            Ba();
        }
    }

    public final void dd(String str) {
        if (!bi.fA(vX(), str)) {
            super.dd(str);
            Ba();
        }
    }

    public final void de(String str) {
        if (!bi.fA(vY(), str)) {
            super.de(str);
            Ba();
        }
    }

    public final void ex(int i) {
        if (!bi.eJ(this.field_showHead, i)) {
            super.ex(i);
            Ba();
        }
    }

    public final void setType(int i) {
        if (!bi.eJ(this.field_type, i)) {
            super.setType(i);
            Ba();
        }
    }

    public final void ey(int i) {
        if (!bi.eJ(this.field_weiboFlag, i)) {
            super.ey(i);
            Ba();
        }
    }

    public final void df(String str) {
        if (!bi.fA(this.field_weiboNickname, str)) {
            super.df(str);
            Ba();
        }
    }

    public final void dg(String str) {
        if (!bi.fA(this.field_conRemarkPYFull, str)) {
            super.dg(str);
            Ba();
        }
    }

    public final void dh(String str) {
        if (!bi.fA(this.field_conRemarkPYShort, str)) {
            super.dh(str);
            Ba();
        }
    }

    public final void z(byte[] bArr) {
        if (!bi.isEqual(this.field_lvbuff, bArr)) {
            super.z(bArr);
            Ba();
        }
    }

    public final void ez(int i) {
        if (!bi.eJ(this.field_verifyFlag, i)) {
            super.ez(i);
            Ba();
        }
    }

    public final void di(String str) {
        if (!bi.fA(this.field_encryptUsername, str)) {
            super.di(str);
            Ba();
        }
    }

    public final void eA(int i) {
        if (!bi.eJ(this.field_chatroomFlag, i)) {
            super.eA(i);
            Ba();
        }
    }

    public final void eB(int i) {
        if (!bi.eJ(this.field_deleteFlag, i)) {
            super.eB(i);
            Ba();
        }
    }

    public final void dj(String str) {
        if (!bi.fA(this.field_contactLabelIds, str)) {
            super.dj(str);
            Ba();
        }
    }

    public final void eC(int i) {
        if (!bi.eJ(this.fWZ, i)) {
            super.eC(i);
            Ba();
        }
    }

    public final void eD(int i) {
        if (!bi.eJ(this.fXa, i)) {
            super.eD(i);
            Ba();
        }
    }

    public final void dk(String str) {
        if (!bi.fA(this.fXb, str)) {
            super.dk(str);
            Ba();
        }
    }

    public final void ai(long j) {
        if (!bi.L(this.fXc, j)) {
            super.ai(j);
            Ba();
        }
    }

    public final void eE(int i) {
        if (!bi.eJ(this.uin, i)) {
            super.eE(i);
            Ba();
        }
    }

    public final void dl(String str) {
        if (!bi.fA(this.fXd, str)) {
            super.dl(str);
            Ba();
        }
    }

    public final void dm(String str) {
        if (!bi.fA(this.fBa, str)) {
            super.dm(str);
            Ba();
        }
    }

    public final void eF(int i) {
        if (!bi.eJ(this.fXe, i)) {
            super.eF(i);
            Ba();
        }
    }

    public final void eG(int i) {
        if (!bi.eJ(this.fXf, i)) {
            super.eG(i);
            Ba();
        }
    }

    public final void dn(String str) {
        if (!bi.fA(this.fXg, str)) {
            super.dn(str);
            Ba();
        }
    }

    public final void do(String str) {
        if (!bi.fA(this.fXh, str)) {
            super.do(str);
            Ba();
        }
    }

    public final void eH(int i) {
        if (!bi.eJ(this.fXi, i)) {
            super.eH(i);
            Ba();
        }
    }

    public final void eI(int i) {
        if (!bi.eJ(this.fXj, i)) {
            super.eI(i);
            Ba();
        }
    }

    public final void dp(String str) {
        if (!bi.fA(this.signature, str)) {
            super.dp(str);
            Ba();
        }
    }

    public void dq(String str) {
        if (!bi.fA(getProvince(), str)) {
            super.dq(str);
            Ba();
        }
    }

    public void dr(String str) {
        if (!bi.fA(getCity(), str)) {
            super.dr(str);
            Ba();
        }
    }

    public final void ds(String str) {
        if (!bi.fA(this.fXm, str)) {
            super.ds(str);
            Ba();
        }
    }

    public final void eJ(int i) {
        if (!bi.eJ(this.fXn, i)) {
            super.eJ(i);
            Ba();
        }
    }

    public final void setSource(int i) {
        if (!bi.eJ(super.getSource(), i)) {
            super.setSource(i);
            Ba();
        }
    }

    public final void dt(String str) {
        if (!bi.fA(this.fXo, str)) {
            super.dt(str);
            Ba();
        }
    }

    public final void du(String str) {
        if (!bi.fA(this.fXp, str)) {
            super.du(str);
            Ba();
        }
    }

    public void dv(String str) {
        if (!bi.fA(this.fXq, str)) {
            super.dv(str);
            Ba();
        }
    }

    public final void eK(int i) {
        if (!bi.eJ(this.fXr, i)) {
            super.eK(i);
            Ba();
        }
    }

    public final void eL(int i) {
        if (!bi.eJ(this.fXs, i)) {
            super.eL(i);
            Ba();
        }
    }

    public final void dw(String str) {
        if (!bi.fA(this.fXt, str)) {
            super.dw(str);
            Ba();
        }
    }

    public final void dx(String str) {
        if (!bi.fA(this.fXu, str)) {
            super.dx(str);
            Ba();
        }
    }

    public final void dy(String str) {
        if (!bi.fA(this.fXv, str)) {
            super.dy(str);
            Ba();
        }
    }

    public final void dz(String str) {
        if (!bi.fA(this.fXw, str)) {
            super.dz(str);
            Ba();
        }
    }

    public final void dA(String str) {
        if (!bi.fA(this.fXx, str)) {
            super.dA(str);
            Ba();
        }
    }

    public final void dB(String str) {
        if (!bi.fA(this.fXy, str)) {
            super.dB(str);
            Ba();
        }
    }

    public final void dC(String str) {
        if (!bi.fA(this.fXz, str)) {
            super.dC(str);
            Ba();
        }
    }

    public final void dD(String str) {
        if (!bi.fA(this.fXA, str)) {
            super.dD(str);
            Ba();
        }
    }
}
