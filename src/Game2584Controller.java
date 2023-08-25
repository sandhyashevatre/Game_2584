package com.learning.hello.contoller;


import com.learning.hello.game.Tile;

public class Game2584Controller {
	
	    public Tile[][] board;//2d array
//	    private final int[] FIB_NUMBERS= {1,1,2,3,5,8,13,21,34,55,89,144,233,377,610,987,1597,2584};

	    int grids = 4;

	    int border = 0;

	    public int score = 0;


	    public Game2584Controller()
	    {
	        board = new Tile[4][4];//size of 4
	        
	        for ( int i = 0; i < board.length; i++ )
	        {
	            for ( int j = 0; j < board[i].length; j++ )
	            {
	                board[i][j] = new Tile();
	            }
	        }
	    }
	    
	    public Tile[][] getBoard()
	    {
	        return board;
	    }
	    
	    public int getScore()
	    {
	        return score;
	    }

	    public int getHighTile()
	    {
	        int high = board[0][0].getValue();
	        for ( int i = 0; i < board.length; i++ )
	        {
	            for ( int j = 0; j < board[i].length; j++ )
	            {
	                if ( board[i][j].getValue() > high )
	                {
	                    high = board[i][j].getValue();
	                }
	            }
	        }
	        return high;
	    }

	    public void print()
	    {
	        for ( int i = 0; i < board.length; i++ )
	        {
	            for ( int j = 0; j < board[i].length; j++ )
	            {
	                String s = board[i][j].toString() + " ";
	                System.out.print( s );
	            }
	            System.out.println( "" );
	        }
	        System.out.println( "Score: " + score );
	    }


	    public String toString()
	    {
	        String s = "";
	        for ( int i = 0; i < board.length; i++ )
	        {
	            for ( int j = 0; j < board[i].length; j++ )
	            {
	                s += board[i][j].toString() + " ";
	            }
	            s += "\n";
	        }
	        return s;
	    }

	    public void spawn()

        {

            boolean empty = true;



            while ( empty )

            {

                int row = (int)( Math.random() * 4 );

                int col = (int)( Math.random() * 4 );

                double x = Math.random();

                if ( board[row][col].getValue() == 0 )

                {

                    board[row][col] = new Tile( 1 );

                    empty= false;

                }

            }

        }
	    

	    public boolean gameOver()
	    {
	        int count = 0;
	        for ( int i = 0; i < board.length; i++ )
	        {
	            for ( int j = 0; j < board[i].length; j++ )
	            {
	                if ( board[i][j].getValue() > 0 )
	                {
	                    if ( i == 0 && j == 0 )
	                    {
	                        if ( board[i][j].getValue() != board[i + 1][j].getValue()
	                            && board[i][j].getValue() != board[i][j + 1].getValue() )
	                        {
	                            count++;
	                        }
	                    }
	                    else if ( i == 0 && j == 3 )
	                    {
	                        if ( board[i][j].getValue() != board[i + 1][j].getValue()
	                            && board[i][j].getValue() != board[i][j - 1].getValue() )
	                        {
	                            count++;
	                        }
	                    }
	                    else if ( i == 3 && j == 3 )
	                    {
	                        if ( board[i][j].getValue() != board[i - 1][j].getValue()
	                            && board[i][j].getValue() != board[i][j - 1].getValue() )
	                        {
	                            count++;
	                        }
	                    }
	                    else if ( i == 3 && j == 0 )
	                    {
	                        if ( board[i][j].getValue() != board[i - 1][j].getValue()
	                            && board[i][j].getValue() != board[i][j + 1].getValue() )
	                        {
	                            count++;
	                        }
	                    }
	                    else if ( i == 0 && ( j == 1 || j == 2 ) )
	                    {
	                        if ( board[i][j].getValue() != board[i + 1][j].getValue()
	                            && board[i][j].getValue() != board[i][j + 1].getValue()
	                            && board[i][j].getValue() != board[i][j - 1].getValue() )
	                        {
	                            count++;
	                        }
	                    }
	                    else if ( i == 3 && ( j == 1 || j == 2 ) )
	                    {
	                        if ( board[i][j].getValue() != board[i - 1][j].getValue()
	                            && board[i][j].getValue() != board[i][j + 1].getValue()
	                            && board[i][j].getValue() != board[i][j - 1].getValue() )
	                        {
	                            count++;
	                        }
	                    }
	                    else if ( j == 0 && ( i == 1 || i == 2 ) )
	                    {
	                        if ( board[i][j].getValue() != board[i][j + 1].getValue()
	                            && board[i][j].getValue() != board[i - 1][j].getValue()
	                            && board[i][j].getValue() != board[i + 1][j].getValue() )
	                        {
	                            count++;
	                        }
	                    }
	                    else if ( j == 3 && ( i == 1 || i == 2 ) )
	                    {
	                        if ( board[i][j].getValue() != board[i][j - 1].getValue()
	                            && board[i][j].getValue() != board[i - 1][j].getValue()
	                            && board[i][j].getValue() != board[i + 1][j].getValue() )
	                        {
	                            count++;
	                        }
	                    }
	                    else
	                    {
	                        if ( board[i][j].getValue() != board[i][j - 1].getValue()
	                            && board[i][j].getValue() != board[i][j + 1].getValue()
	                            && board[i][j].getValue() != board[i - 1][j].getValue()
	                            && board[i][j].getValue() != board[i + 1][j].getValue() )
	                        {
	                            count++;
	                        }
	                    }
	                }
	            }
	        }
	        if ( count == 16 )
	        {
	            return true;
	        }
	        return false;
	    }
	    public void up()
	    {
	        for ( int i = 0; i < grids; i++ )
	        {
	            border = 0;
	            for ( int j = 0; j < grids; j++ )
	            {
	                if ( board[j][i].getValue() != 0 )
	                {
	                    if ( border <= j )
	                    {
	                        verticalMove( j, i, "up" );
	                    }
	                }
	            }
	        }
	    }
	    public void down()
	    {
	        for ( int i = 0; i < grids; i++ )
	        {
	            border = ( grids - 1 );
	            for ( int j = grids - 1; j >= 0; j-- )
	            {
	                if ( board[j][i].getValue() != 0 )
	                {
	                    if ( border >= j )
	                    {
	                        verticalMove( j, i, "down" );
	                        
	                    }
	                }
	            }
//	           border=0;
	        }
	    }
	    public int getNextFib(int num) {
	    	if(num == 0) {
	    		return 0;
	    	}
	    	else if(num == 1 ) {
	    		return 1;
	    	}
	    	return getNextFib(num-1)+ getNextFib(num-2);
	    }
	    public boolean canMerge(int initialNum, int nextNum) {
	        int expectedSum = getNextFib(initialNum + 1); // Calculate the expected sum
	        return (initialNum == 1 && nextNum == 1) || expectedSum == nextNum || expectedSum == initialNum;
	    }

