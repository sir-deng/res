package com.tencent.mm.plugin.location.ui;

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

public class SimpleImageView extends ImageView {
    public ag handler = new ag() {
        public final void handleMessage(Message message) {
            byte[] bArr = (byte[]) message.obj;
            if (bArr == null || bArr.length == 0) {
                x.e("MicroMsg.SimpleImageView", "handleMsg fail, data is null");
                return;
            }
            Bitmap bitmap;
            Bitmap bn = d.bn(bArr);
            x.d("MicroMsg.SimpleImageView", "filePath  %s", SimpleImageView.this.imagePath + g.s(SimpleImageView.this.url.getBytes()));
            e.b(r2, bArr, bArr.length);
            if (bn == null || SimpleImageView.this.nZY <= 0 || SimpleImageView.this.mBg <= 0) {
                bitmap = bn;
            } else {
                bitmap = d.a(bn, SimpleImageView.this.mBg, SimpleImageView.this.nZY, true, false);
            }
            SimpleImageView.this.setImageBitmap(bitmap);
        }
    };
    public String imagePath;
    public int mBg;
    public int nZY;
    public String url = null;

    static class a implements Runnable {
        private ag handler;
        private String url;

        public a(String str, ag agVar) {
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

    public SimpleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
