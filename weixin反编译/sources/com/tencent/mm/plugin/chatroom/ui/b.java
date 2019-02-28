package com.tencent.mm.plugin.chatroom.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.format.DateUtils;
import android.text.format.Time;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.mm.R;
import java.security.InvalidParameterException;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;

public final class b extends View {
    protected static int ljH = 32;
    protected static int ljI;
    protected static int ljJ = 1;
    protected static int ljK;
    protected static int ljL = 10;
    protected static int ljM;
    protected static int ljN;
    protected static int ljO;
    protected int kEA;
    protected int kEz;
    public Collection<com.tencent.mm.plugin.chatroom.d.a> lgv = new ArrayList();
    protected int ljP = 80;
    protected Paint ljQ;
    protected Paint ljR;
    protected Paint ljS;
    protected Paint ljT;
    protected Paint ljU;
    protected int ljV;
    protected int ljW;
    protected int ljX;
    protected int ljY;
    protected int ljZ;
    private DateFormatSymbols lkA = new DateFormatSymbols();
    public a lkB;
    protected int lka;
    protected int lkb;
    protected int lkc;
    protected int lkd;
    private final StringBuilder lke;
    protected boolean lkf = false;
    protected boolean lkg = false;
    protected int lkh = -1;
    protected int lki = -1;
    protected int lkj = -1;
    protected int lkk = -1;
    protected int lkl = -1;
    protected int lkm = -1;
    protected int lkn = -1;
    protected int lko = 1;
    protected int lkp = 7;
    protected int lkq = this.lkp;
    private int lkr = 0;
    protected Boolean lks;
    protected int lkt = ljH;
    protected int lku = 0;
    final Time lkv;
    private final Calendar lkw;
    private final Calendar lkx;
    private final Boolean lky;
    public int lkz = 6;
    private Context mContext;
    protected int mWidth;

    public interface a {
        void b(com.tencent.mm.plugin.chatroom.d.a aVar);
    }

    public b(Context context, TypedArray typedArray) {
        super(context);
        this.mContext = context;
        Resources resources = context.getResources();
        this.lkx = Calendar.getInstance();
        this.lkw = Calendar.getInstance();
        this.lkv = new Time(Time.getCurrentTimezone());
        this.lkv.setToNow();
        this.ljV = typedArray.getColor(R.n.eZW, resources.getColor(R.e.btt));
        this.ljW = typedArray.getColor(R.n.fac, resources.getColor(R.e.btt));
        this.ljX = typedArray.getColor(R.n.fad, resources.getColor(R.e.btt));
        this.ljY = typedArray.getColor(R.n.fad, resources.getColor(R.e.btu));
        this.ljZ = typedArray.getColor(R.n.fab, resources.getColor(R.e.btt));
        this.lkb = typedArray.getColor(R.n.eZZ, resources.getColor(R.e.btt));
        this.lkc = typedArray.getColor(R.n.faa, resources.getColor(R.e.btf));
        this.lkd = typedArray.getColor(R.n.eZX, resources.getColor(R.e.btJ));
        this.lka = typedArray.getColor(R.n.eZY, resources.getColor(R.e.btK));
        this.lks = Boolean.valueOf(typedArray.getBoolean(R.n.fan, false));
        this.lke = new StringBuilder(50);
        ljK = typedArray.getDimensionPixelSize(R.n.fae, resources.getDimensionPixelSize(R.f.bye));
        ljO = typedArray.getDimensionPixelSize(R.n.faf, resources.getDimensionPixelSize(R.f.byg));
        ljM = typedArray.getDimensionPixelSize(R.n.fag, resources.getDimensionPixelSize(R.f.byf));
        ljN = typedArray.getDimensionPixelOffset(R.n.fah, resources.getDimensionPixelOffset(R.f.bxD));
        ljI = typedArray.getDimensionPixelSize(R.n.fai, resources.getDimensionPixelOffset(R.f.bxT));
        this.lkt = (typedArray.getDimensionPixelSize(R.n.faj, resources.getDimensionPixelOffset(R.f.bwe)) - ljN) / 6;
        this.lku = typedArray.getDimensionPixelSize(R.n.fak, resources.getDimensionPixelOffset(R.f.bwI));
        this.lky = Boolean.valueOf(typedArray.getBoolean(R.n.fal, true));
        this.ljT = new Paint();
        this.ljT.setAntiAlias(true);
        this.ljT.setTextSize((float) ljO);
        this.ljT.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
        this.ljT.setColor(this.ljY);
        this.ljT.setTextAlign(Align.LEFT);
        this.ljT.setStyle(Style.FILL);
        this.ljS = new Paint();
        this.ljS.setFakeBoldText(true);
        this.ljS.setAntiAlias(true);
        this.ljS.setColor(this.lka);
        this.ljS.setTextAlign(Align.CENTER);
        this.ljS.setStyle(Style.FILL);
        this.ljU = new Paint();
        this.ljU.setFakeBoldText(true);
        this.ljU.setAntiAlias(true);
        this.ljU.setColor(this.lkd);
        this.ljU.setTextAlign(Align.CENTER);
        this.ljU.setStyle(Style.FILL);
        this.ljQ = new Paint();
        this.ljQ.setAntiAlias(true);
        this.ljQ.setTextSize((float) ljM);
        this.ljQ.setColor(this.ljY);
        this.ljQ.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
        this.ljQ.setStyle(Style.FILL);
        this.ljQ.setTextAlign(Align.CENTER);
        this.ljQ.setFakeBoldText(true);
        this.ljR = new Paint();
        this.ljR.setAntiAlias(true);
        this.ljR.setTextSize((float) ljK);
        this.ljR.setStyle(Style.FILL);
        this.ljR.setTextAlign(Align.CENTER);
        this.ljR.setFakeBoldText(false);
    }

