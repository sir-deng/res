package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Configuration;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue.IdleHandler;
import android.os.PowerManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ac.n;
import com.tencent.mm.ad.e;
import com.tencent.mm.ap.o;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.f.a.gh;
import com.tencent.mm.f.a.kt;
import com.tencent.mm.f.a.my;
import com.tencent.mm.f.a.nq;
import com.tencent.mm.f.a.qq;
import com.tencent.mm.f.a.re;
import com.tencent.mm.f.a.z;
import com.tencent.mm.f.b.ak;
import com.tencent.mm.kiss.a.b;
import com.tencent.mm.modelfriend.aa;
import com.tencent.mm.modelfriend.m.a;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.report.service.f;
import com.tencent.mm.pluginsdk.q.l;
import com.tencent.mm.sdk.platformtools.FLock;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.as;
import com.tencent.mm.y.s;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;

public class j extends com.tencent.mm.ui.AbstractTabChildActivity.a implements com.tencent.mm.ui.conversation.i.a {
    private int[] rJD = new int[2];
    private g zfz;
    private ConversationWithAppBrandListView ziI;
    private TextView ziJ;
    private i ziK = new i();
    private c ziL = new c();
    private m ziM = new m();
    private k ziN = new k();
    private a ziO;
    private a zix = new a();

    class a {
        boolean fpU;
        boolean ziR;
        boolean ziS;

