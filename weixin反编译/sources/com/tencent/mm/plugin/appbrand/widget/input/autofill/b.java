package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.database.DataSetObserver;
import android.text.Editable;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.Filter.FilterListener;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mm.plugin.appbrand.widget.input.z;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.widget.j;

public final class b {
    final z kfN;
    public final e kfO;
    private final FilterListener kfP;
    public final c kfQ;
    final a kfR;
    int kfS = f.kgp;
    public a kfT;
    private int kfU;
    private int kfV;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.autofill.b$7 */
    static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] kfY = new int[f.anY().length];

        static {
            try {
                kfY[f.kgo - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                kfY[f.kgp - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    private static class a implements h {
        h kfZ;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public void a(String str, com.tencent.mm.plugin.appbrand.widget.input.autofill.h.a aVar) {
            if (this.kfZ != null) {
                this.kfZ.a(str, aVar);
            }
        }
    }

    public b(z zVar) {
        this.kfN = zVar;
        this.kfO = new e(zVar.getContext());
        this.kfQ = new c(zVar, this.kfO);
        this.kfN.a(new com.tencent.mm.plugin.appbrand.widget.input.z.a() {
            public final void anO() {
                b.this.anV();
            }
        });
        this.kfN.a(new com.tencent.mm.plugin.appbrand.widget.input.z.b() {
            public final void anu() {
                b.this.anV();
            }
        });
        this.kfN.a(new OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                if (z) {
                    b.this.anW();
                    return;
                }
                b bVar = b.this;
                if (bVar.kfO.iqe.isShowing()) {
                    g gVar = (g) bVar.kfO.kgh.getAdapter();
                    bVar.kfO.dismiss();
                    gVar.anU();
                }
            }
        });
        this.kfN.addTextChangedListener(new j() {
            private boolean kfX = false;

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.kfX = b.this.kfO.iqe.isShowing();
            }

            public final void afterTextChanged(Editable editable) {
                if (!this.kfX || b.this.kfO.iqe.isShowing()) {
                    if (!b.this.kfO.iqe.isShowing()) {
                        b.this.anW();
                    }
                    b.this.u(editable);
                }
            }
        });
        this.kfP = new FilterListener() {
            public final void onFilterComplete(int i) {
                if (i <= 0) {
                    b.this.kfO.dismiss();
                } else if (b.this.kfO.iqe.isShowing()) {
                    b.this.kfO.show();
                }
            }
        };
        this.kfR = new a() {
            public final void a(String str, com.tencent.mm.plugin.appbrand.widget.input.autofill.h.a aVar) {
                if (aVar == com.tencent.mm.plugin.appbrand.widget.input.autofill.h.a.DELETE) {
                    b.this.u(b.this.kfN.getText());
                }
                super.a(str, aVar);
            }
        };
    }

    final void u(CharSequence charSequence) {
        if (this.kfT != null) {
            this.kfT.getFilter().filter(charSequence, this.kfP);
        }
    }

    final void anV() {
        switch (AnonymousClass7.kfY[this.kfS - 1]) {
            case 1:
                this.kfO.PV = com.tencent.mm.plugin.appbrand.ui.j.alC()[0];
                break;
            case 2:
                this.kfO.PV = this.kfN.getView().getMeasuredWidth();
                break;
        }
        if (this.kfU != 0) {
            this.kfO.SN = this.kfU;
            this.kfO.PV -= this.kfU;
        }
        if (this.kfV != 0) {
            this.kfO.PV -= this.kfV;
        }
    }

    public final void setOnDismissListener(OnDismissListener onDismissListener) {
        this.kfO.iqe.setOnDismissListener(onDismissListener);
    }

    final void anW() {
        if (this.kfT != null) {
            CharSequence text = this.kfN.getText();
            if (!bi.N(text)) {
                u(text);
            }
            this.kfO.SW = this.kfN.getView();
            this.kfO.show();
            ((g) this.kfO.kgh.getAdapter()).a(this);
            c cVar = this.kfQ;
            cVar.mA(2);
            cVar.kgc = Integer.MIN_VALUE;
            if (!bi.N(text)) {
                cVar.kgd = true;
            }
            ListView listView = cVar.kfO.kgh;
            if (listView != null) {
                listView.getAdapter().registerDataSetObserver(new DataSetObserver() {
                    public final void onChanged() {
                        if (c.this.kfO.iqe.isShowing()) {
                            c.this.mA(1);
                        }
                    }
                });
            }
        }
    }
}
