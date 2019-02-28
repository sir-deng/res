package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.a.jt;
import com.tencent.mm.f.a.qk;
import com.tencent.mm.f.a.ql;
import com.tencent.mm.f.a.qm;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.ui.a.e;
import com.tencent.mm.plugin.sns.ui.a.f;
import com.tencent.mm.plugin.sns.ui.a.h;
import com.tencent.mm.plugin.sns.ui.widget.SnsCommentPreloadTextView;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.bpb;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.i;
import com.tencent.mm.y.q;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public final class av implements y {
    public l contextMenuHelper;
    public MMActivity fnF;
    protected ag handler = new ag();
    private ListView ipH;
    com.tencent.mm.sdk.b.c jil;
    public i kMf;
    protected ScaleAnimation rFC;
    protected ScaleAnimation rFD;
    public ar rFJ;
    private int rFM = 0;
    public k rFO;
    public bg rFR;
    boolean rFe = false;
    com.tencent.mm.sdk.b.c rGe = new com.tencent.mm.sdk.b.c<qk>() {
        {
            this.xmG = qk.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            qk qkVar = (qk) bVar;
            if (qkVar instanceof qk) {
                String str = qkVar.fIP.id;
                if (qkVar.fIP.type == 1) {
                    av.c(av.this, str);
                } else if (qkVar.fIP.type == 2) {
                    av.d(av.this, qkVar.fIP.id);
                }
            }
            return false;
        }
    };
    com.tencent.mm.sdk.b.c rGf = new com.tencent.mm.sdk.b.c<ql>() {
        {
            this.xmG = ql.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            ql qlVar = (ql) bVar;
            if (qlVar instanceof ql) {
                if (qlVar.fIR.type == 1) {
                    av.a(av.this, qlVar.fIR.id);
                } else if (qlVar.fIR.type == 2) {
                    av.b(av.this, qlVar.fIR.id);
                }
            }
            return false;
        }
    };
    com.tencent.mm.sdk.b.c rGg = new com.tencent.mm.sdk.b.c<qm>() {
        {
            this.xmG = qm.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            qm qmVar = (qm) bVar;
            if (qmVar instanceof qm) {
                String str = qmVar.fIS.id;
                if (qmVar.fIS.type == 1) {
                    av.e(av.this, str);
                } else if (qmVar.fIS.type == 2) {
                    av.f(av.this, str);
                }
            }
            return false;
        }
    };
    private HashMap<Integer, com.tencent.mm.plugin.sns.ui.a.a> rNA = new HashMap();
    private HashMap<Integer, com.tencent.mm.plugin.sns.ui.a.a.c> rNB;
    public OnClickListener rNC;
    public OnClickListener rND;
    public HashMap<String, Boolean> rNE;
    private c rNF;
    protected x rNr;
    public j rNs;
    protected LinkedList<SnsCommentPreloadTextView> rNt = new LinkedList();
    public HashMap<Integer, WeakReference<View>> rNu = new HashMap();
    View rNv;
    public int rNw = -1;
    int rNx = 0;
    protected HashMap<Integer, View> rNy = new HashMap();
    public HashMap<String, String> rNz = new HashMap();
    protected int requestType = 0;
    public com.tencent.mm.plugin.sns.ui.b.b rfs;
    public OnTouchListener ryR;
    protected HashMap<String, Integer> rye = new HashMap();

    public interface a {
        boolean bCo();
    }

    static class c implements OnCreateContextMenuListener {
        private String fvn;
        private are qZY;
        private m rEl;
        private bpb ryt;
        private View targetView;
        private String url;

        c() {
        }

        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            Object tag = view.getTag();
            if (tag instanceof r) {
                r rVar = (r) tag;
                bpb bpb = rVar.ryt;
                view.getContext();
                String str = bpb.wYj.nlE;
                String str2 = bpb.wYi.nMq;
                str = av.MI(str);
                if (str != null && str.length() != 0) {
                    this.url = str;
                    this.fvn = rVar.fsC;
                    this.targetView = view;
                    this.qZY = bpb.wYj.wfh.size() > 0 ? (are) bpb.wYj.wfh.get(0) : null;
                    this.rEl = ae.bwf().LR(this.fvn);
                    this.ryt = bpb;
                    if (bpb.wYj.wfg != 10 && bpb.wYj.wfg != 13) {
                        if (d.Pu("favorite")) {
                            switch (bpb.wYj.wfg) {
                                case 4:
                                    contextMenu.add(0, 4, 0, view.getContext().getString(j.eAq));
                                    break;
                                case 9:
                                    contextMenu.add(0, 5, 0, view.getContext().getString(j.eAq));
                                    break;
                                case 14:
                                    contextMenu.add(0, 9, 0, view.getContext().getString(j.eAq));
                                    break;
                                default:
                                    contextMenu.add(0, 3, 0, view.getContext().getString(j.eAq));
                                    break;
                            }
                        }
                        if (this.rEl != null && !this.rEl.field_userName.equals(ae.bvL())) {
                            contextMenu.add(0, 8, 0, view.getContext().getString(j.dWa));
                        }
                    }
                }
            }
        }
    }

    public static class b implements com.tencent.mm.y.ak.b.a {
        int mPosition;
        x rNJ = null;

        public b(x xVar, int i) {
            this.rNJ = xVar;
            this.mPosition = i;
        }

        public final void v(String str, boolean z) {
            if (z) {
                g.Dr();
                if (g.Do().CF()) {
                    ae.aOA().post(new Runnable() {
                        public final void run() {
                            if (b.this.rNJ.bAe() != null) {
                                ((aw) b.this.rNJ.bAe()).HG(b.this.mPosition);
                            }
                            b.this.rNJ.notifyDataSetChanged();
                        }
                    });
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.av$7 */
    class AnonymousClass7 implements AnimationListener {
        boolean rGN = false;
        final /* synthetic */ LinearLayout rGO;
        final /* synthetic */ Runnable rNI;

        AnonymousClass7(LinearLayout linearLayout, Runnable runnable) {
            this.rGO = linearLayout;
            this.rNI = runnable;
        }

        public final void onAnimationEnd(Animation animation) {
            if (this.rGO != null) {
                this.rGO.setPressed(false);
            }
            if (!this.rGN) {
                this.rGN = true;
                if ((av.this.fnF instanceof u) && ((u) av.this.fnF).bAb()) {
                    av.this.rNr.notifyDataSetChanged();
                }
            }
            if (this.rNI != null) {
                this.rNI.run();
            }
        }

        public final void onAnimationRepeat(Animation animation) {
        }

        public final void onAnimationStart(Animation animation) {
        }
    }

    static /* synthetic */ void a(av avVar, String str) {
        x.d("MicroMsg.SnsTimeLineBaseAdapter", "postDescTranslateStart, id: %s", str);
        m LQ = ae.bwf().LQ(str);
        if (LQ != null) {
            String bza = LQ.bza();
            if (avVar.rye.containsKey(bza) && ((Integer) avVar.rye.get(bza)).equals(Integer.valueOf(1))) {
                avVar.rye.put(bza, Integer.valueOf(2));
            }
            ao.cd(str, 2);
            avVar.notifyDataSetChanged();
        }
    }

    static /* synthetic */ void b(av avVar, String str) {
        x.d("MicroMsg.SnsTimeLineBaseAdapter", "commentTranslateStart, id: %s", str);
        ao.cd(str, 2);
        avVar.notifyDataSetChanged();
    }

    static /* synthetic */ void c(av avVar, String str) {
        x.d("MicroMsg.SnsTimeLineBaseAdapter", "postDescTranslateFinish, id: %s", str);
        ao.cd(str, 2);
        avVar.notifyDataSetChanged();
    }

    static /* synthetic */ void d(av avVar, String str) {
        x.d("MicroMsg.SnsTimeLineBaseAdapter", "commentTranslateFinish, id: %s", str);
        ao.cd(str, 2);
        avVar.notifyDataSetChanged();
    }

    static /* synthetic */ void e(av avVar, String str) {
        x.d("MicroMsg.SnsTimeLineBaseAdapter", "unTranslatePostDesc, id: %s", str);
        ao.ce(str, 2);
        avVar.notifyDataSetChanged();
    }

    static /* synthetic */ void f(av avVar, String str) {
        x.d("MicroMsg.SnsTimeLineBaseAdapter", "unTranslateComment, id: %s", str);
        ao.ce(str, 2);
        avVar.notifyDataSetChanged();
    }

    public final void bCh() {
        this.rye.clear();
    }

    public final u bCi() {
        if (this.fnF instanceof u) {
            return (u) this.fnF;
        }
        return null;
    }

    public final SnsCommentPreloadTextView bCj() {
        if (this.rNt.size() == 0) {
            return new SnsCommentPreloadTextView(this.fnF);
        }
        return (SnsCommentPreloadTextView) this.rNt.removeFirst();
    }

    public final void a(SnsCommentPreloadTextView snsCommentPreloadTextView) {
        this.rNt.add(snsCommentPreloadTextView);
    }

    public final boolean bCk() {
        if (this.rNt != null) {
            this.rNt.clear();
        }
        if (this.rNB != null) {
            this.rNB.clear();
        }
        if (this.rNA != null) {
            this.rNA.clear();
        }
        com.tencent.mm.pluginsdk.ui.d.i.clearCache();
        com.tencent.mm.kiss.widget.textview.c.gUU.Ei();
        return true;
    }

    public final void notifyDataSetChanged() {
        this.rNr.notifyDataSetChanged();
    }

    public final void bCl() {
        this.rNr.bAd();
    }

    public av(MMActivity mMActivity, ListView listView, com.tencent.mm.plugin.sns.ui.b.b bVar, j jVar, int i, final x xVar) {
        this.rNA.put(Integer.valueOf(6), new f());
        this.rNA.put(Integer.valueOf(2), new e());
        this.rNA.put(Integer.valueOf(3), new e());
        this.rNA.put(Integer.valueOf(4), new e());
        this.rNA.put(Integer.valueOf(5), new e());
        this.rNA.put(Integer.valueOf(0), new com.tencent.mm.plugin.sns.ui.a.c());
        this.rNA.put(Integer.valueOf(1), new com.tencent.mm.plugin.sns.ui.a.d());
        this.rNA.put(Integer.valueOf(7), new com.tencent.mm.plugin.sns.ui.a.d());
        this.rNA.put(Integer.valueOf(8), new com.tencent.mm.plugin.sns.ui.a.d());
        this.rNA.put(Integer.valueOf(9), new h());
        this.rNA.put(Integer.valueOf(11), new com.tencent.mm.plugin.sns.ui.a.b());
        this.rNA.put(Integer.valueOf(10), new com.tencent.mm.plugin.sns.ui.a.d());
        this.rNB = new HashMap();
        this.rNB.put(Integer.valueOf(6), new com.tencent.mm.plugin.sns.ui.a.f.a());
        this.rNB.put(Integer.valueOf(2), new com.tencent.mm.plugin.sns.ui.a.e.a());
        this.rNB.put(Integer.valueOf(3), new com.tencent.mm.plugin.sns.ui.a.e.a());
        this.rNB.put(Integer.valueOf(4), new com.tencent.mm.plugin.sns.ui.a.e.a());
        this.rNB.put(Integer.valueOf(5), new com.tencent.mm.plugin.sns.ui.a.e.a());
        this.rNB.put(Integer.valueOf(0), new com.tencent.mm.plugin.sns.ui.a.e.a());
        this.rNB.put(Integer.valueOf(1), new com.tencent.mm.plugin.sns.ui.a.e.a());
        this.rNB.put(Integer.valueOf(7), new com.tencent.mm.plugin.sns.ui.a.e.a());
        this.rNB.put(Integer.valueOf(8), new com.tencent.mm.plugin.sns.ui.a.e.a());
        this.rNB.put(Integer.valueOf(9), new com.tencent.mm.plugin.sns.ui.a.e.a());
        this.rNB.put(Integer.valueOf(10), new com.tencent.mm.plugin.sns.ui.a.e.a());
        this.rNB.put(Integer.valueOf(12), new com.tencent.mm.plugin.sns.ui.a.a.c());
        this.rNC = new OnClickListener() {
            public final void onClick(View view) {
                x.i("MicroMsg.SnsTimeLineBaseAdapter", "showCommentBtn");
                av.this.rNs.rxy = false;
                com.tencent.mm.plugin.sns.abtest.a.buz();
                if (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.a.a.c) {
                    com.tencent.mm.plugin.sns.ui.a.a.c cVar = (com.tencent.mm.plugin.sns.ui.a.a.c) view.getTag();
                    if (cVar.rUN != null && cVar.rUN.wYj.wfg == 21) {
                        arf arf = cVar.ruX;
                        if (!q.FY().equals(cVar.rUN.kyG) && (arf == null || arf.fMy == 0)) {
                            com.tencent.mm.plugin.sns.lucky.ui.a.e(av.this.fnF, cVar.rUj.xQ(0));
                            return;
                        }
                    }
                    if (av.this.fnF instanceof u) {
                        ((u) av.this.fnF).cH(view);
                        return;
                    }
                    return;
                }
                x.e("MicroMsg.SnsTimeLineBaseAdapter", "showCommentBtn err1");
            }
        };
        this.rND = new OnClickListener() {
            public final void onClick(View view) {
                if (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.a.a.c) {
                    com.tencent.mm.plugin.sns.ui.a.a.c cVar = (com.tencent.mm.plugin.sns.ui.a.a.c) view.getTag();
                    if (cVar == null) {
                        return;
                    }
                    if (av.this.rye.containsKey(cVar.fsC) && ((Integer) av.this.rye.get(cVar.fsC)).equals(Integer.valueOf(1))) {
                        av.this.rye.put(cVar.fsC, Integer.valueOf(2));
                        av.this.rNr.notifyDataSetChanged();
                        return;
                    }
                    av.this.rye.put(cVar.fsC, Integer.valueOf(1));
                    if (cVar.nav.getTop() < 0) {
                        av.this.rfs.b(cVar.nav, cVar.position, cVar.nav.getTop(), cVar.rTL.bzS());
                    } else {
                        av.this.rNr.notifyDataSetChanged();
                    }
                }
            }
        };
        this.ryR = bi.chk();
        this.rNE = new HashMap();
        this.rNF = new c();
        this.jil = new com.tencent.mm.sdk.b.c<jt>() {
            {
                this.xmG = jt.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                jt jtVar = (jt) bVar;
                if (jtVar instanceof jt) {
                    switch (jtVar.fBu.action) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                            av.this.rNr.notifyDataSetChanged();
                            break;
                    }
                }
                return false;
            }
        };
        this.rNr = xVar;
        this.rNs = jVar;
        x.d("MicroMsg.SnsTimeLineBaseAdapter", "SnsTimeLineAdapter 2");
        this.ipH = listView;
        ae.bwc();
        this.fnF = mMActivity;
        this.rfs = bVar;
        this.contextMenuHelper = new l(mMActivity);
        this.kMf = new i(mMActivity);
        this.rFJ = new ar(mMActivity, (byte) 0);
        this.rFC = new ScaleAnimation(0.0f, 1.0f, 1.0f, 1.0f, 1, 1.0f, 1, 0.0f);
        this.rFC.setDuration(150);
        this.rFD = new ScaleAnimation(1.0f, 0.0f, 1.0f, 1.0f, 1, 1.0f, 1, 0.0f);
        this.rFD.setDuration(150);
        this.rFO = new k(mMActivity, 0, jVar.rxw);
        this.requestType = 10;
        this.rFR = new bg(mMActivity, new com.tencent.mm.plugin.sns.ui.bg.a() {
            public final void bBq() {
                xVar.notifyDataSetChanged();
            }
        }, 0, jVar.rxw);
        com.tencent.mm.sdk.b.a.xmy.b(this.jil);
    }

    public final void bCm() {
        int firstVisiblePosition = this.ipH.getFirstVisiblePosition() - this.ipH.getHeaderViewsCount();
        int lastVisiblePosition = this.ipH.getLastVisiblePosition() - this.ipH.getHeaderViewsCount();
        x.i("MicroMsg.SnsTimeLineBaseAdapter", "reConverItem start ~ end" + firstVisiblePosition + " " + lastVisiblePosition);
        int count = this.rNr.getCount();
        int i = firstVisiblePosition;
        while (i <= lastVisiblePosition && i < count) {
            m xL = xL(i);
            View view = (View) this.rNy.get(Integer.valueOf(i));
            if (view == null || xL == null || view.getTag() == null) {
                x.e("MicroMsg.SnsTimeLineBaseAdapter", " passe " + i);
            } else {
                com.tencent.mm.plugin.sns.ui.a.a.c cVar = (com.tencent.mm.plugin.sns.ui.a.a.c) view.getTag();
                x.i("MicroMsg.SnsTimeLineBaseAdapter", "reConverItem " + i + " " + cVar.position);
                cVar.rUQ.a(cVar, i, xL);
            }
            i++;
        }
    }

    public final View i(int i, View view) {
        com.tencent.mm.plugin.sns.ui.a.a.c cVar;
        com.tencent.mm.plugin.sns.ui.a.a aVar;
        m xL = this.rNr.xL(i);
        bpb byF = xL.byF();
        int d = d(byF);
        if (view == null) {
            com.tencent.mm.plugin.sns.ui.a.a cVar2;
            switch (d) {
                case 0:
                    cVar2 = new com.tencent.mm.plugin.sns.ui.a.c();
                    break;
                case 1:
                    cVar2 = new com.tencent.mm.plugin.sns.ui.a.d();
                    break;
                case 2:
                    cVar2 = new e();
                    break;
                case 3:
                    cVar2 = new e();
                    break;
                case 4:
                    cVar2 = new e();
                    break;
                case 5:
                    cVar2 = new e();
                    break;
                case 6:
                    cVar2 = new f();
                    break;
                case 7:
                    cVar2 = new com.tencent.mm.plugin.sns.ui.a.d();
                    break;
                case 8:
                    cVar2 = new com.tencent.mm.plugin.sns.ui.a.d();
                    break;
                case 9:
                    cVar2 = new h();
                    break;
                case 10:
                    cVar2 = new com.tencent.mm.plugin.sns.ui.a.d();
                    break;
                case 11:
                    cVar2 = new com.tencent.mm.plugin.sns.ui.a.b();
                    break;
                case 12:
                    cVar2 = new com.tencent.mm.plugin.sns.ui.a.g();
                    break;
                default:
                    cVar2 = new com.tencent.mm.plugin.sns.ui.a.d();
                    break;
            }
            com.tencent.mm.plugin.sns.ui.a.a.c aVar2 = new com.tencent.mm.plugin.sns.ui.a.e.a();
            aVar2.rUQ = cVar2;
            aVar2.rUN = byF;
            view = cVar2.a(this.fnF, aVar2, d, this, xL);
            cVar = aVar2;
            aVar = cVar2;
        } else {
            com.tencent.mm.plugin.sns.ui.a.a.c cVar3 = (com.tencent.mm.plugin.sns.ui.a.a.c) view.getTag();
            aVar = cVar3.rUQ;
            cVar = cVar3;
        }
        aVar.iT(this.rFe);
        String byG = xL.byG();
        ArrayList arrayList = new ArrayList();
        if (ao.bwI().size() > 0) {
            for (String str : ao.bwI().keySet()) {
                if (str.startsWith(byG)) {
                    com.tencent.mm.plugin.sns.model.ao.b bVar = (com.tencent.mm.plugin.sns.model.ao.b) ao.bwI().get(str);
                    if (ao.c(bVar)) {
                        arrayList.add(bVar);
                    }
                }
            }
        }
        aVar.rTE = arrayList;
        aVar.a(cVar, i, xL, byF, d, this);
        if (ao.cf(xL.byG(), 2)) {
            com.tencent.mm.plugin.sns.model.ao.b KW = ao.KW(xL.byG());
            if (xL.field_snsId == 0) {
                KW = new com.tencent.mm.plugin.sns.model.ao.b();
            }
            if (KW.hjU) {
                if (KW.hmT) {
                    com.tencent.mm.plugin.sns.ui.a.a.e(cVar);
                    ao.ce(KW.id, 2);
                } else {
                    String str2 = KW.result;
                    String str3 = KW.hrN;
                    if (!(cVar == null || cVar.rTO == null)) {
                        cVar.rTO.a(KW, 1, str2, str3, KW.rdD);
                        cVar.rTO.setVisibility(0);
                    }
                }
            } else if (!(cVar == null || cVar.rTO == null)) {
                cVar.rTO.yh(1);
                cVar.rTO.setVisibility(0);
            }
        } else {
            com.tencent.mm.plugin.sns.ui.a.a.e(cVar);
        }
        this.rNy.put(Integer.valueOf(i), view);
        return view;
    }

    public final int getItemViewType(int i) {
        return d(this.rNr.xL(i).byF());
    }

    public final x bCn() {
        return this.rNr;
    }

    protected static int d(bpb bpb) {
        if (bpb.wYj.wfg == 1) {
            int size = bpb.wYj.wfh.size();
            if (size <= 1) {
                return 2;
            }
            if (size <= 3) {
                return 3;
            }
            if (size <= 6) {
                return 4;
            }
            return 5;
        }
        switch (bpb.wYj.wfg) {
            case 1:
            case 8:
                return 3;
            case 2:
                return 6;
            case 4:
                return 0;
            case 5:
                return 1;
            case 7:
                return 2;
            case 14:
                return 7;
            case 15:
                if (bpb.wYq == 1) {
                    return 1;
                }
                return 9;
            case 21:
                return 11;
            case 27:
                return 12;
            default:
                return 1;
        }
    }

    public static String MH(String str) {
        if (bi.oN(str)) {
            return str;
        }
        int indexOf = str.indexOf("://");
        if (indexOf != -1) {
            str = str.substring(indexOf + 3);
        }
        indexOf = str.indexOf("/");
        if (indexOf != -1) {
            return str.substring(0, indexOf);
        }
        return str;
    }

    protected static String e(bpb bpb) {
        return com.tencent.mm.plugin.sns.c.a.ihO.A(bpb.wYj.nlE, "timeline");
    }

    public static String a(bpb bpb, Context context) {
        return com.tencent.mm.plugin.sns.c.a.ihO.f(context, bpb.wYi.nMq, "timeline");
    }

    public static String MI(String str) {
        x.d("MicroMsg.SnsTimeLineBaseAdapter", "url:" + str);
        return com.tencent.mm.plugin.sns.c.a.ihO.A(str, "timeline");
    }

    public final void E(Runnable runnable) {
        this.rNr.bAd();
        runnable.run();
    }

    public final void cI(View view) {
        if (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.a.a.c) {
            x.d("MicroMsg.SnsTimeLineBaseAdapter", "close comment v");
            if (this.rNv != null && this.rNv.getVisibility() == 0) {
                this.rNv.startAnimation(this.rFD);
                this.rFD.setAnimationListener(new AnimationListener() {
                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        if (av.this.rNv != null) {
                            av.this.rNv.clearAnimation();
                            av.this.rNv.setVisibility(8);
                        }
                        av.this.rNv = null;
                    }
                });
            }
        }
    }

    public final m xL(int i) {
        return this.rNr.xL(i);
    }

    public final int getCount() {
        return this.rNr.getCount();
    }

    public final boolean xM(int i) {
        if (i < this.ipH.getFirstVisiblePosition() - 1 || i > this.ipH.getLastVisiblePosition() - 1) {
            return false;
        }
        return true;
    }
}
