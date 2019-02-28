package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.share.i;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

public class VoicePrintVolumeMeter extends View {
    static int obh = 20;
    private static int sol = Color.rgb(240, 250, 235);
    private static int som = Color.rgb(i.CTRL_INDEX, 240, 200);
    private static int son = 100;
    private static float sou = 1.5f;
    private static float sov = 2.0f;
    private static float sow = 0.1f;
    private static float sox = 0.05f;
    private Paint fC;
    private Context mContext;
    boolean mIsPlaying = false;
    float mVolume = -1.0f;
    View oaV;
    private int soh = -1;
    private int soi = -1;
    ah soj = null;
    al sok = null;
    private float soo = 0.0f;
    private float sop = 0.0f;
    private float soq = 0.0f;
    private float sor = 0.0f;
    private float sos = 0.0f;
    private float sot = 0.0f;
    boolean soy = true;

    static /* synthetic */ void a(VoicePrintVolumeMeter voicePrintVolumeMeter) {
        if (voicePrintVolumeMeter.mIsPlaying) {
            if (voicePrintVolumeMeter.soy) {
                voicePrintVolumeMeter.sos *= sow + 1.0f;
                voicePrintVolumeMeter.sot = voicePrintVolumeMeter.sos * sou;
            } else {
                voicePrintVolumeMeter.sos *= 1.0f - sox;
                voicePrintVolumeMeter.sot = voicePrintVolumeMeter.sos * sou;
            }
            voicePrintVolumeMeter.postInvalidate();
        }
    }

    public VoicePrintVolumeMeter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public VoicePrintVolumeMeter(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.fC = new Paint();
        this.soj = new ah("VoicePrintVolumeMeter");
        this.sok = new al(this.soj.oFY.getLooper(), new a() {
            public final boolean uG() {
                VoicePrintVolumeMeter.a(VoicePrintVolumeMeter.this);
                return VoicePrintVolumeMeter.this.mIsPlaying;
            }
        }, true);
    }

    final void bGD() {
        if (this.oaV != null && this.oaV.getVisibility() != 8) {
            int[] iArr = new int[2];
            this.oaV.getLocationOnScreen(iArr);
            if (iArr[0] == 0 || iArr[1] == 0) {
                x.d("MicroMsg.VoicePrintVolumeMeter", "setCenterLocation, cannot get archView location");
                return;
            }
            int width = this.oaV.getWidth();
            int height = this.oaV.getHeight();
            if (height == 0 || width == 0) {
                x.d("MicroMsg.VoicePrintVolumeMeter", "setCenterLocation, cannot get archView size");
                return;
            }
            this.soh = iArr[0] + (width / 2);
            this.soi = (iArr[1] + (height / 2)) - com.tencent.mm.bu.a.fromDPToPix(this.mContext, 25);
            x.d("MicroMsg.VoicePrintVolumeMeter", "setCenterLocation, mCenterX:%d, mCenterY:%d", Integer.valueOf(this.soh), Integer.valueOf(this.soi));
            this.soo = ((float) width) / 2.0f;
            this.sop = this.soo * sou;
            this.soq = this.soo * sov;
            this.sor = this.sop * sov;
            this.sot = this.sop;
            this.sos = this.soo;
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mIsPlaying) {
            if (this.soh == -1 || this.soi == -1) {
                bGD();
            }
            this.fC.setAlpha(son);
            if (this.sot > this.sor) {
                this.sot = this.sor;
            }
            if (this.sot < this.sop) {
                this.sot = this.sop;
            }
            this.fC.setColor(sol);
            canvas.drawCircle((float) this.soh, (float) this.soi, this.sot, this.fC);
            if (this.sos > this.soq) {
                this.sos = this.soq;
            }
            if (this.sos < this.soo) {
                this.sos = this.soo;
            }
            this.fC.setColor(som);
            canvas.drawCircle((float) this.soh, (float) this.soi, this.sos, this.fC);
        }
    }

    public final void stop() {
        reset();
        this.mIsPlaying = false;
        this.sok.TN();
        postInvalidate();
    }

    public final void reset() {
        this.soy = false;
        this.mVolume = -1.0f;
        this.mIsPlaying = false;
        this.sos = 0.0f;
        this.sot = 0.0f;
        postInvalidate();
    }
}
