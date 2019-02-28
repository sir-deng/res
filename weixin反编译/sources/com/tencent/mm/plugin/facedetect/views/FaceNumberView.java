package com.tencent.mm.plugin.facedetect.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.facedetect.a.d;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.Timer;

public class FaceNumberView extends LinearLayout {
    private String msK;
    private int msL;
    public ViewGroup msM;
    public FaceNumberItemView[] msN;
    public int msO;
    private Animation msP;
    private int msQ;

    public enum a {
        ;

        static {
            msR = 1;
            msS = 2;
            msT = new int[]{msR, msS};
        }
    }

    public FaceNumberView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public FaceNumberView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.msK = null;
        this.msN = null;
        this.msO = 0;
        this.msP = null;
        this.msQ = a.msS;
        this.msM = (ViewGroup) inflate(getContext(), g.mjs, null);
        addView(this.msM);
        this.msP = AnimationUtils.loadAnimation(getContext(), com.tencent.mm.plugin.facedetect.a.a.bqk);
    }

    private static void a(FaceNumberItemView faceNumberItemView, String str) {
        if (faceNumberItemView != null) {
            if (str.equals("0")) {
                faceNumberItemView.setImageResource(d.miq);
            } else if (str.equals("1")) {
                faceNumberItemView.setImageResource(d.mir);
            } else if (str.equals("2")) {
                faceNumberItemView.setImageResource(d.mis);
            } else if (str.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
                faceNumberItemView.setImageResource(d.mit);
            } else if (str.equals("4")) {
                faceNumberItemView.setImageResource(d.miu);
            } else if (str.equals("5")) {
                faceNumberItemView.setImageResource(d.miv);
            } else if (str.equals("6")) {
                faceNumberItemView.setImageResource(d.miw);
            } else if (str.equals("7")) {
                faceNumberItemView.setImageResource(d.mix);
            } else if (str.equals("8")) {
                faceNumberItemView.setImageResource(d.miy);
            } else if (str.equals("9")) {
                faceNumberItemView.setImageResource(d.miz);
            } else {
                faceNumberItemView.setImageResource(d.miA);
            }
        }
    }

    public final void Au(String str) {
        int i = 0;
        this.msK = str;
        if (this.msK != null) {
            this.msL = this.msK.length();
        } else {
            this.msL = 0;
        }
        if (this.msN != null && this.msN.length > 0) {
            if (bi.oN(this.msK)) {
                while (i < this.msN.length) {
                    a(this.msN[i], "point");
                    i++;
                }
                return;
            }
            for (int i2 = 0; i2 < this.msN.length; i2++) {
                String str2;
                if (this.msL > i2) {
                    String str3 = this.msK.charAt(i2);
                    FaceNumberItemView faceNumberItemView;
                    if (this.msL == i2 + 1) {
                        faceNumberItemView = this.msN[i2];
                        if (faceNumberItemView.msz != null) {
                            faceNumberItemView.aIn();
                        }
                        faceNumberItemView.msz = new Timer("FaceNumberItemView_karaoke", true);
                        faceNumberItemView.msz.scheduleAtFixedRate(new a(faceNumberItemView, faceNumberItemView.msH, (byte) 0), 0, FaceNumberItemView.msA);
                        str2 = str3;
                    } else {
                        this.msN[i2].aIn();
                        faceNumberItemView = this.msN[i2];
                        faceNumberItemView.msG = 30;
                        faceNumberItemView.invalidate();
                        str2 = str3;
                    }
                } else {
                    str2 = "";
                }
                a(this.msN[i2], str2);
            }
        }
    }
}
