package com.tencent.mm.plugin.nearby.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.be.h;
import com.tencent.mm.be.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.rtmp.TXLiveConstants;

public class NearbyFriendShowSayHiUI extends MMActivity {
    ImageView ikK;
    String oUa = "";
    View oUb = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.exE);
        initView();
    }

    protected void onResume() {
        super.onResume();
        TextView textView = (TextView) findViewById(R.h.cIO);
        int Tx = l.TF().Tx();
        if (Tx == 0) {
            this.oUb.setVisibility(4);
            return;
        }
        textView.setText(getResources().getQuantityString(R.j.duV, Tx, new Object[]{Integer.valueOf(Tx)}));
        this.ikK = (ImageView) findViewById(R.h.cvy);
        h Ty = l.TF().Ty();
        if (Ty != null) {
            this.oUa = Ty.field_sayhiuser;
            b.a(this.ikK, this.oUa);
        }
    }

    public void onPause() {
        super.onPause();
    }

    protected final int getLayoutId() {
        return R.i.doS;
    }

    protected final void initView() {
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                NearbyFriendShowSayHiUI.this.aWY();
                NearbyFriendShowSayHiUI.this.finish();
                return true;
            }
        });
        ((Button) findViewById(R.h.cyY)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                NearbyFriendShowSayHiUI.this.startActivity(new Intent(NearbyFriendShowSayHiUI.this, NearbyFriendsUI.class));
            }
        });
        this.oUb = findViewById(R.h.cnR);
        this.oUb.setVisibility(0);
        this.oUb.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent(NearbyFriendShowSayHiUI.this, NearbySayHiListUI.class);
                intent.putExtra("k_say_hi_type", 2);
                intent.putExtra("show_clear_header", true);
                NearbyFriendShowSayHiUI.this.startActivityForResult(intent, TXLiveConstants.PLAY_EVT_CHANGE_RESOLUTION);
            }
        });
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == TXLiveConstants.PLAY_EVT_CHANGE_RESOLUTION && i2 == -1) {
            finish();
        }
    }
}
