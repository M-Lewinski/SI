package com.auto;

import klient.Rezerwacja;
import klient.Zwrot;

public abstract class Samochod {
	public double cenaOd3;
	public double cenaDo3;
	public double cenaKMOd3;
	public double cenaKMDo3;
	
	public double fotelik;
	public double bagaznik;
	
	public double brakDowodu;
	public double brakKolpaka;
	public double opoznienie;
	
	public int klasa;
	
	protected Samochod(){
		this.brakDowodu=500.0;
		this.brakKolpaka=20.0;
		this.opoznienie=3;
		this.cenaKMDo3=1;
		this.cenaKMOd3=0.5;
		this.fotelik = 10;
		this.bagaznik = 10;
	}

	public double cenaZaSamochod(Zwrot zwrot){
		double koszt = 0;
		double cena  = 0;
		Rezerwacja r = zwrot.rezerwacja;
		if (r.getDays() > 3) 
			cena = this.cenaKMOd3 * zwrot.przejechaneKilometry + r.cenaOd3 * r.getDays() + r.cenaOd3 * this.opoznienie * r.daysBetween(zwrot.dataOddania);
		else
			cena = this.cenaKMDo3 * zwrot.przejechaneKilometry + r.cenaDo3 * r.getDays() + r.cenaDo3 * this.opoznienie * r.daysBetween(zwrot.dataOddania);
		cena += this.dodatki(zwrot.rezerwacja);
		koszt = cena + kara(zwrot);
		return koszt;
	}
	
	public double kara(Zwrot zwrot){
		return zwrot.zgubioneKolpaki*this.brakKolpaka + zwrot.zgubionyDowod * this.brakDowodu;
	}
	
	public double dodatki(Rezerwacja r){
		double dodatki = r.bagaznik * this.bagaznik + r.fotelik * this.fotelik;
		if (r.klient.programLojalnosciowy == true){
			if (dodatki > 0){
				dodatki -= this.bagaznik;		
			}
		}
		return dodatki;
	}
}
