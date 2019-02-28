package com.tencent.mm.compatible.b;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;

public final class j extends MediaPlayer {
    public j() {
        f.fF(hashCode());
    }

    public static j a(Context context, Uri uri) {
        try {
            j jVar = new j();
            jVar.setDataSource(context, uri);
            jVar.prepare();
            return jVar;
        } catch (IOException e) {
            x.d("MicroMsg.MediaPlayerWrapper", "create failed:", e);
        } catch (IllegalArgumentException e2) {
            x.d("MicroMsg.MediaPlayerWrapper", "create failed:", e2);
        } catch (SecurityException e3) {
            x.d("MicroMsg.MediaPlayerWrapper", "create failed:", e3);
        }
        return null;
    }

    public final void release() {
        super.release();
        f.fG(hashCode());
    }
}
