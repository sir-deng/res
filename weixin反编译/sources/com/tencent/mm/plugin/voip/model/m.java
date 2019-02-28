package com.tencent.mm.plugin.voip.model;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Looper;
import com.tencent.mm.R;
import com.tencent.mm.a.f;
import com.tencent.mm.bp.b;
import com.tencent.mm.f.a.ih;
import com.tencent.mm.f.a.sr;
import com.tencent.mm.network.n;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.model.a.e;
import com.tencent.mm.plugin.voip.model.a.h;
import com.tencent.mm.plugin.voip.ui.VideoActivity;
import com.tencent.mm.protocal.c.aof;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.boi;
import com.tencent.mm.protocal.c.btg;
import com.tencent.mm.protocal.c.buz;
import com.tencent.mm.protocal.c.bvt;
import com.tencent.mm.protocal.c.bvu;
import com.tencent.mm.protocal.c.bvy;
import com.tencent.mm.protocal.c.bwi;
import com.tencent.mm.protocal.c.bwt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class m {
    private static final f<Integer, com.tencent.mm.plugin.voip.model.i.a> hfz = new f(5);
    public boolean fjK;
    public al oMa;
    private n qaE;
    public n ssY;
    public j ssZ;
    public String ssw;
    public boolean sta;
    public boolean stb;
    private long stc;
    public Map<Integer, Long> std;
    public int ste;
    public long stf;
    public long stg;
    public Point sth;
    public boolean sti;
    public boolean stj;
    public boolean stk;
    public bvy stl;
    public long stm;
    List<a> stn;
    public String talker;

    public class a {
        boolean jBH;
        bvy stp;
    }

    public m() {
        this.fjK = false;
        this.sta = false;
        this.stb = false;
        this.talker = null;
        this.stc = 0;
        this.std = new HashMap();
        this.ste = -1;
        this.stf = 0;
        this.stg = 0;
        this.sti = false;
        this.stj = false;
        this.stk = false;
        this.stl = null;
        this.stm = 0;
        this.ssw = null;
        this.qaE = new com.tencent.mm.network.n.a() {
            public final void eq(int i) {
                x.d("MicroMsg.Voip.VoipService", "network status change from " + i);
                if (m.this.fjK && i == 4) {
                    e eVar = m.this.ssY.soQ;
                    if (eVar.sqt == 0) {
                        eVar.sqt = eVar.sqj.suh;
                    }
                    int netType = com.tencent.mm.plugin.voip.b.a.getNetType(ad.getContext());
                    if (netType != eVar.sqt) {
                        com.tencent.mm.plugin.voip.b.a.eA("MicroMsg.Voip.VoipContext", "steve: onVoipLocalNetTypeChange: local network type change from " + eVar.sqt + " to " + netType);
                        try {
                            byte[] bArr = new byte[4];
                            bArr[0] = (byte) netType;
                            int appCmd = eVar.sqj.setAppCmd(301, bArr, 4);
                            if (appCmd < 0) {
                                com.tencent.mm.plugin.voip.b.a.eA("MicroMsg.Voip.VoipContext", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetLocalNetType] update local network type" + netType + "fail:" + appCmd + ", [roomid=" + eVar.sqj.nJm + ", roomkey=" + eVar.sqj.nJf + "]");
                            }
                            btg btg = new btg();
                            btg.xbl = 3;
                            btg.xbm = new b(bArr, 0, 1);
                            eVar.sqj.SendRUDP(btg.toByteArray(), btg.toByteArray().length);
                        } catch (Exception e) {
                            com.tencent.mm.plugin.voip.b.a.eA("MicroMsg.Voip.VoipContext", "onVoipLocalNetTypeChange Error");
                        }
                        eVar.sqt = netType;
                    }
                    n nVar = m.this.ssY;
                    new h(nVar.soQ.sqj.nJe, nVar.soQ.sqj.nJf, nVar.soQ.sqj.nJm, 0, 0, null).bIw();
                }
            }
        };
        this.oMa = new al(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.al.a() {
            public final boolean uG() {
                x.v("MicroMsg.Voip.VoipService", "voip repeat check is foreground");
                if (m.this.stl == null) {
                    m.this.stm = 0;
                    m.this.oMa.TN();
                    return false;
                } else if (m.dg(ad.getContext())) {
                    m.this.N(m.this.stl.wil, m.this.stl.wim);
                    m.this.a(m.this.stl);
                    m.this.stl = null;
                    m.this.stm = 0;
                    m.this.oMa.TN();
                    g.pWK.a(500, 5, 1, false);
                    return false;
                } else if (System.currentTimeMillis() - m.this.stm < 60000) {
                    return true;
                } else {
                    m.this.stl = null;
                    m.this.stm = 0;
                    m.this.oMa.TN();
                    return false;
                }
            }
        }, true);
        this.stn = null;
        this.ssY = new n();
        this.fjK = false;
        this.sta = false;
        this.stb = false;
        this.talker = null;
        this.ssw = null;
        as.a(this.qaE);
    }

    protected final void finalize() {
        this.ssY.stop();
        this.ssY = null;
        as.b(this.qaE);
        super.finalize();
    }

    public final void a(boolean z, boolean z2, String str) {
        x.i("MicroMsg.Voip.VoipService", "setCalling " + z + "  videoCall " + z2);
        this.fjK = z;
        if (z2) {
            this.sta = z;
            this.ssY.soQ.sqj.suu = 0;
        } else {
            this.ssY.soQ.sqj.suu = 1;
            this.stb = z;
        }
        this.talker = str;
    }

    public final void B(boolean z, boolean z2) {
        this.stj = z;
        this.stk = z2;
        x.d("MicroMsg.Voip.VoipService", "isMinimize: %b, miniOnlyHideVoip: %b", Boolean.valueOf(z), Boolean.valueOf(z2));
    }

    public final void aF(Context context, String str) {
        x.i("MicroMsg.Voip.VoipService", "startVoiceCall, toUser:" + str);
        if (!bi.oN(str) && System.currentTimeMillis() - this.stc >= 2000) {
            if (System.currentTimeMillis() - this.stf < this.stg) {
                x.i("MicroMsg.Voip.VoipService", "fail! cuz overloadInterval fail!");
                com.tencent.mm.ui.base.h.a(context, R.l.eVZ, R.l.eWs, null);
                return;
            }
            this.stc = System.currentTimeMillis();
            as.Hm();
            if (c.Ff().Xv(str) != null) {
                a(context, str, true, false, false);
                bHX();
            }
        }
    }

    public final void aG(Context context, String str) {
        x.i("MicroMsg.Voip.VoipService", "startVideoCall, toUser:" + str);
        if (!bi.oN(str) && System.currentTimeMillis() - this.stc >= 2000) {
            if (System.currentTimeMillis() - this.stf < this.stg) {
                x.i("MicroMsg.Voip.VoipService", "fail! cuz overloadInterval fail!");
                com.tencent.mm.ui.base.h.a(context, R.l.eVZ, R.l.eWs, null);
                return;
            }
            this.stc = System.currentTimeMillis();
            as.Hm();
            if (c.Ff().Xv(str) != null) {
                a(context, str, true, true, false);
                bHX();
            }
        }
    }

    private static void bHX() {
        com.tencent.mm.sdk.b.b srVar = new sr();
        srVar.fLl.fvG = 7;
        com.tencent.mm.sdk.b.a.xmy.m(srVar);
    }

    public final void N(final int i, final long j) {
        ah.y(new Runnable() {
            public final void run() {
                x.i("MicroMsg.Voip.VoipService", "onDelayInvite, roomId:%s, roomKey:%s", Integer.valueOf(i), Long.valueOf(j));
                if (!com.tencent.mm.j.a.zw() && !m.dg(ad.getContext())) {
                    x.i("MicroMsg.Voip.VoipService", "background now and notification Is closed.");
                } else if (m.this.ssY.bIk()) {
                    x.i("MicroMsg.Voip.VoipService", "room is ready, ingore the msg");
                } else {
                    new e(i, j, "").bIw();
                }
            }
        });
    }

    public final void a(bvy bvy) {
        if (com.tencent.mm.j.a.zw() || dg(ad.getContext())) {
            String str = bvy.xdp;
            String FY = q.FY();
            int i = bvy.xdh;
            x.i("MicroMsg.Voip.VoipService", "doTaskCallin self:%s talker:%s type:%d roomid:%d", FY, str, Integer.valueOf(i), Integer.valueOf(bvy.wil));
            if (this.ssY.bHa()) {
                n.a(bvy.wil, bvy.wim, 2, null, null, str);
                x.d("MicroMsg.Voip.VoipService", "doTaskCallin invite ignor because voip busy:roomid " + bvy.wil);
                g.pWK.a(11525, true, true, Integer.valueOf(bvy.wil), Long.valueOf(bvy.wim), Integer.valueOf(bvy.xdh), Integer.valueOf(2), Integer.valueOf(com.tencent.mm.plugin.voip.b.a.getNetType(ad.getContext())), Long.valueOf(System.currentTimeMillis()));
                g.pWK.a(11526, true, true, Integer.valueOf(d.bGT().ssY.soQ.sqj.nJe), Long.valueOf(d.bGT().bIa()), Long.valueOf(d.bGT().bIb()), Integer.valueOf(7));
                return;
            } else if (n.bIl()) {
                n.a(bvy.wil, bvy.wim, 3, null, null, str);
                x.e("MicroMsg.Voip.VoipService", "doTaskCallin invite ignor because telephone busy:roomid " + bvy.wil);
                g.pWK.a(11525, true, true, Integer.valueOf(bvy.wil), Long.valueOf(bvy.wim), Integer.valueOf(bvy.xdh), Integer.valueOf(3), Integer.valueOf(com.tencent.mm.plugin.voip.b.a.getNetType(ad.getContext())), Long.valueOf(System.currentTimeMillis()));
                g.pWK.a(11526, true, true, Integer.valueOf(d.bGT().ssY.soQ.sqj.nJe), Long.valueOf(d.bGT().bIa()), Long.valueOf(d.bGT().bIb()), Integer.valueOf(7));
                return;
            } else {
                Object obj;
                this.ssY.bIm();
                n nVar = this.ssY;
                if (nVar.soQ.bHa()) {
                    com.tencent.mm.plugin.voip.b.a.ez("MicroMsg.Voip.VoipServiceEx", "Failed to setInviteContent during calling, status =" + nVar.soQ.mStatus);
                    obj = null;
                } else if (bvy == null) {
                    obj = null;
                } else {
                    nVar.soQ.sqj.svN.sri = bvy.xdh;
                    x.d("MicroMsg.Voip.VoipServiceEx", "iRoomType " + nVar.soQ.sqj.svN.sri);
                    if (nVar.soQ.sqj.oCT) {
                        com.tencent.mm.plugin.voip.b.a.eC("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.g.zo() + "v2protocal already init.");
                        nVar.soQ.sqj.jq(false);
                        nVar.soQ.sqj.reset();
                    }
                    e eVar = nVar.soQ;
                    eVar.sqo = bvy;
                    eVar.sqj.nYY = eVar.sqo.xdp;
                    eVar.sqj.nJe = eVar.sqo.wil;
                    eVar.sqj.nJf = eVar.sqo.wim;
                    eVar.sqj.nJm = 1;
                    eVar.sqj.sui = 0;
                    eVar.mStatus = 3;
                    if (d.bIZ() || com.tencent.mm.o.a.Bd() || d.bJc()) {
                        x.e("MicroMsg.Voip.VoipServiceEx", "setInviteContent, reject, pstn/multitak/f2f talking");
                        if (d.bIZ()) {
                            n.a(bvy.wil, bvy.wim, 2, null, null, bvy.xdp);
                        } else {
                            nVar.bIo();
                            l.a(bvy.xdp, (bvy.xdh == 0 ? 1 : null) != null ? au.xHC : au.xHB, 0, 6, ad.getContext().getString(R.l.eUE));
                        }
                        obj = null;
                    } else if (nVar.soQ.sqj.bFf() < 0) {
                        com.tencent.mm.plugin.voip.b.a.ez("MicroMsg.Voip.VoipServiceEx", "Failed to init v2protocol.");
                        obj = null;
                    } else {
                        g.pWK.a(11524, true, true, Integer.valueOf(bvy.wil), Long.valueOf(bvy.wim), Integer.valueOf(bvy.xdh), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()));
                        nVar.soQ.sqk.bHE();
                        obj = 1;
                    }
                }
                if (obj == null) {
                    x.e("MicroMsg.Voip.VoipService", "doTaskCallin setInviteContent failed!");
                    g.pWK.a(11525, true, true, Integer.valueOf(bvy.wil), Long.valueOf(bvy.wim), Integer.valueOf(bvy.xdh), Integer.valueOf(5), Integer.valueOf(com.tencent.mm.plugin.voip.b.a.getNetType(ad.getContext())), Long.valueOf(System.currentTimeMillis()));
                    g.pWK.a(11526, true, true, Integer.valueOf(d.bGT().ssY.soQ.sqj.nJe), Long.valueOf(d.bGT().bIa()), Long.valueOf(d.bGT().bIb()), Integer.valueOf(7));
                    return;
                }
                Context context = ad.getContext();
                as.Hm();
                if (c.Ff().Xv(str) == null) {
                    n.a(bvy.wil, bvy.wim, 4, null, null, str);
                    x.d("MicroMsg.Voip.VoipService", "doTaskCallin invite ignor because talker nil:roomid " + bvy.wil);
                    g.pWK.a(11525, true, true, Integer.valueOf(bvy.wil), Long.valueOf(bvy.wim), Integer.valueOf(bvy.xdh), Integer.valueOf(4), Integer.valueOf(com.tencent.mm.plugin.voip.b.a.getNetType(ad.getContext())), Long.valueOf(System.currentTimeMillis()));
                    g.pWK.a(11526, true, true, Integer.valueOf(d.bGT().ssY.soQ.sqj.nJe), Long.valueOf(d.bGT().bIa()), Long.valueOf(d.bGT().bIb()), Integer.valueOf(7));
                    return;
                }
                if (1 == i || i == 0) {
                    a(context, str, false, i == 0, true);
                    if (this.ssY != null) {
                        nVar = this.ssY;
                        nVar.sts = bvy.wil;
                        if (!nVar.stD.cgx()) {
                            nVar.stD.TN();
                        }
                        nVar.stD.K(70000, 70000);
                    }
                    x.d("MicroMsg.Voip.VoipService", "doTaskCallin invite startActivity VideoActivity");
                }
                n.a(bvy.wil, bvy.wim, 1, this.ssY.soQ.sqj.field_peerId, this.ssY.soQ.sqj.field_capInfo, str);
                g.pWK.a(11525, true, true, Integer.valueOf(bvy.wil), Long.valueOf(bvy.wim), Integer.valueOf(bvy.xdh), Integer.valueOf(1), Integer.valueOf(com.tencent.mm.plugin.voip.b.a.getNetType(ad.getContext())), Long.valueOf(System.currentTimeMillis()));
                return;
            }
        }
        x.i("MicroMsg.Voip.VoipService", "NotificationConfig.isNewVoipMsgNotification() is false and is not in foreground, now return.");
        if (this.stl == null && this.oMa.cgx()) {
            x.i("MicroMsg.Voip.VoipService", "voipGetRoomInfoResp is null and time is stopped.");
            this.stl = bvy;
            this.oMa.K(2000, 2000);
            this.stm = System.currentTimeMillis();
            g.pWK.a(500, 4, 1, false);
        }
    }

    public final void yX(int i) {
        if (this.stn != null && !this.stn.isEmpty()) {
            for (a aVar : this.stn) {
                if (aVar != null && aVar.stp != null && aVar.stp.wil == i) {
                    aVar.jBH = true;
                    return;
                }
            }
        }
    }

    public static com.tencent.mm.plugin.voip.model.i.a Nh(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        int hashCode = str.hashCode();
        com.tencent.mm.plugin.voip.model.i.a aVar = (com.tencent.mm.plugin.voip.model.i.a) hfz.get(Integer.valueOf(hashCode));
        if (aVar != null) {
            return aVar;
        }
        aVar = new com.tencent.mm.plugin.voip.model.i.a();
        if (!aVar.parse(str)) {
            return null;
        }
        hfz.l(Integer.valueOf(hashCode), aVar);
        return aVar;
    }

    private static Map<Integer, Long> aP(byte[] bArr) {
        if (bi.by(bArr)) {
            return null;
        }
        try {
            boi boi = (boi) new boi().aH(bArr);
            if (boi == null) {
                return null;
            }
            x.d("MicroMsg.Voip.VoipService", "dkpush : keyCount:" + boi.wTO);
            LinkedList linkedList = boi.wTP;
            if (linkedList.size() != boi.wTO) {
                return null;
            }
            Map<Integer, Long> hashMap = new HashMap();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= boi.wTO) {
                    break;
                }
                hashMap.put(Integer.valueOf(((aof) linkedList.get(i2)).pWg), Long.valueOf(4294967295L & ((long) ((aof) linkedList.get(i2)).wBQ)));
                i = i2 + 1;
            }
            if (hashMap.size() != boi.wTO) {
                return null;
            }
            return hashMap;
        } catch (Exception e) {
            return null;
        }
    }

    private static byte[] R(Map<Integer, Long> map) {
        boi boi = new boi();
        LinkedList linkedList = new LinkedList();
        for (Integer num : map.keySet()) {
            aof aof = new aof();
            aof.pWg = num.intValue();
            aof.wBQ = ((Long) map.get(num)).intValue();
            linkedList.push(aof);
        }
        boi.wTP = linkedList;
        boi.wTO = linkedList.size();
        try {
            return boi.toByteArray();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Voip.VoipService", e, "", new Object[0]);
            return null;
        }
    }

    private static String aQ(byte[] bArr) {
        String str = "";
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & 255);
            if (toHexString.length() == 1) {
                toHexString = "0" + toHexString;
            }
            str = str + toHexString.toUpperCase();
        }
        return str;
    }

    public final int b(byte[] bArr, int i, long j) {
        long j2;
        long j3;
        long j4;
        long j5;
        long j6 = 0;
        long j7 = 0;
        long j8 = 0;
        x.i("MicroMsg.Voip.VoipService", "__parse voip notify begin");
        Map aP = aP(this.ssY.soQ.sqn);
        if (aP == null) {
            x.i("MicroMsg.Voip.VoipService", "local voipsynckey buff nil");
            j2 = 0;
            j3 = 0;
            j4 = 0;
        } else {
            j2 = 0;
            j4 = 0;
            j5 = 0;
            for (Integer num : aP.keySet()) {
                Long l = (Long) aP.get(num);
                switch (num.intValue()) {
                    case 1:
                        j2 = l.longValue();
                        break;
                    case 2:
                        j4 = l.longValue();
                        break;
                    case 3:
                        j5 = l.longValue();
                        break;
                    default:
                        String str = "MicroMsg.Voip.VoipService";
                        x.i(str, "parse local voipsynckey:" + num.intValue() + ",value:" + l);
                        break;
                }
            }
            j3 = j2;
            j2 = j4;
            j4 = j5;
        }
        x.i("MicroMsg.Voip.VoipService", "local voip synckey: statuskey:" + j3 + " relayData key:" + j2 + " connectingStatusKey:" + j4);
        try {
            bvu bvu = (bvu) new bvu().aH(bArr);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < bvu.xdi.size()) {
                    bvt bvt = (bvt) bvu.xdi.get(i3);
                    x.i("MicroMsg.Voip.VoipService", "__parse voip notify, item cmdid:" + bvt.wet);
                    StringBuilder stringBuilder;
                    if (bvt.wet == 1) {
                        bwt bwt;
                        try {
                            bwt = (bwt) new bwt().aH(bvt.vQW.wRm.oz);
                        } catch (Throwable e) {
                            x.i("MicroMsg.Voip.VoipService", "parse Voip notify status item fail");
                            x.printErrStackTrace("MicroMsg.Voip.VoipService", e, "", new Object[0]);
                            bwt = null;
                        }
                        if (bwt != null) {
                            x.i("MicroMsg.Voip.VoipService", "voip notify status:" + bwt.kyY);
                            if (j6 < ((long) bvt.pWg)) {
                                j5 = (long) bvt.pWg;
                            } else {
                                j5 = j6;
                            }
                            if (((long) bvt.pWg) > j3) {
                                x.i("MicroMsg.Voip.VoipService", "voiop notify status key[" + bvt.pWg + "] > local status key[" + j3 + "] status[" + bwt.kyY + "]");
                                this.ssY.soQ.sqm.a(bwt, 1);
                                j6 = j5;
                            }
                        } else {
                            x.i("MicroMsg.Voip.VoipService", "parse Voip notify status item fail");
                            j5 = j6;
                        }
                        j6 = j5;
                    } else if (bvt.wet == 2) {
                        bwi bwi;
                        try {
                            bwi = (bwi) new bwi().aH(bvt.vQW.wRm.oz);
                        } catch (Throwable e2) {
                            x.i("MicroMsg.Voip.VoipService", "parse Voip notify relaydata item fail");
                            x.printErrStackTrace("MicroMsg.Voip.VoipService", e2, "", new Object[0]);
                            bwi = null;
                        }
                        if (bwi != null) {
                            x.i("MicroMsg.Voip.VoipService", "notify relay data type:" + bwi.kzz);
                            if (j7 < ((long) bvt.pWg)) {
                                j5 = (long) bvt.pWg;
                            } else {
                                j5 = j7;
                            }
                            if (((long) bvt.pWg) > j2) {
                                stringBuilder = new StringBuilder("notify relaydata key:[");
                                x.i("MicroMsg.Voip.VoipService", stringBuilder.append(bvt.pWg).append("] > local relaydata key[").append(j2).append("]").toString());
                                if (bwi.kzz == 5) {
                                    this.ssY.soQ.sqm.a(bwi);
                                    j7 = j5;
                                } else if (bwi.kzz == 1) {
                                    this.ssY.soQ.sqm.b(bwi);
                                    j7 = j5;
                                } else {
                                    x.i("MicroMsg.Voip.VoipService", "notify relaydata unknown type:" + bwi.kzz);
                                    j7 = j5;
                                }
                            } else {
                                stringBuilder = new StringBuilder("notify relaydata item key[");
                                x.i("MicroMsg.Voip.VoipService", stringBuilder.append(bvt.pWg).append("] <=local relaydatakey[").append(j2).append("]").toString());
                                j7 = j5;
                            }
                        } else {
                            x.i("MicroMsg.Voip.VoipService", "parse Voip notify relaydata item fail");
                        }
                    } else if (bvt.wet == 3) {
                        bes bm;
                        try {
                            bm = new bes().bm(bvt.vQW.wRm.oz);
                        } catch (Throwable e22) {
                            x.printErrStackTrace("MicroMsg.Voip.VoipService", e22, "", new Object[0]);
                            bm = null;
                        }
                        if (bm != null) {
                            if (j8 < ((long) bvt.pWg)) {
                                j5 = (long) bvt.pWg;
                            } else {
                                j5 = j8;
                            }
                            if (((long) bvt.pWg) > j4) {
                                stringBuilder = new StringBuilder("notify connectingStatkey[");
                                x.i("MicroMsg.Voip.VoipService", stringBuilder.append(bvt.pWg).append("]> local connectingstatus key[").append(j4).append("]").toString());
                                this.ssY.soQ.sqm.c(bm);
                                if (this.stl != null && (com.tencent.mm.plugin.voip.b.a.aS(bm.wRm.toByteArray()) & 255) == 1) {
                                    this.stl.xdh = 1;
                                }
                            }
                            j8 = j5;
                        }
                    }
                    i2 = i3 + 1;
                } else {
                    if (j6 <= j3) {
                        j6 = j3;
                    }
                    if (j7 <= j2) {
                        j7 = j2;
                    }
                    if (j8 <= j4) {
                        j8 = j4;
                    }
                    Map hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(1), Long.valueOf(j6));
                    hashMap.put(Integer.valueOf(2), Long.valueOf(j7));
                    hashMap.put(Integer.valueOf(3), Long.valueOf(j8));
                    byte[] R = R(hashMap);
                    if (i == this.ssY.soQ.sqj.nJe && j == this.ssY.soQ.sqj.nJf) {
                        this.ssY.soQ.sqn = R;
                        x.i("MicroMsg.Voip.VoipService", "voipNotify:ext notify data new keys:" + j6 + ", " + j7 + ", " + j8);
                    }
                    x.i("MicroMsg.Voip.VoipService", "__parse voip notify end");
                    return 0;
                }
            }
        } catch (Throwable e3) {
            x.printErrStackTrace("MicroMsg.Voip.VoipService", e3, "", new Object[0]);
            x.i("MicroMsg.Voip.VoipService", "parse voip extNotifyData fail extNotifyData size " + bArr.length + " first byte " + aQ(bArr));
            return 0;
        }
    }

    public static byte[] N(byte[] bArr, int i) {
        byte[] bArr2 = new byte[i];
        for (int i2 = 12; i2 < i + 12; i2++) {
            bArr2[i2 - 12] = bArr[i2];
        }
        return bArr2;
    }

    public final int C(boolean z, boolean z2) {
        n nVar = this.ssY;
        nVar.bIr();
        if (!nVar.stD.cgx()) {
            nVar.stD.TN();
        }
        h hVar = nVar.soQ.sqj.svN;
        hVar.srE = System.currentTimeMillis();
        com.tencent.mm.plugin.voip.b.a.eB("MicroMsg.VoipDailReport", "devin:acceptCallTime:" + hVar.srE);
        x.i("MicroMsg.Voip.VoipServiceEx", "accept onlyAudio:" + z);
        if (!nVar.soQ.bGZ()) {
            com.tencent.mm.plugin.voip.b.a.ez("MicroMsg.Voip.VoipServiceEx", "Failed to accept with calling, status =" + nVar.soQ.mStatus);
            return -1;
        } else if (nVar.soQ.sqj.nJe == 0) {
            com.tencent.mm.plugin.voip.b.a.ez("MicroMsg.Voip.VoipServiceEx", "Failed to accept with roomid = 0. ");
            return -1;
        } else {
            com.tencent.mm.plugin.voip.b.a.eB("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.g.zo() + "accept invite, roomid:" + nVar.soQ.sqj.nJe);
            nVar.stC.K(50000, 50000);
            nVar.soQ.sqj.svN.bHp();
            new com.tencent.mm.plugin.voip.model.a.b(1, nVar.soQ.sqj.netType, nVar.soQ.sqj.nJe, nVar.soQ.sqj.field_peerId, nVar.soQ.sqj.field_capInfo, nVar.soQ.sqj.nJf, z, z2).bIw();
            nVar.soQ.eR(4);
            nVar.soQ.sql.sqF = 1;
            nVar.soQ.fEQ = true;
            return 0;
        }
    }

    public final int bHY() {
        n nVar = this.ssY;
        x.i("MicroMsg.Voip.VoipServiceEx", "hangUp");
        if (nVar.soQ.sqj.nJe == 0) {
            nVar.soQ.sql.bHo();
            nVar.reset();
            return 0;
        }
        nVar.soQ.sqj.svN.sqW = nVar.soQ.bGY();
        return nVar.bIp();
    }

    public final void yN(int i) {
        this.ssY.soQ.yN(i);
    }

    public final int bHZ() {
        return this.ssY.soQ.sqj.nJe;
    }

    public final long bIa() {
        return this.ssY.soQ.sqj.nJf;
    }

    public final long bIb() {
        return (long) this.ssY.soQ.sqj.suu;
    }

    public final boolean bIc() {
        return this.ssY.soQ.bHf();
    }

    public final boolean bId() {
        return this.ssY.soQ.bHg();
    }

    public final int bGR() {
        g gVar = this.ssY.soQ.sql;
        return gVar.sqD != null ? gVar.sqD.bGR() : 0;
    }

    public final void yY(int i) {
        x.d("MicroMsg.Voip.VoipService", "devin: camera errcode: %d", Integer.valueOf(i));
        this.ssY.soQ.sqj.suv = Math.abs(i);
    }

    public final void bIe() {
        x.d("MicroMsg.Voip.VoipService", "devin: setCallResult: %d", Integer.valueOf(1));
        this.ssY.soQ.sqj.svN.srj = 1;
    }

    public final int a(byte[] bArr, int i, int i2, int i3, int i4, int[] iArr, boolean z) {
        g gVar = this.ssY.soQ.sql;
        if (((!z ? 1 : 0) & (gVar.sqF == g.sqE ? 1 : 0)) != 0) {
            return -1;
        }
        return !gVar.soQ.sqj.oCT ? -1 : gVar.soQ.sqj.videoEncodeToLocal(bArr, i, i3, i4, i2, 0, 75, iArr);
    }

    public final boolean ji(boolean z) {
        g gVar = this.ssY.soQ.sql;
        return gVar.sqD != null ? gVar.sqD.ji(z) : false;
    }

    public final int jn(boolean z) {
        e eVar = this.ssY.soQ;
        int tv = z ? eVar.sqj.tv(412) : eVar.sqj.tv(413);
        if (tv < 0) {
            com.tencent.mm.plugin.voip.b.a.ez("MicroMsg.Voip.VoipContext", "voipContext tryMuteMicrophone ret:" + tv);
        }
        return tv;
    }

    public final int jo(boolean z) {
        e eVar = this.ssY.soQ;
        int tv = z ? eVar.sqj.tv(401) : eVar.sqj.tv(com.tencent.mm.plugin.appbrand.jsapi.a.e.CTRL_INDEX);
        if (tv < 0) {
            com.tencent.mm.plugin.voip.b.a.eA("MicroMsg.Voip.VoipContext", "voipContext trySwitchSpeakerPhone ret:" + tv);
        }
        return tv;
    }

    public final void k(int i, int i2, boolean z) {
        n nVar = this.ssY;
        if (nVar.str != null && i > 0) {
            nVar.str.m(i, i2, z);
        }
    }

    public final void dS(int i, int i2) {
        n nVar = this.ssY;
        if (nVar.str != null && i > 0) {
            nVar.str.e(i, false, i2);
        }
    }

    public final void yZ(int i) {
        n nVar = this.ssY;
        if (nVar.str != null && i > 0) {
            nVar.str.b(i, false, 0, false);
        }
    }

    public final void stopRing() {
        n nVar = this.ssY;
        if (nVar.str != null) {
            nVar.str.stop();
        }
    }

    public final boolean bIf() {
        n nVar = this.ssY;
        return nVar.str != null ? nVar.str.aiV() : true;
    }

    public static void bIg() {
    }

    public static void bIh() {
    }

    public static void a(Context context, String str, boolean z, boolean z2, boolean z3) {
        if (context == null) {
            context = ad.getContext();
        }
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.mm.sdk.b.b ihVar = new ih();
        ihVar.fzE.fzH = false;
        ihVar.fzE.fzG = currentTimeMillis;
        ihVar.fzE.fzF = context;
        com.tencent.mm.sdk.b.a.xmy.m(ihVar);
        x.i("MicroMsg.Voip.VoipService", "start VideoActivity");
        Intent intent = new Intent(context, VideoActivity.class);
        intent.putExtra("Voip_User", str);
        intent.putExtra("Voip_Outcall", z);
        intent.putExtra("Voip_VideoCall", z2);
        intent.putExtra("Voip_LastPage_Hash", currentTimeMillis);
        if (z3) {
            intent.setFlags(603979776);
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        }
        context.startActivity(intent);
    }

    public static float jp(boolean z) {
        float f = 0.74766356f;
        try {
            byte[] bArr;
            m bGT = d.bGT();
            if (z) {
                bArr = bGT.ssY.soQ.sqj.field_capInfo;
            } else {
                bArr = bGT.ssY.soQ.sqj.sul;
            }
            if (bArr != null) {
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                if (wrap.getInt() > 65535) {
                    wrap.order(ByteOrder.LITTLE_ENDIAN);
                }
                wrap.getShort();
                wrap.getShort();
                float f2 = ((float) wrap.getInt()) / 100.0f;
                if (f2 != 0.0f) {
                    f = f2;
                }
                x.d("MicroMsg.Voip.VoipService", "use rate: %s, changed: %s", Float.valueOf(f), Boolean.valueOf(z));
            }
        } catch (Exception e) {
            x.e("MicroMsg.Voip.VoipService", "update failed: " + e.getMessage());
        }
        return f;
    }

    public final void bIi() {
        this.ssY.stB.K(1000, 1000);
    }

    private static boolean dg(Context context) {
        List runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1);
        if (!(runningTasks == null || runningTasks.isEmpty())) {
            ComponentName componentName = ((RunningTaskInfo) runningTasks.get(0)).topActivity;
            x.d("MicroMsg.Voip.VoipService", "topActivity:" + componentName.flattenToString());
            if (!componentName.getPackageName().equals(context.getPackageName())) {
                x.i("MicroMsg.Voip.VoipService", "is in backGround.");
                return false;
            }
        }
        if (((KeyguardManager) ad.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            return false;
        }
        x.i("MicroMsg.Voip.VoipService", "is in foreGround.");
        return true;
    }

    public final void za(int i) {
        e eVar = this.ssY.soQ;
        com.tencent.mm.plugin.voip.b.a.eA("MicroMsg.Voip.VoipContext", "zhengxue: audio device occupied stat sync stat " + i + " app 1");
        try {
            byte[] bArr = new byte[4];
            bArr[0] = (byte) i;
            eVar.sqj.setJNIAppCmd(2, bArr, 4);
            buz buz = new buz();
            buz.xcN = i;
            buz.xcO = 1;
            btg btg = new btg();
            btg.xbl = 4;
            btg.xbm = new b(buz.toByteArray(), 0, 1);
            eVar.sqj.SendRUDP(btg.toByteArray(), btg.toByteArray().length);
        } catch (Exception e) {
            com.tencent.mm.plugin.voip.b.a.eA("MicroMsg.Voip.VoipContext", "onAudioDevOccupiedStat Error");
        }
    }

    public final void Ni(final String str) {
        for (int i = 0; i < 2; i++) {
            ah.h(new Runnable() {
                public final void run() {
                    if (m.this.ssZ != null) {
                        j jVar = m.this.ssZ;
                        String str = str;
                        if (jVar.srS != null) {
                            jVar.ssw = str;
                            jVar.srS.Ni(str);
                        }
                    }
                }
            }, 1000);
        }
    }

    public final void bIj() {
        g gVar = this.ssY.soQ.sql;
        x.i("MicroMsg.Voip.VoipDeviceHandler", "forceCleanRecord, recorder %s", gVar.oLx);
        synchronized (gVar.sqP) {
            if (gVar.oLx != null) {
                x.i("MicroMsg.Voip.VoipDeviceHandler", "do stop record");
                gVar.oLx.vj();
                gVar.oLx = null;
            }
        }
    }
}
