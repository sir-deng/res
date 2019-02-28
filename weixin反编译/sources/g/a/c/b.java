package g.a.c;

import com.tencent.smtt.sdk.WebView;
import java.io.InputStream;

public final class b {
    public int AIW;
    public InputStream AIX;
    public int wXj;

    public final int d(short[] sArr, int i) {
        short s = sArr[i];
        int i2 = (this.AIW >>> 11) * s;
        if ((this.wXj ^ Integer.MIN_VALUE) < (Integer.MIN_VALUE ^ i2)) {
            this.AIW = i2;
            sArr[i] = (short) (s + ((2048 - s) >>> 5));
            if ((this.AIW & WebView.NIGHT_MODE_COLOR) == 0) {
                this.wXj = (this.wXj << 8) | this.AIX.read();
                this.AIW <<= 8;
            }
            return 0;
        }
        this.AIW -= i2;
        this.wXj -= i2;
        sArr[i] = (short) (s - (s >>> 5));
        if ((this.AIW & WebView.NIGHT_MODE_COLOR) == 0) {
            this.wXj = (this.wXj << 8) | this.AIX.read();
            this.AIW <<= 8;
        }
        return 1;
    }

    public static void b(short[] sArr) {
        for (int i = 0; i < sArr.length; i++) {
            sArr[i] = (short) 1024;
        }
    }
}
