package org.camera.preview;

import android.content.Context;
import android.graphics.PixelFormat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import org.camera.camera.CameraWrapper;

public class CameraSurfacePreview extends SurfaceView implements SurfaceHolder.Callback {
	
	public static final String TAG = "CameraSurfacePreview";
	SurfaceHolder mSurfaceHolder;
	Context mContext;
	CameraWrapper mCameraWrapper;

	@SuppressWarnings("deprecation")
	public CameraSurfacePreview(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.mSurfaceHolder = getHolder();
		this.mContext = getContext();
		this.mSurfaceHolder.setFormat(PixelFormat.TRANSPARENT);
		this.mSurfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);  
		this.mSurfaceHolder.addCallback(this);
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		Log.i(TAG, "surfaceCreated...");  
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		Log.i(TAG, "surfaceChanged...");
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		Log.i(TAG, "surfaceDestroyed...");
		CameraWrapper.getInstance().doStopCamera();
	}
	
	public SurfaceHolder getSurfaceHolder(){  
        return this.mSurfaceHolder;  
    }
}
