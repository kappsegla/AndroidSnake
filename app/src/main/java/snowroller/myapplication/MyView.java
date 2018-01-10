package snowroller.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import java.util.LinkedList;
import java.util.Random;

/**
 * Created by Martin on 2018-01-10.
 */


public class MyView extends View implements View.OnTouchListener {
    private Paint snakePaint;
    private Paint applePaint;
    private Paint textPaint;

    private Point apple;
    private Random random;
    private LinkedList<Point> snake = new LinkedList<>();
    private static int WIDTH = 1080;
    private static int HEIGHT = 1920;
    int nextx = WIDTH/80;
    int nexty = HEIGHT/80;
    int vx = 1;
    int vy = 0;
    int length = 5;

    public MyView(Context context) {
        super(context);
         snakePaint= new Paint();
         snakePaint.setColor(Color.GREEN);
         applePaint = new Paint();
         applePaint.setColor(Color.RED);
         textPaint = new Paint();
         textPaint.setColor(Color.BLACK);
         textPaint.setTextSize(24.0f);

         snake.add(new Point(nextx++,nexty));
         snake.add(new Point(nextx++,nexty));
         snake.add(new Point(nextx++,nexty));
         snake.add(new Point(nextx++,nexty));
         snake.add(new Point(nextx,nexty));

         random = new Random();
         apple = new Point(random.nextInt(WIDTH/40),random.nextInt(HEIGHT/40));

         this.setOnTouchListener(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int h = canvas.getHeight();
        int w = canvas.getWidth();

        updateSnake();

        for ( Point p: snake ) {
            canvas.drawCircle(p.x * 40, p.y * 40, 20.0f, snakePaint);
        }

        canvas.drawCircle(apple.x * 40, apple.y * 40, 20.0f, applePaint);

        canvas.drawText("Segments: " + length, 40.0f,40.0f,textPaint );

        postDelayed(()->this.invalidate(),250);
    }

    private void updateSnake() {
        nextx += vx;
        nexty += vy;

        Point newpoint = new Point(nextx, nexty);
        snake.add(newpoint);

        if (nextx < 0)
            nextx = WIDTH / 40;
        if (nexty < 0)
            nexty = HEIGHT / 40;
        if (nextx > WIDTH / 40)
            nextx = 0;
        if (nexty > HEIGHT / 40)
            nexty = 0;

        if (apple.x == newpoint.x && apple.y == newpoint.y){
            apple = new Point(random.nextInt(WIDTH / 40), random.nextInt(HEIGHT / 40));
            length++;
        }
        else
            snake.pollFirst();
    }
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if( event.getAction() == MotionEvent.ACTION_DOWN )
        {
            if( vy == 0 )
            {
                    if (event.getY()/40 < nexty)
                        vy = -1;
                    else
                        vy = 1;
                vx = 0;
            }
            else if( vx == 0 )
            {
                    if (event.getX()/40 < nextx)
                        vx = -1;
                    else
                        vx = 1;

                vy = 0;
            }
            return true;
        }
        return false;
    }
}

class Point
{
    int x,y;
    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}