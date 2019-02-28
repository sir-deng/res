package com.tencent.mm.plugin.appbrand.widget.input;

import android.app.Activity;
import android.os.Looper;
import android.support.v4.view.z;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.ui.j;
import com.tencent.mm.plugin.appbrand.widget.input.b.e;
import com.tencent.mm.plugin.appbrand.widget.input.b.h;
import com.tencent.mm.plugin.appbrand.widget.input.u.d;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.lang.ref.WeakReference;
import junit.framework.Assert;

public abstract class AppBrandInputInvokeHandler implements y<w> {
    private static final String TAG = "MicroMsg.AppBrandInputInvokeHandler";
    private final ag H = new ag(Looper.getMainLooper());
    private final com.tencent.mm.ui.tools.a.c.a inputExceedMaxLengthCallback = new com.tencent.mm.plugin.appbrand.widget.input.n.a() {
        public final void aeD() {
            if (AppBrandInputInvokeHandler.this.mInput != null) {
                try {
                    AppBrandInputInvokeHandler.this.mValueChangeNotify.a(AppBrandInputInvokeHandler.this.mInput.getEditableText(), false);
                } catch (Exception e) {
                }
            }
        }
    };
    private final Runnable mAutoScrollForMultiLineRunnerAfterSmileyPanelSettle = new Runnable() {
        public final void run() {
            AppBrandInputInvokeHandler.this.mayAutoScrollIfMultiLine();
        }
    };
    private w mInput;
    final OnFocusChangeListener mInputFocusChangeListenerImpl = new OnFocusChangeListener() {
        public final void onFocusChange(View view, boolean z) {
            AppBrandInputInvokeHandler.this.notifyInputFocusChange(z);
            Object obj = (!z || (AppBrandInputInvokeHandler.this.mParams.khr && !j.bK(AppBrandInputInvokeHandler.this.mInput))) ? null : 1;
            if (obj != null && AppBrandInputInvokeHandler.this.mInput != null && AppBrandInputInvokeHandler.this.mSmileyPanel != null) {
                AppBrandInputInvokeHandler.this.mInput.requestFocus();
                AppBrandInputInvokeHandler.this.mSmileyPanel.show();
            }
        }
    };
    private int mInputId;
    private int mLastContentHeight = -1;
    private int mLastLineCount = -1;
    private t mNumberKeyboard;
    private volatile a mOnInputFocusChangeListener;
    private volatile b mOnLineHeightChangeListener;
    protected WeakReference<p> mPageRef;
    private e mParams;
    private boolean mPerformingDelete = false;
    private final Runnable mResetPerformingDelete = new Runnable() {
        public final void run() {
            AppBrandInputInvokeHandler.this.mPerformingDelete = false;
        }
    };
    private final d mSmileyChosenListener = new d() {
        public final boolean vD(String str) {
            if (AppBrandInputInvokeHandler.this.mInput != null) {
                w access$200;
                if ("[DELETE_EMOTION]".equalsIgnoreCase(str)) {
                    access$200 = AppBrandInputInvokeHandler.this.mInput;
                    if (access$200.kez == null) {
                        access$200.dispatchKeyEvent(new KeyEvent(0, 67));
                        access$200.dispatchKeyEvent(new KeyEvent(1, 67));
                    } else if (!bi.N(access$200.getEditableText())) {
                        access$200.kez.deleteSurroundingText(access$200.getEditableText().length(), access$200.getEditableText().length() - 1);
                    }
                } else {
                    access$200 = AppBrandInputInvokeHandler.this.mInput;
                    if (access$200.getEditableText() == null) {
                        access$200.setText(str, BufferType.EDITABLE);
                    } else {
                        access$200.getEditableText().append(str);
                    }
                    access$200.setSelection(access$200.getEditableText().length());
                }
            }
            return true;
        }
    };
    private final com.tencent.mm.plugin.appbrand.widget.input.u.c mSmileyOnDoneListener = new com.tencent.mm.plugin.appbrand.widget.input.u.c() {
        public final void dw(boolean z) {
            if (z) {
                AppBrandInputInvokeHandler.this.mTextDoneReason$25f24e96 = c.kcR;
            }
            AppBrandInputInvokeHandler.this.doneTextInput();
            AppBrandInputInvokeHandler.this.mTextDoneReason$25f24e96 = 0;
        }
    };
    private u mSmileyPanel;
    private final u.e mSmileyVisibilityListener = new u.e() {
        public final void ki(int i) {
            x.d(AppBrandInputInvokeHandler.TAG, "[appInput], onSmileyPanelVisibilityChanged = %d", Integer.valueOf(i));
            if (i != 2) {
                if (i == 0 && AppBrandInputInvokeHandler.this.mInput != null) {
                    AppBrandInputInvokeHandler.this.mInput.requestFocus();
                }
                AppBrandInputInvokeHandler.this.hideNumberKeyboard();
                if (AppBrandInputInvokeHandler.this.mPageRef != null && AppBrandInputInvokeHandler.this.mPageRef.get() != null) {
                    m.a((p) AppBrandInputInvokeHandler.this.mPageRef.get(), AppBrandInputInvokeHandler.this.mInput);
                    return;
                }
                return;
            }
            AppBrandInputInvokeHandler.this.mTextDoneReason$25f24e96 = c.kcQ;
            AppBrandInputInvokeHandler.this.doneTextInput();
            AppBrandInputInvokeHandler.this.mTextDoneReason$25f24e96 = 0;
        }
    };
    private int mTextDoneReason$25f24e96 = 0;
    private final com.tencent.mm.plugin.appbrand.widget.input.a.a mValueChangeNotify = new com.tencent.mm.plugin.appbrand.widget.input.a.a();

