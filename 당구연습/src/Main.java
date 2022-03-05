import java.io.IOException;
public class Main {
	static class Point{
		double x,y;

		public Point(double x, double y) {
			this.x = x;
			this.y = y;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		//앞에서 구멍 정하는 로직 돌린후
		Point start = new Point(0,3);
		Point end = new Point(0,-4);
		Point hole = new Point(1,4+Math.sqrt(3));
		double dy = end.y-start.y;
		double dx = end.x-start.x;
		double angle;//하얀 공의 각도(x축기준 0~90도)
		double wangle;//하얀공의 각도(0~360도)
		if(dx==0) {
			if(dy>0) {
				angle = 0;
				wangle = angle;
			} else {
				angle = 0;
				wangle = 180;
			}
		} else {
			angle = Math.atan(dy/dx)*(180.0/Math.PI);
			if(dx>0)
			{
				wangle=90-angle; //1,2사분면
				
			} else {
				wangle = 270-angle; //3,4사분면
			}
		}
		angle = Math.abs(angle);
		//-------------------------------------------------
		double D = 61.5;//공의 직경
		double T;//두께
		double rdy = Math.abs(hole.y-end.y);
		double rdx = Math.abs(hole.x-end.x);
		double rangle = Math.atan(rdy/rdx)*(180.0/Math.PI);
//		System.out.println(1-Math.cos((90-Math.abs(rangle-angle))*(Math.PI/180.0)));
		T = D*(1-Math.cos((90-Math.abs(rangle-angle))*(Math.PI/180.0)));
//		System.out.println(T);
		double dist = Math.sqrt((dx*dx)+(dy*dy));//공과 공사이의 거리
		double ceta = Math.atan((D-T)/dist);
		if(wangle<=180) {
			if(hole.y<end.y) {
				wangle+=ceta;
			} else {
				wangle-=ceta;
			}
		} else {
			if(hole.y<end.y) {
				wangle-=ceta;
			} else {
				wangle+=ceta;
			}
		}
		if(wangle<0) {
			wangle+=360;
		}
		if(wangle>360) {
			wangle-=360;
		}
		System.out.println(wangle);
	}
}
