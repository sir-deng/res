package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.tencent.mm.plugin.report.service.f;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.DrawedCallBackLinearLayout;

public class TestTimeForChatting extends DrawedCallBackLinearLayout {
    public final String TAG = "MicroMsg.TestTimeForChatting";
    public int gVd = 0;
    public a zws;
    public int zwt = 0;
    public int zwu = 0;

    public interface a {
        void coo();
    }

    public TestTimeForChatting(Context context) {
        super(context);
    }

    public TestTimeForChatting(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    protected void onDraw(Canvas canvas) {
        long currentTimeMillis = System.currentTimeMillis();
        super.onDraw(canvas);
        x.i("MicroMsg.TestTimeForChatting", (System.currentTimeMillis() - currentTimeMillis));
    }

    public final void cyU() {
        x.i("MicroMsg.TestTimeForChatting", "klem frameCount:%d", Integer.valueOf(this.gVd));
        g.pWK.h(11198, Integer.valueOf(this.gVd));
    }

    protected void dispatchDraw(Canvas canvas) {
        this.gVd++;
        try {
            super.dispatchDraw(canvas);
        } catch (Throwable th) {
            x.printErrStackTrace("MicroMsg.TestTimeForChatting", th, "dispatchDraw", new Object[0]);
        }
        f.vS(9);
        f.vS(18);
        f.vS(25);
        f.vS(24);
        f.vS(20);
        f.vS(18);
        if (this.zws != null) {
            this.zws.coo();
        }
    }

    public boolean fitSystemWindows(Rect rect) {
        x.d("MicroMsg.TestTimeForChatting", "ashu::fitSystemWindows: %s, fixBottomPadding:%d fixRightPadding:%d", rect.toString(), Integer.valueOf(this.zwt), Integer.valueOf(this.zwu));
        rect.bottom += this.zwt;
        rect.right += this.zwu;
        return super.fitSystemWindows(rect);
    }
}
