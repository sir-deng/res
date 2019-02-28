package com.tencent.mm.plugin.voip.ui;

import android.annotation.SuppressLint;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.compatible.b.f;
import com.tencent.mm.f.a.ih;
import com.tencent.mm.f.a.ja;
import com.tencent.mm.j.g;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetSetting;
import com.tencent.mm.plugin.appbrand.jsapi.share.h;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiGetGameCommInfo;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.bd;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver;
import com.tencent.mm.plugin.voip.model.e;
import com.tencent.mm.plugin.voip.model.j;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.m;
import com.tencent.mm.plugin.voip.model.n;
import com.tencent.mm.plugin.voip.ui.d.d;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.base.MMSuperAlert;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.y.as;
import com.tencent.mm.y.q;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

@a(3)
@SuppressLint({"SimpleDateFormat"})
public class VideoActivity extends MMActivity implements b, d, SensorController.a {
    private String gBJ;
    private ag jQE;
    private boolean mIsMute = false;
    private int mStatus;
    private boolean msk = false;
    private CaptureView srU;
    private x srY;
    private boolean srZ;
    private boolean ssa;
    private int sse = 1;
    private d svS;
    private WeakReference<c> svT;
    private SensorController svU;
    private long svV = -1;
    private long svW = 0;
    private boolean svX = false;
    private int svY = 1;
    private boolean svZ = false;
    private boolean swa = false;
    private c swb = new c<ja>() {
        {
            this.xmG = ja.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            if (((ja) bVar) instanceof ja) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VideoActivity", "summerkick LogoutEvent thread name[%s]", Thread.currentThread().getName());
                ah.y(new Runnable() {
                    public final void run() {
                        if (VideoActivity.this.svT != null && VideoActivity.this.svT.get() != null) {
                            boolean bHA = ((c) VideoActivity.this.svT.get()).bHA();
                            boolean bHz = ((c) VideoActivity.this.svT.get()).bHz();
                            boolean bHt = ((c) VideoActivity.this.svT.get()).bHt();
                            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VideoActivity", "summerkick LogoutEvent ret[%b, %b, %b]", Boolean.valueOf(bHA), Boolean.valueOf(bHz), Boolean.valueOf(bHt));
                        }
                    }
                });
            }
            return false;
        }
    };
    private TelephonyManager swc = null;
    private long swd;

    static /* synthetic */ void a(VideoActivity videoActivity, int i) {
        int i2;
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.Voip.VideoActivity", "getHintByErrorCode " + i);
        if (i == 235) {
            i2 = R.l.eVu;
        } else if (i == 233) {
            com.tencent.mm.plugin.voip.model.d.bGT().bIe();
            i2 = R.l.eVt;
        } else {
            i2 = i == bd.CTRL_BYTE ? (!com.tencent.mm.aq.b.PZ() || videoActivity.ssa) ? R.l.eVv : R.l.eVx : i == JsApiGetSetting.CTRL_INDEX ? R.l.eVH : i == h.CTRL_INDEX ? R.l.eVw : 0;
        }
        if (i2 != 0 || videoActivity.svS == null) {
            if (i2 == 0) {
                i2 = R.l.eVs;
            }
            MMSuperAlert.i(videoActivity, R.l.dGZ, i2);
            return;
        }
        videoActivity.svS.cr(videoActivity.getString(R.l.eVs), -1);
    }

    public void onCreate(Bundle bundle) {
        Object obj;
        Bundle bundle2;
        boolean a;
        super.onCreate(bundle);
        if (!com.tencent.mm.plugin.voip.b.d.dE(this.mController.xRr)) {
            com.tencent.mm.plugin.voip.b.d.dF(this.mController.xRr);
        }
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VideoActivity", "VideoActivity onCreate start");
        getSupportActionBar().hide();
        getWindow().setSoftInputMode(3);
        getWindow().addFlags(6815872);
        if (as.Hp()) {
            com.tencent.mm.plugin.voip.model.d.bGT().B(false, false);
        }
        this.jQE = new ag();
        PBool pBool = new PBool();
        PBool pBool2 = new PBool();
        PString pString = new PString();
        PInt pInt = new PInt();
        pString.value = getIntent().getStringExtra("Voip_User");
        pBool.value = getIntent().getBooleanExtra("Voip_Outcall", true);
        pBool2.value = getIntent().getBooleanExtra("Voip_VideoCall", true);
        this.swd = getIntent().getLongExtra("Voip_LastPage_Hash", 0);
        pInt.value = com.tencent.mm.plugin.voip.b.b.E(pBool.value, pBool2.value);
        if (pBool.value) {
            try {
                if (bdl()) {
                    Toast.makeText(this, R.l.epG, 0).show();
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VideoActivity", "this phone is on a call");
                    super.finish();
                    return;
                }
            } catch (Exception e) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.Voip.VideoActivity", "not ready now!");
            }
        }
        m bGT = com.tencent.mm.plugin.voip.model.d.bGT();
        if (bGT.ssZ != null) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VoipService", "voipMgr is not null");
            pString.value = bGT.ssZ.gBJ;
            pBool.value = bGT.ssZ.srZ;
            pBool2.value = bGT.ssZ.ssa;
            pInt.value = bGT.ssZ.srQ.mState;
        } else {
            if (pString.value == null) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.Voip.VoipService", "username is null, can't start voip");
                obj = null;
            } else if (pBool.value || bGT.ssY.bHa()) {
                String str;
                j jVar;
                List F;
                com.tencent.mm.plugin.voip.video.j jVar2;
                IntentFilter intentFilter;
                bGT.ssZ = new j();
                f.a aVar = bGT.ssZ;
                String str2 = pString.value;
                boolean z = pBool.value;
                boolean z2 = pBool2.value;
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VoipMgr", "start VoIP, userName: %s, isOutCall: %b, isVideoCall: %b", str2, Boolean.valueOf(z), Boolean.valueOf(z2));
                aVar.sss = true;
                aVar.gBJ = str2;
                aVar.srZ = z;
                aVar.ssa = z2;
                as.Hm();
                aVar.srY = com.tencent.mm.y.c.Ff().Xv(aVar.gBJ);
                aVar.jQE = new ag();
                aVar.ssb = bi.getInt(g.Af().getValue("VOIPCameraSwitch"), 1) == 0;
                if (!aVar.ssa) {
                    aVar.ssb = false;
                }
                int E = com.tencent.mm.plugin.voip.b.b.E(z, z2);
                if (aVar.ssb) {
                    if (E == 0) {
                        E = 1;
                    } else if (256 == E) {
                        E = 257;
                    }
                }
                if (z) {
                    aVar.srQ = com.tencent.mm.plugin.voip.b.b.zi(E);
                } else {
                    aVar.srQ = com.tencent.mm.plugin.voip.b.b.zh(E);
                }
                boolean zf = com.tencent.mm.compatible.f.b.zf();
                boolean zh = com.tencent.mm.compatible.f.b.zh();
                if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
                    com.tencent.mm.plugin.report.service.g gVar;
                    Object[] objArr;
                    if (!zf) {
                        gVar = com.tencent.mm.plugin.report.service.g.pWK;
                        objArr = new Object[2];
                        objArr[0] = Integer.valueOf(aVar.ssa ? 0 : 1);
                        objArr[1] = Integer.valueOf(1);
                        gVar.h(11306, objArr);
                    }
                    if (!zh) {
                        gVar = com.tencent.mm.plugin.report.service.g.pWK;
                        objArr = new Object[2];
                        objArr[0] = Integer.valueOf(aVar.ssa ? 0 : 1);
                        objArr[1] = Integer.valueOf(0);
                        gVar.h(11306, objArr);
                    }
                }
                if (!(zh && zf)) {
                    String str3 = null;
                    str = null;
                    if (!zf && !zh) {
                        str3 = getString(R.l.dGV);
                        str = getString(R.l.dFV);
                    } else if (!zf) {
                        str3 = getString(R.l.dGX);
                        str = getString(R.l.dFW);
                    } else if (!zh) {
                        str3 = getString(R.l.dGW);
                        str = getString(R.l.dFX);
                    }
                    com.tencent.mm.ui.base.h.a((Context) this, str3, str, getString(R.l.dFY), true, new com.tencent.mm.plugin.voip.model.j.AnonymousClass11(this));
                }
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VoipMgr", "initMgr");
                as.uy().wI();
                as.Hn().b(aVar);
                as.Hn().a(aVar);
                as.Hn().xP();
                aVar.flO = new com.tencent.mm.compatible.util.b(ad.getContext());
                aVar.flO.requestFocus();
                if (aVar.ssa) {
                    com.tencent.mm.plugin.voip.model.d.bGT().a(true, true, aVar.gBJ);
                } else {
                    com.tencent.mm.plugin.voip.model.d.bGT().a(true, false, aVar.gBJ);
                }
                if (aVar.srZ) {
                    com.tencent.mm.plugin.voip.model.d.bGT().ssY.bIm();
                    if ((aVar.ssa ? com.tencent.mm.plugin.voip.model.d.bGT().ssY.cq(aVar.srY.field_username, 0) : com.tencent.mm.plugin.voip.model.d.bGT().ssY.cq(aVar.srY.field_username, 1)) < 0) {
                        aVar.fD(false);
                    }
                }
                aVar.srR = new HeadsetPlugReceiver();
                aVar.srR.a(ad.getContext(), aVar.ssy);
                m bGT2 = com.tencent.mm.plugin.voip.model.d.bGT();
                Context context = ad.getContext();
                n nVar = bGT2.ssY;
                nVar.soQ.kgx = context;
                nVar.soQ.sqk = aVar;
                com.tencent.mm.plugin.voip.b.a.eB("MicroMsg.Voip.VoipServiceEx", "attach ui........");
                aVar.nHI = (TelephonyManager) ad.getContext().getSystemService("phone");
                aVar.nHI.listen(aVar.nHJ, 32);
                com.tencent.mm.plugin.voip.model.d.bGT().k(R.k.dAv, aVar.ssa ? 0 : 1, aVar.srZ);
                f.a jVar3;
                if (as.Hn().xY()) {
                    E = 3;
                    jVar3 = aVar;
                } else if (as.Hn().xS()) {
                    E = 4;
                    jVar3 = aVar;
                } else if (aVar.ssa) {
                    E = 1;
                    jVar3 = aVar;
                } else {
                    E = 2;
                    jVar3 = aVar;
                }
                jVar3.sse = E;
                if (aVar.ssa) {
                    aVar.ssh = true;
                } else {
                    aVar.ssh = false;
                }
                str2 = "voip_recent_contact" + q.FY();
                SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("voip_plugin_prefs", 0);
                str = sharedPreferences.getString(str2, null);
                if (str != null) {
                    F = bi.F(str.split(";"));
                    if (F != null) {
                        int size = F.size();
                        if (F.contains(aVar.gBJ)) {
                            if (size > 1) {
                                F.remove(aVar.gBJ);
                            }
                            sharedPreferences.edit().putString(str2, bi.d(F, ";")).commit();
                            com.tencent.mm.sdk.b.a.xmy.b(aVar.ssz);
                            com.tencent.mm.sdk.b.a.xmy.b(aVar.nHK);
                            jVar2 = aVar.ssl;
                            if (!jVar2.kCL.contains(aVar)) {
                                jVar2.kCL.add(aVar);
                            }
                            intentFilter = new IntentFilter();
                            intentFilter.addAction("android.intent.action.SCREEN_ON");
                            intentFilter.addAction("android.intent.action.SCREEN_OFF");
                            intentFilter.addAction("android.intent.action.USER_PRESENT");
                            ad.getContext().registerReceiver(aVar.ssx, intentFilter);
                        } else if (4 == size) {
                            F.remove(size - 1);
                        }
                        F.add(0, aVar.gBJ);
                        sharedPreferences.edit().putString(str2, bi.d(F, ";")).commit();
                        com.tencent.mm.sdk.b.a.xmy.b(aVar.ssz);
                        com.tencent.mm.sdk.b.a.xmy.b(aVar.nHK);
                        jVar2 = aVar.ssl;
                        if (jVar2.kCL.contains(aVar)) {
                            jVar2.kCL.add(aVar);
                        }
                        intentFilter = new IntentFilter();
                        intentFilter.addAction("android.intent.action.SCREEN_ON");
                        intentFilter.addAction("android.intent.action.SCREEN_OFF");
                        intentFilter.addAction("android.intent.action.USER_PRESENT");
                        ad.getContext().registerReceiver(aVar.ssx, intentFilter);
                    }
                }
                F = new ArrayList();
                F.add(0, aVar.gBJ);
                sharedPreferences.edit().putString(str2, bi.d(F, ";")).commit();
                com.tencent.mm.sdk.b.a.xmy.b(aVar.ssz);
                com.tencent.mm.sdk.b.a.xmy.b(aVar.nHK);
                jVar2 = aVar.ssl;
                if (jVar2.kCL.contains(aVar)) {
                    jVar2.kCL.add(aVar);
                }
                intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                intentFilter.addAction("android.intent.action.USER_PRESENT");
                ad.getContext().registerReceiver(aVar.ssx, intentFilter);
            } else {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.Voip.VoipService", "is out call, but kenerl is not working");
                l.a(pString.value, pBool2.value ? au.xHC : au.xHB, pBool.value ? 1 : 0, 4, ad.getContext().getString(R.l.eUw));
                obj = null;
            }
            if (obj != null) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.Voip.VideoActivity", "unable to init VoipMgr");
                super.finish();
            }
            this.svT = new WeakReference(obj);
            this.gBJ = pString.value;
            this.ssa = pBool2.value;
            this.srZ = pBool.value;
            this.mStatus = pInt.value;
            as.Hm();
            this.srY = com.tencent.mm.y.c.Ff().Xv(this.gBJ);
            bundle2 = new Bundle();
            bundle2.putString("key_username", this.srY.field_username);
            bundle2.putBoolean("key_isoutcall", this.srZ);
            bundle2.putInt("key_status", com.tencent.mm.plugin.voip.b.b.E(this.srZ, this.ssa));
            if (com.tencent.mm.plugin.voip.b.b.zk(this.mStatus)) {
                this.svS = new f();
            } else {
                this.svS = new e();
            }
            this.svS.setArguments(bundle2);
            getSupportFragmentManager().aT().b(R.h.cXt, this.svS).commit();
            setTitleVisibility(8);
            if (com.tencent.mm.plugin.voip.b.b.zl(this.mStatus) && this.srZ) {
                this.jQE.postDelayed(new Runnable() {
                    public final void run() {
                        if (com.tencent.mm.plugin.voip.b.b.zl(VideoActivity.this.mStatus) && !VideoActivity.this.msk && VideoActivity.this.svS != null) {
                            VideoActivity.this.svS.cr(VideoActivity.this.getString(R.l.eUJ), 10000);
                        }
                    }
                }, 20000);
            }
            this.svS.a((c) this.svT.get());
            this.svS.a((d) this);
            this.svS.zc(this.sse);
            this.svS.setMute(this.mIsMute);
            if (com.tencent.mm.plugin.voip.model.d.bGT().ssZ.ssw != null) {
                Ni(com.tencent.mm.plugin.voip.model.d.bGT().ssZ.ssw);
            }
            this.svU = new SensorController(this.mController.xRr);
            if (!(this.svT == null || this.svT.get() == null)) {
                ((c) this.svT.get()).a(this, 1);
            }
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VideoActivity", "VideoActivity onCreate end isOutCall:%b isVideoCall:%b username:%s state:%d", Boolean.valueOf(this.srZ), Boolean.valueOf(this.ssa), this.gBJ, Integer.valueOf(this.mStatus));
            if (this.svU != null) {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.Voip.VideoActivity", "onCreate setSensorCallBack");
                this.svU.a(this);
            }
            if (com.tencent.mm.plugin.voip.b.b.zk(this.mStatus)) {
                a = com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.RECORD_AUDIO", 82, "", "");
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VideoActivity", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(a), bi.chl(), this);
            } else {
                a = com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.CAMERA", 19, "", "");
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VideoActivity", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(a), bi.chl(), this);
                a = com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.RECORD_AUDIO", 19, "", "");
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VideoActivity", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(a), bi.chl(), this);
            }
            com.tencent.mm.sdk.b.a.xmy.b(this.swb);
            return;
        }
        obj = bGT.ssZ;
        if (obj != null) {
            this.svT = new WeakReference(obj);
            this.gBJ = pString.value;
            this.ssa = pBool2.value;
            this.srZ = pBool.value;
            this.mStatus = pInt.value;
            as.Hm();
            this.srY = com.tencent.mm.y.c.Ff().Xv(this.gBJ);
            bundle2 = new Bundle();
            bundle2.putString("key_username", this.srY.field_username);
            bundle2.putBoolean("key_isoutcall", this.srZ);
            bundle2.putInt("key_status", com.tencent.mm.plugin.voip.b.b.E(this.srZ, this.ssa));
            if (com.tencent.mm.plugin.voip.b.b.zk(this.mStatus)) {
                this.svS = new f();
            } else {
                this.svS = new e();
            }
            this.svS.setArguments(bundle2);
            getSupportFragmentManager().aT().b(R.h.cXt, this.svS).commit();
            setTitleVisibility(8);
            this.jQE.postDelayed(/* anonymous class already generated */, 20000);
            this.svS.a((c) this.svT.get());
            this.svS.a((d) this);
            this.svS.zc(this.sse);
            this.svS.setMute(this.mIsMute);
            if (com.tencent.mm.plugin.voip.model.d.bGT().ssZ.ssw != null) {
                Ni(com.tencent.mm.plugin.voip.model.d.bGT().ssZ.ssw);
            }
            this.svU = new SensorController(this.mController.xRr);
            ((c) this.svT.get()).a(this, 1);
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VideoActivity", "VideoActivity onCreate end isOutCall:%b isVideoCall:%b username:%s state:%d", Boolean.valueOf(this.srZ), Boolean.valueOf(this.ssa), this.gBJ, Integer.valueOf(this.mStatus));
            if (this.svU != null) {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.Voip.VideoActivity", "onCreate setSensorCallBack");
                this.svU.a(this);
            }
            if (com.tencent.mm.plugin.voip.b.b.zk(this.mStatus)) {
                a = com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.RECORD_AUDIO", 82, "", "");
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VideoActivity", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(a), bi.chl(), this);
            } else {
                a = com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.CAMERA", 19, "", "");
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VideoActivity", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(a), bi.chl(), this);
                a = com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.RECORD_AUDIO", 19, "", "");
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VideoActivity", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(a), bi.chl(), this);
            }
            com.tencent.mm.sdk.b.a.xmy.b(this.swb);
            return;
        }
        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.Voip.VideoActivity", "unable to init VoipMgr");
        super.finish();
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
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VideoActivity", "TelephoneManager.callState is %d", Integer.valueOf(r2));
                return z;
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            z = false;
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.Voip.VideoActivity", "get callState error , errMsg is %s", e.getLocalizedMessage());
            return z;
        }
    }

    protected final int getForceOrientation() {
        return 1;
    }

    private void bHF() {
        this.jQE.postDelayed(new Runnable() {
            public final void run() {
                VideoActivity.this.finish();
            }
        }, 2000);
    }

    public final void dU(int i, int i2) {
        this.mStatus = i2;
        if (1 != this.svY && i2 != 8 && i2 != 262) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VideoActivity", "activity is not normal, can't transform");
        } else if (this.svS == null) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VideoActivity", "mBaseFragment is null ,already close,now return.");
        } else {
            this.svS.dU(i, i2);
            switch (i2) {
                case 1:
                case 3:
                case 7:
                case 257:
                case 261:
                    if (this.svS == null || !(this.svS instanceof f)) {
                        if (this.svS != null) {
                            this.svS.uninit();
                            getSupportFragmentManager().aT().a(this.svS).commit();
                            this.svS = null;
                        }
                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VideoActivity", "switch to voice fragment");
                        Bundle bundle = new Bundle();
                        bundle.putString("key_username", this.srY.field_username);
                        bundle.putBoolean("key_isoutcall", this.srZ);
                        bundle.putInt("key_status", this.mStatus);
                        this.svS = new f();
                        this.svS.setArguments(bundle);
                        this.svS.a((c) this.svT.get());
                        this.svS.fg(this.svV);
                        this.svS.a((d) this);
                        this.svS.zc(this.sse);
                        this.svS.setMute(this.mIsMute);
                        this.svS.b(this.srU);
                        getSupportFragmentManager().aT().b(R.h.cXt, this.svS).commit();
                        return;
                    }
                    return;
                case 8:
                case 262:
                    switch (i) {
                        case 4098:
                            this.jQE.postDelayed(new Runnable() {
                                public final void run() {
                                    VideoActivity.this.bHF();
                                }
                            }, 50);
                            break;
                        case 4099:
                            if (this.srZ) {
                                this.svS.cr(this.ssa ? getString(R.l.eWh) : getString(R.l.eUr), -1);
                            }
                            bHF();
                            break;
                        case 4103:
                        case 4104:
                            bHF();
                            break;
                        case 4106:
                            this.jQE.post(new Runnable() {
                                public final void run() {
                                    if (VideoActivity.this.svS != null) {
                                        VideoActivity.this.svS.cr(VideoActivity.this.getString(R.l.eWa), -1);
                                    }
                                    VideoActivity.this.bHF();
                                }
                            });
                            break;
                        case 4107:
                            finish();
                            break;
                        case 4109:
                            this.jQE.post(new Runnable() {
                                public final void run() {
                                    VideoActivity.this.bHF();
                                }
                            });
                            break;
                    }
                    bHF();
                    return;
                default:
                    return;
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            return true;
        }
        if (i == 25) {
            if (com.tencent.mm.plugin.voip.model.d.bGT().bIf() || this.srZ) {
                as.Hn().fA(as.Hn().xS() ? as.Hn().ye() : aUy());
            } else {
                com.tencent.mm.plugin.voip.model.d.bGT().stopRing();
            }
            return true;
        } else if (i != 24) {
            return super.onKeyDown(i, keyEvent);
        } else {
            if (com.tencent.mm.plugin.voip.model.d.bGT().bIf() || this.srZ) {
                as.Hn().fz(as.Hn().xS() ? as.Hn().ye() : aUy());
            } else {
                com.tencent.mm.plugin.voip.model.d.bGT().stopRing();
            }
            return true;
        }
    }

    protected void onDestroy() {
        this.svY = 4;
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VideoActivity", "onDestroy, status: %s", com.tencent.mm.plugin.voip.b.b.zg(this.mStatus));
        if (!this.swa) {
            finish();
        }
        if (this.svU != null && this.svU.xqv) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.Voip.VideoActivity", "onDestroy removeSensorCallBack");
            setScreenEnable(true);
            this.svU.cgS();
        }
        if (!(this.svT == null || this.svT.get() == null)) {
            ((c) this.svT.get()).a(this);
        }
        com.tencent.mm.sdk.b.a.xmy.c(this.swb);
        this.svU = null;
        super.onDestroy();
    }

    protected void onStop() {
        this.svY = 2;
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VideoActivity", "onStop, status: %s", com.tencent.mm.plugin.voip.b.b.zg(this.mStatus));
        super.onStop();
        if (262 != this.mStatus && 8 != this.mStatus && this.svZ && !this.swa && this.svT != null && this.svT.get() != null && ((c) this.svT.get()).jm(false)) {
            D(false, true);
            if (com.tencent.mm.plugin.voip.b.b.zj(this.mStatus)) {
                com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pWK;
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(com.tencent.mm.plugin.voip.b.b.zk(this.mStatus) ? 2 : 3);
                objArr[1] = Integer.valueOf(2);
                gVar.h(11618, objArr);
            }
        }
    }

    public void onStart() {
        super.onStart();
        if (!this.swa) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VideoActivity", "onStart");
            this.svY = 1;
            dU(Downloads.RECV_BUFFER_SIZE, this.mStatus);
        }
    }

    public void finish() {
        boolean z;
        this.svY = 3;
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VideoActivity", "finish, finishBczMinimize: %b, status: %s", Boolean.valueOf(this.svX), com.tencent.mm.plugin.voip.b.b.zg(this.mStatus));
        if (!(this.svX || !com.tencent.mm.plugin.voip.b.b.zj(this.mStatus) || 4 == this.svY)) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VideoActivity", "finish VideoActivity, start ChattingUI");
            Intent intent = new Intent();
            intent.addFlags(67108864);
            intent.putExtra("Chat_User", this.gBJ);
            com.tencent.mm.plugin.voip.a.a.ihN.e(intent, (Context) this);
        }
        if (this.svU != null) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.Voip.VideoActivity", "removeSensorCallBack");
            setScreenEnable(true);
            this.svU.cgS();
            this.svU = null;
        }
        if (this.svS != null) {
            if (this.svS.swl == 4105) {
                z = true;
            } else {
                z = false;
            }
            this.svS.uninit();
            this.svS = null;
        } else {
            z = false;
        }
        this.svT = null;
        this.srU = null;
        this.swa = true;
        super.finish();
        b ihVar;
        if (z) {
            ihVar = new ih();
            ihVar.fzE.fzH = true;
            ihVar.fzE.fzG = this.swd;
            com.tencent.mm.sdk.b.a.xmy.m(ihVar);
            return;
        }
        ihVar = new ih();
        ihVar.fzE.fzH = false;
        ihVar.fzE.fzG = 0;
        com.tencent.mm.sdk.b.a.xmy.m(ihVar);
    }

    protected void onNewIntent(Intent intent) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VideoActivity", "onNewIntent");
        super.onNewIntent(intent);
    }

    public void onPause() {
        boolean z;
        super.onPause();
        PowerManager powerManager = (PowerManager) ad.getContext().getSystemService("power");
        boolean inKeyguardRestrictedInputMode = ((KeyguardManager) ad.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode();
        boolean hasWindowFocus = hasWindowFocus();
        boolean isScreenOn = powerManager.isScreenOn();
        if ((hasWindowFocus || !inKeyguardRestrictedInputMode) && isScreenOn) {
            z = true;
        } else {
            z = false;
        }
        this.svZ = z;
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VideoActivity", "onPause, status: %s, screenOn: %b, hasWindowFocus: %s, isScreenLocked: %s, isScreenOn: %s", com.tencent.mm.plugin.voip.b.b.zg(this.mStatus), Boolean.valueOf(this.svZ), Boolean.valueOf(hasWindowFocus), Boolean.valueOf(inKeyguardRestrictedInputMode), Boolean.valueOf(isScreenOn));
    }

    public void onResume() {
        int i = 0;
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VideoActivity", "onResume, status: %s", com.tencent.mm.plugin.voip.b.b.zg(this.mStatus));
        as.getNotification().cancel(40);
        e eVar = com.tencent.mm.plugin.voip.model.d.bGT().ssY.soQ;
        if (eVar.spV) {
            eVar.spV = false;
        }
        super.onResume();
        setScreenEnable(true);
        this.svW = bi.Wz();
        if (this.srZ && com.tencent.mm.plugin.voip.b.b.zl(this.mStatus) && com.tencent.mm.plugin.voip.model.d.bGT().bIf()) {
            if (!this.ssa) {
                i = 1;
            }
            com.tencent.mm.plugin.voip.model.d.bGT().k(R.k.dAv, i, this.srZ);
        }
    }

    public final void a(byte[] bArr, long j, int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.svS != null) {
            this.svS.a(bArr, j, i, i2, i3, i4, i5, i6);
        }
    }

    public final void aP(final int i, String str) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VideoActivity", "onError, errCode:%d, isVideoCall:%s", Integer.valueOf(i), Boolean.valueOf(this.ssa));
        this.msk = true;
        if (i == GameJsApiGetGameCommInfo.CTRL_BYTE) {
            com.tencent.mm.ui.base.h.b(this, str, null, true);
        } else {
            this.jQE.post(new Runnable() {
                public final void run() {
                    VideoActivity.a(VideoActivity.this, i);
                }
            });
        }
    }

    public final void Ni(final String str) {
        if (this.svS != null) {
            this.jQE.post(new Runnable() {
                public final void run() {
                    if (VideoActivity.this.svS != null) {
                        VideoActivity.this.svS.Ni(str);
                    }
                }
            });
        }
    }

    protected final int getLayoutId() {
        return R.i.dtW;
    }

    public final void dX(boolean z) {
        if (bi.Wz() - this.svW < 500) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.Voip.VideoActivity", "onSensorEvent time interval too small");
        } else if ((this.srZ || com.tencent.mm.plugin.voip.b.b.zj(this.mStatus)) && !com.tencent.mm.plugin.voip.b.b.zk(this.mStatus)) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.Voip.VideoActivity", "onSensorEvent, isOn: " + z);
            setScreenEnable(z);
        }
    }

    protected final void dealContentView(View view) {
        ae.c(ae.a(getWindow(), null), this.mController.xRd);
        ((ViewGroup) getWindow().getDecorView()).addView(view, 0);
    }

    private int aUy() {
        int bGR;
        if (com.tencent.mm.plugin.voip.b.b.zj(this.mStatus)) {
            bGR = com.tencent.mm.plugin.voip.model.d.bGT().bGR();
        } else {
            bGR = as.Hn().xS() ? 0 : 2;
            if (this.srZ) {
                if (this.ssa) {
                    bGR = 3;
                    if (com.tencent.mm.compatible.e.q.gHG.gEU >= 0) {
                        bGR = com.tencent.mm.compatible.e.q.gHG.gEU;
                    }
                } else if (com.tencent.mm.compatible.e.q.gHG.gEX >= 0) {
                    bGR = com.tencent.mm.compatible.e.q.gHG.gEX;
                } else {
                    bGR = 0;
                }
            }
            if (!as.Hn().xS() && com.tencent.mm.compatible.e.q.gHG.gEZ >= 0) {
                bGR = com.tencent.mm.compatible.e.q.gHG.gEZ;
            }
        }
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.Voip.VideoActivity", "Current StreamType:%d", Integer.valueOf(bGR));
        return bGR;
    }

    public final void zc(int i) {
        this.sse = i;
        if (this.svS != null) {
            this.svS.zc(i);
        }
    }

    public final void setMute(boolean z) {
        this.mIsMute = z;
        if (this.svS != null) {
            this.svS.setMute(z);
        }
    }

    public final void b(int i, int i2, int[] iArr) {
        if (this.svS != null) {
            this.svS.b(i, i2, iArr);
        }
    }

    public final void bHJ() {
        if (this.svS != null) {
            this.svS.bHJ();
        }
    }

    public final Context bIK() {
        return this.mController.xRr;
    }

    public final void uninit() {
        if (this.svS != null) {
            this.svS.uninit();
        }
    }

    public final void ff(long j) {
        this.svV = j;
        if (this.svS != null) {
            this.svS.fg(this.svV);
        }
    }

    public final void bIL() {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.Voip.VideoActivity", "tryShowNetStatusWarning");
        if (this.svS != null) {
            this.svS.bIM();
        }
    }

    public final void aVo() {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.Voip.VideoActivity", "dismissNetStatusWarning");
        if (this.svS != null) {
            this.svS.bIN();
        }
    }

    public final void D(boolean z, boolean z2) {
        this.svX = z2;
        if (z) {
            bHF();
        } else {
            finish();
        }
    }

    public final void a(CaptureView captureView) {
        this.srU = captureView;
        if (this.svS != null) {
            this.svS.b(captureView);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (strArr == null || strArr.length == 0 || iArr == null || iArr.length == 0) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.Voip.VideoActivity", "onRequestPermissionsResult %d data is invalid", Integer.valueOf(i));
            return;
        }
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Voip.VideoActivity", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 19:
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.h.a((Context) this, getString("android.permission.CAMERA".equals(strArr[0]) ? R.l.ezZ : R.l.eAd), getString(R.l.eAg), getString(R.l.esG), getString(R.l.cancel), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            VideoActivity.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                }
                return;
            case 82:
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.h.a((Context) this, getString(R.l.eAd), getString(R.l.eAg), getString(R.l.esG), getString(R.l.cancel), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            VideoActivity.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, null);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
