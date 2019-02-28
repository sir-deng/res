package com.tencent.mm.plugin.card.ui.a;

import android.text.TextUtils;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.y.q;

public class a implements g {
    protected b kOv;
    protected com.tencent.mm.plugin.card.ui.e.a kWZ;
    protected MMActivity kgL;
    boolean lbI = false;
    private boolean lbJ = false;
    private boolean lbK = false;
    private boolean lbL = false;
    private boolean lbM = false;
    private boolean lbN = false;
    private boolean lbO = false;
    private boolean lbP = false;
    private boolean lbQ = false;
    private boolean lbR = false;

    public a(MMActivity mMActivity) {
        this.kgL = mMActivity;
    }

    public final void a(b bVar, com.tencent.mm.plugin.card.ui.e.a aVar) {
        this.kOv = bVar;
        this.kWZ = aVar;
        axb();
    }

    public final void release() {
        this.kOv = null;
        this.kWZ = null;
        this.kgL = null;
    }

    public final String awV() {
        String str = "";
        if (!TextUtils.isEmpty(this.kOv.aui().vZk)) {
            return this.kOv.aui().vZk;
        }
        if (this.kOv.auj().vYk == 0) {
            return getString(R.l.dPb);
        }
        if (this.kOv.auj().vYl != 0) {
            return str;
        }
        if (TextUtils.isEmpty(this.kOv.aui().vYR)) {
            return getString(R.l.dNJ);
        }
        return this.kOv.aui().vYR;
    }

    private String getString(int i) {
        return this.kgL.getString(i);
    }

    public final boolean awW() {
        if (this.kOv.auj().status == 0 || this.kOv.auj().status == 1 || this.kOv.auj().status == 2) {
            return true;
        }
        return false;
    }

    public final boolean awX() {
        return this.kWZ.kKY == 3 || ((this.kWZ.kKY == 6 && this.kOv.auj().vYh == 0) || this.kWZ.kKY == 4 || this.kWZ.kKY == 5 || this.kWZ.kKY == 15);
    }

    private boolean awY() {
        return !TextUtils.isEmpty(this.kOv.auj().code);
    }

    protected final boolean awZ() {
        return !this.kOv.isAcceptable() && (l.oq(this.kWZ.kKY) || l.or(this.kWZ.kKY) || this.kWZ.kKY == 23);
    }

    protected final boolean axa() {
        return !this.kOv.auf() && this.kWZ.kKY == 6;
    }

    protected void axb() {
        x.i("MicroMsg.CardBaseShowLogic", "updateAcceptState()");
        if (l.oq(this.kWZ.kKY) || l.or(this.kWZ.kKY)) {
            if (this.kOv.isAcceptable()) {
                this.lbJ = true;
                this.lbK = true;
                this.lbP = true;
                this.lbN = true;
                this.lbO = true;
            } else if (this.kOv.isAcceptable()) {
                this.lbJ = false;
                this.lbK = false;
                this.lbN = false;
            } else {
                this.lbJ = true;
                this.lbK = false;
                if (this.kOv.aud()) {
                    this.lbQ = true;
                    this.lbN = true;
                    this.lbM = true;
                } else {
                    this.lbN = false;
                }
                this.lbO = true;
            }
        } else if (this.kWZ.kKY == 6) {
            if (this.kOv.auf()) {
                this.lbJ = true;
                this.lbK = true;
                this.lbN = false;
            } else if (this.kOv.aue()) {
                this.lbQ = true;
                this.lbN = true;
                this.lbL = true;
                this.lbM = true;
            } else {
                this.lbJ = false;
                this.lbK = false;
                this.lbN = false;
                this.lbL = true;
            }
        } else if (l.os(this.kWZ.kKY)) {
            this.lbJ = false;
            this.lbK = false;
            this.lbL = true;
            if (this.kOv.aue()) {
                this.lbQ = true;
                this.lbN = true;
                this.lbM = true;
            } else {
                this.lbR = true;
            }
        } else if (this.kWZ.kKY == 23) {
            if (this.kOv.isAcceptable()) {
                this.lbJ = true;
                this.lbK = true;
                this.lbN = false;
                this.lbO = true;
            } else {
                this.lbJ = true;
                this.lbK = false;
                this.lbN = false;
                this.lbO = true;
            }
            if (!(TextUtils.isEmpty(this.kWZ.kWh) || this.kWZ.kWh.equals(q.FY()) || this.kOv.auh())) {
                x.i("MicroMsg.CardBaseShowLogic", " detail page");
                this.lbJ = false;
                this.lbK = false;
                this.lbL = true;
                if (this.kOv.aue()) {
                    this.lbQ = true;
                    this.lbN = true;
                    this.lbM = true;
                }
            }
        }
        if (this.kOv.aud()) {
            this.lbJ = false;
            this.lbK = false;
            x.i("MicroMsg.CardBaseShowLogic", "need direct jump!");
        } else {
            x.i("MicroMsg.CardBaseShowLogic", "not need direct jump!");
        }
        if (this.lbI) {
            this.lbJ = false;
            this.lbK = false;
            x.i("MicroMsg.CardBaseShowLogic", "updateAcceptView to gone!");
        } else if (this.lbJ) {
            this.lbI = false;
            x.i("MicroMsg.CardBaseShowLogic", "set mIsAcceptedCard is false!");
        } else {
            this.lbI = true;
            x.i("MicroMsg.CardBaseShowLogic", "set mIsAcceptedCard is true");
        }
        x.i("MicroMsg.CardBaseShowLogic", "mIsAcceptedCard:" + this.lbI);
    }

