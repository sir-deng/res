package com.tencent.mm.plugin.card.ui.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.protocal.c.oy;
import com.tencent.mm.protocal.c.rj;
import java.util.LinkedList;

public final class l extends i {
    View lcn;
    LinearLayout lco;
    boolean lcp = false;

    public final void initView() {
    }

    public final void update() {
        if (this.lcn == null) {
            this.lcn = ((ViewStub) findViewById(R.h.bQv)).inflate();
        }
        final rj rjVar = this.lcl.awp().auj().vYs;
        ((TextView) this.lcn.findViewById(R.h.cbt)).setText(rjVar.title);
        if (rjVar.wgh != null && rjVar.wgh.size() > 0) {
            this.lco = (LinearLayout) this.lcn.findViewById(R.h.cbs);
            this.lco.removeAllViews();
            final LinkedList linkedList = rjVar.wgh;
            final LayoutInflater layoutInflater = (LayoutInflater) this.lcl.aws().getSystemService("layout_inflater");
            int i;
            TextView textView;
            if (rjVar.wgg >= linkedList.size() || this.lcp) {
                this.lcn.findViewById(R.h.cbr).setVisibility(8);
                for (i = 0; i < linkedList.size(); i++) {
                    textView = (TextView) layoutInflater.inflate(R.i.dcP, null, false);
                    textView.setText(((oy) linkedList.get(i)).title);
                    this.lco.addView(textView);
                }
                this.lco.invalidate();
                return;
            }
            for (i = 0; i < rjVar.wgg; i++) {
                textView = (TextView) layoutInflater.inflate(R.i.dcP, null, false);
                textView.setText(((oy) linkedList.get(i)).title);
                this.lco.addView(textView);
            }
            this.lco.invalidate();
            this.lcn.findViewById(R.h.cbr).setVisibility(0);
            this.lcn.findViewById(R.h.cbr).setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    l.this.lcp = true;
                    l.this.lcn.findViewById(R.h.cbr).setVisibility(8);
                    int i = rjVar.wgg;
                    while (true) {
                        int i2 = i;
                        if (i2 < linkedList.size()) {
                            TextView textView = (TextView) layoutInflater.inflate(R.i.dcP, null, false);
                            textView.setText(((oy) linkedList.get(i2)).title);
                            l.this.lco.addView(textView);
                            i = i2 + 1;
                        } else {
                            l.this.lco.invalidate();
                            return;
                        }
                    }
                }
            });
        }
    }

    public final void axD() {
        if (this.lcn != null) {
            this.lcn.setVisibility(8);
        }
    }
}
