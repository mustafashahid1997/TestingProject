
import java.util.Random;

public class Cell {
    
    int[][] arr;
    int [] cells;
    int size;
    
    public Cell(int size)
    {
        arr=new int[size][size];
        this.size=size;
    }
    
    public void convertArray()
    {
        this.cells=new int[size*size];
        int k=0;
         for(int i=0;i<this.size;i++)
        {
            for(int j=0;j<this.size;j++)
            {
               this.cells[k]=this.arr[i][j];
              // System.out.println(this.cells[k]+ " ");
               k++;
            }
        }
    }
    
    public void CountNeighbor()
    {
        int count=0;
        for(int i=0;i<this.size;i++)
        {
            for(int j=0;j<this.size;j++)
            {
                if(this.arr[i][j]!=-1)
                {for(int m=-1;m<=1;m++)
                {
                    for( int n=-1;n<=1;n++)
                    {
                        if(i+m<0 || j+n<0 || i+m==this.size || j+n==this.size)
                        {}
                        else
                        {if(this.arr[i+m][j+n]==-1)
                        {
                            count++;
                        }
                        }
                    }
                }  
                this.arr[i][j]=count;
                count=0;
                }
            }
        }
        convertArray();
    }
    
    public void generateRandom()
    {
        Random rand = new Random();
        int count=0;
        for(int i=0;i<this.size;i++)
        {
            for(int j=0;j<this.size;j++)
            {
                if((i==0 || j==0) || (i==this.size-1 || j==this.size-1))
                {
                   
                }
                else
                {
                    int temp=rand.nextInt(100);       
                    if(temp>50)         
                    {
                        
                        this.arr[i][j]=-1;
                         count++;
                         if(count==3)
                         {
                             count=0;
                             break; 
                         }                               
                    } 
                }
            }
        }
        CountNeighbor();
    }
}
