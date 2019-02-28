package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.ct;
import com.tencent.mm.plugin.emoji.e.m;
import com.tencent.mm.plugin.emoji.f.g;
import com.tencent.mm.plugin.emoji.f.n;
import com.tencent.mm.plugin.emoji.model.f;
import com.tencent.mm.plugin.emoji.model.h;
import com.tencent.mm.plugin.emoji.model.h.b;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.ui.EmojiMineUI;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreVpHeader;
import com.tencent.mm.pluginsdk.model.q;
import com.tencent.mm.protocal.c.aci;
import com.tencent.mm.protocal.c.sm;
import com.tencent.mm.protocal.c.so;
import com.tencent.mm.protocal.c.sx;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.d;
import com.tencent.mm.ui.u;
import com.tencent.mm.ui.v;
import com.tencent.mm.y.as;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.util.ArrayList;
import java.util.LinkedList;

public abstract class a extends u implements OnScrollListener, OnItemClickListener, e, com.tencent.mm.plugin.emoji.a.h.a, com.tencent.mm.plugin.emoji.model.h.a, b, com.tencent.mm.pluginsdk.model.i.a, com.tencent.mm.sdk.e.j.a, c, d, MMPullDownView.e {
    ListView Fv;
    private View klX;
    com.tencent.mm.plugin.emoji.a.a.a lDw;
    private g lGA;
    private boolean lGB = false;
    private LinkedList<sm> lGC = new LinkedList();
    private LinkedList<so> lGD = new LinkedList();
    EmojiStoreVpHeader lGb;
    private MMPullDownView lGe;
    private TextView lGf;
    private int lGh = -1;
    private boolean lGi;
    private View lGj;
    private byte[] lGk;
    private final int lGo = 131074;
    private final int lGp = 131075;
    private final int lGq = 131076;
    private final String lGr = "product_id";
    private final String lGs = "progress";
    private final String lGt = DownloadInfo.STATUS;
    private n lGu;
    private int lGv;
    private f lGw;
    private h lGx;
    private com.tencent.mm.sdk.b.c lGz = new com.tencent.mm.sdk.b.c<ct>() {
        {
            this.xmG = ct.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            ct ctVar = (ct) bVar;
            if (ctVar != null) {
                a aVar = a.this;
                String str = ctVar.frP.frQ;
                int i = ctVar.frP.status;
                int i2 = ctVar.frP.progress;
                x.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[onExchange] productId:[%s] status:[%d] progress:[%d] cdnClientId:[%s]", str, Integer.valueOf(i), Integer.valueOf(i2), ctVar.frP.frR);
                if (!(aVar.lDw == null || aVar.lDw.lAm == null)) {
                    if (i == 6) {
                        Message obtain = Message.obtain();
                        obtain.getData().putString("product_id", str);
                        obtain.getData().putInt("progress", i2);
                        obtain.what = 131075;
                        aVar.m(obtain);
                    } else {
                        x.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "product status:%d", Integer.valueOf(i));
                        Message obtain2 = Message.obtain();
                        obtain2.getData().putString("product_id", str);
                        obtain2.getData().putInt(DownloadInfo.STATUS, i);
                        obtain2.what = 131076;
                        aVar.m(obtain2);
                    }
                    com.tencent.mm.plugin.emoji.a.a.f yA = aVar.lDw.lAm.yA(str);
                    if (yA != null) {
                        yA.lAB = r4;
                    }
                }
            }
            return false;
        }
    };
    private final int lKQ = 131077;
    public EmojiStoreV2HotBarView lKR;
    private boolean lKS = false;
    private boolean lKT = false;
    private boolean lKU = false;
    private ag lKV = new ag() {
        public final void handleMessage(Message message) {
            a aVar = a.this;
            String string;
            switch (message.what) {
                case 131074:
                    if (aVar.lDw != null) {
                        aVar.lDw.notifyDataSetChanged();
                        return;
                    }
                    return;
                case 131075:
                    if (aVar.lDw != null && message.getData() != null) {
                        string = message.getData().getString("product_id");
                        if (string != null) {
                            aVar.lDw.bf(string, message.getData().getInt("progress"));
                            return;
                        }
                        return;
                    }
                    return;
                case 131076:
                    if (aVar.lDw != null && message.getData() != null) {
                        string = message.getData().getString("product_id");
                        if (string != null) {
                            aVar.lDw.be(string, message.getData().getInt(DownloadInfo.STATUS));
                            return;
                        }
                        return;
                    }
                    return;
                case 131077:
                    if (aVar.lGb != null) {
                        aVar.lGb.aDP();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private OnMenuItemClickListener lKW = new OnMenuItemClickListener() {
        public final boolean onMenuItemClick(MenuItem menuItem) {
            a.this.thisActivity().finish();
            return false;
        }
    };
    private ProgressDialog lzx;
    private ActionBar mActionBar;
    private com.tencent.mm.ui.b mActionBarHelper;

    public abstract com.tencent.mm.plugin.emoji.a.a.a aCQ();

    public abstract int aCX();

    public abstract boolean aDX();

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        x.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onAttach");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRequestedOrientation(1);
        this.mActionBar = ((ActionBarActivity) thisActivity()).getSupportActionBar();
        View inflate = v.fw(getContext()).inflate(R.i.dac, null);
        this.mActionBarHelper = new com.tencent.mm.ui.b(inflate);
        this.mActionBar.setLogo(new ColorDrawable(getResources().getColor(17170445)));
        this.mActionBar.cP();
        this.mActionBar.setDisplayHomeAsUpEnabled(false);
        this.mActionBar.cO();
        this.mActionBar.cQ();
        this.mActionBar.setCustomView(inflate);
        this.mActionBar.show();
        com.tencent.mm.ui.b bVar = this.mActionBarHelper;
        bVar.ikL.setText(R.l.eaw);
        if (com.tencent.mm.bu.a.ez(bVar.ikL.getContext())) {
            bVar.ikL.setTextSize(0, com.tencent.mm.bu.a.ex(bVar.ikL.getContext()) * ((float) com.tencent.mm.bu.a.ab(bVar.ikL.getContext(), com.tencent.mm.v.a.e.bun)));
        }
        this.mActionBarHelper.o(new OnClickListener() {
            public final void onClick(View view) {
                if (a.this.isScreenEnable() && a.this.lKW != null) {
                    a.this.lKW.onMenuItemClick(null);
                }
            }
        });
        showOptionMenu(true);
        addIconOptionMenu(0, R.k.dvn, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent();
                intent.setClass(a.this.thisActivity(), EmojiMineUI.class);
                a.this.startActivity(intent);
                return false;
            }
        });
        com.tencent.mm.sdk.b.a.xmy.b(this.lGz);
        i.aCl().lCx.c(this);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        x.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onCreateView");
        return layoutInflater.inflate(getLayoutId(), viewGroup, false);
    }

    public void onActivityCreated(Bundle bundle) {
        x.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onActivityCreated");
        super.onActivityCreated(bundle);
        this.lKU = true;
        this.lDw = aCQ();
        this.lDw.lAn = this;
        this.klX = findViewById(R.h.empty);
        this.lGf = (TextView) this.klX.findViewById(R.h.ceh);
        this.lGj = getLayoutInflater().inflate(R.i.dfQ, null);
        this.lGj.setVisibility(8);
        this.lGb = new EmojiStoreVpHeader(getContext());
        this.Fv = (ListView) findViewById(16908298);
        this.Fv.addHeaderView(this.lGb);
        if (!aDX()) {
            this.lKR = new EmojiStoreV2HotBarView(getContext());
            EmojiStoreV2HotBarView emojiStoreV2HotBarView = this.lKR;
            if (emojiStoreV2HotBarView.lLK != null) {
                emojiStoreV2HotBarView.lLK.setVisibility(8);
            }
            emojiStoreV2HotBarView = this.lKR;
            if (emojiStoreV2HotBarView.lLI != null) {
                int aa = com.tencent.mm.bu.a.aa(emojiStoreV2HotBarView.getContext(), R.f.bvz);
                int aa2 = com.tencent.mm.bu.a.aa(emojiStoreV2HotBarView.getContext(), R.f.bvC);
                int aa3 = com.tencent.mm.bu.a.aa(emojiStoreV2HotBarView.getContext(), R.f.bvK);
                emojiStoreV2HotBarView.lLI.setPadding(aa3, aa, aa3, aa2);
            }
            this.Fv.addHeaderView(this.lKR);
        }
        this.Fv.addFooterView(this.lGj);
        this.Fv.setAdapter(this.lDw);
        if (aDX()) {
            this.Fv.setOnItemClickListener(this);
        } else {
            ((com.tencent.mm.plugin.emoji.a.h) this.lDw).lzW = this;
        }
        this.Fv.setOnScrollListener(this);
        this.Fv.setLongClickable(false);
        this.Fv.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return false;
            }
        });
        this.lDw.lAl = this.Fv;
        this.lGe = (MMPullDownView) findViewById(R.h.ctt);
        if (this.lGe != null) {
            this.lGe.mw(false);
            this.lGe.ylh = this;
            this.lGe.ykV = this;
            this.lGe.ylg = this;
            this.lGe.mv(false);
            this.lGe.mu(false);
            this.lGe.ylq = true;
        }
        if (this.lKS) {
            aDU();
        }
    }

    public void onStart() {
        super.onStart();
        x.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onStart");
    }

    public void onResume() {
        super.onResume();
        x.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onResume");
        as.CN().a(411, (e) this);
        as.CN().a(423, (e) this);
        if (this.lKS) {
            if (this.lKV != null) {
                this.lKV.sendEmptyMessageDelayed(131077, 4000);
            }
            if (!(this.lDw == null || this.lDw.lAm == null)) {
                this.lDw.lAm.aBr();
                this.lDw.amN();
            }
            as.Hm();
            if (((Boolean) com.tencent.mm.y.c.Db().get(208900, Boolean.valueOf(false))).booleanValue()) {
                aCd();
                as.Hm();
                com.tencent.mm.y.c.Db().set(208900, Boolean.valueOf(false));
            }
        }
    }

    public void setUserVisibleHint(boolean z) {
        x.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "setUserVisibleHint :%b", Boolean.valueOf(z));
        super.setUserVisibleHint(z);
        this.lKS = z;
        if (!this.lKT && this.lKU) {
            aDU();
        }
    }

    public void onPause() {
        super.onPause();
        as.CN().b(411, (e) this);
        as.CN().b(423, (e) this);
        x.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onPause");
        if (this.lGb != null) {
            this.lGb.aDQ();
        }
        if (this.lKV != null) {
            this.lKV.removeMessages(131077);
        }
    }

    public void onStop() {
        super.onStop();
        x.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onStop");
    }

    public void onDestroyView() {
        super.onDestroyView();
        x.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onResume");
    }

    public void onDestroy() {
        super.onDestroy();
        x.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onDestroy");
        if (this.lDw != null) {
            this.lDw.clear();
            this.lDw = null;
        }
        if (this.lGb != null) {
            this.lGb.aDQ();
            this.lGb.clear();
        }
        com.tencent.mm.sdk.b.a.xmy.c(this.lGz);
        i.aCl().lCx.j(this);
    }

    public void onDetach() {
        super.onDetach();
        x.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onDetach");
    }

    private void aDU() {
        int i = 0;
        this.lKT = true;
        this.lGx = new h();
        this.lGx.kgx = thisActivity();
        this.lGx.lDy = this;
        this.lGx.lDw = this.lDw;
        if (aDX()) {
            this.lGx.lDz = 1;
        } else {
            this.lGx.lDz = 2;
        }
        this.lGx.lDC = this;
        this.lGv = thisActivity().getIntent().getIntExtra("preceding_scence", 5);
        aci DT = i.aCl().lCz.DT(aCX());
        f a = n.a(DT);
        String str = "MicroMsg.emoji.EmojiStoreV2BaseFragment";
        String str2 = "load cache type: %d, size: %d ";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(aCX());
        objArr[1] = Integer.valueOf(DT == null ? 0 : DT.wrM);
        x.d(str, str2, objArr);
        if (a != null && a.lDn.size() > 0) {
            int size;
            int i2;
            int i3;
            this.lGB = true;
            this.klX.setVisibility(8);
            this.lGe.setVisibility(0);
            a(this.lGh, a);
            if (DT != null) {
                size = DT.wrY == null ? 0 : DT.wrY.size();
                i2 = DT.wrV;
                int i4 = DT.wrW;
                i3 = i2;
                i2 = size;
                size = i4;
            } else {
                size = 0;
                i3 = 0;
                i2 = 0;
            }
            x.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "load cache hotcount:%d type:%d", Integer.valueOf(i3), Integer.valueOf(aCX()));
            if (this.lDw != null && aDX()) {
                this.lDw.oV(i3 + i2);
                this.lDw.oW(size);
            }
            aCW();
            i = 1;
        }
        if (i == 0 || this.lKV == null) {
            eF(true);
        } else {
            this.lKV.postDelayed(new Runnable() {
                public final void run() {
                    a.this.eF(false);
                }
            }, 3000);
        }
    }

    public final void eF(boolean z) {
        x.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "loadNetWork force:%b isNeedToRefresh:%b", Boolean.valueOf(z), Boolean.valueOf(aDW()));
        if (!z) {
            aDW();
        }
        am(this.lGk);
        aDV();
    }

    private void am(byte[] bArr) {
        int aCX = aCX();
        int i = this.lGv == 1 ? 1 : 2;
        if (bArr != null) {
            x.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[refreshNetSceneGetEmotionList] request buffer %s", bArr.toString());
            this.lGu = new n(aCX, bArr, i);
            return;
        }
        x.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[refreshNetSceneGetEmotionList] request buffer is null.");
        this.lGu = new n(aCX, i);
    }

    private void aDV() {
        as.CN().a(this.lGu, 0);
    }

    private static boolean aDW() {
        as.Hm();
        ((Long) com.tencent.mm.y.c.Db().get(com.tencent.mm.storage.w.a.USERINFO_EMOJI_STORE_LAST_REFRESH_TIME_LONG, Long.valueOf(0))).longValue();
        return true;
    }

    private void a(int i, f fVar) {
        Object obj = 1;
        Object obj2 = null;
        x.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "");
        int obj22;
        switch (i) {
            case -1:
                this.lGw = fVar;
                obj22 = 1;
                break;
            case 0:
                this.lGw = fVar;
                obj = null;
                break;
            case 1:
                this.lGw = fVar;
                obj22 = 1;
                obj = null;
                break;
            case 2:
                if (this.lGw == null) {
                    this.lGw = new f();
                }
                this.lGw.pd(fVar.lDm);
                this.lGw.aC(fVar.lDn);
                obj22 = 1;
                obj = null;
                break;
            default:
                obj = null;
                break;
        }
        if (this.lGw != null) {
            this.lGw.aCc();
        }
        if (this.lGw != null && obj22 != null) {
            if (obj != null) {
                if (this.lGw == null) {
                    x.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "update store ui header failed. ");
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

    private void aCW() {
        com.tencent.mm.plugin.emoji.a.a.b.a(this.lDw.lAm, (com.tencent.mm.pluginsdk.model.i.a) this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onSceneEnd errType:%d,errCode:%d,errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (this.lzx != null && this.lzx.isShowing()) {
            this.lzx.dismiss();
        }
        switch (kVar.getType()) {
            case 411:
                n nVar = (n) kVar;
                if (nVar != null && nVar.mType == aCX()) {
                    int i3;
                    int i4;
                    int i5 = 0;
                    if (nVar == null || nVar.aCB() == null) {
                        i3 = 0;
                        i4 = 0;
                        i5 = 0;
                    } else {
                        if (this.lDw.aBn() <= 0 && aDX()) {
                            if (nVar.aCB().wrY == null) {
                                i5 = 0;
                            } else {
                                i5 = nVar.aCB().wrY.size();
                            }
                            this.lDw.oX(i5);
                        }
                        i3 = nVar.aCB().wrV;
                        i4 = i5;
                        i5 = nVar.aCB().wrW;
                    }
                    x.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onSceneEnd setSize:%d hotcount:%d recentHotCount:%d type:%d getSceneType:%d", Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(i5), Integer.valueOf(r4), Integer.valueOf(nVar.mType));
                    if (this.lDw != null && this.lDw.aBm() <= 0 && aDX()) {
                        this.lDw.oV(i3 + this.lDw.aBn());
                        this.lDw.oW(i5);
                    }
                    this.lGi = false;
                    this.lGj.setVisibility(8);
                    Object obj = (i == 0 || i == 4) ? 1 : null;
                    if (obj != null) {
                        this.klX.setVisibility(8);
                        this.lGe.setVisibility(0);
                        n nVar2 = (n) kVar;
                        f a = n.a(nVar2.aCB());
                        this.lGk = nVar2.lEK;
                        aci aCB;
                        if (i2 == 0) {
                            aCB = nVar2.aCB();
                            a(this.lGh, a);
                            d(aCB);
                            this.lGh = 0;
                        } else if (i2 == 2) {
                            aCB = nVar2.aCB();
                            a(this.lGh, a);
                            aCW();
                            d(aCB);
                            this.lGh = 2;
                        } else if (i2 == 3) {
                            a(this.lGh, a);
                            this.lGh = 1;
                        } else {
                            this.klX.setVisibility(0);
                            this.lGe.setVisibility(8);
                            this.lGf.setText(R.l.eaK);
                        }
                    } else if (!this.lGB) {
                        this.klX.setVisibility(0);
                        this.lGe.setVisibility(8);
                        this.lGf.setText(R.l.eaL);
                    }
                    if (aDX()) {
                        if (!(nVar.aCB() == null || nVar.aCB().wrY == null || nVar.aCB().wrY.size() <= 0)) {
                            i5 = 0;
                            while (true) {
                                i3 = i5;
                                if (i3 < nVar.aCB().wrY.size()) {
                                    com.tencent.mm.plugin.report.service.g.pWK.h(13223, Integer.valueOf(0), Integer.valueOf(((so) nVar.aCB().wrY.get(i3)).fgJ), ((so) nVar.aCB().wrY.get(i3)).fpg, Integer.valueOf(0));
                                    i5 = i3 + 1;
                                }
                            }
                        }
                        if (nVar.aCB().wrW > 0 && nVar.aCB().wrN != null && nVar.aCB().wrN.size() > nVar.aCB().wrV + nVar.aCB().wrW) {
                            i5 = 0;
                            while (true) {
                                i3 = i5;
                                if (i3 < nVar.aCB().wrW) {
                                    com.tencent.mm.plugin.report.service.g.pWK.h(13223, Integer.valueOf(0), ((sx) nVar.aCB().wrN.get(nVar.aCB().wrV + i3)).vPI, ((sx) nVar.aCB().wrN.get(nVar.aCB().wrV + i3)).whv, Integer.valueOf(1));
                                    i5 = i3 + 1;
                                } else {
                                    return;
                                }
                            }
                        }
                        return;
                    }
                    return;
                }
                return;
                break;
            default:
                x.w("MicroMsg.emoji.EmojiStoreV2BaseFragment", "unknow scene type.");
                return;
        }
    }

    public final boolean azR() {
        x.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[onBottomLoadData] startLoadRemoteEmoji.");
        eG(true);
        return true;
    }

    public final boolean azS() {
        return false;
    }

    public final boolean azT() {
        return false;
    }

    private void d(final aci aci) {
        if (this.lGh == -1) {
            as.Dt().F(new Runnable() {
                public final void run() {
                    int i = 0;
                    if (aci != null) {
                        String str = "MicroMsg.emoji.EmojiStoreV2BaseFragment";
                        String str2 = "jacks save EmoijStoreUI Cache: list:%d, size: %d, type: %d";
                        Object[] objArr = new Object[3];
                        objArr[0] = Integer.valueOf(aci == null ? 0 : aci.wrM);
                        if (!(aci == null || aci.vOw == null)) {
                            i = aci.vOw.bkL();
                        }
                        objArr[1] = Integer.valueOf(i);
                        objArr[2] = Integer.valueOf(a.this.aCX());
                        x.d(str, str2, objArr);
                        i.aCl().lCz.a(a.this.aCX(), aci);
                    }
                }
            });
        }
    }

    public final void a(com.tencent.mm.plugin.emoji.a.a aVar) {
        if (aVar.aBb() == 9) {
            zm(getString(R.l.dHd));
        }
        if (!aDX()) {
            this.lGx.lDz = 2;
        } else if (aVar.mPosition >= 0 && aVar.mPosition < this.lDw.aBl()) {
            this.lGx.lDz = 3;
        } else if (aVar.mPosition < this.lDw.aBl() || aVar.mPosition >= this.lDw.aBm() + this.lDw.aBl()) {
            this.lGx.lDz = 1;
        } else {
            this.lGx.lDz = 19;
        }
        this.lGx.a(aVar);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int headerViewsCount = i - this.Fv.getHeaderViewsCount();
        if (headerViewsCount >= 0 && headerViewsCount < this.lDw.getCount()) {
            com.tencent.mm.plugin.emoji.a.a.f oY = this.lDw.oY(headerViewsCount);
            a(oY, headerViewsCount);
            if (aDX() && this.lDw.aBm() > 0 && headerViewsCount >= this.lDw.aBl() && headerViewsCount < this.lDw.aBl() + this.lDw.aBm() && oY.lAy != null) {
                com.tencent.mm.plugin.report.service.g.pWK.h(13223, Integer.valueOf(1), oY.lAy.vPI, oY.lAy.whv, Integer.valueOf(1), Integer.valueOf(0));
            }
        }
    }

    public final void mN(int i) {
        if (i >= 0 && i < ((com.tencent.mm.plugin.emoji.a.h) this.lDw).aBp()) {
            a(this.lDw.oY(i), i);
        }
    }

    private void a(com.tencent.mm.plugin.emoji.a.a.f fVar, int i) {
        if (fVar == null) {
            x.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "item is null.");
        } else if (fVar.lAx == com.tencent.mm.plugin.emoji.a.a.f.a.lAG) {
            so soVar = fVar.lAz;
            if (soVar == null) {
                x.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "banner set is null. do nothing");
            } else {
                m.a(getContext(), soVar, false);
            }
        } else {
            sx sxVar = fVar.lAy;
            if (sxVar == null) {
                x.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "summary is null. do nothing");
                return;
            }
            int i2;
            if (!aDX()) {
                i2 = 2;
            } else if (i >= 0 && i < this.lDw.aBl()) {
                i2 = 3;
            } else if (i < this.lDw.aBl() || i >= this.lDw.aBm() + this.lDw.aBl()) {
                i2 = 1;
            } else {
                i2 = 19;
            }
            m.a(getContext(), sxVar, i2, fVar.mStatus, fVar.sm, thisActivity().getIntent().getStringExtra("to_talker_name"), 5);
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i != 0 || absListView.getLastVisiblePosition() != absListView.getCount() - 1) {
            return;
        }
        if (this.lGh == 0 || this.lGi) {
            x.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "No More List.");
            return;
        }
        eG(true);
        x.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[onScrollStateChanged] startLoadRemoteEmoji.");
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        x.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onActivityResult . requestCode:" + i + "  resultCode:" + i2);
        super.onActivityResult(i, i2, intent);
        if (this.lGx != null) {
            this.lGx.onActivityResult(i, i2, intent);
        } else {
            x.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "mPayOrDownloadComponent have no init.");
        }
    }

    public final void J(String str, String str2, String str3) {
        this.lGA = new g(str, str2, str3);
        as.CN().a(this.lGA, 0);
    }

    public final void aCd() {
        this.lGk = null;
        this.lGh = -1;
        eG(false);
    }

    private void eG(boolean z) {
        if (this.lGi) {
            x.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "isLoading");
            return;
        }
        this.lGi = true;
        if (z) {
            this.lGj.setVisibility(0);
        }
        am(this.lGk);
        aDV();
        x.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[startLoadRemoteEmoji] doScene GetEmotionListNetScene");
        if (!z) {
            zm(getString(R.l.dHn));
        }
    }

    public final void m(Message message) {
        if (this.lKV != null) {
            this.lKV.sendMessage(message);
        }
    }

    private void zm(String str) {
        if (isFinishing()) {
            x.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[showLoadingDialog] acitivity is finished.");
            return;
        }
        Context thisActivity = thisActivity();
        getString(R.l.dGZ);
        this.lzx = com.tencent.mm.ui.base.h.a(thisActivity, str, true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                a.aDa();
            }
        });
    }

    protected static void aDa() {
    }

    public final void u(ArrayList<q> arrayList) {
        x.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "google [onQueryFinish]");
        if (this.lDw != null) {
            if (this.lKV != null) {
                this.lKV.sendEmptyMessageDelayed(131074, 50);
            }
            com.tencent.mm.plugin.emoji.a.a.b.a((ArrayList) arrayList, this.lDw.lAm);
        }
    }

    public final void a(String str, l lVar) {
        if (!TextUtils.isEmpty(str) && str.equals("delete_group") && this.lKV != null) {
            this.lKV.sendEmptyMessageDelayed(131074, 50);
        }
    }

    protected int getForceOrientation() {
        return 1;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.lGb != null) {
            this.lGb.requestLayout();
        }
        setRequestedOrientation(1);
    }
}
