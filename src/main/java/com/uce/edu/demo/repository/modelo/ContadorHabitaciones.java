package com.uce.edu.demo.repository.modelo;

public class ContadorHabitaciones {



	   private String hotel;
	    private String tipo;
	    private Long cantidad;
	    
	    public ContadorHabitaciones(String hotel, String tipo, Long cantidad) {
	        this.hotel=hotel;
	        this.tipo=tipo;
	        this.cantidad=cantidad;
	    }



	   //SET GET
	    public String getHotel() {
	        return hotel;
	    }




	    public void setHotel(String hotel) {
	        this.hotel = hotel;
	    }




	    public String getTipo() {
	        return tipo;
	    }



	   public void setTipo(String tipo) {
	        this.tipo = tipo;
	    }



	   public Long getCantidad() {
	        return cantidad;
	    }



	   public void setCantidad(Long cantidad) {
	        this.cantidad = cantidad;
	    }



	   @Override
	    public String toString() {
	        return "ContadorHabitaciones [hotel=" + hotel + ", tipo=" + tipo + ", cantidad=" + cantidad + "]";
	   }   
	    
	}