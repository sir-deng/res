package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.Point;
import android.graphics.Shader.TileMode;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.a.d;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

public class ExdeviceStepChartView extends View {
    Paint jbA;
    private final int mdA;
    private final int mdB;
    private final int mdC;
    private int mdD;
    private int mdE;
    private int mdF;
    private final float mdG;
    private final float mdH;
    private final int mdI;
    private final float mdJ;
    private final int mdK;
    private final float mdL;
    private final int mdM;
    private final float mdN;
    private final int mdO;
    private final float mdP;
    private final int mdQ;
    private final float mdR;
    private final int mdS;
    private final float mdT;
    private final int mdU;
    private final float mdV;
    private final int mdW;
    private final float mdX;
    private final int mdY;
    private final float mdZ;
    private final int mdr;
    private final int mds;
    private final int mdt;
    private final float mdu;
    private final float mdv;
    private final float mdw;
    private final float mdx;
    private final float mdy;
    private final int mdz;
    private final int meA;
    private final int meB;
    private final int meC;
    private final int meD;
    private final int meE;
    private int meF;
    private final Typeface meG;
    private final Typeface meH;
    private int meI;
    private int meJ;
    private int[] meK;
    private final int meL;
    private float[] meM;
    private float[] meN;
    private boolean[] meO;
    Path meP;
    Path meQ;
    List<String> meR;
    private boolean meS;
    PathEffect meT;
    private int meU;
    private int meV;
    private boolean meW;
    private final int mea;
    private final float meb;
    private final int mec;
    private final float med;
    private final int mee;
    private final float mef;
    private final float meg;
    private final float meh;
    private final float mei;
    private final int mej;
    private final int mek;
    private final int mel;
    private final int mem;
    private final float men;
    private final int meo;
    private final float mep;
    private final int meq;
    private final float mer;
    private final int mes;
    private final float met;
    private final int meu;
    private final float mev;
    private final int mew;
    private final int mex;
    private final int mey;
    private final int mez;
    List<Point> points;

