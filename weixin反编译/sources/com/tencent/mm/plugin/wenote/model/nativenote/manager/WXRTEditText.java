package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView.t;
import android.text.Editable;
import android.text.Layout;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ParagraphStyle;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.TextView.BufferType;
import com.tencent.mm.bw.g;
import com.tencent.mm.plugin.wenote.model.nativenote.a.a;
import com.tencent.mm.plugin.wenote.model.nativenote.b.c;
import com.tencent.mm.plugin.wenote.model.nativenote.c.b;
import com.tencent.mm.plugin.wenote.model.nativenote.c.d;
import com.tencent.mm.plugin.wenote.model.nativenote.c.e;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.i;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.k;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.n;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.u;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.PasterEditText;

public class WXRTEditText extends PasterEditText implements SpanWatcher {
    private al ind = null;
    public int mZw = 0;
    public boolean tXZ = false;
    public int tYb = 0;
    c tZK;
    private int tZL = -1;
    private int tZM = -1;
    private boolean tZN = false;
    private boolean tZO;
    private int tZP;
    private int tZQ;
    private String tZR;
    public String tZS = "";
    private Spannable tZT;
    public int tZU = 0;
    private WXRTEditText tZV = null;
    public t tZW;
    private boolean tZX;
    private boolean tZY;
    private boolean tZZ;
    private boolean uaa;
    private boolean uab;
    private boolean uac = false;
    private boolean uad;
    private j uae;
    public boolean uaf = false;
    public boolean uag = false;
    public int uah = -1;
    private Paint uai = null;
    private b uaj = null;
    public boolean uak = false;
    private Path ual = null;
    private int uam = -1;
    private int uan = -1;
    private int uao = -1;
    private boolean uap = false;
    TextWatcher uaq = new TextWatcher() {
        public final synchronized void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Object c = WXRTEditText.this.tZR == null ? "" : WXRTEditText.this.tZR;
            if (!(WXRTEditText.this.tZO || charSequence.toString().equals(c))) {
                WXRTEditText.this.tZP = WXRTEditText.this.getSelectionStart();
                WXRTEditText.this.tZQ = WXRTEditText.this.getSelectionEnd();
                WXRTEditText.this.tZR = charSequence.toString();
                WXRTEditText.this.tZS = WXRTEditText.this.tZR;
                WXRTEditText.this.tZT = WXRTEditText.this.bXz();
            }
        }

