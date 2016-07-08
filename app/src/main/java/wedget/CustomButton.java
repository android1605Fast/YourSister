package wedget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.qf.administrator.yoursister.R;

/**
 * Created by Shinelon on 2016/7/8.
 */
public class CustomButton extends View {
    private Paint paint;
    private Bitmap bitmap;
    private int bitmapID;
    private String text;
    private float fFontHeight;
    private int size;
    private int textColor;
    public CustomButton(Context context) {
        super(context);
        init(context, null, 0);
    }
    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public CustomButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        if(attrs!=null){
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.comment_btn);
            size=typedArray.getInteger(R.styleable.comment_btn_textSize,35);
            text=typedArray.getString(R.styleable.comment_btn_text);
            bitmapID=typedArray.getResourceId(R.styleable.comment_btn_rightImageID, R.mipmap.ic_launcher);
            textColor=typedArray.getColor(R.styleable.comment_btn_textColor,Color.argb(50,240,240,240));
        }
        paint=new Paint();
        paint.setColor(Color.BLACK);
        paint.setTextSize(size);
        bitmap = BitmapFactory.decodeResource(getResources(), bitmapID);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(bitmap,getWidth()/4,0, paint);
        canvas.drawText(text,getWidth()/4+bitmap.getWidth(),getHeight()/2,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction()==MotionEvent.ACTION_DOWN){
            setBackgroundColor(Color.RED);
        }
        if(event.getAction()==MotionEvent.ACTION_UP){
            setBackgroundColor(Color.WHITE);
        }

        return true;
    }
    //设置图片
    public void setImageBitmap(Bitmap bitmap){
        this.bitmap=bitmap;
        invalidate();
    }
    //设置文字
    public void setText(String text){
        this.text=text;
        invalidate();
    }
    public void setTextSize(int size){
        this.size=size;
        invalidate();
    }

    public void setTextColor(int textColor){
        this.textColor=textColor;
        invalidate();
    }
}