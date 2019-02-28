package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.t;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.lv;
import com.tencent.mm.f.a.qd;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.SpellMap;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiCreateAudioInstance;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetAudioState;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.protocal.c.awe;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.bc;
import com.tencent.mm.storage.bf;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.RealAlphabetScrollBar;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.q;
import com.tencent.mm.y.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class UnfamiliarContactDetailUI extends MMActivity implements com.tencent.mm.ad.e {
    public static final String ljD = new String(Character.toChars(123));
    private r jqf = null;
    private ArrayList<b> jtl = new ArrayList();
    private View pzp;
    private boolean qmj;
    private boolean qmk;
    private boolean qml;
    private RecyclerView qrM;
    private TextView qrN;
    private View qrO;
    private View qrP;
    private View qrQ;
    private TextView qrR;
    private a qrS;
    private RealAlphabetScrollBar qrT;
    HashMap<String, Integer> qrU = new HashMap();
    private HashMap<Integer, String> qrV = new HashMap();
    private HashSet<Integer> qrW = new HashSet();
    private d qrX;
    private int qrY = -1;
    private HashSet<String> qrZ = new HashSet();
    private com.tencent.mm.plugin.setting.a.a qsa;
    private boolean qsb;

    class c extends t {
        View VU;
        MaskLayout lji;
        CheckBox mXO;
        TextView qsj;
        TextView qsk;
        ImageView qsl;
        ImageView qsm;
        LinearLayout qsn;
        LinearLayout qso;

        static /* synthetic */ void a(c cVar, b bVar, int i) {
            if (bVar != null) {
                if (UnfamiliarContactDetailUI.this.qsb) {
                    f.qsE++;
                } else {
                    f.qsF++;
                }
                String str = bVar.gDt;
                String str2 = bVar.jQP.field_username;
                String str3 = bVar.jQP.field_nickname;
                if (bi.oN(str)) {
                    as.Hm();
                    bf FF = com.tencent.mm.y.c.Fg().FF(str2);
                    if (!(FF == null || bi.oN(FF.field_encryptUsername))) {
                        str = FF.field_conRemark;
                    }
                }
                if (!bi.oN(str2)) {
                    Intent intent = new Intent();
                    intent.putExtra("Contact_User", str2);
                    intent.putExtra("Contact_RemarkName", str);
                    intent.putExtra("Contact_Nick", str3);
                    com.tencent.mm.plugin.setting.a.ihN.d(intent, UnfamiliarContactDetailUI.this);
                    UnfamiliarContactDetailUI.this.qrY = i;
                }
            }
        }

        public c(View view) {
            super(view);
            this.VU = view;
            this.lji = (MaskLayout) view.findViewById(R.h.bXf);
            this.qsj = (TextView) view.findViewById(R.h.bYn);
            this.qsk = (TextView) view.findViewById(R.h.bXe);
            this.qsl = (ImageView) view.findViewById(R.h.bYu);
            this.qsm = (ImageView) view.findViewById(R.h.bYv);
            this.qsn = (LinearLayout) view.findViewById(R.h.bWb);
            this.mXO = (CheckBox) view.findViewById(R.h.checkbox);
            this.qso = (LinearLayout) view.findViewById(R.h.crv);
            this.qsn.setOnClickListener(new OnClickListener(UnfamiliarContactDetailUI.this) {
                public final void onClick(View view) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    c.this.mXO.setChecked(!c.this.mXO.isChecked());
                    if (c.this.mXO.isChecked()) {
                        UnfamiliarContactDetailUI.this.qrW.add(Integer.valueOf(intValue));
                    } else {
                        UnfamiliarContactDetailUI.this.qrW.remove(Integer.valueOf(intValue));
                    }
                    if (UnfamiliarContactDetailUI.this.qrW.size() == 0) {
                        UnfamiliarContactDetailUI.this.qrP.setEnabled(false);
                        UnfamiliarContactDetailUI.this.qrO.setEnabled(false);
                        return;
                    }
                    UnfamiliarContactDetailUI.this.qrP.setEnabled(true);
                    UnfamiliarContactDetailUI.this.qrO.setEnabled(true);
                }
            });
            view.setOnClickListener(new OnClickListener(UnfamiliarContactDetailUI.this) {
                public final void onClick(View view) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    x.i("MicroMsg.UnfamiliarContactUI", "position:%s", Integer.valueOf(intValue), UnfamiliarContactDetailUI.this.qrS.wq(intValue).gDt);
                    c.a(c.this, r1, intValue);
                }
            });
        }
    }

    static class f {
        static int qsA;
        static int qsB;
        static int qsC;
        static int qsD;
        static int qsE;
        static int qsF;
    }

    public interface h {
        void a(e eVar);

        void e(HashSet hashSet);

        void onError();

        void onSuccess();
    }

    class a extends android.support.v7.widget.RecyclerView.a {
        a() {
        }

        public final t a(ViewGroup viewGroup, int i) {
            return new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.i.dty, viewGroup, false));
        }

        public final void a(t tVar, int i) {
            if (tVar instanceof c) {
                int i2;
                c cVar = (c) tVar;
                cVar.qsn.setTag(Integer.valueOf(i));
                cVar.VU.setTag(Integer.valueOf(i));
                b bVar = (b) UnfamiliarContactDetailUI.this.jtl.get(i);
                com.tencent.mm.pluginsdk.ui.a.b.a((ImageView) cVar.lji.view, bVar.jQP.field_username);
                cVar.qsj.setText(i.b(UnfamiliarContactDetailUI.this.mController.xRr, bVar.gDt, cVar.qsj.getTextSize()));
                cVar.qsm.setVisibility(bVar.jQP.AR() ? 0 : 8);
                ImageView imageView = cVar.qsl;
                String str = bVar.jQP.field_username;
                if (n.qWE != null && UnfamiliarContactDetailUI.this.qrZ.size() == 0) {
                    UnfamiliarContactDetailUI.this.qrZ.addAll(n.qWE.ep(5));
                }
                if (UnfamiliarContactDetailUI.this.qrZ.contains(str)) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                imageView.setVisibility(i2);
                if (UnfamiliarContactDetailUI.this.qrV.containsKey(Integer.valueOf(i))) {
                    cVar.qsk.setVisibility(0);
                    cVar.qsk.setText((CharSequence) UnfamiliarContactDetailUI.this.qrV.get(Integer.valueOf(i)));
                } else {
                    cVar.qsk.setVisibility(8);
                }
                if (UnfamiliarContactDetailUI.this.qsb) {
                    cVar.qso.setPadding(cVar.qso.getPaddingLeft(), cVar.qso.getPaddingTop(), 0, cVar.qso.getPaddingBottom());
                    if (UnfamiliarContactDetailUI.this.qrW.contains(Integer.valueOf(i))) {
                        cVar.mXO.setChecked(true);
                    } else {
                        cVar.mXO.setChecked(false);
                    }
                    cVar.qsn.setVisibility(0);
                    return;
                }
                cVar.qso.setPadding(cVar.qso.getPaddingLeft(), cVar.qso.getPaddingTop(), (int) UnfamiliarContactDetailUI.this.getResources().getDimension(R.f.bvz), cVar.qso.getPaddingBottom());
                cVar.qsn.setVisibility(8);
            }
        }

        public final int getItemCount() {
            return UnfamiliarContactDetailUI.this.jtl.size();
        }

        public final b wq(int i) {
            if (UnfamiliarContactDetailUI.this.jtl.size() > i) {
                return (b) UnfamiliarContactDetailUI.this.jtl.get(i);
            }
            return new b(new com.tencent.mm.storage.x());
        }
    }

    class d implements com.tencent.mm.ad.e, Runnable {
        int index = 0;
        int ouE = 0;
        g qsr;
        Collection<Integer> qss;
        int qst = 0;
        LinkedList<String> qsu = new LinkedList();
        LinkedList<com.tencent.mm.plugin.messenger.foundation.a.a.e.b> qsv = new LinkedList();

        d(Collection<Integer> collection, g gVar) {
            this.qss = collection;
            this.qsr = gVar;
        }

        public final void run() {
            this.ouE = this.qss.size();
            for (Integer intValue : this.qss) {
                int intValue2 = intValue.intValue();
                this.index++;
                int size = this.qss.size();
                int i = this.index;
                if (UnfamiliarContactDetailUI.this.qrS != null) {
                    ag agVar = UnfamiliarContactDetailUI.this.qrS.wq(intValue2).jQP;
                    if (com.tencent.mm.storage.x.Xg(agVar.field_username)) {
                        ((com.tencent.mm.openim.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.openim.a.a.class)).ow(agVar.field_username);
                    } else {
                        this.qsv.add(new com.tencent.mm.ax.c(agVar.field_username));
                        if (this.qsv.size() % 20 == 0 || i == size) {
                            com.tencent.mm.kernel.g.Dr();
                            com.tencent.mm.kernel.g.Dp().gRu.a(new com.tencent.mm.ax.a(this.qsv), 0);
                            this.qsv.clear();
                        }
                    }
                }
            }
        }

        public final void a(int i, int i2, String str, k kVar) {
            if (kVar.getType() != 681) {
                return;
            }
            if (((com.tencent.mm.ax.a) kVar).hKx == null || ((com.tencent.mm.ax.a) kVar).hKx.hKA == null) {
                x.e("MicroMsg.UnfamiliarContactUI", "[onSceneEnd] rr is null!");
                return;
            }
            awe awe = ((com.tencent.mm.ax.a) kVar).hKx.hKA.hKC;
            if (awe.vQL != 0 || awe.wKo == null || awe.wKo.wrr == null) {
                x.e("MicroMsg.UnfamiliarContactUI", "summeroplog tryStartNetscene onSceneEnd Ret:%d  not ok and no retry.", Integer.valueOf(awe.vQL));
                return;
            }
            List list = ((com.tencent.mm.ax.a) kVar).hKy;
            x.i("MicroMsg.UnfamiliarContactUI", "[onSceneEnd] list size:%s, result:%s", Integer.valueOf(list.size()), Integer.valueOf(awe.wKo.wrr.size()));
            for (int i3 = 0; i3 < list.size(); i3++) {
                com.tencent.mm.plugin.messenger.foundation.a.a.e.b bVar = (com.tencent.mm.plugin.messenger.foundation.a.a.e.b) list.get(i3);
                if (bVar.getCmdId() == 4 && (bVar instanceof com.tencent.mm.ax.c)) {
                    this.ouE--;
                    com.tencent.mm.ax.c cVar = (com.tencent.mm.ax.c) bVar;
                    if (((Integer) r5.get(i3)).intValue() == 0) {
                        this.qst++;
                        ag Xv = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Ff().Xv(cVar.username);
                        if (Xv != null) {
                            Xv.Ao();
                            bb.a(Xv.field_username, null);
                            as.Hm();
                            com.tencent.mm.y.c.Ff().a(Xv.field_username, Xv);
                            as.Hm();
                            com.tencent.mm.y.c.Fk().XE(Xv.field_username);
                            this.qsu.add(Xv.field_username);
                        }
                    } else {
                        x.e("MicroMsg.UnfamiliarContactUI", "delete contact fail! ret:%s", r5.get(i3), cVar.username);
                    }
                } else {
                    x.w("MicroMsg.UnfamiliarContactUI", "cmdId:%s operation:%s", Integer.valueOf(bVar.getCmdId()), bVar.toString());
                }
            }
            if (this.ouE <= 0) {
                Iterator it = this.qsu.iterator();
                while (it.hasNext()) {
                    String str2 = (String) it.next();
                    Iterator it2 = UnfamiliarContactDetailUI.this.jtl.iterator();
                    while (it2.hasNext()) {
                        if (((b) it2.next()).jQP.field_username.equals(str2)) {
                            it2.remove();
                        }
                    }
                }
                UnfamiliarContactDetailUI.this.bJ(UnfamiliarContactDetailUI.this.jtl);
                UnfamiliarContactDetailUI.this.runOnUiThread(new Runnable() {
                    public final void run() {
                        if (d.this.qsr != null) {
                            d.this.qsr.dw(UnfamiliarContactDetailUI.this.qrW.size(), d.this.qst);
                            UnfamiliarContactDetailUI.this.qrW.clear();
                        }
                    }
                });
            }
        }
    }

    class b {
        String gDt;
        com.tencent.mm.storage.x jQP;
        String qsi;

        public b(com.tencent.mm.storage.x xVar) {
            this.jQP = xVar;
        }
    }

    public enum e {
        OVER_ONE_MIN,
        NORMAL
    }

    interface g {
        void brT();

        void dw(int i, int i2);
    }

    static /* synthetic */ void a(UnfamiliarContactDetailUI unfamiliarContactDetailUI, HashSet hashSet) {
        unfamiliarContactDetailUI.jtl.clear();
        Object linkedList = new LinkedList();
        Iterator it = hashSet.iterator();
        int i = 0;
        while (it.hasNext()) {
            linkedList.add((String) it.next());
            i++;
            if (i % 200 == 0 || i == hashSet.size()) {
                Cursor cK = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Ff().cK(linkedList);
                if (cK != null) {
                    cK.moveToFirst();
                    while (!cK.isAfterLast()) {
                        ag xVar = new com.tencent.mm.storage.x();
                        xVar.b(cK);
                        if (com.tencent.mm.k.a.ga(xVar.field_type)) {
                            String str;
                            b bVar = new b(xVar);
                            ag agVar = bVar.jQP;
                            if (agVar == null) {
                                str = null;
                            } else {
                                str = agVar.field_nickname;
                                if (!bi.oN(agVar.field_conRemark)) {
                                    str = agVar.field_conRemark;
                                } else if (bi.oN(str)) {
                                    str = agVar.AW();
                                }
                            }
                            String str2 = "";
                            if (TextUtils.isEmpty(str)) {
                                x.w("MicroMsg.UnfamiliarContactUI", "[%s:%s]", xVar.field_username, xVar.field_nickname);
                            } else {
                                str2 = SpellMap.g(str.charAt(0));
                            }
                            str2 = bi.oN(str2) ? ljD : !str2.matches("[a-zA-Z]+$") ? ljD : str2.toLowerCase().substring(0, 1);
                            bVar.qsi = str2;
                            bVar.gDt = str;
                            unfamiliarContactDetailUI.jtl.add(bVar);
                            cK.moveToNext();
                        } else {
                            x.d("MicroMsg.UnfamiliarContactUI", "contact:%s username:%s", xVar.field_nickname, xVar.field_username);
                            cK.moveToNext();
                        }
                    }
                    cK.close();
                }
                linkedList.clear();
            }
        }
        Collections.sort(unfamiliarContactDetailUI.jtl, new Comparator<b>() {
            public final /* synthetic */ int compare(Object obj, Object obj2) {
                return ((b) obj).qsi.compareTo(((b) obj2).qsi);
            }
        });
        unfamiliarContactDetailUI.bJ(unfamiliarContactDetailUI.jtl);
    }

    static /* synthetic */ void a(UnfamiliarContactDetailUI unfamiliarContactDetailUI, final HashSet hashSet, final int i) {
        unfamiliarContactDetailUI.ec(true);
        if (i == 0) {
            f.qsD += hashSet.size();
        } else if (i == 1) {
            f.qsC += hashSet.size();
        }
        com.tencent.mm.sdk.f.e.post(new Runnable() {
            public final void run() {
                List linkedList = new LinkedList();
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    b wq = UnfamiliarContactDetailUI.this.qrS.wq(((Integer) it.next()).intValue());
                    x.i("MicroMsg.UnfamiliarContactUI", "username:%s index:%s", wq.jQP.field_username, Integer.valueOf(i));
                    com.tencent.mm.sdk.b.b qdVar;
                    if (i == 0) {
                        qdVar = new qd();
                        qdVar.fIC.fIE = false;
                        qdVar.fIC.fID = true;
                        qdVar.fIC.username = wq.jQP.field_username;
                        com.tencent.mm.sdk.b.a.xmy.m(qdVar);
                        linkedList.add(wq.jQP.field_username);
                    } else if (i == 1) {
                        wq.jQP.AC();
                        qdVar = new qd();
                        qdVar.fIC.fIE = true;
                        qdVar.fIC.fID = false;
                        qdVar.fIC.username = wq.jQP.field_username;
                        com.tencent.mm.sdk.b.a.xmy.m(qdVar);
                        s.j(wq.jQP);
                    }
                }
                if (linkedList.size() > 0) {
                    com.tencent.mm.sdk.b.b lvVar = new lv();
                    lvVar.fEb.list = linkedList;
                    lvVar.fEb.fvo = 1;
                    lvVar.fEb.fEc = 5;
                    com.tencent.mm.sdk.b.a.xmy.m(lvVar);
                    return;
                }
                UnfamiliarContactDetailUI.this.runOnUiThread(new Runnable() {
                    public final void run() {
                        UnfamiliarContactDetailUI.this.qrS.UR.notifyChanged();
                        UnfamiliarContactDetailUI.this.ec(false);
                    }
                });
            }
        }, "handleSnsSetting");
    }

    static /* synthetic */ void b(UnfamiliarContactDetailUI unfamiliarContactDetailUI, boolean z) {
        Animation loadAnimation;
        if (z) {
            loadAnimation = AnimationUtils.loadAnimation(unfamiliarContactDetailUI, R.a.bqo);
            loadAnimation.setAnimationListener(new AnimationListener() {
                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    UnfamiliarContactDetailUI.this.pzp.setVisibility(0);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
            unfamiliarContactDetailUI.pzp.startAnimation(loadAnimation);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(unfamiliarContactDetailUI, R.a.bqm);
            loadAnimation.setAnimationListener(new AnimationListener() {
                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    UnfamiliarContactDetailUI.this.pzp.setVisibility(8);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
            unfamiliarContactDetailUI.pzp.startAnimation(loadAnimation);
        }
        unfamiliarContactDetailUI.qsb = z;
        if (unfamiliarContactDetailUI.qsb) {
            unfamiliarContactDetailUI.updateOptionMenuText(1, unfamiliarContactDetailUI.getString(R.l.eRW));
            return;
        }
        unfamiliarContactDetailUI.updateOptionMenuText(1, unfamiliarContactDetailUI.getString(R.l.eSa));
        ((CheckBox) unfamiliarContactDetailUI.qrQ.findViewById(R.h.checkbox)).setChecked(false);
    }

    protected final int getLayoutId() {
        return R.i.dsx;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        as.CN().a((int) JsApiCreateAudioInstance.CTRL_INDEX, (com.tencent.mm.ad.e) this);
        this.qmj = getIntent().getBooleanExtra("half_year_not_chat", false);
        this.qmk = getIntent().getBooleanExtra("half_year_not_response", false);
        this.qml = getIntent().getBooleanExtra("has_not_same_chatroom", false);
        initView();
        this.qsa = new com.tencent.mm.plugin.setting.a.a(this.qmj, this.qmk, this.qml, new h() {
            long start = System.currentTimeMillis();

            public final void onSuccess() {
                x.i("MicroMsg.UnfamiliarContactUI", "[onSuccess] size:%s cost:%sms", Integer.valueOf(UnfamiliarContactDetailUI.this.jtl.size()), Long.valueOf(System.currentTimeMillis() - this.start));
                UnfamiliarContactDetailUI.this.qrN.setText(UnfamiliarContactDetailUI.this.getString(R.l.eRZ) + "(" + UnfamiliarContactDetailUI.this.jtl.size() + ")");
                if (UnfamiliarContactDetailUI.this.jtl.size() == 0) {
                    UnfamiliarContactDetailUI.this.findViewById(R.h.cRY).setVisibility(0);
                    UnfamiliarContactDetailUI.this.findViewById(R.h.cEf).setVisibility(8);
                    UnfamiliarContactDetailUI.this.findViewById(R.h.ctg).setVisibility(8);
                    UnfamiliarContactDetailUI.this.qrR.setText(UnfamiliarContactDetailUI.this.getString(R.l.eti));
                    return;
                }
                UnfamiliarContactDetailUI.this.findViewById(R.h.cRY).setVisibility(8);
                UnfamiliarContactDetailUI.this.findViewById(R.h.ctg).setVisibility(0);
                if (UnfamiliarContactDetailUI.this.qrS != null) {
                    UnfamiliarContactDetailUI.this.qrS.UR.notifyChanged();
                }
            }

            public final void onError() {
                x.e("MicroMsg.UnfamiliarContactUI", "[onError]");
                UnfamiliarContactDetailUI.this.findViewById(R.h.cRY).setVisibility(0);
                UnfamiliarContactDetailUI.this.findViewById(R.h.cEf).setVisibility(8);
                UnfamiliarContactDetailUI.this.qrR.setText(UnfamiliarContactDetailUI.this.getString(R.l.eSd));
            }

            public final void a(e eVar) {
                x.i("MicroMsg.UnfamiliarContactUI", "[onLoading] type:%s", eVar.name());
                UnfamiliarContactDetailUI.this.findViewById(R.h.cRY).setVisibility(0);
                UnfamiliarContactDetailUI.this.findViewById(R.h.cEf).setVisibility(0);
                if (eVar == e.NORMAL) {
                    UnfamiliarContactDetailUI.this.qrR.setText(UnfamiliarContactDetailUI.this.getString(R.l.ctG));
                } else if (eVar == e.OVER_ONE_MIN) {
                    UnfamiliarContactDetailUI.this.qrR.setText(UnfamiliarContactDetailUI.this.getString(R.l.eSe));
                }
            }

            public final void e(HashSet hashSet) {
                String str = "MicroMsg.UnfamiliarContactUI";
                String str2 = "[onResult] size:%s";
                Object[] objArr = new Object[1];
                objArr[0] = Integer.valueOf(hashSet == null ? 0 : hashSet.size());
                x.i(str, str2, objArr);
                if (hashSet != null) {
                    UnfamiliarContactDetailUI.a(UnfamiliarContactDetailUI.this, hashSet);
                }
            }
        });
        com.tencent.mm.plugin.setting.a.a aVar = this.qsa;
        aVar.neh = System.currentTimeMillis();
        aVar.qms.a(e.NORMAL);
        aVar.gSq.F(new Runnable() {
            public final void run() {
                a aVar = a.this;
                long currentTimeMillis = System.currentTimeMillis();
                LinkedList linkedList = new LinkedList();
                ar Ff = ((h) g.h(h.class)).Ff();
                String str = "@all.contact.without.chatroom";
                List arrayList = new ArrayList();
                arrayList.add("tmessage");
                arrayList.add("officialaccounts");
                arrayList.add("filehelper");
                arrayList.add("helper_entry");
                arrayList.add(q.FY());
                bc FE = ((h) g.h(h.class)).Fn().FE("@t.qq.com");
                if (FE != null) {
                    arrayList.add(FE.name);
                }
                arrayList.add("blogapp");
                Cursor a = Ff.a(str, null, arrayList, null, false, false);
                if (a != null) {
                    a.moveToFirst();
                    while (!a.isAfterLast()) {
                        ag xVar = new com.tencent.mm.storage.x();
                        xVar.b(a);
                        linkedList.add(xVar.field_username);
                        a.moveToNext();
                    }
                    a.close();
                }
                x.i("MicroMsg.UnfamiliarContactEngine", "[getQuery] cost:%sms list size:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(linkedList.size()));
                a.a(aVar, linkedList);
            }
        });
    }

    protected void onResume() {
        super.onResume();
        if (-1 != this.qrY) {
            Object obj;
            if (-1 == this.qrY) {
                obj = null;
            } else {
                b bVar = (b) this.jtl.get(this.qrY);
                ag agVar = bVar.jQP;
                ag Xv = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Ff().Xv(agVar.field_username);
                if (com.tencent.mm.k.a.ga(Xv.field_type) || !com.tencent.mm.k.a.ga(agVar.field_type)) {
                    bVar.jQP = Xv;
                    obj = null;
                } else {
                    this.jtl.remove(this.qrY);
                    obj = 1;
                }
            }
            if (obj != null) {
                f.qsB++;
            }
            this.qrY = -1;
        }
        this.qrZ.clear();
        if (this.qrS != null) {
            this.qrS.UR.notifyChanged();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        int i = (this.qmk ? 4 : 0) | ((this.qml ? 2 : 0) | (this.qmj ? 1 : 0));
        com.tencent.mm.plugin.report.service.g.pWK.h(14434, Integer.valueOf(i), Integer.valueOf(f.qsB), Integer.valueOf(f.qsA), Integer.valueOf(f.qsF), Integer.valueOf(f.qsC), Integer.valueOf(f.qsE), Integer.valueOf(f.qsD));
        x.i("MicroMsg.UnfamiliarContactUI", "[%s:%s:%s:%s:%s:%s:%s]", Integer.valueOf(i), Integer.valueOf(f.qsB), Integer.valueOf(f.qsA), Integer.valueOf(f.qsF), Integer.valueOf(f.qsC), Integer.valueOf(f.qsE), Integer.valueOf(f.qsD));
        f.qsA = 0;
        f.qsB = 0;
        f.qsC = 0;
        f.qsD = 0;
        f.qsE = 0;
        f.qsF = 0;
        as.CN().b((int) JsApiCreateAudioInstance.CTRL_INDEX, (com.tencent.mm.ad.e) this);
        as.CN().b(681, this.qrX);
        com.tencent.mm.plugin.setting.a.a aVar = this.qsa;
        x.i("MicroMsg.UnfamiliarContactEngine", "[onDestroy] [%s:%s:%s]", Boolean.valueOf(aVar.qmk), Boolean.valueOf(aVar.qmj), Boolean.valueOf(aVar.qml));
        if (aVar.qmr != null) {
            as.CN().b((int) JsApiSetAudioState.CTRL_INDEX, aVar.qmr);
        }
        aVar.gSq.oFY.quit();
        com.tencent.mm.sdk.f.e.Q(aVar.mRunnable);
    }

    protected final void initView() {
        int i;
        int i2 = 0;
        super.initView();
        setMMTitle(R.l.eNZ);
        addTextOptionMenu(1, getString(R.l.eSa), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                UnfamiliarContactDetailUI.this.qsb = !UnfamiliarContactDetailUI.this.qsb;
                UnfamiliarContactDetailUI.this.qrW.clear();
                UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.this, UnfamiliarContactDetailUI.this.qsb);
                if (UnfamiliarContactDetailUI.this.qsb) {
                    UnfamiliarContactDetailUI.this.qrO.setEnabled(false);
                    UnfamiliarContactDetailUI.this.qrP.setEnabled(false);
                    UnfamiliarContactDetailUI.this.updateOptionMenuText(1, UnfamiliarContactDetailUI.this.getString(R.l.eRW));
                } else {
                    UnfamiliarContactDetailUI.this.updateOptionMenuText(1, UnfamiliarContactDetailUI.this.getString(R.l.eSa));
                }
                if (UnfamiliarContactDetailUI.this.qrS != null) {
                    UnfamiliarContactDetailUI.this.qrS.UR.notifyChanged();
                }
                return true;
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                UnfamiliarContactDetailUI.this.finish();
                return true;
            }
        });
        findViewById(R.h.cMx).setVisibility(this.qmj ? 0 : 8);
        View findViewById = findViewById(R.h.cMz);
        if (this.qml) {
            i = 0;
        } else {
            i = 8;
        }
        findViewById.setVisibility(i);
        View findViewById2 = findViewById(R.h.cMy);
        if (!this.qmk) {
            i2 = 8;
        }
        findViewById2.setVisibility(i2);
        this.qrM = (RecyclerView) findViewById(R.h.cTP);
        this.pzp = findViewById(R.h.bottom_bar);
        this.qrN = (TextView) findViewById(R.h.cvN);
        this.qrX = new d(this.qrW, new g() {
            public final void dw(int i, int i2) {
                f.qsA += i;
                UnfamiliarContactDetailUI.this.ec(false);
                UnfamiliarContactDetailUI.this.qrN.setText(UnfamiliarContactDetailUI.this.getString(R.l.eRZ) + "(" + UnfamiliarContactDetailUI.this.jtl.size() + ")");
                if (UnfamiliarContactDetailUI.this.qrS != null) {
                    UnfamiliarContactDetailUI.this.qrS.UR.notifyChanged();
                }
                if (i2 < i) {
                    x.w("MicroMsg.UnfamiliarContactUI", "[onDelSuccess] realDeleteCount:%s count:%s", Integer.valueOf(i2), Integer.valueOf(i));
                    com.tencent.mm.ui.base.h.b(UnfamiliarContactDetailUI.this.mController.xRr, UnfamiliarContactDetailUI.this.getString(R.l.eRX, new Object[]{Integer.valueOf(i - i2)}), "", true);
                }
            }

            public final void brT() {
                UnfamiliarContactDetailUI.this.ec(true);
            }
        });
        this.qrO = findViewById(R.h.cTM);
        this.qrO.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                com.tencent.mm.ui.base.h.a(UnfamiliarContactDetailUI.this.mController.xRr, true, UnfamiliarContactDetailUI.this.mController.xRr.getString(R.l.eSc), UnfamiliarContactDetailUI.this.mController.xRr.getString(R.l.bXt), UnfamiliarContactDetailUI.this.mController.xRr.getString(R.l.dEH), UnfamiliarContactDetailUI.this.mController.xRr.getString(R.l.dEy), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        if (UnfamiliarContactDetailUI.this.qrX != null) {
                            com.tencent.mm.kernel.g.Dr();
                            com.tencent.mm.kernel.g.Dp().gRu.a(681, UnfamiliarContactDetailUI.this.qrX);
                            Runnable h = UnfamiliarContactDetailUI.this.qrX;
                            h.index = 0;
                            h.ouE = 0;
                            h.qst = 0;
                            h.qsu.clear();
                            h.qsv.clear();
                            com.tencent.mm.sdk.f.e.remove(h);
                            if (h.qsr != null) {
                                h.qsr.brT();
                            }
                            com.tencent.mm.sdk.f.e.post(h, "delete_contact_task");
                        }
                        UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.this, false);
                    }
                }, null, R.e.brm, 0);
            }
        });
        this.qrP = findViewById(R.h.cTN);
        this.qrP.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                com.tencent.mm.ui.widget.g gVar = new com.tencent.mm.ui.widget.g(UnfamiliarContactDetailUI.this, com.tencent.mm.ui.widget.g.zCt, false);
                gVar.rQF = new com.tencent.mm.ui.base.p.c() {
                    public final void a(com.tencent.mm.ui.base.n nVar) {
                        nVar.a(0, UnfamiliarContactDetailUI.this.getString(R.l.eys), UnfamiliarContactDetailUI.this.getString(R.l.eKA), UnfamiliarContactDetailUI.this.getResources().getDrawable(R.k.dyb), false);
                        nVar.a(1, UnfamiliarContactDetailUI.this.getString(R.l.eyt), UnfamiliarContactDetailUI.this.getString(R.l.eKA), UnfamiliarContactDetailUI.this.getResources().getDrawable(R.k.dyc), false);
                    }
                };
                gVar.rQG = new com.tencent.mm.ui.base.p.d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        com.tencent.mm.kernel.g.Dr();
                        com.tencent.mm.kernel.g.Dp().gRu.b(681, UnfamiliarContactDetailUI.this.qrX);
                        UnfamiliarContactDetailUI.a(UnfamiliarContactDetailUI.this, UnfamiliarContactDetailUI.this.qrW, i);
                        UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.this, false);
                        if (UnfamiliarContactDetailUI.this.qrS != null) {
                            UnfamiliarContactDetailUI.this.qrS.UR.notifyChanged();
                        }
                    }
                };
                gVar.bUX();
            }
        });
        this.qrQ = findViewById(R.h.cTO);
        this.qrQ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                boolean z;
                CheckBox checkBox = (CheckBox) UnfamiliarContactDetailUI.this.qrQ.findViewById(R.h.checkbox);
                if (checkBox.isChecked()) {
                    z = false;
                } else {
                    z = true;
                }
                checkBox.setChecked(z);
                if (checkBox.isChecked()) {
                    for (int i = 0; i < UnfamiliarContactDetailUI.this.jtl.size(); i++) {
                        UnfamiliarContactDetailUI.this.qrW.add(Integer.valueOf(i));
                    }
                } else {
                    UnfamiliarContactDetailUI.this.qrW.clear();
                }
                if (UnfamiliarContactDetailUI.this.qrW.size() > 0) {
                    UnfamiliarContactDetailUI.this.qrP.setEnabled(true);
                    UnfamiliarContactDetailUI.this.qrO.setEnabled(true);
                } else {
                    UnfamiliarContactDetailUI.this.qrP.setEnabled(false);
                    UnfamiliarContactDetailUI.this.qrO.setEnabled(false);
                }
                UnfamiliarContactDetailUI.this.qrM.post(new Runnable() {
                    public final void run() {
                        UnfamiliarContactDetailUI.this.qrS.UR.notifyChanged();
                    }
                });
            }
        });
        this.qrR = (TextView) findViewById(R.h.cSc);
        this.qrM.a(new LinearLayoutManager());
        this.qrS = new a();
        this.qrM.a(this.qrS);
        this.qrT = (RealAlphabetScrollBar) findViewById(R.h.cTQ);
        this.qrT.yqj = new com.tencent.mm.ui.base.VerticalScrollBar.a() {
            public final void xN(String str) {
                UnfamiliarContactDetailUI unfamiliarContactDetailUI = UnfamiliarContactDetailUI.this;
                int intValue = (unfamiliarContactDetailUI.qrU == null || !unfamiliarContactDetailUI.qrU.containsKey(str)) ? -1 : ((Integer) unfamiliarContactDetailUI.qrU.get(str)).intValue();
                x.i("MicroMsg.UnfamiliarContactUI", "[onScollBarTouch] showHead:%s pos:%s", str, Integer.valueOf(intValue));
                if (intValue != -1) {
                    UnfamiliarContactDetailUI.this.qrM.be(intValue);
                }
            }
        };
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        onBackPressed();
        return true;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.UnfamiliarContactUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " " + kVar.getType());
        if (!(i == 0 && i2 == 0)) {
            Toast.makeText(this, getString(R.l.eSb), 1).show();
        }
        if (kVar.getType() == JsApiCreateAudioInstance.CTRL_INDEX) {
            ec(false);
            this.qrZ.clear();
            this.qrS.UR.notifyChanged();
        }
    }

    private void bJ(List<b> list) {
        this.qrU.clear();
        this.qrV.clear();
        int i = 0;
        String str = null;
        Iterator it = list.iterator();
        while (true) {
            int i2 = i;
            String str2 = str;
            if (it.hasNext()) {
                b bVar = (b) it.next();
                if (ljD.equalsIgnoreCase(bVar.qsi)) {
                    bVar.qsi = "#";
                }
                str = bVar.qsi;
                if (!str.equalsIgnoreCase(str2)) {
                    this.qrU.put(str.toUpperCase(), Integer.valueOf(i2));
                    this.qrV.put(Integer.valueOf(i2), str.toUpperCase());
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void ec(boolean z) {
        x.i("MicroMsg.UnfamiliarContactUI", "[setProgress] isVisible:%s", Boolean.valueOf(z));
        if (z) {
            this.jqf = r.b(this, getString(R.l.eRY), true, 0, null);
        } else if (this.jqf != null && this.jqf.isShowing()) {
            this.jqf.dismiss();
            this.jqf = null;
        }
    }
}
