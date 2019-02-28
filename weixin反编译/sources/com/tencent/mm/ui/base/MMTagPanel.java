package com.tencent.mm.ui.base;

import android.content.Context;
import android.os.IBinder;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.h;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.v.a.e;
import com.tencent.mm.v.a.f;
import com.tencent.mm.v.a.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MMTagPanel extends FlowLayout {
    public int mAm = com.tencent.mm.v.a.d.btv;
    public int mAn = f.gWN;
    private boolean mzr = false;
    public int nPX = f.bGD;
    public int nPY = com.tencent.mm.v.a.d.buj;
    public boolean niO = true;
    public LinkedList<d> wml = new LinkedList();
    public boolean ymf = true;
    private boolean ymg = false;
    public boolean ymh = true;
    public boolean ymi = false;
    public boolean ymj = false;
    public int ymk = f.gWL;
    private int yml = 0;
    public int ymm = f.gWM;
    private int ymn = com.tencent.mm.v.a.d.white;
    private d ymo = null;
    private LinkedList<d> ymp = new LinkedList();
    public a ymq;
    private int ymr;
    private View yms;
    public MMEditText ymt;
    public boolean ymu = false;
    private OnClickListener ymv = new OnClickListener() {
        public final void onClick(final View view) {
            if (((Integer) view.getTag()).intValue() == 0) {
                MMTagPanel.this.a((TextView) view, true, false);
                if (MMTagPanel.this.ymq != null) {
                    view.post(new Runnable() {
                        public final void run() {
                            MMTagPanel.this.ymq.zp(((TextView) view).getText().toString());
                        }
                    });
                }
            } else if (!MMTagPanel.this.ymg || MMTagPanel.this.ymi) {
                MMTagPanel.this.a((TextView) view, false, false);
                if (MMTagPanel.this.ymq != null) {
                    view.post(new Runnable() {
                        public final void run() {
                            MMTagPanel.this.ymq.zo(((TextView) view).getText().toString());
                        }
                    });
                }
            } else if (MMTagPanel.this.ymo == null) {
                MMTagPanel.this.ymo = MMTagPanel.a(MMTagPanel.this, ((TextView) view).getText().toString());
                if (MMTagPanel.this.ymo != null) {
                    MMTagPanel.this.a(MMTagPanel.this.ymo.ymI, false, true);
                }
            } else if (MMTagPanel.this.ymo.ymI == view) {
                MMTagPanel.this.ymo = null;
                MMTagPanel.this.a((TextView) view, false, false);
                if (MMTagPanel.this.ymq != null) {
                    view.post(new Runnable() {
                        public final void run() {
                            MMTagPanel.this.ymq.zo(((TextView) view).getText().toString());
                        }
                    });
                }
            } else {
                MMTagPanel.this.cqx();
                MMTagPanel.this.ymo = MMTagPanel.a(MMTagPanel.this, ((TextView) view).getText().toString());
                MMTagPanel.this.a(MMTagPanel.this.ymo.ymI, false, true);
            }
        }
    };

    public interface a {
        void aEg();

        void j(boolean z, int i);

        void zo(String str);

        void zp(String str);

        void zq(String str);

        void zr(String str);

        void zs(String str);
    }

    public class b implements InputFilter {
        int mark;
        List<String> ymz = new LinkedList();

        public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            x.d("MicroMsg.MMTagPanel", "on create tag filter, %s [%d, %d) %s [%d, %d), maxlength[%B]", charSequence, Integer.valueOf(i), Integer.valueOf(i2), spanned, Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(MMTagPanel.this.mzr));
            this.mark = -1;
            this.ymz.clear();
            char[] cArr = new char[(i2 - i)];
            TextUtils.getChars(charSequence, i, i2, cArr, 0);
            if (MMTagPanel.this.ymh) {
                int i5 = i;
                while (i5 < i2) {
                    if (cArr[i5] == 10 || cArr[i5] == ',' || cArr[i5] == ';' || cArr[i5] == 12289 || cArr[i5] == 65292 || cArr[i5] == 65307) {
                        if (-1 == this.mark) {
                            this.ymz.add((spanned.subSequence(0, i3).toString() + charSequence.subSequence(i, i5)).trim());
                        } else {
                            this.ymz.add(charSequence.subSequence(this.mark, i5).toString().trim());
                        }
                        this.mark = i5 + 1;
                    }
                    i5++;
                }
                if (MMTagPanel.this.ymu) {
                    i5 = h.aaF(spanned.toString());
                    if (MMTagPanel.this.mzr && charSequence.equals("\n") && 36 < i5) {
                        this.ymz.clear();
                    }
                }
                if (this.ymz.isEmpty()) {
                    return null;
                }
                String charSequence2;
                if (MMTagPanel.this.ymq != null) {
                    for (final String charSequence22 : this.ymz) {
                        if (charSequence22.length() > 0) {
                            MMTagPanel.this.post(new Runnable() {
                                public final void run() {
                                    MMTagPanel.this.ymq.zs(charSequence22.trim());
                                }
                            });
                        }
                    }
                }
                if (this.mark >= i2) {
                    spanned.length();
                    charSequence22 = spanned.subSequence(i4, spanned.length()).toString();
                } else {
                    charSequence22 = charSequence.subSequence(this.mark, i2).toString() + spanned.subSequence(i4, spanned.length());
                }
                MMTagPanel.this.post(new Runnable() {
                    public final void run() {
                        MMTagPanel.this.ymt.setText("");
                        MMTagPanel.this.ymt.append(charSequence22);
                    }
                });
                return "";
            }
            Object obj = null;
            final StringBuilder stringBuilder = new StringBuilder();
            while (i < i2) {
                if (cArr[i] == 10) {
                    obj = 1;
                } else {
                    stringBuilder.append(cArr[i]);
                }
                i++;
            }
            if (obj == null) {
                return null;
            }
            CharSequence stringBuilder2 = stringBuilder.toString();
            stringBuilder.insert(0, spanned.subSequence(0, i3));
            stringBuilder.append(spanned.subSequence(i4, spanned.length()));
            MMTagPanel.this.post(new Runnable() {
                public final void run() {
                    MMTagPanel.this.ymq.zs(stringBuilder.toString());
                }
            });
            return stringBuilder2;
        }
    }

    public class c implements InputFilter {
        int ymD = 36;
        private int ymE = 256;
        private int ymF;

        public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int aaF = h.aaF(spanned.toString()) + h.aaF(charSequence.toString());
            if (i4 > i3) {
                if (aaF - (i4 - i3) > this.ymD) {
                    MMTagPanel.this.mzr = true;
                    this.ymF = (aaF - (i4 - i3)) - this.ymD;
                } else {
                    MMTagPanel.this.mzr = false;
                }
            } else if (aaF > this.ymD) {
                MMTagPanel.this.mzr = true;
                this.ymF = aaF - this.ymD;
            } else {
                MMTagPanel.this.mzr = false;
            }
            if (MMTagPanel.this.ymu && 1 == this.ymF && charSequence.equals("\n")) {
                this.ymF = 0;
            }
            if (MMTagPanel.this.ymq != null) {
                MMTagPanel.this.post(new Runnable() {
                    public final void run() {
                        MMTagPanel.this.ymq.j(MMTagPanel.this.mzr, h.be(c.this.ymF, ""));
                    }
                });
            }
            if (aaF > this.ymE) {
                return "";
            }
            return charSequence;
        }
    }

    public static final class d {
        public String ymH;
        public TextView ymI;
    }

    static /* synthetic */ d a(MMTagPanel mMTagPanel, String str) {
        if (bi.oN(str)) {
            x.w("MicroMsg.MMTagPanel", "want to get tag info, but it is null or empty");
            return null;
        }
        Iterator it = mMTagPanel.wml.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (str.equals(dVar.ymH)) {
                return dVar;
            }
        }
        x.w("MicroMsg.MMTagPanel", "want to get tag %s, but it not exsited!", str);
        return null;
    }

    public MMTagPanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public MMTagPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void aKi() {
    }

    private void init() {
        this.ymr = getContext().getResources().getDimensionPixelSize(e.bvt);
        this.yms = LayoutInflater.from(getContext()).inflate(com.tencent.mm.v.a.h.gZK, null);
        this.ymt = (MMEditText) this.yms.findViewById(g.cdl);
        this.ymt.setOnKeyListener(new OnKeyListener() {
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 0 && 67 == i) {
                    x.d("MicroMsg.MMTagPanel", "on del click, selection[%d, %d]", Integer.valueOf(MMTagPanel.this.ymt.getSelectionStart()), Integer.valueOf(MMTagPanel.this.ymt.getSelectionEnd()));
                    boolean z = MMTagPanel.this.ymt.getSelectionStart() == 0 && MMTagPanel.this.ymt.getSelectionStart() == MMTagPanel.this.ymt.getSelectionEnd();
                    if (z) {
                        MMTagPanel.this.aKi();
                        if (!(MMTagPanel.this.wml == null || MMTagPanel.this.wml.isEmpty())) {
                            if (!MMTagPanel.this.ymi && MMTagPanel.this.ymo == null) {
                                MMTagPanel.this.ymo = (d) MMTagPanel.this.wml.getLast();
                                MMTagPanel.this.a(MMTagPanel.this.ymo.ymI, false, true);
                                MMTagPanel.this.ymt.setCursorVisible(false);
                            } else if (MMTagPanel.this.ymo == null || MMTagPanel.this.wml == null || MMTagPanel.this.wml.getLast() == null || bi.oN(MMTagPanel.this.ymo.ymH) || bi.oN(((d) MMTagPanel.this.wml.getLast()).ymH) || MMTagPanel.this.ymo.ymH.equals(((d) MMTagPanel.this.wml.getLast()).ymH)) {
                                String str = ((d) MMTagPanel.this.wml.getLast()).ymH;
                                MMTagPanel.this.removeTag(str);
                                if (MMTagPanel.this.ymq != null) {
                                    MMTagPanel.this.ymq.zq(str);
                                }
                                MMTagPanel.this.cqx();
                            } else {
                                x.i("MicroMsg.MMTagPanel", "change hight");
                                MMTagPanel.this.cqx();
                                MMTagPanel.this.ymo = (d) MMTagPanel.this.wml.getLast();
                                MMTagPanel.this.a(MMTagPanel.this.ymo.ymI, false, true);
                                MMTagPanel.this.ymt.setCursorVisible(false);
                            }
                        }
                    }
                }
                return false;
            }
        });
        this.ymt.addTextChangedListener(new TextWatcher() {
            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (MMTagPanel.this.ymq != null) {
                    MMTagPanel.this.ymq.zr(obj);
                }
                if (obj.length() > 0) {
                    MMTagPanel.this.cqx();
                }
            }
        });
        this.ymt.setOnFocusChangeListener(new OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                x.d("MicroMsg.MMTagPanel", "on edittext focus changed %B", Boolean.valueOf(z));
                if (z && MMTagPanel.this.ymq != null) {
                    MMTagPanel.this.ymq.aEg();
                }
            }
        });
        this.ymt.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                x.d("MicroMsg.MMTagPanel", "on edittext click");
                MMTagPanel.this.cqx();
                if (MMTagPanel.this.ymq != null) {
                    MMTagPanel.this.ymq.aEg();
                }
            }
        });
        this.ymt.setOnEditorActionListener(new OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                x.d("MicroMsg.MMTagPanel", "on action %d, %s", Integer.valueOf(i), keyEvent);
                return false;
            }
        });
        final c cVar = new c();
        b bVar = new b();
        this.ymt.setFilters(new InputFilter[]{cVar, bVar});
        cqu();
        setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                x.d("MicroMsg.MMTagPanel", "on panel click, enableEditMode %B", Boolean.valueOf(MMTagPanel.this.ymg));
                if (MMTagPanel.this.ymg) {
                    MMTagPanel.this.cqx();
                    MMTagPanel.this.ymt.requestFocus();
                    MMTagPanel.this.ymt.setSelection(MMTagPanel.this.ymt.getText().length());
                    ((InputMethodManager) MMTagPanel.this.getContext().getSystemService("input_method")).showSoftInput(MMTagPanel.this.ymt, 0);
                    x.d("MicroMsg.MMTagPanel", "on content click");
                    if (MMTagPanel.this.ymq != null) {
                        MMTagPanel.this.ymq.aEg();
                    }
                }
            }
        });
        setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (MMTagPanel.this.ymj) {
                    String cqq = MMTagPanel.this.cqq();
                    if (!bi.oN(cqq)) {
                        if (cVar != null && h.aaF(cqq) > cVar.ymD) {
                            int aaG = cVar.ymD - h.aaG(cqq);
                            if (aaG <= cqq.length()) {
                                cqq = cqq.substring(0, aaG);
                            }
                        }
                        MMTagPanel.this.bj(cqq, true);
                        if (MMTagPanel.this.ymq != null) {
                            MMTagPanel.this.ymq.zs(cqq);
                        }
                        MMTagPanel.this.cqr();
                    }
                }
                return false;
            }
        });
    }

    public final void Fi(int i) {
        this.yml = i;
        if (this.ymt != null) {
            com.tencent.mm.bu.a.fromDPToPix(getContext(), 6);
            getResources().getDimensionPixelSize(e.bvK);
            this.ymt.setBackgroundResource(this.yml);
        }
    }

    public final void Zs(String str) {
        if (this.ymt != null) {
            this.ymt.setHint(str);
        }
    }

    public final String cqq() {
        if (this.ymt != null) {
            return this.ymt.getText().toString();
        }
        return "";
    }

    public final void cqr() {
        if (this.ymt != null) {
            this.ymt.setText("");
        }
    }

    public final boolean cqs() {
        if (this.ymt == null) {
            return false;
        }
        return this.ymt.isFocused();
    }

    public final void cqt() {
        if (this.ymt != null && !this.ymt.isFocused()) {
            this.ymt.requestFocus();
        }
    }

    public final void cqu() {
        if (this.ymt != null && this.ymt.isFocused()) {
            x.d("MicroMsg.MMTagPanel", "do clear edit focus");
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (inputMethodManager != null) {
                IBinder windowToken = this.ymt.getWindowToken();
                if (windowToken != null) {
                    inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
                    this.ymt.clearFocus();
                }
            }
        }
    }

    public final void mz(boolean z) {
        if (z != this.ymg) {
            this.ymg = z;
            removeView(this.yms);
            if (this.ymg) {
                addView(this.yms);
                cqu();
            }
        }
    }

    public final ArrayList<String> cqv() {
        ArrayList<String> arrayList = new ArrayList();
        Iterator it = this.wml.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (!bi.oN(dVar.ymH)) {
                arrayList.add(dVar.ymH);
            }
        }
        return arrayList;
    }

    public void cqj() {
        this.wml.clear();
        removeAllViews();
        Iterator it = this.wml.iterator();
        while (it.hasNext()) {
            a((d) it.next());
        }
    }

    public final void a(Collection<String> collection, List<String> list) {
        cqj();
        if (this.ymg) {
            addView(this.yms);
        }
        if (list != null && !list.isEmpty()) {
            for (String str : list) {
                bj(str, collection == null ? false : collection.contains(str));
            }
        }
    }

    public final d cqw() {
        if (!this.ymp.isEmpty()) {
            return (d) this.ymp.removeFirst();
        }
        d dVar = new d();
        TextView textView = new TextView(getContext());
        textView.setBackgroundResource(this.mAn);
        textView.setTextColor(getResources().getColor(this.mAm));
        textView.setTag(Integer.valueOf(0));
        textView.setGravity(17);
        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, this.ymk, 0);
        textView.setOnClickListener(this.ymf ? this.ymv : null);
        textView.setEllipsize(TruncateAt.END);
        textView.setSingleLine();
        dVar.ymI = textView;
        return dVar;
    }

    public final void a(d dVar) {
        dVar.ymI.setOnClickListener(null);
        if (this.ymp.size() < 16) {
            this.ymp.add(dVar);
        }
    }

    public final void a(d dVar, String str, boolean z) {
        dVar.ymH = str;
        dVar.ymI.setText(com.tencent.mm.ui.e.c.b.a(getContext(), str, this.ymr));
        dVar.ymI.setOnClickListener(this.ymf ? this.ymv : null);
        a(dVar.ymI, z, false);
    }

    public final void cqx() {
        if (this.ymt != null) {
            x.d("MicroMsg.MMTagPanel", "do clear high light info, edittext is focus %B", Boolean.valueOf(this.ymt.isFocused()));
            this.ymt.setCursorVisible(true);
        }
        if (this.ymo != null) {
            boolean z;
            TextView textView = this.ymo.ymI;
            if (((Integer) this.ymo.ymI.getTag()).intValue() == 1) {
                z = true;
            } else {
                z = false;
            }
            a(textView, z, false);
            this.ymo = null;
        }
    }

    public final void a(TextView textView, boolean z, boolean z2) {
        textView.setTextSize(0, getContext().getResources().getDimension(e.bvt) * com.tencent.mm.bu.a.ev(getContext()));
        if (z2) {
            textView.setBackgroundResource(this.ymm);
            textView.setTextColor(getResources().getColor(this.ymn));
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, this.ymk, 0);
        } else if (z) {
            textView.setTag(Integer.valueOf(1));
            textView.setBackgroundResource(this.nPX);
            textView.setTextColor(getResources().getColor(this.nPY));
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        } else {
            textView.setTag(Integer.valueOf(0));
            textView.setBackgroundResource(this.mAn);
            textView.setTextColor(getResources().getColor(this.mAm));
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    public final void bj(String str, boolean z) {
        if (bi.oN(str)) {
            x.w("MicroMsg.MMTagPanel", "want to add tag, but it is null or empty");
            return;
        }
        String trim = str.trim();
        x.d("MicroMsg.MMTagPanel", "want to add tag %s, do remove tag first", trim);
        removeTag(trim);
        Iterator it = this.wml.iterator();
        while (it.hasNext()) {
            if (trim.equals(((d) it.next()).ymH)) {
                x.w("MicroMsg.MMTagPanel", "want to add tag %s, but it exsited!", trim);
                return;
            }
        }
        d cqw = cqw();
        a(cqw, trim, z);
        this.wml.add(cqw);
        if (this.ymg) {
            addView(cqw.ymI, getChildCount() - 1);
        } else {
            addView(cqw.ymI);
        }
        cqx();
    }

    public final void removeTag(String str) {
        if (bi.oN(str)) {
            x.w("MicroMsg.MMTagPanel", "want to remove tag, but it is null or empty");
            return;
        }
        Iterator it = this.wml.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (str.equals(dVar.ymH)) {
                this.wml.remove(dVar);
                removeView(dVar.ymI);
                a(dVar);
                cqx();
                return;
            }
        }
        x.w("MicroMsg.MMTagPanel", "want to remove tag %s, but it not exsited!", str);
    }

    public final void bk(String str, boolean z) {
        if (bi.oN(str)) {
            x.w("MicroMsg.MMTagPanel", "want to update tag status, but it is null or empty");
            return;
        }
        Iterator it = this.wml.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (str.equals(dVar.ymH)) {
                a(dVar, str, z);
                cqx();
                return;
            }
        }
        x.w("MicroMsg.MMTagPanel", "want to update tag %s status, but it not exsited!", str);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.niO) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }
}
