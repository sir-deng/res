package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.selectcontact.a.d;
import com.tencent.mm.plugin.selectcontact.a.e;
import com.tencent.mm.plugin.selectcontact.a.f;
import com.tencent.mm.plugin.selectcontact.a.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MultiSelectContactView extends LinearLayout {
    private LayoutInflater ntf;
    private int padding;
    private View rts;
    private HorizontalScrollView vra;
    private LinearLayout vrb;
    private View vrc;
    public MMEditText vrd;
    private List<String> vre;
    private Animation vrf;
    private int vrg;
    public a vrh;
    public b vri;
    public c vrj;
    private List<View> vrk;
    boolean vrl;

    public interface a {
        void oW(String str);
    }

    public interface b {
        void Eu(String str);
    }

    public interface c {
        void caZ();
    }

    static /* synthetic */ void d(MultiSelectContactView multiSelectContactView) {
        if (multiSelectContactView.vrb.getChildCount() != 0) {
            View childAt = multiSelectContactView.vrb.getChildAt(multiSelectContactView.vrb.getChildCount() - 1);
            if (multiSelectContactView.vrl) {
                multiSelectContactView.a(childAt, true, false);
                multiSelectContactView.vrl = false;
            } else {
                multiSelectContactView.vrl = true;
                multiSelectContactView.caX();
                childAt.findViewById(e.mask).setVisibility(0);
            }
            multiSelectContactView.vrd.requestFocus();
        }
    }

    public MultiSelectContactView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.vrg = 0;
        this.padding = 0;
        this.vrl = false;
        this.padding = getResources().getDimensionPixelSize(com.tencent.mm.plugin.selectcontact.a.c.bup);
        this.ntf = LayoutInflater.from(context);
        this.ntf.inflate(f.qlw, this, true);
        this.vra = (HorizontalScrollView) findViewById(e.qlq);
        this.vrd = (MMEditText) findViewById(e.cyy);
        this.vrb = (LinearLayout) findViewById(e.qlp);
        this.vrc = findViewById(e.qlr);
        this.vre = new LinkedList();
        this.vrf = AnimationUtils.loadAnimation(context, com.tencent.mm.plugin.selectcontact.a.a.bpZ);
        com.tencent.mm.ui.tools.a.c.d(this.vrd).Hg(100).a(null);
        this.rts = findViewById(e.cIB);
        this.vrd.addTextChangedListener(new TextWatcher() {
            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                MultiSelectContactView.this.caW();
                if (MultiSelectContactView.this.vri != null) {
                    MultiSelectContactView.this.vri.Eu(charSequence.toString());
                }
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        this.vrd.setOnKeyListener(new OnKeyListener() {
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (i == 67 && keyEvent.getAction() == 0 && MultiSelectContactView.this.vrd.getSelectionStart() == 0 && MultiSelectContactView.this.vrd.getSelectionEnd() == 0) {
                    MultiSelectContactView.d(MultiSelectContactView.this);
                }
                return false;
            }
        });
        this.vrk = new ArrayList();
        this.vrd.clearFocus();
        this.vrd.setOnFocusChangeListener(new OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                if (z) {
                    MultiSelectContactView.this.rts.setBackgroundResource(d.bDg);
                    MultiSelectContactView.this.rts.setPadding(MultiSelectContactView.this.padding, MultiSelectContactView.this.padding, MultiSelectContactView.this.padding, MultiSelectContactView.this.padding);
                } else {
                    MultiSelectContactView.this.rts.setBackgroundResource(d.bDh);
                    MultiSelectContactView.this.rts.setPadding(MultiSelectContactView.this.padding, MultiSelectContactView.this.padding, MultiSelectContactView.this.padding, MultiSelectContactView.this.padding);
                }
                if (MultiSelectContactView.this.vrj != null) {
                    MultiSelectContactView.this.vrj.caZ();
                }
            }
        });
        setBackgroundColor(-201326593);
        setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
            }
        });
    }

    public void clearFocus() {
        this.vrd.clearFocus();
        caW();
    }

    public final void SL(String str) {
        if (!bi.oN(str)) {
            if (this.vre.contains(str)) {
                x.i("MicroMsg.MultiSeclectContactView", "fixed user cant change");
                return;
            }
            caW();
            View SN = SN(str);
            if (SN != null) {
                a(SN, false, false);
            } else {
                bb(str, true);
            }
        }
    }

    public final void SM(String str) {
        View SN = SN(str);
        if (SN != null) {
            a(SN, false, false);
        }
    }

    private void caW() {
        if (this.vrb.getChildCount() != 0 && this.vrl) {
            View childAt = this.vrb.getChildAt(this.vrb.getChildCount() - 1);
            this.vrl = false;
            childAt.findViewById(e.mask).setVisibility(8);
        }
    }

    public final void bb(String str, boolean z) {
        Cj(this.vrb.getChildCount() + 1);
        View inflate = this.ntf.inflate(f.qlx, null, true);
        ImageView imageView = (ImageView) inflate.findViewById(e.bLD);
        com.tencent.mm.pluginsdk.ui.a.b.a(imageView, str);
        imageView.setContentDescription(((com.tencent.mm.plugin.messenger.a.b) g.h(com.tencent.mm.plugin.messenger.a.b.class)).gw(str));
        inflate.setTag(str);
        inflate.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                MultiSelectContactView.this.a(view, true, true);
            }
        });
        if (z) {
            inflate.startAnimation(this.vrf);
        }
        this.vrb.addView(inflate);
        caY();
        LayoutParams layoutParams = (LayoutParams) inflate.getLayoutParams();
        layoutParams.height = getResources().getDimensionPixelSize(com.tencent.mm.plugin.selectcontact.a.c.buA);
        layoutParams.width = getResources().getDimensionPixelSize(com.tencent.mm.plugin.selectcontact.a.c.buA);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(com.tencent.mm.plugin.selectcontact.a.c.bup);
        inflate.setLayoutParams(layoutParams);
        caX();
    }

    private void a(final View view, boolean z, boolean z2) {
        if (z && this.vrh != null) {
            this.vrh.oW(view.getTag().toString());
        }
        if (z2) {
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), com.tencent.mm.plugin.selectcontact.a.a.bqa);
            loadAnimation.setAnimationListener(new AnimationListener() {
                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    view.post(new Runnable() {
                        public final void run() {
                            MultiSelectContactView.this.vrb.removeView(view);
                            MultiSelectContactView.this.caY();
                            MultiSelectContactView.this.Cj(MultiSelectContactView.this.vrb.getChildCount());
                        }
                    });
                }
            });
            view.startAnimation(loadAnimation);
            return;
        }
        this.vrb.removeView(view);
        caY();
        Cj(this.vrb.getChildCount());
    }

    private void caX() {
        this.vrb.post(new Runnable() {
            public final void run() {
                MultiSelectContactView.this.vra.scrollTo(MultiSelectContactView.this.vrb.getMeasuredWidth(), 0);
            }
        });
    }

    private void Cj(int i) {
        int measureText;
        if (this.vrg <= 0) {
            this.vrg += getResources().getDimensionPixelSize(com.tencent.mm.plugin.selectcontact.a.c.bvx);
            int b = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(getContext(), 40.0f);
            measureText = (int) this.vrd.getPaint().measureText(getContext().getString(h.dGK));
            this.vrg = Math.max(b, measureText) + this.vrg;
        }
        if (this.vrg > 0) {
            measureText = this.rts.getWidth();
            x.v("MicroMsg.MultiSeclectContactView", "parentWidth:%d, avatarWidth:%d, minInputAreaWidth:%d", Integer.valueOf(measureText), Integer.valueOf(i * (getResources().getDimensionPixelSize(com.tencent.mm.plugin.selectcontact.a.c.buA) + getResources().getDimensionPixelSize(com.tencent.mm.plugin.selectcontact.a.c.bup))), Integer.valueOf(this.vrg));
            LayoutParams layoutParams = (LayoutParams) this.vra.getLayoutParams();
            if (measureText - (i * (getResources().getDimensionPixelSize(com.tencent.mm.plugin.selectcontact.a.c.buA) + getResources().getDimensionPixelSize(com.tencent.mm.plugin.selectcontact.a.c.bup))) > this.vrg) {
                layoutParams.width = -2;
            } else {
                layoutParams.width = measureText - this.vrg;
            }
        }
    }

    private void caY() {
        if (this.vrb.getChildCount() == 0) {
            this.vrc.setVisibility(0);
        } else {
            this.vrc.setVisibility(8);
        }
    }

    public final String bVF() {
        return this.vrd.getText().toString();
    }

    private View SN(String str) {
        int childCount = this.vrb.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.vrb.getChildAt(i);
            if (str.equals(childAt.getTag())) {
                return childAt;
            }
        }
        return null;
    }
}
