import java.io.*;
import java.util.Scanner;
public class NBody {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double T,dt,R,time;
		String filename;
		int num;
		Planet p;
		Scanner s = new Scanner(System.in);
		T = s.nextDouble();
		dt =s.nextDouble();
		filename = s.next();
		In in = new In(filename);
		num = in.readInt();
		R = in.readDouble();
		Planet[] ps = new Planet[num];
		StdDraw.setScale(-R,R);
		for (int n=0;n<num;n++){
			ps[n] = getPlanet(in);
		}
		time= 0.0;
		StdAudio.play("audio/2001.mid");
		while (time<T){
		StdDraw.picture(0.0,0.0,"images/starfield.jpg",R*2.0,R*2.0);
			for (int n=0;n<num;n++){
				ps[n].setNetForce(ps);
				ps[n].update(dt);
				ps[n].draw();
			}
			StdDraw.show(5);
			time+=dt;
		}
		System.out.println(num);
		System.out.println(R);
		for (int n=0;n<num;n++){
			p = ps[n];
			System.out.println(p.x+"  "+p.y+"  "+p.xVelocity+"  "+p.yVelocity+"  "+p.mass+"  "+p.img);
		}

	}
	public static Planet getPlanet(In i){
		double d1 = i.readDouble();
		double d2 = i.readDouble();
		double d3 = i.readDouble();
		double d4 = i.readDouble();
		double d5 = i.readDouble();
		String imgs = i.readString();
		Planet p = new Planet(d1,d2,d3,d4,d5,imgs);
		return p; 
	}

}
