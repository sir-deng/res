package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mm.c.f;
import com.tencent.mm.f.a.mn;
import com.tencent.mm.f.a.ou;
import com.tencent.mm.f.a.ow;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.x.o;
import java.util.Map;
import junit.framework.Assert;

public final class au extends o {
    public static String xHB = "voip_content_voice";
    public static String xHC = "voip_content_video";
    public boolean xHD = false;
    private String xHE;

    public static final class a {
        private String bhd = "";
        public int fXa;
        private String fXk;
        private String fXl;
        public String fXp = "";
        private String fXq = "";
        public String fqG = "";
        public String ggL = "";
        public String hyF = "";
        public String hyG = "";
        public String hyH = "";
        public String hyK = "";
        public String pnr = "";
        public long ppA = 0;
        public String ppC = "";
        public int scene = 0;
        public String sfb = "";
        public String signature;
        public int tth = 0;
        public String vzN = "";
        public int xHH = 0;
        public String xHI = "";
        public String xHJ = "";
        public String xHK = "";
        public String xHL = "";
        public String xHM = "";
        public String xHN = "";
        public String xHO = "";
        public String xHP = "";

        private a() {
        }

        public static a XY(String str) {
            a aVar = new a();
            String trim = bi.aD(str, "").trim();
            if (!trim.startsWith("<")) {
                int indexOf = trim.indexOf(":");
                if (indexOf != -1) {
                    trim = trim.substring(indexOf + 1);
                }
            }
            Map y = bj.y(trim, "msg");
            if (y != null) {
                try {
                    if (y.get(".msg.$fromusername") == null) {
                        aVar.sfb = (String) y.get(".msg.$username");
                    } else {
                        aVar.sfb = (String) y.get(".msg.$fromusername");
                    }
                    if (y.get(".msg.$fromnickname") == null) {
                        aVar.fqG = (String) y.get(".msg.$nickname");
                    } else {
                        aVar.fqG = (String) y.get(".msg.$fromnickname");
                    }
                    aVar.ggL = (String) y.get(".msg.$alias");
                    aVar.hyG = (String) y.get(".msg.$fullpy");
                    aVar.hyF = (String) y.get(".msg.$shortpy");
                    aVar.bhd = (String) y.get(".msg.$source");
                    aVar.xHH = bi.getInt((String) y.get(".msg.$imagestatus"), 0);
                    aVar.scene = bi.getInt((String) y.get(".msg.$scene"), 0);
                    aVar.xHI = (String) y.get(".msg.$mobileidentify");
                    aVar.xHJ = (String) y.get(".msg.$mobilelongidentify");
                    if (y.get(".msg.$qqnum") != null && ((String) y.get(".msg.$qqnum")).length() > 0) {
                        aVar.ppA = bi.getLong((String) y.get(".msg.$qqnum"), 0);
                    }
                    aVar.signature = (String) y.get(".msg.$sign");
                    if (y.get(".msg.$sex") != null && ((String) y.get(".msg.$sex")).length() > 0) {
                        aVar.fXa = bi.getInt((String) y.get(".msg.$sex"), 0);
                    }
                    aVar.fXl = (String) y.get(".msg.$city");
                    aVar.fXk = (String) y.get(".msg.$province");
                    aVar.hyH = (String) y.get(".msg.$qqnickname");
                    aVar.hyK = (String) y.get(".msg.$qqremark");
                    aVar.tth = bi.getInt(TextUtils.isEmpty((CharSequence) y.get(".msg.$certflag")) ? "0" : (String) y.get(".msg.$certflag"), 0);
                    aVar.fXp = bi.oM((String) y.get(".msg.$certinfo"));
                    aVar.pnr = bi.oM((String) y.get(".msg.$brandIconUrl"));
                    aVar.fXq = bi.oM((String) y.get(".msg.$regionCode"));
                    aVar.xHK = bi.oM((String) y.get(".msg.$bigheadimgurl"));
                    aVar.xHL = bi.oM((String) y.get(".msg.$smallheadimgurl"));
                    aVar.ppC = bi.oM((String) y.get(".msg.$googlecontact"));
                    aVar.vzN = bi.oM((String) y.get(".msg.$antispamticket"));
                    aVar.xHM = bi.oM((String) y.get(".msg.$openimappid"));
                    aVar.xHN = bi.oM((String) y.get(".msg.$openimdesc"));
                    aVar.xHO = bi.oM((String) y.get(".msg.$openimdescicon"));
                    aVar.xHP = bi.oM((String) y.get(".msg.$openimcustominfo"));
                    if (x.Xg(aVar.sfb)) {
                        aVar.vzN = bi.oM((String) y.get(".msg.$ticket"));
                    }
                    x.i("MicroMsg.MsgInfo", "dkverify FriendContent user:[%s] ticket:[%s] big:[%s] sm:[%s]", aVar.sfb, aVar.vzN, aVar.xHK, aVar.xHL);
                } catch (Throwable e) {
                    x.e("MicroMsg.MsgInfo", "exception:%s", bi.i(e));
                }
            }
            return aVar;
        }

