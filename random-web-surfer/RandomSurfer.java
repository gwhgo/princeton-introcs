/**
 * trails: number of moves
 * n : number of pages
 * page : current page
 * p[i][j] : probability that the surfer moves from page i to page j
 * freq[i] : number of times the surfer hits page i
 */

public class RandomSurfer{
    public static void main(String[] args){

        StdDraw.enableDoubleBuffering();

        int trials = Integer.parseInt(args[0]);
        int n = StdIn.readInt();
        StdIn.readInt();

        int[] freq = new int[n];
        double[][] p = new double[n][n];

        int page = 0;

        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++){
                p[i][j] = StdIn.readDouble();
            }
        
        for(int t = 0; t < trials; t++){
            double sum = 0;
            double r = Math.random();
            for(int i = 0; i < n; i++){
                sum += p[page][i];
                if ( r < sum ) { 
                    page = i;
                    break;
                }
            }
            freq[page]++;

            /*
                StdDraw.clear();
                StdDraw.setXscale(-1, n);
                StdDraw.setYscale(0, trials);
                for (int k = 0; k < n; k++){
                    StdDraw.filledRectangle(k, freq[k]/2.0, 0.25, freq[k]/2.0);
                }
                StdDraw.show();
                StdDraw.pause(20);
            */
            for(int i = 0; i < n; i++){
                System.out.printf("%8.5f",(double)freq[i]/(t+1));
            }
            System.out.println();

            StdDraw.clear();
            StdDraw.setXscale(-1, n);
            StdDraw.setYscale(0, t+1);
            for (int k = 0; k < n; k++){
                StdDraw.filledRectangle(k, freq[k]/2, 0.25, freq[k]/2);
            }
            StdDraw.show();
            StdDraw.pause(20);

        }
                        
                        

        for(int i = 0; i < n; i++){
            System.out.printf("%8.5f",(double)freq[i]/trials);
        }
        
    }
}
