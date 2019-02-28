package com.tencent.mm.plugin.appbrand.game.e;

import com.tencent.magicbrush.engine.c;
import com.tencent.magicbrush.handler.image.MBCanvasContentHolder;
import com.tencent.mm.plugin.appbrand.game.i;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public enum a {
    ;

    private static class a implements Callable<MBCanvasContentHolder> {
        private int jdz;

        /* synthetic */ a(int i, byte b) {
            this(i);
        }

        public final /* synthetic */ Object call() {
            return afi();
        }

        private a(int i) {
            this.jdz = i;
        }

        public final MBCanvasContentHolder afi() {
            x.i("MicroMsg.WAGameCanvasSnapshotHandler", "hy: before");
            long currentTimeMillis = System.currentTimeMillis();
            MBCanvasContentHolder eg = c.eg(this.jdz);
            x.i("MicroMsg.WAGameCanvasSnapshotHandler", "hy: capture using : %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            return eg;
        }
    }

    private static class b implements Callable<MBCanvasContentHolder> {
        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }

        public final /* synthetic */ Object call() {
            x.i("MicroMsg.WAGameCanvasSnapshotHandler", "hy: before");
            long currentTimeMillis = System.currentTimeMillis();
            MBCanvasContentHolder sD = c.sD();
            x.i("MicroMsg.WAGameCanvasSnapshotHandler", "hy: capture using : %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            return sD;
        }
    }

    private a(String str) {
    }

    public final MBCanvasContentHolder kn(int i) {
        return b(new a(i, (byte) 0));
    }

    public final MBCanvasContentHolder afg() {
        return b(new b());
    }

    public static MBCanvasContentHolder ko(int i) {
        MBCanvasContentHolder mBCanvasContentHolder = null;
        if (afh()) {
            try {
                return new a(i, (byte) 0).afi();
            } catch (Exception e) {
                x.e("MicroMsg.WAGameCanvasSnapshotHandler", "getScreenCanvas Direct [%s]", e);
                return mBCanvasContentHolder;
            }
        }
        x.e("MicroMsg.WAGameCanvasSnapshotHandler", "CurrentThread is not glThread, please post to GLThread. [%s]", Thread.currentThread());
        return mBCanvasContentHolder;
    }

    private MBCanvasContentHolder b(Callable<MBCanvasContentHolder> callable) {
        i iVar = null;
        int i = 0;
        if (afh()) {
            x.e("MicroMsg.WAGameCanvasSnapshotHandler", "Current thread is [%s], dismiss this task", Thread.currentThread());
        } else {
            i = 1;
        }
        if (i == 0) {
            return null;
        }
        final FutureTask futureTask = new FutureTask(callable);
        com.tencent.mm.plugin.appbrand.game.i.a anonymousClass1 = new com.tencent.mm.plugin.appbrand.game.i.a() {
            public final void aei() {
                futureTask.run();
            }
        };
        i iVar2 = i.jaA;
        if (!iVar2.jaB.contains(anonymousClass1)) {
            iVar2.jaB.add(anonymousClass1);
        }
        try {
            MBCanvasContentHolder mBCanvasContentHolder = (MBCanvasContentHolder) futureTask.get(2500, TimeUnit.MILLISECONDS);
            if (mBCanvasContentHolder != null) {
                return mBCanvasContentHolder;
            }
            futureTask.cancel(true);
            x.w("MicroMsg.WAGameCanvasSnapshotHandler", "postGetCanvasShotSyncOnRenderThread bitmap is null");
            i.jaA.a(anonymousClass1);
            return null;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WAGameCanvasSnapshotHandler", e, "hy: AppBrandGame getScreenShotsBitmap InterruptedException", new Object[0]);
            futureTask.cancel(true);
            return iVar;
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.WAGameCanvasSnapshotHandler", e2, "hy: AppBrandGame getScreenShotsBitmap ExecutionException", new Object[0]);
            futureTask.cancel(true);
            return iVar;
        } catch (Throwable e22) {
            x.printErrStackTrace("MicroMsg.WAGameCanvasSnapshotHandler", e22, "hy: AppBrandGame getScreenShotsBitmap TimeoutException", new Object[0]);
            futureTask.cancel(true);
            return iVar;
        } finally {
            iVar = i.jaA;
            iVar.a(anonymousClass1);
            return iVar;
        }
    }

    private static boolean afh() {
        String name = Thread.currentThread().getName();
        return name != null && name.startsWith("GLThread");
    }
}
