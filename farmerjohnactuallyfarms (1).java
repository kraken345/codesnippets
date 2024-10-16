import java.io.*;
import java.util.*;

public class farmerjohnactuallyfarms {
	static class plant {
		int h;
		int a;
		int t;

		public String toString() {
            return "h: " + h + " a: " + a + " t: " + t;
        }
	}
	static class comp implements Comparator <plant> {
		public int compare(plant p1, plant p2) {
			return p2.t - p1.t;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);

		StringTokenizer st = new StringTokenizer(r.readLine());
		int t = Integer.parseInt(st.nextToken());

		
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(r.readLine());
			int n = Integer.parseInt(st.nextToken());
			plant[] plants = new plant[n];

			st = new StringTokenizer(r.readLine());
			for (int b = 0; b < n; b++) {
				plants[b] = new plant();
				plants[b].h = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(r.readLine());
			for (int c = 0; c < n; c++) {
				plants[c].a = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(r.readLine());
			for (int d = 0; d < n; d++) {
				plants[d].t = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(plants, new comp());
			pw.println(Arrays.toString(plants));
			
			double cnt = 0;

			double speediff = 0;
			double highdiff = 0;
			double times = 0;

			for (int j = n-1; j > 0; j--) {
				highdiff = plants[j].h - plants[j-1].h;
				speediff = plants[j].a - plants[j-1].a;

				if (highdiff > 0) {
					continue;
				}
				if ((speediff < 0 && highdiff < 0) || (speediff == 0 && highdiff == 0) || (speediff == 0 && highdiff < 0) || (speediff < 0 && highdiff == 0)) {
					cnt = -1;
					break;
				}
				else {
					highdiff = highdiff * (-1);
					if (highdiff % speediff == 0) {
						times = highdiff / speediff + 1;
					}
					else {
						times = Math.ceil(highdiff / speediff);
					}
				}
				/*
				pw.print(highdiff + " ");
				pw.print(speediff + " ");
				pw.println(times);*/
				for (int z = 0; z < n; z++) {
					plants[z].h += plants[z].a * times;
				}
				//pw.println(Arrays.toString(plants));
				cnt += times;
				//pw.println(cnt);
			}
			for (int x = 0; x < n - 1; x++) {
				if (plants[x].h >= plants[x+1].h) {
					cnt = -1;
					break;
				}
			}
			pw.println((int)cnt);
		}

		
		
		pw.close();
	}
	
}

