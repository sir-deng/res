package com.tencent.mm.plugin.location.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bl.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.p.b;
import com.tencent.mm.ui.u;
import java.util.ArrayList;

public class LocationExtUI extends MMActivity {
    private ArrayList<String> lNr = new ArrayList();
    private TextView nYj;
    private TextView nYk;
    private String nYl;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        CharSequence stringExtra = getIntent().getStringExtra("Kwebmap_locaion");
        if (bi.oN(stringExtra)) {
            findViewById(R.h.ctW).setVisibility(8);
        } else {
            ((TextView) findViewById(R.h.cui)).setText(stringExtra);
        }
        this.nYj = (TextView) findViewById(R.h.cQm);
        this.nYk = (TextView) findViewById(R.h.cHG);
        this.nYj.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("key_fav_result_list", LocationExtUI.this.lNr);
                d.b(LocationExtUI.this.mController.xRr, "favorite", ".ui.FavTagEditUI", intent, 4098);
            }
        });
        this.nYk.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent(LocationExtUI.this.mController.xRr, RemarkUI.class);
                intent.putExtra("key_nullable", true);
                intent.putExtra("key_value", LocationExtUI.this.getIntent().getStringExtra("key_value"));
                intent.putExtra("key_hint", LocationExtUI.this.getString(R.l.etr));
                intent.putExtra("Kwebmap_locaion", LocationExtUI.this.getIntent().getStringExtra("Kwebmap_locaion"));
                intent.putExtra(u.FLAG_OVERRIDE_EXIT_ANIMATION, R.a.bqm);
                intent.putExtra(u.FLAG_OVERRIDE_ENTER_ANIMATION, R.a.bpZ);
                intent.putExtra("kFavInfoLocalId", LocationExtUI.this.getIntent().getLongExtra("kFavInfoLocalId", -1));
                intent.putExtra("kRemark", LocationExtUI.this.getIntent().getStringExtra("kRemark"));
                LocationExtUI.this.startActivityForResult(intent, 4097);
            }
        });
        a(0, getString(R.l.dFw), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent();
                intent.putExtra("key_remark_result", LocationExtUI.this.nYl);
                intent.putExtra("key_tags_result", LocationExtUI.this.lNr);
                LocationExtUI.this.setResult(-1, intent);
                LocationExtUI.this.finish();
                return true;
            }
        }, b.xSe);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                LocationExtUI.this.finish();
                return true;
            }
        });
    }

    protected final int getLayoutId() {
        return R.i.dmM;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (4097 == i) {
            if (-1 == i2 && intent != null) {
                CharSequence charSequenceExtra = intent.getCharSequenceExtra("key_result");
                this.nYl = charSequenceExtra == null ? "" : charSequenceExtra.toString();
                this.nYk.setText(this.nYl);
            }
        } else if (4098 != i) {
            super.onActivityResult(i, i2, intent);
        } else if (-1 == i2 && intent != null) {
            this.lNr.clear();
            String[] stringArrayExtra = intent.getStringArrayExtra("key_fav_result_array");
            if (stringArrayExtra != null && stringArrayExtra.length > 0) {
                CharSequence charSequence = stringArrayExtra[0];
                this.lNr.add(stringArrayExtra[0]);
                String string = getResources().getString(R.l.egX);
                for (int i3 = 1; i3 < stringArrayExtra.length; i3++) {
                    this.lNr.add(stringArrayExtra[i3]);
                    charSequence = charSequence + string + stringArrayExtra[i3];
                }
                this.nYj.setText(charSequence);
            }
        }
    }
}