    public interface b {
        void bI(int i, int i2);
    }

    public interface a {
        void cN(boolean z);
    }

    private enum c {
        ;

        static {
            kcQ = 1;
            kcR = 2;
            kcS = new int[]{kcQ, kcR};
        }
    }

    public abstract void onInputDone(String str, int i, boolean z, boolean z2);

    public abstract void onInputInitialized();

    public abstract void onRuntimeFail();

    public void setOnValueChangeListener(com.tencent.mm.plugin.appbrand.widget.input.a.c cVar) {
        this.mValueChangeNotify.kgv = cVar;
    }

    public void setOnLineHeightChangeListener(b bVar) {
        this.mOnLineHeightChangeListener = bVar;
    }

    public void setOnInputFocusChangeListener(a aVar) {
        this.mOnInputFocusChangeListener = aVar;
    }

    public final void insertInput(e eVar, int i, int i2) {
        com.tencent.mm.plugin.appbrand.r.c.bk(this);
        this.mParams = eVar;
        insertInputImpl(i, i2);
    }

    final boolean updateInput(h hVar) {
        if (this.mParams == null || this.mInput == null) {
            return false;
        }
        this.mParams.a(hVar);
        if (!this.mParams.khs && (this.mParams.khw == null || this.mParams.khw.intValue() <= 0)) {
            return false;
        }
        this.mInput.setWillNotDraw(true);
        resetInputAttributes();
        if (this.mParams.khu != null) {
            this.mInput.r(bi.oM(this.mParams.khu));
        }
        if (af.e(this.mParams.khP)) {
            mayAutoResizeInputHeight();
            lineHeightMaybeChanged();
        } else {
            updateInputPosition(this.mInput, this.mParams);
        }
        this.mInput.setWillNotDraw(false);
        this.mInput.invalidate();
        return true;
    }

    public boolean isAttachedTo(p pVar) {
        return (pVar == null || this.mPageRef == null || pVar != this.mPageRef.get()) ? false : true;
    }

    public boolean showKeyboard(int i, int i2) {
        doShowKeyboard();
        setInputSelection(i, i2);
        return true;
    }

