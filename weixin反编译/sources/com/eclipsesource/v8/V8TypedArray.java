package com.eclipsesource.v8;

import java.nio.ByteBuffer;

public class V8TypedArray extends V8Array {

    private static class V8ArrayData {
        private V8ArrayBuffer buffer;
        private int offset;
        private int size;
        private int type;

        public V8ArrayData(V8ArrayBuffer v8ArrayBuffer, int i, int i2, int i3) {
            this.buffer = v8ArrayBuffer;
            this.offset = i;
            this.size = i2;
            this.type = i3;
        }
    }

    public V8TypedArray(V8 v8, V8ArrayBuffer v8ArrayBuffer, int i, int i2, int i3) {
        super(v8, new V8ArrayData(v8ArrayBuffer, i2, i3, i));
    }

    private V8TypedArray(V8 v8) {
        super(v8);
    }

    public V8ArrayBuffer getBuffer() {
        return (V8ArrayBuffer) get("buffer");
    }

    public ByteBuffer getByteBuffer() {
        V8ArrayBuffer buffer = getBuffer();
        try {
            ByteBuffer backingStore = buffer.getBackingStore();
            return backingStore;
        } finally {
            buffer.release();
        }
    }

    protected void initialize(long j, Object obj) {
        this.v8.checkThread();
        if (obj == null) {
            super.initialize(j, obj);
            return;
        }
        V8ArrayData v8ArrayData = (V8ArrayData) obj;
        checkArrayProperties(v8ArrayData);
        long createTypedArray = createTypedArray(j, v8ArrayData);
        this.released = false;
        addObjectReference(createTypedArray);
    }

    private long createTypedArray(long j, V8ArrayData v8ArrayData) {
        switch (v8ArrayData.type) {
            case 1:
                return this.v8.initNewV8Int32Array(j, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
            case 2:
                return this.v8.initNewV8Float64Array(j, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
            case 9:
                return this.v8.initNewV8Int8Array(j, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
            case 11:
                return this.v8.initNewV8UInt8Array(j, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
            case 12:
                return this.v8.initNewV8UInt8ClampedArray(j, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
            case 13:
                return this.v8.initNewV8Int16Array(j, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
            case 14:
                return this.v8.initNewV8UInt16Array(j, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
            case 15:
                return this.v8.initNewV8UInt32Array(j, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
            case 16:
                return this.v8.initNewV8Float32Array(j, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
            default:
                throw new IllegalArgumentException("Cannot create a typed array of type " + V8Value.getStringRepresentation(v8ArrayData.type));
        }
    }

    public static int getStructureSize(int i) {
        switch (i) {
            case 1:
            case 15:
            case 16:
                return 4;
            case 2:
                return 8;
            case 9:
            case 11:
            case 12:
                return 1;
            case 13:
            case 14:
                return 2;
            default:
                throw new IllegalArgumentException("Cannot create a typed array of type " + V8Value.getStringRepresentation(i));
        }
    }

    private void checkArrayProperties(V8ArrayData v8ArrayData) {
        checkOffset(v8ArrayData);
        checkSize(v8ArrayData);
    }

    private void checkSize(V8ArrayData v8ArrayData) {
        if (v8ArrayData.size < 0) {
            throw new IllegalStateException("RangeError: Invalid typed array length");
        } else if ((v8ArrayData.size * getStructureSize(v8ArrayData.type)) + v8ArrayData.offset > v8ArrayData.buffer.getBackingStore().limit()) {
            throw new IllegalStateException("RangeError: Invalid typed array length");
        }
    }

    private void checkOffset(V8ArrayData v8ArrayData) {
        if (v8ArrayData.offset % getStructureSize(v8ArrayData.type) != 0) {
            throw new IllegalStateException("RangeError: Start offset of Int32Array must be a multiple of " + getStructureSize(v8ArrayData.type));
        }
    }

    protected V8Value createTwin() {
        return new V8TypedArray(this.v8);
    }
}
