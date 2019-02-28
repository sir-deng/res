package com.tencent.mm.plugin.facedetect.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.ad.k;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.plugin.facedetect.a.h;
import com.tencent.mm.plugin.facedetect.b.d;
import com.tencent.mm.plugin.facedetect.c.e;
import com.tencent.mm.plugin.facedetect.model.FaceContextData;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.model.o;
import com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMFragmentActivity;
import java.lang.ref.WeakReference;
import java.security.InvalidParameterException;
import java.util.ArrayList;

@com.tencent.mm.ui.base.a(3)
public class FaceDetectPrepareUI extends MMFragmentActivity implements android.support.v4.app.a.a, e {
    private String gBJ;
    private boolean hpb = false;
    private boolean jsh = false;
    private String mAppId;
    private int mkx;
    private d mky = null;
    private long mlO;
    private boolean mpA = false;
    private com.tencent.mm.plugin.facedetect.c.a mpl = null;
    private a mpm = null;
    private b mpn = null;
    private boolean mpo;
    private byte[] mpp;
    private boolean mpq = false;
    private boolean mpr = false;
    private b mps;
    private boolean mpt = false;
    private boolean mpu = false;
    private String mpv = null;
    private long mpw = -1;
    private Messenger mpx = null;
    private a mpy = null;
    private int mpz = -1;

    private static class a extends Handler {
        private WeakReference<FaceDetectPrepareUI> moH;

        /* synthetic */ a(FaceDetectPrepareUI faceDetectPrepareUI, byte b) {
            this(faceDetectPrepareUI);
        }

        private a(FaceDetectPrepareUI faceDetectPrepareUI) {
            this.moH = null;
            this.moH = new WeakReference(faceDetectPrepareUI);
        }

