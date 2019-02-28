package com.tencent.mm.ui.base;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.v;
import com.tencent.mm.v.a.d;
import com.tencent.mm.v.a.e;
import com.tencent.mm.v.a.f;
import com.tencent.mm.v.a.g;
import com.tencent.mm.v.a.h;
import com.tencent.mm.v.a.j;
import com.tencent.mm.v.a.l;
import java.util.List;

public class i extends Dialog implements DialogInterface {
    private CheckBox KR;
    private View kK;
    public EditText kT;
    private View kbj;
    private Context mContext;
    private TextView maU;
    private Button moC;
    private boolean needEdit = false;
    private ImageView nwX;
    private boolean qva;
    public Button tbx;
    private LinearLayout xQD;
    private TextView xQE;
    private TextView xQF;
    private LinearLayout xQG;
    private LinearLayout xQH;
    private TextView yhD;
    private TextView yhE;
    private View yhF;
    private ViewStub yhG;
    private ViewGroup yhH;
    private ViewGroup yhI;
    private View yhJ;
    private boolean yhK = false;
    private Animation yhL;
    private Animation yhM;
    private Animation yhN;
    private Animation yhO;
    private c yhP;
    private int[] yhQ = new int[]{g.gYr, g.gYs, g.gYt, g.gYu, g.gYv, g.gYw, g.gYx, g.gYy, g.gYz};

    public static class a {
        private Context mContext;
        public c yhY = new c();

        public interface a {
            void aKs();
        }

        public interface c {
            CharSequence a(CharSequence charSequence, float f);
        }

        public interface b {
            void cbD();
        }

        public a(Context context) {
            this.mContext = context;
        }

        public final a Zm(String str) {
            this.yhY.title = str;
            return this;
        }

        public final a Q(CharSequence charSequence) {
            this.yhY.title = charSequence;
            return this;
        }

        public final a ES(int i) {
            this.yhY.title = this.mContext.getString(i);
            return this;
        }

        public final a Zn(String str) {
            this.yhY.yfD = str;
            return this;
        }

        public final a ET(int i) {
            this.yhY.yfD = this.mContext.getString(i);
            return this;
        }

        public final a R(CharSequence charSequence) {
            this.yhY.yfE = charSequence;
            return this;
        }

        public final a mo(boolean z) {
            this.yhY.yfJ = z;
            return this;
        }

        public final a a(String str, CharSequence charSequence, Boolean bool, b bVar) {
            this.yhY.yfs = str;
            this.yhY.yfu = charSequence;
            this.yhY.yfv = bool.booleanValue();
            this.yhY.yfx = bVar;
            return this;
        }

        public final a a(c cVar) {
            this.yhY.yfz = cVar;
            return this;
        }

        public final a a(Bitmap bitmap, boolean z, int i) {
            this.yhY.yfC = bitmap;
            this.yhY.yfK = z;
            this.yhY.yfR = i;
            return this;
        }

        public final a EU(int i) {
            this.yhY.yfQ = i;
            return this;
        }

        public final a Zo(String str) {
            this.yhY.yfp = str;
            return this;
        }

        public final a dk(View view) {
            this.yhY.tFx = view;
            return this;
        }

        public final a Zp(String str) {
            this.yhY.yfG = str;
            return this;
        }

        public final a EV(int i) {
            this.yhY.yfG = this.mContext.getString(i);
            return this;
        }

        public final a a(OnClickListener onClickListener) {
            this.yhY.yfL = onClickListener;
            return this;
        }

        public final a a(boolean z, OnClickListener onClickListener) {
            this.yhY.yfL = onClickListener;
            this.yhY.yfT = z;
            return this;
        }

        public final a Zq(String str) {
            this.yhY.yfH = str;
            return this;
        }

        public final a EW(int i) {
            this.yhY.yfH = this.mContext.getString(i);
            return this;
        }

        public final a b(OnClickListener onClickListener) {
            this.yhY.yfM = onClickListener;
            return this;
        }

        public final a d(OnCancelListener onCancelListener) {
            this.yhY.Gj = onCancelListener;
            return this;
        }

        public final a a(OnDismissListener onDismissListener) {
            this.yhY.Gk = onDismissListener;
            return this;
        }

        public final a mp(boolean z) {
            this.yhY.qva = z;
            return this;
        }

        public final a mq(boolean z) {
            this.yhY.yfI = z;
            return this;
        }

