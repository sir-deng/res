package com.tencent.mm.plugin.sns.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;

public class SnsLongMsgUI extends MMActivity {
    private Button rpz;

    public void onDestroy() {
        super.onDestroy();
    }

    @TargetApi(17)
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitleVisibility(8);
        this.rpz = (Button) findViewById(f.qIF);
        this.rpz.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(SnsLongMsgUI.this, SnsUploadUI.class);
                intent.putExtra("KSnsPostManu", true);
                intent.putExtra("KTouchCameraTime", bi.Wx());
                intent.putExtra("sns_comment_type", 1);
                intent.putExtra("Ksnsupload_type", 9);
                SnsLongMsgUI.this.startActivity(intent);
                SnsLongMsgUI.this.finish();
            }
        });
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getAction() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        Intent intent = new Intent();
        intent.setClass(this, SnsUploadUI.class);
        intent.putExtra("KSnsPostManu", true);
        intent.putExtra("KTouchCameraTime", bi.Wx());
        intent.putExtra("sns_comment_type", 1);
        intent.putExtra("Ksnsupload_type", 9);
        startActivity(intent);
        finish();
        return true;
    }

    protected final int getLayoutId() {
        return g.qMz;
    }
}