        public final void handleMessage(Message message) {
            x.i("MicroMsg.FaceDetectPrepareUI", "alvinluo client msg.what: %d", Integer.valueOf(message.what));
            if (this.moH != null && this.moH.get() != null) {
                switch (message.what) {
                    case 0:
                        FaceDetectPrepareUI.a((FaceDetectPrepareUI) this.moH.get(), message);
                        return;
                    case 1:
                        FaceDetectPrepareUI.b((FaceDetectPrepareUI) this.moH.get(), message);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    private class b {
        int errCode;
        int errType;
        Bundle extras;
        String foE;

        private b() {
        }

        /* synthetic */ b(FaceDetectPrepareUI faceDetectPrepareUI, byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.ui.FaceDetectPrepareUI$4 */
    class AnonymousClass4 implements Runnable {
        final /* synthetic */ com.tencent.mm.plugin.facedetect.ui.a.b moL;
        final /* synthetic */ boolean mpC = true;

        AnonymousClass4(boolean z, com.tencent.mm.plugin.facedetect.ui.a.b bVar) {
            this.moL = bVar;
        }

        public final void run() {
            FaceDetectPrepareUI.this.a(true, this.mpC, this.moL);
        }
    }

    private interface c {
        void i(int i, int i2, String str);
    }

    static /* synthetic */ void a(FaceDetectPrepareUI faceDetectPrepareUI, Message message) {
        x.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onInitDone result: %d", Integer.valueOf(message.arg1));
        if (message.arg1 != 0) {
            faceDetectPrepareUI.agx();
            return;
        }
        x.i("MicroMsg.FaceDetectPrepareUI", "alvinluo start FaceDetectUI");
        faceDetectPrepareUI.mpz = 2;
        Intent intent = new Intent(faceDetectPrepareUI, FaceDetectUI.class);
        intent.putExtra("k_user_name", faceDetectPrepareUI.gBJ);
        intent.putExtra("k_server_scene", faceDetectPrepareUI.mkx);
        intent.putExtra("k_need_signature", faceDetectPrepareUI.mpo);
        intent.putExtra("k_bio_id", faceDetectPrepareUI.mlO);
        intent.putExtra("k_bio_config", faceDetectPrepareUI.mpp);
        x.v("MicroMsg.FaceDetectPrepareUI", "alvinluo FaceDetectReporter info: %s", Long.valueOf(FaceDetectReporter.aHr().mmh));
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_parcelable_reporter", FaceDetectReporter.aHr());
        intent.putExtra("key_reporter_bundle", bundle);
        if (faceDetectPrepareUI.mpm != null) {
            a aVar = faceDetectPrepareUI.mpm;
            if (a.moI != null) {
                a.moI.cancel();
            }
            aVar.moC.setVisibility(4);
            aVar.moy.setVisibility(4);
            aVar.moD.setVisibility(4);
            aVar.moB.setVisibility(4);
            aVar.moA.setVisibility(4);
        }
        faceDetectPrepareUI.startActivityForResult(intent, 1);
    }

    static /* synthetic */ boolean a(FaceDetectPrepareUI faceDetectPrepareUI, long j, byte[] bArr) {
        FaceContextData.aHa().mlO = j;
        Bundle bundle = new Bundle();
        bundle.putString("k_bio_id", String.valueOf(j));
        bundle.putByteArray("k_bio_config", bArr);
        bundle.putInt("k_server_scene", faceDetectPrepareUI.mkx);
        bundle.putParcelable("k_ontext_data", FaceContextData.aHa());
        faceDetectPrepareUI.j(0, bundle);
        return true;
    }

    static /* synthetic */ void b(FaceDetectPrepareUI faceDetectPrepareUI, Message message) {
        Bundle data = message.getData();
        if (data == null) {
            faceDetectPrepareUI.aHQ();
        } else if (data.getInt("key_face_result_code", -1) != 0) {
            faceDetectPrepareUI.aHQ();
        } else {
            faceDetectPrepareUI.mpz = 3;
            final String string = data.getString("key_face_result_file_path");
            if (string != null) {
                com.tencent.mm.sdk.f.e.post(new Runnable() {
                    public final void run() {
                        try {
                            FaceDetectPrepareUI.this.mpl.Ap(string);
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.FaceDetectPrepareUI", e, "", new Object[0]);
                        }
                    }
                }, "face_upload");
            }
        }
    }

    static /* synthetic */ int pT(int i) {
        if (i == 1 || i == 2) {
            return 3;
        }
        if (i == 4) {
            return 2;
        }
        return i != 0 ? 4 : i;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(g.mju);
        getWindow().addFlags(2097280);
        this.mAppId = getIntent().getStringExtra("k_app_id");
        this.gBJ = getIntent().getStringExtra("k_user_name");
        this.mkx = getIntent().getIntExtra("k_server_scene", -1);
        this.mpo = getIntent().getBooleanExtra("k_need_signature", false);
        boolean z = com.tencent.mm.plugin.facedetect.model.e.aHc() || getIntent().getBooleanExtra("key_is_need_video", false);
        this.mpt = z;
        this.mpv = getIntent().getStringExtra("key_feedback_url");
        this.mpy = new a();
        this.mpx = new Messenger(this.mpy);
        Intent intent = new Intent(this, FaceDetectProcessService.class);
        intent.putExtra("k_messenger", this.mpx);
        startService(intent);
        FaceContextData.a(new FaceContextData());
        o.p(this);
        int i = com.tencent.mm.plugin.facedetect.c.b.mlr;
        this.mpl = com.tencent.mm.plugin.facedetect.c.b.a(this, this, this.mkx, getIntent().getExtras());
        if (this.mpl == null) {
            agx();
        } else {
            this.mpl.a(new com.tencent.mm.plugin.facedetect.b.c() {
                public final void e(long j, byte[] bArr) {
                    x.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onGetConfigSuccess, bioId: %d, isCancel: %b", Long.valueOf(j), Boolean.valueOf(FaceDetectPrepareUI.this.hpb));
                    if (!FaceDetectPrepareUI.this.hpb) {
                        FaceDetectPrepareUI.this.mlO = j;
                        FaceDetectPrepareUI.this.mpp = bArr;
                        FaceDetectPrepareUI.a(FaceDetectPrepareUI.this, j, bArr);
                    }
                }

                public final void ae(int i, String str) {
                    x.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onGetConfigFailed, errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(90015), str);
                    FaceDetectPrepareUI.this.b(FaceDetectPrepareUI.pT(i), 90015, str, FaceDetectPrepareUI.this.getString(h.mjK));
                }
            });
            this.mky = new d() {
                private double mpF = 0.0d;

                public final void l(double d) {
                    x.i("MicroMsg.FaceDetectPrepareUI", "hy: reg on process : %f", Double.valueOf(d));
                    this.mpF = 100.0d * d;
                }

                public final void a(int i, int i2, int i3, String str) {
                    x.i("MicroMsg.FaceDetectPrepareUI", "onError scene: %d, errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
                    FaceDetectPrepareUI.this.b(i2, i3, str, FaceDetectPrepareUI.this.getString(h.mkm));
                }

                public final void a(int i, int i2, String str, Bundle bundle) {
                    x.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onUploadEnd");
                    int pT = FaceDetectPrepareUI.pT(0);
                    if (pT != 0) {
                        FaceDetectPrepareUI.this.g(pT, 0, str, bundle);
                    }
                    if (FaceDetectPrepareUI.this.mpl != null) {
                        FaceDetectPrepareUI.this.mpl.d(pT, 0, str, bundle);
                    }
                }

                public final void h(int i, int i2, String str, k kVar) {
                    x.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onVerifyEnd sceneType: %d, errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2), str);
                    int pT = FaceDetectPrepareUI.pT(i);
                    if (!(pT == 0 && i2 == 0)) {
                        FaceDetectPrepareUI.this.g(pT, i2, str, null);
                    }
                    if (FaceDetectPrepareUI.this.mpl != null) {
                        FaceDetectPrepareUI.this.mpl.h(pT, i2, str, kVar);
                    }
                }
            };
            this.mpl.a(this.mky);
        }
        if (this.mps != null) {
            b bVar = this.mps;
            bVar.errType = -1;
            bVar.errCode = -1;
            bVar.foE = "";
            if (bVar.extras != null) {
                bVar.extras.clear();
            }
        }
        this.mpq = false;
        if (this.mkx == 2 || this.mkx == 5) {
            if (com.tencent.mm.kernel.g.Dq().Db().getBoolean(com.tencent.mm.storage.w.a.USERINFO_FACE_SHOW_TUTORIAL_BOOLEAN_SYNC, false)) {
                z = false;
            }
            z = true;
        } else {
            if (this.mkx != 3 && this.mkx == 4) {
                z = false;
            }
            z = true;
        }
        if (z) {
            x.i("MicroMsg.FaceDetectPrepareUI", "hy: need tutorial. show tutorial first");
            this.mpn = new b();
            this.mpz = 0;
            b bVar2 = this.mpn;
            if (this == null) {
                throw new InvalidParameterException("hy: tutorial context is null");
            }
            bVar2.lzm = findViewById(com.tencent.mm.plugin.facedetect.a.e.mjc);
            bVar2.moC = (Button) bVar2.lzm.findViewById(com.tencent.mm.plugin.facedetect.a.e.csO);
            bVar2.xS = (ViewPager) bVar2.lzm.findViewById(com.tencent.mm.plugin.facedetect.a.e.cCs);
            bVar2.mqr = new b(getSupportFragmentManager());
            bVar2.xS.a(bVar2.mqr);
            bVar2.moC.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    if (b.this.mqs != null) {
                        b.this.mqs.onCancel();
                    }
                    b.this.dismiss();
                }
            });
            ViewPager viewPager = bVar2.xS;
            com.tencent.mm.plugin.facedetect.ui.b.AnonymousClass2 anonymousClass2 = new ViewPager.e() {
                public final void a(int i, float f, int i2) {
                }

                public final void ae(int i) {
                    if (b.this.xS.getParent() != null) {
                        b.this.xS.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                }

                public final void af(int i) {
                }
            };
            if (viewPager.zn == null) {
                viewPager.zn = new ArrayList();
            }
            viewPager.zn.add(anonymousClass2);
            this.mpn.mqs = new a() {
                public final void onCancel() {
                    x.i("MicroMsg.FaceDetectPrepareUI", "hy: user cancel in tutorial");
                    FaceDetectPrepareUI.this.ah(90002, "user cancel in tutorial");
                }

                public final void aHT() {
                    x.i("MicroMsg.FaceDetectPrepareUI", "hy: tutorial confirmed. start");
                    FaceDetectPrepareUI.this.aHP();
                }
            };
            com.tencent.mm.kernel.g.Do();
            if (com.tencent.mm.kernel.a.CE()) {
                com.tencent.mm.kernel.g.Dq().Db().a(com.tencent.mm.storage.w.a.USERINFO_FACE_SHOW_TUTORIAL_BOOLEAN_SYNC, Boolean.valueOf(true));
            }
            this.mpn.lzm.setVisibility(0);
            return;
        }
        View findViewById = findViewById(com.tencent.mm.plugin.facedetect.a.e.mjc);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        aHP();
    }

    private void aHP() {
        this.mpz = 1;
        this.mpm = new a(this);
        a aVar = this.mpm;
        synchronized (((FaceDetectPrepareUI) aVar.moH.get())) {
            if (aVar.moH.get() != null) {
                aVar.mox = (RelativeLayout) ((FaceDetectPrepareUI) aVar.moH.get()).findViewById(com.tencent.mm.plugin.facedetect.a.e.mji);
                aVar.moy = (Button) ((FaceDetectPrepareUI) aVar.moH.get()).findViewById(com.tencent.mm.plugin.facedetect.a.e.cAl);
                aVar.moz = (ImageView) ((FaceDetectPrepareUI) aVar.moH.get()).findViewById(com.tencent.mm.plugin.facedetect.a.e.mjl);
                aVar.moA = (TextView) ((FaceDetectPrepareUI) aVar.moH.get()).findViewById(com.tencent.mm.plugin.facedetect.a.e.cSl);
                aVar.moF = AnimationUtils.loadAnimation((Context) aVar.moH.get(), com.tencent.mm.plugin.facedetect.a.a.bpO);
                aVar.moG = AnimationUtils.loadAnimation((Context) aVar.moH.get(), com.tencent.mm.plugin.facedetect.a.a.bpP);
                aVar.moC = (Button) ((FaceDetectPrepareUI) aVar.moH.get()).findViewById(com.tencent.mm.plugin.facedetect.a.e.mjh);
                aVar.moD = (Button) ((FaceDetectPrepareUI) aVar.moH.get()).findViewById(com.tencent.mm.plugin.facedetect.a.e.mjk);
                aVar.moB = (TextView) ((FaceDetectPrepareUI) aVar.moH.get()).findViewById(com.tencent.mm.plugin.facedetect.a.e.mjm);
                aVar.moE = (TextView) ((FaceDetectPrepareUI) aVar.moH.get()).findViewById(com.tencent.mm.plugin.facedetect.a.e.mjd);
                aVar.moF.setDuration(500);
                aVar.moG.setDuration(500);
            }
        }
        if (o.o(this)) {
            x.i("MicroMsg.FaceDetectPrepareUI", "alvinluo checkFacePermissionAnd Request true and do init ");
            aHS();
        } else {
            x.i("MicroMsg.FaceDetectPrepareUI", "hy: no camera permission. request permission");
        }
        if (this.mpt) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("key_is_need_video", this.mpt);
            j(4, bundle);
        }
        aHR();
    }

