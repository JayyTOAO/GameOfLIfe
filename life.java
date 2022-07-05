class GameOfLife {
  
  private int[][] grid;
  
  public GameOfLife(int[][] grid)
  {
    this.grid = grid;
  }
  public int[][] getGrid()
  {
    return grid;
  }
  public void setGrid(int[][] grid)
  {
    this.grid = grid;
  }
  
  public void updateGrid()
  {
    int[][] gridCopy = new int[grid.length][grid[0].length];
    for(int r = 0; r<grid.length; r++)
    {
      for(int c = 0; c<grid[r].length; c++)
      {
        int[] coords = {r,c};
        if((grid[r][c] == 0)&& getNeighbors(coords) == 3)
        {
          gridCopy[r][c] = 1;
        }
        else if((grid[r][c] == 1)&&(getNeighbors(coords) == 3))
        {
          gridCopy[r][c] = 1;
        }
        else if((grid[r][c] == 1)&&(getNeighbors(coords) == 2))
        {
          gridCopy[r][c] = 1;
        }
      }
    }
    setGrid(gridCopy);
  }
  
  public int getNeighbors(int[] cell)
  {
    int sum = 0;
    if((cell[0]-1>-1 )&&(cell[1]-1>-1)&&(grid[cell[0]-1][cell[1]-1] == 1))
    {
      sum++;
    }
    if((cell[0]-1>-1 )&&(grid[cell[0]-1][cell[1]] == 1))
    {
      sum++;
    }
    if((cell[0]-1>-1 )&&(cell[1]+1<grid[0].length)&&(grid[cell[0]-1][cell[1]+1] == 1))
    {
      sum++;
    }
    if((cell[1]-1>-1)&&(grid[cell[0]][cell[1]-1] == 1))
    {
      sum++;
    }
    if((cell[1]+1<grid[0].length)&&(grid[cell[0]][cell[1]+1] == 1))
    {
      sum++;
    }
    if((cell[0]+1<grid.length )&&(cell[1]-1>-1)&&(grid[cell[0]+1][cell[1]-1] == 1))
    {
      sum++;
    }
    if((cell[0]+1<grid.length)&&(grid[cell[0]+1][cell[1]] == 1))
    {
      sum++;
    }
    if((cell[0]+1<grid.length)&&(cell[1]+1<grid[0].length)&&(grid[cell[0]+1][cell[1]+1] == 1))
    {
      sum++;
    }
    return sum;
  }
}

int[][] grid = { {0,0,0,0,0,0,0,0,0,0},
                 {0,0,0,0,1,0,0,0,0,0},
                 {0,0,1,0,1,0,0,0,0,0},
                 {0,0,0,1,1,0,0,0,0,0},
                 {0,0,0,0,0,0,0,0,0,0}};
GameOfLife game = new GameOfLife(grid);


void setup()
{
  frameRate(1);
  size(1000,1000);
  smooth();
}

void draw()
{
  background(124);
  makeGrid();
  game.updateGrid();
  
}


void makeGrid()
{
  int w = 1000/game.getGrid().length;
  for(int i = 1; i<game.getGrid().length; i++)
  {
    line(0,i*w,1000,i*w);
  }
  int h = 1000/game.getGrid()[0].length;
  for(int i = 1; i<game.getGrid()[0].length; i++)
  {
    line(h*i,0,h*i,1000);
  }
  
  for(int r = 0; r<game.getGrid().length; r++)
  {
    for(int c = 0; c<game.getGrid()[0].length; c++)
    {
      if(game.getGrid()[r][c] == 1)
      {
        rect(c*h,r*w, h, w);
      }
    }
  }
}



