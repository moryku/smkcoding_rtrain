package com.example.robet.rtrain;

import com.google.gson.annotations.SerializedName;

public class TrainItem{

	@SerializedName("seat")
	private String seat;

	@SerializedName("date")
	private String date;

	@SerializedName("cars")
	private String cars;

	@SerializedName("booked")
	private int booked;

	@SerializedName("price")
	private String price;

	@SerializedName("name")
	private String name;

	@SerializedName("destination")
	private String destination;

	@SerializedName("id")
	private String id;

	@SerializedName("time")
	private String time;

	@SerializedName("category")
	private String category;

	@SerializedName("depart")
	private String depart;

	public void setSeat(String seat){
		this.seat = seat;
	}

	public String getSeat(){
		return seat;
	}

	public void setDate(String date){
		this.date = date;
	}

	public String getDate(){
		return date;
	}

	public void setCars(String cars){
		this.cars = cars;
	}

	public String getCars(){
		return cars;
	}

	public void setBooked(int booked){
		this.booked = booked;
	}

	public int getBooked(){
		return booked;
	}

	public void setPrice(String price){
		this.price = price;
	}

	public String getPrice(){
		return price;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setDestination(String destination){
		this.destination = destination;
	}

	public String getDestination(){
		return destination;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setTime(String time){
		this.time = time;
	}

	public String getTime(){
		return time;
	}

	public void setCategory(String category){
		this.category = category;
	}

	public String getCategory(){
		return category;
	}

	public void setDepart(String depart){
		this.depart = depart;
	}

	public String getDepart(){
		return depart;
	}
}