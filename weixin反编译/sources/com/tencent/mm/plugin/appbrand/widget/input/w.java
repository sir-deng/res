package com.tencent.mm.plugin.appbrand.widget.input;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.Editable.Factory;
import android.text.Layout.Alignment;
import android.text.Selection;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.text.style.AlignmentSpan.Standard;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.bw.c;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.plugin.appbrand.widget.b.d;
import com.tencent.mm.plugin.appbrand.widget.input.autofill.b;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.Map;

@SuppressLint({"AppCompatCustomView"})
public abstract class w extends EditText implements d, z {
    private Method keA;
    boolean keB = false;
    private final b keC;
    private final Map<com.tencent.mm.plugin.appbrand.widget.input.z.a, Object> keD = new android.support.v4.e.a();
    private final Map<OnFocusChangeListener, Object> keE = new android.support.v4.e.a();
    private final Map<z.b, Object> keF = new android.support.v4.e.a();
    private final a keG = new a();
    private final PasswordTransformationMethod keH = new k();
    final x keI = new x(this);
    private boolean keJ;
    private int keK = 0;
    private boolean keL = false;
    private final int[] keM = new int[2];
    InputConnection kez;
    volatile int mInputId = -1;

    private final class a implements TextWatcher {
        final Map<TextWatcher, Object> keO;

        private a() {
            this.keO = new android.support.v4.e.a();
        }

        /* synthetic */ a(w wVar, byte b) {
            this();
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (!w.a(w.this) && !this.keO.isEmpty()) {
                for (TextWatcher beforeTextChanged : (TextWatcher[]) this.keO.keySet().toArray(new TextWatcher[this.keO.size()])) {
                    beforeTextChanged.beforeTextChanged(charSequence, i, i2, i3);
                }
            }
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (!w.a(w.this) && !this.keO.isEmpty()) {
                for (TextWatcher onTextChanged : (TextWatcher[]) this.keO.keySet().toArray(new TextWatcher[this.keO.size()])) {
                    onTextChanged.onTextChanged(charSequence, i, i2, i3);
                }
            }
        }

