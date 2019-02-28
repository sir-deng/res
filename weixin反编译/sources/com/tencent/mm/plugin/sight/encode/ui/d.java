package com.tencent.mm.plugin.sight.encode.ui;

import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.k;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class d implements TextWatcher, OnClickListener, OnFocusChangeListener, k {
    private ag handler = new ag(Looper.getMainLooper());
    public EditText qDa;
    public TextView qDb;
    public View qDc;
    private com.tencent.mm.plugin.fts.a.a.a qDd;
    public InputMethodManager qDe;
    public int qDf = b.qDi;
    public a qDg;

    public enum b {
        ;

        static {
            qDh = 1;
            qDi = 2;
            qDj = new int[]{qDh, qDi};
        }
    }

    public interface a {
        void bK(List<String> list);

        void bun();

        void buo();
    }

    public final boolean buk() {
        return this.qDf == b.qDh;
    }

    public final void onFocusChange(View view, boolean z) {
        if (!z) {
            this.qDa.clearFocus();
            bi.hideVKB(this.qDa);
        }
    }

    public final void onClick(View view) {
        if (view.getId() == R.h.cJw && buk()) {
            bul();
        }
    }

    public final void bul() {
        if (buk()) {
            bum();
        } else if (!buk()) {
            this.qDf = b.qDh;
            this.qDc.setVisibility(0);
            if (this.qDg != null) {
                this.qDg.bun();
            }
            this.qDa.requestFocus();
            this.qDe.showSoftInput(this.qDa, 0);
        }
    }

    public final void bum() {
        if (buk()) {
            this.qDa.setText("");
            this.qDa.clearFocus();
            bi.hideVKB(this.qDa);
            this.qDf = b.qDi;
            this.qDc.setVisibility(8);
            if (this.qDg != null) {
                this.qDg.buo();
            }
        }
    }

    public final void b(h hVar) {
        if (hVar.bjW == 0 && hVar.mRN != null && this.qDg != null) {
            List arrayList = new ArrayList();
            for (j jVar : hVar.mRN) {
                arrayList.add(jVar.mRd);
            }
            this.qDg.bK(arrayList);
        }
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        if (!bi.oN(editable.toString())) {
            x.i("MicroMsg.MainSightSelectContactSearchHelper", "doSearch: query=%s", editable.toString());
            if (this.qDd != null) {
                ((m) g.k(m.class)).cancelSearchTask(this.qDd);
                this.qDd = null;
            }
            this.qDd = ((m) g.k(m.class)).search(2, com.tencent.mm.plugin.fts.a.a.g.a(r0, new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, 131075}, null, 3, new HashSet(), com.tencent.mm.plugin.fts.a.c.b.mSk, this, this.handler));
        }
    }
}
