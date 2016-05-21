package application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;



public class MainController {
	@FXML private Label slUlog;
	@FXML private Label mogDob;
	@FXML private Label cistDob;
	@FXML private Label pogNstanje;
	@FXML private Label promNstanje;
	@FXML private Label kvk;
	@FXML private TextField bankroll = new TextField();
	@FXML private TextField kvota = new TextField();

    
    @FXML
	
	public void izraCunaj(ActionEvent event){
		try
	    {
			String bank = (bankroll.getText());
			String kvot = (kvota.getText());
			double bankD = Double.parseDouble(bank);
			double kvotD = Double.parseDouble(kvot);
		if (bankD >= 50000) {
	
			double proc3 = ((bankD*3)/100);
			double mogDobitak = (proc3 * kvotD);
			double cistDobitak = (mogDobitak-proc3);
			
			slUlog.setText(String.valueOf(proc3+" din"));
			mogDob.setText(String.valueOf(mogDobitak+" din"));
			cistDob.setText(String.valueOf(cistDobitak+" din"));
			pogNstanje.setText(String.valueOf("0.0 din"));
			promNstanje.setText(String.valueOf("0.0 din"));
							}
		else if (bankD <= 10000){
			double proc7 = ((bankD*7)/100);
			double mogDobitak = (proc7 * kvotD);
			double cistDobitak = (mogDobitak-proc7);
			
			slUlog.setText(String.valueOf(proc7+" din"));
			mogDob.setText(String.valueOf(mogDobitak+" din"));
			cistDob.setText(String.valueOf(cistDobitak+" din"));
			pogNstanje.setText(String.valueOf("0.0 din"));
			promNstanje.setText(String.valueOf("0.0 din"));
			
		}
		else{
			double proc5 = ((bankD*5)/100);
			double mogDobitak = (proc5 * kvotD);
			double cistDobitak = (mogDobitak-proc5);
			
			slUlog.setText(String.valueOf(proc5+" din"));
			mogDob.setText(String.valueOf(mogDobitak+" din"));
			cistDob.setText(String.valueOf(cistDobitak+" din"));
			pogNstanje.setText(String.valueOf("0.0 din"));
			promNstanje.setText(String.valueOf("0.0 din"));		
			}
	    }
	    catch (NumberFormatException nfe)
	    {
	      System.out.println("NumberFormatException: " + nfe.getMessage());
	    }	

	}
	public void pogoDak(ActionEvent event){

		try
	    {	
			DBMainConnection DB1= new DBMainConnection();
			DB1.DBDelete();
			String bank = (bankroll.getText());
			String kvot = (kvota.getText());
			double bankD = Double.parseDouble(bank);
			double kvotD = Double.parseDouble(kvot);
		if (bankD >= 50000) {
	
			double proc3 = ((bankD*3)/100);
			double mogDobitak = (proc3 * kvotD);
			double cistDobitak = (mogDobitak-proc3);
			double pogodak = (cistDobitak+bankD);
			
			slUlog.setText(String.valueOf(proc3+" din"));
			mogDob.setText(String.valueOf(mogDobitak+" din"));
			cistDob.setText(String.valueOf(cistDobitak+" din"));
			pogNstanje.setText(String.valueOf(pogodak+" din"));
			promNstanje.setText(String.valueOf("0.0 din"));
			
			if (kvotD > 2.00){
				kvotD = 2.00;
				kvk.setText(String.valueOf(kvotD));
			}
			else{
				kvotD = 2.00;
				kvk.setText(String.valueOf(kvotD));
				}
			
							}
		else if (bankD <= 10000){
			double proc7 = ((bankD*7)/100);
			double mogDobitak = (proc7 * kvotD);
			double cistDobitak = (mogDobitak-proc7);
			double pogodak = (cistDobitak+bankD);
			
			slUlog.setText(String.valueOf(proc7+" din"));
			mogDob.setText(String.valueOf(mogDobitak+" din"));
			cistDob.setText(String.valueOf(cistDobitak+" din"));
			pogNstanje.setText(String.valueOf(pogodak+" din"));
			promNstanje.setText(String.valueOf("0.0 din"));
			
			if (kvotD > 3.00){
				kvotD = 3.00;
				kvk.setText(String.valueOf(kvotD));
			}
		else{
				kvotD = 2.50;
				kvk.setText(String.valueOf(kvotD));
				}
			
		}
		else{
			double proc5 = ((bankD*5)/100);
			double mogDobitak = (proc5 * kvotD);
			double cistDobitak = (mogDobitak-proc5);
			double pogodak = (cistDobitak+bankD);
			
			slUlog.setText(String.valueOf(proc5+" din"));
			mogDob.setText(String.valueOf(mogDobitak+" din"));
			cistDob.setText(String.valueOf(cistDobitak+" din"));
			pogNstanje.setText(String.valueOf(pogodak+" din"));
			promNstanje.setText(String.valueOf("0.0 din"));
			
			if (kvotD > 2.50){
				kvotD = 2.50;
				kvk.setText(String.valueOf(kvotD));
			}
			else{
				kvotD = 2.50;
				kvk.setText(String.valueOf(kvotD));
				}
			}
	
	    }
	    catch (NumberFormatException nfe)
	    {
	      System.out.println("NumberFormatException: " + nfe.getMessage());
	    }	

	}
	public void promaSaj(ActionEvent event){

		try
	    {	
			DBMainConnection DB1= new DBMainConnection();
			  
			String bank = (bankroll.getText());
			String kvot = (kvota.getText());
			double bankD = Double.parseDouble(bank);
			double kvotD = Double.parseDouble(kvot);
			if (bankD >= 50000) {
			
			
			double proc3 = ((bankD*3)/100);
			String proc3S = Double.toString(proc3);
			        DB1.DBInsert(proc3S);
			double mogDobitak = (proc3 * kvotD);
			double cistDobitak = (mogDobitak-proc3);
			double promasaj = (bankD-proc3);
			
			slUlog.setText(String.valueOf(proc3+" din"));
			mogDob.setText(String.valueOf(mogDobitak+" din"));
			cistDob.setText(String.valueOf(cistDobitak+" din"));
			pogNstanje.setText(String.valueOf("0.0 din"));
			promNstanje.setText(String.valueOf(promasaj+" din"));
			
			if (kvotD<10){
				kvotD+=1; 
				kvk.setText(String.valueOf(kvotD));
				}
			else if ((kvotD>=10)&&((kvotD<40))){
				kvotD+=2;
				kvk.setText(String.valueOf(kvotD));
			}
			else if ((kvotD>=40)){
				kvotD+=2.50;
				kvk.setText(String.valueOf(kvotD));
			}
								}
			else if (bankD <= 10000){
				double proc7 = ((bankD*7)/100);
				double mogDobitak = (proc7 * kvotD);
				double cistDobitak = (mogDobitak-proc7);
				double promasaj = (bankD-proc7);
				
				slUlog.setText(String.valueOf(proc7+" din"));
				mogDob.setText(String.valueOf(mogDobitak+" din"));
				cistDob.setText(String.valueOf(cistDobitak+" din"));
				pogNstanje.setText(String.valueOf("0.0 din"));
				promNstanje.setText(String.valueOf(promasaj+" din"));
				
				if (kvotD<10){
					kvotD+=1;
					kvk.setText(String.valueOf(kvotD));
					}
				else if ((kvotD>=10)&&((kvotD<20))){
					kvotD+=2;
					kvk.setText(String.valueOf(kvotD));
				}
				else if ((kvotD>=20)){
					kvotD+=5.00;
					kvk.setText(String.valueOf(kvotD));
				}
				
								}
			else{
				double proc5 = ((bankD*5)/100);
				double mogDobitak = (proc5 * kvotD);
				double cistDobitak = (mogDobitak-proc5);
				double promasaj = (bankD-proc5);
				
				slUlog.setText(String.valueOf(proc5+" din"));
				mogDob.setText(String.valueOf(mogDobitak+" din"));
				cistDob.setText(String.valueOf(cistDobitak+" din"));
				pogNstanje.setText(String.valueOf("0.0 din"));
				promNstanje.setText(String.valueOf(promasaj+" din"));
				
				if (kvotD<10){
					kvotD+=1;
					kvk.setText(String.valueOf(kvotD));
					}
				else if ((kvotD>=10)&&((kvotD<20))){
					kvotD+=2;
					kvk.setText(String.valueOf(kvotD));
				}
				else if ((kvotD>=20)){
					kvotD+=3.00;
					kvk.setText(String.valueOf(kvotD));
				}
				
				}
			
	    }
	    catch (NumberFormatException nfe)
	    {
	      System.out.println("NumberFormatException: " + nfe.getMessage());
	    }	

	}

}
