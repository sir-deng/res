package com.tencent.mm.plugin.voip.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.SharedPreferences;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.f.a.sq;
import com.tencent.mm.f.a.to;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetSetting;
import com.tencent.mm.plugin.appbrand.jsapi.share.h;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiGetGameCommInfo;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiLaunchApplication;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.bd;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.ui.c;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.f;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.y.as;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public final class j implements com.tencent.mm.compatible.b.f.a, com.tencent.mm.plugin.voip.model.k.a, p, c, f, com.tencent.mm.plugin.voip.video.j.a {
    public b flO;
    public String gBJ;
    public ag jQE;
    private boolean mIsMute = false;
    private int mUIType;
    public TelephonyManager nHI;
    public PhoneStateListener nHJ = new PhoneStateListener() {
        public final void onCallStateChanged(int i, String str) {
            int i2 = true;
            super.onCallStateChanged(i, str);
            x.d("MicroMsg.Voip.VoipMgr", "onCallStateChanged :%d, isStartVoip: %b", Integer.valueOf(i), Boolean.valueOf(j.this.sss));
            if (!j.this.sss) {
                return;
            }
            if (i == 1) {
                j.this.ssu = true;
                d.bGT().za(1);
            } else if (i == 2) {
                String string;
                j.this.ssu = false;
                x.i("MicroMsg.Voip.VoipMgr", "phone call coming now!");
                if (j.this.srZ && !com.tencent.mm.plugin.voip.b.b.zj(j.this.srQ.mState)) {
                    n nVar = d.bGT().ssY;
                    x.i("MicroMsg.Voip.VoipServiceEx", "cancelCallByPhoneInter, roomId:" + nVar.soQ.sqj.nJe);
                    if (nVar.soQ.sqj.nJe != 0) {
                        nVar.soQ.sqj.svN.sqW = 102;
                        nVar.soQ.sqj.svN.srj = 6;
                        g.pWK.a(11521, true, true, Integer.valueOf(d.bGT().ssY.soQ.sqj.nJe), Long.valueOf(d.bGT().bIa()), Long.valueOf(d.bGT().bIb()), Integer.valueOf(3), Long.valueOf(System.currentTimeMillis()), Long.valueOf(System.currentTimeMillis()));
                        nVar.bIn();
                    }
                }
                if (com.tencent.mm.plugin.voip.b.b.zj(j.this.srQ.mState)) {
                    string = ad.getContext().getString(R.l.eUB, new Object[]{j.bq(bi.bz(j.this.ssf))});
                } else {
                    string = ad.getContext().getString(R.l.eUy);
                }
                n nVar2 = d.bGT().ssY;
                x.i("MicroMsg.Voip.VoipServiceEx", "hangUpByPhoneInter");
                if (nVar2.soQ.sqj.nJe == 0) {
                    nVar2.soQ.sql.bHo();
                    nVar2.reset();
                } else {
                    nVar2.soQ.sqj.svN.sqW = 109;
                    nVar2.soQ.sqj.svN.srp = 4;
                    nVar2.bIp();
                }
                String str2 = j.this.srY.field_username;
                String str3 = j.this.ssa ? au.xHC : au.xHB;
                if (!j.this.srZ) {
                    i2 = 0;
                }
                l.a(str2, str3, i2, 6, string);
                j.this.ld(4107);
                j.this.bHF();
                au auVar = new au();
                auVar.setType(10000);
                auVar.aq(System.currentTimeMillis());
                auVar.eR(6);
                auVar.setContent(ad.getContext().getString(R.l.eUA) + ", <a href=\"weixin://voip/callagain/?username=" + j.this.gBJ + "&isvideocall=" + j.this.ssa + "\">" + ad.getContext().getString(R.l.eUv) + "</a>");
                if (!(j.this.gBJ == null || j.this.gBJ.equals(""))) {
                    auVar.dU(j.this.gBJ);
                    as.Hm();
                    com.tencent.mm.y.c.Fh().Q(auVar);
                }
                d.bGT().za(2);
            } else if (i == 0) {
                d.bGT().za(2);
                if (1 == j.this.sse && com.tencent.mm.plugin.voip.b.b.zj(j.this.srQ.mState) && j.this.ssu) {
                    j.this.jk(true);
                }
                j.this.ssu = false;
            }
        }
    };
    public com.tencent.mm.sdk.b.c nHK = new com.tencent.mm.sdk.b.c<sq>() {
        {
            this.xmG = sq.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            sq sqVar = (sq) bVar;
            if (sqVar instanceof sq) {
                sqVar.fLh.fLi = com.tencent.mm.plugin.voip.b.b.zk(j.this.srQ.mState);
                sqVar.fLh.fLj = j.this.srT != null;
                sqVar.fLh.fLk = true;
                sqVar.fLh.talker = j.this.gBJ;
            }
            return false;
        }
    };
    private long nKa = 0;
    private boolean oyb = false;
    public com.tencent.mm.plugin.voip.b.c srQ;
    public HeadsetPlugReceiver srR;
    com.tencent.mm.plugin.voip.ui.b srS;
    private com.tencent.mm.plugin.voip.video.a srT;
    private CaptureView srU;
    private a srV = null;
    private boolean srW = false;
    private Object srX = new Object();
    public com.tencent.mm.storage.x srY;
    public boolean srZ;
    public boolean ssa;
    public boolean ssb = false;
    private int ssc = Downloads.RECV_BUFFER_SIZE;
    private boolean ssd = false;
    public int sse = 1;
    private long ssf = -1;
    private boolean ssg = false;
    public boolean ssh = false;
    private boolean ssi = false;
    private boolean ssj = false;
    private int ssk = 0;
    public com.tencent.mm.plugin.voip.video.j ssl = new com.tencent.mm.plugin.voip.video.j();
    private al ssm = null;
    private ah ssn;
    private boolean sso = false;
    private boolean ssp = false;
    private int ssq = 0;
    private boolean ssr = false;
    public boolean sss = false;
    private com.tencent.mm.plugin.voip.widget.b sst;
    private boolean ssu = false;
    private boolean ssv = false;
    public String ssw = null;
    public BroadcastReceiver ssx = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            PowerManager powerManager = (PowerManager) ad.getContext().getSystemService("power");
            if ("android.intent.action.USER_PRESENT".equals(action) && powerManager.isScreenOn()) {
                j.this.ssj = false;
            } else if ("android.intent.action.SCREEN_ON".equals(action)) {
                j.this.ssj = false;
            } else if ("android.intent.action.SCREEN_OFF".equals(action)) {
                j.this.ssj = true;
                if (!com.tencent.mm.plugin.voip.b.b.zj(j.this.srQ.mState) && !j.this.srZ) {
                    d.bGT().stopRing();
                }
            }
        }
    };
    public com.tencent.mm.plugin.voip.HeadsetPlugReceiver.a ssy = new com.tencent.mm.plugin.voip.HeadsetPlugReceiver.a() {
        public final void gc(boolean z) {
            x.d("MicroMsg.Voip.VoipMgr", "onHeadsetState, on:%b", Boolean.valueOf(z));
            if (!(true == z && 3 == j.this.sse) && (z || 3 == j.this.sse)) {
                if (com.tencent.mm.plugin.voip.b.b.zk(j.this.srQ.mState)) {
                    if (z) {
                        j.this.jk(false);
                        j.this.sse = 3;
                    } else if (d.bGT().bIf()) {
                        Toast.makeText(j.this.getContext(), j.this.getContext().getString(R.l.eWm), 0).show();
                        j.this.jk(true);
                        j.this.sse = 1;
                    } else {
                        j.this.jk(false);
                        j.this.sse = 3;
                    }
                } else if (z) {
                    if (1 == j.this.sse) {
                        j.this.jk(false);
                        j.this.ssg = true;
                    } else {
                        j.this.ssg = false;
                    }
                    j.this.sse = 3;
                } else if (d.bGT().bIf()) {
                    if (j.this.ssg || 2 == j.this.mUIType) {
                        Toast.makeText(j.this.getContext(), j.this.getContext().getString(R.l.eWm), 0).show();
                        j.this.jk(true);
                        j.this.sse = 1;
                    } else {
                        Toast.makeText(j.this.getContext(), j.this.getContext().getString(R.l.eWl), 0).show();
                        j.this.sse = 2;
                    }
                    j.this.ssg = false;
                } else {
                    j.this.jk(false);
                    j.this.sse = 2;
                }
                j.this.yS(j.this.sse);
                return;
            }
            x.d("MicroMsg.Voip.VoipMgr", "same status, no changed");
        }
    };
    public com.tencent.mm.sdk.b.c ssz = new com.tencent.mm.sdk.b.c<to>() {
        {
            this.xmG = to.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            final to toVar = (to) bVar;
            if (toVar instanceof to) {
                ah.y(new Runnable() {
                    public final void run() {
                        switch (toVar.fMW.fql) {
                            case 1:
                                if (com.tencent.mm.plugin.voip.b.b.zk(j.this.srQ.mState)) {
                                    j.this.bHw();
                                    return;
                                } else {
                                    j.this.bHy();
                                    return;
                                }
                            case 2:
                                if (com.tencent.mm.plugin.voip.b.b.zk(j.this.srQ.mState)) {
                                    j.this.bHv();
                                    return;
                                } else {
                                    j.this.bHx();
                                    return;
                                }
                            case 3:
                                j.this.bHt();
                                return;
                            default:
                                return;
                        }
                    }
                });
            }
            return false;
        }
    };

    /* renamed from: com.tencent.mm.plugin.voip.model.j$11 */
    class AnonymousClass11 implements OnClickListener {
        final /* synthetic */ Context ssK;

        public AnonymousClass11(Context context) {
            this.ssK = context;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            x.i("MicroMsg.Voip.VoipMgr", "show Permission settings");
            com.tencent.mm.compatible.f.b.aL(this.ssK);
            if (j.this.srZ) {
                if (j.this.ssa) {
                    j.this.bHz();
                } else {
                    j.this.bHA();
                }
            } else if (j.this.ssa) {
                j.this.bHv();
            } else {
                j.this.bHx();
            }
        }
    }

    class a implements Runnable {
        a() {
        }

        public final void run() {
            j.this.bHL();
            j.this.srV = null;
        }
    }

    static /* synthetic */ void e(j jVar, boolean z) {
        x.i("MicroMsg.Voip.VoipMgr", "do minimizeVoip");
        if (2 != jVar.mUIType || VERSION.SDK_INT >= 24) {
            jVar.mUIType = 2;
            jVar.ssk++;
            jVar.sst = new com.tencent.mm.plugin.voip.widget.b(jVar, jVar.srQ.mState, jVar.srY, jVar.ssa, jVar.srZ, z);
            if (GameJsApiLaunchApplication.CTRL_BYTE == jVar.srQ.mState || 6 == jVar.srQ.mState) {
                as.Hm();
                if (1 == com.tencent.mm.y.c.Db().getInt(327948, 0)) {
                    Toast.makeText(jVar.getContext(), jVar.getContext().getString(R.l.eWk), 0).show();
                } else {
                    Toast.makeText(jVar.getContext(), jVar.getContext().getString(R.l.eWj), 1).show();
                    as.Hm();
                    com.tencent.mm.y.c.Db().setInt(327948, 1);
                }
            }
            if (jVar.srQ.mState == 0 || 2 == jVar.srQ.mState || 256 == jVar.srQ.mState) {
                jVar.bHM();
            }
            d.bGT().stopRing();
            d.bGT().B(true, z);
            return;
        }
        x.e("MicroMsg.Voip.VoipMgr", "already is widget");
    }

    static /* synthetic */ void w(j jVar) {
        if (com.tencent.mm.plugin.voip.b.b.zj(jVar.srQ.mState)) {
            jVar.ssl.sBc = jVar.ssp;
            jVar.ssl.sBd = jVar.ssq;
            com.tencent.mm.plugin.voip.video.j jVar2 = jVar.ssl;
            int[] iArr = new int[2];
            if (jVar.ssr) {
                iArr[0] = 1;
                iArr[1] = 0;
            } else {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            ByteBuffer allocate = ByteBuffer.allocate(8);
            allocate.asIntBuffer().put(iArr);
            byte[] array = allocate.array();
            if (jVar2.ssL.setAppCmd(13, array, array.length) >= 0) {
                int length = (array.length % 4 == 0 ? 0 : 1) + (array.length / 4);
                ByteBuffer allocate2 = ByteBuffer.allocate(length * 4);
                allocate2.put(array);
                allocate2.order(ByteOrder.nativeOrder());
                allocate2.rewind();
                int[] iArr2 = new int[length];
                allocate2.asIntBuffer().get(iArr2);
                int i = iArr2[0];
                length = iArr2[1];
                if (i + length != 0) {
                    b bVar = new b();
                    bVar = new b();
                    bVar.sBg = i & 65535;
                    bVar.sBh = (i >> 16) & 65535;
                    bVar.sBi = length & 65535;
                    bVar.sBj = (length >> 16) & 65535;
                    x.d("MicroMsg.VoipFaceDetector", "detect face, location:%s", bVar);
                    Iterator it = jVar2.kCL.iterator();
                    while (it.hasNext()) {
                        ((com.tencent.mm.plugin.voip.video.j.a) it.next()).a(new int[]{bVar.sBg, bVar.sBh, bVar.sBi, bVar.sBj}, jVar2.sBc, jVar2.sBd);
                    }
                    return;
                }
                Iterator it2 = jVar2.kCL.iterator();
                while (it2.hasNext()) {
                    ((com.tencent.mm.plugin.voip.video.j.a) it2.next()).a(null, jVar2.sBc, jVar2.sBd);
                }
            }
        }
    }

    public final void er(int i) {
        int i2 = 1;
        x.d("MicroMsg.Voip.VoipMgr", "onBluetoothHeadsetStateChange status: %d, mBTRecoverSpeakerOn: %b", Integer.valueOf(i), Boolean.valueOf(this.ssh));
        switch (i) {
            case 1:
                as.Hn().b(false, d.bGT().bGR());
                d.bGT().ji(false);
                d.bGT().jo(false);
                i2 = 4;
                break;
            case 2:
                as.Hn().xQ();
                jk(bcA());
                if (!bcA()) {
                    i2 = 2;
                    break;
                }
                break;
            case 3:
                as.Hn().xP();
                return;
            case 4:
                as.Hn().xQ();
                as.Hn().xO();
                jk(bcA());
                if (!bcA()) {
                    i2 = 2;
                }
                yS(i2);
                return;
            default:
                return;
        }
        yS(i2);
    }

    private boolean bcA() {
        if (d.bGT().bIf() && this.ssa) {
            return true;
        }
        if (this.srZ || !this.ssa) {
            return false;
        }
        return true;
    }

    private void yS(int i) {
        this.sse = i;
        if (this.srS != null) {
            this.srS.zc(this.sse);
        }
    }

    private void jk(boolean z) {
        x.j("MicroMsg.Voip.VoipMgr", "enableSpeaker: " + z, new Object[0]);
        this.ssg = z;
        this.ssh = z;
        x.d("MicroMsg.Voip.VoipMgr", "MMCore.getAudioManager() " + as.Hn().xW());
        if (as.Hn().xS()) {
            z = false;
        }
        if (q.gHG.gEr) {
            q.gHG.dump();
            if (q.gHG.gEs > 0) {
                d.bGT().ji(z);
            }
        }
        if (q.gHG.gEU >= 0 || q.gHG.gEV >= 0) {
            d.bGT().ji(z);
        }
        as.Hn().b(z, d.bGT().bGR());
        d.bGT().jo(z);
        this.ssi = z;
    }

    public final void jl(boolean z) {
        int i;
        x.d("MicroMsg.Voip.VoipMgr", "onSpeakerStateChanged, isSpeakerOn: %b", Boolean.valueOf(z));
        if (d.bGT().bIf()) {
            jk(z);
        } else {
            n nVar = d.bGT().ssY;
            if (nVar.str != null) {
                nVar.str.ju(z);
            }
        }
        if (z) {
            i = 1;
        } else {
            i = 2;
        }
        yS(i);
        g gVar = g.pWK;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(2);
        if (z) {
            i = 1;
        } else {
            i = 2;
        }
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(0);
        gVar.h(11080, objArr);
    }

    public final void gQ(boolean z) {
        int i = 1;
        g gVar;
        if (z) {
            gVar = d.bGT().ssY.soQ.sql;
            if (gVar.oLx != null) {
                gVar.oLx.aS(true);
            }
            d.bGT().yN(9);
            d.bGT().jn(true);
        } else {
            gVar = d.bGT().ssY.soQ.sql;
            if (gVar.oLx != null) {
                gVar.oLx.aS(false);
            }
            d.bGT().yN(8);
            d.bGT().jn(false);
        }
        this.mIsMute = z;
        g gVar2 = g.pWK;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(2);
        objArr[1] = Integer.valueOf(0);
        if (z) {
            i = 2;
        }
        objArr[2] = Integer.valueOf(i);
        gVar2.h(11080, objArr);
    }

    public final boolean bHt() {
        if (!this.srQ.zm(4103)) {
            return false;
        }
        yT(4103);
        d.bGT().bIj();
        return true;
    }

    public final boolean bHu() {
        if (!this.srQ.zm(4101)) {
            return false;
        }
        d.bGT().stopRing();
        d.bGT().yN(1);
        d.bGT().C(true, this.ssa);
        g gVar = g.pWK;
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(1);
        objArr[1] = Long.valueOf(d.bGT().bIa());
        objArr[2] = Integer.valueOf(d.bGT().ssY.soQ.sqj.nJe);
        objArr[3] = Integer.valueOf(0);
        objArr[4] = Integer.valueOf(this.srZ ? 1 : 0);
        gVar.h(11046, objArr);
        g.pWK.h(11080, Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0));
        ld(4111);
        ld(4101);
        ld(4100);
        return true;
    }

    public final boolean bHv() {
        int i = 0;
        if (!this.srQ.zm(4099)) {
            return false;
        }
        String str = this.srY.field_username;
        String str2 = this.ssa ? au.xHC : au.xHB;
        if (this.srZ) {
            i = 1;
        }
        l.a(str, str2, i, 6, ad.getContext().getString(R.l.eUE));
        d.bGT().stopRing();
        d.bGT().ssY.bIo();
        ld(4099);
        bHF();
        return true;
    }

    public final boolean bHw() {
        if (!this.srQ.zm(4100)) {
            return false;
        }
        x.i("MicroMsg.Voip.VoipMgr", "onAcceptVideoInvite");
        d.bGT().stopRing();
        d.bGT().C(false, this.ssa);
        ld(4100);
        return true;
    }

    public final boolean bHx() {
        int i = 0;
        if (!this.srQ.zm(4099)) {
            return false;
        }
        x.i("MicroMsg.Voip.VoipMgr", "onRejectVoiceInvite");
        String str = this.srY.field_username;
        String str2 = this.ssa ? au.xHC : au.xHB;
        if (this.srZ) {
            i = 1;
        }
        l.a(str, str2, i, 6, ad.getContext().getString(R.l.eUE));
        d.bGT().stopRing();
        d.bGT().ssY.bIo();
        ld(4099);
        bHF();
        return true;
    }

    public final boolean bHy() {
        if (!this.srQ.zm(4100)) {
            return false;
        }
        x.i("MicroMsg.Voip.VoipMgr", "onAcceptVoiceInvite");
        d.bGT().stopRing();
        d.bGT().C(true, this.ssa);
        ld(4111);
        ld(4100);
        return true;
    }

    public final boolean bHz() {
        if (!this.srQ.zm(4098)) {
            return false;
        }
        x.i("MicroMsg.Voip.VoipMgr", "onCancelVideoInvite");
        yT(4098);
        d.bGT().bIj();
        return true;
    }

    public final boolean bHA() {
        if (!this.srQ.zm(4098)) {
            return false;
        }
        x.i("MicroMsg.Voip.VoipMgr", "onCancelVoiceInvite");
        yT(4098);
        d.bGT().bIj();
        return true;
    }

    public final void a(com.tencent.mm.plugin.voip.ui.b bVar, int i) {
        x.i("MicroMsg.Voip.VoipMgr", "onVoipUICreated");
        if (1 == i && this.srS != null) {
            this.srS.uninit();
        }
        this.srS = bVar;
        this.mUIType = i;
        int i2 = 320;
        int i3 = 240;
        if (this.srT == null && com.tencent.mm.plugin.voip.b.b.zk(this.srQ.mState)) {
            this.srU = new CaptureView(ad.getContext());
            if (v2protocal.sue) {
                x.i("MicroMsg.Voip.VoipMgr", "steve: 640 capture!");
                i2 = 640;
                i3 = 480;
            }
            this.srT = new com.tencent.mm.plugin.voip.video.a(i2, i3);
            this.srT.a((f) this, true);
            this.srT.a(this.srU);
            d.bGT().yY(this.srT.bJk());
            this.jQE.postDelayed(new Runnable() {
                public final void run() {
                    x.d("MicroMsg.Voip.VoipMgr", "mCaptureRender == " + j.this.srT);
                    if (j.this.srT != null) {
                        j.this.srT.bJf();
                    }
                }
            }, 50);
        }
        this.srS.a(this.srU);
        this.srS.dU(-1, this.srQ.mState);
        this.srS.ff(this.ssf);
        this.srS.zc(this.sse);
        this.srS.setMute(this.mIsMute);
    }

    public final void a(com.tencent.mm.plugin.voip.ui.b bVar) {
        x.i("MicroMsg.Voip.VoipMgr", "onVoipUIDestroy");
        if (this.srS == bVar) {
            x.d("MicroMsg.Voip.VoipMgr", "same VoipUI, clear it");
            this.srS = null;
        }
        if (this.jQE != null) {
            this.jQE = null;
        }
    }

    public final void bHB() {
        x.i("MicroMsg.Voip.VoipMgr", "onSwitchCamera");
        if (this.srT != null) {
            this.srT.bJe();
        }
        g.pWK.h(11079, Integer.valueOf(1));
    }

    private void yT(int i) {
        String string;
        x.i("MicroMsg.Voip.VoipMgr", "hangupTalkingOrCancelInvite");
        if (true == bHN()) {
            this.ssc = i;
        }
        Context context = ad.getContext();
        if (com.tencent.mm.plugin.voip.b.b.zj(this.srQ.mState)) {
            string = context.getString(R.l.eUB, new Object[]{bq(bi.bz(this.ssf))});
        } else if (this.srZ) {
            string = context.getString(R.l.eUx);
        } else {
            string = context.getString(R.l.eUw);
        }
        l.a(this.srY.field_username, this.ssa ? au.xHC : au.xHB, this.srZ ? 1 : 0, 6, string);
        if (!this.srZ || com.tencent.mm.plugin.voip.b.b.zj(this.srQ.mState)) {
            e.post(new Runnable() {
                public final void run() {
                    d.bGT().stopRing();
                    if (j.this.ssa) {
                        d.bGT().dS(R.k.dAw, 0);
                    } else {
                        d.bGT().dS(R.k.dAw, 1);
                    }
                }
            }, "VoipMgr_play_end_sound");
            this.srW = true;
            d.bGT().bHY();
            if (Downloads.RECV_BUFFER_SIZE == this.ssc) {
                ld(i);
                bHF();
                return;
            }
            return;
        }
        d.bGT().stopRing();
        if (this.srZ && !com.tencent.mm.plugin.voip.b.b.zj(this.srQ.mState)) {
            x.i("MicroMsg.Voip.VoipMgr", "hangupVoipButton OnClick call cancelCall");
            n nVar = d.bGT().ssY;
            x.i("MicroMsg.Voip.VoipServiceEx", "cancelCall, roomId:" + nVar.soQ.sqj.nJe);
            if (nVar.soQ.sqj.nJe == 0 && nVar.soQ.sqj.nJh == 0) {
                nVar.reset();
            } else {
                nVar.soQ.sqj.svN.sqW = nVar.soQ.bGY();
                nVar.soQ.sqj.svN.srj = 3;
                if (nVar.soQ.mStatus < 6) {
                    nVar.soQ.sqj.svN.srl = 1;
                }
                g gVar = g.pWK;
                Object[] objArr = new Object[6];
                objArr[0] = Integer.valueOf(d.bGT().ssY.soQ.sqj.nJe);
                objArr[1] = Long.valueOf(d.bGT().bIa());
                objArr[2] = Long.valueOf(d.bGT().bIb());
                objArr[3] = Integer.valueOf(nVar.soQ.mStatus == 5 ? 2 : 1);
                objArr[4] = Long.valueOf(System.currentTimeMillis());
                objArr[5] = Long.valueOf(System.currentTimeMillis());
                gVar.a(11521, true, true, objArr);
                nVar.bIn();
            }
        }
        x.i("MicroMsg.Voip.VoipMgr", "hangupVoipButton OnClick call hangUp");
        d.bGT().bHY();
        if (Downloads.RECV_BUFFER_SIZE == this.ssc) {
            ld(i);
            bHF();
        }
    }

    public final boolean bHC() {
        if (d.bGT().ssY.soQ.sqj.nJe != 0) {
            return bHD();
        }
        this.ssd = true;
        return true;
    }

    private boolean bHD() {
        int i = 4;
        int i2 = 0;
        if (!this.srQ.zm(4101)) {
            return false;
        }
        Object[] objArr;
        g gVar;
        int i3;
        Object[] objArr2;
        int i4;
        Object[] objArr3;
        ld(4101);
        Object[] objArr4;
        if (261 == this.srQ.mState || 7 == this.srQ.mState) {
            d.bGT().yN(1);
            g gVar2 = g.pWK;
            Object[] objArr5 = new Object[5];
            objArr5[0] = Integer.valueOf(2);
            objArr5[1] = Long.valueOf(d.bGT().bIa());
            objArr5[2] = Integer.valueOf(d.bGT().ssY.soQ.sqj.nJe);
            objArr5[3] = Integer.valueOf(0);
            objArr5[4] = Integer.valueOf(this.srZ ? 1 : 0);
            gVar2.h(11046, objArr5);
            gVar2 = g.pWK;
            objArr = new Object[3];
            objArr[0] = Integer.valueOf(2);
            objArr[1] = Integer.valueOf(0);
            gVar = gVar2;
            i3 = 11080;
            objArr2 = objArr;
            objArr4 = objArr;
            i4 = 2;
            objArr3 = objArr4;
        } else {
            if (1 == this.srQ.mState || 3 == this.srQ.mState) {
                d.bGT().yN(1);
                gVar = g.pWK;
                i3 = 11046;
                objArr = new Object[5];
                objArr[0] = Integer.valueOf(1);
                objArr[1] = Long.valueOf(d.bGT().bIa());
                objArr[2] = Integer.valueOf(d.bGT().ssY.soQ.sqj.nJe);
                objArr[3] = Integer.valueOf(0);
                if (this.srZ) {
                    i2 = 1;
                    objArr3 = objArr;
                    objArr[i] = Integer.valueOf(i2);
                    gVar.h(i3, objArr3);
                } else {
                    objArr3 = objArr;
                    objArr4 = objArr;
                    i4 = 4;
                    objArr2 = objArr4;
                }
            }
            d.bGT().bIc();
            d.bGT().bId();
            return true;
        }
        int i5 = i4;
        objArr = objArr2;
        i = i5;
        objArr[i] = Integer.valueOf(i2);
        gVar.h(i3, objArr3);
        d.bGT().bIc();
        d.bGT().bId();
        return true;
    }

    public final void bHE() {
        x.i("MicroMsg.Voip.VoipMgr", "onRoomReady");
        if (this.ssd && d.bGT().ssY.soQ.sqj.nJe != 0) {
            this.ssd = false;
            bHD();
        }
        if (this.srZ) {
            ld(4097);
        }
    }

    private void ld(final int i) {
        x.j("MicroMsg.Voip.VoipMgr", "swtchState, action: %s, currentState: %s", com.tencent.mm.plugin.voip.b.b.zg(i), com.tencent.mm.plugin.voip.b.b.zg(this.srQ.mState));
        if (4101 == i && com.tencent.mm.plugin.voip.b.b.zk(this.srQ.mState)) {
            bHM();
        }
        boolean z = 4111 == i ? true : 4101 == i && (com.tencent.mm.plugin.voip.b.b.zj(this.srQ.mState) || this.srZ);
        if (z && 1 == this.mUIType && 1 == this.sse) {
            this.ssv = true;
            jk(false);
            yS(2);
        }
        com.tencent.mm.plugin.voip.b.c cVar = this.srQ;
        if (cVar.zm(i)) {
            x.d("MicroMsg.Voip.VoipStateMachine", "from oldState: %s to newState: %s, action: %s", com.tencent.mm.plugin.voip.b.b.zg(cVar.mState), com.tencent.mm.plugin.voip.b.b.zg(((Integer) ((Map) cVar.syK.get(Integer.valueOf(cVar.mState))).get(Integer.valueOf(i))).intValue()), com.tencent.mm.plugin.voip.b.b.zg(i));
            cVar.mState = r0;
        } else {
            x.e("MicroMsg.Voip.VoipStateMachine", "can't tranform due to no such rule");
        }
        this.jQE.post(new Runnable() {
            public final void run() {
                if (j.this.srS != null) {
                    j.this.srS.dU(i, j.this.srQ.mState);
                }
            }
        });
        if (6 == this.srQ.mState || GameJsApiLaunchApplication.CTRL_BYTE == this.srQ.mState) {
            aGS();
        }
        switch (this.srQ.mState) {
            case 258:
            case 259:
                yU(5);
                return;
            case 262:
                yU(6);
                return;
            default:
                return;
        }
    }

    private static void yU(int i) {
        com.tencent.mm.sdk.b.b toVar = new to();
        toVar.fMW.fql = i;
        com.tencent.mm.sdk.b.a.xmy.m(toVar);
    }

    public final void onError(int i, String str) {
        if (this.ssa) {
            d.bGT().dS(R.k.dAw, 0);
        } else {
            d.bGT().dS(R.k.dAw, 1);
        }
        if (i == GameJsApiGetGameCommInfo.CTRL_BYTE && bi.oN(str)) {
            str = getContext().getString(R.l.eVW);
        }
        if (this.srS != null) {
            this.srS.aP(i, str);
        }
        ld(4109);
        x.i("MicroMsg.Voip.VoipMgr", "onError, errCode: %s, roomId: %s", Integer.valueOf(i), Integer.valueOf(d.bGT().ssY.soQ.sqj.nJe));
        Context context = ad.getContext();
        x.d("MicroMsg.Voip.VoipMgr", "getErrorMsgContent, errorCode" + i);
        String string = i == 235 ? context.getString(R.l.eUG) : i == 233 ? context.getString(R.l.eUz) : i == bd.CTRL_BYTE ? context.getString(R.l.eUG) : i == JsApiGetSetting.CTRL_INDEX ? context.getString(R.l.eUz) : i == h.CTRL_INDEX ? context.getString(R.l.eUF) : context.getString(R.l.eUy);
        String str2;
        String str3;
        int i2;
        if (d.bGT().ssY.soQ.sqj.nJe != 0 && d.bGT().std.get(Integer.valueOf(d.bGT().ssY.soQ.sqj.nJe)) == null) {
            str2 = this.srY.field_username;
            str3 = this.ssa ? au.xHC : au.xHB;
            i2 = this.srZ ? 1 : 0;
            if (com.tencent.mm.plugin.voip.b.b.zj(this.srQ.mState)) {
                string = ad.getContext().getString(R.l.eUC, new Object[]{bq(bi.bz(this.ssf))});
            }
            d.bGT().std.put(Integer.valueOf(d.bGT().ssY.soQ.sqj.nJe), Long.valueOf(l.a(str2, str3, i2, 6, string, true)));
        } else if (d.bGT().ssY.soQ.sqj.nJe == 0) {
            str2 = this.srY.field_username;
            str3 = this.ssa ? au.xHC : au.xHB;
            i2 = this.srZ ? 1 : 0;
            if (com.tencent.mm.plugin.voip.b.b.zj(this.srQ.mState)) {
                string = ad.getContext().getString(R.l.eUC, new Object[]{bq(bi.bz(this.ssf))});
            }
            l.a(str2, str3, i2, 6, string, true);
        }
        d.bGT().bIj();
        bHF();
    }

    public final void aTy() {
        x.i("MicroMsg.Voip.VoipMgr", "on accept");
        d.bGT().stopRing();
        ld(4100);
    }

    public final void onReject() {
        x.i("MicroMsg.Voip.VoipMgr", "onReject");
        ld(4099);
        l.a(this.srY.field_username, this.ssa ? au.xHC : au.xHB, this.srZ ? 1 : 0, 6, ad.getContext().getString(R.l.eUI));
        bHF();
    }

    private void bHF() {
        x.d("MicroMsg.Voip.VoipMgr", "delayFinish");
        this.ssw = null;
        this.jQE.postDelayed(new Runnable() {
            public final void run() {
                j.this.fD(false);
            }
        }, 2000);
    }

    public final void fD(boolean z) {
        m bGT;
        x.i("MicroMsg.Voip.VoipMgr", "finish");
        this.sss = false;
        this.ssu = false;
        if (this.ssk != -1) {
            g.pWK.h(11700, Integer.valueOf(this.ssk), Long.valueOf(bi.bz(this.ssf)));
            this.ssk = -1;
        }
        try {
            ad.getContext().unregisterReceiver(this.ssx);
        } catch (Exception e) {
        }
        com.tencent.mm.sdk.b.a.xmy.c(this.nHK);
        com.tencent.mm.sdk.b.a.xmy.c(this.ssz);
        if (this.srS != null) {
            this.srS.uninit();
            this.srS = null;
        }
        this.srU = null;
        as.Hn().b((com.tencent.mm.compatible.b.f.a) this);
        as.Hn().xQ();
        if (d.bGT() != null) {
            d.bGT().stopRing();
            if (z) {
                d.bGT().ssY.bIq();
            } else {
                d.bGT().bHY();
            }
            if (this.ssa) {
                d.bGT().a(false, true, this.gBJ);
            } else {
                d.bGT().a(false, false, this.gBJ);
            }
            bGT = d.bGT();
            Context context = ad.getContext();
            n nVar = bGT.ssY;
            if (context == nVar.soQ.kgx && this == nVar.soQ.sqk) {
                nVar.soQ.kgx = null;
                nVar.soQ.sqk = p.stL;
                com.tencent.mm.plugin.voip.b.a.eB("MicroMsg.Voip.VoipServiceEx", "detach ui........");
                com.tencent.mm.plugin.voip.b.a.bIV();
            } else {
                com.tencent.mm.plugin.voip.b.a.eB("MicroMsg.Voip.VoipServiceEx", "cannot detach other's ui.");
            }
        }
        bGT = d.bGT();
        bGT.ssZ = null;
        bGT.sth = null;
        bGT.sti = false;
        if (this.srW) {
            this.srV = new a();
            e.post(this.srV, "VoipMgr_clean");
        } else {
            bHL();
        }
        if (!(this.nHI == null || this.nHJ == null)) {
            this.nHI.listen(this.nHJ, 0);
            this.nHJ = null;
        }
        if (this.srR != null) {
            this.srR.dB(ad.getContext());
        }
        this.nHI = null;
        as.uy().wH();
        k.bHR().bHT();
        k.bHR().ssN = null;
        as.getNotification().cancel(40);
    }

    public final void bHG() {
        x.i("MicroMsg.Voip.VoipMgr", "onNoResp");
        ld(4105);
        l.a(this.srY.field_username, this.ssa ? au.xHC : au.xHB, this.srZ ? 1 : 0, 4, ad.getContext().getString(R.l.eUH));
        g.pWK.a(11518, true, true, Integer.valueOf(d.bGT().ssY.soQ.sqj.nJe), Long.valueOf(d.bGT().bIa()), Long.valueOf(d.bGT().bIb()), Integer.valueOf(6), Integer.valueOf(ao.getNetWorkType(getContext())));
        bHF();
    }

    public final void onConnected() {
        ld(4102);
        this.ssf = bi.Wx();
        if (this.srS != null) {
            this.srS.ff(this.ssf);
        }
        boolean bHc = d.bGT().ssY.soQ.bHc();
        boolean bHb = d.bGT().ssY.soQ.bHb();
        if (this.ssa && this.srZ && !bHb && !bHc) {
            d.bGT().yN(1);
        }
        if (!com.tencent.mm.plugin.voip.b.b.zk(this.srQ.mState)) {
            g.pWK.h(11080, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0));
        }
        n nVar = d.bGT().ssY;
        if (nVar.str != null) {
            com.tencent.mm.plugin.voip.video.h hVar = nVar.str;
            bi.m(hVar.mContext, hVar.mContext.getSharedPreferences(ad.cgf(), 0).getBoolean("settings_shake", true));
        }
        m bGT = d.bGT();
        int i = d.bGT().ssY.soQ.sqj.sut;
        n nVar2 = bGT.ssY;
        nVar2.bni = null;
        nVar2.sty = null;
        nVar2.stw = 0;
        if (i > 0) {
            n.stu = i;
        }
        nVar2.bni = (WifiManager) ad.getContext().getApplicationContext().getSystemService("wifi");
        nVar2.stx = new Timer();
        nVar2.stx.schedule(new TimerTask() {
            public final void run() {
                int i = 10;
                if (n.this.bni != null) {
                    n.this.sty = n.this.bni.getConnectionInfo();
                }
                if (n.this.sty == null || n.this.sty.getBSSID() == null || n.this.bni == null) {
                    n.kGi = -1;
                } else {
                    n.kGi = WifiManager.calculateSignalLevel(n.this.sty.getRssi(), 10);
                    if (n.kGi <= 10) {
                        i = n.kGi;
                    }
                    n.kGi = i;
                    n.kGi = n.kGi < 0 ? 0 : n.kGi;
                    n.kGi = n.kGi * 10;
                }
                if (n.kGi == -1) {
                    if (n.this.stw <= 1) {
                        n.stt = -1;
                    }
                    n.this.setNetSignalValue(1, n.stt);
                    return;
                }
                n.this.setNetSignalValue(2, n.kGi);
            }
        }, 0, (long) (n.stu * 1000));
        TelephonyManager telephonyManager = (TelephonyManager) ad.getContext().getSystemService("phone");
        if (telephonyManager != null) {
            telephonyManager.listen(new com.tencent.mm.plugin.voip.model.n.AnonymousClass5(telephonyManager), 256);
        }
        k.bHR().bHS();
        k.bHR().ssN = this;
    }

    public final void bHH() {
        int i = 0;
        g gVar = g.pWK;
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(d.bGT().ssY.soQ.sqj.nJe);
        objArr[1] = Long.valueOf(d.bGT().bIa());
        objArr[2] = Long.valueOf(d.bGT().bIb());
        if (!this.srZ) {
            i = 1;
        }
        objArr[3] = Integer.valueOf(i);
        objArr[4] = Integer.valueOf(1);
        gVar.a(11522, true, true, objArr);
    }

    public final void bHI() {
        String string;
        x.i("MicroMsg.Voip.VoipMgr", "onShutDown");
        if (com.tencent.mm.plugin.voip.b.b.zj(this.srQ.mState)) {
            string = ad.getContext().getString(R.l.eUB, new Object[]{bq(bi.bz(this.ssf))});
        } else {
            string = ad.getContext().getString(R.l.eUy);
        }
        if (this.srZ || com.tencent.mm.plugin.voip.b.b.zj(this.srQ.mState)) {
            l.a(this.srY.field_username, this.ssa ? au.xHC : au.xHB, 0, 6, string);
        }
        if (this.ssa) {
            d.bGT().dS(R.k.dAw, 0);
        } else {
            d.bGT().dS(R.k.dAw, 1);
        }
        if (bHN()) {
            this.ssc = 4106;
        } else {
            ld(4106);
            bHF();
        }
        d.bGT().bIj();
    }

    public final void yV(int i) {
        x.i("MicroMsg.Voip.VoipMgr", "remote voip mode changed, cmd:%d", Integer.valueOf(i));
        if (1 == i || 3 == i || 5 == i || 6 == i || 7 == i) {
            ld(4101);
            d.bGT().bIc();
            d.bGT().bId();
        }
    }

    public final void a(int i, int i2, int i3, int[] iArr) {
        if (this.srS != null) {
            this.srS.b(i, i2, iArr);
        }
    }

    public final void bHJ() {
        if (this.srS != null) {
            this.srS.bHJ();
        }
    }

    public final void yW(int i) {
        boolean z = false;
        x.i("MicroMsg.Voip.VoipMgr", "onSessionBeingCalled, callType: " + i);
        if (this.srQ.zm(4110)) {
            m bGT = d.bGT();
            boolean z2 = i == 1;
            if (i == 1) {
                z = true;
            }
            bGT.C(z2, z);
            d.bGT().stopRing();
            if (i == 1 && com.tencent.mm.plugin.voip.b.b.zk(this.srQ.mState)) {
                ld(4101);
            }
            ld(4110);
        }
    }

    public final void bHK() {
        boolean z = false;
        x.d("MicroMsg.Voip.VoipMgr", "onPretreatmentForStartDev");
        if (as.Hn().xY() || as.Hn().xS()) {
            jk(false);
            return;
        }
        boolean z2 = 1 == this.sse;
        if (!this.ssv) {
            if (this.ssa) {
                z = true;
            } else {
                z = z2;
            }
        }
        jk(z);
    }

    private static String bq(long j) {
        return String.format("%02d:%02d", new Object[]{Long.valueOf(j / 60), Long.valueOf(j % 60)});
    }

    public final void c(byte[] bArr, long j, int i, int i2, int i3) {
        if (!this.ssj) {
            int i4;
            int i5 = this.srT.bJi() ? OpenGlRender.sAp : 0;
            int i6 = this.srT.bJj() ? OpenGlRender.sAo : OpenGlRender.sAn;
            int i7 = (int) j;
            g gVar = d.bGT().ssY.soQ.sql;
            if (gVar.sqF != 2) {
                i4 = 0;
            } else if (gVar.soQ.bHf()) {
                v2protocal v2protocal = gVar.soQ.sqj;
                v2protocal.svv++;
                i4 = gVar.soQ.sqj.videoEncodeToSend(bArr, i7, i, i2, i3);
            } else {
                i4 = 0;
            }
            if (this.srS != null) {
                this.srS.a(bArr, j, i, i2, i3, i5, i6, i4);
            }
            this.ssp = i5 == OpenGlRender.sAp;
            this.ssq = i6 == OpenGlRender.sAo ? 270 : 90;
            com.tencent.mm.plugin.voip.video.j jVar = this.ssl;
            jVar.sBf = i2;
            jVar.sBe = i;
        }
    }

    private void bHL() {
        synchronized (this.srX) {
            d.bGT().stopRing();
            bHM();
            as.Hn().setMode(0);
            if (this.flO != null) {
                this.flO.zk();
            }
        }
    }

    private void bHM() {
        x.j("MicroMsg.Voip.VoipMgr", "uninitCaptureRender", new Object[0]);
        if (this.srT != null) {
            if (this.ssl != null) {
                com.tencent.mm.plugin.voip.video.j jVar = this.ssl;
                if (jVar.kCL.contains(this)) {
                    jVar.kCL.remove(this);
                }
            }
            if (this.ssm != null) {
                x.d("MicroMsg.Voip.VoipMgr", "stop face detect timer");
                this.ssm.TN();
            }
            if (this.ssn != null) {
                x.d("MicroMsg.Voip.VoipMgr", "quit face detect thread");
                this.ssn.oFY.getLooper().quit();
            }
            try {
                this.srT.bJg();
                com.tencent.mm.plugin.voip.video.a.bJh();
            } catch (Exception e) {
                x.d("MicroMsg.Voip.VoipMgr", "stop capture error:" + e.toString());
            }
            this.srT = null;
        }
    }

    public final void aTD() {
        x.i("MicroMsg.Voip.VoipMgr", "onBadNetStatus");
        if (this.srS != null) {
            this.srS.bIL();
        }
        if (!com.tencent.mm.plugin.voip.b.b.zk(this.srQ.mState) && !this.ssi) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.nKa > 30000) {
                this.nKa = currentTimeMillis;
                d.bGT().yZ(R.k.dBL);
            }
        }
    }

    public final void aTE() {
        x.i("MicroMsg.Voip.VoipMgr", "onResumeGoodNetStatus");
        if (this.srS != null) {
            this.srS.aVo();
        }
    }

    private boolean bHN() {
        if (!com.tencent.mm.plugin.voip.b.b.zj(this.srQ.mState)) {
            return false;
        }
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("voip_plugin_prefs", 0);
        if (sharedPreferences.getBoolean("voip_shortcut_has_added", false)) {
            return false;
        }
        String value = com.tencent.mm.j.g.Af().getValue("VOIPShortcutAutoadd");
        x.i("MicroMsg.Voip.VoipMgr", "voip shortcut autoAdd is %s", value);
        if (value != null && value.equals("0") && bi.bz(this.ssf) > 30) {
            int i = sharedPreferences.getInt("voip_shortcut_prompt_times", 0);
            boolean z = sharedPreferences.getBoolean("voip_shortcut_never_show_anymore", false);
            if (i >= 3 || z) {
                return false;
            }
            Context context = getContext();
            View inflate = View.inflate(context, R.i.dns, null);
            final CheckBox checkBox = (CheckBox) inflate.findViewById(R.h.cwh);
            checkBox.setChecked(false);
            TextView textView = (TextView) inflate.findViewById(R.h.cwj);
            if (1 == bi.getInt(com.tencent.mm.j.g.Af().getValue("VOIPCallType"), 0)) {
                textView.setText(R.l.eUp);
            } else {
                textView.setText(R.l.eUq);
            }
            com.tencent.mm.ui.base.h.a(context, false, context.getString(R.l.dGZ), inflate, context.getString(R.l.dHo), context.getString(R.l.dGc), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    j.this.c(j.this.getContext().getSharedPreferences("voip_plugin_prefs", 0));
                    if (Downloads.RECV_BUFFER_SIZE != j.this.ssc) {
                        j.this.ld(j.this.ssc);
                        j.this.ssc = Downloads.RECV_BUFFER_SIZE;
                    }
                    j.this.jQE.post(new Runnable() {
                        public final void run() {
                            j.this.fD(false);
                        }
                    });
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (checkBox != null) {
                        j.this.getContext().getSharedPreferences("voip_plugin_prefs", 0).edit().putBoolean("voip_shortcut_never_show_anymore", checkBox.isChecked()).commit();
                    }
                    if (Downloads.RECV_BUFFER_SIZE != j.this.ssc) {
                        j.this.ld(j.this.ssc);
                        j.this.ssc = Downloads.RECV_BUFFER_SIZE;
                    }
                    j.this.jQE.post(new Runnable() {
                        public final void run() {
                            j.this.fD(false);
                        }
                    });
                }
            });
            sharedPreferences.edit().putInt("voip_shortcut_prompt_times", i + 1).commit();
            return true;
        } else if (value == null || !value.equals("1") || bi.bz(this.ssf) <= 15) {
            return false;
        } else {
            c(sharedPreferences);
            return false;
        }
    }

    private void c(SharedPreferences sharedPreferences) {
        Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        intent.putExtra("duplicate", false);
        Object intent2 = new Intent("com.tencent.mm.action.BIZSHORTCUT");
        intent2.addFlags(67108864);
        if (1 == bi.getInt(com.tencent.mm.j.g.Af().getValue("VOIPCallType"), 0)) {
            intent2.putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip");
            intent.putExtra("android.intent.extra.shortcut.NAME", getContext().getString(R.l.dFr));
            intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", ShortcutIconResource.fromContext(getContext(), R.g.bHH));
            intent.putExtra("shortcut_icon_resource_id", R.g.bHH);
        } else {
            intent2.putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip_audio");
            intent.putExtra("android.intent.extra.shortcut.NAME", getContext().getString(R.l.dFs));
            intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", ShortcutIconResource.fromContext(getContext(), R.g.bHP));
            intent.putExtra("shortcut_icon_resource_id", R.g.bHP);
        }
        intent.putExtra("android.intent.extra.shortcut.INTENT", intent2);
        com.tencent.mm.plugin.base.model.b.o(getContext(), intent);
        sharedPreferences.edit().putBoolean("voip_shortcut_has_added", true).commit();
    }

    private Context getContext() {
        Context context = null;
        if (this.srS != null) {
            context = this.srS.bIK();
        }
        if (context == null) {
            return ad.getContext();
        }
        return context;
    }

    public final boolean jm(final boolean z) {
        if (!this.ssu || z) {
            x.j("MicroMsg.Voip.VoipMgr", "miniOnlyHidenVoip: %b", Boolean.valueOf(z));
            x.i("MicroMsg.Voip.VoipMgr", "onMinimizeVoip, async to minimize");
            if (this.srS != null) {
                this.srS.uninit();
                this.srS = null;
            }
            this.jQE.post(new Runnable() {
                public final void run() {
                    j.e(j.this, z);
                }
            });
            return true;
        }
        x.i("MicroMsg.Voip.VoipMgr", "has phone call  cannot mini!");
        return false;
    }

    public final void bHO() {
        if (256 == this.srQ.mState || 257 == this.srQ.mState) {
            as.Hm();
            if (com.tencent.mm.y.c.Db().getInt(327945, 0) != 0 || this.srS.bIK() == null) {
                d.M(ad.getContext(), R.l.eVG);
                bHQ();
                return;
            }
            as.Hm();
            com.tencent.mm.y.c.Db().setInt(327945, 1);
            i a = com.tencent.mm.ui.base.h.a(this.srS.bIK(), R.l.eVG, R.l.dGZ, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    j.this.bHQ();
                }
            });
            a.setCancelable(false);
            a.setCanceledOnTouchOutside(false);
            a.show();
        }
    }

    public final void bHP() {
        this.sso = !this.sso;
        if (this.sso) {
            this.ssm.TN();
        } else {
            aGS();
        }
    }

    public final void bHQ() {
        d.bGT().ste = d.bGT().ssY.soQ.sqj.nJe;
        l.a(this.srY.field_username, this.ssa ? au.xHC : au.xHB, this.srZ ? 1 : 0, 6, ad.getContext().getString(R.l.eUD));
        d.bGT().stopRing();
        ld(4108);
        this.jQE.postDelayed(new Runnable() {
            public final void run() {
                j.this.fD(true);
            }
        }, 2000);
    }

    public final void bdJ() {
        if (true == this.oyb || this.srS == null || this.srS.bIK() == null) {
            x.d("MicroMsg.Voip.VoipMgr", "onCameraError, already show");
        } else if (!Build.MANUFACTURER.equalsIgnoreCase("meizu") || com.tencent.mm.compatible.f.b.zh()) {
            int i;
            x.d("MicroMsg.Voip.VoipMgr", "onCameraError, show dialog");
            g gVar = g.pWK;
            Object[] objArr = new Object[2];
            if (this.ssa) {
                i = 0;
            } else {
                i = 1;
            }
            objArr[0] = Integer.valueOf(i);
            objArr[1] = Integer.valueOf(0);
            gVar.h(11306, objArr);
            i h = com.tencent.mm.ui.base.h.h(this.srS.bIK(), R.l.eVQ, R.l.dGZ);
            if (h == null) {
                x.e("MicroMsg.Voip.VoipMgr", "new dialog failed");
                return;
            }
            h.setCancelable(false);
            h.setCanceledOnTouchOutside(false);
            h.show();
            this.oyb = true;
        } else {
            x.d("MicroMsg.Voip.VoipMgr", "onCameraError, meizu machine");
        }
    }

    private void aGS() {
        if (this.ssm == null) {
            this.ssn = new ah("faceDetect");
            this.ssm = new al(this.ssn.oFY.getLooper(), new com.tencent.mm.sdk.platformtools.al.a() {
                public final boolean uG() {
                    j.w(j.this);
                    return true;
                }
            }, true);
        }
        this.ssm.K(2000, 2000);
        this.sso = false;
    }

    public final void a(final int[] iArr, final boolean z, final int i) {
        ah.y(new Runnable() {
            public final void run() {
                if (j.this.srT != null) {
                    j.this.srT.l(iArr);
                }
                if (j.this.srS != null) {
                    j.this.srS;
                }
            }
        });
    }
}