    public boolean hideKeyboard() {
        doHideKeyboard();
        return true;
    }

    public void updateValue(String str, Integer num) {
        if (this.mInput != null) {
            this.mInput.r((CharSequence) str);
            Integer valueOf = Integer.valueOf(num == null ? -1 : num.intValue());
            setInputSelection(valueOf.intValue(), valueOf.intValue());
            lineHeightMaybeChanged();
        }
    }

    public boolean isFocused() {
        return this.mInput != null && (this.mInput.isFocused() || (findSmileyPanel() != null && findSmileyPanel().afo() == this.mInput));
    }

    @Deprecated
    private void doHideKeyboard() {
        if (isFocused()) {
            u findSmileyPanel = findSmileyPanel();
            if (findSmileyPanel != null) {
                findSmileyPanel.setVisibility(8);
                return;
            }
            return;
        }
        x.d(TAG, "doHideKeyboard, not focused, return");
    }

    @Deprecated
    private void doShowKeyboard() {
        if (this.mInput != null && this.mPageRef != null && this.mPageRef.get() != null) {
            this.mInput.performClick();
        }
    }

    public boolean removeSelf() {
        if (!removeInput()) {
            return false;
        }
        onDestroy();
        return true;
    }

    @Deprecated
    private boolean removeInput() {
        if (this.mInput == null || this.mPageRef == null || this.mPageRef.get() == null) {
            return false;
        }
        this.mInput.destroy();
        f fVar = ((p) this.mPageRef.get()).jJv;
        if (fVar == null) {
            return false;
        }
        if (this.mInput.hasFocus()) {
            if (this.mNumberKeyboard != null) {
                this.mNumberKeyboard.setVisibility(8);
            }
            findSmileyPanel();
            if (this.mSmileyPanel != null) {
                this.mSmileyPanel.setVisibility(8);
            }
        }
        fVar.bR(this.mInput);
        return true;
    }

    public View getInputPanel() {
        return this.mSmileyPanel;
    }

    public w getWidget() {
        return this.mInput;
    }

    public boolean adjustPositionOnFocused() {
        return this.mParams != null && af.e(this.mParams.khU);
    }

    public int getInputPanelMarginBottom() {
        if (this.mParams != null && this.mParams.khR != null) {
            return this.mParams.khR.intValue();
        }
        if (this.mInput == null || !this.mInput.anr()) {
            return 0;
        }
        return 5;
    }

    private void onDestroy() {
        this.mInput = null;
        com.tencent.mm.plugin.appbrand.r.c.bl(this);
    }

    public final int getInputId() {
        return this.mInputId;
    }

    private void mayAutoResizeInputHeight() {
        if (this.mInput != null && af.e(this.mParams.khP) && af.e(this.mParams.khN)) {
            ((o) this.mInput).dy(true);
            int lineHeight = this.mInput.getLineHeight();
            int anI = this.mInput.anI();
            int intValue = (this.mParams.khz == null || this.mParams.khz.intValue() <= 0) ? lineHeight : this.mParams.khz.intValue();
            lineHeight = (this.mParams.khA == null || this.mParams.khA.intValue() <= 0) ? Integer.MAX_VALUE : Math.max(this.mParams.khA.intValue(), lineHeight);
            this.mInput.setMinHeight(intValue);
            this.mInput.setMaxHeight(lineHeight);
            this.mParams.khw = Integer.valueOf(Math.max(intValue, Math.min(anI, lineHeight)));
            updateInputPosition(this.mInput, this.mParams);
        }
    }

