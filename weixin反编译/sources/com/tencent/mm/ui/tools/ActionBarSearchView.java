package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.AutoMatchKeywordEditText;
import com.tencent.mm.v.a.e;
import com.tencent.mm.v.a.f;
import com.tencent.mm.v.a.g;
import com.tencent.mm.v.a.h;
import com.tencent.mm.v.a.j;
import com.tencent.mm.v.a.k;
import java.util.ArrayList;

public class ActionBarSearchView extends LinearLayout implements f {
    private TextWatcher vxT = new TextWatcher() {
        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            ActionBarSearchView.this.cyn();
            t b = ActionBarSearchView.this.zpt;
            if (b.zwy) {
                EditText editText = (EditText) b.zww.get();
                if (editText != null) {
                    if (((charSequence == null || charSequence.toString() == null || charSequence.toString().length() == 0) && (b.kav == null || b.kav.length() == 0)) || !(b.kav == null || charSequence == null || !b.kav.equals(charSequence.toString()))) {
                        x.d("MicroMsg.WordsChecker", "text not change, new : %s, old : %s", charSequence, b.kav);
                    } else {
                        b.kav = charSequence != null ? charSequence.toString() : "";
                        b.zwv = t.k(b.kav, b.zwx);
                        if (t.a(editText, b.zwx)) {
                            x.d("MicroMsg.WordsChecker", "decorate text succ.");
                        }
                    }
                }
            }
            if (ActionBarSearchView.this.zpu != null) {
                ActionBarSearchView.this.zpu.Eu(charSequence == null ? "" : charSequence.toString());
            }
        }

