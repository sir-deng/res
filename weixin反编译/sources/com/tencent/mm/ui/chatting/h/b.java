package com.tencent.mm.ui.chatting.h;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.c;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import com.tencent.mm.R;
import com.tencent.mm.ca.a.e;
import com.tencent.mm.pluginsdk.h.n;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.picker.OptionPicker;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public final class b {
    private Button kxK;
    private Button kxL;
    private View lHV;
    Context mContext;
    OptionPicker yQR;
    OptionPicker yQS;
    public c yQT;
    private int yQU;
    private BottomSheetBehavior yQV;
    public a yQW;
    ArrayList<Long> yQX = new ArrayList(42);

    public interface a {
        void fY(long j);

        void onCancel();
    }

    public b(Context context) {
        this.mContext = context;
        this.lHV = View.inflate(this.mContext, R.i.dqU, null);
        this.yQT = new c(this.mContext);
        this.yQT.setContentView(this.lHV);
        this.yQT.setOnDismissListener(new OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                b.this.yQT = null;
            }
        });
        this.yQR = (OptionPicker) this.lHV.findViewById(R.h.cBU);
        this.yQS = (OptionPicker) this.lHV.findViewById(R.h.cBV);
        this.yQR.setValue(0);
        this.yQR.KD = com.tencent.mm.bu.a.fromDPToPix(this.mContext, 60);
        this.yQS.KD = com.tencent.mm.bu.a.fromDPToPix(this.mContext, 60);
        this.yQR.j(cwk());
        this.yQS.j(GC(0));
        this.yQR.setOnValueChangedListener(new OnValueChangeListener() {
            public final void onValueChange(NumberPicker numberPicker, int i, int i2) {
                x.d("MicroMsg.MMRemindDatePicker", "[onValueChange] oldVal:%s newVal:%s", Integer.valueOf(i), Integer.valueOf(i2));
                b.this.yQS.j(b.this.GC(i2));
                int i3 = Calendar.getInstance().get(11);
                if (i2 == 0) {
                    b.this.yQS.setValue(0);
                } else {
                    b.this.yQS.setValue(i3);
                }
            }
        });
        LayoutParams layoutParams = (LayoutParams) this.lHV.getLayoutParams();
        layoutParams.height = com.tencent.mm.bu.a.fromDPToPix(this.mContext, 288);
        this.lHV.setLayoutParams(layoutParams);
        this.yQU = com.tencent.mm.bu.a.fromDPToPix(this.mContext, 350);
        this.yQV = BottomSheetBehavior.i((View) this.lHV.getParent());
        if (this.yQV != null) {
            this.yQV.q(this.yQU);
            this.yQV.fj = false;
        }
        this.kxK = (Button) this.lHV.findViewById(e.cBI);
        this.kxK.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (b.this.yQW != null) {
                    a aVar = b.this.yQW;
                    b bVar = b.this;
                    long currentTimeMillis = System.currentTimeMillis();
                    int value = bVar.yQR.getValue();
                    int value2 = bVar.yQS.getValue();
                    currentTimeMillis = value == 0 ? com.tencent.mm.sdk.a.b.cfx() ? currentTimeMillis + 360000 : currentTimeMillis + (((long) (value2 + 1)) * 3600000) : ((Long) bVar.yQX.get(value)).longValue() + (((long) (value2 + 1)) * 3600000);
                    String ak = n.ak(bVar.mContext.getString(R.l.eiY) + "HH:mm", currentTimeMillis / 1000);
                    x.i("MicroMsg.MMRemindDatePicker", "[getTimestamp] date:%s", ak);
                    aVar.fY(currentTimeMillis);
                }
            }
        });
        this.kxL = (Button) this.lHV.findViewById(e.bPp);
        this.kxL.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (b.this.yQW != null) {
                    b.this.yQW.onCancel();
                }
            }
        });
    }

    public final void hide() {
        if (this.yQT != null) {
            this.yQT.dismiss();
        }
    }

    final String[] GC(int i) {
        int i2;
        int i3 = 1;
        Object arrayList = new ArrayList();
        if (com.tencent.mm.sdk.a.b.cfx()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        switch (i - i2) {
            case -1:
                arrayList.add("after 6 min");
                break;
            case 0:
                int i4 = Calendar.getInstance().get(11);
                for (i2 = 1; i2 <= 24 - i4; i2++) {
                    arrayList.add(this.mContext.getResources().getString(R.l.dDH, new Object[]{Integer.valueOf(i2)}));
                }
                break;
            default:
                while (true) {
                    i2 = i3;
                    if (i2 > 24) {
                        break;
                    }
                    arrayList.add((i2 < 10 ? "0" + i2 : Integer.valueOf(i2)) + ":00");
                    i3 = i2 + 1;
                }
        }
        return bi.cB(arrayList);
    }

    private String[] cwk() {
        int i = 0;
        this.yQX.clear();
        List arrayList = new ArrayList();
        Calendar instance = Calendar.getInstance();
        int i2 = 0;
        while (i2 < instance.getActualMaximum(5)) {
            if (com.tencent.mm.sdk.a.b.cfx() && i2 == 0) {
                arrayList.add("test");
                this.yQX.add(Long.valueOf(instance.getTimeInMillis()));
            }
            if (i2 == 0) {
                instance.setTimeInMillis(System.currentTimeMillis() + (86400000 * ((long) i2)));
                this.yQX.add(Long.valueOf(instance.getTimeInMillis()));
            } else {
                instance.setTimeInMillis(System.currentTimeMillis() + (86400000 * ((long) i2)));
                instance.set(11, 0);
                instance.set(12, 0);
                instance.set(13, 0);
                instance.set(14, 0);
                this.yQX.add(Long.valueOf(instance.getTimeInMillis()));
            }
            String ak = n.ak(this.mContext.getString(R.l.eiJ), instance.getTimeInMillis() / 1000);
            if (i2 == 0) {
                arrayList.add(this.mContext.getResources().getString(R.l.ejg));
            } else if (i2 == 1) {
                arrayList.add(ak + " " + this.mContext.getResources().getString(R.l.ejh));
            } else if (i2 == 2) {
                arrayList.add(ak + " " + this.mContext.getResources().getString(R.l.ejf));
            } else {
                arrayList.add(ak + " " + n.T(this.mContext, instance.get(7)));
            }
            i2++;
        }
        i2 = instance.get(1);
        int i3 = instance.get(2) + 1;
        while (i < 12) {
            if (i3 + i > 12) {
                instance.set(1, i2 + 1);
                instance.set(2, (i3 + i) - 12);
            } else {
                instance.set(2, i3 + i);
            }
            instance.set(5, 1);
            this.yQX.add(Long.valueOf(instance.getTimeInMillis()));
            arrayList.add(String.valueOf(n.ak(this.mContext.getString(R.l.eiY), instance.getTimeInMillis() / 1000)));
            i++;
        }
        return bi.cB(arrayList);
    }
}
