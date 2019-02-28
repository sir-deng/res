package com.tencent.mm.plugin.card.sharecard.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.ap.a.a.c.a;
import com.tencent.mm.ap.o;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.a.bw;
import com.tencent.mm.plugin.card.b.f;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.model.g;
import com.tencent.mm.plugin.card.sharecard.model.j;
import com.tencent.mm.plugin.card.sharecard.model.q;
import com.tencent.mm.protocal.c.bjk;
import com.tencent.mm.protocal.c.bjs;
import com.tencent.mm.protocal.c.kw;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.statusbar.DrawStatusBarActivity;
import com.tencent.mm.y.as;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CardConsumeSuccessUI extends DrawStatusBarActivity implements e {
    private View Iv;
    private final String TAG = "MicroMsg.CardConsumeSuccessUI";
    private OnClickListener iqi = new OnClickListener() {
        public final void onClick(View view) {
            if (view.getId() == R.h.bIg) {
                CardConsumeSuccessUI.a(CardConsumeSuccessUI.this);
            } else if (view.getId() == R.h.cPL) {
                Intent intent = new Intent();
                intent.putExtra("KLabel_range_index", CardConsumeSuccessUI.this.kUf);
                intent.putExtra("Klabel_name_list", CardConsumeSuccessUI.this.kUg);
                intent.putExtra("Kother_user_name_list", CardConsumeSuccessUI.this.kUh);
                intent.putExtra("k_sns_label_ui_title", CardConsumeSuccessUI.this.getString(R.l.dPw));
                intent.putExtra("k_sns_label_ui_style", 0);
                intent.putExtra("KLabel_is_filter_private", true);
                d.b(CardConsumeSuccessUI.this, "sns", ".ui.SnsLabelUI", intent, 1);
            }
        }
    };
    ag jFp = new ag(Looper.getMainLooper());
    private r jqf = null;
    private String kOh = "";
    private String kPu = "";
    private TextView kTH;
    private TextView kTI;
    private TextView kTT;
    private TextView kTU;
    private TextView kTV;
    private TextView kTW;
    private ImageView kTX;
    private Button kTY;
    private CheckBox kTZ;
    private j kUa;
    private String kUb = "";
    private String kUc = "";
    int kUd = 0;
    int kUe = 0;
    public int kUf = 0;
    private String kUg = "";
    private String kUh = "";
    public ArrayList<String> kUi = new ArrayList();
    public ArrayList<String> kUj = new ArrayList();
    private long mStartTime = 0;

    static /* synthetic */ void a(CardConsumeSuccessUI cardConsumeSuccessUI) {
        if (cardConsumeSuccessUI.kUa == null || cardConsumeSuccessUI.kUa.kST == null || cardConsumeSuccessUI.kUa.kST.isEmpty()) {
            x.e("MicroMsg.CardConsumeSuccessUI", "mConsumedInfo.list == null || mConsumedInfo.list.isEmpty()!");
            return;
        }
        cardConsumeSuccessUI.ec(true);
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < cardConsumeSuccessUI.kUa.kST.size(); i++) {
            kw kwVar = ((q) cardConsumeSuccessUI.kUa.kST.get(i)).kQD;
            bjk bjk = new bjk();
            if (kwVar != null) {
                bjk.kPy = kwVar.kPy;
                cardConsumeSuccessUI.kPu = kwVar.kPy;
            }
            bjk.fHQ = ((q) cardConsumeSuccessUI.kUa.kST.get(i)).fHQ;
            bjk.vLt = "";
            bjk.vLs = "";
            bjk.vLu = cardConsumeSuccessUI.kUe;
            linkedList.add(bjk);
        }
        String str = cardConsumeSuccessUI.kUd == 1 ? cardConsumeSuccessUI.kUa.kSU : cardConsumeSuccessUI.kOh;
        bjs a = l.a(cardConsumeSuccessUI.kUf, cardConsumeSuccessUI.kUi, cardConsumeSuccessUI.kUj);
        k gVar = cardConsumeSuccessUI.kTZ.isChecked() ? new g(0, linkedList, cardConsumeSuccessUI.kUa.kSW, str, a, 20, null) : new g(0, linkedList, "", str, a, 20, null);
        if (cardConsumeSuccessUI.kTZ != null && cardConsumeSuccessUI.kTZ.getVisibility() == 0) {
            if (cardConsumeSuccessUI.kTZ.isChecked()) {
                com.tencent.mm.plugin.report.service.g.pWK.h(11324, "CardConsumeSuccessFollowServices", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), "");
            } else {
                com.tencent.mm.plugin.report.service.g.pWK.h(11324, "CardConsumeSuccessView", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), "");
            }
        }
        as.CN().a(gVar, 0);
    }

    private void ec(boolean z) {
        if (z) {
            this.jqf = r.b(this, getString(R.l.ctG), true, 0, null);
        } else if (this.jqf != null && this.jqf.isShowing()) {
            this.jqf.dismiss();
            this.jqf = null;
        }
    }

    protected final int getLayoutId() {
        return R.i.dbY;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.CardConsumeSuccessUI", "onCreate()");
        this.mStartTime = System.currentTimeMillis();
        setMMTitle("");
        setResult(0);
        as.CN().a(902, (e) this);
        as.CN().a(910, (e) this);
        String str = "";
        this.kUd = getIntent().getIntExtra("key_from_scene", 0);
        if (this.kUd == 1) {
            x.i("MicroMsg.CardConsumeSuccessUI", "SCENE_FROM_JS");
            this.kUb = getIntent().getStringExtra("key_consumed_card_id");
            this.kUc = getIntent().getStringExtra("key_consumed_Code");
            if (TextUtils.isEmpty(this.kUb)) {
                x.e("MicroMsg.CardConsumeSuccessUI", "the mConsumdeCardId is empty!");
                og(0);
                finish();
                return;
            }
            x.i("MicroMsg.CardConsumeSuccessUI", "the mConsumdeCode is " + this.kUc);
            ec(true);
            as.CN().a(new com.tencent.mm.plugin.card.sharecard.model.d("", this.kUb, this.kUc), 0);
            avI();
            this.kUe = 7;
        } else if (this.kUd == 2) {
            x.i("MicroMsg.CardConsumeSuccessUI", "SCENE_FROM_MSG_UI");
            this.kOh = getIntent().getStringExtra("key_card_id");
            if (TextUtils.isEmpty(this.kOh)) {
                x.e("MicroMsg.CardConsumeSuccessUI", "the mCardId is empty!");
                og(0);
                finish();
                return;
            }
            x.i("MicroMsg.CardConsumeSuccessUI", "the mCardId is " + this.kOh);
            ec(true);
            as.CN().a(new com.tencent.mm.plugin.card.sharecard.model.d(this.kOh, "", ""), 0);
            avI();
            this.kUe = 4;
        } else {
            x.i("MicroMsg.CardConsumeSuccessUI", "SCENE_FROM_CONSUMED_CODE");
            this.kOh = getIntent().getStringExtra("KEY_CARD_ID");
            if (xc(getIntent().getStringExtra("KEY_CARD_CONSUMED_JSON"))) {
                String str2;
                if (!(this.kUa == null || bi.cC(this.kUa.kST))) {
                    kw kwVar = ((q) this.kUa.kST.get(0)).kQD;
                    if (kwVar != null) {
                        str2 = kwVar.hdx;
                        if (bi.oN(str2)) {
                            str2 = getIntent().getStringExtra("KEY_CARD_COLOR");
                        }
                        this.kUe = getIntent().getIntExtra("key_stastic_scene", 0);
                        str = str2;
                    }
                }
                str2 = str;
                if (bi.oN(str2)) {
                    str2 = getIntent().getStringExtra("KEY_CARD_COLOR");
                }
                this.kUe = getIntent().getIntExtra("key_stastic_scene", 0);
                str = str2;
            } else {
                x.e("MicroMsg.CardConsumeSuccessUI", "the mCardId is empty!");
                og(0);
                finish();
                return;
            }
        }
        com.tencent.mm.plugin.report.service.g.pWK.h(11324, "CardConsumeSuccessUI", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(this.kUe), "", Integer.valueOf(0), "");
        initView();
        if (!TextUtils.isEmpty(str)) {
            xd(str);
        }
    }

    private boolean xc(String str) {
        if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.CardConsumeSuccessUI", "parseCardConsumedJson the consumed json is empty!");
            return false;
        }
        this.kUa = com.tencent.mm.plugin.card.b.r.xD(str);
        if (this.kUa != null) {
            return true;
        }
        x.e("MicroMsg.CardConsumeSuccessUI", "parseCardConsumedJson the mConsumedInfo is null! json is " + str);
        return false;
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        as.CN().b(902, (e) this);
        as.CN().b(910, (e) this);
        long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
        if (TextUtils.isEmpty(this.kOh)) {
            com.tencent.mm.plugin.report.service.g.pWK.h(13219, "CardConsumeSuccessUI", Integer.valueOf(this.kUd), this.kPu, this.kUb, Long.valueOf(currentTimeMillis));
        } else {
            com.tencent.mm.plugin.report.service.g.pWK.h(13219, "CardConsumeSuccessUI", Integer.valueOf(this.kUd), this.kPu, this.kOh, Long.valueOf(currentTimeMillis));
        }
        super.onDestroy();
    }

    protected final void initView() {
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                CardConsumeSuccessUI.this.finish();
                CardConsumeSuccessUI.og(0);
                return true;
            }
        });
        this.Iv = this.mController.contentView;
        this.kTH = (TextView) findViewById(R.h.bPQ);
        this.kTI = (TextView) findViewById(R.h.bRy);
        this.kTT = (TextView) findViewById(R.h.bQl);
        this.kTU = (TextView) findViewById(R.h.cPM);
        this.kTV = (TextView) findViewById(R.h.cPL);
        this.kTW = (TextView) findViewById(R.h.cPK);
        this.kTX = (ImageView) findViewById(R.h.bQZ);
        this.kTY = (Button) findViewById(R.h.bIg);
        this.kTZ = (CheckBox) findViewById(R.h.bLs);
        this.kTY.setOnClickListener(this.iqi);
        this.kTZ.setOnClickListener(this.iqi);
        this.kTV.setOnClickListener(this.iqi);
        if (this.kUa != null) {
            av();
        }
    }

    private void av() {
        if (this.kUa == null) {
            x.e("MicroMsg.CardConsumeSuccessUI", "don't updateView() , mConsumedInfo is null");
            return;
        }
        findViewById(R.h.cIC).setVisibility(0);
        if (TextUtils.isEmpty(this.kUa.kSV) || TextUtils.isEmpty(this.kUa.kSW)) {
            this.kTZ.setVisibility(8);
            x.e("MicroMsg.CardConsumeSuccessUI", "mConsumedInfo.subscribe_wording is empty or subscribe_app_username is empty!");
        } else {
            this.kTZ.setText(this.kUa.kSV);
            this.kTZ.setVisibility(0);
        }
        if (this.kUa.kST == null || this.kUa.kST.size() <= 0) {
            this.kTY.setEnabled(false);
            x.e("MicroMsg.CardConsumeSuccessUI", "mConsumedInfo.list is null!");
            return;
        }
        this.kTU.setText(getString(R.l.dOg, new Object[]{Integer.valueOf(this.kUa.kST.size())}));
        kw kwVar = ((q) this.kUa.kST.get(0)).kQD;
        if (kwVar != null) {
            xd(kwVar.hdx);
            this.kTH.setText(kwVar.kQL);
            this.kTI.setText(kwVar.title);
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.f.bwu);
            if (TextUtils.isEmpty(kwVar.kPA)) {
                x.e("MicroMsg.CardConsumeSuccessUI", "cardTpInfo.logo_url is empty!");
                this.kTX.setImageResource(R.g.bDU);
            } else {
                a aVar = new a();
                aVar.hFo = com.tencent.mm.compatible.util.e.bnF;
                o.PH();
                aVar.hFH = null;
                aVar.hFn = m.wQ(kwVar.kPA);
                aVar.hFl = true;
                aVar.hFJ = true;
                aVar.hFj = true;
                aVar.hFs = dimensionPixelSize;
                aVar.hFr = dimensionPixelSize;
                aVar.hFA = R.g.bDU;
                o.PG().a(kwVar.kPA, this.kTX, aVar.PQ());
            }
            if (TextUtils.isEmpty(kwVar.vYV)) {
                this.kTY.setText(R.l.dOe);
                return;
            }
            x.e("MicroMsg.CardConsumeSuccessUI", "accept_wording is empty!");
            this.kTY.setText(kwVar.vYV);
            return;
        }
        x.e("MicroMsg.CardConsumeSuccessUI", "cardTpInfo is null!");
    }

    private void avI() {
        this.mController.contentView.setBackgroundColor(getResources().getColor(R.e.brI));
        findViewById(R.h.cIC).setVisibility(4);
    }

    @TargetApi(16)
    private void xd(String str) {
        int xu = l.xu(str);
        this.Iv.setBackgroundColor(xu);
        com.tencent.mm.plugin.card.b.m.a((MMActivity) this, xu);
        com.tencent.mm.ui.statusbar.a.d(this.mController.contentView, xu, true);
        if (com.tencent.mm.compatible.util.d.fN(16)) {
            this.kTY.setBackground(l.cm(xu, getResources().getDimensionPixelSize(R.f.bwf) / 2));
        } else {
            this.kTY.setBackgroundDrawable(l.cm(xu, getResources().getDimensionPixelSize(R.f.bwf) / 2));
        }
        this.Iv.invalidate();
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.CardConsumeSuccessUI", "onSceneEnd, errType = " + i + " errCode = " + i2 + " scene cmd is " + kVar.getType());
        ec(false);
        if (i == 0 && i2 == 0) {
            if (kVar instanceof g) {
                g gVar = (g) kVar;
                if (gVar.kRz == 0) {
                    h.bu(this, getString(R.l.dNK));
                    setResult(-1);
                    this.kTY.setEnabled(false);
                    l.axN();
                    x.i("MicroMsg.CardConsumeSuccessUI", "finish UI!");
                    og(-1);
                    String str2 = ((g) kVar).kRy;
                    ShareCardInfo shareCardInfo = new ShareCardInfo();
                    f.a(shareCardInfo, str2);
                    l.a(shareCardInfo);
                    am.avo().asP();
                    finish();
                    return;
                }
                x.e("MicroMsg.CardConsumeSuccessUI", "shareNetscene.getRetCode() is " + gVar.kRz);
                com.tencent.mm.plugin.card.b.d.b(this, gVar.kRA);
                h.bu(this, getString(R.l.dNH));
            } else if (kVar instanceof com.tencent.mm.plugin.card.sharecard.model.d) {
                com.tencent.mm.plugin.card.sharecard.model.d dVar = (com.tencent.mm.plugin.card.sharecard.model.d) kVar;
                if (dVar.kRz == 0) {
                    if (TextUtils.isEmpty(dVar.kRy) || !xc(dVar.kRy)) {
                        x.e("MicroMsg.CardConsumeSuccessUI", "consumed return json is empty, finish ui!");
                        if (this.kUd == 1) {
                            og(0);
                            finish();
                            return;
                        }
                        avI();
                        xe(dVar.kRA);
                        if (bi.oN(dVar.kRA)) {
                            h.bu(this, getString(R.l.dNJ));
                            return;
                        } else {
                            h.bu(this, dVar.kRA);
                            return;
                        }
                    }
                    x.i("MicroMsg.CardConsumeSuccessUI", "consumed return json is valid, update ui");
                    this.jFp.post(new Runnable() {
                        public final void run() {
                            CardConsumeSuccessUI.this.av();
                        }
                    });
                } else if (this.kUd == 1) {
                    og(0);
                    finish();
                } else {
                    x.e("MicroMsg.CardConsumeSuccessUI", "succScene.getRetCode() is " + dVar.kRz);
                    avI();
                    xe(dVar.kRA);
                }
            }
        } else if ((kVar instanceof com.tencent.mm.plugin.card.sharecard.model.d) && this.kUd == 1) {
            og(0);
            finish();
        } else {
            com.tencent.mm.plugin.card.b.d.b(this, str);
        }
    }

    private void xe(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getString(R.l.dNJ);
        }
        h.a((Context) this, str, "", false, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                CardConsumeSuccessUI.og(0);
                CardConsumeSuccessUI.this.finish();
            }
        });
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            x.e("MicroMsg.CardConsumeSuccessUI", "onKeyDown finishUI");
            og(0);
            finish();
        }
        return super.onKeyDown(i, keyEvent);
    }

    private static void og(int i) {
        x.i("MicroMsg.CardConsumeSuccessUI", "pushConsumedEvent resultCode is " + i);
        b bwVar = new bw();
        bwVar.fqT.bjW = i;
        com.tencent.mm.sdk.b.a.xmy.m(bwVar);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                if (i2 == -1) {
                    this.kUf = intent.getIntExtra("Ktag_range_index", 0);
                    x.i("MicroMsg.CardConsumeSuccessUI", "mPrivateSelelct : %d", Integer.valueOf(this.kUf));
                    if (this.kUf >= 2) {
                        this.kUg = intent.getStringExtra("Klabel_name_list");
                        this.kUh = intent.getStringExtra("Kother_user_name_list");
                        x.d("MicroMsg.CardConsumeSuccessUI", "mPrivateSelect : %d, names : %s", Integer.valueOf(this.kUf), this.kUg);
                        if (TextUtils.isEmpty(this.kUg) && TextUtils.isEmpty(this.kUh)) {
                            x.e("MicroMsg.CardConsumeSuccessUI", "mLabelNameList and mPrivateTmpUsers by getIntent is empty");
                            return;
                        }
                        List asList = Arrays.asList(this.kUg.split(","));
                        this.kUj = l.aq(asList);
                        this.kUi = l.ap(asList);
                        if (this.kUh != null && this.kUh.length() > 0) {
                            this.kUi.addAll(Arrays.asList(this.kUh.split(",")));
                        }
                        if (this.kUj != null) {
                            x.i("MicroMsg.CardConsumeSuccessUI", "mPrivateIdsList size is " + this.kUj.size());
                        }
                        if (this.kUi != null) {
                            x.i("MicroMsg.CardConsumeSuccessUI", "mPrivateNamesList size is " + this.kUi.size());
                            Iterator it = this.kUi.iterator();
                            while (it.hasNext()) {
                                x.d("MicroMsg.CardConsumeSuccessUI", "username : %s", (String) it.next());
                            }
                        }
                        if (this.kUf == 2) {
                            this.kTW.setVisibility(0);
                            this.kTW.setText(getString(R.l.dPv, new Object[]{avJ()}));
                            return;
                        } else if (this.kUf == 3) {
                            this.kTW.setVisibility(0);
                            this.kTW.setText(getString(R.l.dPu, new Object[]{avJ()}));
                            return;
                        } else {
                            this.kTW.setVisibility(8);
                            return;
                        }
                    }
                    this.kTW.setVisibility(8);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private String avJ() {
        if (!TextUtils.isEmpty(this.kUg) && !TextUtils.isEmpty(this.kUh)) {
            return this.kUg + "," + l.xy(this.kUh);
        }
        if (!TextUtils.isEmpty(this.kUg)) {
            return this.kUg;
        }
        if (TextUtils.isEmpty(this.kUh)) {
            return "";
        }
        return l.xy(this.kUh);
    }
}
