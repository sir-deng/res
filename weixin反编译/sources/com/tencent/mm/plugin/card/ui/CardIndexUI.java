package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.b.i;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.model.ad;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.f;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.r.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;

public class CardIndexUI extends CardBaseUI {
    private final String TAG = "MicroMsg.CardIndexUI";
    int fromScene = 0;
    private View kZo;
    private TextView kZp;
    private f kZq;
    private TextView kZr;
    private TextView kZs;
    private ImageView kZt;
    private LinearLayout kZu;
    int kZv = -1;
    private long mStartTime = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.CardIndexUI", "oncreate");
        this.mStartTime = System.currentTimeMillis();
        initView();
        as.CN().a(984, (e) this);
        am.avg();
        b.nX(1);
        int i = am.avl().kPr;
        if (c.Bx().aQ(262152, 266256) || i > 0) {
            g.pWK.h(11324, "CardPackageListView", Integer.valueOf(0), "", "", Integer.valueOf(1), Integer.valueOf(this.fromScene), "", Integer.valueOf(0), "");
            return;
        }
        g.pWK.h(11324, "CardPackageListView", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(this.fromScene), "", Integer.valueOf(0), "");
    }

    protected void onDestroy() {
        as.CN().b(984, (e) this);
        long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
        g.pWK.h(13219, "CardPackageListView", Integer.valueOf(this.fromScene), "", "", Long.valueOf(currentTimeMillis));
        super.onDestroy();
    }

    protected final void initView() {
        if (getIntent() != null) {
            this.kZv = getIntent().getIntExtra("key_card_type", -1);
        }
        super.initView();
    }

    protected final void atz() {
        if (1 == this.kZv) {
            setMMTitle(R.l.dOQ);
        } else if (3 == this.kZv) {
            setMMTitle(R.l.dPX);
        } else {
            setMMTitle(R.l.eLY);
        }
        this.kZr = (TextView) findViewById(R.h.cAw);
        this.kZs = (TextView) findViewById(R.h.cAx);
        this.kZt = (ImageView) findViewById(R.h.cAu);
        this.kZo = findViewById(R.h.bQx);
        this.kZp = (TextView) findViewById(R.h.bQy);
        this.kZu = (LinearLayout) findViewById(R.h.cAv);
        this.kZo.setVisibility(8);
        this.kZs.setVisibility(0);
        this.kZr.setVisibility(0);
        this.kZt.setVisibility(8);
        LayoutParams layoutParams = (LayoutParams) this.kZu.getLayoutParams();
        layoutParams.topMargin = BackwardSupportUtil.b.b((Context) this, 100.0f);
        this.kZu.setLayoutParams(layoutParams);
        if (1 == this.kZv) {
            this.kZs.setText(getString(R.l.dOH));
            this.kZr.setText(getString(R.l.dOG));
        } else if (3 == this.kZv) {
            this.kZs.setText(getString(R.l.dOL));
            this.kZr.setText(getString(R.l.dOK));
        } else {
            this.kZs.setText(getString(R.l.dPi));
            this.kZr.setText(getString(R.l.dPq));
        }
        this.kZp.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (!TextUtils.isEmpty(CardIndexUI.this.kZq.kQQ)) {
                    com.tencent.mm.plugin.card.b.b.a(CardIndexUI.this, CardIndexUI.this.kZq.kQQ, 0);
                }
            }
        });
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onStop() {
        super.onStop();
    }

    protected final int atA() {
        if (1 == this.kZv) {
            return a.kRv;
        }
        if (3 == this.kZv) {
            return a.kRu;
        }
        return a.kRr;
    }

    protected final BaseAdapter atB() {
        if (3 == this.kZv) {
            return new k(this, atA());
        }
        return new c(this, atA());
    }

    public final void a(int i, int i2, String str, k kVar) {
        super.a(i, i2, str, kVar);
        if (i != 0 || i2 != 0) {
            return;
        }
        if (kVar instanceof com.tencent.mm.plugin.card.model.x) {
            as.Hm();
            this.kZq = i.xs((String) com.tencent.mm.y.c.Db().get(282885, (Object) ""));
            if (this.kZq == null) {
                this.kZq = new f();
            }
            if (!(this.kZq == null || TextUtils.isEmpty(this.kZq.kQO))) {
                this.kZr.setText(this.kZq.kQO);
            }
            if (this.kZq == null || !this.kZq.kQR) {
                this.kZo.setVisibility(8);
                return;
            }
            this.kZp.setText(this.kZq.kQP);
            if (TextUtils.isEmpty(this.kZq.kQP) || TextUtils.isEmpty(this.kZq.kQQ)) {
                this.kZo.setVisibility(8);
            } else {
                this.kZo.setVisibility(0);
            }
        } else if ((kVar instanceof ad) && ((ad) kVar).kRO && (this.kNQ instanceof c)) {
            ((c) this.kNQ).mb(false);
            ((c) this.kNQ).mb(true);
            ((c) this.kNQ).XH();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }
}
