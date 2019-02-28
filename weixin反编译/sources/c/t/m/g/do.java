package c.t.m.g;

import android.location.Location;

public final class do extends dq {
    public final Location a;
    public final long b;
    public final int c;
    public final int d;
    private int e;
    private int f;

    public enum a {
        ;
        
        public static final int a = 0;

        static {
            a = 2;
            int[] iArr = new int[]{1, 2, 3, 4};
        }
    }

    public do(Location location, long j, int i, int i2, int i3, int i4) {
        this.a = location;
        this.b = j;
        this.e = i;
        this.c = i2;
        this.f = i3;
        this.d = i4;
    }

    public final String toString() {
        return "TxGpsInfo [location=" + this.a + ", gpsTime=" + this.b + ", visbleSatelliteNum=" + this.e + ", usedSatelliteNum=" + this.c + ", gpsStatus=" + this.f + "]";
    }
}