    public final boolean awA() {
        return this.lbI;
    }

    public boolean axc() {
        return this.lbJ;
    }

    public final boolean axd() {
        return this.lbK;
    }

    public final boolean axe() {
        return this.lbL;
    }

    public final boolean axf() {
        return this.lbM;
    }

    public final boolean axg() {
        return this.lbN;
    }

    public final boolean axh() {
        return this.lbP;
    }

    public final boolean axi() {
        return this.lbQ;
    }

    public final boolean axj() {
        return this.lbR;
    }

    public boolean axk() {
        return true;
    }

    public boolean axl() {
        return false;
    }

    public boolean axm() {
        return false;
    }

    public boolean axn() {
        return (this.kWZ.kKY == 6 && (!this.kOv.aue() || this.kOv.auf())) || this.kWZ.kKY == 5 || (this.kWZ.kKY == 23 && this.kOv.auh());
    }

    public boolean axo() {
        return false;
    }

    public boolean axp() {
        return true;
    }

    public boolean axq() {
        return (awY() && awW() && awX()) || this.lbI;
    }

    public boolean axr() {
        return false;
    }

    public boolean axs() {
        return !this.kOv.aue();
    }

    public boolean axt() {
        return (this.kOv.aui().vZe == null || this.kOv.aui().vZe.wge == null || this.kOv.aui().vZe.wge.size() <= 0 || TextUtils.isEmpty((CharSequence) this.kOv.aui().vZe.wge.get(0))) ? false : true;
    }

    public boolean axu() {
        if (this.kOv.auj().vYj == null || this.kOv.auj().vYj.size() <= 0 || ((!awW() || !awX()) && !this.lbI)) {
            return false;
        }
        return true;
    }

    public boolean axv() {
        return false;
    }

    public final boolean axw() {
        return (this.kOv.auj().vYn == null || TextUtils.isEmpty(this.kOv.auj().vYn.title)) ? false : true;
    }

    public boolean axx() {
        return (this.kOv.auj().vYq == null || TextUtils.isEmpty(this.kOv.auj().vYq.title)) ? false : true;
    }

    public boolean axy() {
        return this.kOv.aui().vZa != null;
    }

    public boolean axz() {
        if (TextUtils.isEmpty(this.kOv.aui().vYX)) {
            return false;
        }
        return true;
    }

    public boolean axA() {
        return false;
    }

    public boolean axB() {
        return false;
    }

    public final void axC() {
        int i;
        int i2 = 1;
        String str = "MicroMsg.CardBaseShowLogic";
        String str2 = "printStatus, isValidCode:%d, getUnacceptWording:%s, isAcceptedCard:%d, acceptViewVisible:%d, acceptViewEnabled:%d, isShowConsumedBtn:%d, isConsumedBtnEnabled:%d, enableOptionMenu:%d, isShareLogoVisible:%d, addShareMenu:%d, addMenu:%d, addInvalidCardMenu:%d ";
        Object[] objArr = new Object[12];
        if (awY()) {
            i = 1;
        } else {
            i = 0;
        }
        objArr[0] = Integer.valueOf(i);
        objArr[1] = awV();
        objArr[2] = Integer.valueOf(this.lbI ? 1 : 0);
        objArr[3] = Integer.valueOf(axc() ? 1 : 0);
        objArr[4] = Integer.valueOf(this.lbK ? 1 : 0);
        objArr[5] = Integer.valueOf(this.lbL ? 1 : 0);
        objArr[6] = Integer.valueOf(this.lbM ? 1 : 0);
        objArr[7] = Integer.valueOf(this.lbN ? 1 : 0);
        objArr[8] = Integer.valueOf(this.lbO ? 1 : 0);
        objArr[9] = Integer.valueOf(this.lbP ? 1 : 0);
        objArr[10] = Integer.valueOf(this.lbQ ? 1 : 0);
        if (!this.lbR) {
            i2 = 0;
        }
        objArr[11] = Integer.valueOf(i2);
        x.i(str, str2, objArr);
    }
}
