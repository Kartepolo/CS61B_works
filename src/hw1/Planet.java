
public class Planet {
	public static double g = 6.67/Math.pow(10,11);
	public double x;
	public double y;
	public double xVelocity;
	public double yVelocity;
	public double mass;
	public String img;
	public double xNetForce;
	public double yNetForce;
	public double xAccel;
	public double yAccel;
	public Planet(double xp,double yp,double xv,double yv, double m, String s){
		this.x = xp;
		this.y = yp;
		this.xVelocity = xv;
		this.yVelocity = yv;
		this.mass = m;
		this.img = s;
	}
	public double calcDistance(Planet p){
		double xdis = this.x - p.x;
		double ydis = this.y - p.y;
		return Math.sqrt(xdis*xdis+ydis*ydis);
	}
	public double calcPairwiseForce(Planet p){
		double dis = this.calcDistance(p);
		return g*this.mass*p.mass/(dis*dis);
	}
	public double calcPairwiseForceX(Planet p){
		double dis = this.calcDistance(p);
		return calcPairwiseForce(p)*(p.x-this.x)/dis;
	}
	public double calcPairwiseForceY(Planet p){
		double dis = this.calcDistance(p);
		return calcPairwiseForce(p)*(p.y-this.y)/dis;
	}
	public void setNetForce(Planet[] ps){
		int l = ps.length;
		this.xNetForce = 0;
		this.yNetForce = 0;
		for (int n=0; n<l;n++){
			if (this != ps[n]){
				this.xNetForce+= calcPairwiseForceX(ps[n]);
				this.yNetForce+= calcPairwiseForceY(ps[n]);
			}	
		}
	}
	public void draw(){
		StdDraw.picture(this.x,this.y,"images/"+this.img);
	}
	public void update(double dt){
		xAccel = xNetForce/mass;
		yAccel = yNetForce/mass;
		xVelocity +=dt*xAccel;
		yVelocity +=dt*yAccel;
		x +=dt*xVelocity;
		y +=dt*yVelocity;
	}
	

}