        public final String getDisplayName() {
            if (!TextUtils.isEmpty(this.fqG)) {
                return this.fqG;
            }
            if (!TextUtils.isEmpty(this.ggL)) {
                return this.ggL;
            }
            x.f("MicroMsg.MsgInfo", "username is nullOrNil");
            return bi.oM(this.sfb);
        }

        public final String ckv() {
            if (this.hyK != null && this.hyK.length() > 0) {
                return this.hyK;
            }
            if (this.hyH == null || this.hyH.length() <= 0) {
                return Long.toString(this.ppA);
            }
            return this.hyH;
        }

        public final String getCity() {
            if (!bi.oN(this.fXq)) {
                String[] split = this.fXq.split("_");
                if (split.length > 0) {
                    if (split.length > 2) {
                        this.fXl = RegionCodeDecoder.ckE().aj(split[0], split[1], split[2]);
                    } else if (split.length == 2) {
                        this.fXl = RegionCodeDecoder.ckE().fK(split[0], split[1]);
                    } else {
                        this.fXl = "";
                    }
                }
            }
            return this.fXl;
        }

        public final String getProvince() {
            if (!bi.oN(this.fXq)) {
                String[] split = this.fXq.split("_");
                if (split.length > 0) {
                    if (split.length <= 2 || !RegionCodeDecoder.Yl(split[0])) {
                        this.fXk = RegionCodeDecoder.ckE().Ym(split[0]);
                    } else {
                        this.fXk = RegionCodeDecoder.ckE().fK(split[0], split[1]);
                    }
                }
            }
            return this.fXk;
        }
    }

    public static final class b {
        public int fAq = 0;
        public String label = "";
        public double nWe = 0.0d;
        public double nWf = 0.0d;
        public String nYL = "";
        public String sfb = "";
        public String vjB = "";
        public String xHQ = "";
        public String xHR = null;
        public String xHS = null;
        public String xHT = null;

        public final String toString() {
            return String.format("%d-%d-%d", new Object[]{Integer.valueOf((int) (this.nWe * 1000000.0d)), Integer.valueOf((int) (this.nWf * 1000000.0d)), Integer.valueOf(this.fAq)});
        }

        public static b XZ(String str) {
            b bVar = new b();
            Map y = bj.y(str, "msg");
            if (y != null) {
                bVar.sfb = bi.aD((String) y.get(".msg.location.$fromusername"), "");
                bVar.nWe = bi.Wq((String) y.get(".msg.location.$x"));
                bVar.nWf = bi.Wq((String) y.get(".msg.location.$y"));
                bVar.label = bi.aD((String) y.get(".msg.location.$label"), "");
                bVar.xHQ = bi.aD((String) y.get(".msg.location.$maptype"), "");
                bVar.fAq = bi.Wo((String) y.get(".msg.location.$scale"));
                bVar.xHT = bi.aD((String) y.get(".msg.location.$localLocationen"), "");
                bVar.xHR = bi.aD((String) y.get(".msg.location.$localLocationcn"), "");
                bVar.xHS = bi.aD((String) y.get(".msg.location.$localLocationtw"), "");
                bVar.nYL = bi.aD((String) y.get(".msg.location.$poiname"), "");
                bVar.vjB = bi.aD((String) y.get(".msg.location.$infourl"), "");
            }
            return bVar;
        }

        public final boolean ckw() {
            return (this.nYL == null || this.nYL.equals("")) ? false : true;
        }
    }

    public static final class c {
        public String content = "";
        public String hOy = "";
        public boolean mAz = false;
        public String ptN;
        public String title = "";
        public String xHU = "";

        private c() {
        }