	    public void verticalMove( int row, int col, String direction )
	    {
//	    	spawn();
	        Tile initial = board[border][col];
	        Tile compare = board[row][col];
	        if ( initial.getValue() != 0 || canMerge(initial.getValue(),compare.getValue()))
	        {
	            if ( row > border || ( direction.equals( "down" ) && ( row < border ) ) )
	            {
	                int addScore = initial.getValue() + compare.getValue();
	                if ( initial.getValue() != 0 )
	                {
	                    score += addScore;
	                }
	                initial.setValue( addScore );
	                compare.setValue( 0 );
	            }
	        }
	        else
	        {
	            if ( direction.equals( "down" ) )
	            {
	                border--;
	            }
	            else
	            {
	                border++;
	            }
	            verticalMove( row, col, direction );
	        }
	    }
	    public void left()
	    {
	        for ( int i = 0; i < grids; i++ )
	        {
	            border = 0;
	            for ( int j = 0; j < grids; j++ )
	            {
	                if ( board[i][j].getValue() != 0 )
	                {
	                    if ( border <= j )
	                    {
	                        horizontalMove( i, j, "left" );
	                    }
	                }
	            }
	        }
	    }
	    public void right()
	    {
	        for ( int i = 0; i < grids; i++ )
	        {
	            border = ( grids - 1 );
	            for ( int j = ( grids - 1 ); j >= 0; j-- )
	            {
	                if ( board[i][j].getValue() != 0 )
	                {
	                    if ( border >= j )
	                    {
	                        horizontalMove( i, j, "right" );
	                    }
	                }
	            }
	        }
	    }
	    public void horizontalMove( int row, int col, String direction )
	    {
	        Tile initial = board[row][border];
	        Tile compare = board[row][col];
	        if ( initial.getValue() != 0 || canMerge(initial.getValue(), compare.getValue()) )
	        {
	            if ( col > border || ( direction.equals( "right" ) && ( col < border ) ) )
	            {
	                int addScore = initial.getValue() + compare.getValue();
	                if ( initial.getValue() != 0 )
	                {
	                    score += addScore;
	                }
	                initial.setValue( addScore );
	                compare.setValue( 0 );
	            }
	        }
	        else
	        {
	            if ( direction.equals( "right" ) )
	            {
	                border--;
	            }
	            else
	            {
	                border++;
	            }
	            horizontalMove( row, col, direction );
	        }
	    }
	    
	    

	}


