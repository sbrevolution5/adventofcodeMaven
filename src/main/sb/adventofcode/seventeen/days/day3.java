package sb.adventofcode.seventeen.days;

public class day3 {
    public int StepsToNode(int nodeNum){
        //construct spiral
         makeSpiralUpTo(nodeNum);
        //count steps inward
        //return stepsFromNode(nodeNum);
        return 0;

    }

    private void makeSpiralUpTo(int nodeNum) {
        //sq is the bottom right corner, i will be the dimensions

        int i = 3;
        while(i*i<nodeNum){

            i+=2;
        }
        int [][] spr = new int[i][i];
        var c = ((i-1)/2)+1;
        //center is 1
        spr[c][c] = 1;
        var d = 0;
        var x=c;
        var y = c;
        for (int j = 2; j <= nodeNum; j++) {
            //order, right up left down

            switch (d){
                case 0: y++;
                    spr[x][y]=j;
                    d++;
                    break;
                case 1: x--;
                    spr[x][y]=j;
                    d++;
                    break;
                case 2: y--;
                    spr[x][y]=j;
                    d++;
                    break;
                case 3: y++;
                    spr[x][y]=j;
                    d=0;
                    break;
            }
        }


    }
}
