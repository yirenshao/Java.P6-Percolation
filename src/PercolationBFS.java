import java.util.LinkedList;
import java.util.Queue;

public class PercolationBFS extends PercolationDFSFast{
    /**
     * Initialize a grid so that all cells are blocked.
     *
     * @param n is the size of the simulated (square) grid
     */
    public PercolationBFS(int n) {
        super(n);
    }

    @Override
    protected void dfs(int row, int col){
        if (! inBounds(row,col)) return;
        if(myGrid[row][col] == FULL || !isOpen(row, col) ){return;}


        int[] rowDelta = {-1,1,0,0};
        int[] colDelta = {0,0,-1,1};
        Queue<int[]> qp = new LinkedList<>();
        myGrid[row][col] = FULL;
        qp.add(new int[]{row,col});
        while(qp.size() != 0){
            int[] p = qp.remove();
            for(int k=0; k < rowDelta.length; k++) {
                row = p[0] + rowDelta[k];
                col = p[1] + colDelta[k];
                if( inBounds(row, col ) && isOpen(row, col) && !isFull(row, col)  ){
                    qp.add(new int[]{row,col});
                    myGrid[row][col] = FULL;

                }
            }


            }


    }
}
