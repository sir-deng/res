package com.tencent.mm.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.p;
import android.support.v4.view.ViewPager.e;
import android.support.v4.view.u;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.f.a.an;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.ui.conversation.j;
import com.tencent.mm.ui.mogic.WxViewPager;
import com.tencent.mm.y.as;
import com.tencent.mm.y.s;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.HashMap;
import java.util.HashSet;

public final class w {
    private static HashMap<String, Integer> xTl;
    private final long hUT = 180000;
    private int mGf = -1;
    public int msV = -1;
    MMFragmentActivity xOh;
    public x xTc = new x();
    d xTd;
    boolean xTe;
    private HashSet<l> xTf = new HashSet();
    CustomViewPager xTg;
    a xTh;
    private int xTi = -1;
    private int xTj = -1;
    c xTk = new c<an>() {
        {
            this.xmG = an.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            int i = ((an) bVar).fpz.index;
            if (i >= 0 && i <= 3) {
                switch (i) {
                    case 0:
                        w.this.YW("tab_main");
                        break;
                    case 1:
                        w.this.YW("tab_address");
                        break;
                    case 2:
                        w.this.YW("tab_find_friend");
                        break;
                    case 3:
                        w.this.YW("tab_settings");
                        break;
                }
            }
            return false;
        }
    };
    public HashMap<Integer, u> xTm = new HashMap();

    public class a extends p implements e, com.tencent.mm.ui.c.a {
        private int rpa = 0;
        private com.tencent.mm.ui.contact.AddressUI.a xTo;
        private final WxViewPager xTp;
        private boolean xTq = false;
        boolean[] xTr = new boolean[]{true, false, false, false};

        public a(FragmentActivity fragmentActivity, WxViewPager wxViewPager) {
            super(fragmentActivity.getSupportFragmentManager());
            this.xTp = wxViewPager;
            this.xTp.a((u) this);
            this.xTp.b((e) this);
        }

        public final int getCount() {
            return 4;
        }

        public final Fragment R(int i) {
            return w.this.Eq(i);
        }

        public final void a(final int i, float f, int i2) {
            x a = w.this.xTc;
            if (a.xTu != null) {
                a.xTu.h(i, f);
            }
            if (0.0f != f) {
                if (this.xTo == null) {
                    this.xTo = (com.tencent.mm.ui.contact.AddressUI.a) w.this.Eq(1);
                }
                this.xTo.nf(false);
            } else {
                x.v("MicroMsg.LauncherUI.MainTabUI", "onPageScrolled, position = %d, mLastIndex = %d", Integer.valueOf(i), Integer.valueOf(w.this.mGf));
                if (-1 == w.this.mGf) {
                    w.this.eO(w.this.mGf, w.this.msV);
                    w.this.Eo(i);
                } else {
                    ah.y(new Runnable() {
                        public final void run() {
                            w.this.eO(w.this.mGf, w.this.msV);
                            w.this.Eo(i);
                        }
                    });
                }
            }
            if (i2 == 0) {
                for (Integer num : w.xTl.values()) {
                    if (num.intValue() != i) {
                        eP(num.intValue(), 8);
                    } else if (!this.xTr[num.intValue()]) {
                        eP(num.intValue(), 0);
                    }
                }
                return;
            }
            for (Integer num2 : w.xTl.values()) {
                if (!(num2.intValue() == i || this.xTr[num2.intValue()])) {
                    eP(num2.intValue(), 0);
                }
            }
        }

        private void eP(int i, int i2) {
            if (w.this.Eq(i) != null) {
                View findViewById = w.this.Eq(i).findViewById(R.h.ctE);
                if (findViewById != null) {
                    findViewById.setVisibility(i2);
                }
            }
        }

