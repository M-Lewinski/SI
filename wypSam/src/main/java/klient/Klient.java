package klient;

public class Klient {

	public boolean programLojalnosciowy;
	public String name;
	public Klient(String n, boolean loj){
		this.programLojalnosciowy = loj;
		this.name = n;
	}
}