        public final void afterTextChanged(Editable editable) {
        }
    };
    private View zpo;
    private ActionBarEditText zpp;
    private ImageButton zpq;
    private int zpr = c.zpC;
    private boolean zps = false;
    private t zpt;
    public b zpu;
    public a zpv;
    private OnFocusChangeListener zpw = new OnFocusChangeListener() {
        public final void onFocusChange(View view, boolean z) {
            x.v("MicroMsg.ActionBarSearchView", "on edittext focus changed, hasFocus %B", Boolean.valueOf(z));
            if (ActionBarSearchView.this.zpx != null) {
                ActionBarSearchView.this.zpx.onFocusChange(view, z);
            }
        }
    };
    public OnFocusChangeListener zpx;
    private OnClickListener zpy = new OnClickListener() {
        public final void onClick(View view) {
            if (c.zpC == ActionBarSearchView.this.zpr) {
                x.d("MicroMsg.ActionBarSearchView", "on status btn click, cur status is clear");
                ActionBarSearchView.this.nz(true);
                if (ActionBarSearchView.this.zpu != null) {
                    ActionBarSearchView.this.zpu.XC();
                    return;
                }
                return;
            }
            x.d("MicroMsg.ActionBarSearchView", "on status btn click, cur status is voice search");
            if (ActionBarSearchView.this.zpu != null) {
                ActionBarSearchView.this.zpu.aXf();
            }
        }
    };
    private OnClickListener zpz = new OnClickListener() {
        public final void onClick(View view) {
            if (ActionBarSearchView.this.zpv != null) {
                ActionBarSearchView.this.zpv.aXg();
            }
        }
    };

    public interface a {
        void aXg();
    }

    public interface b {
        void Eu(String str);

        void XC();

        void aXe();

        void aXf();
    }

    private enum c {
        ;

        static {
            zpC = 1;
            zpD = 2;
            zpE = new int[]{zpC, zpD};
        }
    }

    class d extends Drawable {
        private RectF fE;
        private String kav;
        private Paint zpF;
        private int zpG = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(ad.getContext(), 2.0f);
        private float zpH;
        private float zpI;
        private Bitmap zpJ;

        d(EditText editText, String str) {
            this.zpF = new Paint(editText.getPaint());
            this.kav = str;
            this.zpF.setColor(ad.getResources().getColor(com.tencent.mm.v.a.d.bsE));
            this.zpJ = com.tencent.mm.sdk.platformtools.d.u(ActionBarSearchView.this.getResources().getDrawable(j.dvl));
            this.zpH = this.zpF.measureText(this.kav);
            FontMetrics fontMetrics = this.zpF.getFontMetrics();
            this.zpI = (float) Math.ceil((double) (fontMetrics.bottom - fontMetrics.top));
            setBounds(0, 0, (int) ((((this.zpH + ((float) (this.zpG * 2))) + ((float) (this.zpG * 2))) + ((float) this.zpJ.getWidth())) + 2.0f), (int) (((float) this.zpJ.getHeight()) > this.zpI ? (float) this.zpJ.getHeight() : this.zpI));
        }

        public final void draw(Canvas canvas) {
            FontMetricsInt fontMetricsInt = this.zpF.getFontMetricsInt();
            Rect bounds = getBounds();
            int i = (bounds.top + ((((bounds.bottom - bounds.top) - fontMetricsInt.bottom) + fontMetricsInt.top) / 2)) - fontMetricsInt.top;
            canvas.drawBitmap(this.zpJ, (float) ((int) ((((float) (bounds.right - bounds.left)) - (this.fE.right - this.fE.left)) / 2.0f)), (float) bounds.top, null);
            canvas.drawText(this.kav, (float) ((bounds.left + this.zpJ.getWidth()) + 2), (float) i, this.zpF);
        }

        public final void setBounds(int i, int i2, int i3, int i4) {
            super.setBounds(i, i2, i3, i4);
            FontMetrics fontMetrics = this.zpF.getFontMetrics();
            this.fE = new RectF((float) (this.zpG + i), (fontMetrics.ascent - fontMetrics.top) + ((float) i2), (float) (i3 - this.zpG), (float) i4);
            invalidateSelf();
        }

        public final void setAlpha(int i) {
        }

        public final void setColorFilter(ColorFilter colorFilter) {
        }

        public final int getOpacity() {
            return -3;
        }
    }

    public static class ActionBarEditText extends AutoMatchKeywordEditText {
        ActionBarSearchView zpB;

        public ActionBarEditText(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
        }

        public ActionBarEditText(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            x.v("MicroMsg.ActionBarSearchView", "on onKeyPreIme");
            if (i == 4) {
                DispatcherState keyDispatcherState;
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    x.v("MicroMsg.ActionBarSearchView", "on onKeyPreIme action down");
                    keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    x.v("MicroMsg.ActionBarSearchView", "on onKeyPreIme action up");
                    keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        x.v("MicroMsg.ActionBarSearchView", "on onKeyPreIme action up is tracking");
                        this.zpB.clearFocus();
                        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
                        if (inputMethodManager != null) {
                            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
                        }
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }
    }

    public ActionBarSearchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ActionBarSearchView(Context context) {
        super(context);
        init();
    }

    private void init() {
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(h.gYH, this, true);
        this.zpo = findViewById(g.bIc);
        this.zpo.setOnClickListener(this.zpz);
        this.zpp = (ActionBarEditText) findViewById(g.cdl);
        this.zpt = new t(this.zpp);
        this.zpp.zpB = this;
        this.zpp.post(new Runnable() {
            public final void run() {
                ActionBarSearchView.this.zpp.setText("");
                if (ActionBarSearchView.this.zpu != null) {
                    ActionBarSearchView.this.zpu.aXe();
                }
            }
        });
        this.zpq = (ImageButton) findViewById(g.cPs);
        this.zpp.addTextChangedListener(this.vxT);
        this.zpp.setOnKeyListener(new OnKeyListener() {
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (i != 67) {
                    return false;
                }
                x.d("MicroMsg.ActionBarSearchView", "on back key click.");
                t b = ActionBarSearchView.this.zpt;
                if (b.zwy) {
                    EditText editText = (EditText) b.zww.get();
                    if (!(editText == null || b.zwv == null)) {
                        CharSequence text = editText.getText();
                        int selectionStart = editText.getSelectionStart();
                        if (selectionStart == editText.getSelectionEnd()) {
                            b He = b.He(selectionStart);
                            if (He != null && He.zwB) {
                                text.delete(He.start, He.start + He.length);
                                editText.setTextKeepState(text);
                                editText.setSelection(He.start);
                                return true;
                            }
                        }
                        return false;
                    }
                }
                return false;
            }
        });
        this.zpp.zzQ = new com.tencent.mm.ui.widget.AutoMatchKeywordEditText.a() {
            public final void b(EditText editText, int i, int i2) {
                x.d("MicroMsg.ActionBarSearchView", "start : %d, stop : %d", Integer.valueOf(i), Integer.valueOf(i2));
                t b = ActionBarSearchView.this.zpt;
                if (b.zwy) {
                    EditText editText2 = (EditText) b.zww.get();
                    if (editText2 != null && editText == editText2) {
                        CharSequence text = editText2.getText();
                        int selectionStart = editText2.getSelectionStart();
                        int selectionEnd = editText2.getSelectionEnd();
                        if (selectionStart >= 0 && selectionEnd >= selectionStart) {
                            if (selectionStart == selectionEnd) {
                                b He = b.He(selectionStart);
                                if (He != null && He.zwB) {
                                    editText2.setTextKeepState(text);
                                    editText2.setSelection(He.length + He.start);
                                    return;
                                }
                                return;
                            }
                            b He2 = b.He(selectionStart);
                            if (He2 != null && He2.zwB) {
                                selectionStart = He2.start + He2.length;
                            }
                            if (selectionStart >= selectionEnd) {
                                editText2.setTextKeepState(text);
                                editText2.setSelection(selectionStart);
                                return;
                            }
                            b He3 = b.He(selectionEnd);
                            if (He3 != null && He3.zwB) {
                                int i3 = He3.start;
                                editText2.setTextKeepState(text);
                                editText2.setSelection(selectionStart, i3);
                            }
                        }
                    }
                }
            }
        };
        this.zpp.setOnFocusChangeListener(this.zpw);
        com.tencent.mm.ui.tools.a.c.d(this.zpp).Hg(100).a(null);
        this.zpq.setOnClickListener(this.zpy);
    }

    public final String bVF() {
        if (this.zpp.getEditableText() != null) {
            return this.zpp.getEditableText().toString();
        }
        return "";
    }

    public final void a(b bVar) {
        this.zpu = bVar;
    }

    public final void a(a aVar) {
        this.zpv = aVar;
    }

    public final void aay(String str) {
        Object str2;
        if (str2 == null) {
            str2 = "";
        }
        this.zpp.setText(str2);
        this.zpp.setSelection(str2.length());
    }

    public final void setHint(CharSequence charSequence) {
        this.zpp.setHint(charSequence);
    }

    public final void nw(boolean z) {
        this.zps = z;
        cyn();
    }

    public final void nx(boolean z) {
        this.zpp.setEnabled(z);
    }

    public final void ny(boolean z) {
        this.zpq.setEnabled(z);
    }

    private void fh(int i, int i2) {
        this.zpq.setImageResource(i);
        this.zpq.setBackgroundResource(0);
        if (i == f.gWQ) {
            this.zpq.setContentDescription(getContext().getString(k.hax));
        } else {
            this.zpq.setContentDescription(getContext().getString(k.bWi));
        }
        LayoutParams layoutParams = this.zpq.getLayoutParams();
        layoutParams.width = i2;
        this.zpq.setLayoutParams(layoutParams);
    }

    private void cyn() {
        if (this.zpp.getEditableText() != null && !bi.oN(this.zpp.getEditableText().toString())) {
            fh(f.gWH, getResources().getDimensionPixelSize(e.bvI));
            this.zpr = c.zpC;
        } else if (this.zps) {
            fh(f.gWQ, getResources().getDimensionPixelSize(e.bvI));
            this.zpr = c.zpD;
        } else {
            fh(0, 0);
            this.zpr = c.zpC;
        }
    }

    public final void setOnEditorActionListener(OnEditorActionListener onEditorActionListener) {
        this.zpp.setOnEditorActionListener(onEditorActionListener);
    }

    public final void nz(boolean z) {
        if (z) {
            this.zpp.setText("");
            return;
        }
        this.zpp.removeTextChangedListener(this.vxT);
        this.zpp.setText("");
        this.zpp.addTextChangedListener(this.vxT);
    }

    public final void cyo() {
        this.zpp.clearFocus();
    }

    public final void a(com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper.a aVar) {
    }

    public final boolean cyp() {
        if (this.zpp != null) {
            return this.zpp.hasFocus();
        }
        return false;
    }

    public final boolean cyq() {
        if (this.zpp != null) {
            return this.zpp.requestFocus();
        }
        return false;
    }

    public final void ak(ArrayList<String> arrayList) {
        if (this.zpt != null) {
            t tVar = this.zpt;
            tVar.zwx = arrayList;
            if (tVar.zwy) {
                EditText editText = (EditText) tVar.zww.get();
                if (editText != null) {
                    t.a(editText, tVar.zwx);
                }
            }
        }
    }

    public final void nA(boolean z) {
        if (this.zpt != null) {
            this.zpt.zwy = z;
        }
    }

    public final void Hc(int i) {
        if (this.zpp != null) {
            this.zpp.setCompoundDrawables(ad.getResources().getDrawable(i), null, null, null);
        }
    }

    public final void aaz(String str) {
        if (this.zpp != null) {
            this.zpp.setCompoundDrawables(new d(this.zpp, str), null, null, null);
            this.zpp.setHint("");
        }
    }
}
