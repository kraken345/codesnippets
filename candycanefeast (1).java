import java.io.*;
import java.util.*;

public class candycanefeast {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);

		StringTokenizer st = new StringTokenizer(r.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
        long[] cows = new long[n];
        st = new StringTokenizer(r.readLine());
        for (int i = 0; i < n; i++) {
            cows[i] = Long.parseLong(st.nextToken());
        }

        long[] candy = new long[m];
        st = new StringTokenizer(r.readLine());
        for (int j = 0; j < m; j++) {
            candy[j] = Integer.parseInt(st.nextToken());
        }

        //pw.println(Arrays.toString(cows));

        long min = 0;
        long newmin = 0;
        long amount = 0;
        for (int x = 0; x < m; x++) {
            min = 0;
            amount = candy[x];
            //pw.println(amount);
            for (int y = 0; y < n; y++) {
                if (cows[y] > min) {
                   // pw.print(min + " ");
                    newmin = cows[y];
                    cows[y] += Math.min(amount - min, cows[y] - min);
                    min = newmin;
                    //pw.println(cows[y]);
                    //pw.println(Arrays.toString(cows));
                    if (min > amount) {
                        break;
                    }
                }
            }
            
        }
        

        for (int z = 0; z < n; z++) {
            pw.println(cows[z]);
        }



		pw.close();
	}
}