        public final void ae(int i) {
            x.d("MicroMsg.LauncherUI.MainTabUI", "on page selected changed to %d", Integer.valueOf(i));
            x.v("MicroMsg.LauncherUI.MainTabUI", "reportSwitch clickCount:%d, pos:%d", Integer.valueOf(this.rpa), Integer.valueOf(i));
            if (this.rpa <= 0) {
                switch (i) {
                    case 0:
                        g.pWK.k(10957, "5");
                        break;
                    case 1:
                        g.pWK.k(10957, "6");
                        break;
                    case 2:
                        g.pWK.k(10957, "7");
                        break;
                }
            }
            this.rpa--;
            switch (i) {
                case 0:
                    g.pWK.k(10957, "1");
                    break;
                case 1:
                    g.pWK.k(10957, "2");
                    break;
                case 2:
                    g.pWK.k(10957, TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
                    break;
                case 3:
                    g.pWK.k(10957, "4");
                    break;
            }
            this.xTq = false;
            w.this.mGf = w.this.msV;
            w.this.msV = i;
            w.this.eO(w.this.mGf, w.this.msV);
            w.this.xTc.Es(i);
            w.this.xOh.supportInvalidateOptionsMenu();
            if (w.this.mGf == 1 && w.this.msV != 1) {
                as.Hm();
                com.tencent.mm.y.c.Db().set(340226, Long.valueOf(System.currentTimeMillis()));
            }
            if (w.this.msV == 1) {
                long currentTimeMillis = System.currentTimeMillis();
                as.Hm();
                if (currentTimeMillis - t.d((Long) com.tencent.mm.y.c.Db().get(340226, null)) >= 180000) {
                    ((com.tencent.mm.ui.contact.AddressUI.a) w.this.Eq(w.this.msV)).cwA();
                }
            }
            if (w.this.msV == 0) {
                as.getNotification().aW(true);
            } else {
                as.getNotification().aW(false);
            }
        }

        public final void af(int i) {
            x.d("MicroMsg.LauncherUI.MainTabUI", "onPageScrollStateChanged state %d", Integer.valueOf(i));
            if (i == 0 && this.xTo != null) {
                this.xTo.nf(true);
                this.xTo = null;
            }
        }

        public final void po(int i) {
            if (i == w.this.msV) {
                x.d("MicroMsg.LauncherUI.MainTabUI", "on click same index");
                u Eq = w.this.Eq(i);
                if (Eq instanceof com.tencent.mm.ui.AbstractTabChildActivity.a) {
                    ((com.tencent.mm.ui.AbstractTabChildActivity.a) Eq).cmo();
                    return;
                }
                return;
            }
            this.xTq = true;
            this.rpa++;
            x.v("MicroMsg.LauncherUI.MainTabUI", "onTabClick count:%d", Integer.valueOf(this.rpa));
            this.xTp.d(i, false);
            if (i == 3) {
                com.tencent.mm.r.c.Bx().aS(262145, 266241);
                com.tencent.mm.r.c.Bx().aS(262156, 266241);
                com.tencent.mm.r.c.Bx().aS(262147, 266241);
                com.tencent.mm.r.c.Bx().aS(262149, 266241);
                com.tencent.mm.r.c.Bx().b(com.tencent.mm.storage.w.a.NEW_BANDAGE_DATASOURCE_DEVICE_PROTECT_STRING_SYNC, 266241);
                boolean aR = com.tencent.mm.r.c.Bx().aR(262156, 266241);
                g gVar = g.pWK;
                Object[] objArr = new Object[5];
                objArr[0] = Integer.valueOf(6);
                objArr[1] = Integer.valueOf(aR ? 1 : 0);
                objArr[2] = "";
                objArr[3] = "";
                objArr[4] = Integer.valueOf(0);
                gVar.h(14872, objArr);
            }
        }
    }

    public final u cnU() {
        return (u) this.xTm.get(Integer.valueOf(this.msV));
    }

    public final void cnr() {
        j jVar = (j) this.xTm.get(Integer.valueOf(0));
        if (jVar != null) {
            jVar.cwy();
            jVar.cxC();
        }
    }

    public final void cnV() {
        j jVar = (j) this.xTm.get(Integer.valueOf(0));
        if (jVar != null) {
            jVar.cxD();
        }
    }

    public final void eO(int i, int i2) {
        if (i != i2) {
            u Eq = Eq(i);
            if (Eq != null && (Eq instanceof l)) {
                ((l) Eq).cnh();
            }
            Eq = Eq(i2);
            if (Eq != null && (Eq instanceof l)) {
                ((l) Eq).cng();
            }
            k.a(this.xOh, 4, i, "deliverOnTabChange");
            k.a(this.xOh, 3, i2, "deliverOnTabChange");
        }
    }

    public final void Eo(int i) {
        u Eq = Eq(i);
        if (Eq != null) {
            if (Eq instanceof l) {
                ((l) Eq).cmu();
            }
            this.xTh.xTr[i] = true;
        }
    }

