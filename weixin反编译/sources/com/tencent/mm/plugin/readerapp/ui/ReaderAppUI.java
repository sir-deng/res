package com.tencent.mm.plugin.readerapp.ui;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.f.a.cg;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.readerapp.b.g;
import com.tencent.mm.pluginsdk.h.n;
import com.tencent.mm.pluginsdk.model.t;
import com.tencent.mm.pluginsdk.ui.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.tools.CustomFitTextView;
import com.tencent.mm.ui.widget.i;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bg;
import com.tencent.mm.y.bh;
import com.tencent.mm.y.c;
import com.tencent.mm.y.u;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

public class ReaderAppUI extends MMActivity implements com.tencent.mm.platformtools.j.a {
    private static float density;
    private int fFe = 0;
    private i kMf;
    private String oaf = "";
    private View onR;
    private ListView oti;
    private MMPullDownView otm;
    private d otp = new d() {
        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            int groupId = menuItem.getGroupId();
            bg bgVar;
            long longValue;
            switch (menuItem.getItemId()) {
                case 0:
                    if (ReaderAppUI.this.fFe == 20) {
                        List b = g.bmV().b(((Long) ReaderAppUI.this.pGC.getItem(groupId)).longValue(), ReaderAppUI.this.fFe);
                        if (b.size() > 0) {
                            bgVar = (bg) b.get(0);
                            com.tencent.mm.x.g.a aVar = new com.tencent.mm.x.g.a();
                            aVar.title = bgVar.getTitle();
                            aVar.description = bgVar.HS();
                            aVar.action = "view";
                            aVar.type = 5;
                            aVar.url = bgVar.getUrl();
                            String a = com.tencent.mm.x.g.a.a(aVar, null, null);
                            Intent intent = new Intent();
                            intent.putExtra("Retr_Msg_content", a);
                            intent.putExtra("Retr_Msg_Type", 2);
                            intent.putExtra("Retr_Msg_thumb_path", t.x(bgVar.HR(), bgVar.type, "@T"));
                            intent.putExtra("Retr_Msg_Id", 7377812);
                            a = u.hC(bgVar.hiW);
                            intent.putExtra("reportSessionId", a);
                            com.tencent.mm.y.u.b t = u.GQ().t(a, true);
                            t.o("prePublishId", "msg_" + bgVar.hiW);
                            t.o("preUsername", "newsapp");
                            t.o("preChatName", "newsapp");
                            t.o("preMsgIndex", Integer.valueOf(0));
                            t.o("sendAppMsgScene", Integer.valueOf(1));
                            com.tencent.mm.plugin.readerapp.a.a.ihN.l(intent, ReaderAppUI.this);
                            return;
                        }
                        return;
                    }
                    return;
                case 1:
                    if (ReaderAppUI.this.fFe == 20) {
                        List b2 = g.bmV().b(((Long) ReaderAppUI.this.pGC.getItem(groupId)).longValue(), ReaderAppUI.this.fFe);
                        if (!b2.isEmpty()) {
                            x.i("MicroMsg.ReaderAppUI", "fav time %d, index %d, size %d", Long.valueOf(longValue), Integer.valueOf(ReaderAppUI.this.pGF), Integer.valueOf(b2.size()));
                            if (ReaderAppUI.this.pGF >= b2.size()) {
                                ReaderAppUI.this.pGF = 0;
                            }
                            bgVar = (bg) b2.get(ReaderAppUI.this.pGF);
                            com.tencent.mm.sdk.b.b cgVar = new cg();
                            String hC = u.hC(bgVar.hiW);
                            com.tencent.mm.y.u.b t2 = u.GQ().t(hC, true);
                            t2.o("prePublishId", "msg_" + bgVar.hiW);
                            t2.o("preUsername", "newsapp");
                            t2.o("preChatName", "newsapp");
                            t2.o("preMsgIndex", Integer.valueOf(0));
                            t2.o("sendAppMsgScene", Integer.valueOf(1));
                            cgVar.frk.frp = hC;
                            com.tencent.mm.plugin.readerapp.b.b.a(cgVar, bgVar, ReaderAppUI.this.pGF);
                            cgVar.frk.frr = 7;
                            cgVar.frk.activity = ReaderAppUI.this;
                            com.tencent.mm.sdk.b.a.xmy.m(cgVar);
                            return;
                        }
                        return;
                    }
                    return;
                case 2:
                    longValue = ((Long) ReaderAppUI.this.pGC.getItem(groupId)).longValue();
                    if (longValue != 0) {
                        g.v(longValue, ReaderAppUI.this.fFe);
                        bh bmV = g.bmV();
                        int a2 = ReaderAppUI.this.fFe;
                        x.d("MicroMsg.ReaderAppInfoStorage", "deleteGroup:%s", "delete from " + bh.gX(a2) + " where time = " + longValue);
                        if (bmV.hiZ.fD(bh.gX(a2), "delete from " + bh.gX(a2) + " where time = " + longValue)) {
                            bmV.ha(a2);
                            bmV.doNotify();
                        }
                    }
                    ReaderAppUI.this.refresh();
                    return;
                default:
                    return;
            }
        }
    };
    private a<Long> pGC;
    private e pGD = null;
    private ag pGE = new ag();
    private int pGF = 0;

    class a extends a<Long> {
        private Context context;
        private int hLP;
        private int las;
        private ImageGetter pGK = new ImageGetter() {
            public final Drawable getDrawable(String str) {
                Drawable drawable = ReaderAppUI.this.getResources().getDrawable(bi.getInt(str, 0));
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                return drawable;
            }
        };
        private int pGL = 0;
        private int pGM = 0;
        private int pGN = 0;

        final class a {
            TextView jtn;
            ProgressBar mBp;
            View pGP;
            View pGQ;
            ImageView pGR;
            ImageView pGS;
            View pGT;

            a() {
            }
        }

        final class b {
            TextView jtn;
            ProgressBar mBp;
            TextView nub;
            TextView otc;
            View pGT;
            TextView pGU;
            ImageView pGV;
            View pGW;
            ViewGroup pGX;
            ViewGroup pGY;
            CustomFitTextView pGZ;
            LinearLayout pHa;
            List<a> pHb;

            b() {
            }
        }

        public final /* synthetic */ Object a(Object obj, Cursor cursor) {
            return Long.valueOf(cursor.getLong(0));
        }

        public final /* synthetic */ Object getItem(int i) {
            return vB(i);
        }

        public a(Context context, Long l) {
            super(context, l);
            this.context = context;
            this.las = 3;
            this.hLP = g.bmV().gY(ReaderAppUI.this.fFe);
            this.pGM = context.getResources().getDimensionPixelSize(R.f.bvT);
            this.pGN = context.getResources().getDimensionPixelSize(R.f.buN);
            this.pGL = context.getResources().getDimensionPixelSize(R.f.bup);
        }

        protected final void XI() {
            XH();
        }

        public final boolean awL() {
            return this.las >= this.hLP;
        }

        public final int bmW() {
            return this.las;
        }

        public final int awM() {
            if (awL()) {
                return 0;
            }
            this.las += 3;
            if (this.las <= this.hLP) {
                return 3;
            }
            this.las = this.hLP;
            return this.hLP % 3;
        }

        public final void XH() {
            this.hLP = g.bmV().gY(20);
            setCursor(g.bmV().aY(this.las, 20));
            super.notifyDataSetChanged();
        }

        private Long vB(int i) {
            return (Long) super.getItem(i);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            a aVar;
            int i2;
            x.w("MicroMsg.ReaderAppUI", "ashutest get view position %d", Integer.valueOf(i));
            if (view == null) {
                bVar = new b();
                view = View.inflate(this.context, R.i.dqm, null);
                bVar.nub = (TextView) view.findViewById(R.h.cFE);
                bVar.pGY = (ViewGroup) view.findViewById(R.h.cFA);
                bVar.jtn = (TextView) view.findViewById(R.h.cFF);
                bVar.pGU = (TextView) view.findViewById(R.h.cFC);
                bVar.pGV = (ImageView) view.findViewById(R.h.cFD);
                bVar.otc = (TextView) view.findViewById(R.h.cFB);
                bVar.pGW = view.findViewById(R.h.cSG);
                bVar.pGX = (ViewGroup) view.findViewById(R.h.cSx);
                bVar.pGZ = (CustomFitTextView) view.findViewById(R.h.cSA);
                bVar.pHa = (LinearLayout) view.findViewById(R.h.cbm);
                bVar.mBp = (ProgressBar) view.findViewById(R.h.crI);
                bVar.pGT = view.findViewById(R.h.ccF);
                bVar.pHb = new ArrayList();
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            for (a aVar2 : bVar.pHb) {
                bVar.pGY.removeView(aVar2.pGP);
            }
            bVar.pHb.clear();
            List b = g.bmV().b(vB(i).longValue(), 20);
            if (b.size() > 0) {
                int size = b.size();
                bg bgVar = (bg) b.get(0);
                bVar.jtn.setText(bgVar.getTitle());
                bVar.otc.setText(bgVar.HS());
                bVar.nub.setText(n.c(this.context, bgVar.time, false));
                bVar.pGU.setText(n.ak(this.context.getString(R.l.eiJ), bgVar.hiR));
                if (ReaderAppUI.this.pGD != null) {
                    bVar.nub.setTextColor(ReaderAppUI.this.pGD.vqb);
                    if (ReaderAppUI.this.pGD.vqc) {
                        bVar.nub.setShadowLayer(2.0f, 1.2f, 1.2f, ReaderAppUI.this.pGD.vqd);
                    } else {
                        bVar.nub.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                    }
                    if (ReaderAppUI.this.pGD.vqe) {
                        bVar.nub.setBackgroundResource(R.g.bAP);
                        bVar.nub.setPadding(this.pGM, this.pGL, this.pGM, this.pGL);
                    } else {
                        bVar.nub.setBackgroundColor(0);
                    }
                }
                boolean z = true;
                bVar.mBp.setVisibility(8);
                bVar.pGT.setVisibility(8);
                if (bgVar.HM()) {
                    bVar.pGZ.b(bgVar.getTitle(), 4, true, R.g.bFd);
                } else {
                    bVar.pGZ.b(bgVar.getTitle(), 4, false, -1);
                }
                if (bi.oN(bgVar.HR())) {
                    bVar.pGV.setVisibility(8);
                    z = false;
                } else {
                    bVar.pGV.setVisibility(0);
                    bVar.pGV.setImageBitmap(j.a(new t(bgVar.HR(), bgVar.type, "@T", this.mgx)));
                }
                bVar.pGW.setOnClickListener(ReaderAppUI.this.a(bgVar, ReaderAppUI.this.fFe, 0));
                if (size > 1) {
                    a(bVar, false, z);
                    for (i2 = 1; i2 < size - 1; i2++) {
                        a(bVar, b, R.i.dqt, i2);
                    }
                    a(bVar, b, R.i.dqs, size - 1);
                } else {
                    a(bVar, true, !z);
                }
            }
            bVar.pGW.setTag(Integer.valueOf(i));
            bVar.pGW.setTag(R.h.cFQ, Integer.valueOf(0));
            ReaderAppUI.this.kMf.c(bVar.pGW, new OnCreateContextMenuListener(b.size() == 1) {
                public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    contextMenu.clear();
                    if (ReaderAppUI.this.fFe == 20) {
                        contextMenu.setHeaderTitle(R.l.eoV);
                    } else {
                        contextMenu.setHeaderTitle(R.l.eoY);
                    }
                    if (20 == ReaderAppUI.this.fFe) {
                        if (r2) {
                            contextMenu.add(intValue, 0, 1, R.l.eCh);
                        }
                        if (com.tencent.mm.bl.d.Pu("favorite")) {
                            contextMenu.add(intValue, 1, 2, R.l.eAq);
                        }
                        ReaderAppUI.this.pGF = ((Integer) view.getTag(R.h.cFQ)).intValue();
                    }
                    contextMenu.add(intValue, 2, 3, R.l.eCg);
                }
            }, ReaderAppUI.this.otp);
            i2 = 1;
            Iterator it = bVar.pHb.iterator();
            while (true) {
                int i3 = i2;
                if (!it.hasNext()) {
                    return view;
                }
                aVar2 = (a) it.next();
                aVar2.pGP.setTag(Integer.valueOf(i));
                ReaderAppUI.this.kMf.c(aVar2.pGP, /* anonymous class already generated */, ReaderAppUI.this.otp);
                i2 = i3 + 1;
                aVar2.pGP.setTag(R.h.cFQ, Integer.valueOf(i3));
            }
        }

        private void a(b bVar, List<bg> list, int i, int i2) {
            a aVar = new a();
            aVar.pGP = View.inflate(this.context, i, null);
            aVar.jtn = (TextView) aVar.pGP.findViewById(R.h.title);
            aVar.pGR = (ImageView) aVar.pGP.findViewById(R.h.bZn);
            aVar.pGS = (ImageView) aVar.pGP.findViewById(R.h.cUE);
            aVar.pGQ = aVar.pGP.findViewById(R.h.bZo);
            aVar.mBp = (ProgressBar) aVar.pGP.findViewById(R.h.ctG);
            aVar.pGT = aVar.pGP.findViewById(R.h.ctw);
            if (bVar != null) {
                bVar.pGY.addView(aVar.pGP);
                bVar.pHb.add(aVar);
            }
            bg bgVar = (bg) list.get(i2);
            aVar.jtn.setText(bgVar.getTitle());
            aVar.mBp.setVisibility(8);
            aVar.pGT.setVisibility(8);
            if (bgVar.HM()) {
                aVar.jtn.setText(Html.fromHtml(bgVar.getTitle() + "<img src='" + R.g.bFe + "'/>", this.pGK, null));
            } else {
                aVar.jtn.setText(bgVar.getTitle());
            }
            if (bi.oN(bgVar.HR())) {
                aVar.pGQ.setVisibility(8);
                aVar.pGS.setVisibility(8);
            } else {
                aVar.pGR.setVisibility(0);
                aVar.pGR.setImageBitmap(j.a(new t(bgVar.HR(), bgVar.type, "@S", this.mgx)));
            }
            aVar.pGP.setOnClickListener(ReaderAppUI.this.a(bgVar, ReaderAppUI.this.fFe, i2));
        }

        private void a(b bVar, boolean z, boolean z2) {
            int i;
            int i2 = 0;
            bVar.pHa.setVisibility(z ? 0 : 8);
            if (z) {
                bVar.pGW.setBackgroundResource(R.g.bBn);
                bVar.pGW.setPadding(this.pGN, this.pGN, this.pGN, this.pGN);
            } else {
                bVar.pGW.setBackgroundResource(R.g.bBm);
                bVar.pGW.setPadding(this.pGN, this.pGN, this.pGN, this.pGM);
            }
            TextView textView = bVar.jtn;
            if (z || !(z || z2)) {
                i = 0;
            } else {
                i = 8;
            }
            textView.setVisibility(i);
            textView = bVar.pGU;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            textView.setVisibility(i);
            textView = bVar.otc;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            textView.setVisibility(i);
            ViewGroup viewGroup = bVar.pGX;
            if (z || !z2) {
                i2 = 8;
            }
            viewGroup.setVisibility(i2);
        }
    }

    class b extends a<Long> {
        private Context context;
        private int hLP = this.las;
        private int las = 3;
        private int pGL;
        private int pGM;

        class a {
            TextView nub;
            ReaderItemListView pHc;

            a() {
            }
        }

        public final /* synthetic */ Object a(Object obj, Cursor cursor) {
            return Long.valueOf(cursor.getLong(0));
        }

        public b(Context context, Long l) {
            super(context, l);
            this.context = context;
            this.pGL = context.getResources().getDimensionPixelSize(R.f.bup);
            this.pGM = context.getResources().getDimensionPixelSize(R.f.bvT);
        }

        protected final void XI() {
            XH();
        }

        public final boolean awL() {
            return this.las >= this.hLP;
        }

        public final int bmW() {
            return this.las;
        }

        public final int awM() {
            if (awL()) {
                return 0;
            }
            this.las += 3;
            if (this.las <= this.hLP) {
                return 3;
            }
            this.las = this.hLP;
            return this.hLP % 3;
        }

        public final void XH() {
            this.hLP = g.bmV().gY(ReaderAppUI.this.fFe);
            setCursor(g.bmV().aY(this.las, ReaderAppUI.this.fFe));
            super.notifyDataSetChanged();
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                aVar = new a();
                view = View.inflate(this.context, R.i.dqn, null);
                aVar.pHc = (ReaderItemListView) view.findViewById(R.h.cFS);
                aVar.nub = (TextView) view.findViewById(R.h.cFE);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            aVar.nub.setText(n.c(this.context, ((Long) getItem(i)).longValue(), false));
            ReaderItemListView readerItemListView = aVar.pHc;
            long longValue = ((Long) getItem(i)).longValue();
            OnCreateContextMenuListener a = /* anonymous class already generated */;
            d g = ReaderAppUI.this.otp;
            readerItemListView.position = i;
            readerItemListView.pHg = a;
            readerItemListView.otp = g;
            readerItemListView.pHe = g.bmV().b(longValue, readerItemListView.type);
            readerItemListView.pHf.notifyDataSetChanged();
            if (ReaderAppUI.this.pGD != null) {
                aVar.nub.setTextColor(ReaderAppUI.this.pGD.vqb);
                if (ReaderAppUI.this.pGD.vqc) {
                    aVar.nub.setShadowLayer(2.0f, 1.2f, 1.2f, ReaderAppUI.this.pGD.vqd);
                } else {
                    aVar.nub.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                }
                if (ReaderAppUI.this.pGD.vqe) {
                    aVar.nub.setBackgroundResource(R.g.bAP);
                    aVar.nub.setPadding(this.pGM, this.pGL, this.pGM, this.pGL);
                } else {
                    aVar.nub.setBackgroundColor(0);
                }
            }
            return view;
        }
    }

    static /* synthetic */ String a(ReaderAppUI readerAppUI, String str) {
        int i = 1;
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.ReaderAppUI", "appendArgs fail, srcUrl is null");
            return "";
        }
        int i2;
        List linkedList;
        String format;
        PackageInfo IH = readerAppUI.IH("com.tencent.news");
        if (IH == null) {
            x.i("MicroMsg.ReaderAppUI", "isNewsInstallAndSupport false, pkgInfo is null");
        } else if (IH.versionCode >= 220) {
            i2 = 1;
            if (i2 == 0) {
                i = 0;
            }
            x.i("MicroMsg.ReaderAppUI", "appendArgsForNews, isNewsInstallAndSupport = " + i);
            linkedList = new LinkedList();
            linkedList.add(new BasicNameValuePair("isappinstalled", String.valueOf(i)));
            format = URLEncodedUtils.format(linkedList, ProtocolPackage.ServerEncoding);
            return str.contains("?") ? str + "&" + format : str + "?" + format;
        }
        i2 = 0;
        if (i2 == 0) {
            i = 0;
        }
        x.i("MicroMsg.ReaderAppUI", "appendArgsForNews, isNewsInstallAndSupport = " + i);
        linkedList = new LinkedList();
        linkedList.add(new BasicNameValuePair("isappinstalled", String.valueOf(i)));
        format = URLEncodedUtils.format(linkedList, ProtocolPackage.ServerEncoding);
        if (str.contains("?")) {
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fFe = getIntent().getIntExtra(Columns.TYPE, 0);
        density = com.tencent.mm.bu.a.getDensity(this);
        initView();
        this.oaf = bg.gW(this.fFe);
    }

    public void onDestroy() {
        if (this.pGC != null) {
            this.pGC.aUU();
            this.pGC.xQN = null;
        }
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.dqh;
    }

    protected void onResume() {
        super.onResume();
        j.b((com.tencent.mm.platformtools.j.a) this);
        if (this.fFe == 20) {
            setMMTitle(R.l.eoV);
        } else {
            setMMTitle(R.l.eoY);
        }
        as.getNotification().eq(this.oaf);
        as.getNotification().cancelNotification(this.oaf);
        as.Hm();
        c.Fk().XH(this.oaf);
        g.bmV().c(this.pGC);
        this.pGC.a(null, null);
        refresh();
    }

    protected void onPause() {
        super.onPause();
        as.getNotification().eq("");
        g.bmV().j(this.pGC);
        j.c((com.tencent.mm.platformtools.j.a) this);
        as.Hm();
        c.Fk().XH(this.oaf);
    }

    public final void refresh() {
        TextView textView = (TextView) findViewById(R.h.ceo);
        textView.setText(this.fFe == 20 ? R.l.bFf : R.l.eCn);
        if (this.pGC.getCount() == 0) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
    }

    protected final void initView() {
        try {
            this.pGD = new e(bi.convertStreamToString(getAssets().open("chatting/default_chat.xml")));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ReaderAppUI", e, "", new Object[0]);
        }
        this.oti = (ListView) findViewById(R.h.cFO);
        this.otm = (MMPullDownView) findViewById(R.h.cFR);
        this.onR = getLayoutInflater().inflate(R.i.dqk, null);
        this.oti.addHeaderView(this.onR);
        ((TextView) findViewById(R.h.ceo)).setText(R.l.eCc);
        if (this.fFe == 20) {
            this.pGC = new a(this, Long.valueOf(0));
        } else if (this.fFe == 11) {
            this.pGC = new b(this, Long.valueOf(0));
        }
        this.oti.setOnScrollListener(this.pGC);
        this.oti.setAdapter(this.pGC);
        this.oti.setTranscriptMode(0);
        registerForContextMenu(this.oti);
        this.kMf = new i(this);
        if (this.pGC.getCount() == 0) {
            Intent intent = new Intent(this, ReaderAppIntroUI.class);
            intent.putExtra(Columns.TYPE, this.fFe);
            startActivity(intent);
            finish();
            return;
        }
        this.otm.ykU = new MMPullDownView.g() {
            public final boolean azU() {
                if (ReaderAppUI.this.pGC.awL()) {
                    ReaderAppUI.this.oti.setSelectionFromTop(0, ReaderAppUI.this.otm.ykW);
                } else {
                    int awM = ReaderAppUI.this.pGC.awM();
                    x.v("MicroMsg.ReaderAppUI", "onLoadData add count:" + awM);
                    ReaderAppUI.this.pGC.a(null, null);
                    ReaderAppUI.this.oti.setSelectionFromTop(awM, ReaderAppUI.this.otm.ykW);
                }
                return true;
            }
        };
        this.otm.mw(true);
        this.otm.ylg = new MMPullDownView.c() {
            public final boolean azT() {
                View childAt = ReaderAppUI.this.oti.getChildAt(ReaderAppUI.this.oti.getChildCount() - 1);
                if (childAt != null && childAt.getBottom() <= ReaderAppUI.this.oti.getHeight() && ReaderAppUI.this.oti.getLastVisiblePosition() == ReaderAppUI.this.oti.getAdapter().getCount() - 1) {
                    return true;
                }
                return false;
            }
        };
        this.otm.ylh = new MMPullDownView.d() {
            public final boolean azS() {
                View childAt = ReaderAppUI.this.oti.getChildAt(ReaderAppUI.this.oti.getFirstVisiblePosition());
                if (childAt == null || childAt.getTop() != 0) {
                    return false;
                }
                return true;
            }
        };
        this.otm.mu(true);
        this.pGC.xQN = new com.tencent.mm.ui.o.a() {
            public final void XE() {
                ReaderAppUI.this.otm.mt(ReaderAppUI.this.pGC.awL());
            }

            public final void XF() {
            }
        };
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ReaderAppUI.this.finish();
                return true;
            }
        });
        addIconOptionMenu(0, R.l.dCu, R.k.dvn, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                com.tencent.mm.plugin.readerapp.a.a.ihN.d(new Intent().putExtra("Contact_User", ReaderAppUI.this.oaf), ReaderAppUI.this);
                return true;
            }
        });
        this.oti.setSelection((this.pGC.bmW() - 1) + this.oti.getHeaderViewsCount());
    }

    public final OnClickListener a(final bg bgVar, final int i, final int i2) {
        return new OnClickListener() {
            public final void onClick(View view) {
                if (20 == i) {
                    Intent intent = new Intent();
                    intent.putExtra("mode", 1);
                    String url = bgVar.getUrl();
                    intent.putExtra("news_svr_id", bgVar.hiW);
                    intent.putExtra("news_svr_tweetid", bgVar.HN());
                    intent.putExtra("rawUrl", ReaderAppUI.a(ReaderAppUI.this, url));
                    intent.putExtra("title", bgVar.getName());
                    intent.putExtra("webpageTitle", bgVar.getTitle());
                    intent.putExtra("useJs", true);
                    intent.putExtra("vertical_scroll", true);
                    Bundle bundle = new Bundle();
                    bundle.putInt("snsWebSource", 3);
                    intent.putExtra("jsapiargs", bundle);
                    intent.putExtra("shortUrl", bgVar.HO());
                    intent.putExtra(Columns.TYPE, bgVar.type);
                    intent.putExtra("tweetid", bgVar.HN());
                    intent.putExtra("geta8key_username", "newsapp");
                    intent.putExtra("KPublisherId", "msg_" + Long.toString(bgVar.hiW));
                    intent.putExtra("pre_username", "newsapp");
                    intent.putExtra("prePublishId", "msg_" + Long.toString(bgVar.hiW));
                    intent.putExtra("preUsername", "newsapp");
                    intent.putExtra("preChatName", "newsapp");
                    intent.putExtra("preMsgIndex", i2);
                    com.tencent.mm.plugin.readerapp.a.a.ihN.j(intent, ReaderAppUI.this);
                }
            }
        };
    }

    public final void l(String str, Bitmap bitmap) {
        x.d("MicroMsg.ReaderAppUI", "onUpdate");
        if (this == null || isFinishing() || bitmap == null) {
            x.d("MicroMsg.ReaderAppUI", "readerappui is finish");
        } else {
            this.pGE.post(new Runnable() {
                public final void run() {
                    if (ReaderAppUI.this.pGC != null) {
                        ReaderAppUI.this.pGC.notifyDataSetChanged();
                    }
                }
            });
        }
    }

    private PackageInfo IH(String str) {
        PackageInfo packageInfo = null;
        if (str.length() == 0) {
            return packageInfo;
        }
        try {
            return this.mController.xRr.getPackageManager().getPackageInfo(str, 0);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ReaderAppUI", e, "", new Object[0]);
            return packageInfo;
        }
    }
}