        public static c Ya(String str) {
            c cVar = new c();
            Map y = bj.y(str, "msg");
            if (y != null) {
                try {
                    cVar.title = (String) y.get(".msg.pushmail.content.subject");
                    cVar.content = (String) y.get(".msg.pushmail.content.digest");
                    cVar.hOy = (String) y.get(".msg.pushmail.content.sender");
                    cVar.xHU = (String) y.get(".msg.pushmail.waplink");
                    cVar.mAz = bi.oM((String) y.get(".msg.pushmail.content.attach")).equalsIgnoreCase("true");
                    cVar.ptN = (String) y.get(".msg.pushmail.mailid");
                } catch (Throwable e) {
                    x.e("MicroMsg.MsgInfo", "exception:%s", bi.i(e));
                }
            }
            return cVar;
        }
    }

    public static final class d {
        public String chatroomName = "";
        public String content = "";
        private String countryCode;
        public int fXa;
        public String fqG = "";
        public int fvG;
        public String ggL = "";
        private String hjg;
        private String hjh;
        public String hyF = "";
        public String hyG = "";
        public String hyH = "";
        private String hyK = "";
        public String mTU;
        public long ppA = 0;
        public String ppC;
        public int scene = 0;
        public String sfb = "";
        public String signature;
        public String vtA;
        public String vtB;
        public int xHH = 0;
        public String xHI = "";
        public String xHJ = "";
        public String xHK = "";
        public String xHL = "";
        public int xHV = 0;
        public String xHW;
        public String xHX;
        public int xHY;
        public String xHZ;
        public String xIa;

        private d() {
        }

        public static d Yb(String str) {
            d dVar = new d();
            Map y = bj.y(str, "msg");
            if (y != null) {
                try {
                    dVar.sfb = (String) y.get(".msg.$fromusername");
                    dVar.ggL = (String) y.get(".msg.$alias");
                    dVar.fqG = (String) y.get(".msg.$fromnickname");
                    dVar.hyG = (String) y.get(".msg.$fullpy");
                    dVar.hyF = (String) y.get(".msg.$shortpy");
                    dVar.content = (String) y.get(".msg.$content");
                    dVar.xHH = bi.getInt((String) y.get(".msg.$imagestatus"), 0);
                    dVar.scene = bi.getInt((String) y.get(".msg.$scene"), 0);
                    dVar.xHI = (String) y.get(".msg.$mhash");
                    dVar.xHJ = (String) y.get(".msg.$mfullhash");
                    if (y.get(y.get(".msg.$qqnum")) != null && ((String) y.get(y.get(".msg.$qqnum"))).length() > 0) {
                        dVar.ppA = bi.getLong((String) y.get(".msg.$qqnum"), 0);
                    }
                    dVar.hyH = (String) y.get(".msg.$qqnickname");
                    dVar.hyK = (String) y.get(".msg.$qqremark");
                    dVar.signature = (String) y.get(".msg.$sign");
                    if (y.get(".msg.$sex") != null && ((String) y.get(".msg.$sex")).length() > 0) {
                        dVar.fXa = bi.getInt((String) y.get(".msg.$sex"), 0);
                    }
                    dVar.hjg = (String) y.get(".msg.$city");
                    dVar.hjh = (String) y.get(".msg.$province");
                    dVar.countryCode = (String) y.get(".msg.$country");
                    if (y.get(".msg.$snsflag") != null) {
                        dVar.xHV = bi.getInt((String) y.get(".msg.$snsflag"), 0);
                        dVar.xHW = (String) y.get(".msg.$snsbgimgid");
                    }
                    dVar.mTU = (String) y.get(".msg.$ticket");
                    x.d("MicroMsg.MsgInfo", "dkverify ticket:%s", dVar.mTU);
                    dVar.xHK = bi.oM((String) y.get(".msg.$bigheadimgurl"));
                    dVar.xHL = bi.oM((String) y.get(".msg.$smallheadimgurl"));
                    dVar.fvG = bi.getInt((String) y.get(".msg.$opcode"), 0);
                    dVar.xHX = bi.oM((String) y.get(".msg.$encryptusername"));
                    dVar.ppC = bi.oM((String) y.get(".msg.$googlecontact"));
                    x.d("MicroMsg.MsgInfo", "dkavatar VerifyContent user:[%s] big:[%s] sm:[%s]", dVar.sfb, dVar.xHK, dVar.xHL);
                    dVar.chatroomName = bi.oM((String) y.get(".msg.$chatroomusername"));
                    dVar.vtA = (String) y.get(".msg.$sourceusername");
                    dVar.vtB = (String) y.get(".msg.$sourcenickname");
                    dVar.xHY = bi.getInt((String) y.get(".msg.Antispam.$isSuspiciousUser"), 0);
                    if (dVar.xHY == 1) {
                        dVar.xHZ = (String) y.get(".msg.Antispam.safetyWarning");
                        dVar.xIa = (String) y.get(".msg.Antispam.safetyWarningDetail");
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.MsgInfo", e, "", new Object[0]);
                }
            }
            return dVar;
        }

        public final String ckx() {
            return this.mTU;
        }

        public final String vU() {
            return this.ggL;
        }

        public final String cky() {
            return this.sfb;
        }

        public final String vW() {
            return this.fqG;
        }

        public final String getDisplayName() {
            if (this.fqG != null && this.fqG.length() > 0) {
                return this.fqG;
            }
            x.f("MicroMsg.MsgInfo", "username is nullOrNil");
            return this.sfb;
        }

        public final String vY() {
            return this.hyG;
        }

        public final String vX() {
            return this.hyF;
        }

        public final int ckz() {
            return this.fXa;
        }

        public final String ckA() {
            return this.signature;
        }

        public final String getCity() {
            if (bi.oN(this.countryCode) || bi.oN(this.hjh)) {
                return this.hjg;
            }
            if (bi.oN(this.hjg)) {
                return RegionCodeDecoder.ckE().fK(this.countryCode, this.hjh);
            }
            return RegionCodeDecoder.ckE().aj(this.countryCode, this.hjh, this.hjg);
        }

        public final String getProvince() {
            if (bi.oN(this.countryCode)) {
                return this.hjh;
            }
            if (bi.oN(this.hjh) || bi.oN(this.hjg) || !RegionCodeDecoder.Yl(this.countryCode)) {
                return RegionCodeDecoder.ckE().Ym(this.countryCode);
            }
            return RegionCodeDecoder.ckE().fK(this.countryCode, this.hjh);
        }

        public final String ckB() {
            return this.xHX;
        }
    }

