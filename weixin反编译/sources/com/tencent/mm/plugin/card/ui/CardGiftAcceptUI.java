package com.tencent.mm.plugin.card.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Animation;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.ap.a.a.c;
import com.tencent.mm.plugin.card.b.d;
import com.tencent.mm.plugin.card.b.m.AnonymousClass3;
import com.tencent.mm.plugin.card.model.ag;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.model.q;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.y.as;

@a(3)
public class CardGiftAcceptUI extends MMActivity implements OnClickListener, e {
    private final String TAG = "MicroMsg.CardGiftAcceptUI";
    private String fBK;
    private String fGc;
    private int hdY;
    private String hdZ;
    private RelativeLayout kXA;
    private ag kXB;
    private q kXC;
    private RelativeLayout kXn;
    private RelativeLayout kXo;
    private ImageView kXp;
    private TextView kXq;
    private TextView kXr;
    private ImageView kXs;
    private Button kXt;
    private LinearLayout kXu;
    private TextView kXv;
    private LinearLayout kXw;
    private TextView kXx;
    private ImageView kXy;
    private ImageView kXz;
    private r tipDialog = null;

    protected final int getLayoutId() {
        return R.i.dce;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hdZ = getIntent().getStringExtra("key_order_id");
        this.hdY = getIntent().getIntExtra("key_biz_uin", -1);
        this.fGc = getIntent().getStringExtra("key_from_user_name");
        this.fBK = getIntent().getStringExtra("key_chatroom_name");
        x.i("MicroMsg.CardGiftAcceptUI", "onCreate, orderId:%s, bizUin:%s, fromUserName:%s", this.hdZ, Integer.valueOf(this.hdY), this.fGc);
        if (this.hdY == -1) {
            x.e("MicroMsg.CardGiftAcceptUI", "bizUin is -1, fail!");
            d.a(this, "", true);
        } else if (this.hdZ == null) {
            x.e("MicroMsg.CardGiftAcceptUI", "orderId is null, fail");
            d.a(this, "", true);
        } else {
            if (!bi.oN(this.fGc)) {
                g.pWK.h(13866, Integer.valueOf(1), this.hdZ, o.getString(this.hdY), this.fGc);
            }
            initView();
            as.CN().a(1171, (e) this);
            as.CN().a(1136, (e) this);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        as.CN().b(1171, (e) this);
        as.CN().b(1136, (e) this);
    }

    protected final void initView() {
        this.kXn = (RelativeLayout) findViewById(R.h.bQA);
        this.kXo = (RelativeLayout) findViewById(R.h.bQH);
        this.kXp = (ImageView) findViewById(R.h.bQJ);
        this.kXq = (TextView) findViewById(R.h.bQK);
        this.kXr = (TextView) findViewById(R.h.bQF);
        this.kXs = (ImageView) findViewById(R.h.csd);
        this.kXt = (Button) findViewById(R.h.bQM);
        this.kXv = (TextView) findViewById(R.h.bQG);
        this.kXx = (TextView) findViewById(R.h.bQI);
        this.kXA = (RelativeLayout) findViewById(R.h.bQL);
        this.kXy = (ImageView) findViewById(R.h.bQE);
        this.kXz = (ImageView) findViewById(R.h.cKB);
        this.kXu = (LinearLayout) findViewById(R.h.cCg);
        this.kXw = (LinearLayout) findViewById(R.h.cKC);
        this.kXA.setOnClickListener(this);
        this.kXn.setOnClickListener(this);
        this.kXo.setOnClickListener(this);
        this.kXu.setOnClickListener(this);
        this.kXw.setOnClickListener(this);
        this.mController.contentView.setVisibility(8);
        this.tipDialog = h.a(this.mController.xRr, getString(R.l.ctG), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                if (CardGiftAcceptUI.this.tipDialog != null && CardGiftAcceptUI.this.tipDialog.isShowing()) {
                    CardGiftAcceptUI.this.tipDialog.dismiss();
                }
                x.i("MicroMsg.CardGiftAcceptUI", "user cancel & finish");
                CardGiftAcceptUI.this.finish();
            }
        });
        as.CN().a(new ag(this.hdY, this.hdZ, this.fBK), 0);
        if (this.tipDialog != null) {
            this.tipDialog.show();
        }
    }

    private static Drawable b(Drawable drawable, ColorStateList colorStateList) {
        Drawable h = android.support.v4.b.a.a.h(drawable);
        android.support.v4.b.a.a.a(h, colorStateList);
        return h;
    }

    private void cj(int i, int i2) {
        Drawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i2);
        gradientDrawable.setStroke(2, i);
        gradientDrawable.setCornerRadius(6.0f);
        this.kXt.setBackground(gradientDrawable);
    }

    public void onClick(View view) {
        if (view.getId() == R.h.bQM || view.getId() == R.h.cCg) {
            if (this.kXt.getVisibility() == 0) {
                int bc = bi.bc(this.kXB.kRU, getResources().getColor(R.e.brN));
                cj(bc, bc);
                this.kXt.setTextColor(getResources().getColor(R.e.white));
            }
            awB();
            if (!bi.oN(this.fGc)) {
                g.pWK.h(13866, Integer.valueOf(2), this.hdZ, o.getString(this.hdY), this.fGc);
            }
        } else if (view.getId() == R.h.bQL) {
            finish();
        } else if (view.getId() == R.h.bQA) {
            finish();
        } else if (view.getId() == R.h.cKC) {
            as.CN().a(new q(this.hdY, this.hdZ, this.fBK, Boolean.valueOf(true)), 0);
            if (this.tipDialog != null) {
                this.tipDialog.show();
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (i != 0 || i2 != 0) {
            if (this.tipDialog != null && this.tipDialog.isShowing()) {
                this.tipDialog.dismiss();
            }
            if (kVar instanceof ag) {
                x.e("MicroMsg.CardGiftAcceptUI", "NetSceneGetCardGiftInfo onSceneEnd fail, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                d.a(this, str, true);
            } else if (kVar instanceof q) {
                x.e("MicroMsg.CardGiftAcceptUI", "NetSceneGetCardGiftInfo onSceneEnd fail, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                d.a(this, str, true);
            }
        } else if (kVar instanceof ag) {
            this.kXB = (ag) kVar;
            x.i("MicroMsg.CardGiftAcceptUI", "ignore:%b", Boolean.valueOf(this.kXB.kRS));
            if (this.kXB.kRS) {
                x.i("MicroMsg.CardGiftAcceptUI", "NetScenePreAcceptGiftCard ignore is true~so ignore it");
                awB();
                return;
            }
            if (this.tipDialog != null && this.tipDialog.isShowing()) {
                this.tipDialog.dismiss();
            }
            if (this.kXB == null) {
                x.e("MicroMsg.CardGiftAcceptUI", "preAcceptGiftCard is null");
            } else {
                int fromDPToPix;
                MarginLayoutParams marginLayoutParams;
                this.kXr.setText(this.kXB.content);
                this.kXq.setText(i.b(this, this.kXB.fGc, this.kXq.getTextSize()));
                if (this.kXB.status == 0) {
                    if (bi.oN(this.kXB.kRR)) {
                        this.kXt.setVisibility(0);
                        this.kXt.setText(getResources().getString(R.l.dOs));
                        this.kXt.setOnClickListener(this);
                    } else {
                        this.kXt.setVisibility(0);
                        this.kXt.setText(this.kXB.kRR);
                        this.kXt.setOnClickListener(this);
                    }
                } else if (this.kXB.status == 1 || this.kXB.status != 2) {
                    this.kXt.setVisibility(8);
                    this.kXt.setOnClickListener(null);
                } else if (bi.oN(this.kXB.kRR)) {
                    this.kXt.setVisibility(8);
                    this.kXt.setOnClickListener(null);
                } else {
                    this.kXt.setVisibility(0);
                    this.kXt.setBackgroundDrawable(null);
                    this.kXt.setText(this.kXB.kRR);
                    this.kXt.setTextColor(getResources().getColor(R.e.black));
                    this.kXt.setTextSize(1, 17.0f);
                    this.kXt.setOnClickListener(null);
                }
                if (!bi.oN(this.kXB.kRV)) {
                    this.kXt.setVisibility(8);
                    this.kXw.setVisibility(8);
                    this.kXu.setVisibility(0);
                    this.kXv.setText(this.kXB.kRV);
                }
                if (!bi.oN(this.kXB.kRW)) {
                    this.kXu.setVisibility(8);
                    this.kXw.setVisibility(0);
                    this.kXx.setText(this.kXB.kRW);
                }
                if (!bi.oN(this.kXB.kRQ)) {
                    fromDPToPix = com.tencent.mm.bu.a.fromDPToPix(this, 15);
                    c.a aVar = new c.a();
                    aVar.hFo = com.tencent.mm.compatible.util.e.bnF;
                    com.tencent.mm.ap.o.PH();
                    aVar.hFH = null;
                    aVar.hFn = m.wQ(this.kXB.kRQ);
                    aVar.hFl = true;
                    aVar.hFJ = true;
                    aVar.hFK = (float) fromDPToPix;
                    aVar.hFj = true;
                    aVar.hFA = R.g.bDU;
                    com.tencent.mm.ap.o.PG().a(this.kXB.kRQ, this.kXp, aVar.PQ());
                }
                if (!bi.oN(this.kXB.kRT)) {
                    com.tencent.mm.ap.o.PG().a(this.kXB.kRT, this.kXs);
                }
                if (!bi.oN(this.kXB.kRU) && this.kXt.getVisibility() == 0) {
                    fromDPToPix = bi.bc(this.kXB.kRU, getResources().getColor(R.e.brN));
                    cj(fromDPToPix, getResources().getColor(R.e.brM));
                    this.kXt.setTextColor(fromDPToPix);
                }
                if (!bi.oN(this.kXB.kRU) && this.kXv.getVisibility() == 0) {
                    this.kXv.setTextColor(bi.bc(this.kXB.kRU, getResources().getColor(R.e.brN)));
                    fromDPToPix = getResources().getColor(R.e.brN);
                    if (!bi.oN(this.kXB.kRU)) {
                        fromDPToPix = bi.bc(this.kXB.kRU, fromDPToPix);
                    }
                    this.kXy.setImageDrawable(b(this.kXy.getDrawable(), ColorStateList.valueOf(fromDPToPix)));
                }
                if (!bi.oN(this.kXB.kRU) && this.kXx.getVisibility() == 0) {
                    this.kXx.setTextColor(bi.bc(this.kXB.kRU, getResources().getColor(R.e.brN)));
                    fromDPToPix = getResources().getColor(R.e.brN);
                    if (!bi.oN(this.kXB.kRU)) {
                        fromDPToPix = bi.bc(this.kXB.kRU, fromDPToPix);
                    }
                    this.kXz.setImageDrawable(b(this.kXz.getDrawable(), ColorStateList.valueOf(fromDPToPix)));
                    marginLayoutParams = (MarginLayoutParams) this.kXt.getLayoutParams();
                    marginLayoutParams.topMargin -= com.tencent.mm.bu.a.fromDPToPix(this, 20);
                    this.kXt.setLayoutParams(marginLayoutParams);
                }
                if (this.kXt.getVisibility() == 0 && this.kXw.getVisibility() == 8) {
                    marginLayoutParams = (MarginLayoutParams) this.kXt.getLayoutParams();
                    marginLayoutParams.bottomMargin += com.tencent.mm.bu.a.fromDPToPix(this, 28);
                    this.kXt.setLayoutParams(marginLayoutParams);
                }
            }
            View view = this.kXo;
            Animation scaleAnimation = new ScaleAnimation(0.0f, 0.96f, 0.0f, 0.96f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300);
            scaleAnimation.setInterpolator(new OvershootInterpolator());
            scaleAnimation.setFillAfter(true);
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.96f, 1.0f, 0.96f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(100);
            scaleAnimation2.setFillAfter(true);
            scaleAnimation.setAnimationListener(new AnonymousClass3(view, scaleAnimation2));
            if (view != null) {
                view.startAnimation(scaleAnimation);
            }
            this.mController.contentView.setVisibility(0);
        } else if (kVar instanceof q) {
            if (this.tipDialog != null && this.tipDialog.isShowing()) {
                this.tipDialog.dismiss();
            }
            x.i("MicroMsg.CardGiftAcceptUI", "accept gift card is success!");
            this.kXC = (q) kVar;
            Intent intent = new Intent(this, CardGiftReceiveUI.class);
            intent.putExtra("key_order_id", this.hdZ);
            intent.putExtra("key_biz_uin", this.hdY);
            intent.putExtra("key_gift_into", this.kXC.kRB);
            intent.putExtra("key_from_group_chat_room", !bi.oN(this.fBK));
            startActivity(intent);
            finish();
        }
    }

    private void awB() {
        as.CN().a(new q(this.hdY, this.hdZ, this.fBK, Boolean.valueOf(false)), 0);
        if (this.tipDialog != null) {
            this.tipDialog.show();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            x.e("MicroMsg.CardGiftAcceptUI", "onKeyDown finishUI");
            if (this.tipDialog != null && this.tipDialog.isShowing()) {
                this.tipDialog.dismiss();
            }
            finish();
        }
        return super.onKeyDown(i, keyEvent);
    }
}
