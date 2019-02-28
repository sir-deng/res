package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bm.d.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.s;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class InviteRemindDialog extends MMBaseActivity {
    private TextView jtn;
    private TextView svO;
    private String talker = "";
    private int type = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.i.doo);
        this.jtn = (TextView) findViewById(R.h.cwp);
        this.svO = (TextView) findViewById(R.h.cwm);
        this.talker = getIntent().getStringExtra("InviteRemindDialog_User");
        this.type = getIntent().getIntExtra("InviteRemindDialog_Type", 0);
        if (this.type == 0) {
            this.jtn.setText(getString(R.l.eVY));
            this.svO.setText(getString(R.l.eVJ));
        } else if (this.type == 1) {
            this.jtn.setText(getString(R.l.eWq));
            this.svO.setText(getString(R.l.eWo));
        }
        findViewById(R.h.cwq).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (InviteRemindDialog.this.talker != null) {
                    try {
                        as.Hm();
                        Map TP = a.TP((String) c.Db().get(77829, null));
                        a aVar;
                        if (TP != null) {
                            if (TP != null && TP.size() > 0) {
                                if (TP.containsKey(InviteRemindDialog.this.talker)) {
                                    aVar = (a) TP.get(InviteRemindDialog.this.talker);
                                    aVar.hLp++;
                                    TP.put(InviteRemindDialog.this.talker, aVar);
                                } else {
                                    aVar = new a();
                                    aVar.hLp++;
                                    TP.put(InviteRemindDialog.this.talker, aVar);
                                }
                            }
                            as.Hm();
                            c.Db().set(77829, a.as(TP));
                            for (Entry value : TP.entrySet()) {
                                aVar = (a) value.getValue();
                                x.d("MMInviteRemindDialog", "val " + aVar.hitCount + " " + aVar.hLp);
                            }
                        } else {
                            Map hashMap = new HashMap();
                            a aVar2 = new a();
                            aVar2.hLp++;
                            hashMap.put(InviteRemindDialog.this.talker, aVar2);
                            as.Hm();
                            c.Db().set(77829, a.as(hashMap));
                            for (Entry value2 : hashMap.entrySet()) {
                                aVar = (a) value2.getValue();
                                x.d("MMInviteRemindDialog", "val " + aVar.hitCount + " " + aVar.hLp);
                            }
                        }
                    } catch (Throwable e) {
                        x.printErrStackTrace("MMInviteRemindDialog", e, "", new Object[0]);
                    }
                }
                String string = InviteRemindDialog.this.type == 0 ? InviteRemindDialog.this.getString(R.l.eVI) : InviteRemindDialog.this.type == 1 ? InviteRemindDialog.this.getString(R.l.eWn) : null;
                as.CN().a(new com.tencent.mm.plugin.voip.model.c(InviteRemindDialog.this.talker, string, s.hs(InviteRemindDialog.this.talker)), 0);
                Intent intent = new Intent();
                intent.addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
                intent.addFlags(67108864);
                intent.putExtra("Chat_User", InviteRemindDialog.this.talker);
                com.tencent.mm.plugin.voip.a.a.ihN.e(intent, InviteRemindDialog.this);
                InviteRemindDialog.this.finish();
            }
        });
        findViewById(R.h.cwg).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                InviteRemindDialog.this.finish();
            }
        });
    }

    public void finish() {
        super.finish();
    }

    public static void l(Context context, String str, int i) {
        Intent intent = new Intent(context, InviteRemindDialog.class);
        intent.putExtra("InviteRemindDialog_User", str);
        intent.putExtra("InviteRemindDialog_Type", i);
        context.startActivity(intent);
    }
}
