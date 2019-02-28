package com.tencent.mm.plugin.aa.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.bl.d;
import com.tencent.mm.plugin.aa.a.h;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.d.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.y.q;

@a(1)
public class AAEntranceUI extends MMActivity {
    private Button iki;
    private TextView ikj;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(i.uQj);
        this.iki = (Button) findViewById(f.usi);
        this.ikj = (TextView) findViewById(f.uoe);
        this.iki.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("key_from_scene", 1);
                intent.putExtra("Select_Conv_Type", 3);
                intent.putExtra("select_is_ret", false);
                intent.putExtra("mutil_select_is_ret", false);
                intent.putExtra("Select_block_List", q.FY());
                intent.putExtra("recent_remittance_contact_list", h.WS());
                d.b(AAEntranceUI.this.mController.xRr, "remittance", ".ui.SelectRemittanceContactUI", intent, 1);
            }
        });
        this.ikj.setClickable(true);
        this.ikj.setOnTouchListener(new l(this));
        CharSequence spannableStringBuilder = new SpannableStringBuilder(getString(i.uOH));
        spannableStringBuilder.setSpan(new a(new a.a() {
            public final void WX() {
                AAEntranceUI.this.startActivity(new Intent(AAEntranceUI.this.mController.xRr, AAQueryListUI.class));
            }
        }), 0, spannableStringBuilder.length(), 18);
        this.ikj.setText(spannableStringBuilder);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AAEntranceUI.this.finish();
                return false;
            }
        });
    }

    protected final int getLayoutId() {
        return g.uHq;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 1) {
            String stringExtra = intent.getStringExtra("Select_Conv_User");
            x.i("MicroMsg.AAEntranceUI", "select chatroom：%s", stringExtra);
            if (!bi.oN(stringExtra)) {
                Intent intent2 = new Intent(this.mController.xRr, LaunchAAUI.class);
                intent2.putExtra("enter_scene", 2);
                intent2.putExtra("chatroom_name", stringExtra);
                startActivity(intent2);
            }
        }
    }
}
