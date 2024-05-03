package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {

	private String name;
	private Date date;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Client() {

	}

	public Client(String name, Date date) {
		this.name = name;
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public String toString () {
		return "Nome: "
				+ name
				+ ", data de nascimento: "
				+ sdf.format(date);
	}

}