    public final void cnW() {
        j jVar = (j) this.xTm.get(Integer.valueOf(0));
        ViewGroup viewGroup = (ViewGroup) this.xOh.findViewById(R.h.csD);
        if (viewGroup != null) {
            viewGroup.setImportantForAccessibility(4);
        }
        if (jVar != null) {
            jVar.onHiddenChanged(true);
        }
        k.a(this.xOh, 4, this.msV, "prepareStartChatting");
        cnV();
        this.xTc.cnY();
    }

    static {
        HashMap hashMap = new HashMap();
        xTl = hashMap;
        hashMap.put("tab_main", Integer.valueOf(0));
        xTl.put("tab_address", Integer.valueOf(1));
        xTl.put("tab_find_friend", Integer.valueOf(2));
        xTl.put("tab_settings", Integer.valueOf(3));
    }

    public final void YW(String str) {
        if (str != null && !str.equals("")) {
            Ep(((Integer) xTl.get(str)).intValue());
        }
    }

    public final void Ep(int i) {
        String str = "MicroMsg.LauncherUI.MainTabUI";
        String str2 = "change tab to %d, cur tab %d, has init tab %B, tab cache size %d";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(this.msV);
        objArr[2] = Boolean.valueOf(this.xTg != null);
        objArr[3] = Integer.valueOf(this.xTm.size());
        x.i(str, str2, objArr);
        if (this.xTg != null && i >= 0) {
            if (this.xTh != null && i > this.xTh.getCount() - 1) {
                return;
            }
            if (this.msV != i || this.xTm.size() == 0) {
                this.msV = i;
                this.xTc.Es(this.msV);
                if (this.xTg != null) {
                    this.xTg.d(this.msV, false);
                    Eo(this.msV);
                }
                if (this.msV == 0 && com.tencent.mm.kernel.g.Dp().gRu.foreground) {
                    as.getNotification().aW(true);
                } else {
                    as.getNotification().aW(false);
                }
            }
        }
    }

    public final u Eq(int i) {
        u uVar = null;
        x.d("MicroMsg.LauncherUI.MainTabUI", "get tab %d", Integer.valueOf(i));
        if (i < 0) {
            return null;
        }
        if (this.xTm.containsKey(Integer.valueOf(i))) {
            return (u) this.xTm.get(Integer.valueOf(i));
        }
        Bundle bundle = new Bundle();
        switch (i) {
            case 0:
                bundle.putInt(j.class.getName(), 0);
                uVar = (u) Fragment.instantiate(this.xOh, j.class.getName(), bundle);
                as.getNotification().aW(true);
                break;
            case 1:
                bundle.putInt(com.tencent.mm.ui.contact.AddressUI.a.class.getName(), 1);
                bundle.putBoolean("Need_Voice_Search", true);
                bundle.putBoolean("favour_include_biz", true);
                uVar = (u) Fragment.instantiate(this.xOh, com.tencent.mm.ui.contact.AddressUI.a.class.getName(), bundle);
                break;
            case 2:
                bundle.putInt(h.class.getName(), 2);
                uVar = (u) Fragment.instantiate(this.xOh, h.class.getName(), bundle);
                break;
            case 3:
                bundle.putInt(y.class.getName(), 3);
                uVar = (u) Fragment.instantiate(this.xOh, y.class.getName(), bundle);
                break;
        }
        x.v("MicroMsg.LauncherUI.MainTabUI", "createFragment index:%d", Integer.valueOf(i));
        if (uVar != null) {
            uVar.setParent(this.xOh);
        }
        this.xTm.put(Integer.valueOf(i), uVar);
        return uVar;
    }

    public final int cnX() {
        x xVar = this.xTc;
        return (xVar.xTu == null || xVar.xTu.cmw() <= 0) ? 0 : xVar.xTu.cmw();
    }

    protected final void cnY() {
        this.xTc.cnY();
    }

    protected final void cnZ() {
        this.xTc.cnZ();
    }

    protected final void coa() {
        this.xTc.coa();
    }

    public final int cob() {
        int a;
        x xVar = this.xTc;
        long currentTimeMillis = System.currentTimeMillis();
        if (as.Hp()) {
            a = com.tencent.mm.y.t.a(s.hgU, af.cou());
            x.d("MicroMsg.LauncherUI", "getMainTabUnreadCount  unread : %d", Integer.valueOf(a));
        } else {
            x.w("MicroMsg.UnreadCountHelper", "getMainTabUnreadCount, but mmcore not ready");
            a = 0;
        }
        xVar.Er(a);
        x.d("MicroMsg.LauncherUI.MainTabUnreadMgr", "unreadcheck setConversationTagUnread  last time %d, unread %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(a));
        return a;
    }
}
