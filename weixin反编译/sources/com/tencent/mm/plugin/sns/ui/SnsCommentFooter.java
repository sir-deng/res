package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.text.Editable;
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
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.protocal.c.bku;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.BasePanelKeybordLayout;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.List;

public class SnsCommentFooter extends BasePanelKeybordLayout {
    private MMActivity fnF;
    private ImageButton opZ;
    MMEditText oqa;
    private Button oqb;
    ChatFooterPanel oqc;
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
            if (SnsCommentFooter.this.oqa.getText() != null) {
                SnsCommentFooter.this.oqa.requestFocus();
                boolean z = editable.length() > 0 && editable.toString().trim().length() > 0;
                if (z && SnsCommentFooter.this.oqg) {
                    SnsCommentFooter.this.gz(true);
                    SnsCommentFooter.this.oqg = false;
                }
                if (!z) {
                    SnsCommentFooter.this.gz(false);
                    SnsCommentFooter.this.oqg = true;
                }
            }
        }
    };
    ImageView rHf;
    Button rHg;
    int rHh = 0;
    public boolean rHi;
    private String rHj = "";
    private boolean rHk = false;
    a rHl;
    d rHm;
    private bi rHn;
    bku raa = null;
    int state = 0;

    interface a {
        void bBr();
    }

    interface c {
        void Mp(String str);
    }

    interface d {
        void onShow();
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsCommentFooter$7 */
    class AnonymousClass7 implements OnClickListener {
        final /* synthetic */ b rHs;

        AnonymousClass7(b bVar) {
            this.rHs = bVar;
        }

        public final void onClick(View view) {
            SnsCommentFooter.this.rHf.setImageResource(e.qEY);
            Animation scaleAnimation = new ScaleAnimation(0.9f, 1.3f, 0.9f, 1.3f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(400);
            scaleAnimation.setStartOffset(100);
            scaleAnimation.setRepeatCount(0);
            SnsCommentFooter.this.rHf.startAnimation(scaleAnimation);
            scaleAnimation.setAnimationListener(new AnimationListener() {
                public final void onAnimationEnd(Animation animation) {
                    SnsCommentFooter.this.rHf.setImageResource(e.qEX);
                }

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationStart(Animation animation) {
                }
            });
            this.rHs.bBs();
        }
    }

    interface b {
        void bBs();
    }

    static /* synthetic */ void h(SnsCommentFooter snsCommentFooter) {
        snsCommentFooter.oqc.onPause();
        snsCommentFooter.oqc.setVisibility(8);
    }

    public final boolean bBt() {
        if (this.oqa.getText() == null || bi.oN(this.oqa.getText().toString())) {
            return true;
        }
        return false;
    }

    public SnsCommentFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fnF = (MMActivity) context;
    }

    public final void bBu() {
        ViewGroup viewGroup = (ViewGroup) inflate(this.fnF, g.qNn, this);
        this.rHf = (ImageView) viewGroup.findViewById(f.qKL);
        this.oqb = (Button) viewGroup.findViewById(f.qGL);
        this.rHg = (Button) viewGroup.findViewById(f.qGF);
        this.oqa = (MMEditText) viewGroup.findViewById(f.qGD);
        gz(false);
        this.opZ = (ImageButton) viewGroup.findViewById(f.bJR);
        this.opZ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                SnsCommentFooter.this.oqd = true;
                x.i("MicroMsg.SnsCommentFooter", "state onClick" + SnsCommentFooter.this.state);
                if (SnsCommentFooter.this.state == 0) {
                    SnsCommentFooter.this.bBw();
                    SnsCommentFooter.this.oqa.requestFocus();
                    SnsCommentFooter.this.state = 1;
                    SnsCommentFooter.this.anD();
                    SnsCommentFooter.this.opZ.setImageResource(e.bBp);
                    SnsCommentFooter.this.oqf = false;
                    return;
                }
                SnsCommentFooter.h(SnsCommentFooter.this);
                SnsCommentFooter.this.oqf = false;
                SnsCommentFooter.this.oqa.requestFocus();
                SnsCommentFooter.this.bBv();
                SnsCommentFooter.this.opZ.setImageResource(e.bBo);
                SnsCommentFooter.this.state = 0;
            }
        });
        this.oqa.setHint(this.fnF.getString(j.qSG));
        this.oqa.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                SnsCommentFooter.this.oqf = false;
                SnsCommentFooter.this.oqc.setVisibility(8);
                SnsCommentFooter.this.oqc.onPause();
                SnsCommentFooter.this.opZ.setImageResource(e.bBo);
                if (SnsCommentFooter.this.rHl != null) {
                    SnsCommentFooter.this.rHl.bBr();
                }
                SnsCommentFooter.this.state = 0;
                return false;
            }
        });
        if (com.tencent.mm.pluginsdk.ui.chat.e.vxZ == null) {
            this.oqc = new com.tencent.mm.pluginsdk.ui.chat.d(this.fnF);
            return;
        }
        this.oqc = com.tencent.mm.pluginsdk.ui.chat.e.vxZ.cw(getContext());
        this.oqc.ej(ChatFooterPanel.SCENE_SNS);
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
                if (SnsCommentFooter.this.oqa != null && SnsCommentFooter.this.oqa.zCS != null) {
                    SnsCommentFooter.this.oqa.zCS.sendKeyEvent(new KeyEvent(0, 67));
                    SnsCommentFooter.this.oqa.zCS.sendKeyEvent(new KeyEvent(1, 67));
                }
            }

            public final void append(String str) {
                try {
                    SnsCommentFooter.this.oqa.aaU(str);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.SnsCommentFooter", e, "", new Object[0]);
                }
            }
        };
    }

    public void setVisibility(int i) {
        boolean z = false;
        this.state = 0;
        if (i == 0) {
            z = true;
        }
        iO(z);
        super.setVisibility(i);
    }

    public final void iO(boolean z) {
        if (this.oqc != null) {
            this.rHi = z;
            x.i("MicroMsg.SnsCommentFooter", "showState " + z);
            if (z) {
                if (this.state == 0) {
                    bBv();
                    this.oqa.requestFocus();
                    this.oqc.setVisibility(8);
                } else {
                    bBw();
                    this.oqa.requestFocus();
                    anD();
                }
                this.oqf = false;
                return;
            }
            this.oqc.setVisibility(8);
            this.opZ.setImageResource(i.dBm);
            bBw();
            requestLayout();
        }
    }

    private void bBv() {
        if (this.fnF.mController.xRL != 1) {
            this.fnF.showVKB();
        }
    }

    private void bBw() {
        if (this.fnF.mController.xRL == 1) {
            this.fnF.aWY();
        }
    }

    private void anD() {
        this.oqc.onResume();
        this.oqc.setVisibility(0);
        LayoutParams layoutParams = this.oqc.getLayoutParams();
        if (layoutParams != null && com.tencent.mm.compatible.util.j.aS(getContext()) && this.oqf) {
            layoutParams.height = com.tencent.mm.compatible.util.j.aQ(getContext());
            this.oqc.setLayoutParams(layoutParams);
            this.oqf = false;
        }
        if (this.rHm != null) {
            this.rHm.onShow();
        }
    }

    public final boolean bBx() {
        return this.state == 1;
    }

    public final void bBy() {
        if (this.oqa == null) {
            x.e("MicroMsg.SnsCommentFooter", "send edittext is null");
            return;
        }
        this.oqa.removeTextChangedListener(this.oqh);
        this.oqa.addTextChangedListener(this.oqh);
    }

    public final void i(final List<l> list, String str) {
        this.rHj = str;
        if (this.oqa != null) {
            String aD;
            String str2 = "";
            for (l lVar : list) {
                if (str.equals(lVar.aAM)) {
                    list.remove(lVar);
                    aD = bi.aD(lVar.text, "");
                    break;
                }
            }
            aD = str2;
            if (bi.oN(aD)) {
                this.oqa.setText("");
            } else {
                this.rHg.setVisibility(0);
                this.oqb.setVisibility(8);
                this.oqa.setText("");
                this.oqa.aaU(aD);
            }
            if (!this.rHk) {
                this.oqa.addTextChangedListener(new TextWatcher() {
                    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    }

                    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    }

                    public final void afterTextChanged(Editable editable) {
                        if (SnsCommentFooter.this.oqa.getText() != null) {
                            l lVar;
                            boolean z;
                            x.d("MicroMsg.SnsCommentFooter", "update commentkey:" + SnsCommentFooter.this.rHj);
                            for (l lVar2 : list) {
                                if (SnsCommentFooter.this.rHj.equals(lVar2.aAM)) {
                                    x.d("MicroMsg.SnsCommentFooter", "afterTextChanged update");
                                    lVar2.text = SnsCommentFooter.this.oqa.getText().toString();
                                    z = true;
                                    break;
                                }
                            }
                            z = false;
                            if (!z) {
                                x.d("MicroMsg.SnsCommentFooter", "afterTextChanged add");
                                lVar2 = new l();
                                lVar2.aAM = SnsCommentFooter.this.rHj;
                                lVar2.text = SnsCommentFooter.this.oqa.getText().toString();
                                if (lVar2.text != null && lVar2.text.length() > 0) {
                                    list.add(lVar2);
                                }
                            }
                            if (list.size() > 5) {
                                x.d("MicroMsg.SnsCommentFooter", "comments remove");
                                list.remove(0);
                            }
                            SnsCommentFooter.this.oqa.requestFocus();
                            z = editable.length() > 0 && editable.toString().trim().length() > 0;
                            if (z && SnsCommentFooter.this.oqg) {
                                SnsCommentFooter.this.gz(z);
                                SnsCommentFooter.this.oqg = false;
                            }
                            if (!z) {
                                SnsCommentFooter.this.gz(z);
                                SnsCommentFooter.this.oqg = true;
                            }
                        }
                    }
                });
            }
            this.rHk = true;
        }
    }

    public final void a(String str, bku bku) {
        this.rHh = 0;
        if (bi.oN(str)) {
            this.oqa.setHint("");
        } else {
            this.oqa.setHint(com.tencent.mm.pluginsdk.ui.d.i.a(getContext(), str + this.fnF.getString(j.qQj, new Object[]{Float.valueOf(this.oqa.getTextSize())})));
        }
        this.raa = bku;
    }

    public final void b(String str, bku bku) {
        if (bi.oN(str)) {
            this.oqa.setHint("");
        } else {
            this.oqa.setHint(com.tencent.mm.pluginsdk.ui.d.i.a(getContext(), this.fnF.getString(j.qQb) + str + this.fnF.getString(j.qQj, new Object[]{Float.valueOf(this.oqa.getTextSize())})));
            this.rHh = 1;
        }
        this.raa = bku;
    }

    public final void bBz() {
        this.oqa.setText("");
        this.oqa.setHint("");
        this.raa = null;
        this.rHh = 0;
        this.state = 0;
    }

    public final void MB(String str) {
        this.oqa.setHint(com.tencent.mm.pluginsdk.ui.d.i.b(getContext(), str, this.oqa.getTextSize()));
    }

    public final bku bBA() {
        if (this.raa == null) {
            return new bku();
        }
        return this.raa;
    }

    public final void a(final c cVar) {
        this.rHg.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                com.tencent.mm.ui.tools.a.c Hg = com.tencent.mm.ui.tools.a.c.d(SnsCommentFooter.this.oqa).Hg(com.tencent.mm.j.b.zI());
                Hg.zwQ = true;
                Hg.a(new com.tencent.mm.ui.tools.a.c.a() {
                    public final void vE(String str) {
                        cVar.Mp(SnsCommentFooter.this.oqa.getText().toString());
                        SnsCommentFooter.this.oqa.setText("");
                    }

                    public final void anp() {
                    }

                    public final void aeD() {
                        h.h(SnsCommentFooter.this.fnF, j.qSK, j.qSL);
                    }
                });
            }
        });
    }

    public final void bBB() {
        this.rHf.setVisibility(8);
    }

    protected final void ra(int i) {
        super.ra(i);
        switch (i) {
            case -3:
                this.oqe = true;
                if (getVisibility() == 0 && this.rHn != null) {
                    x.d("MicroMsg.SnsCommentFooter", "jacks dynamic adjust animation up");
                    this.rHn.bCU();
                    return;
                }
                return;
            default:
                this.oqe = false;
                return;
        }
    }

    public final void aYy() {
        this.rHn = null;
        if (this.oqc != null) {
            x.i("MicroMsg.SnsCommentFooter", "commentfooter release");
            this.oqc.tj();
            this.oqc.destroy();
        }
    }

    private void gz(boolean z) {
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), com.tencent.mm.plugin.sns.i.a.bqk);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), com.tencent.mm.plugin.sns.i.a.bql);
        loadAnimation.setDuration(150);
        loadAnimation2.setDuration(150);
        if (this.oqb != null && this.rHg != null) {
            if (z) {
                if (this.oqb.getVisibility() != 8 && this.oqb.getVisibility() != 4) {
                    this.rHg.startAnimation(loadAnimation);
                    this.rHg.setVisibility(0);
                    this.oqb.startAnimation(loadAnimation2);
                    this.oqb.setVisibility(8);
                } else {
                    return;
                }
            } else if (this.oqb.getVisibility() != 0 && this.oqb.getVisibility() != 0) {
                this.oqb.startAnimation(loadAnimation);
                this.oqb.setVisibility(0);
                this.rHg.startAnimation(loadAnimation2);
                this.rHg.setVisibility(8);
            } else {
                return;
            }
            this.rHg.getParent().requestLayout();
        }
    }

    protected final List<View> aYz() {
        List<View> arrayList = new ArrayList();
        arrayList.add(this.oqc);
        return arrayList;
    }
}
