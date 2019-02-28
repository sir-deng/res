package com.tencent.mm.plugin.emoji.ui.v2;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ap.o;
import com.tencent.mm.f.a.ct;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.plugin.emoji.f.g;
import com.tencent.mm.plugin.emoji.model.h.b;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.RecommendView;
import com.tencent.mm.protocal.c.sx;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.ui.v;
import com.tencent.mm.y.as;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public class EmojiStoreV2SingleRecommendView extends RecommendView implements OnClickListener, b {
    private ViewGroup jKO;
    private String lEi;
    private g lFR;
    protected final int lGo = 131074;
    private final int lGp = 131075;
    private final int lGq = 131076;
    private final String lGr = "product_id";
    private final String lGs = "progress";
    private final String lGt = DownloadInfo.STATUS;
    private ImageView lIK;
    private String lJd;
    private ag lKV = new ag() {
        public final void handleMessage(Message message) {
            switch (message.what) {
                case 131075:
                    int i = message.getData().getInt("progress");
                    if (bi.oN(message.getData().getString("product_id"))) {
                        x.w("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "product id is null");
                        return;
                    }
                    if (EmojiStoreV2SingleRecommendView.this.lNB != null) {
                        EmojiStoreV2SingleRecommendView.this.lNB.setVisibility(8);
                    }
                    if (EmojiStoreV2SingleRecommendView.this.lNC != null) {
                        EmojiStoreV2SingleRecommendView.this.lNC.setVisibility(0);
                        EmojiStoreV2SingleRecommendView.this.lNC.setProgress(i);
                        return;
                    }
                    return;
                case 131076:
                    message.getData().getInt(DownloadInfo.STATUS);
                    if (bi.oN(message.getData().getString("product_id"))) {
                        x.w("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "product id is null");
                        return;
                    }
                    if (EmojiStoreV2SingleRecommendView.this.lNB != null) {
                        EmojiStoreV2SingleRecommendView.this.lNB.setVisibility(0);
                    }
                    if (EmojiStoreV2SingleRecommendView.this.lNC != null) {
                        EmojiStoreV2SingleRecommendView.this.lNC.setVisibility(8);
                        EmojiStoreV2SingleRecommendView.this.lNC.setProgress(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private TextView lNA;
    private Button lNB;
    private ProgressBar lNC;
    private EmojiGroupInfo lND;
    private boolean lNE = true;
    private c lNF = new c<ct>() {
        {
            this.xmG = ct.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            ct ctVar = (ct) bVar;
            if (ctVar instanceof ct) {
                EmojiStoreV2SingleRecommendView.this.lJd = ctVar.frP.frR;
                if (!bi.oN(ctVar.frP.frQ) && ctVar.frP.frQ.equalsIgnoreCase(EmojiStoreV2SingleRecommendView.this.lEi)) {
                    EmojiStoreV2SingleRecommendView emojiStoreV2SingleRecommendView = EmojiStoreV2SingleRecommendView.this;
                    String str = ctVar.frP.frQ;
                    int i = ctVar.frP.status;
                    int i2 = ctVar.frP.progress;
                    String str2 = ctVar.frP.frR;
                    x.d("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "[onExchange] productId:[%s] status:[%d] progress:[%d] cdnClientId:[%s]", str, Integer.valueOf(i), Integer.valueOf(i2), str2);
                    if (i == 6) {
                        Message obtain = Message.obtain();
                        obtain.getData().putString("product_id", str);
                        obtain.getData().putInt("progress", i2);
                        obtain.what = 131075;
                        emojiStoreV2SingleRecommendView.m(obtain);
                    } else {
                        x.i("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "product status:%d", Integer.valueOf(i));
                        Message obtain2 = Message.obtain();
                        obtain2.getData().putString("product_id", str);
                        obtain2.getData().putInt(DownloadInfo.STATUS, i);
                        obtain2.what = 131076;
                        emojiStoreV2SingleRecommendView.m(obtain2);
                    }
                }
            }
            return false;
        }
    };
    private ImageView lNy;
    private TextView lNz;

    public EmojiStoreV2SingleRecommendView(Context context, boolean z) {
        super(context);
        this.lNE = z;
        init();
    }

    public EmojiStoreV2SingleRecommendView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    @TargetApi(11)
    public EmojiStoreV2SingleRecommendView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        x.d("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "onAttachedToWindow");
        a.xmy.b(this.lNF);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        x.d("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "onDetachedFromWindow");
        a.xmy.c(this.lNF);
    }

    private void init() {
        if (this.lNE) {
            this.jKO = (ViewGroup) v.fw(getContext()).inflate(R.i.dgk, this);
        } else {
            this.jKO = (ViewGroup) v.fw(getContext()).inflate(R.i.dgl, this);
        }
        this.lIK = (ImageView) this.jKO.findViewById(R.h.cdq);
        this.lNy = (ImageView) this.jKO.findViewById(R.h.cdB);
        this.lNz = (TextView) this.jKO.findViewById(R.h.ceb);
        this.lNA = (TextView) this.jKO.findViewById(R.h.ced);
        this.lNB = (Button) this.jKO.findViewById(R.h.bBP);
        this.lNC = (ProgressBar) this.jKO.findViewById(R.h.cdx);
    }

    public final void zt(String str) {
        this.lEi = str;
        if (bi.oN(this.lEi)) {
            this.jKO.setVisibility(8);
            return;
        }
        this.lND = i.aCl().lCx.bg(this.lEi, false);
        this.lIK.setOnClickListener(this);
        this.lNB.setOnClickListener(this);
        this.jKO.setOnClickListener(this);
        EmojiGroupInfo emojiGroupInfo = this.lND;
        if (this.lNB != null) {
            switch (emojiGroupInfo.field_buttonType) {
                case 1:
                    this.lNB.setVisibility(0);
                    this.lNB.setText(R.l.eaF);
                    break;
                case 2:
                    this.lNB.setVisibility(0);
                    this.lNB.setText(R.l.evm);
                    break;
                default:
                    this.lNB.setVisibility(8);
                    break;
            }
        }
        if (!bi.oN(emojiGroupInfo.field_packName)) {
            this.lNz.setText(emojiGroupInfo.field_packName);
        }
        if (this.lNA != null) {
            if (bi.oN(emojiGroupInfo.field_recommandWord)) {
                this.lNA.setVisibility(8);
            } else {
                this.lNA.setVisibility(0);
                this.lNA.setText(emojiGroupInfo.field_recommandWord);
            }
        }
        this.lNC.setVisibility(8);
        o.PG().a(this.lND.field_BigIconUrl, this.lNy, f.c(this.lEi, this.lND.field_BigIconUrl, new Object[0]));
    }

    public final void J(String str, String str2, String str3) {
        as.CN().a(new g(str, str2, str3), 0);
    }

    public final void aCd() {
    }

    public final void m(Message message) {
        if (this.lKV != null) {
            this.lKV.sendMessage(message);
        }
    }

    private void c(sx sxVar) {
        Intent intent = new Intent();
        intent.setClass(getContext(), EmojiStoreDetailUI.class);
        intent.putExtra("extra_id", sxVar.vPI);
        intent.putExtra("extra_name", sxVar.whv);
        intent.putExtra("extra_copyright", sxVar.whF);
        intent.putExtra("extra_coverurl", sxVar.whD);
        intent.putExtra("extra_description", sxVar.whw);
        intent.putExtra("extra_price", sxVar.why);
        intent.putExtra("extra_type", sxVar.whz);
        intent.putExtra("extra_flag", sxVar.whA);
        intent.putExtra("extra_price_num", sxVar.whG);
        intent.putExtra("extra_price_type", sxVar.whH);
        intent.putExtra("preceding_scence", 108);
        intent.putExtra("call_by", 1);
        intent.putExtra("download_entrance_scene", 8);
        intent.putExtra("check_clickflag", false);
        getContext().startActivity(intent);
    }

    public void onClick(View view) {
        if (view == this.lIK) {
            i.aCl().lCx.Yx(this.lEi);
            com.tencent.mm.plugin.report.service.g.pWK.h(12068, Integer.valueOf(2), this.lEi, Integer.valueOf(this.lND.field_recommandType));
        } else if (view == this.jKO) {
            c(this.lND.ckN());
            com.tencent.mm.plugin.report.service.g.pWK.h(12068, Integer.valueOf(4), this.lEi, Integer.valueOf(this.lND.field_recommandType));
        } else if (view != this.lNB) {
            x.d("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "do nothing");
        } else if (this.lND.field_buttonType == 1) {
            this.lFR = new g(this.lEi);
            as.CN().a(this.lFR, 0);
            com.tencent.mm.plugin.report.service.g.pWK.h(12068, Integer.valueOf(3), this.lEi, Integer.valueOf(this.lND.field_recommandType));
            com.tencent.mm.plugin.report.service.g.pWK.h(12066, Integer.valueOf(0), Integer.valueOf(8), "", this.lEi);
        } else if (this.lND.field_buttonType == 2) {
            c(this.lND.ckN());
            com.tencent.mm.plugin.report.service.g.pWK.h(12068, Integer.valueOf(4), this.lEi, Integer.valueOf(this.lND.field_recommandType));
        } else {
            x.i("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "unknown buttonType do nothing.");
        }
    }
}
