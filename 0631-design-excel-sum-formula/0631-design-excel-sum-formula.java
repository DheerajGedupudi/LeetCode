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
        // System.out.println("set : ["+row+", "+col+"] : "+val);
        // print();
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
        // System.out.println("-=-=-=-=-= after setting : ["+row+", "+col+"] : "+val);
        // print();
    }

    private void updateCell(Cell cell, int value)
    {
        //replacing this cell, with this value
        // System.out.println("updating---- "+cell+", with : "+value);
        for (Formula parent : formToCell.keySet())
        {
            if (parent.has(cell))
            {
                //parent formula
                int oldSum = parent.getSum();
                // System.out.println("---- - - found parent---- "+parent+", with : "+oldSum);
                parent.update(cell, value);
                int newSum = parent.getSum();
                // System.out.println("-- found parent--- updated - "+parent+", with : "+newSum);
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
        // System.out.println("get of : ["+row+", "+col+"] : "+this.grid[row][col]);
        return this.grid[row][col];
    }
    
    public int sum(int row, char column, String[] numbers) {
        row--;
        int col = column-'A';
        // System.out.println("form : ["+row+", "+col+"] : "+Arrays.toString(numbers));
        // print();
        //if formula is present, replace
        Formula form = getForm(row, col);
        Cell cell = new Cell(row, col);
        if (form!=null)
        {
            cellToForm.remove(cell);
            formToCell.remove(form);
        }
        form = new Formula(cell, h, w, this.grid, numbers);
        this.grid[row][col] = form.getSum();
        updateCell(cell, this.grid[row][col]);
        // System.out.println("-=-=-=-=-=-= after form : ["+row+", "+col+"] : "+Arrays.toString(numbers));
        // print();
        this.formToCell.put(form, cell);
        this.cellToForm.put(cell, form);
        return this.grid[row][col];
    }

    private Formula getForm(int x, int y)
    {
        Cell cell = new Cell(x,y);
        return this.cellToForm.get(cell);
    }

    private void print()
    {
        for (int[] row : grid)
        {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
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
        // System.out.println("before computing : printing count");
        // print();
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
        // System.out.println("computed sum : "+this.sum);
        this.grid[dest.row()][dest.col()] = this.sum;
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

        // System.out.println("added : "+number);
        // print();
    }

    //
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

    public void update(Cell cell, int value)
    {
        this.grid[cell.row()][cell.col()] = value;
        computeSum();
    }


    private void print()
    {
        System.out.println("printing count : ");
        for (int[] row : count)
        {
            System.out.println("--- "+Arrays.toString(row));
        }
        System.out.println();
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