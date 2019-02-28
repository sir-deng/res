package com.tencent.mm.plugin.sns.ui;

import android.widget.ListView;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

public final class bi {
    ListView nQn;
    int position = -1;
    public int rFH = -1;
    int rHd = -1;
    int rSQ = -1;
    int rSR = -1;
    public int rSS = 0;
    boolean rST = false;
    int rSU;
    protected long rSV;
    Runnable rSW = new Runnable() {
        public final void run() {
            if (bi.this.nQn != null && bi.this.nQn.getCount() > bi.this.position) {
                int i;
                int top = bi.this.rxz.getTop();
                x.d("MicroMsg.TimeLineScrollAnimation", "limitCount: " + bi.this.rSU + " footerHeight:" + bi.this.rxz.getHeight() + " listOriginalBottom: " + bi.this.rFH);
                if (bi.this.rSU = bi.this.rSU - 1 > 0 && (bi.this.rHd != top || top > bi.this.rFH - 200 || bi.this.nQn.getBottom() > (bi.this.rFH - bi.this.rxz.getHeight()) - 150)) {
                    i = 10;
                    if (bi.this.rSU == 0) {
                        i = 200;
                    }
                    new ag().postDelayed(this, (long) i);
                }
                bi.this.rHd = top;
                i = (bi.this.rHd - bi.this.rSS) - bi.this.rSQ;
                x.d("MicroMsg.TimeLineScrollAnimation", "itemH:" + bi.this.rSQ + " footerTop" + bi.this.rHd + " list.bottom:" + bi.this.nQn.getBottom() + " position: " + bi.this.position + " topselection: " + i);
                x.d("MicroMsg.TimeLineScrollAnimation", "list.getTop(): " + bi.this.nQn.getTop() + " marginTop: " + bi.this.rSS + " footerTop " + bi.this.rHd);
                bi.this.nQn.setSelectionFromTop(bi.this.position + bi.this.nQn.getHeaderViewsCount(), i);
            }
        }
    };
    Runnable rSX = new Runnable() {
        int offset = 0;

        public final void run() {
            if (bi.this.nQn != null && bi.this.nQn.getCount() > bi.this.position) {
                bi.this.rHd = bi.this.rxz.getTop();
                int i = (bi.this.rHd - bi.this.rSS) - bi.this.rSQ;
                x.d("MicroMsg.TimeLineScrollAnimation", "itemH:" + bi.this.rSQ + " footerTop" + bi.this.rHd + " list.bottom:" + bi.this.nQn.getBottom() + " position: " + bi.this.position + " topselection: " + i);
                x.d("MicroMsg.TimeLineScrollAnimation", "list.getTop(): " + bi.this.nQn.getTop() + " marginTop: " + bi.this.rSS + " footerTop " + bi.this.rHd);
                if (i == this.offset) {
                    bi.this.nQn.setSelectionFromTop(bi.this.position + bi.this.nQn.getHeaderViewsCount(), i);
                    this.offset = 0;
                    bi.this.rSU = 0;
                } else if (bi.this.rSU = bi.this.rSU - 1 > 0) {
                    new ag().postDelayed(this, 100);
                    this.offset = i;
                } else {
                    this.offset = 0;
                    bi.this.rSU = 0;
                }
            }
        }
    };
    Runnable rSY = new Runnable() {
        public final void run() {
            x.d("MicroMsg.TimeLineScrollAnimation", "originalTop:" + bi.this.rSR + " position:" + bi.this.position + " list.bottom:" + bi.this.nQn.getBottom());
        }
    };
    SnsCommentFooter rxz;

    public bi(ListView listView, SnsCommentFooter snsCommentFooter) {
        this.nQn = listView;
        this.rxz = snsCommentFooter;
    }

    public final void bCU() {
        this.rST = true;
        new ag().postDelayed(this.rSW, 30);
        this.rSU = 10;
        x.e("MicroMsg.TimeLineScrollAnimation", "footerTop when up :" + this.rxz.getTop());
        this.rSV = com.tencent.mm.sdk.platformtools.bi.Wz();
    }

    public final void bCV() {
        this.rST = true;
        this.rSU = 20;
        new ag().postDelayed(this.rSX, 100);
    }

    public final void bCW() {
        if (this.rST) {
            this.rST = false;
            new ag().postDelayed(this.rSY, 30);
            this.rSU = 10;
        }
    }
}
