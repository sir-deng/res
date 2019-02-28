package com.tencent.mm.plugin.card.a;

import android.text.TextUtils;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.model.b;
import com.tencent.mm.protocal.c.kr;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.y.s;
import java.util.ArrayList;
import java.util.List;

public final class f {
    public int kKY = 3;
    public b kOA;
    public ArrayList<kr> kOB;
    public com.tencent.mm.plugin.card.base.b kOv;
    public List<b> kOz = new ArrayList();
    public MMActivity kgL;

    public f(MMActivity mMActivity) {
        this.kgL = mMActivity;
    }

    public final b auH() {
        boolean z;
        b bVar = new b();
        bVar.kPL = 1;
        if (l.oq(this.kKY) || l.or(this.kKY) || this.kKY == 23) {
            if (!(!this.kOv.isAcceptable() || this.kOv.aui().vZg == null || TextUtils.isEmpty(this.kOv.aui().vZg.text) || TextUtils.isEmpty(this.kOv.aui().vYJ))) {
                z = true;
            }
            z = false;
        } else {
            if (!(this.kKY != 6 || !this.kOv.auf() || this.kOv.aui().vZg == null || TextUtils.isEmpty(this.kOv.aui().vZg.text) || TextUtils.isEmpty(this.kOv.aui().vYJ))) {
                z = true;
            }
            z = false;
        }
        bVar.kPN = z;
        if (!bVar.kPN && !TextUtils.isEmpty(this.kOv.aui().vYZ)) {
            bVar.title = this.kOv.aui().vYZ;
        } else if (s.gH(this.kOv.aui().vYJ)) {
            bVar.title = getString(R.l.dOV);
            bVar.kPN = false;
        } else {
            bVar.title = getString(R.l.dOU);
            if (this.kOv.aui().vZg == null || this.kOv.aui().vZg.wnE != 1) {
                bVar.kPO = false;
            } else {
                bVar.kPO = true;
            }
        }
        if (!TextUtils.isEmpty(this.kOv.aui().vZb)) {
            bVar.kPB = this.kOv.aui().vZb;
        }
        bVar.kTd = "";
        bVar.url = "card://jump_service";
        this.kOA = bVar;
        return this.kOA;
    }

    public final String getTitle() {
        StringBuilder stringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty(this.kOv.aui().kQK)) {
            stringBuilder.append(this.kOv.aui().kQK);
        } else if (this.kOv.atP()) {
            stringBuilder.append(getString(R.l.dcw));
        } else if (this.kOv.atQ()) {
            stringBuilder.append(getString(R.l.dbZ));
        } else if (this.kOv.atR()) {
            stringBuilder.append(getString(R.l.dNU));
        } else if (this.kOv.atS()) {
            stringBuilder.append(getString(R.l.dOn));
        } else if (this.kOv.atT()) {
            stringBuilder.append(getString(R.l.dco));
        }
        return stringBuilder.toString();
    }

    public final String getString(int i) {
        return this.kgL.getString(i);
    }
}
