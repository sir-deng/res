package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class t extends i implements SensorEventListener {
    private SensorManager bgR;
    Sensor bkA;
    Sensor bkC;
    ImageView fwa;
    ProgressBar lFV;
    int rqC;
    final float rqD = 10.0f;
    final int rqE = 1;
    HorizontalScrollView rqF;
    float[] rqG;
    float[] rqH;
    private int rqI = 0;
    boolean rqJ = true;

    public t(Context context, o oVar, ViewGroup viewGroup) {
        super(context, oVar, viewGroup);
    }

    protected final int bkr() {
        return g.qMN;
    }

    public final View bxG() {
        View view = this.contentView;
        this.bgR = (SensorManager) this.context.getSystemService("sensor");
        this.bkA = this.bgR.getDefaultSensor(1);
        this.bkC = this.bgR.getDefaultSensor(2);
        this.rqF = (HorizontalScrollView) view.findViewById(f.qGf);
        this.fwa = (ImageView) view.findViewById(f.qGg);
        this.lFV = (ProgressBar) view.findViewById(f.cEk);
        this.lFV.setVisibility(8);
        return view;
    }

    protected final void bxK() {
        if (!e.bO(d.ep("adId", ((o) this.rpm).rmC))) {
            this.rqJ = false;
        }
        this.rqF.setLayoutParams(new LayoutParams(this.kJB, this.kJC));
        this.fwa.setLayoutParams(new LayoutParams(this.kJB, this.kJC));
        this.contentView.setLayoutParams(new LinearLayout.LayoutParams(this.kJB, this.kJC));
        this.contentView.setPadding(this.contentView.getPaddingLeft(), (int) ((o) this.rpm).rmP, this.contentView.getPaddingRight(), (int) ((o) this.rpm).rmQ);
        String str = ((o) this.rpm).rmC;
        Bitmap er = d.er("adId", str);
        if (er != null) {
            x.i("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "loaded cached image with  " + str);
            H(er);
            return;
        }
        startLoading();
        d.a(str, ((o) this.rpm).rmO, new a() {
            public final void bxM() {
                t.this.startLoading();
            }

            public final void bxN() {
                t.this.lFV.setVisibility(8);
            }

            public final void LD(String str) {
                try {
                    t.this.H(BitmapFactory.decodeFile(str));
                } catch (Throwable e) {
                    x.e("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "%s" + bi.i(e));
                }
            }
        });
    }

    public final void startLoading() {
        this.lFV.setVisibility(0);
    }

    public final void H(Bitmap bitmap) {
        if (bitmap == null) {
            x.e("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "when set image the bmp is null!");
        } else if (this.fwa == null) {
            x.e("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "when set image the imageView is null!");
        } else if (bitmap.getHeight() == 0) {
            x.e("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "when set image the bmp.getHeight is 0!");
        } else {
            this.lFV.setVisibility(8);
            this.fwa.setImageBitmap(bitmap);
            this.fwa.setLayoutParams(new LayoutParams((bitmap.getWidth() * this.kJC) / bitmap.getHeight(), this.kJC));
            this.fwa.post(new Runnable() {
                public final void run() {
                    int measuredWidth = t.this.fwa.getMeasuredWidth();
                    if (measuredWidth > t.this.kJB) {
                        t.this.rqC = (measuredWidth - t.this.kJB) / 2;
                        t.this.rqF.scrollBy(t.this.rqC, 0);
                    }
                }
            });
            if (bitmap.getHeight() != 0) {
                this.contentView.setLayoutParams(new LinearLayout.LayoutParams((bitmap.getWidth() * this.kJC) / bitmap.getHeight(), this.kJC));
            }
        }
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        float f = -10.0f;
        if (sensorEvent.sensor.getType() == 1) {
            this.rqG = sensorEvent.values;
        }
        if (sensorEvent.sensor.getType() == 2) {
            this.rqH = sensorEvent.values;
        }
        if (this.rqG != null && this.rqH != null) {
            float[] fArr = new float[9];
            if (SensorManager.getRotationMatrix(fArr, new float[9], this.rqG, this.rqH)) {
                float[] fArr2 = new float[3];
                SensorManager.getOrientation(fArr, fArr2);
                float f2 = fArr2[2];
                if (this.rqC != 0) {
                    if (f2 > 10.0f) {
                        f2 = 10.0f;
                    }
                    if (f2 >= -10.0f) {
                        f = f2;
                    }
                    this.rqF.scrollBy((int) ((f * ((float) this.rqC)) / 10.0f), 0);
                }
            }
        }
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public final void bxr() {
        super.bxr();
        this.bgR.registerListener(this, this.bkA, 1);
        this.bgR.registerListener(this, this.bkC, 1);
    }

    public final void bxs() {
        super.bxs();
        this.bgR.unregisterListener(this);
    }

    public final boolean T(JSONObject jSONObject) {
        if (!super.T(jSONObject)) {
            return false;
        }
        try {
            jSONObject.put("swipeCount", this.rqI);
            if (!this.rqJ) {
                String VF = ac.VF(((o) this.rpm).rmC);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("urlMd5", VF);
                jSONObject2.put("needDownload", 1);
                jSONObject.put("imgUrlInfo", jSONObject2);
            }
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", e, "", new Object[0]);
            return false;
        }
    }
}
