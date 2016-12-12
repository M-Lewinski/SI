package klient;

import java.util.Date;

public class Zwrot {

	public Rezerwacja rezerwacja;
	public Date dataOddania;
	
	public int zgubionyDowod;
	public int zgubioneKolpaki;
	public double przejechaneKilometry;
	public boolean zwrocony = false;
	
	public Zwrot(Rezerwacja r, Date date, double kilometry, int zDowod, int zKolpaki){
		this.rezerwacja = r;
		this.dataOddania = date;
		this.przejechaneKilometry = kilometry;
		this.zgubionyDowod = zDowod;
		this.zgubioneKolpaki = zKolpaki;
	}
}
