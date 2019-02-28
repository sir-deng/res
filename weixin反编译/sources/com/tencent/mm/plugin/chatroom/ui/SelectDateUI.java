package com.tencent.mm.plugin.chatroom.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.chatroom.a.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.r;
import java.util.HashMap;

public class SelectDateUI extends MMActivity implements a {
    private String jXh;
    private r jqf = null;
    private long lgw = -1;
    private DayPickerView liW;
    private HashMap<String, com.tencent.mm.plugin.chatroom.d.a> liX;
    private TextView liY;
    private ag mHandler;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.tencent.mm.plugin.chatroom.ui.SelectDateUI r10) {
        /*
        r9 = 1;
        r8 = 0;
        r2 = java.lang.System.currentTimeMillis();
        com.tencent.mm.y.as.Hm();
        r0 = com.tencent.mm.y.c.Fh();
        r1 = r10.jXh;
        r1 = r0.Fb(r1);
        r0 = r1.moveToFirst();	 Catch:{ Exception -> 0x0054 }
        if (r0 == 0) goto L_0x0083;
    L_0x0019:
        r0 = r1.isAfterLast();	 Catch:{ Exception -> 0x0054 }
        if (r0 != 0) goto L_0x0083;
    L_0x001f:
        r4 = -1;
        r6 = r10.lgw;	 Catch:{ Exception -> 0x0054 }
        r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r0 != 0) goto L_0x002e;
    L_0x0027:
        r0 = 0;
        r4 = r1.getLong(r0);	 Catch:{ Exception -> 0x0054 }
        r10.lgw = r4;	 Catch:{ Exception -> 0x0054 }
    L_0x002e:
        r0 = new com.tencent.mm.plugin.chatroom.d.a;	 Catch:{ Exception -> 0x0054 }
        r4 = 0;
        r4 = r1.getLong(r4);	 Catch:{ Exception -> 0x0054 }
        r0.<init>(r4);	 Catch:{ Exception -> 0x0054 }
        r4 = 1;
        r4 = r1.getLong(r4);	 Catch:{ Exception -> 0x0054 }
        r0.frh = r4;	 Catch:{ Exception -> 0x0054 }
        r4 = r0.toString();	 Catch:{ Exception -> 0x0054 }
        r5 = r10.liX;	 Catch:{ Exception -> 0x0054 }
        r5 = r5.containsKey(r4);	 Catch:{ Exception -> 0x0054 }
        if (r5 != 0) goto L_0x0050;
    L_0x004b:
        r5 = r10.liX;	 Catch:{ Exception -> 0x0054 }
        r5.put(r4, r0);	 Catch:{ Exception -> 0x0054 }
    L_0x0050:
        r1.moveToNext();	 Catch:{ Exception -> 0x0054 }
        goto L_0x0019;
    L_0x0054:
        r0 = move-exception;
        r4 = "MicroMsg.SelectDateUI";
        r0 = r0.toString();	 Catch:{ all -> 0x0087 }
        com.tencent.mm.sdk.platformtools.x.e(r4, r0);	 Catch:{ all -> 0x0087 }
        r1.close();
    L_0x0062:
        r0 = "MicroMsg.SelectDateUI";
        r1 = "[prepareData] time:%s";
        r4 = new java.lang.Object[r9];
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = java.lang.System.currentTimeMillis();
        r2 = r6 - r2;
        r2 = r5.append(r2);
        r2 = r2.toString();
        r4[r8] = r2;
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r4);
        return;
    L_0x0083:
        r1.close();
        goto L_0x0062;
    L_0x0087:
        r0 = move-exception;
        r1.close();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.chatroom.ui.SelectDateUI.a(com.tencent.mm.plugin.chatroom.ui.SelectDateUI):void");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.eGo);
        this.liW = (DayPickerView) findViewById(R.h.cCH);
        this.liY = (TextView) findViewById(R.h.cJY);
        this.liX = new HashMap();
        this.mHandler = new ag(getMainLooper());
        this.jXh = getIntent().getStringExtra("detail_username");
        e.post(new Runnable() {
            public final void run() {
                SelectDateUI.a(SelectDateUI.this);
                SelectDateUI.this.mHandler.post(new Runnable() {
                    public final void run() {
                        SelectDateUI.this.liW.lgw = SelectDateUI.this.lgw == -1 ? System.currentTimeMillis() * 1000 : SelectDateUI.this.lgw;
                        SelectDateUI.this.liW.a(SelectDateUI.this, SelectDateUI.this.liX.values());
                        if (SelectDateUI.this.liX.size() == 0) {
                            SelectDateUI.this.liY.setVisibility(0);
                            SelectDateUI.this.liW.setVisibility(8);
                            SelectDateUI.this.liY.setText(SelectDateUI.this.getString(R.l.dSP));
                            return;
                        }
                        SelectDateUI.this.liY.setVisibility(8);
                        SelectDateUI.this.liW.setVisibility(0);
                    }
                });
            }
        }, "prepare_data");
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SelectDateUI.this.finish();
                return true;
            }
        });
    }

    protected final int getLayoutId() {
        return R.i.drM;
    }

    public final long aye() {
        return System.currentTimeMillis();
    }

    public final void a(com.tencent.mm.plugin.chatroom.d.a aVar) {
        if (aVar == null) {
            x.e("MicroMsg.SelectDateUI", "null == calendarDay");
            return;
        }
        x.i("MicroMsg.SelectDateUI", "Day Selected timestamp:%s day:%s month:%s year:%s", Long.valueOf(aVar.leW), Integer.valueOf(aVar.kIo), Integer.valueOf(aVar.month), Integer.valueOf(aVar.year));
        x.i("MicroMsg.SelectDateUI", "[goToChattingUI] msgLocalId:%s", Long.valueOf(aVar.frh));
        com.tencent.mm.plugin.chatroom.a.ihN.e(new Intent().putExtra("Chat_User", this.jXh).putExtra("finish_direct", true).putExtra("from_global_search", true).putExtra("msg_local_id", r0), (Context) this);
    }
}