    private void e(Canvas canvas) {
        int i = ljN - (ljM / 2);
        int i2 = (this.mWidth - (this.ljP * 2)) / (this.lkp * 2);
        for (int i3 = 0; i3 < this.lkp; i3++) {
            int i4 = (((i3 * 2) + 1) * i2) + this.ljP;
            this.lkx.set(7, (this.lko + i3) % this.lkp);
            canvas.drawText(this.lkA.getShortWeekdays()[this.lkx.get(7)].toUpperCase(Locale.getDefault()), (float) i4, (float) i, this.ljQ);
        }
    }

    private int ayF() {
        return (this.lkr < this.lko ? this.lkr + this.lkp : this.lkr) - this.lko;
    }

    private boolean a(int i, Time time) {
        return this.kEz < time.year || ((this.kEz == time.year && this.kEA < time.month) || (this.kEA == time.month && i < time.monthDay));
    }

    private void f(Canvas canvas) {
        int i = (this.mWidth - (this.ljP * 2)) / (this.lkp * 2);
        int i2 = 1;
        int i3 = (((this.lkt + ljK) / 2) - ljJ) + ljN;
        int ayF = ayF();
        while (true) {
            int i4 = i2;
            if (i4 > this.lkq) {
                return;
            }
            if (i4 <= this.lkn || -1 == this.lkn) {
                int i5 = this.ljP + (((ayF * 2) + 1) * i);
                if ((this.kEA == this.lkj && this.lkh == i4 && this.lkl == this.kEz) || ((this.kEA == this.lkk && this.lki == i4 && this.lkm == this.kEz) || (this.lkf && this.lkn == i4 && this.lkh == -1))) {
                    if (this.lks.booleanValue()) {
                        canvas.drawRoundRect(new RectF((float) (i5 - ljI), (float) ((i3 - (ljK / 3)) - ljI), (float) (ljI + i5), (float) ((i3 - (ljK / 3)) + ljI)), 10.0f, 10.0f, this.ljU);
                    } else {
                        canvas.drawCircle((float) i5, (float) (i3 - (ljK / 3)), (float) ljI, this.ljU);
                    }
                    if (this.lkf && this.lkn == i4 && this.lkh == -1) {
                        this.ljR.setColor(this.lkd);
                        this.ljR.setTypeface(Typeface.defaultFromStyle(0));
                        this.ljR.setTextSize(30.0f);
                        canvas.drawText(this.mContext.getResources().getString(R.l.eRx), (float) i5, (float) ((i3 + 12) + ljI), this.ljR);
                    }
                }
                this.ljR.setTextSize((float) ljK);
                if (!(this.lkf && this.lkn == i4)) {
                    this.ljR.setColor(this.ljZ);
                    this.ljR.setTypeface(Typeface.defaultFromStyle(0));
                }
                if (this.lkh != -1 && this.lki != -1 && this.lkl == this.lkm && this.lkj == this.lkk && this.lkh == this.lki && i4 == this.lkh && this.kEA == this.lkj && this.kEz == this.lkl) {
                    this.ljR.setColor(this.lkd);
                }
                if (this.lkh != -1 && this.lki != -1 && this.lkl == this.lkm && this.lkl == this.kEz && ((this.kEA == this.lkj && this.lkk == this.lkj && ((this.lkh < this.lki && i4 > this.lkh && i4 < this.lki) || (this.lkh > this.lki && i4 < this.lkh && i4 > this.lki))) || ((this.lkj < this.lkk && this.kEA == this.lkj && i4 > this.lkh) || ((this.lkj < this.lkk && this.kEA == this.lkk && i4 < this.lki) || ((this.lkj > this.lkk && this.kEA == this.lkj && i4 < this.lkh) || (this.lkj > this.lkk && this.kEA == this.lkk && i4 > this.lki)))))) {
                    this.ljR.setColor(this.lkd);
                }
                if (!(this.lkh == -1 || this.lki == -1 || this.lkl == this.lkm || (((this.lkl != this.kEz || this.kEA != this.lkj) && (this.lkm != this.kEz || this.kEA != this.lkk)) || ((this.lkj >= this.lkk || this.kEA != this.lkj || i4 >= this.lkh) && ((this.lkj >= this.lkk || this.kEA != this.lkk || i4 <= this.lki) && ((this.lkj <= this.lkk || this.kEA != this.lkj || i4 <= this.lkh) && (this.lkj <= this.lkk || this.kEA != this.lkk || i4 >= this.lki))))))) {
                    this.ljR.setColor(this.lkd);
                }
                if (this.lkh != -1 && this.lki != -1 && this.lkl == this.lkm && this.kEz == this.lkl && ((this.kEA > this.lkj && this.kEA < this.lkk && this.lkj < this.lkk) || (this.kEA < this.lkj && this.kEA > this.lkk && this.lkj > this.lkk))) {
                    this.ljR.setColor(this.lkd);
                }
                if (!(this.lkh == -1 || this.lki == -1 || this.lkl == this.lkm || ((this.lkl >= this.lkm || ((this.kEA <= this.lkj || this.kEz != this.lkl) && (this.kEA >= this.lkk || this.kEz != this.lkm))) && (this.lkl <= this.lkm || ((this.kEA >= this.lkj || this.kEz != this.lkl) && (this.kEA <= this.lkk || this.kEz != this.lkm)))))) {
                    this.ljR.setColor(this.lkd);
                }
                if (!this.lky.booleanValue() && a(i4, this.lkv) && this.lkv.month == this.kEA && this.lkv.year == this.kEz) {
                    this.ljR.setColor(this.lkb);
                    this.ljR.setTypeface(Typeface.defaultFromStyle(2));
                }
                for (com.tencent.mm.plugin.chatroom.d.a aVar : this.lgv) {
                    if (aVar.kIo == i4 && aVar.month == this.kEA && aVar.year == this.kEz) {
                        this.ljR.setColor(this.lkc);
                        this.ljR.setTypeface(Typeface.defaultFromStyle(0));
                    }
                }
                if ((this.kEA == this.lkj && this.lkh == i4 && this.lkl == this.kEz) || ((this.kEA == this.lkk && this.lki == i4 && this.lkm == this.kEz) || (this.lkf && this.lkn == i4 && this.lkh == -1))) {
                    this.ljR.setTypeface(Typeface.defaultFromStyle(0));
                    this.ljR.setColor(-1);
                }
                canvas.drawText(String.format("%d", new Object[]{Integer.valueOf(i4)}), (float) i5, (float) i3, this.ljR);
                ayF++;
                if (ayF == this.lkp) {
                    ayF = 0;
                    i3 += this.lkt;
                }
                i2 = i4 + 1;
            } else {
                return;
            }
        }
    }

