package com.tencent.mm.ui.chatting.b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.ay.n;
import com.tencent.mm.ay.r;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;

public final class b {
    p fhH;
    private Bitmap yHm;
    private ImageView yHn;
    public final a yHo = new a() {
        public final void a(String str, l lVar) {
            x.d("MicroMsg.ChattingUI.BackgroundImp", "onBGChange event:%s", str);
            if (str == null) {
                return;
            }
            if (str.equals(b.this.fhH.csn()) || str.equals("*")) {
                b.this.bTe();
            }
        }
    };

    public b(p pVar) {
        this.fhH = pVar;
    }

    public final void ctU() {
        if (this.yHm != null) {
            x.i("MicroMsg.ChattingUI.BackgroundImp", "recycle bitmap:%s", this.yHm.toString());
            this.yHm.recycle();
        }
    }

    private int ctV() {
        return this.fhH.cte().thisResources().getColor(R.e.brR);
    }

    public final void bTe() {
        if (this.fhH.ctm() == null) {
            x.e("MicroMsg.ChattingUI.BackgroundImp", "initBackground, adapter is not initialized properly");
            return;
        }
        int intValue;
        com.tencent.mm.ay.a lP = r.QP().lP(this.fhH.csW().field_username);
        if (lP == null) {
            as.Hm();
            intValue = ((Integer) c.Db().get(12311, Integer.valueOf(-2))).intValue();
        } else {
            intValue = lP.hKZ;
        }
        if (intValue == -2) {
            setBackgroundColor(ctV());
            if (this.fhH.ctm() == null) {
                this.fhH.cte().finish();
                return;
            } else {
                this.fhH.ctm().bw(this.fhH.cte().getContext(), "chatting/purecolor_chat.xml");
                return;
            }
        }
        r.QO();
        int bn = n.bn(this.fhH.cte().getContext());
        if (intValue == 0) {
            switch (bn) {
                case 1:
                case 2:
                case 3:
                case 4:
                    intValue = R.g.bAZ;
                    break;
                default:
                    intValue = -1;
                    break;
            }
            if (intValue != -1) {
                ctU();
                try {
                    this.yHm = BitmapFactory.decodeResource(this.fhH.cte().getMMResources(), intValue);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.Crash", e, "May cause dvmFindCatchBlock crash!", new Object[0]);
                    throw ((IncompatibleClassChangeError) new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(e));
                } catch (Throwable th) {
                }
                if (this.yHm == null) {
                    x.e("MicroMsg.ChattingUI.BackgroundImp", "setBackground decodeFile fail, bm is null, resId = " + intValue);
                    setBackgroundColor(this.fhH.cte().getMMResources().getColor(R.e.brR));
                } else {
                    if (this.yHn == null) {
                        this.yHn = (ImageView) this.fhH.cte().findViewById(R.h.bTB);
                    }
                    this.yHn.setImageBitmap(this.yHm);
                }
                this.fhH.ctm().bw(this.fhH.cte().getContext(), "chatting/reserved_chat.xml");
                return;
            }
            return;
        }
        String str;
        n QO = r.QO();
        if (intValue > 0) {
            this.fhH.ctm().ZH(QO.bh(intValue, 1) + "chat.xml");
            switch (bn) {
                case 1:
                    str = QO.bh(intValue, 1) + "horizontal_hdpi.jpg";
                    break;
                case 2:
                    str = QO.bh(intValue, 1) + "horizontal_ldpi.jpg";
                    break;
                case 3:
                    str = QO.bh(intValue, 1) + "vertical_hdpi.jpg";
                    break;
                case 4:
                    str = QO.bh(intValue, 1) + "vertical_ldpi.jpg";
                    break;
                default:
                    str = null;
                    break;
            }
        }
        this.fhH.ctm().bw(this.fhH.cte().getContext(), "chatting/default_chat.xml");
        str = lP == null ? QO.Q("default", bn) : QO.Q(this.fhH.csn(), bn);
        ctU();
        this.yHm = j.oH(str);
        if (this.yHm == null) {
            x.e("MicroMsg.ChattingUI.BackgroundImp", "setBackground decodeFile fail, bm is null, path = " + str);
            setBackgroundColor(ctV());
            return;
        }
        if (this.yHn == null) {
            this.yHn = (ImageView) this.fhH.cte().findViewById(R.h.bTB);
        }
        this.yHn.setImageBitmap(this.yHm);
    }

    private void setBackgroundColor(int i) {
        ctU();
        if (this.yHn == null) {
            View findViewById = this.fhH.cte().findViewById(R.h.bTC);
            if (findViewById != null) {
                findViewById.setBackgroundColor(i);
                return;
            }
            return;
        }
        this.yHn.setImageDrawable(new ColorDrawable(i));
    }
}
