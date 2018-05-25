package ru.kai.services;


import ru.kai.models.Point;

import java.util.ArrayDeque;

public class PathFinder{
    
    public boolean isCorrect(int x, int y, int width, int height) {
        if (x < 0 || y < 0)
            return false;
        if (x >= width || y >= height)
            return false;
        
        return true;
    }
    
     public int findPath(int width, int height, int x1, int y1, int x2, int y2){
        int moveX[] = {-2, -2, -1, -1, 1, 1, 2, 2};
        int moveY[] = {-1, 1, -2, 2, -2, 2, -1, 1};

        Point begin = new Point(x1, y1-1);
        Point end = new Point(x2,y2-1);

        int chessField[][]= new int[width][height];

        for (int i=0; i<width; i++){
            for(int j=0; j<height; j++){
                chessField[i][j]=-1;
            }
        }

        chessField[begin.getX()][begin.getY()]=0;
        ArrayDeque<Point> q= new ArrayDeque<>();
        q.add(begin);
        while (!q.isEmpty()){
            Point current= q.pollFirst();
            for (int i=0; i<8; i++){
                int x= current.getX()+ moveX[i];
                int y= current.getY()+moveY[i];
                if(isCorrect(x,y,width,height) && chessField[x][y]==-1){
                    chessField[x][y]=chessField[current.getX()][current.getY()]+1;

                    if(end.getX()==x && end.getY()==y){
                        return chessField[x][y];
                    }
                    q.add(new Point(x,y));
                }
            }
        }
        return -1;
    }
}

