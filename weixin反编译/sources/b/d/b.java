package b.d;

import b.a.a;
import java.util.NoSuchElementException;

public final class b extends a {
    private final int AEj;
    private boolean AEk;
    private int AEl;
    private final int jhF;

    public b(int i, int i2, int i3) {
        boolean z = true;
        this.jhF = i3;
        this.AEj = i2;
        if (this.jhF > 0) {
            if (i > i2) {
                z = false;
            }
        } else if (i < i2) {
            z = false;
        }
        this.AEk = z;
        if (!this.AEk) {
            i = this.AEj;
        }
        this.AEl = i;
    }

    public final boolean hasNext() {
        return this.AEk;
    }

    public final int nextInt() {
        int i = this.AEl;
        if (i != this.AEj) {
            this.AEl += this.jhF;
        } else if (this.AEk) {
            this.AEk = false;
        } else {
            throw new NoSuchElementException();
        }
        return i;
    }
}
