package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;

public class VoiceReCreatePromptUI extends MMActivity implements OnClickListener {
    private View soA = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mController.hideTitleView();
        this.soA = findViewById(R.h.cHi);
        this.soA.setOnClickListener(this);
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.dtP;
    }

    public void onClick(View view) {
        startActivity(new Intent(this, VoiceCreateUI.class));
        finish();
    }
}
