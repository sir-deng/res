package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wenote.model.a.b;
import com.tencent.mm.plugin.wenote.model.a.h;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.c;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.u;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;

public final class k extends a {
    private WXRTEditText ueV;

    public k(View view, com.tencent.mm.plugin.wenote.model.nativenote.manager.k kVar) {
        super(view, kVar);
        this.ueV = (WXRTEditText) view.findViewById(R.h.cIJ);
        if (!(kVar.uaN == 2 && this.ucQ.uaO)) {
            this.ueV.setKeyListener(null);
            this.ueV.setFocusable(false);
            this.ueV.setClickable(true);
        }
        this.ueV.tZW = this;
        this.ueV.tZU = 0;
        this.ucQ.o(this.ueV);
        this.ueV.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                as.Dt().F(new Runnable() {
                    public final void run() {
                        k.this.ueV.hasFocus();
                    }
                });
            }
        });
    }

    public final void a(b bVar, int i, int i2) {
        LayoutParams layoutParams;
        this.ueV.uah = i;
        final h hVar = (h) bVar;
        hVar.tXW = this.ueV;
        hVar.tXU = null;
        hVar.tXV = null;
        b BL = c.bXc().BL(i - 1);
        if (BL != null && BL.getType() == 1) {
            layoutParams = (LayoutParams) this.ueV.getLayoutParams();
            layoutParams.topMargin = 0;
            this.ueV.setLayoutParams(layoutParams);
        }
        BL = c.bXc().BL(i + 1);
        if (BL != null && BL.getType() == 1) {
            layoutParams = (LayoutParams) this.ueV.getLayoutParams();
            layoutParams.bottomMargin = 0;
            this.ueV.setLayoutParams(layoutParams);
        }
        if (this.ucQ.uaN == 2 && this.ucQ.uaO) {
            ah.y(new Runnable() {
                public final void run() {
                    k.this.ueV.Rw(hVar.content);
                    k.this.ueV.bXC();
                    k.this.ueV.bXE();
                    i.i(k.this.ueV);
                    k.this.ueV.bXF();
                    k.this.ueV.bXD();
                    if (hVar.tXR) {
                        if (hVar.tXT == -1 || hVar.tXT >= k.this.ueV.getText().toString().length()) {
                            k.this.ueV.setSelection(k.this.ueV.getText().toString().length());
                        } else {
                            k.this.ueV.setSelection(hVar.tXT);
                        }
                        k.this.ueV.requestFocus();
                        ah.h(new Runnable() {
                            public final void run() {
                                if (hVar.tYa != 0) {
                                    int i = k.this.ueV.bXA().Ww;
                                    if (i == hVar.content.length()) {
                                        k.this.ueV.bXC();
                                        k.this.ueV.getText().append("\n");
                                        k.this.ueV.bXD();
                                        k.this.ueV.setSelection(i);
                                    }
                                    hVar.tYa = 0;
                                    if (hVar.tYb == 1) {
                                        k.this.ueV.a(u.ucI, Boolean.valueOf(true));
                                    } else if (hVar.tYb == 3) {
                                        k.this.ueV.a(u.ucH, Boolean.valueOf(true));
                                    } else if (hVar.tYb == 2) {
                                        k.this.ueV.a(u.ucJ, Boolean.valueOf(true));
                                    }
                                }
                            }
                        }, 500);
                    } else if (k.this.ueV.hasFocus()) {
                        k.this.ueV.clearFocus();
                    }
                    if (hVar.tXZ) {
                        hVar.tXZ = false;
                        k.this.ueV.tXZ = true;
                        k.this.ueV.onTextContextMenuItem(16908322);
                    }
                }
            });
        } else {
            this.ueV.Rw(hVar.content);
            i.i(this.ueV);
        }
        x.i("MicroMsg.Note.NoteTextItemHolder", "TextItemHolder position is " + ge());
    }

    public final int bYB() {
        return 1;
    }
}
