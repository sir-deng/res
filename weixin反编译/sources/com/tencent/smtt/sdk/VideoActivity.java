package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.VideoView;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.wcdb.database.SQLiteDatabase;

public class VideoActivity extends Activity {
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        y.hx(this);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.requestWindowFeature(1);
        super.getWindow().setFormat(-3);
        Intent intent = super.getIntent();
        Bundle bundleExtra = intent != null ? intent.getBundleExtra("extraData") : null;
        if (bundleExtra != null) {
            bundleExtra.putInt("callMode", 1);
            y hx = y.hx(super.getApplicationContext());
            if (bundleExtra == null) {
                bundleExtra = new Bundle();
            }
            if (!TextUtils.isEmpty(null)) {
                bundleExtra.putString("videoUrl", null);
            }
            bundleExtra.putInt("callMode", 1);
            z zVar = hx.Aif;
            zVar.setBackgroundColor(WebView.NIGHT_MODE_COLOR);
            if (zVar.Aih == null) {
                h.nW(true).a(zVar.getContext().getApplicationContext(), null);
                aa cEO = h.nW(true).cEO();
                DexLoader dexLoader = cEO != null ? cEO.Ain : null;
                if (dexLoader != null && QbSdk.canLoadVideo(zVar.getContext())) {
                    zVar.Aih = new ac(dexLoader);
                }
            }
            if (zVar.Aih != null && zVar.Aig == null) {
                zVar.Aig = zVar.Aih.hy(zVar.getContext().getApplicationContext());
            }
            boolean z = false;
            if (zVar.cFT()) {
                bundleExtra.putInt("callMode", bundleExtra.getInt("callMode"));
                z = zVar.Aih.a(zVar.Aig, bundleExtra, zVar, null);
            }
            if (!z) {
                if (zVar.Aii != null) {
                    zVar.Aii.stopPlayback();
                }
                if (zVar.Aii == null) {
                    zVar.Aii = new VideoView(zVar.getContext());
                }
                zVar.mUrl = bundleExtra.getString("videoUrl");
                zVar.Aii.setVideoURI(Uri.parse(zVar.mUrl));
                zVar.Aii.setOnErrorListener(zVar);
                intent = new Intent("com.tencent.smtt.tbs.video.PLAY");
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                Context applicationContext = zVar.getContext().getApplicationContext();
                intent.setPackage(applicationContext.getPackageName());
                applicationContext.startActivity(intent);
            }
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        y.hx(this).n(this, 4);
    }

    protected void onPause() {
        super.onPause();
        y.hx(this).n(this, 3);
    }

    protected void onResume() {
        super.onResume();
        y.hx(this).n(this, 2);
    }

    protected void onStop() {
        super.onStop();
        y.hx(this).n(this, 1);
    }
}
