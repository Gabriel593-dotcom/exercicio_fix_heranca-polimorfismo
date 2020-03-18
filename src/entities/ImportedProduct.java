package entities;

public class ImportedProduct extends Product {
 
	private Double customsFee;

	public ImportedProduct() {
	}

	public ImportedProduct(String name, Double price, Double customsFee) {

		super(name, price);
		this.customsFee = customsFee;

	}
	
	public Double getCustomsFee() {
		
		return this.customsFee;
	}
	
	public void setCustomsFee(Double customsFee) {
		
		this.customsFee = customsFee; 
	}
	
	public Double totalPrice() {
		
		return price + customsFee; 
	}
	
	@Override 
	public String priceTag() {
		
		return String.format(name + " $ " + this.totalPrice() + "(Customs Fee: $ " + this.customsFee + ")"); 
	}
}
