package com.tencent.mm.plugin.record.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.f.a.rv;
import com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public abstract class RecordMsgBaseUI extends BaseFavDetailReportUI {
    protected long frh = -1;
    protected ListView kLX = null;
    protected h pLN;

    protected abstract h bnE();

    protected abstract String bnF();

    protected abstract String bnG();

    protected abstract String bnH();

    protected abstract void bnI();

    protected abstract void c(int i, int i2, Intent intent);

    protected final int getLayoutId() {
        return R.i.dqJ;
    }

    protected final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        e.h(this);
        super.onCreate(bundle);
        bnD();
        e.i(this);
    }

    protected void bnD() {
        this.pLN = bnE();
        this.frh = getIntent().getLongExtra("message_id", -1);
        this.kLX = (ListView) findViewById(R.h.cHg);
        bnL();
        String bnG = bnG();
        String bnH = bnH();
        if (bi.oN(bnG) || bi.oN(bnH)) {
            x.i("MicroMsg.RecordMsgBaseUI", "subtitle time error!");
        } else {
            bnG = bnG.split(" ")[0];
            bnH = bnH.split(" ")[0];
            if (bnG.equals(bnH)) {
                this.pLN.pLH = false;
            } else {
                bnG = bnG + "~" + bnH;
                this.pLN.pLH = true;
            }
            setMMSubTitle(bnG);
        }
        View view = new View(this.mController.xRr);
        view.setLayoutParams(new LayoutParams(-1, getResources().getDimensionPixelSize(R.f.bvO)));
        this.kLX.addHeaderView(view, null, false);
        view = View.inflate(this.mController.xRr, R.i.dqI, null);
        this.kLX.setAdapter(this.pLN);
        this.pLN.Fv = this.kLX;
        this.pLN.bnJ();
        this.kLX.setOnScrollListener(new OnScrollListener() {
            public final void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    b rvVar = new rv();
                    rvVar.fKt.type = 5;
                    rvVar.fKt.fKu = RecordMsgBaseUI.this.kLX.getFirstVisiblePosition();
                    rvVar.fKt.fKv = RecordMsgBaseUI.this.kLX.getLastVisiblePosition();
                    rvVar.fKt.fKw = RecordMsgBaseUI.this.kLX.getHeaderViewsCount();
                    a.xmy.m(rvVar);
                }
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                RecordMsgBaseUI.this.finish();
                return true;
            }
        });
        bnI();
        this.kLX.postDelayed(new Runnable() {
            public final void run() {
                View childAt = RecordMsgBaseUI.this.kLX.getChildAt(RecordMsgBaseUI.this.kLX.getLastVisiblePosition());
                if (childAt != null) {
                    int bottom = childAt.getBottom();
                    int bottom2 = RecordMsgBaseUI.this.kLX.getBottom();
                    int fromDPToPix = com.tencent.mm.bu.a.fromDPToPix(RecordMsgBaseUI.this.mController.xRr, 64);
                    x.d("MicroMsg.RecordMsgBaseUI", "lastBotm %s, listBotm %s, listEndmargin %s", Integer.valueOf(bottom), Integer.valueOf(bottom2), Integer.valueOf(fromDPToPix));
                    if (bottom < bottom2 - fromDPToPix) {
                        x.d("MicroMsg.RecordMsgBaseUI", "offset %d", Integer.valueOf((bottom2 - bottom) - fromDPToPix));
                        view.setPadding(0, bottom, 0, 0);
                    }
                }
                RecordMsgBaseUI.this.kLX.addFooterView(view, null, false);
            }
        }, 100);
    }

    protected void onResume() {
        super.onResume();
        b rvVar = new rv();
        if (this.kLX != null) {
            rvVar.fKt.type = 0;
            rvVar.fKt.fKu = this.kLX.getFirstVisiblePosition();
            rvVar.fKt.fKv = this.kLX.getLastVisiblePosition();
            rvVar.fKt.fKw = this.kLX.getHeaderViewsCount();
            a.xmy.m(rvVar);
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.pLN != null) {
            h hVar = this.pLN;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= hVar.pLG.size()) {
                    break;
                }
                h.b bVar = (h.b) hVar.pLG.valueAt(i2);
                if (bVar != null) {
                    bVar.pause();
                }
                i = i2 + 1;
            }
        }
        b rvVar = new rv();
        rvVar.fKt.type = 1;
        a.xmy.m(rvVar);
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.pLN != null) {
            this.pLN.destroy();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        c(i, i2, intent);
    }

    protected final void bnL() {
        CharSequence bnF = bnF();
        String string = this.mController.xRr.getString(R.l.eei);
        if (bnF != null && bnF.endsWith(string) && bnF.lastIndexOf(string) > 0) {
            bnF = bnF.substring(0, bnF.lastIndexOf(string) - 1);
        }
        P(i.c(this.mController.xRr, bnF, getResources().getDimensionPixelSize(R.f.but)));
    }
}
