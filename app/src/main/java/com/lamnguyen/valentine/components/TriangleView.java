package com.lamnguyen.valentine.components;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.lamnguyen.valentine.R;

public class TriangleView extends View {
    private Paint paint;
    private String direction;
    private int color;

    private float borderWidthOutLine = 10f;

    public TriangleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TriangleView);
        this.init(typedArray);
    }


    private void init(TypedArray typedArray) {
        // Khởi tạo đối tượng Paint để vẽ hình
        paint = new Paint();
        direction = typedArray.getString(R.styleable.TriangleView_triangleDirection);
        color = typedArray.getColor(R.styleable.TriangleView_triangleColor, 0);

        paint.setColor(color); // Màu sắc của tam giác
        paint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth();
        int height = getHeight();

        canvas.drawPath(createTrianglePath(width, height), paint);
        createBorder(canvas, width, height);
    }

    private Path createTrianglePath(int width, int height) {
        Path path = new Path();

        if (direction == null) direction = "east";

        switch (direction) {
            case "east": {
                createEastTriangle(path, width, height);
                break;
            }
            case "west": {
                createWestTriangle(path, width, height);
                break;
            }
            case "south": {
                createSouthTriangle(path, width, height);
                break;
            }
            case "north": {
                createNorthTriangle(path, width, height);
                break;
            }
        }
        return path;
    }

    private void createEastTriangle(Path path, int width, int height) {
        path.moveTo(width / 2f, height / 2f); // Đỉnh tam giác
        path.lineTo(width, 0); // Điểm dưới bên trái
        path.lineTo(width, height); // Điểm dưới bên phải
        path.close(); // Kết thúc tam giác
    }

    private void createWestTriangle(Path path, int width, int height) {
        path.moveTo(width / 2f, height / 2f); // Đỉnh tam giác
        path.lineTo(0, 0); // Điểm dưới bên trái
        path.lineTo(0, height); // Điểm dưới bên phải
        path.close(); // Kết thúc tam giác
    }


    private void createSouthTriangle(Path path, int width, int height) {
        path.moveTo(width / 2f, height / 2f); // Đỉnh tam giác
        path.lineTo(width, height); // Điểm dưới bên phải
        path.lineTo(0, height); // Điểm dưới bên trái
        path.close(); // Kết thúc tam giác
    }


    private void createNorthTriangle(Path path, int width, int height) {
        path.moveTo(width / 2f, height / 2f); // Đỉnh tam giác
        path.lineTo(0, 0); // Điểm dưới bên trái
        path.lineTo(width, 0); // Điểm dưới bên phải
        path.close(); // Kết thúc tam giác
    }

    private void createBorder(Canvas canvas, int width, int height) {
        paint.setColor(Integer.parseInt(String.valueOf(R.color.black)));
        paint.setStrokeWidth(2f);

        switch (direction) {
            case "east": {
                createBorderForEastTriangle(canvas, width, height);
                break;
            }
            case "west": {
                createBorderForWestTriangle(canvas, width, height);
                break;
            }
            case "south": {
                createBorderForSouthTriangle(canvas, width, height);
                break;
            }
            case "north": {
                createBorderForNorthTriangle(canvas, width, height);
                break;
            }
        }
    }

    private void createBorderForEastTriangle(Canvas canvas, int width, int height) {
        canvas.drawLine(width / 2f, height / 2f, width, 0, paint);
        canvas.drawLine(width / 2f, height / 2f, width, height, paint);
        paint.setStrokeWidth(borderWidthOutLine);
        canvas.drawLine(width, 0, width, height, paint);
    }

    private void createBorderForWestTriangle(Canvas canvas, int width, int height) {
        canvas.drawLine(width / 2f, height / 2f, 0, 0, paint);
        canvas.drawLine(width / 2f, height / 2f, 0, height, paint);
        paint.setStrokeWidth(borderWidthOutLine);
        canvas.drawLine(0, 0, 0, height, paint);
    }

    private void createBorderForSouthTriangle(Canvas canvas, int width, int height) {
        canvas.drawLine(width / 2f, height / 2f, 0, height, paint);
        canvas.drawLine(width / 2f, height / 2f, width, height, paint);
        paint.setStrokeWidth(borderWidthOutLine);
        canvas.drawLine(0, height, width, height, paint);
    }

    private void createBorderForNorthTriangle(Canvas canvas, int width, int height) {
        canvas.drawLine(width / 2f, height / 2f, 0, 0, paint);
        canvas.drawLine(width / 2f, height / 2f, width, 0, paint);
        paint.setStrokeWidth(borderWidthOutLine);
        canvas.drawLine(0, 0, width, 0, paint);
    }
}
