package klient;

import java.util.Date;

import com.auto.A;
import com.auto.Samochod;

public class Rezerwacja {

	public Samochod samochod;
	public Klient klient;
	public Date dataOd;
	public Date dataDo;
	public boolean przyjeta = false;
	public boolean zakonczona = false;
	public int bagaznik = 0;
	public int fotelik = 0;
	public double cenaOd3;
	public double cenaDo3;

	
	public int getDays(){
		return (int)((this.dataDo.getTime()-this.dataOd.getTime())/(1000*60*60*24)) + 1;
	}
	
	public int daysBetween(Date dDo){
		return (int)((dDo.getTime()-this.dataDo.getTime())/(1000*60*60*24));
			
	}
	public boolean dateBetween(Date d){
		return dataDo.compareTo(d) * d.compareTo(dataOd) > 0;
	}
	
	public Rezerwacja(Klient k, Samochod s, Date dOd, Date dDo,int b,int f){
		if (s == null)
			s = new A();
		this.samochod = s;
		this.klient = k;
		this.dataDo = dDo;
		this.dataOd = dOd;
		this.bagaznik = b;
		this.fotelik = f;
	}
	
}
