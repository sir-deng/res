package com.tencent.mm.plugin.card.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.ap.o;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.model.CardGiftInfo;
import com.tencent.mm.plugin.card.model.CardGiftInfo.AcceptedCardItem;
import com.tencent.mm.plugin.card.model.CardGiftInfo.AccepterItem;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.model.t;
import com.tencent.mm.plugin.card.model.z;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.protocal.c.bmz;
import com.tencent.mm.protocal.c.kx;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.statusbar.DrawStatusBarActivity;
import com.tencent.mm.y.as;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class CardGiftReceiveUI extends DrawStatusBarActivity implements OnClickListener, e {
    private int hdY;
    private String hdZ;
    private CardGiftInfo kXE;
    private ProgressBar kXI;
    private ag kXJ = new ag(Looper.getMainLooper());
    private ScrollView kXU;
    private LinearLayout kXV;
    private ImageView kXW;
    private TextView kXX;
    private TextView kXY;
    private ImageView kXZ;
    private TextView kYA;
    private ListView kYB;
    private RelativeLayout kYC;
    private TextView kYD;
    private TextView kYE;
    private View kYF;
    com.tencent.mm.plugin.card.b.a.a kYG = new com.tencent.mm.plugin.card.b.a.a() {
        public final void aY(String str, int i) {
            if (CardGiftReceiveUI.this.kXE == null) {
                x.e("MicroMsg.CardGiftReceiveUI", "CDN  updateProgress cardGiftInfo is null return!");
            } else if (bi.oN(str) || bi.oN(CardGiftReceiveUI.this.kXE.kPT) || !str.equals(CardGiftReceiveUI.this.kXE.kPT)) {
                CardGiftReceiveUI.this.kXJ.post(new Runnable() {
                    public final void run() {
                        if (CardGiftReceiveUI.this.kXI.getVisibility() != 0) {
                            CardGiftReceiveUI.this.kXI.setVisibility(0);
                        }
                    }
                });
            } else {
                x.i("MicroMsg.CardGiftReceiveUI", "CDN  updateProgress fromUserContentVideoUrl return!");
            }
        }

        public final void fail(String str) {
            x.e("MicroMsg.CardGiftReceiveUI", "CDN download pic failure! fieldId:" + str);
        }

        public final void cb(final String str, final String str2) {
            x.i("MicroMsg.CardGiftReceiveUI", "CDN  download success! fieldId:" + str);
            if (CardGiftReceiveUI.this.kXE == null) {
                x.e("MicroMsg.CardGiftReceiveUI", "CDN  download cardGiftInfo is null return!");
            } else if (bi.oN(str) || bi.oN(CardGiftReceiveUI.this.kXE.kPT) || !str.equals(CardGiftReceiveUI.this.kXE.kPT)) {
                CardGiftReceiveUI.this.kXJ.post(new Runnable() {
                    public final void run() {
                        if (CardGiftReceiveUI.this.kXI.getVisibility() != 8) {
                            CardGiftReceiveUI.this.kXI.setVisibility(8);
                        }
                        if (bi.oN(str) || bi.oN(CardGiftReceiveUI.this.kXE.kPU) || !str.equals(CardGiftReceiveUI.this.kXE.kPU)) {
                            CardGiftReceiveUI.this.kYw.setVisibility(8);
                        } else {
                            CardGiftReceiveUI.this.kYw.setVisibility(0);
                        }
                        Bitmap oH = j.oH(str2);
                        if (oH == null) {
                            CardGiftReceiveUI.this.kYx.setImageResource(R.k.dyE);
                        } else {
                            CardGiftReceiveUI.this.kYx.setImageBitmap(oH);
                        }
                    }
                });
            } else {
                x.i("MicroMsg.CardGiftReceiveUI", "CDN  download fromUserContentVideoUrl! return");
            }
        }
    };
    private ImageView kYa;
    private LinearLayout kYb;
    private RelativeLayout kYc;
    private RelativeLayout kYd;
    private TextView kYe;
    private ImageView kYf;
    private TextView kYg;
    private TextView kYh;
    private TextView kYi;
    private ImageView kYj;
    private ImageView kYk;
    private View kYl;
    private TextView kYm;
    private LinearLayout kYn;
    private ListView kYo;
    private RelativeLayout kYp;
    private LinearLayout kYq;
    private ImageView kYr;
    private TextView kYs;
    private LinearLayout kYt;
    private TextView kYu;
    private RelativeLayout kYv;
    private RelativeLayout kYw;
    private ImageView kYx;
    private ImageView kYy;
    private TextView kYz;
    private r tipDialog = null;

    class c extends BaseAdapter {
        private LinkedList<AcceptedCardItem> kYM;

        public final /* synthetic */ Object getItem(int i) {
            return om(i);
        }

        c(LinkedList<AcceptedCardItem> linkedList) {
            this.kYM = linkedList;
        }

        public final int getCount() {
            return this.kYM.size();
        }

        private AcceptedCardItem om(int i) {
            return (AcceptedCardItem) this.kYM.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            d dVar;
            AcceptedCardItem om = om(i);
            if (view == null) {
                view = View.inflate(CardGiftReceiveUI.this, R.i.dcf, null);
                d dVar2 = new d();
                dVar2.jtn = (TextView) view.findViewById(R.h.cTj);
                dVar2.kYL = (TextView) view.findViewById(R.h.cTi);
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            dVar.jtn.setText(om.kQz);
            dVar.kYL.setText(om.kQA + CardGiftReceiveUI.this.mController.xRr.getString(R.l.dOv));
            return view;
        }
    }

    class a extends BaseAdapter {
        a() {
        }

        public final /* synthetic */ Object getItem(int i) {
            return (AccepterItem) CardGiftReceiveUI.this.kXE.kQu.get(i);
        }

        public final int getCount() {
            return CardGiftReceiveUI.this.kXE.kQu.size();
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            AccepterItem accepterItem = (AccepterItem) CardGiftReceiveUI.this.kXE.kQu.get(i);
            if (view == null) {
                view = View.inflate(CardGiftReceiveUI.this, R.i.dcg, null);
                b bVar2 = new b();
                bVar2.kYJ = (ImageView) view.findViewById(R.h.cpH);
                bVar2.kYK = (TextView) view.findViewById(R.h.cTf);
                bVar2.jtn = (TextView) view.findViewById(R.h.cTh);
                bVar2.kYL = (TextView) view.findViewById(R.h.cTg);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (accepterItem != null) {
                if (accepterItem.kQC != null) {
                    ImageView imageView = bVar.kYJ;
                    String str = accepterItem.kQC;
                    int i2 = R.g.bDU;
                    if (!(imageView == null || TextUtils.isEmpty(str))) {
                        if (TextUtils.isEmpty(str)) {
                            imageView.setImageResource(i2);
                        } else {
                            com.tencent.mm.ap.a.a.c.a aVar = new com.tencent.mm.ap.a.a.c.a();
                            aVar.hFo = com.tencent.mm.compatible.util.e.bnF;
                            o.PH();
                            aVar.hFH = null;
                            aVar.hFn = m.wQ(str);
                            aVar.hFl = true;
                            aVar.hFJ = true;
                            aVar.hFK = 3.0f;
                            aVar.hFj = true;
                            aVar.hFs = 34;
                            aVar.hFr = 34;
                            aVar.hFA = i2;
                            o.PG().a(str, imageView, aVar.PQ());
                        }
                    }
                }
                bVar.kYK.setText(accepterItem.kQB);
                bVar.jtn.setText(accepterItem.kQz);
                bVar.kYL.setText(accepterItem.kQA + CardGiftReceiveUI.this.mController.xRr.getString(R.l.dOv));
            }
            return view;
        }
    }

    class b {
        public TextView jtn;
        public ImageView kYJ;
        public TextView kYK;
        public TextView kYL;

        b() {
        }
    }

    class d {
        public TextView jtn;
        public TextView kYL;

        d() {
        }
    }

    static /* synthetic */ void a(CardGiftReceiveUI cardGiftReceiveUI, boolean z) {
        RelativeLayout relativeLayout = (RelativeLayout) View.inflate(cardGiftReceiveUI, R.i.dch, null);
        cardGiftReceiveUI.kYF = relativeLayout.findViewById(R.h.bOS);
        cardGiftReceiveUI.kYD = (TextView) relativeLayout.findViewById(R.h.cTp);
        cardGiftReceiveUI.kYE = (TextView) relativeLayout.findViewById(R.h.cTo);
        cardGiftReceiveUI.kYD.setOnClickListener(cardGiftReceiveUI);
        cardGiftReceiveUI.kYE.setOnClickListener(cardGiftReceiveUI);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        if (z) {
            if (cardGiftReceiveUI.kYC.getVisibility() == 0) {
                layoutParams.addRule(3, R.h.bIp);
            } else {
                layoutParams.addRule(3, R.h.bQD);
            }
            layoutParams.bottomMargin = cardGiftReceiveUI.I(30);
            layoutParams.topMargin = cardGiftReceiveUI.I(40);
        } else {
            layoutParams.addRule(12, -1);
            layoutParams.bottomMargin = cardGiftReceiveUI.I(30);
            layoutParams.topMargin = cardGiftReceiveUI.I(40);
        }
        LayoutParams layoutParams2;
        if (cardGiftReceiveUI.kYC.getVisibility() == 0) {
            layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
            if (cardGiftReceiveUI.kYv.getVisibility() == 0) {
                layoutParams2.topMargin = cardGiftReceiveUI.I(0);
                cardGiftReceiveUI.kYC.setLayoutParams(layoutParams2);
            } else {
                layoutParams2.topMargin = cardGiftReceiveUI.I(60);
            }
            cardGiftReceiveUI.kYC.setLayoutParams(layoutParams2);
            cardGiftReceiveUI.kYC.addView(relativeLayout, layoutParams);
        } else {
            layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
            layoutParams2.topMargin = cardGiftReceiveUI.I(60);
            cardGiftReceiveUI.kYp.setLayoutParams(layoutParams2);
            cardGiftReceiveUI.kYp.addView(relativeLayout, layoutParams);
        }
        if (bi.oN(cardGiftReceiveUI.kXE.kQp)) {
            cardGiftReceiveUI.kYD.setVisibility(8);
        } else {
            cardGiftReceiveUI.kYD.setVisibility(0);
            cardGiftReceiveUI.kYD.setText(cardGiftReceiveUI.kXE.kQp);
        }
        if (bi.oN(cardGiftReceiveUI.kXE.kQc)) {
            cardGiftReceiveUI.kYF.setVisibility(8);
            cardGiftReceiveUI.kYE.setVisibility(8);
        } else {
            cardGiftReceiveUI.kYF.setVisibility(0);
            cardGiftReceiveUI.kYE.setVisibility(0);
            cardGiftReceiveUI.kYE.setText(cardGiftReceiveUI.kXE.kQc);
        }
        if (bi.oN(cardGiftReceiveUI.kXE.kPR)) {
            cardGiftReceiveUI.kYp.setVisibility(8);
        }
    }

    protected final int getLayoutId() {
        return R.i.dcj;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hdZ = getIntent().getStringExtra("key_order_id");
        this.hdY = getIntent().getIntExtra("key_biz_uin", -1);
        this.kXE = (CardGiftInfo) getIntent().getParcelableExtra("key_gift_into");
        x.i("MicroMsg.CardGiftReceiveUI", "onCreate, orderId:%s, bizUin:%s", this.hdZ, Integer.valueOf(this.hdY));
        initView();
        as.CN().a(1165, (e) this);
        as.CN().a(699, (e) this);
        com.tencent.mm.plugin.card.b.a.a(this.kYG);
        if (this.kXE == null) {
            x.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo is null, sync GiftCard from serve");
            if (this.hdY == -1) {
                x.e("MicroMsg.CardGiftReceiveUI", "NetSceneGetCardGiftInfo, bizUin is -1, fail!");
                return;
            }
            if (this.hdZ == null) {
                x.e("MicroMsg.CardGiftReceiveUI", "NetSceneGetCardGiftInfo, orderId is null, fail");
            }
            x.e("MicroMsg.CardGiftReceiveUI", "doNetSceneGetCardGiftInfo");
            as.CN().a(new z(this.hdY, this.hdZ), 0);
            this.tipDialog = h.a(this.mController.xRr, getString(R.l.ctG), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    if (CardGiftReceiveUI.this.tipDialog != null && CardGiftReceiveUI.this.tipDialog.isShowing()) {
                        CardGiftReceiveUI.this.tipDialog.dismiss();
                    }
                    if (CardGiftReceiveUI.this.mController.contentView.getVisibility() == 8 || CardGiftReceiveUI.this.mController.contentView.getVisibility() == 4) {
                        x.i("MicroMsg.CardGiftReceiveUI", "user cancel & finish");
                        CardGiftReceiveUI.this.finish();
                    }
                }
            });
            if (this.tipDialog != null) {
                this.tipDialog.show();
                return;
            }
            return;
        }
        avH();
    }

    protected void onDestroy() {
        super.onDestroy();
        as.CN().b(1165, (e) this);
        as.CN().b(699, (e) this);
        com.tencent.mm.plugin.card.b.a.b(this.kYG);
    }

    private void avH() {
        if (this.kXE == null) {
            x.e("MicroMsg.CardGiftReceiveUI", "doUpdate due to cardGiftInfo is null!");
            return;
        }
        x.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.descLayoutMode:%d", Integer.valueOf(this.kXE.kQj));
        com.tencent.mm.ap.a.a.c.a aVar;
        if (this.kXE.kQj == 1 || this.kXE.kQj != 2) {
            this.kXV.setVisibility(8);
            this.kYb.setVisibility(0);
            this.kYg.setText(this.kXE.kQa);
            if (this.kXE.kQw == 1) {
                this.kYj.setAlpha(0.5f);
                this.kYh.setVisibility(8);
                this.kYi.setVisibility(8);
                this.kYd.setVisibility(8);
                this.kYc.setVisibility(8);
            } else {
                this.kYh.setVisibility(0);
                this.kYi.setVisibility(0);
                this.kYd.setVisibility(0);
                this.kYc.setVisibility(0);
                this.kYh.setText(this.kXE.kQb);
                this.kYi.setText(R.l.dOv);
                if (bi.oN(this.kXE.kQb)) {
                    this.kYh.setVisibility(8);
                    this.kYi.setVisibility(8);
                }
                if (bi.oN(this.kXE.kQn)) {
                    x.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.cardPriceTitleColor is empty");
                } else {
                    this.kYh.setTextColor(bi.bc(this.kXE.kQn, getResources().getColor(R.e.black)));
                }
            }
            if (bi.oN(this.kXE.kQi)) {
                this.kYf.setVisibility(8);
                x.i("MicroMsg.CardGiftReceiveUI", "descIconUrl is null");
            } else {
                this.kYf.setVisibility(0);
                aVar = new com.tencent.mm.ap.a.a.c.a();
                aVar.hFo = com.tencent.mm.compatible.util.e.bnF;
                o.PH();
                aVar.hFH = null;
                aVar.hFn = m.wQ(this.kXE.kQi);
                aVar.hFl = true;
                aVar.hFj = true;
                o.PG().a(this.kXE.kQi, this.kYf, aVar.PQ());
            }
            if (bi.oN(this.kXE.kQh)) {
                this.kYe.setVisibility(8);
                x.i("MicroMsg.CardGiftReceiveUI", "descIconUrl is null");
            } else {
                this.kYe.setVisibility(0);
                this.kYe.setText(this.kXE.kQh);
                if (bi.oN(this.kXE.kQl)) {
                    x.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.descriptionTitleColor is empty");
                } else {
                    this.kYe.setTextColor(bi.bc(this.kXE.kQl, getResources().getColor(R.e.black)));
                }
            }
            if (bi.oN(this.kXE.kQm)) {
                x.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.cardTitleColor is empty");
            } else {
                this.kYg.setTextColor(bi.bc(this.kXE.kQm, getResources().getColor(R.e.black)));
            }
            if (bi.oN(this.kXE.kPZ)) {
                x.i("MicroMsg.CardGiftReceiveUI", "cardLogoLUrl is null");
            } else {
                aVar = new com.tencent.mm.ap.a.a.c.a();
                aVar.hFo = com.tencent.mm.compatible.util.e.bnF;
                o.PH();
                aVar.hFH = null;
                aVar.hFn = m.wQ(this.kXE.kPZ);
                aVar.hFJ = true;
                aVar.hFl = true;
                aVar.hFj = true;
                aVar.hFB = new ColorDrawable(l.xu("#CCCCCC"));
                o.PG().a(this.kXE.kPZ, this.kYk, aVar.PQ());
            }
            if (bi.oN(this.kXE.kPY)) {
                x.i("MicroMsg.CardGiftReceiveUI", "cardBackgroundPicUrl is null");
            } else {
                aVar = new com.tencent.mm.ap.a.a.c.a();
                aVar.hFo = com.tencent.mm.compatible.util.e.bnF;
                o.PH();
                aVar.hFH = null;
                aVar.hFn = m.wQ(this.kXE.kPY);
                aVar.hFl = true;
                aVar.hFj = true;
                aVar.hFB = new ColorDrawable(l.xu("#CCCCCC"));
                aVar.hFJ = true;
                aVar.hFK = (float) com.tencent.mm.bu.a.fromDPToPix(this, 8);
                o.PG().a(this.kXE.kPY, this.kYj, aVar.PQ());
            }
        } else {
            this.kYb.setVisibility(8);
            this.kXV.setVisibility(0);
            this.kXX.setText(this.kXE.kQh);
            this.kXY.setText(this.kXE.kQa + "     " + this.kXE.kQb + this.mController.xRr.getString(R.l.dOv));
            if (bi.oN(this.kXE.kQi)) {
                this.kXW.setVisibility(8);
            } else {
                this.kXW.setVisibility(0);
                aVar = new com.tencent.mm.ap.a.a.c.a();
                aVar.hFo = com.tencent.mm.compatible.util.e.bnF;
                o.PH();
                aVar.hFH = null;
                aVar.hFn = m.wQ(this.kXE.kQi);
                aVar.hFl = true;
                aVar.hFj = true;
                o.PG().a(this.kXE.kQi, this.kXW, aVar.PQ());
            }
            if (bi.oN(this.kXE.kQl)) {
                x.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.descriptionTitleColor is empty");
            } else {
                this.kXX.setTextColor(bi.bc(this.kXE.kQl, getResources().getColor(R.e.black)));
            }
            if (bi.oN(this.kXE.kQm)) {
                x.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.cardTitleColor is empty");
            } else {
                this.kXY.setTextColor(bi.bc(this.kXE.kQm, getResources().getColor(R.e.black)));
            }
            if (bi.oN(this.kXE.kPZ)) {
                x.i("MicroMsg.CardGiftReceiveUI", "cardLogoLUrl is null");
            } else {
                aVar = new com.tencent.mm.ap.a.a.c.a();
                aVar.hFo = com.tencent.mm.compatible.util.e.bnF;
                o.PH();
                aVar.hFH = null;
                aVar.hFn = m.wQ(this.kXE.kPZ);
                aVar.hFJ = true;
                aVar.hFl = true;
                aVar.hFj = true;
                aVar.hFB = new ColorDrawable(l.xu("#CCCCCC"));
                o.PG().a(this.kXE.kPZ, this.kYa, aVar.PQ());
            }
            if (bi.oN(this.kXE.kPY)) {
                x.i("MicroMsg.CardGiftReceiveUI", "cardBackgroundPicUrl is null");
            } else {
                aVar = new com.tencent.mm.ap.a.a.c.a();
                aVar.hFo = com.tencent.mm.compatible.util.e.bnF;
                o.PH();
                aVar.hFH = null;
                aVar.hFn = m.wQ(this.kXE.kPY);
                aVar.hFl = true;
                aVar.hFj = true;
                aVar.hFB = new ColorDrawable(l.xu("#CCCCCC"));
                aVar.hFJ = true;
                aVar.hFK = (float) com.tencent.mm.bu.a.fromDPToPix(this, 8);
                o.PG().a(this.kXE.kPY, this.kXZ, aVar.PQ());
            }
        }
        if (this.kXE.kQw == 1) {
            this.kYq.setVisibility(0);
            this.kYt.setVisibility(8);
            this.kYp.setVisibility(8);
            this.kYs.setText(i.b(this, this.kXE.fGc, this.kYs.getTextSize()));
            a(this.kYr);
        } else {
            this.kYq.setVisibility(8);
            this.kYt.setVisibility(0);
            this.kYp.setVisibility(0);
            a(this.kYy);
            this.kYz.setText(i.b(this, this.kXE.fGc, this.kYz.getTextSize()));
            if ((bi.oN(this.kXE.kPS) || "undefined".equals(this.kXE.kPS)) && (bi.oN(this.kXE.kPT) || "undefined".equals(this.kXE.kPT))) {
                this.kYv.setVisibility(8);
                x.i("MicroMsg.CardGiftReceiveUI", "fromUserImgUrl is empty");
            } else {
                this.kYv.setVisibility(0);
            }
            if (this.kXE == null || bi.oN(this.kXE.kPS)) {
                x.e("MicroMsg.CardGiftReceiveUI", "fromUserContentPicUrl is null");
            } else {
                com.tencent.mm.plugin.card.b.a.h(this.kXE.kPS, this.kXE.kPV, this.kXE.kQe, 2);
            }
            if (this.kXE == null || bi.oN(this.kXE.kPU)) {
                x.e("MicroMsg.CardGiftReceiveUI", "fromUserContentThumbPicUrl is null");
            } else {
                com.tencent.mm.plugin.card.b.a.h(this.kXE.kPU, this.kXE.kPX, this.kXE.kQg, 2);
            }
            if (!bi.oN(this.kXE.kPR)) {
                this.kYu.setText(i.b(this, this.kXE.kPR, this.kYu.getTextSize()));
            }
        }
        avS();
        if (this.kXE.kQu.size() > 0) {
            this.kYC.setVisibility(0);
            this.kYB.setVisibility(0);
            this.kYB.setAdapter(new a());
            b(this.kYB);
            if (!bi.oN(this.kXE.kQv)) {
                this.kYA.setVisibility(0);
                this.kYA.setText(this.kXE.kQv);
            }
        } else {
            this.kYC.setVisibility(0);
            this.kYB.setVisibility(0);
            this.kYA.setVisibility(0);
            if (!bi.oN(this.kXE.kQv)) {
                this.kYA.setVisibility(0);
                this.kYA.setText(this.kXE.kQv);
            }
        }
        if (bi.oN(this.kXE.kQp) && bi.oN(this.kXE.kQc)) {
            this.kXU.setFillViewport(true);
        } else {
            this.kXU.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
                public final void onGlobalLayout() {
                    x.i("MicroMsg.CardGiftReceiveUI", "bottomHeight: %d  totalViewHeight:%d  screenHeight:%d ", Integer.valueOf(com.tencent.mm.bu.a.fromDPToPix(CardGiftReceiveUI.this.mController.xRr, 67)), Integer.valueOf(CardGiftReceiveUI.this.kXU.getChildAt(0).getHeight() + com.tencent.mm.bu.a.fromDPToPix(CardGiftReceiveUI.this.mController.xRr, 67)), Integer.valueOf(CardGiftReceiveUI.this.getWindow().findViewById(16908290).getHeight()));
                    CardGiftReceiveUI.this.kXU.setFillViewport(true);
                    if (CardGiftReceiveUI.this.kXU.getChildAt(0).getHeight() + com.tencent.mm.bu.a.fromDPToPix(CardGiftReceiveUI.this.mController.xRr, 67) > CardGiftReceiveUI.this.getWindow().findViewById(16908290).getHeight()) {
                        CardGiftReceiveUI.a(CardGiftReceiveUI.this, true);
                    } else {
                        CardGiftReceiveUI.a(CardGiftReceiveUI.this, false);
                    }
                    CardGiftReceiveUI.this.kXU.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            });
        }
    }

    private int I(int i) {
        return com.tencent.mm.bu.a.fromDPToPix(this.mController.xRr, i);
    }

    private void a(ImageView imageView) {
        if (bi.oN(this.kXE.kPQ)) {
            x.i("MicroMsg.CardGiftReceiveUI", "fromUserImgUrl is null");
            return;
        }
        int fromDPToPix = com.tencent.mm.bu.a.fromDPToPix(this, 20);
        com.tencent.mm.ap.a.a.c.a aVar = new com.tencent.mm.ap.a.a.c.a();
        aVar.hFo = com.tencent.mm.compatible.util.e.bnF;
        o.PH();
        aVar.hFH = null;
        aVar.hFn = m.wQ(this.kXE.kPQ);
        aVar.hFl = true;
        aVar.hFJ = true;
        aVar.hFK = 3.0f;
        aVar.hFj = true;
        aVar.hFs = fromDPToPix;
        aVar.hFr = fromDPToPix;
        aVar.hFB = new ColorDrawable(l.xu("#CCCCCC"));
        o.PG().a(this.kXE.kPQ, imageView, aVar.PQ());
    }

    private void avS() {
        int i = 0;
        if (this.kXE.kQt.size() > 0) {
            this.kYl.setVisibility(0);
            this.kYo.setVisibility(8);
            if (this.kXE.kQt.size() <= 2) {
                this.kYm.setVisibility(8);
                G(this.kXE.kQt);
                return;
            }
            LinkedList linkedList = new LinkedList();
            linkedList.add(this.kXE.kQt.get(0));
            linkedList.add(this.kXE.kQt.get(1));
            G(linkedList);
            this.kYm.setVisibility(0);
            this.kYm.setOnClickListener(this);
            linkedList = new LinkedList();
            while (i < this.kXE.kQt.size()) {
                if (!(i == 0 || i == 1)) {
                    linkedList.add(this.kXE.kQt.get(i));
                }
                i++;
            }
            this.kYo.setAdapter(new c(linkedList));
            b(this.kYo);
            return;
        }
        this.kYl.setVisibility(8);
        this.kYm.setVisibility(8);
        this.kYo.setVisibility(8);
    }

    private void G(LinkedList<AcceptedCardItem> linkedList) {
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            AcceptedCardItem acceptedCardItem = (AcceptedCardItem) it.next();
            View inflate = View.inflate(this, R.i.dcf, null);
            TextView textView = (TextView) inflate.findViewById(R.h.cTi);
            ((TextView) inflate.findViewById(R.h.cTj)).setText(acceptedCardItem.kQz);
            textView.setText(acceptedCardItem.kQA + this.mController.xRr.getString(R.l.dOv));
            this.kYn.addView(inflate);
        }
    }

    private static void b(ListView listView) {
        ListAdapter adapter = listView.getAdapter();
        if (adapter != null) {
            int count = adapter.getCount();
            int i = 0;
            for (int i2 = 0; i2 < count; i2++) {
                View view = adapter.getView(i2, null, listView);
                view.measure(0, 0);
                i += view.getMeasuredHeight();
            }
            LayoutParams layoutParams = listView.getLayoutParams();
            layoutParams.height = (listView.getDividerHeight() * (adapter.getCount() - 1)) + i;
            listView.setLayoutParams(layoutParams);
        }
    }

    protected final void initView() {
        this.kXU = (ScrollView) findViewById(R.h.bQN);
        this.kXV = (LinearLayout) findViewById(R.h.bSp);
        this.kXW = (ImageView) findViewById(R.h.csh);
        this.kXX = (TextView) findViewById(R.h.cTB);
        this.kXY = (TextView) findViewById(R.h.cTA);
        this.kXZ = (ImageView) findViewById(R.h.csf);
        this.kYa = (ImageView) findViewById(R.h.csg);
        this.kXZ.setOnClickListener(this);
        this.kYb = (LinearLayout) findViewById(R.h.bSo);
        this.kYc = (RelativeLayout) findViewById(R.h.bMP);
        this.kYd = (RelativeLayout) findViewById(R.h.bMR);
        this.kYe = (TextView) findViewById(R.h.cTm);
        this.kYg = (TextView) findViewById(R.h.cTz);
        this.kYf = (ImageView) findViewById(R.h.cse);
        this.kYh = (TextView) findViewById(R.h.cTD);
        this.kYi = (TextView) findViewById(R.h.cTE);
        this.kYj = (ImageView) findViewById(R.h.crZ);
        this.kYk = (ImageView) findViewById(R.h.csa);
        this.kYj.setOnClickListener(this);
        this.kYl = findViewById(R.h.bRo);
        this.kYm = (TextView) findViewById(R.h.cTC);
        this.kYn = (LinearLayout) findViewById(R.h.bRn);
        this.kYo = (ListView) findViewById(R.h.bRp);
        this.kYp = (RelativeLayout) findViewById(R.h.bQC);
        this.kYq = (LinearLayout) findViewById(R.h.cnK);
        this.kYr = (ImageView) findViewById(R.h.csc);
        this.kYs = (TextView) findViewById(R.h.cTs);
        this.kYt = (LinearLayout) findViewById(R.h.cnJ);
        this.kYy = (ImageView) findViewById(R.h.csb);
        this.kYz = (TextView) findViewById(R.h.cTr);
        this.kYu = (TextView) findViewById(R.h.cTq);
        this.kYv = (RelativeLayout) findViewById(R.h.bRa);
        this.kYw = (RelativeLayout) findViewById(R.h.cpI);
        this.kYx = (ImageView) findViewById(R.h.cTt);
        this.kYv.setOnClickListener(this);
        this.kYw.setOnClickListener(this);
        this.kYA = (TextView) findViewById(R.h.cTe);
        this.kYB = (ListView) findViewById(R.h.bIp);
        this.kYC = (RelativeLayout) findViewById(R.h.bQB);
        this.kXI = (ProgressBar) findViewById(R.h.cpr);
        com.tencent.mm.plugin.card.b.m.b((MMActivity) this, false);
        com.tencent.mm.ui.statusbar.a.d(this.mController.contentView, -1, true);
        setMMTitle("");
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                CardGiftReceiveUI.this.finish();
                return true;
            }
        });
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        if (i == 0 && i2 == 0) {
            if (kVar instanceof z) {
                x.i("MicroMsg.CardGiftReceiveUI", "card gift info cgi success!");
                this.kXE = ((z) kVar).kRB;
                avH();
            } else if (kVar instanceof t) {
                Intent intent = new Intent(this, CardDetailUI.class);
                LinkedList linkedList = ((t) kVar).kRF;
                if (linkedList == null || linkedList.size() == 0) {
                    x.e("MicroMsg.CardGiftReceiveUI", "NetSceneBatchGetCardItemByTpInfo resp cardinfo list  size is null or empty!");
                    return;
                }
                com.tencent.mm.plugin.card.base.b bVar = (com.tencent.mm.plugin.card.base.b) linkedList.get(0);
                if (bVar == null || !(bVar instanceof CardInfo)) {
                    x.e("MicroMsg.CardGiftReceiveUI", "NetSceneBatchGetCardItemByTpInfo resp cardInfo  is null!");
                    return;
                }
                ArrayList arrayList = new ArrayList();
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    arrayList.add((CardInfo) it.next());
                }
                intent.putExtra("key_card_info", (CardInfo) bVar);
                intent.putExtra("key_previous_scene", 27);
                intent.putExtra("key_from_scene", 27);
                intent.putExtra("key_from_appbrand_type", intent.getIntExtra("key_from_appbrand_type", 0));
                intent.putExtra("key_card_git_info", this.kXE);
                startActivity(intent);
            }
        } else if (kVar instanceof z) {
            x.e("MicroMsg.CardGiftReceiveUI", "NetSceneGetCardGiftInfo onSceneEnd fail, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
            com.tencent.mm.plugin.card.b.d.a(this, str, true);
        } else if (kVar instanceof t) {
            x.e("MicroMsg.CardGiftReceiveUI", ", NetSceneBatchGetCardItemByTpInfo onSceneEnd fail return!  errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        }
    }

    public void onClick(View view) {
        Intent intent;
        if (view.getId() == R.h.cpI) {
            if (!bi.oN(this.kXE.kPT)) {
                intent = new Intent(this, CardGiftVideoUI.class);
                intent.putExtra("key_gift_into", this.kXE);
                intent.putExtra("key_is_mute", false);
                startActivity(intent);
                overridePendingTransition(0, 0);
                g.pWK.h(13866, Integer.valueOf(3), this.hdZ, com.tencent.mm.a.o.getString(this.hdY));
            }
        } else if (view.getId() == R.h.bRa) {
            if (this.kXI.getVisibility() != 0 && !bi.oN(this.kXE.kPS)) {
                intent = new Intent(this, CardGiftImageUI.class);
                intent.putExtra("key_gift_into", this.kXE);
                startActivity(intent);
                overridePendingTransition(0, 0);
                g.pWK.h(13866, Integer.valueOf(4), this.hdZ, com.tencent.mm.a.o.getString(this.hdY));
            }
        } else if (view.getId() == R.h.cTo) {
            if (this.kXE != null && this.kXE.kQd) {
                g.pWK.h(13866, Integer.valueOf(7), this.hdZ, com.tencent.mm.a.o.getString(this.hdY));
                intent = new Intent(this, CardHomePageUI.class);
                intent.putExtra("key_home_page_from_scene", 2);
                startActivity(intent);
                x.i("MicroMsg.CardGiftReceiveUI", "enter to cardhome");
                finish();
                overridePendingTransition(0, 0);
            }
        } else if (view.getId() == R.h.cTp) {
            if (!TextUtils.isEmpty(this.kXE.kQx) && !TextUtils.isEmpty(this.kXE.kQy)) {
                com.tencent.mm.plugin.card.b.b.d(this.kXE.kQo, this.kXE.kQx, this.kXE.kQy, 1062, getIntent().getIntExtra("key_from_appbrand_type", 0));
                g.pWK.h(13866, Integer.valueOf(8), this.hdZ, com.tencent.mm.a.o.getString(this.hdY));
            } else if (!bi.oN(this.kXE.kQq)) {
                com.tencent.mm.plugin.card.b.b.a((MMActivity) this, this.kXE.kQq, 0);
                g.pWK.h(13866, Integer.valueOf(8), this.hdZ, com.tencent.mm.a.o.getString(this.hdY));
            }
        } else if (view.getId() == R.h.crZ || view.getId() == R.h.csf) {
            if (bi.oN(this.kXE.kQr) || bi.oN(this.kXE.kQs)) {
                x.e("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.userCardId is null");
                return;
            }
            LinkedList linkedList = new LinkedList();
            kx kxVar = new kx();
            kxVar.kPy = this.kXE.kQr;
            kxVar.code = this.kXE.kQs;
            linkedList.add(kxVar);
            String stringExtra = getIntent().getStringExtra("key_template_id");
            bmz bmz = new bmz();
            bmz.wWW = stringExtra;
            x.i("MicroMsg.CardGiftReceiveUI", "doBatchGetCardItemByTpInfo templateId:%s", stringExtra);
            as.CN().a(new t(linkedList, bmz, 27), 0);
            g.pWK.h(13866, Integer.valueOf(9), this.hdZ, com.tencent.mm.a.o.getString(this.hdY));
        } else if (view.getId() != R.h.cTC) {
        } else {
            if (this.kYo.getVisibility() == 0) {
                this.kYo.setVisibility(8);
                this.kYm.setText("查看全部");
                return;
            }
            this.kYo.setVisibility(0);
            this.kYm.setText("收起");
        }
    }
}
