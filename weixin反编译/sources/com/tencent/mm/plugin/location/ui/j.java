package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.graphics.Color;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.location.model.l;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.r;
import java.util.ArrayList;

public final class j {
    TextView FN;
    Context context;
    private String lis;
    ag mHandler = new ag(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            j jVar;
            Message obtain;
            String gw;
            switch (message.what) {
                case 1:
                    j.this.FN.setText(j.this.nZW);
                    return;
                case 2:
                    x.d("MicroMsg.ShareHeaderMsgMgr", "update member num, isMyselfTalking=%b, isOtherTalking=%b", Boolean.valueOf(j.this.nZB), Boolean.valueOf(j.this.nZV));
                    if (!j.this.nZB && !j.this.nZV) {
                        jVar = j.this;
                        jVar.FN.setTextColor(jVar.nZS);
                        jVar.FN.invalidate();
                        int intValue = ((Integer) message.obj).intValue();
                        if (intValue == 0) {
                            j.this.FN.setText(j.this.context.getString(R.l.eRB));
                            return;
                        }
                        j.this.FN.setText(j.this.context.getResources().getQuantityString(R.j.duW, intValue, new Object[]{Integer.valueOf(intValue)}));
                        return;
                    }
                    return;
                case 3:
                    if (j.this.nZV || j.this.nZB) {
                        removeMessages(3);
                        obtain = Message.obtain();
                        obtain.what = 3;
                        obtain.obj = message.obj;
                        sendMessage(obtain);
                        return;
                    }
                    j.this.nZW = j.this.FN.getText().toString();
                    j.a(j.this);
                    gw = r.gw((String) message.obj);
                    j.this.FN.setText(j.this.context.getString(R.l.eRH, new Object[]{gw}));
                    if (j.this.nZB || j.this.nZV) {
                        j.b(j.this);
                        return;
                    }
                    return;
                case 4:
                    if (j.this.nZV || j.this.nZB) {
                        removeMessages(4);
                        obtain = Message.obtain();
                        obtain.what = 4;
                        obtain.obj = message.obj;
                        sendMessage(obtain);
                        return;
                    }
                    j.this.nZW = j.this.FN.getText().toString();
                    j.a(j.this);
                    gw = r.gw((String) message.obj);
                    j.this.FN.setText(j.this.context.getString(R.l.eRI, new Object[]{gw}));
                    if (j.this.nZB || j.this.nZV) {
                        j.b(j.this);
                        return;
                    }
                    return;
                case 5:
                    j.this.nZV = true;
                    j.this.nZB = false;
                    j.a(j.this);
                    gw = r.gw((String) message.obj);
                    j.this.FN.setText(j.this.context.getString(R.l.eRJ, new Object[]{gw}));
                    return;
                case 6:
                    j.this.nZB = true;
                    j.this.nZV = false;
                    j.a(j.this);
                    j.this.FN.setText(j.this.context.getString(R.l.eRG));
                    return;
                case 7:
                    j.this.nZV = true;
                    jVar = j.this;
                    jVar.FN.setTextColor(jVar.nZT);
                    jVar.FN.invalidate();
                    j.this.FN.setText(j.this.context.getString(R.l.eRK));
                    j.this.nZW = j.this.FN.getText().toString();
                    j.b(j.this);
                    return;
                case 8:
                    jVar = j.this;
                    jVar.FN.setTextColor(jVar.nZU);
                    jVar.FN.invalidate();
                    j.this.FN.setText(j.this.context.getString(R.l.eRL));
                    return;
                case 9:
                    j.this.nZB = false;
                    if (!j.this.nZV) {
                        j.this.gr(true);
                        return;
                    }
                    return;
                case 10:
                    j.this.nZV = false;
                    j.this.gr(false);
                    return;
                default:
                    return;
            }
        }
    };
    boolean nZB = false;
    private ViewGroup nZD;
    ArrayList<String> nZE;
    private final int nZF = 100;
    private final int nZG = 1;
    private final int nZH = 2;
    private final int nZI = 3;
    private final int nZJ = 4;
    private final int nZK = 5;
    private final int nZL = 6;
    private final int nZM = 7;
    private final int nZN = 8;
    private final int nZO = 9;
    private final int nZP = 10;
    boolean nZQ = true;
    private int nZR = Color.parseColor("#44FEBB");
    int nZS = Color.parseColor("#FFFFFF");
    int nZT = Color.parseColor("#E54646");
    int nZU = Color.parseColor("#FFC90C");
    boolean nZV = false;
    String nZW = "";

    static /* synthetic */ void a(j jVar) {
        jVar.FN.setTextColor(jVar.nZR);
        jVar.FN.invalidate();
    }

    static /* synthetic */ void b(j jVar) {
        jVar.mHandler.removeMessages(1);
        Message obtain = Message.obtain();
        obtain.what = 1;
        jVar.mHandler.sendMessageDelayed(obtain, 100);
    }

    public j(Context context, ViewGroup viewGroup, String str) {
        this.context = context;
        this.nZD = viewGroup;
        this.FN = (TextView) this.nZD.findViewById(R.h.title);
        this.lis = str;
        init();
    }

    private void init() {
        x.d("MicroMsg.ShareHeaderMsgMgr", "init");
        this.FN.invalidate();
        this.nZE = new ArrayList();
        for (String add : l.aWb().Eg(this.lis)) {
            this.nZE.add(add);
        }
        gr(false);
    }

    final void gr(boolean z) {
        this.mHandler.removeMessages(2);
        Message obtain = Message.obtain();
        obtain.what = 2;
        obtain.obj = Integer.valueOf(this.nZE.size());
        x.d("MicroMsg.ShareHeaderMsgMgr", "updateMemberCount, size=%d, isDelay=%b", Integer.valueOf(this.nZE.size()), Boolean.valueOf(z));
        if (z) {
            this.mHandler.sendMessageDelayed(obtain, 100);
        } else {
            this.mHandler.sendMessage(obtain);
        }
    }
}
