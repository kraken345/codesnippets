import java.io.*;
import java.util.*;

public class humanchessboard {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);

		//Input Step
		StringTokenizer st = new StringTokenizer(r.readLine());
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(r.readLine());
		int cx = Integer.parseInt(st.nextToken());
		int cy = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(r.readLine());
		int rx = Integer.parseInt(st.nextToken());
		int ry = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(r.readLine());
		int bx = Integer.parseInt(st.nextToken());
		int by = Integer.parseInt(st.nextToken());

		int movecount = 0;

		if (Math.abs(cx - bx) == Math.abs(cy - by)){
			if (((cx - rx) == (rx - bx)) && ((cy - ry) == (ry - by))) {
				movecount = 2;
			}
			else {
				movecount = 1;	
			}
		}
		else if ((rx == cx) || (ry == cy)) {
			if ((((cx > bx) && (bx > rx)) || ((cx < bx) && (bx < rx))) || (((cy > by) && (by > ry)) || ((cy < by) && (by < ry)))) {
				movecount = 2;
			}
			else {
				movecount = 1;
			}
		}
		else {
			movecount = 2;
		}

		pw.print(movecount);
		
		pw.close();
	}
}
