package com.tencent.mm.plugin.multitalk.a;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.f.a.jr;
import com.tencent.mm.f.a.my;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.video.h;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.w;
import com.tencent.mm.y.ak;
import com.tencent.mm.y.am;
import com.tencent.mm.y.as;
import com.tencent.mm.y.m;
import com.tencent.mm.y.q;
import com.tencent.mm.y.r;
import com.tencent.pb.common.b.a.a.aa;
import com.tencent.pb.common.b.a.a.z;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import com.tencent.pb.talkroom.sdk.a;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public final class e implements a {
    private long hMJ = 0;
    b hZB;
    private Timer jBG;
    public boolean kYN;
    private boolean nHN;
    public h nIN;
    boolean oLH;
    public boolean oLI;
    int oLJ;
    public boolean oLK = true;
    public HashSet<String> oLL = new HashSet();
    public com.tencent.mm.plugin.multitalk.ui.widget.e oLM = com.tencent.mm.plugin.multitalk.ui.widget.e.Init;
    public MultiTalkGroup oLN = null;
    private k oLO;
    public int oLP = 0;
    private int oLQ = 0;
    private int oLR = 2;
    private boolean oLS = false;
    private long oLT = 0;
    private long oLU = 30000;
    public a oLV;
    i.a oLW;
    public boolean oLX;
    MultiTalkGroup oLY = null;
    long oLZ = 0;
    al oMa = new al(Looper.getMainLooper(), new al.a() {
        public final boolean uG() {
            x.v("MicroMsg.MT.MultiTalkManager", "voip repeat check is foreground");
            if (e.this.oLY == null) {
                e.this.oLZ = 0;
                e.this.oMa.TN();
                return false;
            } else if (e.dg(ad.getContext())) {
                e.this.b(e.this.oLY);
                e.this.oLY = null;
                e.this.oLZ = 0;
                e.this.oMa.TN();
                g.pWK.a(500, 7, 1, false);
                return false;
            } else if (System.currentTimeMillis() - e.this.oLZ < 60000) {
                return true;
            } else {
                e.this.oLY = null;
                e.this.oLZ = 0;
                e.this.oMa.TN();
                return false;
            }
        }
    }, true);
    ag oMb = new ag(Looper.getMainLooper());
    BroadcastReceiver oMc = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            if (!e.this.bcZ()) {
                return;
            }
            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                e.this.oMb.removeCallbacksAndMessages(null);
                e.this.oMb.postDelayed(new Runnable() {
                    public final void run() {
                        i.a bdt = i.bdt();
                        if (bdt != e.this.oLW) {
                            i.a aVar = e.this.oLW;
                            e.this.oLW = bdt;
                            x.i("MicroMsg.MT.MultiTalkManager", "steve: network change: %s -> %s", aVar.name(), e.this.oLW.name());
                            e.this.ty(e.this.oLJ);
                            if (e.this.oLV != null) {
                                e.this.oLV.a(e.this.oLW);
                                return;
                            }
                            return;
                        }
                        x.i("MicroMsg.MT.MultiTalkManager", "network not change: %s", e.this.oLW.name());
                    }
                }, 8000);
                return;
            }
            x.i("MicroMsg.MT.MultiTalkManager", "phone state %d", Integer.valueOf(i.q(context, intent)));
            if (i.q(context, intent) == 0) {
                ah.y(new Runnable() {
                    public final void run() {
                        o.bdA().oLv.nU(false);
                    }
                });
            } else {
                ah.y(new Runnable() {
                    public final void run() {
                        o.bdA().oLv.nU(true);
                    }
                });
            }
        }
    };
    c oMd = new c<jr>() {
        {
            this.xmG = jr.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            jr jrVar = (jr) bVar;
            if (jrVar instanceof jr) {
                jr.b bVar2;
                boolean bcZ;
                switch (jrVar.fBl.action) {
                    case 1:
                        bVar2 = jrVar.fBm;
                        bcZ = e.this.bcZ();
                        break;
                    case 2:
                        bVar2 = jrVar.fBm;
                        e eVar = e.this;
                        if (eVar.oLV == null) {
                            bcZ = false;
                            break;
                        }
                        bcZ = eVar.oLV.bcz();
                        break;
                }
                bVar2.fBn = bcZ;
            }
            return false;
        }
    };

    public e() {
        com.tencent.mm.sdk.b.a.xmy.b(this.oMd);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PHONE_STATE");
        intentFilter.addAction("android.intent.action.PHONE_STATE_2");
        intentFilter.addAction("android.intent.action.PHONE_STATE2");
        intentFilter.addAction("android.intent.action.PHONE_STATE_EXT");
        intentFilter.addAction("android.intent.action.DUAL_PHONE_STATE");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        ad.getContext().registerReceiver(this.oMc, intentFilter);
        this.nIN = new h(ad.getContext());
        this.hZB = new b(ad.getContext());
        this.oLX = false;
    }

    public final boolean bcX() {
        i.bds();
        return i.tz(this.oLJ);
    }

    public final boolean bcY() {
        i.bds();
        return i.tA(this.oLJ);
    }

    public final boolean bcZ() {
        boolean z;
        if (this.oLM == com.tencent.mm.plugin.multitalk.ui.widget.e.Init || this.oLN == null) {
            z = false;
        } else {
            z = true;
        }
        x.d("MicroMsg.MT.MultiTalkManager", "isMultiTalkConnecting %b", Boolean.valueOf(z));
        return z;
    }

    public final boolean bda() {
        boolean z;
        if (this.oLM == com.tencent.mm.plugin.multitalk.ui.widget.e.Starting || this.oLM == com.tencent.mm.plugin.multitalk.ui.widget.e.Talking) {
            z = true;
        } else {
            z = false;
        }
        x.d("MicroMsg.MT.MultiTalkManager", "isMultiTalkStarting %b", Boolean.valueOf(z));
        return z;
    }

    public final boolean bdb() {
        boolean z;
        if (this.oLM == com.tencent.mm.plugin.multitalk.ui.widget.e.Talking) {
            z = true;
        } else {
            z = false;
        }
        x.d("MicroMsg.MT.MultiTalkManager", "isMultiTalkTalking %b", Boolean.valueOf(z));
        return z;
    }

    public final long bdc() {
        return System.currentTimeMillis() - this.hMJ;
    }

    private boolean a(MultiTalkGroup multiTalkGroup) {
        if (!bcZ()) {
            x.i("MicroMsg.MT.MultiTalkManager", "first time update multitalk group: %s", i.h(multiTalkGroup));
            this.oLN = multiTalkGroup;
            this.oLP = 0;
            this.oLJ = 1;
            this.oLL.clear();
            bdd();
            sort();
            return true;
        } else if (i.a(multiTalkGroup, this.oLN)) {
            x.i("MicroMsg.MT.MultiTalkManager", "update multitalk group: %s", i.h(multiTalkGroup));
            MultiTalkGroup multiTalkGroup2 = this.oLN;
            HashMap hashMap = new HashMap();
            for (MultiTalkGroupMember multiTalkGroupMember : multiTalkGroup.zZG) {
                hashMap.put(multiTalkGroupMember.zZH, multiTalkGroupMember);
            }
            for (MultiTalkGroupMember multiTalkGroupMember2 : multiTalkGroup2.zZG) {
                if (!q.FY().equals(multiTalkGroupMember2.zZH) && q.FY().equals(multiTalkGroupMember2.zZI) && multiTalkGroupMember2.status == 1) {
                    if (!hashMap.containsKey(multiTalkGroupMember2.zZH) || ((MultiTalkGroupMember) hashMap.get(multiTalkGroupMember2.zZH)).status == 20) {
                        String str = multiTalkGroupMember2.zZH;
                        Toast.makeText(ad.getContext(), i.a(ad.getContext(), ad.getContext().getString(R.l.ewR, new Object[]{r.gw(str)})), 0).show();
                    }
                }
            }
            this.oLN = multiTalkGroup;
            bdd();
            sort();
            return true;
        } else {
            x.e("MicroMsg.MT.MultiTalkManager", "updateCurrentMultiTalkGroup: not same multitalk\ncurrentGroup=%s\nchangeGroup=%s", i.h(this.oLN), i.h(multiTalkGroup));
            return false;
        }
    }

    private void sort() {
        x.v("MicroMsg.MT.MultiTalkManager", "before sort: %s", this.oLN.zZG);
        List linkedList = new LinkedList();
        Object obj = null;
        for (MultiTalkGroupMember multiTalkGroupMember : this.oLN.zZG) {
            if (multiTalkGroupMember.zZH.equals(q.FY())) {
                obj = multiTalkGroupMember;
            } else {
                linkedList.add(multiTalkGroupMember);
            }
        }
        Collections.sort(linkedList, new Comparator<MultiTalkGroupMember>() {
            public final /* synthetic */ int compare(Object obj, Object obj2) {
                return -((MultiTalkGroupMember) obj).zZH.compareTo(((MultiTalkGroupMember) obj2).zZH);
            }
        });
        Collections.sort(linkedList, new Comparator<MultiTalkGroupMember>() {
            public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                MultiTalkGroupMember multiTalkGroupMember = (MultiTalkGroupMember) obj;
                MultiTalkGroupMember multiTalkGroupMember2 = (MultiTalkGroupMember) obj2;
                if (multiTalkGroupMember.zYH > multiTalkGroupMember2.zYH) {
                    return -1;
                }
                return multiTalkGroupMember.zYH < multiTalkGroupMember2.zYH ? 1 : 0;
            }
        });
        Collections.sort(linkedList, new Comparator<MultiTalkGroupMember>() {
            public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                MultiTalkGroupMember multiTalkGroupMember = (MultiTalkGroupMember) obj;
                MultiTalkGroupMember multiTalkGroupMember2 = (MultiTalkGroupMember) obj2;
                if (!(multiTalkGroupMember.status == 10 && multiTalkGroupMember2.status == 10)) {
                    if (multiTalkGroupMember.status == 10) {
                        return -1;
                    }
                    if (multiTalkGroupMember.status == 10) {
                        return 1;
                    }
                }
                return 0;
            }
        });
        if (obj != null) {
            linkedList.add(obj);
        }
        this.oLN.zZG = linkedList;
        x.v("MicroMsg.MT.MultiTalkManager", "after sort: %s", this.oLN.zZG);
    }

    private void bdd() {
        for (MultiTalkGroupMember multiTalkGroupMember : this.oLN.zZG) {
            if (multiTalkGroupMember.status != 10 && this.oLL.remove(multiTalkGroupMember.zZH)) {
                x.i("MicroMsg.MT.MultiTalkManager", "remove video user according group %s", multiTalkGroupMember.zZH);
            }
        }
    }

    public final void a(Activity activity, String str, String str2) {
        String str3 = "MicroMsg.MT.MultiTalkManager";
        String str4 = "createMultiTalk All Var Value:\n isMute: %b isHandsFree: %b isCameraFace: %b multiTalkStatus: %s groupIsNull: %b";
        Object[] objArr = new Object[5];
        objArr[0] = Boolean.valueOf(this.kYN);
        objArr[1] = Boolean.valueOf(this.oLI);
        objArr[2] = Boolean.valueOf(this.oLK);
        objArr[3] = this.oLM.toString();
        objArr[4] = Boolean.valueOf(this.oLN == null);
        x.i(str3, str4, objArr);
        d.bcL();
        if (bdl()) {
            com.tencent.mm.ui.base.h.h(activity, R.l.epG, R.l.dGZ);
        } else if (d.bIZ()) {
            com.tencent.mm.ui.base.h.h(activity, R.l.epK, R.l.dGZ);
        } else if (d.bJa()) {
            com.tencent.mm.ui.base.h.h(activity, R.l.epJ, R.l.dGZ);
        } else if (com.tencent.mm.at.a.Qr()) {
            com.tencent.mm.ui.base.h.h(activity, R.l.epF, R.l.dGZ);
        } else if (d.bJb()) {
            com.tencent.mm.ui.base.h.h(activity, R.l.epI, R.l.dGZ);
        } else if (bcZ()) {
            com.tencent.mm.at.a.a(activity, R.l.ewB, null);
        } else if (!this.oLS || System.currentTimeMillis() - this.oLT >= this.oLU) {
            this.oLS = false;
            List<String> F = bi.F(str.split(","));
            MultiTalkGroup multiTalkGroup = new MultiTalkGroup();
            multiTalkGroup.zZD = o.bdA().oLv.cDR();
            multiTalkGroup.zZE = str2;
            for (String str5 : F) {
                MultiTalkGroupMember multiTalkGroupMember = new MultiTalkGroupMember();
                multiTalkGroupMember.zZH = str5;
                if (str5.equals(q.FY())) {
                    multiTalkGroupMember.status = 10;
                } else {
                    multiTalkGroupMember.status = 1;
                }
                multiTalkGroup.zZG.add(multiTalkGroupMember);
            }
            o.bdA().oLv.bg(bi.e((Integer) as.Hk().get(1)), q.FY());
            if (o.bdA().oLv.e(multiTalkGroup.zZD, str2, F)) {
                d.bcJ();
            } else {
                d.bcK();
            }
            b(com.tencent.mm.plugin.multitalk.ui.widget.e.Creating);
            c(multiTalkGroup);
        } else {
            com.tencent.mm.at.a.a(activity, R.l.ewK, null);
        }
    }

    public void c(boolean z, boolean z2, boolean z3) {
        int i = 4;
        x.i("MicroMsg.MT.MultiTalkManager", "exitCurrentMultiTalk: isReject %b isMissCall %b isPhoneCall %b isNetworkError %b", Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(false), Boolean.valueOf(z3));
        o.bdB().stopRing();
        if (bcZ()) {
            com.tencent.mm.sdk.b.b myVar = new my();
            myVar.fFP.type = 2;
            com.tencent.mm.sdk.b.a.xmy.m(myVar);
            String l = i.l(this.oLN);
            d.FU(l);
            if (this.oLM != com.tencent.mm.plugin.multitalk.ui.widget.e.Talking) {
                boolean k = i.k(this.oLN);
                long bdc = bdc();
                if (!k) {
                    i = z2 ? bdc >= 45 ? 6 : 8 : z ? 7 : z3 ? 10 : 0;
                } else if (!z2) {
                    i = z ? 1 : z3 ? 5 : 2;
                }
                d.a(k, bdc, l, i);
            } else {
                d.tw(this.oLP);
                d.m((long) this.oLP, l);
            }
            com.tencent.mm.plugin.multitalk.ui.widget.e eVar = this.oLM;
            if (this.oLV != null) {
                this.oLV.bcw();
            }
            this.oLM = com.tencent.mm.plugin.multitalk.ui.widget.e.Init;
            bdk();
            aTG();
            akq();
            o.bdz().reset();
            o.bdC().bdv();
            if (this.oLN != null) {
                a(this.oLN, eVar, z2);
                String str = this.oLN.zZC;
                if (bi.oN(str)) {
                    str = this.oLN.zZD;
                }
                o.bdA().oLv.Ge(str);
                this.oLN = null;
            }
            this.oLJ = 0;
            this.oLI = true;
            this.kYN = false;
            this.oLK = true;
            this.hMJ = 0;
            this.oLP = 0;
            this.oLL.clear();
            this.oLQ = 0;
            return;
        }
        bdk();
        aTG();
        akq();
        this.oLN = null;
        this.oLJ = 0;
        this.hMJ = 0;
        this.oLP = 0;
        this.oLL.clear();
        this.oLM = com.tencent.mm.plugin.multitalk.ui.widget.e.Init;
        this.oLQ = 0;
    }

    public final void b(String str, String str2, boolean z, boolean z2) {
        if (!m.ge(str)) {
            x.i("MicroMsg.MT.MultiTalkManager", "Get Chatroom When chatroom not in conversation %s", str);
            ak.a.hhv.a(str, "", new ak.b.a() {
                public final void v(String str, boolean z) {
                }
            });
        }
        au auVar = new au();
        auVar.setType(64);
        auVar.aq(System.currentTimeMillis());
        auVar.eR(6);
        auVar.eS(2);
        String gw = r.gw(str2);
        if (!(gw == null || gw.equals(""))) {
            str2 = gw;
        }
        gw = str2 + ad.getContext().getString(R.l.ewU);
        auVar.setContent(gw);
        if (m.gf(str)) {
            auVar.dU(str);
            as.Hm();
            com.tencent.mm.y.c.Fh().Q(auVar);
            as.Hm();
            ae XF = com.tencent.mm.y.c.Fk().XF(str);
            if (XF != null) {
                if (z) {
                    XF.eP(XF.field_unReadCount + 1);
                }
                XF.setContent(gw);
                as.Hm();
                if (com.tencent.mm.y.c.Fk().a(XF, str) == -1) {
                    x.e("MicroMsg.MT.MultiTalkManager", "update cvs fail!!! for :" + str);
                }
                if (z2) {
                    ((am) as.getNotification()).a(auVar);
                    return;
                }
                return;
            }
            XF = new ae();
            XF.setUsername(str);
            if (z) {
                XF.eP(1);
            }
            XF.setContent(gw);
            as.Hm();
            com.tencent.mm.y.c.Fk().d(XF);
            if (z2) {
                ((am) as.getNotification()).a(auVar);
            }
        }
    }

    public static void FV(String str) {
        x.i("MicroMsg.MT.MultiTalkManager", "generateMsgExitMsg");
        cg auVar = new au();
        auVar.setType(64);
        auVar.aq(System.currentTimeMillis());
        auVar.eR(6);
        auVar.setContent(ad.getContext().getString(R.l.ewW));
        if (m.gf(str)) {
            auVar.dU(str);
            auVar.setContent(auVar.field_content);
            as.Hm();
            com.tencent.mm.y.c.Fh().Q(auVar);
        }
    }

    private static void a(MultiTalkGroup multiTalkGroup, com.tencent.mm.plugin.multitalk.ui.widget.e eVar, boolean z) {
        x.i("MicroMsg.MT.MultiTalkManager", "generateMsgExitMsg");
        if (eVar == com.tencent.mm.plugin.multitalk.ui.widget.e.Inviting && z) {
            cg auVar = new au();
            auVar.setType(64);
            auVar.aq(System.currentTimeMillis());
            auVar.eR(6);
            auVar.setContent(ad.getContext().getString(R.l.ewW));
            if (m.gf(multiTalkGroup.zZE)) {
                auVar.dU(multiTalkGroup.zZE);
                auVar.setContent(auVar.field_content);
                as.Hm();
                com.tencent.mm.y.c.Fh().Q(auVar);
            }
        }
    }

    public final void g(int i, Object obj) {
        int i2;
        x.i("MicroMsg.MT.MultiTalkManager", "onErr: %d", Integer.valueOf(i));
        as.Hm();
        com.tencent.mm.y.c.Db().a(w.a.USERINFO_MULTITALK_DISABLE_TIME_INT_SYNC, Integer.valueOf(-1));
        as.Hm();
        com.tencent.mm.y.c.Db().a(w.a.USERINFO_MULTITALK_DISABLE_TIMESTAMP_LONG_SYNC, Long.valueOf(-1));
        switch (i) {
            case -14256:
                x.i("MicroMsg.MT.MultiTalkManager", "14256,other device has handle this!");
                i2 = R.l.ews;
                if (!(obj == null || ((aa) obj) == null)) {
                    com.tencent.wecall.talkroom.model.a.cIo().og(false);
                    break;
                }
            case -14255:
                String str = "MicroMsg.MT.MultiTalkManager";
                String str2 = "onErr:MULTITALK_E_Talk_Enter_BannerClear  %d, currentMultiTalkGroup=%s,wxGroupId=%s";
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(i);
                objArr[1] = this.oLN;
                objArr[2] = this.oLN != null ? this.oLN.zZE : "";
                x.i(str, str2, objArr);
                if (obj != null) {
                    aa aaVar = (aa) obj;
                    if (aaVar != null) {
                        x.i("MicroMsg.MT.MultiTalkManager", "ErrorCode :-14255,now exitMultiTalk for groupId : " + aaVar.groupId);
                        if (aaVar.zWa != null) {
                            o.bdD().Gg(aaVar.zWa.zYs);
                            x.i("MicroMsg.MT.MultiTalkManager", "cleanBanner for wxGroupId :" + aaVar.zWa.zYs);
                        }
                        if (!o.bdA().oLv.Ge(aaVar.groupId)) {
                            x.i("MicroMsg.MT.MultiTalkManager", "exit fail!!,now cleanBanner for groupId :" + aaVar.groupId);
                        }
                    }
                }
                i2 = R.l.ewS;
                break;
            case -1700:
                x.i("MicroMsg.MT.MultiTalkManager", "onErr, MULTITALK_ERRORCODE_SWITCHVIDEO_FAIL_DISABLE, disableTime: %s", obj);
                Toast.makeText(ad.getContext(), ad.getContext().getString(R.l.ewj), 0).show();
                if (obj != null) {
                    i2 = ((Integer) obj).intValue();
                    if (i2 > 0) {
                        as.Hm();
                        com.tencent.mm.y.c.Db().a(w.a.USERINFO_MULTITALK_DISABLE_TIME_INT_SYNC, Integer.valueOf(i2));
                        as.Hm();
                        com.tencent.mm.y.c.Db().a(w.a.USERINFO_MULTITALK_DISABLE_TIMESTAMP_LONG_SYNC, Long.valueOf(bi.Wz()));
                    }
                }
                i2 = R.l.ewj;
                break;
            case -1400:
                i2 = R.l.ewr;
                break;
            case -1300:
                i2 = R.l.ewq;
                this.oLS = true;
                this.oLT = System.currentTimeMillis();
                if (obj != null) {
                    z zVar = (z) obj;
                    if (zVar != null) {
                        x.i("MicroMsg.MT.MultiTalkManager", "ErrorCode : -1300, now try set retrySeconds:" + zVar.zXw);
                        if (zVar.zXw != 0) {
                            this.oLU = (long) (zVar.zXw * 1000);
                            break;
                        }
                    }
                }
                break;
            case -1200:
                i2 = R.l.ewp;
                break;
            case -1100:
                i2 = R.l.ewo;
                break;
            case DownloadResult.CODE_UNDEFINED /*-1000*/:
                i2 = R.l.ewn;
                break;
            case -900:
                i2 = R.l.ewA;
                break;
            case -800:
                i2 = R.l.ewz;
                break;
            case -700:
                i2 = R.l.ewy;
                break;
            case -600:
                i2 = R.l.ewx;
                break;
            case -500:
                i2 = R.l.eww;
                break;
            case -400:
                i2 = R.l.ewv;
                break;
            case -300:
                i2 = R.l.ewu;
                break;
            case -200:
                d.gU(false);
                i2 = R.l.ewt;
                break;
            case -100:
                d.gT(false);
                i2 = R.l.ewm;
                break;
            default:
                i2 = R.l.ewx;
                break;
        }
        if (this.oLV != null) {
            this.oLV.onError(i);
        }
        if (i != -800 && i != -500 && i != -1700) {
            Toast.makeText(ad.getContext(), ad.getContext().getString(i2), 0).show();
            c(false, false, true);
        }
    }

    public final void b(final MultiTalkGroup multiTalkGroup) {
        String str = "MicroMsg.MT.MultiTalkManager";
        String str2 = "onInviteMultiTalk All Var Value:\n isMute: %b isHandsFree: %b isCameraFace: %b multiTalkStatus: %s groupIsNull: %b";
        Object[] objArr = new Object[5];
        objArr[0] = Boolean.valueOf(this.kYN);
        objArr[1] = Boolean.valueOf(this.oLI);
        objArr[2] = Boolean.valueOf(this.oLK);
        objArr[3] = this.oLM.toString();
        objArr[4] = Boolean.valueOf(this.oLN == null);
        x.i(str, str2, objArr);
        d.bcM();
        if (com.tencent.mm.j.a.zw() || dg(ad.getContext())) {
            int i;
            boolean i2;
            str = i.m(multiTalkGroup);
            as.Hm();
            com.tencent.mm.f.b.ag Xv = com.tencent.mm.y.c.Ff().Xv(str);
            if (com.tencent.mm.j.g.Af().getInt("MultitalkBlockReceiver", 0) == 0) {
                i2 = 1;
            } else {
                i2 = false;
            }
            if (i2 == 0 || Xv.AM()) {
                x.i("MicroMsg.MT.MultiTalkManager", "not open multitalk receiver or black user");
                ah.h(new Runnable() {
                    public final void run() {
                        String str = multiTalkGroup.zZC;
                        if (bi.oN(str)) {
                            str = multiTalkGroup.zZD;
                        }
                        o.bdA().oLv.Ge(str);
                    }
                }, 1000);
                d.ay(3, i.l(multiTalkGroup));
                return;
            }
            if (!(bcZ() || d.bJa() || d.bIZ() || com.tencent.mm.at.a.Qr())) {
                if (((TelephonyManager) ad.getContext().getSystemService("phone")).getCallState() != 0) {
                    i2 = 1;
                } else {
                    i2 = false;
                }
                if (i2 == 0 && !d.bJb() && com.tencent.mm.k.a.ga(Xv.field_type)) {
                    if (!m.ge(multiTalkGroup.zZE)) {
                        x.i("MicroMsg.MT.MultiTalkManager", "Get Chatroom When chatroom not in conversation %s", multiTalkGroup.zZE);
                        ak.a.hhv.a(multiTalkGroup.zZE, "", null);
                    }
                    x.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk: %s", i.h(multiTalkGroup));
                    b(com.tencent.mm.plugin.multitalk.ui.widget.e.Inviting);
                    d.ay(1, i.l(multiTalkGroup));
                    if (com.tencent.mm.k.a.ga(Xv.field_type)) {
                        x.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk friend show invitingUI inviter=%s,currentuser=%s", str, q.FY());
                        c(multiTalkGroup);
                        return;
                    }
                    x.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk nofriend do not show invitingUI  inviter=%s,currentuser=%s", str, q.FY());
                    if (a(multiTalkGroup)) {
                        this.oLH = false;
                        bde();
                        aTI();
                        return;
                    }
                    return;
                }
            }
            x.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk: exit multitalk: %s", i.h(multiTalkGroup));
            if (!m.ge(multiTalkGroup.zZE)) {
                x.i("MicroMsg.MT.MultiTalkManager", "Get Chatroom When chatroom not in conversation %s", multiTalkGroup.zZE);
                ak.a.hhv.a(multiTalkGroup.zZE, "", new ak.b.a() {
                    public final void v(String str, boolean z) {
                    }
                });
            }
            ah.h(new Runnable() {
                public final void run() {
                    String str = multiTalkGroup.zZC;
                    if (bi.oN(str)) {
                        str = multiTalkGroup.zZD;
                    }
                    o.bdA().oLv.Ge(str);
                }
            }, 1000);
            d.ay(3, i.l(multiTalkGroup));
            return;
        }
        x.i("MicroMsg.MT.MultiTalkManager", "NotificationConfig.isNewVoipMsgNotification() is false and is not in foreground, now return.");
        if (this.oLY == null && this.oMa.cgx()) {
            this.oLY = multiTalkGroup;
            this.oMa.K(2000, 2000);
            this.oLZ = System.currentTimeMillis();
            g.pWK.a(500, 6, 1, false);
        }
    }

    private void c(MultiTalkGroup multiTalkGroup) {
        x.k("MicroMsg.MT.MultiTalkManager", "enterNewMultiTalk", new Object[0]);
        if (a(multiTalkGroup)) {
            this.oLH = false;
            bde();
            aTI();
            com.tencent.mm.bl.d.b(ad.getContext(), "multitalk", ".ui.MultiTalkMainUI", new Intent());
        }
    }

    private void bde() {
        e eVar;
        boolean z;
        e eVar2;
        if (this.oLM == com.tencent.mm.plugin.multitalk.ui.widget.e.Creating) {
            eVar = this;
        } else if (as.Hn().xY() || as.Hn().xS()) {
            eVar = this;
        } else {
            z = true;
            eVar2 = this;
            eVar2.oLI = z;
            this.kYN = false;
            this.oLW = i.bdt();
        }
        eVar2 = eVar;
        z = false;
        eVar2.oLI = z;
        this.kYN = false;
        this.oLW = i.bdt();
    }

    public final void d(MultiTalkGroup multiTalkGroup) {
        d.ay(2, i.l(multiTalkGroup));
        a(multiTalkGroup, com.tencent.mm.plugin.multitalk.ui.widget.e.Inviting, true);
    }

    public final void e(MultiTalkGroup multiTalkGroup) {
        x.i("MicroMsg.MT.MultiTalkManager", "onCreateMultiTalk: %s", i.h(multiTalkGroup));
        d.gT(true);
        if (a(multiTalkGroup)) {
            bdf();
        }
    }

    public final void f(MultiTalkGroup multiTalkGroup) {
        x.i("MicroMsg.MT.MultiTalkManager", "onEnterMultiTalk: %s", i.h(multiTalkGroup));
        com.tencent.mm.sdk.b.b myVar = new my();
        myVar.fFP.type = 1;
        com.tencent.mm.sdk.b.a.xmy.m(myVar);
        d.gU(true);
        if (this.oLM != com.tencent.mm.plugin.multitalk.ui.widget.e.Inviting) {
            b(com.tencent.mm.plugin.multitalk.ui.widget.e.Starting);
            c(multiTalkGroup);
        }
        if (bcZ() && a(multiTalkGroup)) {
            bdf();
        }
    }

    private void bdf() {
        if (i.i(this.oLN)) {
            b(com.tencent.mm.plugin.multitalk.ui.widget.e.Talking);
        } else {
            b(com.tencent.mm.plugin.multitalk.ui.widget.e.Starting);
        }
        if (this.oLV != null) {
            this.oLV.aZD();
            i.a bdt = i.bdt();
            if (bdt != this.oLW) {
                this.oLW = bdt;
                return;
            }
            return;
        }
        com.tencent.mm.bl.d.b(ad.getContext(), "multitalk", ".ui.MultiTalkMainUI", new Intent());
    }

    public final void g(MultiTalkGroup multiTalkGroup) {
        x.i("MicroMsg.MT.MultiTalkManager", "onMemberChange: %s", i.h(multiTalkGroup));
        if (!bcZ() || !a(multiTalkGroup)) {
            return;
        }
        if (i.j(this.oLN)) {
            if (this.oLM != com.tencent.mm.plugin.multitalk.ui.widget.e.Talking && i.i(multiTalkGroup)) {
                b(com.tencent.mm.plugin.multitalk.ui.widget.e.Talking);
            }
            if (this.oLV != null && i.c(this.oLM)) {
                this.oLV.bcx();
            }
        } else if (this.oLM == com.tencent.mm.plugin.multitalk.ui.widget.e.Inviting) {
            c(false, true, false);
        } else {
            c(false, false, false);
        }
    }

    public final void bdg() {
        x.i("MicroMsg.MT.MultiTalkManager", "onMultiTalkReady");
    }

    public final void gQ(boolean z) {
        this.kYN = z;
        if (this.oLV != null) {
            this.oLV.gQ(this.kYN);
        }
    }

    public final void bdh() {
        x.i("MicroMsg.MT.MultiTalkManager", "onSwitchMultiTalkVideoSuss currentVideoAction %d", Integer.valueOf(this.oLJ));
    }

    public final void bdi() {
        x.i("MicroMsg.MT.MultiTalkManager", "onSubscribeLargeVideoSuss ");
    }

    public final void tx(int i) {
        x.i("MicroMsg.MT.MultiTalkManager", "onNotifyLargeVideoSubscribersChange largeVideoSubscribersCnt: " + i);
        if (i > 0) {
            this.oLX = true;
        } else {
            this.oLX = false;
        }
    }

    public final void bk(List<com.tencent.pb.common.b.a.a.am> list) {
        if (bcZ()) {
            this.oLL.clear();
            x.d("MicroMsg.MT.MultiTalkManager", "onVideoGroupMemberChange: %s", list);
            for (com.tencent.pb.common.b.a.a.am amVar : list) {
                if (amVar.zXP == 2 || amVar.zXP == 3) {
                    this.oLL.add(amVar.zXO);
                }
            }
            this.oLL.remove(q.FY());
            x.i("MicroMsg.MT.MultiTalkManager", "onVideoGroupMemberChange %s", this.oLL);
            if (this.oLO != null) {
                this.oLO.tB(this.oLL.size());
            }
            if (this.oLV != null) {
                this.oLV.bcy();
            }
        }
    }

    public final void gV(boolean z) {
        if (bcZ() && !this.nHN) {
            this.nHN = true;
            d.d(i.bdq(), o.bdB().bcX(), z);
            Toast.makeText(ad.getContext(), R.l.ewI, 0).show();
            CharSequence string = ad.getContext().getString(R.l.ewg);
            CharSequence string2 = ad.getContext().getString(R.l.ewL);
            Intent intent = new Intent();
            intent.setClass(ad.getContext(), MultiTalkMainUI.class);
            PendingIntent activity = PendingIntent.getActivity(ad.getContext(), 43, intent, 134217728);
            int i = R.g.bEr;
            if (com.tencent.mm.compatible.util.d.fO(19)) {
                i = R.g.bEq;
            }
            Notification a = d.a(new Builder(ad.getContext()).setTicker(string2).setWhen(System.currentTimeMillis()).setContentTitle(string).setContentText(string2).setContentIntent(activity));
            a.icon = i;
            a.flags |= 32;
            as.getNotification().a(43, a, false);
            if (this.oLV != null) {
                this.oLV.aTN();
            }
            ah.y(new Runnable() {
                public final void run() {
                    Intent intent = new Intent();
                    intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    intent.putExtra("enterMainUiWxGroupId", e.this.oLN != null ? e.this.oLN.zZE : "");
                    intent.setClass(ad.getContext(), MultiTalkMainUI.class);
                    intent.putExtra("enterMainUiSource", 1);
                    com.tencent.mm.plugin.voip.model.d.bGU().a(intent, new com.tencent.mm.plugin.voip.ui.a() {
                        public final boolean aTJ() {
                            if (e.this.bda() || e.this.bdb()) {
                                return true;
                            }
                            return false;
                        }

                        public final void a(Intent intent, com.tencent.mm.plugin.voip.ui.h hVar) {
                            if (e.this.bdb()) {
                                int i = e.this.oLP;
                                hVar.Nj(String.format("%02d:%02d", new Object[]{Integer.valueOf(i / 60), Integer.valueOf(i % 60)}));
                                return;
                            }
                            hVar.Nj(ad.getContext().getString(R.l.ewY));
                        }
                    });
                }
            });
        }
    }

    public final void aTG() {
        this.nHN = false;
        com.tencent.mm.plugin.voip.model.d.bGU().dismiss();
        ((NotificationManager) ad.getContext().getSystemService("notification")).cancel(43);
    }

    public final void bdj() {
        x.i("MicroMsg.MT.MultiTalkManager", "try to startNetworkReceiver");
        if (this.oLV == null) {
            x.e("MicroMsg.MT.MultiTalkManager", "ui callback is null");
        } else if (this.oLL.size() == 0) {
            x.i("MicroMsg.MT.MultiTalkManager", "currentVideoUserSet.size() is 0,just return.");
        } else {
            if (this.oLO == null) {
                x.i("MicroMsg.MT.MultiTalkManager", "startNetworkReceiver: networkReceiver is null %d", Integer.valueOf(this.oLL.size()));
                this.oLO = new k(this.oLV);
                this.oLO.tB(this.oLL.size());
            }
            if (!this.oLO.fmm) {
                this.oLO.start();
            }
        }
    }

    public final void bdk() {
        x.i("MicroMsg.MT.MultiTalkManager", "try to stopNetworkReceiver");
        if (this.oLO != null) {
            this.oLO.stop();
            this.oLO = null;
        }
    }

    public final void gW(boolean z) {
        o.bdA().oLv.gW(z);
        x.i("MicroMsg.MT.MultiTalkManager", "onSpeakerStateChange %b", Boolean.valueOf(z));
        this.oLI = z;
        if (this.oLV != null) {
            this.oLV.gR(this.oLI);
        }
    }

    public final boolean ty(int i) {
        if (!bda()) {
            return false;
        }
        x.i("MicroMsg.MT.MultiTalkManager", "try switch to action : " + i);
        boolean ty = o.bdA().oLv.ty(i);
        x.i("MicroMsg.MT.MultiTalkManager", "switchMultiTalkVideo %b", Boolean.valueOf(ty));
        int i2 = this.oLJ;
        this.oLJ = i;
        if (bcY()) {
            bdj();
        } else {
            bdk();
        }
        if (this.oLV == null || i2 == this.oLJ) {
            return ty;
        }
        this.oLV.cU(i2, this.oLJ);
        return ty;
    }

    public final boolean FW(String str) {
        if (!bda()) {
            return false;
        }
        x.i("MicroMsg.MT.MultiTalkManager", "ownerUserName : " + str);
        boolean FW = o.bdA().oLv.FW(str);
        x.i("MicroMsg.MT.MultiTalkManager", "result of subscribeLargeVideo: " + FW);
        return FW;
    }

    private void b(com.tencent.mm.plugin.multitalk.ui.widget.e eVar) {
        boolean z = true;
        com.tencent.mm.plugin.multitalk.ui.widget.e eVar2 = this.oLM;
        this.oLM = eVar;
        if (eVar2 != eVar) {
            if (eVar == com.tencent.mm.plugin.multitalk.ui.widget.e.Talking) {
                com.tencent.mm.sdk.b.b myVar = new my();
                myVar.fFP.type = 1;
                com.tencent.mm.sdk.b.a.xmy.m(myVar);
                d.a(i.k(this.oLN), bdc(), i.l(this.oLN));
                o.bdB().stopRing();
                if (as.Hn().xY() || as.Hn().xS()) {
                    z = false;
                }
                gW(z);
            }
            if (this.oLV != null) {
                this.oLV.a(eVar);
            }
        }
    }

    private void aTI() {
        x.i("MicroMsg.MT.MultiTalkManager", "startTimeCount");
        if (this.jBG != null) {
            this.jBG.cancel();
            return;
        }
        this.hMJ = System.currentTimeMillis();
        this.oLP = 0;
        this.jBG = new Timer();
        this.jBG.schedule(new TimerTask() {
            public final void run() {
                if (e.this.bdc() >= 45000 && e.this.oLM != com.tencent.mm.plugin.multitalk.ui.widget.e.Talking) {
                    ah.y(new Runnable() {
                        public final void run() {
                            e.this.c(false, true, false);
                        }
                    });
                }
                if (e.this.oLM == com.tencent.mm.plugin.multitalk.ui.widget.e.Talking) {
                    e eVar = e.this;
                    eVar.oLP++;
                    ah.y(new Runnable() {
                        public final void run() {
                            if (e.this.oLM == com.tencent.mm.plugin.multitalk.ui.widget.e.Talking) {
                                com.tencent.mm.plugin.voip.model.d.bGU().xr(e.this.oLP);
                                if (e.this.oLV != null) {
                                    e.this.oLV.aTO();
                                }
                            }
                        }
                    });
                }
            }
        }, 1000, 1000);
    }

    private void akq() {
        if (this.jBG != null) {
            this.jBG.cancel();
            this.jBG = null;
        }
    }

    public final void gX(boolean z) {
        if (!this.oLH) {
            this.nIN.m(R.k.dAv, 0, z);
            this.hZB.requestFocus();
            this.oLH = true;
        }
    }

    public final void stopRing() {
        com.tencent.mm.sdk.f.e.post(new Runnable() {
            public final void run() {
                e.this.nIN.stop();
                e.this.oLH = false;
                e.this.hZB.zk();
                as.Hn().setSpeakerphoneOn(e.this.oLI);
            }
        }, "MultiTalkManager_stop_ring");
    }

    private static boolean bdl() {
        Exception e;
        boolean z;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) ad.getContext().getSystemService("phone");
            if (telephonyManager == null) {
                return false;
            }
            switch (telephonyManager.getCallState()) {
                case 0:
                    z = false;
                    break;
                case 1:
                case 2:
                    z = true;
                    break;
                default:
                    z = false;
                    break;
            }
            try {
                x.i("MicroMsg.MT.MultiTalkManager", "TelephoneManager.callState is %d", Integer.valueOf(r2));
                return z;
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            z = false;
            x.e("MicroMsg.MT.MultiTalkManager", "get callState error , errMsg is %s", e.getLocalizedMessage());
            return z;
        }
    }

    static boolean dg(Context context) {
        List runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1);
        if (!(runningTasks == null || runningTasks.isEmpty())) {
            ComponentName componentName = ((RunningTaskInfo) runningTasks.get(0)).topActivity;
            x.d("MicroMsg.MT.MultiTalkManager", "topActivity:" + componentName.flattenToString());
            if (!componentName.getPackageName().equals(context.getPackageName())) {
                x.i("MicroMsg.MT.MultiTalkManager", "is in backGround.");
                return false;
            }
        }
        if (((KeyguardManager) ad.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            return false;
        }
        x.i("MicroMsg.MT.MultiTalkManager", "is in foreGround.");
        return true;
    }
}
