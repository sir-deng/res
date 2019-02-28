package com.tencent.mm.plugin.card.ui.view;

import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.br.a.a;
import com.tencent.mm.plugin.card.b.c;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.plugin.card.b.p;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.ui.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public abstract class g extends i {
    String code;
    private Bitmap iqd;
    protected b kOv;
    private OnLongClickListener kTB = new OnLongClickListener() {
        public final boolean onLongClick(View view) {
            if (view.getId() == R.h.bWE) {
                p.I(g.this.kgL, g.this.kOv.auj().code);
                h.bu(g.this.kgL, g.this.getString(R.l.dEE));
            }
            return false;
        }
    };
    private Bitmap kTs;
    private j kWQ;
    MMActivity kgL;
    private ViewGroup lce;
    private ab lcf;
    private ViewStub lcg;

    public abstract ab axI();

    public abstract ab axJ();

    public abstract ab axK();

    public abstract String e(c cVar);

    public abstract boolean h(b bVar);

    public final void initView() {
        this.kgL = this.lcl.aws();
        this.kWQ = this.lcl.awy();
        this.kOv = this.lcl.awp();
        if (this.kOv == null) {
            x.e("MicroMsg.CardBaseCodeView", "initView failure! cardInfo is null!");
            return;
        }
        switch (this.kOv.auj().vYi) {
            case 0:
                this.lcf = axK();
                break;
            case 1:
                this.lcf = axJ();
                break;
            case 2:
                this.lcf = axI();
                break;
            default:
                this.lcf = axI();
                break;
        }
        if (this.lcf == null) {
            x.e("MicroMsg.CardBaseCodeView", "iniView failure! codeContainer is null!");
            return;
        }
        switch (this.kOv.auj().vYi) {
            case 0:
                if (this.lcg == null) {
                    this.lcg = (ViewStub) findViewById(R.h.bQg);
                    break;
                }
                break;
            case 1:
                if (this.lcg == null) {
                    this.lcg = (ViewStub) findViewById(R.h.bPJ);
                    break;
                }
                break;
            case 2:
                if (this.lcg == null) {
                    this.lcg = (ViewStub) findViewById(R.h.bRO);
                    break;
                }
                break;
            default:
                if (this.lcg == null) {
                    this.lcg = (ViewStub) findViewById(R.h.bRO);
                    break;
                }
                break;
        }
        if (this.lcg == null) {
            x.e("MicroMsg.CardBaseCodeView", "initTargetView failure! viewStub is null!");
        } else if (this.lcf == null) {
            x.e("MicroMsg.CardBaseCodeView", "iniView failure! codeContainer is null!");
        } else if (this.lcf.getLayoutId() == 0) {
            x.e("MicroMsg.CardBaseCodeView", "initTargetView failure! codeContainer.getLayoutId()  is 0!");
        } else {
            this.lcg.setLayoutResource(this.lcf.getLayoutId());
            if (this.lce == null) {
                this.lce = (ViewGroup) this.lcg.inflate();
            }
        }
        if (this.lce == null) {
            x.e("MicroMsg.CardBaseCodeView", "iniView failure! targetView is null!");
        }
    }

    public final void d(b bVar) {
        if (bVar == null) {
            x.e("MicroMsg.CardBaseCodeView", "updateCardInfo failure! mCardInfo is null!");
        } else {
            this.kOv = bVar;
        }
    }

    public final void destroy() {
        super.destroy();
        this.kgL = null;
        this.kWQ = null;
        this.kOv = null;
        this.lce = null;
        this.lcf = null;
        l.u(this.iqd);
        l.u(this.kTs);
    }

    public final void update() {
        if (this.kOv == null) {
            x.e("MicroMsg.CardBaseCodeView", "update  failure! mCardInfo is null!");
        } else if (this.lcf == null) {
            x.e("MicroMsg.CardBaseCodeView", "update failure! codeContainer is null!");
        } else if (this.lce == null) {
            x.e("MicroMsg.CardBaseCodeView", "update failure! targetView is null!");
        } else {
            this.kWQ.awN();
            d(c.CARDCODEREFRESHACTION_ENTERCHANGE);
            this.lcf.c(this.lce, this.kOv);
        }
    }

    public final void d(c cVar) {
        int i = 1;
        if (this.kOv == null) {
            x.e("MicroMsg.CardBaseCodeView", "updateCodeView getCode mCardInfo  is null ! cannot show code view");
        } else if (cVar == null) {
            x.e("MicroMsg.CardBaseCodeView", "updateCodeView failure!refreshReason is null!");
        } else if (this.lcf.i(this.kOv)) {
            this.lcf.d(this.lce);
            x.i("MicroMsg.CardBaseCodeView", "updateCodeView from refreshReason = %s", Integer.valueOf(cVar.action));
            this.code = e(cVar);
            if (com.tencent.pb.common.c.g.Bf(this.code)) {
                x.e("MicroMsg.CardBaseCodeView", "updateCodeView getCode is empty! cannot show code view");
                return;
            }
            View view;
            String str;
            ImageView imageView;
            switch (this.kOv.auj().vYi) {
                case 0:
                    view = this.lce;
                    str = this.code;
                    TextView textView = (TextView) view.findViewById(R.h.bWE);
                    textView.setText(m.xC(str));
                    textView.setOnLongClickListener(this.kTB);
                    String str2 = this.kOv.aui().hdx;
                    if (!com.tencent.pb.common.c.g.Bf(str2)) {
                        textView.setTextColor(l.xu(str2));
                    }
                    if (str.length() <= 12) {
                        textView.setTextSize(1, 33.0f);
                        return;
                    } else if (str.length() > 12 && str.length() <= 16) {
                        textView.setTextSize(1, 30.0f);
                        return;
                    } else if (str.length() > 16 && str.length() <= 20) {
                        textView.setTextSize(1, 24.0f);
                        return;
                    } else if (str.length() > 20 && str.length() <= 40) {
                        textView.setTextSize(1, 18.0f);
                        return;
                    } else if (str.length() > 40) {
                        textView.setVisibility(8);
                        return;
                    } else {
                        return;
                    }
                case 1:
                    view = this.lce;
                    String str3 = this.code;
                    try {
                        imageView = (ImageView) view.findViewById(R.h.bWo);
                        l.u(this.kTs);
                        if (str3 != null && str3.length() > 0) {
                            this.kTs = a.b(this.kgL, str3, 5, 0);
                        }
                        a(imageView, this.kTs);
                        imageView.setOnClickListener(this.lcl.awt());
                        this.kWQ.kTs = this.kTs;
                        return;
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.CardBaseCodeView", e, "", new Object[0]);
                        return;
                    }
                case 2:
                    view = this.lce;
                    str = this.code;
                    try {
                        imageView = (ImageView) view.findViewById(R.h.bWx);
                        l.u(this.iqd);
                        if (!(this.kOv == null || this.kOv.aui() == null)) {
                            i = this.kOv.aui().vZt;
                        }
                        this.iqd = a.b(this.kgL, str, 0, i);
                        a(imageView, this.iqd);
                        imageView.setOnClickListener(this.lcl.awt());
                        this.kWQ.iqd = this.iqd;
                        j jVar = this.kWQ;
                        if (jVar.iqe != null && jVar.iqe.isShowing()) {
                            jVar.iqf.setImageBitmap(jVar.iqd);
                            return;
                        }
                        return;
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.CardBaseCodeView", e2, "", new Object[0]);
                        return;
                    }
                default:
                    return;
            }
        } else {
            x.e("MicroMsg.CardBaseCodeView", "updateCodeView failure! can not get qrcode! refreshReason = %s", Integer.valueOf(cVar.action));
            axG();
        }
    }

    public final void axG() {
        if (this.lcf != null && this.kOv != null && this.lce != null) {
            this.lcf.a(this.lce, this.kOv);
        }
    }

    public final void axH() {
        if (this.kOv == null || this.lcf == null || this.lce == null) {
            x.e("MicroMsg.CardBaseCodeView", "onScreenShot is error! mCardInfo or codeContainer or targetView is null ");
            return;
        }
        this.lcf.b(this.lce, this.kOv);
        if (this.kOv.auj().vYi == 2 && this.kWQ != null) {
            j jVar = this.kWQ;
            if (jVar.iqe != null && jVar.iqe.isShowing()) {
                jVar.iqe.dismiss();
            }
        }
    }

    public final void axD() {
        if (this.lce != null) {
            this.lce.setVisibility(8);
        }
    }

    private static void a(ImageView imageView, Bitmap bitmap) {
        if (imageView != null && bitmap != null) {
            imageView.setImageBitmap(bitmap);
        }
    }
}