        public final void afterTextChanged(Editable editable) {
            if (e.ang()) {
                PBool pBool = new PBool();
                PInt pInt = new PInt();
                final String a = w.a(editable, pBool, pInt);
                final int i = pInt.value;
                if (pBool.value && !bi.oN(a)) {
                    final int selectionEnd = Selection.getSelectionEnd(editable);
                    final boolean a2 = w.a(w.this);
                    w.this.post(new Runnable() {
                        public final void run() {
                            if (a2) {
                                w.this.r(a);
                            } else {
                                w.this.setText(a);
                            }
                            try {
                                w.this.setSelection(Math.min(selectionEnd + i, a.length()));
                            } catch (Exception e) {
                                x.e("MicroMsg.AppBrand.WebEditText", "replace softBank to unicode, setSelection ", e);
                            }
                        }
                    });
                    return;
                }
            }
            if (!w.a(w.this)) {
                w.this.keK = 0;
                if (!this.keO.isEmpty()) {
                    for (TextWatcher afterTextChanged : (TextWatcher[]) this.keO.keySet().toArray(new TextWatcher[this.keO.size()])) {
                        afterTextChanged.afterTextChanged(editable);
                    }
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.w$2 */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] azD = new int[Alignment.values().length];

        static {
            try {
                azD[Alignment.ALIGN_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                azD[Alignment.ALIGN_OPPOSITE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    protected abstract void ant();

    static /* synthetic */ String a(Editable editable, PBool pBool, PInt pInt) {
        pInt.value = 0;
        pBool.value = false;
        if (editable == null || editable.length() <= 0) {
            return null;
        }
        String obj = editable.toString();
        int length = editable.length();
        int i = 0;
        while (i < length) {
            String str;
            int codePointAt = obj.codePointAt(i);
            c DD = com.tencent.mm.bw.b.chK().DD(codePointAt);
            if (DD == null || DD.xte == 0) {
                str = obj;
            } else {
                str = obj.replace(new String(Character.toChars(codePointAt)), Character.toChars(DD.xte) + (DD.xtf != 0 ? Character.toChars(DD.xtf) : ""));
                pBool.value = true;
                pInt.value++;
            }
            i++;
            obj = str;
        }
        return obj;
    }

    static /* synthetic */ boolean a(w wVar) {
        return wVar.keK > 0;
    }

    public final int getInputId() {
        return this.mInputId;
    }

    public final void mu(int i) {
        this.mInputId = i;
    }

    public String toString() {
        return String.format(Locale.US, "[%s|%s]", new Object[]{getClass().getSimpleName(), Integer.valueOf(this.mInputId)});
    }

    public final View getView() {
        return this;
    }

    public boolean ans() {
        return true;
    }

    public final b anH() {
        return this.keC;
    }

    public void r(float f, float f2) {
        throw new IllegalStateException("Should implement performClick(float, float) in this class!");
    }

    public final void a(com.tencent.mm.plugin.appbrand.widget.input.z.a aVar) {
        this.keD.put(aVar, this);
    }

    public final void a(OnFocusChangeListener onFocusChangeListener) {
        if (onFocusChangeListener != null) {
            this.keE.put(onFocusChangeListener, this);
        }
    }

    public final void b(OnFocusChangeListener onFocusChangeListener) {
        if (onFocusChangeListener != null) {
            this.keE.remove(onFocusChangeListener);
        }
    }

    public final void a(z.b bVar) {
        this.keF.put(bVar, this);
    }

    public w(Context context) {
        super(context);
        setBackgroundDrawable(null);
        setIncludeFontPadding(false);
        mv(3);
        setSingleLine(true);
        try {
            new com.tencent.mm.compatible.loader.c(this, "mCursorDrawableRes", TextView.class.getName()).set(Integer.valueOf(f.ivC));
        } catch (Throwable e) {
            x.d("MicroMsg.AppBrand.WebEditText", "setTextCursorDrawable, exp = %s", bi.i(e));
        }
        setTextIsSelectable(true);
        setFocusable(true);
        setFocusableInTouchMode(true);
        if (VERSION.SDK_INT >= 16) {
            setLineSpacing(0.0f, 1.0f);
        }
        setTypeface(Typeface.SANS_SERIF);
        super.addTextChangedListener(this.keG);
        super.setPadding(0, 0, 0, 0);
        super.setEditableFactory(new Factory() {
            public final Editable newEditable(CharSequence charSequence) {
                return w.this.c(super.newEditable(charSequence));
            }
        });
        try {
            this.keA = TextView.class.getDeclaredMethod("nullLayouts", new Class[0]);
        } catch (Exception e2) {
        }
        if (ans()) {
            this.keC = new b(this);
        } else {
            this.keC = null;
        }
        this.keJ = true;
    }

    public boolean amZ() {
        return false;
    }

    private void mv(int i) {
        setGravity(((getGravity() & -8388612) & -8388614) | i);
        int gravity = getGravity();
        CharSequence hint = getHint();
        if (!TextUtils.isEmpty(hint)) {
            Alignment alignment;
            hint = af.s(hint);
            switch (gravity & 7) {
                case 1:
                    alignment = Alignment.ALIGN_CENTER;
                    break;
                case 5:
                    alignment = Alignment.ALIGN_OPPOSITE;
                    break;
                default:
                    alignment = Alignment.ALIGN_NORMAL;
                    break;
            }
            hint.setSpan(new Standard(alignment), 0, getHint().length(), 18);
            super.setHint(hint);
            if (VERSION.SDK_INT >= 17) {
                switch (AnonymousClass2.azD[alignment.ordinal()]) {
                    case 1:
                        gravity = 4;
                        break;
                    case 2:
                        gravity = 6;
                        break;
                    default:
                        gravity = 5;
                        break;
                }
                super.setTextAlignment(gravity);
            }
        }
    }

    Editable c(Editable editable) {
        return this.keI.c(editable);
    }

    public final int mw(int i) {
        x.d("MicroMsg.AppBrand.WebEditText", "calculateLinePosition, lineNumber %d, returnHeight %d, layout %s", Integer.valueOf(i), Integer.valueOf(getPaddingTop() + ((int) (((float) i) * (((float) getLineHeight()) + getLineSpacingExtra())))), getLayout());
        return getPaddingTop() + ((int) (((float) i) * (((float) getLineHeight()) + getLineSpacingExtra())));
    }

    public final int anI() {
        return mw(getLineCount()) + getPaddingBottom();
    }

    public final void anJ() {
        mv(3);
    }

    public final void anK() {
        mv(5);
    }

    public final void anL() {
        mv(1);
    }

    public void setSelection(int i) {
        if (getEditableText() != null) {
            super.setSelection(Math.min(i, getEditableText().length()));
        }
    }

    public void setSelection(int i, int i2) {
        super.setSelection(i, i2);
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        this.kez = super.onCreateInputConnection(editorInfo);
        return this.kez;
    }

    public void setText(CharSequence charSequence, BufferType bufferType) {
        super.setText(charSequence, bufferType);
    }

    public void setMinHeight(int i) {
        if (getMinHeight() != i) {
            super.setMinHeight(i);
        }
    }

    public void setMaxHeight(int i) {
        if (getMaxHeight() != i) {
            super.setMaxHeight(i);
        }
    }

    protected final void onMeasure(int i, int i2) {
        x.v("MicroMsg.AppBrand.WebEditText", "[scrollUp] input onMeasure");
        super.onMeasure(i, i2);
        if (!this.keF.isEmpty()) {
            for (Object obj : this.keF.keySet().toArray()) {
                z.b bVar = (z.b) obj;
                getMeasuredWidth();
                getMeasuredHeight();
                bVar.anu();
            }
        }
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        x.v("MicroMsg.AppBrand.WebEditText", "[scrollUp] input onLayout");
        super.onLayout(z, i, i2, i3, i4);
    }

    final void anM() {
        this.keK++;
    }

    final void anN() {
        this.keK = Math.max(0, this.keK - 1);
    }

    public final void r(CharSequence charSequence) {
        anM();
        Editable editableText = getEditableText();
        if (editableText == null) {
            setText(charSequence, BufferType.EDITABLE);
        } else {
            clearComposingText();
            if (TextUtils.isEmpty(charSequence)) {
                editableText.clear();
            } else {
                editableText.replace(0, editableText.length(), charSequence);
            }
        }
        anN();
    }

    public final void r(p pVar) {
        if (this.keC != null) {
            com.tencent.mm.plugin.appbrand.widget.input.autofill.c cVar = this.keC.kfQ;
            cVar.kgb = pVar;
            i l = i.l(pVar);
            com.tencent.mm.plugin.appbrand.widget.input.i.a aVar = cVar.kga;
            if (aVar != null && !l.kcZ.containsKey(aVar)) {
                l.kcZ.put(aVar, l);
            }
        }
    }

    public final void s(p pVar) {
        if (this.keC != null) {
            i.l(pVar).a(this.keC.kfQ.kga);
        }
    }

    public final void dC(boolean z) {
        this.keL = z;
    }

    public boolean anv() {
        return this.keL;
    }

    public void dz(boolean z) {
        anM();
        this.keB = z;
        setTransformationMethod(z ? this.keH : null);
        anN();
    }

    public void setInputType(int i) {
        if (getInputType() != i) {
            super.setInputType(i);
        }
    }

    public void setSingleLine(boolean z) {
    }

    public final void setTextSize(float f) {
        setTextSize(0, f);
    }

    public void setTextSize(int i, float f) {
        super.setTextSize(i, f);
    }

    public void setTypeface(Typeface typeface) {
        super.setTypeface(typeface);
    }

    public void setTypeface(Typeface typeface, int i) {
        super.setTypeface(typeface, i);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void addTextChangedListener(TextWatcher textWatcher) {
        a aVar = this.keG;
        if (textWatcher != null) {
            aVar.keO.put(textWatcher, aVar);
        }
    }

    public void removeTextChangedListener(TextWatcher textWatcher) {
        a aVar = this.keG;
        if (textWatcher != null) {
            aVar.keO.remove(textWatcher);
        }
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!this.keD.isEmpty()) {
            for (com.tencent.mm.plugin.appbrand.widget.input.z.a anO : (com.tencent.mm.plugin.appbrand.widget.input.z.a[]) this.keD.keySet().toArray(new com.tencent.mm.plugin.appbrand.widget.input.z.a[this.keD.size()])) {
                anO.anO();
            }
        }
    }

    protected void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (!z) {
            clearComposingText();
        }
        if (z) {
            ant();
        }
        if (!this.keE.isEmpty()) {
            for (OnFocusChangeListener onFocusChange : (OnFocusChangeListener[]) this.keE.keySet().toArray(new OnFocusChangeListener[this.keE.size()])) {
                onFocusChange.onFocusChange(this, z);
            }
        }
    }

    public void clearFocus() {
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).setFocusableInTouchMode(true);
            ((ViewGroup) getParent()).setDescendantFocusability(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
        }
        super.clearFocus();
    }

    public boolean requestFocus(int i, Rect rect) {
        if (130 == i && rect == null && (getParent() instanceof ViewGroup)) {
            ((ViewGroup) getParent()).setDescendantFocusability(262144);
            ((ViewGroup) getParent()).setFocusableInTouchMode(false);
        }
        return super.requestFocus(i, rect);
    }

    @Deprecated
    public void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        super.setOnFocusChangeListener(onFocusChangeListener);
    }

    public final void destroy() {
        this.keD.clear();
        this.keF.clear();
        this.keE.clear();
        this.keG.keO.clear();
        if (this.keC != null) {
            b bVar = this.keC;
            com.tencent.mm.plugin.appbrand.widget.input.autofill.c cVar = bVar.kfQ;
            i.l(cVar.kgb).a(cVar.kga);
            bVar.kfT = null;
            bVar.kfO.dismiss();
        }
        setOnFocusChangeListener(null);
    }
}
