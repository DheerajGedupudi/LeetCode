class Excel {

    private int[][] grid;
    private int h;
    private int w;
    private Map<Cell, Formula> cellToForm;
    private Map<Formula, Cell> formToCell;

    public Excel(int height, char width) {
        this.h = height;
        this.w = width-'A'+1;
        this.grid = new int[this.h][this.w];
        this.formToCell = new HashMap<>();
        this.cellToForm = new HashMap<>();
    }
    
    public void set(int row, char column, int val) {
        row--;
        int col = column-'A';
        //if formula is present, remove
        Cell cell = new Cell(row, col);
        Formula form = getForm(row, col);
        if (form!=null)
        {
            cellToForm.remove(cell);
            formToCell.remove(form);
        }
        updateCell(cell, val);
        this.grid[row][col] = val;
    }

    private void updateCell(Cell cell, int value)
    {
        int oldValue = this.grid[cell.row()][cell.col()];
        if (oldValue==value)
        {
            return;
        }
        this.grid[cell.row()][cell.col()] = value;
        for (Formula parent : formToCell.keySet())
        {
            if (parent.has(cell))
            {
                //parent formula
                parent.update(cell, oldValue, value);
                int newSum = parent.getSum();
                Cell dest = parent.getTotalLoc();
                updateCell(dest, newSum);
            }
        }
    }
    
    public int get(int row, char column) {
        row--;
        int col = column-'A';
        Cell cell = new Cell(row, col);
        if (cellToForm.containsKey(cell))
        {
            this.grid[row][col] = this.cellToForm.get(cell).getSum();
        }
        return this.grid[row][col];
    }
    
    public int sum(int row, char column, String[] numbers) {
        row--;
        int col = column-'A';
        //if formula is present, replace
        Formula form = getForm(row, col);
        Cell cell = new Cell(row, col);
        if (form!=null)
        {
            cellToForm.remove(cell);
            formToCell.remove(form);
        }
        form = new Formula(cell, h, w, this.grid, numbers);
        updateCell(cell, form.getSum());
        this.formToCell.put(form, cell);
        this.cellToForm.put(cell, form);
        return this.grid[row][col];
    }

    private Formula getForm(int x, int y)
    {
        Cell cell = new Cell(x,y);
        return this.cellToForm.get(cell);
    }
}

class Formula
{
    /*

    recap:
    public methods:

    get sum
    update
    get total loc, gets the destination

    */
    private Cell dest;
    private int[][] count;
    private int[][] grid;
    private int sum;

    Formula(Cell cell, int n, int m, int[][] grid, String[] numbers)
    {
        this.dest = new Cell(cell.row(), cell.col());
        this.count = new int[n][m];
        this.grid = grid;
        for (String number : numbers)
        {
            addNumber(number);
        }
        computeSum();
    }

    public int getSum()
    {
        return this.sum;
    }

    public void computeSum()
    {
        int n = this.count.length;
        int m = this.count[0].length;
        this.sum = 0;
        for (int i=0; i<n; i++)
        {
            for (int j=0; j<m; j++)
            {
                this.sum += (this.grid[i][j]*this.count[i][j]);
            }
        }
        // this.grid[dest.row()][dest.col()] = this.sum;
    }

    private void addNumber(String number)
    {
        int index = number.indexOf(":");
        if (index==-1)
        {
            //single
            Cell loc = getLoc(number);
            this.count[loc.row()][loc.col()]++;
        }
        else
        {
            //many
            Cell start = getLoc(number.substring(0, index));
            Cell end = getLoc(number.substring(index+1));
            for(int i=start.row(); i<=end.row(); i++)
            {
                for (int j=start.col(); j<=end.col(); j++)
                {
                    this.count[i][j]++;
                }
            }
        }
    }

    private Cell getLoc(String num)
    {
        int row = Integer.parseInt(num.substring(1))-1;
        int col = num.charAt(0)-'A';
        return new Cell(row,col);
    }

    public Cell getTotalLoc()
    {
        return this.dest;
    }

    public boolean has(Cell cell)
    {
        return this.count[cell.row()][cell.col()]>0;
    }

    public void update(Cell cell, int oldValue, int newValue)
    {
        int freq = this.count[cell.row()][cell.col()];
        this.sum -= (oldValue*freq);
        this.sum += (newValue*freq);
    }

    @Override
    public String toString()
    {
        return "Dest : "+this.dest;
    }
}

record Cell(int row, int col){

}

/**
 * Your Excel object will be instantiated and called as such:
 * Excel obj = new Excel(height, width);
 * obj.set(row,column,val);
 * int param_2 = obj.get(row,column);
 * int param_3 = obj.sum(row,column,numbers);
 */