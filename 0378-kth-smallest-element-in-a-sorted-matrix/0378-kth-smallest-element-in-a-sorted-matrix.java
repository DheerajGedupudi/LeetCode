class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;
        Queue<Cell> heap = new PriorityQueue<>((a,b)->(matrix[a.row][a.col]-matrix[b.row][b.col]));
        for (int i=0; i<n; i++)
        {
            heap.offer(new Cell(i, 0));
        }
        int count = 0;
        while(heap.isEmpty()==false)
        {
            count++;
            Cell curr = heap.poll();
            if (count==k)
            {
                return matrix[curr.row][curr.col];
            }
            if (curr.col+1<m)
            {
                heap.offer(new Cell(curr.row, curr.col+1));
            }
        }
        return -1;
    }
}

class Cell
{
    int row;
    int col;

    Cell(int row, int col)
    {
        this.row = row;
        this.col = col;
    }
}


/*



1  5  9
10 11 13
12 13 15

*/