        public final synchronized void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            WXRTEditText.this.uad = true;
        }

        public final synchronized void afterTextChanged(Editable editable) {
            x.d("noteeditor.WXRTEditText", "afterTextChanged");
            String obj = editable.toString();
            String str = WXRTEditText.this.tZS == null ? "" : WXRTEditText.this.tZS;
            if (WXRTEditText.this.tZU != 0) {
                WXRTEditText.this.tZS = "";
            }
            if (!WXRTEditText.this.tZO && WXRTEditText.this.bXA().Ww == WXRTEditText.this.bXA().wq && (((!str.endsWith("\n") && (str + "\n").equals(obj)) || (str.endsWith("\n") && !str.endsWith("\n\n") && str.equals(obj))) && ((ParagraphStyle[]) WXRTEditText.this.getText().getSpans(str.length(), str.length(), ParagraphStyle.class)).length > 0)) {
                int selectionStart = WXRTEditText.this.getSelectionStart();
                WXRTEditText.this.tZO = true;
                WXRTEditText.this.getText().append("\n");
                WXRTEditText.this.tZO = false;
                WXRTEditText.this.setSelection(selectionStart);
            }
            if (!(WXRTEditText.this.tZK == null || WXRTEditText.this.tZO || str.equals(obj))) {
                Spannable bXz = WXRTEditText.this.bXz();
                WXRTEditText.this.tZS = obj;
                c g = WXRTEditText.this.tZK;
                WXRTEditText h = WXRTEditText.this.tZV;
                Spannable i = WXRTEditText.this.tZT;
                WXRTEditText.this.getSelectionStart();
                g.a(h, i, bXz, WXRTEditText.this.getSelectionEnd());
            }
            WXRTEditText.this.uad = true;
            WXRTEditText.this.tZX = true;
            WXRTEditText.this.kS(false);
            WXRTEditText.this.bXG();
        }
    };
    int uar = 0;

    public WXRTEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public WXRTEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public void setMaxHeight(int i) {
        super.setMaxHeight(i);
    }

    private void init() {
        this.tZV = this;
        removeTextChangedListener(this.uaq);
        addTextChangedListener(this.uaq);
        setMovementMethod(i.bYk());
        this.uah = -1;
        this.uai = new Paint(1);
        this.uai.setColor(1347529272);
        this.uaj = new b();
        this.ual = new Path();
        this.uam = -1;
        this.uan = -1;
        this.uao = -1;
        if (e.isEnabled()) {
            setHighlightColor(0);
            setCustomSelectionActionModeCallback(new Callback() {
                public final boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                    return false;
                }

                public final void onDestroyActionMode(ActionMode actionMode) {
                }

                public final boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                    return false;
                }

                public final boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                    return false;
                }
            });
        }
    }

    public final void Rw(String str) {
        bXC();
        if (bi.oN(str)) {
            setText("");
        } else {
            b(a.Rs(str));
        }
        bXD();
    }

    private void b(Spanned spanned) {
        bXC();
        bXE();
        super.setText(spanned, BufferType.EDITABLE);
        bXF();
        bXG();
        u.a(this, new com.tencent.mm.plugin.wenote.model.nativenote.spans.t[0]);
        bXD();
    }

    public final void setText(String str) {
        bXC();
        super.setText(str);
        bXD();
    }

    public final void bXy() {
        if (this.tZK != null) {
            this.tZK.f(true, 50);
            this.tZK.BI(1);
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    protected void onFocusChanged(boolean z, int i, Rect rect) {
        this.uap = false;
        this.tZL = -1;
        this.tZM = -1;
        super.onFocusChanged(z, i, rect);
        if (this.tZK != null) {
            this.tZK.a(this, z, bXB());
        }
        if (z && !this.uap) {
            onSelectionChanged(getSelectionStart(), getSelectionEnd());
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void onSelectionChanged(int r5, int r6) {
        /*
        r4 = this;
        r2 = 0;
        r1 = 1;
        monitor-enter(r4);
        r0 = r4.tZN;	 Catch:{ all -> 0x007a }
        if (r0 == 0) goto L_0x0009;
    L_0x0007:
        monitor-exit(r4);	 Catch:{ all -> 0x007a }
    L_0x0008:
        return;
    L_0x0009:
        monitor-exit(r4);	 Catch:{ all -> 0x007a }
        r4.uap = r1;
        if (r5 < 0) goto L_0x0008;
    L_0x000e:
        r0 = r4.tZL;
        if (r0 != r5) goto L_0x0016;
    L_0x0012:
        r0 = r4.tZM;
        if (r0 == r6) goto L_0x0043;
    L_0x0016:
        r4.tZL = r5;
        r4.tZM = r6;
        super.onSelectionChanged(r5, r6);
        if (r6 <= r5) goto L_0x007d;
    L_0x001f:
        r0 = r1;
    L_0x0020:
        r4.tZY = r0;
        r0 = r4.tZZ;
        if (r0 != 0) goto L_0x0036;
    L_0x0026:
        r0 = r4.uaa;
        if (r0 != 0) goto L_0x0036;
    L_0x002a:
        r4.uab = r1;
        r0 = new com.tencent.mm.plugin.wenote.model.nativenote.spans.t[r2];
        com.tencent.mm.plugin.wenote.model.nativenote.spans.u.a(r4, r0);
        r4.uab = r2;
        r4.kS(r1);
    L_0x0036:
        r0 = r4.tZK;
        if (r0 == 0) goto L_0x0043;
    L_0x003a:
        r4.uac = r1;
        r0 = r4.tZK;
        r0.a(r4, r5, r6);
        r4.uac = r2;
    L_0x0043:
        r0 = com.tencent.mm.plugin.wenote.model.nativenote.c.e.isEnabled();
        if (r0 == 0) goto L_0x0008;
    L_0x0049:
        r0 = r4.uak;
        if (r0 != 0) goto L_0x0008;
    L_0x004d:
        r0 = r4.hasFocus();
        if (r0 == 0) goto L_0x0008;
    L_0x0053:
        r0 = r4.uah;
        if (r0 < 0) goto L_0x0008;
    L_0x0057:
        r4.ew(r5, r6);
        r0 = com.tencent.mm.plugin.wenote.model.nativenote.c.e.bXS();
        r2 = r4.uah;
        r0 = r0.BN(r2);
        if (r0 != r1) goto L_0x0008;
    L_0x0066:
        r0 = com.tencent.mm.plugin.wenote.model.nativenote.c.e.bXS();
        r2 = com.tencent.mm.plugin.wenote.model.nativenote.c.e.mHasInit;
        if (r2 == 0) goto L_0x0008;
    L_0x006e:
        r2 = 0;
        r0.g(r1, r2);
        r0.bYa();
        r0.bXY();
        goto L_0x0008;
    L_0x007a:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x007a }
        throw r0;
    L_0x007d:
        r0 = r2;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText.onSelectionChanged(int, int):void");
    }

    public final Spannable bXz() {
        CharSequence text = super.getText();
        if (text == null) {
            text = "";
        }
        return new a(text);
    }

    public final e bXA() {
        return new e(getSelectionStart(), getSelectionEnd());
    }

    public final String a(i iVar) {
        if (iVar == i.uau) {
            return getText().toString();
        }
        if (iVar == i.uav) {
            return com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(getText());
        }
        return "";
    }

    public final int bXB() {
        if (this.tZW.ge() == -1) {
            return 0;
        }
        return this.tZW.ge();
    }

    public boolean onTextContextMenuItem(int i) {
        if (i == 16908319) {
            this.tZK.bWY();
            return true;
        }
        if (i == 16908321 || i == 16908320) {
            f.abi();
        } else if (i == 16908322) {
            int dV = f.dV(getContext());
            if (dV == 2) {
                f.abi();
            } else if (dV == 3) {
                this.tZK.b(this);
                return true;
            }
        }
        try {
            boolean onTextContextMenuItem = super.onTextContextMenuItem(i);
            if (i == 16908322) {
                this.uar = 0;
                try {
                    b(getText());
                } catch (IndexOutOfBoundsException e) {
                    x.e("noteeditor.WXRTEditText", "!!MMEditText Exception %d", Integer.valueOf(this.uar));
                    if (this.uar < 3) {
                        this.uar++;
                        b(new SpannableStringBuilder(TextUtils.concat(new CharSequence[]{" ", r3})));
                    } else {
                        throw e;
                    }
                }
            }
            if (i == 16908322 && this.tXZ) {
                if (this.tZK != null) {
                    this.tZK.f(false, 0);
                    this.tZK.BI(0);
                }
                this.tXZ = false;
            }
            return onTextContextMenuItem;
        } catch (NullPointerException e2) {
            x.e("noteeditor.WXRTEditText", "!!MMEditText NullPointerException %s", e2);
            return false;
        }
    }

    private void b(Spannable spannable) {
        int selectionStart = getSelectionStart();
        b(g.chT().a(getContext(), spannable, getTextSize()));
        int length = getText().length() - spannable.length();
        if (length > 0) {
            selectionStart += length;
            if (selectionStart <= getText().length()) {
                setSelection(selectionStart);
                return;
            }
            return;
        }
        setSelection(selectionStart);
    }

    public final synchronized void bXC() {
        this.tZO = true;
    }

    public final synchronized void bXD() {
        this.tZO = false;
    }

    public final synchronized void bXE() {
        this.tZN = true;
    }

    public final synchronized void bXF() {
        this.tZN = false;
    }

    public void onSpanAdded(Spannable spannable, Object obj, int i, int i2) {
        this.tZX = true;
        if ((obj instanceof com.tencent.mm.plugin.wenote.model.nativenote.spans.g) && (obj instanceof ParagraphStyle)) {
            kS(false);
        }
    }

    public void onSpanRemoved(Spannable spannable, Object obj, int i, int i2) {
        this.tZX = true;
        if ((obj instanceof com.tencent.mm.plugin.wenote.model.nativenote.spans.g) && (obj instanceof ParagraphStyle)) {
            kS(false);
        }
    }

    public void onSpanChanged(Spannable spannable, Object obj, int i, int i2, int i3, int i4) {
        this.tZX = true;
        if ((obj instanceof com.tencent.mm.plugin.wenote.model.nativenote.spans.g) && (obj instanceof ParagraphStyle)) {
            kS(false);
        }
    }

    public final <V, C extends com.tencent.mm.plugin.wenote.model.nativenote.spans.g<V>> void a(com.tencent.mm.plugin.wenote.model.nativenote.spans.t<V, C> tVar, V v) {
        if (!this.uac && !this.tZZ) {
            Spannable bXz = this.tZO ? null : bXz();
            tVar.a(this, v);
            synchronized (this) {
                if (!(this.tZK == null || this.tZO)) {
                    Spannable bXz2 = bXz();
                    c cVar = this.tZK;
                    getSelectionStart();
                    getSelectionEnd();
                    getSelectionStart();
                    cVar.a(this, bXz, bXz2, getSelectionEnd());
                }
                this.uad = true;
            }
        }
    }

    private void bXG() {
        Spannable text = getText();
        if (text.getSpans(0, text.length(), getClass()) != null) {
            text.setSpan(this, 0, text.length(), 18);
        }
    }

    private synchronized void kS(boolean z) {
        if (!this.uab) {
            this.uaa = z;
        }
    }

    public final e bXH() {
        int i = 0;
        j bXI = bXI();
        e eVar = new e(this);
        int lineForOffset = bXI.getLineForOffset(eVar.Ww);
        int lineForOffset2 = bXI.getLineForOffset(eVar.isEmpty() ? eVar.wq : eVar.wq - 1);
        lineForOffset = (bXI.uax == 0 || lineForOffset < 0) ? 0 : lineForOffset < bXI.uax ? ((n) bXI.uay.get(lineForOffset)).Ww : ((n) bXI.uay.get(bXI.uax - 1)).wq - 1;
        if (bXI.uax != 0 && lineForOffset2 >= 0) {
            i = lineForOffset2 < bXI.uax ? ((n) bXI.uay.get(lineForOffset2)).wq : ((n) bXI.uay.get(bXI.uax - 1)).wq - 1;
        }
        return new e(lineForOffset, i);
    }

    public j bXI() {
        j jVar;
        synchronized (this) {
            if (this.uae == null || this.uad) {
                this.uae = new j(getText());
                this.uad = false;
            }
            jVar = this.uae;
        }
        return jVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void onDraw(android.graphics.Canvas r17) {
        /*
        r16 = this;
        r1 = com.tencent.mm.plugin.wenote.model.nativenote.c.e.isEnabled();
        if (r1 == 0) goto L_0x003a;
    L_0x0006:
        r0 = r16;
        r1 = r0.tZU;
        if (r1 != 0) goto L_0x003a;
    L_0x000c:
        r5 = r16.getText();
        if (r5 == 0) goto L_0x003a;
    L_0x0012:
        r1 = com.tencent.mm.plugin.wenote.model.nativenote.c.e.bXS();
        r6 = r1.bXU();
        r4 = -1;
        r3 = 0;
        r2 = 0;
        r1 = 0;
        r7 = com.tencent.mm.plugin.wenote.model.nativenote.c.e.bXS();
        r0 = r16;
        r8 = r0.uah;
        r7 = r7.BN(r8);
        switch(r7) {
            case 1: goto L_0x003e;
            case 2: goto L_0x004c;
            case 3: goto L_0x0062;
            case 4: goto L_0x0057;
            default: goto L_0x002d;
        };
    L_0x002d:
        r6 = r2;
        r2 = r4;
        r4 = r3;
    L_0x0030:
        if (r2 < 0) goto L_0x003a;
    L_0x0032:
        r3 = r5.length();
        if (r4 > r3) goto L_0x003a;
    L_0x0038:
        if (r2 <= r4) goto L_0x006a;
    L_0x003a:
        super.onDraw(r17);
        return;
    L_0x003e:
        r3 = r6.startOffset;
        r4 = r6.ubl;
        if (r3 == r4) goto L_0x003a;
    L_0x0044:
        r4 = r6.startOffset;
        r3 = r6.ubl;
        r6 = r2;
        r2 = r4;
        r4 = r3;
        goto L_0x0030;
    L_0x004c:
        r4 = 0;
        r3 = r5.length();
        r2 = 1;
        r1 = 1;
        r6 = r2;
        r2 = r4;
        r4 = r3;
        goto L_0x0030;
    L_0x0057:
        r4 = r6.startOffset;
        r3 = r5.length();
        r1 = 1;
        r6 = r2;
        r2 = r4;
        r4 = r3;
        goto L_0x0030;
    L_0x0062:
        r4 = 0;
        r3 = r6.ubl;
        r2 = 1;
        r6 = r2;
        r2 = r4;
        r4 = r3;
        goto L_0x0030;
    L_0x006a:
        r5 = r16.getLayout();
        if (r5 == 0) goto L_0x003a;
    L_0x0070:
        r0 = r16;
        r3 = r0.uam;
        r7 = -1;
        if (r3 != r7) goto L_0x007f;
    L_0x0077:
        r3 = r16.getPaddingLeft();
        r0 = r16;
        r0.uam = r3;
    L_0x007f:
        r0 = r16;
        r3 = r0.uan;
        r7 = -1;
        if (r3 != r7) goto L_0x008e;
    L_0x0086:
        r3 = r16.getPaddingTop();
        r0 = r16;
        r0.uan = r3;
    L_0x008e:
        r0 = r16;
        r3 = r0.uao;
        r7 = -1;
        if (r3 != r7) goto L_0x009d;
    L_0x0095:
        r3 = r16.getPaddingBottom();
        r0 = r16;
        r0.uao = r3;
    L_0x009d:
        r0 = r16;
        r3 = r0.ual;
        if (r3 != 0) goto L_0x00ac;
    L_0x00a3:
        r3 = new android.graphics.Path;
        r3.<init>();
        r0 = r16;
        r0.ual = r3;
    L_0x00ac:
        r0 = r16;
        r3 = r0.ual;
        r3.reset();
        r13 = r5.getLineForOffset(r2);	 Catch:{ Exception -> 0x014f }
        r14 = r5.getLineForOffset(r4);	 Catch:{ Exception -> 0x014f }
        if (r13 > r14) goto L_0x003a;
    L_0x00bd:
        r15 = r5.getWidth();	 Catch:{ Exception -> 0x014f }
        r2 = r5.getPrimaryHorizontal(r2);	 Catch:{ Exception -> 0x014f }
        r0 = r16;
        r3 = r0.uam;	 Catch:{ Exception -> 0x014f }
        r3 = (float) r3;	 Catch:{ Exception -> 0x014f }
        r2 = r2 + r3;
        r3 = r5.getLineTop(r13);	 Catch:{ Exception -> 0x014f }
        r0 = r16;
        r7 = r0.uan;	 Catch:{ Exception -> 0x014f }
        r3 = r3 + r7;
        r3 = (float) r3;	 Catch:{ Exception -> 0x014f }
        r7 = r5.getLineBottom(r13);	 Catch:{ Exception -> 0x014f }
        r0 = r16;
        r8 = r0.uan;	 Catch:{ Exception -> 0x014f }
        r7 = r7 + r8;
        r10 = (float) r7;	 Catch:{ Exception -> 0x014f }
        r4 = r5.getPrimaryHorizontal(r4);	 Catch:{ Exception -> 0x014f }
        r0 = r16;
        r7 = r0.uam;	 Catch:{ Exception -> 0x014f }
        r7 = (float) r7;	 Catch:{ Exception -> 0x014f }
        r4 = r4 + r7;
        r7 = r5.getLineTop(r14);	 Catch:{ Exception -> 0x014f }
        r0 = r16;
        r8 = r0.uan;	 Catch:{ Exception -> 0x014f }
        r7 = r7 + r8;
        r12 = (float) r7;	 Catch:{ Exception -> 0x014f }
        r5 = r5.getLineBottom(r14);	 Catch:{ Exception -> 0x014f }
        r0 = r16;
        r7 = r0.uan;	 Catch:{ Exception -> 0x014f }
        r5 = r5 + r7;
        r5 = (float) r5;	 Catch:{ Exception -> 0x014f }
        if (r6 == 0) goto L_0x0161;
    L_0x00ff:
        if (r1 == 0) goto L_0x0161;
    L_0x0101:
        r0 = r16;
        r1 = r0.ual;	 Catch:{ Exception -> 0x014f }
        r0 = r16;
        r2 = r0.uam;	 Catch:{ Exception -> 0x014f }
        r2 = (float) r2;	 Catch:{ Exception -> 0x014f }
        r3 = 0;
        r0 = r16;
        r4 = r0.uam;	 Catch:{ Exception -> 0x014f }
        r4 = r4 + r15;
        r4 = (float) r4;	 Catch:{ Exception -> 0x014f }
        r0 = r16;
        r6 = r0.uao;	 Catch:{ Exception -> 0x014f }
        r6 = (float) r6;	 Catch:{ Exception -> 0x014f }
        r5 = r5 + r6;
        r6 = android.graphics.Path.Direction.CW;	 Catch:{ Exception -> 0x014f }
        r1.addRect(r2, r3, r4, r5, r6);	 Catch:{ Exception -> 0x014f }
    L_0x011c:
        r0 = r16;
        r1 = r0.ual;	 Catch:{ Exception -> 0x014f }
        r1 = r1.isEmpty();	 Catch:{ Exception -> 0x014f }
        if (r1 != 0) goto L_0x003a;
    L_0x0126:
        r0 = r16;
        r1 = r0.uai;	 Catch:{ Exception -> 0x014f }
        if (r1 != 0) goto L_0x0140;
    L_0x012c:
        r1 = new android.graphics.Paint;	 Catch:{ Exception -> 0x014f }
        r2 = 1;
        r1.<init>(r2);	 Catch:{ Exception -> 0x014f }
        r0 = r16;
        r0.uai = r1;	 Catch:{ Exception -> 0x014f }
        r0 = r16;
        r1 = r0.uai;	 Catch:{ Exception -> 0x014f }
        r2 = 1347529272; // 0x5051aa38 float:1.40703744E10 double:6.6576792E-315;
        r1.setColor(r2);	 Catch:{ Exception -> 0x014f }
    L_0x0140:
        r0 = r16;
        r1 = r0.ual;	 Catch:{ Exception -> 0x014f }
        r0 = r16;
        r2 = r0.uai;	 Catch:{ Exception -> 0x014f }
        r0 = r17;
        r0.drawPath(r1, r2);	 Catch:{ Exception -> 0x014f }
        goto L_0x003a;
    L_0x014f:
        r1 = move-exception;
        r2 = "noteeditor.WXRTEditText";
        r3 = "tryDrawCover: ";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r4[r5] = r1;
        com.tencent.mm.sdk.platformtools.x.e(r2, r3, r4);
        goto L_0x003a;
    L_0x0161:
        if (r13 != r14) goto L_0x0197;
    L_0x0163:
        if (r6 == 0) goto L_0x0175;
    L_0x0165:
        r0 = r16;
        r1 = r0.ual;	 Catch:{ Exception -> 0x014f }
        r0 = r16;
        r2 = r0.uam;	 Catch:{ Exception -> 0x014f }
        r2 = (float) r2;	 Catch:{ Exception -> 0x014f }
        r3 = 0;
        r6 = android.graphics.Path.Direction.CW;	 Catch:{ Exception -> 0x014f }
        r1.addRect(r2, r3, r4, r5, r6);	 Catch:{ Exception -> 0x014f }
        goto L_0x011c;
    L_0x0175:
        if (r1 == 0) goto L_0x018d;
    L_0x0177:
        r0 = r16;
        r1 = r0.ual;	 Catch:{ Exception -> 0x014f }
        r0 = r16;
        r4 = r0.uam;	 Catch:{ Exception -> 0x014f }
        r4 = r4 + r15;
        r4 = (float) r4;	 Catch:{ Exception -> 0x014f }
        r0 = r16;
        r6 = r0.uao;	 Catch:{ Exception -> 0x014f }
        r6 = (float) r6;	 Catch:{ Exception -> 0x014f }
        r5 = r5 + r6;
        r6 = android.graphics.Path.Direction.CW;	 Catch:{ Exception -> 0x014f }
        r1.addRect(r2, r3, r4, r5, r6);	 Catch:{ Exception -> 0x014f }
        goto L_0x011c;
    L_0x018d:
        r0 = r16;
        r1 = r0.ual;	 Catch:{ Exception -> 0x014f }
        r6 = android.graphics.Path.Direction.CW;	 Catch:{ Exception -> 0x014f }
        r1.addRect(r2, r3, r4, r5, r6);	 Catch:{ Exception -> 0x014f }
        goto L_0x011c;
    L_0x0197:
        if (r6 == 0) goto L_0x01d8;
    L_0x0199:
        r0 = r16;
        r6 = r0.ual;	 Catch:{ Exception -> 0x014f }
        r0 = r16;
        r1 = r0.uam;	 Catch:{ Exception -> 0x014f }
        r7 = (float) r1;	 Catch:{ Exception -> 0x014f }
        r8 = 0;
        r0 = r16;
        r1 = r0.uam;	 Catch:{ Exception -> 0x014f }
        r1 = r1 + r15;
        r9 = (float) r1;	 Catch:{ Exception -> 0x014f }
        r11 = android.graphics.Path.Direction.CW;	 Catch:{ Exception -> 0x014f }
        r6.addRect(r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x014f }
        r0 = r16;
        r1 = r0.ual;	 Catch:{ Exception -> 0x014f }
        r0 = r16;
        r2 = r0.uam;	 Catch:{ Exception -> 0x014f }
        r2 = (float) r2;	 Catch:{ Exception -> 0x014f }
        r6 = android.graphics.Path.Direction.CW;	 Catch:{ Exception -> 0x014f }
        r3 = r12;
        r1.addRect(r2, r3, r4, r5, r6);	 Catch:{ Exception -> 0x014f }
    L_0x01bd:
        r1 = r14 - r13;
        r2 = 1;
        if (r1 <= r2) goto L_0x011c;
    L_0x01c2:
        r0 = r16;
        r8 = r0.ual;	 Catch:{ Exception -> 0x014f }
        r0 = r16;
        r1 = r0.uam;	 Catch:{ Exception -> 0x014f }
        r9 = (float) r1;	 Catch:{ Exception -> 0x014f }
        r0 = r16;
        r1 = r0.uam;	 Catch:{ Exception -> 0x014f }
        r1 = r1 + r15;
        r11 = (float) r1;	 Catch:{ Exception -> 0x014f }
        r13 = android.graphics.Path.Direction.CW;	 Catch:{ Exception -> 0x014f }
        r8.addRect(r9, r10, r11, r12, r13);	 Catch:{ Exception -> 0x014f }
        goto L_0x011c;
    L_0x01d8:
        if (r1 == 0) goto L_0x0207;
    L_0x01da:
        r0 = r16;
        r6 = r0.ual;	 Catch:{ Exception -> 0x014f }
        r0 = r16;
        r1 = r0.uam;	 Catch:{ Exception -> 0x014f }
        r1 = r1 + r15;
        r9 = (float) r1;	 Catch:{ Exception -> 0x014f }
        r11 = android.graphics.Path.Direction.CW;	 Catch:{ Exception -> 0x014f }
        r7 = r2;
        r8 = r3;
        r6.addRect(r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x014f }
        r0 = r16;
        r1 = r0.ual;	 Catch:{ Exception -> 0x014f }
        r0 = r16;
        r2 = r0.uam;	 Catch:{ Exception -> 0x014f }
        r2 = (float) r2;	 Catch:{ Exception -> 0x014f }
        r0 = r16;
        r3 = r0.uam;	 Catch:{ Exception -> 0x014f }
        r3 = r3 + r15;
        r4 = (float) r3;	 Catch:{ Exception -> 0x014f }
        r0 = r16;
        r3 = r0.uao;	 Catch:{ Exception -> 0x014f }
        r3 = (float) r3;	 Catch:{ Exception -> 0x014f }
        r5 = r5 + r3;
        r6 = android.graphics.Path.Direction.CW;	 Catch:{ Exception -> 0x014f }
        r3 = r12;
        r1.addRect(r2, r3, r4, r5, r6);	 Catch:{ Exception -> 0x014f }
        goto L_0x01bd;
    L_0x0207:
        r0 = r16;
        r6 = r0.ual;	 Catch:{ Exception -> 0x014f }
        r0 = r16;
        r1 = r0.uam;	 Catch:{ Exception -> 0x014f }
        r1 = r1 + r15;
        r9 = (float) r1;	 Catch:{ Exception -> 0x014f }
        r11 = android.graphics.Path.Direction.CW;	 Catch:{ Exception -> 0x014f }
        r7 = r2;
        r8 = r3;
        r6.addRect(r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x014f }
        r0 = r16;
        r1 = r0.ual;	 Catch:{ Exception -> 0x014f }
        r0 = r16;
        r2 = r0.uam;	 Catch:{ Exception -> 0x014f }
        r2 = (float) r2;	 Catch:{ Exception -> 0x014f }
        r6 = android.graphics.Path.Direction.CW;	 Catch:{ Exception -> 0x014f }
        r3 = r12;
        r1.addRect(r2, r3, r4, r5, r6);	 Catch:{ Exception -> 0x014f }
        goto L_0x01bd;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText.onDraw(android.graphics.Canvas):void");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (e.isEnabled()) {
            Spannable text = getText();
            if (text == null) {
                bXK();
                return true;
            }
            int length = text.length();
            int offsetForPosition = getOffsetForPosition(motionEvent.getX(), motionEvent.getY());
            if (length < 0 || offsetForPosition < 0 || offsetForPosition > length) {
                bXK();
                return true;
            }
            switch (motionEvent.getAction()) {
                case 0:
                    int x = (int) motionEvent.getX();
                    length = (int) motionEvent.getY();
                    Layout layout = getLayout();
                    length = layout.getOffsetForHorizontal(layout.getLineForVertical(length), (float) x);
                    k[] kVarArr = (k[]) getText().getSpans(length, length + 1, k.class);
                    if (!e.bXS().isEditable() || x >= b.bXb() || kVarArr.length == 0) {
                        bXK();
                        this.uaj.a(1, motionEvent.getRawX(), motionEvent.getRawY(), motionEvent.getX(), motionEvent.getY(), offsetForPosition);
                        bXJ();
                        this.ind.K(500, 0);
                        return true;
                    }
                    x.i("noteeditor.WXRTEditText", "clicked todo");
                    this.tZK.bWW();
                    kVarArr[0].a(this, text, motionEvent, kVarArr[0]);
                    return true;
                case 1:
                    bXJ();
                    if (this.uaj == null) {
                        return true;
                    }
                    b bVar = this.uaj;
                    float rawX = motionEvent.getRawX();
                    float rawY = motionEvent.getRawY();
                    float x2 = motionEvent.getX();
                    float y = motionEvent.getY();
                    bVar.ubd = rawX;
                    bVar.ube = rawY;
                    bVar.ubf = x2;
                    bVar.ubg = y;
                    if (bVar.kZv == 1) {
                        bVar.ubh = offsetForPosition;
                    } else {
                        bVar.ubh = 0;
                    }
                    length = this.uaj.getType();
                    bXK();
                    if (length != 2) {
                        return true;
                    }
                    if (e.bXS().isEditable()) {
                        boolean z2;
                        boolean z3;
                        if (!hasFocus()) {
                            requestFocus();
                            z2 = false;
                            z3 = false;
                        } else if (getSelectionStart() == getSelectionEnd() && offsetForPosition == getSelectionStart()) {
                            z2 = true;
                            z3 = true;
                        } else {
                            z2 = false;
                            z3 = true;
                        }
                        this.uak = true;
                        setSelection(offsetForPosition);
                        this.uak = false;
                        if (this.tZK != null) {
                            this.tZK.f(true, 50);
                            this.tZK.BI(1);
                        }
                        ew(offsetForPosition, offsetForPosition);
                        e.bXS().N(z3, z2);
                        return true;
                    }
                    d bXU = e.bXS().bXU();
                    if (e.bXS().bXZ() && bXU.bXR() == 1 && bXU.hna == this.uah && bXU.startOffset == offsetForPosition) {
                        z = true;
                    }
                    ew(offsetForPosition, offsetForPosition);
                    e bXS = e.bXS();
                    if (!e.mHasInit) {
                        return true;
                    }
                    bXS.bYa();
                    bXS.bXY();
                    bXS.g(true, 50);
                    bXS.kU(true);
                    bXS.kT(z);
                    return true;
                case 3:
                    bXK();
                    bXJ();
                    return true;
                default:
                    return true;
            }
        }
        if (motionEvent.getAction() == 1 && this.tZK != null) {
            this.tZK.f(true, 300);
            this.tZK.BI(1);
        }
        return super.onTouchEvent(motionEvent);
    }

    private void bXJ() {
        if (this.ind == null) {
            this.ind = new al(new al.a() {
                public final boolean uG() {
                    if (WXRTEditText.this.uaj != null && WXRTEditText.this.uaj.getType() == 1) {
                        int i = WXRTEditText.this.uaj.ubc;
                        WXRTEditText.this.bXK();
                        WXRTEditText.this.Z(i, false);
                    }
                    return true;
                }
            }, false);
        } else {
            this.ind.TN();
        }
    }

    public final void Z(int i, boolean z) {
        Editable text = getText();
        if (text != null) {
            Layout layout = getLayout();
            if (layout != null) {
                int length = text.length();
                if (i >= 0 && i <= length) {
                    int i2;
                    if (length == 0) {
                        i = 0;
                        i2 = 0;
                    } else {
                        if (i < length) {
                            if (z || text.charAt(i) != 10) {
                                i2 = i;
                                i = layout.getOffsetToRightOf(i);
                            }
                        } else if (i == length && z) {
                            i2 = layout.getOffsetToLeftOf(i);
                        }
                        i2 = i;
                    }
                    if (i2 >= 0 && i2 <= length && i >= 0 && i <= length) {
                        if (e.bXS().isEditable()) {
                            requestFocus();
                            this.uak = true;
                            setSelection(i2, i);
                            this.uak = false;
                            if (this.tZK != null) {
                                this.tZK.f(true, 50);
                                this.tZK.BI(1);
                            }
                        }
                        ew(i2, i);
                        e.bXS().N(true, true);
                    }
                }
            }
        }
    }

    private void bXK() {
        if (this.uaj == null) {
            this.uaj = new b();
        } else {
            this.uaj.reset();
        }
    }

    private void ew(int i, int i2) {
        if (this.tZU == 2) {
            e.bXS().t(this.uah, 1, this.uah, 1);
        } else if (this.tZU == 1) {
            e.bXS().t(this.uah, 0, this.uah, 0);
        } else {
            e.bXS().t(this.uah, i, this.uah, i2);
        }
    }
}