    protected final void onDraw(Canvas canvas) {
        int i = (((this.mWidth - (this.ljP * 2)) / (this.lkp * 2)) + this.ljP) - (ljO / 2);
        int i2 = ((ljN - ljO) / 2) + ljO;
        this.lke.setLength(0);
        long timeInMillis = this.lkw.getTimeInMillis();
        StringBuilder stringBuilder = new StringBuilder(DateUtils.formatDateRange(getContext(), timeInMillis, timeInMillis, 52).toLowerCase());
        stringBuilder.setCharAt(0, Character.toUpperCase(stringBuilder.charAt(0)));
        canvas.drawText(stringBuilder.toString(), (float) i, (float) i2, this.ljT);
        canvas.drawLine(0.0f, (float) ljN, (float) this.mWidth, (float) (ljN + 1), this.ljT);
        e(canvas);
        f(canvas);
    }

    protected final void onMeasure(int i, int i2) {
        setMeasuredDimension(MeasureSpec.getSize(i), ((this.lkt * this.lkz) + ljN) + this.lku);
    }

    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        this.mWidth = i;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            com.tencent.mm.plugin.chatroom.d.a aVar;
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int i = this.ljP;
            if (x < ((float) i) || x > ((float) (this.mWidth - this.ljP))) {
                aVar = null;
            } else {
                int ayF = ((((int) (((x - ((float) i)) * ((float) this.lkp)) / ((float) ((this.mWidth - i) - this.ljP)))) - ayF()) + 1) + ((((int) (y - ((float) ljN))) / this.lkt) * this.lkp);
                if (this.kEA > 11 || this.kEA < 0 || com.tencent.mm.plugin.chatroom.f.a.cn(this.kEA, this.kEz) < ayF || ayF <= 0) {
                    aVar = null;
                } else {
                    com.tencent.mm.plugin.chatroom.d.a aVar2 = new com.tencent.mm.plugin.chatroom.d.a(this.kEz, this.kEA, ayF);
                    for (com.tencent.mm.plugin.chatroom.d.a aVar3 : this.lgv) {
                        if (aVar3.equals(aVar2)) {
                            break;
                        }
                    }
                    aVar3 = null;
                }
            }
            if (!(aVar3 == null || this.lkB == null || (!this.lky.booleanValue() && aVar3.month == this.lkv.month && aVar3.year == this.lkv.year && aVar3.kIo < this.lkv.monthDay))) {
                this.lkB.b(aVar3);
            }
        }
        return true;
    }

    public final void l(HashMap<String, Integer> hashMap) {
        int i = 0;
        if (hashMap.containsKey("month") || hashMap.containsKey("year")) {
            int i2;
            setTag(hashMap);
            if (hashMap.containsKey("height")) {
                this.lkt = ((Integer) hashMap.get("height")).intValue();
                if (this.lkt < ljL) {
                    this.lkt = ljL;
                }
            }
            if (hashMap.containsKey("selected_begin_day")) {
                this.lkh = ((Integer) hashMap.get("selected_begin_day")).intValue();
            }
            if (hashMap.containsKey("selected_last_day")) {
                this.lki = ((Integer) hashMap.get("selected_last_day")).intValue();
            }
            if (hashMap.containsKey("selected_begin_month")) {
                this.lkj = ((Integer) hashMap.get("selected_begin_month")).intValue();
            }
            if (hashMap.containsKey("selected_last_month")) {
                this.lkk = ((Integer) hashMap.get("selected_last_month")).intValue();
            }
            if (hashMap.containsKey("selected_begin_year")) {
                this.lkl = ((Integer) hashMap.get("selected_begin_year")).intValue();
            }
            if (hashMap.containsKey("selected_last_year")) {
                this.lkm = ((Integer) hashMap.get("selected_last_year")).intValue();
            }
            this.kEA = ((Integer) hashMap.get("month")).intValue();
            this.kEz = ((Integer) hashMap.get("year")).intValue();
            this.lkf = false;
            this.lkn = -1;
            this.lkw.set(2, this.kEA);
            this.lkw.set(1, this.kEz);
            this.lkw.set(5, 1);
            this.lkr = this.lkw.get(7);
            if (hashMap.containsKey("week_start")) {
                this.lko = ((Integer) hashMap.get("week_start")).intValue();
            } else {
                this.lko = this.lkw.getFirstDayOfWeek();
            }
            this.lkq = com.tencent.mm.plugin.chatroom.f.a.cn(this.kEA, this.kEz);
            for (i2 = 0; i2 < this.lkq; i2++) {
                boolean z;
                int i3 = i2 + 1;
                Time time = this.lkv;
                if (this.kEz == time.year && this.kEA == time.month && i3 == time.monthDay) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    this.lkf = true;
                    this.lkn = i3;
                }
                this.lkg = a(i3, this.lkv);
            }
            i2 = ayF();
            int i4 = (this.lkq + i2) / this.lkp;
            if ((i2 + this.lkq) % this.lkp > 0) {
                i = 1;
            }
            this.lkz = i4 + i;
            return;
        }
        throw new InvalidParameterException("You must specify month and year for this view");
    }
}
