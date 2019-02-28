package com.tencent.mm.plugin.shake.ui;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.f.a.dk;
import com.tencent.mm.f.a.dl;
import com.tencent.mm.f.a.dr;
import com.tencent.mm.f.a.qr;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.platformtools.i;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.shake.b.d;
import com.tencent.mm.plugin.shake.b.e;
import com.tencent.mm.plugin.shake.b.l;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.plugin.shake.d.a.h;
import com.tencent.mm.plugin.shake.d.a.k;
import com.tencent.mm.pluginsdk.ui.f;
import com.tencent.mm.protocal.c.ati;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.ac;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.y.ao;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bj;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ShakeReportUI extends MMActivity implements com.tencent.mm.platformtools.j.a, com.tencent.mm.plugin.shake.b.l.a, com.tencent.mm.plugin.shake.c.a.f.a, com.tencent.mm.sdk.e.j.a, b, ao {
    private static List<com.tencent.mm.plugin.shake.d.a.h.a> gAl = new CopyOnWriteArrayList();
    private c gAg;
    private boolean gAj = false;
    private Map<String, com.tencent.mm.plugin.shake.d.a.h.a> gAk = new ConcurrentHashMap();
    private com.tencent.mm.modelgeo.a.a gAn = new com.tencent.mm.modelgeo.a.a() {
        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            if (z) {
                x.d("MicroMsg.ShakeReportUI", "on location get ok");
                as.Hm();
                com.tencent.mm.y.c.Db().a(com.tencent.mm.storage.w.a.USERINFO_SHAKE_TV_LATITUDE_STRING, String.valueOf(f2));
                as.Hm();
                com.tencent.mm.y.c.Db().a(com.tencent.mm.storage.w.a.USERINFO_SHAKE_TV_LONGTITUDE_STRING, String.valueOf(f));
                as.Hm();
                com.tencent.mm.y.c.Db().a(com.tencent.mm.storage.w.a.USERINFO_SHAKE_TV_ACCURACY_STRING, String.valueOf(d2));
                ShakeReportUI.this.gAj = true;
                if (ShakeReportUI.this.gAg != null) {
                    ShakeReportUI.this.gAg.c(ShakeReportUI.this.gAn);
                }
            } else {
                x.w("MicroMsg.ShakeReportUI", "getLocation fail");
            }
            return false;
        }
    };
    private com.tencent.mm.ap.a.a hEr = null;
    private ImageView ikl;
    private com.tencent.mm.pluginsdk.k.c oTo;
    private boolean pEf = true;
    private boolean qwX = false;
    private boolean qwY = false;
    private boolean qwZ;
    private String qxA = "";
    private Bitmap qxB = null;
    private Dialog qxC;
    private ImageView qxD = null;
    private d qxE = null;
    private ImageView qxF;
    private ImageView qxG;
    private ImageView qxH;
    private ImageView qxI;
    private ImageView qxJ;
    private ImageView qxK;
    private TextView qxL;
    private int qxM = 1;
    private int qxN = 0;
    private View qxO;
    private ImageView qxP;
    private ImageView qxQ;
    private ImageView qxR;
    private ImageView qxS;
    private View qxT;
    private View qxU;
    private View qxV;
    private View qxW;
    private View qxX = null;
    private int qxY = 0;
    private com.tencent.mm.plugin.shake.c.b.a qxZ;
    private boolean qxa = false;
    private boolean qxb = false;
    private boolean qxc = false;
    private boolean qxd = false;
    private int qxe = 22;
    private c qxf;
    private l qxg = new l();
    private f qxh;
    private View qxi;
    private View qxj;
    private TextView qxk;
    private TextView qxl;
    private TextView qxm;
    private View qxn;
    private View qxo;
    private View qxp;
    private View qxq;
    private Animation qxr;
    private Animation qxs;
    private Animation qxt;
    private Animation qxu;
    private View qxv = null;
    private View qxw = null;
    private MMImageView qxx = null;
    private TextView qxy = null;
    private ImageView qxz = null;
    private boolean qya = false;
    @SuppressLint({"UseSparseArrays"})
    private Map<Integer, Boolean> qyb = new HashMap();
    private boolean qyc = false;
    private boolean qyd = false;
    private boolean qye = false;
    private boolean qyf = false;
    private int qyg = 1;
    private long qyh = 0;
    private boolean qyi = false;
    private com.tencent.mm.sdk.b.c qyj = new com.tencent.mm.sdk.b.c<dl>() {
        {
            this.xmG = dl.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            dl dlVar = (dl) bVar;
            String str = dlVar.fsT.fsR;
            int i = dlVar.fsT.fsU;
            int i2 = dlVar.fsT.fsV;
            String str2 = dlVar.fsT.fsY;
            double d = dlVar.fsT.fsX;
            int i3 = dlVar.fsT.fsZ;
            if (!ShakeReportUI.this.gAk.containsKey(str + "," + i + "," + i2)) {
                com.tencent.mm.plugin.shake.d.a.h.a aVar = new com.tencent.mm.plugin.shake.d.a.h.a();
                aVar.njL = str;
                aVar.hNI = dlVar.fsT.fsW;
                aVar.major = i;
                aVar.minor = i2;
                aVar.qvT = str2;
                aVar.qvU = d;
                aVar.qvV = i3;
                ShakeReportUI.this.gAk.put(str + "," + i + "," + i2, aVar);
                if (dlVar.fsT.fsW >= 0.0d && ShakeReportUI.gAl.size() > 0) {
                    i3 = 0;
                    while (i3 < ShakeReportUI.gAl.size()) {
                        com.tencent.mm.plugin.shake.d.a.h.a aVar2 = (com.tencent.mm.plugin.shake.d.a.h.a) ShakeReportUI.gAl.get(i3);
                        if (dlVar.fsT.fsW >= aVar2.hNI) {
                            if (i3 == ShakeReportUI.gAl.size() - 1 && dlVar.fsT.fsW > aVar2.hNI) {
                                ShakeReportUI.gAl.add(aVar);
                                break;
                            }
                            i3++;
                        } else {
                            ShakeReportUI.gAl.add(i3, aVar);
                            break;
                        }
                    }
                }
                ShakeReportUI.gAl.add(aVar);
                if (ShakeReportUI.this.gAk.size() == 1 && !ShakeReportUI.this.qyi) {
                    ShakeReportUI.this.qyh = System.currentTimeMillis() - ShakeReportUI.this.qyh;
                    g.pWK.h(11497, String.valueOf((int) (((double) (ShakeReportUI.this.qyh / 1000)) + 0.5d)), Integer.valueOf(0), Integer.valueOf((int) ShakeReportUI.this.qyh));
                    ShakeReportUI.this.qyh = 0;
                    ShakeReportUI.this.runOnUiThread(new Runnable() {
                        public final void run() {
                            ShakeReportUI.h(ShakeReportUI.this);
                        }
                    });
                }
            }
            x.i("MicroMsg.ShakeReportUI", "result iBeacon = %s,beaconMap.size:%d", str + "," + i + "," + i2, Integer.valueOf(ShakeReportUI.this.gAk.size()));
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c qyk = new com.tencent.mm.sdk.b.c<dr>() {
        {
            this.xmG = dr.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            dr drVar = (dr) bVar;
            x.d("MicroMsg.ShakeReportUI", "ExDeviceOnBluetoothStateChangeEvent = %s", Integer.valueOf(drVar.fti.ftj));
            boolean hasSystemFeature = ShakeReportUI.this.mController.xRr.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
            if (drVar.fti.ftj == 10 && VERSION.SDK_INT >= 18 && hasSystemFeature) {
                ShakeReportUI.this.bsW();
            } else if (drVar.fti.ftj == 12) {
                if (VERSION.SDK_INT < 18 || !hasSystemFeature) {
                    ShakeReportUI.this.qyg = 1;
                } else {
                    ShakeReportUI.this.bsV();
                    ShakeReportUI.this.qyg = 0;
                }
                bj HW = bj.HW();
                String oM = bi.oM(HW.hjh);
                String oM2 = bi.oM(HW.hjg);
                int i = hasSystemFeature ? 1 : 0;
                if (ShakeReportUI.this.qyd) {
                    g.pWK.h(13139, oM, oM2, Integer.valueOf(1), Integer.valueOf(ShakeReportUI.this.qyg), Integer.valueOf(1), Integer.valueOf(i));
                } else {
                    g.pWK.h(13139, oM, oM2, Integer.valueOf(0), Integer.valueOf(ShakeReportUI.this.qyg), Integer.valueOf(1), Integer.valueOf(i));
                }
                if (ShakeReportUI.this.qye && ShakeReportUI.this.qyd && !ShakeReportUI.this.qyi && ShakeReportUI.this.qxN < 4) {
                    ShakeReportUI.this.runOnUiThread(new Runnable() {
                        public final void run() {
                            ShakeReportUI.h(ShakeReportUI.this);
                        }
                    });
                }
            }
            return false;
        }
    };
    private OnClickListener qyl = new OnClickListener() {
        public long qwC = 0;

        public final void onClick(View view) {
            if (!bi.oN((String) ShakeReportUI.this.qxi.getTag()) && ShakeReportUI.this.qxE != null) {
                d L = ShakeReportUI.this.qxE;
                String str = L.field_username;
                Intent intent;
                if (11 != L.field_type) {
                    as.Hm();
                    ag Xv = com.tencent.mm.y.c.Ff().Xv(str);
                    if (com.tencent.mm.k.a.ga(Xv.field_type)) {
                        Intent intent2 = new Intent();
                        intent2.putExtra("Contact_User", str);
                        intent2.putExtra("Sns_from_Scene", 22);
                        if (str != null && str.length() > 0) {
                            if (Xv.ciN()) {
                                g.pWK.k(10298, str + "," + ShakeReportUI.this.qxe);
                                intent2.putExtra("Contact_Scene", ShakeReportUI.this.qxe);
                            }
                            com.tencent.mm.plugin.shake.a.ihN.d(intent2, ShakeReportUI.this);
                            return;
                        }
                        return;
                    }
                    if ((L.field_reserved1 & 8) > 0) {
                        g.pWK.k(10298, L.field_username + "," + ShakeReportUI.this.qxe);
                    }
                    intent = new Intent();
                    intent.putExtra("Contact_User", L.field_username);
                    intent.putExtra("Contact_Nick", L.field_nickname);
                    intent.putExtra("Contact_Distance", L.field_distance);
                    intent.putExtra("Contact_Signature", L.field_signature);
                    intent.putExtra("Contact_Province", L.getProvince());
                    intent.putExtra("Contact_City", L.getCity());
                    intent.putExtra("Contact_Sex", L.field_sex);
                    intent.putExtra("Contact_IsLBSFriend", true);
                    intent.putExtra("Contact_VUser_Info", L.field_reserved3);
                    intent.putExtra("Contact_VUser_Info_Flag", L.field_reserved1);
                    intent.putExtra("Contact_KSnsIFlag", L.field_snsFlag);
                    intent.putExtra("Contact_KSnsBgUrl", L.field_sns_bgurl);
                    intent.putExtra("Contact_Scene", ShakeReportUI.this.qxe);
                    intent.putExtra("Sns_from_Scene", 22);
                    com.tencent.mm.plugin.shake.a.ihN.d(intent, ShakeReportUI.this);
                } else if (System.currentTimeMillis() - this.qwC > 3000) {
                    this.qwC = System.currentTimeMillis();
                    if (L.field_reserved3 == null || L.field_reserved3.split(",").length != 3 || L.field_reserved3.split(",")[0] == null || L.field_reserved3.split(",")[0].equals("")) {
                        intent = new Intent();
                        intent.putExtra("rawUrl", L.getCity());
                        intent.putExtra("scene", 27);
                        intent.putExtra("stastic_scene", 5);
                        com.tencent.mm.bl.d.b(ad.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                    } else {
                        String[] split = L.field_reserved3.split(",");
                        com.tencent.mm.sdk.b.b qrVar = new qr();
                        qrVar.fJd.userName = split[0];
                        qrVar.fJd.fJf = bi.aD(split[1], "");
                        qrVar.fJd.fJg = bi.getInt(split[2], 0);
                        qrVar.fJd.scene = 1077;
                        com.tencent.mm.sdk.b.a.xmy.m(qrVar);
                    }
                    l.b bVar = ShakeReportUI.this.qxg.qtS;
                    if (bVar != null && (bVar instanceof h)) {
                        h.a(L);
                        h.b(L);
                    }
                }
            }
        }
    };

    static class a extends com.tencent.mm.pluginsdk.k.c.a {
        private final long[] igQ = new long[]{300, 200, 300, 200};
        private long kIG = bi.Wz();
        private Vibrator kJP;
        WeakReference<ShakeReportUI> qys;

        public a(ShakeReportUI shakeReportUI) {
            this.qys = new WeakReference(shakeReportUI);
        }

        public final void bfv() {
            ShakeReportUI shakeReportUI = (ShakeReportUI) this.qys.get();
            if (shakeReportUI != null) {
                if (shakeReportUI.isFinishing()) {
                    x.e("MicroMsg.ShakeReportUI", "ui finished");
                } else if (shakeReportUI.qxc) {
                    shakeReportUI.btc();
                    long bB = bi.bB(this.kIG);
                    if (bB < 1200) {
                        x.i("MicroMsg.ShakeReportUI", "tryStartShake delay too short:" + bB);
                        return;
                    }
                    x.w("MicroMsg.ShakeReportUI", "tryStartShake delaytoo enough:" + bB);
                    this.kIG = bi.Wz();
                    if (shakeReportUI.qxf != null) {
                        c w = shakeReportUI.qxf;
                        if (w.view != null) {
                            w.view.setKeepScreenOn(true);
                        }
                        w.fia.K(30000, 30000);
                    }
                    if (shakeReportUI.qxh != null) {
                        f q = shakeReportUI.qxh;
                        if (q.opq != null) {
                            q.opq.dismiss();
                        }
                    }
                    ShakeReportUI shakeReportUI2;
                    if (shakeReportUI.qwZ) {
                        shakeReportUI2 = (ShakeReportUI) this.qys.get();
                        if (shakeReportUI2 != null) {
                            com.tencent.mm.sdk.platformtools.as.H(shakeReportUI2, R.l.ePm);
                        }
                    } else {
                        shakeReportUI2 = (ShakeReportUI) this.qys.get();
                        if (shakeReportUI2 != null) {
                            if (this.kJP == null) {
                                this.kJP = (Vibrator) shakeReportUI2.getSystemService("vibrator");
                            }
                            if (this.kJP != null) {
                                this.kJP.vibrate(this.igQ, -1);
                            }
                        }
                    }
                    com.tencent.mm.pluginsdk.k.c.a.reset();
                    ShakeReportUI.y(shakeReportUI);
                } else {
                    x.i("MicroMsg.ShakeReportUI", "tryShake the status is can's shake");
                }
            }
        }

        public final void onRelease() {
        }
    }

    static /* synthetic */ void h(ShakeReportUI shakeReportUI) {
        if (bth()) {
            ViewGroup viewGroup = (ViewGroup) shakeReportUI.findViewById(R.h.cNe);
            if (viewGroup != null) {
                int i;
                int childCount = viewGroup.getChildCount();
                List arrayList = new ArrayList();
                int i2 = 0;
                for (i = 0; i < childCount; i++) {
                    if (viewGroup.getChildAt(i).getVisibility() == 0) {
                        i2++;
                        arrayList.add(viewGroup.getChildAt(i));
                    }
                }
                int width;
                Animation animationSet;
                Animation alphaAnimation;
                Animation translateAnimation;
                View view;
                if (!shakeReportUI.qyc && (shakeReportUI.qyd || shakeReportUI.qyf)) {
                    childCount = viewGroup.getWidth() / (i2 + 1);
                    width = viewGroup.getWidth() / i2;
                    animationSet = new AnimationSet(false);
                    alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation.setDuration(600);
                    translateAnimation = new TranslateAnimation((float) viewGroup.getWidth(), (float) (viewGroup.getWidth() - childCount), 0.0f, 0.0f);
                    animationSet.addAnimation(alphaAnimation);
                    translateAnimation.setDuration(600);
                    animationSet.addAnimation(translateAnimation);
                    shakeReportUI.findViewById(R.h.cNr).setAnimation(animationSet);
                    if (i2 < 4) {
                        for (i = 0; i < i2; i++) {
                            view = (View) arrayList.get(i);
                            translateAnimation = new TranslateAnimation((float) (((i * width) + (width / 2)) - ((i * childCount) + (childCount / 2))), 0.0f, 0.0f, 0.0f);
                            translateAnimation.setDuration(600);
                            view.setAnimation(translateAnimation);
                        }
                    }
                } else if (!(shakeReportUI.qyc || shakeReportUI.qyd || shakeReportUI.qyf)) {
                    childCount = viewGroup.getWidth() / (i2 + 1);
                    width = viewGroup.getWidth() / i2;
                    Animation animationSet2 = new AnimationSet(false);
                    animationSet = new AlphaAnimation(0.0f, 1.0f);
                    animationSet.setDuration(1200);
                    alphaAnimation = new TranslateAnimation((float) ((-childCount) / 2), 0.0f, 0.0f, 0.0f);
                    animationSet2.addAnimation(animationSet);
                    alphaAnimation.setDuration(600);
                    animationSet2.addAnimation(alphaAnimation);
                    shakeReportUI.findViewById(R.h.cNo).setAnimation(animationSet2);
                    for (i = 1; i < i2 + 1; i++) {
                        view = (View) arrayList.get(i - 1);
                        translateAnimation = new TranslateAnimation((float) (-(((i * childCount) + (childCount / 2)) - (((i - 1) * width) + (width / 2)))), 0.0f, 0.0f, 0.0f);
                        translateAnimation.setDuration(600);
                        view.setAnimation(translateAnimation);
                    }
                }
                shakeReportUI.qyc = true;
                shakeReportUI.qxM = 5;
                shakeReportUI.qyi = true;
                shakeReportUI.btf();
                shakeReportUI.bsY();
                shakeReportUI.hZ(false);
            }
        }
    }

    static /* synthetic */ void y(ShakeReportUI shakeReportUI) {
        if (shakeReportUI.qxn == null) {
            shakeReportUI.qxn = shakeReportUI.findViewById(R.h.cNM);
        }
        if (shakeReportUI.qxo == null) {
            shakeReportUI.qxo = shakeReportUI.findViewById(R.h.cMJ);
        }
        if (shakeReportUI.qxp == null) {
            shakeReportUI.qxp = shakeReportUI.findViewById(R.h.cMO);
        }
        if (shakeReportUI.qxq == null) {
            shakeReportUI.qxq = shakeReportUI.findViewById(R.h.cMP);
        }
        if (shakeReportUI.qxr == null) {
            shakeReportUI.qxr = AnimationUtils.loadAnimation(shakeReportUI.mController.xRr, R.a.bqI);
            shakeReportUI.qxr.setAnimationListener(new AnimationListener() {
                public final void onAnimationStart(Animation animation) {
                    ShakeReportUI.this.qwX = false;
                    ShakeReportUI.this.qwY = true;
                    ShakeReportUI.this.hY(false);
                    ShakeReportUI.this.qxb = true;
                    ShakeReportUI.this.ic(true);
                }

                public final void onAnimationEnd(Animation animation) {
                    ShakeReportUI.this.hY(true);
                    ShakeReportUI.this.qxb = false;
                    if (!ShakeReportUI.this.qwX) {
                        ShakeReportUI.this.qxa = true;
                        ShakeReportUI.this.ib(true);
                        ShakeReportUI.this.bsY();
                        if (ShakeReportUI.this.qxg.qtR == 3) {
                            com.tencent.mm.au.b.Qv();
                        } else if (ShakeReportUI.this.qxg.qtR == 5) {
                            l.b bVar = ShakeReportUI.this.qxg.qtS;
                            if (bVar != null && (bVar instanceof h)) {
                                h hVar = (h) bVar;
                                Collection arrayList = new ArrayList();
                                arrayList.addAll(ShakeReportUI.gAl);
                                hVar.qvN = arrayList;
                            }
                        }
                        ShakeReportUI.this.qxg.qtS.start();
                    }
                    ShakeReportUI.this.qwY = false;
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
        }
        if (shakeReportUI.qxs == null) {
            shakeReportUI.qxs = AnimationUtils.loadAnimation(shakeReportUI.mController.xRr, R.a.bqG);
        }
        if (shakeReportUI.qxt == null) {
            shakeReportUI.qxt = AnimationUtils.loadAnimation(shakeReportUI.mController.xRr, R.a.bqt);
        }
        if (!(shakeReportUI.qxu == null || shakeReportUI.qxl == null)) {
            com.tencent.mm.sdk.platformtools.BackwardSupportUtil.a.c(shakeReportUI.qxl, shakeReportUI.qxu);
        }
        shakeReportUI.wA(3);
        shakeReportUI.qxp.startAnimation(shakeReportUI.qxt);
        shakeReportUI.qxq.startAnimation(shakeReportUI.qxt);
        shakeReportUI.qxp.setVisibility(0);
        shakeReportUI.qxq.setVisibility(0);
        shakeReportUI.qxk.setVisibility(4);
        shakeReportUI.qxn.startAnimation(shakeReportUI.qxr);
        shakeReportUI.qxo.startAnimation(shakeReportUI.qxs);
        if (shakeReportUI.qxi != null && shakeReportUI.qxi.getVisibility() == 0) {
            Animation loadAnimation = AnimationUtils.loadAnimation(shakeReportUI.mController.xRr, R.a.bqv);
            loadAnimation.setFillAfter(true);
            shakeReportUI.qxi.startAnimation(loadAnimation);
            new com.tencent.mm.sdk.platformtools.ag().postDelayed(new Runnable() {
                public final void run() {
                    if (ShakeReportUI.this.qxi != null) {
                        ShakeReportUI.this.qxi.setVisibility(8);
                    }
                }
            }, loadAnimation.getDuration());
        }
        shakeReportUI.qxd = false;
        new com.tencent.mm.sdk.platformtools.ag().postDelayed(new Runnable() {
            public final void run() {
                if (ShakeReportUI.this.qxp != null) {
                    ShakeReportUI.this.qxp.setVisibility(8);
                }
                if (ShakeReportUI.this.qxq != null) {
                    ShakeReportUI.this.qxq.setVisibility(8);
                }
                if (ShakeReportUI.this.qxk != null) {
                    ShakeReportUI.this.qxk.setVisibility(0);
                }
                if (!ShakeReportUI.this.qxd && !ShakeReportUI.this.qwX) {
                    ShakeReportUI.this.wA(1);
                }
            }
        }, 1200);
    }

    protected final int getLayoutId() {
        return R.i.dsE;
    }

    protected final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        int i;
        int i2;
        super.onCreate(bundle);
        setMMTitle(R.l.eOZ);
        this.gAg = c.OV();
        as.Hm();
        com.tencent.mm.y.c.Db().a(com.tencent.mm.storage.w.a.USERINFO_SHAKE_TV_LATITUDE_STRING, (Object) "");
        as.Hm();
        com.tencent.mm.y.c.Db().a(com.tencent.mm.storage.w.a.USERINFO_SHAKE_TV_LONGTITUDE_STRING, (Object) "");
        as.Hm();
        com.tencent.mm.y.c.Db().a(com.tencent.mm.storage.w.a.USERINFO_SHAKE_TV_ACCURACY_STRING, (Object) "");
        this.qxX = findViewById(R.h.cNo);
        bj HW = bj.HW();
        String oM = bi.oM(HW.hjh);
        String oM2 = bi.oM(HW.hjg);
        String F = com.tencent.mm.j.g.Ag().F("IBeacon", "GatedLaunch");
        if (bi.oN(F)) {
            F = null;
        }
        this.qyd = false;
        this.qye = false;
        if (F != null) {
            try {
                JSONObject jSONObject = new JSONObject(F);
                i = jSONObject.getInt("gatedlaunch");
                as.Hp();
                if (i != 0) {
                    JSONArray jSONArray;
                    int length;
                    String string;
                    int i3;
                    JSONArray jSONArray2;
                    if (i == 1) {
                        jSONArray = jSONObject.getJSONArray("citylist");
                        length = jSONArray.length();
                        for (i = 0; i < length; i++) {
                            jSONObject = jSONArray.getJSONObject(i);
                            string = jSONObject.getString("province");
                            i3 = jSONObject.getInt("allgatedlaunch");
                            if (string.equals(oM) && i3 == 1) {
                                this.qyd = true;
                            } else if (string.equals(oM) && i3 == 0) {
                                jSONArray2 = jSONObject.getJSONArray("cities");
                                i3 = jSONArray2.length();
                                for (i2 = 0; i2 < i3; i2++) {
                                    if (jSONArray2.getString(i2).equals(oM2)) {
                                        this.qyd = true;
                                    }
                                }
                            }
                        }
                    } else if (i == 2) {
                        jSONArray = jSONObject.getJSONArray("citylist");
                        length = jSONArray.length();
                        for (i = 0; i < length; i++) {
                            jSONObject = jSONArray.getJSONObject(i);
                            string = jSONObject.getString("province");
                            i3 = jSONObject.getInt("allgatedlaunch");
                            if (string.equals(oM) && i3 == 1) {
                                this.qye = true;
                                this.qyd = true;
                            } else if (string.equals(oM) && i3 == 0) {
                                jSONArray2 = jSONObject.getJSONArray("cities");
                                i3 = jSONArray2.length();
                                for (i2 = 0; i2 < i3; i2++) {
                                    if (jSONArray2.getString(i2).equals(oM2)) {
                                        this.qye = true;
                                        this.qyd = true;
                                    }
                                }
                            }
                        }
                    } else if (i == 3) {
                        this.qyd = true;
                        this.qye = false;
                    } else if (i == 4) {
                        this.qyd = true;
                        this.qye = true;
                    }
                }
            } catch (JSONException e) {
                x.e("MicroMsg.ShakeReportUI", "[shakezb]parse dymanic setting json fail!!");
                this.qyd = false;
                this.qye = false;
            }
        }
        if (as.Hp()) {
            as.Hm();
            if (((Integer) com.tencent.mm.y.c.Db().get(com.tencent.mm.storage.w.a.USERINFO_IBEACON_SHAKE_TAB_IS_UIN_RESIDENT_INT, Integer.valueOf(0))).intValue() == 1) {
                this.qyf = true;
            }
        }
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        boolean hasSystemFeature = ad.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
        if (defaultAdapter == null || !hasSystemFeature || VERSION.SDK_INT < 18 || defaultAdapter.getState() != 12) {
            this.qyg = 1;
        } else {
            this.qyg = 0;
        }
        if (defaultAdapter == null || defaultAdapter.getState() != 12) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        if (hasSystemFeature) {
            i = 1;
        } else {
            i = 0;
        }
        if (this.qyd) {
            g.pWK.h(13139, oM, oM2, Integer.valueOf(1), Integer.valueOf(this.qyg), Integer.valueOf(i2), Integer.valueOf(i));
        } else {
            g.pWK.h(13139, oM, oM2, Integer.valueOf(0), Integer.valueOf(this.qyg), Integer.valueOf(i2), Integer.valueOf(i));
        }
        if (this.qyf || this.qyd) {
            this.qyc = true;
            this.qxX = findViewById(R.h.cNr);
            if (this.qye) {
                if (defaultAdapter == null || defaultAdapter.getState() != 12) {
                    this.qyc = false;
                } else if (defaultAdapter != null) {
                    defaultAdapter.getState();
                }
            }
        }
        com.tencent.mm.plugin.shake.c.a.f bsr = m.bsr();
        if (bsr.kOg == null) {
            bsr.kOg = new ArrayList();
        }
        if (this != null) {
            bsr.kOg.add(new WeakReference(this));
        }
        Boolean valueOf = Boolean.valueOf(false);
        long Wx = bi.Wx();
        long j = 0;
        long j2 = 0;
        if (as.Hp()) {
            as.Hm();
            com.tencent.mm.y.c.Db().a(com.tencent.mm.storage.w.a.USERINFO_IBEACON_PUSH_IS_IN_SHAKEUI_BOOLEAN, Boolean.valueOf(true));
            as.Hm();
            Boolean valueOf2 = Boolean.valueOf(bi.a((Boolean) com.tencent.mm.y.c.Db().get(com.tencent.mm.storage.w.a.USERINFO_IBEACON_PUSH_IS_OPEN_BOOLEAN, null), false));
            as.Hm();
            j = bi.a((Long) com.tencent.mm.y.c.Db().get(com.tencent.mm.storage.w.a.USERINFO_IBEACON_PUSH_OPEN_TIEMSTAMP_LONG, null), 0);
            as.Hm();
            j2 = bi.a((Long) com.tencent.mm.y.c.Db().get(com.tencent.mm.storage.w.a.USERINFO_IBEACON_PUSH_CHANNEL_OPEN_TIME_LONG, null), 0);
            valueOf = valueOf2;
        }
        if (!valueOf.booleanValue() || Wx - j >= j2) {
            initView();
        } else {
            this.qxM = 5;
            this.qyc = true;
            this.qxa = true;
            initView();
            bsY();
            as.Hm();
            String aD = bi.aD((String) com.tencent.mm.y.c.Db().get(com.tencent.mm.storage.w.a.USERINFO_IBEACON_PUSH_LAST_BEACONINFO_STRING, null), "");
            as.Hm();
            F = bi.aD((String) com.tencent.mm.y.c.Db().get(com.tencent.mm.storage.w.a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, null), "");
            if (!(F == null || F.equals(""))) {
                String[] split = F.split(",");
                d dVar = new d();
                dVar.field_type = 11;
                dVar.field_username = split[0];
                dVar.field_nickname = split[0];
                dVar.field_signature = split[1];
                dVar.field_province = split[2];
                dVar.field_city = split[3];
                dVar.field_sex = 1;
                try {
                    dVar.field_lvbuffer = (String.valueOf(split[4]) + "," + String.valueOf(split[5]) + "," + String.valueOf(split[6])).getBytes(ProtocolPackage.ServerEncoding);
                } catch (UnsupportedEncodingException e2) {
                    x.e("MicroMsg.ShakeReportUI", "[kevinkma]parst shakeItem error!");
                }
                dVar.field_insertBatch = 2;
                e bsm = m.bsm();
                bsm.bse();
                bsm.a(dVar, true);
                List linkedList = new LinkedList();
                linkedList.add(dVar);
                d(linkedList, 1);
                as.Hm();
                com.tencent.mm.y.c.Db().a(com.tencent.mm.storage.w.a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, (Object) "");
                Object obj = aD + "," + split[4] + split[5] + split[6];
                as.Hm();
                com.tencent.mm.y.c.Db().a(com.tencent.mm.storage.w.a.USERINFO_IBEACON_PUSH_LAST_BEACONINFO_STRING, obj);
            }
        }
        this.qxf = new c(this.mController.xRd);
        this.oTo = new com.tencent.mm.pluginsdk.k.c(this);
        if (!this.oTo.caA()) {
            com.tencent.mm.ui.base.h.a((Context) this, R.l.eOY, R.l.dGZ, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    ShakeReportUI.this.finish();
                }
            });
        }
        if (com.tencent.mm.plugin.shake.a.ihO != null) {
            com.tencent.mm.plugin.shake.a.ihO.un();
        }
        j.b((com.tencent.mm.platformtools.j.a) this);
        x.i("MicroMsg.ShakeReportUI", "%s", getResources().getDisplayMetrics().toString());
        i = m.bsn().Tx();
        g.pWK.h(11317, Integer.valueOf(i), e.btj());
        g.pWK.h(11710, Integer.valueOf(1));
        g.pWK.h(834, 0);
    }

    protected void onResume() {
        super.onResume();
        if (this.pEf) {
            x.i("MicroMsg.ShakeReportUI", "summerper checkPermission checkposition[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, "", "")), bi.chl(), this);
            if (com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, "", "")) {
                bmr();
            }
        }
    }

    private void bmr() {
        bsX();
        as.Hm();
        com.tencent.mm.y.c.a(this);
        as.Hm();
        com.tencent.mm.y.c.Db().a(this);
        m.bsm().c(this);
        if (this.qxg.qtS != null) {
            this.qxg.qtS.resume();
        }
        this.qxc = true;
        if (!(this.qxZ == null || !this.qxZ.isShowing() || this.qxZ.qvb)) {
            this.qxc = false;
        }
        x.i("MicroMsg.ShakeReportUI", "tryStartShake");
        if (!(this.oTo == null || this.oTo.cay())) {
            this.oTo.a(new a(this));
            if (!this.oTo.caA() || this.qxk == null) {
                this.qxk.setText(getString(R.l.eOY));
            } else {
                this.qxk.setText(getString(R.l.eOm));
            }
        }
        new com.tencent.mm.sdk.platformtools.ag().postDelayed(new Runnable() {
            public final void run() {
                if (ShakeReportUI.this.oTo != null) {
                    ShakeReportUI.this.oTo.caz();
                }
            }
        }, 1000);
        if (this.oTo != null) {
            this.oTo.caz();
        }
        ia(false);
        ib(false);
        bsZ();
        as.Hm();
        String str = (String) com.tencent.mm.y.c.Db().get(327696, (Object) "1");
        if (k.bsk()) {
            if (this.qxM == 4) {
                hX(true);
            }
            if (str.equals("4")) {
                ct(findViewById(R.h.cNw));
            }
        }
        if (str.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
            ct(findViewById(R.h.cNt));
        } else if (str.equals("6") && com.tencent.mm.plugin.shake.c.c.a.bsL()) {
            ct(findViewById(R.h.cNj));
        }
        boolean aR = com.tencent.mm.r.c.Bx().aR(262154, 266258);
        if (getIntent().getBooleanExtra("shake_music", false) && com.tencent.mm.au.c.QE() && this.qxg.qtR != 3) {
            getIntent().putExtra("shake_music", false);
            this.qxM = 3;
        } else if (getIntent().getBooleanExtra("shake_tv", false) && this.qxg.qtR != 4 && k.bsk()) {
            getIntent().putExtra("shake_tv", false);
            this.qxM = 4;
        } else if (this.qxg.qtR != 6 && com.tencent.mm.plugin.shake.c.c.a.bsL() && (aR || getIntent().getBooleanExtra("shake_card", false))) {
            this.qxY = getIntent().getIntExtra("shake_card", 0);
            getIntent().putExtra("shake_card", false);
            x.i("MicroMsg.ShakeReportUI", "onresume shake card tab is open, activity type is 0 or open from specialview");
            this.qxM = 6;
        }
        bsY();
        hY(true);
        x.d("MicroMsg.ShakeReportUI", "isShakeGetConfigList = %s", Boolean.valueOf(r.ifD));
        if (r.ifD) {
            as.CN().a(new com.tencent.mm.ay.k(7), 0);
        }
        ic(true);
        btf();
        bsV();
    }

    protected void onPause() {
        as.Hm();
        com.tencent.mm.y.c.b(this);
        as.Hm();
        com.tencent.mm.y.c.Db().b(this);
        m.bsm().j(this);
        if (this.qxg.qtS != null) {
            this.qxg.qtS.pause();
        }
        this.qxc = false;
        if (this.oTo != null) {
            this.oTo.aQC();
        }
        this.qxf.bsT();
        if (this.qxM != 5) {
            as.Hm();
            com.tencent.mm.y.c.Db().set(327696, this.qxM);
        }
        if (this.qxM == 4) {
            hX(false);
        }
        bsW();
        super.onPause();
    }

    protected void onDestroy() {
        boolean z = false;
        if (!(this.qxB == null || this.qxB.isRecycled())) {
            this.qxB.recycle();
        }
        if (this.qxC != null && this.qxC.isShowing()) {
            this.qxC.dismiss();
            this.qxC = null;
        }
        if (this.qxg.qtS != null) {
            this.qxg.qtS.brZ();
        }
        if (this.oTo != null) {
            this.oTo.aQC();
            this.oTo = null;
        }
        com.tencent.mm.plugin.shake.d.a.j a = com.tencent.mm.plugin.shake.d.a.j.a(null);
        if (com.tencent.mm.plugin.shake.d.a.j.oCT) {
            com.tencent.mm.plugin.shake.d.a.j.oCT = false;
            if (!a.qvW.bsN()) {
                x.e("Micromsg.ShakeMusicMgr", "release MusicFingerPrintRecorder error");
            }
        }
        com.tencent.mm.plugin.shake.d.a.j.qvX = null;
        j.c((com.tencent.mm.platformtools.j.a) this);
        com.tencent.mm.sdk.b.a.xmy.c(this.qyj);
        com.tencent.mm.sdk.b.a.xmy.c(this.qyk);
        as.Hm();
        com.tencent.mm.y.c.Db().a(com.tencent.mm.storage.w.a.USERINFO_IBEACON_PUSH_IS_IN_SHAKEUI_BOOLEAN, Boolean.valueOf(false));
        bsW();
        if (com.tencent.mm.plugin.shake.c.c.a.bsL()) {
            com.tencent.mm.r.c.Bx().p(262154, false);
        }
        btc();
        com.tencent.mm.plugin.shake.c.a.f bsr = m.bsr();
        if (bsr.kOg != null && this != null) {
            while (true) {
                boolean z2 = z;
                if (z2 >= bsr.kOg.size()) {
                    break;
                }
                WeakReference weakReference = (WeakReference) bsr.kOg.get(z2);
                if (weakReference != null) {
                    com.tencent.mm.plugin.shake.c.a.f.a aVar = (com.tencent.mm.plugin.shake.c.a.f.a) weakReference.get();
                    if (aVar != null && aVar.equals(this)) {
                        bsr.kOg.remove(weakReference);
                        break;
                    }
                }
                z = z2 + 1;
            }
        }
        com.tencent.mm.plugin.shake.c.a.d bss = m.bss();
        bss.gAh = -85.0f;
        bss.gAi = -1000.0f;
        if (this.gAg != null) {
            this.gAg.c(this.gAn);
        }
        super.onDestroy();
    }

    private void bsV() {
        if (bth() && BluetoothAdapter.getDefaultAdapter() != null) {
            List<String> zU = com.tencent.mm.j.g.Ag().zU();
            if (zU != null) {
                this.qyh = System.currentTimeMillis();
                for (String str : zU) {
                    x.i("MicroMsg.ShakeReportUI", "op=true,iBeacon = %s", str);
                    com.tencent.mm.sdk.b.b dkVar = new dk();
                    dkVar.fsP.fsR = str;
                    dkVar.fsP.fsO = true;
                    com.tencent.mm.sdk.b.a.xmy.m(dkVar);
                }
            }
        }
    }

    private void bsW() {
        as.Hm();
        if (!Boolean.valueOf(bi.a((Boolean) com.tencent.mm.y.c.Db().get(com.tencent.mm.storage.w.a.USERINFO_IBEACON_PUSH_IS_IN_SHAKEUI_BOOLEAN, null), false)).booleanValue()) {
            this.gAk.clear();
            gAl = new CopyOnWriteArrayList();
        }
        if (VERSION.SDK_INT >= 18) {
            List<String> zU = com.tencent.mm.j.g.Ag().zU();
            if (zU != null) {
                for (String str : zU) {
                    com.tencent.mm.sdk.b.b dkVar = new dk();
                    x.i("MicroMsg.ShakeReportUI", "op=false,iBeacon = %s", str);
                    dkVar.fsP.fsR = str;
                    dkVar.fsP.fsO = false;
                    com.tencent.mm.sdk.b.a.xmy.m(dkVar);
                }
            }
        }
    }

    protected final void initView() {
        com.tencent.mm.plugin.shake.c.c.a.bsg();
        this.qyb.put(Integer.valueOf(1), Boolean.valueOf(true));
        this.qyb.put(Integer.valueOf(3), Boolean.valueOf(false));
        this.qyb.put(Integer.valueOf(4), Boolean.valueOf(false));
        this.qyb.put(Integer.valueOf(5), Boolean.valueOf(false));
        this.qyb.put(Integer.valueOf(6), Boolean.valueOf(false));
        this.hEr = new com.tencent.mm.ap.a.a((Context) this);
        this.qxk = (TextView) findViewById(R.h.cNh);
        this.qxj = findViewById(R.h.cNx);
        this.qxl = (TextView) findViewById(R.h.cNc);
        this.qxm = (TextView) findViewById(R.h.cNg);
        this.qxO = findViewById(R.h.cNL);
        this.qxP = (ImageView) findViewById(R.h.cNz);
        this.qxQ = (ImageView) findViewById(R.h.cNB);
        this.qxR = (ImageView) findViewById(R.h.cND);
        this.qxS = (ImageView) findViewById(R.h.cNF);
        this.qxT = findViewById(R.h.cNA);
        this.qxU = findViewById(R.h.cNC);
        this.qxV = findViewById(R.h.cNE);
        this.qxW = findViewById(R.h.cNG);
        this.qxi = findViewById(R.h.cNf);
        this.qxi.setOnClickListener(this.qyl);
        this.ikl = (ImageView) this.qxi.findViewById(R.h.cMR);
        this.ikl.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (ShakeReportUI.this.qxM != 5) {
                    ShakeReportUI.this.qxh = new f(ShakeReportUI.this, (String) ShakeReportUI.this.qxi.getTag(), null, com.tencent.mm.pluginsdk.ui.f.a.vqE);
                    ShakeReportUI.this.qxh.caN();
                }
            }
        });
        bsX();
        View inflate = View.inflate(this.mController.xRr, R.i.dsB, null);
        this.qxC = new com.tencent.mm.ui.base.k(this.mController.xRr, R.m.eZl);
        this.qxC.setContentView(inflate);
        this.qxC.setOnCancelListener(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                Looper.myQueue().addIdleHandler(new IdleHandler() {
                    public final boolean queueIdle() {
                        u.a(ShakeReportUI.this, 0, ShakeReportUI.this.getString(R.l.ePi));
                        as.Hm();
                        com.tencent.mm.y.c.Db().set(4117, Boolean.valueOf(true));
                        return false;
                    }
                });
            }
        });
        ((Button) inflate.findViewById(R.h.cML)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                ShakeReportUI.this.qxC.cancel();
            }
        });
        as.Hm();
        boolean c = bi.c((Boolean) com.tencent.mm.y.c.Db().get(4108, null));
        as.Hm();
        boolean c2 = bi.c((Boolean) com.tencent.mm.y.c.Db().get(4117, null));
        if (!c) {
            inflate.setVisibility(0);
            this.qxC.show();
            as.Hm();
            com.tencent.mm.y.c.Db().set(4108, Boolean.valueOf(true));
        } else if (!c2) {
            Looper.myQueue().addIdleHandler(new IdleHandler() {
                public final boolean queueIdle() {
                    u.a(ShakeReportUI.this, 0, ShakeReportUI.this.getString(R.l.ePi));
                    as.Hm();
                    com.tencent.mm.y.c.Db().set(4117, Boolean.valueOf(true));
                    return false;
                }
            });
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ShakeReportUI.this.qxa = false;
                ShakeReportUI.this.finish();
                return true;
            }
        });
        addIconOptionMenu(0, R.l.dCy, R.k.dvn, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ShakeReportUI.this.qxa = false;
                Intent intent = new Intent();
                intent.setClass(ShakeReportUI.this, ShakePersonalInfoUI.class);
                ShakeReportUI.this.startActivityForResult(intent, 3);
                return true;
            }
        });
        OnClickListener anonymousClass29 = new OnClickListener() {
            public final void onClick(View view) {
                ShakeReportUI.this.ct(view);
            }
        };
        if (this.qyf || this.qyd) {
            this.qxD = (ImageView) findViewById(R.h.cNq);
        } else {
            this.qxD = (ImageView) findViewById(R.h.cNp);
        }
        this.qxF = (ImageView) findViewById(R.h.cNm);
        this.qxG = (ImageView) findViewById(R.h.cNs);
        this.qxH = (ImageView) findViewById(R.h.cNv);
        this.qxI = (ImageView) findViewById(R.h.cNi);
        this.qxL = (TextView) findViewById(R.h.cNl);
        this.qxK = (ImageView) findViewById(R.h.cNk);
        this.qxJ = (ImageView) findViewById(R.h.cNu);
        bte();
        this.qxX.setOnClickListener(anonymousClass29);
        findViewById(R.h.cNr).setOnClickListener(anonymousClass29);
        findViewById(R.h.cNn).setOnClickListener(anonymousClass29);
        findViewById(R.h.cNt).setOnClickListener(anonymousClass29);
        findViewById(R.h.cNw).setOnClickListener(anonymousClass29);
        findViewById(R.h.cNj).setOnClickListener(anonymousClass29);
        com.tencent.mm.sdk.b.a.xmy.b(this.qyj);
        com.tencent.mm.sdk.b.a.xmy.b(this.qyk);
        bta();
        btd();
        ic(true);
    }

    private void bsX() {
        as.Hm();
        int a = bi.a((Integer) com.tencent.mm.y.c.Db().get(12290, null), 0);
        ImageView imageView = (ImageView) findViewById(R.h.cNd);
        if (!(this.qxB == null || this.qxB.isRecycled())) {
            this.qxB.recycle();
        }
        as.Hm();
        if (bi.b((Boolean) com.tencent.mm.y.c.Db().get(4110, null))) {
            StringBuilder stringBuilder = new StringBuilder();
            as.Hm();
            String stringBuilder2 = stringBuilder.append(com.tencent.mm.y.c.Fp()).append("default_shake_img_filename.jpg").toString();
            if (com.tencent.mm.a.e.bO(stringBuilder2)) {
                this.qxB = j.oH(stringBuilder2);
                imageView.setImageDrawable(new BitmapDrawable(this.qxB));
            } else {
                Drawable bitmapDrawable;
                try {
                    bitmapDrawable = new BitmapDrawable(com.tencent.mm.sdk.platformtools.d.decodeStream(this.mController.xRr.getAssets().open("resource/shakehideimg_man.jpg")));
                } catch (IOException e) {
                    x.w("MicroMsg.ShakeReportUI", "Bg decode exp:" + e.getLocalizedMessage());
                    bitmapDrawable = null;
                }
                imageView.setImageDrawable(bitmapDrawable);
            }
        } else {
            as.Hm();
            this.qxB = j.oH((String) com.tencent.mm.y.c.Db().get(4111, null));
            imageView.setImageDrawable(new BitmapDrawable(this.qxB));
        }
        imageView = (ImageView) findViewById(R.h.bGc);
        ImageView imageView2 = (ImageView) findViewById(R.h.bFZ);
        imageView.setImageResource(a == 2 ? R.g.bGb : R.g.bGc);
        imageView2.setImageResource(a == 2 ? R.g.bGa : R.g.bFZ);
        OnClickListener anonymousClass7 = new OnClickListener() {
            public final void onClick(View view) {
                if (ShakeReportUI.this.qwY) {
                    ShakeReportUI.this.qxc = false;
                    ShakeReportUI.this.qwX = true;
                    ShakeReportUI.this.ib(false);
                    com.tencent.mm.ui.base.h.a(ShakeReportUI.this.mController.xRr, null, new String[]{ShakeReportUI.this.getString(R.l.eOK)}, "", new com.tencent.mm.ui.base.h.c() {
                        public final void jo(int i) {
                            ShakeReportUI.this.qxc = true;
                            switch (i) {
                                case 0:
                                    com.tencent.mm.pluginsdk.ui.tools.k.a(ShakeReportUI.this, 1, null);
                                    return;
                                default:
                                    return;
                            }
                        }
                    }, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            ShakeReportUI.this.qxc = true;
                        }
                    });
                }
            }
        };
        imageView.setOnClickListener(anonymousClass7);
        imageView2.setOnClickListener(anonymousClass7);
        if (this.qxp == null) {
            this.qxp = findViewById(R.h.cMO);
        }
        this.qxp.setOnClickListener(anonymousClass7);
        if (this.qxq == null) {
            this.qxq = findViewById(R.h.cMP);
        }
        this.qxq.setOnClickListener(anonymousClass7);
    }

    private void hX(boolean z) {
        String format = String.format("%1$s-shaketype-%2$d", new Object[]{getClass().getName(), Integer.valueOf(4)});
        x.d("MicroMsg.ShakeReportUI", "activate change report , class name=" + format + ", isActive=" + z);
        ac.a(z, new Intent().putExtra("classname", format));
    }

    private void bsY() {
        l.b bVar;
        if (this.qxM == 3 && com.tencent.mm.au.c.QE()) {
            this.qxM = 3;
            this.qxm.setText(R.l.ePg);
            this.qxD.setBackgroundResource(R.g.bFR);
            this.qxF.setBackgroundResource(R.g.bFV);
            this.qxG.setBackgroundResource(R.g.bFU);
            this.qxH.setBackgroundResource(R.g.bFX);
            this.qxI.setBackgroundResource(R.g.bFP);
            findViewById(R.h.cNe).setVisibility(0);
            setMMTitle(R.l.ePc);
            g.pWK.h(11720, Integer.valueOf(2));
            g.pWK.h(834, 2);
        } else if (this.qxM == 4 && k.bsk()) {
            this.qxM = 4;
            this.qxm.setText(R.l.ePh);
            this.qxD.setBackgroundResource(R.g.bFR);
            this.qxF.setBackgroundResource(R.g.bFV);
            this.qxG.setBackgroundResource(R.g.bFT);
            this.qxH.setBackgroundResource(R.g.bFY);
            this.qxI.setBackgroundResource(R.g.bFP);
            findViewById(R.h.cNe).setVisibility(0);
            setMMTitle(R.l.ePd);
            g.pWK.h(11720, Integer.valueOf(3));
            g.pWK.h(834, 3);
        } else if (this.qxM == 5 && btg()) {
            this.qxM = 5;
            this.qxm.setText(R.l.ePf);
            this.qxD.setBackgroundResource(R.g.bFS);
            this.qxF.setBackgroundResource(R.g.bFV);
            this.qxG.setBackgroundResource(R.g.bFT);
            this.qxH.setBackgroundResource(R.g.bFX);
            this.qxI.setBackgroundResource(R.g.bFP);
            findViewById(R.h.cNe).setVisibility(0);
            setMMTitle(R.l.ePb);
            g.pWK.h(11720, Integer.valueOf(4));
            g.pWK.h(834, 4);
        } else if (this.qxM == 6 && com.tencent.mm.plugin.shake.c.c.a.bsL()) {
            this.qxM = 6;
            this.qxm.setText(R.l.ePe);
            this.qxD.setBackgroundResource(R.g.bFR);
            this.qxF.setBackgroundResource(R.g.bFV);
            this.qxG.setBackgroundResource(R.g.bFT);
            this.qxH.setBackgroundResource(R.g.bFX);
            this.qxI.setBackgroundResource(R.g.bFQ);
            findViewById(R.h.cNe).setVisibility(0);
            setMMTitle(R.l.ePa);
            btb();
            bte();
            g.pWK.h(11720, Integer.valueOf(5));
            g.pWK.h(834, 5);
        } else {
            this.qxM = 1;
            this.qxm.setText(R.l.eOt);
            this.qxD.setBackgroundResource(R.g.bFR);
            this.qxF.setBackgroundResource(R.g.bFW);
            this.qxG.setBackgroundResource(R.g.bFT);
            this.qxH.setBackgroundResource(R.g.bFX);
            this.qxI.setBackgroundResource(R.g.bFP);
            if (com.tencent.mm.au.c.QE()) {
                findViewById(R.h.cNe).setVisibility(0);
            }
            setMMTitle(R.l.eOZ);
            g.pWK.h(11720, Integer.valueOf(1));
            g.pWK.h(834, 1);
        }
        l lVar = this.qxg;
        int i = this.qxM;
        if (i == lVar.qtR) {
            bVar = lVar.qtS;
        } else {
            if (lVar.qtS != null) {
                lVar.qtS.brZ();
            }
            switch (i) {
                case 1:
                    lVar.qtS = new com.tencent.mm.plugin.shake.b.c(this, this);
                    break;
                case 3:
                    lVar.qtS = com.tencent.mm.plugin.shake.d.a.j.a((com.tencent.mm.plugin.shake.b.l.a) this);
                    break;
                case 4:
                    lVar.qtS = new com.tencent.mm.plugin.shake.d.a.l(this, this);
                    break;
                case 5:
                    lVar.qtS = new h(this);
                    break;
                case 6:
                    lVar.qtS = new com.tencent.mm.plugin.shake.c.a.g(this);
                    break;
            }
            lVar.qtR = i;
            lVar.qtS.init();
            bVar = lVar.qtS;
        }
        if (!this.qxa) {
            ib(false);
        }
        if (com.tencent.mm.plugin.shake.c.c.a.bsL() && (bVar instanceof com.tencent.mm.plugin.shake.c.a.g)) {
            com.tencent.mm.plugin.shake.c.a.g gVar = (com.tencent.mm.plugin.shake.c.a.g) bVar;
            int i2 = this.qxY;
            gVar.kKY = i2;
            x.i("MicroMsg.ShakeCardService", "ShakeCardService from_scene:" + i2);
            if (this.qxY == 3) {
                x.i("MicroMsg.ShakeReportUI", "open shake card from specialview");
                com.tencent.mm.plugin.shake.c.a.g gVar2 = (com.tencent.mm.plugin.shake.c.a.g) bVar;
                String stringExtra = getIntent().getStringExtra("key_shake_card_ext_info");
                if (stringExtra == null || stringExtra.length() > 256) {
                    x.i("MicroMsg.ShakeCardService", "ShakeCardService ext_info size > 256 byte, extinfo:" + stringExtra);
                    return;
                }
                x.i("MicroMsg.ShakeCardService", "ShakeCardService mExtInfo:" + gVar2.jfO);
                gVar2.jfO = stringExtra;
            }
        }
    }

    private void bsZ() {
        as.Hm();
        this.qwZ = bi.b((Boolean) com.tencent.mm.y.c.Db().get(4112, null));
        if (this.qwZ) {
            setTitleMuteIconVisibility(8);
        } else {
            setTitleMuteIconVisibility(0);
        }
    }

    private void hY(boolean z) {
        com.tencent.mm.plugin.shake.b.f fVar = null;
        hZ(z);
        if (this.qxw == null) {
            this.qxw = findViewById(R.h.cnS);
        }
        if (z) {
            if (m.bsn().Tx() <= 0) {
                this.qxw.setVisibility(8);
                return;
            }
            if (this.qxy == null) {
                this.qxy = (TextView) this.qxw.findViewById(R.h.cMV);
            }
            this.qxy.setText(getString(R.l.eOR, new Object[]{Integer.valueOf(r2)}));
            this.qxw.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    Intent intent = new Intent(ShakeReportUI.this, ShakeMsgListUI.class);
                    intent.putExtra("shake_msg_from", 1);
                    intent.putExtra("shake_msg_list_title", ShakeReportUI.this.getString(R.l.ePq));
                    ShakeReportUI.this.startActivity(intent);
                }
            });
            if (this.qxx == null) {
                this.qxx = (MMImageView) findViewById(R.h.cNb);
            }
            com.tencent.mm.plugin.shake.b.g bsn = m.bsn();
            Cursor a = bsn.gLA.a("SELECT * FROM " + bsn.getTableName() + " where status != 1 ORDER BY rowid" + " DESC LIMIT 1", null, 2);
            if (a != null) {
                com.tencent.mm.plugin.shake.b.f fVar2;
                if (a.moveToFirst()) {
                    fVar2 = new com.tencent.mm.plugin.shake.b.f();
                    fVar2.b(a);
                } else {
                    fVar2 = null;
                }
                a.close();
                fVar = fVar2;
            }
            if (fVar != null) {
                String str = fVar.field_thumburl;
                if (bi.oN(str)) {
                    this.qxx.setImageResource(R.k.dvO);
                } else {
                    i bVar = new com.tencent.mm.plugin.shake.e.b(str);
                    Bitmap a2 = j.a(bVar);
                    this.qxx.setTag(bVar.Wq());
                    if (a2 == null || a2.isRecycled()) {
                        this.qxx.setImageResource(R.k.dvO);
                    } else {
                        this.qxx.setImageBitmap(a2);
                    }
                }
            }
            this.qxw.setVisibility(0);
            return;
        }
        this.qxw.setVisibility(8);
    }

    private void hZ(boolean z) {
        if (this.qxv == null) {
            this.qxv = findViewById(R.h.cnR);
        }
        if (this.qxg.qtR == 3 || this.qxg.qtR == 4 || this.qxg.qtR == 5 || this.qxg.qtR == 6 || !z) {
            this.qxv.setVisibility(8);
            return;
        }
        int Tx = com.tencent.mm.be.l.TG().Tx();
        if (Tx <= 0) {
            this.qxv.setVisibility(8);
            return;
        }
        this.qxv.setVisibility(0);
        ((TextView) this.qxv.findViewById(R.h.cIO)).setText(getResources().getQuantityString(R.j.duV, Tx, new Object[]{Integer.valueOf(Tx)}));
        this.qxv.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent(ShakeReportUI.this, ShakeSayHiListUI.class);
                intent.putExtra("IntentSayHiType", 1);
                ShakeReportUI.this.startActivity(intent);
            }
        });
        if (this.qxz == null) {
            this.qxz = (ImageView) findViewById(R.h.cvy);
        }
        com.tencent.mm.be.j TB = com.tencent.mm.be.l.TG().TB();
        if (TB != null) {
            this.qxA = TB.field_sayhiuser;
            com.tencent.mm.pluginsdk.ui.a.b.a(this.qxz, this.qxA);
        }
    }

    private void ia(boolean z) {
        if (this.qxl == null) {
            return;
        }
        if (z) {
            this.qxl.setVisibility(0);
            return;
        }
        this.qxl.setVisibility(8);
        this.qxl.cancelLongPress();
    }

    private void ib(boolean z) {
        if (this.qxj == null) {
            return;
        }
        if (z) {
            this.qxj.setVisibility(0);
        } else {
            this.qxj.setVisibility(4);
        }
    }

    private void wA(int i) {
        ib(i == 1);
        if (i == 2) {
            ia(true);
        } else {
            ia(false);
        }
    }

    public final void Hd() {
        bsY();
    }

    private void JS(String str) {
        this.qxa = false;
        if (this.qwZ) {
            com.tencent.mm.sdk.platformtools.as.H(this.mController.xRr, R.l.eOX);
        }
        if (this.qxu == null) {
            this.qxu = AnimationUtils.loadAnimation(this.mController.xRr, R.a.bpY);
        }
        wA(2);
        if (str == null || str.length() <= 1) {
            this.qxl.setText(R.l.eOz);
        } else {
            this.qxl.setText(str);
        }
        this.qxl.startAnimation(this.qxu);
        this.qxd = true;
        ah.h(new Runnable() {
            public final void run() {
                ShakeReportUI.this.ia(false);
                ShakeReportUI.this.ib(false);
            }
        }, this.qxu.getDuration());
    }

    public final void d(List<d> list, long j) {
        ic(true);
        if (list == null || !this.qxa || j == 6) {
            this.qxE = null;
            if (j == 6) {
                JS(getString(R.l.eOH));
                return;
            } else if (j == 7) {
                JS(getString(R.l.eOF));
                return;
            } else if (j == 8) {
                JS(getString(R.l.eOD));
                return;
            } else if (j == 9) {
                JS(getString(R.l.eOC));
                return;
            } else if (j == 10) {
                JS(getString(R.l.eOG));
                return;
            } else {
                JS(null);
                return;
            }
        }
        this.qxa = false;
        if (list.size() > 0) {
            this.qxE = (d) list.get(0);
        }
        int size;
        d dVar;
        Intent intent;
        if (this.qxg.qtR == 1) {
            if (list.size() <= 0 || ((d) list.get(0)).field_type == 0) {
                this.qxe = ((d) list.get(0)).scene;
                size = list.size();
                if (size == 0) {
                    JS(null);
                    return;
                } else if (size == 1) {
                    x.i("MicroMsg.ShakeReportUI", "1 u:" + ((d) list.get(0)).field_username + " n:" + ((d) list.get(0)).field_nickname + " d:" + ((d) list.get(0)).field_distance);
                    if (this.qwZ) {
                        com.tencent.mm.sdk.platformtools.as.H(this.mController.xRr, R.l.eOP);
                    }
                    wA(3);
                    dVar = (d) list.get(0);
                    if (!bi.oN(dVar.field_username)) {
                        this.qxi.setTag(dVar.field_username);
                        this.qxi.setVisibility(0);
                        as.Hm();
                        ag Xv = com.tencent.mm.y.c.Ff().Xv(dVar.field_username);
                        String str = dVar.field_nickname + (com.tencent.mm.k.a.ga(Xv.field_type) ? getString(R.l.eOQ) : "");
                        if (dVar.field_sex == 1) {
                            this.qxi.setContentDescription(str + dVar.field_distance + this.mController.xRr.getString(R.l.ePl));
                        } else if (dVar.field_sex == 2) {
                            this.qxi.setContentDescription(str + dVar.field_distance + this.mController.xRr.getString(R.l.ePk));
                        } else {
                            this.qxi.setContentDescription(str + dVar.field_distance);
                        }
                        TextView textView = (TextView) this.qxi.findViewById(R.h.cMS);
                        textView.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this.mController.xRr, dVar.field_nickname + (com.tencent.mm.k.a.ga(Xv.field_type) ? getString(R.l.eOQ) : ""), textView.getTextSize()));
                        if (this.ikl != null) {
                            if (bi.oN(str)) {
                                this.ikl.setContentDescription(getString(R.l.eOp));
                            } else {
                                this.ikl.setContentDescription(String.format(getString(R.l.eOo), new Object[]{str}));
                            }
                        }
                        ((TextView) this.qxi.findViewById(R.h.cMQ)).setText(dVar.field_distance);
                        com.tencent.mm.pluginsdk.ui.a.b.a((ImageView) this.qxi.findViewById(R.h.cMR), dVar.field_username);
                        ImageView imageView = (ImageView) this.qxi.findViewById(R.h.cMU);
                        if (dVar.field_reserved1 != 0) {
                            imageView.setVisibility(0);
                            imageView.setImageBitmap(BackwardSupportUtil.b.b(com.tencent.mm.y.ak.a.hhx.gP(dVar.field_reserved1), 2.0f));
                        } else {
                            imageView.setVisibility(8);
                        }
                        if (dVar.field_reserved1 != 0 || dVar.field_sex == 0) {
                            this.qxi.findViewById(R.h.cMT).setVisibility(8);
                        } else {
                            Drawable b = com.tencent.mm.bu.a.b(this, dVar.field_sex == 1 ? R.k.dyY : R.k.dyX);
                            this.qxi.findViewById(R.h.cMT).setVisibility(0);
                            ((ImageView) this.qxi.findViewById(R.h.cMT)).setImageDrawable(b);
                        }
                        if (dVar.getProvince() == null) {
                            x.e("MicroMsg.ShakeReportUI", "PROVINCE NULL");
                            dVar.field_province = "";
                        }
                        if (dVar.getCity() == null) {
                            x.e("MicroMsg.ShakeReportUI", "CITY NULL");
                            dVar.field_city = "";
                        }
                        this.qxi.startAnimation(AnimationUtils.loadAnimation(this.mController.xRr, R.a.bqu));
                        return;
                    }
                    return;
                } else {
                    if (this.qwZ) {
                        com.tencent.mm.sdk.platformtools.as.H(this.mController.xRr, R.l.eOP);
                    }
                    wA(3);
                    hZ(false);
                    intent = new Intent(this, ShakeItemListUI.class);
                    intent.putExtra("_key_show_type_", -1);
                    intent.putExtra("_key_title_", getString(R.l.eOO));
                    startActivity(intent);
                    return;
                }
            }
            JS(null);
        } else if (this.qxg.qtR == 3) {
            size = list.size();
            if (size == 0) {
                JS(getString(R.l.eOW));
            } else if (size == 1) {
                if (this.qwZ) {
                    com.tencent.mm.sdk.platformtools.as.H(this.mController.xRr, R.l.eOP);
                }
                wA(3);
                if (((d) list.get(0)).field_type == 4) {
                    ati d = com.tencent.mm.plugin.shake.d.a.i.d(((d) list.get(0)).field_lvbuffer, j);
                    com.tencent.mm.au.b.c(d);
                    Intent intent2 = new Intent();
                    intent2.putExtra("key_mode", 1);
                    intent2.putExtra("key_offset", d.wHu);
                    intent2.putExtra("music_player_beg_time", d.qXq);
                    intent2.putExtra("key_scene", 3);
                    if (com.tencent.mm.au.c.QF()) {
                        intent2.putExtra("KGlobalShakeMusic", true);
                    }
                    com.tencent.mm.bl.d.b(this, "music", ".ui.MusicMainUI", intent2);
                    return;
                }
                x.w("MicroMsg.ShakeReportUI", "Unexpected type, ignore.");
            }
        } else if (this.qxg.qtR == 4) {
            ic(true);
            size = list.size();
            if (size == 0) {
                JS(getString(R.l.ePr));
            } else if (size == 1) {
                if (this.qwZ) {
                    com.tencent.mm.sdk.platformtools.as.H(this.mController.xRr, R.l.eOP);
                }
                wA(3);
                new com.tencent.mm.sdk.platformtools.ag().postDelayed(new com.tencent.mm.plugin.shake.d.a.k.AnonymousClass1((d) list.get(0), this), 100);
            }
        } else if (this.qxg.qtR == 5) {
            switch ((int) j) {
                case 1:
                    if (list.isEmpty() || ((d) list.get(0)).field_type != 11) {
                        JS(null);
                        return;
                    } else if (list.size() == 1) {
                        if (this.qwZ) {
                            com.tencent.mm.sdk.platformtools.as.H(this.mController.xRr, R.l.eOP);
                        }
                        wA(3);
                        dVar = (d) list.get(0);
                        if (!bi.oN(dVar.field_username)) {
                            this.qxi.setTag(dVar.field_username);
                            ((TextView) this.qxi.findViewById(R.h.cMS)).setText(dVar.field_username);
                            this.qxi.setContentDescription(bi.oM(dVar.field_nickname));
                            ((TextView) this.qxi.findViewById(R.h.cMQ)).setText(dVar.field_signature);
                            this.hEr.a(dVar.getProvince(), (ImageView) this.qxi.findViewById(R.h.cMR));
                            this.qxi.findViewById(R.h.cMT).setVisibility(8);
                            this.qxi.startAnimation(AnimationUtils.loadAnimation(this.mController.xRr, R.a.bqu));
                            this.qxi.setVisibility(0);
                            return;
                        }
                        return;
                    } else {
                        if (this.qwZ) {
                            com.tencent.mm.sdk.platformtools.as.H(this.mController.xRr, R.l.eOP);
                        }
                        wA(3);
                        hZ(false);
                        intent = new Intent(this, ShakeItemListUI.class);
                        intent.putExtra("_key_show_type_", -12);
                        intent.putExtra("_key_title_", getString(R.l.eON));
                        intent.putExtra("_key_show_from_shake_", true);
                        intent.putExtra("_ibeacon_new_insert_size", list.size());
                        startActivity(intent);
                        return;
                    }
                case 6:
                    JS(getString(R.l.eOH));
                    return;
                default:
                    return;
            }
        }
    }

    public final void a(int i, final com.tencent.mm.plugin.shake.c.a.e eVar, long j) {
        this.qya = true;
        if (i == 1251) {
            if (eVar != null) {
                x.i("MicroMsg.ShakeReportUI", "onShakeCardReturn MMFunc_Biz_GetLbsCard");
                com.tencent.mm.plugin.shake.c.c.a.bsg();
                btf();
                bta();
                btd();
                this.qxY = 4;
                m.bss().putValue("key_shake_card_item", eVar);
            }
        } else if (i != 1250) {
        } else {
            if (eVar == null) {
                this.qxE = null;
                JS(null);
            } else if ((eVar == null || this.qxa) && !this.qxa) {
                this.qxE = null;
                JS(null);
            } else {
                this.qxa = false;
                x.i("MicroMsg.ShakeReportUI", "onShakeCardReturn MMFunc_Biz_ShakeCard");
                if (this.qxg.qtR == 6) {
                    l.b bVar = this.qxg.qtS;
                    if (bVar != null && (bVar instanceof com.tencent.mm.plugin.shake.c.a.g)) {
                        com.tencent.mm.plugin.shake.c.a.g gVar = (com.tencent.mm.plugin.shake.c.a.g) bVar;
                        switch ((int) j) {
                            case 1:
                                x.i("MicroMsg.ShakeReportUI", "onShakeGetReturn() ShakeCardService RETURN_OK");
                                if (gVar.kRj == 3) {
                                    x.i("MicroMsg.ShakeReportUI", "onShakeGetReturn() actionType is  MMBIZ_SHAKE_CARD_ACTION_TYPE_NO_CARD");
                                    if (eVar == null || TextUtils.isEmpty(eVar.quv)) {
                                        JS(getString(R.l.eOq));
                                        return;
                                    } else {
                                        JS(eVar.quv);
                                        return;
                                    }
                                }
                                x.i("MicroMsg.ShakeReportUI", "onShakeGetReturn() actionType is " + gVar.kRj);
                                wA(3);
                                if (eVar.kRj == 1) {
                                    this.qxc = false;
                                }
                                if (this.qxZ != null && this.qxZ.isShowing()) {
                                    return;
                                }
                                if (eVar.qux) {
                                    ViewStub viewStub = (ViewStub) findViewById(R.h.cWa);
                                    if (viewStub != null) {
                                        viewStub.inflate();
                                    }
                                    ((ShakeEggAnimFrame) findViewById(R.h.bSO)).J(this);
                                    new com.tencent.mm.sdk.platformtools.ag().postDelayed(new Runnable() {
                                        public final void run() {
                                            ShakeReportUI.this.a(eVar);
                                        }
                                    }, 1000);
                                    return;
                                }
                                a(eVar);
                                return;
                            case 2:
                                x.i("MicroMsg.ShakeReportUI", "onShakeGetReturn() ShakeCardService RETURN_ERR_REPORT");
                                JS(getString(R.l.eOq));
                                return;
                            default:
                                return;
                        }
                    }
                }
            }
        }
    }

    private void a(com.tencent.mm.plugin.shake.c.a.e eVar) {
        this.qxZ = com.tencent.mm.plugin.shake.c.b.a.a(this, eVar, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                dialogInterface.dismiss();
                ShakeReportUI.this.qxc = true;
                ShakeReportUI.this.qxZ = null;
                ShakeReportUI.this.qxm.setText("");
            }
        }, new com.tencent.mm.plugin.shake.c.b.a.b() {
            public final void bsB() {
                ShakeReportUI.this.qxc = true;
                ShakeReportUI.this.qxm.setText("");
            }
        });
    }

    private void ct(View view) {
        if (view != null) {
            x.i("MicroMsg.ShakeReportUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.RECORD_AUDIO", 80, "", "")), bi.chl(), this);
            if (com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.RECORD_AUDIO", 80, "", "")) {
                az("", false);
                if (view.getId() == R.h.cNn) {
                    g.pWK.h(11722, Integer.valueOf(1));
                    if (this.qxM != 1) {
                        if (this.qxM == 4) {
                            hX(false);
                        }
                        this.qxM = 1;
                        bsY();
                        hZ(false);
                        if (this.qxi != null) {
                            this.qxi.setVisibility(8);
                        }
                    }
                } else if (view.getId() == R.h.cNt) {
                    g.pWK.h(11722, Integer.valueOf(2));
                    if (!(this.gAj || this.gAg == null)) {
                        this.gAg.a(this.gAn, true);
                    }
                    if (!(com.tencent.mm.o.a.aW(this) || com.tencent.mm.o.a.aU(this) || this.qxM == 3)) {
                        if (this.qxM == 4) {
                            hX(false);
                        }
                        this.qxM = 3;
                        bsY();
                        hZ(false);
                        if (this.qxi != null) {
                            this.qxi.setVisibility(8);
                        }
                    }
                    if (com.tencent.mm.au.c.QF()) {
                        as.Hm();
                        if (com.tencent.mm.y.c.Db().getInt(4118, 0) == 0) {
                            com.tencent.mm.ui.base.i.a aVar = new com.tencent.mm.ui.base.i.a(this.mController.xRr);
                            aVar.ES(R.l.dGZ);
                            aVar.ET(R.l.eOJ);
                            aVar.EV(R.l.eOI).a(new DialogInterface.OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    if (ShakeReportUI.this.qxC != null) {
                                        ShakeReportUI.this.qxC.cancel();
                                    }
                                }
                            });
                            aVar.mp(true);
                            aVar.d(new OnCancelListener() {
                                public final void onCancel(DialogInterface dialogInterface) {
                                    as.Hm();
                                    com.tencent.mm.y.c.Db().setInt(4118, 1);
                                    ShakeReportUI.this.qxJ.setVisibility(8);
                                }
                            });
                            this.qxC = aVar.ale();
                            this.qxC.show();
                        }
                    }
                } else if (view.getId() == R.h.cNw) {
                    g.pWK.h(11722, Integer.valueOf(3));
                    if (!(this.gAj || this.gAg == null)) {
                        this.gAg.a(this.gAn, true);
                    }
                    if (!(com.tencent.mm.o.a.aW(this) || com.tencent.mm.o.a.aU(this) || this.qxM == 4)) {
                        hX(true);
                        this.qxM = 4;
                        bsY();
                        hZ(false);
                        if (this.qxi != null) {
                            this.qxi.setVisibility(8);
                        }
                    }
                } else if (view.getId() == R.h.cNr || view.getId() == R.h.cNo) {
                    g.pWK.h(11722, Integer.valueOf(4));
                    if (this.qxM != 5) {
                        this.qxM = 5;
                        bsY();
                        hZ(false);
                        if (this.qxi != null) {
                            this.qxi.setVisibility(8);
                        }
                        if (!(VERSION.RELEASE.equals("6.0") || VERSION.RELEASE.equals("6.0.0") || VERSION.SDK_INT < 23)) {
                            boolean isProviderEnabled;
                            LocationManager locationManager = (LocationManager) ad.getContext().getSystemService("location");
                            if (locationManager != null) {
                                isProviderEnabled = locationManager.isProviderEnabled("gps");
                            } else {
                                isProviderEnabled = true;
                            }
                            if (!isProviderEnabled) {
                                JS(getString(R.l.eOD));
                            }
                        }
                        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                        if (defaultAdapter != null && defaultAdapter.getState() != 12) {
                            JS(getString(R.l.eOC));
                        } else if (defaultAdapter == null) {
                            JS(getString(R.l.eOG));
                        }
                    }
                } else if (view.getId() == R.h.cNj) {
                    g.pWK.h(11722, Integer.valueOf(5));
                    if (this.qxM != 6) {
                        if (this.qxM == 4) {
                            hX(false);
                        }
                        this.qxM = 6;
                        bsY();
                        hZ(false);
                        if (this.qxi != null) {
                            this.qxi.setVisibility(8);
                        }
                        com.tencent.mm.r.c.Bx().p(262155, false);
                        this.qxK.setVisibility(8);
                    }
                }
                hY(true);
                ib(false);
                ic(true);
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 1:
                if (intent != null) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("CropImageMode", 4);
                    intent2.putExtra("CropImage_Filter", true);
                    intent2.putExtra("CropImage_DirectlyIntoFilter", true);
                    StringBuilder stringBuilder = new StringBuilder();
                    as.Hm();
                    intent2.putExtra("CropImage_OutputPath", stringBuilder.append(com.tencent.mm.y.c.Fp()).append("custom_shake_img_filename.jpg").toString());
                    com.tencent.mm.plugin.shake.a.ihN.a(intent2, 2, this, intent);
                    return;
                }
                return;
            case 2:
                if (intent != null) {
                    String stringExtra = intent.getStringExtra("CropImage_OutputPath");
                    as.Hm();
                    com.tencent.mm.y.c.Db().set(4110, Boolean.valueOf(false));
                    as.Hm();
                    com.tencent.mm.y.c.Db().set(4111, stringExtra);
                    bsX();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
        bsZ();
        if (!this.qxb) {
            hY(true);
        }
    }

    public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
        a("", null);
    }

    public final void l(String str, Bitmap bitmap) {
        if (str != null && bitmap != null && !bitmap.isRecycled() && this.qxx != null && this.qxx.getTag() != null && str.equals((String) this.qxx.getTag())) {
            this.qxx.setImageBitmap(bitmap);
        }
    }

    public final void bsv() {
        com.tencent.mm.plugin.shake.c.c.a.bsg();
        bta();
        btb();
        bte();
        btf();
        btd();
    }

    private void bta() {
        if (!com.tencent.mm.plugin.shake.c.c.a.bsL()) {
            return;
        }
        if (com.tencent.mm.r.c.Bx().aR(262155, 266259)) {
            this.qxK.setVisibility(0);
        } else {
            this.qxK.setVisibility(8);
        }
    }

    private void btb() {
        if (this.qxM == 6 && com.tencent.mm.plugin.shake.c.c.a.bsL()) {
            boolean aR = com.tencent.mm.r.c.Bx().aR(262154, 266258);
            boolean aR2 = com.tencent.mm.r.c.Bx().aR(262155, 266259);
            if (aR) {
                az(com.tencent.mm.plugin.shake.c.c.a.bsG(), true);
            } else if (aR2) {
                az(com.tencent.mm.plugin.shake.c.c.a.bsI(), true);
            } else if (!this.qya) {
                if (TextUtils.isEmpty(com.tencent.mm.plugin.shake.c.c.a.bsE())) {
                    az(getString(R.l.eOr), true);
                } else {
                    az(com.tencent.mm.plugin.shake.c.c.a.bsE(), true);
                }
            }
        }
    }

    private void az(String str, boolean z) {
        this.qxa = false;
        if (this.qxu == null) {
            this.qxu = AnimationUtils.loadAnimation(this.mController.xRr, R.a.bpY);
        }
        wA(2);
        ia(true);
        if (str != null && str.length() > 1) {
            this.qxl.setText(str);
        } else if (z) {
            this.qxl.setText(R.l.eOr);
        } else {
            this.qxl.setText("");
            ia(false);
        }
        this.qxd = true;
    }

    private void btc() {
        if (this.qxZ != null && this.qxZ.isShowing()) {
            this.qxZ.dismiss();
        }
        this.qxZ = null;
    }

    private void btd() {
        int intExtra;
        int i;
        int i2 = 1;
        boolean bsh = com.tencent.mm.plugin.shake.c.c.a.bsh();
        boolean aR = com.tencent.mm.r.c.Bx().aR(262154, 266258);
        boolean aR2 = com.tencent.mm.r.c.Bx().aR(262155, 266259);
        if (getIntent().getBooleanExtra("shake_card", false)) {
            intExtra = getIntent().getIntExtra("shake_card", 0);
        } else {
            intExtra = 0;
        }
        g gVar = g.pWK;
        Object[] objArr = new Object[6];
        objArr[0] = Integer.valueOf(1);
        objArr[1] = Integer.valueOf(intExtra);
        if (aR) {
            i = 1;
        } else {
            i = 0;
        }
        objArr[2] = Integer.valueOf(i);
        objArr[3] = Integer.valueOf(bsh ? 1 : 0);
        objArr[4] = com.tencent.mm.plugin.shake.c.c.a.bsH();
        objArr[5] = Integer.valueOf(com.tencent.mm.plugin.shake.c.c.a.bsD());
        gVar.h(11668, objArr);
        g gVar2 = g.pWK;
        Object[] objArr2 = new Object[6];
        objArr2[0] = Integer.valueOf(2);
        objArr2[1] = Integer.valueOf(intExtra);
        if (aR2) {
            intExtra = 1;
        } else {
            intExtra = 0;
        }
        objArr2[2] = Integer.valueOf(intExtra);
        if (!bsh) {
            i2 = 0;
        }
        objArr2[3] = Integer.valueOf(i2);
        objArr2[4] = com.tencent.mm.plugin.shake.c.c.a.bsH();
        objArr2[5] = Integer.valueOf(com.tencent.mm.plugin.shake.c.c.a.bsD());
        gVar2.h(11668, objArr2);
    }

    private void bte() {
        if (!TextUtils.isEmpty(com.tencent.mm.plugin.shake.c.c.a.bsF())) {
            this.qxL.setText(com.tencent.mm.plugin.shake.c.c.a.bsF());
        }
    }

    private void btf() {
        if (com.tencent.mm.au.c.QE()) {
            x.i("MicroMsg.ShakeReportUI", "is not oversea user, show shake music");
            this.qyb.put(Integer.valueOf(3), Boolean.valueOf(true));
            findViewById(R.h.cNt).setVisibility(0);
            if (com.tencent.mm.au.c.QF()) {
                as.Hm();
                if (com.tencent.mm.y.c.Db().getInt(4118, 0) == 0) {
                    this.qxJ.setVisibility(0);
                } else {
                    this.qxJ.setVisibility(8);
                }
            }
        } else {
            this.qyb.put(Integer.valueOf(3), Boolean.valueOf(false));
            findViewById(R.h.cNt).setVisibility(8);
            x.i("MicroMsg.ShakeReportUI", "is oversea user, hide shake music");
        }
        if (k.bsk()) {
            this.qyb.put(Integer.valueOf(4), Boolean.valueOf(true));
            findViewById(R.h.cNw).setVisibility(0);
            x.i("MicroMsg.ShakeReportUI", "show shake tv tab");
        } else {
            this.qyb.put(Integer.valueOf(4), Boolean.valueOf(false));
            findViewById(R.h.cNw).setVisibility(8);
            x.i("MicroMsg.ShakeReportUI", "hide shake tv tab");
        }
        if (com.tencent.mm.plugin.shake.c.c.a.bsL()) {
            this.qyb.put(Integer.valueOf(6), Boolean.valueOf(true));
            findViewById(R.h.cNj).setVisibility(0);
            x.i("MicroMsg.ShakeReportUI", "show shake card tab");
        } else {
            findViewById(R.h.cNj).setVisibility(8);
            this.qyb.put(Integer.valueOf(6), Boolean.valueOf(false));
            x.i("MicroMsg.ShakeReportUI", "hide shake card tab");
        }
        if (btg()) {
            this.qyb.put(Integer.valueOf(5), Boolean.valueOf(true));
            this.qxX.setVisibility(0);
            x.i("MicroMsg.ShakeReportUI", "[shakezb]show shake ibeacon tab");
        } else {
            this.qyb.put(Integer.valueOf(5), Boolean.valueOf(false));
            this.qxX.setVisibility(8);
            x.i("MicroMsg.ShakeReportUI", "[shakezb]hide shake ibeacon tab");
        }
        int i = 0;
        for (Boolean booleanValue : this.qyb.values()) {
            int i2;
            if (booleanValue.booleanValue()) {
                i2 = i + 1;
            } else {
                i2 = i;
            }
            i = i2;
        }
        this.qxN = i;
        LinearLayout linearLayout = (LinearLayout) findViewById(R.h.cNe);
        if (i == 1) {
            linearLayout.setVisibility(8);
        } else {
            linearLayout.setVisibility(0);
        }
        if (i > 4 && this.qyi) {
            findViewById(R.h.cNw).setVisibility(8);
            x.i("MicroMsg.ShakeReportUI", "show tab count is > 4 and beaconMap.size() > 0.");
            this.qxN--;
        } else if (i > 4 && !this.qyi) {
            this.qxX.setVisibility(8);
            this.qyc = false;
            this.qxN--;
            x.i("MicroMsg.ShakeReportUI", "show tab count is > 4 and beaconMap.size() <= 0.");
        }
    }

    private boolean btg() {
        x.i("MicroMsg.ShakeReportUI", "[shakezb] isChineseAppLang :" + w.cfR() + " ,getApplicationLanguage[en or zh_CN or zh_HK or zh_TW is avaliable] :" + w.cfV());
        return this.qyc && bth();
    }

    private static boolean bth() {
        return w.cfR() || w.cfV().equals("en") || w.cfV().equals("ja");
    }

    private void ic(boolean z) {
        this.qxO.setVisibility(8);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            String str = "MicroMsg.ShakeReportUI";
            String str2 = "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(iArr == null ? -1 : iArr.length);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = strArr;
            objArr[3] = bi.chl();
            x.w(str, str2, objArr);
            return;
        }
        x.i("MicroMsg.ShakeReportUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 64:
                if (iArr[0] == 0) {
                    bmr();
                    return;
                }
                this.pEf = false;
                com.tencent.mm.ui.base.h.a((Context) this, getString(R.l.eAc), getString(R.l.eAg), getString(R.l.esG), getString(R.l.cancel), false, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        ShakeReportUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        ShakeReportUI.this.pEf = true;
                        ShakeReportUI.this.finish();
                    }
                }, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        ShakeReportUI.this.pEf = true;
                        ShakeReportUI.this.finish();
                    }
                });
                return;
            case 80:
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.h.a((Context) this, getString(R.l.eAd), getString(R.l.eAg), getString(R.l.esG), getString(R.l.cancel), false, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            ShakeReportUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                }
                return;
            default:
                return;
        }
    }
}
