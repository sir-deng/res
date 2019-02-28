package com.tencent.wecall.talkroom.model;

import android.app.Activity;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.bio.face.JsApiCheckIsSupportFaceDetect;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.jsapi.share.h;
import com.tencent.mm.plugin.appbrand.jsapi.share.i;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.multi.talk;
import com.tencent.pb.common.b.a.a.aa;
import com.tencent.pb.common.b.a.a.ab;
import com.tencent.pb.common.b.a.a.ac;
import com.tencent.pb.common.b.a.a.af;
import com.tencent.pb.common.b.a.a.ah;
import com.tencent.pb.common.b.a.a.aj;
import com.tencent.pb.common.b.a.a.ak;
import com.tencent.pb.common.b.a.a.as;
import com.tencent.pb.common.b.a.a.at;
import com.tencent.pb.common.b.a.a.au;
import com.tencent.pb.common.b.a.a.av;
import com.tencent.pb.common.b.a.a.aw;
import com.tencent.pb.common.b.a.a.ay;
import com.tencent.pb.common.b.a.a.o;
import com.tencent.pb.common.b.a.a.q;
import com.tencent.pb.common.b.a.a.r;
import com.tencent.pb.common.b.a.a.x;
import com.tencent.pb.common.b.a.a.z;
import com.tencent.pb.common.c.g;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.wcdb.FileUtils;
import com.tencent.wecall.talkroom.a.j;
import com.tencent.wecall.talkroom.a.k;
import com.tencent.wecall.talkroom.a.l;
import com.tencent.wecall.talkroom.a.m;
import com.tencent.wecall.talkroom.model.g.AnonymousClass11;
import com.tencent.wecall.talkroom.model.g.AnonymousClass15;
import com.tencent.wecall.talkroom.model.g.AnonymousClass17;
import com.tencent.wecall.talkroom.model.g.AnonymousClass20;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public final class f implements Callback, com.tencent.e.a.d, com.tencent.pb.common.b.b {
    private static int AwF = 30000;
    public static List<Integer> Awy = new ArrayList();
    public static String[] Axc = new String[]{"GLOBAL_TOPIC_NETWORK_CHANGE", "topic_bind_mobile_other"};
    private static com.tencent.pb.talkroom.sdk.e zVE = null;
    private final int AwA = 1;
    private final int AwB = 2;
    private final int AwC = 3;
    private final int AwD = 4;
    public final int AwE = 6;
    private boolean AwG = false;
    private boolean AwH = false;
    public String AwI;
    public long AwJ;
    private int AwK = 0;
    private int AwL = 0;
    private int AwM = 0;
    private long AwN = 0;
    private boolean AwO = true;
    private int AwP = 0;
    int AwQ = -1;
    public h AwR = h.Ayc;
    b AwS;
    private com.tencent.mm.plugin.multi.talk.a AwT;
    private TimerTask AwU;
    private TimerTask AwV;
    private Timer AwW = new Timer("TalkRoomService_HelloTimer");
    private TimerTask AwX;
    private Timer AwY = new Timer("TalkRoomService_talkDurationTimer");
    g AwZ = new g();
    private com.tencent.e.a.a Awa;
    f Awx;
    private Map<String, e> Awz = new HashMap();
    private int Axa = 0;
    private boolean Axb = false;
    public String Axd = null;
    HashSet<Long> Axe = new HashSet();
    public boolean Axf = false;
    public boolean Axg = true;
    public boolean Axh = true;
    private short[] Axi = null;
    private int[] Axj = null;
    private short[] Axk = null;
    private int[] Axl = null;
    private int Axm = 0;
    public boolean Axn = false;
    public boolean Axo = true;
    private Runnable Axp = new Runnable() {
        public final void run() {
            if (f.this.bHa() && f.this.nZr) {
                com.tencent.pb.common.c.c.d("TalkRoomService", "syscall", "finishtalk becos holdtimeout");
                h.Jw(-2003);
                f.this.AwR.Jz(401);
                f.this.ak(f.this.nqU, 3, 108);
            }
        }
    };
    private com.tencent.pb.common.b.d Axq = null;
    private Runnable Axr = new Runnable() {
        public final void run() {
            com.tencent.pb.common.b.d dVar = null;
            String str = "TalkRoomService";
            Object[] objArr = new Object[6];
            objArr[0] = "beginSenceCircle state: ";
            objArr[1] = Integer.valueOf(f.this.state);
            objArr[2] = " mCircleScene: ";
            objArr[3] = f.this.Axq == null ? null : Integer.valueOf(f.this.Axq.getType());
            objArr[4] = " mIsAck: ";
            objArr[5] = Boolean.valueOf(f.this.AwG);
            com.tencent.pb.common.c.c.d(str, objArr);
            if (f.this.Axq == null) {
                f.this.mHandler.removeCallbacks(f.this.Axr);
                com.tencent.pb.common.c.c.m("TalkRoomService", "beginSenceCircle removeCallbacks");
            } else if (f.this.bHa()) {
                if (f.this.Axq != null && f.this.Axq.getType() == 202 && f.this.state == 3) {
                    com.tencent.wecall.talkroom.a.e eVar = (com.tencent.wecall.talkroom.a.e) f.this.Axq;
                    if (f.this.b(eVar.nqU, eVar.nPD, eVar.AwJ, f.Jt(eVar.AyE))) {
                        dVar = new com.tencent.wecall.talkroom.a.e(eVar);
                        com.tencent.pb.common.c.c.m("TalkRoomService", "beginSenceCircle enter");
                    }
                }
                if (dVar != null) {
                    com.tencent.pb.common.b.e.cDx().a(dVar);
                    return;
                }
                f.this.mHandler.removeCallbacks(f.this.Axr);
                com.tencent.pb.common.c.c.m("TalkRoomService", "beginSenceCircle removeCallbacks");
            } else {
                f.this.mHandler.removeCallbacks(f.this.Axr);
                com.tencent.pb.common.c.c.m("TalkRoomService", "beginSenceCircle removeCallbacks");
            }
        }
    };
    Handler mHandler;
    boolean mIsMute = false;
    public int nPD;
    boolean nZr = false;
    public String nqU;
    boolean srZ = false;
    int state = 0;
    int zVs;

    class e {
        String groupId;
        int nJe;
        long nJf;

        e() {
        }
    }

    public interface f {
    }

    public enum b {
        OK,
        NOT_AUTH,
        NOT_BIND,
        NOT_MATCH,
        NO_NETWORK,
        BUSY,
        NOT_VALID_STATE,
        GROUP_NOT_VALID,
        UNINIT_SERVICE_FAILED,
        INIT_ENGINE_FAILED
    }

    class d {
        long AwJ;
        int nPD;
        String nqU;
    }

    class a {
        String[] AxE;
        ay AxF;
        long AxG;
        String AxH;
        boolean AxI;
        String AxJ;
        String groupId;
        int type;
        int zWd;

        a() {
        }
    }

    class c {
        String groupId;
        int nJe;
        long nJf;
        int zWd;
        int zWk;

        c() {
        }
    }

    static /* synthetic */ void a(f fVar, final m mVar) {
        if (fVar.AwV == null) {
            fVar.AwV = new TimerTask() {
                public final void run() {
                    if (mVar == null) {
                        com.tencent.pb.common.c.c.m("TalkRoomService", "doHelloTimeOutTask scene is null");
                    } else if (f.this.b(mVar.nqU, mVar.nPD, mVar.AwJ, false)) {
                        com.tencent.pb.common.c.c.m("TalkRoomService", "doHelloTimeOutTask mGroupId: ", f.this.nqU, " mRoomId: ", Integer.valueOf(f.this.nPD), " mRoomKey: ", Long.valueOf(f.this.AwJ));
                        f.this.AwR.Jz(330);
                        h.Jv(-1606);
                        f.this.a(mVar.nqU, mVar.nPD, mVar.AwJ, 117, true);
                        f.this.AwZ.g(-600, null);
                    } else {
                        com.tencent.pb.common.c.c.m("TalkRoomService", "doHelloTimeOutTask isCurrentRoom is false scene.mGroupId: ", mVar.nqU, " scene.mRoomId: ", Integer.valueOf(mVar.nPD), " scene.mRoomKey: ", Long.valueOf(mVar.AwJ));
                    }
                }
            };
            fVar.AwW.schedule(fVar.AwV, 120000);
        }
    }

    static /* synthetic */ void a(f fVar, int[] iArr) {
        if (iArr == null) {
            com.tencent.pb.common.c.c.m("TalkRoomService", "onMebersChangedToEngineByIds members is null");
            return;
        }
        String str = "TalkRoomService";
        Object[] objArr = new Object[2];
        objArr[0] = "engine onMebersChangedToEngineByIds members.length: ";
        objArr[1] = Integer.valueOf(iArr == null ? 0 : iArr.length);
        com.tencent.pb.common.c.c.m(str, objArr);
        if (fVar.AwS == null) {
            com.tencent.pb.common.c.c.m("TalkRoomService", "onMebersChangedToEngine engine is null");
        } else {
            fVar.AwS.OnMembersChanged(iArr);
        }
    }

    static /* synthetic */ void e(f fVar) {
        if (fVar.AwS == null) {
            com.tencent.pb.common.c.c.e("TalkRoomService", "the engine should not be null.");
            return;
        }
        com.tencent.pb.common.c.c.d("TalkRoomService", "initMediaComponent");
        com.tencent.pb.common.c.f.w(411, 1, "1");
        fVar.cIQ();
        fVar.aUx();
    }

    static /* synthetic */ m j(f fVar) {
        if (TextUtils.isEmpty(fVar.nqU)) {
            com.tencent.pb.common.c.c.m("TalkRoomService", "doHelloVoiceRoom mGroupId is null");
            return null;
        }
        com.tencent.pb.common.c.c.m("TalkRoomService", "doHelloVoiceRoom mGroupId: ", fVar.nqU, " mRoomId: ", Integer.valueOf(fVar.nPD), " mRoomKey: ", Long.valueOf(fVar.AwJ), " selfMemberId: ", Integer.valueOf(c.cIA().acF(fVar.nqU)), " mCallData: ", Integer.valueOf(fVar.AwP));
        com.tencent.pb.common.b.d mVar = new m(fVar.nqU, fVar.nPD, fVar.AwJ, r6, fVar.AwP);
        com.tencent.pb.common.b.e.cDx().a(mVar);
        return mVar;
    }

    public final boolean handleMessage(Message message) {
        Object obj;
        switch (message.what) {
            case 1:
                obj = message.obj;
                if (this.state != 4) {
                    if (!(obj instanceof d)) {
                        com.tencent.pb.common.c.c.m("TalkRoomService", "handlerInviteTimeOut obj is not GroupRoomInfo");
                        break;
                    }
                    d dVar = (d) obj;
                    if (dVar.nqU != null) {
                        com.tencent.pb.common.c.c.d("TalkRoomService", "handlerInviteTimeOut");
                        if (dVar.nqU.equals(this.nqU) && dVar.nPD == this.nPD && dVar.AwJ == this.AwJ) {
                            h.cIV();
                            this.AwR.Jz(HardCoderJNI.SCENE_DB);
                            b(dVar.nqU, dVar.nPD, dVar.AwJ, 7);
                            com.tencent.pb.common.c.c.m("TalkRoomService", "handlerInviteTimeOut groupRoomInfo.mGroupId: ", dVar.nqU);
                            break;
                        }
                    }
                    com.tencent.pb.common.c.c.m("TalkRoomService", "handlerInviteTimeOut groupRoomInfo.mGroupId is null");
                    break;
                }
                com.tencent.pb.common.c.c.m("TalkRoomService", "handlerInviteTimeOut state: ", Integer.valueOf(this.state));
                break;
            case 2:
                obj = message.obj;
                if (this.state == 1) {
                    if (!(obj instanceof a)) {
                        com.tencent.pb.common.c.c.m("TalkRoomService", "handlerCreateGroup obj is not CreateGroupObj");
                        break;
                    }
                    a aVar = (a) obj;
                    if (g.ga(aVar.groupId, this.nqU)) {
                        String str = aVar.groupId;
                        String[] strArr = aVar.AxE;
                        ay ayVar = aVar.AxF;
                        int i = aVar.zWd;
                        int i2 = aVar.type;
                        long j = aVar.AxG;
                        String str2 = aVar.AxH;
                        boolean z = aVar.AxI;
                        String str3 = aVar.AxJ;
                        this.AwR.cIU();
                        String str4 = "";
                        TalkRoom acE = c.cIA().acE(str);
                        if (acE != null) {
                            str4 = acE.Awi == null ? "" : acE.Awi.name;
                        }
                        boolean a = com.tencent.pb.common.b.e.cDx().a(new com.tencent.wecall.talkroom.a.d(str, strArr, this.AwS.cIy(), str4, ayVar, i, i2, j, str2, z, str3));
                        this.AwR.Q("create", "req", String.valueOf(a), String.valueOf(this.state));
                        com.tencent.pb.common.c.c.m("TalkRoomService", "sendCreateSence groupId: ", str, " routeId:", Integer.valueOf(i), " type: ", Integer.valueOf(i2), " playId: ", Long.valueOf(j), " name: ", str4, " ret: ", Boolean.valueOf(a));
                        break;
                    }
                }
                com.tencent.pb.common.c.c.m("TalkRoomService", "handlerCreateGroup state: ", Integer.valueOf(this.state));
                break;
                break;
            case 3:
                obj = message.obj;
                if (this.state == 3) {
                    if (!(obj instanceof c)) {
                        com.tencent.pb.common.c.c.m("TalkRoomService", "handlerCreateGroup obj is not CreateGroupObj");
                        break;
                    }
                    c cVar = (c) obj;
                    if (b(cVar.groupId, cVar.nJe, cVar.nJf, false)) {
                        b(cVar.groupId, cVar.nJe, cVar.nJf, cVar.zWd, cVar.zWk);
                        break;
                    }
                }
                com.tencent.pb.common.c.c.m("TalkRoomService", "handlerEnterGroup state: ", Integer.valueOf(this.state));
                break;
                break;
            case 4:
                com.tencent.pb.common.c.f.cDN();
                break;
        }
        return true;
    }

    public f() {
        com.tencent.pb.common.b.e.cDx().a(201, (com.tencent.pb.common.b.b) this);
        com.tencent.pb.common.b.e.cDx().a(202, (com.tencent.pb.common.b.b) this);
        com.tencent.pb.common.b.e.cDx().a(203, (com.tencent.pb.common.b.b) this);
        com.tencent.pb.common.b.e.cDx().a((int) com.tencent.mm.plugin.appbrand.jsapi.a.d.CTRL_INDEX, (com.tencent.pb.common.b.b) this);
        com.tencent.pb.common.b.e.cDx().a((int) com.tencent.mm.plugin.appbrand.jsapi.a.g.CTRL_INDEX, (com.tencent.pb.common.b.b) this);
        com.tencent.pb.common.b.e.cDx().a((int) com.tencent.mm.plugin.appbrand.jsapi.a.b.CTRL_INDEX, (com.tencent.pb.common.b.b) this);
        com.tencent.pb.common.b.e.cDx().a(207, (com.tencent.pb.common.b.b) this);
        com.tencent.pb.common.b.e.cDx().a((int) com.tencent.mm.plugin.appbrand.jsapi.a.f.CTRL_INDEX, (com.tencent.pb.common.b.b) this);
        com.tencent.pb.common.b.e.cDx().a((int) i.CTRL_INDEX, (com.tencent.pb.common.b.b) this);
        com.tencent.pb.common.b.e.cDx().a((int) com.tencent.mm.plugin.appbrand.jsapi.a.c.CTRL_INDEX, (com.tencent.pb.common.b.b) this);
        com.tencent.pb.common.b.e.cDx().a((int) h.CTRL_INDEX, (com.tencent.pb.common.b.b) this);
        com.tencent.pb.common.b.e.cDx().a((int) com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX, (com.tencent.pb.common.b.b) this);
        com.tencent.pb.common.b.e.cDx().a((int) com.tencent.mm.plugin.appbrand.jsapi.bio.face.c.CTRL_INDEX, (com.tencent.pb.common.b.b) this);
        com.tencent.pb.common.b.e.cDx().a((int) JsApiCheckIsSupportFaceDetect.CTRL_INDEX, (com.tencent.pb.common.b.b) this);
        com.tencent.pb.common.b.e.cDx().a(800, (com.tencent.pb.common.b.b) this);
        c cIA = c.cIA();
        g gVar = this.AwZ;
        try {
            new Throwable("trace caller").getStackTrace();
        } catch (Exception e) {
            com.tencent.pb.common.c.c.d("TalkRoomManager", "setTalkServerCallback caller stack: ", r2);
        }
        cIA.Awp = gVar;
        HandlerThread handlerThread = new HandlerThread("TalkRoomService");
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper(), this);
        if (this.Awa == null) {
            this.Awa = (com.tencent.e.a.a) com.tencent.e.f.acA("EventCenter");
        }
        com.tencent.pb.common.c.c.d("TalkRoomService", "syscall", "register", Boolean.valueOf(true));
        this.Awa.a(this, Axc);
    }

    final boolean cIJ() {
        com.tencent.pb.common.c.c.d("TalkRoomService", "initService");
        com.tencent.pb.talkroom.sdk.e eVar = zVE;
        if (eVar != null) {
            eVar.bcB();
        }
        this.AwS = new b();
        this.Axd = this.nqU;
        this.AwT = new com.tencent.mm.plugin.multi.talk.a() {
            public final void keep_OnOpenSuccess() {
                int[] iArr = null;
                f.this.AwR.nKB = 1;
                com.tencent.pb.common.c.c.d("TalkRoomService", "engine OnOpenSuccess");
                if (f.this.state != 4) {
                    com.tencent.pb.common.c.c.m("TalkRoomService", "has exit the talkroom state:%d", Integer.valueOf(f.this.state));
                    return;
                }
                f fVar = f.this;
                c cIA = c.cIA();
                Object b = f.this.nqU;
                if (!TextUtils.isEmpty(b)) {
                    TalkRoom acE = cIA.acE(b);
                    if (acE != null) {
                        List cIu = acE.cIu();
                        if (cIu != null) {
                            int[] iArr2 = new int[cIu.size()];
                            StringBuffer stringBuffer = new StringBuffer();
                            for (int i = 0; i < cIu.size(); i++) {
                                d dVar = (d) cIu.get(i);
                                if (dVar != null) {
                                    iArr2[i] = dVar.cID();
                                    stringBuffer.append(iArr2[i]);
                                    stringBuffer.append(",");
                                }
                            }
                            com.tencent.pb.common.c.c.m("TalkRoomManager", "getAllMemberIds memberIds: ", stringBuffer.toString());
                            iArr = iArr2;
                        }
                    }
                }
                f.a(fVar, iArr);
                if (f.this.AwS != null) {
                    b c = f.this.AwS;
                    boolean xX = f.xX();
                    if (com.tencent.pb.common.a.a.zUT) {
                        if (xX) {
                            c.Awk.tv(401);
                        } else {
                            c.Awk.tv(com.tencent.mm.plugin.appbrand.jsapi.a.e.CTRL_INDEX);
                        }
                    }
                }
                f.this.AwH = true;
                f.this.AwS;
                com.tencent.pb.talkroom.sdk.e cIR = f.cIR();
                if (cIR != null) {
                    cIR.bcC();
                }
                talk talk = f.this.AwS.Awk;
                if (com.tencent.pb.common.a.a.zUT) {
                    AtomicInteger atomicInteger = new AtomicInteger();
                    AtomicInteger atomicInteger2 = new AtomicInteger();
                    try {
                        talk.getSampleRate(atomicInteger, atomicInteger2);
                    } catch (Throwable th) {
                        com.tencent.pb.common.c.c.m("TalkRoomService", "keep_OnOpenSuccess:  ", th);
                        return;
                    }
                    int i2 = atomicInteger.get();
                    int i3 = atomicInteger2.get();
                    talk.oLp = i2;
                    talk.oLq = i3;
                    com.tencent.pb.common.c.c.m("VoipAdapterUtil", "adapterInitv2engineSampleRate getSampleRate:", Integer.valueOf(talk.oLp), Integer.valueOf(talk.oLq));
                }
                try {
                    f.e(f.this);
                } catch (Throwable th2) {
                    com.tencent.pb.common.c.c.m("TalkRoomService", "keep_OnOpenSuccess initMediaComponent:  ", th2);
                }
                h hVar = f.this.AwR;
                if (hVar.Ayr == 0) {
                    hVar.Ayg = 0;
                } else {
                    hVar.Ayg = System.currentTimeMillis() - hVar.Ayr;
                }
                com.tencent.pb.common.c.c.d(h.TAG, "endFirstSendPcm", Long.valueOf(hVar.Ayg), Long.valueOf(hVar.Ayr));
                g f = f.this.AwZ;
                Runnable anonymousClass3 = new Runnable() {
                    public final void run() {
                        synchronized (g.this.gzt) {
                            for (a aWH : g.this.gzt) {
                                aWH.aWH();
                            }
                        }
                    }
                };
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    anonymousClass3.run();
                } else {
                    f.handler.post(anonymousClass3);
                }
            }

            public final void keep_OnError(int i) {
                int i2 = 207;
                int i3 = -3007;
                int i4 = 103;
                switch (i) {
                    case -4:
                        i2 = com.tencent.mm.plugin.appbrand.jsapi.a.b.CTRL_INDEX;
                        i3 = -3006;
                        i4 = 115;
                        break;
                    case -3:
                        i2 = com.tencent.mm.plugin.appbrand.jsapi.a.g.CTRL_INDEX;
                        i3 = -3005;
                        i4 = 114;
                        break;
                    case -2:
                        i2 = com.tencent.mm.plugin.appbrand.jsapi.a.d.CTRL_INDEX;
                        i3 = -3004;
                        i4 = 113;
                        break;
                    case -1:
                        i2 = 203;
                        i3 = -3003;
                        i4 = MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
                        break;
                }
                h.Jy(i3);
                f.this.AwR.Jz(i2);
                com.tencent.pb.common.c.c.d("TalkRoomService", "engine exitTalkRoom engineCallback OnError:", Integer.valueOf(i));
                f.this.a(f.this.nqU, f.this.nPD, f.this.AwJ, i4, true);
                f.this.AwZ.g(-400, null);
            }

            public final void keep_OnNotify(int i) {
                com.tencent.pb.common.c.c.m("TalkRoomService", "keep_OnNotify eventCode: ", Integer.valueOf(i));
                if (i == 5) {
                    f.this.AwR.Aye = 1;
                    h hVar = f.this.AwR;
                    if (hVar.Ayr == 0) {
                        hVar.Ayf = 0;
                    } else {
                        hVar.Ayf = System.currentTimeMillis() - hVar.Ayr;
                    }
                    com.tencent.pb.common.c.c.d(h.TAG, "endRecvFirstPcm", Long.valueOf(hVar.Ayr), Long.valueOf(hVar.Ayf));
                    f.this.AwP = 1;
                    f.j(f.this);
                }
            }

            public final void keep_OnReportEngineRecv(String str, int i) {
                com.tencent.pb.common.c.c.d("TalkRoomService", "keep_OnReportEngineRecv:", Integer.valueOf(i), str);
                StringBuilder stringBuilder = new StringBuilder(g.abt(f.this.Axd));
                stringBuilder.append(",");
                stringBuilder.append(str);
                h.acN(stringBuilder.toString());
            }

            public final void keep_OnReportEngineSend(String str) {
                com.tencent.pb.common.c.c.d("TalkRoomService", "keep_OnReportEngineSend:", str);
                StringBuilder stringBuilder = new StringBuilder(g.abt(f.this.Axd));
                stringBuilder.append(",");
                stringBuilder.append(str);
                h.acO(stringBuilder.toString());
            }

            public final void keep_OnReportChannel(String str) {
                com.tencent.pb.common.c.c.d("TalkRoomService", "keep_OnReportChannel:", str);
                StringBuilder stringBuilder = new StringBuilder(g.abt(f.this.Axd));
                stringBuilder.append(",");
                stringBuilder.append(str);
                h.acP(stringBuilder.toString());
            }
        };
        return true;
    }

    public final void og(boolean z) {
        int uninitLive;
        String cIS;
        this.AwR.groupId = this.nqU;
        this.AwR.zVY = this.AwI;
        if (g.Bf(this.AwR.groupId)) {
            this.AwR.groupId = "";
        }
        if (g.Bf(this.AwR.zVY)) {
            this.AwR.zVY = "";
        }
        this.AwR.suu = 1;
        this.AwR.nJe = this.nPD;
        this.AwR.nJf = this.AwJ;
        com.tencent.pb.common.c.c.d("TalkRoomService", "uninitService isUpload: ", Boolean.valueOf(z));
        com.tencent.pb.common.c.c.d("TalkRoomService", "releaseConpent");
        try {
            vj();
        } catch (Throwable th) {
            com.tencent.pb.common.c.c.m("TalkRoomService", "releaseConpent ", th);
        }
        try {
            cIL();
        } catch (Throwable th2) {
            com.tencent.pb.common.c.c.m("TalkRoomService", "releaseConpent ", th2);
        }
        this.Awz.remove(this.nqU);
        this.Axa = 0;
        this.mIsMute = false;
        setState(0);
        this.AwH = false;
        a(this.AwI, 0, 0, null);
        this.AwI = null;
        this.zVs = 0;
        this.AwK = 0;
        this.AwL = 0;
        this.AwM = 0;
        this.AwO = true;
        this.Axg = true;
        this.AwN = 0;
        this.AwP = 0;
        this.AwG = false;
        this.Axn = false;
        this.Axo = true;
        cIK();
        this.mHandler.removeMessages(1);
        if (this.AwS != null) {
            b bVar = this.AwS;
            if (com.tencent.pb.common.a.a.zUT) {
                bVar.Awk.field_capInfo = null;
            }
        }
        cIP();
        cIO();
        try {
            com.tencent.pb.common.c.c.m("TalkRoomService", "cancelTalkDurationTimerTask");
            if (this.AwX != null) {
                this.AwX.cancel();
            }
        } catch (Exception e) {
            com.tencent.pb.common.c.c.m("TalkRoomService", "cancelTalkDurationTimerTask: ", e);
        }
        this.AwX = null;
        this.mHandler.removeCallbacks(this.Axr);
        this.Axq = null;
        this.nZr = false;
        this.Axf = false;
        int i = QbSdk.EXTENSION_INIT_FAILURE;
        if (this.AwS != null) {
            try {
                this.Axa = this.AwS.cIz();
                i = this.AwS.Close();
            } catch (Throwable th3) {
                com.tencent.pb.common.c.c.m("TalkRoomService", "uninitService", th3);
            }
            com.tencent.pb.common.c.c.m("TalkRoomService", "uninitService mid", Integer.valueOf(i));
        }
        if (this.AwS != null) {
            try {
                uninitLive = this.AwS.uninitLive();
            } catch (Exception e2) {
                com.tencent.pb.common.c.c.m("TalkRoomService", "uninitService 2", e2);
            }
            this.AwS = null;
            if (z) {
                cIS = this.AwR.cIS();
                if (!(TextUtils.isEmpty(this.AwR.groupId) && TextUtils.isEmpty(this.AwR.zVY))) {
                    h.acM(cIS);
                    this.mHandler.removeMessages(4);
                    this.mHandler.sendEmptyMessageDelayed(4, 0);
                }
                cIM();
                try {
                    ((AudioManager) com.tencent.pb.common.c.d.syL.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).setMode(0);
                    com.tencent.pb.common.c.c.m("TalkRoomService", "resumeAudioConfig mode: ", Integer.valueOf(r0.getMode()), " isSpeaker: ", Boolean.valueOf(r0.isSpeakerphoneOn()));
                } catch (Throwable th22) {
                    com.tencent.pb.common.c.c.m("TalkRoomService", "resumeAudioConfig ", th22);
                }
            }
            com.tencent.pb.common.c.c.d("TalkRoomService", "uninitService end error", Integer.valueOf(uninitLive));
        }
        uninitLive = i;
        this.AwS = null;
        if (z) {
            cIS = this.AwR.cIS();
            h.acM(cIS);
            this.mHandler.removeMessages(4);
            this.mHandler.sendEmptyMessageDelayed(4, 0);
            cIM();
            ((AudioManager) com.tencent.pb.common.c.d.syL.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).setMode(0);
            com.tencent.pb.common.c.c.m("TalkRoomService", "resumeAudioConfig mode: ", Integer.valueOf(r0.getMode()), " isSpeaker: ", Boolean.valueOf(r0.isSpeakerphoneOn()));
        }
        com.tencent.pb.common.c.c.d("TalkRoomService", "uninitService end error", Integer.valueOf(uninitLive));
    }

    public final void cIK() {
        try {
            com.tencent.pb.common.c.c.m("TalkRoomService", "stopHoldeOnPusher ");
            if (this.Axp != null) {
                this.mHandler.removeCallbacks(this.Axp);
            }
        } catch (Throwable th) {
            com.tencent.pb.common.c.c.m("TalkRoomService", " stopTimer: ", th);
        }
    }

    final void setState(int i) {
        com.tencent.pb.common.c.c.m("TalkRoomService", "setState newState: ", Integer.valueOf(i));
        if (this.state != i) {
            this.state = i;
            g gVar = this.AwZ;
            Runnable anonymousClass9 = new com.tencent.wecall.talkroom.model.g.AnonymousClass9(i);
            if (Looper.myLooper() == Looper.getMainLooper()) {
                anonymousClass9.run();
            } else {
                gVar.handler.post(anonymousClass9);
            }
        }
    }

    static String[] dP(List<String> list) {
        if (list == null || list.size() <= 0) {
            return new String[0];
        }
        String[] strArr = new String[list.size()];
        int i = 0;
        for (String str : list) {
            int i2 = i + 1;
            strArr[i] = str;
            i = i2;
        }
        return strArr;
    }

    public final b a(Activity activity, String str, int i, long j, int i2, int i3) {
        com.tencent.pb.common.c.c.m("TalkRoomService", "enterTalkRoom", str, Integer.valueOf(this.nPD), Integer.valueOf(i), Long.valueOf(this.AwJ), Long.valueOf(j), Integer.valueOf(i3), "needConfirm", Boolean.valueOf(false));
        if (com.tencent.pb.a.a.a.cDP()) {
            com.tencent.pb.common.b.h.isNetworkConnected();
            if (Jt(i3) && i3 != 100 && bHa()) {
                h.a(str, "", this.nPD, this.AwJ, "enter", "req", "false", String.valueOf(i3), "isBusy");
                com.tencent.pb.common.c.c.m("TalkRoomService", "enterTalkRoom isBusy");
                return b.BUSY;
            }
            boolean acL = i3 == 100 ? true : Jt(i3) ? this.state == 0 : i3 == 1 ? acL(str) : false;
            if (!acL) {
                com.tencent.pb.common.c.c.m("TalkRoomService", "exitTalkRoom enterTalkRoom isValidEnterState is false enterType: ", Integer.valueOf(i3), " state: ", Integer.valueOf(this.state));
                h.a(str, "", this.nPD, this.AwJ, "enter", "req", "false", String.valueOf(i3), "isNotValidEnterState");
                return b.NOT_VALID_STATE;
            } else if (TextUtils.isEmpty(str)) {
                com.tencent.pb.common.c.c.m("TalkRoomService", "exitTalkRoom enterTalkRoom groupId is null");
                h.a(str, "", this.nPD, this.AwJ, "enter", "req", "false", String.valueOf(i3), "groupIdnull");
                return b.GROUP_NOT_VALID;
            } else {
                if (Jt(i3)) {
                    cIM();
                    og(false);
                }
                cIJ();
                if (bFC()) {
                    this.nqU = str;
                    if (Jt(i3)) {
                        this.nPD = i;
                        this.AwJ = j;
                    } else {
                        e acK = acK(str);
                        this.nPD = acK == null ? 0 : acK.nJe;
                        this.AwJ = acK == null ? 0 : acK.nJf;
                    }
                    this.Axd = str;
                    this.zVs = i2;
                    setState(3);
                    this.srZ = Jt(i3);
                    if (this.srZ) {
                        this.AwR.cIT();
                    }
                    if (!this.srZ || c.cIA().bu(this.nqU, true)) {
                        b(str, this.nPD, this.AwJ, i2, i3);
                    } else {
                        c cVar = new c();
                        cVar.groupId = str;
                        cVar.nJe = i;
                        cVar.nJf = j;
                        cVar.zWk = i3;
                        cVar.zWd = i2;
                        Message obtain = Message.obtain();
                        obtain.what = 3;
                        obtain.obj = cVar;
                        this.mHandler.sendMessageDelayed(obtain, 0);
                    }
                    return b.OK;
                }
                com.tencent.pb.common.c.c.m("TalkRoomService", "exitTalkRoom enterTalkRoom initEngine fail");
                if (Jt(i3)) {
                    h.a(str, "", this.nPD, this.AwJ, "enter", "req", "false", "initEnginefail");
                    og(false);
                } else {
                    this.AwR.Q("enter", "req", "false", "initEnginefail");
                }
                return b.INIT_ENGINE_FAILED;
            }
        }
        com.tencent.pb.common.c.c.m("TalkRoomService", "enterTalkRoom isAuthed: ", Boolean.valueOf(com.tencent.pb.a.a.a.cDP()), " isBindMobile: ", Boolean.valueOf(true));
        h.a(str, "", this.nPD, this.AwJ, "enter", "req", "false", String.valueOf(i3), "noAuth");
        return b.NOT_AUTH;
    }

    private void b(String str, int i, long j, int i2, int i3) {
        com.tencent.pb.common.c.c.m("TalkRoomService", "sendEnterGroupScence groupId: ", str, " roomId: ", Integer.valueOf(i), " roomKey: ", Long.valueOf(j), " enterType: ", Integer.valueOf(i3), " isSenceCircle: ", Boolean.valueOf(true));
        if (i == 0 || j == 0) {
            com.tencent.pb.common.c.c.e("TalkRoomService", "roomId or roomkey is 0..return.");
            return;
        }
        if (!Jt(i3)) {
            h hVar = this.AwR;
            com.tencent.pb.common.c.c.d(h.TAG, "endAnswerTime", Long.valueOf(hVar.Ays));
            if (hVar.Ays == 0) {
                hVar.nKA = 0;
            } else {
                hVar.nKA = System.currentTimeMillis() - hVar.Ays;
            }
        }
        this.AwR.cIU();
        com.tencent.pb.common.b.d eVar = new com.tencent.wecall.talkroom.a.e(str, i, j, this.AwS.cIy(), i2, i3);
        com.tencent.pb.common.b.e.cDx().a(eVar);
        this.mHandler.removeCallbacks(this.Axr);
        this.Axq = eVar;
        this.mHandler.postDelayed(this.Axr, 3000);
    }

    public final boolean b(String str, int i, long j, int i2) {
        com.tencent.pb.common.c.c.m("TalkRoomService", "rejectTalkRoom groupId: ", str, " mGroupId: ", this.nqU, " roomId: ", Integer.valueOf(i), " roomKey: ", Long.valueOf(j), " reason: ", Integer.valueOf(i2));
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!(3 != (1 == i2 ? 1 : 3) || i2 == 7 || this.AwN == 0)) {
            System.currentTimeMillis();
        }
        boolean a = com.tencent.pb.common.b.e.cDx().a(new com.tencent.wecall.talkroom.a.i(str, i, j, i2));
        if (b(str, i, j, false)) {
            this.AwR.Q("reject", "req", String.valueOf(a), String.valueOf(this.state));
        } else {
            h.a(str, i, j, "reject", "req", String.valueOf(a), String.valueOf(this.state));
        }
        a(str, i, j, false);
        com.tencent.pb.common.c.c.m("TalkRoomService", "rejectTalkRoom ret: ", Boolean.valueOf(a));
        return a;
    }

    private boolean dO(String str, int i) {
        com.tencent.pb.common.c.c.m("TalkRoomService", "cancelCreateTalkRoom clientGroupId: ", str);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        boolean a = com.tencent.pb.common.b.e.cDx().a(new com.tencent.wecall.talkroom.a.c(str, i, this.zVs));
        this.AwR.Q("cancel", "req", String.valueOf(a), String.valueOf(this.state));
        a(str, this.nPD, this.AwJ, true);
        com.tencent.pb.common.c.c.m("TalkRoomService", "cancelCreateTalkRoom ret: ", Boolean.valueOf(a));
        return a;
    }

    public final boolean a(String str, int i, long j, int i2, boolean z) {
        com.tencent.pb.common.c.c.m("TalkRoomService", "exitTalkRoom", str, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2));
        if (TextUtils.isEmpty(str)) {
            com.tencent.pb.common.c.c.d("TalkRoomService", "exitTalkRoom: has exited");
            return false;
        }
        boolean a = com.tencent.pb.common.b.e.cDx().a(new com.tencent.wecall.talkroom.a.f(str, i, j, i2));
        this.AwR.Q("exit", "req", String.valueOf(a), String.valueOf(this.state));
        a(str, i, j, z);
        com.tencent.pb.common.c.c.m("TalkRoomService", "exitTalkRoom ret: ", Boolean.valueOf(a));
        return a;
    }

    private boolean cIL() {
        boolean bcD;
        try {
            com.tencent.pb.talkroom.sdk.e eVar = zVE;
            if (eVar != null) {
                this.AwR.suI = eVar.bcF();
                this.AwR.suy = eVar.bcI();
                bcD = eVar.bcD();
                com.tencent.pb.common.c.c.d("TalkRoomService", "stopPlayer ret: ", Boolean.valueOf(bcD));
                return bcD;
            }
        } catch (Exception e) {
            com.tencent.pb.common.c.c.m("TalkRoomService", "stopPlayer: ", e);
        }
        bcD = false;
        com.tencent.pb.common.c.c.d("TalkRoomService", "stopPlayer ret: ", Boolean.valueOf(bcD));
        return bcD;
    }

    private static int b(int i, int i2, com.tencent.pb.talkroom.sdk.b bVar) {
        int i3 = -100;
        try {
            com.tencent.pb.talkroom.sdk.e eVar = zVE;
            if (eVar != null) {
                i3 = eVar.a(i, i2, bVar);
            }
        } catch (Exception e) {
            com.tencent.pb.common.c.c.m("TalkRoomService", "startPlayer: ", Integer.valueOf(i), Integer.valueOf(i2), e);
        }
        com.tencent.pb.common.c.c.d("TalkRoomService", "startPlayer samplerate: ", " frameDuration: ", Integer.valueOf(i2), " ret: ", Integer.valueOf(i3));
        return i3;
    }

    private boolean vj() {
        boolean bcE;
        try {
            com.tencent.pb.talkroom.sdk.e eVar = zVE;
            if (eVar != null) {
                this.AwR.suB = eVar.bcG();
                this.AwR.sux = eVar.bcH();
                bcE = eVar.bcE();
                com.tencent.pb.common.c.c.d("TalkRoomService", "stopRecord ret: ", Boolean.valueOf(bcE));
                return bcE;
            }
        } catch (Exception e) {
            com.tencent.pb.common.c.c.m("TalkRoomService", "stopRecord: ", e);
        }
        bcE = false;
        com.tencent.pb.common.c.c.d("TalkRoomService", "stopRecord ret: ", Boolean.valueOf(bcE));
        return bcE;
    }

    private static int b(int i, int i2, com.tencent.pb.talkroom.sdk.c cVar) {
        int i3 = -100;
        try {
            com.tencent.pb.talkroom.sdk.e eVar = zVE;
            if (eVar != null) {
                i3 = eVar.a(i, i2, cVar);
            }
        } catch (Exception e) {
            com.tencent.pb.common.c.c.m("TalkRoomService", "startRecord: ", e);
        }
        com.tencent.pb.common.c.c.d("TalkRoomService", "startRecord samplerate: ", " frameDuration: ", Integer.valueOf(i2), " ret: ", Integer.valueOf(i3));
        return i3;
    }

    public final void a(int i, int i2, String str, com.tencent.pb.common.b.d dVar) {
        Map y;
        String str2 = "TalkRoomService";
        Object[] objArr = new Object[6];
        objArr[0] = "CLTNOT onNetSceneEnd errCode:";
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = " errType: ";
        objArr[3] = Integer.valueOf(i);
        objArr[4] = " scene.getType(): ";
        objArr[5] = dVar != null ? Integer.valueOf(dVar.getType()) : "";
        com.tencent.pb.common.c.c.d(str2, objArr);
        if (i == 1 || i == 2) {
            y = com.tencent.pb.common.c.b.y(Integer.valueOf(201), Integer.valueOf(-1004), Integer.valueOf(202), Integer.valueOf(-1107), Integer.valueOf(203), Integer.valueOf(-1205), Integer.valueOf(com.tencent.mm.plugin.appbrand.jsapi.a.d.CTRL_INDEX), Integer.valueOf(TXLiveConstants.PUSH_ERR_AUDIO_ENCODE_FAIL), Integer.valueOf(com.tencent.mm.plugin.appbrand.jsapi.a.g.CTRL_INDEX), Integer.valueOf(-1403), Integer.valueOf(207), Integer.valueOf(-1502), Integer.valueOf(com.tencent.mm.plugin.appbrand.jsapi.a.c.CTRL_INDEX), Integer.valueOf(-1512), Integer.valueOf(com.tencent.mm.plugin.appbrand.jsapi.a.b.CTRL_INDEX), Integer.valueOf(-1522), Integer.valueOf(com.tencent.mm.plugin.appbrand.jsapi.a.f.CTRL_INDEX), Integer.valueOf(-1532), Integer.valueOf(i.CTRL_INDEX), Integer.valueOf(-1542));
            int type = dVar.getType();
            if (y.containsKey(Integer.valueOf(type))) {
                h.Jv(((Integer) y.get(Integer.valueOf(type))).intValue());
            }
        }
        k kVar;
        if (i2 == -1) {
            try {
                if (dVar.getType() == 201) {
                    com.tencent.wecall.talkroom.a.d dVar2 = (com.tencent.wecall.talkroom.a.d) dVar;
                    if (g.ga(this.AwI, dVar2.AwI)) {
                        this.AwR.Jz(301);
                        this.AwR.Q("create", "resp", "-1", String.valueOf(this.state));
                        dO(dVar2.AwI, 1001);
                        if (!dVar2.AyD) {
                            this.Awa.c("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
                        }
                        this.AwZ.g(-100, null);
                        return;
                    }
                    return;
                } else if (dVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.a.c.CTRL_INDEX) {
                    this.AwZ.dN(((com.tencent.wecall.talkroom.a.g) dVar).nqU, i2);
                    return;
                } else if (dVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.a.b.CTRL_INDEX) {
                    com.tencent.wecall.talkroom.a.a aVar = (com.tencent.wecall.talkroom.a.a) dVar;
                    if (!b(aVar.nqU, aVar.nPD, aVar.AwJ, false)) {
                        h.a(aVar.nqU, aVar.nPD, aVar.AwJ, "ack", "resp", "-1", String.valueOf(this.state));
                    }
                    this.AwZ.a(aVar.AyC, c.cIA().acJ(aVar.nqU));
                    return;
                } else if (dVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.a.d.CTRL_INDEX) {
                    com.tencent.wecall.talkroom.a.b bVar = (com.tencent.wecall.talkroom.a.b) dVar;
                    if (b(bVar.nqU, bVar.nPD, bVar.AwJ, false)) {
                        this.AwR.Q("add", "resp", "-1", String.valueOf(this.state));
                        this.AwZ.g(-300, null);
                        return;
                    }
                    return;
                } else if (dVar.getType() == 202) {
                    com.tencent.wecall.talkroom.a.e eVar = (com.tencent.wecall.talkroom.a.e) dVar;
                    if (b(eVar.nqU, eVar.nPD, eVar.AwJ, Jt(eVar.AyE)) && this.state == 3) {
                        this.AwR.Jz(HardCoderJNI.SCENE_QUIT_CHATTING);
                        this.AwZ.g(-200, null);
                        return;
                    }
                    return;
                } else if (dVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX) {
                    this.AwZ.dO(null);
                    return;
                } else if (dVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.bio.face.c.CTRL_INDEX) {
                    if (g.equals(((j) dVar).nqU, this.nqU)) {
                        this.AwR.Q("sendmsg", "resp", "-1", String.valueOf(this.state));
                        this.AwZ.g(-700, null);
                        return;
                    }
                    return;
                } else if (dVar.getType() == h.CTRL_INDEX) {
                    com.tencent.wecall.talkroom.a.h hVar = (com.tencent.wecall.talkroom.a.h) dVar;
                    if (b(hVar.groupId, hVar.nJe, hVar.nJf, false)) {
                        this.AwR.Q("redirect", "resp", "-1", String.valueOf(this.state));
                        return;
                    }
                    return;
                } else if (dVar.getType() == JsApiCheckIsSupportFaceDetect.CTRL_INDEX) {
                    l lVar = (l) dVar;
                    if (b(lVar.nqU, lVar.nPD, lVar.AwJ, false)) {
                        this.AwZ.g(-800, null);
                        return;
                    }
                    return;
                } else if (dVar.getType() == 800) {
                    kVar = (k) dVar;
                    if (b(kVar.nqU, kVar.nPD, kVar.AwJ, false)) {
                        this.AwZ.g(-1600, null);
                        return;
                    }
                    return;
                } else {
                    return;
                }
            } catch (Exception e) {
                com.tencent.pb.common.c.c.m("TalkRoomService", "cancelCreateTalkRoom: ", e);
                return;
            }
        }
        Map y2;
        g gVar;
        Runnable anonymousClass6;
        int i3;
        Runnable anonymousClass18;
        if (dVar.getType() == 201) {
            com.tencent.wecall.talkroom.a.d dVar3 = (com.tencent.wecall.talkroom.a.d) dVar;
            if (!(dVar3 == null || dVar3.zVq == null)) {
                Object obj;
                z zVar = (z) dVar3.zVq;
                com.tencent.pb.common.c.c.m("TalkRoomService", "handleCreateVoiceGroupEnd errCode: ", Integer.valueOf(i2), Integer.valueOf(dVar3.mType), dVar3.AwI);
                if (dVar3.AyD) {
                    obj = null;
                } else {
                    obj = 1;
                }
                y2 = com.tencent.pb.common.c.b.y(Integer.valueOf(14000), Integer.valueOf(-1001), Integer.valueOf(14001), Integer.valueOf(-1002), Integer.valueOf(14002), Integer.valueOf(-1009));
                if (y2.containsKey(Integer.valueOf(i2))) {
                    h.Jv(((Integer) y2.get(Integer.valueOf(i2))).intValue());
                }
                if (i2 != 14002) {
                    Awy = null;
                    if (i2 != 0) {
                        if (g.ga(this.AwI, dVar3.AwI)) {
                            if (i2 != -1) {
                                this.AwR.Jz(321);
                                this.AwR.Q("create", "resp", String.valueOf(i2), String.valueOf(this.state));
                            }
                            if (this.state != 1) {
                                com.tencent.pb.common.c.c.m("TalkRoomService", "handleCreateVoiceGroupEnd state is error: ", Integer.valueOf(this.state), "  errCode: ", Integer.valueOf(i2), dVar3.AwI);
                                if (obj != null) {
                                    this.Awa.c("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
                                }
                            } else {
                                a(this.nqU, this.nPD, this.AwJ, true);
                                if (i2 == 14051) {
                                    this.AwZ.g(-900, null);
                                } else if (i2 == 14052) {
                                    this.AwZ.g(-1100, null);
                                } else if (i2 == 14053) {
                                    this.AwZ.g(-1300, zVar);
                                } else if (i2 == 14504) {
                                    this.AwZ.g(-1400, null);
                                } else {
                                    this.AwZ.g(-100, null);
                                }
                                if (obj != null) {
                                    this.Awa.c("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
                                }
                            }
                        } else {
                            com.tencent.pb.common.c.c.m("TalkRoomService", "handleCreateVoiceGroupEnd mClientGroupId is not same mClientGroupId: ", this.AwI, " createScene.mClientGroupId: ", dVar3.AwI, " errCode: ", Integer.valueOf(i2));
                            if (obj != null) {
                                this.Awa.c("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
                            }
                        }
                    } else if (g.ga(this.AwI, zVar.zVY)) {
                        this.AwR.Q("create", "resp", String.valueOf(i2), String.valueOf(this.state));
                        if (this.state != 1) {
                            h.Jv(-1003);
                            com.tencent.pb.common.c.c.m("TalkRoomService", "handleCreateVoiceGroupEnd state != STATE_CREATING_TAKLROOM: ", Integer.valueOf(this.state), zVar.zVY, Integer.valueOf(zVar.srH), Long.valueOf(zVar.srI));
                            if (obj != null) {
                                this.Awa.c("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
                            }
                        } else if (zVar.zXr == null || zVar.zXr.length == 0) {
                            com.tencent.pb.common.c.c.m("TalkRoomService", "handleCreateVoiceGroupEnd resp.addrlist is null,errCode: ", Integer.valueOf(i2), zVar.zVY, Integer.valueOf(zVar.srH), Long.valueOf(zVar.srI));
                            h.Jv(-1605);
                            this.AwR.sCt = 329;
                            a(zVar.groupId, zVar.srH, zVar.srI, 116, true);
                            if (obj != null) {
                                this.Awa.c("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
                            }
                            this.AwZ.g(-100, null);
                        } else {
                            a(zVar.zVY, zVar.srH, zVar.srI, zVar.groupId);
                            this.Axd = zVar.groupId;
                            this.zVs = zVar.zWd;
                            setState(4);
                            a(zVar.zXr, zVar.zXy, zVar.zXz);
                            a(zVar.groupId, zVar.zVY, zVar.zWd, zVar.srH, zVar.srI, zVar.zWE, zVar.zXs, zVar.zWa, false, true);
                            if (this.AwZ != null) {
                                gVar = this.AwZ;
                                anonymousClass6 = new com.tencent.wecall.talkroom.model.g.AnonymousClass6(c.cIA().acJ(zVar.groupId));
                                if (Looper.myLooper() == Looper.getMainLooper()) {
                                    anonymousClass6.run();
                                } else {
                                    gVar.handler.post(anonymousClass6);
                                }
                            }
                            byte[] bArr = new byte[zVar.zXu.length];
                            for (i3 = 0; i3 < zVar.zXu.length; i3++) {
                                bArr[i3] = (byte) zVar.zXu[i3];
                            }
                            a(0, zVar.zWE, zVar.zWF, bArr, (zVar.zXt & 2) != 0, zVar.groupId, zVar.srH, zVar.srI, zVar.zXA, zVar.zXB, zVar.zXC);
                            if (zVar.zXx != 0) {
                                com.tencent.pb.common.c.c.l("TalkRoomService", "get helloFreqSeconds:" + zVar.zXx);
                                AwF = zVar.zXx * 1000;
                            }
                            cIN();
                            h(zVar.groupId, zVar.srH, zVar.srI);
                            if (obj != null) {
                                y = new HashMap();
                                y.put("result", Boolean.valueOf(true));
                                y.put("shareUrl", new String(zVar.zWa.zYm, Charset.forName(ProtocolPackage.ServerEncoding)));
                                y.put("smsShortUrl", new String(zVar.zWa.zYn, Charset.forName(ProtocolPackage.ServerEncoding)));
                                y.put("groupId", zVar.groupId);
                                this.Awa.c("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, y);
                            }
                            com.tencent.pb.common.c.c.m("TalkRoomService", "handleCreateVoiceGroupEnd", this.nqU, Integer.valueOf(this.nPD), Long.valueOf(this.AwJ));
                        }
                    } else {
                        com.tencent.pb.common.c.c.m("TalkRoomService", "handleCreateVoiceGroupEnd mClientGroupId is not same mClientGroupId: ", this.AwI, " resp.clientGroupId: ", zVar.zVY, Integer.valueOf(zVar.srH), Long.valueOf(zVar.srI));
                        a(zVar.groupId, zVar.srH, zVar.srI, 110, false);
                        if (obj != null) {
                            this.Awa.c("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
                        }
                    }
                }
            }
        }
        if (dVar.getType() == 202) {
            com.tencent.wecall.talkroom.a.e eVar2 = (com.tencent.wecall.talkroom.a.e) dVar;
            if (!(eVar2 == null || eVar2.zVq == null)) {
                a(i2, (aa) eVar2.zVq, eVar2);
            }
        }
        if (dVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.a.d.CTRL_INDEX) {
            com.tencent.wecall.talkroom.a.b bVar2 = (com.tencent.wecall.talkroom.a.b) dVar;
            if (!(bVar2 == null || bVar2.zVq == null)) {
                x xVar = (x) bVar2.zVq;
                com.tencent.pb.common.c.c.m("TalkRoomService", "handleAddVoiceGroupMemberEnd", this.nqU, Integer.valueOf(this.nPD), Long.valueOf(this.AwJ), " errCode: ", Integer.valueOf(i2));
                y2 = com.tencent.pb.common.c.b.y(Integer.valueOf(14600), Integer.valueOf(TXLiveConstants.PUSH_ERR_OPEN_CAMERA_FAIL), Integer.valueOf(14601), Integer.valueOf(TXLiveConstants.PUSH_ERR_OPEN_MIC_FAIL), Integer.valueOf(14602), Integer.valueOf(TXLiveConstants.PUSH_ERR_VIDEO_ENCODE_FAIL));
                if (y2.containsKey(Integer.valueOf(i2))) {
                    h.Jv(((Integer) y2.get(Integer.valueOf(i2))).intValue());
                }
                if (i2 == 0) {
                    str2 = "TalkRoomService";
                    objArr = new Object[2];
                    objArr[0] = "handleAddVoiceGroupMemberEnd  resp.members length: ";
                    objArr[1] = Integer.valueOf(xVar.zXq == null ? 0 : xVar.zXq.length);
                    com.tencent.pb.common.c.c.m(str2, objArr);
                    if (b(xVar.groupId, xVar.srH, xVar.srI, false)) {
                        this.AwR.Q("add", "resp", String.valueOf(i2), String.valueOf(this.state));
                    } else {
                        com.tencent.pb.common.c.c.m("TalkRoomService", "handleAddVoiceGroupMemberEnd isCurrentRoom false resp.groupId: ", xVar.groupId, this.nqU, " resp.roomid: ", Integer.valueOf(xVar.srH), Integer.valueOf(this.nPD));
                        h.Jv(TXLiveConstants.PUSH_ERR_SCREEN_CAPTURE_START_FAILED);
                    }
                    a(xVar.groupId, null, this.zVs, xVar.srH, xVar.srI, xVar.zXq, null, xVar.zWa, true, true);
                } else if (b(bVar2.nqU, bVar2.nPD, bVar2.AwJ, false)) {
                    this.AwR.Q("add", "resp", String.valueOf(i2), String.valueOf(this.state));
                    this.AwZ.g(-300, null);
                }
            }
        }
        if (dVar.getType() == 203) {
            com.tencent.wecall.talkroom.a.f fVar = (com.tencent.wecall.talkroom.a.f) dVar;
            if (!(fVar == null || fVar.zVq == null)) {
                ab abVar = (ab) fVar.zVq;
                com.tencent.pb.common.c.c.d("TalkRoomService", "handleExitVoiceRoomEnd", abVar.groupId, this.nqU, Integer.valueOf(this.nPD), Long.valueOf(this.AwJ), " errCode: ", Integer.valueOf(i2));
                y = com.tencent.pb.common.c.b.y(Integer.valueOf(14400), Integer.valueOf(-1201), Integer.valueOf(14401), Integer.valueOf(-1202), Integer.valueOf(14402), Integer.valueOf(-1203), Integer.valueOf(14403), Integer.valueOf(-1204));
                if (y.containsKey(Integer.valueOf(i2))) {
                    h.Jv(((Integer) y.get(Integer.valueOf(i2))).intValue());
                }
                if (i2 != 0) {
                    com.tencent.pb.common.c.c.m("TalkRoomService", "handleExitVoiceRoomEnd fail errCode is ", Integer.valueOf(i2));
                }
            }
        }
        if (dVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.a.g.CTRL_INDEX) {
            m mVar = (m) dVar;
            if (!(mVar == null || mVar.zVq == null)) {
                ak akVar = (ak) mVar.zVq;
                com.tencent.pb.common.c.c.d("TalkRoomService", "handleHelloEnd", akVar.groupId, this.nqU, Integer.valueOf(this.nPD), Long.valueOf(this.AwJ), Integer.valueOf(i2), Integer.valueOf(i));
                cIO();
                i3 = 0;
                if (i2 == 14800) {
                    i3 = -1401;
                } else if (i2 == 14801) {
                    i3 = -1402;
                }
                if (i3 != 0) {
                    this.AwR.Jz(p.CTRL_INDEX);
                    h.Jv(i3);
                }
            }
        }
        if (dVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.a.b.CTRL_INDEX) {
            com.tencent.wecall.talkroom.a.a aVar2 = (com.tencent.wecall.talkroom.a.a) dVar;
            if (!(aVar2 == null || aVar2.zVq == null)) {
                com.tencent.pb.common.c.c.m("TalkRoomService", "CLTNOT handleAckEnd errCode is ", Integer.valueOf(i2), " groupId: ", aVar2.nqU, " roomid: ", Integer.valueOf(aVar2.nPD), " roomKey: ", Long.valueOf(aVar2.AwJ));
                MultiTalkGroup acJ;
                if (i2 == 18950) {
                    if (!b(aVar2.nqU, aVar2.nPD, aVar2.AwJ, false)) {
                        h.a(aVar2.nqU, aVar2.nPD, aVar2.AwJ, "ack", "resp", String.valueOf(i2), String.valueOf(this.state));
                    }
                    acJ = c.cIA().acJ(aVar2.nqU);
                    com.tencent.pb.common.c.c.m("TalkRoomService", "CLTNOT handleAckEnd onMisscMultiTalk mGroupId:", aVar2.nqU, " multiTalkGroup: ", acJ);
                    if (acJ != null) {
                        this.AwZ.a(aVar2.AyC, acJ);
                    }
                } else {
                    if (i2 == 0) {
                        this.AwG = true;
                    }
                    if (!bHa()) {
                        com.tencent.pb.common.c.c.m("TalkRoomService", "CLTNOT handleAckEnd is working groupId: ", aVar2.nqU);
                        cIM();
                        og(false);
                        this.AwR.Q("ack", "resp", String.valueOf(i2), String.valueOf(this.state));
                        this.srZ = false;
                        this.nqU = aVar2.nqU;
                        this.Axd = this.nqU;
                        this.nPD = aVar2.nPD;
                        this.AwJ = aVar2.AwJ;
                        this.zVs = aVar2.zVs;
                        setState(2);
                        this.AwN = System.currentTimeMillis();
                        h hVar2 = this.AwR;
                        com.tencent.pb.common.c.c.d(h.TAG, "beginNotifyTime");
                        hVar2.Ays = System.currentTimeMillis();
                        if (i2 == 18900) {
                            h.Jv(-1521);
                        }
                    } else if (g.equals(aVar2.nqU, this.nqU)) {
                        com.tencent.pb.common.c.c.m("TalkRoomService", "CLTNOT handleAckEnd groupid same return ", this.nqU);
                    }
                    e eVar3 = new e();
                    eVar3.groupId = aVar2.nqU;
                    eVar3.nJe = aVar2.nPD;
                    eVar3.nJf = aVar2.AwJ;
                    this.Awz.put(aVar2.nqU, eVar3);
                    acJ = c.cIA().acJ(aVar2.nqU);
                    com.tencent.pb.common.c.c.m("TalkRoomService", "CLTNOT handleAckEnd onInviteMultiTalk mGroupId:", aVar2.nqU, " multiTalkGroup: ", acJ);
                    if (acJ != null) {
                        gVar = this.AwZ;
                        anonymousClass6 = new AnonymousClass20(acJ);
                        if (Looper.myLooper() == Looper.getMainLooper()) {
                            anonymousClass6.run();
                        } else {
                            gVar.handler.post(anonymousClass6);
                        }
                    } else {
                        a(aVar2.nqU, aVar2.nPD, aVar2.AwJ, false, false, false);
                    }
                }
            }
        }
        if (dVar.getType() == 207) {
            com.tencent.wecall.talkroom.a.i iVar = (com.tencent.wecall.talkroom.a.i) dVar;
            if (!(iVar == null || iVar.zVq == null)) {
                if (i2 == 18100) {
                    h.Jv(-1501);
                }
                com.tencent.pb.common.c.c.m("TalkRoomService", "handleRejectEnd  errCode is ", Integer.valueOf(i2));
            }
        }
        if (dVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.a.f.CTRL_INDEX) {
            com.tencent.wecall.talkroom.a.c cVar = (com.tencent.wecall.talkroom.a.c) dVar;
            if (!(cVar == null || cVar.zVq == null)) {
                if (i2 == 18300) {
                    h.Jv(-1531);
                }
                com.tencent.pb.common.c.c.m("TalkRoomService", "handleCancelCreateEnd errCode is ", Integer.valueOf(i2));
            }
        }
        if (dVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.a.c.CTRL_INDEX) {
            com.tencent.wecall.talkroom.a.g gVar2 = (com.tencent.wecall.talkroom.a.g) dVar;
            if (!(gVar2 == null || gVar2.zVq == null)) {
                ac acVar = (ac) gVar2.zVq;
                if (i2 == 17900) {
                    h.Jv(-1511);
                }
                if (i2 != 0) {
                    this.AwZ.dN(gVar2.nqU, i2);
                    com.tencent.pb.common.c.c.m("TalkRoomService", "handleNetSceneModifyVoiceGroupEnd fail errCode is ", Integer.valueOf(i2));
                } else {
                    TalkRoom acE = c.cIA().acE(acVar.groupId);
                    if (acE != null) {
                        com.tencent.pb.common.c.c.m("TalkRoomService", "handleVoiceGroupMemberChange handleModifyVoiceGroupEnd");
                        a(acVar.groupId, null, acE.cIr(), TalkRoom.cIs(), TalkRoom.bIa(), null, null, acVar.zWa, true, false);
                    } else {
                        a(acVar.groupId, null, 0, 0, 0, null, null, acVar.zWa, true, false);
                    }
                    this.AwZ.dN(acVar.groupId, 0);
                }
            }
        }
        if (dVar.getType() == i.CTRL_INDEX) {
            com.tencent.pb.common.c.c.d("TalkRoomService", "talkHoldonResp", Integer.valueOf(i), Integer.valueOf(i2));
            if (i2 == 19100) {
                h.Jv(-1541);
            }
        }
        if (dVar.getType() == h.CTRL_INDEX) {
            com.tencent.wecall.talkroom.a.h hVar3 = (com.tencent.wecall.talkroom.a.h) dVar;
            if (hVar3 != null) {
                a(i, i2, dVar.zVq, hVar3);
            }
        }
        if (dVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX) {
            a(i2, (ah) dVar.zVq);
        }
        if (dVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.bio.face.c.CTRL_INDEX) {
            j jVar = (j) dVar;
            com.tencent.pb.common.c.c.m("TalkRoomService", "handleSendMsg errCode: ", Integer.valueOf(i2));
            if (i2 != 0) {
                if (g.equals(jVar.nqU, this.nqU)) {
                    this.AwR.Q("sendmsg", "resp", String.valueOf(i2), String.valueOf(this.state));
                    this.AwZ.g(-700, null);
                }
            } else if (g.equals(jVar.nqU, this.nqU)) {
                this.AwR.Q("sendmsg", "resp", String.valueOf(i2), String.valueOf(this.state));
                gVar = this.AwZ;
                anonymousClass18 = new Runnable() {
                    public final void run() {
                        synchronized (g.this.gzt) {
                            for (a cII : g.this.gzt) {
                                cII.cII();
                            }
                        }
                    }
                };
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    anonymousClass18.run();
                } else {
                    gVar.handler.post(anonymousClass18);
                }
            }
        }
        if (dVar.getType() == JsApiCheckIsSupportFaceDetect.CTRL_INDEX) {
            af afVar = (af) dVar.zVq;
            l lVar2 = (l) dVar;
            com.tencent.pb.common.c.c.m("TalkRoomService", "handleSwitchVideoGroup errCode: ", Integer.valueOf(i2));
            if (b(lVar2.nqU, lVar2.nPD, lVar2.AwJ, false)) {
                if (this.AwS != null) {
                    com.tencent.pb.common.c.c.d("TalkRoomService", "setMVSvrCfg:small:br:,WH:,FPS:,big:br:,WH:,Fps:", Integer.valueOf(new int[]{afVar.zXE, afVar.zXF, afVar.zXG, afVar.zXH, afVar.zXI, afVar.zXJ}[0]), Integer.valueOf(new int[]{afVar.zXE, afVar.zXF, afVar.zXG, afVar.zXH, afVar.zXI, afVar.zXJ}[1]), Integer.valueOf(new int[]{afVar.zXE, afVar.zXF, afVar.zXG, afVar.zXH, afVar.zXI, afVar.zXJ}[2]), Integer.valueOf(new int[]{afVar.zXE, afVar.zXF, afVar.zXG, afVar.zXH, afVar.zXI, afVar.zXJ}[3]), Integer.valueOf(new int[]{afVar.zXE, afVar.zXF, afVar.zXG, afVar.zXH, afVar.zXI, afVar.zXJ}[4]), Integer.valueOf(new int[]{afVar.zXE, afVar.zXF, afVar.zXG, afVar.zXH, afVar.zXI, afVar.zXJ}[5]));
                    this.AwS.Awk.setMVSvrCfg(r5, 6);
                }
                if (i2 == 0) {
                    g gVar3 = this.AwZ;
                    anonymousClass6 = new AnonymousClass15(afVar.zXE);
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        anonymousClass6.run();
                    } else {
                        gVar3.handler.post(anonymousClass6);
                    }
                } else if (i2 == 24301) {
                    this.AwZ.g(-1700, Integer.valueOf(afVar.zXL));
                } else {
                    this.AwZ.g(-800, null);
                }
            } else {
                com.tencent.pb.common.c.c.m("TalkRoomService", "handleSwitchVideoGroup isCurrentRoom is not same", lVar2.nqU, Integer.valueOf(lVar2.nPD));
            }
        }
        if (dVar.getType() == 800) {
            kVar = (k) dVar;
            com.tencent.pb.common.c.c.m("TalkRoomService", "handleSubscribeLargeVideo errCode: ", Integer.valueOf(i2));
            if (!b(kVar.nqU, kVar.nPD, kVar.AwJ, false)) {
                com.tencent.pb.common.c.c.m("TalkRoomService", "handleSubscribeLargeVideo isCurrentRoom is not same", kVar.nqU, Integer.valueOf(kVar.nPD));
            } else if (i2 == 0) {
                gVar = this.AwZ;
                anonymousClass18 = new Runnable() {
                    public final void run() {
                        synchronized (g.this.gzt) {
                            for (a bdi : g.this.gzt) {
                                bdi.bdi();
                            }
                        }
                    }
                };
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    anonymousClass18.run();
                } else {
                    gVar.handler.post(anonymousClass18);
                }
            } else {
                this.AwZ.g(-1600, null);
            }
        }
    }

    private void a(int i, ah ahVar) {
        com.tencent.pb.common.c.c.m("TalkRoomService", "handleGetGroupInfoBatch errCode: ", Integer.valueOf(i));
        if (i != 0) {
            this.AwZ.dO(null);
            return;
        }
        au[] auVarArr = ahVar.zXM;
        if (auVarArr == null || auVarArr.length == 0) {
            com.tencent.pb.common.c.c.m("TalkRoomService", "handleGetGroupInfoBatch resp.groupInfoList is null");
            return;
        }
        List arrayList = new ArrayList();
        for (au auVar : auVarArr) {
            if (auVar != null) {
                a(auVar.groupId, null, 0, auVar.srH, auVar.srI, auVar.zXq, null, null, false, false);
                arrayList.add(c.cIA().acJ(auVar.groupId));
            }
        }
        com.tencent.pb.common.c.c.m("TalkRoomService", "handleGetGroupInfoBatch multiTalkGrouplist size: ", Integer.valueOf(arrayList.size()));
        this.AwZ.dO(arrayList);
    }

    private void a(int i, int i2, Object obj, com.tencent.wecall.talkroom.a.h hVar) {
        com.tencent.pb.common.c.c.d("TalkRoomService", "handleRedirectResp", Integer.valueOf(i), Integer.valueOf(i2));
        if (i2 != 0 || obj == null) {
            com.tencent.pb.common.c.c.e("TalkRoomService", "handleRedirectResp err", Integer.valueOf(i), Integer.valueOf(i2));
            if (b(hVar.groupId, hVar.nJe, hVar.nJf, false)) {
                this.AwR.Q("redirect", "resp", "-1", String.valueOf(this.state));
                return;
            }
            return;
        }
        aj ajVar = (aj) obj;
        if (b(ajVar.groupId, ajVar.srH, ajVar.srI, false)) {
            this.AwR.Q("redirect", "resp", String.valueOf(i2), String.valueOf(this.state));
            a(ajVar.groupId, null, this.zVs, ajVar.srH, ajVar.srI, ajVar.zXq, ajVar.zXs, ajVar.zWa, false, false);
            byte[] bArr = new byte[ajVar.zXu.length];
            for (int i3 = 0; i3 < ajVar.zXu.length; i3++) {
                bArr[i3] = (byte) ajVar.zXu[i3];
            }
            a(ajVar.zXr, ajVar.zXy, ajVar.zXz);
            this.AwS.Close();
            a(0, ajVar.zXq, ajVar.zWF, bArr, (ajVar.zXt & 2) != 0, ajVar.groupId, ajVar.srH, ajVar.srI, ajVar.zXA, ajVar.zXB, ajVar.zXC);
            return;
        }
        com.tencent.pb.common.c.c.e("TalkRoomService", "handleRedirectResp roomid error", Integer.valueOf(ajVar.srH), Integer.valueOf(this.nPD));
    }

    private void a(int i, aa aaVar, com.tencent.wecall.talkroom.a.e eVar) {
        com.tencent.pb.common.c.c.d("TalkRoomService", "handleEnterTalkRoomEnd", eVar.nqU, Integer.valueOf(eVar.nPD), Long.valueOf(eVar.AwJ), " errCode: ", Integer.valueOf(i), " state: ", Integer.valueOf(this.state));
        Map y = com.tencent.pb.common.c.b.y(Integer.valueOf(14200), Integer.valueOf(-1101), Integer.valueOf(14201), Integer.valueOf(-1102), Integer.valueOf(14202), Integer.valueOf(-1103), Integer.valueOf(14203), Integer.valueOf(-1104), Integer.valueOf(14204), Integer.valueOf(-1105), Integer.valueOf(14205), Integer.valueOf(-1111));
        if (y.containsKey(Integer.valueOf(i))) {
            h.Jv(((Integer) y.get(Integer.valueOf(i))).intValue());
        }
        if (i == 14255) {
            com.tencent.pb.common.c.c.e("TalkRoomService", "handleEnterTalkRoomEnd errCode =%d, groupId=%s,roomid=%d,roomkey=%s", Integer.valueOf(14255), aaVar.groupId, Integer.valueOf(aaVar.srH), Long.valueOf(aaVar.srI));
            this.AwZ.g(-14255, aaVar);
        } else if (i == 14256) {
            com.tencent.pb.common.c.c.e("TalkRoomService", "handleEnterTalkRoomEnd errCode =%d, groupId=%s,roomid=%d,roomkey=%s", Integer.valueOf(14256), aaVar.groupId, Integer.valueOf(aaVar.srH), Long.valueOf(aaVar.srI));
            this.AwZ.g(-14256, aaVar);
        } else if (i == 0 || i == 14204) {
            if (i == 14204 && this.state == 4) {
                com.tencent.pb.common.c.c.m("TalkRoomService", "handleEnterTalkRoomEnd errCode == EmRetCode.E_Talk_Enter_AlreadyEnter", aaVar.groupId, Integer.valueOf(aaVar.srH), Long.valueOf(aaVar.srI));
            } else if (!b(aaVar.groupId, aaVar.srH, aaVar.srI, Jt(aaVar.zWk))) {
                com.tencent.pb.common.c.c.m("TalkRoomService", "handleEnterTalkRoomEnd isCurrentRoom is false,state: ", Integer.valueOf(this.state), " resp.groupId锟斤拷", aaVar.groupId, " mGroupId: ", this.nqU, Integer.valueOf(aaVar.srH), Integer.valueOf(this.nPD), Long.valueOf(aaVar.srI), Long.valueOf(this.AwJ));
                a(aaVar.groupId, aaVar.srH, aaVar.srI, 111, false);
                h.Jv(-1110);
            } else if (this.state != 3) {
                com.tencent.pb.common.c.c.m("TalkRoomService", "handleEnterTalkRoomEnd state is error: ", Integer.valueOf(this.state), aaVar.groupId, Integer.valueOf(aaVar.srH), Long.valueOf(aaVar.srI));
            } else {
                this.AwR.Q("enter", "resp", String.valueOf(i), String.valueOf(this.state));
                if (aaVar.zXr == null || aaVar.zXr.length == 0) {
                    com.tencent.pb.common.c.c.m("TalkRoomService", "handleEnterTalkRoomEnd resp.addrlist is null,errCode: ", Integer.valueOf(i), aaVar.groupId, Integer.valueOf(aaVar.srH), Long.valueOf(aaVar.srI));
                    h.Jv(-1605);
                    this.AwR.sCt = 329;
                    a(aaVar.groupId, aaVar.srH, aaVar.srI, 116, true);
                    this.AwZ.g(-200, null);
                    return;
                }
                this.nqU = aaVar.groupId;
                this.Axd = aaVar.groupId;
                this.nPD = aaVar.srH;
                this.AwJ = aaVar.srI;
                setState(4);
                a(aaVar.zXr, aaVar.zXy, aaVar.zXz);
                a(aaVar.groupId, null, this.zVs, aaVar.srH, aaVar.srI, aaVar.zXq, aaVar.zXs, aaVar.zWa, false, true);
                g gVar = this.AwZ;
                Runnable anonymousClass7 = new com.tencent.wecall.talkroom.model.g.AnonymousClass7(c.cIA().acJ(aaVar.groupId));
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    anonymousClass7.run();
                } else {
                    gVar.handler.post(anonymousClass7);
                }
                byte[] bArr = new byte[aaVar.zXu.length];
                for (int i2 = 0; i2 < aaVar.zXu.length; i2++) {
                    bArr[i2] = (byte) aaVar.zXu[i2];
                }
                a(0, aaVar.zXq, aaVar.zWF, bArr, (aaVar.zXt & 2) != 0, aaVar.groupId, aaVar.srH, aaVar.srI, aaVar.zXA, aaVar.zXB, aaVar.zXC);
                if (aaVar.zXx != 0) {
                    com.tencent.pb.common.c.c.l("TalkRoomService", "get helloFreqSeconds:" + aaVar.zXx);
                    AwF = aaVar.zXx * 1000;
                }
                cIN();
                com.tencent.pb.common.c.c.m("TalkRoomService", "handleVoiceGroupMemberChange handleEnterTalkRoomEnd", this.nqU, Integer.valueOf(this.nPD), Long.valueOf(this.AwJ));
            }
        } else if (!b(eVar.nqU, eVar.nPD, eVar.AwJ, Jt(eVar.AyE))) {
            com.tencent.pb.common.c.c.m("TalkRoomService", "handleEnterTalkRoomEnd isCurrentRoom is false errCode:", Integer.valueOf(i), " enterScene.mGroupId: ", eVar.nqU, " mGroupId: ", this.nqU, Integer.valueOf(eVar.nPD), Integer.valueOf(this.nPD), Long.valueOf(eVar.AwJ), Long.valueOf(this.AwJ));
        } else if (3 != this.state) {
            com.tencent.pb.common.c.c.m("TalkRoomService", "handleEnterTalkRoomEnd state is error: ", Integer.valueOf(this.state), " errCode: ", Integer.valueOf(i), eVar.nqU, Integer.valueOf(eVar.nPD), Long.valueOf(eVar.AwJ));
        } else {
            this.AwR.Q("enter", "resp", String.valueOf(i), String.valueOf(this.state));
            this.AwR.Jz(322);
            com.tencent.pb.common.c.c.m("TalkRoomService", "exitTalkRoom handleEnterTalkRoomEnd fail errCode: ", Integer.valueOf(i), eVar.nqU, Integer.valueOf(eVar.nPD), Long.valueOf(eVar.AwJ));
            a(eVar.nqU, eVar.nPD, eVar.AwJ, true);
            if (i == 14251) {
                this.AwZ.g(DownloadResult.CODE_UNDEFINED, null);
            } else if (i == 14252) {
                this.AwZ.g(-1200, null);
            } else if (i == 14253) {
                Object valueOf = Integer.valueOf(60);
                if (aaVar != null) {
                    valueOf = Integer.valueOf(aaVar.zXw);
                }
                this.AwZ.g(-1500, valueOf);
            } else {
                this.AwZ.g(-200, null);
            }
        }
    }

    private void a(String str, String str2, int i, int i2, long j, av[] avVarArr, aw[] awVarArr, at atVar, boolean z, boolean z2) {
        Integer num;
        String str3;
        boolean z3;
        if (avVarArr == null) {
            com.tencent.pb.common.c.c.m("TalkRoomService", "printMembersLog members is null groupId: ", str, "  roomid: ", Integer.valueOf(i2), "  roomKey", Long.valueOf(j));
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            for (av avVar : avVarArr) {
                if (avVar != null) {
                    stringBuffer.append(" memberId:" + avVar.nJK + " uuid: " + avVar.zXO + " status: " + avVar.status + "   mem.inviteTime:" + avVar.zYH + "  mem.reason: " + avVar.aAk + "  mem.inviteuuid: " + avVar.zYT + "\n");
                }
            }
            com.tencent.pb.common.c.c.m("TalkRoomService", "printMembersLog groupId: ", str, "  romid: ", Integer.valueOf(i2), "  roomKey", Long.valueOf(j), "  members.length: ", Integer.valueOf(avVarArr.length), "  ", stringBuffer.toString());
        }
        c cIA = c.cIA();
        if (i == 0) {
            num = null;
        } else {
            num = Integer.valueOf(i);
        }
        boolean z4 = this.nqU != null && this.nqU.equals(str);
        com.tencent.pb.common.c.c.d("TalkRoomManager", "newOrUpdateGroup groupId: ", str, " isActive: ", Boolean.valueOf(z4));
        if (TextUtils.isEmpty(str)) {
            str3 = str2;
        } else {
            str3 = str;
        }
        if (TextUtils.isEmpty(str3)) {
            com.tencent.pb.common.c.c.m("TalkRoomManager", "newOrUpdateGroup invalid groupId");
            z3 = false;
        } else {
            if (j.acQ(str2)) {
                cIA.Awo.put(str2, str3);
            }
            TalkRoom talkRoom = (TalkRoom) cIA.Awn.get(str3);
            if (TextUtils.isEmpty(str2) || talkRoom == null || atVar == null || atVar.fws == 100) {
                TalkRoom talkRoom2;
                if (talkRoom == null) {
                    if (j.acQ(str2)) {
                        talkRoom2 = (TalkRoom) cIA.Awn.get(str2);
                    } else {
                        talkRoom2 = talkRoom;
                    }
                    if (talkRoom2 != null) {
                        cIA.Awn.put(str3, talkRoom2);
                    }
                } else {
                    talkRoom2 = talkRoom;
                }
                if (talkRoom2 != null && z4) {
                    int cIW = j.cIW();
                    long cIX = j.cIX();
                    com.tencent.pb.common.c.c.d("TalkRoomManager", "check current active group roomId: ", Integer.valueOf(cIW), " and roomKey: ", Long.valueOf(j));
                    if (cIW != 0 && cIW != i2) {
                        com.tencent.pb.common.c.c.m("TalkRoomManager", "diff roomId: ", Integer.valueOf(cIW), " -> ", Integer.valueOf(i2));
                        z3 = false;
                    } else if (!(0 == cIX || cIX == j)) {
                        com.tencent.pb.common.c.c.m("TalkRoomManager", "diff roomKey: ", Long.valueOf(cIX), " -> ", Long.valueOf(j));
                        z3 = false;
                    }
                }
                if (talkRoom2 == null) {
                    com.tencent.pb.common.c.c.d("TalkRoomManager", "newOrUpdateGroup create groupId: ", str3);
                    cIA.Awn.put(str3, TalkRoom.a(str3, str2, num, i2, j, atVar, avVarArr, awVarArr));
                } else {
                    com.tencent.pb.common.c.c.d("TalkRoomManager", "newOrUpdateGroup update groupId: ", str3);
                    TalkRoom.a(talkRoom2, str3, str2, num, i2, j, atVar, avVarArr, awVarArr);
                }
                if (cIA.Awp != null && z) {
                    cIA.Awp.g(cIA.acJ(str3));
                }
                c.cIB();
                z3 = true;
            } else {
                com.tencent.pb.common.c.c.m("TalkRoomManager", "newOrUpdateGroup clientGroupId is not empty , room is not null");
                z3 = false;
            }
        }
        String str4 = "TalkRoomService";
        Object[] objArr = new Object[16];
        objArr[0] = "engine handleVoiceGroupMemberChange";
        objArr[1] = str;
        objArr[2] = this.nqU;
        objArr[3] = Integer.valueOf(i2);
        objArr[4] = Integer.valueOf(this.nPD);
        objArr[5] = Long.valueOf(j);
        objArr[6] = Long.valueOf(this.AwJ);
        objArr[7] = Boolean.valueOf(z3);
        objArr[8] = " isCurrentRoom: ";
        objArr[9] = Boolean.valueOf(b(str, i2, j, false));
        objArr[10] = " members.length: ";
        objArr[11] = Integer.valueOf(avVarArr != null ? avVarArr.length : 0);
        objArr[12] = " isCallBackEngine: ";
        objArr[13] = Boolean.valueOf(z2);
        objArr[14] = " mFirstGetAudioData: ";
        objArr[15] = Boolean.valueOf(this.AwO);
        com.tencent.pb.common.c.c.d(str4, objArr);
        if (c.cIA().bu(this.nqU, false)) {
            com.tencent.pb.common.c.c.m("TalkRoomService", "handleVoiceGroupMemberChange isGroupActive mFirstGetAudioData: ", Boolean.valueOf(this.AwO), " mGroupId: ", this.nqU, " roomId: ", Integer.valueOf(i2));
            if (this.AwO) {
                this.AwO = false;
                this.nZr = true;
                this.Axb = k.cIY();
                this.AwM = this.AwK;
                if (this.AwX != null) {
                    com.tencent.pb.common.c.c.m("TalkRoomService", "refreashTalkingTime mTalkDurationTimerTask is null");
                } else {
                    com.tencent.pb.common.c.c.m("TalkRoomService", "refreashTalkingTime mTalkRoomTalkingCallBack: ", this.Awx, " mIsHoldOn: ", Boolean.valueOf(this.Axn));
                    this.AwX = new TimerTask() {
                        public final void run() {
                            if (!f.this.Axn) {
                                f.this.AwK = f.this.AwK + 1;
                                if (f.this.Axb) {
                                    f.this.AwM = f.this.AwM + 1;
                                }
                                if (f.this.AwQ == 3 || f.this.AwQ == 2) {
                                    f.this.AwL = f.this.AwL + 1;
                                    f.this.AwR.sCH = f.this.AwL;
                                }
                                f.this.AwR.Ayh = f.this.AwK * 1000;
                                f.this.AwR.sCG = f.this.AwK;
                            }
                            if (f.this.Awx != null) {
                                f fVar = f.this.Awx;
                                boolean z = f.this.Axn;
                                f.this.AwK;
                            }
                        }
                    };
                    this.AwY.scheduleAtFixedRate(this.AwX, 1000, 1000);
                }
            }
        }
        if (avVarArr != null && z2 && b(str, i2, j, false) && avVarArr.length > 0 && this.AwS != null) {
            a(avVarArr);
        }
    }

    private void a(av[] avVarArr) {
        if (avVarArr == null) {
            com.tencent.pb.common.c.c.m("TalkRoomService", "onMebersChangedToEngine members is null");
            return;
        }
        int[] iArr = new int[avVarArr.length];
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < avVarArr.length; i++) {
            iArr[i] = avVarArr[i].nJK;
            stringBuffer.append(avVarArr[i].nJK);
            stringBuffer.append(",");
        }
        com.tencent.pb.common.c.c.m("TalkRoomService", "engine handleVoiceGroupMemberChange engine.OnMembersChanged memberid: ", stringBuffer.toString());
        if (this.AwS == null) {
            com.tencent.pb.common.c.c.m("TalkRoomService", "onMebersChangedToEngine engine is null");
            return;
        }
        this.AwS.OnMembersChanged(iArr);
    }

    private void a(o[] oVarArr, o[] oVarArr2, int i) {
        String str = "TalkRoomService";
        Object[] objArr = new Object[2];
        objArr[0] = "handleRelayData addrs length: ";
        objArr[1] = Integer.valueOf(oVarArr == null ? 0 : oVarArr.length);
        com.tencent.pb.common.c.c.d(str, objArr);
        if (oVarArr != null && oVarArr.length > 0) {
            this.Axj = new int[oVarArr.length];
            this.Axi = new short[oVarArr.length];
            this.Axl = new int[oVarArr2.length];
            this.Axk = new short[oVarArr2.length];
            this.Axm = i;
            com.tencent.pb.common.c.c.m("TalkRoomService", "handleRelayData tcpStartTime: ", Integer.valueOf(this.Axm));
            int i2 = 0;
            for (o oVar : oVarArr) {
                this.Axj[i2] = oVar.zWB;
                this.Axi[i2] = (short) oVar.port;
                com.tencent.pb.common.c.c.m("TalkRoomService", "handleRelayData ip: ", Integer.valueOf(oVar.zWB), " addr.port: ", Integer.valueOf(oVar.port));
                i2++;
            }
            i2 = 0;
            for (o oVar2 : oVarArr2) {
                this.Axl[i2] = oVar2.zWB;
                this.Axk[i2] = (short) oVar2.port;
                com.tencent.pb.common.c.c.m("TalkRoomService", "handleRelayData tcpIp: ", Integer.valueOf(oVar2.zWB), " tcpAddr.port: ", Integer.valueOf(oVar2.port));
                i2++;
            }
            com.tencent.pb.common.c.c.d("TalkRoomService", "handleRelayData", Arrays.toString(this.Axj), Arrays.toString(this.Axi), this.nqU, this.nqU, Integer.valueOf(this.nPD), Long.valueOf(this.AwJ), Arrays.toString(this.Axl), Arrays.toString(this.Axk), Integer.valueOf(this.Axm));
        }
    }

    public final int bU(byte[] bArr) {
        com.tencent.pb.common.b.a.a.p pVar;
        try {
            pVar = (com.tencent.pb.common.b.a.a.p) com.google.a.a.e.a(new com.tencent.pb.common.b.a.a.p(), bArr, bArr.length);
        } catch (Exception e) {
            h.Jv(-1601);
            pVar = null;
        }
        if (pVar == null) {
            if (TextUtils.isEmpty(this.nqU) && TextUtils.isEmpty(this.AwI)) {
                h.a(this.nPD, this.AwJ, "notify", "pasrefail");
            } else {
                this.AwR.Q("notify", "pasrefail");
            }
            com.tencent.pb.common.c.c.m("TalkRoomService", "CLTNOT onVoiceGroupChange groupChg null");
            return -2;
        }
        Object obj;
        com.tencent.pb.common.c.c.m("TalkRoomService", "CLTNOT onVoiceGroupChange", this.nqU, Integer.valueOf(this.nPD), Long.valueOf(this.AwJ), Long.valueOf(pVar.frh), Integer.valueOf(pVar.zWC));
        long j = pVar.frh;
        if (this.Axe.contains(Long.valueOf(j))) {
            obj = 1;
        } else {
            this.Axe.add(Long.valueOf(j));
            obj = null;
        }
        if (obj != null) {
            com.tencent.pb.common.c.c.d("TalkRoomService", "CLTNOT onVoiceGroupChange isMsgDouble error");
            if (b(pVar.groupId, pVar.srH, pVar.srI, false)) {
                this.AwR.Q("notify", "repeat", String.valueOf(pVar.zWC));
            } else {
                h.a(pVar.groupId, pVar.srH, pVar.srI, "notify", "repeat", String.valueOf(pVar.zWC));
            }
            return -3;
        }
        if (b(pVar.groupId, pVar.srH, pVar.srI, false)) {
            this.AwR.Q("notify", "succ", String.valueOf(pVar.zWC));
        }
        int i;
        g gVar;
        byte[] bArr2;
        Runnable anonymousClass11;
        if (pVar.zWC == 4 || pVar.zWC == 2) {
            a(pVar.groupId, null, pVar.zWd, pVar.srH, pVar.srI, pVar.zWE, pVar.zWD, pVar.zWa, true, true);
        } else if (pVar.zWC == 16) {
            a(pVar.groupId, null, pVar.zWd, pVar.srH, pVar.srI, pVar.zWE, pVar.zWD, pVar.zWa, true, false);
        } else if (pVar.zWC == 1) {
            com.tencent.pb.common.c.c.m("TalkRoomService", "handlerCreateGroupChange groupChg.groupId: ", pVar.groupId, " roomId: ", Integer.valueOf(pVar.srH), " roomkey: ", Long.valueOf(pVar.srI));
            if (!com.tencent.pb.a.a.a.cDP()) {
                com.tencent.pb.common.c.c.m("TalkRoomService", "CLTNOT handlerCreateGroupChange isAuthed is false");
            } else if (bHa() && g.equals(pVar.groupId, this.nqU)) {
                com.tencent.pb.common.c.c.m("TalkRoomService", "CLTNOT handlerCreateGroupChange return is same groupId: ", this.nqU);
            } else {
                a(pVar.groupId, null, pVar.zWd, pVar.srH, pVar.srI, pVar.zWE, pVar.zWD, pVar.zWa, false, true);
                Object obj2 = pVar.groupId;
                i = pVar.srH;
                long j2 = pVar.srI;
                int i2 = pVar.zWd;
                int i3 = pVar.zWG;
                if (TextUtils.isEmpty(obj2)) {
                    com.tencent.pb.common.c.c.m("TalkRoomService", "CLTNOT ackTalkRoom groupId is null");
                } else {
                    boolean a = com.tencent.pb.common.b.e.cDx().a(new com.tencent.wecall.talkroom.a.a(obj2, i, j2, i2, i3));
                    com.tencent.pb.common.c.c.d("TalkRoomService", "CLTNOT ackTalkRoom groupId: ", obj2, Integer.valueOf(i), Long.valueOf(j2), Integer.valueOf(i3), Boolean.valueOf(a));
                }
                com.tencent.pb.common.c.c.m("TalkRoomService", "handlerCreateGroupChange start ui");
            }
        } else if (pVar.zWC == 8) {
            com.tencent.pb.common.c.c.m("TalkRoomService", "handleCancelCreateVoiceGroupChange groupChg.groupId: ", pVar.groupId, " mGroupId: ", this.nqU);
            if (b(pVar.groupId, pVar.srH, pVar.srI, false)) {
                a(pVar.groupId, null, pVar.zWd, pVar.srH, pVar.srI, pVar.zWE, pVar.zWD, pVar.zWa, true, false);
                a(pVar.groupId, pVar.srH, pVar.srI, false, false, true);
            } else {
                a(pVar.groupId, null, pVar.zWd, pVar.srH, pVar.srI, pVar.zWE, pVar.zWD, pVar.zWa, true, false);
            }
        } else if (pVar.zWC == FileUtils.S_IWUSR) {
            String str = "TalkRoomService";
            Object[] objArr = new Object[6];
            objArr[0] = "handleMemberWhisper groupChg.groupChg.groupId: ";
            objArr[1] = pVar.groupId;
            objArr[2] = " mGroupId: ";
            objArr[3] = this.nqU;
            objArr[4] = " groupChg.whisperBuf size: ";
            objArr[5] = Integer.valueOf(pVar.zWH == null ? 0 : pVar.zWH.length);
            com.tencent.pb.common.c.c.d(str, objArr);
            gVar = this.AwZ;
            Runnable anonymousClass17 = new AnonymousClass17(pVar.groupId, pVar.zWH);
            if (Looper.myLooper() == Looper.getMainLooper()) {
                anonymousClass17.run();
            } else {
                gVar.handler.post(anonymousClass17);
            }
        } else if (pVar.zWC == 256) {
            if (!b(pVar.groupId, pVar.srH, pVar.srI, false)) {
                com.tencent.pb.common.c.c.m("TalkRoomService", "handleVideoMember is not same room ", pVar.groupId, Integer.valueOf(pVar.srH));
            } else if (pVar.zWH == null) {
                com.tencent.pb.common.c.c.m("TalkRoomService", "handleVideoMember whisperBuf is null", pVar.groupId, Integer.valueOf(pVar.srH));
            } else {
                r rVar;
                try {
                    bArr2 = pVar.zWH;
                    rVar = (r) com.google.a.a.e.a(new r(), bArr2, bArr2.length);
                } catch (com.google.a.a.d e2) {
                    com.tencent.pb.common.c.c.m("TalkRoomService", "handleVideoMember ", e2);
                    rVar = null;
                }
                if (rVar == null || rVar.zWL == null) {
                    com.tencent.pb.common.c.c.m("TalkRoomService", "handleVideoMember notify is null", pVar.groupId, Integer.valueOf(pVar.srH));
                } else {
                    List arrayList = new ArrayList();
                    for (Object obj3 : rVar.zWL) {
                        if (obj3 != null) {
                            arrayList.add(obj3);
                        }
                    }
                    com.tencent.pb.common.c.c.d("TalkRoomService", "handleVideoMember groupid: ", this.nqU, " roomId: ", Integer.valueOf(this.nPD), " videoUserNames: ", arrayList);
                    gVar = this.AwZ;
                    anonymousClass11 = new AnonymousClass11(arrayList);
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        anonymousClass11.run();
                    } else {
                        gVar.handler.post(anonymousClass11);
                    }
                }
            }
        } else if (pVar.zWC == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            if (!b(pVar.groupId, pVar.srH, pVar.srI, false)) {
                com.tencent.pb.common.c.c.m("TalkRoomService", "handleOtherDevice is not same room ", pVar.groupId, Integer.valueOf(pVar.srH));
            } else if (!(this.state == 3 || this.state == 4)) {
                b(pVar.groupId, pVar.srH, pVar.srI, 1);
                this.AwZ.g(-1400, null);
            }
        } else if (pVar.zWC == WXMediaMessage.TITLE_LENGTH_LIMIT) {
            if (!b(pVar.groupId, pVar.srH, pVar.srI, false)) {
                com.tencent.pb.common.c.c.m("TalkRoomService", "handleVideoSubscribes is not same room ", pVar.groupId, Integer.valueOf(pVar.srH));
            } else if (pVar.zWH == null) {
                com.tencent.pb.common.c.c.m("TalkRoomService", "handleVideoSubscribes whisperBuf is null", pVar.groupId, Integer.valueOf(pVar.srH));
            } else {
                q qVar;
                try {
                    bArr2 = pVar.zWH;
                    qVar = (q) com.google.a.a.e.a(new q(), bArr2, bArr2.length);
                } catch (com.google.a.a.d e22) {
                    com.tencent.pb.common.c.c.m("TalkRoomService", "handleVideoSubscribes ", e22);
                    qVar = null;
                }
                if (qVar == null) {
                    com.tencent.pb.common.c.c.m("TalkRoomService", "handleVideoMember notify is null", pVar.groupId, Integer.valueOf(pVar.srH));
                } else {
                    g gVar2 = this.AwZ;
                    anonymousClass11 = new com.tencent.wecall.talkroom.model.g.AnonymousClass1(qVar.zWK);
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        anonymousClass11.run();
                    } else {
                        gVar2.handler.post(anonymousClass11);
                    }
                }
            }
        }
        return 0;
    }

    public final void cIM() {
        h hVar = this.AwR;
        com.tencent.pb.common.c.c.d(h.TAG, "reset");
        hVar.Ays = 0;
        hVar.Ayr = 0;
        hVar.Ayq = 0;
        hVar.groupId = "";
        hVar.zVY = "";
        hVar.suu = 1;
        hVar.nJe = 0;
        hVar.nJf = 0;
        hVar.nJK = -1;
        hVar.sCt = 0;
        hVar.sCA = 0;
        hVar.sCw = 0;
        hVar.nKB = 0;
        hVar.Ayd = 0;
        hVar.Aye = 0;
        hVar.Ayf = 0;
        hVar.Ayg = 0;
        hVar.Ayh = 0;
        hVar.Ayi = 0;
        hVar.Ayj = 0;
        hVar.Ayk = 0;
        hVar.sCB = 0;
        hVar.nKA = 0;
        hVar.sCG = 0;
        hVar.sCH = 0;
        hVar.netType = -1;
        hVar.Ayl = 0;
        hVar.Aym = 0;
        hVar.Ayn = "";
        hVar.deviceModel = "";
        hVar.Ayo = -1;
        hVar.sCM = "";
        hVar.Ayp.setLength(0);
        hVar.suI = -1;
        hVar.suB = 0;
        hVar.sux = 0;
        hVar.suy = 0;
    }

    private void a(String str, int i, long j, boolean z) {
        a(str, i, j, z, true, true);
    }

    public final void a(String str, int i, long j, boolean z, boolean z2, boolean z3) {
        com.tencent.pb.common.c.c.m("TalkRoomService", "closeVoiceGroup groupId: ", str, " mGroupId: ", this.nqU, " roomId: ", Integer.valueOf(i), " mRoomId: ", Integer.valueOf(this.nPD), " roomKey: ", Long.valueOf(j), " mRoomKey: ", Long.valueOf(this.AwJ));
        try {
            TalkRoom acE = c.cIA().acE(str);
            if (acE == null) {
                com.tencent.pb.common.c.c.m("TalkRoomManager", "handleRoomExit assert failed: current TalkRoom MUST exists");
            } else {
                d acD = acE.acD(com.tencent.pb.a.a.a.cDO());
                if (acD != null) {
                    acD.Awq.status = 20;
                    acD.Awq.nJK = -1;
                }
                String str2 = "tagorewang:TalkRoom";
                Object[] objArr = new Object[2];
                objArr[0] = "resetRoomTempInfo groupId: ";
                objArr[1] = acE.zZC == null ? "" : acE.zZC;
                com.tencent.pb.common.c.c.d(str2, objArr);
                c.cIB();
            }
        } catch (Throwable th) {
            com.tencent.pb.common.c.c.m("TalkRoomManager", "handleRoomExit: ", th);
        }
        if (z) {
            h(str, i, j);
        }
        this.Awz.remove(str);
        if (b(str, i, j, false)) {
            com.tencent.pb.common.c.c.d("TalkRoomService", "closeVoiceGroup isCurrentRoom groupId: ", str, " roomId: ", Integer.valueOf(i), " roomKey: ", Long.valueOf(j));
            og(true);
            g gVar = this.AwZ;
            Runnable anonymousClass8 = new com.tencent.wecall.talkroom.model.g.AnonymousClass8(str, z2);
            if (Looper.myLooper() == Looper.getMainLooper()) {
                anonymousClass8.run();
            } else {
                gVar.handler.post(anonymousClass8);
            }
        }
        if (z3) {
            MultiTalkGroup acJ = c.cIA().acJ(str);
            if (acJ != null) {
                this.AwZ.g(acJ);
            }
        }
    }

    public final boolean bHa() {
        com.tencent.pb.common.c.c.m("TalkRoomService", "state: ", Integer.valueOf(this.state));
        if (this.state != 0) {
            return true;
        }
        return false;
    }

    public final e acK(String str) {
        return (e) this.Awz.get(str);
    }

    public final boolean acL(String str) {
        return ((e) this.Awz.get(str)) != null;
    }

    private void cIN() {
        com.tencent.pb.common.c.c.m("TalkRoomService", "hello timer start~~");
        if (this.AwU != null) {
            com.tencent.pb.common.c.c.m("TalkRoomService", "dealWithInit enter talkroom not first time");
            return;
        }
        try {
            this.AwU = new TimerTask() {
                public final void run() {
                    if (f.this.nPD == 0 || f.this.nqU == null) {
                        com.tencent.pb.common.c.c.m("TalkRoomService", "talkNoopTimer error: roomId %d, talkUsername %s", Integer.valueOf(f.this.nPD), f.this.nqU);
                        f.this.cIP();
                        return;
                    }
                    f.a(f.this, f.j(f.this));
                }
            };
            this.AwW.schedule(this.AwU, 0, (long) AwF);
        } catch (Exception e) {
            com.tencent.pb.common.c.c.m("TalkRoomService", "startNooper: ", e);
        }
    }

    private void cIO() {
        try {
            com.tencent.pb.common.c.c.m("TalkRoomService", "cancelHelloTimeOutTask");
            if (this.AwV != null) {
                this.AwV.cancel();
            }
        } catch (Exception e) {
            com.tencent.pb.common.c.c.m("TalkRoomService", "cancelHelloTimeOutTask: ", e);
        }
        this.AwV = null;
    }

    private void cIP() {
        try {
            com.tencent.pb.common.c.c.m("TalkRoomService", "cancelHelloTimerTask");
            if (this.AwU != null) {
                this.AwU.cancel();
            }
        } catch (Exception e) {
            com.tencent.pb.common.c.c.m("TalkRoomService", "cancelHelloTimerTask: ", e);
        }
        this.AwU = null;
    }

    private void a(int i, av[] avVarArr, as asVar, byte[] bArr, boolean z, String str, int i2, long j, int i3, int i4, byte[] bArr2) {
        Exception e;
        final int i5;
        final av[] avVarArr2;
        final as asVar2;
        final byte[] bArr3;
        final boolean z2;
        final String str2;
        final int i6;
        final long j2;
        final int i7;
        final int i8;
        final byte[] bArr4;
        com.tencent.pb.common.c.c.d("TalkRoomService", "dealWithInit", Integer.valueOf(i), str, Integer.valueOf(i2), Long.valueOf(j), Integer.valueOf(this.state));
        if (this.AwS != null) {
            boolean z3;
            try {
                if (this.state != 4) {
                    com.tencent.pb.common.c.c.m("TalkRoomService", "dealWithInit state is error: ", Integer.valueOf(this.state));
                    z3 = false;
                } else {
                    z3 = a(avVarArr, asVar, bArr, z, i2, j, i3, i4, bArr2);
                }
                try {
                    com.tencent.pb.common.c.c.m("TalkRoomService", "dealWithInit ret: ", Boolean.valueOf(z3));
                } catch (Exception e2) {
                    e = e2;
                    com.tencent.pb.common.c.c.m("TalkRoomService", "dealWithInit ", e);
                    if (z3) {
                        return;
                    }
                    if (i > 0) {
                        i5 = i;
                        avVarArr2 = avVarArr;
                        asVar2 = asVar;
                        bArr3 = bArr;
                        z2 = z;
                        str2 = str;
                        i6 = i2;
                        j2 = j;
                        i7 = i3;
                        i8 = i4;
                        bArr4 = bArr2;
                        this.mHandler.postDelayed(new Runnable() {
                            public final void run() {
                                f.this.a(i5 - 1, avVarArr2, asVar2, bArr3, z2, str2, i6, j2, i7, i8, bArr4);
                            }
                        }, 50);
                    }
                    this.AwR.Jz(202);
                    com.tencent.pb.common.c.c.m("TalkRoomService", "exitTalkRoom dealWithInit fail");
                    a(str, i2, j, 102, true);
                    this.AwZ.g(-400, null);
                    return;
                }
            } catch (Exception e3) {
                e = e3;
                z3 = false;
            }
            if (z3) {
                return;
            }
        }
        if (i > 0) {
            this.AwR.Jz(202);
            com.tencent.pb.common.c.c.m("TalkRoomService", "exitTalkRoom dealWithInit fail");
            a(str, i2, j, 102, true);
            this.AwZ.g(-400, null);
            return;
        }
        i5 = i;
        avVarArr2 = avVarArr;
        asVar2 = asVar;
        bArr3 = bArr;
        z2 = z;
        str2 = str;
        i6 = i2;
        j2 = j;
        i7 = i3;
        i8 = i4;
        bArr4 = bArr2;
        this.mHandler.postDelayed(/* anonymous class already generated */, 50);
    }

    final boolean bFC() {
        int yw;
        com.tencent.pb.common.c.c.d("TalkRoomService", "initEngine", this.nqU, Integer.valueOf(this.nPD), Long.valueOf(this.AwJ), Integer.valueOf(this.state));
        try {
            b bVar = this.AwS;
            if (com.tencent.pb.common.a.a.zUT) {
                int i;
                String absolutePath = com.tencent.pb.common.c.d.syL.getDir("lib", 0).getAbsolutePath();
                com.tencent.pb.talkroom.sdk.e eVar = zVE;
                if (eVar != null) {
                    yw = eVar.yw();
                } else {
                    yw = 0;
                }
                com.tencent.pb.common.c.c.d("simon:TalkRoomContext", "protocalInit netType:", Integer.valueOf(k.iO(com.tencent.pb.common.c.d.syL)), " cpuFlag:", Integer.valueOf(yw), "libPath:", absolutePath);
                yw = bVar.Awk.init(r6, yw, absolutePath + "/");
                absolutePath = "simon:TalkRoomContext";
                Object[] objArr = new Object[4];
                objArr[0] = "protocalInit";
                objArr[1] = Integer.valueOf(yw);
                objArr[2] = "field_capInfo length: ";
                if (bVar.Awk.field_capInfo == null) {
                    i = 0;
                } else {
                    i = bVar.Awk.field_capInfo.length;
                }
                objArr[3] = Integer.valueOf(i);
                com.tencent.pb.common.c.c.d(absolutePath, objArr);
            } else {
                yw = 0;
            }
        } catch (Exception e) {
            com.tencent.pb.common.c.c.m("TalkRoomService", "initEngine", e);
            yw = QbSdk.EXTENSION_INIT_FAILURE;
        }
        if (yw >= 0) {
            return true;
        }
        h.Jy(-3001);
        this.AwR.Jz(201);
        this.AwS = null;
        com.tencent.pb.common.c.c.m("TalkRoomService", "initEngine engine.protocalInit error", Integer.valueOf(yw));
        return false;
    }

    public final void oh(boolean z) {
        try {
            vj();
            cIL();
            if (z) {
                cIQ();
                aUx();
            }
            com.tencent.pb.common.c.c.m("TalkRoomService", "setRecordDevActive active: ", Boolean.valueOf(z));
        } catch (Throwable th) {
            com.tencent.pb.common.c.c.m("TalkRoomService", "setRecordDevActive active: ", Boolean.valueOf(z), th);
        }
    }

    private void aUx() {
        vj();
        int b = b(talk.oLp, talk.oLq, new com.tencent.pb.talkroom.sdk.c() {
            public final void R(byte[] bArr, int i) {
                try {
                    if (f.this.AwH) {
                        if (f.this.mIsMute) {
                            for (int i2 = 0; i2 < bArr.length; i2++) {
                                bArr[i2] = (byte) 0;
                            }
                        }
                        if (f.this.AwH) {
                            b c = f.this.AwS;
                            short s = (short) i;
                            if (com.tencent.pb.common.a.a.zUT) {
                                c.Awk.SendAudio(bArr, s, 0);
                            }
                            if (f.this.Axg) {
                                f.this.Axg = false;
                                com.tencent.pb.common.c.c.m("TalkRoomService", "onRecPcmDataCallBack len: ", Integer.valueOf(i));
                            }
                        }
                    }
                } catch (Exception e) {
                    com.tencent.pb.common.c.c.m("TalkRoomService", "initMediaComponent record", e);
                }
            }
        });
        if (b <= 0) {
            this.AwR.Jz(101);
            h.Jw(-2001);
            this.AwZ.g(-500, null);
        }
        h hVar;
        if (b > 0) {
            hVar = this.AwR;
            hVar.Ayd &= -2;
        } else {
            hVar = this.AwR;
            hVar.Ayd |= 1;
        }
        com.tencent.pb.common.c.c.m("TalkRoomService", "audioAdapter startRecord ret: ", Integer.valueOf(b));
    }

    private void cIQ() {
        cIL();
        final AtomicInteger atomicInteger = new AtomicInteger();
        final AtomicInteger atomicInteger2 = new AtomicInteger();
        if (b(talk.oLp, talk.oLq, new com.tencent.pb.talkroom.sdk.b() {
            public final int Q(byte[] bArr, int i) {
                if (!f.this.AwH) {
                    return 0;
                }
                try {
                    int GetAudioData = !com.tencent.pb.common.a.a.zUT ? 1 : f.this.AwS.Awk.GetAudioData(bArr, (short) i, atomicInteger, atomicInteger2);
                    if (f.this.Axh && GetAudioData >= 0) {
                        f.this.Axh = false;
                        com.tencent.pb.common.c.c.m("TalkRoomService", "onPlayPcmDataCallBack len: ", Integer.valueOf(i), " ret: ", Integer.valueOf(GetAudioData));
                    }
                    return GetAudioData;
                } catch (Exception e) {
                    com.tencent.pb.common.c.c.m("TalkRoomService", "initMediaComponent play", e);
                    return -1;
                }
            }
        }) <= 0) {
            this.AwR.Jz(101);
            h.Jw(-2001);
            h hVar = this.AwR;
            hVar.Ayd |= 1;
            this.AwZ.g(-500, null);
        }
        com.tencent.pb.common.c.c.m("TalkRoomService", "audioAdapter startPlayer ret: ", Integer.valueOf(r0));
    }

    private boolean a(av[] avVarArr, as asVar, byte[] bArr, boolean z, int i, long j, int i2, int i3, byte[] bArr2) {
        int[] iArr;
        int i4;
        int i5;
        com.tencent.pb.common.c.c.d("TalkRoomService", "connectToCompenent myRoomMemId roomid:", Integer.valueOf(i), " roomKey: ", Long.valueOf(j), " groupId: ", this.nqU, " ip: ", Arrays.toString(this.Axj), " ports: ", Arrays.toString(this.Axi), " tcpIp: ", Arrays.toString(this.Axl), " tcpPorts: ", Arrays.toString(this.Axk), " tcpStartTime: ", Integer.valueOf(this.Axm));
        String cDO = com.tencent.pb.a.a.a.cDO();
        int i6 = -1;
        if (avVarArr == null || avVarArr.length <= 0) {
            iArr = null;
            i4 = -1;
        } else {
            int[] iArr2 = new int[avVarArr.length];
            for (i5 = 0; i5 < avVarArr.length; i5++) {
                iArr2[i5] = avVarArr[i5].nJK;
                if (g.equals(avVarArr[i5].zXO, cDO)) {
                    i6 = avVarArr[i5].nJK;
                }
            }
            iArr = iArr2;
            i4 = i6;
        }
        int acF = c.cIA().acF(this.nqU);
        this.AwR.nJK = i4;
        try {
            int i7;
            b bVar = this.AwS;
            com.tencent.mm.plugin.multi.talk.a aVar = this.AwT;
            TalkRoom acE = c.cIA().acE(this.nqU);
            if (acE == null) {
                com.tencent.pb.common.c.c.m("TalkRoomManager", "getMyUuid TalkRoom is null  groupId: ", r3);
                i7 = 0;
            } else {
                d acD = acE.acD(com.tencent.pb.a.a.a.cDO());
                if (acD == null) {
                    com.tencent.pb.common.c.c.m("TalkRoomManager", "getMyUuid talkRoomMember is null  groupId: ", r3);
                    i7 = 0;
                } else {
                    av avVar = acD.Awq;
                    if (avVar == null) {
                        com.tencent.pb.common.c.c.m("TalkRoomManager", "getMyUuid voiceGroupMem is null  groupId: ", r3);
                        i7 = 0;
                    } else {
                        com.tencent.pb.common.c.c.d("TalkRoomManager", "getMyUuid groupId: ", r3, " uuid: ", Integer.valueOf(avVar.vJp));
                        i7 = avVar.vJp;
                    }
                }
            }
            int[] iArr3 = this.Axj;
            short[] sArr = this.Axi;
            int[] iArr4 = this.Axl;
            short[] sArr2 = this.Axk;
            int i8 = this.Axm;
            com.tencent.pb.common.c.c.d("simon:TalkRoomContext", "Open");
            i iVar = null;
            if (asVar != null) {
                iVar = new i(asVar.zXZ, asVar.hvV, asVar.hvW, asVar.zYa, asVar.zYb, asVar.zYc, asVar.zYd, asVar.zYe, asVar.zYf, asVar.zYg, asVar.zYh, asVar.zYi);
            } else {
                com.tencent.pb.common.c.c.m("simon:TalkRoomContext", "voiceConf is null");
            }
            i5 = bVar.Awk.Open(aVar, iVar, i7, i4, i, j, iArr3, sArr, 0, iArr, bArr, z, k.iO(com.tencent.pb.common.c.d.syL), iArr4, sArr2, i8, i2, i3, bArr2);
        } catch (Throwable th) {
            com.tencent.pb.common.c.c.m("TalkRoomService", "connectToCompenent", th);
            i5 = QbSdk.EXTENSION_INIT_FAILURE;
        }
        g gVar = this.AwZ;
        Runnable anonymousClass2 = new com.tencent.wecall.talkroom.model.g.AnonymousClass2(i5);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            anonymousClass2.run();
        } else {
            gVar.handler.post(anonymousClass2);
        }
        com.tencent.pb.common.c.c.d("TalkRoomService", "connectToCompenent ret =", Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(acF));
        if (i5 < 0) {
            h.Jy(-3002);
        }
        if (i5 == 0) {
            this.AwR.sCw = 1;
        }
        if (i5 == 0) {
            return true;
        }
        return false;
    }

    private boolean b(String str, int i, long j, boolean z) {
        if (z) {
            return g.ga(str, this.nqU);
        }
        com.tencent.pb.common.c.c.m("TalkRoomService", "isCurrentRoom groupId: ", str, " mGroupId: ", this.nqU, "roomId: ", Integer.valueOf(i), " mRoomId: ", Integer.valueOf(this.nPD), " roomKey: ", Long.valueOf(j), " mRoomKey: ", Long.valueOf(this.AwJ));
        if (g.ga(str, this.nqU) && i == this.nPD && j == this.AwJ) {
            return true;
        }
        return false;
    }

    private void h(String str, int i, long j) {
        String str2 = null;
        try {
            c cIA = c.cIA();
            if (i == 0 && j == 0) {
                com.tencent.pb.common.c.c.m("TalkRoomManager", "getMsgKeyByGroupId roomId and roomKey is 0,groupId: ", str);
            } else {
                TalkRoom acE = cIA.acE(str);
                if (acE == null) {
                    com.tencent.pb.common.c.c.m("TalkRoomManager", "getMsgKeyByGroupId talkRoom is null,groupId: ", str);
                } else {
                    d acD = acE.acD(com.tencent.pb.a.a.a.cDO());
                    if (acD == null) {
                        com.tencent.pb.common.c.c.m("TalkRoomManager", "getMsgKeyByGroupId talkRoomMember is null,groupId: ", str);
                    } else {
                        av avVar = acD.Awq;
                        if (avVar == null) {
                            com.tencent.pb.common.c.c.m("TalkRoomManager", "getMsgKeyByGroupId voiceGroupMem is null,groupId: ", str);
                        } else {
                            StringBuffer stringBuffer = new StringBuffer();
                            stringBuffer.append(str);
                            stringBuffer.append(",");
                            stringBuffer.append(i);
                            stringBuffer.append(",");
                            stringBuffer.append(j);
                            stringBuffer.append(",");
                            stringBuffer.append(avVar.zYJ);
                            com.tencent.pb.common.c.c.m("TalkRoomManager", "getMsgKeyByGroupId msgKey is", stringBuffer.toString());
                            str2 = stringBuffer.toString();
                        }
                    }
                }
            }
            com.tencent.pb.common.c.c.m("TalkRoomService", "addCallLog groupId: ", str, " mIsOutCall: ", Boolean.valueOf(this.srZ), " mTalkDuration: ", Integer.valueOf(this.AwK), " msgKey: ", str2);
        } catch (Throwable th) {
            com.tencent.pb.common.c.c.m("TalkRoomService", "handleRoomExit: ", th);
        }
    }

    public final boolean ak(String str, int i, int i2) {
        com.tencent.pb.common.c.c.m("TalkRoomService", "finishCurrentTalk groupId: ", str, " rejectReason: ", Integer.valueOf(i), " exitReason: ", Integer.valueOf(i2));
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (i == 1 || i2 == 100) {
            h hVar = this.AwR;
            com.tencent.pb.common.c.c.d(h.TAG, "endCancelCreate", Long.valueOf(System.currentTimeMillis() - hVar.Ayq), Long.valueOf(hVar.Ayf));
            if (hVar.Ayf <= 0) {
                hVar.sCA = 1;
                if (hVar.Ayq == 0) {
                    hVar.sCB = 0;
                } else {
                    hVar.sCB = System.currentTimeMillis() - hVar.Ayq;
                }
            }
        }
        int i3 = this.nPD;
        long j = this.AwJ;
        int i4 = a.cIo().state;
        if (j.acQ(str)) {
            this.AwR.Jz(327);
            return a.cIo().dO(str, 1000);
        } else if (i4 == 2) {
            return a.cIo().b(str, i3, j, i);
        } else {
            Integer[] numArr = new Integer[]{Integer.valueOf(102), Integer.valueOf(103), Integer.valueOf(104), Integer.valueOf(105), Integer.valueOf(106), Integer.valueOf(107), Integer.valueOf(108)};
            List arrayList = new ArrayList();
            for (i4 = 0; i4 < 7; i4++) {
                arrayList.add(numArr[i4]);
            }
            arrayList.contains(Integer.valueOf(i2));
            return a.cIo().a(str, i3, j, i2, true);
        }
    }

    public final void dM(String str, int i) {
        if (!g.equals("GLOBAL_TOPIC_NETWORK_CHANGE", str) || !bHa()) {
            return;
        }
        if (this.nZr || this.AwH) {
            switch (i) {
                case 21:
                    switch (k.iO(com.tencent.pb.common.c.d.syL)) {
                        case 4:
                            this.Axb = true;
                            break;
                        default:
                            this.Axb = false;
                            break;
                    }
                    if (this.nPD == 0 || this.AwJ == 0) {
                        com.tencent.pb.common.c.c.m("TalkRoomService", "sendRedirect mRoomId valid(session ended)");
                        return;
                    }
                    com.tencent.pb.common.c.c.m("TalkRoomService", "sendRedirect", this.nqU, Integer.valueOf(this.nPD));
                    this.AwR.cIU();
                    boolean a = com.tencent.pb.common.b.e.cDx().a(new com.tencent.wecall.talkroom.a.h(this.nqU, this.nPD, this.AwJ, c.cIA().acF(this.nqU)));
                    this.AwR.Q("redirect", "req", String.valueOf(a), String.valueOf(this.state));
                    com.tencent.pb.common.c.c.m("TalkRoomService", "sendRedirect ret: ", Boolean.valueOf(a));
                    return;
                case 33:
                    b bVar = this.AwS;
                    int iO = k.iO(com.tencent.pb.common.c.d.syL);
                    if (com.tencent.pb.common.a.a.zUT) {
                        bVar.Awk.onNetworkChange(iO);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private static boolean Jt(int i) {
        return i != 1;
    }

    private void a(String str, int i, long j, String str2) {
        this.nPD = i;
        this.AwJ = j;
        this.nqU = str2;
        this.AwI = str;
    }

    public static boolean xX() {
        boolean isSpeakerphoneOn;
        try {
            isSpeakerphoneOn = ((AudioManager) com.tencent.pb.common.c.d.syL.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).isSpeakerphoneOn();
        } catch (Exception e) {
            com.tencent.pb.common.c.c.m("TalkRoomService", "isSpeakerOn ", e);
            isSpeakerphoneOn = false;
        }
        com.tencent.pb.common.c.c.d("TalkRoomService", "isSpeakerOn ret: ", Boolean.valueOf(isSpeakerphoneOn));
        return isSpeakerphoneOn;
    }

    public static void a(com.tencent.pb.talkroom.sdk.e eVar) {
        zVE = eVar;
    }

    public static com.tencent.pb.talkroom.sdk.e cIR() {
        return zVE;
    }
}