    private void resetInputAttributes() {
        b.a(this.mInput, this.mParams);
        if (this.mParams.khG == null) {
            this.mParams.khG = Integer.valueOf(com.tencent.mm.plugin.appbrand.jsapi.map.b.CTRL_INDEX);
        } else if (this.mParams.khG.intValue() <= 0) {
            this.mParams.khG = Integer.valueOf(Integer.MAX_VALUE);
        }
        com.tencent.mm.ui.tools.a.c Hg = n.a(this.mInput).Hg(this.mParams.khG.intValue());
        Hg.zwQ = false;
        Hg.kdI = com.tencent.mm.ui.tools.h.a.ztX;
        Hg.a(this.inputExceedMaxLengthCallback);
        this.mInput.dz(this.mParams.khq);
        if (af.e(this.mParams.khL)) {
            this.mInput.setEnabled(false);
            this.mInput.setFocusable(false);
            this.mInput.setFocusableInTouchMode(false);
            this.mInput.setClickable(false);
        } else {
            this.mInput.setEnabled(true);
            this.mInput.setClickable(true);
        }
        if (this.mInput instanceof o) {
            o oVar;
            if (this.mParams.khV != null) {
                oVar = (o) this.mInput;
                oVar.setLineSpacing((float) this.mParams.khV.intValue(), oVar.kdO);
            }
            if (this.mParams.khW != null) {
                oVar = (o) this.mInput;
                float intValue = (float) this.mParams.khW.intValue();
                if (intValue > 0.0f) {
                    oVar.a(intValue, true);
                }
            }
        }
    }

    private void setInputSelection(int i, int i2) {
        b.a(this.mInput, i, i2);
        mayAutoScrollIfMultiLine();
    }

    private void lineHeightMaybeChanged() {
        if (this.mInput != null) {
            if (this.mInput.getLineCount() != this.mLastLineCount || this.mInput.anI() != this.mLastContentHeight) {
                Object obj = this.mLastLineCount == -1 ? 1 : null;
                this.mLastLineCount = this.mInput.getLineCount();
                this.mLastContentHeight = this.mInput.anI();
                if (this.mOnLineHeightChangeListener != null) {
                    this.mOnLineHeightChangeListener.bI(this.mLastLineCount, this.mLastContentHeight);
                }
                if (this.mParams.khN.booleanValue() && obj == null) {
                    mayAutoResizeInputHeight();
                    mayAutoScrollIfMultiLine();
                }
            }
        }
    }

    private void mayAutoScrollIfMultiLine() {
        if (this.mParams.khN.booleanValue() && this.mSmileyPanel != null && this.mSmileyPanel.isShown() && this.mInput != null && this.mInput == this.mSmileyPanel.afo()) {
            i.a(this.mPageRef).anj();
        }
    }

    private void setupSmileyFocus() {
        if (this.mParams.khN.booleanValue()) {
            findSmileyPanel();
        }
        if (this.mSmileyPanel != null && this.mInput != null) {
            this.mSmileyPanel.ker = this.mInput;
            this.mSmileyPanel.dB(af.e(this.mParams.khO));
            setupSmileyPanelListeners();
            if (j.bK(this.mInput) && this.mInput.hasFocus()) {
                this.mSmileyPanel.show();
            }
        }
    }

    private void notifyInputFocusChange(boolean z) {
        if (z) {
            setupSmileyFocus();
        }
        if (this.mSmileyPanel == null) {
            this.mSmileyPanel = findSmileyPanel();
        }
        if (this.mOnInputFocusChangeListener != null) {
            this.mOnInputFocusChangeListener.cN(z);
        }
        if (this.mInput != null && z && this.mParams.khN.booleanValue()) {
            ah.h(this.mAutoScrollForMultiLineRunnerAfterSmileyPanelSettle, 100);
        }
        if (!(this.mInput == null || z || this.mParams.khr)) {
            if (this.mTextDoneReason$25f24e96 == 0) {
                dispatchKeyboardComplete(false);
            }
            this.mInput.setFocusable(false);
            this.mInput.setFocusableInTouchMode(false);
            if (this.mSmileyPanel.afo() == this.mInput) {
                this.mSmileyPanel.hide();
                this.mSmileyPanel.b(this.mInput);
            }
        }
        if (this.mSmileyPanel != null && this.mInput != null && !z && this.mParams.khr) {
            removeInputWhenFocusLoss();
        }
    }

