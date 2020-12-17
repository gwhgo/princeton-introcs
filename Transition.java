public class Transition {
    public static void main(String[] args){
        int n = StdIn.readInt();
        int[][] counts = new int[n][n];
        int[] outdegrees = new int[n];

        while(!StdIn.isEmpty()){
            int i = StdIn.readInt();
            int j = StdIn.readInt();
            counts[i][j]++;
            outdegrees[i]++;
        }

        System.out.println(n + " " + n);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                double p  = 0;
                if(outdegrees[i] == 0){
                    p = 0.1/n;
                }
                else{
                    p = 0.9 * counts[i][j] / outdegrees[i] + 0.1 / n;
                }
                System.out.printf("%8.5f",p);
            }
            System.out.println();
        }
    }
}