    public ExdeviceStepChartView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mdr = -1;
        this.mds = -1;
        this.mdt = getResources().getColor(R.e.bse);
        this.mdu = 12.0f;
        this.mdv = 28.0f;
        this.mdw = 33.0f;
        this.mdx = 12.0f;
        this.mdy = 12.0f;
        this.mdz = getResources().getColor(R.e.bsf);
        this.mdA = -1;
        this.mdB = getResources().getColor(R.e.bsf);
        this.mdC = -1;
        this.mdD = Integer.MAX_VALUE;
        this.mdE = 0;
        this.mdF = 0;
        this.mdG = 10.0f;
        this.mdH = 2.5f;
        this.mdI = (int) i(1, 2.5f);
        this.mdJ = 4.0f;
        this.mdK = (int) i(1, 4.0f);
        this.mdL = 1.8f;
        this.mdM = (int) i(1, 1.8f);
        this.mdN = 1.0f;
        this.mdO = (int) i(1, 1.0f);
        this.mdP = 8.0f;
        this.mdQ = (int) i(1, 8.0f);
        this.mdR = 22.0f;
        this.mdS = (int) i(1, 22.0f);
        this.mdT = 67.0f;
        this.mdU = (int) i(1, 67.0f);
        this.mdV = 40.0f;
        this.mdW = (int) i(1, 40.0f);
        this.mdX = 22.0f;
        this.mdY = (int) i(1, 22.0f);
        this.mdZ = 55.0f;
        this.mea = (int) i(1, 55.0f);
        this.meb = 35.0f;
        this.mec = (int) i(1, 35.0f);
        this.med = 45.0f;
        this.mee = (int) i(1, 45.0f);
        this.mef = 8.0f;
        this.meg = (float) ((int) i(1, 8.0f));
        this.meh = 8.0f;
        this.mei = (float) ((int) i(1, 8.0f));
        this.mej = 2;
        this.mek = (int) i(1, 2.0f);
        this.mel = 15;
        this.mem = (int) i(1, 15.0f);
        this.men = 33.0f;
        this.meo = (int) i(1, 33.0f);
        this.mep = 8.0f;
        this.meq = (int) i(1, 8.0f);
        this.mer = 35.0f;
        this.mes = (int) i(1, 35.0f);
        this.met = 10.0f;
        this.meu = (int) i(1, 10.0f);
        this.mev = 58.0f;
        this.mew = (int) i(1, 58.0f);
        this.mex = (int) i(1, 1.0f);
        this.mey = 102;
        this.mez = 102;
        this.meA = 153;
        this.meB = 102;
        this.meC = 102;
        this.meD = 102;
        this.meE = d.CTRL_INDEX;
        this.meF = 0;
        this.meG = Typeface.create(Typeface.DEFAULT_BOLD, 0);
        this.meH = Typeface.create(Typeface.DEFAULT_BOLD, 1);
        this.meI = 0;
        this.meJ = 0;
        this.meK = new int[]{0, 0, 0, 0, 0, 0, 0};
        this.meL = 7;
        this.meM = new float[7];
        this.meN = new float[7];
        this.meO = new boolean[7];
        this.meS = false;
        this.meT = new DashPathEffect(new float[]{5.0f, 5.0f}, 0.0f);
        aGa();
    }

    public ExdeviceStepChartView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mdr = -1;
        this.mds = -1;
        this.mdt = getResources().getColor(R.e.bse);
        this.mdu = 12.0f;
        this.mdv = 28.0f;
        this.mdw = 33.0f;
        this.mdx = 12.0f;
        this.mdy = 12.0f;
        this.mdz = getResources().getColor(R.e.bsf);
        this.mdA = -1;
        this.mdB = getResources().getColor(R.e.bsf);
        this.mdC = -1;
        this.mdD = Integer.MAX_VALUE;
        this.mdE = 0;
        this.mdF = 0;
        this.mdG = 10.0f;
        this.mdH = 2.5f;
        this.mdI = (int) i(1, 2.5f);
        this.mdJ = 4.0f;
        this.mdK = (int) i(1, 4.0f);
        this.mdL = 1.8f;
        this.mdM = (int) i(1, 1.8f);
        this.mdN = 1.0f;
        this.mdO = (int) i(1, 1.0f);
        this.mdP = 8.0f;
        this.mdQ = (int) i(1, 8.0f);
        this.mdR = 22.0f;
        this.mdS = (int) i(1, 22.0f);
        this.mdT = 67.0f;
        this.mdU = (int) i(1, 67.0f);
        this.mdV = 40.0f;
        this.mdW = (int) i(1, 40.0f);
        this.mdX = 22.0f;
        this.mdY = (int) i(1, 22.0f);
        this.mdZ = 55.0f;
        this.mea = (int) i(1, 55.0f);
        this.meb = 35.0f;
        this.mec = (int) i(1, 35.0f);
        this.med = 45.0f;
        this.mee = (int) i(1, 45.0f);
        this.mef = 8.0f;
        this.meg = (float) ((int) i(1, 8.0f));
        this.meh = 8.0f;
        this.mei = (float) ((int) i(1, 8.0f));
        this.mej = 2;
        this.mek = (int) i(1, 2.0f);
        this.mel = 15;
        this.mem = (int) i(1, 15.0f);
        this.men = 33.0f;
        this.meo = (int) i(1, 33.0f);
        this.mep = 8.0f;
        this.meq = (int) i(1, 8.0f);
        this.mer = 35.0f;
        this.mes = (int) i(1, 35.0f);
        this.met = 10.0f;
        this.meu = (int) i(1, 10.0f);
        this.mev = 58.0f;
        this.mew = (int) i(1, 58.0f);
        this.mex = (int) i(1, 1.0f);
        this.mey = 102;
        this.mez = 102;
        this.meA = 153;
        this.meB = 102;
        this.meC = 102;
        this.meD = 102;
        this.meE = d.CTRL_INDEX;
        this.meF = 0;
        this.meG = Typeface.create(Typeface.DEFAULT_BOLD, 0);
        this.meH = Typeface.create(Typeface.DEFAULT_BOLD, 1);
        this.meI = 0;
        this.meJ = 0;
        this.meK = new int[]{0, 0, 0, 0, 0, 0, 0};
        this.meL = 7;
        this.meM = new float[7];
        this.meN = new float[7];
        this.meO = new boolean[7];
        this.meS = false;
        this.meT = new DashPathEffect(new float[]{5.0f, 5.0f}, 0.0f);
        aGa();
    }

    private void c(Canvas canvas, boolean z) {
        int i = 0;
        if (z) {
            this.meQ.reset();
            this.meQ.moveTo((float) ((Point) this.points.get(0)).x, (float) ((Point) this.points.get(0)).y);
            for (int i2 = 0; i2 < this.points.size(); i2++) {
                this.meQ.lineTo((float) ((Point) this.points.get(i2)).x, (float) ((Point) this.points.get(i2)).y);
            }
            this.meQ.lineTo(this.meM[this.meM.length - 1], (float) ((this.mdF - this.mec) - 1));
            this.meQ.lineTo((float) this.mdQ, (float) ((this.mdF - this.mec) - 1));
            this.meQ.lineTo((float) this.mdQ, this.meN[0]);
            canvas.drawPath(this.meQ, this.jbA);
            return;
        }
        this.meQ.reset();
        this.meQ.moveTo((float) ((Point) this.points.get(0)).x, (float) ((Point) this.points.get(0)).y);
        while (i < this.points.size()) {
            if (i <= 0) {
                aGc();
            } else if (((Point) this.points.get(i - 1)).y == this.mdF - this.mdW) {
                this.jbA.reset();
                this.jbA.setPathEffect(new DashPathEffect(new float[]{5.0f, 5.0f}, 0.0f));
                this.jbA.setAntiAlias(true);
                this.jbA.setStrokeWidth((float) this.mdM);
                this.jbA.setStyle(Style.STROKE);
                this.jbA.setColor(-1);
            } else {
                aGc();
            }
            this.meQ.lineTo((float) ((Point) this.points.get(i)).x, (float) ((Point) this.points.get(i)).y);
            canvas.drawPath(this.meQ, this.jbA);
            this.meQ.reset();
            this.meQ.moveTo((float) ((Point) this.points.get(i)).x, (float) ((Point) this.points.get(i)).y);
            i++;
        }
    }

    private void g(Canvas canvas) {
        this.jbA.reset();
        this.jbA.setAntiAlias(true);
        this.jbA.setColor(-1);
        this.jbA.setStrokeWidth(0.0f);
        this.jbA.setStyle(Style.FILL);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.points.size()) {
                Point point = (Point) this.points.get(i2);
                if (i2 == this.points.size() - 1) {
                    canvas.drawCircle((float) point.x, (float) point.y, (float) this.mdK, this.jbA);
                } else {
                    canvas.drawCircle((float) point.x, (float) point.y, (float) this.mdI, this.jbA);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private float i(int i, float f) {
        Resources system;
        Context context = getContext();
        if (context == null) {
            system = Resources.getSystem();
        } else {
            system = context.getResources();
        }
        return TypedValue.applyDimension(i, f, system.getDisplayMetrics());
    }

    private void b(Canvas canvas, List<String> list) {
        if (list != null && list.size() == 7) {
            this.jbA.reset();
            this.jbA.setAntiAlias(true);
            this.jbA.setStrokeWidth(0.0f);
            this.jbA.setTextSize(i(2, 12.0f));
            this.jbA.setAlpha(153);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    if (i2 == 0) {
                        this.jbA.setTextAlign(Align.LEFT);
                    } else {
                        this.jbA.setTextAlign(Align.CENTER);
                    }
                    if (this.meO[i2]) {
                        this.jbA.setColor(-1);
                    } else {
                        this.jbA.setColor(this.mdz);
                    }
                    canvas.drawText((String) list.get(i2), (float) ((Point) this.points.get(i2)).x, (float) (this.mdF - this.mem), this.jbA);
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private void aGa() {
        this.jbA = new Paint();
        this.meP = new Path();
        this.meQ = new Path();
        this.points = new LinkedList();
        this.meR = new LinkedList();
        aGb();
    }

    private void aGb() {
        for (int i = 0; i < 7; i++) {
            if (i == 6) {
                this.meO[i] = true;
            } else {
                this.meO[i] = false;
            }
        }
    }

    private void aGc() {
        this.jbA.reset();
        this.jbA.setAntiAlias(true);
        this.jbA.setStrokeWidth((float) this.mdM);
        this.jbA.setStyle(Style.STROKE);
        this.jbA.setColor(-1);
    }

    protected void onDraw(Canvas canvas) {
        int i;
        this.points.clear();
        View findViewById = findViewById(R.h.cfx);
        this.mdE = findViewById.getWidth();
        this.mdF = findViewById.getHeight();
        this.meI = ((this.mdE - this.mdQ) - this.mdS) / 6;
        this.meJ = ((this.mdF - this.mdU) - this.mdW) / 2;
        for (i = 0; i < this.meM.length; i++) {
            this.meM[i] = (float) (this.mdQ + (this.meI * i));
        }
        i = this.meK.length;
        if (i > 7) {
            i = 7;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            if (this.meK[i3] > 100000) {
                this.meK[i3] = 100000;
            }
            if (this.meK[i3] < 0) {
                this.meK[i3] = 0;
            }
            if (this.meK[i3] > i2) {
                i2 = this.meK[i3];
            }
        }
        if (i2 <= 15000 && i2 >= 0) {
            i2 = 15000;
        } else if (i2 <= 15000 || i2 > 100000) {
            i2 = 0;
        } else if (((double) i2) / 5000.0d > ((double) (((float) i2) / 5000.0f))) {
            i2 = ((i2 / 5000) + 1) * 5000;
        }
        this.meF = (((this.mdF - this.mdU) - this.mdW) * 10000) / i2;
        this.meF = (this.mdF - this.mdW) - this.meF;
        for (int i4 = 0; i4 < i; i4++) {
            this.meN[i4] = ((float) (this.mdF - this.mdW)) - ((((float) this.meK[i4]) / ((float) i2)) * ((float) ((this.mdF - this.mdU) - this.mdW)));
            this.points.add(new Point((int) this.meM[i4], (int) this.meN[i4]));
        }
        super.onDraw(canvas);
        if (!this.meS) {
            g(canvas);
            if (this.mdD != Integer.MAX_VALUE) {
                i2 = this.mdD;
                this.jbA.reset();
                this.jbA.setColor(this.mdz);
                this.jbA.setAntiAlias(true);
                this.jbA.setStrokeWidth(0.0f);
                this.jbA.setTextSize(i(2, 12.0f));
                this.jbA.setTextAlign(Align.CENTER);
                if (i2 >= 0 && i2 <= 6) {
                    if (i2 == 0) {
                        this.jbA.setTextAlign(Align.LEFT);
                    }
                    if (i2 == 6) {
                        this.jbA.setTextAlign(Align.RIGHT);
                    }
                    if (!this.meW) {
                        this.meU = ((Point) this.points.get(i2)).y - this.mew;
                        this.meV = this.meU;
                        this.meW = true;
                    }
                    if (this.meW) {
                        float f = (float) (((double) this.meV) / 8.0d);
                        if (this.meU > 0) {
                            this.jbA.setAlpha(((this.meV - this.meU) * 255) / this.meV);
                        }
                        canvas.drawText(this.meK[i2], (float) ((Point) this.points.get(i2)).x, (float) (this.meU + this.mew), this.jbA);
                        if (this.meU > 0) {
                            if (((float) this.meU) / ((float) this.meV) <= 1.0f / f) {
                                this.meU--;
                            } else {
                                this.meU = (int) (((float) this.meU) - ((((float) this.meU) / ((float) this.meV)) * f));
                            }
                            invalidate();
                        } else {
                            this.meW = false;
                        }
                    }
                }
                i = this.mdD;
                if (i >= 0 && i <= 6) {
                    this.meO[i] = true;
                }
            }
        }
        this.jbA.reset();
        this.meP.reset();
        this.jbA.setPathEffect(new DashPathEffect(new float[]{5.0f, 5.0f}, 0.0f));
        this.jbA.setColor(this.mdt);
        this.jbA.setStrokeWidth((float) this.mdO);
        this.jbA.setAlpha(102);
        this.jbA.setStyle(Style.STROKE);
        if (!(this.meF == 0 || this.meS)) {
            this.meP.moveTo((float) this.mdQ, (float) this.meF);
            this.meP.lineTo((float) (this.mdE - this.mdY), (float) this.meF);
            canvas.drawPath(this.meP, this.jbA);
        }
        this.jbA.reset();
        this.meP.reset();
        this.jbA.setColor(this.mdt);
        this.jbA.setStrokeWidth((float) this.mdO);
        this.jbA.setStyle(Style.STROKE);
        this.jbA.setAlpha(102);
        this.meP.reset();
        this.meP.moveTo(this.meg, (float) (this.mdF - this.mec));
        this.meP.lineTo(((float) this.mdE) - this.mei, (float) (this.mdF - this.mec));
        this.meP.moveTo(this.meg, (float) this.mee);
        this.meP.lineTo(((float) this.mdE) - this.mei, (float) this.mee);
        canvas.drawPath(this.meP, this.jbA);
        if (!this.meS) {
            this.jbA.reset();
            this.jbA.setColor(this.mdB);
            this.jbA.setAntiAlias(true);
            this.jbA.setAlpha(102);
            this.jbA.setStrokeWidth(0.0f);
            this.jbA.setTextSize(i(2, 12.0f));
            this.jbA.setTextAlign(Align.RIGHT);
            canvas.drawText(getResources().getString(R.l.edP), (float) (this.mdE - this.mek), (float) (((double) this.meF) + (((double) this.jbA.getTextSize()) * 0.34d)), this.jbA);
        }
        this.jbA.reset();
        this.jbA.setColor(-1);
        this.jbA.setAntiAlias(true);
        this.jbA.setStrokeWidth(0.0f);
        this.jbA.setTypeface(this.meG);
        this.jbA.setTextSize(i(2, 28.0f));
        canvas.drawText(getResources().getString(R.l.edQ), (float) this.meq, (float) this.meo, this.jbA);
        this.jbA.setTextAlign(Align.RIGHT);
        this.jbA.setTextSize(i(2, 33.0f));
        canvas.drawText(this.meK[this.meK.length - 1], (float) (this.mdE - this.meu), (float) this.mes, this.jbA);
        if (this.points.size() > 2) {
            this.jbA.reset();
            this.jbA.setAntiAlias(true);
            this.jbA.setStrokeWidth(0.0f);
            this.jbA.setAlpha(102);
            this.jbA.setStyle(Style.FILL_AND_STROKE);
            this.jbA.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, (float) (this.mdF - this.mec), -1, 16777215, TileMode.REPEAT));
            this.jbA.setColor(-1);
            c(canvas, true);
            aGc();
            if (!this.meS) {
                c(canvas, false);
            }
        }
        b(canvas, this.meR);
    }

    private int ag(float f) {
        this.mdD = Integer.MAX_VALUE;
        if (this.points.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.points.size()) {
                    break;
                }
                if (i2 != 0) {
                    if (i2 > 0 && i2 < this.points.size() - 1) {
                        if (f < ((float) (((Point) this.points.get(i2)).x + (this.meI / 2))) && f > ((float) (((Point) this.points.get(i2)).x - (this.meI / 2)))) {
                            this.mdD = i2;
                            invalidate();
                            break;
                        }
                    } else if (i2 == this.points.size() - 1) {
                        if (f < ((float) this.mdE) && f > ((float) (((Point) this.points.get(i2)).x - (this.meI / 2)))) {
                            this.mdD = i2;
                            invalidate();
                            break;
                        }
                    } else {
                        this.mdD = Integer.MAX_VALUE;
                        break;
                    }
                } else if (f < ((float) (((Point) this.points.get(i2)).x + (this.meI / 2))) && f > 0.0f) {
                    this.mdD = i2;
                    invalidate();
                    break;
                }
                i = i2 + 1;
            }
        }
        return this.mdD;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        motionEvent.getY();
        x.i("MicroMsg.exdevice.ExdeviceStepChartView", "mOnTouchLinePsition:" + this.mdD);
        switch (motionEvent.getAction()) {
            case 0:
                x.d("MicroMsg.exdevice.ExdeviceStepChartView", "ACTION_DOWN");
                return true;
            case 1:
                x.d("MicroMsg.exdevice.ExdeviceStepChartView", "ACTION_UP");
                this.mdD = ag(x);
                aGb();
                this.meW = false;
                invalidate();
                return false;
            default:
                x.d("MicroMsg.exdevice.ExdeviceStepChartView", "default");
                return false;
        }
    }
}
