package com.tencent.mm.plugin.voiceprint.ui;

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
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

public class VoicePrintFinishUI extends MMActivity {
    private TextView jOY;
    private TextView soc;
    private Button sod;
    private ImageView soe;
    private int sof;

    public void onCreate(Bundle bundle) {
        x.i("MicroMsg.VoicePrintFinishUI", "VoicePrintFinishUI");
        super.onCreate(bundle);
        this.mController.hideTitleView();
        this.sof = getIntent().getIntExtra("kscene_type", 73);
        x.d("MicroMsg.VoicePrintFinishUI", "onCreate, sceneType:%d", Integer.valueOf(this.sof));
        this.jOY = (TextView) findViewById(R.h.cWL);
        this.soc = (TextView) findViewById(R.h.cWN);
        this.sod = (Button) findViewById(R.h.cIk);
        this.soe = (ImageView) findViewById(R.h.cWK);
        switch (this.sof) {
            case 72:
                this.jOY.setText(R.l.eUb);
                this.soc.setText(R.l.eUc);
                this.soe.setVisibility(0);
                this.sod.setText(R.l.eOf);
                break;
            case 73:
                this.jOY.setVisibility(8);
                this.soc.setText(R.l.eUo);
                this.soe.setVisibility(0);
                this.sod.setText(R.l.eOg);
                break;
        }
        this.sod.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (VoicePrintFinishUI.this.sof == 72) {
                    Intent intent = new Intent();
                    intent.setClass(VoicePrintFinishUI.this, VoiceUnLockUI.class);
                    intent.putExtra("kscene_type", 73);
                    VoicePrintFinishUI.this.startActivity(intent);
                }
                VoicePrintFinishUI.this.finish();
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                VoicePrintFinishUI.this.finish();
                return true;
            }
        });
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.dtM;
    }
}
