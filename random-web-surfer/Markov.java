public class Markov
{
    // Compute page rank after trials moves.
    public static void main(String[] args){

        StdDraw.enableDoubleBuffering();

        int trials = Integer.parseInt(args[0]);
        int n = StdIn.readInt();
        StdIn.readInt();

        // Read transition matrix 
        double[][] p = new double[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                p[i][j] = StdIn.readDouble();

        // Use the power method to compute page ranks.
        double[] ranks = new double[n];
        ranks[0] = 1.0;
        for(int t = 0; t < trials; t++)
        {
            double[] newRanks = new double[n];
            for(int j = 0; j < n; j++)
            {
                for(int k = 0; k < n; k++)
                    newRanks[j] += ranks[k] * p[k][j];
            }
            
            for(int j = 0; j < n; j++)
                ranks[j] = newRanks[j];

            StdDraw.clear();
            StdDraw.setXscale(-1, n);
            StdDraw.setYscale(0, 1);
            for(int k = 0; k < n; k++){
                StdDraw.filledRectangle(k,ranks[k]/2,0.25,ranks[k]/2);
            }
            StdDraw.show();
            StdDraw.pause(20);
            for(int i = 0; i < n; i++)
                System.out.printf("%8.5f",ranks[i]);
            System.out.println();
        }
        System.out.println("End----");

    }

}