    public au(String str) {
        super.dU(str);
    }

    public final boolean aNJ() {
        return (getType() & 65535) == 49;
    }

    public final boolean cjK() {
        return getType() == 285212721;
    }

    public final boolean cjL() {
        return getType() == 34;
    }

    public final boolean cjM() {
        return getType() == 436207665;
    }

    public final boolean cjN() {
        return getType() == 469762097;
    }

    public final boolean cjO() {
        return getType() == 301989937;
    }

    public final boolean cjP() {
        return getType() == 50 || getType() == 53;
    }

    public final boolean cjQ() {
        return getType() == 52;
    }

    public final boolean cjR() {
        return getType() == 318767153;
    }

    public final boolean cjS() {
        return getType() == 10002;
    }

    public final boolean cjT() {
        switch (getType()) {
            case 3:
            case 13:
            case 23:
            case 33:
            case 39:
                return true;
            default:
                return false;
        }
    }

    public final boolean cjU() {
        return getType() == 42 || getType() == 66;
    }

    public final boolean aNL() {
        return getType() == 48;
    }

    public final boolean cjV() {
        switch (getType()) {
            case 1:
            case 11:
            case 21:
            case 31:
            case 36:
                return true;
            default:
                return false;
        }
    }

    public final boolean isSystem() {
        return getType() == 10000;
    }

    public final boolean cjW() {
        return getType() == 43;
    }

    public final boolean cjX() {
        return getType() == 62;
    }

    public final boolean cjY() {
        return getType() == 47;
    }

    public final boolean cjZ() {
        return getType() == 1048625;
    }

    public final boolean cka() {
        return getType() == 16777265;
    }

    public final boolean ckb() {
        return getType() == 268435505;
    }

    public final boolean ckc() {
        return getType() == -1879048191;
    }

    public final boolean ckd() {
        return getType() == -1879048190;
    }

    public final boolean cke() {
        return getType() == -1879048189;
    }

    public final boolean ckf() {
        switch (getType()) {
            case 55:
            case 57:
                return true;
            default:
                return false;
        }
    }

