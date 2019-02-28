package com.tencent.mm.plugin.card.sharecard.ui;

import android.content.Intent;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.a.c.a;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.j;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.oy;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.statusbar.DrawStatusBarActivity;

public class CardConsumeCodeUI extends DrawStatusBarActivity implements OnClickListener, a, d.a {
    private final String TAG = "MicroMsg.CardConsumeCodeUI";
    private Vibrator kJP;
    private int kKY = 3;
    private b kOv;
    private String kTD;
    private int kTE = 3;
    private int kTF = 0;
    private a kTG;
    private TextView kTH;
    private TextView kTI;
    private LinearLayout kTJ;
    private ImageView kTK;
    private View kTL;
    private LinearLayout kTM;
    private View kTN;
    private TextView kTO;
    private TextView kTP;
    private TextView kTQ;
    private boolean kTR = false;

    protected final int getLayoutId() {
        return R.i.dbX;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.CardConsumeCodeUI", "onCreate()");
        setResult(0);
        this.kOv = (b) getIntent().getParcelableExtra("key_card_info_data");
        this.kKY = getIntent().getIntExtra("key_from_scene", 3);
        this.kTE = getIntent().getIntExtra("key_previous_scene", 3);
        this.kTD = getIntent().getStringExtra("key_mark_user");
        this.kTF = getIntent().getIntExtra("key_from_appbrand_type", 0);
        if (this.kOv == null || this.kOv.aui() == null || this.kOv.auj() == null) {
            x.e("MicroMsg.CardConsumeCodeUI", "mCardInfo == null or mCardInfo.getCardTpInfo() == null or mCardInfo.getDataInfo() == null");
            finish();
            return;
        }
        initView();
        am.avn().o("", "", 3);
    }

