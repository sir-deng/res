package com.tencent.mm.plugin.card.sharecard.ui;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.plugin.card.b.p;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.q;

public final class a {
    private final String TAG = "MicroMsg.CardConsumeCodeController";
    Bitmap iqd;
    OnClickListener iqi = new OnClickListener() {
        public final void onClick(View view) {
            if (view.getId() != R.h.cBu) {
                return;
            }
            if (a.this.kTv.isChecked()) {
                if (a.this.kTz != null) {
                    a.this.kTz.of(1);
                }
            } else if (a.this.kTz != null) {
                a.this.kTz.of(0);
            }
        }
    };
    b kOv;
    float kTA = 0.0f;
    private OnLongClickListener kTB = new OnLongClickListener() {
        public final boolean onLongClick(View view) {
            if (view.getId() == R.h.bWE) {
                p.I(a.this.kgL, a.this.kOv.auj().code);
                h.bu(a.this.kgL, a.this.kgL.getString(R.l.dEE));
            }
            return false;
        }
    };
    View kTo;
    private View kTp;
    private View kTq;
    private View kTr;
    Bitmap kTs;
    TextView kTt;
    TextView kTu;
    CheckBox kTv;
    String kTw;
    int kTx = 1;
    boolean kTy = false;
    a kTz;
    MMActivity kgL;

    public interface a {
        void of(int i);
    }

    public a(MMActivity mMActivity, View view) {
        this.kgL = mMActivity;
        this.kTo = view;
    }

    final void ae(float f) {
        LayoutParams attributes = this.kgL.getWindow().getAttributes();
        attributes.screenBrightness = f;
        this.kgL.getWindow().setAttributes(attributes);
    }

