package com.tencent.mm.plugin.nearlife.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;

public class LogoImageView extends ImageView {
    ag handler = new ag() {
        public final void handleMessage(Message message) {
            byte[] bArr = (byte[]) message.obj;
            if (bArr == null || bArr.length == 0) {
                x.e("MicroMsg.LogoImageView", "handleMsg fail, data is null");
                return;
            }
            Bitmap bitmap;
            Bitmap bn = d.bn(bArr);
            x.d("MicroMsg.LogoImageView", "filePath  %s", LogoImageView.this.imagePath + g.s(LogoImageView.this.url.getBytes()));
            e.b(r2, bArr, bArr.length);
            if (bn == null || LogoImageView.this.nZY <= 0 || LogoImageView.this.mBg <= 0) {
                bitmap = bn;
            } else {
                bitmap = d.a(bn, LogoImageView.this.mBg, LogoImageView.this.nZY, true, false);
            }
            LogoImageView.this.setImageBitmap(bitmap);
        }
    };
    String imagePath;
    int mBg;
    int nZY;
    String url = null;

    static class a implements Runnable {
        private ag handler;
        private String url;

        a(String str, ag agVar) {
            this.url = str;
            this.handler = agVar;
        }

        public final void run() {
            Object Ws = bi.Ws(this.url);
            Message obtain = Message.obtain();
            obtain.obj = Ws;
            this.handler.sendMessage(obtain);
        }
    }

    public LogoImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
