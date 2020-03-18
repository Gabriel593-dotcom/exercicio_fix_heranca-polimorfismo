import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		// Classes do Sistema
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		//Classes do Programa /Regra de Negócio		
		List<Product> list = new ArrayList<>();
		Product pdc = new Product();
		ImportedProduct importedPdc = new ImportedProduct();
		UsedProduct usedPdc = new UsedProduct();
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			
			System.out.println("Product #" + i + " data:");
			System.out.print("Common, Used or Imported: (c/u/i)");		
			char cui = sc.next().charAt(0);
			
			System.out.print("Name: ");
			sc.nextLine(); 
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			
			if(cui == 'c' || cui == 'C') {
				
				list.add(new Product(name, price));
			}
			
			else if (cui == 'i' || cui == 'I') {
				
				System.out.print("Customs Fee: ");
				Double customsFee = sc.nextDouble();
				list.add(new ImportedProduct(name, price, customsFee));
			}
			
			else if(cui == 'u' || cui == 'U') {
				
				System.out.print("Manufacture date: ");
			
				Date data = sdf.parse(sc.next());
				
				list.add(new UsedProduct(name, price, data));
			}
			else {
				
				System.out.println("Opção Inválida");
			}
			
		}
		
		System.out.println("PRICE TAGS:");
		
		for(Product p : list) {
			
			System.out.println(p.priceTag());
		}
		
		sc.close();

	}

}