    public final void avH() {
        x.i("MicroMsg.CardConsumeCodeController", "doUpdate()");
        if (this.kTy) {
            String str;
            ImageView imageView;
            if (!bi.oN(this.kOv.auj().vYv)) {
                x.i("MicroMsg.CardConsumeCodeController", "code:%s from sign_number", this.kOv.auj().vYv);
                str = r0;
            } else if (this.kOv.auc()) {
                x.i("MicroMsg.CardConsumeCodeController", "code:%s from dynamic code", am.avu().getCode());
                str = r0;
            } else {
                x.i("MicroMsg.CardConsumeCodeController", "code:%s from dataInfo", this.kOv.auj().code);
                str = r0;
            }
            View view;
            TextView textView;
            switch (this.kOv.auj().vYi) {
                case 0:
                    if (this.kTr == null) {
                        this.kTr = ((ViewStub) this.kTo.findViewById(R.h.bQh)).inflate();
                    }
                    TextView textView2 = (TextView) this.kTr.findViewById(R.h.bWE);
                    textView2.setText(m.xC(str));
                    textView2.setOnLongClickListener(this.kTB);
                    if (!this.kOv.atP()) {
                        textView2.setTextColor(l.xu(this.kOv.aui().hdx));
                    }
                    if (str.length() <= 12) {
                        textView2.setTextSize(1, 33.0f);
                    } else if (str.length() > 12 && str.length() <= 16) {
                        textView2.setTextSize(1, 30.0f);
                    } else if (str.length() > 16 && str.length() <= 20) {
                        textView2.setTextSize(1, 24.0f);
                    } else if (str.length() > 20 && str.length() <= 40) {
                        textView2.setTextSize(1, 18.0f);
                    } else if (str.length() > 40) {
                        textView2.setVisibility(8);
                    }
                    cj(this.kTr);
                    break;
                case 1:
                    if (this.kTq == null) {
                        this.kTq = ((ViewStub) this.kTo.findViewById(R.h.bQb)).inflate();
                    }
                    view = this.kTq;
                    imageView = (ImageView) view.findViewById(R.h.bWo);
                    textView = (TextView) view.findViewById(R.h.bWE);
                    if (!this.kOv.atP()) {
                        textView.setTextColor(l.xu(this.kOv.aui().hdx));
                    }
                    if (TextUtils.isEmpty(str) || str.length() > 40) {
                        textView.setVisibility(8);
                    } else {
                        textView.setText(m.xC(str));
                        if (this.kOv.atY()) {
                            textView.setVisibility(0);
                            textView.setOnLongClickListener(this.kTB);
                        } else {
                            textView.setVisibility(8);
                        }
                    }
                    if (this.kTx != 1) {
                        textView.setVisibility(4);
                    }
                    try {
                        l.u(this.kTs);
                        if (TextUtils.isEmpty(str)) {
                            this.kTs = null;
                            imageView.setImageBitmap(this.kTs);
                        } else {
                            this.kTs = com.tencent.mm.br.a.a.b(this.kgL, str, 5, 0);
                            a(imageView, this.kTs);
                        }
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.CardConsumeCodeController", e, "", new Object[0]);
                    }
                    cj(this.kTq);
                    break;
                case 2:
                    if (this.kTp == null) {
                        this.kTp = ((ViewStub) this.kTo.findViewById(R.h.bQf)).inflate();
                    }
                    view = this.kTp;
                    imageView = (ImageView) view.findViewById(R.h.bWx);
                    textView = (TextView) view.findViewById(R.h.bWE);
                    if (!this.kOv.atP()) {
                        textView.setTextColor(l.xu(this.kOv.aui().hdx));
                    }
                    if (str.length() <= 40) {
                        textView.setText(m.xC(str));
                        if (this.kOv.atY()) {
                            textView.setVisibility(0);
                            textView.setOnLongClickListener(this.kTB);
                        } else {
                            textView.setVisibility(8);
                        }
                    } else {
                        textView.setVisibility(8);
                    }
                    if (this.kTx != 1) {
                        textView.setVisibility(4);
                    }
                    try {
                        l.u(this.iqd);
                        if (TextUtils.isEmpty(str)) {
                            this.iqd = null;
                            imageView.setImageBitmap(this.iqd);
                        } else {
                            this.iqd = com.tencent.mm.br.a.a.b(this.kgL, str, 0, 3);
                            a(imageView, this.iqd);
                        }
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.CardConsumeCodeController", e2, "", new Object[0]);
                    }
                    cj(this.kTp);
                    break;
            }
            if (bi.oN(this.kOv.aui().loF)) {
                this.kTt.setVisibility(8);
                this.kTu.setVisibility(8);
            } else if (this.kOv.aui().vZq != null) {
                this.kTu.setText(this.kOv.aui().loF);
                this.kTu.setVisibility(0);
                this.kTt.setVisibility(8);
                if (this.kTp != null) {
                    imageView = (ImageView) this.kTp.findViewById(R.h.bWx);
                    ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                    layoutParams.height = com.tencent.mm.bu.a.fromDPToPix(this.kgL, 180);
                    layoutParams.width = com.tencent.mm.bu.a.fromDPToPix(this.kgL, 180);
                    imageView.setLayoutParams(layoutParams);
                }
            } else {
                this.kTt.setText(this.kOv.aui().loF);
                this.kTt.setVisibility(0);
            }
            if (!this.kOv.atO() || TextUtils.isEmpty(this.kOv.auo()) || this.kOv.auo().equals(q.FY())) {
                this.kTv.setChecked(false);
                this.kTv.setVisibility(8);
                return;
            }
            this.kTv.setVisibility(0);
            this.kTv.setText(i.f(this.kgL, " " + this.kgL.getString(R.l.dOd, new Object[]{l.xx(this.kOv.auo())}), this.kgL.getResources().getDimensionPixelOffset(R.f.bvV)));
            return;
        }
        x.i("MicroMsg.CardConsumeCodeController", "doUpdate() not ready show!");
    }

    private void a(ImageView imageView, Bitmap bitmap) {
        if (imageView != null && bitmap != null && !bitmap.isRecycled()) {
            imageView.setImageBitmap(bitmap);
            if (this.kTx != 1) {
                imageView.setAlpha(10);
            } else {
                imageView.setAlpha(255);
            }
        }
    }

    private void cj(View view) {
        Button button = (Button) view.findViewById(R.h.bWw);
        if (this.kTx == 1) {
            button.setVisibility(8);
        } else {
            button.setVisibility(0);
        }
        if (this.kTx == -1) {
            button.setText(R.l.dON);
        }
    }
}
