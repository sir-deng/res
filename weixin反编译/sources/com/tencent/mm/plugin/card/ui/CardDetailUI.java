package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.f.a.pc;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.card.a.c.a;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.f;
import com.tencent.mm.plugin.card.a.i;
import com.tencent.mm.plugin.card.a.j;
import com.tencent.mm.plugin.card.b.k;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.model.CardGiftInfo;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.aa;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.model.o;
import com.tencent.mm.plugin.card.model.t;
import com.tencent.mm.plugin.card.model.v;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.model.g;
import com.tencent.mm.plugin.card.sharecard.ui.CardConsumeSuccessUI;
import com.tencent.mm.protocal.c.bjk;
import com.tencent.mm.protocal.c.bjs;
import com.tencent.mm.protocal.c.bmz;
import com.tencent.mm.protocal.c.ko;
import com.tencent.mm.protocal.c.kr;
import com.tencent.mm.protocal.c.kx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.base.MMVerticalTextView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.y.as;
import com.tencent.mm.y.u;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public class CardDetailUI extends CardDetailBaseUI implements e, a, d.a, j.a, aw.a {
    private final String TAG = "MicroMsg.CardDetailUI";
    private float gAh = -85.0f;
    private float gAi = -1000.0f;
    private com.tencent.mm.modelgeo.a.a gAn = new com.tencent.mm.modelgeo.a.a() {
        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            if (!z) {
                return true;
            }
            if (CardDetailUI.this.gAh == -85.0f && CardDetailUI.this.gAi == -1000.0f) {
                CardDetailUI.this.gAh = f2;
                CardDetailUI.this.gAi = f;
                am.avn().u(CardDetailUI.this.gAh, CardDetailUI.this.gAi);
            }
            i c = CardDetailUI.this.kWu;
            float b = CardDetailUI.this.gAi;
            float a = CardDetailUI.this.gAh;
            synchronized (c.kOI) {
                c.gAh = a;
                c.gAi = b;
            }
            if (CardDetailUI.this.kWs) {
                CardDetailUI.this.awh();
                CardDetailUI.this.kWs = false;
            }
            CardDetailUI.this.atH();
            return false;
        }
    };
    private String hdN = "";
    private c hry;
    private r jqf = null;
    private Vibrator kJP;
    private int kKY = 3;
    private ArrayList<kr> kOB;
    private String kOh = "";
    private b kOv;
    private boolean kPK = false;
    private String kPu = "";
    private int kTE = -1;
    private boolean kTR = false;
    private boolean kUN = false;
    private int kVK = 0;
    private String kVL = "";
    private String kVM = "";
    private String kVN = "";
    e kWg;
    private String kWh = "";
    private String kWi = "";
    private String kWj = "";
    private boolean kWk = false;
    private boolean kWl = false;
    private boolean kWm = false;
    private String kWn = "";
    private e.a kWo;
    private boolean kWp = false;
    private boolean kWq = true;
    private boolean kWr = false;
    private boolean kWs = false;
    private String kWt = "";
    private i kWu = new i();
    ag mHandler = new ag();
    private long mStartTime = 0;

    static /* synthetic */ void a(CardDetailUI cardDetailUI, String str) {
        cardDetailUI.ec(true);
        as.CN().a(new af(cardDetailUI.kOv.aum(), str, 18), 0);
    }

    static /* synthetic */ void i(CardDetailUI cardDetailUI) {
        int i;
        cardDetailUI.ec(true);
        bjk bjk = new bjk();
        if (cardDetailUI.kKY == 3) {
            bjk.fHP = cardDetailUI.kOh;
            i = 1;
        } else {
            bjk.kPy = cardDetailUI.kOh;
            i = 0;
        }
        bjk.fHQ = cardDetailUI.kWj;
        bjk.vLt = cardDetailUI.kVL;
        bjk.vLs = cardDetailUI.kVM;
        bjk.vLu = cardDetailUI.kVK;
        LinkedList linkedList = new LinkedList();
        linkedList.add(bjk);
        bjs a = l.a(cardDetailUI.kWg.kUf, cardDetailUI.kWg.kUi, cardDetailUI.kWg.kUj);
        bmz bmz = new bmz();
        bmz.wWW = cardDetailUI.hdN;
        bmz.kQN = cardDetailUI.kWn;
        x.i("MicroMsg.CardDetailUI", "ShareCardItem upload templateId:%s", cardDetailUI.hdN);
        as.CN().a(new g(i, linkedList, cardDetailUI.kOv.aui().vYJ, cardDetailUI.kVN, a, cardDetailUI.kKY, bmz), 0);
    }

    static /* synthetic */ void j(CardDetailUI cardDetailUI) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(cardDetailUI.kOh);
        cardDetailUI.ec(true);
        as.CN().a(new com.tencent.mm.plugin.card.model.r(linkedList), 0);
    }

    static /* synthetic */ void k(CardDetailUI cardDetailUI) {
        cardDetailUI.ec(true);
        String aun = (cardDetailUI.kKY == 6 || TextUtils.isEmpty(cardDetailUI.kOv.aun())) ? cardDetailUI.kOh : cardDetailUI.kOv.aun();
        int awz = cardDetailUI.kWg.awz();
        bmz bmz = new bmz();
        bmz.wWW = cardDetailUI.hdN;
        bmz.kQN = cardDetailUI.kWn;
        x.i("MicroMsg.CardDetailUI", "AcceptItemInfo templateId:%s", cardDetailUI.hdN);
        as.CN().a(new o(aun, cardDetailUI.kKY, cardDetailUI.kWh, cardDetailUI.kWj, cardDetailUI.kVL, cardDetailUI.kVM, cardDetailUI.kVK, awz, bmz), 0);
    }

    protected final int getLayoutId() {
        return R.i.dcc;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mStartTime = System.currentTimeMillis();
        awc();
        e avs = am.avs();
        ActionBarActivity actionBarActivity = this.mController.xRr;
        as.CN().a(910, avs);
        am.avo().a(avs);
        com.tencent.mm.plugin.card.a.b avg = am.avg();
        if (avg.kOg == null) {
            avg.kOg = new ArrayList();
        }
        if (avs != null) {
            avg.kOg.add(new WeakReference(avs));
        }
        avs.Zt = new WeakReference(actionBarActivity);
        am.avs().a((d.a) this);
        am.avt().a(this);
        avs = am.avu();
        as.CN().a(577, avs);
        avs.kOi.clear();
        avs.kOj = 0;
        am.avu().a(this);
        initView();
    }

    protected void onResume() {
        super.onResume();
        awc();
        if (this.hry != null) {
            this.hry.a(this.gAn, true);
        }
        this.kWg.fwD = false;
        aw.a(this);
        am.avs().a(this, true);
        if ((this.kWk || this.kWl) && this.kOv.atO()) {
            if (this.kOv.aub()) {
                am.avt().aX(this.kOh, 2);
                Boolean bool = (Boolean) am.avs().kOu.get(this.kOh);
                boolean z = bool != null && bool.booleanValue();
                if (!z || TextUtils.isEmpty(am.avs().kOx)) {
                    x.i("MicroMsg.CardDetailUI", "onResume, not need launch succ ui or jsonRet is empty!");
                } else {
                    x.i("MicroMsg.CardDetailUI", "onResume, do launch succ UI!");
                    wD(am.avs().kOx);
                }
                this.kWg.kWE.d(com.tencent.mm.plugin.card.b.c.CARDCODEREFRESHACTION_DOREFRESH);
            } else {
                am.avt().aX(this.kOh, 1);
                com.tencent.mm.plugin.card.ui.view.g gVar = this.kWg.kWE;
                if (gVar != null) {
                    gVar.d(com.tencent.mm.plugin.card.b.c.CARDCODEREFRESHACTION_DOREFRESH);
                }
            }
        }
        if (this.kWu.isInit) {
            this.kWu.start();
        }
    }

    protected void onPause() {
        awd();
        super.onPause();
        this.kWg.fwD = true;
        am.avs().a(this, false);
        aw.a(null);
        e eVar = this.kWu;
        if (eVar.auM()) {
            x.i("MicroMsg.CardLbsOrBluetooth", "stop");
            if (eVar.kOO != null) {
                eVar.kOO.auP();
            }
            eVar.auK();
            as.CN().b(2574, eVar);
        }
    }

    public final void amn() {
        com.tencent.mm.plugin.card.ui.view.g gVar = this.kWg.kWE;
        if (gVar != null) {
            gVar.axH();
        }
    }

    protected void onDestroy() {
        am.avs().c(this);
        awd();
        am.avs().b(this);
        am.avs().release();
        am.avt().b(this);
        am.avu().b(this);
        am.avu().release();
        e eVar = this.kWg;
        f fVar = eVar.kWS;
        fVar.kOv = null;
        fVar.kOz.clear();
        eVar.kWS = null;
        j jVar = eVar.kWQ;
        l.u(jVar.laK);
        for (int size = jVar.laR.size() - 1; size >= 0; size--) {
            l.u((Bitmap) jVar.laR.remove(size));
        }
        jVar.laR.clear();
        if (jVar.iqe.isShowing()) {
            jVar.iqe.dismiss();
        }
        jVar.iqe = null;
        jVar.awO();
        jVar.isO = null;
        jVar.kOv = null;
        eVar.kWQ = null;
        if (eVar.kWD != null) {
            eVar.kWD.release();
        }
        eVar.kWx.jCj = null;
        com.tencent.mm.sdk.b.a.xmy.c(eVar.kXb);
        eVar.kWz.destroy();
        eVar.kWC.destroy();
        eVar.kWB.destroy();
        eVar.kWO.destroy();
        if (eVar.kWP != null) {
            eVar.kWP.destroy();
        }
        if (eVar.kWH != null) {
            eVar.kWH.destroy();
        }
        if (eVar.kWG != null) {
            eVar.kWG.destroy();
        }
        if (eVar.kWI != null) {
            eVar.kWI.destroy();
        }
        if (eVar.kWJ != null) {
            eVar.kWJ.destroy();
        }
        if (eVar.kWK != null) {
            eVar.kWK.destroy();
        }
        if (eVar.kWL != null) {
            eVar.kWL.destroy();
        }
        if (eVar.kWM != null) {
            eVar.kWM.destroy();
        }
        if (eVar.kWN != null) {
            eVar.kWN.destroy();
        }
        if (eVar.kWE != null) {
            eVar.kWE.destroy();
        }
        eVar.kWy = null;
        com.tencent.mm.plugin.card.a.g avx = am.avx();
        if (avx.kOg != null && eVar != null) {
            for (int i = 0; i < avx.kOg.size(); i++) {
                WeakReference weakReference = (WeakReference) avx.kOg.get(i);
                if (weakReference != null) {
                    com.tencent.mm.plugin.card.a.g.a aVar = (com.tencent.mm.plugin.card.a.g.a) weakReference.get();
                    if (aVar != null && aVar.equals(eVar)) {
                        avx.kOg.remove(weakReference);
                        break;
                    }
                }
            }
        }
        am.avx().release();
        this.kJP.cancel();
        atH();
        long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
        if (this.kOv != null) {
            com.tencent.mm.plugin.report.service.g.pWK.h(13219, "CardDetailView", Integer.valueOf(this.kKY), this.kOv.aun(), this.kOv.aum(), Long.valueOf(currentTimeMillis));
        } else {
            com.tencent.mm.plugin.report.service.g.pWK.h(13219, "CardDetailView", Integer.valueOf(this.kKY), this.kOh, this.kOh, Long.valueOf(currentTimeMillis));
        }
        if ((this.kWk || this.kWl) && this.kOv != null && this.kOv.atO()) {
            if (this.kOv.aub()) {
                am.avt().aX(this.kOh, 2);
            } else {
                am.avt().aX(this.kOh, 1);
            }
        }
        i iVar = this.kWu;
        x.i("MicroMsg.CardLbsOrBluetooth", "uninit");
        if (iVar.kOO != null) {
            a aVar2 = iVar.kOO;
            if (aVar2.jmY == null) {
                x.e("MicroMsg.CardLbsOrBluetooth", "bluetoothStateListener null, return");
            } else {
                ad.getContext().unregisterReceiver(aVar2.jmY);
                aVar2.jmY = null;
            }
            iVar.kOO = null;
        }
        iVar.auK();
        iVar.kOT = null;
        iVar.kOG = null;
        super.onDestroy();
    }

    private void awc() {
        as.CN().a(645, (e) this);
        as.CN().a(651, (e) this);
        as.CN().a(563, (e) this);
        as.CN().a(652, (e) this);
        as.CN().a(560, (e) this);
        as.CN().a(699, (e) this);
        as.CN().a(902, (e) this);
        as.CN().a(904, (e) this);
        as.CN().a(1163, (e) this);
    }

    private void awd() {
        as.CN().b(645, (e) this);
        as.CN().b(651, (e) this);
        as.CN().b(563, (e) this);
        as.CN().b(652, (e) this);
        as.CN().b(560, (e) this);
        as.CN().b(699, (e) this);
        as.CN().b(902, (e) this);
        as.CN().b(904, (e) this);
        as.CN().b(1163, (e) this);
    }

    protected final void initView() {
        boolean z;
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                CardDetailUI.this.eg(true);
                return true;
            }
        });
        this.kJP = (Vibrator) getSystemService("vibrator");
        if (this.kWg == null) {
            this.kWg = new e(this, this.mController.contentView);
            Object obj = this.kWg;
            obj.kWQ = new j(obj.kWx);
            j jVar = obj.kWQ;
            jVar.kTA = jVar.isO.getWindow().getAttributes().screenBrightness;
            if (jVar.iqe == null) {
                View inflate = View.inflate(jVar.isO, R.i.dcC, null);
                jVar.iqg = inflate.findViewById(R.h.cDo);
                jVar.iqf = (ImageView) inflate.findViewById(R.h.cDn);
                jVar.laL = (TextView) inflate.findViewById(R.h.cDq);
                jVar.laM = (TextView) inflate.findViewById(R.h.cDp);
                jVar.laN = inflate.findViewById(R.h.cDm);
                jVar.laO = (ImageView) inflate.findViewById(R.h.cDl);
                jVar.laP = (MMVerticalTextView) inflate.findViewById(R.h.cUI);
                jVar.laQ = (MMVerticalTextView) inflate.findViewById(R.h.cUJ);
                inflate.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        if (j.this.iqe != null && j.this.iqe.isShowing()) {
                            j.this.iqe.dismiss();
                        }
                    }
                });
                jVar.iqe = new q(inflate, -1, -1, true);
                jVar.iqe.update();
                jVar.iqe.setBackgroundDrawable(new ColorDrawable(16777215));
                jVar.iqe.setOnDismissListener(new OnDismissListener() {
                    public final void onDismiss() {
                    }
                });
            }
            obj.kWS = new f(obj.kWx);
            obj.kWx.jCj = obj;
            com.tencent.mm.sdk.b.a.xmy.b(obj.kXb);
            e eVar = this.kWg;
            if (eVar.kWz == null) {
                eVar.kWz = new com.tencent.mm.plugin.card.ui.view.x();
                eVar.kWz.a(eVar);
            }
            if (eVar.kWB == null) {
                eVar.kWB = new com.tencent.mm.plugin.card.ui.view.o();
                eVar.kWB.a(eVar);
            }
            if (eVar.kWC == null) {
                eVar.kWC = new com.tencent.mm.plugin.card.ui.view.a();
                eVar.kWC.a(eVar);
            }
            eVar.Fv = (ListView) eVar.findViewById(R.h.bSz);
            eVar.kWF = new m(eVar.kWx.mController.xRr);
            eVar.kWF.lby = eVar.iqi;
            eVar.Fv.setAdapter(eVar.kWF);
            eVar.kWF.notifyDataSetChanged();
            eVar.Fv.setOnItemClickListener(new OnItemClickListener() {
                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    com.tencent.mm.plugin.card.model.b bVar = (com.tencent.mm.plugin.card.model.b) e.this.kOz.get(i);
                    if (bVar != null && !TextUtils.isEmpty(bVar.url)) {
                        Intent intent = new Intent();
                        if (e.this.kOv instanceof CardInfo) {
                            intent.putExtra("key_card_info_data", (CardInfo) e.this.kOv);
                        } else if (e.this.kOv instanceof ShareCardInfo) {
                            intent.putExtra("key_card_info_data", (ShareCardInfo) e.this.kOv);
                        }
                        com.tencent.mm.plugin.report.service.g gVar;
                        Object[] objArr;
                        if (bVar.url.equals("card://jump_detail")) {
                            int i2;
                            if (e.this.kOv.aui().vZe == null || TextUtils.isEmpty(e.this.kOv.aui().vZe.url)) {
                                intent.setClass(e.this.kWx, CardDetailPreference.class);
                                e.this.kWx.startActivity(intent);
                            } else {
                                com.tencent.mm.plugin.card.b.b.a(e.this.kWx, e.this.kOv.aui().vZe.url, 1);
                            }
                            gVar = com.tencent.mm.plugin.report.service.g.pWK;
                            objArr = new Object[9];
                            objArr[0] = "CardLeftRightIntroduceView";
                            objArr[1] = Integer.valueOf(e.this.kOv.aui().kPz);
                            objArr[2] = e.this.kOv.aun();
                            objArr[3] = e.this.kOv.aum();
                            objArr[4] = Integer.valueOf(0);
                            objArr[5] = Integer.valueOf(e.this.kWZ.kTE);
                            objArr[6] = e.this.kWZ.kWh;
                            if (e.this.kOv.aug()) {
                                i2 = 1;
                            } else {
                                i2 = 0;
                            }
                            objArr[7] = Integer.valueOf(i2);
                            objArr[8] = "";
                            gVar.h(11324, objArr);
                        } else if (bVar.url.equals("card://jump_shop_list") && e.this.kOv.aui().vYQ > 0) {
                            e.a(e.this);
                        } else if (!bVar.url.equals("card://jump_shop") || e.this.kOv.aui().vYQ <= 0) {
                            String str;
                            if (bVar.url.equals("card://jump_service")) {
                                if (!TextUtils.isEmpty(e.this.kOv.aui().vYJ)) {
                                    com.tencent.mm.plugin.card.b.b.T(e.this.kWx, e.this.kOv.aui().vYJ);
                                    am.avn().o(e.this.kOv.aum(), e.this.kOv.aun(), 1);
                                }
                                com.tencent.mm.plugin.report.service.g.pWK.h(11582, "OperService", Integer.valueOf(1), Integer.valueOf(e.this.kOv.aui().kPz), e.this.kOv.aun(), e.this.kOv.aum(), e.this.kWZ.kWh);
                            } else if (bVar.url.equals("card://jump_gift")) {
                                e.b(e.this);
                                e eVar = e.this;
                                if (eVar.kOv.auj().vYu == null) {
                                    x.i("MicroMsg.CardDetailUIContoller", "mCardInfo.getDataInfo().gifting_info_cell is null");
                                } else if (eVar.kOv.auj().vYu.weA == null) {
                                    x.e("MicroMsg.CardDetailUIContoller", "mCardInfo.getDataInfo().gifting_info_cell.gifting_info is null");
                                } else {
                                    com.tencent.mm.plugin.report.service.g.pWK.h(13866, Integer.valueOf(6), eVar.kOv.auj().vYu.weA.vLz, com.tencent.mm.a.o.getString(eVar.kOv.auj().vYu.weA.vLy));
                                }
                            } else if (bVar.url.equals("card://jump_card_gift")) {
                                if (e.this.kOv.auj().vYu == null) {
                                    x.e("MicroMsg.CardDetailUIContoller", "jump_card_gift mCardInfo.getDataInfo().gifting_info_cell is null");
                                } else if (e.this.kOv.auj().vYu.weA == null) {
                                    x.e("MicroMsg.CardDetailUIContoller", "jump_card_gift mCardInfo.getDataInfo().gifting_info_cell.gifting_info is null");
                                } else {
                                    e eVar2 = e.this;
                                    x.d("MicroMsg.CardDetailUIContoller", "doJumpCardGift, order_id:%s, biz_uin:%d", e.this.kOv.auj().vYu.weA.vLz, Integer.valueOf(e.this.kOv.auj().vYu.weA.vLy));
                                    Intent intent2 = new Intent(eVar2.kWx, CardGiftReceiveUI.class);
                                    intent2.putExtra("key_biz_uin", r2);
                                    intent2.putExtra("key_order_id", str);
                                    intent2.putExtra("key_gift_into", (CardGiftInfo) eVar2.kWx.getIntent().getParcelableExtra("key_card_git_info"));
                                    eVar2.kWx.startActivity(intent2);
                                    com.tencent.mm.plugin.report.service.g.pWK.h(13866, Integer.valueOf(5), e.this.kOv.auj().vYu.weA.vLz, com.tencent.mm.a.o.getString(e.this.kOv.auj().vYu.weA.vLy));
                                }
                            } else if ((bVar.vZQ & 32) > 0) {
                                com.tencent.mm.ui.MMActivity.a aVar = e.this;
                                com.tencent.mm.plugin.card.b.b.a(aVar.kWx, 4, aVar);
                                aVar.kWx.jCj = aVar;
                            } else if (com.tencent.mm.plugin.card.b.b.d(e.this.kOv.aum(), bVar.vYB, bVar.vYC, e.this.kWZ.kTE, e.this.kWZ.kXf)) {
                                com.tencent.mm.plugin.report.service.g.pWK.h(11941, Integer.valueOf(21), e.this.kOv.aum(), e.this.kOv.aun(), "", bVar.title);
                            } else {
                                String aum;
                                com.tencent.mm.plugin.card.b.b.a(e.this.kWx, l.w(bVar.url, bVar.vZQ), 1);
                                com.tencent.mm.plugin.report.service.g.pWK.h(11492, Integer.valueOf(e.this.kWZ.kTE), e.this.kWZ.kWi, e.this.kOv.aum(), e.this.kOv.aun(), Integer.valueOf(e.this.kOv.auj().status), aum, Integer.valueOf(e.this.kOv.aui().kPz), e.this.kOv.aui().vYJ);
                                com.tencent.mm.plugin.report.service.g.pWK.h(11941, Integer.valueOf(6), e.this.kOv.aum(), e.this.kOv.aun(), "", bVar.title);
                                if (l.a(bVar, e.this.kOv.aum())) {
                                    aum = e.this.kOv.aum();
                                    str = bVar.title;
                                    l.xA(aum);
                                    com.tencent.mm.plugin.card.b.b.a(e.this.kWx, e.this.kOv.aui().kQL);
                                }
                            }
                        } else if (e.this.kOB == null || e.this.kOB.size() == 0) {
                            x.e("MicroMsg.CardDetailUIContoller", "mShopList == null || mShopList.size() == 0");
                        } else {
                            kr krVar = (kr) e.this.kOB.get(0);
                            if (!(krVar == null || TextUtils.isEmpty(krVar.kRm))) {
                                com.tencent.mm.plugin.card.b.b.a(e.this.kWx, krVar.kRm, 1);
                                com.tencent.mm.plugin.report.service.g.pWK.h(11941, Integer.valueOf(4), e.this.kOv.aum(), e.this.kOv.aun(), "", krVar.name);
                            }
                            gVar = com.tencent.mm.plugin.report.service.g.pWK;
                            objArr = new Object[9];
                            objArr[0] = "UsedStoresView";
                            objArr[1] = Integer.valueOf(e.this.kOv.aui().kPz);
                            objArr[2] = e.this.kOv.aun();
                            objArr[3] = e.this.kOv.aum();
                            objArr[4] = Integer.valueOf(0);
                            objArr[5] = Integer.valueOf(e.this.kWZ.kTE);
                            objArr[6] = e.this.kWZ.kWh;
                            objArr[7] = Integer.valueOf(e.this.kOv.aug() ? 1 : 0);
                            objArr[8] = "";
                            gVar.h(11324, objArr);
                        }
                    }
                }
            });
            x.i("MicroMsg.CardDetailUIContoller", "initMenu");
            eVar.kWx.kWa.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    if (e.this.kOv == null) {
                        x.e("MicroMsg.CardDetailUIContoller", "mCardInfo is null, err");
                        return;
                    }
                    com.tencent.mm.plugin.report.service.g.pWK.h(11582, "CardDetailUiMenu", Integer.valueOf(1), Integer.valueOf(e.this.kOv.aui().kPz), e.this.kOv.aun(), e.this.kOv.aum(), e.this.kWZ.kWh);
                    h.a(e.this.kWx.mController.xRr, null, (String[]) e.this.kWX.toArray(new String[e.this.kWX.size()]), null, false, new com.tencent.mm.ui.base.h.c() {
                        public final void jo(int i) {
                            String str = (String) e.this.kWV.get(Integer.valueOf(i));
                            if (!TextUtils.isEmpty(str)) {
                                if (str.equals("menu_func_share_friend")) {
                                    int i2;
                                    com.tencent.mm.ui.MMActivity.a aVar = e.this;
                                    com.tencent.mm.plugin.card.b.b.a(aVar.kWx, 1, aVar);
                                    aVar.kWx.jCj = aVar;
                                    com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pWK;
                                    Object[] objArr = new Object[9];
                                    objArr[0] = "BrandContactView";
                                    objArr[1] = Integer.valueOf(e.this.kOv.aui().kPz);
                                    objArr[2] = e.this.kOv.aun();
                                    objArr[3] = e.this.kOv.aum();
                                    objArr[4] = Integer.valueOf(0);
                                    objArr[5] = Integer.valueOf(e.this.kWZ.kTE);
                                    objArr[6] = e.this.kWZ.kWh;
                                    if (e.this.kOv.aug()) {
                                        i2 = 1;
                                    } else {
                                        i2 = 0;
                                    }
                                    objArr[7] = Integer.valueOf(i2);
                                    objArr[8] = "";
                                    gVar.h(11324, objArr);
                                    com.tencent.mm.plugin.report.service.g.pWK.h(11582, "OperShareFriend", Integer.valueOf(1), Integer.valueOf(e.this.kOv.aui().kPz), e.this.kOv.aun(), e.this.kOv.aum(), e.this.kWT);
                                } else if (str.equals("menu_func_gift")) {
                                    e.b(e.this);
                                } else if (str.equals("menu_func_delete")) {
                                    str = "";
                                    if (e.this.kOv.atP()) {
                                        str = e.this.kWx.getString(R.l.dOi);
                                    }
                                    com.tencent.mm.plugin.card.b.d.a(e.this.kWx, e.this.kWZ.kOh, str, new com.tencent.mm.plugin.card.b.d.a() {
                                        public final void atM() {
                                            if (e.this.kWY != null) {
                                                e.this.kWY.awk();
                                            }
                                        }
                                    });
                                    com.tencent.mm.plugin.report.service.g.pWK.h(11582, "OperDelete", Integer.valueOf(1), Integer.valueOf(e.this.kOv.aui().kPz), e.this.kOv.aun(), e.this.kOv.aum(), "");
                                } else if (str.equals("menu_func_service")) {
                                    if (!TextUtils.isEmpty(e.this.kOv.aui().vYJ)) {
                                        com.tencent.mm.plugin.card.b.b.T(e.this.kWx, e.this.kOv.aui().vYJ);
                                        am.avn().o(e.this.kOv.aum(), e.this.kOv.aun(), 1);
                                    }
                                    com.tencent.mm.plugin.report.service.g.pWK.h(11582, "OperService", Integer.valueOf(1), Integer.valueOf(e.this.kOv.aui().kPz), e.this.kOv.aun(), e.this.kOv.aum(), e.this.kWZ.kWh);
                                } else if (str.equals("menu_func_report")) {
                                    if (!TextUtils.isEmpty(e.this.kOv.auj().vYm)) {
                                        com.tencent.mm.plugin.card.b.b.a(e.this.kWx, e.this.kOv.auj().vYm, e.this.getString(R.l.dPh));
                                    }
                                    com.tencent.mm.plugin.report.service.g.pWK.h(11582, "OperReport", Integer.valueOf(1), Integer.valueOf(e.this.kOv.aui().kPz), e.this.kOv.aun(), e.this.kOv.aum(), "");
                                } else if (str.equals("menu_func_share_timeline")) {
                                    com.tencent.mm.platformtools.j.a(new m(e.this.kOv.aui().kPA));
                                    Context context = e.this.kWx;
                                    com.tencent.mm.plugin.card.base.b bVar = e.this.kOv;
                                    String str2 = e.this.kWZ.kOh;
                                    Object obj = e.this.kWZ.kWj;
                                    Intent intent = new Intent();
                                    intent.putExtra("Ksnsupload_link", bVar.aui().vYS);
                                    intent.putExtra("KContentObjDesc", bVar.aui().kQL);
                                    intent.putExtra("Ksnsupload_title", bVar.aui().title);
                                    if (TextUtils.isEmpty(obj)) {
                                        intent.putExtra("KUploadProduct_UserData", str2 + "#");
                                    } else {
                                        intent.putExtra("KUploadProduct_UserData", str2 + "#" + obj);
                                    }
                                    intent.putExtra("Ksnsupload_imgurl", bVar.aui().kPA);
                                    if (!TextUtils.isEmpty(bVar.aui().kPA)) {
                                        intent.putExtra("KsnsUpload_imgPath", new m(bVar.aui().kPA).Wo());
                                    }
                                    x.d("MicroMsg.CardActivityHelper", "doShareTimeLine KSnsUploadImgPath:" + intent.getStringExtra("KsnsUpload_imgPath"));
                                    intent.putExtra("src_username", com.tencent.mm.y.q.FY());
                                    intent.putExtra("src_displayname", com.tencent.mm.y.q.Ga());
                                    intent.putExtra("Ksnsupload_appid", bVar.aui().fGh);
                                    intent.putExtra("Ksnsupload_appname", bVar.aui().vYJ);
                                    intent.putExtra("Ksnsupload_type", 7);
                                    String hC = u.hC("card_package");
                                    u.GQ().t(hC, true).o("prePublishId", "card_package");
                                    intent.putExtra("reportSessionId", hC);
                                    com.tencent.mm.bl.d.a(context, "sns", ".ui.SnsUploadUI", intent, false);
                                    com.tencent.mm.plugin.report.service.g.pWK.h(11582, "OperShareTimeLine", Integer.valueOf(1), Integer.valueOf(e.this.kOv.aui().kPz), e.this.kOv.aun(), e.this.kOv.aum(), e.this.kWZ.kWh);
                                } else if (str.equals("menu_func_delete_share_card")) {
                                    com.tencent.mm.plugin.card.b.d.a(e.this.kWx, e.this.kWZ.kOh, "", new com.tencent.mm.plugin.card.b.d.a() {
                                        public final void atM() {
                                            if (e.this.kWY != null) {
                                                e.this.kWY.awn();
                                            }
                                        }
                                    });
                                } else {
                                    str = (String) e.this.kWW.get(str);
                                    if (!bi.oN(str)) {
                                        com.tencent.mm.plugin.card.b.b.a(e.this.kWx, str, 0);
                                    }
                                }
                            }
                        }
                    });
                }
            });
            eVar.ee = (LinearLayout) eVar.findViewById(R.h.coA);
            eVar.kWO = new com.tencent.mm.plugin.card.ui.view.d();
            eVar.kWO.a(eVar);
            eVar.kWQ.kOv = eVar.kOv;
        }
        int intExtra = getIntent().getIntExtra("key_from_scene", -1);
        x.i("MicroMsg.CardDetailUI", "scene:%d", Integer.valueOf(intExtra));
        String stringExtra;
        com.tencent.mm.plugin.card.model.d xp;
        if (intExtra == 2 || intExtra == 6 || intExtra == 5) {
            this.kKY = intExtra;
            stringExtra = getIntent().getStringExtra("key_card_app_msg");
            xp = com.tencent.mm.plugin.card.b.g.xp(stringExtra);
            if (xp != null) {
                this.kOh = xp.fHP;
                this.kWh = xp.kQJ;
                this.kWj = xp.fHQ;
                int i = xp.kQM;
                x.i("MicroMsg.CardDetailUI", "scene is " + intExtra + ", isRecommend is " + i);
                if (i == 1 && intExtra == 2) {
                    this.kKY = 23;
                }
                this.kWn = xp.kQN;
                x.i("MicroMsg.CardDetailUI", "recommend_card_id is " + this.kWn);
            }
            this.kWi = com.tencent.mm.plugin.card.b.g.xq(stringExtra);
        } else if (l.or(intExtra) || intExtra == 0 || intExtra == 1 || intExtra == 3 || intExtra == 4 || intExtra == 9 || intExtra == 12 || intExtra == 15 || intExtra == 17 || intExtra == 21) {
            this.kKY = intExtra;
            this.kOh = getIntent().getStringExtra("key_card_id");
            this.kWj = getIntent().getStringExtra("key_card_ext");
            this.kPK = getIntent().getBooleanExtra("key_is_share_card", false);
            this.kVK = getIntent().getIntExtra("key_stastic_scene", 0);
            this.kVN = getIntent().getStringExtra("key_consumed_card_id");
            if (intExtra == 7 || intExtra == 16) {
                this.kVL = getIntent().getStringExtra("src_username");
                this.kVM = getIntent().getStringExtra("js_url");
                this.hdN = getIntent().getStringExtra("key_template_id");
            } else if (this.kPK && intExtra == 3) {
                this.kPu = getIntent().getStringExtra("key_card_tp_id");
                this.kOh = com.tencent.mm.plugin.card.sharecard.a.b.bZ(this.kOh, this.kPu);
            } else if (intExtra == 8) {
                this.kWp = getIntent().getBooleanExtra("key_is_sms_add_card", false);
            }
        } else if (intExtra == 50 || intExtra == 27) {
            this.kKY = getIntent().getIntExtra("key_previous_scene", 50);
            if (!(this.kKY == 26 || this.kKY == 27)) {
                this.kKY = 3;
            }
            this.hdN = getIntent().getStringExtra("key_template_id");
            if (this.kKY == 27) {
                b bVar = (b) getIntent().getParcelableExtra("key_card_info");
                if (bVar != null) {
                    this.kOv = bVar;
                    this.kOh = this.kOv.aum();
                    awe();
                    awh();
                    if (this.kOv.auc()) {
                        am.avu().wB(this.kOv.aum());
                    }
                    avH();
                }
                awf();
                l.axL();
            } else {
                LinkedList bb = k.bb(getIntent().getStringExtra("card_list"), this.kKY);
                if (bb == null || bb.size() == 0) {
                    x.e("MicroMsg.CardDetailUI", "initData tempList size is empty");
                    eg(true);
                } else {
                    ec(true);
                    this.kOh = ((kx) bb.get(0)).kPy;
                    intExtra = getIntent().getIntExtra("key_previous_scene", 51);
                    bmz bmz = new bmz();
                    bmz.wWW = this.hdN;
                    x.i("MicroMsg.CardDetailUI", "doBatchGetCardItemByTpInfo templateId:%s", this.hdN);
                    as.CN().a(new t(bb, bmz, intExtra), 0);
                }
                awe();
            }
            this.kWg.a(this.kOv, this.kWo, this.kOB);
            this.kWg.kWY = new e.d() {
                public final void awj() {
                    CardDetailUI.i(CardDetailUI.this);
                }

                public final void xg(String str) {
                    CardDetailUI.a(CardDetailUI.this, str);
                }

                public final void awk() {
                    CardDetailUI.j(CardDetailUI.this);
                }

                public final void awl() {
                    CardDetailUI.k(CardDetailUI.this);
                }

                public final void awm() {
                    CardDetailUI.this.eg(true);
                }

                public final void awn() {
                    as.CN().a(new com.tencent.mm.plugin.card.sharecard.model.a(CardDetailUI.this.kOh), 0);
                }

                public final void d(b bVar) {
                    CardDetailUI.this.kOv = bVar;
                    CardDetailUI.this.kOh = bVar.aum();
                    CardDetailUI.this.kWo.kOh = CardDetailUI.this.kOh;
                }

                public final void awi() {
                    CardDetailUI.this.awi();
                }

                public final void awo() {
                    x.i("MicroMsg.CardDetailUI", "onConsumeCodeUIResult()");
                }

                public final void eh(boolean z) {
                    x.i("MicroMsg.CardDetailUI", "doMark()");
                    CardDetailUI.this.kWl = true;
                    CardDetailUI.this.ec(true);
                    CardDetailUI.this.kWm = z;
                    if (CardDetailUI.this.kOv.aub()) {
                        am.avt().D(CardDetailUI.this.kOh, l.xB(CardDetailUI.this.kOv.auo()), 2);
                    } else {
                        am.avt().D(CardDetailUI.this.kOh, l.xB(CardDetailUI.this.kOv.auo()), 1);
                    }
                }
            };
            x.i("MicroMsg.CardDetailUI", "checkPermission checkLocation[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null)));
            this.kUN = z;
            if (!this.kUN) {
                this.hry = c.OV();
                atF();
            }
        } else if (intExtra == 51) {
            if (getIntent().getIntExtra("key_previous_scene", 51) == 26) {
                this.kKY = 26;
            } else {
                this.kKY = 3;
            }
            this.kOh = getIntent().getStringExtra("key_card_id");
            this.kOv = am.avm().kNX;
            if (this.kOv == null) {
                this.kOv = am.avh().wL(this.kOh);
            }
            awe();
            if (this.kOv == null) {
                x.e("MicroMsg.CardDetailUI", "initData, mCardId is null from scene == ConstantsProtocal.MM_CARD_ITEM_FROM_SCENE_VIEW_UI");
                eg(true);
            } else {
                awh();
                avH();
                awf();
                if (this.kOv.auc()) {
                    am.avu().wB(this.kOv.aum());
                }
            }
            this.kWg.a(this.kOv, this.kWo, this.kOB);
            this.kWg.kWY = /* anonymous class already generated */;
            x.i("MicroMsg.CardDetailUI", "checkPermission checkLocation[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null)));
            this.kUN = z;
            if (!this.kUN) {
                this.hry = c.OV();
                atF();
            }
        } else if (intExtra == 26) {
            this.kKY = intExtra;
            this.kOh = getIntent().getStringExtra("key_card_id");
            this.kWj = getIntent().getStringExtra("key_card_ext");
        } else {
            this.kKY = intExtra;
            stringExtra = getIntent().getStringExtra("key_card_app_msg");
            xp = com.tencent.mm.plugin.card.b.g.xp(stringExtra);
            if (xp != null) {
                this.kOh = xp.fHP;
                this.kWh = xp.kQJ;
                this.kWj = xp.fHQ;
            }
            this.kWi = com.tencent.mm.plugin.card.b.g.xq(stringExtra);
        }
        awe();
        if (TextUtils.isEmpty(this.kOh)) {
            x.e("MicroMsg.CardDetailUI", "initData, mCardId is null");
            eg(true);
        } else {
            if (intExtra == 2 || intExtra == 6 || ((intExtra == 4 && !this.kPK) || intExtra == 5 || intExtra == 17 || intExtra == 21 || intExtra == 23)) {
                z = true;
            } else if (intExtra == 15) {
                Object value = am.avm().getValue("key_accept_card_info");
                if (value == null || !(value instanceof CardInfo)) {
                    z = true;
                } else {
                    this.kOv = (CardInfo) value;
                    z = false;
                }
            } else if (this.kPK) {
                this.kOv = am.avp().xb(this.kOh);
                z = false;
            } else {
                this.kOv = am.avh().wL(this.kOh);
                z = false;
            }
            if (z || this.kOv == null) {
                x.i("MicroMsg.CardDetailUI", "initData fail, isNeedDoNetScene1 is true or no cardinfo with cardId = " + this.kOh + " isShareCard is " + this.kPK);
                ec(true);
                if (this.kPK) {
                    awi();
                } else {
                    awg();
                }
            } else {
                x.d("MicroMsg.CardDetailUI", "initData(), cardId = " + this.kOh);
                kr aul = this.kOv.aul();
                if (aul != null) {
                    this.kOB = new ArrayList();
                    this.kOB.add(aul);
                }
                avH();
                if (this.kOv.auc()) {
                    am.avu().wB(this.kOv.aum());
                }
                if (this.kPK) {
                    this.kWq = true;
                    z = true;
                } else {
                    if (((long) ((int) (System.currentTimeMillis() / 1000))) - this.kOv.aup() >= 86400) {
                        this.kWq = true;
                        z = true;
                    } else if (this.kOv.atZ()) {
                        this.kWq = true;
                        z = true;
                    }
                }
                if (z) {
                    x.i("MicroMsg.CardDetailUI", "initData fail, isNeedDoNetScene2 is true or no cardinfo with cardId = " + this.kOh + " isShareCard is " + this.kPK);
                    if (this.kPK) {
                        awi();
                    } else {
                        awg();
                    }
                } else {
                    awh();
                }
                awf();
            }
        }
        this.kWg.a(this.kOv, this.kWo, this.kOB);
        this.kWg.kWY = /* anonymous class already generated */;
        x.i("MicroMsg.CardDetailUI", "checkPermission checkLocation[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null)));
        this.kUN = z;
        if (!this.kUN) {
            this.hry = c.OV();
            atF();
        }
    }

    private void awe() {
        this.kTE = this.kKY;
        this.kWo = new e.a();
        this.kWo.kKY = this.kKY;
        this.kWo.kTE = this.kTE;
        this.kWo.kOh = this.kOh;
        this.kWo.kWh = this.kWh;
        this.kWo.kWj = this.kWj;
        this.kWo.kWi = this.kWi;
        this.kWo.kVL = this.kVL;
        this.kWo.kVM = this.kVM;
        this.kWo.kPK = this.kPK;
        this.kWo.kXf = getIntent().getIntExtra("key_from_appbrand_type", 0);
    }

    private void awf() {
        int i = 1;
        if (!this.kWr && this.kOv != null) {
            this.kWr = true;
            com.tencent.mm.plugin.report.service.g gVar;
            Object[] objArr;
            if (this.kPK) {
                gVar = com.tencent.mm.plugin.report.service.g.pWK;
                objArr = new Object[9];
                objArr[0] = "ShareCardDetailUI";
                objArr[1] = Integer.valueOf(this.kOv.aui().kPz);
                objArr[2] = this.kOv.aun();
                objArr[3] = this.kOv.aum();
                objArr[4] = Integer.valueOf(0);
                objArr[5] = Integer.valueOf(this.kTE);
                objArr[6] = this.kWh;
                if (!this.kOv.aug()) {
                    i = 0;
                }
                objArr[7] = Integer.valueOf(i);
                objArr[8] = "";
                gVar.h(11324, objArr);
                return;
            }
            gVar = com.tencent.mm.plugin.report.service.g.pWK;
            objArr = new Object[9];
            objArr[0] = "CardDetailView";
            objArr[1] = Integer.valueOf(this.kOv.aui().kPz);
            objArr[2] = this.kOv.aun();
            objArr[3] = this.kOv.aum();
            objArr[4] = Integer.valueOf(0);
            objArr[5] = Integer.valueOf(this.kTE);
            objArr[6] = this.kWh;
            if (!this.kOv.aug()) {
                i = 0;
            }
            objArr[7] = Integer.valueOf(i);
            objArr[8] = "";
            gVar.h(11324, objArr);
        }
    }

    private void avH() {
        this.kWo.kKY = this.kKY;
        this.kWo.kTE = this.kTE;
        this.kWo.kOh = this.kOh;
        this.kWg.a(this.kOv, this.kWo, this.kOB);
        this.kWg.avH();
        am.avs().kOv = this.kOv;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ad.k kVar) {
        x.i("MicroMsg.CardDetailUI", "onSceneEnd, errType = " + i + " errCode = " + i2);
        int i3;
        if (i == 0 && i2 == 0) {
            ec(false);
            b bVar;
            b cardInfo;
            String str2;
            int i4;
            String str3;
            Integer num;
            Intent intent;
            ShareCardInfo shareCardInfo;
            if (kVar instanceof aa) {
                String str4 = ((aa) kVar).kRy;
                if (TextUtils.isEmpty(str4)) {
                    x.e("MicroMsg.CardDetailUI", "onSceneEnd, NetSceneGetCardItemInfo return json is null");
                    return;
                }
                bVar = this.kOv;
                cardInfo = new CardInfo();
                com.tencent.mm.plugin.card.b.f.a((CardInfo) cardInfo, str4);
                if (!TextUtils.isEmpty(cardInfo.aum())) {
                    this.kOh = cardInfo.aum();
                } else if (TextUtils.isEmpty(cardInfo.aum()) && !this.kOh.equals(cardInfo.aun())) {
                    x.e("MicroMsg.CardDetailUI", "mCardId:%s, mCardTpId:%s is different, error", this.kOh, cardInfo.aun());
                    return;
                }
                this.kOv = cardInfo;
                awh();
                if (this.kKY == 3) {
                    if (bVar != null) {
                        ((CardInfo) this.kOv).field_stickyAnnouncement = ((CardInfo) bVar).field_stickyAnnouncement;
                        ((CardInfo) this.kOv).field_stickyEndTime = ((CardInfo) bVar).field_stickyEndTime;
                        ((CardInfo) this.kOv).field_stickyIndex = ((CardInfo) bVar).field_stickyIndex;
                        ((CardInfo) this.kOv).field_label_wording = ((CardInfo) bVar).field_label_wording;
                        this.kOv.a(bVar.aul());
                    }
                    if (this.kWq) {
                        l.j(this.kOv);
                    } else {
                        x.e("MicroMsg.CardDetailUI", "onSceneEnd(), NetSceneGetCardItemInfo updateDataToDB is false");
                    }
                }
                avH();
                awf();
                if (this.kOv.auc()) {
                    am.avu().wB(this.kOv.aum());
                }
                this.kWu.a(this, this.kOh, this.kOv, this.gAh, this.gAi);
                return;
            } else if (kVar instanceof o) {
                if (this.kTE == 26) {
                    ec(false);
                }
                str2 = ((o) kVar).kRy;
                i4 = ((o) kVar).kRz;
                str3 = ((o) kVar).kRA;
                if (i4 != 0) {
                    b(i2, str, i4, str3);
                } else {
                    h.bu(this, getResources().getString(R.l.dNS));
                }
                if (TextUtils.isEmpty(str2)) {
                    x.e("MicroMsg.CardDetailUI", "onSceneEnd, NetSceneAcceptCardItem return json is null");
                    return;
                }
                this.kKY = 3;
                if (this.kOv == null) {
                    this.kOv = new CardInfo();
                }
                com.tencent.mm.plugin.card.b.f.a((CardInfo) this.kOv, str2);
                if (!TextUtils.isEmpty(this.kOv.aum())) {
                    this.kOh = this.kOv.aum();
                }
                if (this.kWg.awz() == 1) {
                    e eVar = this.kWg;
                    if (eVar.kWS != null) {
                        f fVar = eVar.kWS;
                        if (fVar.kOA != null) {
                            fVar.kOA.kPN = false;
                        }
                    }
                }
                if (this.kTE != 26) {
                    awh();
                    avH();
                }
                l.axL();
                cardInfo = this.kOv;
                if (cardInfo.atP()) {
                    as.Hm();
                    num = (Integer) com.tencent.mm.y.c.Db().get(w.a.USERINFO_CARD_IS_SHOW_MEMBERSHIP_TIP_INT_SYNC, Integer.valueOf(0));
                    if (num == null || num.intValue() != 1) {
                        as.Hm();
                        com.tencent.mm.y.c.Db().a(w.a.USERINFO_CARD_IS_SHOW_MEMBERSHIP_TIP_INT_SYNC, Integer.valueOf(1));
                    }
                    this.kWt = this.kOv.aus();
                    if (this.kTE != 7 || this.kTE == 16) {
                        intent = new Intent();
                        intent.putExtra("key_code", this.kWt);
                        setResult(-1, intent);
                        ok(-1);
                    } else if (!this.kWp && this.kTE == 8) {
                        eg(true);
                    } else if (this.kTE == 26 && i4 == 0) {
                        eg(true);
                    }
                    if (this.kOv.auc()) {
                        am.avu().wB(this.kOv.aum());
                    }
                    this.kWu.a(this, this.kOh, this.kOv, this.gAh, this.gAi);
                    return;
                }
                as.Hm();
                num = (Integer) com.tencent.mm.y.c.Db().get(282884, null);
                if (num == null || num.intValue() != 1) {
                    as.Hm();
                    com.tencent.mm.y.c.Db().set(282884, Integer.valueOf(1));
                }
                this.kWt = this.kOv.aus();
                if (this.kTE != 7) {
                }
                intent = new Intent();
                intent.putExtra("key_code", this.kWt);
                setResult(-1, intent);
                ok(-1);
                if (this.kOv.auc()) {
                    am.avu().wB(this.kOv.aum());
                }
                this.kWu.a(this, this.kOh, this.kOv, this.gAh, this.gAi);
                return;
                if (l.axO()) {
                    com.tencent.mm.plugin.card.b.d.c(this, R.i.dcL, R.l.dNP, cardInfo.aui().kQK);
                } else {
                    com.tencent.mm.plugin.card.b.d.c(this, R.i.dcK, R.l.dNO, cardInfo.aui().kQK);
                }
                this.kWt = this.kOv.aus();
                if (this.kTE != 7) {
                }
                intent = new Intent();
                intent.putExtra("key_code", this.kWt);
                setResult(-1, intent);
                ok(-1);
                if (this.kOv.auc()) {
                    am.avu().wB(this.kOv.aum());
                }
                this.kWu.a(this, this.kOh, this.kOv, this.gAh, this.gAi);
                return;
            } else if (kVar instanceof v) {
                this.kOB = ((v) kVar).kRH;
                if (this.kOv != null && this.kOB != null && this.kOB.size() > 0) {
                    this.kOv.a((kr) this.kOB.get(0));
                    avH();
                    com.tencent.mm.sdk.e.c xb;
                    if (this.kOv.atO()) {
                        xb = am.avp().xb(this.kOh);
                        if (xb != null) {
                            xb.a((kr) this.kOB.get(0));
                            am.avp().c(xb, this.kOh);
                            return;
                        }
                        return;
                    }
                    xb = am.avh().wL(this.kOh);
                    if (xb != null) {
                        xb.a((kr) this.kOB.get(0));
                        am.avh().c(xb, this.kOh);
                        return;
                    }
                    return;
                } else if (this.kOv != null && this.kOB == null) {
                    this.kOv.a(null);
                    avH();
                    com.tencent.mm.sdk.e.c xb2;
                    if (this.kOv.atO()) {
                        xb2 = am.avp().xb(this.kOh);
                        if (xb2 != null) {
                            xb2.a(null);
                            am.avp().c(xb2, this.kOh);
                            return;
                        }
                        return;
                    }
                    xb2 = am.avh().wL(this.kOh);
                    if (xb2 != null) {
                        xb2.a(null);
                        am.avh().c(xb2, this.kOh);
                        return;
                    }
                    return;
                } else {
                    return;
                }
            } else if (kVar instanceof af) {
                i3 = ((af) kVar).kRz;
                str3 = ((af) kVar).kRA;
                if (i3 == 10000) {
                    if (TextUtils.isEmpty(str3)) {
                        str3 = getString(R.l.dOu);
                    }
                    com.tencent.mm.plugin.card.b.d.b(this, str3);
                    return;
                }
                this.kWj = ((af) kVar).fHQ;
                ef(true);
                ko auj = this.kOv.auj();
                auj.status = 3;
                this.kOv.a(auj);
                l.j(this.kOv);
                avH();
                if (this.kTE == 3) {
                    eg(true);
                    return;
                } else if (this.kTE == 15) {
                    com.tencent.mm.sdk.b.a.xmy.m(new pc());
                    return;
                } else {
                    return;
                }
            } else if (kVar instanceof com.tencent.mm.plugin.card.model.r) {
                h.bu(this, getResources().getString(R.l.dOj));
                am.avg();
                com.tencent.mm.plugin.card.a.b.nX(4);
                eg(true);
                return;
            } else if (kVar instanceof t) {
                LinkedList linkedList = ((t) kVar).kRF;
                if (linkedList != null && linkedList.size() > 0) {
                    b bVar2 = (b) linkedList.get(0);
                    if (bVar2 == null || this.kOh.equals(bVar2.aun())) {
                        this.kOv = bVar2;
                        if (this.kOv != null) {
                            this.kOh = this.kOv.aum();
                            awh();
                            if (this.kOv.auc()) {
                                am.avu().wB(this.kOv.aum());
                            }
                        }
                        if (this.kKY == 26) {
                            this.kKY = 3;
                        }
                        avH();
                    } else {
                        x.e("MicroMsg.CardDetailUI", "mCardId:%s, mCardTpId:%s is different, error", this.kOh, bVar2.aun());
                        return;
                    }
                }
                awf();
                l.axL();
                return;
            } else if (kVar instanceof g) {
                str2 = ((g) kVar).kRy;
                i4 = ((g) kVar).kRz;
                str3 = ((g) kVar).kRA;
                if (i4 != 0) {
                    if (TextUtils.isEmpty(str3)) {
                        str3 = getString(R.l.dNH);
                    }
                    com.tencent.mm.plugin.card.b.d.b(this, str3);
                    x.e("MicroMsg.CardDetailUI", "NetSceneShareCardItem onSceneEnd, accept card error, ret_msg:%s", str3);
                    return;
                }
                h.bu(this, getResources().getString(R.l.dNK));
                if (TextUtils.isEmpty(str2)) {
                    x.e("MicroMsg.CardDetailUI", "NetSceneShareCardItem onSceneEnd, json is null");
                    return;
                }
                this.kKY = 3;
                if (this.kOv == null) {
                    this.kOv = new ShareCardInfo();
                } else if (this.kOv instanceof CardInfo) {
                    this.kOv = new ShareCardInfo();
                }
                com.tencent.mm.plugin.card.b.f.a((ShareCardInfo) this.kOv, str2);
                shareCardInfo = (ShareCardInfo) this.kOv;
                if (TextUtils.isEmpty(str2)) {
                    x.e("MicroMsg.CardInfoParser", "parserShareCardItemEncryptCodeForSingle jsonContent is null");
                } else {
                    try {
                        JSONArray optJSONArray = new JSONObject(str2).optJSONArray("card_list");
                        if (optJSONArray != null) {
                            shareCardInfo.kPD = optJSONArray.optJSONObject(0).optString("encrypt_code");
                            x.i("MicroMsg.CardInfoParser", "encrypt_code:" + shareCardInfo.kPD);
                        }
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.CardInfoParser", e, "", new Object[0]);
                        x.e("MicroMsg.CardInfoParser", e.getMessage());
                    }
                }
                if (!TextUtils.isEmpty(this.kOv.aum())) {
                    this.kOh = this.kOv.aum();
                }
                if (TextUtils.isEmpty(this.kOv.auo())) {
                    ((ShareCardInfo) this.kOv).field_from_username = com.tencent.mm.y.q.FY();
                }
                l.a((ShareCardInfo) this.kOv);
                awh();
                avH();
                l.axN();
                am.avo().asP();
                this.kWt = this.kOv.aus();
                if (this.kTE == 7 || this.kTE == 16) {
                    intent = new Intent();
                    intent.putExtra("key_code", this.kWt);
                    setResult(-1, intent);
                    ok(-1);
                } else if (!this.kWp && this.kTE == 8) {
                    eg(true);
                }
                as.Hm();
                num = (Integer) com.tencent.mm.y.c.Db().get(w.a.USERINFO_CARD_IS_SHOW_SHARE_CARD_TIP_INT_SYNC, Integer.valueOf(0));
                if (num == null || num.intValue() != 1) {
                    as.Hm();
                    com.tencent.mm.y.c.Db().a(w.a.USERINFO_CARD_IS_SHOW_SHARE_CARD_TIP_INT_SYNC, Integer.valueOf(1));
                    com.tencent.mm.plugin.card.b.d.c(this, R.i.dcN, R.l.dPy, "");
                }
                if (this.kOv.auc()) {
                    am.avu().wB(this.kOv.aum());
                    return;
                }
                return;
            } else if (kVar instanceof com.tencent.mm.plugin.card.sharecard.model.c) {
                Object obj = ((com.tencent.mm.plugin.card.sharecard.model.c) kVar).kRy;
                if (TextUtils.isEmpty(obj)) {
                    x.e("MicroMsg.CardDetailUI", "onSceneEnd, NetSceneGetShareCard json is null");
                    return;
                }
                bVar = this.kOv;
                this.kOv = new ShareCardInfo();
                shareCardInfo = (ShareCardInfo) this.kOv;
                if (TextUtils.isEmpty(obj)) {
                    x.e("MicroMsg.CardInfoParser", "parserShareCardItemJson jsonContent is null");
                } else {
                    try {
                        com.tencent.mm.plugin.card.b.f.a(shareCardInfo, new JSONObject(obj));
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.CardInfoParser", e2, "", new Object[0]);
                    }
                }
                if (bVar != null) {
                    if (!TextUtils.isEmpty(bVar.auo())) {
                        ((ShareCardInfo) this.kOv).field_from_username = ((ShareCardInfo) bVar).field_from_username;
                    }
                    ((ShareCardInfo) this.kOv).field_app_id = ((ShareCardInfo) bVar).field_app_id;
                    ((ShareCardInfo) this.kOv).field_consumer = ((ShareCardInfo) bVar).field_consumer;
                    ((ShareCardInfo) this.kOv).field_share_time = ((ShareCardInfo) bVar).field_share_time;
                    ((ShareCardInfo) this.kOv).field_updateTime = ((ShareCardInfo) bVar).field_updateTime;
                    ((ShareCardInfo) this.kOv).field_begin_time = ((ShareCardInfo) bVar).field_begin_time;
                    ((ShareCardInfo) this.kOv).field_end_time = ((ShareCardInfo) bVar).field_end_time;
                    ((ShareCardInfo) this.kOv).field_block_mask = ((ShareCardInfo) bVar).field_block_mask;
                    this.kOv.a(bVar.aul());
                    ((ShareCardInfo) this.kOv).field_categoryType = ((ShareCardInfo) bVar).field_categoryType;
                    ((ShareCardInfo) this.kOv).field_itemIndex = ((ShareCardInfo) bVar).field_itemIndex;
                    if (((ShareCardInfo) bVar).field_status != ((ShareCardInfo) this.kOv).field_status) {
                        x.i("MicroMsg.CardDetailUI", "getsharecared return, the status is " + ((ShareCardInfo) this.kOv).field_status);
                        com.tencent.mm.plugin.card.sharecard.a.b.a((Context) this, this.kOv);
                    }
                }
                if (!TextUtils.isEmpty(this.kOv.aum())) {
                    this.kOh = this.kOv.aum();
                }
                avH();
                awh();
                awf();
                if (this.kKY == 3) {
                    if (this.kWq) {
                        l.j(this.kOv);
                    } else {
                        x.e("MicroMsg.CardDetailUI", "onSceneEnd() sharecard updateDataToDB is false");
                    }
                }
                if (this.kOv.auc()) {
                    am.avu().wB(this.kOv.aum());
                    return;
                }
                return;
            } else if (!(kVar instanceof com.tencent.mm.plugin.card.sharecard.model.a)) {
                return;
            } else {
                if (((com.tencent.mm.plugin.card.sharecard.model.a) kVar).kRz != 0) {
                    com.tencent.mm.plugin.card.b.d.b(this, getString(R.l.dOh));
                    return;
                }
                x.i("MicroMsg.CardDetailUI", "delete share card, card id is " + this.kOv.aum());
                com.tencent.mm.plugin.card.sharecard.a.b.a((Context) this, this.kOv);
                h.bu(this, getResources().getString(R.l.dOj));
                am.avo().avy();
                eg(true);
                return;
            }
        }
        CharSequence charSequence;
        x.e("MicroMsg.CardDetailUI", "onSceneEnd, errType = " + i + " errCode = " + i2 + " cmd:" + kVar.getType());
        ec(false);
        Object charSequence2;
        if (kVar instanceof af) {
            ef(false);
            i3 = ((af) kVar).kRz;
            charSequence2 = ((af) kVar).kRA;
            if (i3 == 10000) {
                if (TextUtils.isEmpty(charSequence2)) {
                    charSequence2 = getString(R.l.dOu);
                }
            }
            charSequence2 = str;
        } else if (kVar instanceof o) {
            ok(0);
            b(i2, str, ((o) kVar).kRz, ((o) kVar).kRA);
            return;
        } else {
            if (kVar instanceof v) {
                return;
            }
            charSequence2 = str;
        }
        if (TextUtils.isEmpty(charSequence2)) {
            charSequence2 = getString(R.l.dQc);
        }
        Toast.makeText(this.mController.xRr, charSequence2, 0).show();
    }

    private void b(int i, String str, int i2, String str2) {
        x.e("MicroMsg.CardDetailUI", "handleAcceptError, errCode = " + i + " errMsg = " + str + " ret_code:" + i2 + " ret_msg:" + str2);
        if (i2 == 10000) {
            if (TextUtils.isEmpty(str2)) {
                str2 = getString(R.l.dNI);
            }
            this.kOv.auj().status = 4;
            avH();
        } else if (i2 == 10001) {
            if (TextUtils.isEmpty(str2)) {
                str2 = getString(R.l.dNL);
            }
            this.kOv.auj().status = 5;
            avH();
        } else if (i2 == 10002) {
            if (TextUtils.isEmpty(str2)) {
                str2 = getString(R.l.dPb);
            }
        } else if (TextUtils.isEmpty(str2)) {
            str2 = getString(R.l.dNG);
        }
        com.tencent.mm.plugin.card.b.d.b(this, str2);
    }

    private void ec(boolean z) {
        if (z) {
            this.jqf = r.b(this, getString(R.l.ctG), true, 0, null);
        } else if (this.jqf != null && this.jqf.isShowing()) {
            this.jqf.dismiss();
            this.jqf = null;
        }
    }

    private void ef(boolean z) {
        if (z) {
            l.cg(this.kWg.kWU, this.kWg.kWT);
        }
    }

    private void awg() {
        bmz bmz = new bmz();
        bmz.wWW = this.hdN;
        bmz.kQN = this.kWn;
        x.i("MicroMsg.CardDetailUI", "GetCardItemInfo templateId:%s", this.hdN);
        as.CN().a(new aa(this.kOh, this.kKY, this.kWh, this.kWj, this.kVL, this.kVM, this.kVK, this.kVN, bmz), 0);
    }

    private void awh() {
        String aun;
        if (!TextUtils.isEmpty(this.kOv.aun())) {
            aun = this.kOv.aun();
        } else if (TextUtils.isEmpty(this.kOh)) {
            x.e("MicroMsg.CardDetailUI", "doNetSceneCardShopLBS card id is null, return");
            return;
        } else {
            aun = this.kOh;
        }
        if (this.kOv != null && this.kOv.aui().vYQ == 1) {
            float f = this.gAh;
            float f2 = this.gAi;
            if (f == -85.0f || f2 == -1000.0f) {
                f = am.avn().gAh;
                f2 = am.avn().gAi;
            }
            as.CN().a(new v(aun, f2, f, this.kOv.aum()), 0);
        } else if (this.kOv == null || this.kOv.aui().vYQ <= 1) {
            if (this.kOv != null) {
                this.kOv.a(null);
                avH();
                com.tencent.mm.sdk.e.c xb;
                if (this.kOv.atO()) {
                    xb = am.avp().xb(this.kOh);
                    if (xb != null) {
                        xb.a(null);
                        am.avp().c(xb, this.kOh);
                        return;
                    }
                    return;
                }
                xb = am.avh().wL(this.kOh);
                if (xb != null) {
                    xb.a(null);
                    am.avh().c(xb, this.kOh);
                }
            }
        } else if (this.gAh != -85.0f && this.gAi != -1000.0f) {
            this.kWs = false;
            as.CN().a(new v(aun, this.gAi, this.gAh, this.kOv.aum()), 0);
        } else if (!this.kWs) {
            this.kWs = true;
            if (this.kUN) {
                atF();
            }
        }
    }

    private void awi() {
        as.CN().a(new com.tencent.mm.plugin.card.sharecard.model.c(this.kOh), 0);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            x.e("MicroMsg.CardDetailUI", "onKeyDown finishUI");
            eg(false);
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void eg(boolean z) {
        if ((this.kTE == 7 || this.kTE == 8 || this.kTE == 16 || this.kTE == 26) && this.kKY == 3) {
            Intent intent = new Intent();
            intent.putExtra("key_code", this.kWt);
            setResult(-1, intent);
            if (z) {
                finish();
            }
        } else if ((this.kTE == 7 && this.kKY == 7) || ((this.kTE == 16 && this.kKY == 16) || ((this.kTE == 8 && this.kKY == 8) || (this.kTE == 26 && this.kKY == 26)))) {
            setResult(0);
            if (z) {
                finish();
            }
        } else if (z) {
            finish();
        }
    }

    private void ok(int i) {
        if (this.kTE == 7 || this.kTE == 16) {
            LinkedList linkedList = new LinkedList();
            com.tencent.mm.plugin.card.model.e eVar = new com.tencent.mm.plugin.card.model.e();
            eVar.kPy = this.kOv.aun();
            eVar.fHQ = this.kWj;
            eVar.code = this.kWt;
            linkedList.add(eVar);
            com.tencent.mm.sdk.b.b bVar = new com.tencent.mm.f.a.b();
            bVar.fnC.bjW = i;
            if (i == -1) {
                bVar.fnC.fnD = com.tencent.mm.plugin.card.b.h.a(linkedList, true, this.kTE);
            } else {
                bVar.fnC.fnD = com.tencent.mm.plugin.card.b.h.a(linkedList, false, this.kTE);
            }
            com.tencent.mm.sdk.b.a.xmy.m(bVar);
            return;
        }
        x.i("MicroMsg.CardDetailUI", "mPreviousScene != ConstantsProtocal.MM_CARD_ITEM_FROM_SCENE_JSAPI and mPreviousScene != ConstantsProtocal.MM_CARD_ITEM_FROM_SCENE_NEARBY_PEOPLE_JSAPI ,don't push accept event");
    }

    private void atF() {
        if (this.hry == null) {
            this.hry = c.OV();
        }
        this.hry.a(this.gAn, true);
    }

    private void atH() {
        if (this.hry != null) {
            this.hry.c(this.gAn);
        }
    }

    private void avQ() {
        this.hry = c.OV();
        atF();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.CardDetailUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 69:
                if (iArr[0] == 0) {
                    x.i("MicroMsg.CardDetailUI", "onMPermissionGranted LocationPermissionGranted " + this.kUN);
                    if (!this.kUN) {
                        this.kUN = true;
                        avQ();
                        return;
                    }
                    return;
                }
                h.a((Context) this, getString(R.l.eAc), getString(R.l.eAg), getString(R.l.esG), getString(R.l.cancel), false, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        CardDetailUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                    }
                }, null);
                return;
            default:
                return;
        }
    }

    private synchronized void wC(String str) {
        if (this.kTR) {
            x.e("MicroMsg.CardDetailUI", "has start CardConsumeSuccessUI!");
        } else {
            x.i("MicroMsg.CardDetailUI", "startConsumedSuccUI() ");
            this.kTR = true;
            Intent intent = new Intent(this, CardConsumeSuccessUI.class);
            intent.putExtra("KEY_CARD_ID", this.kOv.aum());
            intent.putExtra("KEY_CARD_CONSUMED_JSON", str);
            intent.putExtra("KEY_CARD_COLOR", this.kOv.aui().hdx);
            intent.putExtra("key_stastic_scene", this.kKY);
            intent.putExtra("key_from_scene", 0);
            startActivity(intent);
        }
    }

    public final void f(b bVar) {
        if (bVar == null) {
            x.e("MicroMsg.CardDetailUI", "cardInfo is empty, not to do onDataChange");
        } else if (this.kOv == null || !this.kOv.aum().equals(bVar.aum())) {
            x.e("MicroMsg.CardDetailUI", "is not the same card, not to do onDataChange");
        } else if (this.kWg.awA()) {
            x.i("MicroMsg.CardDetailUI", "onDataChange");
            this.kOv = bVar;
            this.kOh = this.kOv.aum();
            if (this.kOv.auc() && am.avu().isEmpty()) {
                am.avu().wB(this.kOv.aum());
            }
            avH();
        } else {
            x.e("MicroMsg.CardDetailUI", "because the card is not accept, not to do onDataChange");
        }
    }

    public final void auF() {
        x.i("MicroMsg.CardDetailUI", "onVibrate");
        this.kJP.vibrate(300);
    }

    public final void auG() {
        x.i("MicroMsg.CardDetailUI", "onFinishUI");
    }

    public final void wD(final String str) {
        if (this.kWg.awA()) {
            x.i("MicroMsg.CardDetailUI", "onStartConsumedSuccUI");
            this.mHandler.post(new Runnable() {
                public final void run() {
                    CardDetailUI.this.wC(str);
                }
            });
            return;
        }
        x.e("MicroMsg.CardDetailUI", "because the card is not accept, not to do onStartConsumedSuccUI");
    }

    public final void b(String str, j.b bVar) {
        if (TextUtils.isEmpty(str) || str.equals(this.kOh)) {
            ec(false);
            x.i("MicroMsg.CardDetailUI", "onMarkSuccess()");
            x.i("MicroMsg.CardDetailUI", "markSucc:" + bVar.kPm + " markCardId: " + bVar.kPn);
            this.kWl = false;
            if (bVar.kPm != 1) {
                this.kWk = false;
                com.tencent.mm.plugin.card.b.d.b(this, getString(R.l.dOO));
                return;
            } else if (TextUtils.isEmpty(bVar.kPn) || this.kOv.aum().equals(bVar.kPn)) {
                x.i("MicroMsg.CardDetailUI", "markCardId is same as now id!");
                this.kWk = true;
                a(bVar);
                return;
            } else {
                x.i("MicroMsg.CardDetailUI", "markCardId is diff as now id!");
                if (this.kOv.atO()) {
                    b xb = am.avp().xb(bVar.kPn);
                    if (xb != null) {
                        this.kOv = xb;
                        this.kOh = bVar.kPn;
                        avH();
                        am.avs().d(this.kOv);
                        x.i("MicroMsg.CardDetailUI", "update the mCardInfo");
                        this.kWk = true;
                        a(bVar);
                        return;
                    }
                    x.e("MicroMsg.CardDetailUI", "The mark card id not exist the card info in DB!， mark failed!");
                    com.tencent.mm.plugin.card.b.d.b(this, getString(R.l.dON));
                    this.kWk = false;
                    return;
                }
                return;
            }
        }
        x.e("MicroMsg.CardDetailUI", "onMarkSuccess(), the mark card id is diff from current id!");
    }

    public final void bV(String str, String str2) {
        if (TextUtils.isEmpty(str) || str.equals(this.kOh)) {
            x.i("MicroMsg.CardDetailUI", "onMarkFail()");
            this.kWk = false;
            this.kWl = false;
            ec(false);
            if (TextUtils.isEmpty(str2)) {
                str2 = getString(R.l.dON);
            }
            com.tencent.mm.plugin.card.b.d.b(this, str2);
            return;
        }
        x.e("MicroMsg.CardDetailUI", "onMarkFail(), the mark card id is diff from current id!");
    }

    public final void wG(String str) {
        if (TextUtils.isEmpty(str) || str.equals(this.kOh)) {
            this.kWk = false;
        } else {
            x.e("MicroMsg.CardDetailUI", "onUnmarkSuccess(), the mark card id is diff from current id!");
        }
    }

    private void a(j.b bVar) {
        if (this.kWg.fwD) {
            x.i("MicroMsg.CardDetailUI", "UI is pause, not to jumpMarkUI()");
            return;
        }
        x.i("MicroMsg.CardDetailUI", "jumpMarkUI()");
        this.kWg.a(this.kWm, bVar, true);
    }

    public final void auA() {
        x.i("MicroMsg.CardDetailUI", "code change");
        if (this.kWg.kWE instanceof com.tencent.mm.plugin.card.ui.view.q) {
            ((com.tencent.mm.plugin.card.ui.view.q) this.kWg.kWE).laS = am.avu().getCode();
            this.kWg.avH();
        }
    }

    public final void wA(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.tencent.mm.plugin.card.b.d.a(this, str, true);
        }
    }

    public final void onSuccess() {
        if (this.kWg.kWE instanceof com.tencent.mm.plugin.card.ui.view.q) {
            ((com.tencent.mm.plugin.card.ui.view.q) this.kWg.kWE).laS = am.avu().getCode();
            this.kWg.avH();
        }
        x.i("MicroMsg.CardDetailUI", "code get success");
    }
}