    private void removeInputWhenFocusLoss() {
        dispatchKeyboardComplete(false);
        if (this.mParams.khr) {
            removeInputImpl(this.mInput);
            onDestroy();
        }
    }

    private void insertInputImpl(int i, int i2) {
        this.mPageRef = this.mParams.kcw;
        p pVar = this.mPageRef == null ? null : (p) this.mPageRef.get();
        if (pVar == null || pVar.jJw == null) {
            x.e(TAG, "insertInputImpl, view not ready, return fail");
            onRuntimeFail();
            return;
        }
        w oVar;
        if (af.e(this.mParams.khN)) {
            oVar = new o(pVar.mContext);
        } else {
            oVar = new r(pVar.mContext);
        }
        this.mInput = oVar;
        resetInputAttributes();
        this.mInput.setText(bi.oM(this.mParams.khu));
        if (af.e(this.mParams.khP)) {
            lineHeightMaybeChanged();
        }
        this.mInput.addTextChangedListener(new com.tencent.mm.ui.widget.j() {
            public final void afterTextChanged(Editable editable) {
                if (AppBrandInputInvokeHandler.this.mPageRef != null && AppBrandInputInvokeHandler.this.mPageRef.get() != null && AppBrandInputInvokeHandler.this.mInput != null) {
                    AppBrandInputInvokeHandler.this.lineHeightMaybeChanged();
                    if (af.t(editable)) {
                        x.d(AppBrandInputInvokeHandler.TAG, "[bindInput] text composing %s", editable);
                        return;
                    }
                    x.d(AppBrandInputInvokeHandler.TAG, "[bindInput] not composing text %s", editable);
                    AppBrandInputInvokeHandler.this.mValueChangeNotify.a(AppBrandInputInvokeHandler.this.mInput.getEditableText(), AppBrandInputInvokeHandler.this.mPerformingDelete);
                }
            }
        });
        this.mInput.keI.keU = new com.tencent.mm.plugin.appbrand.widget.input.a.b() {
            public final void aeE() {
                if (AppBrandInputInvokeHandler.this.mInput != null) {
                    x.d(AppBrandInputInvokeHandler.TAG, "[bindInput] onComposingDismissed %s", AppBrandInputInvokeHandler.this.mInput.getEditableText());
                    AppBrandInputInvokeHandler.this.mValueChangeNotify.a(AppBrandInputInvokeHandler.this.mInput.getEditableText(), false);
                }
            }
        };
        if (addInputImpl(this.mInput, this.mParams)) {
            if (!(this.mParams.kht == null || bi.cC(this.mParams.kht.khd))) {
                com.tencent.mm.plugin.appbrand.widget.input.autofill.d.a(pVar, this.mInput, this.mParams.kht);
            }
            if (!af.e(this.mParams.khN)) {
                b.a(this.mInput, i, i2);
            }
            if (af.e(this.mParams.khN)) {
                this.mInput.post(new Runnable() {
                    public final void run() {
                        AppBrandInputInvokeHandler.this.lineHeightMaybeChanged();
                    }
                });
            }
            if ("text".equalsIgnoreCase(this.mParams.khp) || "emoji".equalsIgnoreCase(this.mParams.khp)) {
                initSmileyPanelAndShow();
            } else {
                Assert.assertTrue("Number type implementation removed from here", false);
            }
            this.mInputId = this.mParams.kcA;
            this.mInput.mInputId = this.mInputId;
            this.mInput.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    if (AppBrandInputInvokeHandler.this.mInput != null) {
                        if (AppBrandInputInvokeHandler.this.mInput.hasFocus()) {
                            AppBrandInputInvokeHandler.this.setupSmileyFocus();
                            return;
                        }
                        p pVar = AppBrandInputInvokeHandler.this.mPageRef == null ? null : (p) AppBrandInputInvokeHandler.this.mPageRef.get();
                        if (pVar != null) {
                            g.anh().o(pVar.jJw);
                        }
                        if (AppBrandInputInvokeHandler.this.mInput != null && view == AppBrandInputInvokeHandler.this.mInput) {
                            AppBrandInputInvokeHandler.this.mInput.setFocusable(true);
                            AppBrandInputInvokeHandler.this.mInput.setFocusableInTouchMode(true);
                            AppBrandInputInvokeHandler.this.mSmileyPanel.ker = AppBrandInputInvokeHandler.this.mInput;
                            AppBrandInputInvokeHandler.this.mInput.requestFocus();
                        }
                    }
                }
            });
            m.a(this.mInputId, (y) this);
            onInputInitialized();
            return;
        }
        x.e(TAG, "add custom view into webView failed");
        onRuntimeFail();
    }

    boolean addInputImpl(w wVar, e eVar) {
        if (wVar == null || this.mPageRef == null || this.mPageRef.get() == null) {
            return false;
        }
        f fVar = ((p) this.mPageRef.get()).jJv;
        if (fVar != null) {
            if (fVar.a(((p) this.mPageRef.get()).jJw, wVar, eVar.khv.intValue(), eVar.khw.intValue(), eVar.khy.intValue(), eVar.khx.intValue())) {
                return true;
            }
        }
        return false;
    }

    boolean updateInputPosition(w wVar, e eVar) {
        if (wVar == null || this.mPageRef == null || this.mPageRef.get() == null) {
            return false;
        }
        f fVar = ((p) this.mPageRef.get()).jJv;
        if (fVar != null) {
            if (fVar.b(((p) this.mPageRef.get()).jJw, wVar, eVar.khv.intValue(), eVar.khw.intValue(), eVar.khy.intValue(), eVar.khx.intValue())) {
                return true;
            }
        }
        return false;
    }

    void removeInputImpl(w wVar) {
        if (wVar != null) {
            wVar.b(this.mInputFocusChangeListenerImpl);
            p pVar = this.mPageRef == null ? null : (p) this.mPageRef.get();
            if (pVar != null) {
                f fVar = pVar.jJv;
                if (fVar != null) {
                    fVar.bR(wVar);
                }
            }
        }
    }

    private void setupSmileyPanelListeners() {
        if (this.mSmileyPanel != null) {
            this.mSmileyPanel.keh = this.mSmileyChosenListener;
            this.mSmileyPanel.kei = this.mSmileyOnDoneListener;
            this.mSmileyPanel.kek = this.mSmileyVisibilityListener;
        }
    }

    private void initSmileyPanelAndShow() {
        p pVar = (p) this.mPageRef.get();
        if (z.ak(pVar.getContentView())) {
            this.mSmileyPanel = u.bZ(pVar.getContentView());
            setupSmileyPanelListeners();
            hideNumberKeyboard();
            this.mInput.a(this.mInputFocusChangeListenerImpl);
            this.mInput.setOnKeyListener(new OnKeyListener() {
                public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                    AppBrandInputInvokeHandler.this.mPerformingDelete = 67 == i;
                    if (AppBrandInputInvokeHandler.this.mPerformingDelete) {
                        AppBrandInputInvokeHandler.this.H.removeCallbacks(AppBrandInputInvokeHandler.this.mResetPerformingDelete);
                        AppBrandInputInvokeHandler.this.H.postDelayed(AppBrandInputInvokeHandler.this.mResetPerformingDelete, 1000);
                    } else {
                        AppBrandInputInvokeHandler.this.mResetPerformingDelete.run();
                    }
                    return false;
                }
            });
            m.a((p) this.mPageRef.get(), this.mInput);
            u uVar = this.mSmileyPanel;
            if (!this.mParams.khq) {
                "emoji".equals(this.mParams.khp);
            }
            uVar.anE();
            if (this.mParams.khN.booleanValue()) {
                this.mInput.setOnEditorActionListener(null);
                this.mInput.setImeOptions(0);
            } else {
                com.tencent.mm.plugin.appbrand.widget.input.b.b aoh;
                if (this.mParams.khS == null) {
                    aoh = com.tencent.mm.plugin.appbrand.widget.input.b.b.aoh();
                } else {
                    aoh = this.mParams.khS;
                }
                final int i = aoh.khj;
                this.mInput.setImeOptions(i);
                this.mInput.setOnEditorActionListener(new OnEditorActionListener() {
                    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                        if (i != i) {
                            return false;
                        }
                        AppBrandInputInvokeHandler.this.mTextDoneReason$25f24e96 = c.kcR;
                        AppBrandInputInvokeHandler.this.doneTextInput();
                        AppBrandInputInvokeHandler.this.mTextDoneReason$25f24e96 = 0;
                        return true;
                    }
                });
            }
            this.mSmileyPanel.dB(this.mParams.khO.booleanValue());
            this.mSmileyPanel.ker = this.mInput;
            if (this.mParams.khN.booleanValue()) {
                this.mInput.setFocusable(false);
                this.mInput.setFocusableInTouchMode(false);
                this.mSmileyPanel.hide();
            } else {
                this.mInput.requestFocus();
                this.mSmileyPanel.show();
            }
            if (!this.mParams.khN.booleanValue()) {
                i.a(this.mPageRef).anj();
            }
            ((p) this.mPageRef.get()).a(new p.e() {
                public final void onDestroy() {
                    AppBrandInputInvokeHandler.this.hideSmileyPanel();
                }
            });
        }
    }

    private void dispatchKeyboardComplete(boolean z) {
        if (this.mInput != null) {
            onInputDone(this.mInput.getText().toString(), this.mInput.getSelectionEnd(), this.mTextDoneReason$25f24e96 == c.kcR, z);
        }
    }

    private void doneTextInput() {
        boolean z = this.mTextDoneReason$25f24e96 == c.kcR && af.e(this.mParams.khT);
        if (!z) {
            hideSmileyPanel();
        }
        if (this.mInput != null) {
            if (this.mInput.hasFocus()) {
                dispatchKeyboardComplete(z);
            }
            if (!z) {
                if (this.mSmileyPanel != null) {
                    this.mSmileyPanel.b(this.mInput);
                }
                if (this.mParams.khr) {
                    removeInputImpl(this.mInput);
                    onDestroy();
                    return;
                }
                this.mInput.setFocusable(false);
                this.mInput.setFocusableInTouchMode(false);
            }
        }
    }

    private u findSmileyPanel() {
        if (this.mSmileyPanel != null) {
            return this.mSmileyPanel;
        }
        if (this.mPageRef != null) {
            p pVar = (p) this.mPageRef.get();
            if (pVar != null) {
                u bY = u.bY(pVar.getContentView());
                this.mSmileyPanel = bY;
                return bY;
            }
        }
        return null;
    }

    private void hideSmileyPanel() {
        if (findSmileyPanel() != null) {
            this.mSmileyPanel.hide();
        } else if (this.mPageRef != null) {
            p pVar = (p) this.mPageRef.get();
            if (pVar != null) {
                Activity ch = j.ch(pVar.mContext);
                if (ch instanceof MMActivity) {
                    ((MMActivity) ch).aWY();
                }
            } else {
                return;
            }
        }
        i.a(this.mPageRef).ank();
    }

    private t findNumberKeyboard() {
        if (this.mNumberKeyboard != null) {
            return this.mNumberKeyboard;
        }
        if (this.mPageRef != null) {
            p pVar = (p) this.mPageRef.get();
            if (pVar != null) {
                t bW = t.bW(pVar.getContentView());
                this.mNumberKeyboard = bW;
                return bW;
            }
        }
        return null;
    }

    private void hideNumberKeyboard() {
        if (findNumberKeyboard() != null) {
            this.mNumberKeyboard.setVisibility(8);
        }
    }
}
