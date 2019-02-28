package com.tencent.mm.plugin.appbrand.game.c;

import android.content.Context;
import android.os.Looper;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.al.a;

public final class c extends AppCompatTextView {
    StringBuilder azu = new StringBuilder(100);
    private al ind = new al(Looper.getMainLooper(), new a() {
        public final boolean uG() {
            g aeA = i.jcB.aeA();
            if (aeA != null) {
                c cVar = c.this;
                double d = aeA.jcx;
                double d2 = aeA.jcy;
                cVar.azu.setLength(0);
                cVar.azu.append("MinFPS[").append(Math.round(d2)).append("] RT-FPS[").append(Math.round(d)).append("]");
                cVar.setText(cVar.azu);
            }
            return true;
        }
    }, true);
    private long jbI = -1;
    private long jbJ = -1;
    private int jbK = 0;
    private float jbL = 60.0f;
    private int jbM = 0;

    public c(Context context) {
        super(context);
        setTextSize(12.0f);
        setTextColor(-65536);
        setFocusable(false);
        setClickable(false);
        setOnClickListener(null);
        setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                c.this.jbL = 60.0f;
            }
        });
        this.ind.K(500, 500);
    }
}