        public a(boolean z, boolean z2, boolean z3) {
            this.fpU = z;
            this.ziR = z2;
            this.ziS = z3;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.tencent.mm.ui.conversation.j r8, int r9) {
        /*
        r7 = 8;
        r0 = 1;
        r1 = 0;
        r2 = "MicroMsg.MainUI";
        r3 = "summerinit setShowView count[%d], stack[%s]";
        r4 = 2;
        r4 = new java.lang.Object[r4];
        r5 = java.lang.Integer.valueOf(r9);
        r4[r1] = r5;
        r5 = com.tencent.mm.platformtools.t.WB();
        r4[r0] = r5;
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);
        if (r9 > 0) goto L_0x0065;
    L_0x001e:
        r2 = r8.zix;
        r3 = r2.context;
        if (r3 == 0) goto L_0x0070;
    L_0x0024:
        r3 = "MicroMsg.BannerHelper";
        r4 = "checkBannerEmpyt %d";
        r5 = new java.lang.Object[r0];
        r6 = r2.hashCode();
        r6 = java.lang.Integer.valueOf(r6);
        r5[r1] = r6;
        com.tencent.mm.sdk.platformtools.x.i(r3, r4, r5);
        r3 = r2.zeN;
        r3 = r2.l(r3, r1);
        if (r3 != 0) goto L_0x0070;
    L_0x0041:
        r3 = r2.zeO;
        r3 = r2.l(r3, r1);
        if (r3 != 0) goto L_0x0070;
    L_0x0049:
        r3 = r2.zeP;
        r3 = r2.l(r3, r1);
        if (r3 != 0) goto L_0x0070;
    L_0x0051:
        r3 = r2.zeQ;
        r2 = r2.l(r3, r1);
        if (r2 != 0) goto L_0x0070;
    L_0x0059:
        if (r0 == 0) goto L_0x0065;
    L_0x005b:
        r0 = r8.ziJ;
        r0.setVisibility(r1);
        r0 = r8.ziI;
        r0.setVisibility(r7);
    L_0x0065:
        r0 = r8.ziI;
        r0.setVisibility(r1);
        r0 = r8.ziJ;
        r0.setVisibility(r7);
        return;
    L_0x0070:
        r0 = r1;
        goto L_0x0059;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.conversation.j.a(com.tencent.mm.ui.conversation.j, int):void");
    }

    protected int getLayoutId() {
        return R.i.cuP;
    }

    protected View getLayoutView() {
        return b.Ef().a(getContext(), "R.layout.main", R.i.cuP);
    }

    public boolean supportNavigationSwipeBack() {
        return false;
    }

    public boolean noActionBar() {
        return true;
    }

    public void onResume() {
        x.i("MicroMsg.MainUI", "onResume");
        super.onResume();
        if (this.ziI != null) {
            ConversationWithAppBrandListView conversationWithAppBrandListView = this.ziI;
            x.i("MicroMsg.ConversationWithAppBrandListView", "[onResume]");
            if (conversationWithAppBrandListView.zgM != null) {
                conversationWithAppBrandListView.zgM.T(false);
            }
            conversationWithAppBrandListView.nm(true);
        }
    }

    public void onPause() {
        x.i("MicroMsg.MainUI", "onPause");
        super.onPause();
    }

    public final void d(boolean z, boolean z2, boolean z3) {
        if (this.ziI instanceof ConversationWithAppBrandListView) {
            ConversationWithAppBrandListView conversationWithAppBrandListView = this.ziI;
            if (conversationWithAppBrandListView.nr(false)) {
                x.i("MicroMsg.ConversationWithAppBrandListView", "[showAppBrandHeader] isShow:%s isScrollFirst:%s", Boolean.valueOf(z), Boolean.valueOf(z3));
                conversationWithAppBrandListView.nm(true);
                if (conversationWithAppBrandListView.zgL != null && !z) {
                    conversationWithAppBrandListView.zgL.setVisibility(8);
                } else if (!(conversationWithAppBrandListView.zgL == null || conversationWithAppBrandListView.zgM == null || conversationWithAppBrandListView.zgM.fn().getItemCount() <= 1)) {
                    conversationWithAppBrandListView.zgL.setVisibility(0);
                    if (z3) {
                        conversationWithAppBrandListView.zgM.smoothScrollToPosition(0);
                    }
                }
                conversationWithAppBrandListView.post(new com.tencent.mm.ui.conversation.ConversationWithAppBrandListView.AnonymousClass4(z2));
                return;
            }
            x.w("MicroMsg.ConversationWithAppBrandListView", "[showAppBrandHeader] AppBrandHeader is disable! ");
            return;
        }
        this.ziO = new a(z, z2, z3);
    }

    public final void cwy() {
        if (this.zfz != null) {
            this.zfz.cwy();
        }
    }

    public final void A(long j, int i) {
        if (this.ziI != null) {
            this.ziI.A(j, i);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.zix.cxg();
    }

    protected final void cmi() {
        a aVar;
        x.i("MicroMsg.MainUI", "onTabCreate, %d", Integer.valueOf(hashCode()));
        if (this.mController != null) {
            this.mController.ae(4, false);
        }
        x.i("MicroMsg.MainUI", "mainUIOnCreate");
        long currentTimeMillis = System.currentTimeMillis();
        setMenuVisibility(true);
        as.Dt().cgr();
        x.i("MicroMsg.MainUI", "main ui init view");
        if (this.ziI != null) {
            aVar = this.zix;
            if (aVar.zeU != null) {
                aVar.dC(aVar.zeN);
                aVar.dC(aVar.zeO);
                aVar.dC(aVar.zeP);
                aVar.dC(aVar.zeQ);
                for (com.tencent.mm.pluginsdk.ui.b.b bVar : aVar.zeR) {
                    if (!(bVar == null || bVar.getView() == null)) {
                        aVar.zeU.removeFooterView(bVar.getView());
                    }
                }
            }
        }
        this.ziJ = (TextView) findViewById(R.h.cei);
        this.ziI = (ConversationWithAppBrandListView) findViewById(R.h.cuQ);
        this.ziI.setDrawingCacheEnabled(false);
        this.ziI.setScrollingCacheEnabled(false);
        this.zfz = new g(getContext(), new com.tencent.mm.ui.f.a() {
            public final void XF() {
                f.vR(12);
                c b = j.this.ziL;
                b.zfx = -1;
                b.zfw.clear();
                if (b.zfz == null || b.zfy < 0 || !b.zfz.clE()) {
                    b.zfx = 0;
                } else if (b.zfz.zhF) {
                    b.zfx = 0;
                } else if (b.zfz.zhD) {
                    x.i("MicroMsg.ConvUnreadHelper", "unreadcheck preSetLauncherUIUnReadCount has contact change");
                    b.zfx = 0;
                    b.zfz.zhD = false;
                } else {
                    HashSet hashSet = (HashSet) b.zfz.zhE.clone();
                    x.i("MicroMsg.ConvUnreadHelper", "unreadcheck preSetLauncherUIUnReadCount  events size %d", Integer.valueOf(hashSet.size()));
                    if (hashSet.contains("floatbottle")) {
                        b.zfx = 0;
                        return;
                    }
                    hashSet.remove("officialaccounts");
                    if (hashSet.isEmpty()) {
                        b.zfx = 1;
                        return;
                    }
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        boolean z;
                        String str = (String) it.next();
                        g gVar = b.zfz;
                        if (gVar.aan(str)) {
                            z = false;
                        } else {
                            d dVar = (d) gVar.yvZ.get(str);
                            z = dVar == null ? false : s.eX(str) ? dVar.zgm : dVar.zgj;
                        }
                        if (!z) {
                            ak aam = b.aam(str);
                            if (aam == null) {
                                b.zfw.put(str, Integer.valueOf(0));
                                x.i("MicroMsg.ConvUnreadHelper", "unreadcheck preSetLauncherUIUnReadCount  cov == null username %s, unreadcount %d", str, Integer.valueOf(0));
                            } else {
                                b.zfw.put(str, Integer.valueOf(aam.field_unReadCount));
                                x.i("MicroMsg.ConvUnreadHelper", "unreadcheck preSetLauncherUIUnReadCount  cov != null username %s, unreadcount %d", str, Integer.valueOf(aam.field_unReadCount));
                            }
                        }
                    }
                    x.i("MicroMsg.ConvUnreadHelper", "unreadcheck preSetLauncherUIUnReadCount  preUnReadCount size %d", Integer.valueOf(b.zfw.size()));
                    if (b.zfw.isEmpty()) {
                        b.zfx = 1;
                    } else if (b.zfw.size() > 20) {
                        b.zfx = 0;
                    } else {
                        b.zfx = 2;
                    }
                }
            }

            public final void XE() {
                j.this.ziL.cxh();
                if (j.this.zfz != null) {
                    g a = j.this.zfz;
                    if (!(a.yvZ == null || a.zhE == null || a.zhE.isEmpty())) {
                        if (a.zhF) {
                            a.yvZ.clear();
                            a.zhF = false;
                        } else {
                            x.d("MicroMsg.ConversationWithCacheAdapter", "dealWithConversationEvents size %d", Integer.valueOf(a.zhE.size()));
                            Iterator it = a.zhE.iterator();
                            while (it.hasNext()) {
                                a.yvZ.remove(it.next());
                            }
                        }
                        a.zhE.clear();
                    }
                }
                j.this.ziI.post(new Runnable() {
                    public final void run() {
                        j.a(j.this, j.this.zfz.getCount());
                        j.this.zix.cxg();
                        f.vS(12);
                    }
                });
            }
        });
        this.zfz.a(new c() {
            public final int ci(View view) {
                return j.this.ziI.getPositionForView(view);
            }
        });
        this.zfz.a(new MMSlideDelView.f() {
            public final void t(View view, int i) {
                j.this.ziI.performItemClick(view, i, 0);
            }
        });
        if (d.fP(18)) {
            com.tencent.mm.blink.b.wv().f(new Runnable() {
                public final void run() {
                    j.this.zix.a(j.this.getContext(), j.this.ziI, j.this.ziJ);
                }
            });
        } else {
            this.zix.a(getContext(), this.ziI, this.ziJ);
        }
        k kVar = this.ziN;
        ListView listView = this.ziI;
        g gVar = this.zfz;
        kVar.zeU = listView;
        kVar.zfz = gVar;
        listView.setOnScrollListener(kVar.lfI);
        gVar.zfK = kVar.lfI;
        ah.y(new Runnable() {
            public final void run() {
                k.a(k.this, 0);
            }
        });
        this.ziL.aa(getActivity());
        this.ziI.setAdapter(this.zfz);
        this.ziI.setOnItemClickListener(new e(this.zfz, this.ziI, getActivity()));
        this.ziI.setOnItemLongClickListener(new f(this.zfz, this.ziI, getActivity(), this.rJD));
        this.ziI.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        j.this.hideVKB();
                        j.this.rJD[0] = (int) motionEvent.getRawX();
                        j.this.rJD[1] = (int) motionEvent.getRawY();
                        break;
                }
                return false;
            }
        });
        if (this.ziO != null) {
            d(this.ziO.fpU, this.ziO.ziR, this.ziO.ziS);
        }
        this.ziI.setSelection(0);
        e eVar = this.ziK;
        Activity activity = getActivity();
        aVar = this.zix;
        eVar.fBA = activity;
        eVar.zix = aVar;
        eVar.ziy = this;
        eVar.wakeLock = ((PowerManager) activity.getSystemService("power")).newWakeLock(26, "NetSceneInit Lock");
        as.CN().a(-1, eVar);
        eVar.ziu = false;
        com.tencent.mm.sdk.b.a.xmy.b(eVar.ziz);
        com.tencent.mm.sdk.b.a.xmy.b(eVar.ziA);
        File file = new File(ad.getContext().getFilesDir(), "DBRecoverStarted");
        if (file.exists()) {
            com.tencent.mm.plugin.report.d.pVE.c("DBRepair", "Last recovery interrupted.", null);
            file.delete();
        }
        eVar.ziB = new FLock(new File(ad.getContext().getFilesDir(), "MMStarted"), true);
        if (eVar.ziB.cfG()) {
            eVar.ziB.unlock();
            x.i("MicroMsg.DuplicateDetect", "No data multiple instance detected.");
        } else {
            x.w("MicroMsg.DuplicateDetect", "Data multiple instance detected.");
            com.tencent.mm.plugin.report.d.pVE.a(579, 0, 1, true);
        }
        eVar.ziB.cfF();
        c cVar = this.ziL;
        g gVar2 = this.zfz;
        ListView listView2 = this.ziI;
        Activity activity2 = getActivity();
        cVar.zfz = gVar2;
        cVar.zeU = listView2;
        cVar.activity = activity2;
        com.tencent.mm.sdk.b.a.xmy.b(cVar.zfC);
        com.tencent.mm.sdk.b.a.xmy.b(cVar.zfA);
        com.tencent.mm.sdk.b.a.xmy.b(cVar.zfB);
        m mVar = this.ziM;
        gVar2 = this.zfz;
        ConversationWithAppBrandListView conversationWithAppBrandListView = this.ziI;
        activity2 = getActivity();
        mVar.zfz = gVar2;
        mVar.fBA = activity2;
        mVar.ziI = conversationWithAppBrandListView;
        if (mVar.lBc == null) {
            mVar.lBc = new com.tencent.mm.ui.conversation.m.AnonymousClass3(new ag() {
                public final void handleMessage(Message message) {
                    if (m.this.zfz != null) {
                        m.this.zfz.clearCache();
                        m.this.zfz.notifyDataSetChanged();
                    }
                }
            });
        }
        if (mVar.zjd == null) {
            mVar.zjd = new com.tencent.mm.sdk.b.c<my>() {
                {
                    this.xmG = my.class.getName().hashCode();
                }

                public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                    if (m.this.zfz != null) {
                        ah.y(new Runnable() {
                            public final void run() {
                                x.d("MicroMsg.RefreshHelper", "refresh main ui multitalk icon.");
                                if (m.this.zfz != null) {
                                    m.this.zfz.notifyDataSetChanged();
                                }
                            }
                        });
                    }
                    return true;
                }
            };
        }
        if (mVar.zje == null) {
            mVar.zje = new com.tencent.mm.ui.conversation.m.AnonymousClass5(conversationWithAppBrandListView);
        }
        com.tencent.mm.sdk.b.a.xmy.b(mVar.lBc);
        com.tencent.mm.sdk.b.a.xmy.b(mVar.zjd);
        com.tencent.mm.sdk.b.a.xmy.b(mVar.zje);
        mVar.xOT = new IdleHandler() {
            public final boolean queueIdle() {
                x.d("MicroMsg.RefreshHelper", "dkuploadAddrBook idleHandler");
                if (as.Hp() && com.tencent.mm.modelfriend.m.NT() == a.SUCC && !com.tencent.mm.modelfriend.m.NS()) {
                    as.CN().a(new aa(com.tencent.mm.modelfriend.m.Oa(), com.tencent.mm.modelfriend.m.NZ()), 0);
                }
                Looper.myQueue().removeIdleHandler(m.this.xOT);
                return false;
            }
        };
        Looper.myQueue().addIdleHandler(mVar.xOT);
        conversationWithAppBrandListView.post(new Runnable() {
            public final void run() {
                if (!ad.cgc()) {
                    ad.lH(true);
                    ah.h(new Runnable() {
                        public final void run() {
                            x.i("MicroMsg.RefreshHelper", "APPHasInitEvent begin");
                            com.tencent.mm.sdk.b.a.xmy.m(new com.tencent.mm.f.a.a());
                        }
                    }, 100);
                }
                f.vS(8);
            }
        });
        com.tencent.mm.ap.b PE = o.PE();
        int i = R.g.bAI;
        x.d("MicroMsg.AutoGetBigImgLogic", "chattingMaskResId change from " + PE.hAY + " to " + i);
        PE.hAY = i;
        o.PE().start();
        as.bA(false);
        as.Hm();
        com.tencent.mm.y.c.Fk().a(this.zfz);
        as.Hm();
        com.tencent.mm.y.c.Ff().a(this.zfz);
        g gVar3 = this.zfz;
        if (gVar3.zfQ == null) {
            gVar3.zfQ = new com.tencent.mm.sdk.b.c<z>() {
                {
                    this.xmG = z.class.getName().hashCode();
                }

                public final /* bridge */ /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                    g.this.zfN = true;
                    return false;
                }
            };
        }
        com.tencent.mm.sdk.b.a.xmy.b(gVar3.zfQ);
        this.zfz.zhy = new g.b() {
            public final void cxu() {
                j.this.zfz.clearCache();
                as.Hm();
                com.tencent.mm.y.c.Fk().a(j.this.zfz);
                as.Hm();
                com.tencent.mm.y.c.Ff().a(j.this.zfz);
            }
        };
        r2 = new Object[3];
        as.Hm();
        r2[1] = Integer.valueOf(com.tencent.mm.y.c.Cn());
        r2[2] = Integer.valueOf(com.tencent.mm.protocal.d.vHl);
        x.i("MicroMsg.MainUI", "kevin mainUIOnCreate time:%d uin:%d ver:%x", r2);
        this.ziI.postDelayed(new Runnable() {
            public final void run() {
                if (j.this.thisActivity() != null) {
                    j.this.thisActivity().supportInvalidateOptionsMenu();
                }
            }
        }, 200);
    }

    public final void cxC() {
        if (this.zfz != null) {
            this.zfz.onResume();
        }
    }

    public final void cxD() {
        if (this.zfz != null) {
            this.zfz.onPause();
        }
    }

    protected final void cmj() {
        x.i("MicroMsg.MainUI", "onTabResume");
        long Wy = t.Wy();
        c cVar = this.ziL;
        if (cVar.zfy < 0) {
            x.d("MicroMsg.ConvUnreadHelper", "onTabResume totalUnReadCount %d", Integer.valueOf(cVar.zfy));
            if (cVar.zfz != null) {
                cVar.zfz.cxs();
            }
        }
        cxC();
        com.tencent.mm.blink.b.wv().f(new Runnable() {
            public final void run() {
                a c = j.this.zix;
                n.JF().d(c);
                as.Hm();
                com.tencent.mm.y.c.Db().a(c);
                c.cxg();
            }
        });
        x.d("MicroMsg.MainUI", "start time check dkinit KEVIN mainui TestTimeLayoutTime onTabResume:%d", Long.valueOf(t.bA(Wy)));
        m mVar = this.ziM;
        if (com.tencent.mm.pluginsdk.q.a.viX != null) {
            com.tencent.mm.pluginsdk.q.a.viX.a(mVar);
        }
        ah.y(new Runnable() {
            public final void run() {
                com.tencent.mm.sdk.b.b ghVar = new gh();
                ghVar.fxm.data = "MAIN_UI_EVENT_UPDATE_VIEW";
                com.tencent.mm.sdk.b.a.xmy.m(ghVar);
            }
        });
        l.fT(mVar.fBA);
        if (!(mVar.fBA == null || mVar.fBA.getIntent() == null || !mVar.fBA.getIntent().getBooleanExtra("resend_fail_messages", false))) {
            ah.h(new Runnable() {
                public final void run() {
                    h.a(m.this.fBA, m.this.fBA.getString(R.l.ezg), "", m.this.fBA.getString(R.l.ezh), m.this.fBA.getString(R.l.dEy), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            com.tencent.mm.sdk.b.a.xmy.m(new nq());
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            com.tencent.mm.sdk.b.a.xmy.m(new kt());
                        }
                    });
                }
            }, 500);
            mVar.fBA.getIntent().putExtra("resend_fail_messages", false);
        }
        LauncherUI launcherUI = (LauncherUI) mVar.fBA;
        if (launcherUI != null) {
            launcherUI.xPu.setTitleBarDoubleClickListener(mVar.yZy);
        }
        if (com.tencent.mm.sdk.platformtools.t.a(mVar.fBA.getIntent(), "Main_ListToTop", false) && mVar.ziI != null) {
            mVar.ziI.post(new Runnable() {
                public final void run() {
                    if (!m.this.fBA.isFinishing()) {
                        m.this.ziI.setSelection(0);
                    }
                }
            });
        }
        com.tencent.mm.sdk.platformtools.t.b(mVar.fBA.getIntent(), "Main_ListToTop", false);
        i iVar = this.ziK;
        String str = "MicroMsg.InitHelper";
        String str2 = "onTabResume tip:%d initscene:%d";
        Object[] objArr = new Object[2];
        int i = iVar.inI == null ? -1 : iVar.inI.isShowing() ? 1 : 0;
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(iVar.cxy());
        x.i(str, str2, objArr);
        iVar.cxx();
        ah.h(new Runnable() {
            public final void run() {
                i.d(i.this);
            }
        }, 100);
        if (as.Hp() && !this.ziK.cxz()) {
            com.tencent.mm.sdk.b.a.xmy.a(new re(), Looper.getMainLooper());
            com.tencent.mm.sdk.b.b qqVar = new qq();
            qqVar.fJc.action = 4;
            com.tencent.mm.sdk.b.a.xmy.a(qqVar, Looper.getMainLooper());
        }
    }

    protected final void cmk() {
        x.i("MicroMsg.MainUI", "onTabStart");
    }

    protected final void cml() {
        x.i("MicroMsg.MainUI", "onTabPause");
        com.tencent.mm.blink.b.wv().f(new Runnable() {
            public final void run() {
                Object c = j.this.zix;
                x.i("MicroMsg.BannerHelper", "releaseBanner");
                a.dE(c.zeN);
                a.dE(c.zeO);
                a.dE(c.zeP);
                a.dE(c.zeQ);
                for (com.tencent.mm.pluginsdk.ui.b.b bVar : c.zeR) {
                    if (bVar != null) {
                        bVar.release();
                    }
                }
                if (as.Hp()) {
                    n.JF().e(c);
                }
                if (as.Hp()) {
                    as.Hm();
                    com.tencent.mm.y.c.Db().b(c);
                }
            }
        });
        i iVar = this.ziK;
        if (iVar.wakeLock.isHeld()) {
            x.w("MicroMsg.InitHelper", "onTabPause wakelock.release!");
            iVar.wakeLock.release();
        }
        hideVKB();
        m mVar = this.ziM;
        if (com.tencent.mm.pluginsdk.q.a.viX != null) {
            com.tencent.mm.pluginsdk.q.a.viX.b(mVar);
        }
        l.cxF();
        LauncherUI launcherUI = (LauncherUI) mVar.fBA;
        if (launcherUI != null) {
            launcherUI.xPu.aa(mVar.yZy);
        }
        cxD();
    }

    protected final void cmm() {
        x.i("MicroMsg.MainUI", "onTabStop");
    }

    protected final void cmn() {
        x.i("MicroMsg.MainUI", "onTabDestroy  acc:%b", Boolean.valueOf(as.Hp()));
        com.tencent.mm.blink.b.wv().f(new Runnable() {
            public final void run() {
                Object c = j.this.zix;
                x.i("MicroMsg.BannerHelper", "destroyBanner");
                a.dF(c.zeN);
                a.dF(c.zeO);
                a.dF(c.zeP);
                a.dF(c.zeQ);
                for (com.tencent.mm.pluginsdk.ui.b.b bVar : c.zeR) {
                    if (bVar != null) {
                        bVar.destroy();
                    }
                }
                as.b(c.qaE);
                com.tencent.mm.sdk.b.a.xmy.c(c.zeS);
                com.tencent.mm.sdk.b.a.xmy.c(c.zeT);
                if (as.Hp()) {
                    as.Hm();
                    com.tencent.mm.y.c.b(c);
                }
                c.context = null;
            }
        });
        e eVar = this.ziK;
        eVar.ziB.unlock();
        as.CN().b(-1, eVar);
        if (eVar.inI != null) {
            eVar.inI.dismiss();
            eVar.inI = null;
        }
        com.tencent.mm.sdk.b.a.xmy.c(eVar.ziz);
        com.tencent.mm.sdk.b.a.xmy.c(eVar.ziA);
        l lVar = this.ziM;
        if (lVar.lBc != null) {
            com.tencent.mm.sdk.b.a.xmy.c(lVar.lBc);
            lVar.lBc = null;
        }
        com.tencent.mm.sdk.b.a.xmy.c(lVar.zjd);
        com.tencent.mm.sdk.b.a.xmy.c(lVar.zje);
        if (com.tencent.mm.pluginsdk.q.a.viX != null) {
            com.tencent.mm.pluginsdk.q.a.viX.b(lVar);
        }
        if (as.Hp()) {
            t.WA();
        }
        c cVar = this.ziL;
        com.tencent.mm.sdk.b.a.xmy.c(cVar.zfC);
        com.tencent.mm.sdk.b.a.xmy.c(cVar.zfA);
        com.tencent.mm.sdk.b.a.xmy.c(cVar.zfB);
        cVar.activity = null;
        if (as.Hp() && this.zfz != null) {
            as.Hm();
            com.tencent.mm.y.c.Fk().b(this.zfz);
            as.Hm();
            com.tencent.mm.y.c.Ff().b(this.zfz);
        }
        if (this.zfz != null) {
            g gVar = this.zfz;
            if (gVar.zfQ != null) {
                com.tencent.mm.sdk.b.a.xmy.c(gVar.zfQ);
                gVar.zfQ = null;
            }
            this.zfz.zhy = null;
            com.tencent.mm.ui.f fVar = this.zfz;
            fVar.zhy = null;
            if (fVar.yvZ != null) {
                fVar.yvZ.clear();
                fVar.yvZ = null;
            }
            fVar.lW(true);
            fVar.cmJ();
            fVar.zhB.clear();
            x.i("MicroMsg.ConversationWithCacheAdapter", "clear usernamePositionMap");
        }
    }

    public final void cmp() {
        x.i("MicroMsg.MainUI", "turn to bg");
    }

    public final void cmq() {
        x.i("MicroMsg.MainUI", "turn to fg");
    }

    public final void cmo() {
        if (this.ziI != null) {
            this.ziI.cmo();
        }
    }

    public final void cng() {
        x.i("MicroMsg.MainUI", "dkinit onTabSwitchIn");
        i iVar = this.ziK;
        String str = "MicroMsg.InitHelper";
        String str2 = "onTabSwitchIn tip:%d initscene:%d";
        Object[] objArr = new Object[2];
        int i = iVar.inI == null ? -1 : iVar.inI.isShowing() ? 1 : 0;
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(iVar.cxy());
        x.i(str, str2, objArr);
        if (iVar.wakeLock != null) {
            iVar.cxx();
        }
        if (this.mController != null) {
            this.mController.onResume();
        }
    }

    public final void cnh() {
        x.i("MicroMsg.MainUI", "onTabSwitchOut");
        A(0, 8);
    }

    public void onDestroy() {
        x.i("MicroMsg.MainUI", "onDestroy");
        this.ziN.cxE();
        if (this.ziI != null) {
            ConversationWithAppBrandListView conversationWithAppBrandListView = this.ziI;
            if (conversationWithAppBrandListView.zgM != null) {
                conversationWithAppBrandListView.zgM.release();
            }
            conversationWithAppBrandListView.zgU.dead();
        }
        super.onDestroy();
    }

    public final void cxA() {
        if (this.zfz != null) {
            this.zfz.oad = true;
        }
    }

    public final void cxB() {
        if (this.zfz != null) {
            this.zfz.oad = false;
            this.zfz.cxs();
            if (thisActivity() != null) {
                this.ziL.aa(getActivity());
            }
        }
    }
}
