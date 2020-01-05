package com.tinker.algorithms;

public class LonelyPixel {

    public static void main(String[] args){
        char[][] data={{'B','W','W'},{'W','B','W'},{'W','W','B'}};
        System.out.println(findLonelyBlackNum(data));
    }

    private static int findLonelyBlackNum(char[][] data){
        if(data==null){
            return 0;
        }
        int rowLength=data.length;
        int colLength=data[0].length;
        int rowBlackNum=0;
        int blackIndex=-1;
        int colBlackNum=0;
        int num=0;
        for(int i=0;i<rowLength;i++){
            for(int j=0;j<colLength;j++){
                if(data[i][j]=='B'){
                    rowBlackNum++;
                    if(rowBlackNum>1){
                        break;
                    }else if(rowBlackNum==1){
                        blackIndex=j;
                    }
                }
            }
            if(rowBlackNum==1){
                for(int k=0;k<rowLength;k++){
                    if(data[k][blackIndex]=='B'){
                        colBlackNum++;
                        if(colBlackNum>1){
                            break;
                        }
                    }
                }
                if(colBlackNum==1){
                    num++;
                }
            }
            rowBlackNum=0;
            blackIndex=-1;
            colBlackNum=0;
        }
        return num;
    }
}
