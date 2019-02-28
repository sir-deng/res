package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import org.json.JSONArray;
import org.json.JSONObject;

public final class q extends a {
    private h rpe;
    LinearLayout rqx;

    public q(Context context, r rVar, ViewGroup viewGroup) {
        super(context, rVar, viewGroup);
    }

    public final void bxr() {
        super.bxr();
        for (i bxr : this.rpe.byr()) {
            bxr.bxr();
        }
    }

    public final void X(int i, int i2, int i3) {
        super.X(i, i2, i3);
        for (i X : this.rpe.byr()) {
            X.X(i, i2, i3);
        }
    }

    public final void bxs() {
        super.bxs();
        for (i bxs : this.rpe.byr()) {
            bxs.bxs();
        }
    }

    public final void bxq() {
        super.bxq();
        for (i bxq : this.rpe.byr()) {
            bxq.bxq();
        }
    }

    protected final void bxK() {
        if (((r) this.rpm).rmM == 0) {
            this.rqx.setOrientation(1);
        } else if (((r) this.rpm).rmM == 1) {
            this.rqx.setOrientation(0);
        }
        if (this.rpe == null) {
            this.rpe = new h(((r) this.rpm).rmL, this.context, ((r) this.rpm).bgColor, this.rqx);
            this.rpe.layout();
            return;
        }
        this.rpe.bR(((r) this.rpm).rmL);
    }

    public final View bxG() {
        View view = this.contentView;
        this.rqx = (LinearLayout) view.findViewById(f.qJM);
        return view;
    }

    protected final int bkr() {
        return g.qMT;
    }

    public final boolean s(JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        if (super.T(jSONObject)) {
            jSONArray.put(jSONObject);
        }
        for (i iVar : this.rpe.byr()) {
            JSONObject jSONObject2 = new JSONObject();
            if (iVar != null && iVar.T(jSONObject2)) {
                jSONArray.put(jSONObject2);
            }
        }
        return true;
    }
}