    public final boolean ckg() {
        Object obj;
        String value = ((com.tencent.mm.plugin.zero.b.a) g.h(com.tencent.mm.plugin.zero.b.a.class)).Af().getValue("TranslateMsgOff");
        if (bi.oN(value) || bi.Wo(value) == 0) {
            int obj2 = 1;
        } else {
            x.d("MicroMsg.MsgInfo", "isTranslateFeatureOn false");
            obj2 = null;
        }
        return (obj2 == null || bi.oN(this.field_transContent)) ? false : true;
    }

    public static au ae(au auVar) {
        if (auVar == null) {
            x.d("MicroMsg.MsgInfo", "convertFrom msg is null ");
            return null;
        }
        au auVar2 = new au();
        auVar2.ao(auVar.field_msgId);
        auVar2.ap(auVar.field_msgSvrId);
        auVar2.setType(auVar.getType());
        auVar2.eR(auVar.field_status);
        auVar2.eS(auVar.field_isSend);
        auVar2.field_isShowTimer = auVar.field_isShowTimer;
        auVar2.gkk = true;
        auVar2.aq(auVar.field_createTime);
        auVar2.dU(auVar.field_talker);
        auVar2.setContent(auVar.field_content);
        auVar2.dV(auVar.field_imgPath);
        auVar2.dW(auVar.field_reserved);
        auVar2.A(auVar.field_lvbuffer);
        auVar2.dX(auVar.field_transContent);
        auVar2.dZ(auVar.gkB);
        auVar2.fc(auVar.gkC);
        auVar2.ea(auVar.gkD);
        return auVar2;
    }

    public final void eR(int i) {
        com.tencent.mm.sdk.b.b ouVar;
        super.eR(i);
        if (this.field_isSend == 1) {
            int i2 = (cjV() || aNL() || cjU()) ? 0 : 1;
            if (i2 != 0) {
                if (this.field_status == 5) {
                    x.e("MicroMsg.MsgInfo", "set msg status fail, msgId:%d, type:%d, userName:%s %s", Long.valueOf(this.field_msgId), Integer.valueOf(getType()), this.field_talker, bi.chl());
                    ouVar = new ou();
                    ouVar.fHF.fou = this;
                    com.tencent.mm.sdk.b.a.xmy.m(ouVar);
                    return;
                } else if (this.field_status == 2) {
                    x.d("MicroMsg.MsgInfo", "successfully send msgId:%d, type:%d", Long.valueOf(this.field_msgId), Integer.valueOf(getType()));
                    ouVar = new ow();
                    ouVar.fHH.fou = this;
                    com.tencent.mm.sdk.b.a.xmy.m(ouVar);
                    return;
                } else {
                    return;
                }
            }
        }
        if (this.field_isSend == 0) {
            ouVar = new mn();
            ouVar.fFl.fou = this;
            com.tencent.mm.sdk.b.a.xmy.m(ouVar);
        }
    }

    public final boolean ckh() {
        return (this.gkG & 1) > 0;
    }

    public final void cki() {
        this.gkG |= 1;
        this.ggu = true;
    }

    public final void ckj() {
        if (ckk()) {
            fc(this.gkC & -33);
        }
    }

    public final boolean ckk() {
        return (this.gkC & 32) > 0;
    }

    public final boolean ckl() {
        return ckg() && (this.gkC & 16) > 0;
    }

    public final void ckm() {
        if (ckg()) {
            fc(this.gkC | 16);
        }
    }

    public final void ckn() {
        fc(this.gkC | 768);
    }

    public final boolean cko() {
        return ((this.gkC & 768) == 0 && (this.gkC & 768) == 0) ? false : true;
    }

    public final void DJ(int i) {
        switch (i) {
            case 0:
            case 1:
                fc(this.gkC | i);
                return;
            default:
                x.w("MicroMsg.MsgInfo", "Illgeal forwardflag !!!");
                return;
        }
    }

    public final void ckp() {
        fc(this.gkC & -65);
    }

    public final void ckq() {
        fc(this.gkC | 64);
    }

    public final boolean ckr() {
        return (this.gkC & 64) != 0;
    }

