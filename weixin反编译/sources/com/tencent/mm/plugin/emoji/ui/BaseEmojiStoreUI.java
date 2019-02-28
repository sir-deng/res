package com.tencent.mm.plugin.emoji.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.ct;
import com.tencent.mm.plugin.emoji.e.m;
import com.tencent.mm.plugin.emoji.f.g;
import com.tencent.mm.plugin.emoji.f.n;
import com.tencent.mm.plugin.emoji.f.q;
import com.tencent.mm.plugin.emoji.model.f;
import com.tencent.mm.plugin.emoji.model.h;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.pluginsdk.ui.emoji.StoreBannerEmojiView;
import com.tencent.mm.protocal.c.aci;
import com.tencent.mm.protocal.c.sm;
import com.tencent.mm.protocal.c.so;
import com.tencent.mm.protocal.c.sx;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.d;
import com.tencent.mm.y.as;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public abstract class BaseEmojiStoreUI extends EmojiBaseActivity implements OnScrollListener, OnItemClickListener, e, com.tencent.mm.plugin.emoji.model.h.a, com.tencent.mm.plugin.emoji.model.h.b, com.tencent.mm.pluginsdk.model.i.a, com.tencent.mm.sdk.e.j.a, c, d, MMPullDownView.e {
    private static Map<String, Long> lGy;
    protected ListView Fv;
    protected View klX;
    private com.tencent.mm.plugin.emoji.h.b lDE;
    com.tencent.mm.plugin.emoji.a.a.a lDw;
    protected g lGA;
    protected boolean lGB = false;
    private LinkedList<sm> lGC = new LinkedList();
    private LinkedList<so> lGD = new LinkedList();
    protected EmojiStoreVpHeader lGb;
    protected View lGc;
    protected StoreBannerEmojiView lGd;
    protected MMPullDownView lGe;
    protected TextView lGf;
    protected boolean lGg = false;
    int lGh = -1;
    private boolean lGi;
    private View lGj;
    byte[] lGk;
    private final int lGl = 65537;
    private final int lGm = CdnLogic.kMediaTypeBackupFile;
    private final int lGn = 2002;
    protected final int lGo = 131074;
    private final int lGp = 131075;
    private final int lGq = 131076;
    private final String lGr = "product_id";
    private final String lGs = "progress";
    private final String lGt = DownloadInfo.STATUS;
    private n lGu;
    private int lGv;
    private f lGw;
    private h lGx;
    private com.tencent.mm.sdk.b.c lGz;
    private ProgressDialog lzx;

    private class a extends com.tencent.mm.sdk.b.c<ct> {
        private a() {
            this.xmG = ct.class.getName().hashCode();
        }

        /* synthetic */ a(BaseEmojiStoreUI baseEmojiStoreUI, byte b) {
            this();
            this.xmG = ct.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            ct ctVar = (ct) bVar;
            BaseEmojiStoreUI.this.h(ctVar.frP.frQ, ctVar.frP.status, ctVar.frP.progress, ctVar.frP.frR);
            return false;
        }
    }

    private class b implements OnMenuItemClickListener {
        private b() {
        }

        /* synthetic */ b(BaseEmojiStoreUI baseEmojiStoreUI, byte b) {
            this();
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            BaseEmojiStoreUI.this.finish();
            return true;
        }
    }

    public abstract int aCO();

    public abstract int aCP();

    public abstract com.tencent.mm.plugin.emoji.a.a.a aCQ();

    public abstract int aCX();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lGx = new h();
        initView();
        this.lGv = getIntent().getIntExtra("preceding_scence", 2);
        if (i.aCl().lCx != null) {
            i.aCl().lCx.c(this);
        }
        this.lGz = new a();
        com.tencent.mm.sdk.b.a.xmy.b(this.lGz);
        this.lGx.kgx = this;
        this.lGx.lDw = this.lDw;
        this.lGx.lDz = aCO();
        this.lGx.lDC = this;
        boolean aDf = aDf();
        if (aDf) {
            aDf = aDc();
        }
        s(false, aDf);
        if (lGy == null) {
            lGy = new HashMap();
        }
        x.d("MicroMsg.emoji.BaseEmojiStoreUI", "refresh last net refresh time: %d", Long.valueOf(System.currentTimeMillis()));
        lGy.put(getClass().toString(), Long.valueOf(r0));
        this.lDE = new com.tencent.mm.plugin.emoji.h.b(1005);
    }

    protected void onResume() {
        super.onResume();
        as.CN().a(411, (e) this);
        as.CN().a(423, (e) this);
        as.CN().a(413, (e) this);
        as.CN().a(717, (e) this);
        if (aCU() && this.lGb != null) {
            this.lGb.aDP();
        }
        Boolean.valueOf(false);
        this.lGx.lDx = false;
        if (this.lDw != null && this.lDw.lAm != null) {
            this.lDw.lAm.aBr();
            this.lDw.amN();
        }
    }

    protected void onPause() {
        super.onPause();
        as.CN().b(411, (e) this);
        as.CN().b(423, (e) this);
        as.CN().b(413, (e) this);
        as.CN().b(717, (e) this);
        aDa();
        if (aCU() && this.lGb != null) {
            this.lGb.aDQ();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.lDw != null) {
            this.lDw.clear();
            this.lDw = null;
        }
        if (aCU() && this.lGb != null) {
            this.lGb.clear();
        }
        i.aCl().lCx.j(this);
        com.tencent.mm.sdk.b.a.xmy.c(this.lGz);
        as.CN().c(this.lGA);
        if (this.lGx != null) {
            h hVar = this.lGx;
            hVar.lDw = null;
            hVar.lDC = null;
            hVar.kgx = null;
        }
    }

    protected int getLayoutId() {
        return R.i.dfR;
    }

    public void a(int i, int i2, String str, k kVar) {
        int i3 = -1;
        String str2 = "MicroMsg.emoji.BaseEmojiStoreUI";
        String str3 = "jacks [onSceneEnd] errType:%d,errCode:%d,errMsg:%s";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        objArr[2] = str;
        x.i(str2, str3, objArr);
        aDe();
        switch (kVar.getType()) {
            case 411:
                n nVar = (n) kVar;
                if (nVar == null || nVar.mType != aCX()) {
                    str2 = "MicroMsg.emoji.BaseEmojiStoreUI";
                    str3 = "no some scene type. this ui type:%d callbak type:%d";
                    objArr = new Object[2];
                    objArr[0] = Integer.valueOf(aCX());
                    if (nVar != null) {
                        i3 = nVar.mType;
                    }
                    objArr[1] = Integer.valueOf(i3);
                    x.i(str2, str3, objArr);
                    return;
                }
                this.lGi = false;
                this.lGj.setVisibility(8);
                f fVar = null;
                try {
                    fVar = n.a(nVar.aCB());
                } catch (Exception e) {
                    x.k("MicroMsg.emoji.BaseEmojiStoreUI", "deal NetGetEmotionList error:%s", e.toString());
                }
                if (fVar != null) {
                    boolean z = i == 0 || i == 4;
                    if (z) {
                        this.klX.setVisibility(8);
                        this.lGg = false;
                        this.lGk = nVar.lEK;
                        aci aCB;
                        if (i2 == 0) {
                            aCB = nVar.aCB();
                            a(fVar, false, true);
                            b(aCB);
                            this.lGh = 0;
                            return;
                        } else if (i2 == 2) {
                            aCB = nVar.aCB();
                            a(this.lGh, fVar, false, false);
                            aCW();
                            b(aCB);
                            this.lGh = 2;
                            return;
                        } else if (i2 == 3) {
                            a(this.lGh, fVar, false, false);
                            this.lGh = 1;
                            return;
                        } else {
                            this.klX.setVisibility(0);
                            this.lGg = true;
                            if (aCX() == 7) {
                                this.lGf.setText(R.l.ebm);
                                return;
                            } else {
                                this.lGf.setText(R.l.eaK);
                                return;
                            }
                        }
                    }
                }
                if (!this.lGB) {
                    this.klX.setVisibility(0);
                    this.lGg = true;
                    this.lGf.setText(R.l.eaL);
                    return;
                }
                return;
            case 413:
                q qVar = (q) kVar;
                Message message;
                if (i == 0 && i2 == 0) {
                    i.aCl().lCx.Yx(qVar.lEs);
                    message = new Message();
                    message.what = 2002;
                    message.obj = this.mController.xRr.getString(R.l.dHc);
                    m(message);
                } else {
                    message = new Message();
                    message.what = 2002;
                    message.obj = this.mController.xRr.getString(R.l.dZZ);
                    m(message);
                }
                ct(CdnLogic.kMediaTypeBackupFile, 800);
                return;
            case 423:
                g gVar = (g) kVar;
                if (i == 0 && i2 == 0) {
                    a(gVar);
                    return;
                }
                str2 = gVar.lEs;
                str3 = gVar.lEu;
                final String str4 = gVar.lEt;
                com.tencent.mm.ui.base.h.a((Context) this, getString(R.l.eaG, new Object[]{str4}), "", new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        BaseEmojiStoreUI.this.K(str2, str3, str4);
                        BaseEmojiStoreUI.this.aDb();
                        x.i("MicroMsg.emoji.BaseEmojiStoreUI", "Retry doScene ExchangeEmotionPackNetScene productId:%s", str2);
                        BaseEmojiStoreUI.this.bf(str2, 0);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                be(gVar.lEs, -1);
                return;
            case 717:
                if (i == 0 && i2 == 0) {
                    this.lGk = null;
                    s(false, true);
                    return;
                }
                return;
            default:
                x.e("MicroMsg.emoji.BaseEmojiStoreUI", "unknow scene type");
                return;
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (aCU() || aCV()) {
            if (i != 0) {
                i--;
            } else {
                return;
            }
        }
        if (i >= 0 && i < this.lDw.getCount()) {
            com.tencent.mm.plugin.emoji.a.a.f oY = this.lDw.oY(i);
            if (oY == null) {
                x.i("MicroMsg.emoji.BaseEmojiStoreUI", "item is null.");
            } else if (oY.lAx == com.tencent.mm.plugin.emoji.a.a.f.a.lAG) {
                so soVar = oY.lAz;
                if (soVar == null) {
                    x.i("MicroMsg.emoji.BaseEmojiStoreUI", "banner set is null. do nothing");
                } else {
                    m.a(this.mController.xRr, soVar, false);
                }
            } else {
                sx sxVar = oY.lAy;
                if (sxVar == null) {
                    x.i("MicroMsg.emoji.BaseEmojiStoreUI", "summary is null. do nothing");
                    return;
                }
                m.a(this.mController.xRr, sxVar, aCO(), oY.mStatus, oY.sm, getIntent().getStringExtra("to_talker_name"), aCP());
            }
        }
    }

    protected void aCN() {
        this.lDw = aCQ();
        this.lDw.lAn = this;
    }

    protected void zj(String str) {
    }

    protected void aCR() {
    }

    protected void aCS() {
        if (aCT()) {
            this.lGe = (MMPullDownView) findViewById(R.h.ctt);
            if (this.lGe != null) {
                this.lGe.mw(false);
                this.lGe.ylh = this;
                this.lGe.ykV = this;
                this.lGe.ylg = this;
                this.lGe.mv(false);
                this.lGe.mu(false);
            }
        }
    }

    protected boolean aCT() {
        return true;
    }

    public void initView() {
        setBackBtn(new b());
        aCN();
        this.klX = findViewById(R.h.empty);
        this.lGf = (TextView) this.klX.findViewById(R.h.ceh);
        this.lGj = getLayoutInflater().inflate(R.i.dfQ, null);
        this.lGj.setVisibility(8);
        if (aCU()) {
            this.lGb = new EmojiStoreVpHeader(this.mController.xRr);
        }
        if (aCV()) {
            this.lGc = LayoutInflater.from(this).inflate(R.i.dgo, null);
            int i = EmojiStoreVpHeader.aT(this.mController.xRr)[0];
            this.lGc.setLayoutParams(new LayoutParams(i, ((i * 3) / 8) + 1));
            this.lGd = (StoreBannerEmojiView) this.lGc.findViewById(R.h.cdp);
        }
        this.Fv = (ListView) findViewById(16908298);
        this.Fv.setOnItemClickListener(this);
        if (aCU()) {
            this.Fv.addHeaderView(this.lGb);
        } else if (aCV()) {
            this.Fv.addHeaderView(this.lGc);
        }
        if (aDg()) {
            this.Fv.addFooterView(this.lGj);
        }
        aCR();
        this.Fv.setAdapter(this.lDw);
        this.Fv.setOnScrollListener(this);
        this.lDw.lAl = this.Fv;
        aCS();
    }

    protected final void s(boolean z, boolean z2) {
        n nVar;
        this.lGi = true;
        if (z) {
            this.lGj.setVisibility(0);
        }
        Object obj = this.lGk;
        int aCX = aCX();
        int aCZ = aCZ();
        int aCY = aCY();
        if (obj != null) {
            x.i("MicroMsg.emoji.BaseEmojiStoreUI", "[startLoadRemoteEmoji] request buffer %s", obj.toString());
            nVar = new n(aCX, obj, aCZ);
            if (aCX == 7) {
                nVar.lEM = aCY;
            }
        } else {
            x.i("MicroMsg.emoji.BaseEmojiStoreUI", "[startLoadRemoteEmoji] request buffer is null.");
            nVar = new n(aCX, aCZ);
            if (aCX == 7) {
                nVar.lEM = aCY;
            }
        }
        this.lGu = nVar;
        as.CN().a(this.lGu, 0);
        x.i("MicroMsg.emoji.BaseEmojiStoreUI", "[startLoadRemoteEmoji] doScene GetEmotionListNetScene");
        if (!z && !z2) {
            aDd();
        }
    }

    public final boolean azR() {
        s(true, false);
        x.i("MicroMsg.emoji.BaseEmojiStoreUI", "[onBottomLoadData] startLoadRemoteEmoji.");
        return true;
    }

    public final void k(Message message) {
        switch (message.what) {
            case 2002:
                String str = (String) message.obj;
                if (isFinishing()) {
                    x.i("MicroMsg.emoji.BaseEmojiStoreUI", "[updateLoadingDialog] acitivity is finished.");
                    return;
                } else if (this.lzx != null) {
                    this.lzx.setMessage(str);
                    return;
                } else {
                    return;
                }
            case CdnLogic.kMediaTypeBackupFile /*20001*/:
                aDe();
                return;
            case 65537:
                c((aci) message.obj);
                return;
            default:
                return;
        }
    }

    public void l(Message message) {
        String string;
        switch (message.what) {
            case 131074:
                if (this.lDw != null) {
                    this.lDw.notifyDataSetChanged();
                    aDh();
                    return;
                }
                return;
            case 131075:
                if (this.lDw != null && message.getData() != null) {
                    string = message.getData().getString("product_id");
                    if (string != null) {
                        this.lDw.bf(string, message.getData().getInt("progress"));
                        return;
                    }
                    return;
                }
                return;
            case 131076:
                if (this.lDw != null && message.getData() != null) {
                    string = message.getData().getString("product_id");
                    if (string != null) {
                        this.lDw.be(string, message.getData().getInt(DownloadInfo.STATUS));
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    protected boolean aCU() {
        return true;
    }

    protected boolean aCV() {
        return false;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i != 0 || absListView.getLastVisiblePosition() != absListView.getCount() - 1) {
            return;
        }
        if (this.lGh == 0 || this.lGi) {
            x.d("MicroMsg.emoji.BaseEmojiStoreUI", "No More List.");
            return;
        }
        s(true, false);
        x.i("MicroMsg.emoji.BaseEmojiStoreUI", "[onScrollStateChanged] startLoadRemoteEmoji.");
    }

    private void aCW() {
        com.tencent.mm.plugin.emoji.a.a.b.a(this.lDw.lAm, (com.tencent.mm.pluginsdk.model.i.a) this);
    }

    protected void a(g gVar) {
        bf(gVar.lEs, 0);
    }

    private void bf(String str, int i) {
        Message obtain = Message.obtain();
        obtain.getData().putString("product_id", str);
        obtain.getData().putInt("progress", i);
        obtain.what = 131075;
        m(obtain);
    }

    private void be(String str, int i) {
        Message obtain = Message.obtain();
        obtain.getData().putString("product_id", str);
        obtain.getData().putInt(DownloadInfo.STATUS, i);
        obtain.what = 131076;
        m(obtain);
    }

    protected final g K(String str, String str2, String str3) {
        this.lGA = new g(str, str2, str3);
        return this.lGA;
    }

    public int aCY() {
        return 0;
    }

    protected int aCZ() {
        if (this.lGv == 1) {
            return 1;
        }
        return 2;
    }

    protected final void aDa() {
        as.CN().c(this.lGu);
    }

    protected final void aDb() {
        as.CN().a(this.lGA, 0);
    }

    protected boolean aDc() {
        aci DT = i.aCl().lCz.DT(aCX());
        f a = n.a(DT);
        String str = "MicroMsg.emoji.BaseEmojiStoreUI";
        String str2 = "load cache type: %d, size: %d";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(aCX());
        objArr[1] = Integer.valueOf(DT == null ? 0 : DT.wrM);
        x.d(str, str2, objArr);
        if (a == null) {
            return false;
        }
        boolean z;
        if (a.lDn.size() <= 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            x.d("MicroMsg.emoji.BaseEmojiStoreUI", "jacks init EmoijStoreUI  by Cache: list:%d", Integer.valueOf(a.lDn.size()));
            a(a, true, false);
            return z;
        }
        x.d("MicroMsg.emoji.BaseEmojiStoreUI", "jacks init EmoijStoreUI  by NET");
        return z;
    }

    protected final void aDd() {
        if (isFinishing()) {
            x.i("MicroMsg.emoji.BaseEmojiStoreUI", "[showLoadingDialog] acitivity is finished.");
            return;
        }
        getString(R.l.dGZ);
        this.lzx = com.tencent.mm.ui.base.h.a((Context) this, getString(R.l.dHn), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                BaseEmojiStoreUI.this.aDa();
                as.CN().cancel(413);
            }
        });
    }

    protected final void aDe() {
        if (this.lzx != null && this.lzx.isShowing()) {
            this.lzx.dismiss();
        }
    }

    protected void a(f fVar, boolean z, boolean z2) {
        x.d("MicroMsg.emoji.BaseEmojiStoreUI", "jacks initData begin");
        if (fVar != null && fVar.lDn.size() > 0) {
            this.lGB = true;
            this.klX.setVisibility(8);
            this.lGg = false;
        }
        a(this.lGh, fVar, z, z2);
        aCW();
    }

    private void a(int i, f fVar, boolean z, boolean z2) {
        boolean z3 = false;
        x.d("MicroMsg.emoji.BaseEmojiStoreUI", "");
        switch (i) {
            case -1:
                this.lGw = fVar;
                break;
            case 1:
                this.lGw = fVar;
                break;
            case 2:
                if (this.lGw == null) {
                    this.lGw = new f();
                }
                if (fVar != null) {
                    this.lGw.pd(fVar.lDm);
                    this.lGw.aC(fVar.lDn);
                    break;
                }
                break;
            default:
                if (this.lGw != null) {
                    this.lGw.aCc();
                }
                a(z3, this.lGw, z, z2);
        }
        z3 = true;
        if (this.lGw != null) {
            this.lGw.aCc();
        }
        a(z3, this.lGw, z, z2);
    }

    protected void a(boolean z, f fVar, boolean z2, boolean z3) {
        if (this.lGw != null && z) {
            if (aCU()) {
                if (this.lGw == null || this.lGw.lDo == null || this.lGw.lDo.whj == null) {
                    x.d("MicroMsg.emoji.BaseEmojiStoreUI", "update store ui header failed. ");
                } else {
                    this.lGC = (LinkedList) this.lGw.lDp;
                    this.lGD = (LinkedList) this.lGw.lDq;
                    if (this.lGC != null) {
                        this.lGb.c(this.lGC, this.lGD);
                    } else if (this.lGw.lDo != null) {
                        this.lGC = new LinkedList();
                        this.lGC.add(this.lGw.lDo);
                        this.lGb.c(this.lGC, this.lGD);
                    }
                }
            }
            if (this.lDw != null) {
                this.lDw.b(this.lGw);
            }
        }
    }

    private void b(aci aci) {
        if (this.lGh == -1) {
            Message obtain = Message.obtain();
            obtain.what = 65537;
            obtain.obj = aci;
            if (this.lHg != null) {
                this.lHg.sendMessage(obtain);
            }
        }
    }

    protected void c(aci aci) {
        int i = 0;
        if (aci != null) {
            String str = "MicroMsg.emoji.BaseEmojiStoreUI";
            String str2 = "jacks save EmoijStoreUI Cache: list:%d, size: %d, type: %d";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(aci == null ? 0 : aci.wrM);
            if (!(aci == null || aci.vOw == null)) {
                i = aci.vOw.bkL();
            }
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Integer.valueOf(aCX());
            x.d(str, str2, objArr);
            i.aCl().lCz.a(aCX(), aci);
        }
    }

    public final boolean azS() {
        return false;
    }

    public final boolean azT() {
        return false;
    }

    public void a(String str, l lVar) {
        if (!TextUtils.isEmpty(str) && str.equals("delete_group")) {
            aDp();
            ct(131074, 50);
        }
    }

    public void h(String str, int i, int i2, String str2) {
        x.d("MicroMsg.emoji.BaseEmojiStoreUI", "[onExchange] productId:[%s] status:[%d] progress:[%d] cdnClientId:[%s]", str, Integer.valueOf(i), Integer.valueOf(i2), str2);
        if (this.lDw != null && this.lDw.lAm != null) {
            if (i == 6) {
                bf(str, i2);
            } else {
                x.i("MicroMsg.emoji.BaseEmojiStoreUI", "product status:%d", Integer.valueOf(i));
                be(str, i);
            }
            com.tencent.mm.plugin.emoji.a.a.f yA = this.lDw.lAm.yA(str);
            if (yA != null) {
                yA.lAB = str2;
            }
        }
    }

    public final void a(com.tencent.mm.plugin.emoji.a.a aVar) {
        String str = "MicroMsg.emoji.BaseEmojiStoreUI";
        String str2 = "[onProductClick] productId:%s, productPrice:%s, productStatus:%d";
        Object[] objArr = new Object[3];
        objArr[0] = aVar.aBa();
        objArr[1] = TextUtils.isEmpty(aVar.aBc()) ? "" : aVar.aBc();
        objArr[2] = Integer.valueOf(aVar.aBb());
        x.i(str, str2, objArr);
        if (aVar.aBb() == 9) {
            String string = getString(R.l.dHd);
            if (isFinishing()) {
                x.i("MicroMsg.emoji.BaseEmojiStoreUI", "[showLoadingDialog] acitivity is finished.");
            } else {
                getString(R.l.dGZ);
                this.lzx = com.tencent.mm.ui.base.h.a((Context) this, string, true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        as.CN().cancel(413);
                    }
                });
            }
        }
        this.lGx.a(aVar);
    }

    protected boolean aDf() {
        return false;
    }

    public final void u(ArrayList<com.tencent.mm.pluginsdk.model.q> arrayList) {
        x.d("MicroMsg.emoji.BaseEmojiStoreUI", "google [onQueryFinish]");
        if (this.lDw != null) {
            com.tencent.mm.plugin.emoji.a.a.b.a((ArrayList) arrayList, this.lDw.lAm);
            if (this.lHh != null) {
                this.lHh.removeMessages(131074);
                this.lHh.sendEmptyMessage(131074);
            }
        }
    }

    public final void J(String str, String str2, String str3) {
        K(str, str2, str3);
        aDb();
    }

    public final void aCd() {
        this.lGk = null;
        this.lGh = -1;
        s(false, false);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.d("MicroMsg.emoji.BaseEmojiStoreUI", "onActivityResult . requestCode:" + i + "  resultCode:" + i2);
        super.onActivityResult(i, i2, intent);
        this.lGx.onActivityResult(i, i2, intent);
    }

    protected boolean aDg() {
        return true;
    }

    public void aDh() {
    }
}
