package com.tencent.mm.plugin.sns.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.Fragment;
import android.support.v4.app.o;
import android.support.v4.view.ViewPager.e;
import android.support.v4.view.ViewPager.h;
import android.support.v4.view.u;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Base64;
import android.view.Display;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.c.f;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdlandingRemoteServiceConnectedReceiver;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ac;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.w;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdlandingDummyViewPager;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.DummyViewPager;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.bnd;
import com.tencent.mm.protocal.c.bne;
import com.tencent.mm.protocal.c.bpb;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.snackbar.b.b;
import com.tencent.mm.ui.v;
import com.tencent.wcdb.FileUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class SnsAdNativeLandingPagesUI extends MMActivity {
    public static boolean rDU = false;
    int cPf;
    String fAR;
    private long gAW = 0;
    int hQn;
    String iYb;
    private long jNM = 0;
    private ImageView kIQ;
    private int kJB;
    private int kJC;
    private int kXN = 0;
    private int kXO = 0;
    private int kXP = 0;
    private int kXQ = 0;
    private boolean kra = false;
    String lUI;
    String lUJ;
    private ImageView mDh;
    private d mlo = new d(ad.getContext());
    protected b nfQ = new b() {
        public final void aQv() {
            try {
                AdLandingPagesProxy.getInstance().favEditTag();
            } catch (Exception e) {
                x.e("MicroMsg.SnsAdNativeLandingPagesUI", "favorite edittag fail, ex = " + e.getMessage());
            }
        }
    };
    public LinkedList<c> rDE = new LinkedList();
    private ImageView rDF;
    private ImageView rDG;
    private TextView rDH;
    Bundle rDI;
    b rDJ;
    private boolean rDK = false;
    String rDL;
    String rDM;
    private String rDN;
    String rDO;
    String rDP;
    String rDQ;
    private ImageView rDR;
    String rDS;
    String rDT;
    public Map<String, String> rDV = new HashMap();
    g rDW = new g();
    boolean rDX = false;
    private int rDY = 0;
    private boolean rDZ = false;
    String rEa;
    String rEb;
    String rEc;
    String rEd;
    private AdlandingDummyViewPager rEe;
    int rEf;
    int rEg;
    private ag rEh = new ag();
    private LinkedList<View> rEi;
    private boolean rEj = true;
    private View rEk;
    m rEl;
    private volatile int rEm = 2;
    private BroadcastReceiver rEn = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            int intExtra = intent.getIntExtra("show", 0);
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b bVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b) ((o) SnsAdNativeLandingPagesUI.this.rEe.yE).R(SnsAdNativeLandingPagesUI.this.rEe.yF);
            x.d("MicroMsg.SnsAdNativeLandingPagesUI", "recv videoProgressbarStatusChangeReceiver show %d", Integer.valueOf(intExtra));
            if (bVar.byu()) {
                bVar.byt();
            } else {
                bVar.bys();
            }
        }
    };
    private BroadcastReceiver rEo = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            SnsAdNativeLandingPagesUI.this.bAS();
        }
    };
    private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b.a rEp = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b.a() {
        public final void o(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b bVar) {
            final RecyclerView byq = bVar.byq();
            if (byq != null) {
                byq.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
                    public final boolean onPreDraw() {
                        byq.getViewTreeObserver().removeOnPreDrawListener(this);
                        SnsAdNativeLandingPagesUI.this.rEm = SnsAdNativeLandingPagesUI.this.rEm - 1;
                        SnsAdNativeLandingPagesUI.d(SnsAdNativeLandingPagesUI.this);
                        return true;
                    }
                });
            }
        }
    };
    private e rEq = new h() {
        public final void a(int i, float f, int i2) {
            super.a(i, f, i2);
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b e = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b) ((Fragment) SnsAdNativeLandingPagesUI.this.rEs.get(Integer.valueOf(((c) SnsAdNativeLandingPagesUI.this.rDE.get(SnsAdNativeLandingPagesUI.this.rEe.yF)).id))));
            if (e.rsW != null) {
                e.rsW.byi();
            }
            if (SnsAdNativeLandingPagesUI.this.mController.xRL == 1) {
                SnsAdNativeLandingPagesUI.this.aWY();
            }
        }

        public final void af(int i) {
            super.af(i);
            ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b) ((Fragment) SnsAdNativeLandingPagesUI.this.rEs.get(Integer.valueOf(((c) SnsAdNativeLandingPagesUI.this.rDE.get(SnsAdNativeLandingPagesUI.this.rEe.yF)).id)))).rtc = i;
            Fragment fragment;
            if (i == 1) {
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 < SnsAdNativeLandingPagesUI.this.rDE.size()) {
                        fragment = (Fragment) SnsAdNativeLandingPagesUI.this.rEs.get(Integer.valueOf(((c) SnsAdNativeLandingPagesUI.this.rDE.get(i3)).id));
                        if (fragment != null) {
                            ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b) fragment).bys();
                        }
                        i2 = i3 + 1;
                    } else {
                        ac.dx(SnsAdNativeLandingPagesUI.this.mController.xRr);
                        return;
                    }
                }
            } else if (i == 0) {
                fragment = (Fragment) SnsAdNativeLandingPagesUI.this.rEs.get(Integer.valueOf(((c) SnsAdNativeLandingPagesUI.this.rDE.get(SnsAdNativeLandingPagesUI.this.rEe.yF)).id));
                if (fragment != null) {
                    ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b) fragment).byt();
                }
            }
        }

        public final void ae(int i) {
            super.ae(i);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < SnsAdNativeLandingPagesUI.this.rDE.size()) {
                    Fragment fragment = (Fragment) SnsAdNativeLandingPagesUI.this.rEs.get(Integer.valueOf(((c) SnsAdNativeLandingPagesUI.this.rDE.get(i3)).id));
                    if (fragment != null) {
                        if (i3 == i) {
                            ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b) fragment).byt();
                        } else {
                            ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b) fragment).bys();
                        }
                    }
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }
    };
    private com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.a rEr = new com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.a() {
        public final void as(final Object obj) {
            SnsAdNativeLandingPagesUI.this.rEh.removeCallbacksAndMessages(null);
            SnsAdNativeLandingPagesUI.this.rEh.post(new Runnable() {
                public final void run() {
                    SnsAdNativeLandingPagesUI.this.rDE = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.c(SnsAdNativeLandingPagesUI.this.rDL, SnsAdNativeLandingPagesUI.this.rDM, (String) obj, SnsAdNativeLandingPagesUI.this.rkf, SnsAdNativeLandingPagesUI.this.iYb);
                    ah.y(new Runnable() {
                        public final void run() {
                            SnsAdNativeLandingPagesUI.l(SnsAdNativeLandingPagesUI.this);
                        }
                    });
                }
            });
        }

        public final void e(int i, int i2, Object obj) {
        }
    };
    private Map<Integer, Fragment> rEs = new HashMap();
    private boolean rEt = true;
    private boolean rEu = true;
    private BroadcastReceiver rEv = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
                x.d("MicroMsg.SnsAdNativeLandingPagesUI", "android.intent.action.SCREEN_OFF");
            } else if (intent.getAction().equals("android.intent.action.SCREEN_ON")) {
                x.d("MicroMsg.SnsAdNativeLandingPagesUI", "android.intent.action.SCREEN_ON");
                SnsAdNativeLandingPagesUI.this.bAS();
            }
        }
    };
    private j rEw = null;
    private r rEx = null;
    String rfQ;
    private int rkT;
    String rkf;
    String rkg;
    String rlx;
    private int rnb;
    int rnd;
    private int rql = 1000;
    private int rqm = 700;
    private int rqn = 250;
    z rsX;
    private View rts;
    private long startTime;
    String uin;
    Map<String, String> values;

    private class a {
        public String lUJ;
        public String rlx;
        public String rly;

        private a() {
            this.lUJ = "";
            this.rlx = "";
            this.rly = "";
        }

        /* synthetic */ a(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI, byte b) {
            this();
        }
    }

    static /* synthetic */ void M(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        if (snsAdNativeLandingPagesUI.rDE != null) {
            Iterator it = snsAdNativeLandingPagesUI.rDE.iterator();
            while (it.hasNext()) {
                com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b bVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b) snsAdNativeLandingPagesUI.rEs.get(Integer.valueOf(((c) it.next()).id));
                if (bVar != null) {
                    bVar.rta = true;
                }
            }
            ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b) snsAdNativeLandingPagesUI.rEs.get(Integer.valueOf(((c) snsAdNativeLandingPagesUI.rDE.getFirst()).id))).byt();
        }
    }

    static /* synthetic */ void O(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        for (i iVar : snsAdNativeLandingPagesUI.bAR()) {
            if (iVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) {
                ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) iVar).bxp();
            }
        }
    }

    static /* synthetic */ void W(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        x.i("MicroMsg.SnsAdNativeLandingPagesUI", "setFullScreen");
        if (VERSION.SDK_INT < 16) {
            snsAdNativeLandingPagesUI.getWindow().clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            return;
        }
        snsAdNativeLandingPagesUI.getWindow().getDecorView().setSystemUiVisibility(snsAdNativeLandingPagesUI.getWindow().getDecorView().getSystemUiVisibility() & -1025);
    }

    static /* synthetic */ void bBc() {
    }

    static /* synthetic */ void d(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        if (snsAdNativeLandingPagesUI.rEm == 0) {
            try {
                Map hashMap = new HashMap();
                hashMap.put("startIndex", Integer.valueOf(snsAdNativeLandingPagesUI.rDY));
                ((i) snsAdNativeLandingPagesUI.bAR().get(0)).Q(hashMap);
            } catch (Exception e) {
            }
            snsAdNativeLandingPagesUI.bAY();
            if (snsAdNativeLandingPagesUI.rEj && snsAdNativeLandingPagesUI.rEk != null && snsAdNativeLandingPagesUI.rDK) {
                snsAdNativeLandingPagesUI.rEj = false;
                snsAdNativeLandingPagesUI.kXN = snsAdNativeLandingPagesUI.getIntent().getIntExtra("img_gallery_top", 0);
                snsAdNativeLandingPagesUI.kXO = snsAdNativeLandingPagesUI.getIntent().getIntExtra("img_gallery_left", 0);
                snsAdNativeLandingPagesUI.kXP = snsAdNativeLandingPagesUI.getIntent().getIntExtra("img_gallery_width", 0);
                snsAdNativeLandingPagesUI.kXQ = snsAdNativeLandingPagesUI.getIntent().getIntExtra("img_gallery_height", 0);
                snsAdNativeLandingPagesUI.rDJ.r(snsAdNativeLandingPagesUI.kXO, snsAdNativeLandingPagesUI.kXN, snsAdNativeLandingPagesUI.kXP, snsAdNativeLandingPagesUI.kXQ);
                snsAdNativeLandingPagesUI.kIQ.setVisibility(8);
                snsAdNativeLandingPagesUI.rDF.setVisibility(8);
                b bVar = snsAdNativeLandingPagesUI.rDJ;
                View view = snsAdNativeLandingPagesUI.rEk;
                LinkedList linkedList = snsAdNativeLandingPagesUI.rEi;
                View view2 = snsAdNativeLandingPagesUI.mDh;
                snsAdNativeLandingPagesUI.isFullScreen();
                bVar.a(view, linkedList, view2, new b.b() {
                    public final void onAnimationStart() {
                        x.i("MicroMsg.SnsAdNativeLandingPagesUI", "enter anim start, isFirstAnimStart %s", Boolean.valueOf(SnsAdNativeLandingPagesUI.this.rEt));
                        if (SnsAdNativeLandingPagesUI.this.rEt) {
                            SnsAdNativeLandingPagesUI.this.rEt = false;
                            long currentTimeMillis = System.currentTimeMillis() - SnsAdNativeLandingPagesUI.this.gAW;
                            com.tencent.mm.plugin.report.service.g.pWK.h(14830, Long.valueOf(SnsAdNativeLandingPagesUI.this.gAW), Long.valueOf(currentTimeMillis));
                            x.i("MicroMsg.SnsAdNativeLandingPagesUI", "launch time %d", Long.valueOf(currentTimeMillis));
                        }
                    }

                    public final void onAnimationEnd() {
                        int i = 0;
                        x.i("MicroMsg.SnsAdNativeLandingPagesUI", "enter anim end");
                        if (SnsAdNativeLandingPagesUI.this.rEu) {
                            SnsAdNativeLandingPagesUI.this.rEu = false;
                            SnsAdNativeLandingPagesUI.l(SnsAdNativeLandingPagesUI.this);
                        }
                        SnsAdNativeLandingPagesUI.this.kIQ.setVisibility(0);
                        if (SnsAdNativeLandingPagesUI.this.bAT()) {
                            SnsAdNativeLandingPagesUI.this.rDF.setVisibility(0);
                        }
                        ImageView L = SnsAdNativeLandingPagesUI.this.rDG;
                        if (!SnsAdNativeLandingPagesUI.this.bAV()) {
                            i = 4;
                        }
                        L.setVisibility(i);
                        SnsAdNativeLandingPagesUI.this.setRequestedOrientation(1);
                        SnsAdNativeLandingPagesUI.bBc();
                        SnsAdNativeLandingPagesUI.M(SnsAdNativeLandingPagesUI.this);
                    }
                });
                return;
            }
            snsAdNativeLandingPagesUI.rts.post(new Runnable() {
                public final void run() {
                    SnsAdNativeLandingPagesUI.l(SnsAdNativeLandingPagesUI.this);
                    SnsAdNativeLandingPagesUI.this.setRequestedOrientation(1);
                    SnsAdNativeLandingPagesUI.bBc();
                    ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b) SnsAdNativeLandingPagesUI.this.rEs.get(Integer.valueOf(((c) SnsAdNativeLandingPagesUI.this.rDE.getFirst()).id))).byt();
                    SnsAdNativeLandingPagesUI.M(SnsAdNativeLandingPagesUI.this);
                }
            });
        }
    }

    static /* synthetic */ void l(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.c cVar;
        snsAdNativeLandingPagesUI.bAO();
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.c cVar2 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.c) snsAdNativeLandingPagesUI.rEe.yE;
        if (cVar2 == null) {
            u cVar3 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.c(snsAdNativeLandingPagesUI.getSupportFragmentManager(), new ArrayList());
            snsAdNativeLandingPagesUI.rEe.a(cVar3);
            cVar = cVar3;
        } else {
            cVar = cVar2;
        }
        int i = 0;
        while (i < snsAdNativeLandingPagesUI.rDE.size()) {
            c cVar4 = (c) snsAdNativeLandingPagesUI.rDE.get(i);
            if (cVar4.rmZ) {
                x.i("MicroMsg.SnsAdNativeLandingPagesUI", "loadLandingPages load %d", Integer.valueOf(i));
                Fragment fragment = (Fragment) snsAdNativeLandingPagesUI.rEs.get(Integer.valueOf(cVar4.id));
                if (fragment == null) {
                    fragment = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b.a(cVar4, snsAdNativeLandingPagesUI.rEe, snsAdNativeLandingPagesUI.rsX, i == snsAdNativeLandingPagesUI.rDE.size() + -1, i == 0 ? snsAdNativeLandingPagesUI.rEp : null, snsAdNativeLandingPagesUI.rDK, snsAdNativeLandingPagesUI.bAU());
                    snsAdNativeLandingPagesUI.rEs.put(Integer.valueOf(cVar4.id), fragment);
                } else {
                    ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b) fragment).a(cVar4);
                }
                if (fragment != null) {
                    cVar.a(fragment, i);
                }
            }
            i++;
        }
        cVar.notifyDataSetChanged();
        snsAdNativeLandingPagesUI.rEe.xw(snsAdNativeLandingPagesUI.rDE.size());
    }

    static /* synthetic */ void m(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        if (snsAdNativeLandingPagesUI.rkT != 2) {
            com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pWK;
            Object[] objArr = new Object[7];
            objArr[0] = com.tencent.mm.plugin.sns.data.i.er(com.tencent.mm.plugin.sns.data.i.lV(snsAdNativeLandingPagesUI.rDW.fAR));
            objArr[1] = snsAdNativeLandingPagesUI.rfQ == null ? "" : snsAdNativeLandingPagesUI.rfQ;
            objArr[2] = Integer.valueOf(snsAdNativeLandingPagesUI.rDW.rup);
            objArr[3] = Integer.valueOf(snsAdNativeLandingPagesUI.rDW.ruq);
            objArr[4] = Long.valueOf(snsAdNativeLandingPagesUI.gAW);
            objArr[5] = Integer.valueOf(snsAdNativeLandingPagesUI.rnb);
            objArr[6] = snsAdNativeLandingPagesUI.rDW.ruz;
            gVar.h(14655, objArr);
        }
    }

    static /* synthetic */ void w(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        x.i("MicroMsg.SnsAdNativeLandingPagesUI", "doTransimt snsAdNativeLadingPagesUI");
        g gVar = snsAdNativeLandingPagesUI.rDW;
        gVar.mtO++;
        String bBa = snsAdNativeLandingPagesUI.bBa();
        String bBb = snsAdNativeLandingPagesUI.bBb();
        a bAZ = snsAdNativeLandingPagesUI.bAZ();
        if (bAZ != null) {
            AdLandingPagesProxy.getInstance().doTransimt(snsAdNativeLandingPagesUI, bBb, bAZ.lUJ, bAZ.rly, bAZ.rlx, snsAdNativeLandingPagesUI.lUI, bBa);
            return;
        }
        AdLandingPagesProxy.getInstance().doTransimt(snsAdNativeLandingPagesUI, bBb, snsAdNativeLandingPagesUI.lUJ, snsAdNativeLandingPagesUI.rDS, snsAdNativeLandingPagesUI.rlx, snsAdNativeLandingPagesUI.lUI, bBa);
    }

    static /* synthetic */ void x(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        x.i("MicroMsg.SnsAdNativeLandingPagesUI", "doShareToTimeline snsAdNativeLadingPagesUI");
        g gVar = snsAdNativeLandingPagesUI.rDW;
        gVar.mtP++;
        String str = snsAdNativeLandingPagesUI.lUI;
        a bAZ = snsAdNativeLandingPagesUI.bAZ();
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.SnsAdNativeLandingPagesUI", "doTimeline fail, link is null");
            return;
        }
        int i = snsAdNativeLandingPagesUI.kXP;
        x.i("MicroMsg.SnsAdNativeLandingPagesUI", "doTimeline, init intent");
        Intent intent = new Intent();
        intent.putExtra("Ksnsupload_width", i);
        intent.putExtra("Ksnsupload_height", i);
        intent.putExtra("Ksnsupload_link", snsAdNativeLandingPagesUI.lUI);
        if (bAZ != null) {
            intent.putExtra("Ksnsupload_title", bAZ.lUJ);
            intent.putExtra("Ksnsupload_imgurl", bAZ.rly);
        } else {
            intent.putExtra("Ksnsupload_title", snsAdNativeLandingPagesUI.lUJ);
            intent.putExtra("Ksnsupload_imgurl", snsAdNativeLandingPagesUI.rDS);
        }
        intent.putExtra("Ksnsupload_canvas_info", snsAdNativeLandingPagesUI.bBb());
        intent.putExtra("Ksnsupload_contentattribute", 0);
        intent.putExtra("Ksnsupload_source", 1);
        intent.putExtra("Ksnsupload_type", 1);
        str = snsAdNativeLandingPagesUI.bBa();
        if (!bi.oN(str)) {
            intent.putExtra("key_snsad_statextstr", str);
        }
        x.i("MicroMsg.SnsAdNativeLandingPagesUI", "doTimeline, start activity");
        intent.putExtra("need_result", true);
        str = "sns_";
        if (snsAdNativeLandingPagesUI.cPf == 1 || snsAdNativeLandingPagesUI.cPf == 2 || snsAdNativeLandingPagesUI.cPf == 3 || snsAdNativeLandingPagesUI.cPf == 4 || snsAdNativeLandingPagesUI.cPf == 9 || snsAdNativeLandingPagesUI.cPf == 10 || snsAdNativeLandingPagesUI.cPf == 11) {
            str = "sns_" + snsAdNativeLandingPagesUI.fAR;
        } else if (snsAdNativeLandingPagesUI.cPf == 5 || snsAdNativeLandingPagesUI.cPf == 6) {
            str = "msg_" + snsAdNativeLandingPagesUI.getIntent().getExtras().getLong("msg_id", -2147483648L);
        } else if (snsAdNativeLandingPagesUI.cPf == 7) {
            str = "fav_" + snsAdNativeLandingPagesUI.getIntent().getExtras().getString("sns_landing_favid");
        }
        String hC = com.tencent.mm.y.u.hC(str);
        com.tencent.mm.y.u.GQ().t(hC, true).o("prePublishId", str);
        intent.putExtra("reportSessionId", hC);
        com.tencent.mm.bl.d.a(snsAdNativeLandingPagesUI.mController.xRr, "sns", ".ui.SnsUploadUI", intent, 1, false);
    }

    static /* synthetic */ void y(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        g gVar = snsAdNativeLandingPagesUI.rDW;
        gVar.hMA++;
        x.i("MicroMsg.SnsAdNativeLandingPagesUI", "doFav snsAdNativeLadingPagesUI");
        long j = snsAdNativeLandingPagesUI.getIntent().getExtras().getLong("msg_id", -2147483648L);
        String str = null;
        if (!bi.oN(snsAdNativeLandingPagesUI.fAR)) {
            str = AdLandingPagesProxy.getInstance().getSnsInfo(snsAdNativeLandingPagesUI.fAR).bza();
        }
        String oM = bi.oM(snsAdNativeLandingPagesUI.getIntent().getStringExtra("prePublishId"));
        a bAZ = snsAdNativeLandingPagesUI.bAZ();
        String bBa = snsAdNativeLandingPagesUI.bBa();
        String bBb = snsAdNativeLandingPagesUI.bBb();
        if (bAZ != null) {
            AdLandingPagesProxy.getInstance().doFavAdlanding(j, str, snsAdNativeLandingPagesUI.cPf, snsAdNativeLandingPagesUI.lUI, oM, bAZ.lUJ, bAZ.rlx, bBb, 34, bAZ.rly, bBa);
        } else {
            AdLandingPagesProxy.getInstance().doFavAdlanding(j, str, snsAdNativeLandingPagesUI.cPf, snsAdNativeLandingPagesUI.lUI, oM, snsAdNativeLandingPagesUI.lUJ, snsAdNativeLandingPagesUI.rlx, bBb, 34, snsAdNativeLandingPagesUI.rDS, bBa);
        }
        ((com.tencent.mm.plugin.fav.a.m) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.fav.a.m.class)).a(0, 34, snsAdNativeLandingPagesUI, snsAdNativeLandingPagesUI.nfQ);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.startTime = System.currentTimeMillis();
        this.gAW = System.currentTimeMillis();
        this.rDW.gAW = this.gAW;
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.a aVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.a(this);
        bAS();
        int[] dw = ac.dw(this);
        this.kJB = dw[0];
        this.kJC = dw[1];
        this.rDI = bundle;
        this.mController.hideTitleView();
        getWindow().addFlags(FileUtils.S_IWUSR);
        AdLandingPagesProxy.create(this.mlo);
        this.mlo.I(new Runnable() {
            public final void run() {
                AdlandingRemoteServiceConnectedReceiver.b(android.support.v4.content.d.m(SnsAdNativeLandingPagesUI.this));
                SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI = SnsAdNativeLandingPagesUI.this;
                snsAdNativeLandingPagesUI.rEl = AdLandingPagesProxy.getInstance().getSnsInfo(snsAdNativeLandingPagesUI.fAR);
                AdLandingPagesProxy.getInstance().asyncCacheXml(snsAdNativeLandingPagesUI.fAR);
                if (snsAdNativeLandingPagesUI.values == null) {
                    x.e("MicroMsg.SnsAdNativeLandingPagesUI", "parse landingpagexml is error,landingpagexml is " + snsAdNativeLandingPagesUI.rDL);
                } else {
                    String valueOf;
                    if (snsAdNativeLandingPagesUI.cPf == 1 || snsAdNativeLandingPagesUI.cPf == 2 || snsAdNativeLandingPagesUI.cPf == 14 || snsAdNativeLandingPagesUI.cPf == 9 || snsAdNativeLandingPagesUI.cPf == 10) {
                        long j = 0;
                        if (snsAdNativeLandingPagesUI.rEl != null) {
                            j = snsAdNativeLandingPagesUI.rEl.field_snsId;
                            if (TextUtils.isEmpty(snsAdNativeLandingPagesUI.rkf)) {
                                snsAdNativeLandingPagesUI.rkf = AdLandingPagesProxy.getInstance().getSnsAid(snsAdNativeLandingPagesUI.fAR);
                            }
                            if (TextUtils.isEmpty(snsAdNativeLandingPagesUI.iYb)) {
                                snsAdNativeLandingPagesUI.iYb = AdLandingPagesProxy.getInstance().getSnsTraceid(snsAdNativeLandingPagesUI.fAR);
                            }
                            snsAdNativeLandingPagesUI.hQn = AdLandingPagesProxy.getInstance().getSnsAdType(snsAdNativeLandingPagesUI.fAR);
                            snsAdNativeLandingPagesUI.rkg = AdLandingPagesProxy.getInstance().getSnsAdCanvasExtXml(snsAdNativeLandingPagesUI.fAR);
                        }
                        valueOf = snsAdNativeLandingPagesUI.rDT != null ? snsAdNativeLandingPagesUI.rDT : String.valueOf(j);
                        snsAdNativeLandingPagesUI.values.put("." + snsAdNativeLandingPagesUI.rDM + ".originSnsId", valueOf);
                        snsAdNativeLandingPagesUI.values.put("." + snsAdNativeLandingPagesUI.rDM + ".originUxInfo", snsAdNativeLandingPagesUI.rfQ);
                        CharSequence charSequence = ((((("<" + snsAdNativeLandingPagesUI.rDM + ">") + String.format("<originSnsId>%s</originSnsId>", new Object[]{valueOf})) + String.format("<originUxInfo>%s</originUxInfo>", new Object[]{snsAdNativeLandingPagesUI.rfQ})) + String.format("<originAdType>%d</originAdType>", new Object[]{Integer.valueOf(snsAdNativeLandingPagesUI.hQn)})) + String.format("<originAid>%s</originAid>", new Object[]{snsAdNativeLandingPagesUI.rkf})) + String.format("<originTraceId>%s</originTraceId>", new Object[]{snsAdNativeLandingPagesUI.iYb});
                        if (!bi.oN(snsAdNativeLandingPagesUI.rkg)) {
                            charSequence = charSequence + String.format("<originAdCanvasExt>%s</originAdCanvasExt>", new Object[]{snsAdNativeLandingPagesUI.rkg});
                        }
                        snsAdNativeLandingPagesUI.rDL = snsAdNativeLandingPagesUI.rDL.replace("<" + snsAdNativeLandingPagesUI.rDM + ">", charSequence);
                        snsAdNativeLandingPagesUI.rDW.rfQ = snsAdNativeLandingPagesUI.rfQ;
                        snsAdNativeLandingPagesUI.rDW.fAR = valueOf;
                    } else {
                        snsAdNativeLandingPagesUI.rDW.fAR = (String) snsAdNativeLandingPagesUI.values.get("." + snsAdNativeLandingPagesUI.rDM + ".originSnsId");
                        snsAdNativeLandingPagesUI.rDW.rfQ = (String) snsAdNativeLandingPagesUI.values.get("." + snsAdNativeLandingPagesUI.rDM + ".originUxInfo");
                        snsAdNativeLandingPagesUI.rfQ = snsAdNativeLandingPagesUI.rDW.rfQ;
                        snsAdNativeLandingPagesUI.hQn = bi.Wo((String) snsAdNativeLandingPagesUI.values.get("." + snsAdNativeLandingPagesUI.rDM + ".originAdType"));
                        Matcher matcher = Pattern.compile("<originAdCanvasExt>[\\s\\S]*</originAdCanvasExt>").matcher(snsAdNativeLandingPagesUI.rDL);
                        if (matcher.find()) {
                            valueOf = matcher.group();
                            if (!bi.oN(valueOf)) {
                                snsAdNativeLandingPagesUI.rkg = valueOf.replaceAll("</?originAdCanvasExt>", "");
                            }
                        }
                    }
                    if (bi.oN(snsAdNativeLandingPagesUI.rDW.fAR)) {
                        snsAdNativeLandingPagesUI.rDW.fAR = snsAdNativeLandingPagesUI.getIntent().getStringExtra("sns_landing_pages_rawSnsId");
                    }
                    snsAdNativeLandingPagesUI.rDW.ruy = AdLandingPagesProxy.getInstance().getSnsStatExtBySnsId(bi.Wp(snsAdNativeLandingPagesUI.rDW.fAR));
                    snsAdNativeLandingPagesUI.lUJ = bi.aD((String) snsAdNativeLandingPagesUI.values.get("." + snsAdNativeLandingPagesUI.rDM + ".adCanvasInfo.shareTitle"), "");
                    snsAdNativeLandingPagesUI.lUI = bi.aD((String) snsAdNativeLandingPagesUI.values.get("." + snsAdNativeLandingPagesUI.rDM + ".adCanvasInfo.shareWebUrl"), "");
                    snsAdNativeLandingPagesUI.rlx = bi.aD((String) snsAdNativeLandingPagesUI.values.get("." + snsAdNativeLandingPagesUI.rDM + ".adCanvasInfo.shareDesc"), "");
                    snsAdNativeLandingPagesUI.rnd = bi.Wo(bi.aD((String) snsAdNativeLandingPagesUI.values.get("." + snsAdNativeLandingPagesUI.rDM + ".adCanvasInfo.bizId"), ""));
                    snsAdNativeLandingPagesUI.rEa = bi.aD((String) snsAdNativeLandingPagesUI.values.get("." + snsAdNativeLandingPagesUI.rDM + ".adCanvasInfo.shareAppId"), "");
                    snsAdNativeLandingPagesUI.rEb = bi.aD((String) snsAdNativeLandingPagesUI.values.get("." + snsAdNativeLandingPagesUI.rDM + ".adCanvasInfo.shareType"), "");
                    snsAdNativeLandingPagesUI.rEc = bi.aD((String) snsAdNativeLandingPagesUI.values.get("." + snsAdNativeLandingPagesUI.rDM + ".adCanvasInfo.userInfo"), "");
                    snsAdNativeLandingPagesUI.rEf = bi.Wo(bi.aD((String) snsAdNativeLandingPagesUI.values.get("." + snsAdNativeLandingPagesUI.rDM + ".adCanvasInfo.disableShareBitSet"), ""));
                    snsAdNativeLandingPagesUI.rEg = bi.Wo(bi.aD((String) snsAdNativeLandingPagesUI.values.get("." + snsAdNativeLandingPagesUI.rDM + ".adCanvasInfo.statusBarStyle"), ""));
                    Map map = snsAdNativeLandingPagesUI.values;
                    String str = "." + snsAdNativeLandingPagesUI.rDM;
                    valueOf = (String) map.get(str + ".adCanvasInfo.arrowDownIconStyle.iconUrl");
                    if (TextUtils.isEmpty(valueOf)) {
                        snsAdNativeLandingPagesUI.rsX = null;
                    } else {
                        if (snsAdNativeLandingPagesUI.rsX == null) {
                            snsAdNativeLandingPagesUI.rsX = new z();
                        }
                        snsAdNativeLandingPagesUI.rsX.iconUrl = valueOf;
                        int Wo = bi.Wo((String) map.get(str + ".adCanvasInfo.sizeType"));
                        int Wo2 = bi.Wo((String) map.get(str + ".adCanvasInfo.basicRootFontSize"));
                        int Wo3 = bi.Wo((String) map.get(str + ".adCanvasInfo.basicWidth"));
                        int i = (Wo2 == 0 && Wo == 1) ? com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.ruc : Wo2;
                        Wo2 = (Wo3 == 0 && Wo == 1) ? com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.rub : Wo3;
                        snsAdNativeLandingPagesUI.rsX.rmQ = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a(bi.Wq((String) map.get(str + ".adCanvasInfo.arrowDownIconStyle.paddingBottom")), Wo, Wo2, i);
                        snsAdNativeLandingPagesUI.rsX.width = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a(bi.Wq((String) map.get(str + ".adCanvasInfo.arrowDownIconStyle.layoutWidth")), Wo, Wo2, i);
                        snsAdNativeLandingPagesUI.rsX.height = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a(bi.Wq((String) map.get(str + ".adCanvasInfo.arrowDownIconStyle.layoutHeight")), Wo, Wo2, i);
                    }
                    snsAdNativeLandingPagesUI.uin = AdLandingPagesProxy.getInstance().getUin();
                    snsAdNativeLandingPagesUI.rEd = bi.aD((String) snsAdNativeLandingPagesUI.values.get("." + snsAdNativeLandingPagesUI.rDM + ".adCanvasInfo.officialSyncBuffer"), "");
                    snsAdNativeLandingPagesUI.bAN();
                    snsAdNativeLandingPagesUI.getIntent().putExtra("sns_landing_pages_adType", snsAdNativeLandingPagesUI.hQn);
                    snsAdNativeLandingPagesUI.getIntent().putExtra("sns_landing_pages_rawSnsId", snsAdNativeLandingPagesUI.rDW.fAR);
                    if (bi.oN(snsAdNativeLandingPagesUI.rkf)) {
                        snsAdNativeLandingPagesUI.rkf = bi.aD((String) snsAdNativeLandingPagesUI.values.get("." + snsAdNativeLandingPagesUI.rDM + ".originAid"), "");
                    }
                    if (bi.oN(snsAdNativeLandingPagesUI.iYb)) {
                        snsAdNativeLandingPagesUI.iYb = bi.aD((String) snsAdNativeLandingPagesUI.values.get("." + snsAdNativeLandingPagesUI.rDM + ".originTraceId"), "");
                    }
                    snsAdNativeLandingPagesUI.rDE = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.m(snsAdNativeLandingPagesUI.rDL, snsAdNativeLandingPagesUI.rDM, snsAdNativeLandingPagesUI.rkf, snsAdNativeLandingPagesUI.iYb);
                    if (snsAdNativeLandingPagesUI.rDE.size() > 0) {
                        String str2 = "";
                        c cVar = (c) snsAdNativeLandingPagesUI.rDE.get(0);
                        if (cVar.rtT.size() > 0) {
                            s sVar = (s) cVar.rtT.get(0);
                            if (sVar instanceof p) {
                                snsAdNativeLandingPagesUI.rDS = ((p) sVar).rmC;
                            } else if (sVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o) {
                                snsAdNativeLandingPagesUI.rDS = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o) sVar).rmC;
                            } else if (sVar instanceof q) {
                                snsAdNativeLandingPagesUI.rDS = ((q) sVar).rmF;
                                str2 = ((q) sVar).rmE;
                            } else if (sVar instanceof n) {
                                n nVar = (n) sVar;
                                if (!nVar.rmy.isEmpty()) {
                                    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m mVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m) nVar.rmy.getFirst();
                                    if (!mVar.rmy.isEmpty()) {
                                        sVar = (s) mVar.rmy.getFirst();
                                        if (sVar instanceof p) {
                                            snsAdNativeLandingPagesUI.rDS = ((p) sVar).rmC;
                                        }
                                    }
                                }
                            }
                        }
                        if (snsAdNativeLandingPagesUI.rEl != null) {
                            bpb byF = snsAdNativeLandingPagesUI.rEl.byF();
                            if (!(byF == null || byF.wYj == null || byF.wYj.wfh == null || byF.wYj.wfh.isEmpty())) {
                                are are = (are) byF.wYj.wfh.getFirst();
                                String str3 = am.r(AdLandingPagesProxy.getInstance().getAccSnsPath(), are.nMq) + com.tencent.mm.plugin.sns.data.i.j(are);
                                valueOf = are.nlE;
                                if (str2.equals(valueOf)) {
                                    valueOf = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.eq("adId", valueOf);
                                    if (!FileOp.bO(valueOf) && FileOp.bO(str3)) {
                                        x.i("MicroMsg.SnsAdNativeLandingPagesUI", "copy outsideFiel:%s->%s", str3, valueOf);
                                        FileOp.x(str3, valueOf);
                                    }
                                }
                            }
                        }
                    }
                    snsAdNativeLandingPagesUI.rDO = bi.aD((String) snsAdNativeLandingPagesUI.values.get("." + snsAdNativeLandingPagesUI.rDM + ".adCanvasInfo.rightBarTitle"), "");
                    snsAdNativeLandingPagesUI.rDP = bi.aD((String) snsAdNativeLandingPagesUI.values.get("." + snsAdNativeLandingPagesUI.rDM + ".adCanvasInfo.rightBarCanvasId"), "");
                    snsAdNativeLandingPagesUI.rDQ = bi.aD((String) snsAdNativeLandingPagesUI.values.get("." + snsAdNativeLandingPagesUI.rDM + ".adCanvasInfo.rightBarCanvasExt"), "");
                }
                SnsAdNativeLandingPagesUI.this.bAS();
                SnsAdNativeLandingPagesUI.this.initView();
                SnsAdNativeLandingPagesUI.m(SnsAdNativeLandingPagesUI.this);
                SnsAdNativeLandingPagesUI.this.iL(true);
                SnsAdNativeLandingPagesUI.this.kra = true;
            }
        });
        this.cPf = getIntent().getIntExtra("sns_landig_pages_from_source", 1);
        this.rnb = getIntent().getIntExtra("sns_landig_pages_origin_from_source", 0);
        this.rDL = getIntent().getStringExtra("sns_landing_pages_xml");
        String stringExtra = getIntent().getStringExtra("sns_landing_pages_too_large_xml_path");
        if (bi.oN(this.rDL) && !bi.oN(stringExtra)) {
            this.rDL = ac.LJ(stringExtra);
        }
        if (bi.oN(this.rDL)) {
            finish();
            return;
        }
        this.rDL = this.rDL.replaceAll("</*RecXml[\\s|\\S]*?>", "");
        this.rDW.rfT = getIntent().getStringExtra("sns_landing_pages_expid");
        this.rDM = getIntent().getStringExtra("sns_landing_pages_xml_prefix");
        this.fAR = getIntent().getStringExtra("sns_landing_pages_share_sns_id");
        this.rDT = getIntent().getStringExtra("sns_landing_pages_rawSnsId");
        this.rfQ = getIntent().getStringExtra("sns_landing_pages_ux_info");
        this.rkf = getIntent().getStringExtra("sns_landing_pages_aid");
        this.iYb = getIntent().getStringExtra("sns_landing_pages_traceid");
        Object stringExtra2 = getIntent().getStringExtra("sns_landing_pages_search_extra");
        g gVar = this.rDW;
        if (!TextUtils.isEmpty(stringExtra2)) {
            if (gVar.extra.length() > 0) {
                gVar.extra += "&";
            }
            gVar.extra += "searchextra=" + URLEncoder.encode(stringExtra2);
        }
        stringExtra2 = getIntent().getStringExtra("sns_landing_pages_extra");
        gVar = this.rDW;
        if (!TextUtils.isEmpty(stringExtra2)) {
            gVar.extra += "&extra1=" + URLEncoder.encode(stringExtra2);
        }
        rDU = getIntent().getBooleanExtra("sns_landing_is_native_sight_ad", false);
        this.rkT = getIntent().getIntExtra("sns_landing_pages_rec_src", 0);
        this.rDY = getIntent().getIntExtra("sns_landing_pages_from_outer_index", 0);
        this.rDN = getIntent().getStringExtra("sns_landing_pages_ad_info");
        this.rDK = getIntent().getBooleanExtra("sns_landing_pages_need_enter_and_exit_animation", false);
        if (this.rDK) {
            this.rDW.rup = 0;
            this.rDW.gAw = 0;
        } else {
            this.rDW.rup = 1;
            this.rDW.gAw = 1;
        }
        this.rDW.ruq = this.cPf;
        this.rDW.rur = 0;
        this.rDW.rus = 0;
        this.rDW.rut = 1;
        this.rDW.ruu = 0;
        this.rDW.rnb = this.rnb;
        if (this.rDM == null || "".equals(this.rDL)) {
            this.rDM = "adxml";
        }
        if (bi.oN(this.rDL) || bi.oN(this.rDM)) {
            x.e("MicroMsg.SnsAdNativeLandingPagesUI", "landingPagesXml is " + this.rDL + ",landingPagesXmlPrex is " + this.rDM);
            return;
        }
        this.values = f.y(this.rDL, this.rDM);
        this.rDW.ruz = bi.aD((String) this.values.get("." + this.rDM + ".adCanvasInfo.canvasId"), "");
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected void onDestroy() {
        getWindow().clearFlags(FileUtils.S_IWUSR);
        if (this.kra) {
            x.i("MicroMsg.SnsAdNativeLandingPagesUI", "the SnsAdNativeLadingPagesUI is destroy");
            if (!this.rDX) {
                bAM();
                xd();
            }
        }
        unregisterReceiver(this.rEv);
        super.onDestroy();
    }

    private void bAM() {
        for (Fragment fragment : ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.c) this.rEe.yE).qj) {
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b bVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b) fragment;
            if (bVar.rsW != null && bVar.getUserVisibleHint()) {
                bVar.rsW.byj();
            }
        }
    }

    private void xd() {
        int i;
        Iterator it;
        List<i> bAQ = bAQ();
        this.jNM += System.currentTimeMillis() - this.startTime;
        this.rDW.ruw = (int) this.jNM;
        g gVar = this.rDW;
        if (this.rDE == null) {
            i = 0;
        } else {
            it = this.rDE.iterator();
            i = 0;
            while (it.hasNext()) {
                i = ((c) it.next()).rtT.size() + i;
            }
        }
        gVar.ruv = i;
        g gVar2 = this.rDW;
        JSONArray jSONArray = new JSONArray();
        for (i iVar : bAQ) {
            if (!iVar.bxO().rna) {
                JSONObject jSONObject = new JSONObject();
                if (!iVar.s(jSONArray)) {
                    if (iVar.T(jSONObject)) {
                        jSONArray.put(jSONObject);
                    }
                    if (iVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.o) {
                        it = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.o) iVar).bxZ().iterator();
                        while (it.hasNext()) {
                            jSONArray.put((JSONObject) it.next());
                        }
                    }
                }
            }
        }
        gVar2.rux = jSONArray.toString();
        x.d("MicroMsg.AdLandingPagesReportInfo", "componentsStatStr:%s", gVar2.rux);
        if (!bi.oN(gVar2.rux)) {
            try {
                gVar2.rux = URLEncoder.encode(gVar2.rux, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                x.e("MicroMsg.AdLandingPagesReportInfo", "not support encode " + e.toString());
            }
        }
        String byz = this.rDW.byz();
        if (this.rnd == 2) {
            AdLandingPagesProxy.getInstance().doCgiReportCanvasBrowseInfo(15041, byz);
            x.i("MicroMsg.SnsAdNativeLandingPagesUI", "post cgi stat 15041 data: " + byz);
        } else if (AdLandingPagesProxy.getInstance().isRecExpAd(this.rDW.fAR)) {
            com.tencent.mm.plugin.report.service.g.pWK.k(14650, byz);
            x.i("MicroMsg.SnsAdNativeLandingPagesUI", "post kv stat 14650 data: " + byz);
        } else {
            com.tencent.mm.plugin.report.service.g.pWK.k(13387, byz);
            x.i("MicroMsg.SnsAdNativeLandingPagesUI", "post kv stat 13387 data: " + byz);
        }
    }

    protected void onResume() {
        super.onResume();
        x.i("MicroMsg.SnsAdNativeLandingPagesUI", "onResume");
        bAS();
        android.support.v4.content.d.m(this).a(this.rEn, new IntentFilter("com.tencent.mm.adlanding.video_progressbar_change"));
        android.support.v4.content.d.m(this).a(this.rEo, new IntentFilter("com.tencent.mm.adlanding.set_uioption"));
        if (this.kra) {
            this.startTime = System.currentTimeMillis();
        }
        registerReceiver(this.rEv, new IntentFilter("android.intent.action.SCREEN_ON"));
        if (this.rDZ) {
            iL(false);
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.kra) {
            this.jNM += System.currentTimeMillis() - this.startTime;
        }
        android.support.v4.content.d.m(this).unregisterReceiver(this.rEn);
        android.support.v4.content.d.m(this).unregisterReceiver(this.rEo);
        if (this.rEw != null) {
            this.rEw.bxR();
        }
    }

    public void onSwipeBack() {
        this.rDW.gAw = 2;
        g gVar = this.rDW;
        gVar.ruu++;
        super.onSwipeBack();
    }

    final void bAN() {
        if (bi.oN(this.rDN) && !bi.oN(this.rkg)) {
            this.rDN = String.format("<ADInfo><adCanvasExt>%s</adCanvasExt></ADInfo>", new Object[]{this.rkg});
        }
        if (!bi.oN(this.rDN)) {
            String aD;
            String str = "ADInfo";
            Map y = f.y(this.rDN, str);
            this.rfQ = bi.aD((String) y.get("." + str + ".uxInfo"), "");
            this.rDW.rfQ = this.rfQ;
            this.rkf = bi.aD((String) y.get("." + str + ".session_data.aid"), "");
            this.iYb = bi.aD((String) y.get("." + str + ".session_data.trace_id"), "");
            Map hashMap = new HashMap();
            str = "." + str + ".adCanvasExt.adCardItemList.cardItem";
            int i = 0;
            while (true) {
                String str2;
                if (i > 0) {
                    str2 = str + i;
                } else {
                    str2 = str;
                }
                if (!y.containsKey(str2 + ".cardTpId")) {
                    break;
                }
                String aD2 = bi.aD((String) y.get(str2 + ".cardTpId"), "");
                aD = bi.aD((String) y.get(str2 + ".cardExt"), "");
                if (!(bi.oN(aD2) || bi.oN(aD))) {
                    hashMap.put(aD2, aD);
                }
                i++;
            }
            this.rDV = hashMap;
            aD = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.m(this.rDL, hashMap);
            if (!bi.oN(aD)) {
                this.rDL = aD;
            }
            if (!bi.oN(this.rkf)) {
                if (this.rDL.contains("<originAid>")) {
                    this.rDL = this.rDL.replaceFirst("<originAid>[\\s\\S]*</originAid>", "<originAid>" + this.rkf + "</originAid>");
                } else {
                    this.rDL = this.rDL.replace("<" + this.rDM + ">", "<" + this.rDM + "><originAid>" + this.rkf + "</originAid>");
                }
            }
            if (!bi.oN(this.iYb)) {
                if (this.rDL.contains("<originTraceId>")) {
                    this.rDL = this.rDL.replaceFirst("<originTraceId>[\\s\\S]*</originTraceId>", "<originTraceId>" + this.iYb + "</originTraceId>");
                } else {
                    this.rDL = this.rDL.replace("<" + this.rDM + ">", "<" + this.rDM + "><originTraceId>" + this.iYb + "</originTraceId>");
                }
            }
            if (!bi.oN(this.rfQ)) {
                if (this.rDL.contains("<originUxInfo>")) {
                    this.rDL = this.rDL.replaceFirst("<originUxInfo>[\\s\\S]*</originUxInfo>", "<originUxInfo>" + this.rfQ + "</originUxInfo>");
                } else {
                    this.rDL = this.rDL.replace("<" + this.rDM + ">", "<" + this.rDM + "><originUxInfo>" + this.rfQ + "</originUxInfo>");
                }
            }
        }
    }

    private void bAO() {
        if (this.rDE != null) {
            Iterator it = this.rDE.iterator();
            while (it.hasNext()) {
                List<s> list = ((c) it.next()).rtT;
                if (list != null) {
                    for (s sVar : list) {
                        sVar.xn(this.rnb == 0 ? this.cPf : this.rnb);
                        sVar.iG(rDU);
                        sVar.LB(this.rfQ);
                        sVar.LC(this.uin);
                        sVar.xo(this.rnd);
                    }
                }
            }
        }
    }

    private void bAP() {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.c cVar;
        boolean z = false;
        bAO();
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.c cVar2 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.c) this.rEe.yE;
        if (cVar2 == null) {
            u cVar3 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.c(getSupportFragmentManager(), new ArrayList());
            this.rEe.a(cVar3);
            cVar = cVar3;
        } else {
            cVar = cVar2;
        }
        int i = 0;
        while (i < this.rDE.size()) {
            c cVar4 = (c) this.rDE.get(i);
            if (cVar4.rmZ) {
                x.i("MicroMsg.SnsAdNativeLandingPagesUI", "loadFirstPage load %d", Integer.valueOf(i));
                Fragment fragment = (Fragment) this.rEs.get(Integer.valueOf(cVar4.id));
                if (fragment == null) {
                    DummyViewPager dummyViewPager = this.rEe;
                    z zVar = this.rsX;
                    if (i == this.rDE.size() - 1) {
                        z = true;
                    }
                    fragment = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b.a(cVar4, dummyViewPager, zVar, z, i == 0 ? this.rEp : null, this.rDK, bAU());
                    this.rEs.put(Integer.valueOf(cVar4.id), fragment);
                } else {
                    ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b) fragment).a(cVar4);
                }
                if (fragment != null) {
                    cVar.a(fragment, i);
                }
                cVar.notifyDataSetChanged();
                this.rEe.xw(this.rDE.size());
            }
            i++;
        }
        cVar.notifyDataSetChanged();
        this.rEe.xw(this.rDE.size());
    }

    private List<i> bAQ() {
        List<i> arrayList = new ArrayList();
        for (Fragment fragment : ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.c) this.rEe.yE).qj) {
            arrayList.addAll(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b) fragment).byr());
        }
        return arrayList;
    }

    private List<i> bAR() {
        List<i> arrayList = new ArrayList();
        arrayList.addAll(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b) this.rEs.get(Integer.valueOf(((c) this.rDE.getFirst()).id))).byr());
        return arrayList;
    }

    @TargetApi(16)
    protected final void initView() {
        int identifier;
        super.initView();
        this.rts = findViewById(com.tencent.mm.plugin.sns.i.f.cIB);
        this.rEe = (AdlandingDummyViewPager) findViewById(com.tencent.mm.plugin.sns.i.f.qMf);
        this.rEe.rsL.add(this.rEq);
        if (this.rnd == 2 && !bAV()) {
            LayoutParams layoutParams = (LayoutParams) this.rEe.getLayoutParams();
            Display defaultDisplay = ((WindowManager) getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getSize(point);
            Point fA = ai.fA(this);
            if ((Math.max(fA.y, fA.x) > Math.max(point.y, point.x) ? 1 : 0) != 0) {
                identifier = Resources.getSystem().getIdentifier("navigation_bar_height", "dimen", "android");
                if (identifier > 0) {
                    identifier = Resources.getSystem().getDimensionPixelSize(identifier);
                    layoutParams.setMargins(0, 0, 0, identifier);
                    this.rEe.setLayoutParams(layoutParams);
                }
            }
            identifier = 0;
            layoutParams.setMargins(0, 0, 0, identifier);
            this.rEe.setLayoutParams(layoutParams);
        }
        this.mDh = (ImageView) findViewById(com.tencent.mm.plugin.sns.i.f.ckx);
        this.rDG = (ImageView) findViewById(com.tencent.mm.plugin.sns.i.f.qJI);
        this.kIQ = (ImageView) findViewById(com.tencent.mm.plugin.sns.i.f.qJH);
        this.kIQ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (SnsAdNativeLandingPagesUI.this.mController.xRL == 1) {
                    SnsAdNativeLandingPagesUI.this.aWY();
                }
                SnsAdNativeLandingPagesUI.this.awC();
            }
        });
        this.rDF = (ImageView) findViewById(com.tencent.mm.plugin.sns.i.f.qJX);
        int i = com.tencent.mm.plugin.sns.i.c.white;
        if (!bAV()) {
            identifier = getResources().getColor(com.tencent.mm.plugin.sns.i.c.black);
            if (this.rDE == null || this.rDE.size() <= 0 || bi.oN(((c) this.rDE.getFirst()).iPT)) {
                i = identifier;
            } else {
                i = Color.parseColor(((c) this.rDE.getFirst()).iPT);
            }
            this.rDG.setBackgroundColor(i);
            i = com.tencent.mm.plugin.sns.i.c.black;
        }
        Drawable drawable = this.kIQ.getDrawable();
        if (drawable != null) {
            android.support.v4.b.a.a.a(drawable, android.support.v4.content.a.c(this, i));
            this.kIQ.setImageDrawable(drawable);
        }
        drawable = this.rDF.getDrawable();
        if (drawable != null) {
            android.support.v4.b.a.a.a(drawable, android.support.v4.content.a.c(this, i));
            this.rDF.setImageDrawable(drawable);
        }
        this.rDH = (TextView) findViewById(com.tencent.mm.plugin.sns.i.f.qJY);
        if (bAW() && !bAX() && this.rnd == 2) {
            this.rDF.setVisibility(8);
            this.rDH.setVisibility(0);
            this.rDH.setText(this.rDO);
            this.rDH.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    SnsAdNativeLandingPagesUI.this.s(SnsAdNativeLandingPagesUI.this, SnsAdNativeLandingPagesUI.this.rDP, SnsAdNativeLandingPagesUI.this.rDQ);
                }
            });
        } else if (bAT()) {
            this.rDF.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    final com.tencent.mm.ui.widget.g gVar = new com.tencent.mm.ui.widget.g(SnsAdNativeLandingPagesUI.this, com.tencent.mm.ui.widget.g.zCt, false);
                    gVar.rQF = new com.tencent.mm.ui.base.p.c() {
                        public final void a(com.tencent.mm.ui.base.n nVar) {
                            if (SnsAdNativeLandingPagesUI.this.rEf == 0 || (SnsAdNativeLandingPagesUI.this.rEf & 2) == 0) {
                                nVar.a(1, SnsAdNativeLandingPagesUI.this.getString(com.tencent.mm.plugin.sns.i.j.eET), com.tencent.mm.plugin.sns.i.i.dxb);
                            }
                            if (SnsAdNativeLandingPagesUI.this.rEf == 0 || (SnsAdNativeLandingPagesUI.this.rEf & 1) == 0) {
                                nVar.a(2, SnsAdNativeLandingPagesUI.this.getString(com.tencent.mm.plugin.sns.i.j.qQg), com.tencent.mm.plugin.sns.i.i.dwQ);
                            }
                            if ((SnsAdNativeLandingPagesUI.this.rEf == 0 || (SnsAdNativeLandingPagesUI.this.rEf & 4) == 0) && SnsAdNativeLandingPagesUI.this.cPf != 7) {
                                nVar.a(3, SnsAdNativeLandingPagesUI.this.getString(com.tencent.mm.plugin.sns.i.j.dRa), com.tencent.mm.plugin.sns.i.i.dwJ);
                            }
                            if ((SnsAdNativeLandingPagesUI.this.rEf == 0 || SnsAdNativeLandingPagesUI.this.bAX()) && SnsAdNativeLandingPagesUI.this.rnd == 2 && SnsAdNativeLandingPagesUI.this.bAW()) {
                                nVar.a(4, SnsAdNativeLandingPagesUI.this.rDO != null ? SnsAdNativeLandingPagesUI.this.rDO : "", 0);
                            }
                        }
                    };
                    gVar.zCF = new com.tencent.mm.ui.widget.g.a() {
                        public final void onDismiss() {
                            SnsAdNativeLandingPagesUI.this.bAS();
                        }
                    };
                    gVar.rQG = new com.tencent.mm.ui.base.p.d() {
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                            SnsAdNativeLandingPagesUI.this.bAS();
                            if (menuItem != null) {
                                switch (menuItem.getItemId()) {
                                    case 1:
                                        SnsAdNativeLandingPagesUI.w(SnsAdNativeLandingPagesUI.this);
                                        return;
                                    case 2:
                                        SnsAdNativeLandingPagesUI.x(SnsAdNativeLandingPagesUI.this);
                                        return;
                                    case 3:
                                        SnsAdNativeLandingPagesUI.y(SnsAdNativeLandingPagesUI.this);
                                        return;
                                    case 4:
                                        SnsAdNativeLandingPagesUI.this.s(SnsAdNativeLandingPagesUI.this, SnsAdNativeLandingPagesUI.this.rDP, SnsAdNativeLandingPagesUI.this.rDQ);
                                        return;
                                    default:
                                        return;
                                }
                            }
                        }
                    };
                    if (SnsAdNativeLandingPagesUI.this.bAV()) {
                        gVar.tMI = true;
                    }
                    if (SnsAdNativeLandingPagesUI.this.isFullScreen()) {
                        gVar.bUX();
                        return;
                    }
                    SnsAdNativeLandingPagesUI.this.aWY();
                    SnsAdNativeLandingPagesUI.this.rDF.postDelayed(new Runnable() {
                        public final void run() {
                            gVar.bUX();
                        }
                    }, 300);
                }
            });
        } else {
            this.rDF.setVisibility(8);
        }
        this.rDR = (ImageView) findViewById(com.tencent.mm.plugin.sns.i.f.qLa);
        if (this.rDE == null || this.rDE.size() == 0) {
            x.e("MicroMsg.SnsAdNativeLandingPagesUI", "landingPages is null");
            return;
        }
        bAP();
        this.rDJ = new b(this.mController.xRr);
        this.rts.addOnLayoutChangeListener(new OnLayoutChangeListener() {
            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                if (SnsAdNativeLandingPagesUI.this.rts.getHeight() == SnsAdNativeLandingPagesUI.this.kJC) {
                    SnsAdNativeLandingPagesUI.this.rts.removeOnLayoutChangeListener(this);
                    SnsAdNativeLandingPagesUI.this.rEm = SnsAdNativeLandingPagesUI.this.rEm - 1;
                    SnsAdNativeLandingPagesUI.d(SnsAdNativeLandingPagesUI.this);
                }
            }
        });
    }

    private boolean isFullScreen() {
        boolean z;
        if (this.rDE != null) {
            Iterator it = this.rDE.iterator();
            z = false;
            while (it.hasNext()) {
                Iterator it2 = ((c) it.next()).rtT.iterator();
                while (it2.hasNext()) {
                    if (((s) it2.next()).type == 82) {
                        z = true;
                        break;
                    }
                }
            }
        }
        z = false;
        if (z) {
            return false;
        }
        return true;
    }

    private void bAS() {
        if (bAV()) {
            x.i("MicroMsg.SnsAdNativeLandingPagesUI", "setFullScreen");
            if (VERSION.SDK_INT < 16) {
                getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                return;
            } else {
                getWindow().getDecorView().setSystemUiVisibility(5126);
                return;
            }
        }
        int i;
        if (VERSION.SDK_INT >= 21) {
            int color = getResources().getColor(com.tencent.mm.plugin.sns.i.c.white);
            if (this.rDE == null || this.rDE.size() <= 0 || bi.oN(((c) this.rDE.getFirst()).iPT)) {
                i = color;
            } else {
                i = Color.parseColor(((c) this.rDE.getFirst()).iPT);
            }
            getWindow().addFlags(Integer.MIN_VALUE);
            getWindow().setStatusBarColor(i);
        }
        i = getWindow().getDecorView().getSystemUiVisibility();
        if (VERSION.SDK_INT >= 17) {
            i &= -1031;
        }
        if (VERSION.SDK_INT >= 23) {
            i |= 8192;
        }
        getWindow().getDecorView().setSystemUiVisibility(i);
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.sns.i.g.qNc;
    }

    private boolean bAT() {
        if (this.rEf == 0 || (this.rEf & 4) == 0 || (this.rEf & 2) == 0) {
            return true;
        }
        if ((bAX() && this.rnd == 2) || (this.rEf & 1) == 0) {
            return true;
        }
        return false;
    }

    private boolean bAU() {
        return (this.rEf & 8) == 0;
    }

    private boolean bAV() {
        return this.rEg == 0;
    }

    private boolean bAW() {
        return (bi.oN(this.rDO) || bi.oN(this.rDP)) ? false : true;
    }

    private boolean bAX() {
        return (this.rEf & 16) == 0;
    }

    private void bAY() {
        Iterator it;
        List<i> bAR = bAR();
        LinkedList linkedList = new LinkedList();
        for (i view : bAR) {
            linkedList.add((View) view.getView().getParent());
        }
        this.rEk = null;
        if (this.rEi != null) {
            this.rEi.clear();
        }
        if (!linkedList.isEmpty()) {
            this.rEk = (View) linkedList.removeFirst();
            if (this.rEi == null) {
                this.rEi = new LinkedList();
            }
            this.rEi.clear();
            int height = this.rEk.getHeight();
            it = linkedList.iterator();
            int i = height;
            while (it.hasNext()) {
                View view2 = (View) it.next();
                i += view2.getHeight();
                this.rEi.add(view2);
                if (i >= this.kJC) {
                    return;
                }
            }
        }
    }

    public final void awC() {
        bAM();
        xd();
        this.rDX = true;
        if (this.rDK) {
            try {
                ((i) bAR().get(0)).bxQ();
            } catch (Exception e) {
            }
            this.rEe.d(0, false);
            RecyclerView byq = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b) this.rEs.get(Integer.valueOf(((c) this.rDE.getFirst()).id))).byq();
            if (byq != null) {
                ((LinearLayoutManager) byq.TV).N(0, 0);
            }
            bAM();
            if (this.rEk != null) {
                this.rEk.postDelayed(new Runnable() {
                    public final void run() {
                        SnsAdNativeLandingPagesUI.this.bAY();
                        SnsAdNativeLandingPagesUI.O(SnsAdNativeLandingPagesUI.this);
                        SnsAdNativeLandingPagesUI.this.rDJ.r(SnsAdNativeLandingPagesUI.this.kXO, SnsAdNativeLandingPagesUI.this.kXN, SnsAdNativeLandingPagesUI.this.kXP, SnsAdNativeLandingPagesUI.this.kXQ);
                        b bVar = SnsAdNativeLandingPagesUI.this.rDJ;
                        View T = SnsAdNativeLandingPagesUI.this.rEk;
                        LinkedList U = SnsAdNativeLandingPagesUI.this.rEi;
                        View V = SnsAdNativeLandingPagesUI.this.mDh;
                        b.b anonymousClass1 = new b.b() {
                            public final void onAnimationStart() {
                                SnsAdNativeLandingPagesUI.this.kIQ.setVisibility(8);
                            }

                            public final void onAnimationEnd() {
                                new ag().post(new Runnable() {
                                    public final void run() {
                                        SnsAdNativeLandingPagesUI.this.finish();
                                        SnsAdNativeLandingPagesUI.this.overridePendingTransition(0, 0);
                                    }
                                });
                            }
                        };
                        if (VERSION.SDK_INT >= 12 && T != null && bVar.rvV != bVar.rvS && bVar.rvV != bVar.rvU && bVar.rvV != bVar.rvR) {
                            T.getLocationOnScreen(new int[2]);
                            bVar.i(T, true);
                            if (V != null) {
                                V.animate().setDuration(300).setInterpolator(new DecelerateInterpolator(1.2f)).alpha(0.0f);
                            }
                            Animation animationSet = new AnimationSet(true);
                            Animation anonymousClass2 = new com.tencent.mm.plugin.sns.ui.b.AnonymousClass2(bVar.rvI, bVar.rvI, T, null);
                            anonymousClass2.setDuration(300);
                            anonymousClass2.setInterpolator(new DecelerateInterpolator(1.2f));
                            animationSet.addAnimation(anonymousClass2);
                            anonymousClass2 = new TranslateAnimation(0.0f, (float) bVar.rvE, 0.0f, (float) bVar.rvF);
                            anonymousClass2.setDuration(300);
                            anonymousClass2.setInterpolator(new DecelerateInterpolator(1.2f));
                            animationSet.addAnimation(anonymousClass2);
                            animationSet.setFillAfter(true);
                            animationSet.setAnimationListener(new com.tencent.mm.plugin.sns.ui.b.AnonymousClass3(anonymousClass1));
                            T.startAnimation(animationSet);
                            Iterator it = U.iterator();
                            while (it.hasNext()) {
                                ((View) it.next()).setAlpha(0.0f);
                            }
                        }
                    }
                }, 10);
                return;
            }
            finish();
            overridePendingTransition(0, 0);
            return;
        }
        finish();
    }

    public void onBackPressed() {
        awC();
    }

    private a bAZ() {
        com.tencent.mm.plugin.sns.storage.b bVar = new com.tencent.mm.plugin.sns.storage.b(this.rDL);
        if (bVar.bxk()) {
            int adVoteIndex = AdLandingPagesProxy.getInstance().getAdVoteIndex(bVar.rlq.rlv, this.rfQ, this.uin);
            if (adVoteIndex > 0 && adVoteIndex <= bVar.rlq.rlw.size()) {
                com.tencent.mm.plugin.sns.storage.b.d dVar = (com.tencent.mm.plugin.sns.storage.b.d) bVar.rlq.rlw.get(adVoteIndex - 1);
                a aVar = new a();
                if (bi.oN(dVar.lUJ)) {
                    aVar.lUJ = this.lUJ;
                } else {
                    aVar.lUJ = dVar.lUJ;
                }
                if (bi.oN(dVar.rlx)) {
                    aVar.rlx = this.rlx;
                } else {
                    aVar.rlx = dVar.rlx;
                }
                if (bi.oN(dVar.rly)) {
                    aVar.rly = this.rDS;
                } else {
                    aVar.rly = dVar.rly;
                }
                return aVar;
            }
        }
        return null;
    }

    private String bBa() {
        bnd bnd = new bnd();
        bnd.wXc = new bne();
        bnd.wXc.wXg = this.rDW.rfQ;
        bnd.wXc.wXf = this.rDW.fAR;
        bnd.wXc.hQn = this.hQn;
        try {
            return Base64.encodeToString(bnd.toByteArray(), 2);
        } catch (Exception e) {
            return "";
        }
    }

    private String bBb() {
        return this.rDL.replaceAll("(?s)<adCanvasInfoLeft[^>]*>.*?</adCanvasInfoLeft>", "").replaceAll("(?s)<adCanvasInfoRight[^>]*>.*?</adCanvasInfoRight>", "");
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1) {
            if (i2 == -1) {
                com.tencent.mm.ui.base.h.bu(this.mController.xRr, this.mController.xRr.getString(com.tencent.mm.plugin.sns.i.j.dGR));
            }
        } else if (i == 2) {
            if (intent.getBooleanExtra("kfavorite", false)) {
                ((com.tencent.mm.plugin.fav.a.m) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.fav.a.m.class)).a(AdLandingPagesProxy.getInstance().doFav(intent, 42), 42, this, this.nfQ);
            }
        } else if (i == w.rru) {
            try {
                String stringExtra = intent.getStringExtra("KComponentCid");
                for (i iVar : bAQ()) {
                    if (iVar.bxP().equals(stringExtra)) {
                        w wVar = (w) iVar;
                        int intExtra = intent.getIntExtra("KStreamVideoPlayCount", 0);
                        int intExtra2 = intent.getIntExtra("KStreamVideoPlayCompleteCount", 0);
                        int intExtra3 = intent.getIntExtra("KStreamVideoTotalPlayTimeInMs", 0);
                        wVar.qVs = intExtra + wVar.qVs;
                        wVar.qVt += intExtra2;
                        wVar.qVu += intExtra3;
                        break;
                    }
                }
            } catch (Exception e) {
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    public final void onKeyboardStateChanged() {
        super.onKeyboardStateChanged();
        if (this.rEe != null) {
            this.rEe.postDelayed(new Runnable() {
                public final void run() {
                    if (SnsAdNativeLandingPagesUI.this.mController.xRL != 1) {
                        SnsAdNativeLandingPagesUI.this.bAS();
                    } else {
                        SnsAdNativeLandingPagesUI.W(SnsAdNativeLandingPagesUI.this);
                    }
                    ArrayList arrayList = new ArrayList();
                    for (Fragment fragment : ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.c) SnsAdNativeLandingPagesUI.this.rEe.yE).qj) {
                        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b bVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b) fragment;
                        int i = SnsAdNativeLandingPagesUI.this.mController.xRL;
                        bVar.byn();
                    }
                }
            }, 500);
        }
    }

    public final void iL(boolean z) {
        if (z && this.rnd == 1) {
            AdLandingPagesProxy.getInstance().doDynamicUpdateScene(this.rEa, this.rEb, this.rEc, this.rEr);
        }
        if (this.rnd == 2 && !bi.oN(this.rEd)) {
            AdLandingPagesProxy.getInstance().doSearchDynamicUpdateScene(this.rEd, this.rEr);
        }
        this.rDZ = true;
    }

    public final void a(s sVar, String str, String str2, String str3, boolean z, boolean z2, boolean z3) {
        if (this.rEw == null || z3) {
            final boolean z4 = z3;
            com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.a anonymousClass10 = new com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.a() {
                public final void as(Object obj) {
                }

                public final void e(int i, int i2, Object obj) {
                    SnsAdNativeLandingPagesUI.this.iL(false);
                    if (z4) {
                        if (SnsAdNativeLandingPagesUI.this.rEw != null) {
                            SnsAdNativeLandingPagesUI.this.rEw.bxR();
                        }
                        if (SnsAdNativeLandingPagesUI.this.rEx != null) {
                            SnsAdNativeLandingPagesUI.this.rEx.dismiss();
                            SnsAdNativeLandingPagesUI.this.rEx = null;
                        }
                    }
                }
            };
            if (!z3) {
                int i;
                Context context = this.mController.xRr;
                ViewGroup linearLayout = new LinearLayout(this.mController.xRr);
                v.fw(this.mController.xRr);
                if (bi.oN(sVar.rmW)) {
                    i = -1;
                } else {
                    i = Color.parseColor(sVar.rmW);
                }
                i a = am.a(context, sVar, linearLayout, i);
                this.rEw = new j(this.mController.xRr, a, str, str2, str3, z, z2);
                final View view = a.getView();
                this.rEw.rpw = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.j.a() {
                    public final void bxS() {
                        x.i("MicroMsg.SnsAdNativeLandingPagesUI", "onDismiss");
                        bBd();
                    }

                    public final void bxT() {
                        x.i("MicroMsg.SnsAdNativeLandingPagesUI", "onCancel");
                        bBd();
                    }

                    private void bBd() {
                        if (!(view == null || view.getParent() == null)) {
                            ((ViewGroup) view.getParent()).removeView(view);
                        }
                        SnsAdNativeLandingPagesUI.this.rEw = null;
                    }
                };
                j jVar = this.rEw;
                if (!(jVar.kTo == null || jVar.rpr == null)) {
                    jVar.rpr.getWindow().setFlags(8, 8);
                    jVar.rpr.getWindow().addFlags(131200);
                    if (jVar.rpw != null) {
                        jVar.rpr.setOnDismissListener(new OnDismissListener() {
                            public final void onDismiss(DialogInterface dialogInterface) {
                                j.this.rpw.bxS();
                            }
                        });
                        jVar.rpr.setOnCancelListener(new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                j.this.rpw.bxT();
                            }
                        });
                    }
                    jVar.rpr.setContentView(jVar.kTo);
                    BottomSheetBehavior.i((View) jVar.kTo.getParent()).q(ac.dw(jVar.mContext)[1]);
                    jVar.rpr.show();
                }
            }
            if (!bi.oN(str)) {
                AdLandingPagesProxy.getInstance().doFavOfficialItemScene(str, anonymousClass10);
                if (z3) {
                    this.rEx = com.tencent.mm.ui.base.h.a((Context) this, getString(com.tencent.mm.plugin.sns.i.j.qRC), false, null);
                    return;
                }
                return;
            }
            return;
        }
        x.w("MicroMsg.SnsAdNativeLandingPagesUI", "bottom sheet appear several times");
        this.rEw.bxR();
        if (this.rEx != null) {
            this.rEx.dismiss();
            this.rEx = null;
        }
    }

    public final void s(Context context, String str, String str2) {
        Intent intent = new Intent();
        intent.putExtra("sns_landig_pages_from_source", 14);
        intent.putExtra("sns_landig_pages_origin_from_source", this.rnb == 0 ? this.cPf : this.rnb);
        intent.putExtra("sns_landing_pages_canvasid", str);
        intent.putExtra("sns_landing_pages_canvas_ext", str2);
        intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
        intent.putExtra("sns_landing_pages_no_store", 1);
        String stringExtra = ((Activity) context).getIntent().getStringExtra("sns_landing_pages_sessionId");
        String stringExtra2 = ((Activity) context).getIntent().getStringExtra("sns_landing_pages_ad_buffer");
        if (!bi.oN(stringExtra)) {
            String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("sessionId", valueOf);
                jSONObject.put("cid", "");
                jSONObject.put("adBuffer", !bi.oN(stringExtra2) ? stringExtra2 : "");
                jSONObject.put("preSessionId", stringExtra);
            } catch (Exception e) {
            }
            intent.putExtra("sns_landing_pages_search_extra", jSONObject.toString());
            intent.putExtra("sns_landing_pages_sessionId", valueOf);
            intent.putExtra("sns_landing_pages_ad_buffer", stringExtra2);
        }
        com.tencent.mm.bl.d.b(context, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", intent);
    }
}