    public final boolean XX(String str) {
        if (!(bi.oN(this.gkD) || bi.oN(str))) {
            Map y = bj.y(this.gkD, "msgsource");
            if (y == null) {
                return false;
            }
            String str2 = (String) y.get(".msgsource.atuserlist");
            if (!bi.oN(str2)) {
                for (String trim : str2.split(",")) {
                    if (trim.trim().equals(str)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean cks() {
        boolean z;
        if (bi.oN(this.gkD) || !(this.gkD.contains("announcement@all") || this.gkD.contains("notify@all"))) {
            z = false;
        } else {
            z = true;
        }
        x.d("MicroMsg.MsgInfo", "isAtAll isAtAll:%s", Boolean.valueOf(z));
        return z;
    }

    public static boolean au(Map<String, String> map) {
        boolean z;
        if (map != null && map.containsKey(".sysmsg.$type") && ((String) map.get(".sysmsg.$type")).equalsIgnoreCase("NewXmlChatRoomAccessVerifyApplication")) {
            z = true;
        } else {
            z = false;
        }
        x.d("MicroMsg.MsgInfo", "isAddChatroomInviteMsg:%s", Boolean.valueOf(z));
        return z;
    }

    public static boolean av(Map<String, String> map) {
        boolean z;
        if (map != null && map.containsKey(".sysmsg.$type") && ((String) map.get(".sysmsg.$type")).equalsIgnoreCase("NewXmlChatRoomAccessVerifyApproval")) {
            z = true;
        } else {
            z = false;
        }
        x.d("MicroMsg.MsgInfo", "isAddChatroomInviteAcceptMsg:%s", Boolean.valueOf(z));
        return z;
    }

    public final void b(Cursor cursor) {
        super.b(cursor);
        String str = this.field_content;
        if (str != null && str.length() > 2097152) {
            final long j = this.field_msgId;
            StringBuilder stringBuilder = new StringBuilder(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            stringBuilder.append("Very big message: \nmsgId = ").append(j).append(10).append("msgSvrId = ").append(this.field_msgSvrId).append(10).append("type = ").append(getType()).append(10).append("createTime = ").append(this.field_createTime).append(10).append("talker = ").append(this.field_talker).append(10).append("flag = ").append(this.field_flag).append(10).append("content.length() = ").append(str.length()).append(10).append("content = ").append(str.substring(0, 256));
            x.e("MicroMsg.MsgInfo", stringBuilder.toString());
            setType(1);
            setContent("");
            final au ae = ae(this);
            g.Dt().F(new Runnable() {
                public final void run() {
                    ((h) g.h(h.class)).aZO().a(j, ae);
                }
            });
        }
        fR(this.field_msgId);
    }

    public static void fR(long j) {
        String str = "msgId not in the reasonable scope";
        boolean z = 100000000 > j && -10 < j;
        Assert.assertTrue(str, z);
    }

    public final ContentValues vP() {
        fR(this.field_msgId);
        return super.vP();
    }

    public final String ckt() {
        if (!cjS()) {
            return "";
        }
        if (this.xHE == null) {
            cku();
        }
        return this.xHE;
    }

    public final com.tencent.mm.aw.a cku() {
        x.i("MicroMsg.MsgInfo", "[parseNewXmlSysMsg]");
        com.tencent.mm.aw.a b = com.tencent.mm.aw.a.a.b(f.y(this.field_content, "sysmsg"), this);
        if (b != null) {
            x.i("MicroMsg.MsgInfo", "BaseNewXmlMsg:%s", b);
            if (b.values == null || b.values.size() <= 0) {
                x.e("MicroMsg.BaseNewXmlMsg", "values == null || values.size() == 0 ");
            } else {
                if (b.values.containsKey(".sysmsg.$type")) {
                    b.TYPE = (String) b.values.get(".sysmsg.$type");
                }
                com.tencent.mm.aw.a.hKf = ".sysmsg." + b.TYPE + ".text";
                if (b.values.containsKey(com.tencent.mm.aw.a.hKf)) {
                    b.TEXT = (String) b.values.get(com.tencent.mm.aw.a.hKf);
                }
                com.tencent.mm.aw.a.hKg = ".sysmsg." + b.TYPE + ".link.scene";
                if (b.values.containsKey(com.tencent.mm.aw.a.hKg)) {
                    b.hKi = (String) b.values.get(com.tencent.mm.aw.a.hKg);
                }
                b.QH();
            }
            this.xHE = b.TEXT;
        } else {
            x.e("MicroMsg.MsgInfo", "[parseNewXmlSysMsg] null == pBaseNewXmlMsg");
        }
        return b;
    }

    public final int getType() {
        int type = super.getType();
        if (type == 486539313) {
            return 285212721;
        }
        return type;
    }
}
