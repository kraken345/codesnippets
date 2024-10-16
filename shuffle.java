

import java.io.*;
import java.util.*;

public class shuffle {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("shuffle.in"));
		PrintWriter pw = new PrintWriter("shuffle.out");

		StringTokenizer st = new StringTokenizer(r.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[] id = new int[n];
		int[] repos = new int[n];
		int[] rev = new int[n];
		int[] original = new int[n];

		st = new StringTokenizer(r.readLine());
		for (int i = 0; i < n; i++) {
			repos[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(r.readLine());
		for (int j = 0; j < n; j++) {
			id[j] = Integer.parseInt(st.nextToken());
		}

		for (int a = 0; a < n; a++) {
			rev[repos[a] - 1] = a+1;
		}

		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < n; x++) {
				original[rev[x]-1] = id[x];
			}
			for (int z = 0; z < n; z++) {
				id[z] = original[z];
			}
		}

		for (int f = 0; f < n; f++) {
			pw.println(original[f]);
		}
		
		pw.close();
	}
}
