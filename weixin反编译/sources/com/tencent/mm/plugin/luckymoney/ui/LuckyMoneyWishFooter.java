package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.BasePanelKeybordLayout;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.List;

public class LuckyMoneyWishFooter extends BasePanelKeybordLayout {
    private MMActivity fnF;
    private ImageButton opZ;
    private MMEditText oqa;
    private Button oqb;
    private ChatFooterPanel oqc;
    boolean oqd = false;
    public boolean oqe = false;
    private boolean oqf = true;
    boolean oqg = true;
    private TextWatcher oqh = new TextWatcher() {
        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            if (LuckyMoneyWishFooter.this.oqa.getText() != null) {
                LuckyMoneyWishFooter.this.oqa.requestFocus();
                boolean z = editable.length() > 0 && editable.toString().trim().length() > 0;
                if (z && LuckyMoneyWishFooter.this.oqg) {
                    LuckyMoneyWishFooter.this.gz(true);
                    LuckyMoneyWishFooter.this.oqg = false;
                }
                if (!z) {
                    LuckyMoneyWishFooter.this.gz(false);
                    LuckyMoneyWishFooter.this.oqg = true;
                }
            }
        }
    };
    private int state = 0;

    public interface a {
        void EE(String str);
    }

    public LuckyMoneyWishFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fnF = (MMActivity) context;
        ViewGroup viewGroup = (ViewGroup) inflate(this.fnF, g.uJk, this);
        this.oqb = (Button) viewGroup.findViewById(f.uwk);
        gz(false);
        this.opZ = (ImageButton) viewGroup.findViewById(f.uwj);
        this.opZ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                LuckyMoneyWishFooter.this.oqd = true;
                x.i("MicroMsg.SnsCommentFooter", "state onClick" + LuckyMoneyWishFooter.this.state);
                if (LuckyMoneyWishFooter.this.state == 0) {
                    LuckyMoneyWishFooter.this.fnF.aWY();
                    LuckyMoneyWishFooter.this.oqa.requestFocus();
                    LuckyMoneyWishFooter.this.anD();
                    LuckyMoneyWishFooter.this.opZ.setImageResource(h.dBn);
                    LuckyMoneyWishFooter.this.state = 1;
                    LuckyMoneyWishFooter.this.oqf = false;
                    return;
                }
                LuckyMoneyWishFooter.this.oqf = false;
                LuckyMoneyWishFooter.this.oqa.requestFocus();
                LuckyMoneyWishFooter.this.oqc.setVisibility(8);
                LuckyMoneyWishFooter.this.fnF.showVKB();
                LuckyMoneyWishFooter.this.opZ.setImageResource(h.dBm);
                LuckyMoneyWishFooter.this.state = 0;
            }
        });
        this.oqa = (MMEditText) viewGroup.findViewById(f.uwh);
        this.oqa.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                LuckyMoneyWishFooter.this.oqf = false;
                LuckyMoneyWishFooter.this.oqc.setVisibility(8);
                LuckyMoneyWishFooter.this.oqc.onPause();
                LuckyMoneyWishFooter.this.opZ.setImageResource(e.bBo);
                LuckyMoneyWishFooter.this.state = 0;
                return false;
            }
        });
        if (com.tencent.mm.pluginsdk.ui.chat.e.vxZ == null) {
            this.oqc = new d(this.fnF);
            return;
        }
        this.oqc = com.tencent.mm.pluginsdk.ui.chat.e.vxZ.cw(getContext());
        this.oqc.ej(ChatFooterPanel.vqm);
        this.oqc.setVisibility(8);
        this.oqc.setBackgroundResource(e.bzZ);
        ((LinearLayout) findViewById(f.cIB)).addView(this.oqc, -1, 0);
        this.oqc.tk();
        this.oqc.aH(false);
        this.oqc.vqj = new com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a() {
            public final void aYA() {
            }

            public final void gA(boolean z) {
            }

            public final void anG() {
                LuckyMoneyWishFooter.this.oqa.zCS.sendKeyEvent(new KeyEvent(0, 67));
                LuckyMoneyWishFooter.this.oqa.zCS.sendKeyEvent(new KeyEvent(1, 67));
            }

            public final void append(String str) {
                try {
                    LuckyMoneyWishFooter.this.oqa.aaU(str);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.SnsCommentFooter", e, "", new Object[0]);
                }
            }
        };
    }

    public void setVisibility(int i) {
        boolean z;
        this.state = 0;
        if (i == 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.oqc != null) {
            x.i("MicroMsg.SnsCommentFooter", "showState " + z);
            if (z) {
                if (this.state == 0) {
                    this.fnF.showVKB();
                    this.oqa.requestFocus();
                    this.oqc.setVisibility(8);
                } else {
                    this.fnF.aWY();
                    this.oqa.requestFocus();
                    anD();
                }
                this.oqf = false;
            } else {
                this.oqc.setVisibility(8);
                this.opZ.setImageResource(h.dBm);
                this.fnF.aWY();
                requestLayout();
            }
        }
        super.setVisibility(i);
    }

    private void anD() {
        this.oqc.onResume();
        this.oqc.setVisibility(0);
        LayoutParams layoutParams = this.oqc.getLayoutParams();
        if ((layoutParams != null && layoutParams.height <= 0) || (layoutParams != null && j.aS(getContext()) && this.oqf)) {
            layoutParams.height = j.aQ(getContext());
            this.oqc.setLayoutParams(layoutParams);
            this.oqf = false;
        }
    }

    public final void aYx() {
        this.oqa.setFilters(new InputFilter[]{new LengthFilter(25)});
    }

    public final boolean a(com.tencent.mm.ui.widget.MMEditText.a aVar) {
        if (this.oqa == null) {
            return false;
        }
        this.oqa.zCT = aVar;
        return true;
    }

    public final void a(final a aVar) {
        this.oqb.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                aVar.EE(LuckyMoneyWishFooter.this.oqa.getText().toString());
                LuckyMoneyWishFooter.this.oqa.setText("");
            }
        });
    }

    protected final void ra(int i) {
        super.ra(i);
        switch (i) {
            case -3:
                this.oqe = true;
                return;
            default:
                this.oqe = false;
                return;
        }
    }

    public final void aYy() {
        if (this.oqc != null) {
            x.i("MicroMsg.SnsCommentFooter", "commentfooter release");
            this.oqc.tj();
            this.oqc.destroy();
        }
    }

    private void gz(boolean z) {
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), com.tencent.mm.plugin.wxpay.a.a.bqk);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), com.tencent.mm.plugin.wxpay.a.a.bql);
        loadAnimation.setDuration(150);
        loadAnimation2.setDuration(150);
        if (this.oqb != null) {
            if (z) {
                if (this.oqb.getVisibility() != 8 && this.oqb.getVisibility() != 4) {
                    this.oqb.startAnimation(loadAnimation2);
                    this.oqb.setVisibility(8);
                }
            } else if (this.oqb.getVisibility() != 0 && this.oqb.getVisibility() != 0) {
                this.oqb.startAnimation(loadAnimation);
                this.oqb.setVisibility(0);
            }
        }
    }

    protected final List<View> aYz() {
        List<View> arrayList = new ArrayList();
        arrayList.add(this.oqc);
        return arrayList;
    }
}