    private void j(int i, Bundle bundle) {
        String str = "MicroMsg.FaceDetectPrepareUI";
        String str2 = "hy: sending msg: cmd: %d, data: %s";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = bundle != null ? bundle.toString() : "null";
        x.i(str, str2, objArr);
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt("k_cmd", i);
        Intent intent = new Intent(this, FaceDetectProcessService.class);
        intent.putExtras(bundle);
        startService(intent);
    }

    protected void onDestroy() {
        super.onDestroy();
        if (!this.mpu) {
            stopService(new Intent(this, FaceDetectProcessService.class));
        }
    }

    public final void aGX() {
        this.mpA = false;
    }

    public void onStart() {
        super.onStart();
    }

    protected void onResume() {
        super.onResume();
        this.mpA = true;
    }

    public void onStop() {
        super.onStop();
        if (!this.mpA) {
            return;
        }
        if (this.jsh || !hasError()) {
            finish();
        } else {
            b(this.mps.errType, this.mps.errCode, this.mps.foE, this.mps.extras);
        }
    }

    public void finish() {
        if (this.mpm != null && this.mpm.aHO()) {
            this.mpm.dismiss();
        }
        if (this.mpn != null) {
            this.mpn.dismiss();
        }
        x.v("MicroMsg.FaceDetectPrepareUI", "alvinluo: releaseFaceDetect");
        if (this.mpl != null) {
            this.mpl.aGU();
        }
        super.finish();
        this.jsh = true;
    }