    protected final void initView() {
        a aVar;
        if (this.kOv.atP()) {
            if (TextUtils.isEmpty(this.kOv.aui().kQK)) {
                setMMTitle(getString(R.l.dOf, new Object[]{getString(R.l.dcw)}));
            } else {
                setMMTitle(getString(R.l.dOf, new Object[]{this.kOv.aui().kQK}));
            }
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                CardConsumeCodeUI.this.setResult(-1);
                CardConsumeCodeUI.this.finish();
                return true;
            }
        });
        if (this.kTG == null) {
            this.kTG = new a(this, this.mController.contentView);
            aVar = this.kTG;
            aVar.kTA = aVar.kgL.getWindow().getAttributes().screenBrightness;
            a aVar2 = this.kTG;
            aVar2.kTt = (TextView) aVar2.kTo.findViewById(R.h.bRA);
            aVar2.kTu = (TextView) aVar2.kTo.findViewById(R.h.bRG);
            aVar2.kTv = (CheckBox) aVar2.kTo.findViewById(R.h.cBu);
            aVar2.kTv.setChecked(true);
            aVar2.kTv.setOnClickListener(aVar2.iqi);
            if (aVar2.kTA < 0.8f) {
                aVar2.ae(0.8f);
            }
            this.kTG.kTz = new a.a() {
                public final void of(int i) {
                    am.avt().D(CardConsumeCodeUI.this.kOv.aum(), i, 1);
                }
            };
        }
        this.kTG.kOv = this.kOv;
        this.kTG.kTy = true;
        if (this.kOv.atO()) {
            aVar = this.kTG;
            String str = this.kTD;
            aVar.kTx = 1;
            aVar.kTw = str;
        }
        this.kJP = (Vibrator) getSystemService("vibrator");
        this.kTH = (TextView) findViewById(R.h.bOW);
        this.kTI = (TextView) findViewById(R.h.title);
        this.kTJ = (LinearLayout) findViewById(R.h.bKD);
        this.kTK = (ImageView) findViewById(R.h.bKC);
        this.kTL = findViewById(R.h.can);
        this.kTM = (LinearLayout) findViewById(R.h.bWv);
        if (this.kOv.atP()) {
            findViewById(R.h.bQj).setBackgroundColor(getResources().getColor(R.e.brI));
            m.b((MMActivity) this, true);
            com.tencent.mm.ui.statusbar.a.d(this.mController.contentView, -1, true);
        } else {
            int xu = l.xu(this.kOv.aui().hdx);
            findViewById(R.h.bQj).setBackgroundColor(xu);
            m.a((MMActivity) this, this.kOv);
            com.tencent.mm.ui.statusbar.a.d(this.mController.contentView, xu, true);
        }
        if (!this.kOv.atP() || TextUtils.isEmpty(this.kOv.aui().kPA)) {
            this.kTH.setText(this.kOv.aui().kQL);
            this.kTI.setText(this.kOv.aui().title);
        } else {
            this.kTJ.setVisibility(0);
            this.kTH.setVisibility(8);
            this.kTI.setVisibility(8);
            this.kTL.setVisibility(8);
            m.a(this.kTK, this.kOv.aui().kPA, getResources().getDimensionPixelSize(R.f.bwl), R.g.bDU, true);
        }
        if (this.kOv.aui().vZq != null) {
            oy oyVar = this.kOv.aui().vZq;
            if (!TextUtils.isEmpty(oyVar.title)) {
                if (this.kTN == null) {
                    this.kTN = ((ViewStub) findViewById(R.h.bRH)).inflate();
                }
                this.kTN.setOnClickListener(this);
                this.kTO = (TextView) this.kTN.findViewById(R.h.bRJ);
                this.kTP = (TextView) this.kTN.findViewById(R.h.bRI);
                this.kTQ = (TextView) this.kTN.findViewById(R.h.bRF);
                this.kTO.setVisibility(0);
                this.kTO.setText(oyVar.title);
                Drawable drawable = getResources().getDrawable(R.g.bAo);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                drawable.setColorFilter(l.xu(this.kOv.aui().hdx), Mode.SRC_IN);
                this.kTO.setCompoundDrawables(null, null, drawable, null);
                this.kTO.setTextColor(l.xu(this.kOv.aui().hdx));
                this.kTO.setOnClickListener(this);
                if (TextUtils.isEmpty(oyVar.kPB)) {
                    this.kTP.setVisibility(0);
                    this.kTP.setText(getString(R.l.dOR));
                } else {
                    this.kTP.setVisibility(0);
                    this.kTP.setText(oyVar.kPB);
                }
                if (!TextUtils.isEmpty(oyVar.kPC)) {
                    this.kTQ.setVisibility(0);
                    this.kTQ.setText(oyVar.kPC);
                }
                LayoutParams layoutParams = this.kTK.getLayoutParams();
                layoutParams.height = getResources().getDimensionPixelSize(R.f.bwm);
                layoutParams.width = getResources().getDimensionPixelSize(R.f.bwm);
                this.kTK.setLayoutParams(layoutParams);
                layoutParams = this.kTJ.getLayoutParams();
                layoutParams.height = com.tencent.mm.bu.a.fromDPToPix(this, 54);
                layoutParams.width = com.tencent.mm.bu.a.fromDPToPix(this, 54);
                this.kTJ.setLayoutParams(layoutParams);
                m.a(this.kTK, this.kOv.aui().kPA, getResources().getDimensionPixelSize(R.f.bwm), R.g.bDU, true);
                this.kTM.setPadding(0, com.tencent.mm.bu.a.fromDPToPix(this, 10), 0, com.tencent.mm.bu.a.fromDPToPix(this, 30));
            }
        }
        am.avs().a((d.a) this);
        if (this.kOv.auc()) {
            am.avu().a(this);
            if (am.avu().isEmpty()) {
                x.i("MicroMsg.CardConsumeCodeUI", "registerListener doGetCardCodes");
                am.avu().wB(this.kOv.aum());
                return;
            }
            am.avu().auy();
        }
    }

    protected void onResume() {
        this.kTG.avH();
        am.avs().a(this, true);
        super.onResume();
    }

    protected void onPause() {
        am.avs().a(this, false);
        super.onPause();
    }

    protected void onDestroy() {
        a aVar = this.kTG;
        aVar.ae(aVar.kTA);
        l.u(aVar.iqd);
        l.u(aVar.kTs);
        aVar.kTz = null;
        aVar.kgL = null;
        am.avs().c(this);
        am.avs().b(this);
        if (this.kOv.auc()) {
            am.avu().b(this);
            am.avu().auz();
        }
        this.kJP.cancel();
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            x.e("MicroMsg.CardConsumeCodeUI", "onKeyDown finishUI");
            setResult(-1);
            finish();
        }
        return super.onKeyDown(i, keyEvent);
    }

    public final void f(b bVar) {
        x.i("MicroMsg.CardConsumeCodeUI", "onDataChange");
        if (bVar != null && bVar.aum() != null && bVar.aum().equals(this.kOv.aum())) {
            this.kOv = bVar;
            this.kTG.kOv = this.kOv;
            this.kTG.avH();
        }
    }

    public final void auF() {
        this.kJP.vibrate(300);
    }

    public final void auG() {
        x.i("MicroMsg.CardConsumeCodeUI", "onFinishUI");
        finish();
    }

    public final void wD(String str) {
        x.i("MicroMsg.CardConsumeCodeUI", "onStartConsumedSuccUI");
        if (this.kTR) {
            x.e("MicroMsg.CardConsumeCodeUI", "has start CardConsumeSuccessUI!");
            return;
        }
        x.i("MicroMsg.CardConsumeCodeUI", "startConsumedSuccUI() ");
        this.kTR = true;
        Intent intent = new Intent(this, CardConsumeSuccessUI.class);
        intent.putExtra("KEY_CARD_ID", this.kOv.aum());
        intent.putExtra("KEY_CARD_CONSUMED_JSON", str);
        intent.putExtra("KEY_CARD_COLOR", this.kOv.aui().hdx);
        intent.putExtra("key_stastic_scene", this.kKY);
        intent.putExtra("key_from_scene", 0);
        startActivity(intent);
    }

    public final void auA() {
        this.kTG.avH();
    }

    public final void wA(String str) {
        com.tencent.mm.plugin.card.b.d.a(this, str, true);
    }

    public final void onSuccess() {
        this.kTG.avH();
    }

    public void onClick(View view) {
        if (view.getId() == R.h.bRJ || view.getId() == R.h.bRE) {
            if (this.kOv.aub()) {
                j.b bVar = new j.b();
                com.tencent.mm.plugin.card.b.b.a(this, bVar.kPo, bVar.kPp, false, this.kOv);
            } else {
                oy oyVar = this.kOv.aui().vZq;
                if (!(com.tencent.mm.plugin.card.b.b.a(this.kOv.aum(), oyVar, this.kTE, this.kTF) || oyVar == null || TextUtils.isEmpty(oyVar.url))) {
                    com.tencent.mm.plugin.card.b.b.a((MMActivity) this, l.w(oyVar.url, oyVar.vZQ), 1);
                    g.pWK.h(11941, Integer.valueOf(9), this.kOv.aum(), this.kOv.aun(), "", oyVar.title);
                    if (l.a(oyVar, this.kOv.aum())) {
                        String aum = this.kOv.aum();
                        String str = oyVar.title;
                        l.xA(aum);
                        com.tencent.mm.plugin.card.b.b.a((MMActivity) this, this.kOv.aui().kQL);
                    }
                }
            }
            finish();
        }
    }
}