        public i ale() {
            i iVar = new i(this.mContext);
            iVar.a(this.yhY);
            return iVar;
        }
    }

    static /* synthetic */ void a(i iVar, Animation animation) {
        if (iVar.xQG != null) {
            iVar.xQG.startAnimation(animation);
        }
        if (iVar.xQH != null) {
            iVar.xQH.startAnimation(animation);
        }
        if (iVar.yhE != null && iVar.yhK) {
            iVar.yhE.startAnimation(animation);
        }
        if (iVar.kT == null) {
            return;
        }
        if (iVar.needEdit) {
            iVar.kT.startAnimation(animation);
        } else {
            iVar.kT.setVisibility(8);
        }
    }

    public i(Context context) {
        super(context, l.eZl);
        this.mContext = context;
        this.xQD = (LinearLayout) v.fw(this.mContext).inflate(h.gYZ, null);
        this.tbx = (Button) this.xQD.findViewById(g.cwq);
        this.moC = (Button) this.xQD.findViewById(g.cwg);
        this.maU = (TextView) this.xQD.findViewById(g.gXx);
        this.xQE = (TextView) this.xQD.findViewById(g.cwk);
        this.xQF = (TextView) this.xQD.findViewById(g.gXw);
        this.yhD = (TextView) this.xQD.findViewById(g.cwo);
        this.yhE = (TextView) this.xQD.findViewById(g.bWS);
        this.kT = (EditText) this.xQD.findViewById(g.bWW);
        this.KR = (CheckBox) this.xQD.findViewById(g.gXb);
        this.nwX = (ImageView) this.xQD.findViewById(g.cwn);
        this.kbj = this.xQD.findViewById(g.gXy);
        this.yhG = (ViewStub) this.xQD.findViewById(g.gYB);
        this.xQG = (LinearLayout) this.xQD.findViewById(g.cwl);
        this.yhH = (ViewGroup) this.xQD.findViewById(g.gXt);
        this.yhJ = this.xQD.findViewById(g.gXu);
        this.xQH = (LinearLayout) this.xQD.findViewById(g.gXv);
        this.yhI = (ViewGroup) this.xQD.findViewById(g.gYA);
        setCanceledOnTouchOutside(true);
        this.yhL = AnimationUtils.loadAnimation(ad.getContext(), com.tencent.mm.v.a.a.bpO);
        this.yhM = AnimationUtils.loadAnimation(ad.getContext(), com.tencent.mm.v.a.a.bpO);
        this.yhN = AnimationUtils.loadAnimation(ad.getContext(), com.tencent.mm.v.a.a.bpP);
        this.yhO = AnimationUtils.loadAnimation(ad.getContext(), com.tencent.mm.v.a.a.bpP);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.xQD);
    }

    public View getContentView() {
        return this.xQD;
    }

    public void setTitle(CharSequence charSequence) {
        this.kbj.setVisibility(0);
        this.maU.setVisibility(0);
        if (this.yhP != null) {
            charSequence = this.yhP.a(charSequence.toString(), this.maU.getTextSize());
        }
        this.maU.setMaxLines(2);
        this.maU.setText(charSequence);
        Eh(d.gWh);
    }

    public void setTitle(int i) {
        this.kbj.setVisibility(0);
        this.maU.setVisibility(0);
        this.maU.setMaxLines(2);
        this.maU.setText(i);
        Eh(d.gWh);
    }

    private void Eh(int i) {
        if (this.xQE != null) {
            this.xQE.setTextColor(this.xQE.getContext().getResources().getColor(i));
        }
    }

    public final void setMessage(CharSequence charSequence) {
        this.xQG.setVisibility(0);
        this.xQE.setVisibility(0);
        if (this.yhP != null) {
            c cVar = this.yhP;
            this.xQE.getContext();
            charSequence = cVar.a(charSequence.toString(), this.xQE.getTextSize());
        }
        this.xQE.setText(charSequence);
    }

    private void mm(boolean z) {
        if (z) {
            int fromDPToPix = com.tencent.mm.bu.a.fromDPToPix(this.mContext, 8);
            this.xQG.setVisibility(0);
            this.xQG.setPadding(fromDPToPix, fromDPToPix, fromDPToPix, fromDPToPix);
            this.xQG.setBackgroundResource(f.gWE);
        }
    }

    public final String cpG() {
        return this.kT == null ? null : this.kT.getText().toString();
    }

    private void EP(int i) {
        if (this.xQG != null) {
            this.xQG.setVisibility(i);
        }
        if (this.xQH != null) {
            this.xQH.setVisibility(i);
        }
        if (this.yhE != null && this.yhK) {
            this.yhE.setVisibility(i);
        }
        if (this.kT == null) {
            return;
        }
        if (this.needEdit) {
            this.kT.setVisibility(i);
        } else {
            this.kT.setVisibility(8);
        }
    }

    private void dc(List<String> list) {
        LinearLayout linearLayout;
        this.yhG.setLayoutResource(h.gYR);
        try {
            linearLayout = (LinearLayout) this.yhG.inflate();
        } catch (Exception e) {
            this.yhG.setVisibility(0);
            linearLayout = null;
        }
        if (list != null) {
            int i = 0;
            for (String str : list) {
                if (i <= 8) {
                    if (linearLayout != null) {
                        ImageView imageView = (ImageView) linearLayout.findViewById(this.yhQ[i]);
                        if (str != null) {
                            imageView.setVisibility(0);
                            com.tencent.mm.ui.e.a.a.a(imageView, str);
                            i++;
                        }
                    }
                    i = i;
                } else {
                    return;
                }
            }
        }
    }

    private void J(View view, int i) {
        this.kK = view;
        if (this.kK != null) {
            this.xQG.setVisibility(0);
            this.xQH.setVisibility(0);
            this.xQH.removeAllViews();
            this.xQH.setGravity(1);
            this.xQH.addView(this.kK, new LayoutParams(i, i));
        }
    }

    public final void a(CharSequence charSequence, final boolean z, final OnClickListener onClickListener) {
        if (this.tbx != null) {
            this.tbx.setVisibility(0);
            this.tbx.setText(charSequence);
            this.tbx.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (onClickListener != null) {
                        onClickListener.onClick(i.this, -1);
                    }
                    if (z) {
                        i.this.dismiss();
                    }
                }
            });
        }
    }

    public final void EQ(int i) {
        this.tbx.setTextColor(i);
    }

    public final void ER(int i) {
        this.moC.setTextColor(i);
    }

    public final void a(int i, OnClickListener onClickListener) {
        a(this.mContext.getString(i), true, onClickListener);
    }

    public final void b(CharSequence charSequence, final boolean z, final OnClickListener onClickListener) {
        if (this.moC != null) {
            this.moC.setVisibility(0);
            this.moC.setText(charSequence);
            this.moC.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (onClickListener != null) {
                        onClickListener.onClick(i.this, -2);
                    }
                    if (z) {
                        i.this.cancel();
                    }
                }
            });
        }
    }

    public final void b(int i, OnClickListener onClickListener) {
        b(this.mContext.getString(i), true, onClickListener);
    }

    public void setCancelable(boolean z) {
        super.setCancelable(z);
        this.qva = z;
        setCanceledOnTouchOutside(this.qva);
    }

    public final void mn(boolean z) {
        super.setCancelable(false);
    }

    public final Button getButton(int i) {
        switch (i) {
            case -2:
                return this.moC;
            case -1:
                return this.tbx;
            default:
                return null;
        }
    }

    public final void a(c cVar) {
        int i;
        CharSequence charSequence;
        CharSequence charSequence2;
        ImageView imageView;
        TextView textView;
        if (cVar.title != null && cVar.title.length() > 0) {
            setTitle(cVar.title);
        }
        if (cVar.voU != 0) {
            this.maU.setTextColor(ColorStateList.valueOf(cVar.voU));
        }
        if (cVar.yfO != 0) {
            this.maU.setMaxLines(cVar.yfO);
        }
        if (cVar.yfP != 0) {
            this.xQE.setMaxLines(cVar.yfP);
        }
        if (cVar.tFx != null) {
            J(cVar.tFx, -1);
        }
        if (cVar.yfN != null) {
            this.yhF = cVar.yfN;
            if (this.yhF != null) {
                this.xQG.setVisibility(8);
                this.yhE.setVisibility(8);
                this.kT.setVisibility(8);
                this.yhI.removeAllViews();
                this.yhI.addView(this.yhF, new LayoutParams(-1, -1));
                this.yhI.setVisibility(8);
            }
        }
        if (cVar.yfA != null) {
            Drawable drawable = cVar.yfA;
            if (this.kK == null) {
                this.xQG.setVisibility(0);
                this.nwX.setVisibility(0);
                this.nwX.setBackgroundDrawable(drawable);
            }
        }
        if (cVar.yfD != null && cVar.yfD.length() > 0) {
            setMessage(cVar.yfD);
        }
        mm(cVar.yfJ);
        if (cVar.fwx != null) {
            String str = cVar.fwx;
            int fromDPToPix = com.tencent.mm.bu.a.fromDPToPix(this.mContext, 120);
            this.xQG.setVisibility(0);
            this.nwX.setVisibility(0);
            if (this.nwX instanceof com.tencent.mm.ui.e.a) {
                ((com.tencent.mm.ui.e.a) this.nwX).Y(str, fromDPToPix, fromDPToPix);
            }
            i = cVar.yfS;
            this.xQG.setVisibility(i);
            this.nwX.setVisibility(i);
        }
        if (!(cVar.yfU || cVar.yfV)) {
            if (cVar.yfD != null && cVar.yfD.length() > 0) {
                setMessage(cVar.yfD);
            }
            if (cVar.yfE == null || cVar.yfE.length() <= 0) {
                mm(false);
            } else {
                charSequence = cVar.yfE;
                this.xQG.setVisibility(0);
                this.xQF.setVisibility(0);
                this.xQF.setMaxLines(2);
                this.xQF.setText(charSequence);
            }
            if (cVar.yfF != null && cVar.yfF.length() > 0) {
                charSequence = cVar.yfF;
                if (charSequence != null) {
                    this.xQG.setVisibility(0);
                    this.yhD.setVisibility(0);
                    if (this.yhP != null) {
                        c cVar2 = this.yhP;
                        this.yhD.getContext();
                        charSequence = cVar2.a(charSequence.toString(), this.yhD.getTextSize());
                    }
                    this.yhD.setText(charSequence);
                }
            }
            if (cVar.yfB != null) {
                Bitmap bitmap = cVar.yfB;
                if (this.kK == null) {
                    this.xQG.setVisibility(0);
                    this.nwX.setVisibility(0);
                    this.nwX.setImageBitmap(bitmap);
                }
            }
        }
        Bitmap bitmap2;
        CharSequence charSequence3;
        View inflate;
        if (cVar.yfU) {
            bitmap2 = cVar.yfB;
            charSequence2 = cVar.yfE;
            charSequence3 = cVar.yfF;
            inflate = v.fw(this.mContext).inflate(h.gYN, null);
            if (bitmap2 != null) {
                imageView = (ImageView) inflate.findViewById(g.cwn);
                imageView.setVisibility(0);
                imageView.setImageBitmap(bitmap2);
            }
            if (charSequence2 != null) {
                textView = (TextView) inflate.findViewById(g.gXw);
                textView.setVisibility(0);
                if (this.yhP != null) {
                    charSequence2 = this.yhP.a(charSequence2.toString(), textView.getTextSize());
                }
                textView.setText(charSequence2);
            }
            if (charSequence3 != null) {
                textView = (TextView) inflate.findViewById(g.cwo);
                textView.setVisibility(0);
                if (this.yhP != null) {
                    charSequence2 = this.yhP.a(charSequence3.toString(), textView.getTextSize());
                } else {
                    charSequence2 = charSequence3;
                }
                textView.setText(charSequence2);
            }
            J(inflate, -1);
        } else if (cVar.yfV) {
            bitmap2 = cVar.yfB;
            charSequence2 = cVar.yfE;
            charSequence3 = cVar.yfF;
            inflate = v.fw(this.mContext).inflate(h.gYO, null);
            if (bitmap2 != null) {
                imageView = (ImageView) inflate.findViewById(g.cwn);
                imageView.setVisibility(0);
                imageView.setImageBitmap(bitmap2);
            }
            if (charSequence2 != null) {
                textView = (TextView) inflate.findViewById(g.gXw);
                textView.setVisibility(0);
                if (this.yhP != null) {
                    charSequence2 = this.yhP.a(charSequence2.toString(), textView.getTextSize());
                }
                textView.setText(charSequence2);
            }
            if (charSequence3 != null) {
                textView = (TextView) inflate.findViewById(g.cwo);
                textView.setVisibility(0);
                if (this.yhP != null) {
                    charSequence2 = this.yhP.a(charSequence3.toString(), textView.getTextSize());
                } else {
                    charSequence2 = charSequence3;
                }
                textView.setText(charSequence2);
            }
            J(inflate, -1);
        }
        if (!(cVar.yfs == null && cVar.yfu == null)) {
            String str2 = cVar.yfs;
            charSequence2 = cVar.yfu;
            Boolean valueOf = Boolean.valueOf(cVar.yfv);
            final b bVar = cVar.yfx;
            this.yhG.setLayoutResource(h.gYQ);
            LinearLayout linearLayout = null;
            try {
                linearLayout = (LinearLayout) this.yhG.inflate();
            } catch (Exception e) {
                this.yhG.setVisibility(0);
            }
            if (!(linearLayout == null || str2 == null)) {
                imageView = (ImageView) linearLayout.findViewById(g.gYq);
                imageView.setVisibility(0);
                com.tencent.mm.ui.e.a.a.a(imageView, str2);
            }
            if (!(linearLayout == null || charSequence2 == null)) {
                textView = (TextView) linearLayout.findViewById(g.gYC);
                textView.setVisibility(0);
                if (this.yhP != null) {
                    charSequence2 = this.yhP.a(charSequence2.toString(), this.maU.getTextSize());
                }
                textView.setText(charSequence2);
            }
            if (valueOf.booleanValue() && linearLayout != null) {
                imageView = (ImageView) linearLayout.findViewById(g.gXp);
                imageView.setVisibility(0);
                EP(0);
                linearLayout.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        if (bVar != null) {
                            bVar.cbD();
                        }
                        if (imageView.isSelected()) {
                            i.this.yhI.startAnimation(i.this.yhO);
                            i.this.yhO.setAnimationListener(new AnimationListener() {
                                public final void onAnimationStart(Animation animation) {
                                    i.a(i.this, i.this.yhL);
                                }

                                public final void onAnimationEnd(Animation animation) {
                                    i.this.yhI.setVisibility(8);
                                    i.this.EP(0);
                                }

                                public final void onAnimationRepeat(Animation animation) {
                                }
                            });
                            ObjectAnimator.ofFloat(imageView, "rotation", new float[]{180.0f, 0.0f}).setDuration(200).start();
                            imageView.setSelected(false);
                            return;
                        }
                        i.this.yhI.startAnimation(i.this.yhM);
                        i.this.yhM.setAnimationListener(new AnimationListener() {
                            public final void onAnimationStart(Animation animation) {
                                i.a(i.this, i.this.yhN);
                            }

                            public final void onAnimationEnd(Animation animation) {
                                i.this.yhI.setVisibility(0);
                                i.this.EP(8);
                            }

                            public final void onAnimationRepeat(Animation animation) {
                            }
                        });
                        ObjectAnimator.ofFloat(imageView, "rotation", new float[]{0.0f, 180.0f}).setDuration(200).start();
                        imageView.setSelected(true);
                    }
                });
            }
        }
        if (cVar.yfy != null) {
            final a aVar = cVar.yfy;
            if (this.xQG != null && this.xQG.getVisibility() == 0) {
                this.xQG.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        if (aVar != null) {
                            aVar.aKs();
                        }
                    }
                });
            } else if (this.xQH != null) {
                this.xQH.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        if (aVar != null) {
                            aVar.aKs();
                        }
                    }
                });
            }
        }
        if (cVar.yft != null) {
            dc(cVar.yft);
        }
        if (!(cVar.yfC == null || cVar.yfC.isRecycled())) {
            Bitmap bitmap3 = cVar.yfC;
            boolean z = cVar.yfK;
            int i2 = cVar.yfR;
            if (bitmap3 != null) {
                Bitmap bitmap4;
                mm(false);
                this.xQG.setVisibility(0);
                this.xQG.setGravity(1);
                this.xQG.setPadding(0, 0, 0, 0);
                View inflate2 = View.inflate(this.mContext, h.gYP, null);
                imageView = (ImageView) inflate2.findViewById(g.cwn);
                if (z) {
                    int i3;
                    int i4;
                    bitmap4 = null;
                    float height = ((float) bitmap3.getHeight()) / ((float) bitmap3.getWidth());
                    int ab = com.tencent.mm.bu.a.ab(this.mContext, e.gWw);
                    int ab2 = com.tencent.mm.bu.a.ab(this.mContext, e.gWv);
                    int i5;
                    if (height > 0.0f && ((double) height) < 0.5d) {
                        i3 = (int) (((float) ab) / height);
                        i4 = ab;
                    } else if (((double) height) >= 0.5d && height < 1.0f) {
                        ab = (int) (((float) ab2) * height);
                        i3 = ab2;
                        i4 = ab;
                    } else if (height >= 1.0f && height < 2.0f) {
                        ab = (int) (((float) ab2) / height);
                        i3 = ab;
                        i4 = ab2;
                        i5 = ab2;
                        ab2 = ab;
                        ab = i5;
                    } else if (height >= 2.0f) {
                        i4 = (int) (((float) ab) * height);
                        i3 = ab;
                        i5 = ab;
                        ab = ab2;
                        ab2 = i5;
                    } else {
                        ab = 0;
                        ab2 = 0;
                        i3 = 0;
                        i4 = 0;
                    }
                    if (i4 > 0 && i3 > 0 && bitmap3 != null) {
                        bitmap4 = Bitmap.createScaledBitmap(bitmap3, i3, i4, true);
                        imageView.setLayoutParams(new FrameLayout.LayoutParams(ab2, ab));
                    }
                    bitmap4 = com.tencent.mm.sdk.platformtools.d.a(bitmap4, true, (float) com.tencent.mm.bu.a.fromDPToPix(ad.getContext(), 3));
                } else {
                    bitmap4 = bitmap3;
                }
                imageView.setImageBitmap(bitmap4);
                imageView = (ImageView) inflate2.findViewById(g.gXo);
                if (i2 == 0) {
                    imageView.setVisibility(8);
                } else {
                    imageView.setVisibility(0);
                    if (i2 == 1) {
                        imageView.setImageResource(j.gZY);
                    } else if (i2 == 2) {
                        imageView.setImageResource(j.dvM);
                    }
                }
                J(inflate2, -2);
            }
        }
        if (cVar.yfo != null && cVar.yfo.length() > 0) {
            charSequence = cVar.yfo;
            if (charSequence != null) {
                this.yhE.setVisibility(0);
                this.yhE.setText(charSequence);
            }
            this.yhK = true;
            i = cVar.yfQ;
            if (this.yhE != null) {
                this.yhE.setGravity(i);
            }
        }
        if (cVar.yfp != null && cVar.yfp.length() > 0) {
            charSequence = cVar.yfp;
            this.kT.setVisibility(0);
            this.kT.setHint(charSequence);
        }
        if (cVar.yfq != null && cVar.yfq.length() > 0) {
            charSequence = cVar.yfq;
            this.KR.setVisibility(0);
            this.KR.setText(charSequence);
        }
        if (cVar.yfr) {
            this.needEdit = cVar.yfr;
            if (cVar.yfr) {
                this.kT.setVisibility(0);
            } else {
                this.kT.setVisibility(8);
            }
        }
        if (cVar.yfG != null && cVar.yfG.length() > 0) {
            a(cVar.yfG, cVar.yfT, cVar.yfL);
        }
        if (cVar.yfH != null && cVar.yfH.length() > 0) {
            b(cVar.yfH, true, cVar.yfM);
        }
        if (cVar.Gj != null) {
            setOnCancelListener(cVar.Gj);
        }
        if (cVar.Gk != null) {
            setOnDismissListener(cVar.Gk);
        }
        if (cVar.yfz != null) {
            this.yhP = cVar.yfz;
        }
        setCancelable(cVar.qva);
        this.qva = cVar.qva;
        if (!this.qva) {
            super.setCancelable(cVar.yfI);
        }
        if (cVar.yfw) {
            View inflate3 = v.fw(getContext()).inflate(h.gYM, null);
            this.moC = (Button) inflate3.findViewById(g.cwg);
            this.tbx = (Button) inflate3.findViewById(g.cwq);
            if (cVar.yfG != null && cVar.yfG.length() > 0) {
                a(cVar.yfG, cVar.yfT, cVar.yfL);
            }
            if (cVar.yfH != null && cVar.yfH.length() > 0) {
                b(cVar.yfH, true, cVar.yfM);
            }
            ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, -1);
            this.yhJ.setVisibility(8);
            this.yhH.removeAllViews();
            this.yhH.addView(inflate3, layoutParams);
        }
    }

    public void show() {
        try {
            super.show();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MMAlertDialog", e, "", new Object[0]);
        }
    }

    public void dismiss() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            ah.y(new Runnable() {
                public final void run() {
                    i.this.dismiss();
                }
            });
            x.e("MicroMsg.MMAlertDialog", bi.chl().toString());
            return;
        }
        try {
            super.dismiss();
        } catch (Exception e) {
            x.e("MicroMsg.MMAlertDialog", "dismiss exception, e = " + e.getMessage());
        }
    }
}
