package com.tencent.mm.plugin.fav.ui.detail;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelstat.f;
import com.tencent.mm.plugin.fav.a.g.a;
import com.tencent.mm.plugin.fav.a.r;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMLoadScrollView;

public abstract class BaseFavDetailReportUI extends MMActivity {
    public a muu = new a();
    protected boolean muv;
    private String muw = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.muu.scene = getIntent().getIntExtra("key_detail_fav_scene", 0);
        this.muu.mtU = getIntent().getIntExtra("key_detail_fav_sub_scene", 0);
        this.muu.index = getIntent().getIntExtra("key_detail_fav_index", 0);
        MMLoadScrollView aIS = aIS();
        if (aIS != null) {
            aIS.zCX = new MMLoadScrollView.a() {
                public final void aEc() {
                    BaseFavDetailReportUI.this.muu.mtT = true;
                }
            };
        }
        if (this.muu.scene == 0) {
            x.i("MicroMsg.Fav.BaseFavDetailReportUI", "report object scene is 0");
        }
    }

    public MMLoadScrollView aIS() {
        return null;
    }

    public void onResume() {
        super.onResume();
        if (bi.oN(this.muw)) {
            this.muw = f.Tb().hTi;
        }
        x.v("MicroMsg.Fav.BaseFavDetailReportUI", "onResume firstResumeClassname[%s]", this.muw);
    }

    public void onPause() {
        this.muu.mtK = cnN();
        String str = f.Tb().hTi;
        if (!(bi.fA(getClass().getName(), str) || bi.fA(str, this.muw))) {
            a aVar = this.muu;
            long j = aVar.mtL;
            f Tb = f.Tb();
            aVar.mtL = (Tb.hTh != null ? ((Long) Tb.hTh.get(f.Tb().hTi)).longValue() : 0) + j;
        }
        x.v("MicroMsg.Fav.BaseFavDetailReportUI", "onPause lastClassname[%s] detailPeriod[%d] subDetailPeriod[%d]", str, Long.valueOf(this.muu.mtK), Long.valueOf(this.muu.mtL));
        super.onPause();
    }

    public final void h(com.tencent.mm.plugin.fav.a.f fVar) {
        if (fVar != null && this.muu.scene > 0) {
            this.muu.mtI = (long) fVar.field_id;
            this.muu.type = fVar.field_type;
            this.muu.cPf = fVar.field_sourceType;
            this.muu.timestamp = fVar.field_sourceCreateTime / 1000;
            if (this.muu.timestamp == 0) {
                this.muu.timestamp = fVar.field_updateTime / 1000;
            }
            if (this.muu.timestamp == 0) {
                this.muu.timestamp = fVar.field_edittime;
            }
            this.muu.mtJ = i(fVar);
            this.muv = true;
        }
    }

    public final void dg(long j) {
        com.tencent.mm.plugin.fav.a.f dc = ((r) g.k(r.class)).getFavItemInfoStorage().dc(j);
        if (dc != null) {
            h(dc);
        }
    }

    public void onDestroy() {
        if (this.muv) {
            com.tencent.mm.plugin.fav.a.g.a(this.muu);
        }
        setResult(-1, getIntent().putExtra("key_activity_browse_time", cnN()));
        super.onDestroy();
    }

    public String i(com.tencent.mm.plugin.fav.a.f fVar) {
        return "0";
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1 && intent != null) {
            long longExtra = intent.getLongExtra("key_activity_browse_time", 0);
            a aVar = this.muu;
            aVar.mtL += longExtra;
            x.v("MicroMsg.Fav.BaseFavDetailReportUI", "onActivityResult subDetailPeriod[%d] subUIBrowserTime[%d]", Long.valueOf(this.muu.mtL), Long.valueOf(longExtra));
        }
        super.onActivityResult(i, i2, intent);
    }
}