    private void aHQ() {
        b(4, 90011, "get image failed", getString(h.mjF));
    }

    private void agx() {
        b(4, 90013, "init lib failed", getString(h.mjK));
    }

    private void b(int i, int i2, String str, String str2) {
        x.i("MicroMsg.FaceDetectPrepareUI", "onProcessingError errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        g(i, i2, str, null);
        this.mpr = true;
        a(i, i2, str, str2, false, new c() {
            public final void i(int i, int i2, String str) {
                if (FaceDetectPrepareUI.this.mpl != null) {
                    FaceDetectPrepareUI.this.mpl.f(i, i2, str, FaceDetectPrepareUI.this.mps.extras);
                }
            }
        });
    }

    public void onBackPressed() {
        if (hasError()) {
            if (this.mpl != null) {
                this.mpl.f(this.mps.errType, this.mps.errCode, this.mps.foE, this.mps.extras);
            }
        } else if (this.mpz == 1) {
            ah(90003, "user cancel in init");
        } else if (this.mpz == 3) {
            ah(90005, "user cancel in uploading");
        } else if (this.mpz == 0) {
            ah(90002, "user cancel in tutorial");
        } else {
            ah(90050, "user cancel unknown");
        }
    }

    private void ah(int i, String str) {
        if (hasError()) {
            if (this.mpl != null) {
                this.mpl.f(this.mps.errType, this.mps.errCode, this.mps.foE, this.mps.extras);
            }
        } else if (this.mpl != null) {
            this.mpl.af(i, str);
        }
        this.hpb = true;
        finish();
    }

    private boolean hasError() {
        boolean z;
        String str = "MicroMsg.FaceDetectPrepareUI";
        String str2 = "alvinluo hasLastError: %b, lastError == null: %b, hashCode: %d";
        Object[] objArr = new Object[3];
        objArr[0] = Boolean.valueOf(this.mpq);
        if (this.mps == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[1] = Boolean.valueOf(z);
        objArr[2] = Integer.valueOf(hashCode());
        x.i(str, str2, objArr);
        return this.mpq && this.mps != null;
    }

    public final void g(int i, int i2, String str, Bundle bundle) {
        x.i("MicroMsg.FaceDetectPrepareUI", "alvinluo saveError errType: %d, errCode: %d, errMsg: %s, hashCode: %d", Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(hashCode()));
        if (this.mps == null) {
            this.mps = new b();
        }
        this.mpq = true;
        b bVar = this.mps;
        bVar.errType = i;
        bVar.errCode = i2;
        bVar.foE = str;
        bVar.extras = bundle;
    }

    private void aHR() {
        x.i("MicroMsg.FaceDetectPrepareUI", "hy: start show jumper: %b", Boolean.valueOf(true));
        this.mpw = bi.Wz();
        com.tencent.mm.sdk.f.e.post(new Runnable() {
            public final void run() {
                final Bitmap Aq = o.Aq(FaceDetectPrepareUI.this.gBJ);
                final OnClickListener anonymousClass1 = new OnClickListener() {
                    public final void onClick(View view) {
                        FaceDetectPrepareUI.this.ah(90003, "user cancel in init");
                    }
                };
                ah.y(new Runnable() {
                    public final void run() {
                        com.tencent.mm.plugin.facedetect.ui.a.b a = a.a(FaceDetectPrepareUI.this, anonymousClass1);
                        a.moU = Aq;
                        FaceDetectPrepareUI.this.a(false, false, a);
                    }
                });
            }
        }, "face_prepareInit");
    }

    private void a(final int i, final int i2, final String str, String str2, boolean z, c cVar) {
        x.i("MicroMsg.FaceDetectPrepareUI", "alvinluo showFailJumper showErrMsg: %s", str2);
        final boolean z2 = z;
        final c cVar2 = cVar;
        final int i3 = i;
        final int i4 = i2;
        final String str3 = str;
        com.tencent.mm.plugin.facedetect.ui.a.b a = a.a(com.tencent.mm.plugin.facedetect.a.d.mip, str2, z ? getResources().getString(h.mjY) : getString(h.mjX), z ? getResources().getString(h.dEy) : null, new OnClickListener() {
            public final void onClick(View view) {
                if (!z2) {
                    if (cVar2 != null) {
                        cVar2.i(i3, i4, str3);
                    }
                    FaceDetectPrepareUI.this.b(i3, i4, str3, null);
                } else if (FaceDetectPrepareUI.this.mpl != null) {
                    FaceDetectPrepareUI.this.mpl.aGS();
                }
            }
        }, new OnClickListener() {
            public final void onClick(View view) {
                FaceDetectPrepareUI.this.b(i, i2, str, null);
            }
        });
        a.a(a, getString(h.mjE), new OnClickListener() {
            public final void onClick(View view) {
                if (bi.oN(FaceDetectPrepareUI.this.mpv)) {
                    x.e("MicroMsg.FaceDetectPrepareUI", "alvinluo feedback url is null");
                    return;
                }
                FaceDetectPrepareUI.this.mpA = false;
                try {
                    String str = "appid=%s;errcode=%d;identifyid=%s";
                    Object[] objArr = new Object[3];
                    objArr[0] = FaceDetectPrepareUI.this.mAppId != null ? FaceDetectPrepareUI.this.mAppId : "";
                    objArr[1] = Integer.valueOf(i2);
                    objArr[2] = "";
                    x.i("MicroMsg.FaceDetectPrepareUI", "alvinluo feedback url: %s", FaceDetectPrepareUI.this.mpv + "?customInfo=" + p.encode(String.format(str, objArr), "UTF-8"));
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", r0);
                    com.tencent.mm.bl.d.b(FaceDetectPrepareUI.this, "webview", ".ui.tools.WebViewUI", intent);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.FaceDetectPrepareUI", e, "alvinluo start feedback webview exception", new Object[0]);
                }
            }
        });
        ah.y(new AnonymousClass4(true, a));
    }

    private void aHS() {
        if (this.mpl != null) {
            this.mpl.aGS();
        }
    }

    public final void aGS() {
        x.i("MicroMsg.FaceDetectPrepareUI", "alvinluo startFaceDetect");
        x.i("MicroMsg.FaceDetectPrepareUI", "alvinluo preparing");
        if (this.mpl != null) {
            String string = getIntent().getExtras().getString("k_ticket");
            if (!bi.oN(string)) {
                x.i("MicroMsg.FaceDetectBaseController", "hy: has prepared ticket. force set");
                com.tencent.mm.plugin.facedetect.b.p.Ao(string);
            }
        }
        aHR();
        if (this.mpl != null) {
            this.mpl.aGR();
        }
        this.mpA = true;
    }

    public final void aGU() {
    }

    public final void a(boolean z, boolean z2, com.tencent.mm.plugin.facedetect.ui.a.b bVar) {
        if (z2) {
            x.i("MicroMsg.FaceDetectPrepareUI", "hy: need blur");
            com.tencent.mm.sdk.f.e.post(new Runnable() {
                public final void run() {
                    final Bitmap Aq = o.Aq(FaceDetectPrepareUI.this.gBJ);
                    ah.y(new Runnable() {
                        public final void run() {
                            FaceDetectPrepareUI.this.mpm.w(Aq);
                        }
                    });
                }
            }, "face_refresh_background");
        }
        this.mpm.a(bVar);
    }

    public final void b(int i, int i2, String str, Bundle bundle) {
        x.i("MicroMsg.FaceDetectPrepareUI", "finishWithResult errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        Bundle bundle2 = new Bundle();
        bundle2.putInt("err_code", com.tencent.mm.plugin.facedetect.model.k.pO(i2));
        bundle2.putString("err_msg", str);
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        Intent intent = new Intent();
        intent.putExtras(bundle2);
        setResult(-1, intent);
        if (this.mpt) {
            this.mpu = true;
            j(5, this.mpl.aGW());
        }
        finish();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        int i2 = 90008;
        x.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onRequestPermissionsResult");
        if (iArr != null && iArr.length > 0) {
            switch (i) {
                case 23:
                    int i3;
                    String str = "";
                    String str2 = "";
                    if (iArr.length != 1) {
                        if (iArr.length == 2) {
                            if (iArr[0] == 0 && iArr[1] == 0) {
                                i3 = 1;
                            } else {
                                if (iArr[0] != 0) {
                                    str = "camera permission not granted";
                                    str2 = getString(h.ezZ);
                                } else {
                                    i2 = -1;
                                }
                                if (iArr[1] != 0) {
                                    str = "audio permission not granted";
                                    str2 = getString(h.eAd);
                                    i2 = 90009;
                                }
                                if (!(iArr[0] == 0 || iArr[1] == 0)) {
                                    i2 = 90010;
                                    str = "both camera and audio permission not granted";
                                    str2 = getString(h.ezZ);
                                }
                                b(1, i2, str, str2);
                                i3 = 0;
                            }
                        }
                        i2 = -1;
                        b(1, i2, str, str2);
                        i3 = 0;
                    } else if (iArr[0] == 0) {
                        i3 = 1;
                    } else {
                        if (strArr[0].equals("android.permission.CAMERA")) {
                            str = "camera permission not granted";
                            str2 = getString(h.ezZ);
                        } else {
                            if (strArr[0].equals("android.permission.RECORD_AUDIO")) {
                                str = "audio permission not granted";
                                str2 = getString(h.eAd);
                                i2 = 90009;
                            }
                            i2 = -1;
                        }
                        b(1, i2, str, str2);
                        i3 = 0;
                    }
                    if (i3 != 0) {
                        aHS();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onActivityResult requestCode: %d, resultCode: %d", Integer.valueOf(i), Integer.valueOf(i2));
        this.mpz = 1;
        if (intent == null) {
            x.e("MicroMsg.FaceDetectPrepareUI", "alvinluo onActivityResult data is null");
            a(4, 90018, "system error", getString(h.mjN), false, new c() {
                public final void i(int i, int i2, String str) {
                    if (FaceDetectPrepareUI.this.mpl != null) {
                        FaceDetectPrepareUI.this.mpl.f(i, i2, str, null);
                    }
                }
            });
            return;
        }
        FaceDetectReporter faceDetectReporter = (FaceDetectReporter) intent.getParcelableExtra("key_parcelable_reporter");
        if (faceDetectReporter != null) {
            FaceDetectReporter.aHr().a(faceDetectReporter);
        }
        int intExtra = intent.getIntExtra("err_type", -1);
        int intExtra2 = intent.getIntExtra("err_code", -1);
        String stringExtra = intent.getStringExtra("err_msg");
        if (this.mpl != null) {
            com.tencent.mm.plugin.facedetect.c.a aVar = this.mpl;
            intent.getExtras();
            aVar.h(intExtra, intExtra2, stringExtra);
        }
        x.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onActivityResult errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(intExtra), Integer.valueOf(intExtra2), stringExtra);
        if (intExtra == 0 && intExtra2 == 0) {
            String string = getString(h.mjM);
            com.tencent.mm.plugin.facedetect.ui.a.b a = a.a(com.tencent.mm.plugin.facedetect.a.d.mio, string, null, null, getString(h.dEy), null, new OnClickListener() {
                public final void onClick(View view) {
                    FaceDetectPrepareUI.this.ah(90005, "user cancel in uploading");
                }
            });
            a.moR = true;
            a.moT = string.length() - 3;
            a(false, true, a);
            j(1, null);
        } else if (intExtra != 1) {
            String stringExtra2 = intent.getStringExtra("show_err_msg");
            if (intExtra2 == 90013) {
                stringExtra2 = getString(h.mjK);
            } else if (intExtra2 == 90008 || intExtra2 == 90010) {
                stringExtra2 = getString(h.ezZ);
            } else if (intExtra2 == 90009) {
                stringExtra2 = getString(h.eAd);
            } else if (bi.oN(stringExtra2)) {
                stringExtra2 = getString(h.mkm);
            }
            g(intExtra, intExtra2, stringExtra, null);
            a(intExtra, intExtra2, stringExtra, stringExtra2, intExtra2 == 90023, new c() {
                public final void i(int i, int i2, String str) {
                    if (FaceDetectPrepareUI.this.mpl != null) {
                        FaceDetectPrepareUI.this.mpl.f(i, i2, str, null);
                    }
                }
            });
        } else if (intExtra2 == 90004 || intExtra2 == 90025) {
            ah(intExtra2, stringExtra);
        }
    }
}
